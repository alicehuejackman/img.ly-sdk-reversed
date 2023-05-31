// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.pesdk.backend.model.config.AbstractAsset;
import kotlin.reflect.KClass;
import org.jetbrains.annotations.NotNull;
import ly.img.android.pesdk.backend.model.state.AssetConfig;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u001c\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u0002H\u0001\"\b\b\u0000\u0010\u0001*\u00020\u0002*\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u0002H\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\b¨\u0006\t" }, d2 = { "requireAssetById", "T", "Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "Lly/img/android/pesdk/backend/model/state/AssetConfig;", "classRef", "Lkotlin/reflect/KClass;", "id", "", "(Lly/img/android/pesdk/backend/model/state/AssetConfig;Lkotlin/reflect/KClass;Ljava/lang/String;)Lly/img/android/pesdk/backend/model/config/AbstractAsset;", "pesdk-backend-core_release" })
public final class AssetConfigKotlinExtensionKt
{
    @NotNull
    public static final <T extends AbstractAsset> T requireAssetById(@NotNull final AssetConfig $this$requireAssetById, @NotNull final KClass<T> classRef, @NotNull final String id) {
        Intrinsics.checkNotNullParameter((Object)$this$requireAssetById, "<this>");
        Intrinsics.checkNotNullParameter((Object)classRef, "classRef");
        Intrinsics.checkNotNullParameter((Object)id, "id");
        final AbstractAsset assetById = $this$requireAssetById.getAssetById((Class<T>)JvmClassMappingKt.getJavaClass((KClass)classRef), id);
        if (assetById == null) {
            throw new RuntimeException("Does not found required Asset of type \"" + JvmClassMappingKt.getJavaClass((KClass)classRef).getSimpleName() + "\" with id \"" + id + "\" ");
        }
        return (T)assetById;
    }
}
