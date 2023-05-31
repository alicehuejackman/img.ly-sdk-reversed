// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.Nullable;
import android.graphics.Paint;
import android.graphics.Canvas;
import ly.img.android.pesdk.backend.model.chunk.RectRecycler;
import android.graphics.Bitmap;
import java.lang.ref.SoftReference;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;

public class RectMatrixUtilities
{
    private static final boolean DEBUG_LINES = false;
    private RectF destinationChunk;
    private Rect roundedDestinationChunk;
    private int chunkCount;
    private Matrix transformMatrix;
    private Matrix inverseMatrix;
    private SoftReference<Bitmap> bitmapRecycle;
    
    public RectMatrixUtilities(final Rect destinationChunk, final int chunkCount, final Matrix transformMatrix) {
        this(new RectF(destinationChunk), chunkCount, transformMatrix);
    }
    
    public RectMatrixUtilities(final RectF destinationChunk, final int chunkCount, final Matrix transformMatrix) {
        this.destinationChunk = destinationChunk;
        this.roundedDestinationChunk = new Rect();
        this.destinationChunk.roundOut(this.roundedDestinationChunk);
        this.chunkCount = chunkCount;
        (this.transformMatrix = transformMatrix).invert(this.inverseMatrix = new Matrix());
    }
    
    public static Rect scaleRectSize(final Rect rect, final float scaleFactor) {
        final Rect rounded = RectRecycler.obtain();
        scaleRectFSize(new RectF(rect), scaleFactor).roundOut(rounded);
        return rounded;
    }
    
    public static Rect scaleRectSize(final RectF rect, final float scaleFactor) {
        final Rect rounded = RectRecycler.obtain();
        scaleRectFSize(rect, scaleFactor).roundOut(rounded);
        return rounded;
    }
    
    public static RectF scaleRectFSize(final RectF rect, final float scaleFactor) {
        return new RectF(rect.left * scaleFactor, rect.top * scaleFactor, rect.right * scaleFactor, rect.bottom * scaleFactor);
    }
    
    public static Rect sampledRectSize(final Rect rect, final float sampleFactor) {
        return sampledRectSize(new RectF(rect), sampleFactor);
    }
    
    public static Rect sampledRectSize(final RectF rect, final float sampleFactor) {
        final Rect rounded = RectRecycler.obtain();
        new RectF(rect.left / sampleFactor, rect.top / sampleFactor, rect.right / sampleFactor, rect.bottom / sampleFactor).roundOut(rounded);
        return rounded;
    }
    
    public static Rect createOffsetChunkRect(final Rect rect, final Rect rangeRect, final int offset) {
        final int left = rect.left - offset;
        final int top = rect.top - offset;
        final int right = rect.right + offset;
        final int bottom = rect.bottom + offset;
        return RectRecycler.obtain((left < rangeRect.left) ? rangeRect.left : left, (top < rangeRect.top) ? rangeRect.top : top, (right > rangeRect.right) ? rangeRect.right : right, (bottom > rangeRect.bottom) ? rangeRect.bottom : bottom);
    }
    
