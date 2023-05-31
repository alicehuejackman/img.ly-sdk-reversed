// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.CheckResult;
import android.content.res.AssetFileDescriptor;
import org.jetbrains.annotations.NotNull;
import java.io.File;
import java.util.Map;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import android.os.Binder;
import ly.img.android.IMGLY;
import org.jetbrains.annotations.Nullable;
import android.net.Uri;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000>\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0006\u001a\n\u0010\u000e\u001a\u00020\u000f*\u00020\u0002\u001a\u0012\u0010\u000e\u001a\u00020\u000f*\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u000f\u001a\f\u0010\u0011\u001a\u00020\u0012*\u00020\u0002H\u0002\u001a\n\u0010\u0013\u001a\u00020\n*\u00020\u0002\u001a\n\u0010\u0014\u001a\u00020\n*\u00020\u0002\u001a\u001a\u0010\u0015\u001a\u00020\n*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u00062\u0006\u0010\u0017\u001a\u00020\n\u001a\u0019\u0010\u0018\u001a\u0004\u0018\u00010\u0019*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0002\u0010\u001a\u001a\u0019\u0010\u001b\u001a\u0004\u0018\u00010\u001c*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006¢\u0006\u0002\u0010\u001d\u001a\u0014\u0010\u001e\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0006\u001a\u000e\u0010\u001f\u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002\u001a\u000e\u0010 \u001a\u0004\u0018\u00010\u0002*\u0004\u0018\u00010\u0002\u001a\f\u0010!\u001a\u00020\u0002*\u00020\u0002H\u0007\"\u0017\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0003\u0010\u0004\"\u0017\u0010\u0005\u001a\u0004\u0018\u00010\u0006*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\u0007\u0010\b\"\u0017\u0010\t\u001a\u00020\n*\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\f\"\u0015\u0010\r\u001a\u00020\n*\u00020\u00028F¢\u0006\u0006\u001a\u0004\b\r\u0010\f¨\u0006\"" }, d2 = { "assetResourceFileDescriptor", "Landroid/content/res/AssetFileDescriptor;", "Landroid/net/Uri;", "getAssetResourceFileDescriptor", "(Landroid/net/Uri;)Landroid/content/res/AssetFileDescriptor;", "assetResourcePath", "", "getAssetResourcePath", "(Landroid/net/Uri;)Ljava/lang/String;", "hasReadPermission", "", "getHasReadPermission", "(Landroid/net/Uri;)Z", "isAssetResource", "copyAsFile", "Ljava/io/File;", "destination", "deleteFileUri", "", "hasExternalSchema", "isLocalResource", "paramBoolean", "name", "default", "paramFloat", "", "(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/Float;", "paramInt", "", "(Landroid/net/Uri;Ljava/lang/String;)Ljava/lang/Integer;", "paramString", "restoreWithReadPermission", "saveReadPermission", "waitForAccessPermission", "pesdk-backend-core_release" })
public final class UriHelperKt
{
    public static final boolean getHasReadPermission(@Nullable final Uri $this$hasReadPermission) {
        boolean b;
        try {
            b = (IMGLY.getAppContext().checkUriPermission($this$hasReadPermission, Binder.getCallingPid(), Binder.getCallingUid(), 1) == 0);
        }
        catch (Exception ex) {
            ex.printStackTrace();
            b = false;
        }
        return b;
    }
    
