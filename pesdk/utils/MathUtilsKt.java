// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.math.MathKt;
import kotlin.ranges.LongRange;
import androidx.annotation.CheckResult;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.ranges.IntRange;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000$\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\b\u001a\u001c\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u0001H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0004*\u00020\u00042\u0006\u0010\u0002\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0004H\u0007\u001a\u001c\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0002\u001a\u00020\u00052\u0006\u0010\u0003\u001a\u00020\u0005H\u0007\u001a\u0015\u0010\u0000\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0087\u0004\u001a\u001c\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0002\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\bH\u0007\u001a\u0015\u0010\u0000\u001a\u00020\b*\u00020\b2\u0006\u0010\u0006\u001a\u00020\tH\u0087\u0004\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004\u001a\u0015\u0010\n\u001a\u00020\u0001*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0001H\u0086\u0004\u001a\u0015\u0010\n\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\u000b\u001a\u00020\u0005H\u0086\u0004\u001a\u001a\u0010\f\u001a\u00020\u0005*\u00020\u00052\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\r\u001a\u00020\u00052\u0006\u0010\u000e\u001a\u00020\b\u001a\u0012\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\u000f\u001a\u00020\b\u001a\u001a\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005\u001a\u001a\u0010\f\u001a\u00020\b*\u00020\b2\u0006\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b\u001a\f\u0010\u0010\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\f\u0010\u0010\u001a\u00020\u0004*\u00020\u0004H\u0007\u001a\f\u0010\u0010\u001a\u00020\u0005*\u00020\u0005H\u0007\u001a\f\u0010\u0010\u001a\u00020\b*\u00020\bH\u0007¨\u0006\u0011" }, d2 = { "clamp", "", "min", "max", "", "", "range", "Lkotlin/ranges/IntRange;", "", "Lkotlin/ranges/LongRange;", "floorMod", "other", "roundToNextStep", "counter", "denominator", "stepSize", "wrapTo360", "pesdk-backend-core_release" })
public final class MathUtilsKt
{
    @CheckResult
    public static final int clamp(final int $this$clamp, @NotNull final IntRange range) {
        Intrinsics.checkNotNullParameter((Object)range, "range");
        return MathUtils.clamp($this$clamp, range.getFirst(), range.getLast());
    }
    
    @CheckResult
    public static final long clamp(final long $this$clamp, @NotNull final LongRange range) {
        Intrinsics.checkNotNullParameter((Object)range, "range");
        return MathUtils.clamp($this$clamp, range.getFirst(), range.getLast());
    }
    
    @CheckResult
    public static final int clamp(final int $this$clamp, final int min, final int max) {
        return MathUtils.clamp($this$clamp, min, max);
    }
    
    @CheckResult
    public static final long clamp(final long $this$clamp, final long min, final long max) {
        return MathUtils.clamp($this$clamp, min, max);
    }
    
    @CheckResult
    public static final float clamp(final float $this$clamp, final float min, final float max) {
        return MathUtils.clamp($this$clamp, min, max);
    }
    
    @CheckResult
    public static final double clamp(final double $this$clamp, final double min, final double max) {
        return MathUtils.clamp($this$clamp, min, max);
    }
    
    @CheckResult
    public static final int wrapTo360(final int $this$wrapTo360) {
        return MathUtils.wrapTo360($this$wrapTo360);
    }
    
    @CheckResult
    public static final long wrapTo360(final long $this$wrapTo360) {
        return MathUtils.wrapTo360($this$wrapTo360);
    }
    
    @CheckResult
    public static final float wrapTo360(final float $this$wrapTo360) {
        return MathUtils.wrapTo360($this$wrapTo360);
    }
    
    @CheckResult
    public static final double wrapTo360(final double $this$wrapTo360) {
        return MathUtils.wrapTo360($this$wrapTo360);
    }
    
    public static final double floorMod(final double $this$floorMod, final double other) {
        return ($this$floorMod % other + other) % other;
    }
    
    public static final int floorMod(final int $this$floorMod, final int other) {
        return ($this$floorMod % other + other) % other;
    }
    
    public static final double floorMod(final double $this$floorMod, final int other) {
        return ($this$floorMod % other + other) % other;
    }
    
    public static final double floorMod(final int $this$floorMod, final double other) {
        return ($this$floorMod % other + other) % other;
    }
    
    public static final long roundToNextStep(final long $this$roundToNextStep, final long stepSize) {
        final long it = $this$roundToNextStep % stepSize;
        final int n = 0;
        return (it < stepSize / 2) ? ($this$roundToNextStep - it) : ($this$roundToNextStep + (stepSize - it));
    }
    
    public static final int roundToNextStep(final int $this$roundToNextStep, final int counter, final int denominator) {
        return (int)(MathKt.roundToLong($this$roundToNextStep * denominator / (double)counter) * counter / denominator);
    }
    
    public static final long roundToNextStep(final long $this$roundToNextStep, final int counter, final int denominator) {
        return MathKt.roundToLong($this$roundToNextStep * denominator / (double)counter) * counter / denominator;
    }
    
    public static final long roundToNextStep(final long $this$roundToNextStep, final long counter, final long denominator) {
        return MathKt.roundToLong($this$roundToNextStep * denominator / (double)counter) * counter / denominator;
    }
    
    public static final long roundToNextStep(final long $this$roundToNextStep, final long counter, final int denominator) {
        return MathKt.roundToLong($this$roundToNextStep * denominator / (double)counter) * counter / denominator;
    }
    
    public static final long roundToNextStep(final long $this$roundToNextStep, final int counter, final long denominator) {
        return MathKt.roundToLong($this$roundToNextStep * denominator / (double)counter) * counter / denominator;
    }
}
