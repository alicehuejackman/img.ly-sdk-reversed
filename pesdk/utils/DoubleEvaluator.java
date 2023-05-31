// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import kotlin.Metadata;
import android.animation.TypeEvaluator;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0004\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J)\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u00022\b\u0010\t\u001a\u0004\u0018\u00010\u0002H\u0016¢\u0006\u0002\u0010\n¨\u0006\u000b" }, d2 = { "Lly/img/android/pesdk/utils/DoubleEvaluator;", "Landroid/animation/TypeEvaluator;", "", "()V", "evaluate", "", "fraction", "", "startValue", "endValue", "(FLjava/lang/Number;Ljava/lang/Number;)Ljava/lang/Double;", "pesdk-backend-core_release" })
public final class DoubleEvaluator implements TypeEvaluator<Number>
{
    @NotNull
    public Double evaluate(final float fraction, @Nullable final Number startValue, @Nullable final Number endValue) {
        if (startValue == null) {
            return (endValue != null) ? endValue.doubleValue() : 0.0;
        }
        if (endValue == null) {
            return startValue.doubleValue();
        }
        return startValue.doubleValue() + (endValue.doubleValue() - startValue.doubleValue()) * fraction;
    }
}
