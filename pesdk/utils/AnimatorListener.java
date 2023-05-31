// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.animation.Animator;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;
import android.animation.Animator$AnimatorListener;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\u00020\u0001BU\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\tJ\u0010\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u0011\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u000eH\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Lly/img/android/pesdk/utils/AnimatorListener;", "Landroid/animation/Animator$AnimatorListener;", "atStart", "Lkotlin/Function0;", "", "ifDoneOrCanceled", "ifCanceled", "whenRepeat", "ifDone", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;)V", "canceled", "", "onAnimationCancel", "animation", "Landroid/animation/Animator;", "onAnimationEnd", "onAnimationRepeat", "onAnimationStart", "pesdk-backend-core_release" })
public final class AnimatorListener implements Animator$AnimatorListener
{
    @NotNull
    private final Function0<Unit> atStart;
    @NotNull
    private final Function0<Unit> ifDoneOrCanceled;
    @NotNull
    private final Function0<Unit> ifCanceled;
    @NotNull
    private final Function0<Unit> whenRepeat;
    @NotNull
    private final Function0<Unit> ifDone;
    private boolean canceled;
    
    public AnimatorListener(@NotNull final Function0<Unit> atStart, @NotNull final Function0<Unit> ifDoneOrCanceled, @NotNull final Function0<Unit> ifCanceled, @NotNull final Function0<Unit> whenRepeat, @NotNull final Function0<Unit> ifDone) {
        Intrinsics.checkNotNullParameter((Object)atStart, "atStart");
        Intrinsics.checkNotNullParameter((Object)ifDoneOrCanceled, "ifDoneOrCanceled");
        Intrinsics.checkNotNullParameter((Object)ifCanceled, "ifCanceled");
        Intrinsics.checkNotNullParameter((Object)whenRepeat, "whenRepeat");
        Intrinsics.checkNotNullParameter((Object)ifDone, "ifDone");
        this.atStart = atStart;
        this.ifDoneOrCanceled = ifDoneOrCanceled;
        this.ifCanceled = ifCanceled;
        this.whenRepeat = whenRepeat;
        this.ifDone = ifDone;
    }
    
    public void onAnimationRepeat(@NotNull final Animator animation) {
        Intrinsics.checkNotNullParameter((Object)animation, "animation");
        this.whenRepeat.invoke();
    }
    
    public void onAnimationCancel(@NotNull final Animator animation) {
        Intrinsics.checkNotNullParameter((Object)animation, "animation");
        this.canceled = true;
        this.ifCanceled.invoke();
    }
    
    public void onAnimationStart(@NotNull final Animator animation) {
        Intrinsics.checkNotNullParameter((Object)animation, "animation");
        this.canceled = false;
        this.atStart.invoke();
    }
    
    public void onAnimationEnd(@NotNull final Animator animation) {
        Intrinsics.checkNotNullParameter((Object)animation, "animation");
        if (!this.canceled) {
            this.ifDone.invoke();
        }
        this.ifDoneOrCanceled.invoke();
    }
    
    public AnimatorListener() {
        this(null, null, null, null, null, 31, null);
    }
}
