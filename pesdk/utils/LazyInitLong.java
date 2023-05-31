// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.reflect.KProperty;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\u001f\u0010\n\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u0010H\u0086\u0002J'\u0010\f\u001a\u00020\u00112\b\u0010\u000e\u001a\u0004\u0018\u00010\u00012\n\u0010\u000f\u001a\u0006\u0012\u0002\b\u00030\u00102\u0006\u0010\t\u001a\u00020\u0004H\u0086\u0002J\b\u0010\u0012\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010\t\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00048F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0014" }, d2 = { "Lly/img/android/pesdk/utils/LazyInitLong;", "", "initializer", "Lkotlin/Function0;", "", "(Lkotlin/jvm/functions/Function0;)V", "_value", "isInitialized", "", "value", "getValue", "()J", "setValue", "(J)V", "thisRef", "property", "Lkotlin/reflect/KProperty;", "", "toString", "", "pesdk-backend-core_release" })
public final class LazyInitLong
{
    @NotNull
    private Function0<Long> initializer;
    private boolean isInitialized;
    private long _value;
    
    public LazyInitLong(@NotNull final Function0<Long> initializer) {
        Intrinsics.checkNotNullParameter((Object)initializer, "initializer");
        this.initializer = initializer;
        this._value = Long.MIN_VALUE;
    }
    
    public final long getValue() {
        if (!this.isInitialized) {
            this.isInitialized = true;
            this._value = ((Number)this.initializer.invoke()).longValue();
        }
        return this._value;
    }
    
    public final void setValue(final long value) {
        this._value = value;
    }
    
    public final long getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
        Intrinsics.checkNotNullParameter((Object)property, "property");
        return this.getValue();
    }
    
    public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final long value) {
        Intrinsics.checkNotNullParameter((Object)property, "property");
        this.setValue(value);
    }
    
    @NotNull
    @Override
    public String toString() {
        return String.valueOf(this.getValue());
    }
}