    @Nullable
    public static final Uri saveReadPermission(@Nullable final Uri $this$saveReadPermission) {
        if ($this$saveReadPermission != null) {
            final String path = $this$saveReadPermission.getPath();
            if (path != null) {
                final String uriId = path;
                final ReentrantReadWriteLock permissionUriLock$pesdk_backend_core_release = UriHelper.INSTANCE.getPermissionUriLock$pesdk_backend_core_release();
                final ReentrantReadWriteLock.ReadLock lock = permissionUriLock$pesdk_backend_core_release.readLock();
                final int n = (permissionUriLock$pesdk_backend_core_release.getWriteHoldCount() == 0) ? permissionUriLock$pesdk_backend_core_release.getReadHoldCount() : 0;
                for (int i = 0; i < n; ++i) {
                    lock.unlock();
                }
                final ReentrantReadWriteLock.WriteLock writeLock = permissionUriLock$pesdk_backend_core_release.writeLock();
                writeLock.lock();
                try {
                    final int n2 = 0;
                    final HashSet<String> registeredUriRecorder$pesdk_backend_core_release = UriHelper.INSTANCE.getRegisteredUriRecorder$pesdk_backend_core_release();
                    if (registeredUriRecorder$pesdk_backend_core_release == null) {
                        return $this$saveReadPermission;
                    }
                    final HashSet registeredUriRecorder = registeredUriRecorder$pesdk_backend_core_release;
                    if (getHasReadPermission($this$saveReadPermission)) {
                        Uri keep = $this$saveReadPermission;
                        try {
                            IMGLY.getAppContext().getContentResolver().takePersistableUriPermission(keep, 1);
                        }
                        catch (Exception ignored) {
                            keep = UriHelper.INSTANCE.copyToLocalAsync(keep, (Function1<? super Uri, Unit>)UriHelperKt$saveReadPermission$1.UriHelperKt$saveReadPermission$1$1.INSTANCE);
                            final Map<String, String> tempToOriginalMapping$pesdk_backend_core_release = UriHelper.INSTANCE.getTempToOriginalMapping$pesdk_backend_core_release();
                            final String path2 = keep.getPath();
                            Intrinsics.checkNotNull((Object)path2);
                            tempToOriginalMapping$pesdk_backend_core_release.put(path2, uriId);
                        }
                        registeredUriRecorder.add(uriId);
                        UriHelper.INSTANCE.getKeepURIAccessPermission$pesdk_backend_core_release().put(uriId, keep);
                        final Map<String, Integer> keepURIAccessPermissionUseCount$pesdk_backend_core_release = UriHelper.INSTANCE.getKeepURIAccessPermissionUseCount$pesdk_backend_core_release();
                        final Map $this$getOrPut$iv = UriHelper.INSTANCE.getKeepURIAccessPermissionUseCount$pesdk_backend_core_release();
                        final int $i$f$getOrPut = 0;
                        final Object value$iv = $this$getOrPut$iv.get(uriId);
                        Object o;
                        if (value$iv == null) {
                            final int n3 = 0;
                            final Object answer$iv = 0;
                            $this$getOrPut$iv.put(uriId, answer$iv);
                            o = answer$iv;
                        }
                        else {
                            o = value$iv;
                        }
                        keepURIAccessPermissionUseCount$pesdk_backend_core_release.put(uriId, ((Number)o).intValue() + 1);
                    }
                    else {
                        final String originalUriId = UriHelper.INSTANCE.getTempToOriginalMapping$pesdk_backend_core_release().get(uriId);
                        if (originalUriId != null) {
                            registeredUriRecorder.add(originalUriId);
                            final Map<String, Integer> keepURIAccessPermissionUseCount$pesdk_backend_core_release2 = UriHelper.INSTANCE.getKeepURIAccessPermissionUseCount$pesdk_backend_core_release();
                            final Map $this$getOrPut$iv = UriHelper.INSTANCE.getKeepURIAccessPermissionUseCount$pesdk_backend_core_release();
                            final int $i$f$getOrPut = 0;
                            final Object value$iv = $this$getOrPut$iv.get(originalUriId);
                            Object o2;
                            if (value$iv == null) {
                                final int n4 = 0;
                                final Object answer$iv = 0;
                                $this$getOrPut$iv.put(originalUriId, answer$iv);
                                o2 = answer$iv;
                            }
                            else {
                                o2 = value$iv;
                            }
                            keepURIAccessPermissionUseCount$pesdk_backend_core_release2.put(originalUriId, ((Number)o2).intValue() + 1);
                        }
                    }
                    final Unit instance = Unit.INSTANCE;
                }
                finally {
                    for (int j = 0; j < n; ++j) {
                        lock.lock();
                    }
                    writeLock.unlock();
                }
                return $this$saveReadPermission;
            }
        }
        return $this$saveReadPermission;
    }
    
    private static final void deleteFileUri(final Uri $this$deleteFileUri) {
        if (Intrinsics.areEqual((Object)$this$deleteFileUri.getScheme(), (Object)"file")) {
            final String path = $this$deleteFileUri.getPath();
            if (path == null) {
                return;
            }
            new File(path).delete();
        }
    }
    
