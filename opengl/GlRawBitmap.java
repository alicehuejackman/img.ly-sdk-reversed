// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.collections.ArraysKt;
import android.graphics.Bitmap$Config;
import kotlin.jvm.JvmOverloads;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import kotlin.jvm.internal.Intrinsics;
import java.nio.IntBuffer;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0015\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0016\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J$\u0010\u0012\u001a\u00020\u00132\u0006\u0010\b\u001a\u00020\f2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0017J\u0012\u0010\u0017\u001a\u00020\u00182\b\b\u0002\u0010\u0019\u001a\u00020\u0015H\u0017J\u0018\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0016JD\u0010\u001a\u001a\u00020\u00132\b\b\u0002\u0010\u001b\u001a\u00020\u00032\b\b\u0002\u0010\u001c\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u001d\u001a\u00020\u00032\b\b\u0002\u0010\u001e\u001a\u00020\u0003H\u0016R\u001e\u0010\b\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u000b\u001a\u00020\f¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0010¨\u0006 " }, d2 = { "Lly/img/android/opengl/GlRawBitmap;", "", "width", "", "height", "(II)V", "<set-?>", "Ljava/nio/IntBuffer;", "buffer", "getBuffer", "()Ljava/nio/IntBuffer;", "data", "", "getData", "()[I", "getHeight", "()I", "getWidth", "copyToBitmapBuffer", "", "correctFlip", "", "correctColor", "createBitmap", "Landroid/graphics/Bitmap;", "fixFormat", "glReadPixels", "x", "y", "type", "format", "Companion", "pesdk-backend-core_release" })
public class GlRawBitmap
{
    @NotNull
    public static final Companion Companion;
    private final int width;
    private final int height;
    @NotNull
    private final int[] data;
    @NotNull
    private IntBuffer buffer;
    private static final int R_MASK = 16711680;
    private static final int G_MASK = 65280;
    private static final int B_MASK = 255;
    private static final int A_MASK = -16777216;
    private static final int AG_MASK = -16711936;
    
    public GlRawBitmap(final int width, final int height) {
        this.width = width;
        this.height = height;
        this.data = new int[this.width * this.height];
        final IntBuffer wrap = IntBuffer.wrap(this.data);
        Intrinsics.checkNotNullExpressionValue((Object)wrap, "wrap(data)");
        this.buffer = wrap;
    }
    
    public final int getWidth() {
        return this.width;
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    @NotNull
    public final int[] getData() {
        return this.data;
    }
    
    @NotNull
    public final IntBuffer getBuffer() {
        return this.buffer;
    }
    
    public void glReadPixels(final int x, final int y, final int width, final int height, final int type, final int format) {
        GLES20.glReadPixels(x, y, width, height, type, format, this.buffer.position(0));
    }
    
    @JvmOverloads
    @NotNull
    public Bitmap createBitmap(final boolean fixFormat) {
        return this.createBitmap(fixFormat, fixFormat);
    }
    
    public static /* synthetic */ Bitmap createBitmap$default(final GlRawBitmap glRawBitmap, boolean fixFormat, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: createBitmap");
        }
        if ((n & 0x1) != 0x0) {
            fixFormat = true;
        }
        return glRawBitmap.createBitmap(fixFormat);
    }
    
    @NotNull
    public Bitmap createBitmap(final boolean correctFlip, final boolean correctColor) {
        int[] data;
        if (correctFlip || correctColor) {
            final int[] it = new int[this.data.length];
            final int n = 0;
            this.copyToBitmapBuffer(it, correctFlip, correctColor);
            data = it;
        }
        else {
            data = this.data;
        }
        final int[] bitmapFormat = data;
        final Bitmap bitmap = Bitmap.createBitmap(bitmapFormat, this.width, this.height, Bitmap$Config.ARGB_8888);
        Intrinsics.checkNotNullExpressionValue((Object)bitmap, "createBitmap(bitmapForma\u2026 Bitmap.Config.ARGB_8888)");
        return bitmap;
    }
    
    @JvmOverloads
    public void copyToBitmapBuffer(@NotNull final int[] buffer, final boolean correctFlip, final boolean correctColor) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        if (correctFlip && correctColor) {
            for (int y = 0; y < this.height; ++y) {
                for (int x = 0; x < this.width; ++x) {
                    final int glPixel = this.data[y * this.width + x];
                    final int blue = glPixel >> 16 & 0xFF;
                    final int red = glPixel << 16 & 0xFF0000;
                    buffer[(this.height - y - 1) * this.width + x] = ((glPixel & 0xFF00FF00) | red | blue);
                }
            }
        }
        else if (correctFlip) {
            if (this.data == buffer) {
                throw new IllegalArgumentException("Buffer can not be the same, if correctFlip is not false");
            }
            for (int y = 0; y < this.height; ++y) {
                for (int x = 0; x < this.width; ++x) {
                    buffer[(this.height - y - 1) * this.width + x] = this.data[y * this.width + x];
                }
            }
        }
        else if (correctColor) {
            for (int y = 0; y < this.height; ++y) {
                for (int x = 0; x < this.width; ++x) {
                    final int glPixel = this.data[y * this.width + x];
                    final int blue = glPixel >> 16 & 0xFF;
                    final int red = glPixel << 16 & 0xFF0000;
                    buffer[y * this.width + x] = ((glPixel & 0xFF00FF00) | red | blue);
                }
            }
        }
        else if (this.data != buffer) {
            ArraysKt.copyInto$default(this.data, buffer, 0, 0, 0, 14, (Object)null);
        }
    }
    
    public static /* synthetic */ void copyToBitmapBuffer$default(final GlRawBitmap glRawBitmap, final int[] buffer, boolean correctFlip, boolean correctColor, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyToBitmapBuffer");
        }
        if ((n & 0x2) != 0x0) {
            correctFlip = true;
        }
        if ((n & 0x4) != 0x0) {
            correctColor = true;
        }
        glRawBitmap.copyToBitmapBuffer(buffer, correctFlip, correctColor);
    }
    
    @JvmOverloads
    @NotNull
    public final Bitmap createBitmap() {
        return createBitmap$default(this, false, 1, null);
    }
    
    @JvmOverloads
    public final void copyToBitmapBuffer(@NotNull final int[] buffer, final boolean correctFlip) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToBitmapBuffer$default(this, buffer, correctFlip, false, 4, null);
    }
    
    @JvmOverloads
    public final void copyToBitmapBuffer(@NotNull final int[] buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToBitmapBuffer$default(this, buffer, false, false, 6, null);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\t" }, d2 = { "Lly/img/android/opengl/GlRawBitmap$Companion;", "", "()V", "AG_MASK", "", "A_MASK", "B_MASK", "G_MASK", "R_MASK", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
