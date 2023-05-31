// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import android.content.res.AssetFileDescriptor;
import android.media.MediaMetadataRetriever;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.functions.Function1;
import android.media.MediaExtractor;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import android.media.MediaFormat;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000J\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a\u001d\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0001H\u0086\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0086\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0007H\u0086\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0086\u0002\u001a&\u0010\b\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\tH\u0086\b\u00f8\u0001\u0000\u001a\u001c\u0010\n\u001a\u0004\u0018\u00010\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000b\u001a&\u0010\f\u001a\u00020\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\tH\u0086\b\u00f8\u0001\u0000\u001a\u001c\u0010\r\u001a\u0004\u0018\u00010\u0006*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u000e\u001a&\u0010\u000f\u001a\u00020\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\tH\u0086\b\u00f8\u0001\u0000\u001a\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0007*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u0004H\u0086\b¢\u0006\u0002\u0010\u0011\u001a(\u0010\u0012\u001a\u0004\u0018\u00010\u0004*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\tH\u0086\b\u00f8\u0001\u0000\u001a\u001d\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0001H\u0086\u0002\u001a\u001d\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0006H\u0086\u0002\u001a\u001d\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0007H\u0086\u0002\u001a\u001d\u0010\u0013\u001a\u00020\u0014*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0004H\u0086\u0002\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019\u001a\u0012\u0010\u0016\u001a\u00020\u0014*\u00020\u001a2\u0006\u0010\u0018\u001a\u00020\u0019\u001a>\u0010\u001b\u001a\u0002H\u001c\"\u0004\b\u0000\u0010\u001c*\u00020\u00172!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u0017¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H\u001c0\u001eH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\"\u001a>\u0010#\u001a\u0002H$\"\u0004\b\u0000\u0010$*\u00020\u001a2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u00110\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(!\u0012\u0004\u0012\u0002H$0\u001eH\u0086\f\u00f8\u0001\u0000¢\u0006\u0002\u0010%\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006&" }, d2 = { "get", "", "Landroid/media/MediaFormat;", "key", "", "default", "", "", "getFloat", "Lkotlin/Function0;", "getFloatOrNull", "(Landroid/media/MediaFormat;Ljava/lang/String;)Ljava/lang/Float;", "getInt", "getIntOrNull", "(Landroid/media/MediaFormat;Ljava/lang/String;)Ljava/lang/Integer;", "getLong", "getLongOrNull", "(Landroid/media/MediaFormat;Ljava/lang/String;)Ljava/lang/Long;", "getString", "set", "", "value", "setDataSourceCompat", "Landroid/media/MediaExtractor;", "assetFileDescriptor", "Landroid/content/res/AssetFileDescriptor;", "Landroid/media/MediaMetadataRetriever;", "use", "A", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Landroid/media/MediaExtractor;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "useCompat", "R", "(Landroid/media/MediaMetadataRetriever;Lkotlin/jvm/functions/Function1;)Ljava/lang/Object;", "pesdk-backend-core_release" })
public final class MediaExtensionsKt
{
    public static final int get(@NotNull final MediaFormat $this$get, @NotNull final String key, final int default) {
        Intrinsics.checkNotNullParameter((Object)$this$get, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return $this$get.containsKey(key) ? $this$get.getInteger(key) : default;
    }
    
    public static final long get(@NotNull final MediaFormat $this$get, @NotNull final String key, final long default) {
        Intrinsics.checkNotNullParameter((Object)$this$get, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return $this$get.containsKey(key) ? $this$get.getLong(key) : default;
    }
    
    @NotNull
    public static final String get(@NotNull final MediaFormat $this$get, @NotNull final String key, @NotNull final String default) {
        Intrinsics.checkNotNullParameter((Object)$this$get, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)default, "default");
        String string;
        if ((string = $this$get.getString(key)) == null) {
            string = default;
        }
        return string;
    }
    
    public static final float get(@NotNull final MediaFormat $this$get, @NotNull final String key, final float default) {
        Intrinsics.checkNotNullParameter((Object)$this$get, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        return $this$get.containsKey(key) ? $this$get.getFloat(key) : default;
    }
    
    public static final void set(@NotNull final MediaFormat $this$set, @NotNull final String key, final int value) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        $this$set.setInteger(key, value);
    }
    
    public static final void set(@NotNull final MediaFormat $this$set, @NotNull final String key, final long value) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        $this$set.setLong(key, value);
    }
    
