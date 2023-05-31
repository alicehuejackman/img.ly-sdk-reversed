// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import ly.img.android.pesdk.utils.ThreadUtils;
import android.util.Log;
import androidx.annotation.WorkerThread;
import kotlin.Unit;
import android.os.Process;
import ly.img.android.pesdk.utils.TerminableLoop;
import java.util.Iterator;
import android.opengl.EGL14;
import kotlin.jvm.functions.Function0;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.jvm.internal.Intrinsics;
import javax.microedition.khronos.egl.EGLConfig;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.functions.Function1;
import android.os.SystemClock;
import ly.img.android.opengl.GlContextStopCallback;
import ly.img.android.pesdk.utils.WeakSet;
import java.util.concurrent.locks.ReentrantLock;
import ly.img.android.pesdk.utils.SpeedDeque;
import ly.img.android.opengl.ConfigChooser;
import ly.img.android.opengl.canvas.GlObject;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import ly.img.android.opengl.GlThreadRunner;
import ly.img.android.pesdk.utils.TerminableThread;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 M2\u00020\u00012\u00020\u0002:\u0002MNB\u001b\u0012\n\b\u0002\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\b\u0010.\u001a\u00020/H\u0016J\b\u00100\u001a\u00020/H\u0004J\b\u00101\u001a\u00020/H\u0016J\b\u00102\u001a\u00020/H\u0002J\u0006\u00103\u001a\u00020/J\b\u00104\u001a\u00020/H\u0002J\b\u00105\u001a\u00020/H\u0002J\u0010\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u000eH\u0016J\u0018\u00106\u001a\u00020/2\u0006\u00107\u001a\u00020\u000e2\u0006\u00108\u001a\u00020\u0006H\u0016J\u000e\u00109\u001a\u00020/2\u0006\u0010:\u001a\u00020\u001aJ\u0010\u0010;\u001a\u00020/2\u0006\u00107\u001a\u00020\u000eH\u0016J\u0010\u0010<\u001a\u00020/2\u0006\u0010=\u001a\u00020\u001fH\u0016J\u0016\u0010>\u001a\u00020/2\u000e\b\u0002\u0010?\u001a\b\u0012\u0004\u0012\u00020\u00000@J\u0010\u0010A\u001a\u00020/2\u0006\u0010B\u001a\u00020CH\u0017J\u0010\u0010D\u001a\u00020/2\u0006\u0010E\u001a\u00020\u001aH\u0016J\u0006\u0010F\u001a\u00020\u0004J\u0010\u0010G\u001a\u00020/2\u0006\u0010H\u001a\u00020\u0006H\u0002J!\u0010I\u001a\u0004\u0018\u0001HJ\"\u0004\b\u0000\u0010J2\f\u0010?\u001a\b\u0012\u0004\u0012\u0002HJ0@¢\u0006\u0002\u0010KJ\u0010\u0010L\u001a\u00020/2\u0006\u0010=\u001a\u00020\u001fH\u0016R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000f\u001a\u00020\u00108F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0014\u0010\u0013\u001a\u00020\u00148VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u001f0\u001eX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0014\u0010#\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b$\u0010\"R\u0014\u0010%\u001a\u00020&X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(R\u000e\u0010)\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010*\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b+\u0010\"R\u0014\u0010,\u001a\b\u0012\u0004\u0012\u00020\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006O" }, d2 = { "Lly/img/android/opengl/egl/GLThread;", "Lly/img/android/pesdk/utils/TerminableThread;", "Lly/img/android/opengl/GlThreadRunner;", "resumeInfo", "Lly/img/android/opengl/egl/GLThread$ResumeInfo;", "lowPriority", "", "(Lly/img/android/opengl/egl/GLThread$ResumeInfo;Z)V", "configChooser", "Lly/img/android/opengl/ConfigChooser;", "contextFactory", "Lly/img/android/opengl/egl/ContextFactory;", "destroyQueue", "Lly/img/android/pesdk/utils/SpeedDeque;", "Lly/img/android/opengl/canvas/GlObject;", "eglConfig", "Ljavax/microedition/khronos/egl/EGLConfig;", "getEglConfig", "()Ljavax/microedition/khronos/egl/EGLConfig;", "eglContext", "Ljavax/microedition/khronos/egl/EGLContext;", "getEglContext", "()Ljavax/microedition/khronos/egl/EGLContext;", "eglContextHelper", "Lly/img/android/opengl/egl/EGLContextHelper;", "eventQueue", "Ljava/lang/Runnable;", "glContextStopCallbackLock", "Ljava/util/concurrent/locks/ReentrantLock;", "glContextStopCallbackSet", "Lly/img/android/pesdk/utils/WeakSet;", "Lly/img/android/opengl/GlContextStopCallback;", "glIsAlive", "getGlIsAlive", "()Z", "glIsDead", "getGlIsDead", "glObjectsList", "Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "getGlObjectsList", "()Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "hasEglContext", "lostEglContext", "getLowPriority", "reboundQueue", "sleepLock", "awakeIfSleeping", "", "finalize", "freeMemory", "guardedLoop", "notifyLostContext", "processDestroyQueue", "processReboundQueue", "queueDestroy", "obj", "sync", "queueEvent", "r", "queueRebound", "registerGlContextStopCallback", "callback", "retire", "block", "Lkotlin/Function0;", "run", "loop", "Lly/img/android/pesdk/utils/TerminableLoop;", "runWithGlContext", "runnable", "shutdownForResume", "stopEglContext", "releaseFinally", "syncWithGlContext", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "unregisterGlContextStopCallback", "Companion", "ResumeInfo", "pesdk-backend-core_release" })
public final class GLThread extends TerminableThread implements GlThreadRunner
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private final ResumeInfo resumeInfo;
    private final boolean lowPriority;
    @NotNull
    private final GlObject.GlObjectCallSet glObjectsList;
    @NotNull
    private final ConfigChooser configChooser;
    @NotNull
    private final EGLContextHelper eglContextHelper;
    @NotNull
    private final ContextFactory contextFactory;
    @NotNull
    private final SpeedDeque<Runnable> eventQueue;
    @NotNull
    private final SpeedDeque<GlObject> destroyQueue;
    @NotNull
    private final SpeedDeque<GlObject> reboundQueue;
    private boolean hasEglContext;
    private boolean lostEglContext;
    @NotNull
    private ReentrantLock sleepLock;
    @NotNull
    private final ReentrantLock glContextStopCallbackLock;
    @NotNull
    private final WeakSet<GlContextStopCallback> glContextStopCallbackSet;
    @NotNull
    private static ReentrantLock singeGlCommandChainLock;
    
    public GLThread(@Nullable final ResumeInfo resumeInfo, final boolean lowPriority) {
        super("GLThread-" + SystemClock.elapsedRealtime(), null, 2, null);
        this.resumeInfo = resumeInfo;
        this.lowPriority = lowPriority;
        this.glObjectsList = new GlObject.GlObjectCallSet();
        this.configChooser = new ConfigChooser(false, 2);
        this.contextFactory = new ContextFactory(2);
        this.eventQueue = new SpeedDeque<Runnable>();
        this.destroyQueue = new SpeedDeque<GlObject>();
        this.reboundQueue = new SpeedDeque<GlObject>();
        this.sleepLock = new ReentrantLock(true);
        this.glContextStopCallbackLock = new ReentrantLock();
        this.glContextStopCallbackSet = new WeakSet<GlContextStopCallback>();
        this.eglContextHelper = new EGLContextHelper(this.configChooser, this.contextFactory);
        final ResumeInfo resumeInfo2 = this.resumeInfo;
        if (resumeInfo2 != null) {
            resumeInfo2.resumeOn(this);
        }
    }
    
    public final boolean getLowPriority() {
        return this.lowPriority;
    }
    
    @NotNull
    @Override
    public GlObject.GlObjectCallSet getGlObjectsList() {
        return this.glObjectsList;
    }
    
    @NotNull
    public final EGLConfig getEglConfig() {
        final EGLConfig eglConfig = this.eglContextHelper.getEglConfig();
        Intrinsics.checkNotNullExpressionValue((Object)eglConfig, "eglContextHelper.eglConfig");
        return eglConfig;
    }
    
    @NotNull
    @Override
    public EGLContext getEglContext() {
        final EGLContext eglContext = this.eglContextHelper.getEglContext();
        Intrinsics.checkNotNullExpressionValue((Object)eglContext, "eglContextHelper.eglContext");
        return eglContext;
    }
    
    @Override
    public boolean getGlIsAlive() {
        return !this.getGlIsDead();
    }
    
    @Override
    public boolean getGlIsDead() {
        return this.hasShutdownSignal();
    }
    
    @Override
    protected final void finalize() throws Throwable {
        this.terminateAsync();
    }
    
    @NotNull
    public final ResumeInfo shutdownForResume() {
        try {
            ResumeInfo resumeInfo2;
            if ((resumeInfo2 = this.resumeInfo) == null) {
                resumeInfo2 = new ResumeInfo();
            }
            final ResumeInfo resumeInfo = resumeInfo2;
            this.syncWithGlContext((kotlin.jvm.functions.Function0<?>)new GLThread$shutdownForResume.GLThread$shutdownForResume$1(this, resumeInfo));
            this.eventQueue.clear();
            this.destroyQueue.clear();
            this.reboundQueue.clear();
            return resumeInfo;
        }
        finally {
            this.terminateAsync();
        }
    }
    
    public final void retire(@NotNull final Function0<GLThread> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        try {
            this.stopEglContext(false);
        }
        catch (Exception ex) {}
        try {
            EGL14.eglReleaseThread();
        }
        catch (Exception ex2) {}
        final GLThread newGLThread = (GLThread)block.invoke();
        if (!Intrinsics.areEqual((Object)this, (Object)newGLThread)) {
            final Iterable $this$forEach$iv = this.getGlObjectsList();
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final GlObject it = (GlObject)element$iv;
                final int n = 0;
                newGLThread.getGlObjectsList().add(it);
            }
            this.getGlObjectsList().clear();
            final int $i$f$loopIfTrue = 0;
            Runnable runnable;
            do {
                final int n2 = 0;
                final Runnable runnable2 = access$getEventQueue$p(this).poll();
                if (runnable2 != null) {
                    final Runnable it2 = runnable2;
                    final int n3 = 0;
                    newGLThread.queueEvent(it2);
                    runnable = it2;
                }
                else {
                    runnable = null;
                }
            } while (runnable != null);
        }
    }
    
    @WorkerThread
    @Override
    public void run(@NotNull final TerminableLoop loop) {
        Intrinsics.checkNotNullParameter((Object)loop, "loop");
        Process.setThreadPriority(-10);
        this.hasEglContext = false;
        final TerminableLoop this_$iv = loop;
        final int $i$f$loopWhileAlive = 0;
        while (this_$iv.isAlive) {
            final int n = 0;
            this.guardedLoop();
            synchronized (this_$iv.pauseLock) {
                final int n2 = 0;
                if (this_$iv.isAlive && this_$iv.sleepEnacted) {
                    try {
                        this_$iv.pauseLock.wait(1000L);
                    }
                    catch (InterruptedException ex) {}
                }
                final Unit instance = Unit.INSTANCE;
                continue;
            }
            break;
        }
        this.stopEglContext(true);
        EGL14.eglReleaseThread();
    }
    
    private final void stopEglContext(final boolean releaseFinally) {
        if (this.hasEglContext) {
            final ReentrantLock reentrantLock = this.glContextStopCallbackLock;
            reentrantLock.lock();
            try {
                final int n = 0;
                if (this.glContextStopCallbackSet.readLock()) {
                    try {
                        int i = 0;
                        Unit instance;
                        do {
                            final GlContextStopCallback glContextStopCallback = this.glContextStopCallbackSet.get(i++);
                            if (glContextStopCallback != null) {
                                glContextStopCallback.onContextStopped(this.getEglContext());
                                instance = Unit.INSTANCE;
                            }
                            else {
                                instance = null;
                            }
                        } while (instance != null);
                    }
                    finally {
                        this.glContextStopCallbackSet.readUnlock();
                    }
                }
                if (releaseFinally) {
                    this.glContextStopCallbackSet.clear();
                }
                final Unit instance2 = Unit.INSTANCE;
            }
            finally {
                reentrantLock.unlock();
            }
            GlObject.Companion.destroyGlContext(this, releaseFinally);
            this.processDestroyQueue();
            this.eglContextHelper.finish();
            this.hasEglContext = false;
        }
    }
    
    public final void notifyLostContext() {
        this.lostEglContext = true;
        Log.e("GlThread", "Context lost notified");
    }
    
    private final void guardedLoop() throws InterruptedException {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/egl/GLThread.lostEglContext:Z
        //     4: ifeq            17
        //     7: aload_0         /* this */
        //     8: iconst_0       
        //     9: invokespecial   ly/img/android/opengl/egl/GLThread.stopEglContext:(Z)V
        //    12: aload_0         /* this */
        //    13: iconst_0       
        //    14: putfield        ly/img/android/opengl/egl/GLThread.lostEglContext:Z
        //    17: aload_0         /* this */
        //    18: getfield        ly/img/android/opengl/egl/GLThread.hasEglContext:Z
        //    21: ifne            53
        //    24: nop            
        //    25: aload_0         /* this */
        //    26: getfield        ly/img/android/opengl/egl/GLThread.eglContextHelper:Lly/img/android/opengl/egl/EGLContextHelper;
        //    29: invokevirtual   ly/img/android/opengl/egl/EGLContextHelper.init:()V
        //    32: getstatic       ly/img/android/opengl/canvas/GlObject.Companion:Lly/img/android/opengl/canvas/GlObject$Companion;
        //    35: aload_0         /* this */
        //    36: checkcast       Lly/img/android/opengl/GlThreadRunner;
        //    39: invokevirtual   ly/img/android/opengl/canvas/GlObject$Companion.createGlContext:(Lly/img/android/opengl/GlThreadRunner;)V
        //    42: goto            48
        //    45: astore_1        /* t */
        //    46: aload_1         /* t */
        //    47: athrow         
        //    48: aload_0         /* this */
        //    49: iconst_1       
        //    50: putfield        ly/img/android/opengl/egl/GLThread.hasEglContext:Z
        //    53: aload_0         /* this */
        //    54: invokespecial   ly/img/android/opengl/egl/GLThread.processDestroyQueue:()V
        //    57: aload_0         /* this */
        //    58: invokespecial   ly/img/android/opengl/egl/GLThread.processReboundQueue:()V
        //    61: aload_0         /* this */
        //    62: getfield        ly/img/android/opengl/egl/GLThread.sleepLock:Ljava/util/concurrent/locks/ReentrantLock;
        //    65: checkcast       Ljava/util/concurrent/locks/Lock;
        //    68: astore_2       
        //    69: aload_2        
        //    70: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    75: nop            
        //    76: iconst_0       
        //    77: istore_3        /* $i$a$-withLock-GLThread$guardedLoop$task$1 */
        //    78: aload_0         /* this */
        //    79: getfield        ly/img/android/opengl/egl/GLThread.eventQueue:Lly/img/android/pesdk/utils/SpeedDeque;
        //    82: invokevirtual   ly/img/android/pesdk/utils/SpeedDeque.poll:()Ljava/lang/Object;
        //    85: checkcast       Ljava/lang/Runnable;
        //    88: dup            
        //    89: ifnonnull       111
        //    92: pop            
        //    93: aload_0         /* this */
        //    94: checkcast       Lly/img/android/opengl/egl/GLThread;
        //    97: astore          $this$guardedLoop_u24lambda_u2d5_u24lambda_u2d4
        //    99: iconst_0       
        //   100: istore          $i$a$-run-GLThread$guardedLoop$task$1$1
        //   102: aload           $this$guardedLoop_u24lambda_u2d5_u24lambda_u2d4
        //   104: invokevirtual   ly/img/android/opengl/egl/GLThread.requestSleep:()V
        //   107: aconst_null    
        //   108: checkcast       Ljava/lang/Runnable;
        //   111: nop            
        //   112: astore_3        /* $i$a$-withLock-GLThread$guardedLoop$task$1 */
        //   113: aload_2        
        //   114: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   119: aload_3        
        //   120: goto            132
        //   123: astore_3       
        //   124: aload_2        
        //   125: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   130: aload_3        
        //   131: athrow         
        //   132: astore_1        /* task */
        //   133: aload_1         /* task */
        //   134: ifnull          182
        //   137: getstatic       ly/img/android/opengl/egl/GLThread.singeGlCommandChainLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   140: checkcast       Ljava/util/concurrent/locks/Lock;
        //   143: astore_2       
        //   144: aload_2        
        //   145: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //   150: nop            
        //   151: iconst_0       
        //   152: istore_3        /* $i$a$-withLock-GLThread$guardedLoop$1 */
        //   153: aload_1         /* task */
        //   154: invokeinterface java/lang/Runnable.run:()V
        //   159: nop            
        //   160: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   163: astore_3       
        //   164: aload_2        
        //   165: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   170: goto            182
        //   173: astore_3       
        //   174: aload_2        
        //   175: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   180: aload_3        
        //   181: athrow         
        //   182: return         
        //    Exceptions:
        //  throws java.lang.InterruptedException
        //    StackMapTable: 00 09 11 5B 07 01 76 02 04 FF 00 39 00 04 07 00 02 00 07 01 3B 01 00 01 07 00 ED FF 00 0B 00 03 07 00 02 00 07 01 3B 00 01 07 00 9F FF 00 08 00 04 07 00 02 00 07 01 3B 07 00 ED 00 01 07 00 ED FF 00 28 00 03 07 00 02 07 00 ED 07 01 3B 00 01 07 00 9F FC 00 08 07 01 02
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                        
        //  -----  -----  -----  -----  ----------------------------
        //  24     42     45     48     Ljava/lang/RuntimeException;
        //  75     113    123    132    Any
        //  123    124    123    132    Any
        //  150    164    173    182    Any
        //  173    174    173    182    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:414)
        //     at com.strobel.assembler.ir.Instruction.accept(Instruction.java:490)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:403)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    private final void processDestroyQueue() {
        Unit instance;
        do {
            final GlObject glObject = this.destroyQueue.poll();
            if (glObject != null) {
                glObject.releaseGlContext();
                instance = Unit.INSTANCE;
            }
            else {
                instance = null;
            }
        } while (instance != null);
    }
    
    private final void processReboundQueue() {
        Unit instance;
        do {
            final GlObject glObject = this.reboundQueue.poll();
            if (glObject != null) {
                glObject.reboundGlContext(this);
                instance = Unit.INSTANCE;
            }
            else {
                instance = null;
            }
        } while (instance != null);
    }
    
    @Override
    public void awakeIfSleeping() {
        final ReentrantLock reentrantLock = this.sleepLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            super.awakeIfSleeping();
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Override
    public void queueDestroy(@NotNull final GlObject obj) {
        Intrinsics.checkNotNullParameter((Object)obj, "obj");
        this.destroyQueue.put(obj);
        this.awakeIfSleeping();
    }
    
    @Override
    public void queueRebound(@NotNull final GlObject obj) {
        Intrinsics.checkNotNullParameter((Object)obj, "obj");
        this.reboundQueue.put(obj);
        this.awakeIfSleeping();
    }
    
    @Override
    public void freeMemory() {
        System.gc();
        this.processDestroyQueue();
    }
    
    @Override
    public void queueDestroy(@NotNull final GlObject obj, final boolean sync) {
        Intrinsics.checkNotNullParameter((Object)obj, "obj");
        if (sync) {
            this.destroyQueue.put(obj);
            while (this.getGlIsAlive() && this.destroyQueue.isNotEmpty()) {}
        }
        else {
            this.destroyQueue.put(obj);
        }
        this.awakeIfSleeping();
    }
    
    @Override
    public void runWithGlContext(@NotNull final Runnable runnable) {
        Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
        this.queueEvent(runnable);
    }
    
    @Override
    public void registerGlContextStopCallback(@NotNull final GlContextStopCallback callback) {
        Intrinsics.checkNotNullParameter((Object)callback, "callback");
        final ReentrantLock reentrantLock = this.glContextStopCallbackLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this.glContextStopCallbackSet.addOnceStrict(callback);
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Override
    public void unregisterGlContextStopCallback(@NotNull final GlContextStopCallback callback) {
        Intrinsics.checkNotNullParameter((Object)callback, "callback");
        final ReentrantLock reentrantLock = this.glContextStopCallbackLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this.glContextStopCallbackSet.remove(callback);
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Nullable
    public final <T> T syncWithGlContext(@NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        if (Intrinsics.areEqual((Object)Thread.currentThread(), (Object)this)) {
            return (T)block.invoke();
        }
        final ThreadUtils.ThreadSync glJob = new ThreadUtils.ThreadSync();
        glJob.startJob();
        this.queueEvent(GLThread::syncWithGlContext$lambda-10);
        final Object waitForJob = glJob.waitForJob(2000L);
        if (waitForJob == null) {}
        return (T)waitForJob;
    }
    
    public final void queueEvent(@NotNull final Runnable r) {
        Intrinsics.checkNotNullParameter((Object)r, "r");
        this.eventQueue.put(r);
        this.awakeIfSleeping();
    }
    
    private static final void syncWithGlContext$lambda-10(final ThreadUtils.ThreadSync $glJob, final Function0 $block) {
        Intrinsics.checkNotNullParameter((Object)$glJob, "$glJob");
        Intrinsics.checkNotNullParameter((Object)$block, "$block");
        $glJob.jobDone($block.invoke());
    }
    
    public GLThread() {
        this(null, false, 3, null);
    }
    
    public static final /* synthetic */ ReentrantLock access$getSingeGlCommandChainLock$cp() {
        return GLThread.singeGlCommandChainLock;
    }
    
    public static final /* synthetic */ void access$setSingeGlCommandChainLock$cp(final ReentrantLock <set-?>) {
        GLThread.singeGlCommandChainLock = <set-?>;
    }
    
    public static final /* synthetic */ SpeedDeque access$getEventQueue$p(final GLThread $this) {
        return $this.eventQueue;
    }
    
    static {
        Companion = new Companion(null);
        GLThread.singeGlCommandChainLock = new ReentrantLock(true);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\t" }, d2 = { "Lly/img/android/opengl/egl/GLThread$Companion;", "", "()V", "singeGlCommandChainLock", "Ljava/util/concurrent/locks/ReentrantLock;", "getSingeGlCommandChainLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "setSingeGlCommandChainLock", "(Ljava/util/concurrent/locks/ReentrantLock;)V", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final ReentrantLock getSingeGlCommandChainLock() {
            return GLThread.access$getSingeGlCommandChainLock$cp();
        }
        
        public final void setSingeGlCommandChainLock(@NotNull final ReentrantLock <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            GLThread.access$setSingeGlCommandChainLock$cp(<set-?>);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0006R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lly/img/android/opengl/egl/GLThread$ResumeInfo;", "", "()V", "glObjectsList", "Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "resumeOn", "Lly/img/android/opengl/egl/GLThread;", "newGLThread", "saveFrom", "", "glThread", "pesdk-backend-core_release" })
    public static final class ResumeInfo
    {
        @NotNull
        private final GlObject.GlObjectCallSet glObjectsList;
        
        public ResumeInfo() {
            this.glObjectsList = new GlObject.GlObjectCallSet();
        }
        
        public final void saveFrom(@NotNull final GLThread glThread) {
            Intrinsics.checkNotNullParameter((Object)glThread, "glThread");
            final Iterable $this$forEach$iv = glThread.getGlObjectsList();
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final GlObject it = (GlObject)element$iv;
                final int n = 0;
                this.glObjectsList.add(it);
            }
            glThread.getGlObjectsList().clear();
        }
        
        @NotNull
        public final GLThread resumeOn(@NotNull final GLThread newGLThread) {
            Intrinsics.checkNotNullParameter((Object)newGLThread, "newGLThread");
            final Iterable $this$forEach$iv = this.glObjectsList;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final GlObject it = (GlObject)element$iv;
                final int n = 0;
                newGLThread.getGlObjectsList().add(it);
            }
            this.glObjectsList.clear();
            return newGLThread;
        }
    }
}
