// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import ly.img.android.pesdk.utils.LazyInit;
import kotlin.Lazy;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import java.util.Iterator;
import android.os.Parcelable;
import java.io.Serializable;
import java.util.Map;
import java.util.Collection;
import kotlin.jvm.internal.TypeIntrinsics;
import java.util.HashMap;
import org.jetbrains.annotations.Nullable;
import java.util.ArrayList;
import org.jetbrains.annotations.NotNull;
import kotlin.jvm.internal.Intrinsics;
import android.os.Parcelable$Creator;
import android.os.Parcel;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000P\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0004\u001a0\u0010\r\u001a\b\u0012\u0004\u0012\u0002H\b0\u000e\"\u0006\b\u0000\u0010\b\u0018\u00012\u0014\b\u0004\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u0002H\b0\u0010H\u0086\b\u00f8\u0001\u0000\u001a\u0016\u0010\u0012\u001a\n\u0012\u0006\b\u0001\u0012\u00020\t0\u0013*\u0006\u0012\u0002\b\u00030\u0013\u001a3\u0010\u0014\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\u0015*\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u00172\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u0019\u001a3\u0010\u0014\u001a\u0004\u0018\u0001H\b\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\u0015*\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u001a2\u0006\u0010\u0018\u001a\u00020\u0007¢\u0006\u0002\u0010\u001b\u001a\u001a\u0010\u001c\u001a\u0004\u0018\u00010\t*\u00020\u00112\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013\u001a,\u0010\u001e\u001a\u00020\u001f\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\u0015*\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u00172\u0006\u0010 \u001a\u00020\u0001\u001a,\u0010\u001e\u001a\u00020\u001f\"\n\b\u0000\u0010\b*\u0004\u0018\u00010\u0015*\u00020\u00112\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u0002H\b0\u001a2\u0006\u0010 \u001a\u00020\u0001\u001a\"\u0010!\u001a\u00020\u001f*\u00020\u00112\b\u0010\"\u001a\u0004\u0018\u00010\t2\f\u0010\u001d\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0013\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0002\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0003\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0004\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010\u0005\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000\"&\u0010\u0006\u001a\u00020\u0007\"\b\b\u0000\u0010\b*\u00020\t*\b\u0012\u0004\u0012\u0002H\b0\n8\u00c6\u0002¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006#" }, d2 = { "TYPE_ARRAY_LIST", "", "TYPE_HASH_MAP", "TYPE_NULL", "TYPE_OTHER_VALUE", "TYPE_SERIALIZABLE", "classLoader", "Ljava/lang/ClassLoader;", "T", "", "Lkotlin/reflect/KClass;", "getClassLoader", "(Lkotlin/reflect/KClass;)Ljava/lang/ClassLoader;", "parcelableCreator", "Landroid/os/Parcelable$Creator;", "create", "Lkotlin/Function1;", "Landroid/os/Parcel;", "getInstantiableClass", "Ljava/lang/Class;", "readLazy", "Landroid/os/Parcelable;", "lazy", "Lkotlin/Lazy;", "loader", "(Landroid/os/Parcel;Lkotlin/Lazy;Ljava/lang/ClassLoader;)Landroid/os/Parcelable;", "Lly/img/android/pesdk/utils/LazyInit;", "(Landroid/os/Parcel;Lly/img/android/pesdk/utils/LazyInit;Ljava/lang/ClassLoader;)Landroid/os/Parcelable;", "readSomething", "persistentClass", "writeLazy", "", "flags", "writeSomething", "value", "pesdk-backend-core_release" })
public final class ParcalExtentionKt
{
    private static final int TYPE_NULL = 0;
    private static final int TYPE_HASH_MAP = 1;
    private static final int TYPE_ARRAY_LIST = 2;
    private static final int TYPE_OTHER_VALUE = 3;
    private static final int TYPE_SERIALIZABLE = 4;
    
    @NotNull
    public static final Class<?> getInstantiableClass(@NotNull final Class<?> $this$getInstantiableClass) {
        Intrinsics.checkNotNullParameter((Object)$this$getInstantiableClass, "<this>");
        return Intrinsics.areEqual((Object)$this$getInstantiableClass.getName(), (Object)"java.util.List") ? ArrayList.class : $this$getInstantiableClass;
    }
    
