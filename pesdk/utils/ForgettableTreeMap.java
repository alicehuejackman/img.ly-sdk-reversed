// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.lang.ref.SoftReference;
import kotlin.jvm.internal.markers.KMappedMarker;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import java.util.Iterator;
import kotlin.jvm.internal.TypeIntrinsics;
import java.util.Map;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import java.util.TreeMap;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0004\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010&\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0019\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u0002*\u0004\b\u0001\u0010\u00032\u00020\u0004:\u0002/0B\r\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J!\u0010\u000e\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010\u0012\u001a\n \u0013*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0006\u0010\u0015\u001a\u00020\u0016J\u0013\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0019J\u0006\u0010\u001a\u001a\u00020\u0006J2\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u001a\u0010\u001c\u001a\u0016\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n\u0018\u00010\u000fH\u0002J\u0014\u0010\u001d\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fJ\u0013\u0010\u001e\u001a\n \u0013*\u0004\u0018\u00018\u00008\u0000¢\u0006\u0002\u0010\u001fJ!\u0010 \u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010!\u001a\n \u0013*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0015\u0010\"\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010#J!\u0010$\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010%\u001a\n \u0013*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J\u0014\u0010&\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000fJ\u0013\u0010'\u001a\n \u0013*\u0004\u0018\u00018\u00008\u0000¢\u0006\u0002\u0010\u001fJ!\u0010(\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001b\u0010)\u001a\n \u0013*\u0004\u0018\u00018\u00008\u00002\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0014J!\u0010*\u001a\u0010\u0012\u0004\u0012\u00028\u0000\u0012\u0004\u0012\u00028\u0001\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00028\u0000¢\u0006\u0002\u0010\u0011J\u001d\u0010+\u001a\u0004\u0018\u00018\u00012\u0006\u0010\u0010\u001a\u00028\u00002\u0006\u0010,\u001a\u00028\u0001¢\u0006\u0002\u0010-J\b\u0010.\u001a\u00020\u0016H\u0002R \u0010\b\u001a\u0014\u0012\u0004\u0012\u00028\u0000\u0012\n\u0012\b\u0012\u0004\u0012\u00028\u00010\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000b\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\r¨\u00061" }, d2 = { "Lly/img/android/pesdk/utils/ForgettableTreeMap;", "KeyType", "", "ValueType", "", "maxSize", "", "(I)V", "data", "Ljava/util/TreeMap;", "Lly/img/android/pesdk/utils/ForgettableTreeMap$TimedValue;", "size", "getSize", "()I", "ceilingEntry", "", "key", "(Ljava/lang/Number;)Ljava/util/Map$Entry;", "ceilingKey", "kotlin.jvm.PlatformType", "(Ljava/lang/Number;)Ljava/lang/Number;", "clear", "", "containsKey", "", "(Ljava/lang/Number;)Z", "count", "createStrongEntry", "entry", "firstEntry", "firstKey", "()Ljava/lang/Number;", "floorEntry", "floorKey", "get", "(Ljava/lang/Number;)Ljava/lang/Object;", "higherEntry", "higherKey", "lastEntry", "lastKey", "lowerEntry", "lowerKey", "nearestEntry", "put", "value", "(Ljava/lang/Number;Ljava/lang/Object;)Ljava/lang/Object;", "trimToSize", "Entry", "TimedValue", "pesdk-backend-core_release" })
public final class ForgettableTreeMap<KeyType extends Number, ValueType>
{
    private final int maxSize;
    @NotNull
    private final TreeMap<KeyType, TimedValue<ValueType>> data;
    
    public ForgettableTreeMap(final int maxSize) {
        this.maxSize = maxSize;
        this.data = new TreeMap<KeyType, TimedValue<ValueType>>();
    }
    
    public final int getSize() {
        return this.data.size();
    }
    
