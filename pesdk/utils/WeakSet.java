// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.Unit;
import java.util.Arrays;
import org.jetbrains.annotations.Nullable;
import androidx.annotation.CheckResult;
import java.util.concurrent.TimeUnit;
import androidx.annotation.WorkerThread;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.LinkedBlockingQueue;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J\u0013\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001a\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0013\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u001d\u0010\u001b\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001dH\u0002¢\u0006\u0002\u0010\u001eJ\u0006\u0010\u001f\u001a\u00020\u0017J\u0018\u0010 \u001a\u0004\u0018\u00018\u00002\u0006\u0010!\u001a\u00020\"H\u0086\u0002¢\u0006\u0002\u0010#J\b\u0010\t\u001a\u00020\u001dH\u0007J\u0006\u0010$\u001a\u00020\u0017J\u0013\u0010%\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u0000¢\u0006\u0002\u0010&J\u001b\u0010%\u001a\u00020\u001d2\u0006\u0010\u0018\u001a\u00028\u00002\u0006\u0010\u001c\u001a\u00020\u001d¢\u0006\u0002\u0010'R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\t\u001a\n \u000b*\u0004\u0018\u00010\n0\nX\u0082\u0004¢\u0006\u0002\n\u0000R*\u0010\f\u001a\u0010\u0012\f\u0012\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\u000e0\rX\u0084\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006(" }, d2 = { "Lly/img/android/pesdk/utils/WeakSet;", "E", "", "()V", "asyncAddQueue", "Ljava/util/concurrent/LinkedBlockingQueue;", "asyncRemoveQueue", "lock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "readLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "kotlin.jvm.PlatformType", "set", "", "Ljava/lang/ref/WeakReference;", "getSet", "()[Ljava/lang/ref/WeakReference;", "setSet", "([Ljava/lang/ref/WeakReference;)V", "[Ljava/lang/ref/WeakReference;", "strictFlushAddQueue", "Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;", "add", "", "e", "(Ljava/lang/Object;)V", "addOnceEqual", "addOnceStrict", "inSync", "", "(Ljava/lang/Object;Z)V", "clear", "get", "index", "", "(I)Ljava/lang/Object;", "readUnlock", "remove", "(Ljava/lang/Object;)Z", "(Ljava/lang/Object;Z)Z", "pesdk-backend-core_release" })
public class WeakSet<E>
{
    @NotNull
    private final ReentrantReadWriteLock lock;
    private final ReentrantReadWriteLock.ReadLock readLock;
    @NotNull
    private WeakReference<E>[] set;
    @NotNull
    private final LinkedBlockingQueue<E> asyncAddQueue;
    @NotNull
    private final LinkedBlockingQueue<E> asyncRemoveQueue;
    @NotNull
    private final ThreadUtils.ReplaceThreadRunnable strictFlushAddQueue;
    
    public WeakSet() {
        this.lock = new ReentrantReadWriteLock(true);
        this.readLock = this.lock.readLock();
        this.set = (WeakReference<E>[])new WeakReference[1];
        this.asyncAddQueue = new LinkedBlockingQueue<E>();
        this.asyncRemoveQueue = new LinkedBlockingQueue<E>();
        final String id$iv = "WeakSet_" + System.identityHashCode(this);
        final Object reference$iv = null;
        final int $i$f$ReplaceRunnable = 0;
        this.strictFlushAddQueue = new ThreadUtils.ReplaceThreadRunnable(id$iv + System.identityHashCode(reference$iv), this) {
            @WorkerThread
            @Override
            public void run() {
                final int n = 0;
                while (true) {
                    final Object poll;
                    final Object o = poll = WeakSet.access$getAsyncAddQueue$p(this.this$0).poll();
                    if (poll == null) {
                        break;
                    }
                    Intrinsics.checkNotNullExpressionValue(poll, "poll()");
                    final Object it = o;
                    final int n2 = 0;
                    this.this$0.addOnceStrict(it, true);
                }
                while (true) {
                    final Object poll2;
                    final Object o2 = poll2 = WeakSet.access$getAsyncRemoveQueue$p(this.this$0).poll();
                    if (poll2 == null) {
                        break;
                    }
                    Intrinsics.checkNotNullExpressionValue(poll2, "poll()");
                    final Object it = o2;
                    final int n3 = 0;
                    this.this$0.remove(it, true);
                }
            }
        };
    }
    
