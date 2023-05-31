// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.JvmStatic;
import kotlin.Deprecated;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.model.state.manager.Settings;
import java.io.Serializable;
import android.os.Parcel;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import java.util.Collection;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmField;
import android.os.Parcelable$Creator;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import ly.img.android.pesdk.backend.model.state.manager.Revertible;
import android.os.Parcelable;
import java.util.ArrayList;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000`\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u001e\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010 \n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\f\b\u0016\u0018\u0000 A*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u00022\u00020\u00032\u00020\u00042\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002H\u00010\u00000\u0005:\u0004?@ABB\u0011\b\u0017\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB\u001f\b\u0017\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\n\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000bB\u0019\b\u0017\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\u000eB\u000f\b\u0016\u0012\u0006\u0010\u000f\u001a\u00020\u0010¢\u0006\u0002\u0010\u0011J\u0015\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u001d\u0010\u0016\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u001bJ\u001e\u0010\u001c\u001a\u00020\u00072\u0006\u0010\u001a\u001a\u00020\r2\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0016\u0010\u001c\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u0019H\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\b\u0010\"\u001a\u00020\rH\u0016J\u0015\u0010#\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00028\u0000H\u0016¢\u0006\u0002\u0010\u0018J\u0016\u0010$\u001a\u00020\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016J\u0015\u0010%\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0016¢\u0006\u0002\u0010&J\u0010\u0010'\u001a\u00020\u00192\u0006\u0010\u0012\u001a\u00020\u001fH\u0016J\u0018\u0010(\u001a\u00020\u00192\u0006\u0010)\u001a\u00020\r2\u0006\u0010*\u001a\u00020\rH\u0016J\u0016\u0010+\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00028\u00000\u0000H\u0016J\u001e\u0010-\u001a\u00028\u00002\u0006\u0010\u001a\u001a\u00020\r2\u0006\u0010\u0017\u001a\u00028\u0000H\u0096\u0002¢\u0006\u0002\u0010.J\u0016\u0010-\u001a\u00020\u00192\f\u0010/\u001a\b\u0012\u0004\u0012\u00028\u000000H\u0016J\u0016\u00101\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\r2\u0006\u00102\u001a\u00020\rJ\u0018\u00103\u001a\u00020\u00192\u0006\u00104\u001a\u00020\u00102\u0006\u00105\u001a\u00020\rH\u0016J\u001e\u00106\u001a\u00020\u0019*\u0006\u0012\u0002\b\u0003072\f\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000107H\u0002J\u001e\u00109\u001a\u00020\u0019*\u0006\u0012\u0002\b\u0003072\f\u00108\u001a\b\u0012\u0002\b\u0003\u0018\u000107H\u0002J\u0019\u0010:\u001a\u00020\u0019*\u00028\u00002\u0006\u0010;\u001a\u00028\u0000H\u0002¢\u0006\u0002\u0010<J\u0019\u0010=\u001a\u00020\u0019*\u00028\u00002\u0006\u0010\u001a\u001a\u00020\rH\u0002¢\u0006\u0002\u0010>R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0006\u001a\u00020\u00078BX\u0082\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006C" }, d2 = { "Lly/img/android/pesdk/utils/DataSourceArrayList;", "TYPE", "Ljava/util/ArrayList;", "Landroid/os/Parcelable;", "Lly/img/android/pesdk/utils/IDataSource;", "Lly/img/android/pesdk/backend/model/state/manager/Revertible;", "updateItemListInfo", "", "(Z)V", "c", "", "(Ljava/util/Collection;Z)V", "initialCapacity", "", "(IZ)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "callbacks", "Lly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler;", "getUpdateItemListInfo", "()Z", "add", "element", "(Ljava/lang/Object;)Z", "", "index", "(ILjava/lang/Object;)V", "addAll", "elements", "addCallback", "Lly/img/android/pesdk/utils/DataSourceArrayList$Callback;", "clear", "createSaveState", "describeContents", "remove", "removeAll", "removeAt", "(I)Ljava/lang/Object;", "removeCallback", "removeRange", "fromIndex", "toIndex", "revertState", "state", "set", "(ILjava/lang/Object;)Ljava/lang/Object;", "list", "", "swap", "withIndex", "writeToParcel", "dest", "flags", "setNextListInfo", "Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;", "info", "setPrevListInfo", "swapPosition", "other", "(Ljava/lang/Object;Ljava/lang/Object;)V", "updatePosition", "(Ljava/lang/Object;I)V", "Callback", "CallbackHandler", "Companion", "ListInfo", "pesdk-backend-core_release" })
public class DataSourceArrayList<TYPE> extends ArrayList<TYPE> implements Parcelable, IDataSource, Revertible<DataSourceArrayList<TYPE>>
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final CallbackHandler callbacks;
    private boolean updateItemListInfo;
    @JvmField
    @NotNull
    public static final Parcelable$Creator<DataSourceArrayList<?>> CREATOR;
    
    private final boolean getUpdateItemListInfo() {
        return true;
    }
    
    @JvmOverloads
    public DataSourceArrayList(final boolean updateItemListInfo) {
        this.callbacks = new CallbackHandler();
        this.updateItemListInfo = updateItemListInfo;
    }
    
    @JvmOverloads
    public DataSourceArrayList(@NotNull final Collection<? extends TYPE> c, final boolean updateItemListInfo) {
        Intrinsics.checkNotNullParameter((Object)c, "c");
        super(c);
        this.callbacks = new CallbackHandler();
        this.updateItemListInfo = updateItemListInfo;
    }
    
    @JvmOverloads
    public DataSourceArrayList(final int initialCapacity, final boolean updateItemListInfo) {
        super(initialCapacity);
        this.callbacks = new CallbackHandler();
        this.updateItemListInfo = updateItemListInfo;
    }
    
    public void addCallback(@NotNull final Callback callbacks) {
        Intrinsics.checkNotNullParameter((Object)callbacks, "callbacks");
        this.callbacks.add(callbacks);
    }
    
    public void removeCallback(@NotNull final Callback callbacks) {
        Intrinsics.checkNotNullParameter((Object)callbacks, "callbacks");
        this.callbacks.remove(callbacks);
    }
    
    private final void updatePosition(final TYPE $this$updatePosition, final int index) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.getUpdateItemListInfo:()Z
        //     4: ifeq            264
        //     7: aload_1         /* $this$updatePosition */
        //     8: instanceof      Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //    11: ifeq            264
        //    14: aload_1         /* $this$updatePosition */
        //    15: checkcast       Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //    18: astore_3        /* listInfo */
        //    19: iload_2         /* index */
        //    20: iflt            162
        //    23: aload_3         /* listInfo */
        //    24: aload_0         /* this */
        //    25: checkcast       Ljava/util/List;
        //    28: iload_2         /* index */
        //    29: iconst_1       
        //    30: isub           
        //    31: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //    34: astore          4
        //    36: aload           4
        //    38: instanceof      Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //    41: ifeq            52
        //    44: aload           4
        //    46: checkcast       Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //    49: goto            53
        //    52: aconst_null    
        //    53: dup            
        //    54: ifnull          84
        //    57: astore          4
        //    59: aload           4
        //    61: astore          5
        //    63: astore          7
        //    65: iconst_0       
        //    66: istore          $i$a$-also-DataSourceArrayList$updatePosition$1
        //    68: aload           it
        //    70: aload_1         /* $this$updatePosition */
        //    71: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setNextItem:(Ljava/lang/Object;)V
        //    76: nop            
        //    77: aload           7
        //    79: aload           4
        //    81: goto            86
        //    84: pop            
        //    85: aconst_null    
        //    86: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setPrevItem:(Ljava/lang/Object;)V
        //    91: aload_3         /* listInfo */
        //    92: aload_0         /* this */
        //    93: checkcast       Ljava/util/List;
        //    96: iload_2         /* index */
        //    97: iconst_1       
        //    98: iadd           
        //    99: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   102: astore          4
        //   104: aload           4
        //   106: instanceof      Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   109: ifeq            120
        //   112: aload           4
        //   114: checkcast       Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   117: goto            121
        //   120: aconst_null    
        //   121: dup            
        //   122: ifnull          152
        //   125: astore          4
        //   127: aload           4
        //   129: astore          5
        //   131: astore          7
        //   133: iconst_0       
        //   134: istore          $i$a$-also-DataSourceArrayList$updatePosition$2
        //   136: aload           it
        //   138: aload_1         /* $this$updatePosition */
        //   139: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setPrevItem:(Ljava/lang/Object;)V
        //   144: nop            
        //   145: aload           7
        //   147: aload           4
        //   149: goto            154
        //   152: pop            
        //   153: aconst_null    
        //   154: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setNextItem:(Ljava/lang/Object;)V
        //   159: goto            264
        //   162: aload_3         /* listInfo */
        //   163: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.getPrevItem:()Ljava/lang/Object;
        //   168: astore          4
        //   170: aload           4
        //   172: instanceof      Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   175: ifeq            186
        //   178: aload           4
        //   180: checkcast       Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   183: goto            187
        //   186: aconst_null    
        //   187: dup            
        //   188: ifnonnull       195
        //   191: pop            
        //   192: goto            206
        //   195: aload_3         /* listInfo */
        //   196: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.getNextItem:()Ljava/lang/Object;
        //   201: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setNextItem:(Ljava/lang/Object;)V
        //   206: aload_3         /* listInfo */
        //   207: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.getNextItem:()Ljava/lang/Object;
        //   212: astore          4
        //   214: aload           4
        //   216: instanceof      Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   219: ifeq            230
        //   222: aload           4
        //   224: checkcast       Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;
        //   227: goto            231
        //   230: aconst_null    
        //   231: dup            
        //   232: ifnonnull       239
        //   235: pop            
        //   236: goto            250
        //   239: aload_3         /* listInfo */
        //   240: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.getPrevItem:()Ljava/lang/Object;
        //   245: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setPrevItem:(Ljava/lang/Object;)V
        //   250: aload_3         /* listInfo */
        //   251: aconst_null    
        //   252: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setPrevItem:(Ljava/lang/Object;)V
        //   257: aload_3         /* listInfo */
        //   258: aconst_null    
        //   259: invokeinterface ly/img/android/pesdk/utils/DataSourceArrayList$ListInfo.setNextItem:(Ljava/lang/Object;)V
        //   264: return         
        //    Signature:
        //  (TTYPE;I)V
        //    StackMapTable: 00 12 FF 00 34 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 01 07 00 52 FF 00 00 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 FF 00 1E 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 FF 00 01 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 61 07 00 52 FF 00 00 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 FF 00 1E 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 FF 00 01 00 05 07 00 02 07 00 71 01 07 00 52 07 00 71 00 02 07 00 52 07 00 52 FA 00 07 FC 00 17 07 00 71 40 07 00 52 47 07 00 52 0A 17 40 07 00 52 47 07 00 52 0A F9 00 0D
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
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
    
    private final void swapPosition(final TYPE $this$swapPosition, final TYPE other) {
        if (this.getUpdateItemListInfo()) {
            final ListInfo listInfo = ($this$swapPosition instanceof ListInfo) ? $this$swapPosition : null;
            if (listInfo == null) {
                return;
            }
            final ListInfo item = listInfo;
            final ListInfo listInfo2 = (other instanceof ListInfo) ? other : null;
            if (listInfo2 == null) {
                return;
            }
            final ListInfo other2 = listInfo2;
            ListInfo itemPrev = item.getPrevItem();
            ListInfo itemNext = item.getNextItem();
            ListInfo otherPrev = other2.getPrevItem();
            ListInfo otherNext = other2.getNextItem();
            if (Intrinsics.areEqual((Object)otherPrev, (Object)item)) {
                otherPrev = other2;
            }
            if (Intrinsics.areEqual((Object)otherNext, (Object)item)) {
                otherNext = other2;
            }
            if (Intrinsics.areEqual((Object)itemNext, (Object)other2)) {
                itemNext = item;
            }
            if (Intrinsics.areEqual((Object)itemPrev, (Object)other2)) {
                itemPrev = item;
            }
            this.setPrevListInfo(item, otherPrev);
            this.setNextListInfo(item, otherNext);
            this.setPrevListInfo(other2, itemPrev);
            this.setNextListInfo(other2, itemNext);
        }
    }
    
    public void set(@NotNull final List<? extends TYPE> list) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "list"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokespecial   java/util/ArrayList.clear:()V
        //    10: aload_0         /* this */
        //    11: aload_1         /* list */
        //    12: checkcast       Ljava/util/Collection;
        //    15: invokespecial   java/util/ArrayList.addAll:(Ljava/util/Collection;)Z
        //    18: pop            
        //    19: aload_0         /* this */
        //    20: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.getUpdateItemListInfo:()Z
        //    23: ifeq            102
        //    26: aload_1         /* list */
        //    27: checkcast       Ljava/lang/Iterable;
        //    30: astore_2        /* $this$forEachIndexed$iv */
        //    31: iconst_0       
        //    32: istore_3        /* $i$f$forEachIndexed */
        //    33: iconst_0       
        //    34: istore          index$iv
        //    36: aload_2         /* $this$forEachIndexed$iv */
        //    37: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    42: astore          5
        //    44: aload           5
        //    46: invokeinterface java/util/Iterator.hasNext:()Z
        //    51: ifeq            101
        //    54: aload           5
        //    56: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    61: astore          item$iv
        //    63: iload           index$iv
        //    65: iinc            index$iv, 1
        //    68: istore          7
        //    70: iload           7
        //    72: ifge            78
        //    75: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //    78: iload           7
        //    80: aload           item$iv
        //    82: astore          8
        //    84: istore          index
        //    86: iconst_0       
        //    87: istore          $i$a$-forEachIndexed-DataSourceArrayList$set$1
        //    89: aload_0         /* this */
        //    90: aload           item
        //    92: iload           index
        //    94: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.updatePosition:(Ljava/lang/Object;I)V
        //    97: nop            
        //    98: goto            44
        //   101: nop            
        //   102: aload_0         /* this */
        //   103: getfield        ly/img/android/pesdk/utils/DataSourceArrayList.callbacks:Lly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler;
        //   106: aload_1         /* list */
        //   107: invokevirtual   ly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler.listInvalid:(Ljava/util/List;)V
        //   110: return         
        //    Signature:
        //  (Ljava/util/List<+TTYPE;>;)V
        //    StackMapTable: 00 04 FF 00 2C 00 06 07 00 02 07 00 54 07 00 96 01 01 07 00 9C 00 00 FD 00 21 07 00 71 01 F9 00 16 FF 00 00 00 02 07 00 02 07 00 54 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
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
    
    @Override
    public TYPE set(final int index, final TYPE element) {
        if (this.getUpdateItemListInfo()) {
            final int existingIndex = this.indexOf(element);
            if (existingIndex >= 0 && existingIndex != index) {
                final Object oldElement = super.set(index, element);
                super.set(existingIndex, (TYPE)oldElement);
                this.updatePosition(oldElement, existingIndex);
                this.updatePosition(element, index);
                return (TYPE)oldElement;
            }
        }
        final Object oldElement2 = super.set(index, element);
        if (this.getUpdateItemListInfo() && !Intrinsics.areEqual((Object)element, oldElement2)) {
            this.updatePosition(oldElement2, -1);
            this.updatePosition(element, index);
        }
        this.callbacks.listItemChanged(this, index);
        return (TYPE)oldElement2;
    }
    
    public final void swap(final int index, final int withIndex) {
        final Object element1 = super.get(index);
        final Object element2 = super.set(withIndex, super.get(index));
        super.set(index, (TYPE)element2);
        if (this.getUpdateItemListInfo()) {
            this.swapPosition(element1, element2);
        }
        this.callbacks.listItemChanged(this, index);
        this.callbacks.listItemChanged(this, withIndex);
    }
    
    @Override
    public boolean add(final TYPE element) {
        final boolean result = super.add(element);
        final int index = this.size() - 1;
        this.updatePosition(element, index);
        this.callbacks.listItemAdded(this, index);
        return result;
    }
    
    @Override
    public void add(final int index, final TYPE element) {
        super.add(index, element);
        this.updatePosition(element, index);
        this.callbacks.listItemAdded(this, index);
    }
    
    @Override
    public boolean remove(final Object element) {
        if (element == null) {
            for (int index = 0; index < this.size(); ++index) {
                if (this.get(index) == null) {
                    return true;
                }
            }
        }
        else {
            for (int index = 0; index < this.size(); ++index) {
                if (Intrinsics.areEqual(element, this.get(index))) {
                    final TYPE remove = this.remove(index);
                    if (remove != null) {
                        this.updatePosition(remove, -1);
                    }
                    return true;
                }
            }
        }
        return false;
    }
    
    public TYPE removeAt(final int index) {
        this.callbacks.beforeListItemRemoved(this, index);
        final TYPE remove;
        final Object result = remove = super.remove(index);
        if (remove != null) {
            this.updatePosition(remove, -1);
        }
        this.callbacks.listItemRemoved(this, index);
        return (TYPE)result;
    }
    
    @Override
    public void clear() {
        super.clear();
        this.callbacks.listInvalid(this);
    }
    
    @Override
    public boolean addAll(@NotNull final Collection<? extends TYPE> elements) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "elements"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokevirtual   ly/img/android/pesdk/utils/DataSourceArrayList.size:()I
        //    10: istore_2        /* startIndex */
        //    11: aload_0         /* this */
        //    12: aload_1         /* elements */
        //    13: invokespecial   java/util/ArrayList.addAll:(Ljava/util/Collection;)Z
        //    16: istore_3        /* result */
        //    17: aload_0         /* this */
        //    18: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.getUpdateItemListInfo:()Z
        //    21: ifeq            105
        //    24: aload_1         /* elements */
        //    25: checkcast       Ljava/lang/Iterable;
        //    28: astore          $this$forEachIndexed$iv
        //    30: iconst_0       
        //    31: istore          $i$f$forEachIndexed
        //    33: iconst_0       
        //    34: istore          index$iv
        //    36: aload           $this$forEachIndexed$iv
        //    38: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    43: astore          7
        //    45: aload           7
        //    47: invokeinterface java/util/Iterator.hasNext:()Z
        //    52: ifeq            104
        //    55: aload           7
        //    57: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    62: astore          item$iv
        //    64: iload           index$iv
        //    66: iinc            index$iv, 1
        //    69: istore          9
        //    71: iload           9
        //    73: ifge            79
        //    76: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //    79: iload           9
        //    81: aload           item$iv
        //    83: astore          10
        //    85: istore          itemIndex
        //    87: iconst_0       
        //    88: istore          $i$a$-forEachIndexed-DataSourceArrayList$addAll$1
        //    90: aload_0         /* this */
        //    91: aload           item
        //    93: iload_2         /* startIndex */
        //    94: iload           itemIndex
        //    96: iadd           
        //    97: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.updatePosition:(Ljava/lang/Object;I)V
        //   100: nop            
        //   101: goto            45
        //   104: nop            
        //   105: aload_0         /* this */
        //   106: getfield        ly/img/android/pesdk/utils/DataSourceArrayList.callbacks:Lly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler;
        //   109: aload_0         /* this */
        //   110: checkcast       Ljava/util/List;
        //   113: iload_2         /* startIndex */
        //   114: iload_2         /* startIndex */
        //   115: aload_1         /* elements */
        //   116: invokeinterface java/util/Collection.size:()I
        //   121: iadd           
        //   122: invokevirtual   ly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler.listItemsAdded:(Ljava/util/List;II)V
        //   125: iload_3         /* result */
        //   126: ireturn        
        //    Signature:
        //  (Ljava/util/Collection<+TTYPE;>;)Z
        //    StackMapTable: 00 04 FF 00 2D 00 08 07 00 02 07 00 90 01 01 07 00 96 01 01 07 00 9C 00 00 FD 00 21 07 00 71 01 F9 00 18 FF 00 00 00 04 07 00 02 07 00 90 01 01 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
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
    
    @Override
    public boolean addAll(final int index, @NotNull final Collection<? extends TYPE> elements) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "elements"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: iload_1         /* index */
        //     8: aload_2         /* elements */
        //     9: invokespecial   java/util/ArrayList.addAll:(ILjava/util/Collection;)Z
        //    12: istore_3        /* result */
        //    13: aload_0         /* this */
        //    14: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.getUpdateItemListInfo:()Z
        //    17: ifeq            101
        //    20: aload_2         /* elements */
        //    21: checkcast       Ljava/lang/Iterable;
        //    24: astore          $this$forEachIndexed$iv
        //    26: iconst_0       
        //    27: istore          $i$f$forEachIndexed
        //    29: iconst_0       
        //    30: istore          index$iv
        //    32: aload           $this$forEachIndexed$iv
        //    34: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    39: astore          7
        //    41: aload           7
        //    43: invokeinterface java/util/Iterator.hasNext:()Z
        //    48: ifeq            100
        //    51: aload           7
        //    53: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //    58: astore          item$iv
        //    60: iload           index$iv
        //    62: iinc            index$iv, 1
        //    65: istore          9
        //    67: iload           9
        //    69: ifge            75
        //    72: invokestatic    kotlin/collections/CollectionsKt.throwIndexOverflow:()V
        //    75: iload           9
        //    77: aload           item$iv
        //    79: astore          10
        //    81: istore          itemIndex
        //    83: iconst_0       
        //    84: istore          $i$a$-forEachIndexed-DataSourceArrayList$addAll$2
        //    86: aload_0         /* this */
        //    87: aload           item
        //    89: iload_1         /* index */
        //    90: iload           itemIndex
        //    92: iadd           
        //    93: invokespecial   ly/img/android/pesdk/utils/DataSourceArrayList.updatePosition:(Ljava/lang/Object;I)V
        //    96: nop            
        //    97: goto            41
        //   100: nop            
        //   101: aload_0         /* this */
        //   102: getfield        ly/img/android/pesdk/utils/DataSourceArrayList.callbacks:Lly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler;
        //   105: aload_0         /* this */
        //   106: checkcast       Ljava/util/List;
        //   109: iload_1         /* index */
        //   110: iload_1         /* index */
        //   111: aload_2         /* elements */
        //   112: invokeinterface java/util/Collection.size:()I
        //   117: iadd           
        //   118: invokevirtual   ly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler.listItemsAdded:(Ljava/util/List;II)V
        //   121: iload_3         /* result */
        //   122: ireturn        
        //    Signature:
        //  (ILjava/util/Collection<+TTYPE;>;)Z
        //    StackMapTable: 00 04 FF 00 29 00 08 07 00 02 01 07 00 90 01 07 00 96 01 01 07 00 9C 00 00 FD 00 21 07 00 71 01 F9 00 18 FF 00 00 00 04 07 00 02 01 07 00 90 01 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
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
    
    public void removeRange(final int fromIndex, final int toIndex) {
        this.callbacks.beforeListItemsRemoved(this, fromIndex, toIndex);
        if (this.getUpdateItemListInfo()) {
            final Iterable $this$forEach$iv = (Iterable)new IntRange(fromIndex, toIndex);
            final int $i$f$forEach = 0;
            final Iterator iterator = $this$forEach$iv.iterator();
            while (iterator.hasNext()) {
                final int it;
                final int element$iv = it = ((IntIterator)iterator).nextInt();
                final int n = 0;
                final TYPE value = this.get(it);
                if (value != null) {
                    this.updatePosition(value, -1);
                }
            }
        }
        super.removeRange(fromIndex, toIndex);
        this.callbacks.listItemsRemoved(this, fromIndex, toIndex);
    }
    
    @Override
    public boolean removeAll(@NotNull final Collection<?> elements) {
        Intrinsics.checkNotNullParameter((Object)elements, "elements");
        final boolean result = super.removeAll(elements);
        final Iterable $this$forEach$iv = elements;
        final int $i$f$forEach = 0;
        for (final Object it : $this$forEach$iv) {
            final Object element$iv = it;
            final int n = 0;
            this.updatePosition(it, -1);
        }
        this.callbacks.listInvalid(this);
        return result;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(@NotNull final Parcel dest, final int flags) {
        Intrinsics.checkNotNullParameter((Object)dest, "dest");
        dest.writeInt((int)(this.getUpdateItemListInfo() ? 1 : 0));
        final int size = this.size();
        dest.writeInt(size);
        dest.writeSerializable((Serializable)this.getClass());
        for (int i = 0; i < size; ++i) {
            dest.writeValue(this.get(i));
        }
    }
    
    public DataSourceArrayList(@NotNull final Parcel parcel) {
        Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
        this.callbacks = new CallbackHandler();
        this.updateItemListInfo = (parcel.readInt() != 0);
        final int size = parcel.readInt();
        final Class c = (Class)parcel.readSerializable();
        for (int i = 0; i < size; ++i) {
            final Class clazz = c;
            Intrinsics.checkNotNull((Object)clazz);
            final Object value = parcel.readValue(clazz.getClassLoader());
            this.updatePosition(value, i);
            super.add((TYPE)value);
        }
    }
    
    private final void setPrevListInfo(final ListInfo<?> $this$setPrevListInfo, final ListInfo<?> info) {
        $this$setPrevListInfo.setPrevItem(info);
        Object o = info;
        ListInfo<?> listInfo = info;
        if (info == null) {
            o = (listInfo = null);
        }
        if (listInfo != null) {
            ((ListInfo<?>)o).setNextItem($this$setPrevListInfo);
        }
    }
    
    private final void setNextListInfo(final ListInfo<?> $this$setNextListInfo, final ListInfo<?> info) {
        $this$setNextListInfo.setNextItem(info);
        Object o = info;
        ListInfo<?> listInfo = info;
        if (info == null) {
            o = (listInfo = null);
        }
        if (listInfo != null) {
            ((ListInfo<?>)o).setPrevItem($this$setNextListInfo);
        }
    }
    
    @NotNull
    public DataSourceArrayList<TYPE> createSaveState() {
        final Object clone = Settings.SaveState.clone(this);
        if (clone == null) {
            throw new NullPointerException("null cannot be cast to non-null type ly.img.android.pesdk.utils.DataSourceArrayList<TYPE of ly.img.android.pesdk.utils.DataSourceArrayList>");
        }
        return (DataSourceArrayList<TYPE>)clone;
    }
    
    public void revertState(@NotNull final DataSourceArrayList<TYPE> state) {
        Intrinsics.checkNotNullParameter((Object)state, "state");
        this.set((List<? extends TYPE>)state);
    }
    
    @JvmOverloads
    public DataSourceArrayList() {
        this(false, 1, null);
    }
    
    @JvmOverloads
    public DataSourceArrayList(@NotNull final Collection<? extends TYPE> c) {
        Intrinsics.checkNotNullParameter((Object)c, "c");
        this(c, false, 2, null);
    }
    
    @JvmOverloads
    public DataSourceArrayList(final int initialCapacity) {
        this(initialCapacity, false, 2, null);
    }
    
    @Deprecated(message = "Value is directly parcelable please use parcel.writeParcelable and parcel.readParcelable")
    @JvmStatic
    @NotNull
    @java.lang.Deprecated
    public static final <T> DataSourceArrayList<T> createTypedDataSourceArrayList(@NotNull final Parcel parcel, @Nullable final ClassLoader loader) {
        return DataSourceArrayList.Companion.createTypedDataSourceArrayList(parcel, loader);
    }
    
    @Deprecated(message = "Value is directly parcelable please use parcel.writeParcelable and parcel.readParcelable")
    @JvmStatic
    @Nullable
    @java.lang.Deprecated
    public static final <T> DataSourceArrayList<T> createTypedDataSourceArrayList(@NotNull final Parcel parcel, @NotNull final Parcelable$Creator<T> creator) {
        return DataSourceArrayList.Companion.createTypedDataSourceArrayList(parcel, creator);
    }
    
    @Override
    public final /* bridge */ TYPE remove(final int index) {
        return this.removeAt(index);
    }
    
    public /* bridge */ int getSize() {
        return super.size();
    }
    
    @Override
    public final /* bridge */ int size() {
        return this.getSize();
    }
    
    static {
        Companion = new Companion(null);
        final int $i$f$parcelableCreator = 0;
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<DataSourceArrayList<?>>() {
            public DataSourceArrayList<?> createFromParcel(@NotNull final Parcel source) {
                Intrinsics.checkNotNullParameter((Object)source, "source");
                final Parcel it = source;
                final int n = 0;
                return new DataSourceArrayList<Object>(it);
            }
            
            @NotNull
            public DataSourceArrayList<?>[] newArray(final int size) {
                return (DataSourceArrayList<?>[])new DataSourceArrayList[size];
            }
        };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0002B\u0005¢\u0006\u0002\u0010\u0003J \u0010\u0004\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u000b\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J\u0018\u0010\u000e\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u0007H\u0016J \u0010\u000f\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0010\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J \u0010\u0011\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\t\u001a\u00020\nH\u0016J(\u0010\u0012\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016J(\u0010\u0013\u001a\u00020\u00052\u000e\u0010\u0006\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\b0\u00072\u0006\u0010\f\u001a\u00020\n2\u0006\u0010\r\u001a\u00020\nH\u0016¨\u0006\u0014" }, d2 = { "Lly/img/android/pesdk/utils/DataSourceArrayList$CallbackHandler;", "Lly/img/android/pesdk/utils/WeakCallSet;", "Lly/img/android/pesdk/utils/DataSourceArrayList$Callback;", "()V", "beforeListItemRemoved", "", "data", "", "", "index", "", "beforeListItemsRemoved", "from", "to", "listInvalid", "listItemAdded", "listItemChanged", "listItemRemoved", "listItemsAdded", "listItemsRemoved", "pesdk-backend-core_release" })
    private static final class CallbackHandler extends WeakCallSet<Callback> implements Callback
    {
        public CallbackHandler() {
        }
        
        @Override
        public void listInvalid(@NotNull final List<?> data) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listInvalid(data);
            }
        }
        
        @Override
        public void listItemChanged(@NotNull final List<?> data, final int index) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listItemChanged(data, index);
            }
        }
        
        @Override
        public void listItemAdded(@NotNull final List<?> data, final int index) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listItemAdded(data, index);
            }
        }
        
        @Override
        public void listItemsAdded(@NotNull final List<?> data, final int from, final int to) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listItemsAdded(data, from, to);
            }
        }
        
        @Override
        public void listItemRemoved(@NotNull final List<?> data, final int index) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listItemRemoved(data, index);
            }
        }
        
        @Override
        public void listItemsRemoved(@NotNull final List<?> data, final int from, final int to) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.listItemsRemoved(data, from, to);
            }
        }
        
        @Override
        public void beforeListItemRemoved(@NotNull final List<?> data, final int index) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.beforeListItemRemoved(data, index);
            }
        }
        
        @Override
        public void beforeListItemsRemoved(@NotNull final List<?> data, final int from, final int to) {
            Intrinsics.checkNotNullParameter((Object)data, "data");
            for (final Callback callback : this) {
                callback.beforeListItemsRemoved(data, from, to);
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J,\u0010\u0006\u001a\n\u0012\u0004\u0012\u0002H\u0007\u0018\u00010\u0005\"\u0004\b\u0001\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0004H\u0007J&\u0010\u0006\u001a\b\u0012\u0004\u0012\u0002H\u00070\u0005\"\u0004\b\u0001\u0010\u00072\u0006\u0010\b\u001a\u00020\t2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0007R\u001a\u0010\u0003\u001a\f\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lly/img/android/pesdk/utils/DataSourceArrayList$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lly/img/android/pesdk/utils/DataSourceArrayList;", "createTypedDataSourceArrayList", "T", "parcel", "Landroid/os/Parcel;", "creator", "loader", "Ljava/lang/ClassLoader;", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @Deprecated(message = "Value is directly parcelable please use parcel.writeParcelable and parcel.readParcelable")
        @JvmStatic
        @NotNull
        @java.lang.Deprecated
        public final <T> DataSourceArrayList<T> createTypedDataSourceArrayList(@NotNull final Parcel parcel, @Nullable final ClassLoader loader) {
            Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
            int size = parcel.readInt();
            if (size < 0) {
                throw new RuntimeException("Is required to be not null");
            }
            final DataSourceArrayList l = new DataSourceArrayList(size, false, 2, null);
            while (size > 0) {
                final Object value = parcel.readValue(loader);
                l.add(value);
                --size;
            }
            return (DataSourceArrayList<T>)l;
        }
        
        @Deprecated(message = "Value is directly parcelable please use parcel.writeParcelable and parcel.readParcelable")
        @JvmStatic
        @Nullable
        @java.lang.Deprecated
        public final <T> DataSourceArrayList<T> createTypedDataSourceArrayList(@NotNull final Parcel parcel, @NotNull final Parcelable$Creator<T> creator) {
            Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
            Intrinsics.checkNotNullParameter((Object)creator, "creator");
            int size = parcel.readInt();
            if (size < 0) {
                return null;
            }
            final DataSourceArrayList l = new DataSourceArrayList(size, false, 2, null);
            while (size > 0) {
                if (parcel.readInt() != 0) {
                    l.add(creator.createFromParcel(parcel));
                }
                else {
                    l.add(null);
                }
                --size;
            }
            return (DataSourceArrayList<T>)l;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0002\b\n\bf\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\b\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J\u0014\u0010\u000b\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u0005H&J\u001c\u0010\f\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\r\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J\u001c\u0010\u000e\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\u0006\u001a\u00020\u0007H&J$\u0010\u000f\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&J$\u0010\u0010\u001a\u00020\u00032\n\u0010\u0004\u001a\u0006\u0012\u0002\b\u00030\u00052\u0006\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H&¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/utils/DataSourceArrayList$Callback;", "", "beforeListItemRemoved", "", "data", "", "index", "", "beforeListItemsRemoved", "from", "to", "listInvalid", "listItemAdded", "listItemChanged", "listItemRemoved", "listItemsAdded", "listItemsRemoved", "pesdk-backend-core_release" })
    public interface Callback
    {
        void listInvalid(@NotNull final List<?> p0);
        
        void listItemChanged(@NotNull final List<?> p0, final int p1);
        
        void listItemAdded(@NotNull final List<?> p0, final int p1);
        
        void listItemsAdded(@NotNull final List<?> p0, final int p1, final int p2);
        
        void listItemRemoved(@NotNull final List<?> p0, final int p1);
        
        void listItemsRemoved(@NotNull final List<?> p0, final int p1, final int p2);
        
        void beforeListItemRemoved(@NotNull final List<?> p0, final int p1);
        
        void beforeListItemsRemoved(@NotNull final List<?> p0, final int p1, final int p2);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\t\bf\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002R\u001a\u0010\u0003\u001a\u0004\u0018\u00018\u0001X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u0004\u0018\u00018\u0001X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007¨\u0006\u000b" }, d2 = { "Lly/img/android/pesdk/utils/DataSourceArrayList$ListInfo;", "INFO_TYPE", "", "nextItem", "getNextItem", "()Ljava/lang/Object;", "setNextItem", "(Ljava/lang/Object;)V", "prevItem", "getPrevItem", "setPrevItem", "pesdk-backend-core_release" })
    public interface ListInfo<INFO_TYPE>
    {
        @Nullable
        INFO_TYPE getPrevItem();
        
        void setPrevItem(@Nullable final INFO_TYPE p0);
        
        @Nullable
        INFO_TYPE getNextItem();
        
        void setNextItem(@Nullable final INFO_TYPE p0);
    }
}
