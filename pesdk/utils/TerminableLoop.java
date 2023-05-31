// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function0;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmField;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0016\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\b\u001a\u00020\tH\u0016J*\u0010\n\u001a\u00020\t2\u000e\b\u0004\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00040\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0086\b\u00f8\u0001\u0000J\u001a\u0010\n\u001a\u00020\t2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\t0\fH\u0086\b\u00f8\u0001\u0000J\b\u0010\u000e\u001a\u00020\tH\u0016J\b\u0010\u000f\u001a\u00020\tH\u0016R\u0012\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00068\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0010" }, d2 = { "Lly/img/android/pesdk/utils/TerminableLoop;", "", "()V", "isAlive", "", "pauseLock", "Ljava/lang/Object;", "sleepEnacted", "awakeFromSleep", "", "loopWhileAlive", "and", "Lkotlin/Function0;", "block", "notifySleep", "stop", "pesdk-backend-core_release" })
public class TerminableLoop
{
    @JvmField
    public volatile boolean isAlive;
    @JvmField
    public volatile boolean sleepEnacted;
    @JvmField
    @NotNull
    public final Object pauseLock;
    
    public TerminableLoop() {
        this.isAlive = true;
        this.pauseLock = new Object();
    }
    
    public void notifySleep() {
        if (this.isAlive) {
            synchronized (this.pauseLock) {
                final int n = 0;
                this.sleepEnacted = true;
                final Unit instance = Unit.INSTANCE;
            }
        }
    }
    
    public void awakeFromSleep() {
        synchronized (this.pauseLock) {
            final int n = 0;
            this.sleepEnacted = false;
            this.pauseLock.notifyAll();
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    public final void loopWhileAlive(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$loopWhileAlive = 0;
        while (this.isAlive) {
            block.invoke();
            final Object pauseLock = this.pauseLock;
            // monitorenter(pauseLock)
            try {
                final int n = 0;
                if (this.isAlive && this.sleepEnacted) {
                    try {
                        this.pauseLock.wait(1000L);
                    }
                    catch (InterruptedException ex) {}
                }
                final Unit instance = Unit.INSTANCE;
                continue;
            }
            finally {
                InlineMarker.finallyStart(1);
                // monitorexit(pauseLock)
                InlineMarker.finallyEnd(1);
            }
            break;
        }
    }
    
    public final void loopWhileAlive(@NotNull final Function0<Boolean> and, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)and, "and");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$loopWhileAlive = 0;
        while (this.isAlive && (boolean)and.invoke()) {
            block.invoke();
        }
    }
    
    public void stop() {
        this.isAlive = false;
    }
}