    @NotNull
    protected final WeakReference<E>[] getSet() {
        return this.set;
    }
    
    protected final void setSet(@NotNull final WeakReference<E>[] <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.set = <set-?>;
    }
    
    @CheckResult
    public final boolean readLock() {
        final boolean it = this.readLock.tryLock(1L, TimeUnit.SECONDS);
        final int n = 0;
        if (!it) {
            Trace.out("WeakSet readLock failed", Trace.stackAll());
        }
        return it;
    }
    
    @Nullable
    public final E get(final int index) {
        for (int j = index; j < this.set.length; ++j) {
            final WeakReference<E> weakReference = this.set[j];
            if (weakReference != null) {
                final Object value = weakReference.get();
                if (value != null) {
                    return (E)value;
                }
            }
        }
        return null;
    }
    
    public final void readUnlock() {
        this.readLock.unlock();
    }
    
    public final void addOnceEqual(final E e) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/WeakSet.lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //     4: astore_2       
        //     5: aload_2        
        //     6: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //     9: astore_3       
        //    10: aload_2        
        //    11: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    14: ifne            24
        //    17: aload_2        
        //    18: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    21: goto            25
        //    24: iconst_0       
        //    25: istore          4
        //    27: iconst_0       
        //    28: istore          5
        //    30: iload           5
        //    32: iload           4
        //    34: if_icmpge       47
        //    37: aload_3        
        //    38: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    41: iinc            5, 1
        //    44: goto            30
        //    47: aload_2        
        //    48: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    51: astore          5
        //    53: aload           5
        //    55: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    58: nop            
        //    59: iconst_0       
        //    60: istore          $i$a$-write-WeakSet$addOnceEqual$1
        //    62: iconst_1       
        //    63: istore          doAdd
        //    65: iconst_m1      
        //    66: istore          destination
        //    68: iconst_0       
        //    69: istore          i
        //    71: aload_0         /* this */
        //    72: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    75: arraylength    
        //    76: istore          10
        //    78: iload           i
        //    80: iload           10
        //    82: if_icmpge       157
        //    85: aload_0         /* this */
        //    86: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    89: iload           i
        //    91: aaload         
        //    92: dup            
        //    93: ifnull          102
        //    96: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    99: goto            104
        //   102: pop            
        //   103: aconst_null    
        //   104: astore          value
        //   106: aload           value
        //   108: ifnonnull       136
        //   111: aload_0         /* this */
        //   112: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   115: iload           i
        //   117: new             Ljava/lang/ref/WeakReference;
        //   120: dup            
        //   121: aload_1         /* e */
        //   122: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   125: aastore        
        //   126: iconst_1       
        //   127: istore          doAdd
        //   129: iload           i
        //   131: istore          destination
        //   133: goto            151
        //   136: aload           value
        //   138: aload_1         /* e */
        //   139: invokestatic    kotlin/jvm/internal/Intrinsics.areEqual:(Ljava/lang/Object;Ljava/lang/Object;)Z
        //   142: ifeq            151
        //   145: iconst_0       
        //   146: istore          doAdd
        //   148: goto            157
        //   151: iinc            i, 1
        //   154: goto            78
        //   157: iload           doAdd
        //   159: ifeq            248
        //   162: iload           destination
        //   164: iconst_m1      
        //   165: if_icmpne       233
        //   168: aload_0         /* this */
        //   169: aload_0         /* this */
        //   170: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   173: aload_0         /* this */
        //   174: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   177: arraylength    
        //   178: iconst_1       
        //   179: iadd           
        //   180: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   183: dup            
        //   184: ldc             "copyOf(this, newSize)"
        //   186: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   189: astore          9
        //   191: aload           9
        //   193: checkcast       [Ljava/lang/ref/WeakReference;
        //   196: astore          10
        //   198: astore          12
        //   200: iconst_0       
        //   201: istore          $i$a$-also-WeakSet$addOnceEqual$1$1
        //   203: aload           it
        //   205: aload_0         /* this */
        //   206: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   209: arraylength    
        //   210: new             Ljava/lang/ref/WeakReference;
        //   213: dup            
        //   214: aload_1         /* e */
        //   215: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   218: aastore        
        //   219: nop            
        //   220: aload           12
        //   222: aload           9
        //   224: checkcast       [Ljava/lang/ref/WeakReference;
        //   227: putfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   230: goto            248
        //   233: aload_0         /* this */
        //   234: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   237: iload           destination
        //   239: new             Ljava/lang/ref/WeakReference;
        //   242: dup            
        //   243: aload_1         /* e */
        //   244: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   247: aastore        
        //   248: nop            
        //   249: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   252: astore          6
        //   254: iconst_0       
        //   255: istore          7
        //   257: iload           7
        //   259: iload           4
        //   261: if_icmpge       274
        //   264: aload_3        
        //   265: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   268: iinc            7, 1
        //   271: goto            257
        //   274: aload           5
        //   276: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   279: goto            312
        //   282: astore          6
        //   284: iconst_0       
        //   285: istore          7
        //   287: iload           7
        //   289: iload           4
        //   291: if_icmpge       304
        //   294: aload_3        
        //   295: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   298: iinc            7, 1
        //   301: goto            287
        //   304: aload           5
        //   306: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   309: aload           6
        //   311: athrow         
        //   312: return         
        //    Signature:
        //  (TE;)V
        //    StackMapTable: 00 12 FD 00 18 07 00 0B 07 00 6B 40 01 FD 00 04 01 01 10 FF 00 1E 00 0B 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 01 01 01 01 01 00 00 57 07 00 1B 41 07 00 05 FC 00 1F 07 00 05 0E FA 00 05 FB 00 4B F9 00 0E FF 00 08 00 09 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 07 00 B0 01 01 00 00 10 FF 00 07 00 06 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 00 01 07 00 BF FD 00 04 07 00 BF 01 10 FF 00 07 00 09 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 07 00 B0 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  58     254    282    312    Any
        //  282    284    282    312    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final void addOnceStrict(final E e) {
        this.addOnceStrict(e, false);
    }
    
    private final void addOnceStrict(final E e, final boolean inSync) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/WeakSet.lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //     7: astore_3        /* lock */
        //     8: iload_2         /* inSync */
        //     9: ifeq            20
        //    12: aload_3         /* lock */
        //    13: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    16: iconst_1       
        //    17: goto            24
        //    20: aload_3         /* lock */
        //    21: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.tryLock:()Z
        //    24: istore          isLocked
        //    26: iload           isLocked
        //    28: ifeq            224
        //    31: iconst_1       
        //    32: istore          doAdd
        //    34: iconst_m1      
        //    35: istore          destination
        //    37: iconst_0       
        //    38: istore          i
        //    40: aload_0         /* this */
        //    41: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    44: arraylength    
        //    45: istore          8
        //    47: iload           i
        //    49: iload           8
        //    51: if_icmpge       126
        //    54: aload_0         /* this */
        //    55: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    58: iload           i
        //    60: aaload         
        //    61: dup            
        //    62: ifnull          71
        //    65: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //    68: goto            73
        //    71: pop            
        //    72: aconst_null    
        //    73: astore          value
        //    75: aload           value
        //    77: aload_1         /* e */
        //    78: if_acmpne       87
        //    81: iconst_0       
        //    82: istore          doAdd
        //    84: goto            126
        //    87: aload           value
        //    89: ifnonnull       120
        //    92: iload           destination
        //    94: iconst_m1      
        //    95: if_icmpne       120
        //    98: aload_0         /* this */
        //    99: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   102: iload           i
        //   104: new             Ljava/lang/ref/WeakReference;
        //   107: dup            
        //   108: aload_1         /* e */
        //   109: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   112: aastore        
        //   113: iconst_1       
        //   114: istore          doAdd
        //   116: iload           i
        //   118: istore          destination
        //   120: iinc            i, 1
        //   123: goto            47
        //   126: iload           doAdd
        //   128: ifeq            217
        //   131: iload           destination
        //   133: iconst_m1      
        //   134: if_icmpne       202
        //   137: aload_0         /* this */
        //   138: aload_0         /* this */
        //   139: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   142: aload_0         /* this */
        //   143: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   146: arraylength    
        //   147: iconst_1       
        //   148: iadd           
        //   149: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   152: dup            
        //   153: ldc             "copyOf(this, newSize)"
        //   155: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   158: astore          7
        //   160: aload           7
        //   162: checkcast       [Ljava/lang/ref/WeakReference;
        //   165: astore          8
        //   167: astore          10
        //   169: iconst_0       
        //   170: istore          $i$a$-also-WeakSet$addOnceStrict$1
        //   172: aload           it
        //   174: aload_0         /* this */
        //   175: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   178: arraylength    
        //   179: new             Ljava/lang/ref/WeakReference;
        //   182: dup            
        //   183: aload_1         /* e */
        //   184: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   187: aastore        
        //   188: nop            
        //   189: aload           10
        //   191: aload           7
        //   193: checkcast       [Ljava/lang/ref/WeakReference;
        //   196: putfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   199: goto            217
        //   202: aload_0         /* this */
        //   203: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   206: iload           destination
        //   208: new             Ljava/lang/ref/WeakReference;
        //   211: dup            
        //   212: aload_1         /* e */
        //   213: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   216: aastore        
        //   217: aload_3         /* lock */
        //   218: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   221: goto            240
        //   224: aload_0         /* this */
        //   225: getfield        ly/img/android/pesdk/utils/WeakSet.asyncAddQueue:Ljava/util/concurrent/LinkedBlockingQueue;
        //   228: aload_1         /* e */
        //   229: invokevirtual   java/util/concurrent/LinkedBlockingQueue.add:(Ljava/lang/Object;)Z
        //   232: pop            
        //   233: aload_0         /* this */
        //   234: getfield        ly/img/android/pesdk/utils/WeakSet.strictFlushAddQueue:Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   237: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable.invoke:()V
        //   240: return         
        //    Signature:
        //  (TE;Z)V
        //    StackMapTable: 00 0C FC 00 14 07 00 9A 43 01 FF 00 16 00 09 07 00 02 07 00 05 01 07 00 9A 01 01 01 01 01 00 00 57 07 00 1B 41 07 00 05 FC 00 0D 07 00 05 20 FA 00 05 FB 00 4B F9 00 0E F9 00 06 0F
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final void add(final E e) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/WeakSet.lock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //     4: astore_2       
        //     5: aload_2        
        //     6: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //     9: astore_3       
        //    10: aload_2        
        //    11: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    14: ifne            24
        //    17: aload_2        
        //    18: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    21: goto            25
        //    24: iconst_0       
        //    25: istore          4
        //    27: iconst_0       
        //    28: istore          5
        //    30: iload           5
        //    32: iload           4
        //    34: if_icmpge       47
        //    37: aload_3        
        //    38: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    41: iinc            5, 1
        //    44: goto            30
        //    47: aload_2        
        //    48: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    51: astore          5
        //    53: aload           5
        //    55: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    58: nop            
        //    59: iconst_0       
        //    60: istore          $i$a$-write-WeakSet$add$1
        //    62: iconst_0       
        //    63: istore          doNotFit
        //    65: iconst_1       
        //    66: istore          doNotFit
        //    68: iconst_0       
        //    69: istore          i
        //    71: aload_0         /* this */
        //    72: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    75: arraylength    
        //    76: istore          9
        //    78: iload           i
        //    80: iload           9
        //    82: if_icmpge       157
        //    85: aload_0         /* this */
        //    86: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //    89: astore          10
        //    91: iload           i
        //    93: iflt            114
        //    96: iload           i
        //    98: aload           10
        //   100: invokestatic    kotlin/collections/ArraysKt.getLastIndex:([Ljava/lang/Object;)I
        //   103: if_icmpgt       114
        //   106: aload           10
        //   108: iload           i
        //   110: aaload         
        //   111: goto            133
        //   114: iload           i
        //   116: istore          it
        //   118: iconst_0       
        //   119: istore          $i$a$-getOrElse-WeakSet$add$1$1
        //   121: iconst_0       
        //   122: istore          doNotFit
        //   124: new             Ljava/lang/ref/WeakReference;
        //   127: dup            
        //   128: aload_1         /* e */
        //   129: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   132: nop            
        //   133: astore          13
        //   135: aload           13
        //   137: ifnull          146
        //   140: aload           13
        //   142: invokevirtual   java/lang/ref/WeakReference.get:()Ljava/lang/Object;
        //   145: pop            
        //   146: iload           doNotFit
        //   148: ifeq            157
        //   151: iinc            i, 1
        //   154: goto            78
        //   157: iload           doNotFit
        //   159: ifeq            224
        //   162: aload_0         /* this */
        //   163: aload_0         /* this */
        //   164: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   167: aload_0         /* this */
        //   168: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   171: arraylength    
        //   172: iconst_1       
        //   173: iadd           
        //   174: invokestatic    java/util/Arrays.copyOf:([Ljava/lang/Object;I)[Ljava/lang/Object;
        //   177: dup            
        //   178: ldc             "copyOf(this, newSize)"
        //   180: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   183: astore          8
        //   185: aload           8
        //   187: checkcast       [Ljava/lang/ref/WeakReference;
        //   190: astore          9
        //   192: astore          14
        //   194: iconst_0       
        //   195: istore          $i$a$-also-WeakSet$add$1$2
        //   197: aload           it
        //   199: aload_0         /* this */
        //   200: getfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   203: arraylength    
        //   204: new             Ljava/lang/ref/WeakReference;
        //   207: dup            
        //   208: aload_1         /* e */
        //   209: invokespecial   java/lang/ref/WeakReference.<init>:(Ljava/lang/Object;)V
        //   212: aastore        
        //   213: nop            
        //   214: aload           14
        //   216: aload           8
        //   218: checkcast       [Ljava/lang/ref/WeakReference;
        //   221: putfield        ly/img/android/pesdk/utils/WeakSet.set:[Ljava/lang/ref/WeakReference;
        //   224: nop            
        //   225: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   228: astore          6
        //   230: iconst_0       
        //   231: istore          7
        //   233: iload           7
        //   235: iload           4
        //   237: if_icmpge       250
        //   240: aload_3        
        //   241: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   244: iinc            7, 1
        //   247: goto            233
        //   250: aload           5
        //   252: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   255: goto            288
        //   258: astore          6
        //   260: iconst_0       
        //   261: istore          7
        //   263: iload           7
        //   265: iload           4
        //   267: if_icmpge       280
        //   270: aload_3        
        //   271: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   274: iinc            7, 1
        //   277: goto            263
        //   280: aload           5
        //   282: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   285: aload           6
        //   287: athrow         
        //   288: return         
        //    Signature:
        //  (TE;)V
        //    StackMapTable: 00 10 FD 00 18 07 00 0B 07 00 6B 40 01 FD 00 04 01 01 10 FF 00 1E 00 0A 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 01 01 01 01 00 00 FC 00 23 07 00 AE 52 07 00 1B FE 00 0C 00 00 07 00 1B FF 00 0A 00 0A 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 01 01 01 01 00 00 F9 00 42 FF 00 08 00 08 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 07 00 B0 01 00 00 10 FF 00 07 00 06 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 00 01 07 00 BF FD 00 04 07 00 BF 01 10 FF 00 07 00 08 07 00 02 07 00 05 07 00 0B 07 00 6B 01 07 00 9A 07 00 B0 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  58     230    258    288    Any
        //  258    260    258    288    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public final boolean remove(final E e) {
        return this.remove(e, false);
    }
    
    public final boolean remove(final E e, final boolean inSync) {
        boolean result = false;
        try {
            final ReentrantReadWriteLock.WriteLock writeLock = this.lock.writeLock();
            boolean tryLock;
            if (inSync) {
                writeLock.lock();
                tryLock = true;
            }
            else {
                tryLock = writeLock.tryLock();
            }
            final boolean isLocked = tryLock;
            if (isLocked) {
                for (int i = 0; i < this.set.length; ++i) {
                    final WeakReference<E> weakReference = this.set[i];
                    final Object value = (weakReference != null) ? weakReference.get() : null;
                    if (value == e) {
                        this.set[i] = null;
                        result = true;
                        break;
                    }
                }
                writeLock.unlock();
            }
            else {
                this.asyncRemoveQueue.add(e);
                ((ThreadUtils.WorkerThreadRunnable)this.strictFlushAddQueue).invoke();
            }
        }
        catch (InterruptedException e2) {
            e2.printStackTrace();
        }
        return result;
    }
    
    public final void clear() {
        final ReentrantReadWriteLock lock = this.lock;
        final ReentrantReadWriteLock.ReadLock lock2 = lock.readLock();
        final int n = (lock.getWriteHoldCount() == 0) ? lock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock2.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            Arrays.fill(this.set, null);
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock2.lock();
            }
            writeLock.unlock();
        }
    }
    
    public static final /* synthetic */ LinkedBlockingQueue access$getAsyncAddQueue$p(final WeakSet $this) {
        return $this.asyncAddQueue;
    }
    
    public static final /* synthetic */ LinkedBlockingQueue access$getAsyncRemoveQueue$p(final WeakSet $this) {
        return $this.asyncRemoveQueue;
    }
}
