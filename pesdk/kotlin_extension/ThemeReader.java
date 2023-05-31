// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.reflect.KProperty;
import androidx.annotation.StyleRes;
import androidx.annotation.AttrRes;
import android.util.AttributeSet;
import android.content.Context;
import kotlin.Pair;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import androidx.annotation.StyleableRes;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\b\u0018\u00002\u00020\u0001:\u0007+,-./01B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u000e\u001a\u00020\u00152\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u0018\u0010\u0016\u001a\u00020\u00122\u0006\u0010\u000e\u001a\u00020\t2\b\b\u0001\u0010\u0010\u001a\u00020\tJ,\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\b\u0001\u0010\u001d\u001a\u00020\t2\b\b\u0003\u0010\u001e\u001a\u00020\tJ;\u0010\u001f\u001a\u00020\u00182.\u0010 \u001a\u0018\u0012\u0014\b\u0001\u0012\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"0!\"\u0010\u0012\u0004\u0012\u00020\t\u0012\u0006\u0012\u0004\u0018\u00010\u00010\"¢\u0006\u0002\u0010#J\u001a\u0010\u001f\u001a\u00020\u00182\b\b\u0001\u0010\u0010\u001a\u00020\t2\b\u0010$\u001a\u0004\u0018\u00010\u0001J\u0018\u0010%\u001a\u00020&2\u0006\u0010\u000e\u001a\u00020\u00152\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u0010\u0010'\u001a\u00020(2\b\b\u0001\u0010\u0010\u001a\u00020\tJ\u0018\u0010'\u001a\u00020)2\u0006\u0010\u000e\u001a\u00020*2\b\b\u0001\u0010\u0010\u001a\u00020\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R*\u0010\u0007\u001a\u001e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bj\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n`\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00062" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader;", "", "attrs", "", "([I)V", "getAttrs", "()[I", "themeAttributes", "Ljava/util/HashMap;", "", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "Lkotlin/collections/HashMap;", "bool", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean;", "default", "", "key", "colorRes", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;", "float", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat;", "", "int", "load", "", "context", "Landroid/content/Context;", "set", "Landroid/util/AttributeSet;", "defStyleAttr", "defStyleRes", "setDefaultValue", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)V", "value", "size", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize;", "string", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeOptionalString;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString;", "", "ThemeAttribute", "ThemeAttributeBoolean", "ThemeAttributeFloat", "ThemeAttributeInt", "ThemeAttributeOptionalString", "ThemeAttributeSize", "ThemeAttributeString", "pesdk-backend-core_release" })
public final class ThemeReader
{
    @NotNull
    private final int[] attrs;
    @NotNull
    private final HashMap<Integer, ThemeAttribute> themeAttributes;
    
    public ThemeReader(@StyleableRes @NotNull final int[] attrs) {
        Intrinsics.checkNotNullParameter((Object)attrs, "attrs");
        this.attrs = attrs;
        this.themeAttributes = new HashMap<Integer, ThemeAttribute>();
    }
    
    @NotNull
    public final int[] getAttrs() {
        return this.attrs;
    }
    
    @NotNull
    public final ThemeAttributeOptionalString string(@StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_2       
        //     8: iload_1         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore_3        /* key$iv */
        //    13: iconst_0       
        //    14: istore          $i$f$getOrPut
        //    16: aload_2         /* $this$getOrPut$iv */
        //    17: aload_3         /* key$iv */
        //    18: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    23: astore          value$iv
        //    25: aload           value$iv
        //    27: ifnonnull       61
        //    30: iconst_0       
        //    31: istore          $i$a$-getOrPut-ThemeReader$string$1
        //    33: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeOptionalString;
        //    36: dup            
        //    37: iload_1         /* key */
        //    38: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeOptionalString.<init>:(I)V
        //    41: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    44: astore          answer$iv
        //    46: aload_2         /* $this$getOrPut$iv */
        //    47: aload_3         /* key$iv */
        //    48: aload           answer$iv
        //    50: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    55: pop            
        //    56: aload           answer$iv
        //    58: goto            63
        //    61: aload           value$iv
        //    63: nop            
        //    64: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeOptionalString;
        //    67: areturn        
        //    StackMapTable: 00 02 FF 00 3D 00 06 07 00 02 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeString string(@NotNull final String default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "default"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    10: checkcast       Ljava/util/Map;
        //    13: astore_3       
        //    14: iload_2         /* key */
        //    15: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    18: astore          key$iv
        //    20: iconst_0       
        //    21: istore          $i$f$getOrPut
        //    23: aload_3         /* $this$getOrPut$iv */
        //    24: aload           key$iv
        //    26: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    31: astore          value$iv
        //    33: aload           value$iv
        //    35: ifnonnull       89
        //    38: iconst_0       
        //    39: istore          $i$a$-getOrPut-ThemeReader$string$2
        //    41: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString;
        //    44: dup            
        //    45: iload_2         /* key */
        //    46: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString.<init>:(I)V
        //    49: astore          8
        //    51: aload           8
        //    53: astore          it
        //    55: iconst_0       
        //    56: istore          $i$a$-also-ThemeReader$string$2$1
        //    58: aload           it
        //    60: aload_1         /* default */
        //    61: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString.setValue:(Ljava/lang/Object;)V
        //    64: nop            
        //    65: aload           8
        //    67: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    70: nop            
        //    71: astore          answer$iv
        //    73: aload_3         /* $this$getOrPut$iv */
        //    74: aload           key$iv
        //    76: aload           answer$iv
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: aload           answer$iv
        //    86: goto            91
        //    89: aload           value$iv
        //    91: nop            
        //    92: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString;
        //    95: areturn        
        //    StackMapTable: 00 02 FF 00 59 00 07 07 00 02 07 00 55 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeBoolean bool(final boolean default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_3       
        //     8: iload_2         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore          key$iv
        //    14: iconst_0       
        //    15: istore          $i$f$getOrPut
        //    17: aload_3         /* $this$getOrPut$iv */
        //    18: aload           key$iv
        //    20: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: astore          value$iv
        //    27: aload           value$iv
        //    29: ifnonnull       109
        //    32: iconst_0       
        //    33: istore          $i$a$-getOrPut-ThemeReader$bool$1
        //    35: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean;
        //    38: dup            
        //    39: iload_2         /* key */
        //    40: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean.<init>:(I)V
        //    43: astore          8
        //    45: aload           8
        //    47: astore          it
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ThemeReader$bool$1$1
        //    52: aload           it
        //    54: iload_1         /* default */
        //    55: invokestatic    java/lang/Boolean.valueOf:(Z)Ljava/lang/Boolean;
        //    58: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean.setValue:(Ljava/lang/Object;)V
        //    61: iload_2         /* key */
        //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    65: astore          11
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    71: checkcast       Ljava/util/Map;
        //    74: aload           11
        //    76: aload           it
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: nop            
        //    85: aload           8
        //    87: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    90: nop            
        //    91: astore          answer$iv
        //    93: aload_3         /* $this$getOrPut$iv */
        //    94: aload           key$iv
        //    96: aload           answer$iv
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload           answer$iv
        //   106: goto            111
        //   109: aload           value$iv
        //   111: nop            
        //   112: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean;
        //   115: areturn        
        //    StackMapTable: 00 02 FF 00 6D 00 07 07 00 02 01 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeFloat float(final float default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_3       
        //     8: iload_2         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore          key$iv
        //    14: iconst_0       
        //    15: istore          $i$f$getOrPut
        //    17: aload_3         /* $this$getOrPut$iv */
        //    18: aload           key$iv
        //    20: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: astore          value$iv
        //    27: aload           value$iv
        //    29: ifnonnull       109
        //    32: iconst_0       
        //    33: istore          $i$a$-getOrPut-ThemeReader$float$1
        //    35: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat;
        //    38: dup            
        //    39: iload_2         /* key */
        //    40: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat.<init>:(I)V
        //    43: astore          8
        //    45: aload           8
        //    47: astore          it
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ThemeReader$float$1$1
        //    52: aload           it
        //    54: fload_1         /* default */
        //    55: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
        //    58: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat.setValue:(Ljava/lang/Object;)V
        //    61: iload_2         /* key */
        //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    65: astore          11
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    71: checkcast       Ljava/util/Map;
        //    74: aload           11
        //    76: aload           it
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: nop            
        //    85: aload           8
        //    87: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    90: nop            
        //    91: astore          answer$iv
        //    93: aload_3         /* $this$getOrPut$iv */
        //    94: aload           key$iv
        //    96: aload           answer$iv
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload           answer$iv
        //   106: goto            111
        //   109: aload           value$iv
        //   111: nop            
        //   112: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat;
        //   115: areturn        
        //    StackMapTable: 00 02 FF 00 6D 00 07 07 00 02 02 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeSize size(final float default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_3       
        //     8: iload_2         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore          key$iv
        //    14: iconst_0       
        //    15: istore          $i$f$getOrPut
        //    17: aload_3         /* $this$getOrPut$iv */
        //    18: aload           key$iv
        //    20: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: astore          value$iv
        //    27: aload           value$iv
        //    29: ifnonnull       109
        //    32: iconst_0       
        //    33: istore          $i$a$-getOrPut-ThemeReader$size$1
        //    35: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize;
        //    38: dup            
        //    39: iload_2         /* key */
        //    40: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize.<init>:(I)V
        //    43: astore          8
        //    45: aload           8
        //    47: astore          it
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ThemeReader$size$1$1
        //    52: aload           it
        //    54: fload_1         /* default */
        //    55: invokestatic    java/lang/Float.valueOf:(F)Ljava/lang/Float;
        //    58: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize.setValue:(Ljava/lang/Object;)V
        //    61: iload_2         /* key */
        //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    65: astore          11
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    71: checkcast       Ljava/util/Map;
        //    74: aload           11
        //    76: aload           it
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: nop            
        //    85: aload           8
        //    87: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    90: nop            
        //    91: astore          answer$iv
        //    93: aload_3         /* $this$getOrPut$iv */
        //    94: aload           key$iv
        //    96: aload           answer$iv
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload           answer$iv
        //   106: goto            111
        //   109: aload           value$iv
        //   111: nop            
        //   112: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize;
        //   115: areturn        
        //    StackMapTable: 00 02 FF 00 6D 00 07 07 00 02 02 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeInt int(final int default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_3       
        //     8: iload_2         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore          key$iv
        //    14: iconst_0       
        //    15: istore          $i$f$getOrPut
        //    17: aload_3         /* $this$getOrPut$iv */
        //    18: aload           key$iv
        //    20: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: astore          value$iv
        //    27: aload           value$iv
        //    29: ifnonnull       109
        //    32: iconst_0       
        //    33: istore          $i$a$-getOrPut-ThemeReader$int$1
        //    35: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;
        //    38: dup            
        //    39: iload_2         /* key */
        //    40: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt.<init>:(I)V
        //    43: astore          8
        //    45: aload           8
        //    47: astore          it
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ThemeReader$int$1$1
        //    52: aload           it
        //    54: iload_1         /* default */
        //    55: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    58: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt.setValue:(Ljava/lang/Object;)V
        //    61: iload_2         /* key */
        //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    65: astore          11
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    71: checkcast       Ljava/util/Map;
        //    74: aload           11
        //    76: aload           it
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: nop            
        //    85: aload           8
        //    87: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    90: nop            
        //    91: astore          answer$iv
        //    93: aload_3         /* $this$getOrPut$iv */
        //    94: aload           key$iv
        //    96: aload           answer$iv
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload           answer$iv
        //   106: goto            111
        //   109: aload           value$iv
        //   111: nop            
        //   112: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;
        //   115: areturn        
        //    StackMapTable: 00 02 FF 00 6D 00 07 07 00 02 01 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    @NotNull
    public final ThemeAttributeInt colorRes(final int default, @StyleableRes final int key) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //     4: checkcast       Ljava/util/Map;
        //     7: astore_3       
        //     8: iload_2         /* key */
        //     9: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    12: astore          key$iv
        //    14: iconst_0       
        //    15: istore          $i$f$getOrPut
        //    17: aload_3         /* $this$getOrPut$iv */
        //    18: aload           key$iv
        //    20: invokeinterface java/util/Map.get:(Ljava/lang/Object;)Ljava/lang/Object;
        //    25: astore          value$iv
        //    27: aload           value$iv
        //    29: ifnonnull       109
        //    32: iconst_0       
        //    33: istore          $i$a$-getOrPut-ThemeReader$colorRes$1
        //    35: new             Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;
        //    38: dup            
        //    39: iload_2         /* key */
        //    40: invokespecial   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt.<init>:(I)V
        //    43: astore          8
        //    45: aload           8
        //    47: astore          it
        //    49: iconst_0       
        //    50: istore          $i$a$-also-ThemeReader$colorRes$1$1
        //    52: aload           it
        //    54: iload_1         /* default */
        //    55: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    58: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt.setValue:(Ljava/lang/Object;)V
        //    61: iload_2         /* key */
        //    62: invokestatic    java/lang/Integer.valueOf:(I)Ljava/lang/Integer;
        //    65: astore          11
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    71: checkcast       Ljava/util/Map;
        //    74: aload           11
        //    76: aload           it
        //    78: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //    83: pop            
        //    84: nop            
        //    85: aload           8
        //    87: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //    90: nop            
        //    91: astore          answer$iv
        //    93: aload_3         /* $this$getOrPut$iv */
        //    94: aload           key$iv
        //    96: aload           answer$iv
        //    98: invokeinterface java/util/Map.put:(Ljava/lang/Object;Ljava/lang/Object;)Ljava/lang/Object;
        //   103: pop            
        //   104: aload           answer$iv
        //   106: goto            111
        //   109: aload           value$iv
        //   111: nop            
        //   112: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;
        //   115: areturn        
        //    StackMapTable: 00 02 FF 00 6D 00 07 07 00 02 01 01 07 00 25 07 00 27 01 07 00 04 00 00 41 07 00 04
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
    
    public final void setDefaultValue(@StyleableRes final int key, @Nullable final Object value) {
        final ThemeAttribute themeAttribute = this.themeAttributes.get(key);
        Unit instance;
        if (themeAttribute != null) {
            themeAttribute.setDefault(value);
            instance = Unit.INSTANCE;
        }
        else {
            instance = null;
        }
        if (instance == null) {
            throw new RuntimeException("This attribute is not bound, to this ThemeReader.");
        }
    }
    
    public final void setDefaultValue(@NotNull final Pair<Integer, ?>... pairs) {
        Intrinsics.checkNotNullParameter((Object)pairs, "pairs");
        final Object[] $this$forEach$iv = pairs;
        final int $i$f$forEach = 0;
        for (int i = 0; i < $this$forEach$iv.length; ++i) {
            final Pair it;
            final Object element$iv = it = (Pair)$this$forEach$iv[i];
            final int n = 0;
            this.setDefaultValue(((Number)it.getFirst()).intValue(), it.getSecond());
        }
    }
    
    public final void load(@NotNull final Context context, @Nullable final AttributeSet set, @AttrRes final int defStyleAttr, @StyleRes final int defStyleRes) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "context"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* context */
        //     7: invokevirtual   android/content/Context.getTheme:()Landroid/content/res/Resources$Theme;
        //    10: dup            
        //    11: ldc             "context.theme"
        //    13: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    16: astore          5
        //    18: aload_0         /* this */
        //    19: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.attrs:[I
        //    22: astore          attrs$iv
        //    24: iconst_0       
        //    25: istore          $i$f$readStyledAttributes
        //    27: aload           $this$readStyledAttributes$iv
        //    29: aload_2         /* set */
        //    30: aload           attrs$iv
        //    32: iload_3         /* defStyleAttr */
        //    33: iload           defStyleRes
        //    35: invokevirtual   android/content/res/Resources$Theme.obtainStyledAttributes:(Landroid/util/AttributeSet;[III)Landroid/content/res/TypedArray;
        //    38: astore          8
        //    40: aload           8
        //    42: astore          it$iv
        //    44: iconst_0       
        //    45: istore          $i$a$-also-ThemeExtentionsKt$readStyledAttributes$1$iv
        //    47: new             Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;
        //    50: dup            
        //    51: aload           $this$readStyledAttributes$iv
        //    53: aload           it$iv
        //    55: ldc             "it"
        //    57: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    60: aload           it$iv
        //    62: invokespecial   ly/img/android/pesdk/kotlin_extension/ExtendedTypedArray.<init>:(Landroid/content/res/Resources$Theme;Landroid/content/res/TypedArray;)V
        //    65: astore          typedArray
        //    67: iconst_0       
        //    68: istore          $i$a$-readStyledAttributes-ThemeReader$load$1
        //    70: aload_0         /* this */
        //    71: getfield        ly/img/android/pesdk/kotlin_extension/ThemeReader.themeAttributes:Ljava/util/HashMap;
        //    74: invokevirtual   java/util/HashMap.values:()Ljava/util/Collection;
        //    77: dup            
        //    78: ldc             "themeAttributes.values"
        //    80: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    83: checkcast       Ljava/lang/Iterable;
        //    86: astore          $this$forEach$iv
        //    88: iconst_0       
        //    89: istore          $i$f$forEach
        //    91: aload           $this$forEach$iv
        //    93: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //    98: astore          15
        //   100: aload           15
        //   102: invokeinterface java/util/Iterator.hasNext:()Z
        //   107: ifeq            140
        //   110: aload           15
        //   112: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   117: astore          element$iv
        //   119: aload           element$iv
        //   121: checkcast       Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;
        //   124: astore          themeAttribute
        //   126: iconst_0       
        //   127: istore          $i$a$-forEach-ThemeReader$load$1$1
        //   129: aload           themeAttribute
        //   131: aload           typedArray
        //   133: invokevirtual   ly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute.readAttribute:(Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;)V
        //   136: nop            
        //   137: goto            100
        //   140: nop            
        //   141: nop            
        //   142: aload           it$iv
        //   144: invokevirtual   android/content/res/TypedArray.recycle:()V
        //   147: nop            
        //   148: nop            
        //   149: nop            
        //   150: return         
        //    StackMapTable: 00 02 FF 00 64 00 10 07 00 02 07 00 C2 07 01 0A 01 01 07 00 CD 07 01 0B 01 07 00 F2 07 00 F2 01 07 00 D3 01 07 00 DF 01 07 00 E5 00 00 27
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
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0016\u0018\u00002\u00020\u0001B\u000f\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\u00122\b\u0010\f\u001a\u0004\u0018\u00010\u0001R\u001a\u0010\u0005\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0001X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u0016" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "", "key", "", "(I)V", "isStyled", "", "()Z", "setStyled", "(Z)V", "getKey", "()I", "value", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setDefault", "pesdk-backend-core_release" })
    public static class ThemeAttribute
    {
        private final int key;
        private boolean isStyled;
        @Nullable
        private Object value;
        
        public ThemeAttribute(@StyleableRes final int key) {
            this.key = key;
        }
        
        public final int getKey() {
            return this.key;
        }
        
        public final boolean isStyled() {
            return this.isStyled;
        }
        
        public final void setStyled(final boolean <set-?>) {
            this.isStyled = <set-?>;
        }
        
        @Nullable
        public final Object getValue() {
            return this.value;
        }
        
        public final void setValue(@Nullable final Object <set-?>) {
            this.value = <set-?>;
        }
        
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            this.isStyled = extendedTypedArray.exists(this.key);
        }
        
        public final void setDefault(@Nullable final Object value) {
            if (!this.isStyled) {
                this.value = value;
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J'\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeBoolean;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeBoolean extends ThemeAttribute
    {
        public ThemeAttributeBoolean(final int key) {
            super(key);
        }
        
        public final boolean getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            return (boolean)value;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final boolean value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            final int key = ((ThemeAttribute)this).getKey();
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Boolean");
            }
            ((ThemeAttribute)this).setValue(extendedTypedArray.getBoolean(key, (boolean)value));
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J!\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J)\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0006H\u0086\u0002¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeOptionalString;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeOptionalString extends ThemeAttribute
    {
        public ThemeAttributeOptionalString(final int key) {
            super(key);
        }
        
        @Nullable
        public final String getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            return (value instanceof String) ? ((String)value) : null;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, @Nullable final String value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            Object value;
            if ((value = extendedTypedArray.getString(((ThemeAttribute)this).getKey())) == null) {
                value = ((ThemeAttribute)this).getValue();
            }
            ((ThemeAttribute)this).setValue(value);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J'\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeString;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeString extends ThemeAttribute
    {
        public ThemeAttributeString(final int key) {
            super(key);
        }
        
        @NotNull
        public final String getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            return (String)value;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, @NotNull final String value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            Intrinsics.checkNotNullParameter((Object)value, "value");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            final int key = ((ThemeAttribute)this).getKey();
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.String");
            }
            ((ThemeAttribute)this).setValue(extendedTypedArray.getString(key, (String)value));
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J'\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeFloat;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeFloat extends ThemeAttribute
    {
        public ThemeAttributeFloat(final int key) {
            super(key);
        }
        
        public final float getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            return (float)value;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final float value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            final int key = ((ThemeAttribute)this).getKey();
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            ((ThemeAttribute)this).setValue(extendedTypedArray.getFloat(key, (float)value));
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0086\u0002J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J'\u0010\u000f\u001a\u00020\f2\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\u0006\u0010\u0010\u001a\u00020\u0006H\u0086\u0002¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeSize;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeSize extends ThemeAttribute
    {
        public ThemeAttributeSize(final int key) {
            super(key);
        }
        
        public final float getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            return (float)value;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final float value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            final int key = ((ThemeAttribute)this).getKey();
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
            ((ThemeAttribute)this).setValue(extendedTypedArray.getSize(key, (float)value));
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001f\u0010\u0005\u001a\u00020\u00032\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\tH\u0086\u0002J\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J'\u0010\u000e\u001a\u00020\u000b2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\n\u0010\b\u001a\u0006\u0012\u0002\b\u00030\t2\u0006\u0010\u000f\u001a\u00020\u0003H\u0086\u0002¨\u0006\u0010" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttributeInt;", "Lly/img/android/pesdk/kotlin_extension/ThemeReader$ThemeAttribute;", "key", "", "(I)V", "getValue", "thisRef", "", "property", "Lkotlin/reflect/KProperty;", "readAttribute", "", "extendedTypedArray", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "setValue", "value", "pesdk-backend-core_release" })
    public static final class ThemeAttributeInt extends ThemeAttribute
    {
        public ThemeAttributeInt(final int key) {
            super(key);
        }
        
        public final int getValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            return (int)value;
        }
        
        public final void setValue(@Nullable final Object thisRef, @NotNull final KProperty<?> property, final int value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            ((ThemeAttribute)this).setValue(value);
        }
        
        @Override
        public void readAttribute(@NotNull final ExtendedTypedArray extendedTypedArray) {
            Intrinsics.checkNotNullParameter((Object)extendedTypedArray, "extendedTypedArray");
            super.readAttribute(extendedTypedArray);
            final int key = ((ThemeAttribute)this).getKey();
            final Object value = ((ThemeAttribute)this).getValue();
            if (value == null) {
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
            }
            ((ThemeAttribute)this).setValue(extendedTypedArray.getInt(key, (int)value));
        }
    }
}
