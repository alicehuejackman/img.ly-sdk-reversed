// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import kotlin.reflect.KProperty;
import kotlin.jvm.internal.DefaultConstructorMarker;
import android.util.Log;
import ly.img.android.pesdk.annotations.OnEvent;
import androidx.annotation.CallSuper;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import android.annotation.SuppressLint;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmOverloads;
import androidx.annotation.AnyThread;
import androidx.annotation.WorkerThread;
import java.util.Iterator;
import ly.img.android.pesdk.utils.ThreadUtils;
import ly.img.android.pesdk.backend.model.state.EditorShowState;
import android.util.AttributeSet;
import android.content.Context;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.Nullable;
import kotlin.Lazy;
import ly.img.android.pesdk.backend.model.state.manager.StateHandler;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import ly.img.android.pesdk.backend.model.state.manager.StateHandlerContext;
import android.view.SurfaceView;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\b&\u0018\u0000 J2\u00020\u00012\u00020\u0002:\u0003JKLB\u0011\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005B\u001b\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB#\b\u0016\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010;\u001a\u00020\rH\u0003J\b\u0010<\u001a\u00020\rH'J\u0010\u0010=\u001a\u00020>2\u0006\u00101\u001a\u000202H\u0015J\b\u0010?\u001a\u00020>H\u0015J\u0010\u0010@\u001a\u00020>2\u0006\u00101\u001a\u000202H\u0015J\b\u0010A\u001a\u00020>H\u0015J\b\u0010B\u001a\u00020>H'J\b\u0010C\u001a\u00020>H\u0005J\b\u0010D\u001a\u00020>H\u0005J\u0016\u0010E\u001a\u00020>2\f\u0010F\u001a\b\u0012\u0004\u0012\u00020>0GH\u0007J\u0010\u0010E\u001a\u00020>2\u0006\u0010F\u001a\u00020\u0013H\u0007J\u0012\u0010H\u001a\u00020>2\b\b\u0002\u0010I\u001a\u00020\rH\u0017R\u0014\u0010\f\u001a\u00020\rX\u0094D¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000R$\u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001cR\u001a\u0010\u001d\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u000f\"\u0004\b\u001e\u0010\u001fR\u000e\u0010 \u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020#X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010'\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0006\b\u0001\u0012\u00020*0)R\u00020\u00000(X\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010+\u001a\u00020,8DX\u0084\u0084\u0002¢\u0006\f\n\u0004\b/\u00100\u001a\u0004\b-\u0010.R\u0014\u00101\u001a\u000202X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b3\u00104R\u0014\u00105\u001a\u00020\u00118BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b6\u00107R\u001a\u00108\u001a\u00020\u0017X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b9\u0010\u001a\"\u0004\b:\u0010\u001c¨\u0006M" }, d2 = { "Lly/img/android/opengl/egl/GLSurfaceView;", "Landroid/view/SurfaceView;", "Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "allowBackgroundRender", "", "getAllowBackgroundRender", "()Z", "currentThread", "Lly/img/android/opengl/egl/GLThread;", "drawRunnable", "Ljava/lang/Runnable;", "eglSurfaceHandler", "Lly/img/android/opengl/egl/EGLSurfaceHandler;", "value", "", "frameRate", "getFrameRate", "()F", "setFrameRate", "(F)V", "isAttached", "setAttached", "(Z)V", "needBlocksInit", "needSetup", "renderInQueue", "Ljava/util/concurrent/atomic/AtomicBoolean;", "renderRequested", "renderTimeOut", "", "setupBlocks", "", "Lly/img/android/opengl/egl/GLSurfaceView$SetupInit;", "", "showState", "Lly/img/android/pesdk/backend/model/state/EditorShowState;", "getShowState", "()Lly/img/android/pesdk/backend/model/state/EditorShowState;", "showState$delegate", "Lkotlin/Lazy;", "stateHandler", "Lly/img/android/pesdk/backend/model/state/manager/StateHandler;", "getStateHandler", "()Lly/img/android/pesdk/backend/model/state/manager/StateHandler;", "thread", "getThread", "()Lly/img/android/opengl/egl/GLThread;", "uiDensity", "getUiDensity", "setUiDensity", "doSetup", "glSetup", "onAttachedToUI", "", "onAttachedToWindow", "onDetachedFromUI", "onDetachedFromWindow", "onDrawGl", "onPauseEvent", "onResumeEvent", "queueEvent", "r", "Lkotlin/Function0;", "render", "force", "Companion", "SetupInit", "UNINITIALIZED_VALUE", "pesdk-backend-core_release" })
public abstract class GLSurfaceView extends SurfaceView implements StateHandlerContext
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final StateHandler stateHandler;
    private volatile boolean isAttached;
    private final boolean allowBackgroundRender;
    private float uiDensity;
    @NotNull
    private final Lazy showState$delegate;
    @NotNull
    private final EGLSurfaceHandler eglSurfaceHandler;
    private boolean needSetup;
    private boolean needBlocksInit;
    @Nullable
    private GLThread currentThread;
    @NotNull
    private final Runnable drawRunnable;
    @NotNull
    private final AtomicBoolean renderRequested;
    @NotNull
    private final AtomicBoolean renderInQueue;
    private long renderTimeOut;
    @NotNull
    private final List<SetupInit<?>> setupBlocks;
    public static final long FRAME_RENDER_TIMEOUT_IN_MS = 2000L;
    
    public GLSurfaceView(@Nullable final Context context) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* context */
        //     2: invokespecial   android/view/SurfaceView.<init>:(Landroid/content/Context;)V
        //     5: aload_0         /* this */
        //     6: aload_0         /* this */
        //     7: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.isInEditMode:()Z
        //    10: ifeq            27
        //    13: new             Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    16: dup            
        //    17: aload_0         /* this */
        //    18: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    21: invokespecial   ly/img/android/pesdk/backend/model/state/manager/StateHandler.<init>:(Landroid/content/Context;)V
        //    24: goto            64
        //    27: astore          7
        //    29: nop            
        //    30: aload           7
        //    32: aload_0         /* this */
        //    33: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    36: invokestatic    ly/img/android/pesdk/backend/model/state/manager/StateHandler.findInViewContext:(Landroid/content/Context;)Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    39: astore_3       
        //    40: goto            57
        //    43: astore          4
        //    45: aload           7
        //    47: new             Ljava/lang/RuntimeException;
        //    50: dup            
        //    51: ldc             "This view need an ImgLyActivity"
        //    53: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    56: athrow         
        //    57: aload_3        
        //    58: dup            
        //    59: ldc             "try {\n        StateHandl\u2026 an ImgLyActivity\")\n    }"
        //    61: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    64: putfield        ly/img/android/opengl/egl/GLSurfaceView.stateHandler:Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    67: aload_0         /* this */
        //    68: aload_0         /* this */
        //    69: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getResources:()Landroid/content/res/Resources;
        //    72: invokevirtual   android/content/res/Resources.getDisplayMetrics:()Landroid/util/DisplayMetrics;
        //    75: getfield        android/util/DisplayMetrics.density:F
        //    78: putfield        ly/img/android/opengl/egl/GLSurfaceView.uiDensity:F
        //    81: aload_0         /* this */
        //    82: aload_0         /* this */
        //    83: checkcast       Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;
        //    86: astore_2        /* $this$stateHandlerResolve$iv */
        //    87: iconst_0       
        //    88: istore_3        /* $i$f$stateHandlerResolve */
        //    89: new             Lly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$1;
        //    92: dup            
        //    93: aload_2         /* $this$stateHandlerResolve$iv */
        //    94: invokespecial   ly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$1.<init>:(Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;)V
        //    97: checkcast       Lkotlin/jvm/functions/Function0;
        //   100: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //   103: putfield        ly/img/android/opengl/egl/GLSurfaceView.showState$delegate:Lkotlin/Lazy;
        //   106: aload_0         /* this */
        //   107: new             Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   110: dup            
        //   111: invokespecial   ly/img/android/opengl/egl/EGLSurfaceHandler.<init>:()V
        //   114: astore_2       
        //   115: aload_2        
        //   116: astore_3       
        //   117: astore          7
        //   119: iconst_0       
        //   120: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   122: iconst_0       
        //   123: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   125: iconst_0       
        //   126: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   128: aload_3         /* it */
        //   129: aload_0         /* this */
        //   130: checkcast       Landroid/view/View;
        //   133: invokevirtual   ly/img/android/opengl/egl/EGLSurfaceHandler.setUiSurface:(Landroid/view/View;)V
        //   136: nop            
        //   137: aload           7
        //   139: aload_2        
        //   140: putfield        ly/img/android/opengl/egl/GLSurfaceView.eglSurfaceHandler:Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   143: aload_0         /* this */
        //   144: iconst_1       
        //   145: putfield        ly/img/android/opengl/egl/GLSurfaceView.needSetup:Z
        //   148: aload_0         /* this */
        //   149: iconst_1       
        //   150: putfield        ly/img/android/opengl/egl/GLSurfaceView.needBlocksInit:Z
        //   153: aload_0         /* this */
        //   154: aload_0         /* this */
        //   155: invokedynamic   BootstrapMethod #0, run:(Lly/img/android/opengl/egl/GLSurfaceView;)Ljava/lang/Runnable;
        //   160: putfield        ly/img/android/opengl/egl/GLSurfaceView.drawRunnable:Ljava/lang/Runnable;
        //   163: aload_0         /* this */
        //   164: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   167: dup            
        //   168: iconst_0       
        //   169: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   172: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderRequested:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   175: aload_0         /* this */
        //   176: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   179: dup            
        //   180: iconst_0       
        //   181: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   184: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderInQueue:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   187: aload_0         /* this */
        //   188: new             Ljava/util/ArrayList;
        //   191: dup            
        //   192: invokespecial   java/util/ArrayList.<init>:()V
        //   195: checkcast       Ljava/util/List;
        //   198: putfield        ly/img/android/opengl/egl/GLSurfaceView.setupBlocks:Ljava/util/List;
        //   201: return         
        //    StackMapTable: 00 04 FF 00 1B 00 02 07 00 02 07 00 A1 00 01 07 00 02 FF 00 0F 00 08 07 00 02 07 00 A1 00 00 00 00 00 07 00 02 00 01 07 00 0B FF 00 0D 00 08 07 00 02 07 00 A1 00 07 00 13 00 00 00 07 00 02 00 01 07 00 02 FF 00 06 00 02 07 00 02 07 00 A1 00 02 07 00 02 07 00 13
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                                         
        //  -----  -----  -----  -----  ---------------------------------------------------------------------------------------------
        //  29     40     43     57     Lly/img/android/pesdk/backend/model/state/manager/StateHandler$StateHandlerNotFoundException;
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    public GLSurfaceView(@Nullable final Context context, @Nullable final AttributeSet attrs) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* context */
        //     2: aload_2         /* attrs */
        //     3: invokespecial   android/view/SurfaceView.<init>:(Landroid/content/Context;Landroid/util/AttributeSet;)V
        //     6: aload_0         /* this */
        //     7: aload_0         /* this */
        //     8: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.isInEditMode:()Z
        //    11: ifeq            28
        //    14: new             Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    17: dup            
        //    18: aload_0         /* this */
        //    19: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    22: invokespecial   ly/img/android/pesdk/backend/model/state/manager/StateHandler.<init>:(Landroid/content/Context;)V
        //    25: goto            67
        //    28: astore          8
        //    30: nop            
        //    31: aload           8
        //    33: aload_0         /* this */
        //    34: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    37: invokestatic    ly/img/android/pesdk/backend/model/state/manager/StateHandler.findInViewContext:(Landroid/content/Context;)Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    40: astore          4
        //    42: goto            59
        //    45: astore          5
        //    47: aload           8
        //    49: new             Ljava/lang/RuntimeException;
        //    52: dup            
        //    53: ldc             "This view need an ImgLyActivity"
        //    55: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    58: athrow         
        //    59: aload           4
        //    61: dup            
        //    62: ldc             "try {\n        StateHandl\u2026 an ImgLyActivity\")\n    }"
        //    64: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    67: putfield        ly/img/android/opengl/egl/GLSurfaceView.stateHandler:Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    70: aload_0         /* this */
        //    71: aload_0         /* this */
        //    72: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getResources:()Landroid/content/res/Resources;
        //    75: invokevirtual   android/content/res/Resources.getDisplayMetrics:()Landroid/util/DisplayMetrics;
        //    78: getfield        android/util/DisplayMetrics.density:F
        //    81: putfield        ly/img/android/opengl/egl/GLSurfaceView.uiDensity:F
        //    84: aload_0         /* this */
        //    85: aload_0         /* this */
        //    86: checkcast       Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;
        //    89: astore_3        /* $this$stateHandlerResolve$iv */
        //    90: iconst_0       
        //    91: istore          $i$f$stateHandlerResolve
        //    93: new             Lly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$2;
        //    96: dup            
        //    97: aload_3         /* $this$stateHandlerResolve$iv */
        //    98: invokespecial   ly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$2.<init>:(Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;)V
        //   101: checkcast       Lkotlin/jvm/functions/Function0;
        //   104: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //   107: putfield        ly/img/android/opengl/egl/GLSurfaceView.showState$delegate:Lkotlin/Lazy;
        //   110: aload_0         /* this */
        //   111: new             Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   114: dup            
        //   115: invokespecial   ly/img/android/opengl/egl/EGLSurfaceHandler.<init>:()V
        //   118: astore_3       
        //   119: aload_3        
        //   120: astore          4
        //   122: astore          8
        //   124: iconst_0       
        //   125: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   127: iconst_0       
        //   128: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   130: iconst_0       
        //   131: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   133: aload           it
        //   135: aload_0         /* this */
        //   136: checkcast       Landroid/view/View;
        //   139: invokevirtual   ly/img/android/opengl/egl/EGLSurfaceHandler.setUiSurface:(Landroid/view/View;)V
        //   142: nop            
        //   143: aload           8
        //   145: aload_3        
        //   146: putfield        ly/img/android/opengl/egl/GLSurfaceView.eglSurfaceHandler:Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   149: aload_0         /* this */
        //   150: iconst_1       
        //   151: putfield        ly/img/android/opengl/egl/GLSurfaceView.needSetup:Z
        //   154: aload_0         /* this */
        //   155: iconst_1       
        //   156: putfield        ly/img/android/opengl/egl/GLSurfaceView.needBlocksInit:Z
        //   159: aload_0         /* this */
        //   160: aload_0         /* this */
        //   161: invokedynamic   BootstrapMethod #0, run:(Lly/img/android/opengl/egl/GLSurfaceView;)Ljava/lang/Runnable;
        //   166: putfield        ly/img/android/opengl/egl/GLSurfaceView.drawRunnable:Ljava/lang/Runnable;
        //   169: aload_0         /* this */
        //   170: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   173: dup            
        //   174: iconst_0       
        //   175: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   178: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderRequested:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   181: aload_0         /* this */
        //   182: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   185: dup            
        //   186: iconst_0       
        //   187: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   190: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderInQueue:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   193: aload_0         /* this */
        //   194: new             Ljava/util/ArrayList;
        //   197: dup            
        //   198: invokespecial   java/util/ArrayList.<init>:()V
        //   201: checkcast       Ljava/util/List;
        //   204: putfield        ly/img/android/opengl/egl/GLSurfaceView.setupBlocks:Ljava/util/List;
        //   207: return         
        //    StackMapTable: 00 04 FF 00 1C 00 03 07 00 02 07 00 A1 07 00 AB 00 01 07 00 02 FF 00 10 00 09 07 00 02 07 00 A1 07 00 AB 00 00 00 00 00 07 00 02 00 01 07 00 0B FF 00 0D 00 09 07 00 02 07 00 A1 07 00 AB 00 07 00 13 00 00 00 07 00 02 00 01 07 00 02 FF 00 07 00 03 07 00 02 07 00 A1 07 00 AB 00 02 07 00 02 07 00 13
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                                         
        //  -----  -----  -----  -----  ---------------------------------------------------------------------------------------------
        //  30     42     45     59     Lly/img/android/pesdk/backend/model/state/manager/StateHandler$StateHandlerNotFoundException;
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    public GLSurfaceView(@Nullable final Context context, @Nullable final AttributeSet attrs, final int defStyleAttr) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aload_1         /* context */
        //     2: aload_2         /* attrs */
        //     3: iload_3         /* defStyleAttr */
        //     4: invokespecial   android/view/SurfaceView.<init>:(Landroid/content/Context;Landroid/util/AttributeSet;I)V
        //     7: aload_0         /* this */
        //     8: aload_0         /* this */
        //     9: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.isInEditMode:()Z
        //    12: ifeq            29
        //    15: new             Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    18: dup            
        //    19: aload_0         /* this */
        //    20: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    23: invokespecial   ly/img/android/pesdk/backend/model/state/manager/StateHandler.<init>:(Landroid/content/Context;)V
        //    26: goto            68
        //    29: astore          9
        //    31: nop            
        //    32: aload           9
        //    34: aload_0         /* this */
        //    35: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getContext:()Landroid/content/Context;
        //    38: invokestatic    ly/img/android/pesdk/backend/model/state/manager/StateHandler.findInViewContext:(Landroid/content/Context;)Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    41: astore          5
        //    43: goto            60
        //    46: astore          6
        //    48: aload           9
        //    50: new             Ljava/lang/RuntimeException;
        //    53: dup            
        //    54: ldc             "This view need an ImgLyActivity"
        //    56: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    59: athrow         
        //    60: aload           5
        //    62: dup            
        //    63: ldc             "try {\n        StateHandl\u2026 an ImgLyActivity\")\n    }"
        //    65: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    68: putfield        ly/img/android/opengl/egl/GLSurfaceView.stateHandler:Lly/img/android/pesdk/backend/model/state/manager/StateHandler;
        //    71: aload_0         /* this */
        //    72: aload_0         /* this */
        //    73: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getResources:()Landroid/content/res/Resources;
        //    76: invokevirtual   android/content/res/Resources.getDisplayMetrics:()Landroid/util/DisplayMetrics;
        //    79: getfield        android/util/DisplayMetrics.density:F
        //    82: putfield        ly/img/android/opengl/egl/GLSurfaceView.uiDensity:F
        //    85: aload_0         /* this */
        //    86: aload_0         /* this */
        //    87: checkcast       Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;
        //    90: astore          $this$stateHandlerResolve$iv
        //    92: iconst_0       
        //    93: istore          $i$f$stateHandlerResolve
        //    95: new             Lly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$3;
        //    98: dup            
        //    99: aload           $this$stateHandlerResolve$iv
        //   101: invokespecial   ly/img/android/opengl/egl/GLSurfaceView$special$$inlined$stateHandlerResolve$3.<init>:(Lly/img/android/pesdk/backend/model/state/manager/StateHandlerContext;)V
        //   104: checkcast       Lkotlin/jvm/functions/Function0;
        //   107: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //   110: putfield        ly/img/android/opengl/egl/GLSurfaceView.showState$delegate:Lkotlin/Lazy;
        //   113: aload_0         /* this */
        //   114: new             Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   117: dup            
        //   118: invokespecial   ly/img/android/opengl/egl/EGLSurfaceHandler.<init>:()V
        //   121: astore          4
        //   123: aload           4
        //   125: astore          5
        //   127: astore          9
        //   129: iconst_0       
        //   130: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   132: iconst_0       
        //   133: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   135: iconst_0       
        //   136: istore          $i$a$-also-GLSurfaceView$eglSurfaceHandler$1
        //   138: aload           it
        //   140: aload_0         /* this */
        //   141: checkcast       Landroid/view/View;
        //   144: invokevirtual   ly/img/android/opengl/egl/EGLSurfaceHandler.setUiSurface:(Landroid/view/View;)V
        //   147: nop            
        //   148: aload           9
        //   150: aload           4
        //   152: putfield        ly/img/android/opengl/egl/GLSurfaceView.eglSurfaceHandler:Lly/img/android/opengl/egl/EGLSurfaceHandler;
        //   155: aload_0         /* this */
        //   156: iconst_1       
        //   157: putfield        ly/img/android/opengl/egl/GLSurfaceView.needSetup:Z
        //   160: aload_0         /* this */
        //   161: iconst_1       
        //   162: putfield        ly/img/android/opengl/egl/GLSurfaceView.needBlocksInit:Z
        //   165: aload_0         /* this */
        //   166: aload_0         /* this */
        //   167: invokedynamic   BootstrapMethod #0, run:(Lly/img/android/opengl/egl/GLSurfaceView;)Ljava/lang/Runnable;
        //   172: putfield        ly/img/android/opengl/egl/GLSurfaceView.drawRunnable:Ljava/lang/Runnable;
        //   175: aload_0         /* this */
        //   176: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   179: dup            
        //   180: iconst_0       
        //   181: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   184: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderRequested:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   187: aload_0         /* this */
        //   188: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   191: dup            
        //   192: iconst_0       
        //   193: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   196: putfield        ly/img/android/opengl/egl/GLSurfaceView.renderInQueue:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   199: aload_0         /* this */
        //   200: new             Ljava/util/ArrayList;
        //   203: dup            
        //   204: invokespecial   java/util/ArrayList.<init>:()V
        //   207: checkcast       Ljava/util/List;
        //   210: putfield        ly/img/android/opengl/egl/GLSurfaceView.setupBlocks:Ljava/util/List;
        //   213: return         
        //    StackMapTable: 00 04 FF 00 1D 00 04 07 00 02 07 00 A1 07 00 AB 01 00 01 07 00 02 FF 00 10 00 0A 07 00 02 07 00 A1 07 00 AB 01 00 00 00 00 00 07 00 02 00 01 07 00 0B FF 00 0D 00 0A 07 00 02 07 00 A1 07 00 AB 01 00 07 00 13 00 00 00 07 00 02 00 01 07 00 02 FF 00 07 00 04 07 00 02 07 00 A1 07 00 AB 01 00 02 07 00 02 07 00 13
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                                         
        //  -----  -----  -----  -----  ---------------------------------------------------------------------------------------------
        //  31     43     46     60     Lly/img/android/pesdk/backend/model/state/manager/StateHandler$StateHandlerNotFoundException;
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    @NotNull
    public StateHandler getStateHandler() {
        return this.stateHandler;
    }
    
    public final boolean isAttached() {
        return this.isAttached;
    }
    
    public final void setAttached(final boolean <set-?>) {
        this.isAttached = <set-?>;
    }
    
    protected boolean getAllowBackgroundRender() {
        return this.allowBackgroundRender;
    }
    
    protected final float getUiDensity() {
        return this.uiDensity;
    }
    
    protected final void setUiDensity(final float <set-?>) {
        this.uiDensity = <set-?>;
    }
    
    @NotNull
    protected final EditorShowState getShowState() {
        return (EditorShowState)this.showState$delegate.getValue();
    }
    
    public final float getFrameRate() {
        return this.eglSurfaceHandler.getFrameRate();
    }
    
    public final void setFrameRate(final float value) {
        this.eglSurfaceHandler.setFrameRate(value);
    }
    
    private final GLThread getThread() {
        final GLThread currentThread = this.currentThread;
        GLThread glThread;
        if (currentThread != null) {
            final GLThread it = currentThread;
            final int n = 0;
            glThread = (it.isAlive() ? it : null);
        }
        else {
            glThread = null;
        }
        GLThread thread = glThread;
        if (thread == null) {
            this.needBlocksInit = true;
            this.needSetup = true;
            thread = ThreadUtils.Companion.getGlRender();
            (this.currentThread = thread).setUncaughtExceptionHandler(GLSurfaceView::_get_thread_$lambda-3);
        }
        return thread;
    }
    
    @WorkerThread
    private final boolean doSetup() {
        boolean isSetupDone = true;
        if (this.needSetup) {
            if (this.needBlocksInit) {
                this.needBlocksInit = true;
                final Iterable $this$forEach$iv = this.setupBlocks;
                final int $i$f$forEach = 0;
                for (final Object element$iv : $this$forEach$iv) {
                    final SetupInit it = (SetupInit)element$iv;
                    final int n = 0;
                    it.init();
                }
            }
            isSetupDone = this.glSetup();
            this.needSetup = !isSetupDone;
        }
        return isSetupDone;
    }
    
    @AnyThread
    @JvmOverloads
    public void render(final boolean force) {
        if (this.renderRequested.compareAndSet(false, true) || force) {
            this.renderTimeOut = System.currentTimeMillis() + 2000L;
            this.queueEvent(this.drawRunnable);
        }
        else {
            this.renderInQueue.set(true);
        }
    }
    
    public static /* synthetic */ void render$default(final GLSurfaceView glSurfaceView, boolean force, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: render");
        }
        if ((n & 0x1) != 0x0) {
            force = (System.currentTimeMillis() > glSurfaceView.renderTimeOut);
        }
        glSurfaceView.render(force);
    }
    
    @SuppressLint({ "WrongThread" })
    @AnyThread
    public final void queueEvent(@NotNull final Runnable r) {
        Intrinsics.checkNotNullParameter((Object)r, "r");
        this.getThread().queueEvent(r);
    }
    
    @AnyThread
    public final void queueEvent(@NotNull final Function0<Unit> r) {
        Intrinsics.checkNotNullParameter((Object)r, "r");
        this.queueEvent(GLSurfaceView::queueEvent$lambda-8);
    }
    
    @WorkerThread
    public abstract boolean glSetup();
    
    @WorkerThread
    public abstract void onDrawGl();
    
    @CallSuper
    protected void onAttachedToUI(@NotNull final StateHandler stateHandler) {
        Intrinsics.checkNotNullParameter((Object)stateHandler, "stateHandler");
        this.render(true);
    }
    
    @CallSuper
    protected void onDetachedFromUI(@NotNull final StateHandler stateHandler) {
        Intrinsics.checkNotNullParameter((Object)stateHandler, "stateHandler");
        this.render(true);
    }
    
    @OnEvent(value = { "EditorShowState.PAUSE" }, ignoreReverts = true, doInitCall = false)
    protected final void onPauseEvent() {
        this.isAttached = false;
    }
    
    @OnEvent(value = { "EditorShowState.RESUME" }, ignoreReverts = true, doInitCall = false)
    protected final void onResumeEvent() {
        this.render(this.isAttached = true);
    }
    
    @CallSuper
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        this.isAttached = true;
        this.onAttachedToUI(this.getStateHandler());
        this.getStateHandler().registerSettingsEventListener(this);
        render$default(this, false, 1, null);
        this.postDelayed(GLSurfaceView::onAttachedToWindow$lambda-9, 2000L);
    }
    
    @CallSuper
    protected void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        this.isAttached = false;
        this.getStateHandler().unregisterSettingsEventListener(this);
        this.queueEvent((Function0<Unit>)new GLSurfaceView$onDetachedFromWindow.GLSurfaceView$onDetachedFromWindow$1(this));
        this.onDetachedFromUI(this.getStateHandler());
    }
    
    @AnyThread
    @JvmOverloads
    public final void render() {
        render$default(this, false, 1, null);
    }
    
    private static final void _get_thread_$lambda-3$lambda-2(final GLSurfaceView this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        this$0.render(true);
    }
    
    private static final void _get_thread_$lambda-3(final GLSurfaceView this$0, final Thread thread, final Throwable throwable) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        throwable.printStackTrace();
        this$0.post(GLSurfaceView::_get_thread_$lambda-3$lambda-2);
    }
    
    private static final void drawRunnable$lambda-7(final GLSurfaceView this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        final AtomicBoolean $this$setFalseIfTrueAndDo$iv = this$0.renderRequested;
        final int $i$f$setFalseIfTrueAndDo = 0;
        if ($this$setFalseIfTrueAndDo$iv.compareAndSet(true, false)) {
            final int n = 0;
            try {
                if (this$0.isAttached) {
                    if (this$0.eglSurfaceHandler.enable()) {
                        final boolean isSetupDone = this$0.doSetup();
                        if (isSetupDone) {
                            this$0.renderInQueue.set(false);
                            this$0.onDrawGl();
                            this$0.eglSurfaceHandler.swapBuffers();
                        }
                        else {
                            render$default(this$0, false, 1, null);
                        }
                    }
                    else {
                        render$default(this$0, false, 1, null);
                    }
                }
                else if (this$0.getAllowBackgroundRender()) {
                    final boolean isSetupDone = this$0.doSetup();
                    if (isSetupDone) {
                        this$0.onDrawGl();
                    }
                }
            }
            catch (IllegalStateException e) {
                Log.e("IMGLY", "eglSurfaceHandler is already enabled", (Throwable)e);
            }
            finally {
                if (this$0.eglSurfaceHandler.isEnabled()) {
                    this$0.eglSurfaceHandler.disable();
                    final AtomicBoolean $this$setFalseIfTrueAndDo$iv2 = this$0.renderInQueue;
                    final int $i$f$setFalseIfTrueAndDo2 = 0;
                    if ($this$setFalseIfTrueAndDo$iv2.compareAndSet(true, false)) {
                        final int n2 = 0;
                        render$default(this$0, false, 1, null);
                    }
                }
                else if (this$0.getAllowBackgroundRender()) {
                    render$default(this$0, false, 1, null);
                }
            }
        }
    }
    
    private static final void queueEvent$lambda-8(final Function0 $r) {
        Intrinsics.checkNotNullParameter((Object)$r, "$r");
        $r.invoke();
    }
    
    private static final void onAttachedToWindow$lambda-9(final GLSurfaceView this$0) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        this$0.render(true);
    }
    
    public static final /* synthetic */ List access$getSetupBlocks$p(final GLSurfaceView $this) {
        return $this.setupBlocks;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\b\u00c0\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lly/img/android/opengl/egl/GLSurfaceView$UNINITIALIZED_VALUE;", "", "()V", "pesdk-backend-core_release" })
    public static final class UNINITIALIZED_VALUE
    {
        @NotNull
        public static final UNINITIALIZED_VALUE INSTANCE;
        
        private UNINITIALIZED_VALUE() {
        }
        
        static {
            INSTANCE = new UNINITIALIZED_VALUE();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0084\u0004\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J$\u0010\f\u001a\u00028\u00002\b\u0010\u000e\u001a\u0004\u0018\u00010\u00022\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002¢\u0006\u0002\u0010\u0011J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00028\u00008F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u0006\u0016" }, d2 = { "Lly/img/android/opengl/egl/GLSurfaceView$SetupInit;", "T", "", "initializer", "Lkotlin/Function0;", "(Lly/img/android/opengl/egl/GLSurfaceView;Lkotlin/jvm/functions/Function0;)V", "_value", "getInitializer$pesdk_backend_core_release", "()Lkotlin/jvm/functions/Function0;", "setInitializer$pesdk_backend_core_release", "(Lkotlin/jvm/functions/Function0;)V", "value", "getValue", "()Ljava/lang/Object;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "init", "", "toString", "", "pesdk-backend-core_release" })
    protected final class SetupInit<T>
    {
        @NotNull
        private Function0<? extends T> initializer;
        @Nullable
        private Object _value;
        
        public SetupInit(final Function0<? extends T> initializer) {
            Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
            this.initializer = initializer;
            this._value = UNINITIALIZED_VALUE.INSTANCE;
            GLSurfaceView.access$getSetupBlocks$p(GLSurfaceView.this).add(this);
        }
        
        @NotNull
        public final Function0<T> getInitializer$pesdk_backend_core_release() {
            return (Function0<T>)this.initializer;
        }
        
        public final void setInitializer$pesdk_backend_core_release(@NotNull final Function0<? extends T> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.initializer = <set-?>;
        }
        
        @NotNull
        public final T getValue() {
            final Object value = this._value;
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type T of ly.img.android.opengl.egl.GLSurfaceView.SetupInit");
            }
            return (T)value;
        }
        
        @NotNull
        @Override
        public String toString() {
            return this.getValue().toString();
        }
        
        public final void init() {
            this._value = this.initializer.invoke();
        }
        
        @NotNull
        public final T getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            return this.getValue();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lly/img/android/opengl/egl/GLSurfaceView$Companion;", "", "()V", "FRAME_RENDER_TIMEOUT_IN_MS", "", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
