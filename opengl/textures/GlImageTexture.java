// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import ly.img.android.opengl.egl.GLThread;
import android.util.Log;
import ly.img.android.pesdk.utils.ThreadUtils;
import android.opengl.GLUtils;
import android.opengl.GLES20;
import ly.img.android.opengl.canvas.GlObject;
import android.graphics.Bitmap$Config;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import androidx.annotation.AnyThread;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.Nullable;
import android.graphics.Bitmap;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0018\u0010\u0011\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0015\u001a\u00020\u00132\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\b\u0010\u0017\u001a\u00020\u0013H\u0014J\u000e\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0006J\u001e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u00062\u0006\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u000bJ\u0010\u0010\u001c\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\u00020\bX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\tR \u0010\f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8W@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR \u0010\u000f\u001a\u00020\u000b2\u0006\u0010\n\u001a\u00020\u000b8W@RX\u0096\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u001e" }, d2 = { "Lly/img/android/opengl/textures/GlImageTexture;", "Lly/img/android/opengl/textures/GlTexture;", "()V", "bitmapBufferLock", "Ljava/util/concurrent/locks/ReentrantLock;", "bufferBitmap", "Landroid/graphics/Bitmap;", "isExternalTexture", "", "()Z", "<set-?>", "", "textureHeight", "getTextureHeight", "()I", "textureWidth", "getTextureWidth", "bindTexture", "slot", "", "uniform", "onAttach", "handle", "onRelease", "setBitmap", "bitmap", "maxWidth", "maxHeight", "setBitmapFromWorker", "Create", "pesdk-backend-core_release" })
public final class GlImageTexture extends GlTexture
{
    private int textureWidth;
    private int textureHeight;
    @Nullable
    private Bitmap bufferBitmap;
    private final boolean isExternalTexture;
    @NotNull
    private final ReentrantLock bitmapBufferLock;
    
    public GlImageTexture() {
        super(3553);
        this.bitmapBufferLock = new ReentrantLock(true);
    }
    
    @AnyThread
    @Override
    public int getTextureWidth() {
        return this.textureWidth;
    }
    
    @AnyThread
    @Override
    public int getTextureHeight() {
        return this.textureHeight;
    }
    
    @Override
    public boolean isExternalTexture() {
        return this.isExternalTexture;
    }
    
    @Override
    public void onAttach(final int handle) {
        this.setBehave(this.upScaleFiltering, this.downScaleFiltering, this.horizontalWrap, this.verticalWrap);
    }
    
    @Override
    protected void onRelease() {
        super.onRelease();
        this.textureWidth = 0;
        this.textureHeight = 0;
    }
    
    public final void setBitmap(@NotNull final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter((Object)bitmap, "bitmap");
        final ReentrantLock reentrantLock = this.bitmapBufferLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this.bufferBitmap = null;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
        this.setBitmap(bitmap, GlTexture.Companion.getMaxTextureSize(), GlTexture.Companion.getMaxTextureSize());
    }
    
