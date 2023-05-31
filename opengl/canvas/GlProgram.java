// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import ly.img.android.opengl.EGLLogWrapper;
import kotlin.jvm.internal.DefaultConstructorMarker;
import android.opengl.GLException;
import kotlin.jvm.JvmStatic;
import android.util.Log;
import kotlin.jvm.JvmOverloads;
import android.opengl.GLES20;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.Lazy;
import ly.img.android.opengl.textures.GlVirtualMipMapTexture;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import java.util.HashMap;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0086\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\t\b\u0016\u0018\u0000 J2\u00020\u0001:\u0002JKB\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\b\u0010/\u001a\u000200H\u0004J\u0006\u00101\u001a\u000200J\b\u00102\u001a\u000200H\u0002J\u000e\u00103\u001a\u0002042\u0006\u00105\u001a\u000204J\u001c\u00103\u001a\u00060\u0012j\u0002`\u00172\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0004J,\u00103\u001a\u00060\u0012j\u0002`\u00192\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u000204H\u0004J\u000e\u00103\u001a\u00020\b2\u0006\u00105\u001a\u00020\bJ(\u00103\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0004J\u000e\u00109\u001a\u0002042\u0006\u0010:\u001a\u000204J\u001c\u00109\u001a\u00060\u0012j\u0002`\u00172\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u000204H\u0004J,\u00109\u001a\u00060\u0012j\u0002`\u00192\u0006\u00105\u001a\u0002042\u0006\u00106\u001a\u0002042\u0006\u00107\u001a\u0002042\u0006\u00108\u001a\u000204H\u0004J(\u00109\u001a\u00020\u001b2\u0006\u00105\u001a\u00020\b2\u0006\u00106\u001a\u00020\b2\u0006\u00107\u001a\u00020\b2\u0006\u00108\u001a\u00020\bH\u0004J\u0018\u0010;\u001a\u00020\b2\u0006\u0010<\u001a\u00020$2\b\b\u0002\u0010=\u001a\u00020\u0015J\u000e\u0010>\u001a\u00020\b2\u0006\u0010<\u001a\u00020$J\b\u0010?\u001a\u000200H\u0016J\b\u0010@\u001a\u000200H\u0014J&\u0010A\u001a\u0002002\u0006\u0010B\u001a\u00020C2\u0006\u0010D\u001a\u00020C2\u0006\u0010E\u001a\u00020\b2\u0006\u0010F\u001a\u00020\bJ&\u0010G\u001a\u0002002\b\b\u0002\u0010+\u001a\u00020\u00152\b\b\u0002\u0010-\u001a\u00020.2\b\b\u0002\u0010,\u001a\u00020\bH\u0007J\u000e\u0010H\u001a\u0002002\u0006\u0010+\u001a\u00020\u0015J\u0006\u0010I\u001a\u000200R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\u0010\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u0011\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0016\u001a\u00060\u0012j\u0002`\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u0018\u001a\u00060\u0012j\u0002`\u0019X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001d\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR\u0014\u0010 \u001a\u00020\u00158BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R*\u0010\"\u001a\u001e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b0#j\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\b`%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010)\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010*\u001a\u00060\u0012j\u0002`\u0013X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020\u0015X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010,\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006L" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram;", "Lly/img/android/opengl/canvas/GlObject;", "vertexShader", "Lly/img/android/opengl/canvas/GlVertexShader;", "fragmentShader", "Lly/img/android/opengl/canvas/GlFragmentShader;", "(Lly/img/android/opengl/canvas/GlVertexShader;Lly/img/android/opengl/canvas/GlFragmentShader;)V", "_handle", "", "absoluteWorldTransform", "Lly/img/android/pesdk/backend/model/chunk/Transformation;", "blit", "Lly/img/android/opengl/canvas/GlBlit;", "getBlit", "()Lly/img/android/opengl/canvas/GlBlit;", "blit$delegate", "Lkotlin/Lazy;", "chunkRectCords", "", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "chunkWorldAvailable", "", "dummyFloat2", "Lly/img/android/pesdk/kotlin_extension/Float2;", "dummyFloat4", "Lly/img/android/pesdk/kotlin_extension/Float4;", "dummyInt2", "", "dummyInt4", "handle", "getHandle", "()I", "isInUse", "()Z", "paramHandleMap", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "relativeWorldTransform", "shorterSide", "Lly/img/android/opengl/canvas/GlProgram$ShorterSide;", "textureAbsoluteCords", "textureRelativeCords", "useExternalTexture", "virtualTextureLodCount", "virtualTextureType", "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;", "attach", "", "blitToViewPort", "clearHandles", "convertAbsolute", "", "x", "y", "z", "w", "convertRelative", "value", "getAttribute", "name", "required", "getUniform", "onHandlesInvalid", "onRelease", "setChunkWorldCords", "chunkRect", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "imageRect", "textureWidth", "textureHeight", "setProgramConfig", "setUseDynamicInput", "use", "Companion", "ShorterSide", "pesdk-backend-core_release" })
public class GlProgram extends GlObject
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final GlVertexShader vertexShader;
    @NotNull
    private GlFragmentShader fragmentShader;
    @NotNull
    private final HashMap<String, Integer> paramHandleMap;
    @NotNull
    private final Transformation absoluteWorldTransform;
    @NotNull
    private final Transformation relativeWorldTransform;
    private boolean chunkWorldAvailable;
    @NotNull
    private ShorterSide shorterSide;
    @NotNull
    private final float[] chunkRectCords;
    @NotNull
    private final float[] textureAbsoluteCords;
    @NotNull
    private final float[] textureRelativeCords;
    @NotNull
    private final int[] dummyInt2;
    @NotNull
    private final int[] dummyInt4;
    @NotNull
    private final float[] dummyFloat2;
    @NotNull
    private final float[] dummyFloat4;
    private int _handle;
    private boolean useExternalTexture;
    @NotNull
    private GlVirtualMipMapTexture.VirtualTextureType virtualTextureType;
    private int virtualTextureLodCount;
    @NotNull
    private final Lazy blit$delegate;
    private static boolean LOG_PROGRAMM_INFOS;
    private static volatile int programInUse;
    
    public GlProgram(@NotNull final GlVertexShader vertexShader, @NotNull final GlFragmentShader fragmentShader) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "vertexShader"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* fragmentShader */
        //     7: ldc             "fragmentShader"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* this */
        //    13: aconst_null    
        //    14: iconst_1       
        //    15: aconst_null    
        //    16: invokespecial   ly/img/android/opengl/canvas/GlObject.<init>:(Lly/img/android/opengl/GlThreadRunner;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //    19: aload_0         /* this */
        //    20: aload_1         /* vertexShader */
        //    21: putfield        ly/img/android/opengl/canvas/GlProgram.vertexShader:Lly/img/android/opengl/canvas/GlVertexShader;
        //    24: aload_0         /* this */
        //    25: aload_2         /* fragmentShader */
        //    26: putfield        ly/img/android/opengl/canvas/GlProgram.fragmentShader:Lly/img/android/opengl/canvas/GlFragmentShader;
        //    29: aload_0         /* this */
        //    30: new             Ljava/util/HashMap;
        //    33: dup            
        //    34: invokespecial   java/util/HashMap.<init>:()V
        //    37: putfield        ly/img/android/opengl/canvas/GlProgram.paramHandleMap:Ljava/util/HashMap;
        //    40: aload_0         /* this */
        //    41: invokestatic    ly/img/android/pesdk/backend/model/chunk/Transformation.permanent:()Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    44: dup            
        //    45: ldc             "permanent()"
        //    47: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    50: putfield        ly/img/android/opengl/canvas/GlProgram.absoluteWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    53: aload_0         /* this */
        //    54: invokestatic    ly/img/android/pesdk/backend/model/chunk/Transformation.permanent:()Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    57: dup            
        //    58: ldc             "permanent()"
        //    60: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    63: putfield        ly/img/android/opengl/canvas/GlProgram.relativeWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    66: aload_0         /* this */
        //    67: getstatic       ly/img/android/opengl/canvas/GlProgram$ShorterSide.WIDTH:Lly/img/android/opengl/canvas/GlProgram$ShorterSide;
        //    70: putfield        ly/img/android/opengl/canvas/GlProgram.shorterSide:Lly/img/android/opengl/canvas/GlProgram$ShorterSide;
        //    73: aload_0         /* this */
        //    74: fconst_0       
        //    75: fstore_3       
        //    76: fconst_0       
        //    77: fstore          4
        //    79: fconst_0       
        //    80: fstore          5
        //    82: fconst_0       
        //    83: fstore          6
        //    85: fconst_0       
        //    86: fstore          7
        //    88: fconst_0       
        //    89: fstore          8
        //    91: fconst_0       
        //    92: fstore          9
        //    94: fconst_0       
        //    95: fstore          y4$iv
        //    97: iconst_0       
        //    98: istore          $i$f$RectCords
        //   100: bipush          8
        //   102: newarray        F
        //   104: astore          12
        //   106: aload           12
        //   108: iconst_0       
        //   109: fload_3         /* x1$iv */
        //   110: fastore        
        //   111: aload           12
        //   113: iconst_1       
        //   114: fload           y1$iv
        //   116: fastore        
        //   117: aload           12
        //   119: iconst_2       
        //   120: fload           x2$iv
        //   122: fastore        
        //   123: aload           12
        //   125: iconst_3       
        //   126: fload           y2$iv
        //   128: fastore        
        //   129: aload           12
        //   131: iconst_4       
        //   132: fload           x3$iv
        //   134: fastore        
        //   135: aload           12
        //   137: iconst_5       
        //   138: fload           y3$iv
        //   140: fastore        
        //   141: aload           12
        //   143: bipush          6
        //   145: fload           x4$iv
        //   147: fastore        
        //   148: aload           12
        //   150: bipush          7
        //   152: fload           y4$iv
        //   154: fastore        
        //   155: aload           12
        //   157: putfield        ly/img/android/opengl/canvas/GlProgram.chunkRectCords:[F
        //   160: aload_0         /* this */
        //   161: fconst_0       
        //   162: fstore_3       
        //   163: fconst_0       
        //   164: fstore          4
        //   166: fconst_0       
        //   167: fstore          5
        //   169: fconst_0       
        //   170: fstore          6
        //   172: fconst_0       
        //   173: fstore          7
        //   175: fconst_0       
        //   176: fstore          8
        //   178: fconst_0       
        //   179: fstore          9
        //   181: fconst_0       
        //   182: fstore          y4$iv
        //   184: iconst_0       
        //   185: istore          $i$f$RectCords
        //   187: bipush          8
        //   189: newarray        F
        //   191: astore          12
        //   193: aload           12
        //   195: iconst_0       
        //   196: fload_3         /* x1$iv */
        //   197: fastore        
        //   198: aload           12
        //   200: iconst_1       
        //   201: fload           y1$iv
        //   203: fastore        
        //   204: aload           12
        //   206: iconst_2       
        //   207: fload           x2$iv
        //   209: fastore        
        //   210: aload           12
        //   212: iconst_3       
        //   213: fload           y2$iv
        //   215: fastore        
        //   216: aload           12
        //   218: iconst_4       
        //   219: fload           x3$iv
        //   221: fastore        
        //   222: aload           12
        //   224: iconst_5       
        //   225: fload           y3$iv
        //   227: fastore        
        //   228: aload           12
        //   230: bipush          6
        //   232: fload           x4$iv
        //   234: fastore        
        //   235: aload           12
        //   237: bipush          7
        //   239: fload           y4$iv
        //   241: fastore        
        //   242: aload           12
        //   244: putfield        ly/img/android/opengl/canvas/GlProgram.textureAbsoluteCords:[F
        //   247: aload_0         /* this */
        //   248: fconst_0       
        //   249: fstore_3       
        //   250: fconst_0       
        //   251: fstore          4
        //   253: fconst_1       
        //   254: fstore          5
        //   256: fconst_0       
        //   257: fstore          6
        //   259: fconst_1       
        //   260: fstore          7
        //   262: fconst_1       
        //   263: fstore          8
        //   265: fconst_0       
        //   266: fstore          9
        //   268: fconst_1       
        //   269: fstore          10
        //   271: nop            
        //   272: iconst_0       
        //   273: istore          $i$f$RectCords
        //   275: bipush          8
        //   277: newarray        F
        //   279: astore          12
        //   281: aload           12
        //   283: iconst_0       
        //   284: fload_3         /* x1$iv */
        //   285: fastore        
        //   286: aload           12
        //   288: iconst_1       
        //   289: fload           y1$iv
        //   291: fastore        
        //   292: aload           12
        //   294: iconst_2       
        //   295: fload           x2$iv
        //   297: fastore        
        //   298: aload           12
        //   300: iconst_3       
        //   301: fload           y2$iv
        //   303: fastore        
        //   304: aload           12
        //   306: iconst_4       
        //   307: fload           x3$iv
        //   309: fastore        
        //   310: aload           12
        //   312: iconst_5       
        //   313: fload           y3$iv
        //   315: fastore        
        //   316: aload           12
        //   318: bipush          6
        //   320: fload           x4$iv
        //   322: fastore        
        //   323: aload           12
        //   325: bipush          7
        //   327: fload           y4$iv
        //   329: fastore        
        //   330: aload           12
        //   332: putfield        ly/img/android/opengl/canvas/GlProgram.textureRelativeCords:[F
        //   335: aload_0         /* this */
        //   336: iconst_2       
        //   337: newarray        I
        //   339: putfield        ly/img/android/opengl/canvas/GlProgram.dummyInt2:[I
        //   342: aload_0         /* this */
        //   343: iconst_4       
        //   344: newarray        I
        //   346: putfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //   349: aload_0         /* this */
        //   350: fconst_0       
        //   351: fstore_3       
        //   352: fconst_0       
        //   353: fstore          y$iv
        //   355: iconst_0       
        //   356: istore          $i$f$Float2
        //   358: iconst_2       
        //   359: newarray        F
        //   361: astore          6
        //   363: aload           6
        //   365: iconst_0       
        //   366: fload_3         /* x$iv */
        //   367: fastore        
        //   368: aload           6
        //   370: iconst_1       
        //   371: fload           y$iv
        //   373: fastore        
        //   374: aload           6
        //   376: putfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat2:[F
        //   379: aload_0         /* this */
        //   380: fconst_0       
        //   381: fstore_3       
        //   382: fconst_0       
        //   383: fstore          4
        //   385: fconst_0       
        //   386: fstore          5
        //   388: fconst_0       
        //   389: fstore          w$iv
        //   391: iconst_0       
        //   392: istore          $i$f$Float4
        //   394: iconst_4       
        //   395: newarray        F
        //   397: astore          8
        //   399: aload           8
        //   401: iconst_0       
        //   402: fload_3         /* x$iv */
        //   403: fastore        
        //   404: aload           8
        //   406: iconst_1       
        //   407: fload           y$iv
        //   409: fastore        
        //   410: aload           8
        //   412: iconst_2       
        //   413: fload           z$iv
        //   415: fastore        
        //   416: aload           8
        //   418: iconst_3       
        //   419: fload           w$iv
        //   421: fastore        
        //   422: aload           8
        //   424: putfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //   427: aload_0         /* this */
        //   428: iconst_m1      
        //   429: putfield        ly/img/android/opengl/canvas/GlProgram._handle:I
        //   432: aload_0         /* this */
        //   433: getstatic       ly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType.NATIVE_MIP_MAP:Lly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;
        //   436: putfield        ly/img/android/opengl/canvas/GlProgram.virtualTextureType:Lly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;
        //   439: aload_0         /* this */
        //   440: iconst_1       
        //   441: putfield        ly/img/android/opengl/canvas/GlProgram.virtualTextureLodCount:I
        //   444: aload_0         /* this */
        //   445: getstatic       ly/img/android/opengl/canvas/GlProgram$blit$2.INSTANCE:Lly/img/android/opengl/canvas/GlProgram$blit$2;
        //   448: checkcast       Lkotlin/jvm/functions/Function0;
        //   451: invokestatic    kotlin/LazyKt.lazy:(Lkotlin/jvm/functions/Function0;)Lkotlin/Lazy;
        //   454: putfield        ly/img/android/opengl/canvas/GlProgram.blit$delegate:Lkotlin/Lazy;
        //   457: return         
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
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createConstructor(AstBuilder.java:713)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:549)
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
    
    public final void blitToViewPort() {
        this.getBlit().enable(this);
        this.getBlit().draw();
        this.getBlit().disable();
    }
    
    public final void setChunkWorldCords(@NotNull final MultiRect chunkRect, @NotNull final MultiRect imageRect, final int textureWidth, final int textureHeight) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "chunkRect"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_2         /* imageRect */
        //     7: ldc             "imageRect"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: aload_0         /* this */
        //    13: iconst_1       
        //    14: putfield        ly/img/android/opengl/canvas/GlProgram.chunkWorldAvailable:Z
        //    17: aload_0         /* this */
        //    18: getstatic       ly/img/android/opengl/canvas/GlProgram$ShorterSide.Companion:Lly/img/android/opengl/canvas/GlProgram$ShorterSide$Companion;
        //    21: aload_2         /* imageRect */
        //    22: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getWidth:()F
        //    25: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //    28: aload_2         /* imageRect */
        //    29: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getHeight:()F
        //    32: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //    35: invokevirtual   ly/img/android/opengl/canvas/GlProgram$ShorterSide$Companion.getShorterSide:(II)Lly/img/android/opengl/canvas/GlProgram$ShorterSide;
        //    38: putfield        ly/img/android/opengl/canvas/GlProgram.shorterSide:Lly/img/android/opengl/canvas/GlProgram$ShorterSide;
        //    41: aload_0         /* this */
        //    42: getfield        ly/img/android/opengl/canvas/GlProgram.chunkRectCords:[F
        //    45: astore          6
        //    47: aload           6
        //    49: astore          it
        //    51: iconst_0       
        //    52: istore          $i$a$-also-GlProgram$setChunkWorldCords$fromDestination$1
        //    54: aload_1         /* chunkRect */
        //    55: aload           it
        //    57: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.toShape:([F)V
        //    60: aload           6
        //    62: astore          fromDestination
        //    64: aload_0         /* this */
        //    65: getfield        ly/img/android/opengl/canvas/GlProgram.relativeWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    68: aload           fromDestination
        //    70: aload_0         /* this */
        //    71: getfield        ly/img/android/opengl/canvas/GlProgram.textureRelativeCords:[F
        //    74: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.setToCordsMapping:([F[F)V
        //    77: aload_0         /* this */
        //    78: getfield        ly/img/android/opengl/canvas/GlProgram.textureAbsoluteCords:[F
        //    81: astore          6
        //    83: aload           6
        //    85: astore          $this$setChunkWorldCords_u24lambda_u2d1
        //    87: iconst_0       
        //    88: istore          $i$a$-apply-GlProgram$setChunkWorldCords$1
        //    90: aload           $this$setChunkWorldCords_u24lambda_u2d1
        //    92: astore          9
        //    94: iload_3         /* textureWidth */
        //    95: i2f            
        //    96: fstore          value$iv
        //    98: iconst_0       
        //    99: istore          $i$f$setX2
        //   101: aload           $this$x2$iv
        //   103: iconst_2       
        //   104: fload           value$iv
        //   106: fastore        
        //   107: nop            
        //   108: aload           $this$setChunkWorldCords_u24lambda_u2d1
        //   110: astore          9
        //   112: iload_3         /* textureWidth */
        //   113: i2f            
        //   114: fstore          value$iv
        //   116: iconst_0       
        //   117: istore          $i$f$setX3
        //   119: aload           $this$x3$iv
        //   121: iconst_4       
        //   122: fload           value$iv
        //   124: fastore        
        //   125: nop            
        //   126: aload           $this$setChunkWorldCords_u24lambda_u2d1
        //   128: astore          9
        //   130: iload           textureHeight
        //   132: i2f            
        //   133: fstore          value$iv
        //   135: iconst_0       
        //   136: istore          $i$f$setY3
        //   138: aload           $this$y3$iv
        //   140: iconst_5       
        //   141: fload           value$iv
        //   143: fastore        
        //   144: nop            
        //   145: aload           $this$setChunkWorldCords_u24lambda_u2d1
        //   147: astore          9
        //   149: iload           textureHeight
        //   151: i2f            
        //   152: fstore          value$iv
        //   154: iconst_0       
        //   155: istore          $i$f$setY4
        //   157: aload           $this$y4$iv
        //   159: bipush          7
        //   161: fload           value$iv
        //   163: fastore        
        //   164: nop            
        //   165: nop            
        //   166: nop            
        //   167: aload_0         /* this */
        //   168: getfield        ly/img/android/opengl/canvas/GlProgram.absoluteWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //   171: aload           fromDestination
        //   173: aload_0         /* this */
        //   174: getfield        ly/img/android/opengl/canvas/GlProgram.textureAbsoluteCords:[F
        //   177: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.setToCordsMapping:([F[F)V
        //   180: return         
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
    
    public final float convertRelative(final float value) {
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        return this.shorterSide.convertToRelative(value, this.chunkRectCords);
    }
    
    public final float convertAbsolute(final float x) {
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        return this.absoluteWorldTransform.mapRadius(x);
    }
    
    public final int convertAbsolute(final int x) {
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        return MathKt.roundToInt(this.absoluteWorldTransform.mapRadius((float)x));
    }
    
    @NotNull
    protected final float[] convertRelative(final float x, final float y) {
        final float[] it;
        final float[] array = it = this.dummyFloat2;
        final int n = 0;
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        final float[] $this$set$iv = it;
        final int $i$f$set = 0;
        $this$set$iv[0] = x;
        $this$set$iv[1] = y;
        this.relativeWorldTransform.mapPoints(it);
        return array;
    }
    
    @NotNull
    protected final float[] convertAbsolute(final float x, final float y) {
        final float[] it;
        final float[] array = it = this.dummyFloat2;
        final int n = 0;
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        final float[] $this$set$iv = it;
        final int $i$f$set = 0;
        $this$set$iv[0] = x;
        $this$set$iv[1] = y;
        this.absoluteWorldTransform.mapPoints(it);
        return array;
    }
    
    @NotNull
    protected final float[] convertRelative(final float x, final float y, final float z, final float w) {
        final float[] it;
        final float[] array = it = this.dummyFloat4;
        final int n = 0;
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        final float[] $this$set$iv = it;
        final int $i$f$set = 0;
        $this$set$iv[0] = x;
        $this$set$iv[1] = y;
        $this$set$iv[2] = z;
        $this$set$iv[3] = w;
        this.relativeWorldTransform.mapPoints(it);
        return array;
    }
    
    @NotNull
    protected final float[] convertAbsolute(final float x, final float y, final float z, final float w) {
        final float[] it;
        final float[] array = it = this.dummyFloat4;
        final int n = 0;
        if (!this.chunkWorldAvailable) {
            throw new RuntimeException("call setChunkWorldCords first");
        }
        final float[] $this$set$iv = it;
        final int $i$f$set = 0;
        $this$set$iv[0] = x;
        $this$set$iv[1] = y;
        $this$set$iv[2] = z;
        $this$set$iv[3] = w;
        this.absoluteWorldTransform.mapPoints(it);
        return array;
    }
    
    @NotNull
    protected final int[] convertRelative(final int x, final int y, final int z, final int w) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/canvas/GlProgram.chunkWorldAvailable:Z
        //     4: ifne            17
        //     7: new             Ljava/lang/RuntimeException;
        //    10: dup            
        //    11: ldc             "call setChunkWorldCords first"
        //    13: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: aload_0         /* this */
        //    18: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //    21: astore          5
        //    23: aload           5
        //    25: astore          it
        //    27: iconst_0       
        //    28: istore          $i$a$-also-GlProgram$convertRelative$3
        //    30: aload           it
        //    32: astore          8
        //    34: iload_1         /* x */
        //    35: i2f            
        //    36: fstore          9
        //    38: iload_2         /* y */
        //    39: i2f            
        //    40: fstore          10
        //    42: iload_3         /* z */
        //    43: i2f            
        //    44: fstore          11
        //    46: iload           w
        //    48: i2f            
        //    49: fstore          y2$iv
        //    51: iconst_0       
        //    52: istore          $i$f$set
        //    54: aload           $this$set$iv
        //    56: iconst_0       
        //    57: fload           x$iv
        //    59: fastore        
        //    60: aload           $this$set$iv
        //    62: iconst_1       
        //    63: fload           y$iv
        //    65: fastore        
        //    66: aload           $this$set$iv
        //    68: iconst_2       
        //    69: fload           x2$iv
        //    71: fastore        
        //    72: aload           $this$set$iv
        //    74: iconst_3       
        //    75: fload           y2$iv
        //    77: fastore        
        //    78: nop            
        //    79: aload_0         /* this */
        //    80: getfield        ly/img/android/opengl/canvas/GlProgram.relativeWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    83: aload           it
        //    85: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.mapPoints:([F)V
        //    88: nop            
        //    89: nop            
        //    90: aload_0         /* this */
        //    91: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt2:[I
        //    94: iconst_0       
        //    95: aload_0         /* this */
        //    96: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat2:[F
        //    99: astore          $this$x$iv
        //   101: iconst_0       
        //   102: istore          $i$f$getX
        //   104: aload           $this$x$iv
        //   106: iconst_0       
        //   107: faload         
        //   108: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   111: iastore        
        //   112: aload_0         /* this */
        //   113: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt2:[I
        //   116: iconst_1       
        //   117: aload_0         /* this */
        //   118: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat2:[F
        //   121: astore          $this$y$iv
        //   123: iconst_0       
        //   124: istore          $i$f$getY
        //   126: aload           $this$y$iv
        //   128: iconst_1       
        //   129: faload         
        //   130: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   133: iastore        
        //   134: aload_0         /* this */
        //   135: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt2:[I
        //   138: areturn        
        //    StackMapTable: 00 01 11
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
    protected final int[] convertAbsolute(final int x, final int y, final int z, final int w) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/canvas/GlProgram.chunkWorldAvailable:Z
        //     4: ifne            17
        //     7: new             Ljava/lang/RuntimeException;
        //    10: dup            
        //    11: ldc             "call setChunkWorldCords first"
        //    13: invokespecial   java/lang/RuntimeException.<init>:(Ljava/lang/String;)V
        //    16: athrow         
        //    17: aload_0         /* this */
        //    18: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //    21: astore          5
        //    23: aload           5
        //    25: astore          it
        //    27: iconst_0       
        //    28: istore          $i$a$-also-GlProgram$convertAbsolute$3
        //    30: aload           it
        //    32: astore          8
        //    34: iload_1         /* x */
        //    35: i2f            
        //    36: fstore          9
        //    38: iload_2         /* y */
        //    39: i2f            
        //    40: fstore          10
        //    42: iload_3         /* z */
        //    43: i2f            
        //    44: fstore          11
        //    46: iload           w
        //    48: i2f            
        //    49: fstore          y2$iv
        //    51: iconst_0       
        //    52: istore          $i$f$set
        //    54: aload           $this$set$iv
        //    56: iconst_0       
        //    57: fload           x$iv
        //    59: fastore        
        //    60: aload           $this$set$iv
        //    62: iconst_1       
        //    63: fload           y$iv
        //    65: fastore        
        //    66: aload           $this$set$iv
        //    68: iconst_2       
        //    69: fload           x2$iv
        //    71: fastore        
        //    72: aload           $this$set$iv
        //    74: iconst_3       
        //    75: fload           y2$iv
        //    77: fastore        
        //    78: nop            
        //    79: aload_0         /* this */
        //    80: getfield        ly/img/android/opengl/canvas/GlProgram.absoluteWorldTransform:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    83: aload           it
        //    85: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.mapPoints:([F)V
        //    88: nop            
        //    89: nop            
        //    90: aload_0         /* this */
        //    91: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //    94: iconst_0       
        //    95: aload_0         /* this */
        //    96: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //    99: astore          $this$x$iv
        //   101: iconst_0       
        //   102: istore          $i$f$getX
        //   104: aload           $this$x$iv
        //   106: iconst_0       
        //   107: faload         
        //   108: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   111: iastore        
        //   112: aload_0         /* this */
        //   113: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //   116: iconst_1       
        //   117: aload_0         /* this */
        //   118: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //   121: astore          $this$y$iv
        //   123: iconst_0       
        //   124: istore          $i$f$getY
        //   126: aload           $this$y$iv
        //   128: iconst_1       
        //   129: faload         
        //   130: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   133: iastore        
        //   134: aload_0         /* this */
        //   135: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //   138: iconst_2       
        //   139: aload_0         /* this */
        //   140: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //   143: astore          $this$x2$iv
        //   145: iconst_0       
        //   146: istore          $i$f$getX2
        //   148: aload           $this$x2$iv
        //   150: iconst_2       
        //   151: faload         
        //   152: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   155: iastore        
        //   156: aload_0         /* this */
        //   157: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //   160: iconst_3       
        //   161: aload_0         /* this */
        //   162: getfield        ly/img/android/opengl/canvas/GlProgram.dummyFloat4:[F
        //   165: astore          $this$y2$iv
        //   167: iconst_0       
        //   168: istore          $i$f$getY2
        //   170: aload           $this$y2$iv
        //   172: iconst_3       
        //   173: faload         
        //   174: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   177: iastore        
        //   178: aload_0         /* this */
        //   179: getfield        ly/img/android/opengl/canvas/GlProgram.dummyInt4:[I
        //   182: areturn        
        //    StackMapTable: 00 01 11
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
    
    public final int getHandle() {
        if (this._handle == -1) {
            this.attach();
        }
        return this._handle;
    }
    
    private final boolean isInUse() {
        return GlProgram.programInUse == this.getHandle();
    }
    
    private final void clearHandles() {
        this.paramHandleMap.clear();
        this.onHandlesInvalid();
    }
    
    public void onHandlesInvalid() {
    }
    
    @JvmOverloads
    public final void setProgramConfig(final boolean useExternalTexture, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType, final int virtualTextureLodCount) {
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType2 = (GlVirtualMipMapTexture.VirtualTextureType)((virtualTextureLodCount <= 1) ? GlVirtualMipMapTexture.VirtualTextureType.NATIVE_MIP_MAP : virtualTextureType);
        if (useExternalTexture != this.useExternalTexture || virtualTextureType2 != this.virtualTextureType || virtualTextureLodCount != this.virtualTextureLodCount) {
            this.useExternalTexture = useExternalTexture;
            this.virtualTextureType = virtualTextureType2;
            this.virtualTextureLodCount = virtualTextureLodCount;
            if (this._handle != -1) {
                GLES20.glDeleteProgram(this._handle);
                this._handle = -1;
            }
            this.clearHandles();
            this.fragmentShader = new GlFragmentShader(this.fragmentShader, useExternalTexture, virtualTextureType2, virtualTextureLodCount);
        }
    }
    
    public static /* synthetic */ void setProgramConfig$default(final GlProgram glProgram, boolean useExternalTexture, GlVirtualMipMapTexture.VirtualTextureType virtualTextureType, int virtualTextureLodCount, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: setProgramConfig");
        }
        if ((n & 0x1) != 0x0) {
            useExternalTexture = glProgram.useExternalTexture;
        }
        if ((n & 0x2) != 0x0) {
            virtualTextureType = glProgram.virtualTextureType;
        }
        if ((n & 0x4) != 0x0) {
            virtualTextureLodCount = glProgram.virtualTextureLodCount;
        }
        glProgram.setProgramConfig(useExternalTexture, virtualTextureType, virtualTextureLodCount);
    }
    
    public final void setUseDynamicInput(final boolean useExternalTexture) {
        setProgramConfig$default(this, useExternalTexture, null, 0, 6, null);
    }
    
    public final void use() {
        this.attach();
        final Companion companion = GlProgram.Companion;
        useProgram(this.getHandle());
    }
    
    protected final void attach() {
        if (this._handle == -1) {
            final Companion companion = GlProgram.Companion;
            this._handle = loadProgram(this.vertexShader.getHandle(), this.fragmentShader.getHandle());
        }
    }
    
    public final int getAttribute(@NotNull final String name, final boolean required) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final Integer value = this.paramHandleMap.get(name);
        if (value != null) {
            return value;
        }
        if (!this.isInUse()) {
            throw new IllegalStateException("You must load program before you can get the attribute location: " + name);
        }
        final int location = GLES20.glGetAttribLocation(this.getHandle(), name);
        if (required && location == -1) {
            Log.e("PESDk", "Could not get attribute location for: " + name + "\nVERTREX SHADER\n" + this.vertexShader.getSourceCode() + "\nFRAGMENT SHADER\n" + this.fragmentShader.getSourceCode());
        }
        this.paramHandleMap.put(name, location);
        return location;
    }
    
    public final int getUniform(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        final Integer value = this.paramHandleMap.get(name);
        if (value != null) {
            return value;
        }
        if (!this.isInUse()) {
            throw new IllegalStateException("You must load program before you can get the uniform location: " + name);
        }
        final int location = GLES20.glGetUniformLocation(this.getHandle(), name);
        if (location == -1) {
            Log.e("PESDk", "Could not get uniform location for: " + name + "\nVERTREX SHADER\n" + this.vertexShader.getSourceCode() + "\nFRAGMENT SHADER\n" + this.fragmentShader.getSourceCode());
        }
        this.paramHandleMap.put(name, location);
        return location;
    }
    
    @Override
    protected void onRelease() {
        GLES20.glDeleteProgram(this._handle);
        this.clearHandles();
        this._handle = -1;
    }
    
    private final GlBlit getBlit() {
        return (GlBlit)this.blit$delegate.getValue();
    }
    
    @JvmOverloads
    public final void setProgramConfig(final boolean useExternalTexture, @NotNull final GlVirtualMipMapTexture.VirtualTextureType virtualTextureType) {
        Intrinsics.checkNotNullParameter((Object)virtualTextureType, "virtualTextureType");
        setProgramConfig$default(this, useExternalTexture, virtualTextureType, 0, 4, null);
    }
    
    @JvmOverloads
    public final void setProgramConfig(final boolean useExternalTexture) {
        setProgramConfig$default(this, useExternalTexture, null, 0, 6, null);
    }
    
    @JvmOverloads
    public final void setProgramConfig() {
        setProgramConfig$default(this, false, null, 0, 7, null);
    }
    
    public static final boolean getLOG_PROGRAMM_INFOS() {
        return GlProgram.Companion.getLOG_PROGRAMM_INFOS();
    }
    
    public static final void setLOG_PROGRAMM_INFOS(final boolean <set-?>) {
        GlProgram.Companion.setLOG_PROGRAMM_INFOS(<set-?>);
    }
    
    @JvmStatic
    protected static final int useProgram(final int handle) {
        return GlProgram.Companion.useProgram(handle);
    }
    
    @JvmStatic
    protected static final int loadProgram(final int vertexShader, final int pixelShader) throws GLException {
        return GlProgram.Companion.loadProgram(vertexShader, pixelShader);
    }
    
    public static final /* synthetic */ boolean access$getLOG_PROGRAMM_INFOS$cp() {
        return GlProgram.LOG_PROGRAMM_INFOS;
    }
    
    public static final /* synthetic */ void access$setLOG_PROGRAMM_INFOS$cp(final boolean <set-?>) {
        GlProgram.LOG_PROGRAMM_INFOS = <set-?>;
    }
    
    public static final /* synthetic */ int access$getProgramInUse$cp() {
        return GlProgram.programInUse;
    }
    
    public static final /* synthetic */ void access$setProgramInUse$cp(final int <set-?>) {
        GlProgram.programInUse = <set-?>;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0084\u0001\u0018\u0000 \u000b2\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u000bB\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\n\u0010\u0006\u001a\u00060\u0007j\u0002`\bH&j\u0002\b\tj\u0002\b\n¨\u0006\f" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram$ShorterSide;", "", "(Ljava/lang/String;I)V", "convertToRelative", "", "value", "chunkCords", "", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "WIDTH", "HEIGHT", "Companion", "pesdk-backend-core_release" })
    protected enum ShorterSide
    {
        @NotNull
        public static final Companion Companion;
        
        WIDTH, 
        HEIGHT;
        
        public abstract float convertToRelative(final float p0, @NotNull final float[] p1);
        
        private static final /* synthetic */ ShorterSide[] $values() {
            return new ShorterSide[] { ShorterSide.WIDTH, ShorterSide.HEIGHT };
        }
        
        static {
            $VALUES = $values();
            Companion = new Companion(null);
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016¨\u0006\b" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram$ShorterSide$WIDTH;", "Lly/img/android/opengl/canvas/GlProgram$ShorterSide;", "convertToRelative", "", "value", "chunkCords", "", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "pesdk-backend-core_release" })
        static final class WIDTH extends ShorterSide
        {
            WIDTH(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
            
            @Override
            public float convertToRelative(final float value, @NotNull final float[] chunkCords) {
                Intrinsics.checkNotNullParameter((Object)chunkCords, "chunkCords");
                final float[] $this$x2$iv = chunkCords;
                final int $i$f$getX2 = 0;
                final float n = $this$x2$iv[2];
                final float[] $this$x1$iv = chunkCords;
                final int $i$f$getX3 = 0;
                return value / Math.abs(n - $this$x1$iv[0]);
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u001c\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\n\u0010\u0005\u001a\u00060\u0006j\u0002`\u0007H\u0016¨\u0006\b" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram$ShorterSide$HEIGHT;", "Lly/img/android/opengl/canvas/GlProgram$ShorterSide;", "convertToRelative", "", "value", "chunkCords", "", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "pesdk-backend-core_release" })
        static final class HEIGHT extends ShorterSide
        {
            HEIGHT(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, null);
            }
            
            @Override
            public float convertToRelative(final float value, @NotNull final float[] chunkCords) {
                Intrinsics.checkNotNullParameter((Object)chunkCords, "chunkCords");
                final float[] $this$y2$iv = chunkCords;
                final int $i$f$getY2 = 0;
                final float n = $this$y2$iv[3];
                final float[] $this$y3$iv = chunkCords;
                final int $i$f$getY3 = 0;
                return value / Math.abs(n - $this$y3$iv[5]);
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0006¨\u0006\b" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram$ShorterSide$Companion;", "", "()V", "getShorterSide", "Lly/img/android/opengl/canvas/GlProgram$ShorterSide;", "width", "", "height", "pesdk-backend-core_release" })
        public static final class Companion
        {
            private Companion() {
            }
            
            @NotNull
            public final ShorterSide getShorterSide(final int width, final int height) {
                return (width < height) ? ShorterSide.WIDTH : ShorterSide.HEIGHT;
            }
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000bH\u0005J\u0010\u0010\u000f\u001a\u00020\u000b2\u0006\u0010\u0010\u001a\u00020\u000bH\u0005R$\u0010\u0003\u001a\u00020\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lly/img/android/opengl/canvas/GlProgram$Companion;", "", "()V", "LOG_PROGRAMM_INFOS", "", "getLOG_PROGRAMM_INFOS$annotations", "getLOG_PROGRAMM_INFOS", "()Z", "setLOG_PROGRAMM_INFOS", "(Z)V", "programInUse", "", "loadProgram", "vertexShader", "pixelShader", "useProgram", "handle", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        public final boolean getLOG_PROGRAMM_INFOS() {
            return GlProgram.access$getLOG_PROGRAMM_INFOS$cp();
        }
        
        public final void setLOG_PROGRAMM_INFOS(final boolean <set-?>) {
            GlProgram.access$setLOG_PROGRAMM_INFOS$cp(<set-?>);
        }
        
        @JvmStatic
        protected final int useProgram(final int handle) {
            final int oldProgram = GlProgram.access$getProgramInUse$cp();
            if (oldProgram != handle) {
                GlProgram.access$setProgramInUse$cp(handle);
                GLES20.glUseProgram(GlProgram.access$getProgramInUse$cp());
            }
            return oldProgram;
        }
        
        @JvmStatic
        protected final int loadProgram(final int vertexShader, final int pixelShader) throws GLException {
            final int program = GLES20.glCreateProgram();
            if (program == 0) {
                throw new RuntimeException("Could not create program");
            }
            GLES20.glAttachShader(program, vertexShader);
            GLES20.glAttachShader(program, pixelShader);
            GLES20.glLinkProgram(program);
            GLES20.glDetachShader(program, vertexShader);
            GLES20.glDetachShader(program, pixelShader);
            final int[] linkStatus = { 0 };
            GLES20.glGetProgramiv(program, 35714, linkStatus, 0);
            if (this.getLOG_PROGRAMM_INFOS()) {
                Log.i("PESDK", "Program loaded successfully: " + (linkStatus[0] != 1) + "\n Debuginfo:" + GLES20.glGetProgramInfoLog(program));
            }
            if (linkStatus[0] != 1) {
                GLES20.glDeleteProgram(program);
                throw new RuntimeException("Could not link program: " + GLES20.glGetProgramInfoLog(program));
            }
            if (this.getLOG_PROGRAMM_INFOS()) {
                Log.i("PESDK", "Program linked extra infos \n" + GLES20.glGetProgramInfoLog(program));
            }
            EGLLogWrapper.readGlError();
            return program;
        }
    }
}
