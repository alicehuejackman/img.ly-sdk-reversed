// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.InlineMarker;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.List;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B\u0015\u0012\u000e\b\u0002\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J7\u0010\u0006\u001a\u00020\u00072)\b\u0004\u0010\b\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u00070\tH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\r" }, d2 = { "Lly/img/android/pesdk/utils/LockableMutableList;", "T", "Lly/img/android/pesdk/utils/LockableList;", "list", "", "(Ljava/util/List;)V", "write", "", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "pesdk-backend-core_release" })
public final class LockableMutableList<T> extends LockableList<T>
{
    public LockableMutableList(@NotNull final List<T> list) {
        Intrinsics.checkNotNullParameter((Object)list, "list");
        super(list);
    }
    
    public final void write(@NotNull final Function1<? super List<T>, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$write = 0;
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
    
    public LockableMutableList() {
        this(null, 1, null);
    }
}
