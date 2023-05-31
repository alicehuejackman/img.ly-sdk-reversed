// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGL10;

public interface EGLConfigChooser
{
    EGLConfig chooseConfig(final EGL10 p0, final EGLDisplay p1);
}
