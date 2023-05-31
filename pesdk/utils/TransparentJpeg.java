// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.graphics.ColorMatrixColorFilter;
import android.graphics.ColorFilter;
import ly.img.android.opengl.GlRawBitmap;
import org.jetbrains.annotations.Nullable;
import android.graphics.Bitmap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import java.io.File;
import android.graphics.Paint;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u000f\u001a\u00020\u000bH\u0007J\u0018\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\u0006\u0010\u0013\u001a\u00020\u0011H\u0007J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J\u001a\u0010\u0016\u001a\u0004\u0018\u00010\u00112\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0004H\u0007J \u0010\u0017\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u0019H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a" }, d2 = { "Lly/img/android/pesdk/utils/TransparentJpeg;", "", "()V", "ALPHA_FILE_SUFFIX", "", "RGB_FILE_SUFFIX", "TRANSPARENT_JPEG_FILE_SUFFIX", "alphaSaveMatrixPaint", "Landroid/graphics/Paint;", "rgbSaveMatrixPaint", "combinationExists", "", "dir", "Ljava/io/File;", "filename", "cleanupIfNot", "combineColorWithMask", "Landroid/graphics/Bitmap;", "rgbBitmap", "maskBitmap", "deleteTransparentJpeg", "", "loadTransparentJpeg", "saveTransparentJpeg", "glRawBitmap", "Lly/img/android/opengl/GlRawBitmap;", "pesdk-backend-core_release" })
public final class TransparentJpeg
{
    @NotNull
    public static final TransparentJpeg INSTANCE;
    @NotNull
    private static final String TRANSPARENT_JPEG_FILE_SUFFIX = ".tjpeg";
    @NotNull
    private static final String RGB_FILE_SUFFIX = ".jrgb";
    @NotNull
    private static final String ALPHA_FILE_SUFFIX = ".jalpha";
    @NotNull
    private static final Paint rgbSaveMatrixPaint;
    @NotNull
    private static final Paint alphaSaveMatrixPaint;
    
    private TransparentJpeg() {
    }
    
    @JvmStatic
    public static final void deleteTransparentJpeg(@NotNull final File dir, @NotNull final String filename) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        Intrinsics.checkNotNullParameter((Object)filename, "filename");
        final StringBuilder append = new StringBuilder().append(filename);
        final TransparentJpeg instance = TransparentJpeg.INSTANCE;
        final File fileNameRGB = new File(dir, append.append(".jrgb").toString());
        final StringBuilder append2 = new StringBuilder().append(filename);
        final TransparentJpeg instance2 = TransparentJpeg.INSTANCE;
        final File fileNameAlpha = new File(dir, append2.append(".jalpha").toString());
        if (fileNameRGB.exists()) {
            fileNameRGB.delete();
        }
        if (fileNameAlpha.exists()) {
            fileNameAlpha.delete();
        }
    }
    
    @JvmStatic
    public static final boolean combinationExists(@NotNull final File dir, @NotNull final String filename, final boolean cleanupIfNot) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        Intrinsics.checkNotNullParameter((Object)filename, "filename");
        final StringBuilder append = new StringBuilder().append(filename);
        final TransparentJpeg instance = TransparentJpeg.INSTANCE;
        final File fileNameRGB = new File(dir, append.append(".jrgb").toString());
        final StringBuilder append2 = new StringBuilder().append(filename);
        final TransparentJpeg instance2 = TransparentJpeg.INSTANCE;
        final File fileNameAlpha = new File(dir, append2.append(".jalpha").toString());
        boolean combinationExist = true;
        if (!fileNameRGB.exists()) {
            if (cleanupIfNot) {
                fileNameRGB.delete();
            }
            combinationExist = false;
        }
        if (!fileNameAlpha.exists()) {
            if (cleanupIfNot) {
                fileNameAlpha.delete();
            }
            combinationExist = false;
        }
        return combinationExist;
    }
    
    @JvmStatic
    @Nullable
    public static final Bitmap loadTransparentJpeg(@NotNull final File dir, @NotNull final String filename) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        Intrinsics.checkNotNullParameter((Object)filename, "filename");
        return null;
    }
    
    @JvmStatic
    @NotNull
    public static final Bitmap combineColorWithMask(@NotNull final Bitmap rgbBitmap, @NotNull final Bitmap maskBitmap) {
        Intrinsics.checkNotNullParameter((Object)rgbBitmap, "rgbBitmap");
        Intrinsics.checkNotNullParameter((Object)maskBitmap, "maskBitmap");
        final Bitmap nothing_BITMAP = BitmapFactoryUtils.NOTHING_BITMAP;
        Intrinsics.checkNotNullExpressionValue((Object)nothing_BITMAP, "NOTHING_BITMAP");
        return nothing_BITMAP;
    }
    
    @JvmStatic
    public static final boolean saveTransparentJpeg(@NotNull final File dir, @NotNull final String filename, @NotNull final GlRawBitmap glRawBitmap) {
        Intrinsics.checkNotNullParameter((Object)dir, "dir");
        Intrinsics.checkNotNullParameter((Object)filename, "filename");
        Intrinsics.checkNotNullParameter((Object)glRawBitmap, "glRawBitmap");
        return true;
    }
    
    static {
        INSTANCE = new TransparentJpeg();
        final Paint $this$rgbSaveMatrixPaint_u24lambda_u2d0 = new Paint();
        final int n = 0;
        $this$rgbSaveMatrixPaint_u24lambda_u2d0.setColorFilter((ColorFilter)new ColorMatrixColorFilter(new float[] { 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f }));
        rgbSaveMatrixPaint = $this$rgbSaveMatrixPaint_u24lambda_u2d0;
        final Paint $this$alphaSaveMatrixPaint_u24lambda_u2d1 = new Paint();
        final int n2 = 0;
        $this$alphaSaveMatrixPaint_u24lambda_u2d1.setColorFilter((ColorFilter)new ColorMatrixColorFilter(new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 255.0f }));
        alphaSaveMatrixPaint = $this$alphaSaveMatrixPaint_u24lambda_u2d1;
    }
}
