// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.atomic.AtomicInteger;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.functions.Function0;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;
import java.io.Serializable;
import kotlin.Lazy;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000V\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000e\n\u0002\b\u0005\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003:\u00010B]\u0012#\b\u0002\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005\u0012#\b\u0002\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\u0005\u0012\f\u0010\f\u001a\b\u0012\u0004\u0012\u00028\u00000\r¢\u0006\u0002\u0010\u000eJ\u0006\u0010\u001e\u001a\u00020\u000bJ\u0006\u0010\u001f\u001a\u00020\u000bJ\u0006\u0010 \u001a\u00020\u000bJ\r\u0010!\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001dJ0\u0010!\u001a\u0004\u0018\u00018\u00002!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\u0005¢\u0006\u0002\u0010#J\u0006\u0010$\u001a\u00020\tJ\u0017\u0010%\u001a\u0004\u0018\u00018\u00002\b\b\u0002\u0010&\u001a\u00020\t¢\u0006\u0002\u0010'J\r\u0010(\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001dJ\r\u0010)\u001a\u0004\u0018\u00018\u0000¢\u0006\u0002\u0010\u001dJ\b\u0010*\u001a\u00020\tH\u0016J\b\u0010+\u001a\u00020,H\u0016J<\u0010-\u001a\u0004\u0018\u0001H.\"\u0004\b\u0001\u0010.2!\u0010\"\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u0002H.0\u0005H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010#J\b\u0010/\u001a\u00020\u0010H\u0002R\"\u0010\u0011\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0012\u0010\u0013R)\u0010\n\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u000b0\u0005X\u0088\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0004\u0012\u00028\u0000\u0018\u00010\rX\u0088\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0014\u001a\u00020\u0015¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000R)\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\t0\u0005X\u0088\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u00028\u00008VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u001c\u0010\u001d\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00061" }, d2 = { "Lly/img/android/pesdk/utils/SingletonReference;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "throwAwayIf", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "", "finalize", "", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "value", "", "_value", "set_value", "(Ljava/lang/Object;)V", "readLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "getReadLock", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;", "readWriteLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "referenceCount", "Ljava/util/concurrent/atomic/AtomicInteger;", "getValue", "()Ljava/lang/Object;", "acquire", "acquireAndGenerate", "create", "destroy", "block", "(Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "exists", "forceDestroy", "ignoreSync", "(Z)Ljava/lang/Object;", "getIfExists", "getIfExistsAndValid", "isInitialized", "toString", "", "useIfExists", "R", "writeReplace", "InitializedLazyImpl", "pesdk-backend-core_release" })
public final class SingletonReference<T> implements Lazy<T>, Serializable
{
    @NotNull
    private final Function1<T, Boolean> throwAwayIf;
    @NotNull
    private final Function1<T, Unit> finalize;
    @Nullable
    private Function0<? extends T> initializer;
    @Nullable
    private volatile Object _value;
    @NotNull
    private AtomicInteger referenceCount;
    @NotNull
    private final ReentrantReadWriteLock readWriteLock;
    @NotNull
    private final ReentrantReadWriteLock.ReadLock readLock;
    
    public SingletonReference(@NotNull final Function1<? super T, Boolean> throwAwayIf, @NotNull final Function1<? super T, Unit> finalize, @NotNull final Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter((Object)throwAwayIf, "throwAwayIf");
        Intrinsics.checkNotNullParameter((Object)finalize, "finalize");
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        this.throwAwayIf = (Function1<T, Boolean>)throwAwayIf;
        this.finalize = (Function1<T, Unit>)finalize;
        this.initializer = initializer;
        this.referenceCount = new AtomicInteger(0);
        this.readWriteLock = new ReentrantReadWriteLock(true);
        final ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
        Intrinsics.checkNotNullExpressionValue((Object)lock, "readWriteLock.readLock()");
        this.readLock = lock;
    }
    
    private final void set_value(final Object value) {
        if (this._value != null) {
            this.finalize.invoke(this._value);
        }
        this._value = value;
    }
    
    @NotNull
    public final ReentrantReadWriteLock.ReadLock getReadLock() {
        return this.readLock;
    }
    
