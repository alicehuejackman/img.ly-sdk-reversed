// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.MainThread;
import java.util.concurrent.atomic.AtomicBoolean;
import ly.img.android.pesdk.kotlin_extension.AtomicSleep;
import java.util.concurrent.SynchronousQueue;
import androidx.annotation.WorkerThread;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.atomic.AtomicReference;
import java.util.Queue;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.ThreadPoolExecutor;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import androidx.annotation.AnyThread;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.opengl.egl.GLThread;
import android.os.Handler;
import android.os.Looper;
import kotlin.jvm.JvmField;
import java.util.concurrent.TimeUnit;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\u0018\u0000 \n2\u00020\u0001:\n\n\u000b\f\r\u000e\u000f\u0010\u0011\u0012\u0013B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bJ\b\u0010\t\u001a\u00020\u0006H\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils;", "", "()V", "supervisor", "Lly/img/android/pesdk/utils/ThreadUtils$Supervisor;", "addTask", "", "runnable", "Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;", "finalize", "Companion", "HotWaitThreadSync", "MainThreadRunnable", "ReplaceThreadRunnable", "SequencedThreadRunnable", "Supervisor", "Task", "ThreadSync", "WorkerExecutor", "WorkerThreadRunnable", "pesdk-backend-core_release" })
public final class ThreadUtils
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Supervisor supervisor;
    private static final long keepAliveTime = 5L;
    @NotNull
    private static final TimeUnit keepAliveUnit;
    @JvmField
    public static final int CPU_CORE_COUNT;
    private static final Looper mainLooper;
    @NotNull
    private static final Handler mainHandler;
    @NotNull
    private static final SingletonReference<ThreadUtils> currentInstance;
    @NotNull
    private static final SingletonReference<GLThread> glSupervisorInstance;
    private static final boolean DEBUG_MODE = false;
    
    private ThreadUtils() {
        this.supervisor = new Supervisor();
    }
    
    @Override
    protected final void finalize() throws Throwable {
        this.supervisor.shutdownNow();
    }
    
    public final void addTask(@NotNull final WorkerThreadRunnable runnable) {
        Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
        this.supervisor.addTask(runnable);
    }
    
    @NotNull
    public static final ThreadUtils getWorker() {
        return ThreadUtils.Companion.getWorker();
    }
    
    @NotNull
    public static final GLThread getGlRender() {
        return ThreadUtils.Companion.getGlRender();
    }
    
    @JvmStatic
    @Nullable
    public static final GLThread getGlRenderIfExists() {
        return ThreadUtils.Companion.getGlRenderIfExists();
    }
    
    @JvmStatic
    public static final void acquireGlRender() {
        ThreadUtils.Companion.acquireGlRender();
    }
    
    @JvmStatic
    public static final void saveReleaseGlRender() {
        ThreadUtils.Companion.saveReleaseGlRender();
    }
    
    @JvmStatic
    @AnyThread
    public static final void postToMainThread(@NotNull final MainThreadRunnable runnable) {
        ThreadUtils.Companion.postToMainThread(runnable);
    }
    
    @JvmStatic
    @AnyThread
    public static final boolean postToMainThread(@NotNull final Function0<Unit> runnable) {
        return ThreadUtils.Companion.postToMainThread(runnable);
    }
    
    @JvmStatic
    @AnyThread
    public static final void runOnMainThread(@NotNull final Function0<Unit> runnable) {
        ThreadUtils.Companion.runOnMainThread(runnable);
    }
    
    @JvmStatic
    public static final void runOnMainThread(@NotNull final MainThreadRunnable runnable) {
        ThreadUtils.Companion.runOnMainThread(runnable);
    }
    
    @JvmStatic
    public static final <T> T syncWithMainThread(@NotNull final Function0<? extends T> runnable) {
        return ThreadUtils.Companion.syncWithMainThread(runnable);
    }
    
    @JvmStatic
    public static final boolean thisIsUiThread() {
        return ThreadUtils.Companion.thisIsUiThread();
    }
    
    public static final /* synthetic */ TimeUnit access$getKeepAliveUnit$cp() {
        return ThreadUtils.keepAliveUnit;
    }
    
    public static final /* synthetic */ SingletonReference access$getCurrentInstance$cp() {
        return ThreadUtils.currentInstance;
    }
    
    public static final /* synthetic */ SingletonReference access$getGlSupervisorInstance$cp() {
        return ThreadUtils.glSupervisorInstance;
    }
    
    public static final /* synthetic */ Handler access$getMainHandler$cp() {
        return ThreadUtils.mainHandler;
    }
    
    public static final /* synthetic */ Looper access$getMainLooper$cp() {
        return ThreadUtils.mainLooper;
    }
    
    static {
        Companion = new Companion(null);
        keepAliveUnit = TimeUnit.SECONDS;
        CPU_CORE_COUNT = ThreadUtils.Companion.getNumberOfCores();
        mainLooper = Looper.getMainLooper();
        mainHandler = new Handler(ThreadUtils.mainLooper);
        currentInstance = new SingletonReference<ThreadUtils>(null, null, (Function0)ThreadUtils$Companion$currentInstance.ThreadUtils$Companion$currentInstance$1.INSTANCE, 3, null);
        glSupervisorInstance = new SingletonReference<GLThread>((Function1)ThreadUtils$Companion$glSupervisorInstance.ThreadUtils$Companion$glSupervisorInstance$1.INSTANCE, null, (Function0)ThreadUtils$Companion$glSupervisorInstance.ThreadUtils$Companion$glSupervisorInstance$2.INSTANCE, 2, null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\u0018\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\bJ\b\u0010\u001f\u001a\u00020\u0019H\u0002J\u0012\u0010 \u001a\u0004\u0018\u00010\b2\u0006\u0010!\u001a\u00020\u000bH\u0002J\b\u0010\"\u001a\u00020\u0019H\u0002J\b\u0010#\u001a\u00020\u0016H\u0017R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\"\u0010\t\u001a\u0016\u0012\u0004\u0012\u00020\u000b\u0012\f\u0012\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\f0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u0014\u0012\u0004\u0012\u00020\u000b\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00110\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006$" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$Supervisor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "Ljava/lang/Runnable;", "()V", "addTaskLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "addTaskQueue", "Lly/img/android/pesdk/utils/SpeedDeque;", "Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;", "exclusiveTasksQueue", "Ljava/util/HashMap;", "", "Ljava/util/concurrent/atomic/AtomicReference;", "exclusiveTasksQueueLock", "groupQueue", "groupQueueLock", "groupTasksQueue", "Ljava/util/Queue;", "groupTasksQueueLock", "workerExecutor", "Lly/img/android/pesdk/utils/ThreadUtils$WorkerExecutor;", "addTask", "", "task", "awaitTermination", "", "timeout", "", "unit", "Ljava/util/concurrent/TimeUnit;", "exclusiveTaskIsDone", "executeTasks", "getTaskOfGroup", "groupId", "handleNewTasks", "run", "pesdk-backend-core_release" })
    public static final class Supervisor extends ThreadPoolExecutor implements Runnable
    {
        @NotNull
        private final ReentrantReadWriteLock addTaskLock;
        @NotNull
        private final ReentrantReadWriteLock groupQueueLock;
        @NotNull
        private final ReentrantReadWriteLock groupTasksQueueLock;
        @NotNull
        private final ReentrantReadWriteLock exclusiveTasksQueueLock;
        @NotNull
        private final SpeedDeque<WorkerThreadRunnable> addTaskQueue;
        @NotNull
        private final SpeedDeque<String> groupQueue;
        @NotNull
        private final HashMap<String, Queue<WorkerThreadRunnable>> groupTasksQueue;
        @NotNull
        private final HashMap<String, AtomicReference<WorkerThreadRunnable>> exclusiveTasksQueue;
        @NotNull
        private final WorkerExecutor workerExecutor;
        
        public Supervisor() {
            super(0, 1, 5L, ThreadUtils.access$getKeepAliveUnit$cp(), new LinkedBlockingQueue<Runnable>());
            this.addTaskLock = new ReentrantReadWriteLock(true);
            this.groupQueueLock = new ReentrantReadWriteLock(true);
            this.groupTasksQueueLock = new ReentrantReadWriteLock(true);
            this.exclusiveTasksQueueLock = new ReentrantReadWriteLock(true);
            this.addTaskQueue = new SpeedDeque<WorkerThreadRunnable>();
            this.groupQueue = new SpeedDeque<String>();
            this.groupTasksQueue = new HashMap<String, Queue<WorkerThreadRunnable>>();
            this.exclusiveTasksQueue = new HashMap<String, AtomicReference<WorkerThreadRunnable>>();
            this.workerExecutor = new WorkerExecutor(this);
        }
        
        public final void addTask(@NotNull final WorkerThreadRunnable task) {
            Intrinsics.checkNotNullParameter((Object)task, "task");
            final ReentrantReadWriteLock addTaskLock = this.addTaskLock;
            final ReentrantReadWriteLock.ReadLock lock = addTaskLock.readLock();
            final int n = (addTaskLock.getWriteHoldCount() == 0) ? addTaskLock.getReadHoldCount() : 0;
            for (int i = 0; i < n; ++i) {
                lock.unlock();
            }
            final ReentrantReadWriteLock.WriteLock writeLock = addTaskLock.writeLock();
            writeLock.lock();
            try {
                final int n2 = 0;
                this.addTaskQueue.put(task);
                final Unit instance = Unit.INSTANCE;
            }
            finally {
                for (int j = 0; j < n; ++j) {
                    lock.lock();
                }
                writeLock.unlock();
            }
            this.execute(this);
        }
        
        public final void exclusiveTaskIsDone(@NotNull final WorkerThreadRunnable task) {
            Intrinsics.checkNotNullParameter((Object)task, "task");
            final ReentrantReadWriteLock groupQueueLock = this.groupQueueLock;
            final ReentrantReadWriteLock.ReadLock lock = groupQueueLock.readLock();
            final int n = (groupQueueLock.getWriteHoldCount() == 0) ? groupQueueLock.getReadHoldCount() : 0;
            for (int i = 0; i < n; ++i) {
                lock.unlock();
            }
            final ReentrantReadWriteLock.WriteLock writeLock = groupQueueLock.writeLock();
            writeLock.lock();
            try {
                final int n2 = 0;
                final AtomicReference<WorkerThreadRunnable> atomicReference = this.exclusiveTasksQueue.get(task.getGroupId$pesdk_backend_core_release());
                if (atomicReference != null && !atomicReference.compareAndSet(task, null)) {
                    final ReentrantReadWriteLock groupQueueLock2 = this.groupQueueLock;
                    final ReentrantReadWriteLock.ReadLock lock2 = groupQueueLock2.readLock();
                    final int n3 = (groupQueueLock2.getWriteHoldCount() == 0) ? groupQueueLock2.getReadHoldCount() : 0;
                    for (int j = 0; j < n3; ++j) {
                        lock2.unlock();
                    }
                    final ReentrantReadWriteLock.WriteLock writeLock2 = groupQueueLock2.writeLock();
                    writeLock2.lock();
                    try {
                        final int n4 = 0;
                        this.groupQueue.put(task.getGroupId$pesdk_backend_core_release());
                        final Unit instance = Unit.INSTANCE;
                    }
                    finally {
                        for (int k = 0; k < n3; ++k) {
                            lock2.lock();
                        }
                        writeLock2.unlock();
                    }
                    this.execute(this);
                }
                final Unit instance2 = Unit.INSTANCE;
            }
            finally {
                for (int l = 0; l < n; ++l) {
                    lock.lock();
                }
                writeLock.unlock();
            }
        }
        
        private final boolean handleNewTasks() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.addTaskLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //     4: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //     7: astore          4
            //     9: aload           4
            //    11: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //    14: nop            
            //    15: iconst_0       
            //    16: istore          $i$a$-read-ThreadUtils$Supervisor$handleNewTasks$task$1
            //    18: aload_0         /* this */
            //    19: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.addTaskQueue:Lly/img/android/pesdk/utils/SpeedDeque;
            //    22: invokevirtual   ly/img/android/pesdk/utils/SpeedDeque.poll:()Ljava/lang/Object;
            //    25: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;
            //    28: astore          null
            //    30: aload           4
            //    32: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    35: aload           5
            //    37: goto            50
            //    40: astore          5
            //    42: aload           4
            //    44: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    47: aload           5
            //    49: athrow         
            //    50: dup            
            //    51: ifnonnull       57
            //    54: pop            
            //    55: iconst_0       
            //    56: ireturn        
            //    57: astore_1        /* task */
            //    58: aload_1         /* task */
            //    59: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable.doReplaceTask:()Z
            //    62: ifeq            420
            //    65: aload_0         /* this */
            //    66: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.exclusiveTasksQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //    69: astore_2       
            //    70: aload_2        
            //    71: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //    74: astore_3       
            //    75: aload_2        
            //    76: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
            //    79: ifne            89
            //    82: aload_2        
            //    83: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
            //    86: goto            90
            //    89: iconst_0       
            //    90: istore          4
            //    92: iconst_0       
            //    93: istore          5
            //    95: iload           5
            //    97: iload           4
            //    99: if_icmpge       112
            //   102: aload_3        
            //   103: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   106: iinc            5, 1
            //   109: goto            95
            //   112: aload_2        
            //   113: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
            //   116: astore          5
            //   118: aload           5
            //   120: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
            //   123: nop            
            //   124: iconst_0       
            //   125: istore          $i$a$-write-ThreadUtils$Supervisor$handleNewTasks$1
            //   127: aload_0         /* this */
            //   128: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.exclusiveTasksQueue:Ljava/util/HashMap;
            //   131: checkcast       Ljava/util/Map;
            //   134: astore          7
            //   136: aload_1         /* task */
            //   137: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable.getGroupId$pesdk_backend_core_release:()Ljava/lang/String;
            //   140: astore          key$iv
            //   142: iconst_0       
            //   143: istore          $i$f$getOrPut
            //   145: aload           $this$getOrPut$iv
            //   147: aload           key$iv
            //   149: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //   154: astore          value$iv
            //   156: aload           value$iv
            //   158: ifnonnull       190
            //   161: iconst_0       
            //   162: istore          $i$a$-getOrPut-ThreadUtils$Supervisor$handleNewTasks$1$oldTask$1
            //   164: new             Ljava/util/concurrent/atomic/AtomicReference;
            //   167: dup            
            //   168: invokespecial   java/util/concurrent/atomic/AtomicReference.<init>:()V
            //   171: astore          answer$iv
            //   173: aload           $this$getOrPut$iv
            //   175: aload           key$iv
            //   177: aload           answer$iv
            //   179: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   184: pop            
            //   185: aload           answer$iv
            //   187: goto            192
            //   190: aload           value$iv
            //   192: nop            
            //   193: checkcast       Ljava/util/concurrent/atomic/AtomicReference;
            //   196: aload_1         /* task */
            //   197: invokevirtual   java/util/concurrent/atomic/AtomicReference.getAndSet:(Ljava/lang/Object;)Ljava/lang/Object;
            //   200: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;
            //   203: astore          oldTask
            //   205: aload           oldTask
            //   207: ifnonnull       356
            //   210: aload_0         /* this */
            //   211: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //   214: astore          7
            //   216: aload           7
            //   218: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //   221: astore          8
            //   223: aload           7
            //   225: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
            //   228: ifne            239
            //   231: aload           7
            //   233: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
            //   236: goto            240
            //   239: iconst_0       
            //   240: istore          9
            //   242: iconst_0       
            //   243: istore          10
            //   245: iload           10
            //   247: iload           9
            //   249: if_icmpge       263
            //   252: aload           8
            //   254: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   257: iinc            10, 1
            //   260: goto            245
            //   263: aload           7
            //   265: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
            //   268: astore          10
            //   270: aload           10
            //   272: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
            //   275: nop            
            //   276: iconst_0       
            //   277: istore          $i$a$-write-ThreadUtils$Supervisor$handleNewTasks$1$1
            //   279: aload_0         /* this */
            //   280: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueue:Lly/img/android/pesdk/utils/SpeedDeque;
            //   283: aload_1         /* task */
            //   284: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable.getGroupId$pesdk_backend_core_release:()Ljava/lang/String;
            //   287: invokevirtual   ly/img/android/pesdk/utils/SpeedDeque.put:(Ljava/lang/Object;)V
            //   290: nop            
            //   291: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
            //   294: astore          11
            //   296: iconst_0       
            //   297: istore          13
            //   299: iload           13
            //   301: iload           9
            //   303: if_icmpge       317
            //   306: aload           8
            //   308: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   311: iinc            13, 1
            //   314: goto            299
            //   317: aload           10
            //   319: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   322: goto            356
            //   325: astore          11
            //   327: iconst_0       
            //   328: istore          13
            //   330: iload           13
            //   332: iload           9
            //   334: if_icmpge       348
            //   337: aload           8
            //   339: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   342: iinc            13, 1
            //   345: goto            330
            //   348: aload           10
            //   350: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   353: aload           11
            //   355: athrow         
            //   356: nop            
            //   357: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
            //   360: astore          6
            //   362: iconst_0       
            //   363: istore          7
            //   365: iload           7
            //   367: iload           4
            //   369: if_icmpge       382
            //   372: aload_3        
            //   373: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   376: iinc            7, 1
            //   379: goto            365
            //   382: aload           5
            //   384: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   387: goto            754
            //   390: astore          6
            //   392: iconst_0       
            //   393: istore          7
            //   395: iload           7
            //   397: iload           4
            //   399: if_icmpge       412
            //   402: aload_3        
            //   403: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   406: iinc            7, 1
            //   409: goto            395
            //   412: aload           5
            //   414: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   417: aload           6
            //   419: athrow         
            //   420: aload_0         /* this */
            //   421: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupTasksQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //   424: astore_2       
            //   425: aload_2        
            //   426: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //   429: astore_3       
            //   430: aload_2        
            //   431: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
            //   434: ifne            444
            //   437: aload_2        
            //   438: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
            //   441: goto            445
            //   444: iconst_0       
            //   445: istore          4
            //   447: iconst_0       
            //   448: istore          5
            //   450: iload           5
            //   452: iload           4
            //   454: if_icmpge       467
            //   457: aload_3        
            //   458: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   461: iinc            5, 1
            //   464: goto            450
            //   467: aload_2        
            //   468: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
            //   471: astore          5
            //   473: aload           5
            //   475: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
            //   478: nop            
            //   479: iconst_0       
            //   480: istore          $i$a$-write-ThreadUtils$Supervisor$handleNewTasks$2
            //   482: aload_0         /* this */
            //   483: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupTasksQueue:Ljava/util/HashMap;
            //   486: checkcast       Ljava/util/Map;
            //   489: astore          7
            //   491: aload_1         /* task */
            //   492: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable.getGroupId$pesdk_backend_core_release:()Ljava/lang/String;
            //   495: astore          key$iv
            //   497: iconst_0       
            //   498: istore          $i$f$getOrPut
            //   500: aload           $this$getOrPut$iv
            //   502: aload           key$iv
            //   504: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //   509: astore          value$iv
            //   511: aload           value$iv
            //   513: ifnonnull       545
            //   516: iconst_0       
            //   517: istore          $i$a$-getOrPut-ThreadUtils$Supervisor$handleNewTasks$2$1
            //   519: new             Ljava/util/concurrent/LinkedBlockingQueue;
            //   522: dup            
            //   523: invokespecial   java/util/concurrent/LinkedBlockingQueue.<init>:()V
            //   526: astore          answer$iv
            //   528: aload           $this$getOrPut$iv
            //   530: aload           key$iv
            //   532: aload           answer$iv
            //   534: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   539: pop            
            //   540: aload           answer$iv
            //   542: goto            547
            //   545: aload           value$iv
            //   547: nop            
            //   548: checkcast       Ljava/util/Queue;
            //   551: aload_1         /* task */
            //   552: invokeinterface java/util/Queue.add:(Ljava/lang/Object;)Z
            //   557: istore          null
            //   559: iconst_0       
            //   560: istore          7
            //   562: iload           7
            //   564: iload           4
            //   566: if_icmpge       579
            //   569: aload_3        
            //   570: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   573: iinc            7, 1
            //   576: goto            562
            //   579: aload           5
            //   581: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   584: goto            617
            //   587: astore          6
            //   589: iconst_0       
            //   590: istore          7
            //   592: iload           7
            //   594: iload           4
            //   596: if_icmpge       609
            //   599: aload_3        
            //   600: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   603: iinc            7, 1
            //   606: goto            592
            //   609: aload           5
            //   611: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   614: aload           6
            //   616: athrow         
            //   617: aload_0         /* this */
            //   618: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //   621: astore_2       
            //   622: aload_2        
            //   623: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //   626: astore_3       
            //   627: aload_2        
            //   628: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
            //   631: ifne            641
            //   634: aload_2        
            //   635: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
            //   638: goto            642
            //   641: iconst_0       
            //   642: istore          4
            //   644: iconst_0       
            //   645: istore          5
            //   647: iload           5
            //   649: iload           4
            //   651: if_icmpge       664
            //   654: aload_3        
            //   655: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   658: iinc            5, 1
            //   661: goto            647
            //   664: aload_2        
            //   665: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
            //   668: astore          5
            //   670: aload           5
            //   672: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
            //   675: nop            
            //   676: iconst_0       
            //   677: istore          $i$a$-write-ThreadUtils$Supervisor$handleNewTasks$3
            //   679: aload_0         /* this */
            //   680: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueue:Lly/img/android/pesdk/utils/SpeedDeque;
            //   683: aload_1         /* task */
            //   684: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable.getGroupId$pesdk_backend_core_release:()Ljava/lang/String;
            //   687: invokevirtual   ly/img/android/pesdk/utils/SpeedDeque.put:(Ljava/lang/Object;)V
            //   690: nop            
            //   691: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
            //   694: astore          6
            //   696: iconst_0       
            //   697: istore          7
            //   699: iload           7
            //   701: iload           4
            //   703: if_icmpge       716
            //   706: aload_3        
            //   707: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   710: iinc            7, 1
            //   713: goto            699
            //   716: aload           5
            //   718: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   721: goto            754
            //   724: astore          6
            //   726: iconst_0       
            //   727: istore          7
            //   729: iload           7
            //   731: iload           4
            //   733: if_icmpge       746
            //   736: aload_3        
            //   737: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   740: iinc            7, 1
            //   743: goto            729
            //   746: aload           5
            //   748: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   751: aload           6
            //   753: athrow         
            //   754: iconst_1       
            //   755: ireturn        
            //    StackMapTable: 00 2F FF 00 28 00 05 07 00 02 00 00 00 07 00 62 00 01 07 00 85 FF 00 09 00 06 07 00 02 00 00 00 07 00 62 07 00 83 00 01 07 00 83 46 07 00 83 FF 00 1F 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 07 00 62 07 00 83 00 00 40 01 FF 00 04 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 01 01 00 00 10 FF 00 4D 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 A1 07 00 C0 01 07 00 C2 00 00 41 07 00 C2 FF 00 2E 00 0D 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 1B 07 00 62 01 07 00 C2 00 07 00 83 00 00 40 01 FF 00 04 00 0D 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 1B 07 00 62 01 01 00 07 00 83 00 00 11 FF 00 23 00 0E 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 1B 07 00 62 01 07 00 6B 07 00 74 07 00 83 01 00 00 11 FF 00 07 00 0D 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 1B 07 00 62 01 07 00 6B 00 07 00 83 00 01 07 00 85 FF 00 04 00 0E 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 1B 07 00 62 01 07 00 6B 07 00 85 07 00 83 01 00 00 11 FF 00 07 00 0D 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 C2 07 00 C2 01 07 00 C2 00 07 00 83 00 00 FF 00 08 00 0D 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 07 00 74 01 07 00 C2 01 07 00 C2 00 07 00 83 00 00 10 FF 00 07 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 00 01 07 00 85 FD 00 04 07 00 85 01 10 FF 00 07 00 06 07 00 02 07 00 83 00 00 07 00 62 07 00 83 00 00 FF 00 17 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 07 00 62 07 00 83 00 00 40 01 FF 00 04 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 01 01 00 00 10 FF 00 4D 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 07 00 A1 07 00 C0 01 07 00 C2 00 00 41 07 00 C2 FF 00 0E 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 01 07 00 C0 01 07 00 C2 00 00 10 FF 00 07 00 06 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 00 01 07 00 85 FD 00 04 07 00 85 01 10 FF 00 07 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 01 01 07 00 C0 01 07 00 C2 00 00 17 40 01 FF 00 04 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 01 01 01 07 00 C0 01 07 00 C2 00 00 10 FF 00 22 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 07 00 74 01 07 00 C0 01 07 00 C2 00 00 10 FF 00 07 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 00 01 07 00 C0 01 07 00 C2 00 01 07 00 85 FF 00 04 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 07 00 85 01 07 00 C0 01 07 00 C2 00 00 10 FF 00 07 00 0B 07 00 02 07 00 83 07 00 1B 07 00 62 01 07 00 6B 07 00 74 01 07 00 C2 01 07 00 C2 00 00
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  14     30     40     50     Any
            //  40     42     40     50     Any
            //  275    296    325    356    Any
            //  325    327    325    356    Any
            //  123    362    390    420    Any
            //  390    392    390    420    Any
            //  478    559    587    617    Any
            //  587    589    587    617    Any
            //  675    696    724    754    Any
            //  724    726    724    754    Any
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
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:543)
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
            //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        private final WorkerThreadRunnable getTaskOfGroup(final String groupId) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupTasksQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //     4: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //     7: astore_2       
            //     8: aload_2        
            //     9: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //    12: nop            
            //    13: iconst_0       
            //    14: istore_3        /* $i$a$-read-ThreadUtils$Supervisor$getTaskOfGroup$1 */
            //    15: aload_0         /* this */
            //    16: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupTasksQueue:Ljava/util/HashMap;
            //    19: aload_1         /* groupId */
            //    20: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    23: checkcast       Ljava/util/Queue;
            //    26: dup            
            //    27: ifnull          41
            //    30: invokeinterface java/util/Queue.poll:()Ljava/lang/Object;
            //    35: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;
            //    38: goto            43
            //    41: pop            
            //    42: aconst_null    
            //    43: astore_3        /* $i$a$-read-ThreadUtils$Supervisor$getTaskOfGroup$1 */
            //    44: aload_2        
            //    45: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    48: aload_3        
            //    49: goto            59
            //    52: astore_3       
            //    53: aload_2        
            //    54: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    57: aload_3        
            //    58: athrow         
            //    59: dup            
            //    60: ifnonnull       121
            //    63: pop            
            //    64: aload_0         /* this */
            //    65: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.exclusiveTasksQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //    68: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //    71: astore_2       
            //    72: aload_2        
            //    73: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //    76: nop            
            //    77: iconst_0       
            //    78: istore_3        /* $i$a$-read-ThreadUtils$Supervisor$getTaskOfGroup$2 */
            //    79: aload_0         /* this */
            //    80: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.exclusiveTasksQueue:Ljava/util/HashMap;
            //    83: aload_1         /* groupId */
            //    84: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    87: checkcast       Ljava/util/concurrent/atomic/AtomicReference;
            //    90: dup            
            //    91: ifnull          103
            //    94: invokevirtual   java/util/concurrent/atomic/AtomicReference.get:()Ljava/lang/Object;
            //    97: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;
            //   100: goto            105
            //   103: pop            
            //   104: aconst_null    
            //   105: astore_3        /* $i$a$-read-ThreadUtils$Supervisor$getTaskOfGroup$2 */
            //   106: aload_2        
            //   107: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   110: aload_3        
            //   111: goto            121
            //   114: astore_3       
            //   115: aload_2        
            //   116: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   119: aload_3        
            //   120: athrow         
            //   121: areturn        
            //    StackMapTable: 00 08 FF 00 29 00 04 07 00 02 07 00 C0 07 00 62 01 00 01 07 00 AB 41 07 00 83 FF 00 08 00 03 07 00 02 07 00 C0 07 00 62 00 01 07 00 85 FF 00 06 00 04 07 00 02 07 00 C0 07 00 62 07 00 83 00 01 07 00 83 FF 00 2B 00 04 07 00 02 07 00 C0 07 00 62 01 00 01 07 00 90 41 07 00 83 FF 00 08 00 03 07 00 02 07 00 C0 07 00 62 00 01 07 00 85 FF 00 06 00 04 07 00 02 07 00 C0 07 00 62 07 00 83 00 01 07 00 83
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  12     44     52     59     Any
            //  52     53     52     59     Any
            //  76     106    114    121    Any
            //  114    115    114    121    Any
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
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:543)
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
            //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        private final boolean executeTasks() {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: aload_0         /* this */
            //     2: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueueLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //     5: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //     8: astore          4
            //    10: aload           4
            //    12: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //    15: nop            
            //    16: iconst_0       
            //    17: istore          $i$a$-read-ThreadUtils$Supervisor$executeTasks$nextTaskGroup$1
            //    19: aload_0         /* this */
            //    20: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.groupQueue:Lly/img/android/pesdk/utils/SpeedDeque;
            //    23: invokevirtual   ly/img/android/pesdk/utils/SpeedDeque.poll:()Ljava/lang/Object;
            //    26: checkcast       Ljava/lang/String;
            //    29: astore          null
            //    31: aload           4
            //    33: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    36: aload           5
            //    38: goto            51
            //    41: astore          5
            //    43: aload           4
            //    45: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    48: aload           5
            //    50: athrow         
            //    51: dup            
            //    52: ifnonnull       58
            //    55: pop            
            //    56: iconst_0       
            //    57: ireturn        
            //    58: astore_1        /* nextTaskGroup */
            //    59: aload_0         /* this */
            //    60: aload_1         /* nextTaskGroup */
            //    61: invokespecial   ly/img/android/pesdk/utils/ThreadUtils$Supervisor.getTaskOfGroup:(Ljava/lang/String;)Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;
            //    64: dup            
            //    65: ifnonnull       72
            //    68: pop            
            //    69: goto            0
            //    72: astore_2        /* nextTask */
            //    73: nop            
            //    74: nop            
            //    75: aload_0         /* this */
            //    76: getfield        ly/img/android/pesdk/utils/ThreadUtils$Supervisor.workerExecutor:Lly/img/android/pesdk/utils/ThreadUtils$WorkerExecutor;
            //    79: aload_2         /* nextTask */
            //    80: checkcast       Ljava/lang/Runnable;
            //    83: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$WorkerExecutor.execute:(Ljava/lang/Runnable;)V
            //    86: goto            97
            //    89: astore_3        /* e */
            //    90: lconst_1       
            //    91: invokestatic    java/lang/Thread.sleep:(J)V
            //    94: goto            73
            //    97: iconst_1       
            //    98: ireturn        
            //    StackMapTable: 00 08 00 FF 00 28 00 05 07 00 02 00 00 00 07 00 62 00 01 07 00 85 FF 00 09 00 06 07 00 02 00 00 00 07 00 62 07 00 C0 00 01 07 00 C0 46 07 00 C0 FF 00 0D 00 06 07 00 02 07 00 C0 00 00 07 00 62 07 00 C0 00 01 07 00 83 FF 00 00 00 06 07 00 02 07 00 C0 07 00 83 00 07 00 62 07 00 C0 00 00 4F 07 00 CE 07
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type                                             
            //  -----  -----  -----  -----  -------------------------------------------------
            //  15     31     41     51     Any
            //  41     43     41     51     Any
            //  74     89     89     97     Ljava/util/concurrent/RejectedExecutionException;
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
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:543)
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
            //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
            //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
            //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        @WorkerThread
        @Override
        public void run() {
            final boolean taskAdded = this.handleNewTasks();
            final boolean taskExecuted = this.executeTasks();
            if (taskAdded || taskExecuted) {
                this.execute(this);
            }
        }
        
        @Override
        public boolean awaitTermination(final long timeout, @NotNull final TimeUnit unit) {
            Intrinsics.checkNotNullParameter((Object)unit, "unit");
            return super.awaitTermination(timeout, unit);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0003\n\u0000\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001a\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0014R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$WorkerExecutor;", "Ljava/util/concurrent/ThreadPoolExecutor;", "supervisor", "Lly/img/android/pesdk/utils/ThreadUtils$Supervisor;", "(Lly/img/android/pesdk/utils/ThreadUtils$Supervisor;)V", "afterExecute", "", "task", "Ljava/lang/Runnable;", "t", "", "pesdk-backend-core_release" })
    private static final class WorkerExecutor extends ThreadPoolExecutor
    {
        @NotNull
        private final Supervisor supervisor;
        
        public WorkerExecutor(@NotNull final Supervisor supervisor) {
            Intrinsics.checkNotNullParameter((Object)supervisor, "supervisor");
            super(0, Integer.MAX_VALUE, 5L, ThreadUtils.access$getKeepAliveUnit$cp(), new SynchronousQueue<Runnable>());
            this.supervisor = supervisor;
        }
        
        @Override
        protected void afterExecute(@NotNull final Runnable task, @Nullable final Throwable t) {
            Intrinsics.checkNotNullParameter((Object)task, "task");
            super.afterExecute(task, t);
            if (task instanceof WorkerThreadRunnable && ((WorkerThreadRunnable)task).doReplaceTask()) {
                this.supervisor.exclusiveTaskIsDone((WorkerThreadRunnable)task);
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$SequencedThreadRunnable;", "Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;", "groupId", "", "(Ljava/lang/String;)V", "doReplaceTask", "", "pesdk-backend-core_release" })
    public abstract static class SequencedThreadRunnable extends WorkerThreadRunnable
    {
        public SequencedThreadRunnable(@NotNull final String groupId) {
            Intrinsics.checkNotNullParameter((Object)groupId, "groupId");
            super(groupId);
        }
        
        @Override
        public boolean doReplaceTask() {
            return false;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;", "Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;", "groupId", "", "(Ljava/lang/String;)V", "doReplaceTask", "", "pesdk-backend-core_release" })
    public abstract static class ReplaceThreadRunnable extends WorkerThreadRunnable
    {
        public ReplaceThreadRunnable(@NotNull final String groupId) {
            Intrinsics.checkNotNullParameter((Object)groupId, "groupId");
            super(groupId);
        }
        
        @Override
        public boolean doReplaceTask() {
            return true;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0007\u001a\u00020\bH&J\u0013\u0010\t\u001a\u00020\b2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0096\u0002J\b\u0010\f\u001a\u00020\rH\u0016J\t\u0010\u000e\u001a\u00020\u000fH\u0086\u0002J\b\u0010\u0010\u001a\u00020\u000fH'J\u0010\u0010\u0011\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u0013H\u0007J\u000e\u0010\u0014\u001a\u00020\b2\u0006\u0010\u0015\u001a\u00020\rR\u0014\u0010\u0002\u001a\u00020\u0003X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$WorkerThreadRunnable;", "Lly/img/android/pesdk/utils/ThreadUtils$Task;", "groupId", "", "(Ljava/lang/String;)V", "getGroupId$pesdk_backend_core_release", "()Ljava/lang/String;", "doReplaceTask", "", "equals", "other", "", "hashCode", "", "invoke", "", "run", "runOnUi", "runnable", "Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "sleep", "milliseconds", "pesdk-backend-core_release" })
    public abstract static class WorkerThreadRunnable extends Task
    {
        @NotNull
        private final String groupId;
        
        public WorkerThreadRunnable(@NotNull final String groupId) {
            Intrinsics.checkNotNullParameter((Object)groupId, "groupId");
            this.groupId = groupId;
        }
        
        @NotNull
        public final String getGroupId$pesdk_backend_core_release() {
            return this.groupId;
        }
        
        @WorkerThread
        @Override
        public abstract void run();
        
        @WorkerThread
        public final void runOnUi(@NotNull final MainThreadRunnable runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            ThreadUtils.Companion.postToMainThread(runnable);
        }
        
        public final boolean sleep(final int milliseconds) {
            boolean b;
            try {
                Thread.sleep(milliseconds);
                b = true;
            }
            catch (InterruptedException e) {
                b = false;
            }
            return b;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (other == null || !Intrinsics.areEqual((Object)this.getClass(), (Object)other.getClass())) {
                return false;
            }
            final WorkerThreadRunnable that = (WorkerThreadRunnable)other;
            return Intrinsics.areEqual((Object)this.groupId, (Object)that.groupId);
        }
        
        @Override
        public int hashCode() {
            return this.groupId.hashCode();
        }
        
        public abstract boolean doReplaceTask();
        
        public final void invoke() {
            ThreadUtils.Companion.getWorker().addTask(this);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0001J\u0014\u0010\b\u001a\u0004\u0018\u00010\u00012\n\u0010\t\u001a\u00060\nj\u0002`\u000bR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\f" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$ThreadSync;", "", "()V", "jobDone", "Lly/img/android/pesdk/kotlin_extension/AtomicSleep;", "result", "", "startJob", "waitForJob", "timeoutInMilliseconds", "", "Lly/img/android/pesdk/kotlin_extension/Milliseconds;", "pesdk-backend-core_release" })
    public static final class ThreadSync
    {
        @NotNull
        private final AtomicSleep jobDone;
        @Nullable
        private Object result;
        
        public ThreadSync() {
            this.jobDone = new AtomicSleep(false);
        }
        
        public final void startJob() {
            this.jobDone.set(false);
        }
        
        @Nullable
        public final Object waitForJob() {
            this.jobDone.waitUntilTrue();
            final Object it = this.result;
            final int n = 0;
            this.result = null;
            return it;
        }
        
        @Nullable
        public final Object waitForJob(final long timeoutInMilliseconds) {
            this.jobDone.waitUntilTrue(timeoutInMilliseconds);
            final Object it = this.result;
            final int n = 0;
            this.result = null;
            return it;
        }
        
        public final void jobDone(@Nullable final Object result) {
            this.result = result;
            this.jobDone.set(true);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00062\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0001J\u0006\u0010\u0007\u001a\u00020\u0006J\b\u0010\b\u001a\u0004\u0018\u00010\u0001R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0001X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\t" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$HotWaitThreadSync;", "", "()V", "jobDone", "Ljava/util/concurrent/atomic/AtomicBoolean;", "result", "", "startJob", "waitForJob", "pesdk-backend-core_release" })
    public static final class HotWaitThreadSync
    {
        @NotNull
        private final AtomicBoolean jobDone;
        @Nullable
        private Object result;
        
        public HotWaitThreadSync() {
            this.jobDone = new AtomicBoolean(false);
        }
        
        public final void startJob() {
            this.jobDone.set(false);
        }
        
        @Nullable
        public final Object waitForJob() {
            final AtomicBoolean $this$waitUntilTrue$iv = this.jobDone;
            final int $i$f$waitUntilTrue = 0;
            while (!$this$waitUntilTrue$iv.get()) {
                Thread.sleep(1L);
            }
            final Object it = this.result;
            final int n = 0;
            this.result = null;
            return it;
        }
        
        public final void jobDone(@Nullable final Object result) {
            this.result = result;
            this.jobDone.set(true);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\t\u0010\u0003\u001a\u00020\u0004H\u0086\u0002J\b\u0010\u0005\u001a\u00020\u0004H'¨\u0006\u0006" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "Lly/img/android/pesdk/utils/ThreadUtils$Task;", "()V", "invoke", "", "run", "pesdk-backend-core_release" })
    public abstract static class MainThreadRunnable extends Task
    {
        @MainThread
        @Override
        public abstract void run();
        
        public final void invoke() {
            ThreadUtils.Companion.runOnMainThread(this);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$Task;", "Ljava/lang/Runnable;", "()V", "pesdk-backend-core_release" })
    public abstract static class Task implements Runnable
    {
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010 \u001a\u00020!H\u0007J\n\u0010\"\u001a\u0004\u0018\u00010\u000bH\u0007J\u0016\u0010#\u001a\u00020\u00062\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%H\u0007J\u0010\u0010#\u001a\u00020!2\u0006\u0010$\u001a\u00020&H\u0007J\u001c\u0010'\u001a\u00020!2\u000e\b\u0004\u0010(\u001a\b\u0012\u0004\u0012\u00020!0%H\u0086\b\u00f8\u0001\u0000J\u0016\u0010)\u001a\u00020!2\f\u0010$\u001a\b\u0012\u0004\u0012\u00020!0%H\u0007J\u0010\u0010)\u001a\u00020!2\u0006\u0010$\u001a\u00020&H\u0007J\b\u0010*\u001a\u00020!H\u0007J!\u0010+\u001a\u0002H,\"\u0004\b\u0000\u0010,2\f\u0010$\u001a\b\u0012\u0004\u0012\u0002H,0%H\u0007¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0006H\u0007R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\n\u001a\u00020\u000b8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\f\u0010\u0002\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u000b0\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\t8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u001d\u0010\u0002\u001a\u0004\b\u001e\u0010\u001f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006/" }, d2 = { "Lly/img/android/pesdk/utils/ThreadUtils$Companion;", "", "()V", "CPU_CORE_COUNT", "", "DEBUG_MODE", "", "currentInstance", "Lly/img/android/pesdk/utils/SingletonReference;", "Lly/img/android/pesdk/utils/ThreadUtils;", "glRender", "Lly/img/android/opengl/egl/GLThread;", "getGlRender$annotations", "getGlRender", "()Lly/img/android/opengl/egl/GLThread;", "glSupervisorInstance", "keepAliveTime", "", "keepAliveUnit", "Ljava/util/concurrent/TimeUnit;", "mainHandler", "Landroid/os/Handler;", "mainLooper", "Landroid/os/Looper;", "kotlin.jvm.PlatformType", "numberOfCores", "getNumberOfCores", "()I", "worker", "getWorker$annotations", "getWorker", "()Lly/img/android/pesdk/utils/ThreadUtils;", "acquireGlRender", "", "getGlRenderIfExists", "postToMainThread", "runnable", "Lkotlin/Function0;", "Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "runAsync", "block", "runOnMainThread", "saveReleaseGlRender", "syncWithMainThread", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "thisIsUiThread", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @NotNull
        public final ThreadUtils getWorker() {
            return ThreadUtils.access$getCurrentInstance$cp().getValue();
        }
        
        @NotNull
        public final GLThread getGlRender() {
            return ThreadUtils.access$getGlSupervisorInstance$cp().getValue();
        }
        
        @JvmStatic
        @Nullable
        public final GLThread getGlRenderIfExists() {
            return ThreadUtils.access$getGlSupervisorInstance$cp().getIfExistsAndValid();
        }
        
        @JvmStatic
        public final void acquireGlRender() {
            ThreadUtils.access$getGlSupervisorInstance$cp().acquire();
        }
        
        @JvmStatic
        public final void saveReleaseGlRender() {
            ThreadUtils.access$getGlSupervisorInstance$cp().destroy((Function1)ThreadUtils$Companion$saveReleaseGlRender.ThreadUtils$Companion$saveReleaseGlRender$1.INSTANCE);
        }
        
        @JvmStatic
        @AnyThread
        public final void postToMainThread(@NotNull final MainThreadRunnable runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            ThreadUtils.access$getMainHandler$cp().post((Runnable)runnable);
        }
        
        @JvmStatic
        @AnyThread
        public final boolean postToMainThread(@NotNull final Function0<Unit> runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            return ThreadUtils.access$getMainHandler$cp().post(Companion::postToMainThread$lambda-0);
        }
        
        @JvmStatic
        @AnyThread
        public final void runOnMainThread(@NotNull final Function0<Unit> runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            if (this.thisIsUiThread()) {
                runnable.invoke();
            }
            else {
                ThreadUtils.access$getMainHandler$cp().post(Companion::runOnMainThread$lambda-1);
            }
        }
        
        @JvmStatic
        public final void runOnMainThread(@NotNull final MainThreadRunnable runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            if (this.thisIsUiThread()) {
                runnable.run();
            }
            else {
                ThreadUtils.access$getMainHandler$cp().post((Runnable)runnable);
            }
        }
        
        public final void runAsync(@NotNull final Function0<Unit> block) {
            Intrinsics.checkNotNullParameter((Object)block, "block");
            final int $i$f$runAsync = 0;
            new Thread((Runnable)new ThreadUtils$Companion$runAsync.ThreadUtils$Companion$runAsync$1((Function0)block)).start();
        }
        
        @JvmStatic
        public final <T> T syncWithMainThread(@NotNull final Function0<? extends T> runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            Object o;
            if (this.thisIsUiThread()) {
                o = runnable.invoke();
            }
            else {
                final ThreadSync mainJob = new ThreadSync();
                mainJob.startJob();
                final int $i$f$loopIfTrue = 0;
                do {
                    final int n = 0;
                } while (!ThreadUtils.access$getMainHandler$cp().post((Runnable)new ThreadUtils$Companion$syncWithMainThread$1.ThreadUtils$Companion$syncWithMainThread$1$1(mainJob, (Function0)runnable)));
                o = mainJob.waitForJob();
            }
            return (T)o;
        }
        
        @JvmStatic
        public final boolean thisIsUiThread() {
            return Intrinsics.areEqual((Object)Looper.myLooper(), (Object)ThreadUtils.access$getMainLooper$cp());
        }
        
        private final int getNumberOfCores() {
            return Runtime.getRuntime().availableProcessors();
        }
        
        private static final void postToMainThread$lambda-0(final Function0 $tmp0) {
            Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
            $tmp0.invoke();
        }
        
        private static final void runOnMainThread$lambda-1(final Function0 $tmp0) {
            Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
            $tmp0.invoke();
        }
    }
}
