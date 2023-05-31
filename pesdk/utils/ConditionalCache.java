// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.JvmField;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002:\u0001\u0019B*\u0012#\b\u0002\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u0004¢\u0006\u0002\u0010\tJ\u0006\u0010\u0010\u001a\u00020\bJ5\u0010\u0011\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00130\u0004H\u0086\f\u00f8\u0001\u0000J\u001f\u0010\u0014\u001a\u00028\u00002\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00028\u00000\u0016H\u0086\f\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0017J5\u0010\u0018\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b2!\u0010\u0012\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\u00130\u0004H\u0086\f\u00f8\u0001\u0000R\u001c\u0010\n\u001a\b\u0012\u0004\u0012\u00028\u00000\u000b8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u0012\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00018\u00008\u0006@\u0006X\u0087\u000e¢\u0006\u0004\n\u0002\u0010\u000fR+\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00118\u0000¢\u0006\f\b\u0005\u0012\b\b\u0006\u0012\u0004\b\b(\u0007\u0012\u0004\u0012\u00020\b0\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a" }, d2 = { "Lly/img/android/pesdk/utils/ConditionalCache;", "T", "", "finalize", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "", "(Lkotlin/jvm/functions/Function1;)V", "_bound", "Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;", "get_bound$annotations", "()V", "cache", "Ljava/lang/Object;", "release", "useIf", "condition", "", "useOrCreate", "creator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "useUnless", "BoundCache", "pesdk-backend-core_release" })
public final class ConditionalCache<T>
{
    @JvmField
    @NotNull
    public final Function1<T, Unit> finalize;
    @JvmField
    @NotNull
    public final BoundCache<T> _bound;
    @JvmField
    @Nullable
    public T cache;
    
    public ConditionalCache(@NotNull final Function1<? super T, Unit> finalize) {
        Intrinsics.checkNotNullParameter((Object)finalize, "finalize");
        this.finalize = (Function1<T, Unit>)finalize;
        this._bound = new BoundCache<T>(this);
    }
    
    @NotNull
    public final BoundCache<T> useIf(@NotNull final Function1<? super T, Boolean> condition) {
        Intrinsics.checkNotNullParameter((Object)condition, "condition");
        final int $i$f$useIf = 0;
        final BoundCache<T> bound = this._bound;
        final T cache = this.cache;
        bound.reuseCache = (cache != null && (boolean)condition.invoke((Object)cache));
        return this._bound;
    }
    
    @NotNull
    public final BoundCache<T> useUnless(@NotNull final Function1<? super T, Boolean> condition) {
        Intrinsics.checkNotNullParameter((Object)condition, "condition");
        final int $i$f$useUnless = 0;
        final BoundCache<T> bound = this._bound;
        final T cache = this.cache;
        bound.reuseCache = (cache == null || !(boolean)condition.invoke((Object)cache));
        return this._bound;
    }
    
    public final T useOrCreate(@NotNull final Function0<? extends T> creator) {
        Intrinsics.checkNotNullParameter((Object)creator, "creator");
        final int $i$f$useOrCreate = 0;
        this._bound.reuseCache = true;
        final BoundCache this_$iv = this._bound;
        final int $i$f$orCreate = 0;
        final Object value$iv = this_$iv.parent.cache;
        Object o;
        if (value$iv != null && this_$iv.reuseCache) {
            o = value$iv;
        }
        else {
            final Object o2 = value$iv;
            if (o2 != null) {
                this_$iv.parent.finalize.invoke(o2);
            }
            final Object it$iv = creator.invoke();
            final int n = 0;
            this_$iv.parent.cache = (T)it$iv;
            o = it$iv;
        }
        return (T)o;
    }
    
    public final void release() {
        final T cache = this.cache;
        if (cache != null) {
            this.finalize.invoke((Object)cache);
        }
        this.cache = null;
    }
    
    public ConditionalCache() {
        this(null, 1, null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000*\u0004\b\u0001\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u0004¢\u0006\u0002\u0010\u0005J5\u0010\b\u001a\b\u0012\u0004\u0012\u00028\u00010\u00002!\u0010\t\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0004\u0012\u00020\u000e0\nH\u0086\f\u00f8\u0001\u0000J\u001f\u0010\u000f\u001a\u00028\u00012\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00028\u00010\u0011H\u0086\f\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0012R\u0016\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00010\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0013" }, d2 = { "Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;", "T", "", "parent", "Lly/img/android/pesdk/utils/ConditionalCache;", "(Lly/img/android/pesdk/utils/ConditionalCache;)V", "reuseCache", "", "andPrepare", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "", "orCreate", "creator", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "pesdk-backend-core_release" })
    public static final class BoundCache<T>
    {
        @JvmField
        @NotNull
        public final ConditionalCache<T> parent;
        @JvmField
        public boolean reuseCache;
        
        public BoundCache(@NotNull final ConditionalCache<T> parent) {
            Intrinsics.checkNotNullParameter((Object)parent, "parent");
            this.parent = parent;
        }
        
        @NotNull
        public final BoundCache<T> andPrepare(@NotNull final Function1<? super T, Unit> block) {
            Intrinsics.checkNotNullParameter((Object)block, "block");
            final int $i$f$andPrepare = 0;
            if (this.reuseCache) {
                final T cache = this.parent.cache;
                if (cache != null) {
                    block.invoke((Object)cache);
                }
            }
            return this;
        }
        
        public final T orCreate(@NotNull final Function0<? extends T> creator) {
            Intrinsics.checkNotNullParameter((Object)creator, "creator");
            final int $i$f$orCreate = 0;
            final Object value = this.parent.cache;
            Object o;
            if (value != null && this.reuseCache) {
                o = value;
            }
            else {
                final Object o2 = value;
                if (o2 != null) {
                    this.parent.finalize.invoke(o2);
                }
                final Object it = creator.invoke();
                final int n = 0;
                this.parent.cache = (T)it;
                o = it;
            }
            return (T)o;
        }
    }
}