    private final void trimToSize() {
        if (this.data.size() > this.maxSize) {
            int deleteCount = 0;
            deleteCount = this.maxSize - this.data.size();
            final TreeMap sortedByTime = new TreeMap();
            final ArrayList emptyReferences = new ArrayList();
            final Map $this$forEach$iv = this.data;
            int $i$f$forEach = 0;
            for (final Map.Entry it : $this$forEach$iv.entrySet()) {
                final Map.Entry element$iv = it;
                final int n = 0;
                final long accessTime = it.getValue().getLastAccessTime();
                if (accessTime > 0L) {
                    sortedByTime.put(accessTime, it.getKey());
                }
                else {
                    emptyReferences.add(it.getKey());
                }
            }
            final Iterable $this$forEach$iv2 = emptyReferences;
            $i$f$forEach = 0;
            for (final Object element$iv2 : $this$forEach$iv2) {
                final Number it2 = (Number)element$iv2;
                final int n2 = 0;
                this.data.remove(it2);
                --deleteCount;
            }
            if (deleteCount > 0) {
                for (int n3 = deleteCount, i = 0; i < n3; ++i) {
                    final int it3 = i;
                    final int n4 = 0;
                    final Map.Entry<K, Number> pollFirstEntry = sortedByTime.pollFirstEntry();
                    final Number it2 = (pollFirstEntry != null) ? pollFirstEntry.getValue() : null;
                    final int n5 = 0;
                    TypeIntrinsics.asMutableMap((Object)this.data).remove(it2);
                }
            }
        }
    }
    
