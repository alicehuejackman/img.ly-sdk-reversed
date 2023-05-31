// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import android.graphics.SurfaceTexture;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.pesdk.backend.decoder.video.NativeVideoDecoder;
import android.os.Handler;
import android.os.HandlerThread;
import android.graphics.SurfaceTexture$OnFrameAvailableListener;
import android.os.Message;
import kotlin.jvm.functions.Function1;
import ly.img.android.pesdk.kotlin_extension.AtomicSleep;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.decoder.VideoSource;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 :2\u00020\u0001:\u0001:B\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u0006\u0010/\u001a\u000200J\u0010\u00101\u001a\u0002002\u0006\u00102\u001a\u00020\u0003H\u0016J\b\u00103\u001a\u000200H\u0014J\b\u00104\u001a\u000200H\u0014J\u001e\u00105\u001a\u0002002\n\u00106\u001a\u00060\nj\u0002`\u000b2\b\b\u0002\u00107\u001a\u00020\u0013H\u0016J\u0010\u00108\u001a\u0002002\u0006\u0010+\u001a\u00020,H\u0016J\u0014\u00109\u001a\u00020\u00132\n\u00106\u001a\u00060\nj\u0002`\u000bH\u0016R\u000e\u0010\u0006\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\t\u001a\u00060\nj\u0002`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R&\u0010\r\u001a\u00060\nj\u0002`\u000b2\n\u0010\f\u001a\u00060\nj\u0002`\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001e\u0010\u0014\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u000e\u0010\u0017\u001a\u00020\u0018X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u001b\u0012\u0004\u0012\u00020\u00130\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u00060\nj\u0002`\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001e\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u001e\u0010!\u001a\u00060\nj\u0002`\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u000fR\u000e\u0010%\u001a\u00020&X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010)\u001a\u00020\u00132\u0006\u0010\u0012\u001a\u00020\u0013@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b*\u0010\u0016R\u0010\u0010+\u001a\u0004\u0018\u00010,X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010-\u001a\u00020.X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006;" }, d2 = { "Lly/img/android/opengl/textures/GlVideoTexture;", "Lly/img/android/opengl/textures/GlSurfaceTexture;", "width", "", "height", "(II)V", "couldDownRoundsNeeded", "decoder", "Lly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder;", "fetchedPresentationTimeInNano", "", "Lly/img/android/pesdk/kotlin_extension/Nanoseconds;", "value", "frameTimeInNano", "setFrameTimeInNano", "(J)V", "isFrameRendered", "Lly/img/android/pesdk/kotlin_extension/AtomicSleep;", "<set-?>", "", "nextFrameAvailable", "getNextFrameAvailable", "()Z", "onFrameDecoded", "Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;", "presentVideoFrame", "Lkotlin/Function1;", "Landroid/os/Message;", "renderedFrameTimeInNano", "renderedSourceId", "rotation", "getRotation", "()I", "surfacePresentationTimeInNano", "getSurfacePresentationTimeInNano", "()J", "setSurfacePresentationTimeInNano", "videoDecoderHandler", "Landroid/os/Handler;", "videoDecoderThread", "Landroid/os/HandlerThread;", "videoIsLoaded", "getVideoIsLoaded", "videoSource", "Lly/img/android/pesdk/backend/decoder/VideoSource;", "waitForFrameLock", "Ljava/util/concurrent/locks/ReentrantLock;", "decoderRelease", "", "onAttach", "handle", "onRebound", "onRelease", "requestNextFrame", "atTimeInNano", "awaitFirstFrame", "setSource", "waitForNextFame", "Companion", "pesdk-backend-core_release" })
public class GlVideoTexture extends GlSurfaceTexture
{
    @NotNull
    public static final Companion Companion;
    @Nullable
    private VideoSource videoSource;
    @NotNull
    private final ReentrantLock waitForFrameLock;
    @NotNull
    private final AtomicSleep isFrameRendered;
    private boolean videoIsLoaded;
    private volatile boolean nextFrameAvailable;
    private long fetchedPresentationTimeInNano;
    private long surfacePresentationTimeInNano;
    @NotNull
    private final Function1<Message, Boolean> presentVideoFrame;
    @NotNull
    private final SurfaceTexture$OnFrameAvailableListener onFrameDecoded;
    @NotNull
    private HandlerThread videoDecoderThread;
    @NotNull
    private Handler videoDecoderHandler;
    @Nullable
    private NativeVideoDecoder decoder;
    private long renderedFrameTimeInNano;
    private int renderedSourceId;
    private int couldDownRoundsNeeded;
    private long frameTimeInNano;
    @NotNull
    public static final String TAG = "PESDK-Video-Decoder";
    public static final long FIRST_FRAME = -1L;
    public static final long NO_FRAME_REQUESTED = -2L;
    private static final int COOL_DOWN_EXTRA_ROUNDS = 10;
    
    public GlVideoTexture(final int width, final int height) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: iload_1         /* width */
        //     2: iload_2         /* height */
        //     3: invokespecial   ly/img/android/opengl/textures/GlSurfaceTexture.<init>:(II)V
        //     6: aload_0         /* this */
        //     7: new             Ljava/util/concurrent/locks/ReentrantLock;
        //    10: dup            
        //    11: iconst_1       
        //    12: invokespecial   java/util/concurrent/locks/ReentrantLock.<init>:(Z)V
        //    15: putfield        ly/img/android/opengl/textures/GlVideoTexture.waitForFrameLock:Ljava/util/concurrent/locks/ReentrantLock;
        //    18: aload_0         /* this */
        //    19: new             Lly/img/android/pesdk/kotlin_extension/AtomicSleep;
        //    22: dup            
        //    23: iconst_0       
        //    24: invokespecial   ly/img/android/pesdk/kotlin_extension/AtomicSleep.<init>:(Z)V
        //    27: putfield        ly/img/android/opengl/textures/GlVideoTexture.isFrameRendered:Lly/img/android/pesdk/kotlin_extension/AtomicSleep;
        //    30: aload_0         /* this */
        //    31: new             Lly/img/android/opengl/textures/GlVideoTexture$presentVideoFrame$1;
        //    34: dup            
        //    35: aload_0         /* this */
        //    36: invokespecial   ly/img/android/opengl/textures/GlVideoTexture$presentVideoFrame$1.<init>:(Lly/img/android/opengl/textures/GlVideoTexture;)V
        //    39: checkcast       Lkotlin/jvm/functions/Function1;
        //    42: putfield        ly/img/android/opengl/textures/GlVideoTexture.presentVideoFrame:Lkotlin/jvm/functions/Function1;
        //    45: aload_0         /* this */
        //    46: aload_0         /* this */
        //    47: invokedynamic   BootstrapMethod #0, onFrameAvailable:(Lly/img/android/opengl/textures/GlVideoTexture;)Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;
        //    52: putfield        ly/img/android/opengl/textures/GlVideoTexture.onFrameDecoded:Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;
        //    55: aload_0         /* this */
        //    56: new             Landroid/os/HandlerThread;
        //    59: dup            
        //    60: ldc             "video decoder"
        //    62: invokespecial   android/os/HandlerThread.<init>:(Ljava/lang/String;)V
        //    65: astore_3       
        //    66: aload_3        
        //    67: astore          4
        //    69: astore          6
        //    71: iconst_0       
        //    72: istore          $i$a$-also-GlVideoTexture$videoDecoderThread$1
        //    74: aload           it
        //    76: invokevirtual   android/os/HandlerThread.start:()V
        //    79: aload           6
        //    81: aload_3        
        //    82: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderThread:Landroid/os/HandlerThread;
        //    85: aload_0         /* this */
        //    86: new             Landroid/os/Handler;
        //    89: dup            
        //    90: aload_0         /* this */
        //    91: getfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderThread:Landroid/os/HandlerThread;
        //    94: invokevirtual   android/os/HandlerThread.getLooper:()Landroid/os/Looper;
        //    97: aload_0         /* this */
        //    98: getfield        ly/img/android/opengl/textures/GlVideoTexture.presentVideoFrame:Lkotlin/jvm/functions/Function1;
        //   101: invokedynamic   BootstrapMethod #1, handleMessage:(Lkotlin/jvm/functions/Function1;)Landroid/os/Handler$Callback;
        //   106: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
        //   109: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderHandler:Landroid/os/Handler;
        //   112: aload_0         /* this */
        //   113: ldc2_w          -1
        //   116: putfield        ly/img/android/opengl/textures/GlVideoTexture.renderedFrameTimeInNano:J
        //   119: aload_0         /* this */
        //   120: bipush          10
        //   122: putfield        ly/img/android/opengl/textures/GlVideoTexture.couldDownRoundsNeeded:I
        //   125: aload_0         /* this */
        //   126: ldc2_w          -1
        //   129: putfield        ly/img/android/opengl/textures/GlVideoTexture.frameTimeInNano:J
        //   132: return         
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
    
    public final boolean getVideoIsLoaded() {
        return this.videoIsLoaded;
    }
    
    public final boolean getNextFrameAvailable() {
        return this.nextFrameAvailable;
    }
    
    public final long getSurfacePresentationTimeInNano() {
        return this.surfacePresentationTimeInNano;
    }
    
    public final void setSurfacePresentationTimeInNano(final long <set-?>) {
        this.surfacePresentationTimeInNano = <set-?>;
    }
    
    public final int getRotation() {
        final VideoSource videoSource = this.videoSource;
        if (videoSource != null) {
            final VideoSource.FormatInfo fetchFormatInfo = videoSource.fetchFormatInfo();
            if (fetchFormatInfo != null) {
                return fetchFormatInfo.getRotation();
            }
        }
        return 0;
    }
    
    private final void setFrameTimeInNano(final long value) {
        final boolean outOfWork = !this.videoDecoderHandler.hasMessages(0);
        if (this.frameTimeInNano != value || (outOfWork && (this.renderedFrameTimeInNano != value || this.renderedSourceId != System.identityHashCode(this.videoSource) || this.couldDownRoundsNeeded-- > 0))) {
            this.frameTimeInNano = value;
            if (value == -2L) {
                this.renderedFrameTimeInNano = value;
                this.couldDownRoundsNeeded = 10;
                this.videoDecoderHandler.removeMessages(0);
            }
            else if (outOfWork) {
                this.videoDecoderHandler.sendEmptyMessage(0);
            }
        }
    }
    
    @Override
    public void onAttach(final int handle) {
        super.onAttach(handle);
        final SurfaceTexture surfaceTexture = this.getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener(this.onFrameDecoded);
        }
    }
    
    @Override
    protected void onRebound() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokespecial   ly/img/android/opengl/textures/GlSurfaceTexture.onRebound:()V
        //     4: aload_0         /* this */
        //     5: new             Landroid/os/HandlerThread;
        //     8: dup            
        //     9: ldc             "video decoder"
        //    11: invokespecial   android/os/HandlerThread.<init>:(Ljava/lang/String;)V
        //    14: astore_1       
        //    15: aload_1        
        //    16: astore_2       
        //    17: astore          4
        //    19: iconst_0       
        //    20: istore_3       
        //    21: aload_2         /* it */
        //    22: invokevirtual   android/os/HandlerThread.start:()V
        //    25: aload           4
        //    27: aload_1        
        //    28: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderThread:Landroid/os/HandlerThread;
        //    31: aload_0         /* this */
        //    32: new             Landroid/os/Handler;
        //    35: dup            
        //    36: aload_0         /* this */
        //    37: getfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderThread:Landroid/os/HandlerThread;
        //    40: invokevirtual   android/os/HandlerThread.getLooper:()Landroid/os/Looper;
        //    43: aload_0         /* this */
        //    44: getfield        ly/img/android/opengl/textures/GlVideoTexture.presentVideoFrame:Lkotlin/jvm/functions/Function1;
        //    47: invokedynamic   BootstrapMethod #2, handleMessage:(Lkotlin/jvm/functions/Function1;)Landroid/os/Handler$Callback;
        //    52: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
        //    55: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoDecoderHandler:Landroid/os/Handler;
        //    58: aload_0         /* this */
        //    59: invokevirtual   ly/img/android/opengl/textures/GlVideoTexture.getSurfaceTexture:()Landroid/graphics/SurfaceTexture;
        //    62: dup            
        //    63: ifnull          76
        //    66: aload_0         /* this */
        //    67: getfield        ly/img/android/opengl/textures/GlVideoTexture.onFrameDecoded:Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;
        //    70: invokevirtual   android/graphics/SurfaceTexture.setOnFrameAvailableListener:(Landroid/graphics/SurfaceTexture$OnFrameAvailableListener;)V
        //    73: goto            77
        //    76: pop            
        //    77: return         
        //    StackMapTable: 00 02 FF 00 4C 00 05 07 00 02 07 00 3B 07 00 3B 01 07 00 02 00 01 07 00 BB 00
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
    
    public final void decoderRelease() {
        this.videoIsLoaded = false;
        final NativeVideoDecoder decoder = this.decoder;
        this.decoder = null;
        final NativeVideoDecoder nativeVideoDecoder = decoder;
        if (nativeVideoDecoder != null) {
            nativeVideoDecoder.release();
        }
        this.isFrameRendered.set(true);
    }
    
    @Override
    protected void onRelease() {
        this.videoDecoderHandler.removeCallbacksAndMessages((Object)null);
        this.videoDecoderThread.quit();
        this.videoIsLoaded = false;
        final NativeVideoDecoder decoder = this.decoder;
        this.decoder = null;
        this.videoSource = null;
        final NativeVideoDecoder nativeVideoDecoder = decoder;
        if (nativeVideoDecoder != null) {
            nativeVideoDecoder.release();
        }
        final SurfaceTexture surfaceTexture = this.getSurfaceTexture();
        if (surfaceTexture != null) {
            surfaceTexture.setOnFrameAvailableListener((SurfaceTexture$OnFrameAvailableListener)null);
        }
        super.onRelease();
    }
    
    public void setSource(@NotNull final VideoSource videoSource) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "videoSource"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: getfield        ly/img/android/opengl/textures/GlVideoTexture.waitForFrameLock:Ljava/util/concurrent/locks/ReentrantLock;
        //    10: checkcast       Ljava/util/concurrent/locks/Lock;
        //    13: astore_2       
        //    14: aload_2        
        //    15: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    20: nop            
        //    21: iconst_0       
        //    22: istore_3        /* $i$a$-withLock-GlVideoTexture$setSource$1 */
        //    23: aload_0         /* this */
        //    24: iconst_0       
        //    25: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoIsLoaded:Z
        //    28: aload_0         /* this */
        //    29: aload_1         /* videoSource */
        //    30: putfield        ly/img/android/opengl/textures/GlVideoTexture.videoSource:Lly/img/android/pesdk/backend/decoder/VideoSource;
        //    33: aload_0         /* this */
        //    34: aload_0         /* this */
        //    35: getfield        ly/img/android/opengl/textures/GlVideoTexture.decoder:Lly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder;
        //    38: dup            
        //    39: ifnull          67
        //    42: astore          4
        //    44: aload           4
        //    46: astore          5
        //    48: astore          6
        //    50: iconst_0       
        //    51: istore          $i$a$-also-GlVideoTexture$setSource$1$1
        //    53: aload           it
        //    55: aload_1         /* videoSource */
        //    56: invokevirtual   ly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder.setSource:(Lly/img/android/pesdk/backend/decoder/VideoSource;)V
        //    59: aload           6
        //    61: aload           4
        //    63: dup            
        //    64: ifnonnull       76
        //    67: pop            
        //    68: new             Lly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder;
        //    71: dup            
        //    72: aload_1         /* videoSource */
        //    73: invokespecial   ly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder.<init>:(Lly/img/android/pesdk/backend/decoder/VideoSource;)V
        //    76: astore          8
        //    78: aload           8
        //    80: astore          9
        //    82: astore          6
        //    84: iconst_0       
        //    85: istore          $i$a$-also-GlVideoTexture$setSource$1$2
        //    87: aload_0         /* this */
        //    88: aload           it
        //    90: invokevirtual   ly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder.getFormat:()Lly/img/android/pesdk/backend/decoder/VideoSource$FormatInfo;
        //    93: invokevirtual   ly/img/android/pesdk/backend/decoder/VideoSource$FormatInfo.getWidth:()I
        //    96: aload           it
        //    98: invokevirtual   ly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder.getFormat:()Lly/img/android/pesdk/backend/decoder/VideoSource$FormatInfo;
        //   101: invokevirtual   ly/img/android/pesdk/backend/decoder/VideoSource$FormatInfo.getHeight:()I
        //   104: invokevirtual   ly/img/android/opengl/textures/GlVideoTexture.setSize:(II)V
        //   107: nop            
        //   108: aload           6
        //   110: aload           8
        //   112: putfield        ly/img/android/opengl/textures/GlVideoTexture.decoder:Lly/img/android/pesdk/backend/decoder/video/NativeVideoDecoder;
        //   115: aload_0         /* this */
        //   116: ldc2_w          -2
        //   119: invokespecial   ly/img/android/opengl/textures/GlVideoTexture.setFrameTimeInNano:(J)V
        //   122: nop            
        //   123: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   126: astore_3       
        //   127: aload_2        
        //   128: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   133: goto            145
        //   136: astore_3       
        //   137: aload_2        
        //   138: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   143: aload_3        
        //   144: athrow         
        //   145: return         
        //    StackMapTable: 00 04 FF 00 43 00 04 07 00 02 07 00 8F 07 00 EC 01 00 02 07 00 02 07 00 D0 FF 00 08 00 04 07 00 02 07 00 8F 07 00 EC 01 00 02 07 00 02 07 00 D0 FF 00 3B 00 03 07 00 02 07 00 8F 07 00 EC 00 01 07 01 0F FF 00 08 00 0A 07 00 02 07 00 8F 07 00 EC 07 01 03 01 00 07 00 02 00 07 00 D0 07 00 D0 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  20     127    136    145    Any
        //  136    137    136    145    Any
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
    
    public boolean waitForNextFame(final long atTimeInNano) {
        final ReentrantLock reentrantLock = this.waitForFrameLock;
        reentrantLock.lock();
        try {
            final int n = 0;
            this.isFrameRendered.set(this.renderedFrameTimeInNano == TypeExtensionsKt.butMin(atTimeInNano, 0L));
            this.setFrameTimeInNano(TypeExtensionsKt.butMin(atTimeInNano, 0L));
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock.unlock();
        }
        this.isFrameRendered.waitUntilTrue();
        return this.nextFrameAvailable;
    }
    
    public void requestNextFrame(final long atTimeInNano, final boolean awaitFirstFrame) {
        if (!this.videoIsLoaded && !awaitFirstFrame) {
            final ReentrantLock reentrantLock = this.waitForFrameLock;
            reentrantLock.lock();
            try {
                final int n = 0;
                this.setFrameTimeInNano(atTimeInNano);
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        this.waitForNextFame(atTimeInNano);
    }
    
    private static final void onFrameDecoded$lambda-0(final GlVideoTexture this$0, final SurfaceTexture it) {
        Intrinsics.checkNotNullParameter((Object)this$0, "this$0");
        this$0.videoIsLoaded = true;
    }
    
    private static final boolean videoDecoderHandler$lambda-2(final Function1 $tmp0, final Message p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter((Object)p0, "p0");
        return (boolean)$tmp0.invoke((Object)p0);
    }
    
    private static final boolean onRebound$lambda-4(final Function1 $tmp0, final Message p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter((Object)p0, "p0");
        return (boolean)$tmp0.invoke((Object)p0);
    }
    
    public GlVideoTexture() {
        this(0, 0, 3, null);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0086T¢\u0006\u0002\n\u0000¨\u0006\n" }, d2 = { "Lly/img/android/opengl/textures/GlVideoTexture$Companion;", "", "()V", "COOL_DOWN_EXTRA_ROUNDS", "", "FIRST_FRAME", "", "NO_FRAME_REQUESTED", "TAG", "", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
