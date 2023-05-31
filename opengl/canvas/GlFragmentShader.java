// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import java.io.IOException;
import kotlin.text.StringsKt;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import androidx.annotation.RawRes;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.opengl.textures.GlVirtualMipMapTexture;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\r\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B/\b\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tB+\b\u0016\u0012\u0006\u0010\n\u001a\u00020\u0000\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000bB-\b\u0007\u0012\u0006\u0010\f\u001a\u00020\r\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\u000eJ\u000e\u0010\u0013\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rJ\u001e\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00072\u0006\u0010\u0017\u001a\u00020\u0003J\u0010\u0010\u0018\u001a\u00020\r2\u0006\u0010\u0014\u001a\u00020\rH\u0014R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R\u000e\u0010\b\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a" }, d2 = { "Lly/img/android/opengl/canvas/GlFragmentShader;", "Lly/img/android/opengl/canvas/GlAbstractShader;", "res", "", "useDynamicInput", "", "virtualTextureType", "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;", "virtualLodCount", "(IZLly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;I)V", "shader", "(Lly/img/android/opengl/canvas/GlFragmentShader;ZLly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;I)V", "rawSourceCode", "", "(Ljava/lang/String;ZLly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;I)V", "getUseDynamicInput", "()Z", "setUseDynamicInput", "(Z)V", "addExternalTextureSupport", "sourceCode", "addVirtualTextureSupport", "type", "lodCount", "prepareSourceCode", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public final class GlFragmentShader extends GlAbstractShader
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private String rawSourceCode;
    private boolean useDynamicInput;
    @NotNull
    private final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType;
    private final int virtualLodCount;
    @NotNull
    private static final String TARGET_PLACEHOLDER = "#INPUT_TYPE";
    @NotNull
    private static final String GL_OES_REQUIRE = "#extension GL_OES_EGL_image_external : require";
    
    @JvmOverloads
    public GlFragmentShader(@NotNull final String rawSourceCode, final boolean useDynamicInput, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType, final int virtualLodCount) {
        Intrinsics.checkNotNullParameter((Object)rawSourceCode, "rawSourceCode");
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        super(rawSourceCode, 35632);
        this.rawSourceCode = rawSourceCode;
        this.useDynamicInput = useDynamicInput;
        this.virtualTextureType = virtualTextureType;
        this.virtualLodCount = virtualLodCount;
    }
    
    public final boolean getUseDynamicInput() {
        return this.useDynamicInput;
    }
    
    public final void setUseDynamicInput(final boolean <set-?>) {
        this.useDynamicInput = <set-?>;
    }
    
    @JvmOverloads
    public GlFragmentShader(@RawRes final int res, final boolean useDynamicInput, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType, final int virtualLodCount) {
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        this(GlFragmentShader.Companion.readRawSource(res), useDynamicInput, virtualTextureType, virtualLodCount);
    }
    
    public GlFragmentShader(@NotNull final GlFragmentShader shader, final boolean useDynamicInput, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType, final int virtualLodCount) {
        Intrinsics.checkNotNullParameter((Object)shader, "shader");
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        this(shader.rawSourceCode, useDynamicInput, virtualTextureType, virtualLodCount);
    }
    
    @NotNull
    @Override
    protected String prepareSourceCode(@NotNull final String sourceCode) {
        Intrinsics.checkNotNullParameter((Object)sourceCode, "sourceCode");
        String newSourceCode = super.prepareSourceCode(sourceCode);
        newSourceCode = this.addExternalTextureSupport(newSourceCode);
        newSourceCode = this.addVirtualTextureSupport(newSourceCode, this.virtualTextureType, TypeExtensionsKt.butMin(this.virtualLodCount, 1));
        return newSourceCode;
    }
    
    @NotNull
    public final String addExternalTextureSupport(@NotNull final String sourceCode) {
        Intrinsics.checkNotNullParameter((Object)sourceCode, "sourceCode");
        String s2;
        if (this.useDynamicInput) {
            final StringBuilder sb = new StringBuilder();
            final String s = "#extension GL_OES_EGL_image_external : require\n";
            final StringBuilder sb2 = sb;
            final int n = 0;
            final boolean contains$default = StringsKt.contains$default((CharSequence)sourceCode, (CharSequence)"#extension GL_OES_EGL_image_external : require", false, 2, (Object)null);
            final StringBuilder sb3 = sb2;
            String str = contains$default ? null : s;
            if (str == null) {
                str = "";
            }
            s2 = sb3.append(str).append(StringsKt.replace$default(GlFragmentShader.Companion.removeMarker(sourceCode), "#INPUT_TYPE", "samplerExternalOES", false, 4, (Object)null)).toString();
        }
        else {
            s2 = StringsKt.replace$default(GlFragmentShader.Companion.removeMarker(sourceCode), "#INPUT_TYPE", "sampler2D", false, 4, (Object)null);
        }
        return s2;
    }
    
    @NotNull
    public final String addVirtualTextureSupport(@NotNull final String sourceCode, @NotNull final GlVirtualMipMapTexture.VirtualTextureType type, final int lodCount) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "sourceCode"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* type */
        //     7: ldc             "type"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aconst_null    
        //    13: astore          extensionSourceCode
        //    15: new             Ljava/lang/StringBuilder;
        //    18: dup            
        //    19: invokespecial   java/lang/StringBuilder.<init>:()V
        //    22: ldc             "\n            uniform sampler2D tex_VN_["
        //    24: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    27: iload_3         /* lodCount */
        //    28: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    31: ldc             "];\n            uniform ivec4 lodRect_VN_["
        //    33: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    36: iload_3         /* lodCount */
        //    37: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //    40: ldc             "];\n\n            vec2 textureMap_VN_(vec2 cord, int lod) {\n                vec2 res = vec2(lodRect_VN_[lod].xy);\n                vec2 visibleSize = vec2(lodRect_VN_[lod].xy - lodRect_VN_[lod].w);\n                vec2 padding = vec2(lodRect_VN_[lod].z);\n                return (cord * visibleSize + padding) / vec2(res);\n            }\n        "
        //    42: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    45: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //    48: invokestatic    kotlin/text/StringsKt.trimIndent:(Ljava/lang/String;)Ljava/lang/String;
        //    51: astore          extensionSourceCode
        //    53: iload_3         /* lodCount */
        //    54: iconst_1       
        //    55: isub           
        //    56: istore          maxLodIndex
        //    58: new             Ljava/lang/StringBuilder;
        //    61: dup            
        //    62: invokespecial   java/lang/StringBuilder.<init>:()V
        //    65: aload           extensionSourceCode
        //    67: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //    70: bipush          10
        //    72: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //    75: aload_2         /* type */
        //    76: getstatic       ly/img/android/opengl/canvas/GlFragmentShader$WhenMappings.$EnumSwitchMapping$0:[I
        //    79: swap           
        //    80: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType.ordinal:()I
        //    83: iaload         
        //    84: tableswitch {
        //                2: 112
        //                3: 299
        //                4: 327
        //          default: 332
        //        }
        //   112: new             Ljava/lang/StringBuilder;
        //   115: dup            
        //   116: invokespecial   java/lang/StringBuilder.<init>:()V
        //   119: ldc             "\n                vec4 texture2DMap_VN_(vec2 cord, int lod) {\n                    if (lod == 0) {\n                        return texture2D(tex_VN_[0], cord);\n                    }\n                "
        //   121: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   124: new             Lkotlin/ranges/IntRange;
        //   127: dup            
        //   128: iconst_1       
        //   129: iload           maxLodIndex
        //   131: invokespecial   kotlin/ranges/IntRange.<init>:(II)V
        //   134: checkcast       Ljava/lang/Iterable;
        //   137: astore          8
        //   139: ldc             ""
        //   141: astore          9
        //   143: astore          19
        //   145: astore          18
        //   147: iconst_0       
        //   148: istore          $i$f$fold
        //   150: aload           initial$iv
        //   152: astore          accumulator$iv
        //   154: aload           $this$fold$iv
        //   156: invokeinterface java/lang/Iterable.iterator:()Ljava/util/Iterator;
        //   161: astore          12
        //   163: aload           12
        //   165: invokeinterface java/util/Iterator.hasNext:()Z
        //   170: ifeq            255
        //   173: aload           12
        //   175: checkcast       Lkotlin/collections/IntIterator;
        //   178: invokevirtual   kotlin/collections/IntIterator.nextInt:()I
        //   181: istore          element$iv
        //   183: aload           accumulator$iv
        //   185: iload           element$iv
        //   187: istore          14
        //   189: astore          sum
        //   191: iconst_0       
        //   192: istore          $i$a$-fold-GlFragmentShader$addVirtualTextureSupport$1
        //   194: new             Ljava/lang/StringBuilder;
        //   197: dup            
        //   198: invokespecial   java/lang/StringBuilder.<init>:()V
        //   201: aload           sum
        //   203: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   206: new             Ljava/lang/StringBuilder;
        //   209: dup            
        //   210: invokespecial   java/lang/StringBuilder.<init>:()V
        //   213: ldc             "\n                    else if (lod == "
        //   215: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   218: iload           i
        //   220: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   223: ldc             ") {\n                        return texture2D(tex_VN_["
        //   225: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   228: iload           i
        //   230: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   233: ldc             "], cord);\n                    }\n                "
        //   235: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   238: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   241: invokestatic    kotlin/text/StringsKt.trimIndent:(Ljava/lang/String;)Ljava/lang/String;
        //   244: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   247: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   250: astore          accumulator$iv
        //   252: goto            163
        //   255: aload           accumulator$iv
        //   257: astore          20
        //   259: aload           18
        //   261: aload           19
        //   263: aload           20
        //   265: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   268: ldc             "\n                    else {\n                        return texture2D(tex_VN_["
        //   270: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   273: iload           maxLodIndex
        //   275: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   278: ldc             "], cord, float(lod - "
        //   280: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   283: iload           maxLodIndex
        //   285: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   288: ldc             "));\n                    }\n                }\n                "
        //   290: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   293: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   296: goto            340
        //   299: new             Ljava/lang/StringBuilder;
        //   302: dup            
        //   303: invokespecial   java/lang/StringBuilder.<init>:()V
        //   306: ldc             "\n                vec4 texture2DMap_VN_(vec2 cord, int lod) {\n                    int index = clamp(lod, 0, "
        //   308: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   311: iload           maxLodIndex
        //   313: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   316: ldc             ");\n                    return texture2D(tex_VN_[index], cord, lod - index);\n                }\n            "
        //   318: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   321: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   324: goto            340
        //   327: ldc             "\n                vec4 texture2DMap_VN_(vec2 cord, float lod) {\n                    return texture2D(tex_VN_[0], cord, lod);\n                }\n            "
        //   329: goto            340
        //   332: new             Lkotlin/NoWhenBranchMatchedException;
        //   335: dup            
        //   336: invokespecial   kotlin/NoWhenBranchMatchedException.<init>:()V
        //   339: athrow         
        //   340: invokestatic    kotlin/text/StringsKt.trimIndent:(Ljava/lang/String;)Ljava/lang/String;
        //   343: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   346: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   349: astore          extensionSourceCode
        //   351: new             Ljava/lang/StringBuilder;
        //   354: dup            
        //   355: invokespecial   java/lang/StringBuilder.<init>:()V
        //   358: aload           extensionSourceCode
        //   360: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   363: bipush          10
        //   365: invokevirtual   java/lang/StringBuilder.append:(C)Ljava/lang/StringBuilder;
        //   368: aload_2         /* type */
        //   369: getstatic       ly/img/android/opengl/canvas/GlFragmentShader$WhenMappings.$EnumSwitchMapping$0:[I
        //   372: swap           
        //   373: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType.ordinal:()I
        //   376: iaload         
        //   377: tableswitch {
        //                2: 404
        //                3: 404
        //                4: 442
        //          default: 447
        //        }
        //   404: new             Ljava/lang/StringBuilder;
        //   407: dup            
        //   408: invokespecial   java/lang/StringBuilder.<init>:()V
        //   411: ldc             "\n                vec4 textureVirtualMipMap2D_VN_(vec2 cord, float lod) {\n                    mediump int highLod = int(lod);\n                    mediump int lowLod = int(ceil(lod));\n                    mediump int highLodCordIndex = int(min(lod, float("
        //   413: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   416: iload           maxLodIndex
        //   418: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   421: ldc             ")));\n                    mediump int lowLodCordIndex = int(min(ceil(lod), float("
        //   423: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   426: iload           maxLodIndex
        //   428: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   431: ldc             ")));\n\n                    mediump vec4 highLodColor = texture2DMap_VN_(textureMap_VN_(cord.xy, highLodCordIndex), highLod);\n                    mediump vec4 lowLodColor =  texture2DMap_VN_(textureMap_VN_(cord.xy, lowLodCordIndex), lowLod);\n                    return clamp(mix(highLodColor, lowLodColor, fract(lod)), 0.0, 1.0);\n                }\n            "
        //   433: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   436: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   439: goto            455
        //   442: ldc             "\n                vec4 textureVirtualMipMap2D_VN_(vec2 cord, float lod) {\n                    return clamp(texture2DMap_VN_(textureMap_VN_(cord.xy, 0), lod), 0.0, 1.0);\n                }\n            "
        //   444: goto            455
        //   447: new             Lkotlin/NoWhenBranchMatchedException;
        //   450: dup            
        //   451: invokespecial   kotlin/NoWhenBranchMatchedException.<init>:()V
        //   454: athrow         
        //   455: invokestatic    kotlin/text/StringsKt.trimIndent:(Ljava/lang/String;)Ljava/lang/String;
        //   458: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   461: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   464: astore          extensionSourceCode
        //   466: aconst_null    
        //   467: astore          newSourceCode
        //   469: aload_1         /* sourceCode */
        //   470: astore          newSourceCode
        //   472: new             Lkotlin/text/Regex;
        //   475: dup            
        //   476: ldc             "virtualMipMap2D#([^#]*)#"
        //   478: invokespecial   kotlin/text/Regex.<init>:(Ljava/lang/String;)V
        //   481: aload_1         /* sourceCode */
        //   482: checkcast       Ljava/lang/CharSequence;
        //   485: iconst_0       
        //   486: iconst_2       
        //   487: aconst_null    
        //   488: invokestatic    kotlin/text/Regex.findAll$default:(Lkotlin/text/Regex;Ljava/lang/CharSequence;IILjava/lang/Object;)Lkotlin/sequences/Sequence;
        //   491: astore          $this$forEach$iv
        //   493: iconst_0       
        //   494: istore          $i$f$forEach
        //   496: aload           $this$forEach$iv
        //   498: invokeinterface kotlin/sequences/Sequence.iterator:()Ljava/util/Iterator;
        //   503: astore          9
        //   505: aload           9
        //   507: invokeinterface java/util/Iterator.hasNext:()Z
        //   512: ifeq            636
        //   515: aload           9
        //   517: invokeinterface java/util/Iterator.next:()Ljava/lang/Object;
        //   522: astore          element$iv
        //   524: aload           element$iv
        //   526: checkcast       Lkotlin/text/MatchResult;
        //   529: astore          match
        //   531: iconst_0       
        //   532: istore          $i$a$-forEach-GlFragmentShader$addVirtualTextureSupport$2
        //   534: aload           match
        //   536: invokeinterface kotlin/text/MatchResult.getGroupValues:()Ljava/util/List;
        //   541: iconst_1       
        //   542: invokestatic    kotlin/collections/CollectionsKt.getOrNull:(Ljava/util/List;I)Ljava/lang/Object;
        //   545: checkcast       Ljava/lang/String;
        //   548: dup            
        //   549: ifnull          630
        //   552: astore          paramName
        //   554: iconst_0       
        //   555: istore          $i$a$-let-GlFragmentShader$addVirtualTextureSupport$2$1
        //   557: nop            
        //   558: aload_1         /* sourceCode */
        //   559: aload           match
        //   561: invokeinterface kotlin/text/MatchResult.getGroupValues:()Ljava/util/List;
        //   566: iconst_0       
        //   567: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   572: checkcast       Ljava/lang/String;
        //   575: aload           extensionSourceCode
        //   577: ldc             "_VN_"
        //   579: aload           paramName
        //   581: iconst_0       
        //   582: iconst_4       
        //   583: aconst_null    
        //   584: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
        //   587: iconst_0       
        //   588: iconst_4       
        //   589: aconst_null    
        //   590: invokestatic    kotlin/text/StringsKt.replace$default:(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZILjava/lang/Object;)Ljava/lang/String;
        //   593: checkcast       Ljava/lang/CharSequence;
        //   596: astore          15
        //   598: new             Lkotlin/text/Regex;
        //   601: dup            
        //   602: ldc_w           "textureVirtualMipMap2D[ ]*\\(([^,]*),([^;]*)"
        //   605: invokespecial   kotlin/text/Regex.<init>:(Ljava/lang/String;)V
        //   608: astore          16
        //   610: ldc_w           "textureVirtualMipMap2D$1($2"
        //   613: astore          17
        //   615: aload           16
        //   617: aload           15
        //   619: aload           17
        //   621: invokevirtual   kotlin/text/Regex.replace:(Ljava/lang/CharSequence;Ljava/lang/String;)Ljava/lang/String;
        //   624: astore          newSourceCode
        //   626: nop            
        //   627: goto            632
        //   630: pop            
        //   631: nop            
        //   632: nop            
        //   633: goto            505
        //   636: nop            
        //   637: aload           newSourceCode
        //   639: areturn        
        //    StackMapTable: 00 0F FF 00 70 00 06 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 00 01 07 00 5F FF 00 32 00 14 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 00 00 07 00 AE 07 00 8A 01 07 00 8A 07 00 B4 00 00 00 00 00 07 00 5F 07 00 5F 00 00 FB 00 5B FF 00 2B 00 06 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 00 01 07 00 5F 5B 07 00 5F 44 07 00 5F FF 00 07 00 06 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 00 02 07 00 5F 07 00 8A F7 00 3F 07 00 5F 65 07 00 5F 44 07 00 5F FF 00 07 00 06 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 00 02 07 00 5F 07 00 8A FF 00 31 00 0A 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 07 00 8A 07 00 E6 01 07 00 B4 00 00 FF 00 7C 00 0D 07 00 02 07 00 8A 07 00 29 01 07 00 8A 01 07 00 8A 07 00 E6 01 07 00 B4 07 01 1E 07 00 ED 01 00 01 07 00 8A 01 F8 00 03
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
    
    @JvmOverloads
    public GlFragmentShader(@NotNull final String rawSourceCode, final boolean useDynamicInput, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType) {
        Intrinsics.checkNotNullParameter((Object)rawSourceCode, "rawSourceCode");
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        this(rawSourceCode, useDynamicInput, virtualTextureType, 0, 8, null);
    }
    
    @JvmOverloads
    public GlFragmentShader(@NotNull final String rawSourceCode, final boolean useDynamicInput) {
        Intrinsics.checkNotNullParameter((Object)rawSourceCode, "rawSourceCode");
        this(rawSourceCode, useDynamicInput, null, 0, 12, null);
    }
    
    @JvmOverloads
    public GlFragmentShader(@NotNull final String rawSourceCode) {
        Intrinsics.checkNotNullParameter((Object)rawSourceCode, "rawSourceCode");
        this(rawSourceCode, false, null, 0, 14, null);
    }
    
    @JvmOverloads
    public GlFragmentShader(@RawRes final int res, final boolean useDynamicInput, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType) {
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        this(res, useDynamicInput, virtualTextureType, 0, 8, null);
    }
    
    @JvmOverloads
    public GlFragmentShader(@RawRes final int res, final boolean useDynamicInput) {
        this(res, useDynamicInput, null, 0, 12, null);
    }
    
    @JvmOverloads
    public GlFragmentShader(@RawRes final int res) {
        this(res, false, null, 0, 14, null);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0002J\u0012\u0010\b\u001a\u00020\u00042\b\b\u0001\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0004H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lly/img/android/opengl/canvas/GlFragmentShader$Companion;", "", "()V", "GL_OES_REQUIRE", "", "TARGET_PLACEHOLDER", "hasHighpSupport", "", "readRawSource", "rawResource", "", "removeMarker", "sourceCode", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        private final String removeMarker(final String sourceCode) {
            return StringsKt.replace$default(StringsKt.replace$default(StringsKt.replace$default(sourceCode, "#ABSOLUTE ", "", false, 4, (Object)null), "#RELATIVE ", "", false, 4, (Object)null), "#RELATIVE_TO_CHUNK_ASPEKT", "", false, 4, (Object)null);
        }
        
        private final String readRawSource(@RawRes final int rawResource) {
            String stringResource;
            try {
                stringResource = GlAbstractShader.Companion.getStringResource(rawResource);
            }
            catch (IOException e) {
                e.printStackTrace();
                stringResource = "";
            }
            return stringResource;
        }
        
        private final boolean hasHighpSupport() {
            return false;
        }
    }
}