    public static final void set(@NotNull final MediaFormat $this$set, @NotNull final String key, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        $this$set.setFloat(key, value);
    }
    
    public static final void set(@NotNull final MediaFormat $this$set, @NotNull final String key, @NotNull final String value) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)value, "value");
        $this$set.setString(key, value);
    }
    
    public static final float getFloat(@NotNull final MediaFormat $this$getFloat, @NotNull final String key, @NotNull final Function0<Float> default) {
        Intrinsics.checkNotNullParameter((Object)$this$getFloat, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)default, "default");
        final int $i$f$getFloat = 0;
        return $this$getFloat.containsKey(key) ? $this$getFloat.getFloat(key) : ((Number)default.invoke()).floatValue();
    }
    
    public static final int getInt(@NotNull final MediaFormat $this$getInt, @NotNull final String key, @NotNull final Function0<Integer> default) {
        Intrinsics.checkNotNullParameter((Object)$this$getInt, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)default, "default");
        final int $i$f$getInt = 0;
        return $this$getInt.containsKey(key) ? $this$getInt.getInteger(key) : ((Number)default.invoke()).intValue();
    }
    
    public static final long getLong(@NotNull final MediaFormat $this$getLong, @NotNull final String key, @NotNull final Function0<Long> default) {
        Intrinsics.checkNotNullParameter((Object)$this$getLong, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)default, "default");
        final int $i$f$getLong = 0;
        return $this$getLong.containsKey(key) ? $this$getLong.getLong(key) : ((Number)default.invoke()).longValue();
    }
    
    @Nullable
    public static final String getString(@NotNull final MediaFormat $this$getString, @NotNull final String key, @NotNull final Function0<String> default) {
        Intrinsics.checkNotNullParameter((Object)$this$getString, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        Intrinsics.checkNotNullParameter((Object)default, "default");
        final int $i$f$getString = 0;
        return (String)($this$getString.containsKey(key) ? $this$getString.getString(key) : default.invoke());
    }
    
    @Nullable
    public static final Float getFloatOrNull(@NotNull final MediaFormat $this$getFloatOrNull, @NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getFloatOrNull, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final int $i$f$getFloatOrNull = 0;
        return $this$getFloatOrNull.containsKey(key) ? Float.valueOf($this$getFloatOrNull.getFloat(key)) : null;
    }
    
    @Nullable
    public static final Integer getIntOrNull(@NotNull final MediaFormat $this$getIntOrNull, @NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getIntOrNull, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final int $i$f$getIntOrNull = 0;
        return $this$getIntOrNull.containsKey(key) ? Integer.valueOf($this$getIntOrNull.getInteger(key)) : null;
    }
    
    @Nullable
    public static final Long getLongOrNull(@NotNull final MediaFormat $this$getLongOrNull, @NotNull final String key) {
        Intrinsics.checkNotNullParameter((Object)$this$getLongOrNull, "<this>");
        Intrinsics.checkNotNullParameter((Object)key, "key");
        final int $i$f$getLongOrNull = 0;
        return $this$getLongOrNull.containsKey(key) ? Long.valueOf($this$getLongOrNull.getLong(key)) : null;
    }
    
    public static final <A> A use(@NotNull final MediaExtractor $this$use, @NotNull final Function1<? super MediaExtractor, ? extends A> block) {
        Intrinsics.checkNotNullParameter((Object)$this$use, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$use = 0;
        try {
            return (A)block.invoke((Object)$this$use);
        }
        finally {
            InlineMarker.finallyStart(1);
            $this$use.release();
            InlineMarker.finallyEnd(1);
        }
    }
    
    public static final <R> R useCompat(@NotNull final MediaMetadataRetriever $this$useCompat, @NotNull final Function1<? super MediaMetadataRetriever, ? extends R> block) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* block */
        //     7: ldc             "block"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$useCompat */
        //    14: getstatic       android/os/Build$VERSION.SDK_INT:I
        //    17: bipush          29
        //    19: if_icmplt       97
        //    22: aload_0         /* $this$useCompat */
        //    23: checkcast       Ljava/lang/AutoCloseable;
        //    26: astore_3       
        //    27: aconst_null    
        //    28: astore          4
        //    30: nop            
        //    31: aload_3        
        //    32: checkcast       Landroid/media/MediaMetadataRetriever;
        //    35: astore          it
        //    37: iconst_0       
        //    38: istore          $i$a$-use-MediaExtensionsKt$useCompat$1
        //    40: aload_1         /* block */
        //    41: aload           it
        //    43: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    48: astore          null
        //    50: iconst_1       
        //    51: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    54: aload_3        
        //    55: aload           4
        //    57: invokestatic    kotlin/jdk7/AutoCloseableKt.closeFinally:(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
        //    60: iconst_1       
        //    61: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //    64: aload           5
        //    66: goto            104
        //    69: astore          5
        //    71: aload           5
        //    73: astore          4
        //    75: aload           5
        //    77: athrow         
        //    78: astore          5
        //    80: iconst_1       
        //    81: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //    84: aload_3        
        //    85: aload           4
        //    87: invokestatic    kotlin/jdk7/AutoCloseableKt.closeFinally:(Ljava/lang/AutoCloseable;Ljava/lang/Throwable;)V
        //    90: iconst_1       
        //    91: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //    94: aload           5
        //    96: athrow         
        //    97: aload_1         /* block */
        //    98: aload_0         /* $this$useCompat */
        //    99: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   104: areturn        
        //    Signature:
        //  <R:Ljava/lang/Object;>(Landroid/media/MediaMetadataRetriever;Lkotlin/jvm/functions/Function1<-Landroid/media/MediaMetadataRetriever;+TR;>;)TR;
        //    StackMapTable: 00 04 FF 00 45 00 05 07 00 BA 07 00 96 01 07 00 B8 05 00 01 07 00 AE FF 00 08 00 05 07 00 BA 07 00 96 01 07 00 B8 07 00 AE 00 01 07 00 AE F9 00 12 46 07 00 04
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  30     50     69     78     Ljava/lang/Throwable;
        //  30     50     78     97     Any
        //  69     78     78     97     Any
        //  78     80     78     97     Any
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0104 (coming from #0096).
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
    
    public static final void setDataSourceCompat(@NotNull final MediaExtractor $this$setDataSourceCompat, @NotNull final AssetFileDescriptor assetFileDescriptor) {
        Intrinsics.checkNotNullParameter((Object)$this$setDataSourceCompat, "<this>");
        Intrinsics.checkNotNullParameter((Object)assetFileDescriptor, "assetFileDescriptor");
        if (assetFileDescriptor.getDeclaredLength() < 0L) {
            $this$setDataSourceCompat.setDataSource(assetFileDescriptor.getFileDescriptor());
        }
        else {
            $this$setDataSourceCompat.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
        assetFileDescriptor.close();
    }
    
    public static final void setDataSourceCompat(@NotNull final MediaMetadataRetriever $this$setDataSourceCompat, @NotNull final AssetFileDescriptor assetFileDescriptor) {
        Intrinsics.checkNotNullParameter((Object)$this$setDataSourceCompat, "<this>");
        Intrinsics.checkNotNullParameter((Object)assetFileDescriptor, "assetFileDescriptor");
        if (assetFileDescriptor.getDeclaredLength() < 0L) {
            $this$setDataSourceCompat.setDataSource(assetFileDescriptor.getFileDescriptor());
        }
        else {
            $this$setDataSourceCompat.setDataSource(assetFileDescriptor.getFileDescriptor(), assetFileDescriptor.getStartOffset(), assetFileDescriptor.getLength());
        }
        assetFileDescriptor.close();
    }
}
