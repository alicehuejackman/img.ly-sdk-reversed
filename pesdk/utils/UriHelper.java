// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.LinkedHashMap;
import kotlin.concurrent.ThreadsKt;
import kotlin.jvm.functions.Function0;
import kotlin.text.Charsets;
import android.content.Context;
import androidx.annotation.CheckResult;
import ly.img.android.IMGLY;
import android.content.res.AssetFileDescriptor;
import kotlin.jvm.functions.Function1;
import kotlin.collections.CollectionsKt;
import java.util.List;
import kotlin.collections.ArraysKt;
import java.util.Locale;
import androidx.annotation.AnyThread;
import java.io.IOException;
import java.io.Closeable;
import kotlin.io.CloseableKt;
import android.util.Base64;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.BufferedOutputStream;
import java.security.NoSuchAlgorithmException;
import kotlin.text.CharsKt;
import java.security.MessageDigest;
import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.internal.TypeIntrinsics;
import java.util.Set;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import java.io.File;
import java.net.URI;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmField;
import android.net.Uri;
import java.util.Map;
import org.jetbrains.annotations.Nullable;
import java.util.HashSet;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\"\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\b\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010 \u001a\u00020\t2\u0006\u0010!\u001a\u00020\tJ\u001a\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\t2\b\b\u0002\u0010%\u001a\u00020#H\u0007J\u0010\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020&H\u0007J\u0018\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020&2\u0006\u0010%\u001a\u00020#H\u0007J1\u0010'\u001a\u00020\t2\u0006\u0010!\u001a\u00020\t2!\u0010(\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b*\u0012\b\b+\u0012\u0004\b\b(!\u0012\u0004\u0012\u00020,0)J\u0010\u0010-\u001a\u00020\t2\u0006\u0010.\u001a\u00020\u0005H\u0007J\u0012\u0010/\u001a\u0004\u0018\u0001002\u0006\u0010!\u001a\u00020\tH\u0007J\u0012\u00101\u001a\u0004\u0018\u00010\u00052\u0006\u0010!\u001a\u00020\tH\u0007J\u0016\u00102\u001a\u00020,2\f\u00103\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0007J\u0016\u00105\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0007J$\u00107\u001a\u00020,2\u001a\u00108\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0019H\u0007J\u0016\u00109\u001a\u00020,2\f\u00106\u001a\b\u0012\u0004\u0012\u00020\u000504H\u0007J\u0010\u0010:\u001a\u00020;2\u0006\u0010!\u001a\u00020\tH\u0007J\u0010\u0010<\u001a\u00020;2\u0006\u0010!\u001a\u00020\tH\u0002J\u0010\u0010=\u001a\u00020;2\u0006\u0010!\u001a\u00020\tH\u0007J\u0010\u0010>\u001a\u00020;2\u0006\u0010!\u001a\u00020\tH\u0007J\u0010\u0010?\u001a\u00020;2\u0006\u0010!\u001a\u00020\tH\u0007J\u0014\u0010@\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0007J\u0014\u0010A\u001a\u0004\u0018\u00010\t2\b\u0010!\u001a\u0004\u0018\u00010\tH\u0007J\u0010\u0010B\u001a\u00020\t2\u0006\u0010!\u001a\u00020\tH\u0007R\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u00048\u0006X\u0087\u0004¢\u0006\u0004\n\u0002\u0010\u0006R \u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR \u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\r0\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR \u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00100\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\rX\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R.\u0010\u0017\u001a\u0016\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0018j\n\u0012\u0004\u0012\u00020\u0005\u0018\u0001`\u0019X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR \u0010\u001e\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00050\bX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u000b¨\u0006C" }, d2 = { "Lly/img/android/pesdk/utils/UriHelper;", "", "()V", "EXTERNAL_SCHEMES", "", "", "[Ljava/lang/String;", "keepURIAccessPermission", "", "Landroid/net/Uri;", "getKeepURIAccessPermission$pesdk_backend_core_release", "()Ljava/util/Map;", "keepURIAccessPermissionLocks", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "getKeepURIAccessPermissionLocks$pesdk_backend_core_release", "keepURIAccessPermissionUseCount", "", "getKeepURIAccessPermissionUseCount$pesdk_backend_core_release", "permissionUriLock", "getPermissionUriLock$pesdk_backend_core_release", "()Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "setPermissionUriLock$pesdk_backend_core_release", "(Ljava/util/concurrent/locks/ReentrantReadWriteLock;)V", "registeredUriRecorder", "Ljava/util/HashSet;", "Lkotlin/collections/HashSet;", "getRegisteredUriRecorder$pesdk_backend_core_release", "()Ljava/util/HashSet;", "setRegisteredUriRecorder$pesdk_backend_core_release", "(Ljava/util/HashSet;)V", "tempToOriginalMapping", "getTempToOriginalMapping$pesdk_backend_core_release", "convertToLocalUri", "uri", "copyAsFile", "Ljava/io/File;", "sourceUri", "destinationFile", "Ljava/net/URI;", "copyToLocalAsync", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "", "createFromBase64String", "base64", "getAssetResourceFileDescriptor", "Landroid/content/res/AssetFileDescriptor;", "getAssetResourcePath", "internal_acquirePermissionsUris", "uriIdsToAcquire", "", "internal_keepPermissionsUris", "releasedUriIds", "internal_registerUriPermissionKeepRecorder", "destination", "internal_releasePermissionsUris", "isAssetResource", "", "isContentUriLocal", "isExternalResource", "isFileResource", "isLocalResource", "restoreWithPermission", "savePermission", "waitForAccessPermission", "pesdk-backend-core_release" })
public final class UriHelper
{
    @NotNull
    public static final UriHelper INSTANCE;
    @NotNull
    private static ReentrantReadWriteLock permissionUriLock;
    @Nullable
    private static HashSet<String> registeredUriRecorder;
    @NotNull
    private static final Map<String, Uri> keepURIAccessPermission;
    @NotNull
    private static final Map<String, ReentrantReadWriteLock> keepURIAccessPermissionLocks;
    @NotNull
    private static final Map<String, Integer> keepURIAccessPermissionUseCount;
    @NotNull
    private static final Map<String, String> tempToOriginalMapping;
    @JvmField
    @NotNull
    public static final String[] EXTERNAL_SCHEMES;
    
    private UriHelper() {
    }
    
    @NotNull
    public final ReentrantReadWriteLock getPermissionUriLock$pesdk_backend_core_release() {
        return UriHelper.permissionUriLock;
    }
    
    public final void setPermissionUriLock$pesdk_backend_core_release(@NotNull final ReentrantReadWriteLock <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        UriHelper.permissionUriLock = <set-?>;
    }
    
    @Nullable
    public final HashSet<String> getRegisteredUriRecorder$pesdk_backend_core_release() {
        return UriHelper.registeredUriRecorder;
    }
    
    public final void setRegisteredUriRecorder$pesdk_backend_core_release(@Nullable final HashSet<String> <set-?>) {
        UriHelper.registeredUriRecorder = <set-?>;
    }
    
    @NotNull
    public final Map<String, Uri> getKeepURIAccessPermission$pesdk_backend_core_release() {
        return UriHelper.keepURIAccessPermission;
    }
    
    @NotNull
    public final Map<String, ReentrantReadWriteLock> getKeepURIAccessPermissionLocks$pesdk_backend_core_release() {
        return UriHelper.keepURIAccessPermissionLocks;
    }
    
    @NotNull
    public final Map<String, Integer> getKeepURIAccessPermissionUseCount$pesdk_backend_core_release() {
        return UriHelper.keepURIAccessPermissionUseCount;
    }
    
    @NotNull
    public final Map<String, String> getTempToOriginalMapping$pesdk_backend_core_release() {
        return UriHelper.tempToOriginalMapping;
    }
    
    @JvmStatic
    @NotNull
    public static final File copyAsFile(@NotNull final URI sourceUri, @NotNull final File destinationFile) {
        Intrinsics.checkNotNullParameter((Object)sourceUri, "sourceUri");
        Intrinsics.checkNotNullParameter((Object)destinationFile, "destinationFile");
        final UriHelper instance = UriHelper.INSTANCE;
        final Uri parse = Uri.parse(sourceUri.toString());
        Intrinsics.checkNotNullExpressionValue((Object)parse, "parse(sourceUri.toString())");
        return copyAsFile(parse, destinationFile);
    }
    
    @JvmStatic
    @NotNull
    public static final File copyAsFile(@NotNull final URI sourceUri) {
        Intrinsics.checkNotNullParameter((Object)sourceUri, "sourceUri");
        final UriHelper instance = UriHelper.INSTANCE;
        final Uri parse = Uri.parse(sourceUri.toString());
        Intrinsics.checkNotNullExpressionValue((Object)parse, "parse(sourceUri.toString())");
        return copyAsFile$default(parse, null, 2, null);
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final File copyAsFile(@NotNull final Uri sourceUri, @NotNull final File destinationFile) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "sourceUri"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* destinationFile */
        //     7: ldc             "destinationFile"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: new             Ljava/io/BufferedInputStream;
        //    15: dup            
        //    16: aload_0         /* sourceUri */
        //    17: invokestatic    ly/img/android/pesdk/backend/decoder/Decoder.getUncachedInputStream:(Landroid/net/Uri;)Ljava/io/InputStream;
        //    20: invokespecial   java/io/BufferedInputStream.<init>:(Ljava/io/InputStream;)V
        //    23: checkcast       Ljava/io/Closeable;
        //    26: astore_2       
        //    27: aconst_null    
        //    28: astore_3       
        //    29: nop            
        //    30: aload_2        
        //    31: checkcast       Ljava/io/BufferedInputStream;
        //    34: astore          input
        //    36: iconst_0       
        //    37: istore          $i$a$-use-UriHelper$copyAsFile$1
        //    39: new             Ljava/io/BufferedOutputStream;
        //    42: dup            
        //    43: new             Ljava/io/FileOutputStream;
        //    46: dup            
        //    47: aload_1         /* destinationFile */
        //    48: iconst_0       
        //    49: invokespecial   java/io/FileOutputStream.<init>:(Ljava/io/File;Z)V
        //    52: checkcast       Ljava/io/OutputStream;
        //    55: invokespecial   java/io/BufferedOutputStream.<init>:(Ljava/io/OutputStream;)V
        //    58: checkcast       Ljava/io/Closeable;
        //    61: astore          7
        //    63: aconst_null    
        //    64: astore          8
        //    66: nop            
        //    67: aload           7
        //    69: checkcast       Ljava/io/BufferedOutputStream;
        //    72: astore          output
        //    74: iconst_0       
        //    75: istore          $i$a$-use-UriHelper$copyAsFile$1$1
        //    77: aload           input
        //    79: checkcast       Ljava/io/InputStream;
        //    82: aload           output
        //    84: checkcast       Ljava/io/OutputStream;
        //    87: iconst_0       
        //    88: iconst_2       
        //    89: aconst_null    
        //    90: invokestatic    kotlin/io/ByteStreamsKt.copyTo$default:(Ljava/io/InputStream;Ljava/io/OutputStream;IILjava/lang/Object;)J
        //    93: lstore          null
        //    95: aload           7
        //    97: aload           8
        //    99: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   102: lload           9
        //   104: goto            128
        //   107: astore          9
        //   109: aload           9
        //   111: astore          8
        //   113: aload           9
        //   115: athrow         
        //   116: astore          9
        //   118: aload           7
        //   120: aload           8
        //   122: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   125: aload           9
        //   127: athrow         
        //   128: nop            
        //   129: lstore          null
        //   131: aload_2        
        //   132: aload_3        
        //   133: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   136: lload           4
        //   138: goto            159
        //   141: astore          4
        //   143: aload           4
        //   145: astore_3       
        //   146: aload           4
        //   148: athrow         
        //   149: astore          4
        //   151: aload_2        
        //   152: aload_3        
        //   153: invokestatic    kotlin/io/CloseableKt.closeFinally:(Ljava/io/Closeable;Ljava/lang/Throwable;)V
        //   156: aload           4
        //   158: athrow         
        //   159: pop2           
        //   160: aload_1         /* destinationFile */
        //   161: areturn        
        //    StackMapTable: 00 06 FF 00 6B 00 09 07 00 4E 07 00 95 07 00 71 05 07 00 66 00 01 07 00 71 05 00 01 07 00 64 FF 00 08 00 09 07 00 4E 07 00 95 07 00 71 05 07 00 66 00 01 07 00 71 07 00 64 00 01 07 00 64 FF 00 0B 00 0B 07 00 4E 07 00 95 07 00 71 05 07 00 66 00 01 07 00 71 05 04 01 00 01 04 FF 00 0C 00 04 07 00 4E 07 00 95 07 00 71 05 00 01 07 00 64 FF 00 07 00 04 07 00 4E 07 00 95 07 00 71 07 00 64 00 01 07 00 64 FF 00 09 00 0A 07 00 4E 07 00 95 07 00 71 05 04 01 07 00 71 05 04 01 00 01 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  66     95     107    116    Ljava/lang/Throwable;
        //  66     95     116    128    Any
        //  107    116    116    128    Any
        //  116    118    116    128    Any
        //  29     131    141    149    Ljava/lang/Throwable;
        //  29     131    149    159    Any
        //  141    149    149    159    Any
        //  149    151    149    159    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IndexOutOfBoundsException: Index -1 out of bounds for length 0
        //     at java.base/jdk.internal.util.Preconditions.outOfBounds(Preconditions.java:64)
        //     at java.base/jdk.internal.util.Preconditions.outOfBoundsCheckIndex(Preconditions.java:70)
        //     at java.base/jdk.internal.util.Preconditions.checkIndex(Preconditions.java:248)
        //     at java.base/java.util.Objects.checkIndex(Objects.java:372)
        //     at java.base/java.util.ArrayList.remove(ArrayList.java:535)
        //     at com.strobel.assembler.ir.StackMappingVisitor.pop(StackMappingVisitor.java:267)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.execute(StackMappingVisitor.java:548)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:398)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2030)
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
    
    public static /* synthetic */ File copyAsFile$default(final Uri sourceUri, File destinationFile, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            final File tempFile = File.createTempFile("uriCache", ".tmp");
            Intrinsics.checkNotNullExpressionValue((Object)tempFile, "createTempFile(\"uriCache\", \".tmp\")");
            destinationFile = tempFile;
        }
        return copyAsFile(sourceUri, destinationFile);
    }
    
    @JvmStatic
    public static final void internal_registerUriPermissionKeepRecorder(@Nullable final HashSet<String> destination) {
        final UriHelper instance = UriHelper.INSTANCE;
        UriHelper.registeredUriRecorder = destination;
    }
    
    @JvmStatic
    public static final void internal_releasePermissionsUris(@NotNull final Set<String> releasedUriIds) {
        Intrinsics.checkNotNullParameter((Object)releasedUriIds, "releasedUriIds");
        final UriHelper instance = UriHelper.INSTANCE;
        final ReentrantReadWriteLock permissionUriLock = UriHelper.permissionUriLock;
        final ReentrantReadWriteLock.ReadLock lock = permissionUriLock.readLock();
        final int n = (permissionUriLock.getWriteHoldCount() == 0) ? permissionUriLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = permissionUriLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            final Iterable $this$forEach$iv = releasedUriIds;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final String uriId = (String)element$iv;
                final int n3 = 0;
                final UriHelper instance2 = UriHelper.INSTANCE;
                final Map $this$getOrPut$iv = UriHelper.keepURIAccessPermissionUseCount;
                final int $i$f$getOrPut = 0;
                final Object value$iv = $this$getOrPut$iv.get(uriId);
                Object o;
                if (value$iv == null) {
                    final int n4 = 0;
                    final Object answer$iv = 1;
                    $this$getOrPut$iv.put(uriId, answer$iv);
                    o = answer$iv;
                }
                else {
                    o = value$iv;
                }
                final int releaseCount = ((Number)o).intValue() - 1;
                if (releaseCount == 0) {
                    final UriHelper instance3 = UriHelper.INSTANCE;
                    UriHelper.keepURIAccessPermissionUseCount.remove(uriId);
                    final UriHelper instance4 = UriHelper.INSTANCE;
                    UriHelper.keepURIAccessPermissionLocks.remove(uriId);
                    final UriHelper instance5 = UriHelper.INSTANCE;
                    final Uri uri = UriHelper.keepURIAccessPermission.remove(uriId);
                    if (uri == null) {
                        continue;
                    }
                    final Uri it = uri;
                    final int n5 = 0;
                    final UriHelper instance6 = UriHelper.INSTANCE;
                    TypeIntrinsics.asMutableMap((Object)UriHelper.tempToOriginalMapping).remove(it.getPath());
                    UriHelperKt.access$deleteFileUri(it);
                }
                else {
                    final Integer value = releaseCount;
                    final UriHelper instance7 = UriHelper.INSTANCE;
                    UriHelper.keepURIAccessPermissionUseCount.put(uriId, value);
                }
            }
            final Unit instance8 = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    @JvmStatic
    public static final void internal_acquirePermissionsUris(@NotNull final Set<String> uriIdsToAcquire) {
        Intrinsics.checkNotNullParameter((Object)uriIdsToAcquire, "uriIdsToAcquire");
        final UriHelper instance = UriHelper.INSTANCE;
        final ReentrantReadWriteLock permissionUriLock = UriHelper.permissionUriLock;
        final ReentrantReadWriteLock.ReadLock lock = permissionUriLock.readLock();
        final int n = (permissionUriLock.getWriteHoldCount() == 0) ? permissionUriLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = permissionUriLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            final Iterable $this$forEach$iv = uriIdsToAcquire;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final String uriId = (String)element$iv;
                final int n3 = 0;
                final UriHelper instance2 = UriHelper.INSTANCE;
                final Map<String, Integer> keepURIAccessPermissionUseCount = UriHelper.keepURIAccessPermissionUseCount;
                final UriHelper instance3 = UriHelper.INSTANCE;
                final Map $this$getOrPut$iv = UriHelper.keepURIAccessPermissionUseCount;
                final int $i$f$getOrPut = 0;
                final Object value$iv = $this$getOrPut$iv.get(uriId);
                Object o;
                if (value$iv == null) {
                    final int n4 = 0;
                    final Object answer$iv = 0;
                    $this$getOrPut$iv.put(uriId, answer$iv);
                    o = answer$iv;
                }
                else {
                    o = value$iv;
                }
                keepURIAccessPermissionUseCount.put(uriId, ((Number)o).intValue() + 1);
            }
            final Unit instance4 = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    @JvmStatic
    public static final void internal_keepPermissionsUris(@NotNull final Set<String> releasedUriIds) {
        Intrinsics.checkNotNullParameter((Object)releasedUriIds, "releasedUriIds");
        final UriHelper instance = UriHelper.INSTANCE;
        final ReentrantReadWriteLock permissionUriLock = UriHelper.permissionUriLock;
        final ReentrantReadWriteLock.ReadLock lock = permissionUriLock.readLock();
        final int n = (permissionUriLock.getWriteHoldCount() == 0) ? permissionUriLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = permissionUriLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            final Iterable $this$forEach$iv = releasedUriIds;
            final int $i$f$forEach = 0;
            for (final Object element$iv : $this$forEach$iv) {
                final String uriId = (String)element$iv;
                final int n3 = 0;
                final UriHelper instance2 = UriHelper.INSTANCE;
                final Map<String, Integer> keepURIAccessPermissionUseCount = UriHelper.keepURIAccessPermissionUseCount;
                final int n4 = 1;
                final UriHelper instance3 = UriHelper.INSTANCE;
                final Integer n5 = UriHelper.keepURIAccessPermissionUseCount.get(uriId);
                if (n5 == null) {
                    return;
                }
                keepURIAccessPermissionUseCount.put(uriId, n4 + n5);
            }
            final Unit instance4 = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    @JvmStatic
    @AnyThread
    @NotNull
    public static final Uri createFromBase64String(@NotNull final String base64) {
        Intrinsics.checkNotNullParameter((Object)base64, "base64");
        byte[] array;
        try {
            final Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue((Object)forName, "forName(charsetName)");
            final byte[] bytes = base64.getBytes(forName);
            Intrinsics.checkNotNullExpressionValue((Object)bytes, "this as java.lang.String).getBytes(charset)");
            array = bytes;
        }
        catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        final byte[] buffer = array;
        String string2;
        try {
            final MessageDigest it;
            final MessageDigest messageDigest = it = MessageDigest.getInstance("SHA1");
            final int n = 0;
            it.reset();
            it.update(buffer);
            final byte[] digest = messageDigest.digest();
            final StringBuilder hexStr = new StringBuilder();
            Intrinsics.checkNotNullExpressionValue((Object)digest, "digest");
            final byte[] array2 = digest;
            for (int i = 0; i < array2.length; ++i) {
                final byte b = array2[i];
                final StringBuilder sb = hexStr;
                final String string = Integer.toString((byte)(b & -1) + 256, CharsKt.checkRadix(16));
                Intrinsics.checkNotNullExpressionValue((Object)string, "toString(this, checkRadix(radix))");
                final String substring = string.substring(1);
                Intrinsics.checkNotNullExpressionValue((Object)substring, "this as java.lang.String).substring(startIndex)");
                sb.append(substring);
            }
            string2 = hexStr.toString();
        }
        catch (NoSuchAlgorithmException e2) {
            throw new RuntimeException(e2);
        }
        final String s = string2;
        Intrinsics.checkNotNullExpressionValue((Object)s, "try {\n\n            val d\u2026imeException(e)\n        }");
        final String tempFileName = s;
        final File $this$createFromBase64String_u24lambda_u2d12 = File.createTempFile(tempFileName, ".tmp");
        final int n2 = 0;
        $this$createFromBase64String_u24lambda_u2d12.deleteOnExit();
        final File file = $this$createFromBase64String_u24lambda_u2d12;
        try {
            final BufferedOutputStream bufferedOutputStream = new BufferedOutputStream(new FileOutputStream(file));
            Throwable t = null;
            try {
                final BufferedOutputStream it2 = bufferedOutputStream;
                final int n3 = 0;
                it2.write(Base64.decode(buffer, 0));
                final Unit instance = Unit.INSTANCE;
            }
            catch (Throwable t2) {
                t = t2;
                throw t2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)bufferedOutputStream, t);
            }
        }
        catch (IOException e3) {
            e3.printStackTrace();
        }
        final Uri fromFile = Uri.fromFile(file);
        Intrinsics.checkNotNullExpressionValue((Object)fromFile, "fromFile(file)");
        return fromFile;
    }
    
    @JvmStatic
    public static final boolean isFileResource(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        return Intrinsics.areEqual((Object)uri.getScheme(), (Object)"file");
    }
    
    @JvmStatic
    public static final boolean isLocalResource(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        return (Intrinsics.areEqual((Object)uri.getScheme(), (Object)"content") && UriHelper.INSTANCE.isContentUriLocal(uri)) || Intrinsics.areEqual((Object)uri.getScheme(), (Object)"file");
    }
    
    @JvmStatic
    public static final boolean isAssetResource(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        return Intrinsics.areEqual((Object)uri.getScheme(), (Object)"asset");
    }
    
    @JvmStatic
    public static final boolean isExternalResource(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        final String[] external_SCHEMES = UriHelper.EXTERNAL_SCHEMES;
        final String scheme = uri.getScheme();
        String lowerCase;
        if (scheme != null) {
            final String s = scheme;
            final Locale root = Locale.ROOT;
            Intrinsics.checkNotNullExpressionValue((Object)root, "ROOT");
            Intrinsics.checkNotNullExpressionValue((Object)(lowerCase = s.toLowerCase(root)), "this as java.lang.String).toLowerCase(locale)");
        }
        else {
            lowerCase = null;
        }
        return ArraysKt.contains((Object[])external_SCHEMES, (Object)lowerCase);
    }
    
    @JvmStatic
    @Nullable
    public static final String getAssetResourcePath(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        String joinToString$default;
        if (UriHelperKt.isAssetResource(uri)) {
            final List pathSegments = uri.getPathSegments();
            Intrinsics.checkNotNullExpressionValue((Object)pathSegments, "uri.pathSegments");
            final List list = pathSegments;
            final String separator = File.separator;
            Intrinsics.checkNotNullExpressionValue((Object)separator, "separator");
            joinToString$default = CollectionsKt.joinToString$default((Iterable)list, (CharSequence)separator, (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)null, 62, (Object)null);
        }
        else {
            joinToString$default = null;
        }
        return joinToString$default;
    }
    
    @JvmStatic
    @Nullable
    public static final AssetFileDescriptor getAssetResourceFileDescriptor(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        final String assetPath = UriHelperKt.getAssetResourcePath(uri);
        return (assetPath != null) ? IMGLY.getAppContext().getAssets().openFd(assetPath) : null;
    }
    
    @JvmStatic
    @CheckResult
    @NotNull
    public static final Uri waitForAccessPermission(@NotNull final Uri uri) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "uri"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: getstatic       ly/img/android/pesdk/utils/UriHelper.INSTANCE:Lly/img/android/pesdk/utils/UriHelper;
        //    10: pop            
        //    11: getstatic       ly/img/android/pesdk/utils/UriHelper.keepURIAccessPermissionLocks:Ljava/util/Map;
        //    14: aload_0         /* uri */
        //    15: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //    18: dup            
        //    19: ifnonnull       25
        //    22: pop            
        //    23: aload_0         /* uri */
        //    24: areturn        
        //    25: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    30: checkcast       Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    33: dup            
        //    34: ifnull          68
        //    37: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //    40: astore_1       
        //    41: aload_1        
        //    42: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //    45: nop            
        //    46: iconst_0       
        //    47: istore_2       
        //    48: aload_0         /* uri */
        //    49: astore_2       
        //    50: aload_1        
        //    51: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    54: aload_2        
        //    55: goto            65
        //    58: astore_2       
        //    59: aload_1        
        //    60: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //    63: aload_2        
        //    64: athrow         
        //    65: goto            70
        //    68: pop            
        //    69: aload_0         /* uri */
        //    70: areturn        
        //    StackMapTable: 00 05 FF 00 19 00 01 07 00 4E 00 02 07 00 D5 07 00 D3 FF 00 20 00 02 07 00 4E 07 00 B5 00 01 07 00 64 FF 00 06 00 03 07 00 4E 07 00 B5 07 00 4E 00 01 07 00 4E FF 00 02 00 01 07 00 4E 00 01 07 00 A8 41 07 00 4E
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  45     50     58     65     Any
        //  58     59     58     65     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0070 (coming from #0065).
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2183)
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
    
    @JvmStatic
    @Nullable
    public static final Uri savePermission(@Nullable final Uri uri) {
        return (uri != null) ? UriHelperKt.saveReadPermission(uri) : null;
    }
    
    @JvmStatic
    @Nullable
    public static final Uri restoreWithPermission(@Nullable final Uri uri) {
        return (uri != null) ? UriHelperKt.restoreWithReadPermission(uri) : null;
    }
    
    private final boolean isContentUriLocal(final Uri uri) {
        final StorageUtils instance = StorageUtils.INSTANCE;
        final Context appContext = IMGLY.getAppContext();
        Intrinsics.checkNotNullExpressionValue((Object)appContext, "getAppContext()");
        return instance.getDataColumn(appContext, uri, null, null) != null;
    }
    
    @NotNull
    public final Uri convertToLocalUri(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        Uri fromFile;
        if (this.isContentUriLocal(uri)) {
            fromFile = uri;
        }
        else {
            final File file = copyAsFile$default(uri, null, 2, null);
            file.deleteOnExit();
            Intrinsics.checkNotNullExpressionValue((Object)(fromFile = Uri.fromFile(file)), "{\n            val file =\u2026.fromFile(file)\n        }");
        }
        return fromFile;
    }
    
    @NotNull
    public final Uri copyToLocalAsync(@NotNull final Uri uri, @NotNull final Function1<? super Uri, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final File externalCacheDir = IMGLY.getAppContext().getExternalCacheDir();
        final StringBuilder sb = new StringBuilder();
        final String path = uri.getPath();
        Intrinsics.checkNotNull((Object)path);
        final byte[] bytes = path.getBytes(Charsets.UTF_8);
        Intrinsics.checkNotNullExpressionValue((Object)bytes, "this as java.lang.String).getBytes(charset)");
        final File file = new File(externalCacheDir, sb.append(Base64.encodeToString(bytes, 8)).append(".tmp").toString());
        Uri fromFile;
        if (!file.exists()) {
            file.deleteOnExit();
            final ThreadUtils.ThreadSync threadSync = new ThreadUtils.ThreadSync();
            ThreadsKt.thread$default(false, false, (ClassLoader)null, (String)null, 0, (Function0)new UriHelper$copyToLocalAsync.UriHelper$copyToLocalAsync$1(uri, threadSync, file, (Function1)block), 31, (Object)null);
            final Object waitForJob = threadSync.waitForJob();
            if (waitForJob == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.net.Uri");
            }
            fromFile = (Uri)waitForJob;
        }
        else {
            Intrinsics.checkNotNullExpressionValue((Object)(fromFile = Uri.fromFile(file)), "{\n            Uri.fromFile(file)\n        }");
        }
        return fromFile;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final File copyAsFile(@NotNull final Uri sourceUri) {
        Intrinsics.checkNotNullParameter((Object)sourceUri, "sourceUri");
        return copyAsFile$default(sourceUri, null, 2, null);
    }
    
    static {
        INSTANCE = new UriHelper();
        UriHelper.permissionUriLock = new ReentrantReadWriteLock();
        keepURIAccessPermission = new LinkedHashMap<String, Uri>();
        keepURIAccessPermissionLocks = new LinkedHashMap<String, ReentrantReadWriteLock>();
        keepURIAccessPermissionUseCount = new LinkedHashMap<String, Integer>();
        tempToOriginalMapping = new LinkedHashMap<String, String>();
        EXTERNAL_SCHEMES = new String[] { "http", "https", "ftp" };
    }
}