    @Nullable
    public static final Object readSomething(@NotNull final Parcel $this$readSomething, @Nullable final Class<?> persistentClass) {
        Intrinsics.checkNotNullParameter((Object)$this$readSomething, "<this>");
        Object o = null;
        switch ($this$readSomething.readInt()) {
            case 0: {
                o = null;
                break;
            }
            case 1: {
                final int size = $this$readSomething.readInt();
                final Class creationClass = (persistentClass != null && !persistentClass.isInterface()) ? persistentClass : HashMap.class;
                final Object instance = creationClass.newInstance();
                if (instance == null) {
                    throw new NullPointerException("null cannot be cast to non-null type kotlin.collections.MutableMap<kotlin.Any?, kotlin.Any?>");
                }
                final Map map = TypeIntrinsics.asMutableMap(instance);
                final int n = 0;
                for (int i = 0; i < size; ++i) {
                    final Class keyClass = (Class)$this$readSomething.readSerializable();
                    final Class valueClass = (Class)$this$readSomething.readSerializable();
                    final Object key = readSomething($this$readSomething, keyClass);
                    final Object value = readSomething($this$readSomething, valueClass);
                    map.put(key, value);
                }
                o = map;
                break;
            }
            case 2: {
                final int size = $this$readSomething.readInt();
                final Class<?> clazz;
                final Class creatorClass = clazz = ((persistentClass != null) ? getInstantiableClass(persistentClass) : null);
                final Object o2 = (clazz != null) ? clazz.newInstance() : null;
                if (o2 == null) {
                    throw new NullPointerException("null cannot be cast to non-null type java.util.Collection<kotlin.Any?>");
                }
                final Collection map2 = (Collection)o2;
                final int n2 = 0;
                for (int i = 0; i < size; ++i) {
                    final Class valueClass2 = (Class)$this$readSomething.readSerializable();
                    final Object value2 = readSomething($this$readSomething, valueClass2);
                    map2.add(value2);
                }
                o = map2;
                break;
            }
            case 4: {
                o = $this$readSomething.readSerializable();
                break;
            }
            case 3: {
                o = $this$readSomething.readValue((persistentClass != null) ? persistentClass.getClassLoader() : null);
                break;
            }
            default: {
                throw new IllegalArgumentException("Unknown type in readSomething()");
            }
        }
        return o;
    }
    
    public static final void writeSomething(@NotNull final Parcel $this$writeSomething, @Nullable final Object value, @Nullable final Class<?> persistentClass) {
        Intrinsics.checkNotNullParameter((Object)$this$writeSomething, "<this>");
        if (persistentClass == null) {
            $this$writeSomething.writeInt(0);
        }
        else if (value instanceof HashMap) {
            $this$writeSomething.writeInt(1);
            $this$writeSomething.writeInt(((HashMap)value).size());
            final Map $this$forEach$iv = (Map)value;
            final int $i$f$forEach = 0;
            for (final Map.Entry it : $this$forEach$iv.entrySet()) {
                final Map.Entry element$iv = it;
                final int n = 0;
                final Object key;
                final Object o = key = it.getKey();
                Class<?> class1;
                if (key != null) {
                    Intrinsics.checkNotNullExpressionValue(key, "key");
                    class1 = o.getClass();
                }
                else {
                    class1 = null;
                }
                final Class keyClass = class1;
                final Object value2;
                final Object o2 = value2 = it.getValue();
                Class<?> class2;
                if (value2 != null) {
                    Intrinsics.checkNotNullExpressionValue(value2, "value");
                    class2 = o2.getClass();
                }
                else {
                    class2 = null;
                }
                final Class valueClass = class2;
                final Object key2;
                final Object o3 = key2 = it.getKey();
                Class<?> class3;
                if (key2 != null) {
                    Intrinsics.checkNotNullExpressionValue(key2, "key");
                    class3 = o3.getClass();
                }
                else {
                    class3 = null;
                }
                $this$writeSomething.writeSerializable((Serializable)class3);
                final Object value3;
                final Object o4 = value3 = it.getValue();
                Class<?> class4;
                if (value3 != null) {
                    Intrinsics.checkNotNullExpressionValue(value3, "value");
                    class4 = o4.getClass();
                }
                else {
                    class4 = null;
                }
                $this$writeSomething.writeSerializable((Serializable)class4);
                writeSomething($this$writeSomething, it.getKey(), keyClass);
                writeSomething($this$writeSomething, it.getValue(), valueClass);
            }
        }
        else if (!(value instanceof Parcelable) && value instanceof Collection) {
            $this$writeSomething.writeInt(2);
            $this$writeSomething.writeInt(((Collection)value).size());
            final Iterable $this$forEach$iv2 = (Iterable)value;
            final int $i$f$forEach = 0;
            for (final Object it2 : $this$forEach$iv2) {
                final Object element$iv2 = it2;
                final int n2 = 0;
                final Object o5 = it2;
                final Class keyClass2 = (o5 != null) ? o5.getClass() : null;
                final Object o6 = it2;
                $this$writeSomething.writeSerializable((Serializable)((o6 != null) ? o6.getClass() : null));
                writeSomething($this$writeSomething, it2, keyClass2);
            }
        }
        else if (!(value instanceof Parcelable) && value instanceof Serializable) {
            $this$writeSomething.writeInt(4);
            $this$writeSomething.writeSerializable((value instanceof Serializable) ? ((Serializable)value) : null);
        }
        else {
            $this$writeSomething.writeInt(3);
            $this$writeSomething.writeValue(value);
        }
    }
    