    public static Bitmap offsetCutOperation(final Rect rect, final Rect rangeRect, final int offset, final BitmapOperation operation) {
        final int left = rect.left - offset;
        final int top = rect.top - offset;
        final int right = rect.right + offset;
        final int bottom = rect.bottom + offset;
        final Rect offsetRect = RectRecycler.obtain((left < rangeRect.left) ? rangeRect.left : left, (top < rangeRect.top) ? rangeRect.top : top, (right > rangeRect.right) ? rangeRect.right : right, (bottom > rangeRect.bottom) ? rangeRect.bottom : bottom);
        final Bitmap bitmap = operation.run(offsetRect, 1, 1);
        if (offsetRect.equals((Object)rect)) {
            return bitmap;
        }
        final float scaleX = bitmap.getWidth() / (float)offsetRect.width();
        final float scaleY = bitmap.getHeight() / (float)offsetRect.height();
        final int x = Math.round((rect.left - offsetRect.left) * scaleX);
        final int y = Math.round((rect.top - offsetRect.top) * scaleY);
        final int width = Math.round(rect.width() * scaleX);
        final int height = Math.round(rect.width() * scaleX);
        if (x + width > bitmap.getWidth() || y + height > bitmap.getHeight()) {
            Trace.out("chunk", "error", offsetRect, rect, scaleX, scaleY, Math.round((rect.left - offsetRect.left) * scaleX), Math.round((rect.top - offsetRect.top) * scaleY), Math.round(rect.width() * scaleX), Math.round(rect.height() * scaleY), bitmap.getWidth(), bitmap.getHeight());
            return bitmap;
        }
        return Bitmap.createBitmap(bitmap, x, y, width, height);
    }
    
    public Matrix getInverseMatrix() {
        return this.inverseMatrix;
    }
    
    public Matrix getInverseCombineMatrix() {
        final Matrix matrix = new Matrix(this.inverseMatrix);
        matrix.postTranslate(-this.destinationChunk.left, -this.destinationChunk.top);
        return matrix;
    }
    
    public Rect[] getSourceChunks() {
        final float[] destinationPoints = rectToShape(this.destinationChunk);
        final RectF fullSourceRegion = new RectF(this.destinationChunk);
        this.transformMatrix.mapRect(fullSourceRegion);
        this.transformMatrix.mapPoints(destinationPoints);
        Rect[] chunks;
        if (fullSourceRegion.width() > fullSourceRegion.height()) {
            if (this.chunkCount > fullSourceRegion.height()) {
                this.chunkCount = (int)fullSourceRegion.height();
            }
            chunks = new Rect[this.chunkCount];
            final float chunkWidth = fullSourceRegion.width() / this.chunkCount;
            for (int i = 0; i < this.chunkCount; ++i) {
                final float chunkX = fullSourceRegion.left + chunkWidth * i;
                final RectF range = new RectF(chunkX - 1.0f, fullSourceRegion.top - 1.0f, chunkX + chunkWidth + 1.0f, fullSourceRegion.bottom + 1.0f);
                final float[] intersection = calculateRectShapeIntersection(range, destinationPoints, true);
                chunks[i] = RectRecycler.obtain();
                new RectF(chunkX, intersection[0], chunkX + chunkWidth, intersection[1]).roundOut(chunks[i]);
            }
        }
        else {
            if (this.chunkCount > fullSourceRegion.height()) {
                this.chunkCount = (int)fullSourceRegion.height();
            }
            chunks = new Rect[this.chunkCount];
            final float chunkHeight = fullSourceRegion.height() / this.chunkCount;
            for (int i = 0; i < this.chunkCount; ++i) {
                final float chunkY = fullSourceRegion.top + chunkHeight * i;
                final RectF range = new RectF(fullSourceRegion.left - 1.0f, chunkY - 1.0f, fullSourceRegion.right + 1.0f, chunkY + chunkHeight + 1.0f);
                final float[] intersection = calculateRectShapeIntersection(range, destinationPoints, false);
                chunks[i] = RectRecycler.obtain();
                new RectF(intersection[0], chunkY, intersection[1], chunkY + chunkHeight).roundOut(chunks[i]);
            }
        }
        return chunks;
    }
    
    public Bitmap combineChunkRequests(final BitmapOperation operation) {
        return this.combineChunkRequests((this.bitmapRecycle == null) ? null : this.bitmapRecycle.get(), operation);
    }
    
