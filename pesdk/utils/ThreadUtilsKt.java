// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import org.jetbrains.annotations.Nullable;
import androidx.annotation.MainThread;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000,\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\u00020\u00012\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b\u00f8\u0001\u0000\u001a0\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b\u00f8\u0001\u0000\u001a0\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b\u00f8\u0001\u0000\u001a\u001c\u0010\r\u001a\u00020\u00042\u000e\b\u0004\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000e" }, d2 = { "MainThreadRunnable", "Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "closure", "Lkotlin/Function0;", "", "ReplaceRunnable", "Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;", "id", "", "reference", "", "SequenceRunnable", "Lly/img/android/pesdk/utils/ThreadUtils$SequencedThreadRunnable;", "runOnMainThread", "pesdk-backend-core_release" })
public final class ThreadUtilsKt
{
    public static final void runOnMainThread(@NotNull final Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter((Object)closure, "closure");
        final int $i$f$runOnMainThread = 0;
        final int $i$f$MainThreadRunnable = 0;
        ((ThreadUtils.MainThreadRunnable)new ThreadUtils.MainThreadRunnable(closure) {
            @MainThread
            @Override
            public void run() {
                final int n = 0;
                this.$closure$inlined.invoke();
            }
        }).invoke();
    }
    
    @NotNull
    public static final ThreadUtils.MainThreadRunnable MainThreadRunnable(@NotNull final Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter((Object)closure, "closure");
        final int $i$f$MainThreadRunnable = 0;
        return (ThreadUtils.MainThreadRunnable)new ThreadUtilsKt$MainThreadRunnable.ThreadUtilsKt$MainThreadRunnable$1((Function0)closure);
    }
    
    @NotNull
    public static final ThreadUtils.SequencedThreadRunnable SequenceRunnable(@NotNull final String id, @Nullable final Object reference, @NotNull final Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter((Object)id, "id");
        Intrinsics.checkNotNullParameter((Object)closure, "closure");
        final int $i$f$SequenceRunnable = 0;
        return (ThreadUtils.SequencedThreadRunnable)new ThreadUtilsKt$SequenceRunnable.ThreadUtilsKt$SequenceRunnable$1((Function0)closure, id + System.identityHashCode(reference));
    }
    
    @NotNull
    public static final ThreadUtils.ReplaceThreadRunnable ReplaceRunnable(@NotNull final String id, @Nullable final Object reference, @NotNull final Function0<Unit> closure) {
        Intrinsics.checkNotNullParameter((Object)id, "id");
        Intrinsics.checkNotNullParameter((Object)closure, "closure");
        final int $i$f$ReplaceRunnable = 0;
        return (ThreadUtils.ReplaceThreadRunnable)new ThreadUtilsKt$ReplaceRunnable.ThreadUtilsKt$ReplaceRunnable$1((Function0)closure, id + System.identityHashCode(reference));
    }
}
