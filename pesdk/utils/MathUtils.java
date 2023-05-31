// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.JvmOverloads;
import kotlin.text.StringsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import androidx.annotation.CheckResult;
import kotlin.jvm.JvmStatic;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0010\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J \u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\t2\u0006\u0010\u0007\u001a\u00020\tH\u0007J \u0010\u0003\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0007J \u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\n2\u0006\u0010\u0006\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\nH\u0007J \u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\b2\u0006\u0010\u0006\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0007J0\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u0004H\u0007J0\u0010\u000b\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\t2\u0006\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\tH\u0007J&\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00012\b\u0010\u0013\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\u0014\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0007J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0005\u001a\u00020\tH\u0007J\u0010\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\nH\u0007J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\bH\u0007¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/utils/MathUtils;", "", "()V", "clamp", "", "value", "min", "max", "", "", "", "mapRange", "inMin", "inMax", "outMin", "outMax", "numbersAlmostEqual", "", "value1", "value2", "threshold", "wrapTo360", "pesdk-backend-core_release" })
public final class MathUtils
{
    @NotNull
    public static final MathUtils INSTANCE;
    
    private MathUtils() {
    }
    
    @JvmStatic
    @CheckResult
    public static final int clamp(final int value, final int min, final int max) {
        return (value < min) ? min : ((value > max) ? max : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final long clamp(final long value, final long min, final long max) {
        return (value < min) ? min : ((value > max) ? max : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final float clamp(final float value, final float min, final float max) {
        return (value < min) ? min : ((value > max) ? max : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final float clamp(final float value, final int min, final int max) {
        return (value < min) ? ((float)min) : ((value > max) ? ((float)max) : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final double clamp(final double value, final double min, final double max) {
        return (value < min) ? min : ((value > max) ? max : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final double clamp(final double value, final long min, final long max) {
        return (value < min) ? ((double)min) : ((value > max) ? ((double)max) : value);
    }
    
    @JvmStatic
    @CheckResult
    public static final float mapRange(final float value, final float inMin, final float inMax, final float outMin, final float outMax) {
        return (inMin == inMax) ? ((outMin + outMax) / 2.0f) : ((value - inMin) * (outMax - outMin) / (inMax - inMin) + outMin);
    }
    
    @JvmStatic
    @CheckResult
    public static final double mapRange(final double value, final double inMin, final double inMax, final double outMin, final double outMax) {
        return (inMin == inMax) ? ((outMin + outMax) / 2.0) : ((value - inMin) * (outMax - outMin) / (inMax - inMin) + outMin);
    }
    
    @JvmStatic
    @CheckResult
    public static final int wrapTo360(final int value) {
        return (value < 0) ? ((360 + value) % 360) : (value % 360);
    }
    
    @JvmStatic
    @CheckResult
    public static final long wrapTo360(final long value) {
        return (value < 0L) ? ((360L + value) % 360L) : (value % 360L);
    }
    
    @JvmStatic
    @CheckResult
    public static final float wrapTo360(final float value) {
        return (value < 0.0f) ? ((360.0f + value) % 360.0f) : (value % 360.0f);
    }
    
    @JvmStatic
    @CheckResult
    public static final double wrapTo360(final double value) {
        return (value < 0.0) ? ((360.0 + value) % 360.0) : (value % 360.0);
    }
    
    @JvmStatic
    @JvmOverloads
    @CheckResult
    public static final boolean numbersAlmostEqual(@Nullable final Object value1, @Nullable final Object value2, final double threshold) {
        boolean b;
        if (Intrinsics.areEqual(value1, value2)) {
            b = true;
        }
        else {
            final Double anyNumber = (value1 instanceof Number) ? Double.valueOf(((Number)value1).doubleValue()) : StringsKt.toDoubleOrNull(String.valueOf(value1));
            final Double otherNumber = (value2 instanceof Number) ? Double.valueOf(((Number)value2).doubleValue()) : StringsKt.toDoubleOrNull(String.valueOf(value2));
            b = (anyNumber != null && otherNumber != null && Math.abs(anyNumber - otherNumber) <= threshold);
        }
        return b;
    }
    
    public static /* synthetic */ boolean numbersAlmostEqual$default(final Object value1, final Object value2, double threshold, final int n, final Object o) {
        if ((n & 0x4) != 0x0) {
            threshold = 1.0E-4;
        }
        return numbersAlmostEqual(value1, value2, threshold);
    }
    
    @JvmStatic
    @JvmOverloads
    @CheckResult
    public static final boolean numbersAlmostEqual(@Nullable final Object value1, @Nullable final Object value2) {
        return numbersAlmostEqual$default(value1, value2, 0.0, 4, null);
    }
    
    static {
        INSTANCE = new MathUtils();
    }
}
