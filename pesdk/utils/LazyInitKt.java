// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u00008\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0000\u001a \u0010\u0000\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0001\"\u0004\b\u0000\u0010\u00022\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u0002H\u00020\u0004\u001a\u0014\u0010\u0005\u001a\u00020\u00062\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u001a\u0014\u0010\b\u001a\u00020\t2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\n0\u0004\u001a\u0014\u0010\u000b\u001a\u00020\f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\r0\u0004\u001a\u0014\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00100\u0004¨\u0006\u0011" }, d2 = { "lazyInit", "Lly/img/android/pesdk/utils/LazyInit;", "T", "initializer", "Lkotlin/Function0;", "lazyInitDouble", "Lly/img/android/pesdk/utils/LazyInitDouble;", "", "lazyInitFloat", "Lly/img/android/pesdk/utils/LazyInitFloat;", "", "lazyInitInt", "Lly/img/android/pesdk/utils/LazyInitInt;", "", "lazyInitLong", "Lly/img/android/pesdk/utils/LazyInitLong;", "", "pesdk-backend-core_release" })
public final class LazyInitKt
{
    @NotNull
    public static final LazyInitInt lazyInitInt(@NotNull final Function0<Integer> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        return new LazyInitInt(initializer);
    }
    
    @NotNull
    public static final LazyInitLong lazyInitLong(@NotNull final Function0<Long> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        return new LazyInitLong(initializer);
    }
    
    @NotNull
    public static final LazyInitFloat lazyInitFloat(@NotNull final Function0<Float> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        return new LazyInitFloat(initializer);
    }
    
    @NotNull
    public static final LazyInitDouble lazyInitDouble(@NotNull final Function0<Double> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        return new LazyInitDouble(initializer);
    }
    
    @NotNull
    public static final <T> LazyInit<T> lazyInit(@NotNull final Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        return new LazyInit<T>(initializer);
    }
}
