// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\b\u0016\u0018\u00002\u00020\u0001B4\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012%\b\u0002\u0010\u0004\u001a\u001f\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t\u0018\u00010\u0005¢\u0006\u0002\u0010\nJ\b\u0010\u0013\u001a\u00020\tH\u0016J\b\u0010\u0014\u001a\u00020\u000eH\u0016J\b\u0010\u0015\u001a\u00020\u000eH\u0016J\b\u0010\u0016\u001a\u00020\tH\u0016J\u0006\u0010\u0017\u001a\u00020\tJ\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\u0006H\u0016J\u0012\u0010\u0018\u001a\u00020\t2\b\u0010\u0019\u001a\u0004\u0018\u00010\fH\u0016J\b\u0010\u001a\u001a\u00020\tH\u0016J\u0016\u0010\u001a\u001a\u00020\t2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\t0\u0010H\u0016J\u0012\u0010\u001c\u001a\u00020\t2\b\b\u0002\u0010\u001d\u001a\u00020\u000eH\u0016J\b\u0010\u001e\u001a\u00020\u000eH\u0016R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u00020\u00068\u0004X\u0085\u0004¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00110\u0006¢\u0006\f\b\u0007\u0012\b\b\u0002\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f" }, d2 = { "Lly/img/android/pesdk/utils/TerminableThread;", "Ljava/lang/Thread;", "name", "", "work", "Lkotlin/Function1;", "Lly/img/android/pesdk/utils/TerminableLoop;", "Lkotlin/ParameterName;", "loop", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function1;)V", "exceptionHandler", "Ljava/lang/Thread$UncaughtExceptionHandler;", "isDoingWork", "", "onTerminated", "Lkotlin/Function0;", "onUncaughtException", "terminableLoop", "awakeIfSleeping", "hasShutdownSignal", "isRunning", "requestSleep", "run", "setUncaughtExceptionHandler", "uncaughtExceptionHandler", "terminateAsync", "block", "terminateSync", "hardShutdown", "willStayRunning", "pesdk-backend-core_release" })
public class TerminableThread extends Thread
{
    @NotNull
    private final Function1<TerminableLoop, Unit> work;
    @JvmField
    @Nullable
    public UncaughtExceptionHandler exceptionHandler;
    @NotNull
    private final UncaughtExceptionHandler onUncaughtException;
    private volatile boolean isDoingWork;
    @JvmField
    @NotNull
    protected final TerminableLoop terminableLoop;
    @NotNull
    private Function0<Unit> onTerminated;
    
    public TerminableThread(@NotNull final String name, @Nullable final Function1<? super TerminableLoop, Unit> work) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        super(name);
        Function1 work2 = work;
        if (work == null) {
            work2 = (Function1)new TerminableThread$work.TerminableThread$work$1(this);
        }
        this.work = (Function1<TerminableLoop, Unit>)work2;
        this.onUncaughtException = TerminableThread::onUncaughtException$lambda-0;
        this.terminableLoop = new TerminableLoop();
        this.onTerminated = (Function0<Unit>)TerminableThread$onTerminated.TerminableThread$onTerminated$1.INSTANCE;
    }
    
    public boolean isRunning() {
        return this.getState() != State.TERMINATED && this.isDoingWork;
    }
    
    public boolean willStayRunning() {
        return this.getState() != State.TERMINATED && this.terminableLoop.isAlive;
    }
    
    public boolean hasShutdownSignal() {
        return !this.terminableLoop.isAlive;
    }
    
    public void requestSleep() {
        this.terminableLoop.notifySleep();
    }
    
    public void awakeIfSleeping() {
        this.terminableLoop.awakeFromSleep();
    }
    
    @Override
    public void setUncaughtExceptionHandler(@Nullable final UncaughtExceptionHandler uncaughtExceptionHandler) {
        if (Intrinsics.areEqual((Object)uncaughtExceptionHandler, (Object)this.onUncaughtException)) {
            super.setUncaughtExceptionHandler(uncaughtExceptionHandler);
        }
        else {
            this.exceptionHandler = uncaughtExceptionHandler;
        }
    }
    
    public void terminateAsync() {
        this.terminableLoop.isAlive = false;
        this.awakeIfSleeping();
    }
    
    public void terminateAsync(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        this.onTerminated = block;
        this.terminableLoop.isAlive = false;
        this.awakeIfSleeping();
    }
    
    public void terminateSync(final boolean hardShutdown) {
        if (Intrinsics.areEqual((Object)Thread.currentThread(), (Object)this)) {
            this.terminateAsync();
        }
        else {
            if (hardShutdown) {
                this.terminableLoop.isAlive = false;
            }
            this.awakeIfSleeping();
            while (this.isRunning()) {
                Thread.sleep(1L);
                this.awakeIfSleeping();
            }
        }
    }
    
    public void run(@NotNull final TerminableLoop loop) {
        Intrinsics.checkNotNullParameter((Object)loop, "loop");
    }
    
    @Override
    public final void run() {
        super.run();
        this.isDoingWork = true;
        Thread.currentThread().setUncaughtExceptionHandler(this.onUncaughtException);
        this.work.invoke((Object)this.terminableLoop);
        this.onTerminated.invoke();
        this.isDoingWork = false;
    }
    
    private static final void onUncaughtException$lambda-0(final TerminableThread this$0, final Thread thread, final Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        this$0.isDoingWork = false;
        this$0.terminableLoop.isAlive = false;
        final UncaughtExceptionHandler exceptionHandler = this$0.exceptionHandler;
        if (exceptionHandler != null) {
            exceptionHandler.uncaughtException(thread, throwable);
        }
    }
}
