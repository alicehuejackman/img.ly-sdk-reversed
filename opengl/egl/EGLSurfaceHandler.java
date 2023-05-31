// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import javax.microedition.khronos.egl.EGLConfig;
import android.opengl.GLUtils;
import android.view.SurfaceHolder;
import androidx.annotation.MainThread;
import android.graphics.SurfaceTexture;
import ly.img.android.opengl.EGLLogWrapper;
import ly.img.android.pesdk.utils.ThreadUtils;
import android.util.Log;
import ly.img.android.opengl.textures.GlFrameBufferTexture;
import androidx.annotation.WorkerThread;
import android.annotation.SuppressLint;
import ly.img.android.pesdk.backend.views.abstracts.ImgLyUITextureView;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.jvm.internal.Intrinsics;
import javax.microedition.khronos.egl.EGL10;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import android.view.View;
import java.lang.ref.WeakReference;
import ly.img.android.opengl.canvas.GlMakeCurrent;
import org.jetbrains.annotations.Nullable;
import android.view.Surface;
import java.util.concurrent.atomic.AtomicBoolean;
import ly.img.android.opengl.canvas.GlViewport;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGLSurface;
import org.jetbrains.annotations.NotNull;
import kotlin.Lazy;
import kotlin.Metadata;
import android.view.SurfaceHolder$Callback;
import android.view.TextureView$SurfaceTextureListener;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0084\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0000\u0018\u00002\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u00106\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0003J\b\u00107\u001a\u000208H\u0007J\b\u00109\u001a\u000208H\u0007J\b\u0010:\u001a\u00020\u001cH\u0007J\u0010\u0010;\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0003J\u0010\u0010<\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020#H\u0003J \u0010=\u001a\u0002082\u0006\u0010(\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0017J\u0010\u0010B\u001a\u00020\u001c2\u0006\u0010(\u001a\u00020>H\u0017J \u0010C\u001a\u0002082\u0006\u0010(\u001a\u00020>2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0017J\u0010\u0010D\u001a\u0002082\u0006\u0010(\u001a\u00020>H\u0017J(\u0010E\u001a\u0002082\u0006\u0010F\u001a\u00020G2\u0006\u0010H\u001a\u00020@2\u0006\u0010?\u001a\u00020@2\u0006\u0010A\u001a\u00020@H\u0016J\u0010\u0010I\u001a\u0002082\u0006\u0010F\u001a\u00020GH\u0016J\u0010\u0010J\u001a\u0002082\u0006\u0010F\u001a\u00020GH\u0016J\u0006\u0010K\u001a\u00020@J\b\u0010L\u001a\u000208H\u0002R!\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\u0012\n\u0004\b\t\u0010\n\u0012\u0004\b\u0006\u0010\u0003\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R \u0010\u0011\u001a\u00020\fX\u0086\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u001b\u001a\u00020\u001c8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001cX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001d\"\u0004\b\u001f\u0010 R\u000e\u0010!\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0018\u0010\"\u001a\u0004\u0018\u00010#8CX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\u0004\u0018\u00010)8BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R(\u0010/\u001a\u0004\u0018\u00010.2\b\u0010-\u001a\u0004\u0018\u00010.8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u0018\u00104\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010.\u0018\u000105X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006M" }, d2 = { "Lly/img/android/opengl/egl/EGLSurfaceHandler;", "Landroid/view/TextureView$SurfaceTextureListener;", "Landroid/view/SurfaceHolder$Callback;", "()V", "EGL", "Ljavax/microedition/khronos/egl/EGL10;", "getEGL$annotations", "getEGL", "()Ljavax/microedition/khronos/egl/EGL10;", "EGL$delegate", "Lkotlin/Lazy;", "currentFrameRate", "", "eglDisplay", "Ljavax/microedition/khronos/egl/EGLDisplay;", "eglSurface", "Ljavax/microedition/khronos/egl/EGLSurface;", "frameRate", "getFrameRate$annotations", "getFrameRate", "()F", "setFrameRate", "(F)V", "glMakeCurrent", "Lly/img/android/opengl/canvas/GlMakeCurrent;", "glViewport", "Lly/img/android/opengl/canvas/GlViewport;", "isAttached", "", "()Z", "isEnabled", "setEnabled", "(Z)V", "isGlInitDone", "nativeSurface", "", "getNativeSurface", "()Ljava/lang/Object;", "needSurfaceCreation", "Ljava/util/concurrent/atomic/AtomicBoolean;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "surfaceIsAvailable", "value", "Landroid/view/View;", "uiSurface", "getUiSurface", "()Landroid/view/View;", "setUiSurface", "(Landroid/view/View;)V", "uiSurfaceReference", "Ljava/lang/ref/WeakReference;", "createSurface", "destroyOldSurface", "", "disable", "enable", "initGL", "initNewSurface", "onSurfaceTextureAvailable", "Landroid/graphics/SurfaceTexture;", "width", "", "height", "onSurfaceTextureDestroyed", "onSurfaceTextureSizeChanged", "onSurfaceTextureUpdated", "surfaceChanged", "holder", "Landroid/view/SurfaceHolder;", "format", "surfaceCreated", "surfaceDestroyed", "swapBuffers", "switchFrameRateIfNeeded", "pesdk-backend-core_release" })
public final class EGLSurfaceHandler implements TextureView$SurfaceTextureListener, SurfaceHolder$Callback
{
    @NotNull
    private final Lazy EGL$delegate;
    @NotNull
    private EGLSurface eglSurface;
    @NotNull
    private EGLDisplay eglDisplay;
    @NotNull
    private GlViewport glViewport;
    private boolean isGlInitDone;
    private float currentFrameRate;
    private float frameRate;
    @NotNull
    private final AtomicBoolean needSurfaceCreation;
    private boolean isEnabled;
    private boolean surfaceIsAvailable;
    @Nullable
    private Surface surface;
    @Nullable
    private Object nativeSurface;
    @Nullable
    private GlMakeCurrent glMakeCurrent;
    @Nullable
    private WeakReference<View> uiSurfaceReference;
    
