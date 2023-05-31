// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.WorkerThread;
import ly.img.android.pesdk.backend.model.state.ProgressState;
import ly.img.android.pesdk.backend.decoder.ImageSource;
import kotlin.jvm.JvmStatic;
import kotlin.NoWhenBranchMatchedException;
import java.util.Map;
import android.net.Uri;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.pesdk.backend.decoder.VideoSource;
import ly.img.android.pesdk.backend.model.state.manager.StateHandler;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0007J\u0018\u0010\u0003\u001a\u00020\b2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bH\u0007J\u0018\u0010\u0003\u001a\u00020\n2\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\nH\u0007¨\u0006\f" }, d2 = { "Lly/img/android/pesdk/utils/DownloadUtils;", "", "()V", "downloadIfNeeded", "Landroid/net/Uri;", "stateHandler", "Lly/img/android/pesdk/backend/model/state/manager/StateHandler;", "uri", "Lly/img/android/pesdk/backend/decoder/ImageSource;", "imageSource", "Lly/img/android/pesdk/backend/decoder/VideoSource;", "videoSource", "pesdk-backend-core_release" })
public final class DownloadUtils
{
    @NotNull
    public static final DownloadUtils INSTANCE;
    
    private DownloadUtils() {
    }
    
    @JvmStatic
    @NotNull
    public static final VideoSource downloadIfNeeded(@NotNull final StateHandler stateHandler, @NotNull final VideoSource videoSource) {
        Intrinsics.checkNotNullParameter((Object)stateHandler, "stateHandler");
        Intrinsics.checkNotNullParameter((Object)videoSource, "videoSource");
        VideoSource videoSource2 = null;
        switch (WhenMappings.$EnumSwitchMapping$0[videoSource.getSourceType().ordinal()]) {
            case 1: {
                videoSource2 = videoSource;
                break;
            }
            case 2: {
                videoSource2 = videoSource;
                break;
            }
            case 3: {
                videoSource2 = videoSource;
                break;
            }
            case 4: {
                videoSource2 = videoSource;
                break;
            }
            case 5: {
                final Uri it = videoSource.getUri$pesdk_backend_core_release();
                final int n = 0;
                Uri uri2;
                Uri empty;
                if ((empty = (uri2 = it)) == null) {
                    uri2 = (empty = Uri.EMPTY);
                }
                Intrinsics.checkNotNullExpressionValue((Object)empty, "it ?: Uri.EMPTY");
                final Uri uri = downloadIfNeeded(stateHandler, uri2);
                videoSource2 = (Intrinsics.areEqual((Object)uri, (Object)it) ? videoSource : VideoSource.Companion.create$default(VideoSource.Companion, uri, null, 2, null));
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return videoSource2;
    }
    
    @JvmStatic
    @NotNull
    public static final ImageSource downloadIfNeeded(@NotNull final StateHandler stateHandler, @NotNull final ImageSource imageSource) {
        Intrinsics.checkNotNullParameter((Object)stateHandler, "stateHandler");
        Intrinsics.checkNotNullParameter((Object)imageSource, "imageSource");
        ImageSource.SOURCE_TYPE source_TYPE;
        if ((source_TYPE = imageSource.sourceType) == null) {
            source_TYPE = ImageSource.SOURCE_TYPE.NONE;
        }
        ImageSource imageSource2 = null;
        switch (WhenMappings.$EnumSwitchMapping$1[source_TYPE.ordinal()]) {
            case 1: {
                imageSource2 = imageSource;
                break;
            }
            case 2: {
                imageSource2 = imageSource;
                break;
            }
            case 3: {
                imageSource2 = imageSource;
                break;
            }
            case 4: {
                imageSource2 = imageSource;
                break;
            }
            case 5: {
                imageSource2 = imageSource;
                break;
            }
            case 6: {
                imageSource2 = imageSource;
                break;
            }
            case 7: {
                final Uri it = imageSource.getUri();
                final int n = 0;
                Uri uri2;
                Uri empty;
                if ((empty = (uri2 = it)) == null) {
                    uri2 = (empty = Uri.EMPTY);
                }
                Intrinsics.checkNotNullExpressionValue((Object)empty, "it ?: Uri.EMPTY");
                final Uri uri = downloadIfNeeded(stateHandler, uri2);
                ImageSource create;
                if (!Intrinsics.areEqual((Object)uri, (Object)it)) {
                    imageSource2 = (create = ImageSource.create(uri));
                }
                else {
                    imageSource2 = imageSource;
                    create = imageSource;
                }
                Intrinsics.checkNotNullExpressionValue((Object)create, "imageSource.uri.let {\n  \u2026          }\n            }");
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        return imageSource2;
    }
    
    @JvmStatic
    @WorkerThread
    @NotNull
    public static final Uri downloadIfNeeded(@NotNull final StateHandler stateHandler, @NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)stateHandler, "stateHandler");
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        final ProgressState value = stateHandler.get(ProgressState.class);
        Intrinsics.checkNotNullExpressionValue((Object)value, "stateHandler[ProgressState::class.java]");
        final ProgressState progressState = value;
        if (!UriHelperKt.isLocalResource(uri)) {
            progressState.notifyLoadingStart();
            try {
                return UriHelper.INSTANCE.convertToLocalUri(uri);
            }
            finally {
                progressState.notifyLoadingFinish();
            }
        }
        return uri;
    }
    
    static {
        INSTANCE = new DownloadUtils();
    }
}
