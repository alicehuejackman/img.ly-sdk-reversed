// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KClass;
import java.util.Map;
import java.util.TreeMap;
import androidx.core.math.MathUtils;
import kotlin.reflect.KMutableProperty0;
import java.lang.ref.WeakReference;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.functions.Function0;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000N\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aG\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00012\u0006\u0010\u0004\u001a\u00020\u00012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00110\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0006H\u0086\b\u00f8\u0001\u0000\u001a1\u0010\n\u001a\u0004\u0018\u0001H\u000b\"\u0004\b\u0000\u0010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u000b0\u000fH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0010\u001a\u001c\u0010\u0011\u001a\u00020\u00122\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000fH\u0086\b\u00f8\u0001\u0000\u001a)\u0010\u0013\u001a\u0004\u0018\u0001H\u0014\"\u0004\b\u0000\u0010\u00142\u000e\b\u0004\u0010\u000e\u001a\b\u0012\u0004\u0012\u0002H\u00140\u000fH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0015\u001a\u0016\u0010\u0016\u001a\u00020\u00122\u000e\u0010\u0017\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00190\u0018\u001a%\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u0001H\u001c0\u001b\"\u0004\b\u0000\u0010\u001c2\n\b\u0002\u0010\t\u001a\u0004\u0018\u0001H\u001c¢\u0006\u0002\u0010\u001d\u001a1\u0010\u001e\u001a\u0004\u0018\u0001H\u001f\"\u0004\b\u0000\u0010 \"\u0004\b\u0001\u0010\u001f*\u000e\u0012\u0004\u0012\u0002H \u0012\u0004\u0012\u0002H\u001f0!2\u0006\u0010\"\u001a\u0002H ¢\u0006\u0002\u0010#\u001aB\u0010$\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u0002H\u00142%\b\u0004\u0010\u000e\u001a\u001f\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(%\u0012\u0006\u0012\u0004\u0018\u0001H\u00140\u0006H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010&\u001a(\u0010'\u001a\u0002H\u0014\"\u0004\b\u0000\u0010\u0014*\u0002H\u00142\u000e\u0010(\u001a\n\u0012\u0006\b\u0000\u0012\u0002H\u00140)H\u0086\u0004¢\u0006\u0002\u0010*\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006+" }, d2 = { "binarySearch", "", "from", "to", "expected", "searchResult", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "value", "continueWithExceptions", "X", "log", "", "block", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "loopIfTrue", "", "skipIfNotExists", "T", "(Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "throwIfClassNotPresent", "classReference", "Lkotlin/reflect/KClass;", "", "weak", "Lly/img/android/pesdk/kotlin_extension/WeakDelegate;", "TYPE", "(Ljava/lang/Object;)Lly/img/android/pesdk/kotlin_extension/WeakDelegate;", "floorValue", "VALUE", "KEY", "Ljava/util/TreeMap;", "key", "(Ljava/util/TreeMap;Ljava/lang/Object;)Ljava/lang/Object;", "loopAsLongNotNull", "it", "(Ljava/lang/Object;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "setField", "field", "Lkotlin/reflect/KMutableProperty0;", "(Ljava/lang/Object;Lkotlin/reflect/KMutableProperty0;)Ljava/lang/Object;", "pesdk-backend-core_release" })
public final class HelperKt
{
    public static final void loopIfTrue(@NotNull final Function0<Boolean> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$loopIfTrue = 0;
        while (block.invoke()) {}
    }
    
    public static final <T> T loopAsLongNotNull(final T $this$loopAsLongNotNull, @NotNull final Function1<? super T, ? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$loopAsLongNotNull = 0;
        Object last = $this$loopAsLongNotNull;
        while (true) {
            final Object invoke = block.invoke(last);
            if (invoke == null) {
                break;
            }
            last = invoke;
        }
        return (T)last;
    }
    
    @NotNull
    public static final <TYPE> WeakDelegate<TYPE> weak(@Nullable final TYPE value) {
        return new WeakDelegate<TYPE>(new WeakReference<TYPE>(value));
    }
    
    @Nullable
    public static final <X> X continueWithExceptions(final boolean log, @NotNull final Function0<? extends X> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$continueWithExceptions = 0;
        Object invoke;
        try {
            invoke = block.invoke();
        }
        catch (Exception ignored) {
            if (log) {
                ignored.printStackTrace();
            }
            invoke = null;
        }
        return (X)invoke;
    }
    
    public static final <T> T setField(final T $this$setField, @NotNull final KMutableProperty0<? super T> field) {
        Intrinsics.checkNotNullParameter((Object)field, "field");
        field.set((Object)$this$setField);
        return $this$setField;
    }
    
    public static final int binarySearch(final int from, final int to, final int expected, @NotNull final Function1<? super Integer, Integer> searchResult) {
        Intrinsics.checkNotNullParameter((Object)searchResult, "searchResult");
        final int $i$f$binarySearch = 0;
        int lo = 0;
        int mid = to - from;
        int hi = to - from << 1;
        int lastFit = mid;
        while (lo <= hi) {
            mid = lo + (hi - lo >> 1);
            final int result = ((Number)searchResult.invoke((Object)(from + mid))).intValue();
            if (expected < result) {
                hi = mid - 1;
                lastFit = mid - 1;
            }
            else {
                if (expected <= result) {
                    lastFit = mid;
                    break;
                }
                lo = mid + 1;
                if (from + mid >= to) {
                    return to;
                }
                continue;
            }
        }
        return MathUtils.clamp(from + lastFit, from, to);
    }
    
    @Nullable
    public static final <KEY, VALUE> VALUE floorValue(@NotNull final TreeMap<KEY, VALUE> $this$floorValue, final KEY key) {
        Intrinsics.checkNotNullParameter((Object)$this$floorValue, "<this>");
        final Map.Entry<KEY, VALUE> floorEntry = $this$floorValue.floorEntry(key);
        return (floorEntry != null) ? floorEntry.getValue() : null;
    }
    
    @Nullable
    public static final <T> T skipIfNotExists(@NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$skipIfNotExists = 0;
        Object invoke;
        try {
            invoke = block.invoke();
        }
        catch (NoClassDefFoundError e) {
            invoke = null;
        }
        return (T)invoke;
    }
    
    public static final void throwIfClassNotPresent(@NotNull final KClass<?> classReference) throws NoClassDefFoundError {
        Intrinsics.checkNotNullParameter((Object)classReference, "classReference");
        if (Reflection.getOrCreateKotlinClass((Class)classReference.getClass()).toString().length() == 0) {
            throw new NoClassDefFoundError();
        }
    }
}