    public EGLSurfaceHandler() {
        this.EGL$delegate = LazyKt.lazy((Function0)EGLSurfaceHandler$EGL.EGLSurfaceHandler$EGL$2.INSTANCE);
        final EGLSurface egl_NO_SURFACE = EGL10.EGL_NO_SURFACE;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_SURFACE, "EGL_NO_SURFACE");
        this.eglSurface = egl_NO_SURFACE;
        final EGLDisplay egl_NO_DISPLAY = EGL10.EGL_NO_DISPLAY;
        Intrinsics.checkNotNullExpressionValue((Object)egl_NO_DISPLAY, "EGL_NO_DISPLAY");
        this.eglDisplay = egl_NO_DISPLAY;
        this.glViewport = new GlViewport(null, 1, null);
        this.needSurfaceCreation = new AtomicBoolean(false);
    }
    
    private final EGL10 getEGL() {
        return (EGL10)this.EGL$delegate.getValue();
    }
    
    public final float getFrameRate() {
        return this.frameRate;
    }
    
    public final void setFrameRate(final float <set-?>) {
        this.frameRate = <set-?>;
    }
    
    public final boolean isEnabled() {
        return this.isEnabled;
    }
    
    public final void setEnabled(final boolean <set-?>) {
        this.isEnabled = <set-?>;
    }
    
    private final Surface getSurface() {
        Surface surface;
        if ((surface = this.surface) == null) {
            final WeakReference<View> uiSurfaceReference = this.uiSurfaceReference;
            final View uiSurface = (uiSurfaceReference != null) ? ((View)uiSurfaceReference.get()) : null;
            Surface surface2;
            if (uiSurface instanceof ImgLyUITextureView) {
                surface2 = new Surface(((ImgLyUITextureView)uiSurface).getSurfaceTexture());
            }
            else if (uiSurface instanceof GLSurfaceView) {
                final Surface it = ((GLSurfaceView)uiSurface).getHolder().getSurface();
                final int n = 0;
                surface2 = (it.isValid() ? it : null);
            }
            else {
                surface2 = null;
            }
            final Surface surface3 = surface2;
            if (surface3 != null) {
                final Surface it2 = surface3;
                final int n2 = 0;
                this.surface = it2;
                surface = it2;
            }
            else {
                surface = null;
            }
        }
        return surface;
    }
    
    @SuppressLint({ "WrongThread" })
    @WorkerThread
    private final Object getNativeSurface() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/egl/EGLSurfaceHandler.surfaceIsAvailable:Z
        //     4: ifne            9
        //     7: aconst_null    
        //     8: areturn        
        //     9: aload_0         /* this */
        //    10: getfield        ly/img/android/opengl/egl/EGLSurfaceHandler.eglSurface:Ljavax/microedition/khronos/egl/EGLSurface;
        //    13: getstatic       javax/microedition/khronos/egl/EGL10.EGL_NO_SURFACE:Ljavax/microedition/khronos/egl/EGLSurface;
        //    16: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //    19: ifeq            159
        //    22: aload_0         /* this */
        //    23: aload_0         /* this */
        //    24: getfield        ly/img/android/opengl/egl/EGLSurfaceHandler.uiSurfaceReference:Ljava/lang/ref/WeakReference;
        //    27: dup            
        //    28: ifnull          40
        //    31: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    34: checkcast       Landroid/view/View;
        //    37: goto            42
        //    40: pop            
        //    41: aconst_null    
        //    42: astore_1        /* uiSurface */
        //    43: aload_1         /* uiSurface */
        //    44: instanceof      Lly/img/android/pesdk/backend/views/abstracts/ImgLyUITextureView;
        //    47: ifeq            89
        //    50: aload_1         /* uiSurface */
        //    51: checkcast       Lly/img/android/pesdk/backend/views/abstracts/ImgLyUITextureView;
        //    54: invokevirtual   ly/img/android/pesdk/backend/views/abstracts/ImgLyUITextureView.getSurfaceTexture:()Landroid/graphics/SurfaceTexture;
        //    57: astore_2       
        //    58: aload_2        
        //    59: astore_3       
        //    60: astore          5
        //    62: iconst_0       
        //    63: istore          $i$a$-takeIf-EGLSurfaceHandler$nativeSurface$1
        //    65: aload_1         /* uiSurface */
        //    66: checkcast       Lly/img/android/pesdk/backend/views/abstracts/ImgLyUITextureView;
        //    69: invokevirtual   ly/img/android/pesdk/backend/views/abstracts/ImgLyUITextureView.isAttached:()Z
        //    72: istore          6
        //    74: aload           5
        //    76: iload           6
        //    78: ifeq            85
        //    81: aload_2        
        //    82: goto            156
        //    85: aconst_null    
        //    86: goto            156
        //    89: aload_1         /* uiSurface */
        //    90: instanceof      Lly/img/android/opengl/egl/GLSurfaceView;
        //    93: ifeq            155
        //    96: aload_1         /* uiSurface */
        //    97: checkcast       Lly/img/android/opengl/egl/GLSurfaceView;
        //   100: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.getHolder:()Landroid/view/SurfaceHolder;
        //   103: astore_2       
        //   104: aload_2        
        //   105: astore_3       
        //   106: astore          5
        //   108: iconst_0       
        //   109: istore          $i$a$-takeIf-EGLSurfaceHandler$nativeSurface$2
        //   111: aload_1         /* uiSurface */
        //   112: checkcast       Lly/img/android/opengl/egl/GLSurfaceView;
        //   115: invokevirtual   ly/img/android/opengl/egl/GLSurfaceView.isAttached:()Z
        //   118: ifeq            137
        //   121: aload_3         /* it */
        //   122: invokeinterface android/view/SurfaceHolder.getSurface:()Landroid/view/Surface;
        //   127: invokevirtual   android/view/Surface.isValid:()Z
        //   130: ifeq            137
        //   133: iconst_1       
        //   134: goto            138
        //   137: iconst_0       
        //   138: istore          6
        //   140: aload           5
        //   142: iload           6
        //   144: ifeq            151
        //   147: aload_2        
        //   148: goto            156
        //   151: aconst_null    
        //   152: goto            156
        //   155: aconst_null    
        //   156: putfield        ly/img/android/opengl/egl/EGLSurfaceHandler.nativeSurface:Ljava/lang/Object;
        //   159: aload_0         /* this */
        //   160: getfield        ly/img/android/opengl/egl/EGLSurfaceHandler.nativeSurface:Ljava/lang/Object;
        //   163: areturn        
        //    StackMapTable: 00 0B 09 FF 00 1E 00 01 07 00 02 00 02 07 00 02 07 00 6F FF 00 01 00 01 07 00 02 00 02 07 00 02 07 00 74 FF 00 2A 00 07 07 00 02 07 00 74 07 00 AC 07 00 AC 01 07 00 02 01 00 01 07 00 02 FF 00 03 00 02 07 00 02 07 00 74 00 01 07 00 02 FF 00 2F 00 06 07 00 02 07 00 74 07 00 87 07 00 87 01 07 00 02 00 00 40 01 FF 00 0C 00 07 07 00 02 07 00 74 07 00 87 07 00 87 01 07 00 02 01 00 01 07 00 02 FF 00 03 00 02 07 00 02 07 00 74 00 01 07 00 02 FF 00 00 00 02 07 00 02 07 00 74 00 02 07 00 02 07 00 04 FA 00 02
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
    
    private final boolean isAttached() {
        final WeakReference<View> uiSurfaceReference = this.uiSurfaceReference;
        final View uiSurface = (uiSurfaceReference != null) ? ((View)uiSurfaceReference.get()) : null;
        return (uiSurface instanceof ImgLyUITextureView) ? ((ImgLyUITextureView)uiSurface).isAttached() : (uiSurface instanceof GLSurfaceView && ((GLSurfaceView)uiSurface).isAttached());
    }
    
    @Nullable
    public final View getUiSurface() {
        final WeakReference<View> uiSurfaceReference = this.uiSurfaceReference;
        return (uiSurfaceReference != null) ? ((View)uiSurfaceReference.get()) : null;
    }
    
    public final void setUiSurface(@Nullable final View value) {
        final WeakReference<View> uiSurfaceReference = this.uiSurfaceReference;
        View uiSurface = (uiSurfaceReference != null) ? ((View)uiSurfaceReference.get()) : null;
        if (uiSurface instanceof ImgLyUITextureView) {
            ((ImgLyUITextureView)uiSurface).setSurfaceTextureListener((TextureView$SurfaceTextureListener)null);
        }
        else if (uiSurface instanceof GLSurfaceView) {
            ((GLSurfaceView)uiSurface).getHolder().removeCallback((SurfaceHolder$Callback)this);
        }
        this.uiSurfaceReference = new WeakReference<View>(value);
        this.needSurfaceCreation.set(true);
        final WeakReference<View> uiSurfaceReference2 = this.uiSurfaceReference;
        uiSurface = ((uiSurfaceReference2 != null) ? ((View)uiSurfaceReference2.get()) : null);
        if (uiSurface instanceof ImgLyUITextureView) {
            ((ImgLyUITextureView)uiSurface).setSurfaceTextureListener((TextureView$SurfaceTextureListener)this);
        }
        else if (uiSurface instanceof GLSurfaceView) {
            ((GLSurfaceView)uiSurface).getHolder().addCallback((SurfaceHolder$Callback)this);
        }
    }
    
    public final int swapBuffers() {
        final int result = this.getEGL().eglSwapBuffers(this.eglDisplay, this.eglSurface) ? 12288 : this.getEGL().eglGetError();
        GlFrameBufferTexture.Companion.endOfRoundTrip();
        switch (result) {
            case 12288: {
                this.switchFrameRateIfNeeded();
                break;
            }
            case 12295:
            case 12296:
            case 12299:
            case 12301: {
                this.destroyOldSurface();
                this.needSurfaceCreation.set(true);
                break;
            }
            case 12291: {
                this.destroyOldSurface();
                this.needSurfaceCreation.set(true);
                break;
            }
            case 12302: {
                Log.w("IMGLY", "EGL_CONTEXT_LOST, EGL context will be recreated");
                final GLThread glRenderIfExists = ThreadUtils.Companion.getGlRenderIfExists();
                if (glRenderIfExists != null) {
                    glRenderIfExists.notifyLostContext();
                    break;
                }
                break;
            }
            default: {
                Log.e("EGLSurface", "Previously gl error detected \"" + EGLLogWrapper.getErrorString(result) + '\"');
                return 12288;
            }
        }
        return result;
    }
    
    private final void switchFrameRateIfNeeded() {
    }
    
    @WorkerThread
    public final boolean enable() {
        if (this.isEnabled) {
            throw new IllegalStateException("Is already enabled");
        }
        if (!this.isAttached()) {
            return false;
        }
        this.isEnabled = true;
        if (this.needSurfaceCreation.compareAndSet(true, false)) {
            this.destroyOldSurface();
            final Object nativeSurface = this.getNativeSurface();
            if (nativeSurface == null || !this.initNewSurface(nativeSurface)) {
                return this.isEnabled = false;
            }
        }
        final GlMakeCurrent glMakeCurrent = this.glMakeCurrent;
        if (glMakeCurrent != null) {
            final GlMakeCurrent it = glMakeCurrent;
            final int n = 0;
            if (it.enable()) {
                this.glViewport.enable();
            }
            else {
                this.glMakeCurrent = null;
                this.destroyOldSurface();
                this.isEnabled = false;
            }
            return true;
        }
        final EGLSurfaceHandler $this$enable_u24lambda_u2d5 = this;
        final int n2 = 0;
        $this$enable_u24lambda_u2d5.needSurfaceCreation.set(true);
        return $this$enable_u24lambda_u2d5.isEnabled = false;
    }
    
    @WorkerThread
    public final void disable() {
        if (this.isEnabled) {
            this.isEnabled = false;
            final GlMakeCurrent glMakeCurrent = this.glMakeCurrent;
            if (glMakeCurrent != null) {
                glMakeCurrent.disable();
            }
            this.glViewport.disable();
            return;
        }
        throw new IllegalStateException("Is already disabled");
    }
    
    @WorkerThread
    private final boolean initNewSurface(final Object nativeSurface) {
        if (this.initGL(nativeSurface)) {
            this.glMakeCurrent = new GlMakeCurrent(this.eglDisplay, this.eglSurface);
            return this.isGlInitDone = true;
        }
        return false;
    }
    
    @WorkerThread
    public final void destroyOldSurface() {
        this.currentFrameRate = 0.0f;
        final GlMakeCurrent glMakeCurrent = this.glMakeCurrent;
        if (glMakeCurrent != null && !glMakeCurrent.isActive()) {
            final GlMakeCurrent glMakeCurrent2 = this.glMakeCurrent;
            if (glMakeCurrent2 != null) {
                glMakeCurrent2.enable();
            }
        }
        if (!Intrinsics.areEqual((Object)this.eglSurface, (Object)EGL10.EGL_NO_SURFACE)) {
            this.getEGL().eglSwapBuffers(this.eglDisplay, this.eglSurface);
            this.getEGL().eglDestroySurface(this.eglDisplay, this.eglSurface);
            final EGLSurface egl_NO_SURFACE = EGL10.EGL_NO_SURFACE;
            Intrinsics.checkNotNullExpressionValue((Object)egl_NO_SURFACE, "EGL_NO_SURFACE");
            this.eglSurface = egl_NO_SURFACE;
        }
        if (!Intrinsics.areEqual((Object)this.eglDisplay, (Object)EGL10.EGL_NO_DISPLAY)) {
            this.getEGL().eglTerminate(this.eglDisplay);
            final EGLDisplay egl_NO_DISPLAY = EGL10.EGL_NO_DISPLAY;
            Intrinsics.checkNotNullExpressionValue((Object)egl_NO_DISPLAY, "EGL_NO_DISPLAY");
            this.eglDisplay = egl_NO_DISPLAY;
        }
        final GlMakeCurrent glMakeCurrent3 = this.glMakeCurrent;
        if (glMakeCurrent3 != null) {
            glMakeCurrent3.disable();
        }
        this.glMakeCurrent = null;
    }
    
    @MainThread
    public void onSurfaceTextureAvailable(@NotNull final SurfaceTexture surface, final int width, final int height) {
        Intrinsics.checkNotNullParameter((Object)surface, "surface");
        if (!Intrinsics.areEqual(this.getNativeSurface(), (Object)surface)) {
            this.glViewport.set(0, 0, width, height);
            final View uiSurface = this.getUiSurface();
            final ImgLyUITextureView textureView = (uiSurface instanceof ImgLyUITextureView) ? uiSurface : null;
            final Object nativeSurface = this.getNativeSurface();
            final SurfaceTexture stillValidSurface = (nativeSurface instanceof SurfaceTexture) ? ((SurfaceTexture)nativeSurface) : null;
            if (textureView != null && stillValidSurface != null) {
                textureView.setSurfaceTexture(stillValidSurface);
            }
            else {
                this.surfaceIsAvailable = true;
                this.needSurfaceCreation.set(true);
            }
        }
    }
    
    @MainThread
    public void onSurfaceTextureUpdated(@NotNull final SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter((Object)surface, "surface");
    }
    
    @MainThread
    public boolean onSurfaceTextureDestroyed(@NotNull final SurfaceTexture surface) {
        Intrinsics.checkNotNullParameter((Object)surface, "surface");
        return false;
    }
    
    @MainThread
    public void onSurfaceTextureSizeChanged(@NotNull final SurfaceTexture surface, final int width, final int height) {
        Intrinsics.checkNotNullParameter((Object)surface, "surface");
        this.glViewport.set(0, 0, width, height);
    }
    
    public void surfaceChanged(@NotNull final SurfaceHolder holder, final int format, final int width, final int height) {
        Intrinsics.checkNotNullParameter((Object)holder, "holder");
        this.glViewport.set(0, 0, width, height);
    }
    
    public void surfaceDestroyed(@NotNull final SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter((Object)holder, "holder");
        this.surfaceIsAvailable = false;
        this.needSurfaceCreation.set(true);
    }
    
    public void surfaceCreated(@NotNull final SurfaceHolder holder) {
        Intrinsics.checkNotNullParameter((Object)holder, "holder");
        this.surfaceIsAvailable = true;
        this.needSurfaceCreation.set(true);
    }
    
    @WorkerThread
    private final boolean initGL(final Object nativeSurface) {
        final EGLDisplay eglGetDisplay = this.getEGL().eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        Intrinsics.checkNotNullExpressionValue((Object)eglGetDisplay, "EGL.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY)");
        this.eglDisplay = eglGetDisplay;
        if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed " + GLUtils.getEGLErrorString(this.getEGL().eglGetError()));
        }
        final int[] version = new int[2];
        if (!this.getEGL().eglInitialize(this.eglDisplay, version)) {
            throw new RuntimeException("eglInitialize failed " + GLUtils.getEGLErrorString(this.getEGL().eglGetError()));
        }
        return this.createSurface(nativeSurface);
    }
    
    @WorkerThread
    private final boolean createSurface(final Object nativeSurface) {
        final EGLConfig config = ThreadUtils.Companion.getGlRender().getEglConfig();
        try {
            final EGLSurface eglCreateWindowSurface = this.getEGL().eglCreateWindowSurface(this.eglDisplay, config, nativeSurface, (int[])null);
            Intrinsics.checkNotNullExpressionValue((Object)eglCreateWindowSurface, "EGL.eglCreateWindowSurfa\u2026fig, nativeSurface, null)");
            this.eglSurface = eglCreateWindowSurface;
        }
        catch (IllegalArgumentException e) {
            Log.e("EGLSurface", "eglCreateWindowSurface", (Throwable)e);
            return false;
        }
        catch (UnsupportedOperationException e2) {
            Log.e("EGLSurface", "Wrong Surface type is: " + nativeSurface.getClass().getName());
            e2.printStackTrace();
        }
        if (this.eglSurface == EGL10.EGL_NO_SURFACE) {
            final View uiSurface;
            final View view = uiSurface = this.getUiSurface();
            if (uiSurface != null) {
                uiSurface.post(EGLSurfaceHandler::createSurface$lambda-7);
            }
            return false;
        }
        return true;
    }
    
    private static final void createSurface$lambda-7$lambda-6(final View $view) {
        $view.setVisibility(0);
    }
    
    private static final void createSurface$lambda-7(final View $view) {
        $view.setVisibility(8);
        $view.post(EGLSurfaceHandler::createSurface$lambda-7$lambda-6);
    }
}
