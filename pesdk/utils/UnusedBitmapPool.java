// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.concurrent.locks.ReentrantLock;
import androidx.annotation.Nullable;
import androidx.annotation.AnyThread;
import androidx.annotation.NonNull;
import android.graphics.Bitmap;
import java.util.LinkedHashSet;
import ly.img.android.pesdk.backend.model.ImageSize;
import android.util.LruCache;
import java.util.concurrent.locks.Lock;

public class UnusedBitmapPool
{
    private static final UnusedBitmapPool instance;
    private static final Lock lock;
    private LruCache<ImageSize, LinkedHashSet<Bitmap>> bitmapSizePool;
    
    private UnusedBitmapPool() {
        this.bitmapSizePool = new LruCache<ImageSize, LinkedHashSet<Bitmap>>(Math.min((int)(Runtime.getRuntime().maxMemory() / 10L), 2147483646)) {
            protected int sizeOf(final ImageSize key, @NonNull final LinkedHashSet<Bitmap> bitmapPool) {
                return key.width * key.height * bitmapPool.size() * 4;
            }
        };
    }
    
    @NonNull
    @AnyThread
    public Bitmap createBitmap(final int width, final int height, final Bitmap.Config config) {
        return this.createBitmap(new ImageSize(width, height, config));
    }
    
    @Nullable
    @AnyThread
    public Bitmap getBitmap(final int width, final int height, final Bitmap.Config config) {
        return this.getBitmap(new ImageSize(width, height, config));
    }
    
    @Nullable
    @AnyThread
    public Bitmap getBitmap(final ImageSize size) {
        return null;
    }
    
    @NonNull
    @AnyThread
    public Bitmap createBitmap(@NonNull final ImageSize size) {
        Bitmap bitmap = this.getBitmap(size);
        if (bitmap == null) {
            if (size.width > 0 && size.height > 0) {
                bitmap = Bitmap.createBitmap(size.width, size.height, size.config);
            }
            else {
                bitmap = Bitmap.createBitmap(1, 1, Bitmap.Config.ALPHA_8);
            }
        }
        else {
            bitmap.eraseColor(0);
        }
        return bitmap;
    }
    
    @AnyThread
    public UnusedBitmapPool recycle(final Bitmap bitmap) {
        return this;
    }
    
    private void add(final ImageSize size, final Bitmap bitmap) {
        LinkedHashSet<Bitmap> bitmapPool = (LinkedHashSet<Bitmap>)this.bitmapSizePool.get((Object)size);
        if (bitmapPool == null) {
            bitmapPool = new LinkedHashSet<Bitmap>();
        }
        bitmapPool.add(bitmap);
        this.bitmapSizePool.remove((Object)size);
    }
    
    @AnyThread
    public static UnusedBitmapPool get() {
        return UnusedBitmapPool.instance;
    }
    
    static {
        instance = new UnusedBitmapPool();
        lock = new ReentrantLock();
    }
}
