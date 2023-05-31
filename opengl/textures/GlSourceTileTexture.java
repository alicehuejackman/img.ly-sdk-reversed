// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import android.graphics.RectF;
import ly.img.android.pesdk.backend.model.ImageSize;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.R$drawable;
import androidx.annotation.AnyThread;
import ly.img.android.pesdk.utils.ThreadUtils;
import android.graphics.Paint;
import ly.img.android.opengl.programs.GlProgramTileDraw;
import ly.img.android.opengl.canvas.GlRect;
import java.util.concurrent.atomic.AtomicBoolean;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.locks.ReentrantLock;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.decoder.ImageSource;
import kotlin.Metadata;
import ly.img.android.opengl.canvas.GlObject;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010>\u001a\u00020\u0019J \u0010?\u001a\u00020\u00192\u0006\u0010@\u001a\u0002032\u0006\u0010A\u001a\u00020B2\b\b\u0002\u0010C\u001a\u00020\u0019J \u0010D\u001a\u00020\u00192\u0006\u0010@\u001a\u0002032\u0006\u0010<\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0002J\b\u0010E\u001a\u00020&H\u0014J\u0011\u0010F\u001a\u00020&2\u0006\u0010G\u001a\u00020\u0019H\u0082\bJ\u0016\u0010H\u001a\u00020&2\u0006\u0010I\u001a\u00020\u00042\u0006\u0010C\u001a\u00020\u0019R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R \u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\u00020\u00048BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0018\u001a\u00020\u0019X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u001e\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0014\u0010 \u001a\u00020\u000f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b!\u0010\u0012R\u0010\u0010\"\u001a\u0004\u0018\u00010#X\u0082\u000e¢\u0006\u0002\n\u0000R\"\u0010$\u001a\n\u0012\u0004\u0012\u00020&\u0018\u00010%X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b'\u0010(\"\u0004\b)\u0010*R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010.\u001a\u00020\u000f2\u0006\u0010-\u001a\u00020\u000f@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b/\u00100R\u000e\u00101\u001a\u00020\u0014X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00102\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000203X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00105\u001a\u000606j\u0002`7X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00108\u001a\u000209X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010:\u001a\u00020;X\u0082\u0004¢\u0006\u0002\n\u0000R \u0010<\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f8G@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b=\u0010\u0012¨\u0006J" }, d2 = { "Lly/img/android/opengl/textures/GlSourceTileTexture;", "Lly/img/android/opengl/canvas/GlObject;", "()V", "_imageSource", "Lly/img/android/pesdk/backend/decoder/ImageSource;", "callOnUpdateEvent", "Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "getCallOnUpdateEvent", "()Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;", "glProgramTileDraw", "Lly/img/android/opengl/programs/GlProgramTileDraw;", "glSharpTileRect", "Lly/img/android/opengl/canvas/GlRect;", "glTileRect", "<set-?>", "", "height", "getHeight", "()I", "imageBuffer", "Lly/img/android/opengl/textures/GlImageTexture;", "imageSource", "getImageSource", "()Lly/img/android/pesdk/backend/decoder/ImageSource;", "isSharpTileRotationInvalid", "", "loadImageBufferInMaxSize", "Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;", "getLoadImageBufferInMaxSize", "()Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;", "loadSharpTile", "getLoadSharpTile", "maxFrameBufferSize", "getMaxFrameBufferSize", "maxSizeTileBuffer", "Lly/img/android/opengl/textures/GlTexture;", "onUpdate", "Lkotlin/Function0;", "", "getOnUpdate", "()Lkotlin/jvm/functions/Function0;", "setOnUpdate", "(Lkotlin/jvm/functions/Function0;)V", "paint", "Landroid/graphics/Paint;", "value", "rotation", "setRotation", "(I)V", "sharpTileBuffer", "sharpTileBufferRect", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "sharpTileBufferRectRequest", "sharpTileBufferSize", "", "Lly/img/android/pesdk/kotlin_extension/Float2;", "textureIsLoaded", "Ljava/util/concurrent/atomic/AtomicBoolean;", "updateLock", "Ljava/util/concurrent/locks/ReentrantLock;", "width", "getWidth", "hasSource", "loadBufferedTexture", "chunkRect", "buffer", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "isExport", "needsHigherResolution", "onRelease", "requestShapeTile", "loadSynchronous", "setSource", "source", "pesdk-backend-core_release" })
public final class GlSourceTileTexture extends GlObject
{
    private int width;
    private int height;
    @Nullable
    private ImageSource _imageSource;
    @Nullable
    private Function0<Unit> onUpdate;
    @NotNull
    private final ReentrantLock updateLock;
    @NotNull
    private final MultiRect sharpTileBufferRectRequest;
    @NotNull
    private final MultiRect sharpTileBufferRect;
    @NotNull
    private final float[] sharpTileBufferSize;
    @NotNull
    private final GlImageTexture sharpTileBuffer;
    @Nullable
    private GlTexture maxSizeTileBuffer;
    @NotNull
    private final GlImageTexture imageBuffer;
    private int rotation;
    @NotNull
    private final AtomicBoolean textureIsLoaded;
    @NotNull
    private final GlRect glTileRect;
    @NotNull
    private final GlRect glSharpTileRect;
    @NotNull
    private final GlProgramTileDraw glProgramTileDraw;
    @NotNull
    private final Paint paint;
    private boolean isSharpTileRotationInvalid;
    @NotNull
    private final ThreadUtils.MainThreadRunnable callOnUpdateEvent;
    @NotNull
    private final ThreadUtils.ReplaceThreadRunnable loadImageBufferInMaxSize;
    @NotNull
    private final ThreadUtils.ReplaceThreadRunnable loadSharpTile;
    
    public GlSourceTileTexture() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: aconst_null    
        //     2: iconst_1       
        //     3: aconst_null    
        //     4: invokespecial   ly/img/android/opengl/canvas/GlObject.<init>:(Lly/img/android/opengl/GlThreadRunner;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //     7: aload_0         /* this */
        //     8: new             Ljava/util/concurrent/locks/ReentrantLock;
        //    11: dup            
        //    12: iconst_1       
        //    13: invokespecial   java/util/concurrent/locks/ReentrantLock.<init>:(Z)V
        //    16: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //    19: aload_0         /* this */
        //    20: invokestatic    ly/img/android/pesdk/backend/model/chunk/MultiRect.permanent:()Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //    23: astore_2       
        //    24: aload_2        
        //    25: astore_3       
        //    26: astore          5
        //    28: iconst_0       
        //    29: istore          $i$a$-apply-GlSourceTileTexture$sharpTileBufferRectRequest$1
        //    31: aload_3         /* $this$sharpTileBufferRectRequest_u24lambda_u2d0 */
        //    32: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.setEmpty:()V
        //    35: aload           5
        //    37: aload_2        
        //    38: dup            
        //    39: ldc             "permanent().apply { setEmpty() }"
        //    41: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    44: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRectRequest:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //    47: aload_0         /* this */
        //    48: invokestatic    ly/img/android/pesdk/backend/model/chunk/MultiRect.permanent:()Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //    51: astore_2       
        //    52: aload_2        
        //    53: astore_3       
        //    54: astore          5
        //    56: iconst_0       
        //    57: istore          $i$a$-apply-GlSourceTileTexture$sharpTileBufferRect$1
        //    59: aload_3         /* $this$sharpTileBufferRect_u24lambda_u2d1 */
        //    60: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.setEmpty:()V
        //    63: aload           5
        //    65: aload_2        
        //    66: dup            
        //    67: ldc             "permanent().apply { setEmpty() }"
        //    69: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    72: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRect:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //    75: aload_0         /* this */
        //    76: iconst_0       
        //    77: istore_1        /* $i$f$Float2 */
        //    78: iconst_2       
        //    79: newarray        F
        //    81: astore_2       
        //    82: aload_2        
        //    83: iconst_0       
        //    84: fconst_0       
        //    85: fastore        
        //    86: aload_2        
        //    87: iconst_1       
        //    88: fconst_0       
        //    89: fastore        
        //    90: aload_2        
        //    91: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferSize:[F
        //    94: aload_0         /* this */
        //    95: new             Lly/img/android/opengl/textures/GlImageTexture;
        //    98: dup            
        //    99: invokespecial   ly/img/android/opengl/textures/GlImageTexture.<init>:()V
        //   102: astore_1       
        //   103: aload_1        
        //   104: astore_2       
        //   105: astore          5
        //   107: iconst_0       
        //   108: istore_3        /* $i$a$-apply-GlSourceTileTexture$sharpTileBuffer$1 */
        //   109: aload_2         /* $this$sharpTileBuffer_u24lambda_u2d2 */
        //   110: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   113: sipush          9987
        //   116: iconst_0       
        //   117: iconst_2       
        //   118: aconst_null    
        //   119: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   122: nop            
        //   123: aload           5
        //   125: aload_1        
        //   126: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBuffer:Lly/img/android/opengl/textures/GlImageTexture;
        //   129: aload_0         /* this */
        //   130: new             Lly/img/android/opengl/textures/GlImageTexture;
        //   133: dup            
        //   134: invokespecial   ly/img/android/opengl/textures/GlImageTexture.<init>:()V
        //   137: astore_1       
        //   138: aload_1        
        //   139: astore_2       
        //   140: astore          5
        //   142: iconst_0       
        //   143: istore_3        /* $i$a$-apply-GlSourceTileTexture$imageBuffer$1 */
        //   144: aload_2         /* $this$imageBuffer_u24lambda_u2d3 */
        //   145: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   148: sipush          9987
        //   151: iconst_0       
        //   152: iconst_2       
        //   153: aconst_null    
        //   154: invokestatic    ly/img/android/opengl/textures/GlTexture.setBehave$default:(Lly/img/android/opengl/textures/GlTexture;IIILjava/lang/Object;)V
        //   157: nop            
        //   158: aload           5
        //   160: aload_1        
        //   161: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.imageBuffer:Lly/img/android/opengl/textures/GlImageTexture;
        //   164: aload_0         /* this */
        //   165: new             Ljava/util/concurrent/atomic/AtomicBoolean;
        //   168: dup            
        //   169: iconst_0       
        //   170: invokespecial   java/util/concurrent/atomic/AtomicBoolean.<init>:(Z)V
        //   173: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.textureIsLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;
        //   176: aload_0         /* this */
        //   177: new             Lly/img/android/opengl/canvas/GlRect;
        //   180: dup            
        //   181: invokespecial   ly/img/android/opengl/canvas/GlRect.<init>:()V
        //   184: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.glTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   187: aload_0         /* this */
        //   188: new             Lly/img/android/opengl/canvas/GlRect;
        //   191: dup            
        //   192: invokespecial   ly/img/android/opengl/canvas/GlRect.<init>:()V
        //   195: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.glSharpTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   198: aload_0         /* this */
        //   199: new             Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   202: dup            
        //   203: invokespecial   ly/img/android/opengl/programs/GlProgramTileDraw.<init>:()V
        //   206: astore_1       
        //   207: aload_1        
        //   208: astore_2       
        //   209: astore          5
        //   211: iconst_0       
        //   212: istore_3        /* $i$a$-apply-GlSourceTileTexture$glProgramTileDraw$1 */
        //   213: aload_2         /* $this$glProgramTileDraw_u24lambda_u2d4 */
        //   214: iconst_0       
        //   215: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUseDynamicInput:(Z)V
        //   218: nop            
        //   219: aload           5
        //   221: aload_1        
        //   222: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.glProgramTileDraw:Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   225: aload_0         /* this */
        //   226: new             Landroid/graphics/Paint;
        //   229: dup            
        //   230: invokespecial   android/graphics/Paint.<init>:()V
        //   233: astore_1       
        //   234: aload_1        
        //   235: astore_2       
        //   236: astore          5
        //   238: iconst_0       
        //   239: istore_3        /* $i$a$-apply-GlSourceTileTexture$paint$1 */
        //   240: aload_2         /* $this$paint_u24lambda_u2d5 */
        //   241: iconst_1       
        //   242: invokevirtual   android/graphics/Paint.setAntiAlias:(Z)V
        //   245: aload_2         /* $this$paint_u24lambda_u2d5 */
        //   246: iconst_1       
        //   247: invokevirtual   android/graphics/Paint.setFilterBitmap:(Z)V
        //   250: nop            
        //   251: aload           5
        //   253: aload_1        
        //   254: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.paint:Landroid/graphics/Paint;
        //   257: aload_0         /* this */
        //   258: iconst_1       
        //   259: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.isSharpTileRotationInvalid:Z
        //   262: aload_0         /* this */
        //   263: iconst_0       
        //   264: istore_1        /* $i$f$MainThreadRunnable */
        //   265: new             Lly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$MainThreadRunnable$1;
        //   268: dup            
        //   269: aload_0         /* this */
        //   270: invokespecial   ly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$MainThreadRunnable$1.<init>:(Lly/img/android/opengl/textures/GlSourceTileTexture;)V
        //   273: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;
        //   276: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.callOnUpdateEvent:Lly/img/android/pesdk/utils/ThreadUtils$MainThreadRunnable;
        //   279: aload_0         /* this */
        //   280: new             Ljava/lang/StringBuilder;
        //   283: dup            
        //   284: invokespecial   java/lang/StringBuilder.<init>:()V
        //   287: aload_0         /* this */
        //   288: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   291: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   294: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   297: ldc             "Full"
        //   299: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   302: aload_0         /* this */
        //   303: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   306: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   309: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   312: astore_1        /* id$iv */
        //   313: aconst_null    
        //   314: astore_2        /* reference$iv */
        //   315: iconst_0       
        //   316: istore_3        /* $i$f$ReplaceRunnable */
        //   317: new             Ljava/lang/StringBuilder;
        //   320: dup            
        //   321: invokespecial   java/lang/StringBuilder.<init>:()V
        //   324: aload_1         /* id$iv */
        //   325: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   328: aload_2         /* reference$iv */
        //   329: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   332: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   335: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   338: astore          4
        //   340: new             Lly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$ReplaceRunnable$default$1;
        //   343: dup            
        //   344: aload           4
        //   346: aload_0         /* this */
        //   347: invokespecial   ly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$ReplaceRunnable$default$1.<init>:(Ljava/lang/String;Lly/img/android/opengl/textures/GlSourceTileTexture;)V
        //   350: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   353: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.loadImageBufferInMaxSize:Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   356: aload_0         /* this */
        //   357: new             Ljava/lang/StringBuilder;
        //   360: dup            
        //   361: invokespecial   java/lang/StringBuilder.<init>:()V
        //   364: aload_0         /* this */
        //   365: invokevirtual   java/lang/Object.getClass:()Ljava/lang/Class;
        //   368: invokevirtual   java/lang/Class.getName:()Ljava/lang/String;
        //   371: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   374: ldc             "Part"
        //   376: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   379: aload_0         /* this */
        //   380: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   383: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   386: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   389: astore_1        /* id$iv */
        //   390: aconst_null    
        //   391: astore_2        /* reference$iv */
        //   392: iconst_0       
        //   393: istore_3        /* $i$f$ReplaceRunnable */
        //   394: new             Ljava/lang/StringBuilder;
        //   397: dup            
        //   398: invokespecial   java/lang/StringBuilder.<init>:()V
        //   401: aload_1         /* id$iv */
        //   402: invokevirtual   java/lang/StringBuilder.append:(Ljava/lang/String;)Ljava/lang/StringBuilder;
        //   405: aload_2         /* reference$iv */
        //   406: invokestatic    java/lang/System.identityHashCode:(Ljava/lang/Object;)I
        //   409: invokevirtual   java/lang/StringBuilder.append:(I)Ljava/lang/StringBuilder;
        //   412: invokevirtual   java/lang/StringBuilder.toString:()Ljava/lang/String;
        //   415: astore          4
        //   417: new             Lly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$ReplaceRunnable$default$2;
        //   420: dup            
        //   421: aload           4
        //   423: aload_0         /* this */
        //   424: invokespecial   ly/img/android/opengl/textures/GlSourceTileTexture$special$$inlined$ReplaceRunnable$default$2.<init>:(Ljava/lang/String;Lly/img/android/opengl/textures/GlSourceTileTexture;)V
        //   427: checkcast       Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   430: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.loadSharpTile:Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   433: return         
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
    
    @AnyThread
    public final int getWidth() {
        return this.width;
    }
    
    @AnyThread
    public final int getHeight() {
        return this.height;
    }
    
    private final ImageSource getImageSource() {
        ImageSource imageSource;
        if ((imageSource = this._imageSource) == null) {
            Intrinsics.checkNotNullExpressionValue((Object)(imageSource = ImageSource.create(R$drawable.imgly_broken_or_missing_file)), "create(R.drawable.imgly_broken_or_missing_file)");
        }
        return imageSource;
    }
    
    @Nullable
    public final Function0<Unit> getOnUpdate() {
        return this.onUpdate;
    }
    
    public final void setOnUpdate(@Nullable final Function0<Unit> <set-?>) {
        this.onUpdate = <set-?>;
    }
    
    private final void setRotation(final int value) {
        this.rotation = value;
        this.isSharpTileRotationInvalid = true;
    }
    
    public final boolean hasSource() {
        return this._imageSource != null;
    }
    
    @Override
    protected void onRelease() {
        this.width = 0;
        this.height = 0;
        this.sharpTileBuffer.releaseGlContext();
        final GlTexture maxSizeTileBuffer = this.maxSizeTileBuffer;
        if (maxSizeTileBuffer != null) {
            maxSizeTileBuffer.releaseGlContext();
        }
    }
    
    @NotNull
    public final ThreadUtils.MainThreadRunnable getCallOnUpdateEvent() {
        return this.callOnUpdateEvent;
    }
    
    @NotNull
    public final ThreadUtils.ReplaceThreadRunnable getLoadImageBufferInMaxSize() {
        return this.loadImageBufferInMaxSize;
    }
    
    @NotNull
    public final ThreadUtils.ReplaceThreadRunnable getLoadSharpTile() {
        return this.loadSharpTile;
    }
    
    private final int getMaxFrameBufferSize() {
        return (int)(GlTexture.Companion.getMaxFrameBufferSize() / 1.5);
    }
    
    public final void setSource(@NotNull final ImageSource source, final boolean isExport) {
        Intrinsics.checkNotNullParameter((Object)source, "source");
        final ReentrantLock reentrantLock = this.updateLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this._imageSource = source;
            this.setRotation(source.getRotation());
            final ImageSize it = source.getSize();
            final int n2 = 0;
            this.width = it.width;
            this.height = it.height;
            this.maxSizeTileBuffer = this.imageBuffer;
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
        ((ThreadUtils.WorkerThreadRunnable)this.loadImageBufferInMaxSize).invoke();
    }
    
    private final boolean needsHigherResolution(final MultiRect chunkRect, final int width, final int height) {
        final GlTexture maxSizeTileBuffer2 = this.maxSizeTileBuffer;
        boolean b;
        if (maxSizeTileBuffer2 != null) {
            final GlTexture maxSizeTileBuffer = maxSizeTileBuffer2;
            final int n = 0;
            final float widthDiff = Math.min(width, this.width) - maxSizeTileBuffer.getWidth() * (chunkRect.width() / this.width);
            final float heightDiff = Math.min(height, this.height) - maxSizeTileBuffer.getHeight() * (chunkRect.height() / this.height);
            b = (widthDiff > 0.5 || heightDiff > 0.5);
        }
        else {
            b = false;
        }
        return b;
    }
    
    private final void requestShapeTile(final boolean loadSynchronous) {
        final int $i$f$requestShapeTile = 0;
        if (loadSynchronous) {
            ((ThreadUtils.WorkerThreadRunnable)this.loadSharpTile).run();
        }
        else if (this.updateLock.tryLock()) {
            if (!this.sharpTileBufferRect.contains((RectF)this.sharpTileBufferRectRequest)) {
                ((ThreadUtils.WorkerThreadRunnable)this.loadSharpTile).invoke();
            }
            this.updateLock.unlock();
        }
    }
    
    public final boolean loadBufferedTexture(@NotNull final MultiRect chunkRect, @NotNull final GlFrameBufferTexture buffer, final boolean isExport) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "chunkRect"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* buffer */
        //     8: ldc_w           "buffer"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_0         /* this */
        //    15: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.textureIsLoaded:Ljava/util/concurrent/atomic/AtomicBoolean;
        //    18: invokevirtual   java/util/concurrent/atomic/AtomicBoolean.get:()Z
        //    21: istore          isLoaded
        //    23: iload           isLoaded
        //    25: ifeq            714
        //    28: invokestatic    ly/img/android/pesdk/backend/model/chunk/Transformation.obtain:()Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    31: dup            
        //    32: ldc_w           "obtain()"
        //    35: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //    38: astore          transformation
        //    40: aload_0         /* this */
        //    41: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glTileRect:Lly/img/android/opengl/canvas/GlRect;
        //    44: aload_1         /* chunkRect */
        //    45: aconst_null    
        //    46: aload_0         /* this */
        //    47: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.width:I
        //    50: aload_0         /* this */
        //    51: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.height:I
        //    54: iconst_0       
        //    55: aload_0         /* this */
        //    56: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.rotation:I
        //    59: i2f            
        //    60: fneg           
        //    61: bipush          18
        //    63: aconst_null    
        //    64: invokestatic    ly/img/android/opengl/canvas/GlRect.setTexture$default:(Lly/img/android/opengl/canvas/GlRect;Lly/img/android/pesdk/backend/model/chunk/MultiRect;Lly/img/android/pesdk/backend/model/chunk/Transformation;IIIFILjava/lang/Object;)V
        //    67: aload           transformation
        //    69: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.recycle:()V
        //    72: aload_1         /* chunkRect */
        //    73: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.width:()F
        //    76: aload_2         /* buffer */
        //    77: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getWidth:()I
        //    80: i2f            
        //    81: fsub           
        //    82: invokestatic    java/lang/Math.abs:(F)F
        //    85: fconst_1       
        //    86: fcmpg          
        //    87: ifgt            94
        //    90: iconst_1       
        //    91: goto            95
        //    94: iconst_0       
        //    95: istore          isUnscaledRequest
        //    97: aload_0         /* this */
        //    98: aload_1         /* chunkRect */
        //    99: aload_2         /* buffer */
        //   100: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getWidth:()I
        //   103: aload_2         /* buffer */
        //   104: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getHeight:()I
        //   107: invokespecial   ly/img/android/opengl/textures/GlSourceTileTexture.needsHigherResolution:(Lly/img/android/pesdk/backend/model/chunk/MultiRect;II)Z
        //   110: ifeq            126
        //   113: iload_3         /* isExport */
        //   114: ifne            122
        //   117: iload           isUnscaledRequest
        //   119: ifeq            126
        //   122: iconst_1       
        //   123: goto            127
        //   126: iconst_0       
        //   127: istore          drawSharpArea
        //   129: iload           drawSharpArea
        //   131: ifeq            315
        //   134: aload_0         /* this */
        //   135: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   138: checkcast       Ljava/util/concurrent/locks/Lock;
        //   141: astore          8
        //   143: aload           8
        //   145: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //   150: nop            
        //   151: iconst_0       
        //   152: istore          $i$a$-withLock-GlSourceTileTexture$loadBufferedTexture$1
        //   154: aload_0         /* this */
        //   155: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferSize:[F
        //   158: astore          10
        //   160: aload           10
        //   162: astore          it
        //   164: iconst_0       
        //   165: istore          $i$a$-also-GlSourceTileTexture$loadBufferedTexture$1$1
        //   167: aload           it
        //   169: astore          13
        //   171: aload_2         /* buffer */
        //   172: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getWidth:()I
        //   175: i2f            
        //   176: fstore          value$iv
        //   178: iconst_0       
        //   179: istore          $i$f$setX
        //   181: aload           $this$x$iv
        //   183: iconst_0       
        //   184: fload           value$iv
        //   186: fastore        
        //   187: nop            
        //   188: aload           it
        //   190: astore          13
        //   192: aload_2         /* buffer */
        //   193: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getHeight:()I
        //   196: i2f            
        //   197: fstore          value$iv
        //   199: iconst_0       
        //   200: istore          $i$f$setY
        //   202: aload           $this$y$iv
        //   204: iconst_1       
        //   205: fload           value$iv
        //   207: fastore        
        //   208: nop            
        //   209: nop            
        //   210: nop            
        //   211: aload_0         /* this */
        //   212: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRectRequest:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   215: aload_1         /* chunkRect */
        //   216: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.set:(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)V
        //   219: nop            
        //   220: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   223: astore          9
        //   225: aload           8
        //   227: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   232: goto            247
        //   235: astore          9
        //   237: aload           8
        //   239: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   244: aload           9
        //   246: athrow         
        //   247: aload_0         /* this */
        //   248: astore          this_$iv
        //   250: iconst_0       
        //   251: istore          $i$f$requestShapeTile
        //   253: iload_3         /* isExport */
        //   254: ifeq            268
        //   257: aload           this_$iv
        //   259: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.loadSharpTile:Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   262: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable.run:()V
        //   265: goto            314
        //   268: aload           this_$iv
        //   270: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   273: invokevirtual   java/util/concurrent/locks/ReentrantLock.tryLock:()Z
        //   276: ifeq            314
        //   279: aload           this_$iv
        //   281: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRect:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   284: aload           this_$iv
        //   286: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRectRequest:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   289: checkcast       Landroid/graphics/RectF;
        //   292: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.contains:(Landroid/graphics/RectF;)Z
        //   295: ifne            306
        //   298: aload           this_$iv
        //   300: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.loadSharpTile:Lly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable;
        //   303: invokevirtual   ly/img/android/pesdk/utils/ThreadUtils$ReplaceThreadRunnable.invoke:()V
        //   306: aload           this_$iv
        //   308: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   311: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   314: nop            
        //   315: iconst_1       
        //   316: istore          doClear$iv
        //   318: iconst_0       
        //   319: istore          clearColor$iv
        //   321: iconst_0       
        //   322: istore          $i$f$record
        //   324: nop            
        //   325: aload_2         /* buffer */
        //   326: iload           doClear$iv
        //   328: iload           clearColor$iv
        //   330: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //   333: iconst_0       
        //   334: istore          $i$a$-record$default-GlSourceTileTexture$loadBufferedTexture$2
        //   336: sipush          3042
        //   339: invokestatic    android/opengl/GLES20.glEnable:(I)V
        //   342: sipush          770
        //   345: sipush          771
        //   348: invokestatic    android/opengl/GLES20.glBlendFunc:(II)V
        //   351: aload_0         /* this */
        //   352: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.maxSizeTileBuffer:Lly/img/android/opengl/textures/GlTexture;
        //   355: dup            
        //   356: ifnull          440
        //   359: astore          maxSizeTileBuffer
        //   361: iconst_0       
        //   362: istore          $i$a$-let-GlSourceTileTexture$loadBufferedTexture$2$1
        //   364: aload_0         /* this */
        //   365: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glProgramTileDraw:Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   368: aload           maxSizeTileBuffer
        //   370: invokevirtual   ly/img/android/opengl/textures/GlTexture.isExternalTexture:()Z
        //   373: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUseDynamicInput:(Z)V
        //   376: aload_0         /* this */
        //   377: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   380: astore          15
        //   382: aload_0         /* this */
        //   383: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glProgramTileDraw:Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   386: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //   389: astore          program$iv
        //   391: iconst_0       
        //   392: istore          $i$f$drawWith
        //   394: aload           this_$iv
        //   396: aload           program$iv
        //   398: invokevirtual   ly/img/android/opengl/canvas/GlRect.enable:(Lly/img/android/opengl/canvas/GlProgram;)V
        //   401: aload           program$iv
        //   403: checkcast       Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   406: astore          it
        //   408: iconst_0       
        //   409: istore          $i$a$-drawWith-GlSourceTileTexture$loadBufferedTexture$2$1$1
        //   411: aload           it
        //   413: iconst_0       
        //   414: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setCutEdges:(Z)V
        //   417: aload           it
        //   419: aload           maxSizeTileBuffer
        //   421: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUniformImage:(Lly/img/android/opengl/textures/GlTexture;)V
        //   424: nop            
        //   425: aload           this_$iv
        //   427: invokevirtual   ly/img/android/opengl/canvas/GlRect.draw:()V
        //   430: aload           this_$iv
        //   432: invokevirtual   ly/img/android/opengl/canvas/GlRect.disable:()V
        //   435: nop            
        //   436: nop            
        //   437: goto            442
        //   440: pop            
        //   441: nop            
        //   442: iload           drawSharpArea
        //   444: ifeq            672
        //   447: aload_0         /* this */
        //   448: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRect:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   451: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.isNotEmpty:()Z
        //   454: ifeq            672
        //   457: aload_1         /* chunkRect */
        //   458: aload_0         /* this */
        //   459: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRect:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   462: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.itIntersects:(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)Z
        //   465: ifeq            672
        //   468: iload_3         /* isExport */
        //   469: ifne            482
        //   472: aload_0         /* this */
        //   473: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   476: invokevirtual   java/util/concurrent/locks/ReentrantLock.tryLock:()Z
        //   479: ifeq            672
        //   482: aload_0         /* this */
        //   483: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glProgramTileDraw:Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   486: aload_0         /* this */
        //   487: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBuffer:Lly/img/android/opengl/textures/GlImageTexture;
        //   490: invokevirtual   ly/img/android/opengl/textures/GlImageTexture.isExternalTexture:()Z
        //   493: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUseDynamicInput:(Z)V
        //   496: aload_0         /* this */
        //   497: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.isSharpTileRotationInvalid:Z
        //   500: ifeq            542
        //   503: aload_0         /* this */
        //   504: iconst_0       
        //   505: putfield        ly/img/android/opengl/textures/GlSourceTileTexture.isSharpTileRotationInvalid:Z
        //   508: aload_0         /* this */
        //   509: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glSharpTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   512: iconst_0       
        //   513: iconst_1       
        //   514: iconst_1       
        //   515: iconst_0       
        //   516: invokestatic    ly/img/android/pesdk/backend/model/chunk/MultiRect.obtain:(IIII)Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   519: dup            
        //   520: ldc_w           "obtain(0, 1, 1, 0)"
        //   523: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullExpressionValue:(Ljava/lang/Object;Ljava/lang/String;)V
        //   526: aconst_null    
        //   527: iconst_1       
        //   528: iconst_1       
        //   529: iconst_0       
        //   530: aload_0         /* this */
        //   531: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.rotation:I
        //   534: i2f            
        //   535: fneg           
        //   536: bipush          18
        //   538: aconst_null    
        //   539: invokestatic    ly/img/android/opengl/canvas/GlRect.setTexture$default:(Lly/img/android/opengl/canvas/GlRect;Lly/img/android/pesdk/backend/model/chunk/MultiRect;Lly/img/android/pesdk/backend/model/chunk/Transformation;IIIFILjava/lang/Object;)V
        //   542: invokestatic    ly/img/android/pesdk/backend/model/chunk/Transformation.obtain:()Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //   545: astore          20
        //   547: aload           20
        //   549: astore          flipTransform
        //   551: iconst_0       
        //   552: istore          $i$a$-also-GlSourceTileTexture$loadBufferedTexture$2$2
        //   554: aload           flipTransform
        //   556: fconst_1       
        //   557: ldc_w           -1.0
        //   560: fconst_0       
        //   561: aload_1         /* chunkRect */
        //   562: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.centerY:()F
        //   565: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.setScale:(FFFF)V
        //   568: aload_0         /* this */
        //   569: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glSharpTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   572: astore          14
        //   574: aload_0         /* this */
        //   575: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBufferRect:Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //   578: astore          15
        //   580: aload           14
        //   582: aload           15
        //   584: aload           flipTransform
        //   586: aload_1         /* chunkRect */
        //   587: iconst_0       
        //   588: bipush          8
        //   590: aconst_null    
        //   591: invokestatic    ly/img/android/opengl/canvas/GlRect.setShape$default:(Lly/img/android/opengl/canvas/GlRect;Lly/img/android/pesdk/backend/model/chunk/MultiRect;Lly/img/android/pesdk/backend/model/chunk/Transformation;Lly/img/android/pesdk/backend/model/chunk/MultiRect;ZILjava/lang/Object;)V
        //   594: nop            
        //   595: nop            
        //   596: aload_0         /* this */
        //   597: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glSharpTileRect:Lly/img/android/opengl/canvas/GlRect;
        //   600: astore          20
        //   602: aload_0         /* this */
        //   603: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.glProgramTileDraw:Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   606: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //   609: astore          program$iv
        //   611: iconst_0       
        //   612: istore          $i$f$drawWith
        //   614: aload           this_$iv
        //   616: aload           program$iv
        //   618: invokevirtual   ly/img/android/opengl/canvas/GlRect.enable:(Lly/img/android/opengl/canvas/GlProgram;)V
        //   621: aload           program$iv
        //   623: checkcast       Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   626: astore          it
        //   628: iconst_0       
        //   629: istore          $i$a$-drawWith-GlSourceTileTexture$loadBufferedTexture$2$3
        //   631: aload           it
        //   633: aload_0         /* this */
        //   634: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.sharpTileBuffer:Lly/img/android/opengl/textures/GlImageTexture;
        //   637: checkcast       Lly/img/android/opengl/textures/GlTexture;
        //   640: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUniformImage:(Lly/img/android/opengl/textures/GlTexture;)V
        //   643: aload           it
        //   645: iconst_0       
        //   646: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setCutEdges:(Z)V
        //   649: nop            
        //   650: aload           this_$iv
        //   652: invokevirtual   ly/img/android/opengl/canvas/GlRect.draw:()V
        //   655: aload           this_$iv
        //   657: invokevirtual   ly/img/android/opengl/canvas/GlRect.disable:()V
        //   660: nop            
        //   661: iload_3         /* isExport */
        //   662: ifne            672
        //   665: aload_0         /* this */
        //   666: getfield        ly/img/android/opengl/textures/GlSourceTileTexture.updateLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   669: invokevirtual   java/util/concurrent/locks/ReentrantLock.unlock:()V
        //   672: iconst_1       
        //   673: sipush          771
        //   676: invokestatic    android/opengl/GLES20.glBlendFunc:(II)V
        //   679: nop            
        //   680: aload_2         /* buffer */
        //   681: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   684: goto            710
        //   687: astore          e$iv
        //   689: aload           e$iv
        //   691: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   694: aload_2         /* buffer */
        //   695: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   698: goto            710
        //   701: astore          11
        //   703: aload_2         /* buffer */
        //   704: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   707: aload           11
        //   709: athrow         
        //   710: nop            
        //   711: goto            767
        //   714: iconst_1       
        //   715: istore          doClear$iv
        //   717: iconst_0       
        //   718: istore          clearColor$iv
        //   720: iconst_0       
        //   721: istore          $i$f$record
        //   723: nop            
        //   724: aload_2         /* buffer */
        //   725: iload           doClear$iv
        //   727: iload           clearColor$iv
        //   729: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //   732: iconst_0       
        //   733: istore          $i$a$-record$default-GlSourceTileTexture$loadBufferedTexture$3
        //   735: nop            
        //   736: aload_2         /* buffer */
        //   737: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   740: goto            766
        //   743: astore          e$iv
        //   745: aload           e$iv
        //   747: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   750: aload_2         /* buffer */
        //   751: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   754: goto            766
        //   757: astore          8
        //   759: aload_2         /* buffer */
        //   760: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   763: aload           8
        //   765: athrow         
        //   766: nop            
        //   767: iload           isLoaded
        //   769: ireturn        
        //    StackMapTable: 00 18 FD 00 5E 01 07 01 6B 40 01 FC 00 1A 01 03 40 01 FF 00 6B 00 09 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 07 01 14 00 01 07 01 37 FF 00 0B 00 10 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 07 01 14 07 01 26 07 01 E6 07 01 E6 01 07 01 E6 02 01 00 00 FF 00 14 00 10 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 07 00 02 01 07 01 E6 07 01 E6 01 07 01 E6 02 01 00 00 25 07 FF 00 00 00 08 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 00 00 FF 00 7C 00 0D 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 01 01 01 00 01 00 01 07 00 34 01 27 3B FB 00 81 FF 00 0E 00 0B 07 00 02 07 00 14 07 01 7A 01 01 07 01 6B 01 01 01 01 01 00 01 07 01 63 4D 07 01 37 08 FF 00 03 00 05 07 00 02 07 00 14 07 01 7A 01 01 00 00 FF 00 1C 00 08 07 00 02 07 00 14 07 01 7A 01 01 01 01 01 00 01 07 01 63 4D 07 01 37 08 FF 00 00 00 08 07 00 02 07 00 14 07 01 7A 01 01 00 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  150    225    235    247    Any
        //  235    237    235    247    Any
        //  324    680    687    701    Ljava/lang/Exception;
        //  324    680    701    710    Any
        //  687    694    701    710    Any
        //  701    703    701    710    Any
        //  723    736    743    757    Ljava/lang/Exception;
        //  723    736    757    766    Any
        //  743    750    757    766    Any
        //  757    759    757    766    Any
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
}
