// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;
import android.animation.TypeEvaluator;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00022\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00022\b\u0010\b\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\t¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/LongEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "fraction", "", "startValue", "endValue", "(FLjava/lang/Long;Ljava/lang/Long;)Ljava/lang/Long;", "pesdk-backend-core_release" })
public final class LongEvaluator implements TypeEvaluator<Long>
{
    @NotNull
    public Long evaluate(final float fraction, @Nullable final Long startValue, @Nullable final Long endValue) {
        if (startValue == null) {
            return (endValue != null) ? endValue : 0L;
        }
        startValue;
        if (endValue != null) {
            endValue;
            return (long)(startValue + (endValue - startValue) * (double)fraction);
        }
        return startValue;
    }
}
