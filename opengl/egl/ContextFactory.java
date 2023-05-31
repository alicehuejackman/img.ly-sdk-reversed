// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import android.util.Log;
import javax.microedition.khronos.egl.EGLContext;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import androidx.annotation.NonNull;
import javax.microedition.khronos.egl.EGL10;

public class ContextFactory implements EGLContextFactory
{
    private static final String TAG = "DefaultContextFactory";
    private static final int EGL_CONTEXT_CLIENT_VERSION = 12440;
    private final int eglContextClientVersion;
    
    public ContextFactory(final int version) {
        this.eglContextClientVersion = version;
    }
    
    @Override
    public EGLContext createContext(@NonNull final EGL10 egl, final EGLDisplay display, final EGLConfig config) {
        return egl.eglCreateContext(display, config, EGL10.EGL_NO_CONTEXT, (int[])((this.eglContextClientVersion != 0) ? new int[] { 12440, this.eglContextClientVersion, 12344 } : null));
    }
    
    @Override
    public void destroyContext(@NonNull final EGL10 egl, final EGLDisplay display, final EGLContext context) {
        if (!egl.eglDestroyContext(display, context)) {
            Log.e("DefaultContextFactory", "display:" + display + " context: " + context);
            throw new RuntimeException("eglDestroyContext" + egl.eglGetError());
        }
        Log.i("DefaultContextFactory", "display:" + display + " context: " + context + " was destroyed as intended.");
    }
}
