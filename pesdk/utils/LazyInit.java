// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.reflect.KProperty;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J$\u0010\b\u001a\u00028\u00002\b\u0010\f\u001a\u0004\u0018\u00010\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000eH\u0086\n¢\u0006\u0002\u0010\u000fJ\u0006\u0010\u0010\u001a\u00020\u0011J,\u0010\n\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u00022\n\u0010\r\u001a\u0006\u0012\u0002\b\u00030\u000e2\u0006\u0010\u0007\u001a\u00028\u0000H\u0086\n¢\u0006\u0002\u0010\u0013J\b\u0010\u0014\u001a\u00020\u0015H\u0016R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0002X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\u0007\u001a\u00028\u00002\u0006\u0010\u0007\u001a\u00028\u00008F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/utils/LazyInit;", "T", "", "initializer", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;)V", "_value", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "isInitialized", "", "", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "toString", "", "pesdk-backend-core_release" })
public final class LazyInit<T>
{
    @NotNull
    private Function0<? extends T> initializer;
    @Nullable
    private volatile Object _value;
    
    public LazyInit(@NotNull final Function0<? extends T> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        this.initializer = initializer;
        this._value = UNINITIALIZED_VALUE.INSTANCE;
    }
    
    public final T getValue() {
        Object temp = this._value;
        Object o;
        if (temp != UNINITIALIZED_VALUE.INSTANCE) {
            o = temp;
        }
        else {
            temp = this._value;
            if (temp != UNINITIALIZED_VALUE.INSTANCE) {
                o = temp;
            }
            else {
                this._value = UNINITIALIZED_VALUE.INSTANCE;
                final Object typedValue = this.initializer.invoke();
                this._value = typedValue;
                o = typedValue;
            }
        }
        return (T)o;
    }
    
    public final void setValue(final T value) {
        this._value = value;
    }
    
    public final T getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)property, "property");
        final int $i$f$getValue = 0;
        return this.getValue();
    }
    
    public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final T value) {
        Intrinsics.checkNotNullParameter((Object)property, "property");
        final int $i$f$setValue = 0;
        this.setValue(value);
    }
    
    public final boolean isInitialized() {
        return this._value != UNINITIALIZED_VALUE.INSTANCE;
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.isInitialized() ? String.valueOf(this.getValue()) : "PreInit value not initialized yet.";
    }
}
