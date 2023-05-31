// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u001e\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\f\u00f8\u0001\u0000\u001a\u001e\u0010\u0005\u001a\u00020\u0001*\u00020\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\f\u00f8\u0001\u0000\u001a\r\u0010\u0006\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u001a\r\u0010\u0007\u001a\u00020\u0001*\u00020\u0002H\u0086\b\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\b" }, d2 = { "setFalseIfTrueAndDo", "", "Ljava/util/concurrent/atomic/AtomicBoolean;", "block", "Lkotlin/Function0;", "setTrueIfFalseAndDo", "waitUntilFalse", "waitUntilTrue", "pesdk-backend-core_release" })
public final class AtomicBooleanUtilsKt
{
    public static final void waitUntilTrue(@NotNull final AtomicBoolean $this$waitUntilTrue) {
        Intrinsics.checkNotNullParameter((Object)$this$waitUntilTrue, "<this>");
        final int $i$f$waitUntilTrue = 0;
        while (!$this$waitUntilTrue.get()) {
            Thread.sleep(1L);
        }
    }
    
    public static final void waitUntilFalse(@NotNull final AtomicBoolean $this$waitUntilFalse) {
        Intrinsics.checkNotNullParameter((Object)$this$waitUntilFalse, "<this>");
        final int $i$f$waitUntilFalse = 0;
        while ($this$waitUntilFalse.get()) {
            Thread.sleep(1L);
        }
    }
    
    public static final void setFalseIfTrueAndDo(@NotNull final AtomicBoolean $this$setFalseIfTrueAndDo, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$setFalseIfTrueAndDo, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$setFalseIfTrueAndDo = 0;
        if ($this$setFalseIfTrueAndDo.compareAndSet(true, false)) {
            block.invoke();
        }
    }
    
    public static final void setTrueIfFalseAndDo(@NotNull final AtomicBoolean $this$setTrueIfFalseAndDo, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$setTrueIfFalseAndDo, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$setTrueIfFalseAndDo = 0;
        if ($this$setTrueIfFalseAndDo.compareAndSet(false, true)) {
            block.invoke();
        }
    }
}
