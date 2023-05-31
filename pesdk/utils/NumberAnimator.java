// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.math.MathKt;
import kotlin.jvm.internal.Lambda;
import kotlin.reflect.KClass;
import android.animation.ValueAnimator$AnimatorUpdateListener;
import kotlin.jvm.internal.Reflection;
import android.animation.ObjectAnimator;
import java.util.Arrays;
import android.animation.TypeEvaluator;
import kotlin.jvm.internal.Intrinsics;
import android.animation.ValueAnimator;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0011\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002JV\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00062#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\b2\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e\"\u00020\u0006H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000fJV\u0010\u0003\u001a\u00020\u0004\"\n\b\u0000\u0010\u0005\u0018\u0001*\u00020\u00062\u0012\u0010\r\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u000e\"\u00020\u00062#\b\u0004\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u0011H\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\f0\bH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/utils/NumberAnimator;", "", "()V", "of", "Landroid/animation/ValueAnimator;", "T", "", "onChange", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "", "values", "", "(Lkotlin/jvm/functions/Function1;[Ljava/lang/Number;)Landroid/animation/ValueAnimator;", "([Ljava/lang/Number;Lkotlin/jvm/functions/Function1;)Landroid/animation/ValueAnimator;", "pesdk-backend-core_release" })
public final class NumberAnimator
{
    @NotNull
    public static final NumberAnimator INSTANCE;
    
    private NumberAnimator() {
    }
    
    static {
        INSTANCE = new NumberAnimator();
    }
}