    @AnyThread
    public final void setBitmapFromWorker(@NotNull final Bitmap bitmap) {
        Intrinsics.checkNotNullParameter((Object)bitmap, "bitmap");
        final ReentrantLock reentrantLock = this.bitmapBufferLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this.textureWidth = bitmap.getWidth();
            this.textureHeight = bitmap.getHeight();
            this.bufferBitmap = bitmap;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Override
    public int bindTexture(final int slot) {
        final Bitmap bufferBitmap = this.bufferBitmap;
        if (bufferBitmap != null) {
            final Bitmap it = bufferBitmap;
            final int n = 0;
            this.setBitmap(it);
        }
        return super.bindTexture(slot);
    }
    
    @Override
    public void bindTexture(final int uniform, final int slot) {
        final Bitmap bufferBitmap = this.bufferBitmap;
        if (bufferBitmap != null) {
            final Bitmap it = bufferBitmap;
            final int n = 0;
            this.setBitmap(it);
        }
        super.bindTexture(uniform, slot);
    }
    
    public final boolean setBitmap(@NotNull final Bitmap bitmap, final int maxWidth, final int maxHeight) {
        Intrinsics.checkNotNullParameter((Object)bitmap, "bitmap");
        Object bitmap2 = null;
        bitmap2 = bitmap;
        boolean isBufferedBitmap = false;
        final ReentrantLock reentrantLock = this.bitmapBufferLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            isBufferedBitmap = Intrinsics.areEqual((Object)this.bufferBitmap, bitmap2);
            if (isBufferedBitmap) {
                this.bufferBitmap = null;
            }
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
        int maxWidth2 = maxWidth;
        int maxHeight2 = maxHeight;
        this.attach();
        final int maxTextureSize = GlTexture.Companion.getMaxTextureSize();
        maxWidth2 = TypeExtensionsKt.butMax(GlTexture.Companion.upscaleValueToPowOfTwo(maxWidth2), maxTextureSize);
        maxHeight2 = TypeExtensionsKt.butMax(GlTexture.Companion.upscaleValueToPowOfTwo(maxHeight2), maxTextureSize);
        if (((Bitmap)bitmap2).getWidth() > maxWidth2 || ((Bitmap)bitmap2).getHeight() > maxHeight2) {
            Object scaledBitmap;
            if (isBufferedBitmap) {
                final Bitmap $this$recycleAfter$iv = (Bitmap)bitmap2;
                final int $i$f$recycleAfter = 0;
                final Bitmap it$iv = $this$recycleAfter$iv;
                final int n2 = 0;
                final Bitmap it = it$iv;
                final int n3 = 0;
                final Object $this$andRecycle$iv$iv = Bitmap.createScaledBitmap(it, TypeExtensionsKt.butMax(((Bitmap)bitmap2).getWidth(), maxTextureSize), TypeExtensionsKt.butMax(((Bitmap)bitmap2).getHeight(), maxTextureSize), true);
                final int $i$f$andRecycle = 0;
                final Object it$iv$iv = $this$andRecycle$iv$iv;
                final int n4 = 0;
                it$iv.recycle();
                Intrinsics.checkNotNullExpressionValue(scaledBitmap = it$iv$iv, "{\n                bitmap\u2026          }\n            }");
            }
            else {
                Intrinsics.checkNotNullExpressionValue(scaledBitmap = Bitmap.createScaledBitmap((Bitmap)bitmap2, TypeExtensionsKt.butMax(((Bitmap)bitmap2).getWidth(), maxTextureSize), TypeExtensionsKt.butMax(((Bitmap)bitmap2).getHeight(), maxTextureSize), true), "{\n                Bitmap\u2026          )\n            }");
            }
            bitmap2 = scaledBitmap;
            isBufferedBitmap = true;
        }
        if (((Bitmap)bitmap2).getConfig() != Bitmap$Config.ARGB_8888 && ((Bitmap)bitmap2).getConfig() != Bitmap$Config.ALPHA_8) {
            Object copy;
            if (isBufferedBitmap) {
                final Bitmap $this$recycleAfter$iv = (Bitmap)bitmap2;
                final int $i$f$recycleAfter = 0;
                final Bitmap it$iv = $this$recycleAfter$iv;
                final int n2 = 0;
                final Bitmap it = it$iv;
                final int n5 = 0;
                final Object $this$andRecycle$iv$iv = it.copy(Bitmap$Config.ARGB_8888, true);
                final int $i$f$andRecycle = 0;
                final Object it$iv$iv = $this$andRecycle$iv$iv;
                final int n4 = 0;
                it$iv.recycle();
                Intrinsics.checkNotNullExpressionValue(copy = it$iv$iv, "{\n                bitmap\u2026          }\n            }");
            }
            else {
                Intrinsics.checkNotNullExpressionValue(copy = ((Bitmap)bitmap2).copy(Bitmap$Config.ARGB_8888, true), "{\n                bitmap\u20268888, true)\n            }");
            }
            bitmap2 = copy;
            isBufferedBitmap = true;
        }
        this.textureWidth = ((Bitmap)bitmap2).getWidth();
        this.textureHeight = ((Bitmap)bitmap2).getHeight();
        if (this.getTextureHandle() != -1) {
            final GlObject.Companion this_$iv = GlObject.Companion;
            final int $i$f$tryGlAllocate = 0;
            int rounds$iv = 5;
        Label_0512:
            while (true) {
                while (rounds$iv-- > 0) {
                    int maxRoundTries$iv = 10;
                    while (maxRoundTries$iv-- > 0) {
                        final int n6 = 0;
                        GLES20.glBindTexture(this.getTextureTarget(), this.getTextureHandle());
                        GLUtils.texImage2D(this.getTextureTarget(), 0, (Bitmap)bitmap2, 0);
                        if (!this_$iv.glIsOutOfMemory()) {
                            break Label_0512;
                        }
                        final GLThread glRenderIfExists = ThreadUtils.Companion.getGlRenderIfExists();
                        if (glRenderIfExists == null) {
                            continue;
                        }
                        glRenderIfExists.freeMemory();
                    }
                    Thread.sleep(1L);
                    continue;
                    if (isBufferedBitmap) {
                        ((Bitmap)bitmap2).recycle();
                    }
                    this.textureChanged();
                    if (GlObject.Companion.glIsOutOfMemory()) {
                        Log.e("Texture", "Error uploading texture fail because out of memory.");
                        return false;
                    }
                    return true;
                }
                continue Label_0512;
            }
        }
        Log.e("Texture", "Error loading texture.");
        return false;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0003\u001a\u00020\u0004J\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0004J\u0006\u0010\u0007\u001a\u00020\u0004J\u0006\u0010\b\u001a\u00020\u0004J\u0006\u0010\t\u001a\u00020\u0004¨\u0006\n" }, d2 = { "Lly/img/android/opengl/textures/GlImageTexture$Create;", "", "()V", "LINEAR", "Lly/img/android/opengl/textures/GlImageTexture;", "LINEAR_MIPMAP_LINEAR", "LINEAR_MIPMAP_NEAREST", "NEAREST", "NEAREST_MIPMAP_LINEAR", "NEAREST_MIPMAP_NEAREST", "pesdk-backend-core_release" })
    public static final class Create
    {
        @NotNull
        public static final Create INSTANCE;
        
        private Create() {
        }
        
        @NotNull
        public final GlImageTexture NEAREST() {
            final GlImageTexture $this$NEAREST_u24lambda_u2d0 = new GlImageTexture();
            final int n = 0;
            $this$NEAREST_u24lambda_u2d0.setBehave(9728, 33071);
            return $this$NEAREST_u24lambda_u2d0;
        }
        
        @NotNull
        public final GlImageTexture NEAREST_MIPMAP_NEAREST() {
            final GlImageTexture $this$NEAREST_MIPMAP_NEAREST_u24lambda_u2d1 = new GlImageTexture();
            final int n = 0;
            $this$NEAREST_MIPMAP_NEAREST_u24lambda_u2d1.setBehave(9984, 33071);
            return $this$NEAREST_MIPMAP_NEAREST_u24lambda_u2d1;
        }
        
        @NotNull
        public final GlImageTexture NEAREST_MIPMAP_LINEAR() {
            final GlImageTexture $this$NEAREST_MIPMAP_LINEAR_u24lambda_u2d2 = new GlImageTexture();
            final int n = 0;
            $this$NEAREST_MIPMAP_LINEAR_u24lambda_u2d2.setBehave(9986, 33071);
            return $this$NEAREST_MIPMAP_LINEAR_u24lambda_u2d2;
        }
        
        @NotNull
        public final GlImageTexture LINEAR() {
            final GlImageTexture $this$LINEAR_u24lambda_u2d3 = new GlImageTexture();
            final int n = 0;
            $this$LINEAR_u24lambda_u2d3.setBehave(9729, 33071);
            return $this$LINEAR_u24lambda_u2d3;
        }
        
        @NotNull
        public final GlImageTexture LINEAR_MIPMAP_NEAREST() {
            final GlImageTexture $this$LINEAR_MIPMAP_NEAREST_u24lambda_u2d4 = new GlImageTexture();
            final int n = 0;
            $this$LINEAR_MIPMAP_NEAREST_u24lambda_u2d4.setBehave(9985, 33071);
            return $this$LINEAR_MIPMAP_NEAREST_u24lambda_u2d4;
        }
        
        @NotNull
        public final GlImageTexture LINEAR_MIPMAP_LINEAR() {
            final GlImageTexture $this$LINEAR_MIPMAP_LINEAR_u24lambda_u2d5 = new GlImageTexture();
            final int n = 0;
            $this$LINEAR_MIPMAP_LINEAR_u24lambda_u2d5.setBehave(9987, 33071);
            return $this$LINEAR_MIPMAP_LINEAR_u24lambda_u2d5;
        }
        
        static {
            INSTANCE = new Create();
        }
    }
}
