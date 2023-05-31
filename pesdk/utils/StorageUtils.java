// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.content.ContentResolver;
import android.database.Cursor;
import org.jetbrains.annotations.Nullable;
import androidx.annotation.CheckResult;
import android.os.Environment;
import android.provider.MediaStore$Video$Media;
import android.provider.MediaStore$Images$Media;
import ly.img.android.SourceType;
import ly.img.android.IMGLY;
import android.content.ContentValues;
import java.io.File;
import kotlin.jvm.JvmStatic;
import ly.img.android.pesdk.ui.utils.PermissionRequest;
import ly.img.android.pesdk.ui.activity.ImgLyIntent;
import android.content.Context;
import android.os.Build$VERSION;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import android.net.Uri;
import kotlin.jvm.functions.Function1;
import ly.img.android.pesdk.backend.model.constant.ExportFormat;
import android.app.Activity;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0007H\u0002J\u0018\u0010\t\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJQ\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u00072#\u0010\u0016\u001a\u001f\u0012\u0015\u0012\u0013\u0018\u00010\r¢\u0006\f\b\u0018\u0012\b\b\u0015\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000f0\u0017H\u0007J.\u0010\u000e\u001a\u0004\u0018\u00010\r2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u00132\b\b\u0002\u0010\u0014\u001a\u00020\u00072\b\b\u0002\u0010\u0015\u001a\u00020\u0007H\u0007JE\u0010\u0019\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u001a\u001a\u00020\u00072\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d¢\u0006\u0002\u0010\u001eJ=\u0010\u001f\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u001b\u001a\u0004\u0018\u00010\u00072\u0010\b\u0002\u0010\u001c\u001a\n\u0012\u0004\u0012\u00020\u0007\u0018\u00010\u001d¢\u0006\u0002\u0010 J\u000e\u0010!\u001a\u00020\u000f2\u0006\u0010\f\u001a\u00020\r¨\u0006\"" }, d2 = { "Lly/img/android/pesdk/utils/StorageUtils;", "", "()V", "createNoneExistingFile", "Ljava/io/File;", "folder", "fileName", "", "fileExtension", "determineFilePath", "context", "Landroid/content/Context;", "uri", "Landroid/net/Uri;", "generateGalleryUri", "", "activity", "Landroid/app/Activity;", "exportFormat", "Lly/img/android/pesdk/backend/model/constant/ExportFormat;", "relativeFolderPath", "name", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "getColumn", "column", "selection", "selectionArgs", "", "(Landroid/content/Context;Ljava/lang/String;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "getDataColumn", "(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;", "setGalleryUriDone", "pesdk-backend-core_release" })
public final class StorageUtils
{
    @NotNull
    public static final StorageUtils INSTANCE;
    
    private StorageUtils() {
    }
    
