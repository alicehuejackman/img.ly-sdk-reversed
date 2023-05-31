// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Iterator;
import java.util.concurrent.locks.ReentrantLock;
import java.util.ArrayList;
import java.util.concurrent.locks.Lock;

public class CallSet<E> implements Iterable<E>
{
    private final Lock lock;
    public final ArrayList<E> set;
    private final SingleIterator iterator;
    
    public CallSet() {
        this.lock = new ReentrantLock(true);
        this.iterator = new SingleIterator();
        this.set = new ArrayList<E>();
    }
    
    @Override
    public Iterator<E> iterator() {
        this.lock.lock();
        this.iterator.index = 0;
        return this.iterator;
    }
    
    public void add(final E e) {
        this.lock.lock();
        this.set.remove(e);
        this.set.add(e);
        this.lock.unlock();
    }
    
    public void remove(final E e) {
        this.lock.lock();
        this.set.remove(e);
        this.lock.unlock();
    }
    
    public void clear() {
        this.lock.lock();
        this.set.clear();
        this.lock.unlock();
    }
    
    private final class SingleIterator implements Iterator<E>
    {
        protected int index;
        
        private SingleIterator() {
            this.index = 0;
        }
        
        @Override
        public boolean hasNext() {
            final int size = CallSet.this.set.size();
            if (size > this.index) {
                return true;
            }
            CallSet.this.lock.unlock();
            return false;
        }
        
        @Override
        public E next() {
            return CallSet.this.set.get(this.index++);
        }
    }
}
