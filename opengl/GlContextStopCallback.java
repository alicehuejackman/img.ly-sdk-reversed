// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import org.jetbrains.annotations.NotNull;
import javax.microedition.khronos.egl.EGLContext;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006" }, d2 = { "Lly/img/android/opengl/GlContextStopCallback;", "", "onContextStopped", "", "context", "Ljavax/microedition/khronos/egl/EGLContext;", "pesdk-backend-core_release" })
public interface GlContextStopCallback
{
    void onContextStopped(@NotNull final EGLContext p0);
}
