// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.JvmOverloads;
import kotlin.Unit;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0017\u001a\u00020\tJ\u0016\u0010\u0018\u001a\u00020\u00192\f\b\u0002\u0010\u001a\u001a\u00060\u0004j\u0002`\u0005H\u0007J\u001e\u0010\u001b\u001a\u00020\u00192\n\u0010\u001c\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u001d\u001a\u00060\u0004j\u0002`\u0005J\u0006\u0010\u001c\u001a\u00020\u0019J\u0014\u0010\u001c\u001a\u00020\u00192\f\b\u0002\u0010\u001e\u001a\u00060\u0004j\u0002`\u0005J\u0012\u0010\u001f\u001a\u00020\u00192\n\u0010\u000e\u001a\u00060\u0004j\u0002`\u0005R\u0012\u0010\u0003\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0007\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\n\u001a\u00020\t2\u0006\u0010\b\u001a\u00020\t@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0012\u0010\r\u001a\u00060\u0004j\u0002`\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0015\u0010\u000e\u001a\u00060\u0004j\u0002`\u00058F¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R&\u0010\u0014\u001a\u00060\u0004j\u0002`\u00052\n\u0010\u0013\u001a\u00060\u0004j\u0002`\u0005@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0015\u0010\u0016¨\u0006 " }, d2 = { "Lly/img/android/pesdk/utils/ImpulseNanosecondClock;", "", "()V", "frozenTime", "", "Lly/img/android/pesdk/kotlin_extension/Nanoseconds;", "maxDuration", "minTime", "<set-?>", "", "running", "getRunning", "()Z", "startTime", "time", "getTime", "()J", "timeLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "value", "timeOffset", "setTimeOffset", "(J)V", "isStarted", "pause", "", "pauseAt", "setRange", "start", "end", "startAt", "update", "pesdk-backend-core_release" })
public final class ImpulseNanosecondClock
{
    @NotNull
    private final ReentrantReadWriteLock timeLock;
    private boolean running;
    private long frozenTime;
    private long startTime;
    private long timeOffset;
    private long minTime;
    private long maxDuration;
    
    public ImpulseNanosecondClock() {
        this.timeLock = new ReentrantReadWriteLock(true);
    }
    
    public final boolean getRunning() {
        return this.running;
    }
    
    private final void setTimeOffset(final long value) {
        final long requestStart = System.nanoTime();
        final ReentrantReadWriteLock timeLock = this.timeLock;
        final ReentrantReadWriteLock.ReadLock lock = timeLock.readLock();
        final int n = (timeLock.getWriteHoldCount() == 0) ? timeLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = timeLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            this.startTime = requestStart;
            this.timeOffset = value;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    public final long getTime() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.timeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //     4: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //     7: astore_1       
        //     8: aload_1        
        //     9: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //    12: nop            
        //    13: iconst_0       
        //    14: istore_2       
        //    15: aload_0         /* this */
        //    16: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.running:Z
        //    19: ifeq            73
        //    22: aload_0         /* this */
        //    23: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.maxDuration:J
        //    26: lconst_0       
        //    27: lcmp           
        //    28: ifle            52
        //    31: invokestatic    java/lang/System.nanoTime:()J
        //    34: aload_0         /* this */
        //    35: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.startTime:J
        //    38: lsub           
        //    39: aload_0         /* this */
        //    40: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.timeOffset:J
        //    43: ladd           
        //    44: aload_0         /* this */
        //    45: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.maxDuration:J
        //    48: lrem           
        //    49: goto            65
        //    52: invokestatic    java/lang/System.nanoTime:()J
        //    55: aload_0         /* this */
        //    56: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.startTime:J
        //    59: lsub           
        //    60: aload_0         /* this */
        //    61: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.timeOffset:J
        //    64: ladd           
        //    65: aload_0         /* this */
        //    66: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.minTime:J
        //    69: ladd           
        //    70: goto            116
        //    73: aload_0         /* this */
        //    74: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.maxDuration:J
        //    77: lconst_0       
        //    78: lcmp           
        //    79: ifle            105
        //    82: aload_0         /* this */
        //    83: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.frozenTime:J
        //    86: aload_0         /* this */
        //    87: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.minTime:J
        //    90: aload_0         /* this */
        //    91: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.minTime:J
        //    94: aload_0         /* this */
        //    95: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.maxDuration:J
        //    98: ladd           
        //    99: invokestatic    ly/img/android/pesdk/utils/MathUtilsKt.clamp:(JJJ)J
        //   102: goto            116
        //   105: aload_0         /* this */
        //   106: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.frozenTime:J
        //   109: aload_0         /* this */
        //   110: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.minTime:J
        //   113: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(JJ)J
        //   116: nop            
        //   117: lstore_2       
        //   118: aload_1        
        //   119: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //   122: lload_2        
        //   123: goto            133
        //   126: astore_2       
        //   127: aload_1        
        //   128: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //   131: aload_2        
        //   132: athrow         
        //   133: lreturn        
        //    StackMapTable: 00 07 FD 00 34 07 00 2E 01 4C 04 07 1F 4A 04 FF 00 09 00 02 07 00 02 07 00 2E 00 01 07 00 4F FF 00 06 00 03 07 00 02 07 00 2E 04 00 01 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  12     118    126    133    Any
        //  126    127    126    133    Any
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
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:581)
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
    