    @NotNull
    public static final <T> ClassLoader getClassLoader(@NotNull final KClass<T> $this$classLoader) {
        Intrinsics.checkNotNullParameter((Object)$this$classLoader, "<this>");
        final int $i$f$getClassLoader = 0;
        final ClassLoader classLoader = JvmClassMappingKt.getJavaClass((KClass)$this$classLoader).getClassLoader();
        Intrinsics.checkNotNull((Object)classLoader);
        return classLoader;
    }
    
    @Nullable
    public static final <T extends Parcelable> T readLazy(@NotNull final Parcel $this$readLazy, @NotNull final Lazy<? extends T> lazy, @NotNull final ClassLoader loader) {
        Intrinsics.checkNotNullParameter((Object)$this$readLazy, "<this>");
        Intrinsics.checkNotNullParameter((Object)lazy, "lazy");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        return (T)(($this$readLazy.readByte() == 1) ? $this$readLazy.readParcelable(loader) : null);
    }
    
    @Nullable
    public static final <T extends Parcelable> T readLazy(@NotNull final Parcel $this$readLazy, @NotNull final LazyInit<T> lazy, @NotNull final ClassLoader loader) {
        Intrinsics.checkNotNullParameter((Object)$this$readLazy, "<this>");
        Intrinsics.checkNotNullParameter((Object)lazy, "lazy");
        Intrinsics.checkNotNullParameter((Object)loader, "loader");
        return (T)(($this$readLazy.readByte() == 1) ? $this$readLazy.readParcelable(loader) : null);
    }
    
    public static final <T extends Parcelable> void writeLazy(@NotNull final Parcel $this$writeLazy, @NotNull final LazyInit<T> lazy, final int flags) {
        Intrinsics.checkNotNullParameter((Object)$this$writeLazy, "<this>");
        Intrinsics.checkNotNullParameter((Object)lazy, "lazy");
        if (lazy.isInitialized()) {
            $this$writeLazy.writeByte((byte)1);
            $this$writeLazy.writeParcelable((Parcelable)lazy.getValue(), flags);
        }
        else {
            $this$writeLazy.writeByte((byte)0);
        }
    }
    
    public static final <T extends Parcelable> void writeLazy(@NotNull final Parcel $this$writeLazy, @NotNull final Lazy<? extends T> lazy, final int flags) {
        Intrinsics.checkNotNullParameter((Object)$this$writeLazy, "<this>");
        Intrinsics.checkNotNullParameter((Object)lazy, "lazy");
        if (lazy.isInitialized()) {
            $this$writeLazy.writeByte((byte)1);
            $this$writeLazy.writeParcelable((Parcelable)lazy.getValue(), flags);
        }
        else {
            $this$writeLazy.writeByte((byte)0);
        }
    }
}
