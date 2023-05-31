// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import ly.img.android.pesdk.backend.model.state.AbsLayerSettings;
import java.util.List;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import ly.img.android.pesdk.backend.model.state.LayerListSettings;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a9\u0010\u0000\u001a\u00020\u0001*\u00020\u00022'\u0010\u0003\u001a#\u0012\u0019\u0012\u0017\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0004\u0012\u00020\u00010\u0004H\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\n" }, d2 = { "layerReadLock", "", "Lly/img/android/pesdk/backend/model/state/LayerListSettings;", "block", "Lkotlin/Function1;", "", "Lly/img/android/pesdk/backend/model/state/AbsLayerSettings;", "Lkotlin/ParameterName;", "name", "it", "pesdk-backend-core_release" })
public final class JavaHelperKt
{
    public static final void layerReadLock(@NotNull final LayerListSettings $this$layerReadLock, @NotNull final Function1<? super List<? extends AbsLayerSettings>, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$layerReadLock, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$layerReadLock = 0;
        $this$layerReadLock.acquireLayerReadLock();
        try {
            final List<AbsLayerSettings> layerSettingsList = $this$layerReadLock.getLayerSettingsList();
            Intrinsics.checkNotNullExpressionValue((Object)layerSettingsList, "this.layerSettingsList");
            block.invoke((Object)layerSettingsList);
        }
        finally {
            InlineMarker.finallyStart(1);
            $this$layerReadLock.releaseLayerReadLock();
            InlineMarker.finallyEnd(1);
        }
    }
}
