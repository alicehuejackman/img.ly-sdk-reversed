// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import androidx.annotation.XmlRes;
import androidx.annotation.WorkerThread;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0011\b\u0017\u0012\b\b\u0001\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007¨\u0006\b" }, d2 = { "Lly/img/android/opengl/canvas/GlVertexShader;", "Lly/img/android/opengl/canvas/GlAbstractShader;", "shader", "", "(Ljava/lang/String;)V", "res", "", "(I)V", "pesdk-backend-core_release" })
public final class GlVertexShader extends GlAbstractShader
{
    @WorkerThread
    public GlVertexShader(@NotNull final String shader) {
        Intrinsics.checkNotNullParameter((Object)shader, "shader");
        super(shader, 35633);
    }
    
    @WorkerThread
    public GlVertexShader(@XmlRes final int res) {
        super(res, 35633);
    }
}
