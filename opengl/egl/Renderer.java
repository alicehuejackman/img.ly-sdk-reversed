// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import javax.microedition.khronos.egl.EGLConfig;

public interface Renderer
{
    void onSurfaceCreated(final EGLConfig p0);
    
    void onSurfaceChanged(final int p0, final int p1);
    
    void onDrawFrame();
}
