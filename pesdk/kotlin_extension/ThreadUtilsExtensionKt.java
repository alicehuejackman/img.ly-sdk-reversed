// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import ly.img.android.pesdk.utils.ThreadUtils;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a$\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u001a$\u0010\u0006\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u000e\b\u0004\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0007" }, d2 = { "replacedTask", "", "group", "", "task", "Lkotlin/Function0;", "sequencedTask", "pesdk-backend-core_release" })
public final class ThreadUtilsExtensionKt
{
    public static final void sequencedTask(@NotNull final String group, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter((Object)group, "group");
        Intrinsics.checkNotNullParameter((Object)task, "task");
        final int $i$f$sequencedTask = 0;
        ThreadUtils.Companion.getWorker().addTask((ThreadUtils.WorkerThreadRunnable)new ThreadUtilsExtensionKt$sequencedTask.ThreadUtilsExtensionKt$sequencedTask$1(group, (Function0)task));
    }
    
    public static final void replacedTask(@NotNull final String group, @NotNull final Function0<Unit> task) {
        Intrinsics.checkNotNullParameter((Object)group, "group");
        Intrinsics.checkNotNullParameter((Object)task, "task");
        final int $i$f$replacedTask = 0;
        ThreadUtils.Companion.getWorker().addTask((ThreadUtils.WorkerThreadRunnable)new ThreadUtilsExtensionKt$replacedTask.ThreadUtilsExtensionKt$replacedTask$1(group, (Function0)task));
    }
}
