// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import android.opengl.EGL14;
import kotlin.Unit;
import kotlin.reflect.KProperty;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.WeakHashMap;
import javax.microedition.khronos.egl.EGL;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.JvmStatic;
import javax.microedition.khronos.egl.EGLContext;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import javax.microedition.khronos.egl.EGL10;
import javax.microedition.khronos.egl.EGLSurface;
import javax.microedition.khronos.egl.EGLDisplay;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0002\u001a\u001bB\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0017\u001a\u00020\u000fJ\u0010\u0010\u0017\u001a\u00020\u000f2\u0006\u0010\u0018\u001a\u00020\u000fH\u0002J\b\u0010\u0019\u001a\u00020\u0016H\u0002R\u000e\u0010\n\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u000e\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001c" }, d2 = { "Lly/img/android/opengl/canvas/GlMakeCurrent;", "", "eglDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;)V", "Landroid/opengl/EGLDisplay;", "Landroid/opengl/EGLSurface;", "(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;)V", "egl10Display", "egl10Surface", "egl14Display", "egl14Surface", "isActive", "", "()Z", "setActive", "(Z)V", "oldState", "useEgl14", "disable", "", "enable", "setChainState", "setCurrent", "Companion", "ThreadBound", "pesdk-backend-core_release" })
@WorkerThread
public final class GlMakeCurrent
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private GlMakeCurrent oldState;
    private boolean isActive;
    @NotNull
    private EGLDisplay egl10Display;
    @NotNull
    private EGLSurface egl10Surface;
    @Nullable
    private android.opengl.EGLDisplay egl14Display;
    @Nullable
    private android.opengl.EGLSurface egl14Surface;
    private final boolean useEgl14;
    @NotNull
    private static final EGL10 EGL;
    @NotNull
    private static final ThreadBound<GlMakeCurrent> glCurrent$delegate;
    
    public final boolean isActive() {
        return this.isActive;
    }
    
    public final void setActive(final boolean <set-?>) {
        this.isActive = <set-?>;
    }
    
    public GlMakeCurrent(@NotNull final EGLDisplay eglDisplay, @NotNull final EGLSurface eglSurface) {
        Intrinsics.checkNotNullParameter((Object)eglDisplay, "eglDisplay");
        Intrinsics.checkNotNullParameter((Object)eglSurface, "eglSurface");
        final EGLDisplay egl_NO_DISPLAY = EGL10.EGL_NO_DISPLAY;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.egl10Display = egl_NO_DISPLAY;
        final EGLSurface egl_NO_SURFACE = EGL10.EGL_NO_SURFACE;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_SURFACE, "EGL_NO_SURFACE");
        this.egl10Surface = egl_NO_SURFACE;
        this.egl10Display = eglDisplay;
        this.egl10Surface = eglSurface;
        this.useEgl14 = false;
    }
    
    public GlMakeCurrent(@NotNull final android.opengl.EGLDisplay eglDisplay, @NotNull final android.opengl.EGLSurface eglSurface) {
        Intrinsics.checkNotNullParameter((Object)eglDisplay, "eglDisplay");
        Intrinsics.checkNotNullParameter((Object)eglSurface, "eglSurface");
        final EGLDisplay egl_NO_DISPLAY = EGL10.EGL_NO_DISPLAY;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.egl10Display = egl_NO_DISPLAY;
        final EGLSurface egl_NO_SURFACE = EGL10.EGL_NO_SURFACE;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_SURFACE, "EGL_NO_SURFACE");
        this.egl10Surface = egl_NO_SURFACE;
        this.egl14Display = eglDisplay;
        this.egl14Surface = eglSurface;
        this.useEgl14 = true;
    }
    
    public final boolean enable() {
        return this.enable(true);
    }
    
    private final boolean enable(final boolean setChainState) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.isActive:Z
        //     4: ifne            148
        //     7: aload_0         /* this */
        //     8: iconst_1       
        //     9: putfield        ly/img/android/opengl/canvas/GlMakeCurrent.isActive:Z
        //    12: iload_1         /* setChainState */
        //    13: ifeq            52
        //    16: aload_0         /* this */
        //    17: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
        //    20: invokestatic    ly/img/android/opengl/canvas/GlMakeCurrent$Companion.access$getGlCurrent:(Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;)Lly/img/android/opengl/canvas/GlMakeCurrent;
        //    23: dup            
        //    24: ifnull          47
        //    27: astore_2       
        //    28: aload_2        
        //    29: astore_3       
        //    30: astore          5
        //    32: iconst_0       
        //    33: istore          $i$a$-apply-GlMakeCurrent$enable$1
        //    35: aload_3         /* $this$enable_u24lambda_u2d0 */
        //    36: iconst_0       
        //    37: putfield        ly/img/android/opengl/canvas/GlMakeCurrent.isActive:Z
        //    40: nop            
        //    41: aload           5
        //    43: aload_2        
        //    44: goto            49
        //    47: pop            
        //    48: aconst_null    
        //    49: putfield        ly/img/android/opengl/canvas/GlMakeCurrent.oldState:Lly/img/android/opengl/canvas/GlMakeCurrent;
        //    52: aload_0         /* this */
        //    53: invokespecial   ly/img/android/opengl/canvas/GlMakeCurrent.setCurrent:()V
        //    56: invokestatic    android/opengl/GLES20.glFlush:()V
        //    59: aload_0         /* this */
        //    60: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.useEgl14:Z
        //    63: ifeq            104
        //    66: aload_0         /* this */
        //    67: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl14Surface:Landroid/opengl/EGLSurface;
        //    70: getstatic       android/opengl/EGL14.EGL_NO_SURFACE:Landroid/opengl/EGLSurface;
        //    73: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    76: ifne            100
        //    79: aload_0         /* this */
        //    80: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl14Display:Landroid/opengl/EGLDisplay;
        //    83: aload_0         /* this */
        //    84: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl14Surface:Landroid/opengl/EGLSurface;
        //    87: aload_0         /* this */
        //    88: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl14Surface:Landroid/opengl/EGLSurface;
        //    91: invokestatic    android/opengl/EGL14.eglGetCurrentContext:()Landroid/opengl/EGLContext;
        //    94: invokestatic    android/opengl/EGL14.eglMakeCurrent:(Landroid/opengl/EGLDisplay;Landroid/opengl/EGLSurface;Landroid/opengl/EGLSurface;Landroid/opengl/EGLContext;)Z
        //    97: goto            147
        //   100: iconst_1       
        //   101: goto            147
        //   104: aload_0         /* this */
        //   105: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl10Surface:Ljavax/microedition/khronos/egl/EGLSurface;
        //   108: getstatic       javax/microedition/khronos/egl/EGL10.EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;
        //   111: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   114: ifne            146
        //   117: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.EGL:Ljavax/microedition/khronos/egl/EGL10;
        //   120: aload_0         /* this */
        //   121: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl10Display:Ljavax/microedition/khronos/egl/EGLDisplay;
        //   124: aload_0         /* this */
        //   125: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl10Surface:Ljavax/microedition/khronos/egl/EGLSurface;
        //   128: aload_0         /* this */
        //   129: getfield        ly/img/android/opengl/canvas/GlMakeCurrent.egl10Surface:Ljavax/microedition/khronos/egl/EGLSurface;
        //   132: getstatic       ly/img/android/opengl/canvas/GlMakeCurrent.Companion:Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;
        //   135: invokevirtual   ly/img/android/opengl/canvas/GlMakeCurrent$Companion.getEgl10Context:()Ljavax/microedition/khronos/egl/EGLContext;
        //   138: invokeinterface javax/microedition/khronos/egl/EGL10.eglMakeCurrent:(Ljavax/microedition/khronos/egl/EGLDisplay;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLSurface;Ljavax/microedition/khronos/egl/EGLContext;)Z
        //   143: goto            147
        //   146: iconst_1       
        //   147: ireturn        
        //   148: new             Ljava/lang/IllegalStateException;
        //   151: dup            
        //   152: new             Ljava/lang/StringBuilder;
        //   155: dup            
        //   156: invokespecial   java/lang/StringBuilder.<init>:()V
        //   159: ldc             "GlCurrent already enabled. "
        //   161: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   164: aload_0         /* this */
        //   165: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/Object;)Ljava/lang/StringBuilder;
        //   168: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   171: invokespecial   java/lang/IllegalStateException.<init>:(Ljava/lang/String;)V
        //   174: athrow         
        //    StackMapTable: 00 08 FF 00 2F 00 02 07 00 02 01 00 02 07 00 02 07 00 02 FF 00 01 00 02 07 00 02 01 00 02 07 00 02 07 00 02 02 2F 03 29 40 01 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
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
    
    public final void disable() {
        if (this.isActive) {
            GlMakeCurrent.Companion.setGlCurrent(null);
            this.isActive = false;
            final GlMakeCurrent oldState = this.oldState;
            if (oldState != null) {
                final GlMakeCurrent $this$disable_u24lambda_u2d1 = oldState;
                final int n = 0;
                $this$disable_u24lambda_u2d1.enable(false);
                $this$disable_u24lambda_u2d1.setCurrent();
            }
        }
        else {
            Log.e("PESDK", "You tried to disable GlMakeCurrent in wrong order");
        }
    }
    
    private final void setCurrent() {
        GlMakeCurrent.Companion.setGlCurrent(this);
    }
    
    @JvmStatic
    @WorkerThread
    @NotNull
    public static final EGLContext getEgl10Context() {
        return GlMakeCurrent.Companion.getEgl10Context();
    }
    
    @JvmStatic
    @WorkerThread
    @NotNull
    public static final android.opengl.EGLSurface getEgl14SurfaceId() {
        return GlMakeCurrent.Companion.getEgl14SurfaceId();
    }
    
    @JvmStatic
    @WorkerThread
    @NotNull
    public static final GlThreadRunner getGLThreadRunner() {
        return GlMakeCurrent.Companion.getGLThreadRunner();
    }
    
    @JvmStatic
    @WorkerThread
    public static final boolean hasEglContext() {
        return GlMakeCurrent.Companion.hasEglContext();
    }
    
    public static final /* synthetic */ ThreadBound access$getGlCurrent$delegate$cp() {
        return GlMakeCurrent.glCurrent$delegate;
    }
    
    public static final /* synthetic */ android.opengl.EGLSurface access$getEgl14Surface$p(final GlMakeCurrent $this) {
        return $this.egl14Surface;
    }
    
    static {
        Companion = new Companion(null);
        final EGL egl = EGLContext.getEGL();
        if (egl == null) {
            throw new NullPointerException("null cannot be cast to non-null type javax.microedition.khronos.egl.EGL10");
        }
        EGL = (EGL10)egl;
        glCurrent$delegate = new ThreadBound<GlMakeCurrent>((kotlin.jvm.functions.Function0<? extends GlMakeCurrent>)GlMakeCurrent$Companion$glCurrent.GlMakeCurrent$Companion$glCurrent$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\"\u0010\r\u001a\u00028\u00002\u0006\u0010\u000e\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002¢\u0006\u0002\u0010\u0011J*\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\u0014\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u0015R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\n\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0006\u0012\u0004\u0018\u00018\u00000\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Lly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound;", "T", "", "initValue", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "getInitValue", "()Lkotlin/jvm/functions/Function0;", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "valueMap", "Ljava/util/WeakHashMap;", "Ljava/lang/Thread;", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
    public static final class ThreadBound<T>
    {
        @NotNull
        private final Function0<T> initValue;
        @NotNull
        private WeakHashMap<Thread, T> valueMap;
        @NotNull
        private final ReentrantReadWriteLock lock;
        
        public ThreadBound(@NotNull final Function0<? extends T> initValue) {
            Intrinsics.checkNotNullParameter((Object)initValue, "initValue");
            this.initValue = (Function0<T>)initValue;
            this.valueMap = new WeakHashMap<Thread, T>();
            this.lock = new ReentrantReadWriteLock(true);
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
            //    12: invokestatic    java/lang/Thread.currentThread:()Ljava/lang/Thread;
            //    15: astore_3        /* context */
            //    16: aload_0         /* this */
            //    17: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //    20: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //    23: astore          5
            //    25: aload           5
            //    27: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //    30: nop            
            //    31: iconst_0       
            //    32: istore          $i$a$-read-GlMakeCurrent$ThreadBound$getValue$1
            //    34: aload_0         /* this */
            //    35: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.valueMap:Ljava/util/WeakHashMap;
            //    38: aload_3         /* context */
            //    39: invokevirtual   java/util/WeakHashMap.containsKey:(Ljava/lang/Object;)Z
            //    42: ifeq            63
            //    45: aload_0         /* this */
            //    46: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.valueMap:Ljava/util/WeakHashMap;
            //    49: aload_3         /* context */
            //    50: invokevirtual   java/util/WeakHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //    53: astore          7
            //    55: aload           5
            //    57: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    60: aload           7
            //    62: areturn        
            //    63: nop            
            //    64: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
            //    67: astore          6
            //    69: aload           5
            //    71: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    74: goto            87
            //    77: astore          6
            //    79: aload           5
            //    81: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //    84: aload           6
            //    86: athrow         
            //    87: aload_0         /* this */
            //    88: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
            //    91: astore          4
            //    93: aload           4
            //    95: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
            //    98: astore          5
            //   100: aload           4
            //   102: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
            //   105: ifne            116
            //   108: aload           4
            //   110: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
            //   113: goto            117
            //   116: iconst_0       
            //   117: istore          6
            //   119: iconst_0       
            //   120: istore          7
            //   122: iload           7
            //   124: iload           6
            //   126: if_icmpge       140
            //   129: aload           5
            //   131: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
            //   134: iinc            7, 1
            //   137: goto            122
            //   140: aload           4
            //   142: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
            //   145: astore          7
            //   147: aload           7
            //   149: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
            //   152: nop            
            //   153: iconst_0       
            //   154: istore          $i$a$-write-GlMakeCurrent$ThreadBound$getValue$2
            //   156: aload_0         /* this */
            //   157: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.valueMap:Ljava/util/WeakHashMap;
            //   160: aload_3         /* context */
            //   161: invokevirtual   java/util/WeakHashMap.containsKey:(Ljava/lang/Object;)Z
            //   164: ifne            190
            //   167: aload_0         /* this */
            //   168: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.valueMap:Ljava/util/WeakHashMap;
            //   171: checkcast       Ljava/util/Map;
            //   174: aload_3         /* context */
            //   175: aload_0         /* this */
            //   176: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.initValue:Lkotlin/jvm/functions/Function0;
            //   179: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
            //   184: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
            //   189: pop            
            //   190: aload_0         /* this */
            //   191: getfield        ly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound.valueMap:Ljava/util/WeakHashMap;
            //   194: aload_3         /* context */
            //   195: invokevirtual   java/util/WeakHashMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
            //   198: astore          null
            //   200: iconst_0       
            //   201: istore          9
            //   203: iload           9
            //   205: iload           6
            //   207: if_icmpge       221
            //   210: aload           5
            //   212: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   215: iinc            9, 1
            //   218: goto            203
            //   221: aload           7
            //   223: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   226: aload           8
            //   228: goto            262
            //   231: astore          8
            //   233: iconst_0       
            //   234: istore          9
            //   236: iload           9
            //   238: iload           6
            //   240: if_icmpge       254
            //   243: aload           5
            //   245: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
            //   248: iinc            9, 1
            //   251: goto            236
            //   254: aload           7
            //   256: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
            //   259: aload           8
            //   261: athrow         
            //   262: areturn        
            //    Signature:
            //  (Ljava/lang/Object;Lkotlin/reflect/KProperty<*>;)TT;
            //    StackMapTable: 00 0E FF 00 3F 00 07 07 00 02 07 00 05 07 00 76 07 00 35 00 07 00 3F 01 00 00 FF 00 0D 00 06 07 00 02 07 00 05 07 00 76 07 00 35 00 07 00 3F 00 01 07 00 78 FC 00 09 07 00 4E FF 00 1C 00 07 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 07 00 4E 00 00 40 01 FF 00 04 00 08 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 01 01 00 00 11 FF 00 31 00 09 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 01 07 00 5F 01 00 00 FF 00 0C 00 0A 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 01 07 00 5F 07 00 05 01 00 00 11 FF 00 09 00 08 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 01 07 00 5F 00 01 07 00 78 FD 00 04 07 00 78 01 11 FF 00 07 00 0A 07 00 02 07 00 05 07 00 76 07 00 35 07 00 20 07 00 3F 01 07 00 5F 07 00 05 01 00 01 07 00 05
            //    Exceptions:
            //  Try           Handler
            //  Start  End    Start  End    Type
            //  -----  -----  -----  -----  ----
            //  30     55     77     87     Any
            //  63     69     77     87     Any
            //  77     79     77     87     Any
            //  152    200    231    262    Any
            //  231    233    231    262    Any
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
            final Thread context = Thread.currentThread();
            final ReentrantReadWriteLock lock = this.lock;
            final ReentrantReadWriteLock.ReadLock lock2 = lock.readLock();
            final int n = (lock.getWriteHoldCount() == 0) ? lock.getReadHoldCount() : 0;
            for (int i = 0; i < n; ++i) {
                lock2.unlock();
            }
            final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
            writeLock.lock();
            try {
                final int n2 = 0;
                this.valueMap.put(context, value);
                final Unit instance = Unit.INSTANCE;
            }
            finally {
                for (int j = 0; j < n; ++j) {
                    lock2.lock();
                }
                writeLock.unlock();
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\b\u0010\u0010\u001a\u00020\u0011H\u0007J\b\u0010\u0012\u001a\u00020\u0013H\u0007J\b\u0010\u0014\u001a\u00020\u0015H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R/\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u00068B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\f\u0010\r\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016" }, d2 = { "Lly/img/android/opengl/canvas/GlMakeCurrent$Companion;", "", "()V", "EGL", "Ljavax/microedition/khronos/egl/EGL10;", "<set-?>", "Lly/img/android/opengl/canvas/GlMakeCurrent;", "glCurrent", "getGlCurrent", "()Lly/img/android/opengl/canvas/GlMakeCurrent;", "setGlCurrent", "(Lly/img/android/opengl/canvas/GlMakeCurrent;)V", "glCurrent$delegate", "Lly/img/android/opengl/canvas/GlMakeCurrent$ThreadBound;", "getEgl10Context", "Ljavax/microedition/khronos/egl/EGLContext;", "getEgl14SurfaceId", "Landroid/opengl/EGLSurface;", "getGLThreadRunner", "Lly/img/android/opengl/GlThreadRunner;", "hasEglContext", "", "pesdk-backend-core_release" })
    public static final class Companion
    {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        
        private Companion() {
        }
        
        private final GlMakeCurrent getGlCurrent() {
            return GlMakeCurrent.access$getGlCurrent$delegate$cp().getValue(this, Companion.$$delegatedProperties[0]);
        }
        
        private final void setGlCurrent(final GlMakeCurrent <set-?>) {
            GlMakeCurrent.access$getGlCurrent$delegate$cp().setValue(this, Companion.$$delegatedProperties[0], <set-?>);
        }
        
        @JvmStatic
        @WorkerThread
        @NotNull
        public final EGLContext getEgl10Context() {
            final Thread currentThread = Thread.currentThread();
            if (currentThread == null) {
                throw new NullPointerException("null cannot be cast to non-null type ly.img.android.opengl.GlThreadRunner");
            }
            return ((GlThreadRunner)currentThread).getEglContext();
        }
        
        @JvmStatic
        @WorkerThread
        @NotNull
        public final android.opengl.EGLSurface getEgl14SurfaceId() {
            final GlMakeCurrent glCurrent = this.getGlCurrent();
            android.opengl.EGLSurface eglSurface;
            if (glCurrent == null || (eglSurface = GlMakeCurrent.access$getEgl14Surface$p(glCurrent)) == null) {
                Intrinsics.checkNotNullExpressionValue((Object)(eglSurface = EGL14.EGL_NO_SURFACE), "EGL_NO_SURFACE");
            }
            return eglSurface;
        }
        
        @JvmStatic
        @WorkerThread
        @NotNull
        public final GlThreadRunner getGLThreadRunner() {
            final Thread currentThread = Thread.currentThread();
            if (currentThread == null) {
                throw new NullPointerException("null cannot be cast to non-null type ly.img.android.opengl.GlThreadRunner");
            }
            return (GlThreadRunner)currentThread;
        }
        
        @JvmStatic
        @WorkerThread
        public final boolean hasEglContext() {
            return !Intrinsics.areEqual((Object)this.getEgl10Context(), (Object)EGL10.EGL_NO_CONTEXT);
        }
        
        static {
            $$delegatedProperties = new KProperty[] { (KProperty)Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((Class)Companion.class, "glCurrent", "getGlCurrent()Lly/img/android/opengl/canvas/GlMakeCurrent;", 0)) };
        }
    }
}
