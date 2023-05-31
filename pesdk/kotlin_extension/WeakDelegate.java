// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import org.jetbrains.annotations.Nullable;
import kotlin.reflect.KProperty;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.lang.ref.WeakReference;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\u0005J$\u0010\u0006\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\u0002¢\u0006\u0002\u0010\nJ*\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0007\u001a\u00020\u00022\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\r\u001a\u00028\u0000H\u0086\u0002¢\u0006\u0002\u0010\u000eR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00028\u00000\u0004X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/WeakDelegate;", "TYPE", "", "weakReference", "Ljava/lang/ref/WeakReference;", "(Ljava/lang/ref/WeakReference;)V", "getValue", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setValue", "", "value", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
public final class WeakDelegate<TYPE>
{
    @NotNull
    private WeakReference<TYPE> weakReference;
    
    public WeakDelegate(@NotNull final WeakReference<TYPE> weakReference) {
        Intrinsics.checkNotNullParameter((Object)weakReference, "weakReference");
        this.weakReference = weakReference;
    }
    
    @Nullable
    public final TYPE getValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter((Object)property, "property");
        return this.weakReference.get();
    }
    
    public final void setValue(@NotNull final Object thisRef, @NotNull final KProperty<?> property, final TYPE value) {
        Intrinsics.checkNotNullParameter(thisRef, "thisRef");
        Intrinsics.checkNotNullParameter((Object)property, "property");
        this.weakReference = new WeakReference<TYPE>(value);
    }
}
