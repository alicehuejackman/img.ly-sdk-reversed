// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Collection;
import ly.img.android.PESDK;
import kotlin.text.StringsKt;
import java.util.List;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import java.io.File;
import android.graphics.Typeface;
import android.util.LruCache;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\b\u001a\u00020\tH\u0007J\u0012\u0010\u0007\u001a\u0004\u0018\u00010\u00062\u0006\u0010\n\u001a\u00020\u0005H\u0007R\u001c\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lly/img/android/pesdk/utils/TypefaceLoader;", "", "()V", "sTypefaceCache", "Landroid/util/LruCache;", "", "Landroid/graphics/Typeface;", "getTypeface", "typefaceFile", "Ljava/io/File;", "typefaceAssetsPath", "pesdk-backend-core_release" })
public final class TypefaceLoader
{
    @NotNull
    public static final TypefaceLoader INSTANCE;
    @NotNull
    private static final LruCache<String, Typeface> sTypefaceCache;
    
    private TypefaceLoader() {
    }
    
    @JvmStatic
    @Nullable
    public static final Typeface getTypeface(@NotNull final File typefaceFile) {
        Intrinsics.checkNotNullParameter((Object)typefaceFile, "typefaceFile");
        final String typefaceName = typefaceFile.getName();
        Typeface typeface2;
        try {
            Typeface typeface = (Typeface)TypefaceLoader.sTypefaceCache.get((Object)typefaceName);
            if (typeface == null) {
                typeface = Typeface.createFromFile(typefaceFile);
                TypefaceLoader.sTypefaceCache.put((Object)typefaceName, (Object)typeface);
            }
            typeface2 = typeface;
        }
        catch (Exception e) {
            typeface2 = null;
        }
        return typeface2;
    }
    
    @JvmStatic
    @Nullable
    public static final Typeface getTypeface(@NotNull final String typefaceAssetsPath) {
        Intrinsics.checkNotNullParameter((Object)typefaceAssetsPath, "typefaceAssetsPath");
        final Collection $this$toTypedArray$iv = StringsKt.split$default((CharSequence)typefaceAssetsPath, new String[] { "/" }, false, 0, 6, (Object)null);
        final int $i$f$toTypedArray = 0;
        final Collection thisCollection$iv = $this$toTypedArray$iv;
        final String[] array = thisCollection$iv.toArray(new String[0]);
        if (array == null) {
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>");
        }
        final String[] split = array;
        final String typefaceName = split[split.length - 1];
        Typeface typeface = (Typeface)TypefaceLoader.sTypefaceCache.get((Object)typefaceName);
        if (typeface == null) {
            typeface = Typeface.createFromAsset(PESDK.getAppContext().getAssets(), typefaceAssetsPath);
            TypefaceLoader.sTypefaceCache.put((Object)typefaceName, (Object)typeface);
        }
        return typeface;
    }
    
    static {
        INSTANCE = new TypefaceLoader();
        sTypefaceCache = new LruCache(12);
    }
}
