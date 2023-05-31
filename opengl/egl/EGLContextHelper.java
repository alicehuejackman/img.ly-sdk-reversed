// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import ly.img.android.opengl.EGLLogWrapper;
import android.util.Log;
import javax.microedition.khronos.opengles.GL;
import androidx.annotation.NonNull;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGL10;
import ly.img.android.opengl.canvas.GlViewport;
import javax.microedition.khronos.egl.EGLSurface;
import android.graphics.SurfaceTexture;

class EGLContextHelper
{
    private EGLConfigChooser eglConfigChooser;
    private EGLContextFactory eglContextFactory;
    private SurfaceTexture dummySurfaceTexture;
    private EGLSurface dummySurface;
    private GlViewport glViewport;
    private EGL10 egl10;
    private EGLDisplay eglDisplay;
    private EGLConfig eglConfig;
    private EGLContext eglContext;
    
    public EGLContextHelper(final EGLConfigChooser eglConfigChooser, final EGLContextFactory eglContextFactory) {
        this.dummySurfaceTexture = new SurfaceTexture(0);
        this.dummySurface = EGL10.EGL_NO_SURFACE;
        this.glViewport = new GlViewport();
        this.eglConfigChooser = eglConfigChooser;
        this.eglContextFactory = eglContextFactory;
    }
    
    public void init() {
        this.egl10 = (EGL10)EGLContext.getEGL();
        this.eglDisplay = this.egl10.eglGetDisplay(EGL10.EGL_DEFAULT_DISPLAY);
        if (this.eglDisplay == EGL10.EGL_NO_DISPLAY) {
            throw new RuntimeException("eglGetDisplay failed");
        }
        final int[] version = new int[2];
        if (!this.egl10.eglInitialize(this.eglDisplay, version)) {
            throw new RuntimeException("eglInitialize failed");
        }
        this.eglConfig = this.eglConfigChooser.chooseConfig(this.egl10, this.eglDisplay);
        this.eglContext = this.eglContextFactory.createContext(this.egl10, this.eglDisplay, this.eglConfig);
        try {
            this.dummySurfaceTexture.detachFromGLContext();
            this.dummySurfaceTexture.setDefaultBufferSize(100, 100);
        }
        catch (Exception ex) {}
        this.dummySurface = this.egl10.eglCreateWindowSurface(this.eglDisplay, this.eglConfig, (Object)this.dummySurfaceTexture, (int[])null);
        this.egl10.eglMakeCurrent(this.eglDisplay, this.dummySurface, this.dummySurface, this.eglContext);
        if (this.eglContext == null || this.eglContext == EGL10.EGL_NO_CONTEXT) {
            this.eglContext = null;
            this.throwEglException("createContext");
        }
        this.glViewport.enable(100, 100);
    }
    
    @NonNull
    public EGLConfig getEglConfig() {
        return this.eglConfig;
    }
    
    GL createGL() {
        return this.eglContext.getGL();
    }
    
    public void finish() {
        if (this.dummySurface != null) {
            this.egl10.eglDestroySurface(this.eglDisplay, this.dummySurface);
            this.dummySurface = null;
        }
        if (this.eglContext != null) {
            this.eglContextFactory.destroyContext(this.egl10, this.eglDisplay, this.eglContext);
            this.eglContext = null;
        }
        if (this.eglDisplay != null) {
            this.egl10.eglTerminate(this.eglDisplay);
            this.eglDisplay = null;
        }
    }
    
    private void throwEglException(final String function) {
        throwEglException(function, this.egl10.eglGetError());
    }
    
    public static void throwEglException(final String function, final int error) {
        final String message = formatEglError(function, error);
        throw new RuntimeException(message);
    }
    
    public static void logEglErrorAsWarning(final String tag, final String function, final int error) {
        Log.w(tag, formatEglError(function, error));
    }
    
    public static String formatEglError(final String function, final int error) {
        return function + " failed: " + EGLLogWrapper.getErrorString(error);
    }
    
    public EGLContext getEglContext() {
        return this.eglContext;
    }
}
