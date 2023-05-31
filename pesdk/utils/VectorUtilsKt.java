// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u00006\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\"\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\b\u001a\u00020\u00022\u0006\u0010\u0006\u001a\u00020\u0007\u001a\u001a\u0010\t\u001a\u00020\u0004*\u00020\n2\u0006\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004\u001a@\u0010\r\u001a\u0002H\u000e\"\u0004\b\u0000\u0010\u000e*\u00020\u000f2#\b\u0004\u0010\u0010\u001a\u001d\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0014\u0012\u0004\u0012\u0002H\u000e0\u0011H\u0086\f\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016" }, d2 = { "mapToRotatedSource", "", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "sourceWidth", "", "sourceHeight", "rotation90deg", "", "source", "orthogonalDistanceTo", "Lly/img/android/pesdk/utils/TransformedMotionEvent$TransformDiff;", "refX", "refY", "useInverted", "T", "Lly/img/android/pesdk/backend/model/chunk/Transformation;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Lly/img/android/pesdk/backend/model/chunk/Transformation;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pesdk-backend-core_release" })
public final class VectorUtilsKt
{
    public static final <T> T useInverted(@NotNull final Transformation $this$useInverted, @NotNull final Function1<? super Transformation, ? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)$this$useInverted, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$useInverted = 0;
        final Recyclable $this$recycleAfter$iv = $this$useInverted.obtainInverted();
        final int $i$f$recycleAfter = 0;
        final Recyclable it$iv = $this$recycleAfter$iv;
        final int n = 0;
        final Object $this$andRecycle$iv$iv = block.invoke((Object)it$iv);
        final int $i$f$andRecycle = 0;
        final Object it$iv$iv = $this$andRecycle$iv$iv;
        final int n2 = 0;
        it$iv.recycle();
        return (T)it$iv$iv;
    }
    
    public static final void mapToRotatedSource(@NotNull final MultiRect $this$mapToRotatedSource, @NotNull final MultiRect source, final int rotation90deg) {
        Intrinsics.checkNotNullParameter((Object)$this$mapToRotatedSource, "<this>");
        Intrinsics.checkNotNullParameter((Object)source, "source");
        VectorUtils.INSTANCE.mapToRotatedSource($this$mapToRotatedSource, source, rotation90deg);
    }
    
    public static final void mapToRotatedSource(@NotNull final MultiRect $this$mapToRotatedSource, final float sourceWidth, final float sourceHeight, final int rotation90deg) {
        Intrinsics.checkNotNullParameter((Object)$this$mapToRotatedSource, "<this>");
        VectorUtils.INSTANCE.mapToRotatedSource($this$mapToRotatedSource, sourceWidth, sourceHeight, rotation90deg);
    }
    
    public static final float orthogonalDistanceTo(@NotNull final TransformedMotionEvent.TransformDiff $this$orthogonalDistanceTo, final float refX, final float refY) {
        Intrinsics.checkNotNullParameter((Object)$this$orthogonalDistanceTo, "<this>");
        final float rotation = 180 - VectorUtils.getAngle($this$orthogonalDistanceTo.startX, $this$orthogonalDistanceTo.startY, refX, refY);
        final float[] $this$x2$iv;
        final float[] yNormalPos = $this$x2$iv = VectorUtils.rotatePointsAroundCenter($this$orthogonalDistanceTo.startX, $this$orthogonalDistanceTo.startY, rotation, new float[] { refX, refY, $this$orthogonalDistanceTo.secondX, $this$orthogonalDistanceTo.secondY });
        final int $i$f$getX2 = 0;
        final float n = $this$x2$iv[2];
        final float[] $this$x1$iv = yNormalPos;
        final int $i$f$getX3 = 0;
        return n - $this$x1$iv[0];
    }
}
