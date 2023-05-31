// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Iterator;
import androidx.annotation.IntRange;
import android.os.Looper;
import android.os.Handler;

public class TimeOutObject<T>
{
    private volatile TimerThread timerThread;
    private volatile long releaseTime;
    private Callback<T> callback;
    private final Handler mainLoopHandler;
    private final WeakCallSet<T> objects;
    
    public TimeOutObject() {
        this.objects = new WeakCallSet<T>() {};
        this.mainLoopHandler = new Handler(Looper.getMainLooper());
    }
    
    public TimeOutObject<T> setTimeOut(@IntRange(from = 10L) final int timeoutMilliseconds, final T object) {
        this.releaseTime = System.currentTimeMillis() + timeoutMilliseconds;
        this.objects.addOnceStrict(object);
        this.startTimerThread();
        return this;
    }
    
    private void startTimerThread() {
        if (this.timerThread == null) {
            (this.timerThread = new TimerThread()).start();
        }
    }
    
    private synchronized void onTimeOut() {
        final Iterator<T> iterator;
        T object;
        this.mainLoopHandler.post(() -> {
            this.timerThread = null;
            if (this.waitForTimeout() >= 1L) {
                this.startTimerThread();
            }
            else {
                this.objects.iterator();
                while (iterator.hasNext()) {
                    object = iterator.next();
                    this.callback.onTimeOut(object);
                }
            }
        });
    }
    
    private long waitForTimeout() {
        return this.releaseTime - System.currentTimeMillis();
    }
    
    public TimeOutObject<T> setCallback(final Callback<T> callback) {
        this.callback = callback;
        return this;
    }
    
    private class TimerThread extends Thread implements Runnable
    {
        @Override
        public void run() {
            super.run();
            long time;
            while ((time = TimeOutObject.this.waitForTimeout()) >= 1L) {
                try {
                    Thread.sleep(time);
                }
                catch (InterruptedException ex) {}
            }
            TimeOutObject.this.onTimeOut();
        }
    }
    
    public interface Callback<T>
    {
        void onTimeOut(final T p0);
    }
}