    @JvmStatic
    public static final void generateGalleryUri(@NotNull final Activity activity, @NotNull final ExportFormat exportFormat, @NotNull final String relativeFolderPath, @NotNull final String name, @NotNull final Function1<? super Uri, Unit> callback) {
        Intrinsics.checkNotNullParameter((Object)activity, "activity");
        Intrinsics.checkNotNullParameter((Object)exportFormat, "exportFormat");
        Intrinsics.checkNotNullParameter((Object)relativeFolderPath, "relativeFolderPath");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)callback, "callback");
        if (Build$VERSION.SDK_INT >= 29) {
            callback.invoke((Object)StorageUtils.INSTANCE.generateGalleryUri((Context)activity, exportFormat, relativeFolderPath, name));
        }
        else {
            PermissionRequest.getPermission(new ImgLyIntent.ResultDelegator(activity), new String[] { "android.permission.WRITE_EXTERNAL_STORAGE" }, (PermissionRequest.Response)new StorageUtils$generateGalleryUri.StorageUtils$generateGalleryUri$1((Function1)callback, activity, exportFormat, relativeFolderPath, name));
        }
    }
    
    private final File createNoneExistingFile(final File folder, final String fileName, final String fileExtension) {
        if (!folder.exists()) {
            folder.mkdirs();
        }
        File file = new File(folder, fileName + fileExtension);
        for (int uniqueFileSuffix = 2; file.exists(); file = new File(folder, fileName + uniqueFileSuffix++ + fileExtension)) {}
        return file;
    }
    
    public final void setGalleryUriDone(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        if (Build$VERSION.SDK_INT >= 29) {
            final ContentValues it = new ContentValues();
            final int n = 0;
            it.put("is_pending", Integer.valueOf(0));
            final ContentValues contentValues = it;
            try {
                IMGLY.getAppContext().getContentResolver().update(uri, contentValues, (String)null, (String[])null);
            }
            catch (Throwable t) {}
        }
    }
    
    @CheckResult
    @Nullable
    public final Uri generateGalleryUri(@NotNull final Context context, @NotNull final ExportFormat exportFormat, @NotNull final String relativeFolderPath, @NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)context, "context");
        Intrinsics.checkNotNullParameter((Object)exportFormat, "exportFormat");
        Intrinsics.checkNotNullParameter((Object)relativeFolderPath, "relativeFolderPath");
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final Uri externalContentUri = (exportFormat.getType() == SourceType.IMAGE) ? MediaStore$Images$Media.EXTERNAL_CONTENT_URI : MediaStore$Video$Media.EXTERNAL_CONTENT_URI;
        final ContentValues it;
        final ContentValues contentValues2 = it = new ContentValues();
        final int n = 0;
        if (Build$VERSION.SDK_INT >= 29) {
            it.put("relative_path", relativeFolderPath);
            it.put("_display_name", name + exportFormat.getFileExtension());
        }
        else {
            final File file = StorageUtils.INSTANCE.createNoneExistingFile(new File(Environment.getExternalStorageDirectory(), relativeFolderPath), name, exportFormat.getFileExtension());
            it.put("_data", file.getAbsolutePath());
            it.put("_display_name", file.getName());
            context.getContentResolver().delete(externalContentUri, "_data=\"" + file.getAbsolutePath() + '\"', (String[])null);
        }
        final ContentValues contentValues = contentValues2;
        if (Build$VERSION.SDK_INT >= 29) {
            contentValues.put("is_pending", Integer.valueOf(1));
        }
        return context.getContentResolver().insert(externalContentUri, contentValues);
    }
    
    @Nullable
    public final String determineFilePath(@NotNull final Context context, @NotNull final Uri uri) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "context"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* uri */
        //     7: ldc             "uri"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_1         /* context */
        //    13: aload_2         /* uri */
        //    14: invokestatic    android/provider/DocumentsContract.isDocumentUri:(Landroid/content/Context;Landroid/net/Uri;)Z
        //    17: ifeq            536
        //    20: aload_2         /* uri */
        //    21: invokevirtual   android/net/Uri.getAuthority:()Ljava/lang/String;
        //    24: astore_3       
        //    25: aload_3        
        //    26: ifnull          590
        //    29: aload_3        
        //    30: invokevirtual   java/lang/String.hashCode:()I
        //    33: lookupswitch {
        //          320699453: 68
        //          596745902: 93
        //          1734583286: 80
        //          default: 533
        //        }
        //    68: aload_3        
        //    69: ldc             "com.android.providers.downloads.documents"
        //    71: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    74: ifne            212
        //    77: goto            590
        //    80: aload_3        
        //    81: ldc_w           "com.android.providers.media.documents"
        //    84: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //    87: ifne            264
        //    90: goto            590
        //    93: aload_3        
        //    94: ldc_w           "com.android.externalstorage.documents"
        //    97: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   100: ifeq            590
        //   103: aload_2         /* uri */
        //   104: invokestatic    android/provider/DocumentsContract.getDocumentId:(Landroid/net/Uri;)Ljava/lang/String;
        //   107: astore          documentId
        //   109: aload           documentId
        //   111: ldc_w           "documentId"
        //   114: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   117: aload           documentId
        //   119: checkcast       Ljava/lang/CharSequence;
        //   122: iconst_1       
        //   123: anewarray       Ljava/lang/String;
        //   126: astore          6
        //   128: aload           6
        //   130: iconst_0       
        //   131: ldc_w           ":"
        //   134: aastore        
        //   135: aload           6
        //   137: iconst_0       
        //   138: iconst_0       
        //   139: bipush          6
        //   141: aconst_null    
        //   142: invokestatic    kotlin/text/StringsKt.split$default:(Ljava/lang/CharSequence;[Ljava/lang/String;ZIILjava/lang/Object;)Ljava/util/List;
        //   145: astore          split
        //   147: aload           split
        //   149: iconst_0       
        //   150: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   155: checkcast       Ljava/lang/String;
        //   158: astore          type
        //   160: ldc_w           "primary"
        //   163: aload           type
        //   165: iconst_1       
        //   166: invokestatic    kotlin/text/StringsKt.equals:(Ljava/lang/String;Ljava/lang/String;Z)Z
        //   169: ifeq            590
        //   172: new             Ljava/lang/StringBuilder;
        //   175: dup            
        //   176: invokespecial   java/lang/StringBuilder.<init>:()V
        //   179: invokestatic    android/os/Environment.getExternalStorageDirectory:()Ljava/io/File;
        //   182: invokevirtual   java/io/File.toString:()Ljava/lang/String;
        //   185: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   188: getstatic       java/io/File.separator:Ljava/lang/String;
        //   191: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   194: aload           split
        //   196: iconst_1       
        //   197: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   202: checkcast       Ljava/lang/String;
        //   205: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   208: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   211: areturn        
        //   212: aload_2         /* uri */
        //   213: invokestatic    android/provider/DocumentsContract.getDocumentId:(Landroid/net/Uri;)Ljava/lang/String;
        //   216: astore          id
        //   218: ldc_w           "content://downloads/public_downloads"
        //   221: invokestatic    android/net/Uri.parse:(Ljava/lang/String;)Landroid/net/Uri;
        //   224: aload           id
        //   226: invokestatic    java/lang/Long.valueOf:(Ljava/lang/String;)Ljava/lang/Long;
        //   229: dup            
        //   230: ldc_w           "valueOf(id)"
        //   233: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   236: checkcast       Ljava/lang/Number;
        //   239: invokevirtual   java/lang/Number.longValue:()J
        //   242: invokestatic    android/content/ContentUris.withAppendedId:(Landroid/net/Uri;J)Landroid/net/Uri;
        //   245: dup            
        //   246: ldc_w           "withAppendedId(Uri.parse\u2026va.lang.Long.valueOf(id))"
        //   249: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   252: astore          contentUri
        //   254: aload_0         /* this */
        //   255: aload_1         /* context */
        //   256: aload           contentUri
        //   258: aconst_null    
        //   259: aconst_null    
        //   260: invokevirtual   ly/img/android/pesdk/utils/StorageUtils.getDataColumn:(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
        //   263: areturn        
        //   264: aload_2         /* uri */
        //   265: invokestatic    android/provider/DocumentsContract.getDocumentId:(Landroid/net/Uri;)Ljava/lang/String;
        //   268: astore          docId
        //   270: aload           docId
        //   272: ldc_w           "docId"
        //   275: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   278: aload           docId
        //   280: checkcast       Ljava/lang/CharSequence;
        //   283: astore          6
        //   285: new             Lkotlin/text/Regex;
        //   288: dup            
        //   289: ldc_w           ":"
        //   292: invokespecial   kotlin/text/Regex.<init>:(Ljava/lang/String;)V
        //   295: astore          7
        //   297: iconst_0       
        //   298: istore          8
        //   300: aload           7
        //   302: aload           6
        //   304: iload           8
        //   306: invokevirtual   kotlin/text/Regex.split:(Ljava/lang/CharSequence;I)Ljava/util/List;
        //   309: checkcast       Ljava/util/Collection;
        //   312: astore          6
        //   314: nop            
        //   315: iconst_0       
        //   316: istore          $i$f$toTypedArray
        //   318: aload           $this$toTypedArray$iv
        //   320: astore          thisCollection$iv
        //   322: aload           thisCollection$iv
        //   324: iconst_0       
        //   325: anewarray       Ljava/lang/String;
        //   328: invokeinterface java/util/Collection.toArray:([Ljava/lang/Object;)[Ljava/lang/Object;
        //   333: dup            
        //   334: ifnonnull       349
        //   337: pop            
        //   338: new             Ljava/lang/NullPointerException;
        //   341: dup            
        //   342: ldc_w           "null cannot be cast to non-null type kotlin.Array<T of kotlin.collections.ArraysKt__ArraysJVMKt.toTypedArray>"
        //   345: invokespecial   java/lang/NullPointerException.<init>:(Ljava/lang/String;)V
        //   348: athrow         
        //   349: checkcast       [Ljava/lang/String;
        //   352: astore          split
        //   354: aload           split
        //   356: iconst_0       
        //   357: aaload         
        //   358: astore          type
        //   360: aload           type
        //   362: astore          8
        //   364: aload           8
        //   366: invokevirtual   java/lang/String.hashCode:()I
        //   369: lookupswitch {
        //          93166550: 432
        //          100313435: 404
        //          112202875: 418
        //          default: 485
        //        }
        //   404: aload           8
        //   406: ldc_w           "image"
        //   409: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   412: ifne            446
        //   415: goto            485
        //   418: aload           8
        //   420: ldc_w           "video"
        //   423: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   426: ifne            459
        //   429: goto            485
        //   432: aload           8
        //   434: ldc_w           "audio"
        //   437: invokevirtual   java/lang/String.equals:(Ljava/lang/Object;)Z
        //   440: ifne            472
        //   443: goto            485
        //   446: getstatic       android/provider/MediaStore$Images$Media.EXTERNAL_CONTENT_URI:Landroid/net/Uri;
        //   449: dup            
        //   450: ldc_w           "{\n                      \u2026                        }"
        //   453: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   456: goto            496
        //   459: getstatic       android/provider/MediaStore$Video$Media.EXTERNAL_CONTENT_URI:Landroid/net/Uri;
        //   462: dup            
        //   463: ldc_w           "{\n                      \u2026                        }"
        //   466: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   469: goto            496
        //   472: getstatic       android/provider/MediaStore$Audio$Media.EXTERNAL_CONTENT_URI:Landroid/net/Uri;
        //   475: dup            
        //   476: ldc_w           "{\n                      \u2026                        }"
        //   479: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   482: goto            496
        //   485: new             Ljava/lang/IllegalArgumentException;
        //   488: dup            
        //   489: ldc_w           "Type not supported."
        //   492: invokespecial   java/lang/IllegalArgumentException.<init>:(Ljava/lang/String;)V
        //   495: athrow         
        //   496: astore          contentUri
        //   498: ldc_w           "_id=?"
        //   501: astore          selection
        //   503: iconst_1       
        //   504: anewarray       Ljava/lang/String;
        //   507: astore          10
        //   509: aload           10
        //   511: iconst_0       
        //   512: aload           split
        //   514: iconst_1       
        //   515: aaload         
        //   516: aastore        
        //   517: aload           10
        //   519: astore          selectionArgs
        //   521: aload_0         /* this */
        //   522: aload_1         /* context */
        //   523: aload           contentUri
        //   525: aload           selection
        //   527: aload           selectionArgs
        //   529: invokevirtual   ly/img/android/pesdk/utils/StorageUtils.getDataColumn:(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
        //   532: areturn        
        //   533: goto            590
        //   536: ldc_w           "content"
        //   539: aload_2         /* uri */
        //   540: invokevirtual   android/net/Uri.getScheme:()Ljava/lang/String;
        //   543: iconst_1       
        //   544: invokestatic    kotlin/text/StringsKt.equals:(Ljava/lang/String;Ljava/lang/String;Z)Z
        //   547: ifeq            559
        //   550: aload_0         /* this */
        //   551: aload_1         /* context */
        //   552: aload_2         /* uri */
        //   553: aconst_null    
        //   554: aconst_null    
        //   555: invokevirtual   ly/img/android/pesdk/utils/StorageUtils.getDataColumn:(Landroid/content/Context;Landroid/net/Uri;Ljava/lang/String;[Ljava/lang/String;)Ljava/lang/String;
        //   558: areturn        
        //   559: ldc_w           "file"
        //   562: aload_2         /* uri */
        //   563: invokevirtual   android/net/Uri.getScheme:()Ljava/lang/String;
        //   566: iconst_1       
        //   567: invokestatic    kotlin/text/StringsKt.equals:(Ljava/lang/String;Ljava/lang/String;Z)Z
        //   570: ifeq            578
        //   573: aload_2         /* uri */
        //   574: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //   577: areturn        
        //   578: aload_2         /* uri */
        //   579: invokevirtual   android/net/Uri.getScheme:()Ljava/lang/String;
        //   582: ifnonnull       590
        //   585: aload_2         /* uri */
        //   586: invokevirtual   android/net/Uri.getPath:()Ljava/lang/String;
        //   589: areturn        
        //   590: aconst_null    
        //   591: areturn        
        //    StackMapTable: 00 13 FC 00 44 07 00 3A 0B 0C FB 00 76 33 FF 00 54 00 09 07 00 02 07 00 2A 07 00 AA 07 00 3A 07 00 3A 00 07 01 53 01 07 01 53 00 01 07 01 85 FF 00 36 00 09 07 00 02 07 00 2A 07 00 AA 07 00 3A 07 00 3A 07 01 5E 07 00 3A 01 07 00 3A 00 00 0D 0D 0D 0C 0C 0C 4A 07 00 AA FF 00 24 00 04 07 00 02 07 00 2A 07 00 AA 07 00 3A 00 00 FA 00 02 16 12 0B
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
    
    @Nullable
    public final String getColumn(@NotNull final Context context, @NotNull final String column, @Nullable final Uri uri, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        Intrinsics.checkNotNullParameter((Object)context, "context");
        Intrinsics.checkNotNullParameter((Object)column, "column");
        Cursor cursor = null;
        final String[] projection = { column };
        try {
            final ContentResolver contentResolver = context.getContentResolver();
            Intrinsics.checkNotNull((Object)uri);
            cursor = contentResolver.query(uri, projection, selection, selectionArgs, (String)null);
            if (cursor != null && cursor.moveToFirst()) {
                final int columnIndex = cursor.getColumnIndexOrThrow(column);
                final String string = cursor.getString(columnIndex);
                cursor.close();
                return string;
            }
        }
        catch (Exception ignore) {
            return null;
        }
        finally {
            final Cursor cursor2 = cursor;
            if (cursor2 != null) {
                cursor2.close();
            }
        }
        return null;
    }
    
    @Nullable
    public final String getDataColumn(@NotNull final Context context, @Nullable final Uri uri, @Nullable final String selection, @Nullable final String[] selectionArgs) {
        Intrinsics.checkNotNullParameter((Object)context, "context");
        return this.getColumn(context, "_data", uri, selection, selectionArgs);
    }
    
    static {
        INSTANCE = new StorageUtils();
    }
}
