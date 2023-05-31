// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import java.util.Iterator;
import ly.img.android.pesdk.utils.WeakCallSet;
import java.nio.Buffer;
import ly.img.android.opengl.egl.GLThread;
import android.util.Log;
import ly.img.android.opengl.EGLLogWrapper;
import android.opengl.GLES20;
import ly.img.android.pesdk.utils.ThreadUtils;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import android.opengl.EGLSurface;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import java.util.concurrent.locks.ReentrantLock;
import javax.microedition.khronos.egl.EGLContext;
import java.util.HashMap;
import kotlin.jvm.functions.Function0;
import ly.img.android.opengl.GlContextStopCallback;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import androidx.annotation.AnyThread;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.JvmOverloads;
import org.jetbrains.annotations.Nullable;
import ly.img.android.opengl.GlThreadRunner;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\b'\u0018\u0000 \u00122\u00020\u0001:\u0004\u0012\u0013\u0014\u0015B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0006\u001a\u00020\u0007H\u0005J\u0010\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000b\u001a\u00020\u0007H\u0014J\b\u0010\f\u001a\u00020\u0007H$J\u0012\u0010\r\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007J\b\u0010\u000e\u001a\u00020\u0007H\u0007J\u0010\u0010\u000f\u001a\u00020\u00072\u0006\u0010\u0010\u001a\u00020\u0003H\u0007J\b\u0010\u0011\u001a\u00020\u0007H\u0017R\u000e\u0010\u0005\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Lly/img/android/opengl/canvas/GlObject;", "", "context", "Lly/img/android/opengl/GlThreadRunner;", "(Lly/img/android/opengl/GlThreadRunner;)V", "glContext", "finalize", "", "freeUp", "sync", "", "onRebound", "onRelease", "queueDestroy", "queueRebound", "reboundGlContext", "newContext", "releaseGlContext", "Companion", "GlContextBound", "GlObjectCallSet", "GlSurfaceBound", "pesdk-backend-core_release" })
@WorkerThread
public abstract class GlObject
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private GlThreadRunner glContext;
    
    @WorkerThread
    @JvmOverloads
    public GlObject(@Nullable final GlThreadRunner context) {
        GlThreadRunner glContext = context;
        if (context == null) {
            final Thread currentThread = Thread.currentThread();
            if (currentThread == null) {
                throw new NullPointerException("null cannot be cast to non-null type ly.img.android.opengl.GlThreadRunner");
            }
            glContext = (GlThreadRunner)currentThread;
        }
        this.glContext = glContext;
        this.glContext.getGlObjectsList().addOnceStrict(this);
    }
    
    @CallSuper
    @AnyThread
    @Override
    protected final void finalize() throws Throwable {
        this.freeUp(false);
    }
    
    @AnyThread
    @WorkerThread
    public final void freeUp(final boolean sync) {
        this.queueDestroy(sync);
        this.glContext.getGlObjectsList().remove(this);
    }
    
    @WorkerThread
    public void releaseGlContext() {
        final Thread currentThread = Thread.currentThread();
        if (Intrinsics.areEqual((Object)((currentThread instanceof GlThreadRunner) ? currentThread : null), (Object)this.glContext)) {
            this.onRelease();
        }
    }
    
    @WorkerThread
    public final void reboundGlContext(@NotNull final GlThreadRunner newContext) {
        Intrinsics.checkNotNullParameter((Object)newContext, "newContext");
        if (this.glContext.getGlIsDead()) {
            this.glContext = newContext;
            this.onRebound();
        }
    }
    
    @AnyThread
    public final void queueDestroy(final boolean sync) {
        this.glContext.queueDestroy(this, sync);
    }
    
    public static /* synthetic */ void queueDestroy$default(final GlObject glObject, boolean sync, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: queueDestroy");
        }
        if ((n & 0x1) != 0x0) {
            sync = false;
        }
        glObject.queueDestroy(sync);
    }
    
    @AnyThread
    public final void queueRebound() {
        this.glContext.queueRebound(this);
    }
    
    protected abstract void onRelease();
    
    protected void onRebound() {
    }
    
    @WorkerThread
    @JvmOverloads
    public GlObject() {
        this(null, 1, null);
    }
    
    @JvmStatic
    @AnyThread
    public static final void runWithGlContext(@NotNull final Runnable runnable) {
        GlObject.Companion.runWithGlContext(runnable);
    }
    
    @JvmStatic
    @WorkerThread
    public static final boolean glIsOutOfMemory() {
        return GlObject.Companion.glIsOutOfMemory();
    }
    
    @JvmStatic
    @WorkerThread
    public static final synchronized void createGlContext(@NotNull final GlThreadRunner glThreadRunner) {
        GlObject.Companion.createGlContext(glThreadRunner);
    }
    
    @JvmStatic
    @WorkerThread
    @JvmOverloads
    public static final synchronized void destroyGlContext(@NotNull final GlThreadRunner glThreadRunner, final boolean releaseFinally) {
        GlObject.Companion.destroyGlContext(glThreadRunner, releaseFinally);
    }
    
    @JvmStatic
    @WorkerThread
    @JvmOverloads
    public static final synchronized void destroyGlContext(@NotNull final GlThreadRunner glThreadRunner) {
        GlObject.Companion.destroyGlContext(glThreadRunner);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u000e\u001a\u00028\u00002\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u0012H\u0086\u0002¢\u0006\u0002\u0010\u0013J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\fH\u0016J\b\u0010\u0017\u001a\u00020\u0015H\u0002J*\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u000f\u001a\u00020\u00102\n\u0010\u0011\u001a\u0006\u0012\u0002\b\u00030\u00122\u0006\u0010\u0019\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001aR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R.\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\rX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b" }, d2 = { "Lly/img/android/opengl/canvas/GlObject$GlContextBound;", "T", "Lly/img/android/opengl/GlContextStopCallback;", "initValue", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getInitValue", "()Lkotlin/jvm/functions/Function0;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "valueMap", "Ljava/util/HashMap;", "Ljavax/microedition/khronos/egl/EGLContext;", "Lkotlin/collections/HashMap;", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "onContextStopped", "", "context", "registerGlContextStopCallback", "setValue", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
    public static final class GlContextBound<T> implements GlContextStopCallback
    {
        @NotNull
        private final Function0<T> initValue;
        @NotNull
        private HashMap<EGLContext, T> valueMap;
        @NotNull
        private final ReentrantLock lock;
        
        public GlContextBound(@NotNull final Function0<? extends T> initValue) {
            Intrinsics.checkNotNullParameter((Object)initValue, "initValue");
            this.initValue = (Function0<T>)initValue;
            this.valueMap = new HashMap<EGLContext, T>();
            this.lock = new ReentrantLock(true);
        }
        
        @NotNull
        public final Function0<T> getInitValue() {
            return this.initValue;
        }
        
        public final T getValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "thisRef"
            //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //     6: aload_2         /* property */
            //     7: ldc             "property"
            //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //    12: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
            //    15: invokevirtual   ly/img/android/opengl/canvas/GlMakeCurrent$Companion.getEgl10Context:()Ljavax/microedition/khronos/egl/EGLContext;
            //    18: astore_3        /* context */
            //    19: aload_0         /* this */
            //    20: getfield        ly/img/android/opengl/canvas/GlObject$GlContextBound.lock:Ljava/util/concurrent/locks/ReentrantLock;
            //    23: checkcast       Ljava/util/concurrent/locks/Lock;
            //    26: astore          4
            //    28: aload           4
            //    30: invokeinterface java/util/concurrent/locks/Lock.lock:()V
            //    35: nop            
            //    36: iconst_0       
            //    37: istore          $i$a$-withLock-GlObject$GlContextBound$getValue$1
            //    39: aload_0         /* this */
            //    40: getfield        ly/img/android/opengl/canvas/GlObject$GlContextBound.valueMap:Ljava/util/HashMap;
            //    43: aload_3         /* context */
            //    44: invokevirtual   java/util/HashMap.containsKey:(Ljava/lang/Object;)Z
            //    47: ifeq            61
            //    50: aload_0         /* this */
            //    51: getfield        ly/img/android/opengl/canvas/GlObject$GlContextBound.valueMap:Ljava/util/HashMap;
            //    54: aload_3         /* context */
            //    55: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    58: goto            117
            //    61: aload_0         /* this */
            //    62: getfield        ly/img/android/opengl/canvas/GlObject$GlContextBound.initValue:Lkotlin/jvm/functions/Function0;
            //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
            //    70: astore          value
            //    72: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
            //    75: invokevirtual   ly/img/android/opengl/canvas/GlMakeCurrent$Companion.getGLThreadRunner:()Lly/img/android/opengl/GlThreadRunner;
            //    78: astore          glThreadRunner
            //    80: aload           glThreadRunner
            //    82: invokeinterface ly/img/android/opengl/GlThreadRunner.getGlIsDead:()Z
            //    87: ifeq            95
            //    90: aload           value
            //    92: goto            117
            //    95: aload_0         /* this */
            //    96: invokespecial   ly/img/android/opengl/canvas/GlObject$GlContextBound.registerGlContextStopCallback:()V
            //    99: aload_0         /* this */
            //   100: getfield        ly/img/android/opengl/canvas/GlObject$GlContextBound.valueMap:Ljava/util/HashMap;
            //   103: checkcast       Ljava/util/Map;
            //   106: aload_3         /* context */
            //   107: aload           value
            //   109: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   114: pop            
            //   115: aload           value
            //   117: astore          null
            //   119: aload           4
            //   121: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
            //   126: aload           5
            //   128: goto            143
            //   131: astore          5
            //   133: aload           4
            //   135: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
            //   140: aload           5
            //   142: athrow         
            //   143: areturn        
            //    Signature:
            //  (Ljava/lang/Object;Lkotlin/reflect/KProperty<*>;)TT;
            //    StackMapTable: 00 05 FE 00 3D 07 00 74 07 00 43 01 FD 00 21 07 00 05 07 00 59 FF 00 15 00 06 07 00 02 07 00 05 07 00 76 07 00 74 07 00 43 01 00 01 07 00 05 FF 00 0D 00 05 07 00 02 07 00 05 07 00 76 07 00 74 07 00 43 00 01 07 00 78 FF 00 0B 00 06 07 00 02 07 00 05 07 00 76 07 00 74 07 00 43 07 00 05 00 01 07 00 05
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  35     119    131    143    Any
            //  131    133    131    143    Any
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
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
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
        
        public final void setValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property, final T value) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final GlThreadRunner glThreadRunner = GlMakeCurrent.Companion.getGLThreadRunner();
            if (glThreadRunner.getGlIsDead()) {
                return;
            }
            final ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                final int n = 0;
                this.registerGlContextStopCallback();
                this.valueMap.put(GlMakeCurrent.Companion.getEgl10Context(), value);
                final Unit instance = Unit.INSTANCE;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        
        private final void registerGlContextStopCallback() {
            GlMakeCurrent.Companion.getGLThreadRunner().registerGlContextStopCallback(this);
        }
        
        @Override
        public void onContextStopped(@NotNull final EGLContext context) {
            Intrinsics.checkNotNullParameter((Object)context, "context");
            final ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                final int n = 0;
                this.valueMap.remove(context);
            }
            finally {
                reentrantLock.unlock();
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\u0015\u001a\u00028\u00002\u0006\u0010\u0016\u001a\u00020\u00022\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0086\u0002¢\u0006\u0002\u0010\u0019J*\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u0016\u001a\u00020\u00022\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u001c\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u001dR\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000Rk\u0010\u000e\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\r2&\u0010\n\u001a\"\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bj\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u0000`\r8B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\u0013\u0010\u0014\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006\u001e" }, d2 = { "Lly/img/android/opengl/canvas/GlObject$GlSurfaceBound;", "T", "", "initValue", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getInitValue", "()Lkotlin/jvm/functions/Function0;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "<set-?>", "Ljava/util/HashMap;", "Landroid/opengl/EGLSurface;", "Lkotlin/collections/HashMap;", "valueMap", "getValueMap", "()Ljava/util/HashMap;", "setValueMap", "(Ljava/util/HashMap;)V", "valueMap$delegate", "Lly/img/android/opengl/canvas/GlObject$GlContextBound;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
    public static final class GlSurfaceBound<T>
    {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        @NotNull
        private final Function0<T> initValue;
        @NotNull
        private final GlContextBound valueMap$delegate;
        @NotNull
        private final ReentrantLock lock;
        
        public GlSurfaceBound(@NotNull final Function0<? extends T> initValue) {
            Intrinsics.checkNotNullParameter((Object)initValue, "initValue");
            this.initValue = (Function0<T>)initValue;
            this.valueMap$delegate = new GlContextBound((Function0<? extends T>)GlObject$GlSurfaceBound$valueMap.GlObject$GlSurfaceBound$valueMap$2.INSTANCE);
            this.lock = new ReentrantLock(true);
        }
        
        @NotNull
        public final Function0<T> getInitValue() {
            return this.initValue;
        }
        
        private final HashMap<EGLSurface, T> getValueMap() {
            return this.valueMap$delegate.getValue(this, GlSurfaceBound.$$delegatedProperties[0]);
        }
        
        private final void setValueMap(final HashMap<EGLSurface, T> <set-?>) {
            this.valueMap$delegate.setValue(this, GlSurfaceBound.$$delegatedProperties[0], <set-?>);
        }
        
        public final T getValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: ldc             "thisRef"
            //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //     6: aload_2         /* property */
            //     7: ldc             "property"
            //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
            //    12: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
            //    15: invokevirtual   ly/img/android/opengl/canvas/GlMakeCurrent$Companion.getEgl14SurfaceId:()Landroid/opengl/EGLSurface;
            //    18: astore_3        /* context */
            //    19: aload_0         /* this */
            //    20: getfield        ly/img/android/opengl/canvas/GlObject$GlSurfaceBound.lock:Ljava/util/concurrent/locks/ReentrantLock;
            //    23: checkcast       Ljava/util/concurrent/locks/Lock;
            //    26: astore          4
            //    28: aload           4
            //    30: invokeinterface java/util/concurrent/locks/Lock.lock:()V
            //    35: nop            
            //    36: iconst_0       
            //    37: istore          $i$a$-withLock-GlObject$GlSurfaceBound$getValue$1
            //    39: aload_0         /* this */
            //    40: invokespecial   ly/img/android/opengl/canvas/GlObject$GlSurfaceBound.getValueMap:()Ljava/util/HashMap;
            //    43: aload_3         /* context */
            //    44: invokevirtual   java/util/HashMap.containsKey:(Ljava/lang/Object;)Z
            //    47: ifeq            61
            //    50: aload_0         /* this */
            //    51: invokespecial   ly/img/android/opengl/canvas/GlObject$GlSurfaceBound.getValueMap:()Ljava/util/HashMap;
            //    54: aload_3         /* context */
            //    55: invokevirtual   java/util/HashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    58: goto            113
            //    61: aload_0         /* this */
            //    62: getfield        ly/img/android/opengl/canvas/GlObject$GlSurfaceBound.initValue:Lkotlin/jvm/functions/Function0;
            //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
            //    70: astore          value
            //    72: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
            //    75: invokevirtual   ly/img/android/opengl/canvas/GlMakeCurrent$Companion.getGLThreadRunner:()Lly/img/android/opengl/GlThreadRunner;
            //    78: astore          glThreadRunner
            //    80: aload           glThreadRunner
            //    82: invokeinterface ly/img/android/opengl/GlThreadRunner.getGlIsDead:()Z
            //    87: ifeq            95
            //    90: aload           value
            //    92: goto            113
            //    95: aload_0         /* this */
            //    96: invokespecial   ly/img/android/opengl/canvas/GlObject$GlSurfaceBound.getValueMap:()Ljava/util/HashMap;
            //    99: checkcast       Ljava/util/Map;
            //   102: aload_3         /* context */
            //   103: aload           value
            //   105: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   110: pop            
            //   111: aload           value
            //   113: astore          null
            //   115: aload           4
            //   117: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
            //   122: aload           5
            //   124: goto            139
            //   127: astore          5
            //   129: aload           4
            //   131: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
            //   136: aload           5
            //   138: athrow         
            //   139: areturn        
            //    Signature:
            //  (Ljava/lang/Object;Lkotlin/reflect/KProperty<*>;)TT;
            //    StackMapTable: 00 05 FE 00 3D 07 00 8C 07 00 5E 01 FD 00 21 07 00 05 07 00 74 FF 00 11 00 06 07 00 02 07 00 05 07 00 8E 07 00 8C 07 00 5E 01 00 01 07 00 05 FF 00 0D 00 05 07 00 02 07 00 05 07 00 8E 07 00 8C 07 00 5E 00 01 07 00 90 FF 00 0B 00 06 07 00 02 07 00 05 07 00 8E 07 00 8C 07 00 5E 07 00 05 00 01 07 00 05
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  35     115    127    139    Any
            //  127    129    127    139    Any
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
            //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
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
        
        public final void setValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property, final T value) {
            Intrinsics.checkNotNullParameter(thisRef, "thisRef");
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final GlThreadRunner glThreadRunner = GlMakeCurrent.Companion.getGLThreadRunner();
            if (glThreadRunner.getGlIsDead()) {
                return;
            }
            final ReentrantLock reentrantLock = this.lock;
            reentrantLock.lock();
            try {
                final int n = 0;
                this.getValueMap().put(GlMakeCurrent.Companion.getEgl14SurfaceId(), value);
                final Unit instance = Unit.INSTANCE;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        
        static {
            $$delegatedProperties = new KProperty[] { (KProperty)Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((Class)GlSurfaceBound.class, "valueMap", "getValueMap()Ljava/util/HashMap;", 0)) };
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u001a\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\b\u001a\u00020\tH\u0007J\u0006\u0010\n\u001a\u00020\u0004J\u000e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\rJ\b\u0010\u000f\u001a\u00020\tH\u0007J\u001c\u0010\u0010\u001a\u00020\u00042\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0086\b\u00f8\u0001\u0000J\u0010\u0010\u0010\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u0014H\u0007J\u000e\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rJ\u000e\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\rJ6\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001eJ6\u0010\u0018\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\r2\u0006\u0010\u0019\u001a\u00020\r2\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u001b\u001a\u00020\t2\u0006\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001f\u001a\u00020\rJ\u001a\u0010 \u001a\u00020\t2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00040\u0012H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006!" }, d2 = { "Lly/img/android/opengl/canvas/GlObject$Companion;", "", "()V", "createGlContext", "", "glThreadRunner", "Lly/img/android/opengl/GlThreadRunner;", "destroyGlContext", "releaseFinally", "", "freeMemory", "glDeleteBuffer", "handle", "", "glGenBuffer", "glIsOutOfMemory", "runWithGlContext", "block", "Lkotlin/Function0;", "runnable", "Ljava/lang/Runnable;", "safeGlDisableVertexAttribArray", "index", "safeGlEnableVertexAttribArray", "safeGlVertexAttribPointer", "size", "type", "normalized", "stride", "ptr", "Ljava/nio/Buffer;", "offset", "tryGlAllocate", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        public final void runWithGlContext(@NotNull final Function0<Unit> block) {
            Intrinsics.checkNotNullParameter((Object)block, "block");
            final int $i$f$runWithGlContext = 0;
            this.runWithGlContext((Runnable)new GlObject$Companion$runWithGlContext.GlObject$Companion$runWithGlContext$1((Function0)block));
        }
        
        @JvmStatic
        @AnyThread
        public final void runWithGlContext(@NotNull final Runnable runnable) {
            Intrinsics.checkNotNullParameter((Object)runnable, "runnable");
            ThreadUtils.Companion.getGlRender().queueEvent(runnable);
        }
        
        @JvmStatic
        @WorkerThread
        public final boolean glIsOutOfMemory() {
            while (true) {
                final int error = GLES20.glGetError();
                switch (error) {
                    case 0: {
                        return false;
                    }
                    case 1285: {
                        return true;
                    }
                    default: {
                        Log.e("PESDK", "GlError: " + EGLLogWrapper.getErrorString(error));
                        continue;
                    }
                }
            }
        }
        
        @JvmStatic
        @WorkerThread
        public final synchronized void createGlContext(@NotNull final GlThreadRunner glThreadRunner) {
            Intrinsics.checkNotNullParameter((Object)glThreadRunner, "glThreadRunner");
            glThreadRunner.getGlObjectsList().reboundGlContext$pesdk_backend_core_release();
        }
        
        @JvmStatic
        @WorkerThread
        @JvmOverloads
        public final synchronized void destroyGlContext(@NotNull final GlThreadRunner glThreadRunner, final boolean releaseFinally) {
            Intrinsics.checkNotNullParameter((Object)glThreadRunner, "glThreadRunner");
            final GlObjectCallSet glObjectsList = glThreadRunner.getGlObjectsList();
            glObjectsList.releaseGlContext$pesdk_backend_core_release();
            if (releaseFinally) {
                glObjectsList.clear();
            }
        }
        
        public static /* synthetic */ void destroyGlContext$default(final Companion companion, final GlThreadRunner glThreadRunner, boolean releaseFinally, final int n, final Object o) {
            if ((n & 0x2) != 0x0) {
                releaseFinally = false;
            }
            companion.destroyGlContext(glThreadRunner, releaseFinally);
        }
        
        public final int glGenBuffer() {
            final int[] it;
            final int[] array = it = new int[] { 0 };
            final int n = 0;
            GLES20.glGenBuffers(it.length, it, 0);
            return array[0];
        }
        
        public final void glDeleteBuffer(final int handle) {
            final int[] it = { handle };
            final int n = 0;
            GLES20.glDeleteBuffers(it.length, it, 0);
            GLES20.glFinish();
        }
        
        public final void freeMemory() {
            final GLThread glRenderIfExists = ThreadUtils.Companion.getGlRenderIfExists();
            if (glRenderIfExists != null) {
                glRenderIfExists.freeMemory();
            }
        }
        
        public final void safeGlVertexAttribPointer(final int index, final int size, final int type, final boolean normalized, final int stride, @NotNull final Buffer ptr) {
            Intrinsics.checkNotNullParameter((Object)ptr, "ptr");
            if (index >= 0) {
                GLES20.glVertexAttribPointer(index, size, type, normalized, stride, ptr);
            }
        }
        
        public final void safeGlVertexAttribPointer(final int index, final int size, final int type, final boolean normalized, final int stride, final int offset) {
            if (index >= 0) {
                GLES20.glVertexAttribPointer(index, size, type, normalized, stride, offset);
            }
        }
        
        public final void safeGlEnableVertexAttribArray(final int index) {
            if (index >= 0) {
                GLES20.glEnableVertexAttribArray(index);
            }
        }
        
        public final void safeGlDisableVertexAttribArray(final int index) {
            if (index >= 0) {
                GLES20.glDisableVertexAttribArray(index);
            }
        }
        
        public final boolean tryGlAllocate(@NotNull final Function0<Unit> block) {
            Intrinsics.checkNotNullParameter((Object)block, "block");
            final int $i$f$tryGlAllocate = 0;
            int rounds = 5;
            while (rounds-- > 0) {
                int maxRoundTries = 10;
                while (maxRoundTries-- > 0) {
                    block.invoke();
                    if (!this.glIsOutOfMemory()) {
                        return true;
                    }
                    final GLThread glRenderIfExists = ThreadUtils.Companion.getGlRenderIfExists();
                    if (glRenderIfExists == null) {
                        continue;
                    }
                    glRenderIfExists.freeMemory();
                }
                Thread.sleep(1L);
            }
            return false;
        }
        
        @JvmStatic
        @WorkerThread
        @JvmOverloads
        public final void destroyGlContext(@NotNull final GlThreadRunner glThreadRunner) {
            Intrinsics.checkNotNullParameter((Object)glThreadRunner, "glThreadRunner");
            destroyGlContext$default(this, glThreadRunner, false, 2, null);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\r\u0010\u0004\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\u0006J\r\u0010\u0007\u001a\u00020\u0005H\u0000¢\u0006\u0002\b\b¨\u0006\t" }, d2 = { "Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "Lly/img/android/pesdk/utils/WeakCallSet;", "Lly/img/android/opengl/canvas/GlObject;", "()V", "reboundGlContext", "", "reboundGlContext$pesdk_backend_core_release", "releaseGlContext", "releaseGlContext$pesdk_backend_core_release", "pesdk-backend-core_release" })
    public static final class GlObjectCallSet extends WeakCallSet<GlObject>
    {
        public final void releaseGlContext$pesdk_backend_core_release() {
            final Iterable $this$forEach$iv = this;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final GlObject it = (GlObject)element$iv;
                final int n = 0;
                GlObject.queueDestroy$default(it, false, 1, null);
            }
        }
        
        public final void reboundGlContext$pesdk_backend_core_release() {
            final Iterable $this$forEach$iv = this;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final GlObject it = (GlObject)element$iv;
                final int n = 0;
                it.queueRebound();
            }
        }
    }
}