    @Nullable
    public static final Uri restoreWithReadPermission(@Nullable final Uri $this$restoreWithReadPermission) {
        if ($this$restoreWithReadPermission != null) {
            final String path2 = $this$restoreWithReadPermission.getPath();
            if (path2 != null) {
                final String path = path2;
                final ReentrantReadWriteLock.ReadLock lock = UriHelper.INSTANCE.getPermissionUriLock$pesdk_backend_core_release().readLock();
                lock.lock();
                try {
                    final int n = 0;
                    Uri uri;
                    if ((uri = UriHelper.INSTANCE.getKeepURIAccessPermission$pesdk_backend_core_release().get(path)) == null) {
                        uri = $this$restoreWithReadPermission;
                    }
                    return uri;
                }
                finally {
                    lock.unlock();
                }
            }
        }
        return $this$restoreWithReadPermission;
    }
    
    @Nullable
    public static final String paramString(@NotNull final Uri $this$paramString, @NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)$this$paramString, "<this>");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        return $this$paramString.getQueryParameter(name);
    }
    
    @Nullable
    public static final Integer paramInt(@NotNull final Uri $this$paramInt, @NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)$this$paramInt, "<this>");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final String queryParameter = $this$paramInt.getQueryParameter(name);
        return (queryParameter != null) ? Integer.valueOf(Integer.parseInt(queryParameter)) : null;
    }
    
    @Nullable
    public static final Float paramFloat(@NotNull final Uri $this$paramFloat, @NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)$this$paramFloat, "<this>");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final String queryParameter = $this$paramFloat.getQueryParameter(name);
        return (queryParameter != null) ? Float.valueOf(Float.parseFloat(queryParameter)) : null;
    }
    
    public static final boolean paramBoolean(@NotNull final Uri $this$paramBoolean, @NotNull final String name, final boolean default) {
        Intrinsics.checkNotNullParameter((Object)$this$paramBoolean, "<this>");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        return $this$paramBoolean.getBooleanQueryParameter(name, default);
    }
    
    @NotNull
    public static final File copyAsFile(@NotNull final Uri $this$copyAsFile) {
        Intrinsics.checkNotNullParameter((Object)$this$copyAsFile, "<this>");
        return UriHelper.copyAsFile$default($this$copyAsFile, null, 2, null);
    }
    
    @NotNull
    public static final File copyAsFile(@NotNull final Uri $this$copyAsFile, @NotNull final File destination) {
        Intrinsics.checkNotNullParameter((Object)$this$copyAsFile, "<this>");
        Intrinsics.checkNotNullParameter((Object)destination, "destination");
        return UriHelper.copyAsFile($this$copyAsFile, destination);
    }
    
    public static final boolean isLocalResource(@NotNull final Uri $this$isLocalResource) {
        Intrinsics.checkNotNullParameter((Object)$this$isLocalResource, "<this>");
        return UriHelper.isLocalResource($this$isLocalResource);
    }
    
    public static final boolean hasExternalSchema(@NotNull final Uri $this$hasExternalSchema) {
        Intrinsics.checkNotNullParameter((Object)$this$hasExternalSchema, "<this>");
        return UriHelper.isExternalResource($this$hasExternalSchema);
    }
    
    public static final boolean isAssetResource(@NotNull final Uri $this$isAssetResource) {
        Intrinsics.checkNotNullParameter((Object)$this$isAssetResource, "<this>");
        return UriHelper.isAssetResource($this$isAssetResource);
    }
    
    @Nullable
    public static final String getAssetResourcePath(@NotNull final Uri $this$assetResourcePath) {
        Intrinsics.checkNotNullParameter((Object)$this$assetResourcePath, "<this>");
        return UriHelper.getAssetResourcePath($this$assetResourcePath);
    }
    
    @Nullable
    public static final AssetFileDescriptor getAssetResourceFileDescriptor(@NotNull final Uri $this$assetResourceFileDescriptor) {
        Intrinsics.checkNotNullParameter((Object)$this$assetResourceFileDescriptor, "<this>");
        return UriHelper.getAssetResourceFileDescriptor($this$assetResourceFileDescriptor);
    }
    
    @CheckResult
    @NotNull
    public static final Uri waitForAccessPermission(@NotNull final Uri $this$waitForAccessPermission) {
        Intrinsics.checkNotNullParameter((Object)$this$waitForAccessPermission, "<this>");
        return UriHelper.waitForAccessPermission($this$waitForAccessPermission);
    }
}
