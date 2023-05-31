// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import android.graphics.Bitmap$Config;
import org.jetbrains.annotations.Nullable;
import android.graphics.Bitmap;
import android.opengl.GLES20;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import java.nio.ByteBuffer;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0002\b\n\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B)\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J\b\u0010\u0018\u001a\u00020\u0019H\u0016J\u0014\u0010\u001a\u001a\u00020\u001b2\n\b\u0002\u0010\u001c\u001a\u0004\u0018\u00010\u001bH\u0016R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\r\u001a\u00020\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0012R\u0011\u0010\u0014\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012¨\u0006\u001d" }, d2 = { "Lly/img/android/opengl/GlRawTextureData;", "", "width", "", "height", "type", "format", "(IIII)V", "<set-?>", "Ljava/nio/ByteBuffer;", "buffer", "getBuffer", "()Ljava/nio/ByteBuffer;", "data", "", "getData", "()[B", "getFormat", "()I", "getHeight", "pixelSizeInBytes", "getPixelSizeInBytes", "getType", "getWidth", "glReadPixels", "", "loadIntoBitmap", "Landroid/graphics/Bitmap;", "reuse", "pesdk-backend-core_release" })
public class GlRawTextureData
{
    private final int width;
    private final int height;
    private final int type;
    private final int format;
    private final int pixelSizeInBytes;
    @NotNull
    private final byte[] data;
    @NotNull
    private ByteBuffer buffer;
    
    public GlRawTextureData(final int width, final int height, final int type, final int format) {
        this.width = width;
        this.height = height;
        this.type = type;
        this.format = format;
        if (this.type == 6408) {
            this.pixelSizeInBytes = 4;
            this.data = new byte[this.width * this.height * this.pixelSizeInBytes];
            final ByteBuffer wrap = ByteBuffer.wrap(this.data);
            Intrinsics.checkNotNullExpressionValue((Object)wrap, "wrap(data)");
            this.buffer = wrap;
            return;
        }
        throw new UnsupportedOperationException("Currently only GL_RGBA is implemented");
    }
    
    public final int getWidth() {
        return this.width;
    }
    
    public final int getHeight() {
        return this.height;
    }
    
    public final int getType() {
        return this.type;
    }
    
    public final int getFormat() {
        return this.format;
    }
    
    public final int getPixelSizeInBytes() {
        return this.pixelSizeInBytes;
    }
    
    @NotNull
    public final byte[] getData() {
        return this.data;
    }
    
    @NotNull
    public final ByteBuffer getBuffer() {
        return this.buffer;
    }
    
    public void glReadPixels() {
        GLES20.glReadPixels(0, 0, this.width, this.height, this.type, this.format, this.buffer.position(0));
    }
    
    @NotNull
    public Bitmap loadIntoBitmap(@Nullable final Bitmap reuse) {
        Bitmap bitmap = null;
        Label_0068: {
            if (reuse != null) {
                final Bitmap it = reuse;
                final int n = 0;
                Bitmap bitmap2;
                if (it.getWidth() == this.width && it.getHeight() == this.height) {
                    bitmap = reuse;
                    bitmap2 = reuse;
                }
                else {
                    bitmap = (bitmap2 = null);
                }
                if (bitmap2 != null) {
                    break Label_0068;
                }
            }
            bitmap = Bitmap.createBitmap(this.width, this.height, Bitmap$Config.ARGB_8888);
        }
        final Bitmap result = bitmap;
        result.copyPixelsFromBuffer(this.buffer.position(0));
        Intrinsics.checkNotNullExpressionValue((Object)result, "result");
        return result;
    }
}
