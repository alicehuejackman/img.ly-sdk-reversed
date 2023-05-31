// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.MainThread;
import android.graphics.PorterDuff;
import androidx.annotation.Nullable;
import androidx.annotation.WorkerThread;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.Lock;
import android.graphics.Bitmap;
import android.graphics.Canvas;

public class BitmapLayer extends Canvas
{
    private Bitmap bitmap1;
    private Bitmap bitmap2;
    private Bitmap buffer;
    public final int width;
    public final int height;
    private Bitmap.Config config;
    private final Lock bufferLock;
    
    @WorkerThread
    public BitmapLayer(final int width, final int height, final Bitmap.Config config) {
        this.bufferLock = new ReentrantLock(true);
        this.width = Math.max(width, 1);
        this.height = Math.max(height, 1);
        this.config = config;
        this.bitmap1 = UnusedBitmapPool.get().createBitmap(this.width, this.height, this.config);
        this.buffer = this.bitmap2;
        this.setBitmap(this.bitmap1);
    }
    
    public BitmapLayer(final float width, final float height, final Bitmap.Config config) {
        this((int)Math.ceil(width), (int)Math.ceil(height), config);
    }
    
    public void recycle() {
        if (this.bitmap1 != null && !this.bitmap1.isRecycled()) {
            this.bitmap1.recycle();
        }
        if (this.bitmap2 != null && !this.bitmap2.isRecycled()) {
            this.bitmap2.recycle();
        }
    }
    
    public void startBuffer() {
        try {
            this.bufferLock.lockInterruptibly();
        }
        catch (InterruptedException ignored) {
            this.bufferLock.lock();
        }
        this.bitmap2 = ((this.bitmap2 == null) ? UnusedBitmapPool.get().createBitmap(this.width, this.height, this.config) : this.bitmap2);
        this.setBitmap(this.buffer);
        this.clear();
    }
    
    public void setBitmap(@Nullable final Bitmap bitmap) {
        if (bitmap != null && !bitmap.isRecycled() && bitmap.isMutable()) {
            super.setBitmap(bitmap);
        }
    }
    
    public void stopBuffer() {
        this.buffer = ((this.buffer == this.bitmap2) ? this.bitmap1 : this.bitmap2);
        this.bufferLock.unlock();
    }
    
    public boolean matchSize(final int width, final int height) {
        return this.width == width && this.height == height;
    }
    
    public Bitmap getBitmap() {
        return (this.buffer == this.bitmap2) ? this.bitmap1 : this.bitmap2;
    }
    
    public BitmapLayer clear() {
        this.drawColor(0, PorterDuff.Mode.CLEAR);
        return this;
    }
    
    public static final class ConcurrentLayer
    {
        private final Lock lock;
        private BitmapLayer layer;
        public final int width;
        public final int height;
        
        public ConcurrentLayer(final int width, final int height, final Bitmap.Config config) {
            this.width = width;
            this.height = height;
            this.lock = new ReentrantLock(true);
            this.layer = new BitmapLayer(width, height, config);
        }
        
        @WorkerThread
        public BitmapLayer lock() {
            try {
                this.lock.lockInterruptibly();
            }
            catch (InterruptedException e) {
                e.printStackTrace();
            }
            return this.layer;
        }
        
        @WorkerThread
        @MainThread
        public BitmapLayer getLockedLayer() {
            return this.layer;
        }
        
        @WorkerThread
        @MainThread
        public void unlock() {
            try {
                this.lock.unlock();
            }
            catch (IllegalStateException ex) {}
            catch (IllegalMonitorStateException ex2) {}
        }
    }
}
