// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import androidx.annotation.WorkerThread;
import kotlin.jvm.JvmOverloads;
import androidx.annotation.IntRange;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0002\u001a\u00020\u0003J\b\u0010\f\u001a\u00020\u000bH\u0007J\b\u0010\r\u001a\u00020\u000bH\u0007J\u0016\u0010\r\u001a\u00020\u000b2\f\b\u0001\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0007J\u0016\u0010\u0011\u001a\u00020\u000b2\f\b\u0003\u0010\u000e\u001a\u00060\u000fj\u0002`\u0010H\u0007R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0004¨\u0006\u0012" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/AtomicSleep;", "", "value", "", "(Z)V", "objectRef", "Ljava/lang/Object;", "getValue", "()Z", "setValue", "set", "", "waitUntilFalse", "waitUntilTrue", "timeOutMilliseconds", "", "Lly/img/android/pesdk/kotlin_extension/Milliseconds;", "waitUntilTrueAndSetFalse", "pesdk-backend-core_release" })
public final class AtomicSleep
{
    private boolean value;
    @NotNull
    private final Object objectRef;
    
    public AtomicSleep(final boolean value) {
        this.value = value;
        this.objectRef = this;
    }
    
    public final boolean getValue() {
        return this.value;
    }
    
    public final void setValue(final boolean <set-?>) {
        this.value = <set-?>;
    }
    
    public final void set(final boolean value) {
        synchronized (this.objectRef) {
            final int n = 0;
            if (this.value != value) {
                this.value = value;
                this.objectRef.notifyAll();
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    @JvmOverloads
    @WorkerThread
    public final void waitUntilTrueAndSetFalse(@IntRange(from = 0L) final long timeOutMilliseconds) {
        synchronized (this.objectRef) {
            final int n = 0;
            if (!this.value) {
                if (timeOutMilliseconds > 0L) {
                    this.objectRef.wait(timeOutMilliseconds);
                }
                else {
                    this.objectRef.wait();
                }
                this.value = false;
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    public static /* synthetic */ void waitUntilTrueAndSetFalse$default(final AtomicSleep atomicSleep, long timeOutMilliseconds, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            timeOutMilliseconds = 0L;
        }
        atomicSleep.waitUntilTrueAndSetFalse(timeOutMilliseconds);
    }
    
    @WorkerThread
    public final void waitUntilTrue() {
        synchronized (this.objectRef) {
            final int n = 0;
            if (!this.value) {
                this.objectRef.wait();
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    @WorkerThread
    public final void waitUntilTrue(@IntRange(from = 1L) final long timeOutMilliseconds) {
        synchronized (this.objectRef) {
            final int n = 0;
            if (!this.value) {
                this.objectRef.wait(timeOutMilliseconds);
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    @WorkerThread
    public final void waitUntilFalse() {
        synchronized (this.objectRef) {
            final int n = 0;
            if (this.value) {
                this.objectRef.wait();
            }
            final Unit instance = Unit.INSTANCE;
        }
    }
    
    @JvmOverloads
    @WorkerThread
    public final void waitUntilTrueAndSetFalse() {
        waitUntilTrueAndSetFalse$default(this, 0L, 1, null);
    }
}
