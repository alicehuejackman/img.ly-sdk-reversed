// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import android.view.Surface;
import android.graphics.Rect;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.Nullable;
import android.graphics.Canvas;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u0016\u0018\u00002\u00020\u0001B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005JC\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u0007¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\rH\u0086\b\u00f8\u0001\u0000J\n\u0010\u0012\u001a\u0004\u0018\u00010\u0007H\u0016J\b\u0010\u0013\u001a\u00020\u0011H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0014" }, d2 = { "Lly/img/android/opengl/textures/GlCanvasTexture;", "Lly/img/android/opengl/textures/GlSurfaceTexture;", "width", "", "height", "(II)V", "canvas", "Landroid/graphics/Canvas;", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "drawOnIt", "", "drawInstructions", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "", "lockCanvas", "unlock", "pesdk-backend-core_release" })
public class GlCanvasTexture extends GlSurfaceTexture
{
    @Nullable
    private Canvas canvas;
    @NotNull
    private ReentrantLock lock;
    
    public GlCanvasTexture(final int width, final int height) {
        super(width, height);
        this.lock = new ReentrantLock(true);
    }
    
    public final boolean drawOnIt(final int width, final int height, @NotNull final Function1<? super Canvas, Unit> drawInstructions) {
        Intrinsics.checkNotNullParameter((Object)drawInstructions, "drawInstructions");
        final int $i$f$drawOnIt = 0;
        this.setSize(width, height);
        final Canvas lockCanvas = this.lockCanvas();
        Unit instance;
        if (lockCanvas != null) {
            final Canvas it = lockCanvas;
            final int n = 0;
            try {
                drawInstructions.invoke((Object)it);
            }
            finally {
                InlineMarker.finallyStart(1);
                this.unlock();
                InlineMarker.finallyEnd(1);
            }
            instance = Unit.INSTANCE;
        }
        else {
            instance = null;
        }
        return instance != null;
    }
    
    @Nullable
    public Canvas lockCanvas() {
        this.lock.lock();
        final boolean log$iv = false;
        final int $i$f$continueWithExceptions = 0;
        Canvas canvas;
        try {
            final int n = 0;
            final Surface surface = this.getSurface();
            final Canvas it = (surface != null) ? surface.lockCanvas((Rect)null) : null;
            final int n2 = 0;
            this.canvas = it;
            canvas = it;
        }
        catch (Exception ignored$iv) {
            canvas = null;
        }
        return canvas;
    }
    
    public void unlock() {
        if (this.canvas != null) {
            final Surface surface = this.getSurface();
            if (surface != null) {
                surface.unlockCanvasAndPost(this.canvas);
            }
            this.canvas = null;
            this.lock.unlock();
            this.invalidateSurface();
        }
    }
    
    public GlCanvasTexture() {
        this(0, 0, 3, null);
    }
}
