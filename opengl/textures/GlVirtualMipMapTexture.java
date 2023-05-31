// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import kotlin.jvm.functions.Function0;
import ly.img.android.pesdk.backend.model.chunk.Recycler;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import android.opengl.GLES20;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import ly.img.android.opengl.canvas.GlShape;
import java.util.ArrayList;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import ly.img.android.opengl.canvas.GlRect;
import java.util.List;
import ly.img.android.opengl.programs.GlProgramShapeDraw;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import ly.img.android.opengl.canvas.GlObject;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 I2\u00020\u0001:\u0003IJKB\u0005¢\u0006\u0002\u0010\u0002J\u0016\u00107\u001a\u0002082\u0006\u00109\u001a\u00020\u000f2\u0006\u0010:\u001a\u00020\u000fJ]\u0010;\u001a\u0002082\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\n\b\u0002\u0010=\u001a\u0004\u0018\u00010>2\u0006\u0010\u001c\u001a\u00020\u000f2#\b\u0004\u0010?\u001a\u001d\u0012\u0013\u0012\u00110A¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u0002080@H\u0086\b\u00f8\u0001\u0000JY\u0010E\u001a\u0002082\u0006\u00105\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010=\u001a\u00020>2\u0006\u0010\u001c\u001a\u00020\u000f2#\b\u0004\u0010F\u001a\u001d\u0012\u0013\u0012\u00110A¢\u0006\f\bB\u0012\b\bC\u0012\u0004\b\b(D\u0012\u0004\u0012\u00020G0@H\u0086\b\u00f8\u0001\u0000J\b\u0010H\u001a\u000208H\u0014R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u000e\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0014R\u001c\u0010\u0015\u001a\u00020\u000f8FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0011\"\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0019\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0011\"\u0004\b\u001e\u0010\u0018R\u0011\u0010\u001f\u001a\u00020 ¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u001a\u0010#\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010\u0011\"\u0004\b%\u0010\u0018R\u001a\u0010&\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020'X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010)\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u0010\u0011\"\u0004\b1\u0010\u0018R\u001a\u00102\u001a\u00020\u000fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0011\"\u0004\b4\u0010\u0018R\u0011\u00105\u001a\u00020\u000f8F¢\u0006\u0006\u001a\u0004\b6\u0010\u0011\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006L" }, d2 = { "Lly/img/android/opengl/textures/GlVirtualMipMapTexture;", "Lly/img/android/opengl/canvas/GlObject;", "()V", "copyProgram", "Lly/img/android/opengl/programs/GlProgramShapeDraw;", "getCopyProgram", "()Lly/img/android/opengl/programs/GlProgramShapeDraw;", "frameBuffers", "", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "getFrameBuffers", "()Ljava/util/List;", "handles", "", "height", "", "getHeight", "()I", "isExternalTexture", "", "()Z", "lodCount", "getLodCount", "setLodCount", "(I)V", "lodRectValues", "getLodRectValues", "()[I", "lodSteps", "getLodSteps", "setLodSteps", "mipMapShape", "Lly/img/android/opengl/canvas/GlRect;", "getMipMapShape", "()Lly/img/android/opengl/canvas/GlRect;", "offset", "getOffset", "setOffset", "samplingX", "", "getSamplingX", "()F", "setSamplingX", "(F)V", "samplingY", "getSamplingY", "setSamplingY", "virtualHeight", "getVirtualHeight", "setVirtualHeight", "virtualWidth", "getVirtualWidth", "setVirtualWidth", "width", "getWidth", "bindTexture", "", "uniform", "slot", "drawMipMap", "minOffset", "region", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "drawTexture", "Lkotlin/Function1;", "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;", "Lkotlin/ParameterName;", "name", "stepInfo", "generateMipMap", "getTexture", "Lly/img/android/opengl/textures/GlTexture;", "onRelease", "Companion", "StepInfo", "VirtualTextureType", "pesdk-backend-core_release" })
@WorkerThread
public final class GlVirtualMipMapTexture extends GlObject
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final GlProgramShapeDraw copyProgram;
    @NotNull
    private final List<GlFrameBufferTexture> frameBuffers;
    @NotNull
    private final GlRect mipMapShape;
    private int virtualWidth;
    private int virtualHeight;
    private final boolean isExternalTexture;
    @NotNull
    private final int[] lodRectValues;
    private int offset;
    private int lodCount;
    private int lodSteps;
    @NotNull
    private final int[] handles;
    private float samplingX;
    private float samplingY;
    public static final int MAX_LOD = 8;
    
    public GlVirtualMipMapTexture() {
        super(null, 1, null);
        this.copyProgram = new GlProgramShapeDraw();
        final int initialCapacity = 8;
        final ArrayList list = new ArrayList<GlFrameBufferTexture>(initialCapacity);
        for (int i = 0; i < initialCapacity; ++i) {
            final ArrayList list2 = list;
            final int n = 0;
            final GlFrameBufferTexture $this$frameBuffers_u24lambda_u2d1_u24lambda_u2d0 = new GlFrameBufferTexture(1, 1);
            final int n2 = 0;
            $this$frameBuffers_u24lambda_u2d1_u24lambda_u2d0.setBehave(9729, 33071);
            list2.add($this$frameBuffers_u24lambda_u2d1_u24lambda_u2d0);
        }
        this.frameBuffers = (ArrayList<GlFrameBufferTexture>)list;
        this.mipMapShape = new GlRect(GlShape.FILL_VIEWPORT_VERTICES_DATA, true);
        int j = 0;
        final int[] lodRectValues = new int[32];
        while (j < 32) {
            lodRectValues[j] = 0;
            ++j;
        }
        this.lodRectValues = lodRectValues;
        int k = 0;
        final int[] handles = new int[8];
        while (k < 8) {
            handles[k] = 0;
            ++k;
        }
        this.handles = handles;
        this.samplingX = 1.0f;
        this.samplingY = 1.0f;
    }
    
    @NotNull
    public final GlProgramShapeDraw getCopyProgram() {
        return this.copyProgram;
    }
    
    @NotNull
    public final List<GlFrameBufferTexture> getFrameBuffers() {
        return this.frameBuffers;
    }
    
    @NotNull
    public final GlRect getMipMapShape() {
        return this.mipMapShape;
    }
    
    public final int getVirtualWidth() {
        return this.virtualWidth;
    }
    
    public final void setVirtualWidth(final int <set-?>) {
        this.virtualWidth = <set-?>;
    }
    
    public final int getVirtualHeight() {
        return this.virtualHeight;
    }
    
    public final void setVirtualHeight(final int <set-?>) {
        this.virtualHeight = <set-?>;
    }
    
    public final boolean isExternalTexture() {
        return this.isExternalTexture;
    }
    
    public final int getWidth() {
        return this.virtualWidth;
    }
    
    public final int getHeight() {
        return this.virtualHeight;
    }
    
    @NotNull
    public final int[] getLodRectValues() {
        return this.lodRectValues;
    }
    
    public final int getOffset() {
        return this.offset;
    }
    
    public final void setOffset(final int <set-?>) {
        this.offset = <set-?>;
    }
    
    public final int getLodCount() {
        return TypeExtensionsKt.butMin(this.lodCount, 1);
    }
    
    public final void setLodCount(final int <set-?>) {
        this.lodCount = <set-?>;
    }
    
    public final int getLodSteps() {
        return this.lodSteps;
    }
    
    public final void setLodSteps(final int <set-?>) {
        this.lodSteps = <set-?>;
    }
    
    public final void bindTexture(final int uniform, final int slot) {
        for (int lod = 0; lod < this.getLodCount(); ++lod) {
            this.handles[lod] = this.frameBuffers.get(lod).bindTexture(slot + lod);
        }
        for (int lod = this.getLodCount(); lod < 8; ++lod) {
            this.handles[lod] = this.handles[this.getLodCount() - 1];
        }
        GLES20.glUniform1iv(uniform, 8, this.handles, 0);
    }
    
    @Override
    protected void onRelease() {
    }
    
    public final float getSamplingX() {
        return this.samplingX;
    }
    
    public final void setSamplingX(final float <set-?>) {
        this.samplingX = <set-?>;
    }
    
    public final float getSamplingY() {
        return this.samplingY;
    }
    
    public final void setSamplingY(final float <set-?>) {
        this.samplingY = <set-?>;
    }
    
    public final void drawMipMap(final int width, final int height, final int minOffset, @Nullable final MultiRect region, final int lodSteps, @NotNull final Function1<? super StepInfo, Unit> drawTexture) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc             "drawTexture"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: iconst_0       
        //     8: istore          $i$f$drawMipMap
        //    10: aload_0         /* this */
        //    11: iload_3         /* minOffset */
        //    12: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setOffset:(I)V
        //    15: aload_0         /* this */
        //    16: iload           lodSteps
        //    18: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setLodSteps:(I)V
        //    21: aload_0         /* this */
        //    22: bipush          8
        //    24: aload_0         /* this */
        //    25: checkcast       Lly/img/android/opengl/textures/GlVirtualMipMapTexture;
        //    28: astore          9
        //    30: istore          39
        //    32: astore          38
        //    34: iconst_0       
        //    35: istore          $i$a$-run-GlVirtualMipMapTexture$drawMipMap$1
        //    37: iload_3         /* minOffset */
        //    38: iconst_1       
        //    39: iload           lodSteps
        //    41: ishl           
        //    42: imul           
        //    43: istore          maxOffset
        //    45: iload           maxOffset
        //    47: iload_1         /* width */
        //    48: iload_2         /* height */
        //    49: invokestatic    java/lang/Math.max:(II)I
        //    52: iadd           
        //    53: istore          neededRange
        //    55: iload           neededRange
        //    57: i2d            
        //    58: getstatic       ly/img/android/opengl/textures/GlTexture.Companion:Lly/img/android/opengl/textures/GlTexture$Companion;
        //    61: invokevirtual   ly/img/android/opengl/textures/GlTexture$Companion.getMaxTextureSize:()I
        //    64: i2d            
        //    65: ldc2_w          2.0
        //    68: ddiv           
        //    69: ddiv           
        //    70: dconst_1       
        //    71: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(DD)D
        //    74: dstore          neededScale
        //    76: dload           neededScale
        //    78: invokestatic    kotlin/math/MathKt.log2:(D)D
        //    81: dstore          maxNeededLod
        //    83: dload           maxNeededLod
        //    85: invokestatic    java/lang/Math.ceil:(D)D
        //    88: d2i            
        //    89: iconst_1       
        //    90: iadd           
        //    91: istore          40
        //    93: aload           38
        //    95: iload           39
        //    97: iload           40
        //    99: nop            
        //   100: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMax:(II)I
        //   103: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setLodCount:(I)V
        //   106: aload_0         /* this */
        //   107: iload_1         /* width */
        //   108: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setVirtualWidth:(I)V
        //   111: aload_0         /* this */
        //   112: iload_2         /* height */
        //   113: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setVirtualHeight:(I)V
        //   116: iload           lodSteps
        //   118: aload_0         /* this */
        //   119: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   122: if_icmple       129
        //   125: iconst_1       
        //   126: goto            130
        //   129: iconst_0       
        //   130: istore          createNativeMipMapForLastLod
        //   132: aload           region
        //   134: dup            
        //   135: ifnull          171
        //   138: astore          it
        //   140: iconst_0       
        //   141: istore          $i$a$-let-GlVirtualMipMapTexture$drawMipMap$2
        //   143: aload_0         /* this */
        //   144: aload           region
        //   146: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.width:()F
        //   149: iload_1         /* width */
        //   150: i2f            
        //   151: fdiv           
        //   152: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setSamplingX:(F)V
        //   155: aload_0         /* this */
        //   156: aload           region
        //   158: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.height:()F
        //   161: iload_2         /* height */
        //   162: i2f            
        //   163: fdiv           
        //   164: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setSamplingY:(F)V
        //   167: nop            
        //   168: goto            173
        //   171: pop            
        //   172: nop            
        //   173: iconst_0       
        //   174: istore          lod
        //   176: aload_0         /* this */
        //   177: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   180: istore          10
        //   182: iload           lod
        //   184: iload           10
        //   186: if_icmpge       786
        //   189: iconst_1       
        //   190: iload           lod
        //   192: ishl           
        //   193: istore          sample
        //   195: iload           createNativeMipMapForLastLod
        //   197: ifeq            215
        //   200: iload           lod
        //   202: aload_0         /* this */
        //   203: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   206: iconst_1       
        //   207: isub           
        //   208: if_icmpne       215
        //   211: iconst_1       
        //   212: goto            216
        //   215: iconst_0       
        //   216: istore          createMipMap
        //   218: iload           createMipMap
        //   220: ifeq            235
        //   223: iload_3         /* minOffset */
        //   224: iconst_1       
        //   225: iload           lodSteps
        //   227: iload           lod
        //   229: isub           
        //   230: ishl           
        //   231: imul           
        //   232: goto            236
        //   235: iload_3         /* minOffset */
        //   236: istore          offset
        //   238: iload           offset
        //   240: iconst_2       
        //   241: imul           
        //   242: iload_1         /* width */
        //   243: iload           sample
        //   245: idiv           
        //   246: iadd           
        //   247: iconst_1       
        //   248: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //   251: istore          lodWidth
        //   253: iload           offset
        //   255: iconst_2       
        //   256: imul           
        //   257: iload_2         /* height */
        //   258: iload           sample
        //   260: idiv           
        //   261: iadd           
        //   262: iconst_1       
        //   263: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //   266: istore          lodHeight
        //   268: iload           lod
        //   270: iconst_4       
        //   271: imul           
        //   272: istore          lodArrayOffset
        //   274: aload_0         /* this */
        //   275: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   278: iconst_0       
        //   279: iload           lodArrayOffset
        //   281: iadd           
        //   282: iload           lodWidth
        //   284: iastore        
        //   285: aload_0         /* this */
        //   286: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   289: iconst_1       
        //   290: iload           lodArrayOffset
        //   292: iadd           
        //   293: iload           lodHeight
        //   295: iastore        
        //   296: aload_0         /* this */
        //   297: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   300: iconst_2       
        //   301: iload           lodArrayOffset
        //   303: iadd           
        //   304: iload           offset
        //   306: iastore        
        //   307: aload_0         /* this */
        //   308: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   311: iconst_3       
        //   312: iload           lodArrayOffset
        //   314: iadd           
        //   315: iload           offset
        //   317: iconst_2       
        //   318: imul           
        //   319: iastore        
        //   320: aload_0         /* this */
        //   321: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getFrameBuffers:()Ljava/util/List;
        //   324: iload           lod
        //   326: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   331: astore          17
        //   333: aload           17
        //   335: checkcast       Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //   338: astore          $this$drawMipMap_u24lambda_u2d4
        //   340: iconst_0       
        //   341: istore          $i$a$-apply-GlVirtualMipMapTexture$drawMipMap$3
        //   343: nop            
        //   344: aload_0         /* this */
        //   345: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   348: iconst_1       
        //   349: if_icmpne       369
        //   352: aload           $this$drawMipMap_u24lambda_u2d4
        //   354: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   357: sipush          9987
        //   360: iconst_0       
        //   361: iconst_2       
        //   362: aconst_null    
        //   363: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   366: goto            405
        //   369: iload           createMipMap
        //   371: ifeq            391
        //   374: aload           $this$drawMipMap_u24lambda_u2d4
        //   376: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   379: sipush          9985
        //   382: iconst_0       
        //   383: iconst_2       
        //   384: aconst_null    
        //   385: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   388: goto            405
        //   391: aload           $this$drawMipMap_u24lambda_u2d4
        //   393: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   396: sipush          9729
        //   399: iconst_0       
        //   400: iconst_2       
        //   401: aconst_null    
        //   402: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   405: nop            
        //   406: nop            
        //   407: aload_0         /* this */
        //   408: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getFrameBuffers:()Ljava/util/List;
        //   411: iload           lod
        //   413: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   418: checkcast       Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //   421: astore          17
        //   423: iconst_1       
        //   424: istore          18
        //   426: nop            
        //   427: iconst_0       
        //   428: istore          $i$f$record
        //   430: aload           this_$iv
        //   432: iload           lodWidth
        //   434: iload           lodHeight
        //   436: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.changeSize:(II)V
        //   439: nop            
        //   440: iconst_0       
        //   441: istore          clearColor$iv$iv
        //   443: iconst_0       
        //   444: istore          $i$f$record
        //   446: nop            
        //   447: aload           this_$iv
        //   449: iload           doClear$iv
        //   451: iload           clearColor$iv$iv
        //   453: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //   456: iconst_0       
        //   457: istore          $i$a$-record-GlVirtualMipMapTexture$drawMipMap$4
        //   459: getstatic       ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.Companion:Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo$Companion;
        //   462: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo$Companion.obtain:()Ljava/lang/Object;
        //   465: checkcast       Lly/img/android/pesdk/backend/model/chunk/Recyclable;
        //   468: astore          $this$recycleAfter$iv
        //   470: iconst_0       
        //   471: istore          $i$f$recycleAfter
        //   473: aload           $this$recycleAfter$iv
        //   475: astore          it$iv
        //   477: iconst_0       
        //   478: istore          $i$a$-let-RecyclerPoolKt$recycleAfter$3$iv
        //   480: aload           it$iv
        //   482: checkcast       Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;
        //   485: astore          info
        //   487: iconst_0       
        //   488: istore          $i$a$-recycleAfter-GlVirtualMipMapTexture$drawMipMap$4$1
        //   490: aload           info
        //   492: iload           lodWidth
        //   494: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setXRes:(I)V
        //   497: aload           info
        //   499: iload           lodHeight
        //   501: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setYRes:(I)V
        //   504: aload           info
        //   506: iload           offset
        //   508: iload           sample
        //   510: imul           
        //   511: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetTop:(I)V
        //   514: aload           info
        //   516: iload           offset
        //   518: iload           sample
        //   520: imul           
        //   521: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetLeft:(I)V
        //   524: aload           info
        //   526: iload           offset
        //   528: iload           sample
        //   530: imul           
        //   531: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetRight:(I)V
        //   534: aload           info
        //   536: iload           offset
        //   538: iload           sample
        //   540: imul           
        //   541: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetBottom:(I)V
        //   544: aload           info
        //   546: iload           sample
        //   548: i2f            
        //   549: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setSourceSample:(F)V
        //   552: aload           info
        //   554: iload           offset
        //   556: i2f            
        //   557: iload           lodHeight
        //   559: i2f            
        //   560: fdiv           
        //   561: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetTop:(F)V
        //   564: aload           info
        //   566: iload           offset
        //   568: i2f            
        //   569: iload           lodWidth
        //   571: i2f            
        //   572: fdiv           
        //   573: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetLeft:(F)V
        //   576: aload           info
        //   578: iload           offset
        //   580: i2f            
        //   581: iload           lodWidth
        //   583: i2f            
        //   584: fdiv           
        //   585: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetRight:(F)V
        //   588: aload           info
        //   590: iload           offset
        //   592: i2f            
        //   593: iload           lodHeight
        //   595: i2f            
        //   596: fdiv           
        //   597: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetBottom:(F)V
        //   600: aload           region
        //   602: ifnull          678
        //   605: aload           info
        //   607: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getRegion:()Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   610: astore          29
        //   612: aload           29
        //   614: astore          it
        //   616: iconst_0       
        //   617: istore          $i$a$-also-GlVirtualMipMapTexture$drawMipMap$4$1$1
        //   619: aload           it
        //   621: aload           region
        //   623: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.set:(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)V
        //   626: aload           it
        //   628: aload           info
        //   630: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetLeft:()I
        //   633: i2f            
        //   634: aload_0         /* this */
        //   635: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingX:()F
        //   638: fmul           
        //   639: aload           info
        //   641: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetTop:()I
        //   644: i2f            
        //   645: aload_0         /* this */
        //   646: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingY:()F
        //   649: fmul           
        //   650: aload           info
        //   652: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetRight:()I
        //   655: i2f            
        //   656: aload_0         /* this */
        //   657: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingX:()F
        //   660: fmul           
        //   661: aload           info
        //   663: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetBottom:()I
        //   666: i2f            
        //   667: aload_0         /* this */
        //   668: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingY:()F
        //   671: fmul           
        //   672: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.addMargin:(FFFF)Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   675: pop            
        //   676: nop            
        //   677: nop            
        //   678: aload           drawTexture
        //   680: aload           info
        //   682: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   687: pop            
        //   688: nop            
        //   689: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   692: astore          $this$andRecycle$iv$iv
        //   694: iconst_0       
        //   695: istore          $i$f$andRecycle
        //   697: aload           $this$andRecycle$iv$iv
        //   699: astore          34
        //   701: aload           34
        //   703: astore          it$iv$iv
        //   705: iconst_0       
        //   706: istore          $i$a$-also-RecyclerPoolKt$andRecycle$3$iv$iv
        //   708: aload           it$iv
        //   710: invokeinterface ly/img/android/pesdk/backend/model/chunk/Recyclable.recycle:()V
        //   715: nop            
        //   716: nop            
        //   717: nop            
        //   718: nop            
        //   719: nop            
        //   720: nop            
        //   721: iconst_1       
        //   722: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   725: aload           this_$iv
        //   727: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   730: iconst_1       
        //   731: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   734: goto            778
        //   737: astore          e$iv$iv
        //   739: aload           e$iv$iv
        //   741: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   744: iconst_1       
        //   745: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   748: aload           this_$iv
        //   750: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   753: iconst_1       
        //   754: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   757: goto            778
        //   760: astore          37
        //   762: iconst_1       
        //   763: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   766: aload           this_$iv
        //   768: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   771: iconst_1       
        //   772: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   775: aload           37
        //   777: athrow         
        //   778: nop            
        //   779: nop            
        //   780: iinc            lod, 1
        //   783: goto            182
        //   786: aload_0         /* this */
        //   787: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   790: istore          lod
        //   792: iload           lod
        //   794: bipush          8
        //   796: if_icmpge       893
        //   799: iload           lod
        //   801: iconst_4       
        //   802: imul           
        //   803: istore          lodArrayOffset
        //   805: aload_0         /* this */
        //   806: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   809: iconst_1       
        //   810: isub           
        //   811: iconst_4       
        //   812: imul           
        //   813: istore          sourceArrayOffset
        //   815: aload_0         /* this */
        //   816: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   819: iconst_0       
        //   820: iload           lodArrayOffset
        //   822: iadd           
        //   823: aload_0         /* this */
        //   824: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   827: iconst_0       
        //   828: iload           sourceArrayOffset
        //   830: iadd           
        //   831: iaload         
        //   832: iastore        
        //   833: aload_0         /* this */
        //   834: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   837: iconst_1       
        //   838: iload           lodArrayOffset
        //   840: iadd           
        //   841: aload_0         /* this */
        //   842: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   845: iconst_1       
        //   846: iload           sourceArrayOffset
        //   848: iadd           
        //   849: iaload         
        //   850: iastore        
        //   851: aload_0         /* this */
        //   852: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   855: iconst_2       
        //   856: iload           lodArrayOffset
        //   858: iadd           
        //   859: aload_0         /* this */
        //   860: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   863: iconst_2       
        //   864: iload           sourceArrayOffset
        //   866: iadd           
        //   867: iaload         
        //   868: iastore        
        //   869: aload_0         /* this */
        //   870: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   873: iconst_3       
        //   874: iload           lodArrayOffset
        //   876: iadd           
        //   877: aload_0         /* this */
        //   878: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   881: iconst_3       
        //   882: iload           sourceArrayOffset
        //   884: iadd           
        //   885: iaload         
        //   886: iastore        
        //   887: iinc            lod, 1
        //   890: goto            792
        //   893: return         
        //    Signature:
        //  (IIILly/img/android/pesdk/backend/model/chunk/MultiRect;ILkotlin/jvm/functions/Function1<-Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;Lkotlin/Unit;>;)V
        //    StackMapTable: 00 13 FF 00 81 00 27 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 00 07 00 02 01 01 01 03 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 40 01 FF 00 28 00 27 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 07 00 02 01 01 01 03 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 01 07 00 D6 FF 00 01 00 27 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 07 00 02 00 01 01 03 03 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 FF 00 08 00 29 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 01 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 20 40 01 12 40 01 FF 00 84 00 29 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 01 01 01 01 01 01 01 01 07 01 83 07 00 18 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 15 0D FF 01 10 00 29 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 01 01 01 01 01 01 01 01 07 00 18 01 01 01 01 01 07 00 FC 01 07 00 FC 01 07 00 F1 01 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 FF 00 3A 00 29 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 01 01 01 01 01 01 01 01 07 00 18 01 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 01 07 00 A1 56 07 01 85 11 FF 00 07 00 29 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 01 01 01 01 01 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 00 07 00 02 01 01 00 00 05 FB 00 64
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  446    721    737    760    Ljava/lang/Exception;
        //  446    721    760    778    Any
        //  737    744    760    778    Any
        //  760    762    760    778    Any
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
    
    public final void generateMipMap(final int width, final int height, final int minOffset, @NotNull final MultiRect region, final int lodSteps, @NotNull final Function1<? super StepInfo, ? extends GlTexture> getTexture) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     2: ldc_w           "region"
        //     5: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     8: aload           getTexture
        //    10: ldc_w           "getTexture"
        //    13: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    16: iconst_0       
        //    17: istore          $i$f$generateMipMap
        //    19: aload_0         /* this */
        //    20: astore          this_$iv
        //    22: iconst_0       
        //    23: istore          $i$f$drawMipMap
        //    25: aload           this_$iv
        //    27: iload_3         /* minOffset */
        //    28: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setOffset:(I)V
        //    31: aload           this_$iv
        //    33: iload           lodSteps
        //    35: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setLodSteps:(I)V
        //    38: aload           this_$iv
        //    40: bipush          8
        //    42: aload           this_$iv
        //    44: checkcast       Lly/img/android/opengl/textures/GlVirtualMipMapTexture;
        //    47: astore          10
        //    49: istore          11
        //    51: astore          12
        //    53: iconst_0       
        //    54: istore          $i$a$-run-GlVirtualMipMapTexture$drawMipMap$1$iv
        //    56: iload_3         /* minOffset */
        //    57: iconst_1       
        //    58: iload           lodSteps
        //    60: ishl           
        //    61: imul           
        //    62: istore          maxOffset$iv
        //    64: iload           maxOffset$iv
        //    66: iload_1         /* width */
        //    67: iload_2         /* height */
        //    68: invokestatic    java/lang/Math.max:(II)I
        //    71: iadd           
        //    72: istore          neededRange$iv
        //    74: iload           neededRange$iv
        //    76: i2d            
        //    77: getstatic       ly/img/android/opengl/textures/GlTexture.Companion:Lly/img/android/opengl/textures/GlTexture$Companion;
        //    80: invokevirtual   ly/img/android/opengl/textures/GlTexture$Companion.getMaxTextureSize:()I
        //    83: i2d            
        //    84: ldc2_w          2.0
        //    87: ddiv           
        //    88: ddiv           
        //    89: dconst_1       
        //    90: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(DD)D
        //    93: dstore          neededScale$iv
        //    95: dload           neededScale$iv
        //    97: invokestatic    kotlin/math/MathKt.log2:(D)D
        //   100: dstore          maxNeededLod$iv
        //   102: dload           maxNeededLod$iv
        //   104: invokestatic    java/lang/Math.ceil:(D)D
        //   107: d2i            
        //   108: iconst_1       
        //   109: iadd           
        //   110: istore          20
        //   112: aload           12
        //   114: iload           11
        //   116: iload           20
        //   118: nop            
        //   119: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMax:(II)I
        //   122: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setLodCount:(I)V
        //   125: aload           this_$iv
        //   127: iload_1         /* width */
        //   128: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setVirtualWidth:(I)V
        //   131: aload           this_$iv
        //   133: iload_2         /* height */
        //   134: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setVirtualHeight:(I)V
        //   137: iload           lodSteps
        //   139: aload           this_$iv
        //   141: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   144: if_icmple       151
        //   147: iconst_1       
        //   148: goto            152
        //   151: iconst_0       
        //   152: istore          createNativeMipMapForLastLod$iv
        //   154: aload           region
        //   156: astore          it$iv
        //   158: iconst_0       
        //   159: istore          $i$a$-let-GlVirtualMipMapTexture$drawMipMap$2$iv
        //   161: aload           this_$iv
        //   163: aload           region
        //   165: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.width:()F
        //   168: iload_1         /* width */
        //   169: i2f            
        //   170: fdiv           
        //   171: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setSamplingX:(F)V
        //   174: aload           this_$iv
        //   176: aload           region
        //   178: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.height:()F
        //   181: iload_2         /* height */
        //   182: i2f            
        //   183: fdiv           
        //   184: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.setSamplingY:(F)V
        //   187: nop            
        //   188: nop            
        //   189: iconst_0       
        //   190: istore          lod$iv
        //   192: aload           this_$iv
        //   194: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   197: istore          13
        //   199: iload           lod$iv
        //   201: iload           13
        //   203: if_icmpge       881
        //   206: iconst_1       
        //   207: iload           lod$iv
        //   209: ishl           
        //   210: istore          sample$iv
        //   212: iload           createNativeMipMapForLastLod$iv
        //   214: ifeq            233
        //   217: iload           lod$iv
        //   219: aload           this_$iv
        //   221: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   224: iconst_1       
        //   225: isub           
        //   226: if_icmpne       233
        //   229: iconst_1       
        //   230: goto            234
        //   233: iconst_0       
        //   234: istore          createMipMap$iv
        //   236: iload           createMipMap$iv
        //   238: ifeq            253
        //   241: iload_3         /* minOffset */
        //   242: iconst_1       
        //   243: iload           lodSteps
        //   245: iload           lod$iv
        //   247: isub           
        //   248: ishl           
        //   249: imul           
        //   250: goto            254
        //   253: iload_3         /* minOffset */
        //   254: istore          offset$iv
        //   256: iload           offset$iv
        //   258: iconst_2       
        //   259: imul           
        //   260: iload_1         /* width */
        //   261: iload           sample$iv
        //   263: idiv           
        //   264: iadd           
        //   265: iconst_1       
        //   266: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //   269: istore          lodWidth$iv
        //   271: iload           offset$iv
        //   273: iconst_2       
        //   274: imul           
        //   275: iload_2         /* height */
        //   276: iload           sample$iv
        //   278: idiv           
        //   279: iadd           
        //   280: iconst_1       
        //   281: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //   284: istore          lodHeight$iv
        //   286: iload           lod$iv
        //   288: iconst_4       
        //   289: imul           
        //   290: istore          lodArrayOffset$iv
        //   292: aload           this_$iv
        //   294: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   297: iconst_0       
        //   298: iload           lodArrayOffset$iv
        //   300: iadd           
        //   301: iload           lodWidth$iv
        //   303: iastore        
        //   304: aload           this_$iv
        //   306: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   309: iconst_1       
        //   310: iload           lodArrayOffset$iv
        //   312: iadd           
        //   313: iload           lodHeight$iv
        //   315: iastore        
        //   316: aload           this_$iv
        //   318: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   321: iconst_2       
        //   322: iload           lodArrayOffset$iv
        //   324: iadd           
        //   325: iload           offset$iv
        //   327: iastore        
        //   328: aload           this_$iv
        //   330: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   333: iconst_3       
        //   334: iload           lodArrayOffset$iv
        //   336: iadd           
        //   337: iload           offset$iv
        //   339: iconst_2       
        //   340: imul           
        //   341: iastore        
        //   342: aload           this_$iv
        //   344: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getFrameBuffers:()Ljava/util/List;
        //   347: iload           lod$iv
        //   349: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   354: astore          26
        //   356: aload           26
        //   358: checkcast       Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //   361: astore          $this$drawMipMap_u24lambda_u2d4$iv
        //   363: iconst_0       
        //   364: istore          $i$a$-apply-GlVirtualMipMapTexture$drawMipMap$3$iv
        //   366: nop            
        //   367: aload           this_$iv
        //   369: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   372: iconst_1       
        //   373: if_icmpne       393
        //   376: aload           $this$drawMipMap_u24lambda_u2d4$iv
        //   378: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   381: sipush          9987
        //   384: iconst_0       
        //   385: iconst_2       
        //   386: aconst_null    
        //   387: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   390: goto            429
        //   393: iload           createMipMap$iv
        //   395: ifeq            415
        //   398: aload           $this$drawMipMap_u24lambda_u2d4$iv
        //   400: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   403: sipush          9985
        //   406: iconst_0       
        //   407: iconst_2       
        //   408: aconst_null    
        //   409: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   412: goto            429
        //   415: aload           $this$drawMipMap_u24lambda_u2d4$iv
        //   417: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   420: sipush          9729
        //   423: iconst_0       
        //   424: iconst_2       
        //   425: aconst_null    
        //   426: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   429: nop            
        //   430: nop            
        //   431: aload           this_$iv
        //   433: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getFrameBuffers:()Ljava/util/List;
        //   436: iload           lod$iv
        //   438: invokeinterface java/util/List.get:(I)Ljava/lang/Object;
        //   443: checkcast       Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //   446: astore          26
        //   448: iconst_1       
        //   449: istore          27
        //   451: nop            
        //   452: iconst_0       
        //   453: istore          $i$f$record
        //   455: aload           this_$iv$iv
        //   457: iload           lodWidth$iv
        //   459: iload           lodHeight$iv
        //   461: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.changeSize:(II)V
        //   464: nop            
        //   465: iconst_0       
        //   466: istore          clearColor$iv$iv$iv
        //   468: iconst_0       
        //   469: istore          $i$f$record
        //   471: nop            
        //   472: aload           this_$iv$iv
        //   474: iload           doClear$iv$iv
        //   476: iload           clearColor$iv$iv$iv
        //   478: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //   481: iconst_0       
        //   482: istore          $i$a$-record-GlVirtualMipMapTexture$drawMipMap$4$iv
        //   484: getstatic       ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.Companion:Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo$Companion;
        //   487: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo$Companion.obtain:()Ljava/lang/Object;
        //   490: checkcast       Lly/img/android/pesdk/backend/model/chunk/Recyclable;
        //   493: astore          $this$recycleAfter$iv$iv
        //   495: iconst_0       
        //   496: istore          $i$f$recycleAfter
        //   498: aload           $this$recycleAfter$iv$iv
        //   500: astore          it$iv$iv
        //   502: iconst_0       
        //   503: istore          $i$a$-let-RecyclerPoolKt$recycleAfter$3$iv$iv
        //   505: aload           it$iv$iv
        //   507: checkcast       Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;
        //   510: astore          info$iv
        //   512: iconst_0       
        //   513: istore          $i$a$-recycleAfter-GlVirtualMipMapTexture$drawMipMap$4$1$iv
        //   515: aload           info$iv
        //   517: iload           lodWidth$iv
        //   519: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setXRes:(I)V
        //   522: aload           info$iv
        //   524: iload           lodHeight$iv
        //   526: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setYRes:(I)V
        //   529: aload           info$iv
        //   531: iload           offset$iv
        //   533: iload           sample$iv
        //   535: imul           
        //   536: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetTop:(I)V
        //   539: aload           info$iv
        //   541: iload           offset$iv
        //   543: iload           sample$iv
        //   545: imul           
        //   546: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetLeft:(I)V
        //   549: aload           info$iv
        //   551: iload           offset$iv
        //   553: iload           sample$iv
        //   555: imul           
        //   556: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetRight:(I)V
        //   559: aload           info$iv
        //   561: iload           offset$iv
        //   563: iload           sample$iv
        //   565: imul           
        //   566: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setOffsetBottom:(I)V
        //   569: aload           info$iv
        //   571: iload           sample$iv
        //   573: i2f            
        //   574: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setSourceSample:(F)V
        //   577: aload           info$iv
        //   579: iload           offset$iv
        //   581: i2f            
        //   582: iload           lodHeight$iv
        //   584: i2f            
        //   585: fdiv           
        //   586: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetTop:(F)V
        //   589: aload           info$iv
        //   591: iload           offset$iv
        //   593: i2f            
        //   594: iload           lodWidth$iv
        //   596: i2f            
        //   597: fdiv           
        //   598: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetLeft:(F)V
        //   601: aload           info$iv
        //   603: iload           offset$iv
        //   605: i2f            
        //   606: iload           lodWidth$iv
        //   608: i2f            
        //   609: fdiv           
        //   610: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetRight:(F)V
        //   613: aload           info$iv
        //   615: iload           offset$iv
        //   617: i2f            
        //   618: iload           lodHeight$iv
        //   620: i2f            
        //   621: fdiv           
        //   622: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.setRelativeOffsetBottom:(F)V
        //   625: aload           region
        //   627: ifnull          707
        //   630: aload           info$iv
        //   632: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getRegion:()Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   635: astore          38
        //   637: aload           38
        //   639: astore          it$iv
        //   641: iconst_0       
        //   642: istore          $i$a$-also-GlVirtualMipMapTexture$drawMipMap$4$1$1$iv
        //   644: aload           it$iv
        //   646: aload           region
        //   648: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.set:(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)V
        //   651: aload           it$iv
        //   653: aload           info$iv
        //   655: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetLeft:()I
        //   658: i2f            
        //   659: aload           this_$iv
        //   661: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingX:()F
        //   664: fmul           
        //   665: aload           info$iv
        //   667: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetTop:()I
        //   670: i2f            
        //   671: aload           this_$iv
        //   673: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingY:()F
        //   676: fmul           
        //   677: aload           info$iv
        //   679: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetRight:()I
        //   682: i2f            
        //   683: aload           this_$iv
        //   685: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingX:()F
        //   688: fmul           
        //   689: aload           info$iv
        //   691: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo.getOffsetBottom:()I
        //   694: i2f            
        //   695: aload           this_$iv
        //   697: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getSamplingY:()F
        //   700: fmul           
        //   701: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.addMargin:(FFFF)Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   704: pop            
        //   705: nop            
        //   706: nop            
        //   707: aload           info$iv
        //   709: astore          stepInfo
        //   711: iconst_0       
        //   712: istore          $i$a$-drawMipMap-GlVirtualMipMapTexture$generateMipMap$1
        //   714: aload           getTexture
        //   716: aload           stepInfo
        //   718: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   723: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   726: astore          texture
        //   728: aload_0         /* this */
        //   729: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getMipMapShape:()Lly/img/android/opengl/canvas/GlRect;
        //   732: astore          44
        //   734: aload_0         /* this */
        //   735: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getCopyProgram:()Lly/img/android/opengl/programs/GlProgramShapeDraw;
        //   738: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //   741: astore          program$iv
        //   743: iconst_0       
        //   744: istore          $i$f$drawWith
        //   746: aload           this_$iv
        //   748: aload           program$iv
        //   750: invokevirtual   ly/img/android/opengl/canvas/GlRect.enable:(Lly/img/android/opengl/canvas/GlProgram;)V
        //   753: aload           program$iv
        //   755: checkcast       Lly/img/android/opengl/programs/GlProgramShapeDraw;
        //   758: astore          it
        //   760: iconst_0       
        //   761: istore          $i$a$-drawWith-GlVirtualMipMapTexture$generateMipMap$1$1
        //   763: aload           it
        //   765: aload           texture
        //   767: invokevirtual   ly/img/android/opengl/programs/GlProgramShapeDraw.setUniformImage:(Lly/img/android/opengl/textures/GlTexture;)V
        //   770: nop            
        //   771: aload           this_$iv
        //   773: invokevirtual   ly/img/android/opengl/canvas/GlRect.draw:()V
        //   776: aload           this_$iv
        //   778: invokevirtual   ly/img/android/opengl/canvas/GlRect.disable:()V
        //   781: nop            
        //   782: nop            
        //   783: nop            
        //   784: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   787: astore          $this$andRecycle$iv$iv$iv
        //   789: iconst_0       
        //   790: istore          $i$f$andRecycle
        //   792: aload           $this$andRecycle$iv$iv$iv
        //   794: astore          51
        //   796: aload           51
        //   798: astore          it$iv$iv$iv
        //   800: iconst_0       
        //   801: istore          $i$a$-also-RecyclerPoolKt$andRecycle$3$iv$iv$iv
        //   803: aload           it$iv$iv
        //   805: invokeinterface ly/img/android/pesdk/backend/model/chunk/Recyclable.recycle:()V
        //   810: nop            
        //   811: nop            
        //   812: nop            
        //   813: nop            
        //   814: nop            
        //   815: nop            
        //   816: iconst_1       
        //   817: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   820: aload           this_$iv$iv
        //   822: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   825: iconst_1       
        //   826: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   829: goto            873
        //   832: astore          e$iv$iv$iv
        //   834: aload           e$iv$iv$iv
        //   836: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   839: iconst_1       
        //   840: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   843: aload           this_$iv$iv
        //   845: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   848: iconst_1       
        //   849: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   852: goto            873
        //   855: astore          54
        //   857: iconst_1       
        //   858: invokestatic    kotlin/jvm/internal/InlineMarker.finallyStart:(I)V
        //   861: aload           this_$iv$iv
        //   863: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   866: iconst_1       
        //   867: invokestatic    kotlin/jvm/internal/InlineMarker.finallyEnd:(I)V
        //   870: aload           54
        //   872: athrow         
        //   873: nop            
        //   874: nop            
        //   875: iinc            lod$iv, 1
        //   878: goto            199
        //   881: aload           this_$iv
        //   883: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   886: istore          lod$iv
        //   888: iload           lod$iv
        //   890: bipush          8
        //   892: if_icmpge       998
        //   895: iload           lod$iv
        //   897: iconst_4       
        //   898: imul           
        //   899: istore          lodArrayOffset$iv
        //   901: aload           this_$iv
        //   903: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodCount:()I
        //   906: iconst_1       
        //   907: isub           
        //   908: iconst_4       
        //   909: imul           
        //   910: istore          sourceArrayOffset$iv
        //   912: aload           this_$iv
        //   914: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   917: iconst_0       
        //   918: iload           lodArrayOffset$iv
        //   920: iadd           
        //   921: aload           this_$iv
        //   923: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   926: iconst_0       
        //   927: iload           sourceArrayOffset$iv
        //   929: iadd           
        //   930: iaload         
        //   931: iastore        
        //   932: aload           this_$iv
        //   934: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   937: iconst_1       
        //   938: iload           lodArrayOffset$iv
        //   940: iadd           
        //   941: aload           this_$iv
        //   943: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   946: iconst_1       
        //   947: iload           sourceArrayOffset$iv
        //   949: iadd           
        //   950: iaload         
        //   951: iastore        
        //   952: aload           this_$iv
        //   954: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   957: iconst_2       
        //   958: iload           lodArrayOffset$iv
        //   960: iadd           
        //   961: aload           this_$iv
        //   963: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   966: iconst_2       
        //   967: iload           sourceArrayOffset$iv
        //   969: iadd           
        //   970: iaload         
        //   971: iastore        
        //   972: aload           this_$iv
        //   974: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   977: iconst_3       
        //   978: iload           lodArrayOffset$iv
        //   980: iadd           
        //   981: aload           this_$iv
        //   983: invokevirtual   ly/img/android/opengl/textures/GlVirtualMipMapTexture.getLodRectValues:()[I
        //   986: iconst_3       
        //   987: iload           sourceArrayOffset$iv
        //   989: iadd           
        //   990: iaload         
        //   991: iastore        
        //   992: iinc            lod$iv, 1
        //   995: goto            888
        //   998: nop            
        //   999: return         
        //    Signature:
        //  (IIILly/img/android/pesdk/backend/model/chunk/MultiRect;ILkotlin/jvm/functions/Function1<-Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;+Lly/img/android/opengl/textures/GlTexture;>;)V
        //    StackMapTable: 00 11 FF 00 97 00 13 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 07 00 02 01 07 00 02 01 01 01 03 03 01 00 00 40 01 FF 00 2E 00 14 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 01 01 07 00 02 01 01 01 03 03 01 01 00 00 21 40 01 12 40 01 FF 00 8A 00 1B 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 01 01 07 00 02 01 01 01 03 03 01 01 01 01 01 01 07 01 83 07 00 18 01 00 00 15 0D FF 01 15 00 24 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 01 01 07 00 02 01 01 01 03 03 01 01 01 01 01 01 07 00 18 01 01 01 01 01 07 00 FC 01 07 00 FC 01 07 00 F1 01 00 00 FF 00 7C 00 1D 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 01 01 07 00 02 01 01 01 03 03 01 01 01 01 01 01 07 00 18 01 01 01 01 00 01 07 00 A1 56 07 01 85 11 FF 00 07 00 14 07 00 02 01 01 01 07 00 D6 01 07 01 3B 01 07 00 02 01 01 01 07 00 02 01 01 01 03 03 01 01 00 00 06 FB 00 6D
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  471    816    832    855    Ljava/lang/Exception;
        //  471    816    855    873    Any
        //  832    839    855    873    Any
        //  855    857    855    873    Any
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
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006" }, d2 = { "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;", "", "(Ljava/lang/String;I)V", "NATIVE_MIP_MAP", "TEXTURE_ARRAY", "TEXTURE_CHOICE", "pesdk-backend-core_release" })
    public enum VirtualTextureType
    {
        NATIVE_MIP_MAP, 
        TEXTURE_ARRAY, 
        TEXTURE_CHOICE;
        
        private static final /* synthetic */ VirtualTextureType[] $values() {
            return new VirtualTextureType[] { VirtualTextureType.NATIVE_MIP_MAP, VirtualTextureType.TEXTURE_ARRAY, VirtualTextureType.TEXTURE_CHOICE };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005" }, d2 = { "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$Companion;", "", "()V", "MAX_LOD", "", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b6\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0086\b\u0018\u0000 L2\u00020\u0001:\u0001LB}\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0005\u0012\b\b\u0002\u0010\b\u001a\u00020\u0005\u0012\b\b\u0002\u0010\t\u001a\u00020\u0005\u0012\b\b\u0002\u0010\n\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\f\u0012\b\b\u0002\u0010\u000f\u001a\u00020\f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\f¢\u0006\u0002\u0010\u0011J\t\u00105\u001a\u00020\u0003H\u00c6\u0003J\t\u00106\u001a\u00020\fH\u00c6\u0003J\t\u00107\u001a\u00020\fH\u00c6\u0003J\t\u00108\u001a\u00020\fH\u00c6\u0003J\t\u00109\u001a\u00020\u0005H\u00c6\u0003J\t\u0010:\u001a\u00020\u0005H\u00c6\u0003J\t\u0010;\u001a\u00020\u0005H\u00c6\u0003J\t\u0010<\u001a\u00020\u0005H\u00c6\u0003J\t\u0010=\u001a\u00020\u0005H\u00c6\u0003J\t\u0010>\u001a\u00020\u0005H\u00c6\u0003J\t\u0010?\u001a\u00020\fH\u00c6\u0003J\t\u0010@\u001a\u00020\fH\u00c6\u0003J\u0081\u0001\u0010A\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\b\b\u0002\u0010\b\u001a\u00020\u00052\b\b\u0002\u0010\t\u001a\u00020\u00052\b\b\u0002\u0010\n\u001a\u00020\u00052\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\f2\b\b\u0002\u0010\u000f\u001a\u00020\f2\b\b\u0002\u0010\u0010\u001a\u00020\fH\u00c6\u0001J\u0013\u0010B\u001a\u00020C2\b\u0010D\u001a\u0004\u0018\u00010EH\u00d6\u0003J\t\u0010F\u001a\u00020\u0005H\u00d6\u0001J\b\u0010G\u001a\u00020HH\u0016J\b\u0010I\u001a\u00020HH\u0016J\t\u0010J\u001a\u00020KH\u00d6\u0001R\u001c\u0010\u0012\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010\n\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\u0018\"\u0004\b\u0019\u0010\u001aR\u001a\u0010\b\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0018\"\u0004\b\u001c\u0010\u001aR\u001a\u0010\t\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0018\"\u0004\b\u001e\u0010\u001aR\u001a\u0010\u0007\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0018\"\u0004\b \u0010\u001aR\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b!\u0010\"\"\u0004\b#\u0010$R\u001a\u0010\u000f\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010&\"\u0004\b'\u0010(R\u001a\u0010\r\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010&\"\u0004\b*\u0010(R\u001a\u0010\u000e\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b+\u0010&\"\u0004\b,\u0010(R\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010&\"\u0004\b.\u0010(R\u001a\u0010\u0010\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b/\u0010&\"\u0004\b0\u0010(R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b1\u0010\u0018\"\u0004\b2\u0010\u001aR\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b3\u0010\u0018\"\u0004\b4\u0010\u001a¨\u0006M" }, d2 = { "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;", "Lly/img/android/pesdk/backend/model/chunk/Recyclable;", "region", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "xRes", "", "yRes", "offsetTop", "offsetLeft", "offsetRight", "offsetBottom", "relativeOffsetTop", "", "relativeOffsetLeft", "relativeOffsetRight", "relativeOffsetBottom", "sourceSample", "(Lly/img/android/pesdk/backend/model/chunk/MultiRect;IIIIIIFFFFF)V", "alsoRecyclable", "getAlsoRecyclable", "()Lly/img/android/pesdk/backend/model/chunk/Recyclable;", "setAlsoRecyclable", "(Lly/img/android/pesdk/backend/model/chunk/Recyclable;)V", "getOffsetBottom", "()I", "setOffsetBottom", "(I)V", "getOffsetLeft", "setOffsetLeft", "getOffsetRight", "setOffsetRight", "getOffsetTop", "setOffsetTop", "getRegion", "()Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "setRegion", "(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)V", "getRelativeOffsetBottom", "()F", "setRelativeOffsetBottom", "(F)V", "getRelativeOffsetLeft", "setRelativeOffsetLeft", "getRelativeOffsetRight", "setRelativeOffsetRight", "getRelativeOffsetTop", "setRelativeOffsetTop", "getSourceSample", "setSourceSample", "getXRes", "setXRes", "getYRes", "setYRes", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "", "other", "", "hashCode", "onRecycle", "", "recycle", "toString", "", "Companion", "pesdk-backend-core_release" })
    public static final class StepInfo implements Recyclable
    {
        @NotNull
        public static final Companion Companion;
        @NotNull
        private MultiRect region;
        private int xRes;
        private int yRes;
        private int offsetTop;
        private int offsetLeft;
        private int offsetRight;
        private int offsetBottom;
        private float relativeOffsetTop;
        private float relativeOffsetLeft;
        private float relativeOffsetRight;
        private float relativeOffsetBottom;
        private float sourceSample;
        @Nullable
        private Recyclable alsoRecyclable;
        
        public StepInfo(@NotNull final MultiRect region, final int xRes, final int yRes, final int offsetTop, final int offsetLeft, final int offsetRight, final int offsetBottom, final float relativeOffsetTop, final float relativeOffsetLeft, final float relativeOffsetRight, final float relativeOffsetBottom, final float sourceSample) {
            Intrinsics.checkNotNullParameter((Object)region, "region");
            this.region = region;
            this.xRes = xRes;
            this.yRes = yRes;
            this.offsetTop = offsetTop;
            this.offsetLeft = offsetLeft;
            this.offsetRight = offsetRight;
            this.offsetBottom = offsetBottom;
            this.relativeOffsetTop = relativeOffsetTop;
            this.relativeOffsetLeft = relativeOffsetLeft;
            this.relativeOffsetRight = relativeOffsetRight;
            this.relativeOffsetBottom = relativeOffsetBottom;
            this.sourceSample = sourceSample;
        }
        
        @NotNull
        public final MultiRect getRegion() {
            return this.region;
        }
        
        public final void setRegion(@NotNull final MultiRect <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.region = <set-?>;
        }
        
        public final int getXRes() {
            return this.xRes;
        }
        
        public final void setXRes(final int <set-?>) {
            this.xRes = <set-?>;
        }
        
        public final int getYRes() {
            return this.yRes;
        }
        
        public final void setYRes(final int <set-?>) {
            this.yRes = <set-?>;
        }
        
        public final int getOffsetTop() {
            return this.offsetTop;
        }
        
        public final void setOffsetTop(final int <set-?>) {
            this.offsetTop = <set-?>;
        }
        
        public final int getOffsetLeft() {
            return this.offsetLeft;
        }
        
        public final void setOffsetLeft(final int <set-?>) {
            this.offsetLeft = <set-?>;
        }
        
        public final int getOffsetRight() {
            return this.offsetRight;
        }
        
        public final void setOffsetRight(final int <set-?>) {
            this.offsetRight = <set-?>;
        }
        
        public final int getOffsetBottom() {
            return this.offsetBottom;
        }
        
        public final void setOffsetBottom(final int <set-?>) {
            this.offsetBottom = <set-?>;
        }
        
        public final float getRelativeOffsetTop() {
            return this.relativeOffsetTop;
        }
        
        public final void setRelativeOffsetTop(final float <set-?>) {
            this.relativeOffsetTop = <set-?>;
        }
        
        public final float getRelativeOffsetLeft() {
            return this.relativeOffsetLeft;
        }
        
        public final void setRelativeOffsetLeft(final float <set-?>) {
            this.relativeOffsetLeft = <set-?>;
        }
        
        public final float getRelativeOffsetRight() {
            return this.relativeOffsetRight;
        }
        
        public final void setRelativeOffsetRight(final float <set-?>) {
            this.relativeOffsetRight = <set-?>;
        }
        
        public final float getRelativeOffsetBottom() {
            return this.relativeOffsetBottom;
        }
        
        public final void setRelativeOffsetBottom(final float <set-?>) {
            this.relativeOffsetBottom = <set-?>;
        }
        
        public final float getSourceSample() {
            return this.sourceSample;
        }
        
        public final void setSourceSample(final float <set-?>) {
            this.sourceSample = <set-?>;
        }
        
        @Nullable
        @Override
        public Recyclable getAlsoRecyclable() {
            return this.alsoRecyclable;
        }
        
        @Override
        public void setAlsoRecyclable(@Nullable final Recyclable <set-?>) {
            this.alsoRecyclable = <set-?>;
        }
        
        @Override
        public void recycle() {
            StepInfo.Companion.recycle(this);
        }
        
        @Override
        public void onRecycle() {
            this.region.reset();
            this.offsetTop = 0;
            this.offsetLeft = 0;
            this.offsetRight = 0;
            this.offsetBottom = 0;
            this.relativeOffsetTop = 0.0f;
            this.relativeOffsetLeft = 0.0f;
            this.relativeOffsetRight = 0.0f;
            this.relativeOffsetBottom = 0.0f;
            this.sourceSample = 1.0f;
        }
        
        @NotNull
        public final MultiRect component1() {
            return this.region;
        }
        
        public final int component2() {
            return this.xRes;
        }
        
        public final int component3() {
            return this.yRes;
        }
        
        public final int component4() {
            return this.offsetTop;
        }
        
        public final int component5() {
            return this.offsetLeft;
        }
        
        public final int component6() {
            return this.offsetRight;
        }
        
        public final int component7() {
            return this.offsetBottom;
        }
        
        public final float component8() {
            return this.relativeOffsetTop;
        }
        
        public final float component9() {
            return this.relativeOffsetLeft;
        }
        
        public final float component10() {
            return this.relativeOffsetRight;
        }
        
        public final float component11() {
            return this.relativeOffsetBottom;
        }
        
        public final float component12() {
            return this.sourceSample;
        }
        
        @NotNull
        public final StepInfo copy(@NotNull final MultiRect region, final int xRes, final int yRes, final int offsetTop, final int offsetLeft, final int offsetRight, final int offsetBottom, final float relativeOffsetTop, final float relativeOffsetLeft, final float relativeOffsetRight, final float relativeOffsetBottom, final float sourceSample) {
            Intrinsics.checkNotNullParameter((Object)region, "region");
            return new StepInfo(region, xRes, yRes, offsetTop, offsetLeft, offsetRight, offsetBottom, relativeOffsetTop, relativeOffsetLeft, relativeOffsetRight, relativeOffsetBottom, sourceSample);
        }
        
        @NotNull
        @Override
        public String toString() {
            final StringBuilder sb = new StringBuilder();
            sb.append("StepInfo(region=").append(this.region).append(", xRes=").append(this.xRes).append(", yRes=").append(this.yRes).append(", offsetTop=").append(this.offsetTop).append(", offsetLeft=").append(this.offsetLeft).append(", offsetRight=").append(this.offsetRight).append(", offsetBottom=").append(this.offsetBottom).append(", relativeOffsetTop=").append(this.relativeOffsetTop).append(", relativeOffsetLeft=").append(this.relativeOffsetLeft).append(", relativeOffsetRight=").append(this.relativeOffsetRight).append(", relativeOffsetBottom=").append(this.relativeOffsetBottom).append(", sourceSample=");
            sb.append(this.sourceSample).append(')');
            return sb.toString();
        }
        
        @Override
        public int hashCode() {
            int result = this.region.hashCode();
            result = result * 31 + Integer.hashCode(this.xRes);
            result = result * 31 + Integer.hashCode(this.yRes);
            result = result * 31 + Integer.hashCode(this.offsetTop);
            result = result * 31 + Integer.hashCode(this.offsetLeft);
            result = result * 31 + Integer.hashCode(this.offsetRight);
            result = result * 31 + Integer.hashCode(this.offsetBottom);
            result = result * 31 + Float.hashCode(this.relativeOffsetTop);
            result = result * 31 + Float.hashCode(this.relativeOffsetLeft);
            result = result * 31 + Float.hashCode(this.relativeOffsetRight);
            result = result * 31 + Float.hashCode(this.relativeOffsetBottom);
            result = result * 31 + Float.hashCode(this.sourceSample);
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof StepInfo)) {
                return false;
            }
            final StepInfo stepInfo = (StepInfo)other;
            return Intrinsics.areEqual((Object)this.region, (Object)stepInfo.region) && this.xRes == stepInfo.xRes && this.yRes == stepInfo.yRes && this.offsetTop == stepInfo.offsetTop && this.offsetLeft == stepInfo.offsetLeft && this.offsetRight == stepInfo.offsetRight && this.offsetBottom == stepInfo.offsetBottom && Intrinsics.areEqual((Object)this.relativeOffsetTop, (Object)stepInfo.relativeOffsetTop) && Intrinsics.areEqual((Object)this.relativeOffsetLeft, (Object)stepInfo.relativeOffsetLeft) && Intrinsics.areEqual((Object)this.relativeOffsetRight, (Object)stepInfo.relativeOffsetRight) && Intrinsics.areEqual((Object)this.relativeOffsetBottom, (Object)stepInfo.relativeOffsetBottom) && Intrinsics.areEqual((Object)this.sourceSample, (Object)stepInfo.sourceSample);
        }
        
        public StepInfo() {
            this(null, 0, 0, 0, 0, 0, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 4095, null);
        }
        
        static {
            Companion = new Companion((DefaultConstructorMarker)null);
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003¨\u0006\u0004" }, d2 = { "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo$Companion;", "Lly/img/android/pesdk/backend/model/chunk/Recycler;", "Lly/img/android/opengl/textures/GlVirtualMipMapTexture$StepInfo;", "()V", "pesdk-backend-core_release" })
        public static final class Companion extends Recycler<StepInfo>
        {
            private Companion() {
                super(16, (Function0)GlVirtualMipMapTexture$StepInfo$Companion$1.INSTANCE);
            }
        }
    }
}
