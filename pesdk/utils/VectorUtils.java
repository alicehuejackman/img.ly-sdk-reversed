// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.math.MathKt;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import kotlin.jvm.JvmOverloads;
import kotlin.collections.ArraysKt;
import android.graphics.RectF;
import android.graphics.Rect;
import android.graphics.Matrix;
import androidx.annotation.CheckResult;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmStatic;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0014\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\n\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0004H\u0007J \u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0007J(\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0011\u001a\u00020\u0004H\u0007J\u0018\u0010\r\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0007J(\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0019\u001a\u00020\u0004H\u0007J\u0018\u0010\u0015\u001a\u00020\b2\u0006\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0013H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020\nH\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\n2\u0006\u0010\u001f\u001a\u00020 H\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020\nH\u0007J\u0018\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020 2\u0006\u0010\u001f\u001a\u00020 H\u0007J4\u0010!\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001d2\n\b\u0002\u0010&\u001a\u0004\u0018\u00010'H\u0007J&\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00042\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020-J\u001e\u0010(\u001a\u00020\b2\u0006\u0010\t\u001a\u00020)2\u0006\u0010.\u001a\u00020)2\u0006\u0010,\u001a\u00020-J(\u0010/\u001a\u00020\u00042\u0006\u0010\"\u001a\u00020\u00042\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00042\u0006\u0010%\u001a\u00020\u001dH\u0007J\u0018\u00100\u001a\u00020\b2\u0006\u00101\u001a\u00020\u00132\u0006\u00102\u001a\u00020-H\u0007J0\u00103\u001a\u00020\u00132\u0006\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u00042\u0006\u00107\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0013H\u0007J(\u00103\u001a\u00020\u00132\u0006\u0010:\u001a\u00020\u00042\u0006\u0010;\u001a\u00020\u00042\u0006\u00108\u001a\u00020\u00042\u0006\u00109\u001a\u00020\u0013H\u0007J$\u0010<\u001a\u00020\u00132\u0006\u0010=\u001a\u00020-2\u0006\u00101\u001a\u00020\u00132\n\b\u0002\u0010>\u001a\u0004\u0018\u00010\u0013H\u0007¨\u0006?" }, d2 = { "Lly/img/android/pesdk/utils/VectorUtils;", "", "()V", "calcAngleSnapDistance", "", "radius", "snapRangeInPixel", "cutVerticalIntersection", "", "rect", "Landroid/graphics/Rect;", "top", "bottom", "distance", "pos1X", "pos1Y", "pos2X", "pos2Y", "pos1", "", "pos2", "getAngle", "centerPosX", "centerPosY", "pointPosX", "pointPosY", "centerPos", "pointPos", "hasIntersection", "", "a", "b", "Landroid/graphics/RectF;", "mapFromSnapSystem", "value", "sortedSnapPoints", "snapRange", "extendedRange", "snapped", "", "mapToRotatedSource", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "sourceWidth", "sourceHeight", "rotation90deg", "", "source", "mapToSnapSystem", "reversePointsPositions", "srcArray", "pointSize", "rotatePointsAroundCenter", "matrixDummy", "Landroid/graphics/Matrix;", "centerX", "centerY", "angle", "points", "x", "y", "shiftPointsPositions", "_offset", "_destArray", "pesdk-backend-core_release" })
public final class VectorUtils
{
    @NotNull
    public static final VectorUtils INSTANCE;
    
    private VectorUtils() {
    }
    
    @JvmStatic
    public static final void reversePointsPositions(@NotNull final float[] srcArray, final int pointSize) {
        Intrinsics.checkNotNullParameter((Object)srcArray, "srcArray");
        for (int index = 0; index < srcArray.length / pointSize / 2; ++index) {
            for (int index2 = 0; index2 < pointSize; ++index2) {
                final int n = index * pointSize + index2;
                final float n2 = srcArray[srcArray.length - pointSize * (index + 1) + index2];
                final int n3 = n;
                final int n4 = 0;
                srcArray[srcArray.length - pointSize * (index + 1) + index2] = srcArray[index * pointSize + index2];
                final Unit instance = Unit.INSTANCE;
                srcArray[n3] = n2;
            }
        }
    }
    
    @JvmStatic
    @CheckResult
    @NotNull
    public static final float[] shiftPointsPositions(final int _offset, @NotNull final float[] srcArray, @Nullable final float[] _destArray) {
        Intrinsics.checkNotNullParameter((Object)srcArray, "srcArray");
        if (_destArray == srcArray) {
            throw new IllegalArgumentException();
        }
        float[] array = null;
        Label_0064: {
            if (_destArray != null) {
                final float[] it = _destArray;
                final int n = 0;
                float[] array2;
                if (it.length == srcArray.length) {
                    array = _destArray;
                    array2 = _destArray;
                }
                else {
                    array = (array2 = null);
                }
                if (array2 != null) {
                    break Label_0064;
                }
            }
            array = new float[srcArray.length];
        }
        final float[] destArray = array;
        final int offset = _offset % srcArray.length;
        System.arraycopy(srcArray, srcArray.length - offset, destArray, 0, offset);
        System.arraycopy(srcArray, 0, destArray, offset, srcArray.length - offset);
        return destArray;
    }
    
    @JvmStatic
    public static final float distance(final float pos1X, final float pos1Y, final float pos2X, final float pos2Y) {
        final float dx = pos1X - pos2X;
        final float dy = pos1Y - pos2Y;
        return (float)Math.sqrt(dx * dx + dy * dy);
    }
    
    @JvmStatic
    public static final float distance(@NotNull final float[] pos1, @NotNull final float[] pos2) {
        Intrinsics.checkNotNullParameter((Object)pos1, "pos1");
        Intrinsics.checkNotNullParameter((Object)pos2, "pos2");
        final VectorUtils instance = VectorUtils.INSTANCE;
        return distance(pos1[0], pos1[1], pos2[0], pos2[1]);
    }
    
    @JvmStatic
    @NotNull
    public static final float[] rotatePointsAroundCenter(@NotNull final Matrix matrixDummy, final float centerX, final float centerY, final float angle, @NotNull final float[] points) {
        Intrinsics.checkNotNullParameter((Object)matrixDummy, "matrixDummy");
        Intrinsics.checkNotNullParameter((Object)points, "points");
        matrixDummy.reset();
        matrixDummy.preRotate(angle, centerX, centerY);
        matrixDummy.mapPoints(points);
        return points;
    }
    
    @JvmStatic
    public static final void getAngle(@NotNull final float[] centerPos, @NotNull final float[] pointPos) {
        Intrinsics.checkNotNullParameter((Object)centerPos, "centerPos");
        Intrinsics.checkNotNullParameter((Object)pointPos, "pointPos");
        final VectorUtils instance = VectorUtils.INSTANCE;
        getAngle(centerPos[0], centerPos[1], pointPos[0], pointPos[1]);
    }
    
    @JvmStatic
    public static final float getAngle(final float centerPosX, final float centerPosY, final float pointPosX, final float pointPosY) {
        return (float)Math.toDegrees(Math.atan2(centerPosY - pointPosY, centerPosX - pointPosX));
    }
    
    @JvmStatic
    public static final boolean hasIntersection(@NotNull final Rect a, @NotNull final RectF b) {
        Intrinsics.checkNotNullParameter((Object)a, "a");
        Intrinsics.checkNotNullParameter((Object)b, "b");
        return a.left < b.right && b.left < a.right && a.top < b.bottom && b.top < a.bottom;
    }
    
    @JvmStatic
    public static final boolean hasIntersection(@NotNull final RectF a, @NotNull final Rect b) {
        Intrinsics.checkNotNullParameter((Object)a, "a");
        Intrinsics.checkNotNullParameter((Object)b, "b");
        return a.left < b.right && b.left < a.right && a.top < b.bottom && b.top < a.bottom;
    }
    
    @JvmStatic
    public static final boolean hasIntersection(@NotNull final Rect a, @NotNull final Rect b) {
        Intrinsics.checkNotNullParameter((Object)a, "a");
        Intrinsics.checkNotNullParameter((Object)b, "b");
        return a.left < b.right && b.left < a.right && a.top < b.bottom && b.top < a.bottom;
    }
    
    @JvmStatic
    public static final boolean hasIntersection(@NotNull final RectF a, @NotNull final RectF b) {
        Intrinsics.checkNotNullParameter((Object)a, "a");
        Intrinsics.checkNotNullParameter((Object)b, "b");
        return a.left < b.right && b.left < a.right && a.top < b.bottom && b.top < a.bottom;
    }
    
    @JvmStatic
    @CheckResult
    public static final float calcAngleSnapDistance(final float radius, final float snapRangeInPixel) {
        return (radius == 0.0f) ? 0.0f : ((float)(360.0 * snapRangeInPixel / (3.141592653589793 * radius * 2.0)));
    }
    
    @JvmStatic
    @CheckResult
    public static final float mapToSnapSystem(final float value, @NotNull final float[] sortedSnapPoints, final float snapRange, final boolean extendedRange) {
        Intrinsics.checkNotNullParameter((Object)sortedSnapPoints, "sortedSnapPoints");
        if (ArraysKt.first(sortedSnapPoints) > value) {
            return value - snapRange;
        }
        for (int i = 0; i < sortedSnapPoints.length - 1; ++i) {
            final float inMin = sortedSnapPoints[i];
            final float inMax = sortedSnapPoints[i + 1];
            float outMin = inMin + snapRange;
            float outMax = inMax - snapRange;
            float offset = 0.0f;
            if (extendedRange) {
                offset = i * snapRange * 2.0f;
                outMin += offset;
                outMax += offset + snapRange * 2.0f;
            }
            final float epsilon = 1.0E-5f;
            if (inMin <= value && value <= inMax) {
                return (value <= inMin + epsilon) ? (inMin + offset) : ((value >= inMax - epsilon) ? (inMax + offset + (extendedRange ? (snapRange * 2.0f) : 0.0f)) : MathUtils.mapRange(value, inMin, inMax, outMin, outMax));
            }
        }
        return extendedRange ? (value + (sortedSnapPoints.length - 1) * snapRange * 2.0f + snapRange) : value;
    }
    
    @JvmStatic
    @CheckResult
    @JvmOverloads
    public static final float mapFromSnapSystem(final float value, @NotNull final float[] sortedSnapPoints, final float snapRange, final boolean extendedRange, @Nullable final boolean[] snapped) {
        Intrinsics.checkNotNullParameter((Object)sortedSnapPoints, "sortedSnapPoints");
        if (snapped != null) {
            snapped[0] = false;
        }
        if (sortedSnapPoints[0] > value) {
            float n;
            if (value >= sortedSnapPoints[0] - snapRange) {
                if (snapped != null) {
                    snapped[0] = true;
                }
                n = sortedSnapPoints[0];
            }
            else {
                n = value + snapRange;
            }
            return n;
        }
        float valueWithOffset = value;
        for (int i = 0; i < sortedSnapPoints.length - 1; ++i) {
            final float outMin = sortedSnapPoints[i];
            final float outMax = sortedSnapPoints[i + 1];
            final float inMin = outMin + snapRange;
            float inMax = outMax - snapRange;
            float rangeMax = outMax;
            if (extendedRange) {
                inMax += snapRange * 2.0f;
                rangeMax += snapRange * 2.0f;
                valueWithOffset = value - i * snapRange * 2.0f;
            }
            if (outMin <= valueWithOffset && valueWithOffset <= rangeMax) {
                float mapRange;
                if (inMin <= valueWithOffset && valueWithOffset <= inMax) {
                    mapRange = MathUtils.mapRange(valueWithOffset, inMin, inMax, outMin, outMax);
                }
                else if (valueWithOffset <= inMin) {
                    if (snapped != null) {
                        snapped[0] = true;
                    }
                    mapRange = outMin;
                }
                else {
                    if (snapped != null) {
                        snapped[0] = true;
                    }
                    mapRange = outMax;
                }
                return mapRange;
            }
        }
        valueWithOffset -= snapRange * 3.0f;
        float last;
        if (valueWithOffset <= ArraysKt.last(sortedSnapPoints)) {
            if (snapped != null) {
                snapped[0] = true;
            }
            last = ArraysKt.last(sortedSnapPoints);
        }
        else {
            last = valueWithOffset;
        }
        return last;
    }
    
    public static /* synthetic */ float mapFromSnapSystem$default(final float value, final float[] sortedSnapPoints, final float snapRange, final boolean extendedRange, boolean[] snapped, final int n, final Object o) {
        if ((n & 0x10) != 0x0) {
            snapped = null;
        }
        return mapFromSnapSystem(value, sortedSnapPoints, snapRange, extendedRange, snapped);
    }
    
    @JvmStatic
    @NotNull
    public static final float[] rotatePointsAroundCenter(final float x, final float y, final float angle, @NotNull final float[] points) {
        Intrinsics.checkNotNullParameter((Object)points, "points");
        final float[] $this$mapPointsBy$iv = points;
        final int $i$f$mapPointsBy = 0;
        final Recyclable $this$recycleAfter$iv$iv = Transformation.obtain();
        final int $i$f$recycleAfter = 0;
        final Recyclable it$iv$iv = $this$recycleAfter$iv$iv;
        final int n = 0;
        final Transformation it$iv = (Transformation)it$iv$iv;
        final int n2 = 0;
        final Matrix it = it$iv;
        final int n3 = 0;
        it.setRotate(angle, x, y);
        it$iv.mapPoints($this$mapPointsBy$iv);
        final Object $this$andRecycle$iv$iv$iv = Unit.INSTANCE;
        final int $i$f$andRecycle = 0;
        final Object it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
        final int n4 = 0;
        it$iv$iv.recycle();
        return points;
    }
    
    @JvmStatic
    public static final void cutVerticalIntersection(@NotNull final Rect rect, final float top, final float bottom) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        final int rectCenterY = rect.centerY();
        final float viewCenterY = (top + bottom) / 2;
        final boolean intersects = rect.contains(rect.left, MathKt.roundToInt(top)) || rect.contains(rect.left, MathKt.roundToInt(bottom));
        if (intersects) {
            if (viewCenterY < rectCenterY) {
                rect.top = MathKt.roundToInt(bottom);
            }
            else {
                rect.bottom = MathKt.roundToInt(top);
            }
        }
    }
    
    public final void mapToRotatedSource(@NotNull final MultiRect rect, @NotNull final MultiRect source, final int rotation90deg) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        Intrinsics.checkNotNullParameter((Object)source, "source");
        final int rotation = MathUtils.wrapTo360(rotation90deg);
        MultiRect $this$mapRectBy$iv = rect;
        int $i$f$mapRectBy = 0;
        Recyclable $this$recycleAfter$iv$iv = Transformation.obtain();
        int $i$f$recycleAfter = 0;
        Recyclable it$iv$iv = $this$recycleAfter$iv$iv;
        int n = 0;
        Transformation it$iv = (Transformation)it$iv$iv;
        int n2 = 0;
        Matrix it = it$iv;
        final int n3 = 0;
        it.postScale(1.0f / source.getWidth(), 1.0f / source.getHeight());
        it.preRotate((float)rotation, source.centerX() / source.getWidth(), source.centerY() / source.getHeight());
        boolean $this$andRecycle$iv$iv$iv = it$iv.mapRect((RectF)$this$mapRectBy$iv);
        int $i$f$andRecycle = 0;
        boolean it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
        int n4 = 0;
        it$iv$iv.recycle();
        $this$mapRectBy$iv = rect;
        $i$f$mapRectBy = 0;
        $this$recycleAfter$iv$iv = Transformation.obtain();
        $i$f$recycleAfter = 0;
        it$iv$iv = $this$recycleAfter$iv$iv;
        n = 0;
        it$iv = (Transformation)it$iv$iv;
        n2 = 0;
        it = it$iv;
        final int n5 = 0;
        switch (rotation % 180) {
            case 0: {
                it.postScale(source.getWidth(), source.getHeight());
                break;
            }
            case 90: {
                it.postScale(source.getHeight(), source.getWidth());
                break;
            }
            default: {
                throw new IllegalStateException("Rotation must be multiple of 90");
            }
        }
        $this$andRecycle$iv$iv$iv = it$iv.mapRect((RectF)$this$mapRectBy$iv);
        $i$f$andRecycle = 0;
        it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
        n4 = 0;
        it$iv$iv.recycle();
    }
    
    public final void mapToRotatedSource(@NotNull final MultiRect rect, final float sourceWidth, final float sourceHeight, final int rotation90deg) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        final int rotation = MathUtils.wrapTo360(rotation90deg);
        MultiRect $this$mapRectBy$iv = rect;
        int $i$f$mapRectBy = 0;
        Recyclable $this$recycleAfter$iv$iv = Transformation.obtain();
        int $i$f$recycleAfter = 0;
        Recyclable it$iv$iv = $this$recycleAfter$iv$iv;
        int n = 0;
        Transformation it$iv = (Transformation)it$iv$iv;
        int n2 = 0;
        Matrix it = it$iv;
        final int n3 = 0;
        it.postScale(1.0f / sourceWidth, 1.0f / sourceHeight);
        it.postRotate((float)rotation, 0.5f, 0.5f);
        boolean $this$andRecycle$iv$iv$iv = it$iv.mapRect((RectF)$this$mapRectBy$iv);
        int $i$f$andRecycle = 0;
        boolean it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
        int n4 = 0;
        it$iv$iv.recycle();
        $this$mapRectBy$iv = rect;
        $i$f$mapRectBy = 0;
        $this$recycleAfter$iv$iv = Transformation.obtain();
        $i$f$recycleAfter = 0;
        it$iv$iv = $this$recycleAfter$iv$iv;
        n = 0;
        it$iv = (Transformation)it$iv$iv;
        n2 = 0;
        it = it$iv;
        final int n5 = 0;
        switch (rotation % 180) {
            case 0: {
                it.postScale(sourceWidth, sourceHeight);
                break;
            }
            case 90: {
                it.postScale(sourceHeight, sourceWidth);
                break;
            }
            default: {
                throw new IllegalStateException("Rotation must be multiple of 90");
            }
        }
        $this$andRecycle$iv$iv$iv = it$iv.mapRect((RectF)$this$mapRectBy$iv);
        $i$f$andRecycle = 0;
        it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
        n4 = 0;
        it$iv$iv.recycle();
    }
    
    @JvmStatic
    @CheckResult
    @JvmOverloads
    public static final float mapFromSnapSystem(final float value, @NotNull final float[] sortedSnapPoints, final float snapRange, final boolean extendedRange) {
        Intrinsics.checkNotNullParameter((Object)sortedSnapPoints, "sortedSnapPoints");
        return mapFromSnapSystem$default(value, sortedSnapPoints, snapRange, extendedRange, null, 16, null);
    }
    
    static {
        INSTANCE = new VectorUtils();
    }
}