    @Nullable
    public Bitmap combineChunkRequests(Bitmap out, final BitmapOperation operation) {
        if ((this.chunkCount == 1 && this.transformMatrix.isIdentity()) || this.destinationChunk.width() < 1.0f || this.destinationChunk.height() < 1.0f) {
            return operation.run(this.roundedDestinationChunk, 1, 0);
        }
        if (out == null || out.getWidth() != this.destinationChunk.width() || out.getHeight() != this.destinationChunk.height()) {
            out = Bitmap.createBitmap((int)Math.ceil(this.destinationChunk.width()), (int)Math.ceil(this.destinationChunk.height()), Bitmap.Config.ARGB_8888);
        }
        final Canvas canvas = new Canvas(out);
        canvas.setMatrix(this.getInverseCombineMatrix());
        final Paint drawPaint = new Paint(1);
        drawPaint.setFilterBitmap(true);
        final Rect sourceRect = RectRecycler.obtain();
        final Rect[] sourceChunks = this.getSourceChunks();
        int i = 0;
        for (final Rect chunkRect : sourceChunks) {
            final Bitmap chunkBitmap = operation.run(chunkRect, sourceChunks.length, i++);
            if (chunkBitmap == null) {
                return null;
            }
            sourceRect.set(0, 0, chunkBitmap.getWidth(), chunkBitmap.getHeight());
            canvas.drawBitmap(chunkBitmap, sourceRect, chunkRect, drawPaint);
            RectRecycler.recycle(sourceRect);
            RectRecycler.obtain(chunkRect);
        }
        return out;
    }
    
    public static float[] calculateRectShapeIntersection(final RectF range, final float[] shape, final boolean verticalIntersection) {
        final float minPos = verticalIntersection ? range.left : range.top;
        final float maxPos = verticalIntersection ? range.right : range.bottom;
        final float minRage = verticalIntersection ? range.top : range.left;
        final float maxRage = verticalIntersection ? range.bottom : range.right;
        final float[] points = { minPos, maxPos };
        float min = Float.MAX_VALUE;
        float max = -3.4028235E38f;
        for (int i = 0; i < 8; i += 2) {
            final float pointX = shape[i];
            final float pointY = shape[i + 1];
            final boolean pointInRange = range.contains(pointX, pointY);
            if (pointInRange) {
                final float value = verticalIntersection ? pointY : pointX;
                if (min > value) {
                    min = value;
                }
                if (max < value) {
                    max = value;
                }
            }
        }
        for (int i = 0; i < 4; ++i) {
            final float[] line = new float[4];
            if (i == 3) {
                System.arraycopy(shape, 0, line, 0, 2);
                System.arraycopy(shape, i << 1, line, 2, 2);
            }
            else {
                System.arraycopy(shape, i << 1, line, 0, 4);
            }
            for (final float pos : points) {
                final float value2 = verticalIntersection ? calculateLineIntersectionY(line, pos) : calculateLineIntersectionX(line, pos);
                if (value2 > minRage && value2 < maxRage) {
                    if (min > value2) {
                        min = value2;
                    }
                    if (max < value2) {
                        max = value2;
                    }
                }
            }
        }
        return new float[] { Math.max(minRage, min), Math.min(maxRage, max) };
    }
    
    public static float[] rectToShape(final RectF rectF) {
        return new float[] { rectF.left, rectF.top, rectF.right, rectF.top, rectF.right, rectF.bottom, rectF.left, rectF.bottom };
    }
    
    public static float calculateLineIntersectionY(final float[] line, final float x) {
        final float aX = line[0];
        final float aY = line[1];
        final float bX = line[2];
        final float bY = line[3];
        final float g = bY - aY;
        final float t = (x - aX) / (bX - aX);
        return aY + t * g;
    }
    
    public static float calculateLineIntersectionX(final float[] line, final float y) {
        final float aX = line[0];
        final float aY = line[1];
        final float bX = line[2];
        final float bY = line[3];
        final float g = bX - aX;
        final float t = (y - aY) / (bY - aY);
        return aX + t * g;
    }
    
    public abstract static class BitmapOperation
    {
        public abstract Bitmap run(final Rect p0, final int p1, final int p2);
    }
}
