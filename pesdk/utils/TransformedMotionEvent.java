// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.MainThread;
import androidx.annotation.CheckResult;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import androidx.annotation.Size;
import ly.img.android.PESDK;
import androidx.annotation.Nullable;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import android.graphics.Matrix;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;

public class TransformedMotionEvent implements Recyclable
{
    private static final float LOW_PASS_ALPHA = 0.1f;
    private static final int REUSE_COUNT = 6;
    private static final TransformedMotionEvent[] reusePool;
    private static final Matrix IDENTITY_MATRIX;
    private static final int X = 0;
    private static final int Y = 1;
    private static final int MAX_CLICK_DURATION = 200;
    private static final int MAX_CLICK_DISTANCE = 15;
    private static long pressStartTime;
    @NonNull
    private static final TransformState startTransformState;
    @NonNull
    private static final TransformState startScreenTransformState;
    private static boolean isClicked;
    private static boolean isDoubleTapped;
    private static boolean isDoubleTapCandidate;
    private boolean isRecycled;
    private MotionEvent event;
    private Transformation matrix;
    private boolean isCheckpoint;
    @Nullable
    private float[] fixedCenterPoint;
    private TransformedMotionEvent screenEvent;
    private boolean isScreenEvent;
    private Recyclable alsoRecyclable;
    
    private TransformedMotionEvent(final MotionEvent event, final Matrix matrix, final boolean isScreenEvent) {
        this.isScreenEvent = false;
        this.alsoRecyclable = null;
        this.set(event, matrix, isScreenEvent);
    }
    
    public static TransformedMotionEvent obtain(final MotionEvent event) {
        return obtain(event, TransformedMotionEvent.IDENTITY_MATRIX, false);
    }
    
    public static TransformedMotionEvent obtain(final MotionEvent event, final Matrix matrix) {
        return obtain(event, matrix, false);
    }
    
    private static TransformedMotionEvent obtain(final MotionEvent event, final Matrix matrix, final boolean isScreenEvent) {
        synchronized (TransformedMotionEvent.reusePool) {
            for (int i = 0; i < 6; ++i) {
                final TransformedMotionEvent p = TransformedMotionEvent.reusePool[i];
                if (p != null) {
                    TransformedMotionEvent.reusePool[i] = null;
                    if (p.isRecycled) {
                        p.set(event, matrix, isScreenEvent);
                        return p;
                    }
                }
            }
        }
        return new TransformedMotionEvent(event, matrix, isScreenEvent);
    }
    
    @Override
    public void recycle() {
        if (!this.isRecycled) {
            this.isRecycled = true;
            if (this.screenEvent != null) {
                this.screenEvent.recycle();
            }
            synchronized (TransformedMotionEvent.reusePool) {
                for (int i = 0; i < 6; ++i) {
                    if (TransformedMotionEvent.reusePool[i] == null) {
                        TransformedMotionEvent.reusePool[i] = this;
                        return;
                    }
                }
            }
        }
    }
    