    public T getValue() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1        /* temp */
        //     2: aload_0         /* this */
        //     3: getfield        ly/img/android/pesdk/utils/SingletonReference._value:Ljava/lang/Object;
        //     6: astore_1        /* temp */
        //     7: aload_1         /* temp */
        //     8: ifnull          34
        //    11: aload_0         /* this */
        //    12: getfield        ly/img/android/pesdk/utils/SingletonReference.throwAwayIf:Lkotlin/jvm/functions/Function1;
        //    15: aload_1         /* temp */
        //    16: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    21: checkcast       Ljava/lang/Boolean;
        //    24: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //    27: ifne            34
        //    30: aload_1         /* temp */
        //    31: goto            219
        //    34: aload_0         /* this */
        //    35: getfield        ly/img/android/pesdk/utils/SingletonReference.readWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    38: astore_2       
        //    39: aload_2        
        //    40: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    43: astore_3       
        //    44: aload_2        
        //    45: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    48: ifne            58
        //    51: aload_2        
        //    52: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    55: goto            59
        //    58: iconst_0       
        //    59: istore          4
        //    61: iconst_0       
        //    62: istore          5
        //    64: iload           5
        //    66: iload           4
        //    68: if_icmpge       81
        //    71: aload_3        
        //    72: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    75: iinc            5, 1
        //    78: goto            64
        //    81: aload_2        
        //    82: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    85: astore          5
        //    87: aload           5
        //    89: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    92: nop            
        //    93: iconst_0       
        //    94: istore          $i$a$-write-SingletonReference$value$1
        //    96: aload_0         /* this */
        //    97: getfield        ly/img/android/pesdk/utils/SingletonReference._value:Ljava/lang/Object;
        //   100: astore_1        /* temp */
        //   101: aload_1         /* temp */
        //   102: ifnull          128
        //   105: aload_0         /* this */
        //   106: getfield        ly/img/android/pesdk/utils/SingletonReference.throwAwayIf:Lkotlin/jvm/functions/Function1;
        //   109: aload_1         /* temp */
        //   110: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: checkcast       Ljava/lang/Boolean;
        //   118: invokevirtual   java/lang/Boolean.booleanValue:()Z
        //   121: ifne            128
        //   124: aload_1         /* temp */
        //   125: goto            156
        //   128: aload_0         /* this */
        //   129: aconst_null    
        //   130: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //   133: aload_0         /* this */
        //   134: getfield        ly/img/android/pesdk/utils/SingletonReference.initializer:Lkotlin/jvm/functions/Function0;
        //   137: dup            
        //   138: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNull:(Ljava/lang/Object;)V
        //   141: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   146: astore          typedValue
        //   148: aload_0         /* this */
        //   149: aload           typedValue
        //   151: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //   154: aload           typedValue
        //   156: nop            
        //   157: astore          null
        //   159: iconst_0       
        //   160: istore          7
        //   162: iload           7
        //   164: iload           4
        //   166: if_icmpge       179
        //   169: aload_3        
        //   170: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   173: iinc            7, 1
        //   176: goto            162
        //   179: aload           5
        //   181: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   184: aload           6
        //   186: goto            219
        //   189: astore          6
        //   191: iconst_0       
        //   192: istore          7
        //   194: iload           7
        //   196: iload           4
        //   198: if_icmpge       211
        //   201: aload_3        
        //   202: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   205: iinc            7, 1
        //   208: goto            194
        //   211: aload           5
        //   213: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   216: aload           6
        //   218: athrow         
        //   219: areturn        
        //    Signature:
        //  ()TT;
        //    StackMapTable: 00 0D FC 00 22 07 00 05 FD 00 17 07 00 2F 07 00 72 40 01 FD 00 04 01 01 10 FF 00 2E 00 07 07 00 02 07 00 05 07 00 2F 07 00 72 01 07 00 7B 01 00 00 5B 07 00 05 FF 00 05 00 08 07 00 02 07 00 05 07 00 2F 07 00 72 01 07 00 7B 07 00 05 01 00 00 10 FF 00 09 00 06 07 00 02 07 00 05 07 00 2F 07 00 72 01 07 00 7B 00 01 07 00 8F FD 00 04 07 00 8F 01 10 FF 00 07 00 02 07 00 02 07 00 05 00 01 07 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  92     159    189    219    Any
        //  189    191    189    219    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0219 (coming from #0218).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public boolean isInitialized() {
        if (this._value != null) {
            final Object value = this._value;
            boolean b;
            if (value != null) {
                final Object it = value;
                final int n = 0;
                b = !(boolean)this.throwAwayIf.invoke(it);
            }
            else {
                b = false;
            }
            if (b) {
                return true;
            }
        }
        return false;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.isInitialized() ? String.valueOf(this.getValue()) : "SingletonReference value not initialized yet.";
    }
    
    private final Object writeReplace() {
        return new InitializedLazyImpl(this.getValue());
    }
    
    public final boolean exists() {
        final ReentrantReadWriteLock.ReadLock lock = this.readWriteLock.readLock();
        lock.lock();
        try {
            final int n = 0;
            return this._value != null;
        }
        finally {
            lock.unlock();
        }
    }
    
    @Nullable
    public final T getIfExists() {
        final Object value = this._value;
        if (value == null) {}
        return (T)value;
    }
    
    @Nullable
    public final <R> R useIfExists(@NotNull final Function1<? super T, ? extends R> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$useIfExists = 0;
        final ReentrantReadWriteLock.ReadLock readLock = this.getReadLock();
        readLock.lock();
        try {
            final int n = 0;
            final Object value = this.getIfExists();
            final Object o = (value != null) ? block.invoke(value) : null;
            InlineMarker.finallyStart(2);
            readLock.unlock();
            InlineMarker.finallyEnd(2);
            return (R)o;
        }
        finally {
            InlineMarker.finallyStart(1);
            readLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
    
    @Nullable
    public final T getIfExistsAndValid() {
        final Object value = this._value;
        if (value == null) {}
        final Object o = value;
        Object o2;
        if (o != null) {
            final Object it = o;
            final int n = 0;
            o2 = (((boolean)this.throwAwayIf.invoke(it)) ? null : it);
        }
        else {
            o2 = null;
        }
        return (T)o2;
    }
    
    public final void create() {
        String.valueOf(this.getValue());
    }
    
    public final void acquire() {
        this.referenceCount.getAndIncrement();
    }
    
    public final void acquireAndGenerate() {
        this.getValue();
        this.referenceCount.getAndIncrement();
    }
    
    @Nullable
    public final T destroy() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_1       
        //     2: aload_1        
        //     3: monitorenter   
        //     4: nop            
        //     5: iconst_0       
        //     6: istore_2        /* $i$a$-synchronized-SingletonReference$destroy$1 */
        //     7: aload_0         /* this */
        //     8: getfield        ly/img/android/pesdk/utils/SingletonReference.referenceCount:Ljava/util/concurrent/atomic/AtomicInteger;
        //    11: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //    14: ifgt            174
        //    17: aload_0         /* this */
        //    18: getfield        ly/img/android/pesdk/utils/SingletonReference.readWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    21: astore_3       
        //    22: aload_3        
        //    23: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    26: astore          4
        //    28: aload_3        
        //    29: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    32: ifne            42
        //    35: aload_3        
        //    36: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    39: goto            43
        //    42: iconst_0       
        //    43: istore          5
        //    45: iconst_0       
        //    46: istore          6
        //    48: iload           6
        //    50: iload           5
        //    52: if_icmpge       66
        //    55: aload           4
        //    57: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    60: iinc            6, 1
        //    63: goto            48
        //    66: aload_3        
        //    67: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    70: astore          6
        //    72: aload           6
        //    74: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    77: nop            
        //    78: iconst_0       
        //    79: istore          $i$a$-write-SingletonReference$destroy$1$1
        //    81: aload_0         /* this */
        //    82: getfield        ly/img/android/pesdk/utils/SingletonReference.referenceCount:Ljava/util/concurrent/atomic/AtomicInteger;
        //    85: iconst_0       
        //    86: invokevirtual   java/util/concurrent/atomic/AtomicInteger.set:(I)V
        //    89: aload_0         /* this */
        //    90: invokevirtual   ly/img/android/pesdk/utils/SingletonReference.getIfExists:()Ljava/lang/Object;
        //    93: astore          8
        //    95: aload           8
        //    97: astore          it
        //    99: iconst_0       
        //   100: istore          $i$a$-also-SingletonReference$destroy$1$1$1
        //   102: aload_0         /* this */
        //   103: aconst_null    
        //   104: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //   107: aload           8
        //   109: nop            
        //   110: astore          null
        //   112: iconst_0       
        //   113: istore          8
        //   115: iload           8
        //   117: iload           5
        //   119: if_icmpge       133
        //   122: aload           4
        //   124: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   127: iinc            8, 1
        //   130: goto            115
        //   133: aload           6
        //   135: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   138: aload           7
        //   140: goto            175
        //   143: astore          7
        //   145: iconst_0       
        //   146: istore          8
        //   148: iload           8
        //   150: iload           5
        //   152: if_icmpge       166
        //   155: aload           4
        //   157: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   160: iinc            8, 1
        //   163: goto            148
        //   166: aload           6
        //   168: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   171: aload           7
        //   173: athrow         
        //   174: aconst_null    
        //   175: nop            
        //   176: astore_2        /* $i$a$-synchronized-SingletonReference$destroy$1 */
        //   177: aload_1        
        //   178: monitorexit    
        //   179: aload_2        
        //   180: goto            188
        //   183: astore_2       
        //   184: aload_1        
        //   185: monitorexit    
        //   186: aload_2        
        //   187: athrow         
        //   188: areturn        
        //    Signature:
        //  ()TT;
        //    StackMapTable: 00 0D FF 00 2A 00 05 07 00 02 07 00 02 01 07 00 2F 07 00 72 00 00 40 01 FD 00 04 01 01 11 FF 00 30 00 0B 07 00 02 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 07 00 05 01 07 00 05 01 00 00 11 FF 00 09 00 07 07 00 02 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 00 01 07 00 8F FD 00 04 07 00 8F 01 11 FF 00 07 00 03 07 00 02 07 00 02 01 00 00 40 07 00 05 FF 00 07 00 02 07 00 02 07 00 02 00 01 07 00 8F FF 00 04 00 03 07 00 02 07 00 02 07 00 05 00 01 07 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  77     112    143    174    Any
        //  143    145    143    174    Any
        //  4      177    183    188    Any
        //  183    184    183    188    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public final T forceDestroy(final boolean ignoreSync) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_2       
        //     2: aload_2        
        //     3: monitorenter   
        //     4: nop            
        //     5: iconst_0       
        //     6: istore_3        /* $i$a$-synchronized-SingletonReference$forceDestroy$1 */
        //     7: iload_1         /* ignoreSync */
        //     8: ifeq            34
        //    11: aload_0         /* this */
        //    12: invokevirtual   ly/img/android/pesdk/utils/SingletonReference.getIfExists:()Ljava/lang/Object;
        //    15: astore          4
        //    17: aload           4
        //    19: astore          it
        //    21: iconst_0       
        //    22: istore          $i$a$-also-SingletonReference$forceDestroy$1$1
        //    24: aload_0         /* this */
        //    25: aconst_null    
        //    26: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //    29: aload           4
        //    31: goto            188
        //    34: aload_0         /* this */
        //    35: getfield        ly/img/android/pesdk/utils/SingletonReference.readWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    38: astore          4
        //    40: aload           4
        //    42: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    45: astore          5
        //    47: aload           4
        //    49: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    52: ifne            63
        //    55: aload           4
        //    57: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    60: goto            64
        //    63: iconst_0       
        //    64: istore          6
        //    66: iconst_0       
        //    67: istore          7
        //    69: iload           7
        //    71: iload           6
        //    73: if_icmpge       87
        //    76: aload           5
        //    78: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    81: iinc            7, 1
        //    84: goto            69
        //    87: aload           4
        //    89: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    92: astore          7
        //    94: aload           7
        //    96: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    99: nop            
        //   100: iconst_0       
        //   101: istore          $i$a$-write-SingletonReference$forceDestroy$1$2
        //   103: aload_0         /* this */
        //   104: invokevirtual   ly/img/android/pesdk/utils/SingletonReference.getIfExists:()Ljava/lang/Object;
        //   107: astore          9
        //   109: aload           9
        //   111: astore          it
        //   113: iconst_0       
        //   114: istore          $i$a$-also-SingletonReference$forceDestroy$1$2$1
        //   116: aload_0         /* this */
        //   117: aconst_null    
        //   118: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //   121: aload           9
        //   123: nop            
        //   124: astore          null
        //   126: iconst_0       
        //   127: istore          9
        //   129: iload           9
        //   131: iload           6
        //   133: if_icmpge       147
        //   136: aload           5
        //   138: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   141: iinc            9, 1
        //   144: goto            129
        //   147: aload           7
        //   149: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   152: aload           8
        //   154: goto            188
        //   157: astore          8
        //   159: iconst_0       
        //   160: istore          9
        //   162: iload           9
        //   164: iload           6
        //   166: if_icmpge       180
        //   169: aload           5
        //   171: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   174: iinc            9, 1
        //   177: goto            162
        //   180: aload           7
        //   182: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   185: aload           8
        //   187: athrow         
        //   188: nop            
        //   189: astore_3        /* $i$a$-synchronized-SingletonReference$forceDestroy$1 */
        //   190: aload_2        
        //   191: monitorexit    
        //   192: aload_3        
        //   193: goto            201
        //   196: astore_3       
        //   197: aload_2        
        //   198: monitorexit    
        //   199: aload_3        
        //   200: athrow         
        //   201: areturn        
        //    Signature:
        //  (Z)TT;
        //    StackMapTable: 00 0D FD 00 22 07 00 02 01 FD 00 1C 07 00 2F 07 00 72 40 01 FD 00 04 01 01 11 FF 00 29 00 0C 07 00 02 01 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 07 00 05 01 07 00 05 01 00 00 11 FF 00 09 00 08 07 00 02 01 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 00 01 07 00 8F FD 00 04 07 00 8F 01 11 FF 00 07 00 07 07 00 02 01 07 00 02 01 07 00 05 07 00 05 01 00 01 07 00 05 FF 00 07 00 03 07 00 02 01 07 00 02 00 01 07 00 8F FF 00 04 00 07 07 00 02 01 07 00 02 07 00 05 07 00 05 07 00 05 01 00 01 07 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  99     126    157    188    Any
        //  157    159    157    188    Any
        //  4      190    196    201    Any
        //  196    197    196    201    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Nullable
    public final T destroy(@NotNull final Function1<? super T, Unit> block) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "block"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: astore_2       
        //     8: aload_2        
        //     9: monitorenter   
        //    10: nop            
        //    11: iconst_0       
        //    12: istore_3        /* $i$a$-synchronized-SingletonReference$destroy$2 */
        //    13: aload_0         /* this */
        //    14: getfield        ly/img/android/pesdk/utils/SingletonReference.referenceCount:Ljava/util/concurrent/atomic/AtomicInteger;
        //    17: invokevirtual   java/util/concurrent/atomic/AtomicInteger.decrementAndGet:()I
        //    20: ifgt            203
        //    23: aload_0         /* this */
        //    24: getfield        ly/img/android/pesdk/utils/SingletonReference.readWriteLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    27: astore          4
        //    29: aload           4
        //    31: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    34: astore          5
        //    36: aload           4
        //    38: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getWriteHoldCount:()I
        //    41: ifne            52
        //    44: aload           4
        //    46: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.getReadHoldCount:()I
        //    49: goto            53
        //    52: iconst_0       
        //    53: istore          6
        //    55: iconst_0       
        //    56: istore          7
        //    58: iload           7
        //    60: iload           6
        //    62: if_icmpge       76
        //    65: aload           5
        //    67: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    70: iinc            7, 1
        //    73: goto            58
        //    76: aload           4
        //    78: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.writeLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$WriteLock;
        //    81: astore          7
        //    83: aload           7
        //    85: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.lock:()V
        //    88: nop            
        //    89: iconst_0       
        //    90: istore          $i$a$-write-SingletonReference$destroy$2$1
        //    92: aload_0         /* this */
        //    93: getfield        ly/img/android/pesdk/utils/SingletonReference.referenceCount:Ljava/util/concurrent/atomic/AtomicInteger;
        //    96: iconst_0       
        //    97: invokevirtual   java/util/concurrent/atomic/AtomicInteger.set:(I)V
        //   100: aload_0         /* this */
        //   101: invokevirtual   ly/img/android/pesdk/utils/SingletonReference.getIfExists:()Ljava/lang/Object;
        //   104: dup            
        //   105: ifnull          137
        //   108: astore          9
        //   110: aload           9
        //   112: astore          it
        //   114: iconst_0       
        //   115: istore          $i$a$-also-SingletonReference$destroy$2$1$1
        //   117: aload_0         /* this */
        //   118: aconst_null    
        //   119: invokespecial   ly/img/android/pesdk/utils/SingletonReference.set_value:(Ljava/lang/Object;)V
        //   122: aload_1         /* block */
        //   123: aload           it
        //   125: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   130: pop            
        //   131: nop            
        //   132: aload           9
        //   134: goto            139
        //   137: pop            
        //   138: aconst_null    
        //   139: astore          null
        //   141: iconst_0       
        //   142: istore          9
        //   144: iload           9
        //   146: iload           6
        //   148: if_icmpge       162
        //   151: aload           5
        //   153: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   156: iinc            9, 1
        //   159: goto            144
        //   162: aload           7
        //   164: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   167: aload           8
        //   169: goto            204
        //   172: astore          8
        //   174: iconst_0       
        //   175: istore          9
        //   177: iload           9
        //   179: iload           6
        //   181: if_icmpge       195
        //   184: aload           5
        //   186: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   189: iinc            9, 1
        //   192: goto            177
        //   195: aload           7
        //   197: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$WriteLock.unlock:()V
        //   200: aload           8
        //   202: athrow         
        //   203: aconst_null    
        //   204: nop            
        //   205: astore_3        /* $i$a$-synchronized-SingletonReference$destroy$2 */
        //   206: aload_2        
        //   207: monitorexit    
        //   208: aload_3        
        //   209: goto            217
        //   212: astore_3       
        //   213: aload_2        
        //   214: monitorexit    
        //   215: aload_3        
        //   216: athrow         
        //   217: areturn        
        //    Signature:
        //  (Lkotlin/jvm/functions/Function1<-TT;Lkotlin/Unit;>;)TT;
        //    StackMapTable: 00 0F FF 00 34 00 06 07 00 02 07 00 4D 07 00 02 01 07 00 2F 07 00 72 00 00 40 01 FD 00 04 01 01 11 FF 00 3C 00 09 07 00 02 07 00 4D 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 01 00 01 07 00 05 41 07 00 05 FF 00 04 00 0A 07 00 02 07 00 4D 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 07 00 05 01 00 00 11 FF 00 09 00 08 07 00 02 07 00 4D 07 00 02 01 07 00 2F 07 00 72 01 07 00 7B 00 01 07 00 8F FD 00 04 07 00 8F 01 11 FF 00 07 00 04 07 00 02 07 00 4D 07 00 02 01 00 00 40 07 00 05 FF 00 07 00 03 07 00 02 07 00 4D 07 00 02 00 01 07 00 8F FF 00 04 00 04 07 00 02 07 00 4D 07 00 02 07 00 05 00 01 07 00 05
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  88     141    172    203    Any
        //  172    174    172    203    Any
        //  10     206    212    217    Any
        //  212    213    212    217    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:595)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0000\u0018\u0000*\u0006\b\u0001\u0010\u0001 \u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u0003B\r\u0012\u0006\u0010\u0004\u001a\u00028\u0001¢\u0006\u0002\u0010\u0005J\b\u0010\t\u001a\u00020\nH\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u0016\u0010\u0004\u001a\u00028\u0001X\u0096\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\r" }, d2 = { "Lly/img/android/pesdk/utils/SingletonReference$InitializedLazyImpl;", "T", "Lkotlin/Lazy;", "Ljava/io/Serializable;", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "Ljava/lang/Object;", "isInitialized", "", "toString", "", "pesdk-backend-core_release" })
    public static final class InitializedLazyImpl<T> implements Lazy<T>, Serializable
    {
        private final T value;
        
        public InitializedLazyImpl(final T value) {
            this.value = value;
        }
        
        public T getValue() {
            return this.value;
        }
        
        public boolean isInitialized() {
            return true;
        }
        
        @NotNull
        @Override
        public String toString() {
            return String.valueOf(this.getValue());
        }
    }
}