    public final void start() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.running:Z
        //     4: ifne            61
        //     7: aload_0         /* this */
        //     8: aload_0         /* this */
        //     9: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.timeLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    12: astore_1       
        //    13: astore          5
        //    15: aload_1        
        //    16: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    19: astore_2       
        //    20: aload_2        
        //    21: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //    24: nop            
        //    25: iconst_0       
        //    26: istore_3       
        //    27: aload_0         /* this */
        //    28: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.frozenTime:J
        //    31: aload_0         /* this */
        //    32: getfield        ly/img/android/pesdk/utils/ImpulseNanosecondClock.minTime:J
        //    35: lsub           
        //    36: lstore_3       
        //    37: aload_2        
        //    38: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    41: lload_3        
        //    42: goto            52
        //    45: astore_3       
        //    46: aload_2        
        //    47: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    50: aload_3        
        //    51: athrow         
        //    52: lstore          6
        //    54: aload           5
        //    56: lload           6
        //    58: invokevirtual   ly/img/android/pesdk/utils/ImpulseNanosecondClock.start:(J)V
        //    61: return         
        //    StackMapTable: 00 03 FF 00 2D 00 06 07 00 02 07 00 0A 07 00 2E 00 00 07 00 02 00 01 07 00 4F FF 00 06 00 05 07 00 02 07 00 0A 07 00 2E 04 07 00 02 00 01 04 FF 00 08 00 01 07 00 02 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  24     37     45     52     Any
        //  45     46     45     52     Any
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
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visitVariable(StackMappingVisitor.java:470)
        //     at com.strobel.assembler.ir.Instruction.accept(Instruction.java:556)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:403)
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
    
    public final void start(final long startAt) {
        this.setTimeOffset(startAt);
        this.running = true;
    }
    
    @JvmOverloads
    public final void pause(final long pauseAt) {
        final ReentrantReadWriteLock timeLock = this.timeLock;
        final ReentrantReadWriteLock.ReadLock lock = timeLock.readLock();
        final int n = (timeLock.getWriteHoldCount() == 0) ? timeLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = timeLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            this.frozenTime = pauseAt;
            this.running = false;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    public static /* synthetic */ void pause$default(final ImpulseNanosecondClock impulseNanosecondClock, long time, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            time = impulseNanosecondClock.getTime();
        }
        impulseNanosecondClock.pause(time);
    }
    
    public final void update(final long time) {
        final ReentrantReadWriteLock timeLock = this.timeLock;
        final ReentrantReadWriteLock.ReadLock lock = timeLock.readLock();
        final int n = (timeLock.getWriteHoldCount() == 0) ? timeLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = timeLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            this.setTimeOffset(this.frozenTime = time);
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    public final void setRange(final long start, final long end) {
        final ReentrantReadWriteLock timeLock = this.timeLock;
        final ReentrantReadWriteLock.ReadLock lock = timeLock.readLock();
        final int n = (timeLock.getWriteHoldCount() == 0) ? timeLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = timeLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            this.minTime = start;
            this.maxDuration = end - start;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    public final boolean isStarted() {
        return this.startTime != 0L;
    }
    
    @JvmOverloads
    public final void pause() {
        pause$default(this, 0L, 1, null);
    }
}
