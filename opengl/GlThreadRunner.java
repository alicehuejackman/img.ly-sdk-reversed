// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import javax.microedition.khronos.egl.EGLContext;
import org.jetbrains.annotations.NotNull;
import ly.img.android.opengl.canvas.GlObject;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0010\u001a\u00020\u0011H&J\u0010\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0018\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0007H&J\u0010\u0010\u0016\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0014H&J\u0010\u0010\u0017\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H&J\u0010\u0010\u001a\u001a\u00020\u00112\u0006\u0010\u001b\u001a\u00020\u001cH&J\u0010\u0010\u001d\u001a\u00020\u00112\u0006\u0010\u0018\u001a\u00020\u0019H&R\u0012\u0010\u0002\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0004\u0010\u0005R\u0012\u0010\u0006\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\b\u0010\tR\u0012\u0010\n\u001a\u00020\u0007X¦\u0004¢\u0006\u0006\u001a\u0004\b\u000b\u0010\tR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u001e" }, d2 = { "Lly/img/android/opengl/GlThreadRunner;", "", "eglContext", "Ljavax/microedition/khronos/egl/EGLContext;", "getEglContext", "()Ljavax/microedition/khronos/egl/EGLContext;", "glIsAlive", "", "getGlIsAlive", "()Z", "glIsDead", "getGlIsDead", "glObjectsList", "Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "getGlObjectsList", "()Lly/img/android/opengl/canvas/GlObject$GlObjectCallSet;", "freeMemory", "", "queueDestroy", "obj", "Lly/img/android/opengl/canvas/GlObject;", "sync", "queueRebound", "registerGlContextStopCallback", "callback", "Lly/img/android/opengl/GlContextStopCallback;", "runWithGlContext", "runnable", "Ljava/lang/Runnable;", "unregisterGlContextStopCallback", "pesdk-backend-core_release" })
public interface GlThreadRunner
{
    void queueDestroy(@NotNull final GlObject p0);
    
    void queueDestroy(@NotNull final GlObject p0, final boolean p1);
    
    void queueRebound(@NotNull final GlObject p0);
    
    void runWithGlContext(@NotNull final Runnable p0);
    
    void registerGlContextStopCallback(@NotNull final GlContextStopCallback p0);
    
    void unregisterGlContextStopCallback(@NotNull final GlContextStopCallback p0);
    
    void freeMemory();
    
    @NotNull
    GlObject.GlObjectCallSet getGlObjectsList();
    
    @NotNull
    EGLContext getEglContext();
    
    boolean getGlIsAlive();
    
    boolean getGlIsDead();
}
