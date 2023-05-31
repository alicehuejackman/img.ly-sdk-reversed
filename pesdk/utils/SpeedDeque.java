// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;
import ly.img.android.pesdk.backend.model.chunk.Recycler;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0015B\u0005¢\u0006\u0002\u0010\u0003J\u0006\u0010\f\u001a\u00020\rJ\u0006\u0010\u000e\u001a\u00020\u000fJ\r\u0010\u0010\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u0011J\u0013\u0010\u0012\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00000\u00050\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/utils/SpeedDeque;", "T", "", "()V", "head", "Lly/img/android/pesdk/utils/SpeedDeque$Node;", "nodeRecycler", "Lly/img/android/pesdk/backend/model/chunk/Recycler;", "pollLock", "Ljava/util/concurrent/locks/ReentrantLock;", "putLock", "tail", "clear", "", "isNotEmpty", "", "poll", "()Ljava/lang/Object;", "put", "element", "(Ljava/lang/Object;)V", "Node", "pesdk-backend-core_release" })
public final class SpeedDeque<T>
{
    @NotNull
    private final Recycler<Node<T>> nodeRecycler;
    @NotNull
    private final ReentrantLock putLock;
    @NotNull
    private final ReentrantLock pollLock;
    @NotNull
    private Node<T> head;
    @NotNull
    private Node<T> tail;
    
    public SpeedDeque() {
        this.nodeRecycler = new Recycler<Node<T>>(10000, (kotlin.jvm.functions.Function0<? extends Node<T>>)SpeedDeque$nodeRecycler.SpeedDeque$nodeRecycler$1.INSTANCE);
        this.putLock = new ReentrantLock(true);
        this.pollLock = new ReentrantLock(true);
        this.head = new Node<T>();
        this.tail = this.head;
    }
    
    public final boolean isNotEmpty() {
        return this.head.value != null;
    }
    
    public final void put(final T element) {
        final ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            if (this.tail.value == null) {
                this.tail.value = element;
            }
            else {
                final Node<T> obtain = this.nodeRecycler.obtain();
                final Node it = obtain;
                final int n2 = 0;
                it.next = null;
                it.value = (T)element;
                final Node newNode = obtain;
                this.tail.next = (Node<T>)newNode;
                this.tail = (Node<T>)newNode;
            }
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Nullable
    public final T poll() {
        Object recyclableNode = null;
        try {
            final ReentrantLock reentrantLock = this.pollLock;
            reentrantLock.lock();
            try {
                final int n = 0;
                final Node next = this.head.next;
                final Object element = this.head.value;
                if (next != null) {
                    this.head.next = null;
                    this.head.value = null;
                    recyclableNode = this.head;
                    this.head = (Node<T>)next;
                }
                else {
                    this.head.value = null;
                }
                final Object o = element;
                reentrantLock.unlock();
                final T t = (T)o;
                final Object o2 = recyclableNode;
                if (o2 != null) {
                    final Node it = (Node)o2;
                    final int n2 = 0;
                    this.nodeRecycler.recycle(it);
                }
                return t;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        finally {
            final Node node = (Node)recyclableNode;
            if (node != null) {
                final Node it2 = node;
                final int n3 = 0;
                this.nodeRecycler.recycle(it2);
            }
        }
    }
    
    public final void clear() {
        final ReentrantLock reentrantLock = this.putLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            final ReentrantLock reentrantLock2 = this.pollLock;
            reentrantLock2.lock();
            try {
                final int n2 = 0;
                this.head.next = null;
                this.head.value = null;
                final Unit instance = Unit.INSTANCE;
            }
            finally {
                reentrantLock2.unlock();
            }
            final Unit instance2 = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\u0004\u0018\u00018\u00018\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u0006¨\u0006\u0007" }, d2 = { "Lly/img/android/pesdk/utils/SpeedDeque$Node;", "T", "", "()V", "next", "value", "Ljava/lang/Object;", "pesdk-backend-core_release" })
    public static final class Node<T>
    {
        @JvmField
        @Nullable
        public Node<T> next;
        @JvmField
        @Nullable
        public T value;
    }
}
