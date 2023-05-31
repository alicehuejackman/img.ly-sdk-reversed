// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.util.TypedValue;
import ly.img.android.PESDK;
import android.graphics.drawable.Drawable;
import android.graphics.Canvas;
import java.io.OutputStream;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import ly.img.android.pesdk.ui.utils.MemoryUtility;
import androidx.annotation.NonNull;
import java.io.IOException;
import android.graphics.Rect;
import java.io.BufferedInputStream;
import ly.img.android.R;
import ly.img.android.IMGLY;
import androidx.annotation.RawRes;
import androidx.annotation.DrawableRes;
import android.content.res.Resources;
import java.io.InputStream;
import android.graphics.Matrix;
import android.graphics.BitmapFactory;
import android.os.MemoryFile;
import android.util.SparseArray;
import android.graphics.Bitmap;

public class BitmapFactoryUtils
{
    public static final Bitmap NOTHING_BITMAP;
    @Deprecated
    public static final Bitmap NOTING_BITMAP;
    public static SparseArray<MemoryFile> memoryFileHashMap;
    
    private BitmapFactoryUtils() {
    }
    
    public static Bitmap decodeFile(final String filename, final int minSize, final boolean square) {
        return decodeFile(filename, minSize, square, true);
    }
    
    public static Bitmap decodeFile(final String filename, final int minSize, final boolean square, final boolean fixRotation) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, opts);
        final int size = Math.max(opts.outWidth, opts.outHeight);
        if (size > minSize && minSize > 0) {
            opts.inSampleSize = size / minSize;
        }
        else {
            opts.inSampleSize = 1;
        }
        Bitmap bitmap = decodeFile(filename, opts.inSampleSize);
        if (bitmap == null) {
            return null;
        }
        if (fixRotation) {
            final int angle = getImageRotation(filename);
            if (angle != 0) {
                final Matrix matrix = new Matrix();
                matrix.postRotate((float)angle);
                bitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
            }
        }
        if (square && bitmap.getWidth() != bitmap.getHeight()) {
            if (bitmap.getWidth() > bitmap.getHeight()) {
                bitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - bitmap.getHeight()) / 2, 0, bitmap.getHeight(), bitmap.getHeight());
            }
            else if (bitmap.getWidth() < bitmap.getHeight()) {
                bitmap = Bitmap.createBitmap(bitmap, 0, (bitmap.getHeight() - bitmap.getWidth()) / 2, bitmap.getWidth(), bitmap.getWidth());
            }
        }
        return bitmap;
    }
    
    public static int getImageRotation(final InputStream fileStream) {
        return ExifUtils.getAngle(fileStream);
    }
    
    public static int getImageRotation(final String filename) {
        return ExifUtils.getAngle(filename);
    }
    
    public static Bitmap decodeResource(final Resources res, @DrawableRes @RawRes final int resId, final int minSize) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, opts);
        final int size = Math.max(opts.outWidth, opts.outHeight);
        if (size > minSize && minSize > 0) {
            opts.inSampleSize = size / minSize;
        }
        else {
            opts.inSampleSize = 1;
        }
        limitMemoryUsage(opts);
        opts.inJustDecodeBounds = false;
        return BitmapFactory.decodeResource(res, resId, opts);
    }
    
    public static Bitmap missingOrBrokenIcon() {
        Bitmap bitmap = BitmapFactory.decodeResource(IMGLY.getAppResource(), R.drawable.imgly_broken_or_missing_file);
        if (bitmap == null) {
            bitmap = BitmapFactoryUtils.NOTHING_BITMAP.copy(Bitmap.Config.ARGB_8888, false);
        }
        return bitmap;
    }
    
    public static Bitmap decodeStream(final InputStream stream, final int minSize) throws IOException {
        final BufferedInputStream bufferedInputStream = new BufferedInputStream(stream);
        try {
            final BitmapFactory.Options opts = new BitmapFactory.Options();
            opts.inJustDecodeBounds = true;
            bufferedInputStream.mark(Integer.MAX_VALUE);
            BitmapFactory.decodeStream((InputStream)bufferedInputStream, (Rect)null, opts);
            final int size = Math.max(opts.outWidth, opts.outHeight);
            if (size > minSize && minSize > 0) {
                opts.inSampleSize = size / minSize;
            }
            else {
                opts.inSampleSize = 1;
            }
            limitMemoryUsage(opts);
            opts.inJustDecodeBounds = false;
            bufferedInputStream.reset();
            bufferedInputStream.mark(8192);
            return BitmapFactory.decodeStream((InputStream)bufferedInputStream, (Rect)null, opts);
        }
        finally {
            bufferedInputStream.close();
        }
    }
    
    @NonNull
    public static int[] decodeSize(final Resources res, @DrawableRes @RawRes final int resId) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, opts);
        return new int[] { opts.outWidth, opts.outHeight };
    }
    
    @NonNull
    public static int[] decodeSize(final InputStream stream) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeStream(stream, (Rect)null, opts);
        return new int[] { opts.outWidth, opts.outHeight };
    }
    
    @NonNull
    public static float[] decodeSize(final String filename) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(filename, opts);
        return new float[] { (float)opts.outWidth, (float)opts.outHeight };
    }
    
    private static void limitMemoryUsage(@NonNull final BitmapFactory.Options options) {
        final float bufferScale = 2.0f;
        if (options.inSampleSize < 1) {
            options.inSampleSize = 1;
        }
        if (freeMemory() < options.outWidth * options.outHeight * 4 / (options.inSampleSize * options.inSampleSize) * 1.5f) {
            System.gc();
            System.gc();
        }
        while (freeMemory() < options.outWidth * options.outHeight * 4 / (options.inSampleSize * options.inSampleSize) * bufferScale) {
            ++options.inSampleSize;
        }
    }
    
    private static long freeMemory() {
        return MemoryUtility.getMaxFreeMemory();
    }
    
    public static Bitmap decodeResource(final Resources res, @DrawableRes @RawRes final int resId) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inPreferredConfig = Bitmap.Config.ARGB_8888;
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeResource(res, resId, opts);
        limitMemoryUsage(opts);
        opts.inJustDecodeBounds = false;
        final MemoryFile memoryFile = (MemoryFile)BitmapFactoryUtils.memoryFileHashMap.get(resId);
        if (memoryFile != null) {
            final TimeIt it = new TimeIt();
            it.start("Load from Memory");
            try {
                final Bitmap bitmap = Bitmap.createBitmap(opts.outWidth, opts.outHeight, Bitmap.Config.ARGB_8888);
                final InputStream stream = memoryFile.getInputStream();
                final byte[] bytes = new byte[4096];
                final ByteBuffer buffer = ByteBuffer.allocate(opts.outWidth * opts.outHeight * 4);
                while (stream.read(bytes) != -1) {
                    buffer.put(bytes);
                }
                buffer.rewind();
                bitmap.copyPixelsFromBuffer((Buffer)buffer);
                return bitmap;
            }
            catch (IOException ex) {}
            finally {
                it.count();
            }
        }
        return BitmapFactory.decodeResource(res, resId, opts);
    }
    
    public static void preloadResource(final Resources res, @DrawableRes @RawRes final int resId) {
        try {
            final Bitmap bitmap = decodeResource(res, resId);
            final MemoryFile memoryFile = new MemoryFile("Res_" + resId, bitmap.getByteCount());
            final OutputStream outputStream = memoryFile.getOutputStream();
            final ByteBuffer buffer = ByteBuffer.allocate(bitmap.getWidth() * bitmap.getHeight() * 4);
            bitmap.copyPixelsToBuffer((Buffer)buffer);
            buffer.rewind();
            outputStream.write(buffer.array());
            outputStream.close();
            BitmapFactoryUtils.memoryFileHashMap.put(resId, (Object)memoryFile);
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    public static Bitmap drawResource(@NonNull final Resources res, @DrawableRes final int resId, final int width, final int height) {
        final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        final Canvas canvas = new Canvas(bitmap);
        final Drawable d = res.getDrawable(resId);
        if (d != null) {
            d.setBounds(0, 0, width, height);
            d.draw(canvas);
        }
        return bitmap;
    }
    
    public static Bitmap drawResource(@NonNull final Resources res, @DrawableRes final int resId) {
        final Drawable d = res.getDrawable(resId);
        if (d != null) {
            final int width = Math.max(d.getIntrinsicWidth(), 1);
            final int height = Math.max(d.getIntrinsicHeight(), 1);
            final Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(bitmap);
            if (width != 1 && height != 1) {
                d.setBounds(0, 0, width, height);
            }
            d.draw(canvas);
            return bitmap;
        }
        return BitmapFactoryUtils.NOTHING_BITMAP;
    }
    
    private static Bitmap decodeFile(final String pathName, final int startInSampleSize) {
        final BitmapFactory.Options opts = new BitmapFactory.Options();
        opts.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(pathName, opts);
        limitMemoryUsage(opts);
        opts.inJustDecodeBounds = false;
        final int inSampleSize = startInSampleSize;
        opts.inSampleSize = inSampleSize;
        opts.inPreferQualityOverSpeed = false;
        opts.inDither = false;
        opts.inMutable = true;
        return BitmapFactory.decodeFile(pathName, opts);
    }
    
    public static boolean checkIsSvgResource(@DrawableRes @RawRes final int resourceID) {
        return checkResourceType(resourceID, "svg");
    }
    
    public static boolean checkIsXMLResource(@DrawableRes @RawRes final int resourceID) {
        return checkResourceType(resourceID, "xml");
    }
    
    public static boolean checkIsGifResource(@DrawableRes @RawRes final int resourceID) {
        return checkResourceType(resourceID, "gif");
    }
    
    public static boolean checkIsJpegResource(@DrawableRes @RawRes final int resourceID) {
        return checkResourceType(resourceID, "jpg", "jpeg");
    }
    
    public static boolean checkIsPngResource(@DrawableRes @RawRes final int resourceID) {
        return checkResourceType(resourceID, "png");
    }
    
    public static boolean checkResourceType(@DrawableRes @RawRes final int resourceID, final String... suffixes) {
        try {
            final Resources resources = PESDK.getAppResource();
            final TypedValue value = new TypedValue();
            resources.getValue(resourceID, value, true);
            final String name = value.string.toString().toLowerCase();
            for (final String suffix : suffixes) {
                if (name.endsWith("." + suffix)) {
                    return true;
                }
            }
        }
        catch (Resources.NotFoundException notFound) {
            return false;
        }
        return false;
    }
    
    public static String getResourceName(@DrawableRes @RawRes final int resourceID) {
        try {
            final Resources resources = PESDK.getAppResource();
            final TypedValue value = new TypedValue();
            resources.getValue(resourceID, value, true);
            final String path = value.coerceToString().toString();
            return path.substring(path.lastIndexOf("/") + 1);
        }
        catch (Resources.NotFoundException ex) {
            return null;
        }
    }
    
    static {
        NOTHING_BITMAP = Bitmap.createBitmap(1, 1, Bitmap.Config.ARGB_8888).copy(Bitmap.Config.ARGB_8888, false);
        NOTING_BITMAP = BitmapFactoryUtils.NOTHING_BITMAP;
        BitmapFactoryUtils.memoryFileHashMap = (SparseArray<MemoryFile>)new SparseArray();
    }
}
