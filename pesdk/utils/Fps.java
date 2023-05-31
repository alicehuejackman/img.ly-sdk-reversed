// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.os.Handler;
import androidx.annotation.Nullable;

public class Fps implements Runnable
{
    @Nullable
    Callback mCallback;
    private final Handler mHandler;
    private final Runnable mCallbackRunner;
    volatile int mFrameCount;
    @Nullable
    private Thread mThread;
    
    public Fps(@Nullable final Callback callback) {
        this.mHandler = new Handler();
        this.mCallbackRunner = new Runnable() {
            @Override
            public void run() {
                Fps.this.mCallback.onFps(Fps.this.mFrameCount);
                Fps.this.mFrameCount = 0;
            }
        };
        if (callback == null) {
            throw new NullPointerException("Callback must not be null");
        }
        this.mCallback = callback;
    }
    
    public void start() {
        synchronized (this) {
            this.stop();
            this.mFrameCount = 0;
            (this.mThread = new Thread(this)).start();
        }
    }
    
    public void stop() {
        synchronized (this) {
            this.mThread = null;
        }
    }
    
    public void countup() {
        ++this.mFrameCount;
    }
    
    @Override
    public void run() {
        try {
            while (true) {
                Thread.sleep(1000L);
                synchronized (this) {
                    if (this.mThread == null || this.mThread != Thread.currentThread()) {
                        break;
                    }
                }
                this.mHandler.post(this.mCallbackRunner);
            }
        }
        catch (InterruptedException e) {}
    }
    
    public interface Callback
    {
        void onFps(final int p0);
    }
}
