// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Iterator;
import androidx.annotation.IntRange;
import android.os.Looper;
import android.os.Handler;

public class TimeOut<T extends Enum<?>>
{
    private volatile TimerThread timerThread;
    private volatile long releaseTime;
    private final CallbackHandler callbackHandler;
    private final Handler mainLoopHandler;
    private final T identifier;
    
    public TimeOut(final T identifier) {
        this.identifier = identifier;
        this.callbackHandler = new CallbackHandler();
        this.mainLoopHandler = new Handler(Looper.getMainLooper());
    }
    
    public TimeOut<T> setTimeOut(@IntRange(from = 10L) final int timeoutMilliseconds) {
        this.releaseTime = System.currentTimeMillis() + timeoutMilliseconds;
        this.startTimerThread();
        return this;
    }
    
    private synchronized void startTimerThread() {
        TimerThread timerThread = this.timerThread;
        if (timerThread == null) {
            timerThread = new TimerThread();
            (this.timerThread = timerThread).start();
        }
    }
    
    private synchronized void onTimeOut() {
        this.mainLoopHandler.post(() -> {
            this.timerThread = null;
            if (this.waitForTimeout() >= 1L) {
                this.startTimerThread();
            }
            else {
                this.callbackHandler.onTimeOut(this.identifier);
            }
        });
    }
    
    private long waitForTimeout() {
        return this.releaseTime - System.currentTimeMillis();
    }
    
    public TimeOut<T> addCallback(final Callback<T> callback) {
        this.callbackHandler.add(callback);
        return this;
    }
    
    private class CallbackHandler extends CallSet<Callback<T>>
    {
        void onTimeOut(final T identifier) {
            for (final Callback<T> callback : this) {
                callback.onTimeOut(identifier);
            }
        }
    }
    
    private class TimerThread extends Thread implements Runnable
    {
        @Override
        public void run() {
            super.run();
            long wait;
            while ((wait = TimeOut.this.waitForTimeout()) >= 1L) {
                try {
                    Thread.sleep(wait);
                }
                catch (InterruptedException ex) {}
            }
            TimeOut.this.onTimeOut();
        }
    }
    
    public interface Callback<T extends Enum<?>>
    {
        void onTimeOut(final T p0);
    }
}