    public static float distance(final float pos1X, final float pos1Y, final float pos2X, final float pos2Y) {
        final float dx = pos1X - pos2X;
        final float dy = pos1Y - pos2Y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
    
    public static float distance(final float[] pos1, final float[] pos2) {
        return distance(pos1[0], pos1[1], pos2[0], pos2[1]);
    }
    
    private static float pxToDp(final float px) {
        return px / PESDK.getAppResource().getDisplayMetrics().density;
    }
    
    private void set(final MotionEvent event, final Matrix matrix, final boolean isScreenEvent) {
        this.isRecycled = false;
        this.isCheckpoint = false;
        this.fixedCenterPoint = null;
        this.isScreenEvent = isScreenEvent;
        if (isScreenEvent) {
            this.screenEvent = this;
        }
        else {
            this.screenEvent = obtain(event, TransformedMotionEvent.IDENTITY_MATRIX, true);
        }
        this.event = event;
        if (this.matrix == null) {
            this.matrix = Transformation.permanent();
        }
        this.matrix.set(matrix);
        final TransformDiff diff = this.obtainTransformDifference();
        final long pressDuration = System.currentTimeMillis() - TransformedMotionEvent.pressStartTime;
        switch (this.getActionMasked()) {
            case 0: {
                if (isScreenEvent) {
                    TransformedMotionEvent.isDoubleTapCandidate = (TransformedMotionEvent.isClicked && !TransformedMotionEvent.isDoubleTapped && pressDuration < 200L && diff.distanceDiff < 15.0f);
                }
                TransformedMotionEvent.isClicked = false;
                TransformedMotionEvent.isDoubleTapped = false;
                this.saveTransformState();
                TransformedMotionEvent.pressStartTime = System.currentTimeMillis();
                break;
            }
            case 1: {
                if (isScreenEvent && pressDuration < 200L && diff.distanceDiff < 15.0f) {
                    TransformedMotionEvent.isClicked = true;
                    TransformedMotionEvent.isDoubleTapped = TransformedMotionEvent.isDoubleTapCandidate;
                    break;
                }
                break;
            }
        }
        diff.recycle();
        if (this.getPointerCount() != 1) {
            TransformedMotionEvent.pressStartTime = 0L;
        }
        final TransformState startTransformState = isScreenEvent ? TransformedMotionEvent.startScreenTransformState : TransformedMotionEvent.startTransformState;
        if (startTransformState.getPointCount() != this.getPointerCount() && !this.isRelease()) {
            this.saveTransformState();
        }
    }
    
    @NonNull
    public TransformDiff obtainTransformDifference() {
        if (this.isScreenEvent) {
            return TransformedMotionEvent.startScreenTransformState.calculateDiff(this);
        }
        return TransformedMotionEvent.startTransformState.calculateDiff(this);
    }
    
    public int getPointerCount() {
        return this.event.getPointerCount();
    }
    
    public void setFixedCenterPoint(@Size(2L) final float[] pos) {
        this.setFixedCenterPoint(pos[0], pos[1]);
    }
    
    public void setFixedCenterPoint(final float x, final float y) {
        this.fixedCenterPoint = new float[] { x, y };
        final Transformation inverted = this.matrix.obtainInverted();
        inverted.mapPoints(this.fixedCenterPoint);
        inverted.recycle();
        if (this.isCheckpoint()) {
            this.saveTransformState();
        }
    }
    
    public boolean isCheckpoint() {
        return this.isCheckpoint;
    }
    
    private void saveTransformState() {
        if (this.isScreenEvent) {
            TransformState.smoothedScreenValues = null;
            TransformedMotionEvent.startScreenTransformState.set(this);
            this.isCheckpoint = true;
        }
        else {
            TransformState.smoothedValues = null;
            TransformedMotionEvent.startTransformState.set(this);
            this.isCheckpoint = true;
        }
    }
    
    public MotionEvent getRawEvent() {
        return this.event;
    }
    
    public TransformedMotionEvent getScreenEvent() {
        return this.screenEvent;
    }
    
    public boolean hasFixedCenterPoint() {
        return this.fixedCenterPoint != null;
    }
    
    public boolean hasClicked() {
        return this.isScreenEvent ? TransformedMotionEvent.isClicked : this.screenEvent.hasClicked();
    }
    
    public boolean hasDoubleTapped() {
        return TransformedMotionEvent.isDoubleTapped;
    }
    
    public boolean isRelease() {
        return this.getActionMasked() == 1;
    }
    
    public int getActionMasked() {
        return this.event.getAction() & 0xFF;
    }
    
    public float[] getPosition(final int index) {
        final float[] point = new float[2];
        this.getPosition(index, point);
        return point;
    }
    
    public boolean isPositionHitting(final MultiRect area) {
        return this.isPositionHitting(0, area, null);
    }
    
    public boolean isPositionHitting(final int index, final MultiRect area) {
        return this.isPositionHitting(index, area, null);
    }
    
    public boolean isPositionHitting(final int index, final MultiRect area, @Nullable final Transformation areaMatrix) {
        final TransformedVector vector = TransformedVector.obtain();
        try {
            vector.updateTransformation(areaMatrix, 1, 1);
            vector.setDestination(this.event.getX(index), this.event.getY(index), 0.0f, 0.0f);
            return area.contains(vector.getSourcePositionX(), vector.getSourcePositionY());
        }
        finally {
            vector.recycle();
        }
    }
    
    public float[] getPosition(final int index, final float[] dest) {
        dest[0] = this.event.getX(index);
        dest[1] = this.event.getY(index);
        this.matrix.mapPoints(dest);
        return dest;
    }
    
    public float[] getInterpolatedPosition(final float[] dest) {
        final TransformDiff diff = this.obtainTransformDifference();
        diff.getCurrentPos(dest);
        diff.recycle();
        return dest;
    }
    
    @Override
    public void onRecycle() {
    }
    
    @org.jetbrains.annotations.Nullable
    @Override
    public Recyclable getAlsoRecyclable() {
        return this.alsoRecyclable;
    }
    
    @Override
    public void setAlsoRecyclable(@org.jetbrains.annotations.Nullable final Recyclable recyclable) {
        this.alsoRecyclable = recyclable;
    }
    
    private static float[] lowPass(final float[] input, final float[] output) {
        if (output == null || output.length != input.length) {
            return input;
        }
        for (int i = 0; i < input.length; ++i) {
            output[i] += 0.1f * (input[i] - output[i]);
        }
        return output;
    }
    
    @CheckResult
    public static float calcSnapArea(final float radius, final float snapRangeInPixel, final float pixelDensity) {
        if (radius == 0.0f) {
            return 0.0f;
        }
        return (float)(360.0 * snapRangeInPixel * pixelDensity / (3.141592653589793 * radius * 2.0));
    }
    
    @CheckResult
    public static float mapToSnapSystem(final float value, final float[] sortedSnapPoints, final float snapArea, final boolean extendedRange) {
        return mapToSnapSystem(value, sortedSnapPoints, snapArea, extendedRange, null);
    }
    
    @CheckResult
    public static float mapToSnapSystem(float value, final float[] sortedSnapPoints, final float snapArea, final boolean extendedRange, final boolean[] snapped) {
        float offset = 0.0f;
        if (snapped != null) {
            snapped[0] = false;
        }
        int i = 0;
        while (i < sortedSnapPoints.length - 1) {
            final float outMin = sortedSnapPoints[i];
            final float outMax = sortedSnapPoints[i + 1];
            final float inMin = outMin + snapArea;
            float inMax = outMax - snapArea;
            if (extendedRange) {
                inMax += snapArea * 2.0f;
                value -= offset;
                offset += snapArea * 2.0f;
            }
            if (outMin <= value && value <= outMax + offset) {
                if (inMin < value && value < inMax) {
                    return MathUtils.mapRange(value, inMin, inMax, outMin, outMax);
                }
                if (snapped != null) {
                    snapped[0] = true;
                }
                return (inMin >= value) ? outMin : outMax;
            }
            else {
                ++i;
            }
        }
        return value;
    }
    
    @CheckResult
    public static float mapFromSnapSystem(float value, final float[] sortedSnapPoints, final float snapArea, final boolean extendedRange) {
        float offset = 0.0f;
        for (int i = 0; i < sortedSnapPoints.length - 1; ++i) {
            final float inMin = sortedSnapPoints[i];
            final float inMax = sortedSnapPoints[i + 1];
            final float outMin = inMin + snapArea;
            float outMax = inMax - snapArea;
            if (extendedRange) {
                outMax += snapArea * 2.0f;
                value += offset;
                offset += snapArea * 2.0f;
            }
            final float epsilon = 1.0E-5f;
            if (inMin + epsilon < value && value < inMax + offset - epsilon) {
                return MathUtils.mapRange(value, inMin, inMax, outMin, outMax);
            }
        }
        return value;
    }
    
    static {
        reusePool = new TransformedMotionEvent[6];
        IDENTITY_MATRIX = new Matrix();
        TransformedMotionEvent.pressStartTime = 0L;
        startTransformState = new TransformState();
        startScreenTransformState = new TransformState();
        TransformedMotionEvent.isClicked = false;
        TransformedMotionEvent.isDoubleTapped = false;
        TransformedMotionEvent.isDoubleTapCandidate = false;
    }
    
    private static class TransformState
    {
        static float[] smoothedValues;
        static float[] smoothedScreenValues;
        private boolean hasFixedCenterPoint;
        private float[][] points;
        private TransformState latestState;
        private Transformation matrix;
        
        TransformState() {
            this.hasFixedCenterPoint = false;
            this.points = new float[1][2];
            this.matrix = Transformation.permanent();
        }
        
        int getPointCount() {
            return this.hasFixedCenterPoint ? 1 : this.points.length;
        }
        
        @NonNull
        @MainThread
        TransformDiff calculateDiff(@NonNull final TransformedMotionEvent wrapper) {
            TransformState latestState = this.latestState;
            if (latestState == null) {
                latestState = new TransformState();
                latestState.set(wrapper);
                this.latestState = latestState;
            }
            else if (wrapper.getPointerCount() == latestState.getPointCount()) {
                latestState.set(wrapper);
            }
            this.matrix.set((Matrix)wrapper.matrix);
            final float[] centerPoint = this.getCenterPoint();
            final float[] latestCenterPoint = latestState.getCenterPoint();
            final float distanceDiff = latestState.getDistance() - this.getDistance();
            final float angle = latestState.getAngle(this.matrix) - this.getAngle(this.matrix);
            this.matrix.mapPoints(latestCenterPoint);
            this.matrix.mapPoints(centerPoint);
            this.matrix.mapRadius(distanceDiff);
            float[] values = { latestState.getDistance(), distanceDiff, latestState.getDistance() / this.getDistance() };
            if (!this.hasFixedCenterPoint) {
                if (wrapper.isScreenEvent) {
                    values = (TransformState.smoothedScreenValues = lowPass(values, TransformState.smoothedScreenValues));
                }
                else {
                    values = (TransformState.smoothedValues = lowPass(values, TransformState.smoothedValues));
                }
            }
            final float secondX = (latestState.points.length > 1) ? (latestState.hasFixedCenterPoint ? latestState.points[0][0] : latestState.points[1][0]) : Float.NaN;
            final float secondY = (latestState.points.length > 1) ? (latestState.hasFixedCenterPoint ? latestState.points[0][1] : latestState.points[1][1]) : Float.NaN;
            return obtain(values[0], values[1], angle, latestCenterPoint[0] - centerPoint[0], latestCenterPoint[1] - centerPoint[1], values[2], latestCenterPoint[0], latestCenterPoint[1], centerPoint[0], centerPoint[1], secondX, secondY);
        }
        
        public void set(@NonNull final TransformedMotionEvent wrapper) {
            final TransformState latestState = this.latestState;
            if (latestState != null) {
                latestState.set(wrapper);
            }
            this.hasFixedCenterPoint = wrapper.hasFixedCenterPoint();
            this.points = new float[this.hasFixedCenterPoint ? 2 : wrapper.getPointerCount()][];
            for (int i = 0, l = Math.min(wrapper.getPointerCount(), this.points.length); i < l; ++i) {
                float[] point = this.points[i];
                if (point == null) {
                    point = new float[2];
                    this.points[i] = point;
                }
                point[0] = wrapper.event.getX(i);
                point[1] = wrapper.event.getY(i);
            }
            if (this.hasFixedCenterPoint) {
                assert wrapper.fixedCenterPoint != null;
                final float[] centerPoint = { wrapper.fixedCenterPoint[0], wrapper.fixedCenterPoint[1] };
                this.points[1] = centerPoint;
            }
        }
        
        float[] getCenterPoint() {
            if (this.hasFixedCenterPoint) {
                final float[] centerPoint = this.points[1];
                return new float[] { centerPoint[0], centerPoint[1] };
            }
            if (this.points.length == 2) {
                return new float[] { (this.points[0][0] + this.points[1][0]) * 0.5f, (this.points[0][1] + this.points[1][1]) * 0.5f };
            }
            final float[] p1 = this.points[0];
            return new float[] { p1[0], p1[1] };
        }
        
        public float getDistance() {
            if (this.points.length == 2) {
                final float[] p1 = this.points[0];
                final float[] p2 = this.points[1];
                return Math.max((float)Math.sqrt((p1[0] - p2[0]) * (p1[0] - p2[0]) + (p1[1] - p2[1]) * (p1[1] - p2[1])), 1.0f);
            }
            return 1.0f;
        }
        
        float getAngle(final Matrix matrix) {
            float angle = 0.0f;
            if (this.points.length == 2) {
                final float[] pOrg1 = this.points[0];
                final float[] pOrg2 = this.points[1];
                final float[] points = { pOrg1[0], pOrg1[1], pOrg2[0], pOrg2[1] };
                matrix.mapPoints(points);
                angle = (float)Math.toDegrees(Math.atan2(points[1] - points[3], points[0] - points[2]));
                if (angle < 0.0f) {
                    angle += 360.0f;
                }
            }
            return angle;
        }
        
        static {
            TransformState.smoothedValues = null;
            TransformState.smoothedScreenValues = null;
        }
    }
    
    public static class TransformDiff implements Recyclable
    {
        private static final int REUSE_COUNT = 20;
        private static final TransformDiff[] reusePool;
        private volatile boolean isRecycled;
        public float distance;
        public float distanceDiff;
        public float angleDiff;
        public float xDiff;
        public float yDiff;
        public float scale;
        public float currentX;
        public float currentY;
        public float startX;
        public float startY;
        public float secondX;
        public float secondY;
        private Recyclable alsoRecyclable;
        
        public TransformDiff() {
            this.isRecycled = false;
            this.alsoRecyclable = null;
        }
        
        private void getCurrentPos(final float[] destination) {
            destination[0] = this.currentX;
            destination[1] = this.currentY;
        }
        
        private TransformDiff set(final float distance, final float distanceDiff, final float angleDiff, final float xDiff, final float yDiff, final float scale, final float x, final float y, final float startX, final float startY, final float secondX, final float secondY) {
            this.distance = distance;
            this.distanceDiff = distanceDiff;
            this.angleDiff = angleDiff;
            this.xDiff = xDiff;
            this.yDiff = yDiff;
            this.scale = scale;
            this.currentX = x;
            this.currentY = y;
            this.startX = startX;
            this.startY = startY;
            this.secondX = secondX;
            this.secondY = secondY;
            return this;
        }
        
        private static TransformDiff obtain(final float distance, final float distanceDiff, final float angleDiff, final float xDiff, final float yDiff, final float scale, final float x, final float y, final float startX, final float startY, final float secondX, final float secondY) {
            synchronized (TransformDiff.reusePool) {
                for (int i = 0; i < 20; ++i) {
                    final TransformDiff p = TransformDiff.reusePool[i];
                    if (p != null) {
                        TransformDiff.reusePool[i] = null;
                        if (p.isRecycled) {
                            p.isRecycled = false;
                            return p.set(distance, distanceDiff, angleDiff, xDiff, yDiff, scale, x, y, startX, startY, secondX, secondY);
                        }
                    }
                }
            }
            return new TransformDiff().set(distance, distanceDiff, angleDiff, xDiff, yDiff, scale, x, y, startX, startY, secondX, secondY);
        }
        
        @Override
        public void recycle() {
            if (!this.isRecycled) {
                this.isRecycled = true;
                synchronized (TransformDiff.reusePool) {
                    for (int i = 0; i < 20; ++i) {
                        if (TransformDiff.reusePool[i] == null) {
                            TransformDiff.reusePool[i] = this;
                            return;
                        }
                    }
                }
            }
        }
        
        @Override
        public String toString() {
            return "TransformDiff{isRecycled=" + this.isRecycled + ", distanceDiff=" + this.distanceDiff + ", angleDiff=" + this.angleDiff + ", xDiff=" + this.xDiff + ", yDiff=" + this.yDiff + ", scale=" + this.scale + ", currentX=" + this.currentX + ", currentY=" + this.currentY + ", startX=" + this.startX + ", startY=" + this.startY + '}';
        }
        
        @Override
        public void onRecycle() {
        }
        
        @org.jetbrains.annotations.Nullable
        @Override
        public Recyclable getAlsoRecyclable() {
            return this.alsoRecyclable;
        }
        
        @Override
        public void setAlsoRecyclable(@org.jetbrains.annotations.Nullable final Recyclable recyclable) {
            this.alsoRecyclable = recyclable;
        }
        
        static {
            reusePool = new TransformDiff[20];
        }
    }
}
