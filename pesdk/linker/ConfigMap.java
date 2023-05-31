// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.linker;

import kotlin.jvm.internal.DefaultConstructorMarker;
import java.util.Map;
import java.io.Serializable;
import android.os.Parcel;
import java.util.Iterator;
import org.jetbrains.annotations.Nullable;
import kotlin.Deprecated;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmField;
import android.os.Parcelable$Creator;
import ly.img.android.pesdk.backend.model.config.SemVersion;
import java.util.TreeMap;
import java.util.HashMap;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import kotlin.jvm.internal.markers.KMappedMarker;
import android.os.Parcelable;
import ly.img.android.pesdk.backend.model.config.AbstractAsset;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u001c\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010(\n\u0002\b\u0005\u0018\u0000 -*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u00032\b\u0012\u0004\u0012\u0002H\u00010\u0004:\u0001-B\u0015\b\u0016\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0014\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0019\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J%\u0010\u0016\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001a\"\u00028\u0000¢\u0006\u0002\u0010\u001bJ\u0019\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0006\u0010\u0017\u001a\u00028\u0000¢\u0006\u0002\u0010\u0018J'\u0010\u001c\u001a\b\u0012\u0004\u0012\u00028\u00000\u00002\u0012\u0010\u0019\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u001a\"\u00028\u0000H\u0007¢\u0006\u0002\u0010\u001bJ\u0015\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u0017\u001a\u00028\u0000H\u0004¢\u0006\u0002\u0010\u001fJ\f\u0010 \u001a\b\u0012\u0004\u0012\u00028\u00000\u0000J\b\u0010!\u001a\u00020\"H\u0016J\u001a\u0010#\u001a\u0004\u0018\u00018\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0012H\u0086\u0002¢\u0006\u0002\u0010%J$\u0010#\u001a\u0004\u0018\u00018\u00002\b\u0010$\u001a\u0004\u0018\u00010\u00122\b\u0010&\u001a\u0004\u0018\u00010\u0010H\u0086\u0002¢\u0006\u0002\u0010'J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00028\u00000)H\u0096\u0002J\u000e\u0010*\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u0012J\u0018\u0010+\u001a\u00020\u001e2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010,\u001a\u00020\"H\u0016R\u0015\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00068F¢\u0006\u0006\u001a\u0004\b\f\u0010\rR&\u0010\u000e\u001a\u001a\u0012\u0004\u0012\u00020\u0010\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00120\u00110\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0015\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00028\u00000\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00028\u00000\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006." }, d2 = { "Lly/img/android/pesdk/linker/ConfigMap;", "Data", "Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "Landroid/os/Parcelable;", "", "typeClass", "Ljava/lang/Class;", "(Ljava/lang/Class;)V", "parcel", "Landroid/os/Parcel;", "(Landroid/os/Parcel;)V", "configType", "getConfigType", "()Ljava/lang/Class;", "legacyAssetsMap", "Ljava/util/TreeMap;", "Lly/img/android/pesdk/backend/model/config/SemVersion;", "Ljava/util/HashMap;", "", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "map", "add", "data", "(Lly/img/android/pesdk/backend/model/config/AbstractAsset;)Lly/img/android/pesdk/linker/ConfigMap;", "dataList", "", "([Lly/img/android/pesdk/backend/model/config/AbstractAsset;)Lly/img/android/pesdk/linker/ConfigMap;", "addOrReplace", "addToVersioning", "", "(Lly/img/android/pesdk/backend/model/config/AbstractAsset;)V", "clear", "describeContents", "", "get", "id", "(Ljava/lang/String;)Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "version", "(Ljava/lang/String;Lly/img/android/pesdk/backend/model/config/SemVersion;)Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "iterator", "", "remove", "writeToParcel", "flags", "Companion", "pesdk-backend-core_release" })
public final class ConfigMap<Data extends AbstractAsset> implements Parcelable, Iterable<Data>, KMappedMarker
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final ReentrantLock lock;
    @NotNull
    private final HashMap<String, Data> map;
    @NotNull
    private final TreeMap<SemVersion, HashMap<String, String>> legacyAssetsMap;
    @NotNull
    private final Class<Data> typeClass;
    @JvmField
    @NotNull
    public static final Parcelable$Creator<ConfigMap<AbstractAsset>> CREATOR;
    
    @NotNull
    public final Class<?> getConfigType() {
        return this.typeClass;
    }
    
    public ConfigMap(@NotNull final Class<Data> typeClass) {
        Intrinsics.checkNotNullParameter((Object)typeClass, "typeClass");
        this.lock = new ReentrantLock(true);
        this.legacyAssetsMap = new TreeMap<SemVersion, HashMap<String, String>>();
        this.typeClass = typeClass;
        this.map = new HashMap<String, Data>();
    }
    
    @NotNull
    public final ConfigMap<Data> add(@NotNull final Data data) {
        Intrinsics.checkNotNullParameter((Object)data, "data");
        try {
            this.lock.lock();
            if (this.map.put(data.getId(), data) != null) {
                throw new RuntimeException("Identifier collision, every configuration must have an unique identifier.You have tried to add \"" + data.getId() + "\" multiple times. If you really need to replace this configuration use `addOrReplace(...)` but it will be eval!");
            }
            this.addToVersioning(data);
        }
        finally {
            this.lock.unlock();
        }
        return this;
    }
    
    public final void remove(@NotNull final String id) {
        Intrinsics.checkNotNullParameter((Object)id, "id");
        this.map.remove(id);
    }
    
    @NotNull
    public final ConfigMap<Data> add(@NotNull final Data... dataList) {
        Intrinsics.checkNotNullParameter((Object)dataList, "dataList");
        for (int i = 0; i < dataList.length; ++i) {
            final AbstractAsset data = dataList[i];
            this.add(data);
        }
        return this;
    }
    
    @Deprecated(message = "")
    @NotNull
    @java.lang.Deprecated
    public final ConfigMap<Data> addOrReplace(@NotNull final Data... dataList) {
        Intrinsics.checkNotNullParameter((Object)dataList, "dataList");
        for (int i = 0; i < dataList.length; ++i) {
            final AbstractAsset data = dataList[i];
            this.addOrReplace(data);
        }
        return this;
    }
    
    @NotNull
    public final ConfigMap<Data> clear() {
        this.lock.lock();
        this.map.clear();
        this.lock.unlock();
        return this;
    }
    
    @NotNull
    public final ConfigMap<Data> addOrReplace(@NotNull final Data data) {
        Intrinsics.checkNotNullParameter((Object)data, "data");
        this.lock.lock();
        this.map.put(data.getId(), data);
        this.addToVersioning(data);
        this.lock.unlock();
        return this;
    }
    
    @Nullable
    public final Data get(@Nullable final String id) {
        if (id != null) {
            this.lock.lock();
            final AbstractAsset data = this.map.get(id);
            this.lock.unlock();
            return (Data)data;
        }
        return null;
    }
    
    @Nullable
    public final Data get(@Nullable final String id, @Nullable final SemVersion version) {
        String realId = id;
        this.lock.lock();
        if (version != null) {
            for (final HashMap versionMap : this.legacyAssetsMap.tailMap(version, true).values()) {
                Intrinsics.checkNotNullExpressionValue((Object)versionMap, "versionMap");
                final String legacyId = (String)versionMap.get(id);
                if (legacyId != null) {
                    realId = legacyId;
                    break;
                }
            }
        }
        final AbstractAsset data = this.map.get(realId);
        this.lock.unlock();
        return (Data)data;
    }
    
    protected final void addToVersioning(@NotNull final Data data) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "data"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* data */
        //     7: instanceof      Lly/img/android/pesdk/backend/model/config/AbstractAsset$MultiAsset;
        //    10: ifeq            98
        //    13: iconst_0       
        //    14: istore_2        /* i */
        //    15: aload_1         /* data */
        //    16: checkcast       Lly/img/android/pesdk/backend/model/config/AbstractAsset$MultiAsset;
        //    19: invokeinterface ly/img/android/pesdk/backend/model/config/AbstractAsset$MultiAsset.getVariantCount:()I
        //    24: istore_3       
        //    25: iload_2         /* i */
        //    26: iload_3        
        //    27: if_icmpge       98
        //    30: aload_0         /* this */
        //    31: aload_1         /* data */
        //    32: checkcast       Lly/img/android/pesdk/backend/model/config/AbstractAsset$MultiAsset;
        //    35: iload_2         /* i */
        //    36: invokeinterface ly/img/android/pesdk/backend/model/config/AbstractAsset$MultiAsset.getVariantAsset:(I)Lly/img/android/pesdk/backend/model/config/AbstractAsset;
        //    41: astore          4
        //    43: aload           4
        //    45: astore          5
        //    47: astore          7
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ConfigMap$addToVersioning$1
        //    52: aload           it
        //    54: dup            
        //    55: ifnonnull       62
        //    58: pop            
        //    59: goto            69
        //    62: aload_1         /* data */
        //    63: invokevirtual   ly/img/android/pesdk/backend/model/config/AbstractAsset.getId:()Ljava/lang/String;
        //    66: invokevirtual   ly/img/android/pesdk/backend/model/config/AbstractAsset.setParentId:(Ljava/lang/String;)V
        //    69: aload           7
        //    71: aload           4
        //    73: dup            
        //    74: ifnonnull       88
        //    77: pop            
        //    78: new             Ljava/lang/NullPointerException;
        //    81: dup            
        //    82: ldc             "null cannot be cast to non-null type Data of ly.img.android.pesdk.linker.ConfigMap"
        //    84: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //    87: athrow         
        //    88: invokevirtual   ly/img/android/pesdk/linker/ConfigMap.add:(Lly/img/android/pesdk/backend/model/config/AbstractAsset;)Lly/img/android/pesdk/linker/ConfigMap;
        //    91: pop            
        //    92: iinc            i, 1
        //    95: goto            25
        //    98: aload_1         /* data */
        //    99: invokevirtual   ly/img/android/pesdk/backend/model/config/AbstractAsset.getLegacyVersion:()Lly/img/android/pesdk/backend/model/config/SemVersion;
        //   102: astore_2        /* semVersion */
        //   103: aload_2         /* semVersion */
        //   104: ifnull          164
        //   107: aload_0         /* this */
        //   108: getfield        ly/img/android/pesdk/linker/ConfigMap.legacyAssetsMap:Ljava/util/TreeMap;
        //   111: aload_2         /* semVersion */
        //   112: invokevirtual   java/util/TreeMap.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //   115: checkcast       Ljava/util/HashMap;
        //   118: astore_3        /* map */
        //   119: aload_3         /* map */
        //   120: ifnonnull       146
        //   123: new             Ljava/util/HashMap;
        //   126: dup            
        //   127: invokespecial   java/util/HashMap.<init>:()V
        //   130: astore_3        /* map */
        //   131: aload_0         /* this */
        //   132: getfield        ly/img/android/pesdk/linker/ConfigMap.legacyAssetsMap:Ljava/util/TreeMap;
        //   135: checkcast       Ljava/util/Map;
        //   138: aload_2         /* semVersion */
        //   139: aload_3         /* map */
        //   140: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   145: pop            
        //   146: aload_3         /* map */
        //   147: checkcast       Ljava/util/Map;
        //   150: aload_1         /* data */
        //   151: invokevirtual   ly/img/android/pesdk/backend/model/config/AbstractAsset.getIdWithoutVersion:()Ljava/lang/String;
        //   154: aload_1         /* data */
        //   155: invokevirtual   ly/img/android/pesdk/backend/model/config/AbstractAsset.getId:()Ljava/lang/String;
        //   158: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   163: pop            
        //   164: return         
        //    Signature:
        //  (TData;)V
        //    StackMapTable: 00 07 FD 00 19 01 01 FF 00 24 00 08 07 00 02 07 00 42 01 01 07 00 42 07 00 42 01 07 00 02 00 01 07 00 42 06 FF 00 12 00 08 07 00 02 07 00 42 01 01 07 00 42 07 00 42 01 07 00 02 00 02 07 00 02 07 00 42 FF 00 09 00 02 07 00 02 07 00 42 00 00 FD 00 2F 07 00 D3 07 00 34 FA 00 11
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
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(@NotNull final Parcel parcel, final int flags) {
        Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
        parcel.writeSerializable((Serializable)this.typeClass);
        parcel.writeInt(this.map.size());
        for (final Map.Entry<Object, Object> entry : this.map.entrySet()) {
            final String key = entry.getKey();
            final AbstractAsset value = entry.getValue();
            parcel.writeString(key);
            parcel.writeParcelable((Parcelable)value, flags);
        }
    }
    
    protected ConfigMap(@NotNull final Parcel parcel) {
        Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
        this.lock = new ReentrantLock(true);
        this.legacyAssetsMap = new TreeMap<SemVersion, HashMap<String, String>>();
        final Serializable serializable = parcel.readSerializable();
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<Data of ly.img.android.pesdk.linker.ConfigMap>");
        }
        this.typeClass = (Class<Data>)serializable;
        final int size = parcel.readInt();
        final ClassLoader classLoader = this.typeClass.getClassLoader();
        this.map = new HashMap<String, Data>(size);
        for (int i = 0; i < size; ++i) {
            final String string = parcel.readString();
            Intrinsics.checkNotNull((Object)string);
            final String key = string;
            final Parcelable parcelable = parcel.readParcelable(classLoader);
            Intrinsics.checkNotNull((Object)parcelable);
            final AbstractAsset value = (AbstractAsset)parcelable;
            this.map.put(key, (Data)value);
        }
    }
    
    @NotNull
    public Iterator<Data> iterator() {
        return this.map.values().iterator();
    }
    
    static {
        Companion = new Companion(null);
        final int $i$f$parcelableCreator = 0;
        CREATOR = (Parcelable$Creator)new Parcelable$Creator<ConfigMap<AbstractAsset>>() {
            public ConfigMap<AbstractAsset> createFromParcel(@NotNull final Parcel source) {
                Intrinsics.checkNotNullParameter((Object)source, "source");
                final Parcel it = source;
                final int n = 0;
                return new ConfigMap<AbstractAsset>(it);
            }
            
            @NotNull
            public ConfigMap<AbstractAsset>[] newArray(final int size) {
                return (ConfigMap<AbstractAsset>[])new ConfigMap[size];
            }
        };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00060\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lly/img/android/pesdk/linker/ConfigMap$Companion;", "", "()V", "CREATOR", "Landroid/os/Parcelable$Creator;", "Lly/img/android/pesdk/linker/ConfigMap;", "Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
