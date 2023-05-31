// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.InlineMarker;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010!\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004J5\u0010\u000f\u001a\u00020\u00102'\u0010\u0011\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\f\b\u0013\u0012\b\b\u0014\u0012\u0004\b\b(\u0015\u0012\u0004\u0012\u00020\u00100\u0012H\u0086\b\u00f8\u0001\u0000R \u0010\u0006\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\u0005R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/utils/LockableList;", "T", "", "list", "", "(Ljava/util/List;)V", "_unsafeList", "get_unsafeList", "()Ljava/util/List;", "set_unsafeList", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "getCopy", "read", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "pesdk-backend-core_release" })
public class LockableList<T>
{
    @NotNull
    private List<T> _unsafeList;
    @NotNull
    private final ReentrantLock lock;
    
    public LockableList(@NotNull final List<T> list) {
        Intrinsics.checkNotNullParameter((Object)list, "list");
        this._unsafeList = list;
        this.lock = new ReentrantLock();
    }
    
    @NotNull
    public final List<T> get_unsafeList() {
        return this._unsafeList;
    }
    
    public final void set_unsafeList(@NotNull final List<T> <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this._unsafeList = <set-?>;
    }
    
    @NotNull
    public final ReentrantLock getLock() {
        return this.lock;
    }
    
    public final void read(@NotNull final Function1<? super List<T>, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$read = 0;
        final ReentrantLock reentrantLock = this.getLock();
        reentrantLock.lock();
        try {
            final int n = 0;
            block.invoke((Object)this.get_unsafeList());
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            InlineMarker.finallyStart(1);
            reentrantLock.unlock();
            InlineMarker.finallyEnd(1);
        }
    }
    
    @NotNull
    public final List<T> getCopy() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/LockableList.lock:Ljava/util/concurrent/locks/ReentrantLock;
        //     4: checkcast       Ljava/util/concurrent/locks/Lock;
        //     7: astore_1       
        //     8: aload_1        
        //     9: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    14: nop            
        //    15: iconst_0       
        //    16: istore_2       
        //    17: new             Ljava/util/ArrayList;
        //    20: dup            
        //    21: aload_0         /* this */
        //    22: getfield        ly/img/android/pesdk/utils/LockableList._unsafeList:Ljava/util/List;
        //    25: checkcast       Ljava/util/Collection;
        //    28: invokespecial   java/util/ArrayList.<init>:(Ljava/util/Collection;)V
        //    31: astore_2       
        //    32: aload_1        
        //    33: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    38: aload_2        
        //    39: goto            51
        //    42: astore_2       
        //    43: aload_1        
        //    44: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    49: aload_2        
        //    50: athrow         
        //    51: checkcast       Ljava/util/List;
        //    54: areturn        
        //    Signature:
        //  ()Ljava/util/List<TT;>;
        //    StackMapTable: 00 02 FF 00 2A 00 02 07 00 02 07 00 32 00 01 07 00 54 FF 00 08 00 03 07 00 02 07 00 32 07 00 57 00 01 07 00 57
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  14     32     42     51     Any
        //  42     43     42     51     Any
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
}