    @Nullable
    public final ValueType put(@NotNull final KeyType key, final ValueType value) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final TimedValue<ValueType> timedValue = this.data.put(key, new TimedValue<ValueType>(value));
        final Object it;
        final ValueType valueType = (ValueType)(it = ((timedValue != null) ? timedValue.getValue() : null));
        final int n = 0;
        this.trimToSize();
        return valueType;
    }
    
    public final int count() {
        return this.data.size();
    }
    
    public final void clear() {
        this.data.clear();
    }
    
    public final KeyType lastKey() {
        return this.data.lastKey();
    }
    
    public final KeyType firstKey() {
        return this.data.firstKey();
    }
    
    public final KeyType lowerKey(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.data.lowerKey(key);
    }
    
    public final KeyType floorKey(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.data.floorKey(key);
    }
    
    public final KeyType higherKey(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.data.higherKey(key);
    }
    
    public final KeyType ceilingKey(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.data.ceilingKey(key);
    }
    
    public final boolean containsKey(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.data.containsKey(key);
    }
    
    @Nullable
    public final ValueType get(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final TimedValue<ValueType> timedValue = this.data.get(key);
        return (timedValue != null) ? timedValue.getValue() : null;
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> lastEntry() {
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.lastEntry());
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> firstEntry() {
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.firstEntry());
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> lowerEntry(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.lowerEntry(key));
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> floorEntry(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.floorEntry(key));
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> higherEntry(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.higherEntry(key));
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> ceilingEntry(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return this.createStrongEntry((Map.Entry<? extends KeyType, TimedValue<ValueType>>)this.data.ceilingEntry(key));
    }
    
    @Nullable
    public final Map.Entry<KeyType, ValueType> nearestEntry(@NotNull final KeyType key) {
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final Number lower = this.data.floorKey(key);
        Number n;
        if ((n = this.data.higherKey(key)) == null) {
            n = lower;
        }
        final Number higher = n;
        if (lower == null) {
            final Number n2 = higher;
            Object floorEntry;
            if (n2 != null) {
                final Number it = n2;
                final int n3 = 0;
                floorEntry = this.floorEntry(it);
            }
            else {
                floorEntry = null;
            }
            return (Map.Entry<KeyType, ValueType>)floorEntry;
        }
        final double a = lower.doubleValue();
        final double b = higher.doubleValue();
        final double c = key.doubleValue();
        Map.Entry<Number, ValueType> entry;
        if (Math.abs(a - c) < Math.abs(b - c)) {
            entry = this.floorEntry(lower);
        }
        else {
            Intrinsics.checkNotNullExpressionValue((Object)higher, "higher");
            entry = this.floorEntry(higher);
        }
        return (Map.Entry<KeyType, ValueType>)entry;
    }
    
    private final Map.Entry<KeyType, ValueType> createStrongEntry(final Map.Entry<? extends KeyType, TimedValue<ValueType>> entry) {
        Entry entry2;
        if (entry != null) {
            final Map.Entry it = entry;
            final int n = 0;
            final Object value = it.getValue().getValue();
            if (value != null) {
                final Object v = value;
                final int n2 = 0;
                entry2 = new Entry(it.getKey(), v);
            }
            else {
                entry2 = null;
            }
        }
        else {
            entry2 = null;
        }
        return (Map.Entry<KeyType, ValueType>)entry2;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010&\n\u0002\b\b\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u0001*\u0004\b\u0003\u0010\u00022\u000e\u0012\u0004\u0012\u0002H\u0001\u0012\u0004\u0012\u0002H\u00020\u0003B\u0015\u0012\u0006\u0010\u0004\u001a\u00028\u0002\u0012\u0006\u0010\u0005\u001a\u00028\u0003¢\u0006\u0002\u0010\u0006R\u0016\u0010\u0004\u001a\u00028\u0002X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\u0007\u0010\bR\u0016\u0010\u0005\u001a\u00028\u0003X\u0096\u0004¢\u0006\n\n\u0002\u0010\t\u001a\u0004\b\n\u0010\b¨\u0006\u000b" }, d2 = { "Lly/img/android/pesdk/utils/ForgettableTreeMap$Entry;", "KeyType", "ValueType", "", "key", "value", "(Ljava/lang/Object;Ljava/lang/Object;)V", "getKey", "()Ljava/lang/Object;", "Ljava/lang/Object;", "getValue", "pesdk-backend-core_release" })
    private static final class Entry<KeyType, ValueType> implements Map.Entry<KeyType, ValueType>, KMappedMarker
    {
        private final KeyType key;
        private final ValueType value;
        
        public Entry(final KeyType key, final ValueType value) {
            this.key = key;
            this.value = value;
        }
        
        @Override
        public KeyType getKey() {
            return this.key;
        }
        
        @Override
        public ValueType getValue() {
            return this.value;
        }
        
        @Override
        public ValueType setValue(final ValueType newValue) {
            throw new UnsupportedOperationException("Operation is not supported for read-only collection");
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0002\u0018\u0000*\u0004\b\u0002\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0002¢\u0006\u0002\u0010\u0004R\u001e\u0010\u0007\u001a\u00020\u00062\u0006\u0010\u0005\u001a\u00020\u0006@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0010\u0012\f\u0012\n \f*\u0004\u0018\u00018\u00028\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u0003\u001a\u0004\u0018\u00018\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\u000e¨\u0006\u000f" }, d2 = { "Lly/img/android/pesdk/utils/ForgettableTreeMap$TimedValue;", "ValueType", "", "value", "(Ljava/lang/Object;)V", "<set-?>", "", "lastAccessTime", "getLastAccessTime", "()J", "reference", "Ljava/lang/ref/SoftReference;", "kotlin.jvm.PlatformType", "getValue", "()Ljava/lang/Object;", "pesdk-backend-core_release" })
    private static final class TimedValue<ValueType>
    {
        @NotNull
        private final SoftReference<ValueType> reference;
        private long lastAccessTime;
        
        public TimedValue(final ValueType value) {
            this.reference = new SoftReference<ValueType>(value);
            this.lastAccessTime = System.currentTimeMillis();
        }
        
        @Nullable
        public final ValueType getValue() {
            final Object result = this.reference.get();
            this.lastAccessTime = ((result != null) ? System.currentTimeMillis() : -1L);
            return (ValueType)result;
        }
        
        public final long getLastAccessTime() {
            return this.lastAccessTime;
        }
    }
}
