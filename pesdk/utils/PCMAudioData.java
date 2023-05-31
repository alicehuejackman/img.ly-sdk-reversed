// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import ly.img.android.pesdk.audio.AudioSampleInterpolator;
import kotlin.ranges.LongRange;
import java.util.Arrays;
import android.util.Log;
import java.util.Map;
import kotlin.collections.MapsKt;
import java.util.TreeMap;
import androidx.annotation.VisibleForTesting;
import ly.img.android.pesdk.audio.PCMChannelConverter;
import kotlin.jvm.JvmStatic;
import kotlin.Unit;
import kotlin.math.MathKt;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.DefaultConstructorMarker;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import kotlin.jvm.functions.Function1;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.decoder.audio.NativeAudioDecoder;
import ly.img.android.pesdk.backend.decoder.AudioSource;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0007\u0018\u0000 @2\u00020\u0001:\u0004>?@AB\u0017\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\u0010\u0010.\u001a\u00020/2\b\b\u0002\u00100\u001a\u00020\u0015J\u0016\u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u0015J \u00101\u001a\u0002022\u0006\u00103\u001a\u00020\u00152\u0006\u00104\u001a\u00020\u00152\u0006\u00105\u001a\u000206H\u0016J\b\u00107\u001a\u000208H\u0002J(\u00109\u001a\u00020\u00152\u0006\u0010:\u001a\u00020;2\u0006\u00103\u001a\u00020\u00152\u0006\u00105\u001a\u0002062\u0006\u0010<\u001a\u000206H\u0016J\b\u0010=\u001a\u00020/H\u0016R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u000e\u0012\u0004\u0012\u00020\u0011\u0012\u0004\u0012\u00020\u00050\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0082\u000e¢\u0006\u0002\n\u0000R\u001e\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0014\u001a\u00020\u0015@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u001a8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001d\u0010\u001e\u001a\u0004\b\u001b\u0010\u001cR\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010!\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010#\"\u0004\b$\u0010\u0018R\u001a\u0010%\u001a\u00020\u0015X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010#\"\u0004\b'\u0010\u0018R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b(\u0010)\"\u0004\b*\u0010+R\u000e\u0010,\u001a\u00020-X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006B" }, d2 = { "Lly/img/android/pesdk/utils/PCMAudioData;", "Lly/img/android/pesdk/utils/IPCMAudioData;", "source", "Lly/img/android/pesdk/backend/decoder/AudioSource;", "autoPreBuffer", "", "(Lly/img/android/pesdk/backend/decoder/AudioSource;Z)V", "audioDecoderHandler", "Landroid/os/Handler;", "audioDecoderThread", "Landroid/os/HandlerThread;", "getAutoPreBuffer", "()Z", "setAutoPreBuffer", "(Z)V", "bufferFillTask", "Lkotlin/Function1;", "Landroid/os/Message;", "bufferLock", "Ljava/util/concurrent/locks/ReentrantReadWriteLock;", "value", "", "currentIndex", "setCurrentIndex", "(J)V", "data", "Lly/img/android/pesdk/utils/PCMAudioData$Buffer;", "getData", "()Lly/img/android/pesdk/utils/PCMAudioData$Buffer;", "data$delegate", "Lly/img/android/pesdk/utils/SingletonReference;", "decoder", "Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;", "lastSourceIndex", "getLastSourceIndex", "()J", "setLastSourceIndex", "latestFetchedIndex", "getLatestFetchedIndex", "setLatestFetchedIndex", "getSource", "()Lly/img/android/pesdk/backend/decoder/AudioSource;", "setSource", "(Lly/img/android/pesdk/backend/decoder/AudioSource;)V", "sourceLock", "Ljava/util/concurrent/locks/ReentrantLock;", "fillBuffer", "", "lastIndex", "getBufferFillRate", "", "startIndex", "minIndex", "destinationSampleRate", "", "getCacheFormat", "Lly/img/android/pesdk/utils/PCMAudioData$Format;", "readData", "buffer", "", "destinationOutputChannelCount", "release", "Buffer", "BufferEntry", "Companion", "Format", "pesdk-backend-core_release" })
public final class PCMAudioData implements IPCMAudioData
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private AudioSource source;
    private boolean autoPreBuffer;
    @Nullable
    private NativeAudioDecoder decoder;
    @NotNull
    private final SingletonReference data$delegate;
    @NotNull
    private ReentrantLock sourceLock;
    @NotNull
    private ReentrantReadWriteLock bufferLock;
    private long currentIndex;
    @NotNull
    private final Function1<Message, Boolean> bufferFillTask;
    @Nullable
    private HandlerThread audioDecoderThread;
    @Nullable
    private Handler audioDecoderHandler;
    private long lastSourceIndex;
    private long latestFetchedIndex;
    private static final boolean DEBUG = false;
    private static final int BUFFER_TIME_IN_SEK = 1;
    private static final int SEEK_THRESHOLD_IN_SEK = 1;
    
    public PCMAudioData(@NotNull final AudioSource source, final boolean autoPreBuffer) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "source"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_0         /* this */
        //     7: invokespecial   java/lang/Object.<init>:()V
        //    10: aload_0         /* this */
        //    11: aload_1         /* source */
        //    12: putfield        ly/img/android/pesdk/utils/PCMAudioData.source:Lly/img/android/pesdk/backend/decoder/AudioSource;
        //    15: aload_0         /* this */
        //    16: iload_2         /* autoPreBuffer */
        //    17: putfield        ly/img/android/pesdk/utils/PCMAudioData.autoPreBuffer:Z
        //    20: aload_0         /* this */
        //    21: astore          7
        //    23: nop            
        //    24: aload           7
        //    26: new             Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;
        //    29: dup            
        //    30: aload_0         /* this */
        //    31: getfield        ly/img/android/pesdk/utils/PCMAudioData.source:Lly/img/android/pesdk/backend/decoder/AudioSource;
        //    34: invokespecial   ly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder.<init>:(Lly/img/android/pesdk/backend/decoder/AudioSource;)V
        //    37: astore_3       
        //    38: goto            50
        //    41: astore          4
        //    43: aload           7
        //    45: aconst_null    
        //    46: checkcast       Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;
        //    49: astore_3       
        //    50: aload_3        
        //    51: putfield        ly/img/android/pesdk/utils/PCMAudioData.decoder:Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;
        //    54: aload_0         /* this */
        //    55: new             Lly/img/android/pesdk/utils/SingletonReference;
        //    58: dup            
        //    59: aconst_null    
        //    60: aconst_null    
        //    61: new             Lly/img/android/pesdk/utils/PCMAudioData$data$2;
        //    64: dup            
        //    65: aload_0         /* this */
        //    66: invokespecial   ly/img/android/pesdk/utils/PCMAudioData$data$2.<init>:(Lly/img/android/pesdk/utils/PCMAudioData;)V
        //    69: checkcast       Lkotlin/jvm/functions/Function0;
        //    72: iconst_3       
        //    73: aconst_null    
        //    74: invokespecial   ly/img/android/pesdk/utils/SingletonReference.<init>:(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //    77: putfield        ly/img/android/pesdk/utils/PCMAudioData.data$delegate:Lly/img/android/pesdk/utils/SingletonReference;
        //    80: aload_0         /* this */
        //    81: new             Ljava/util/concurrent/locks/ReentrantLock;
        //    84: dup            
        //    85: iconst_1       
        //    86: invokespecial   java/util/concurrent/locks/ReentrantLock.<init>:(Z)V
        //    89: putfield        ly/img/android/pesdk/utils/PCMAudioData.sourceLock:Ljava/util/concurrent/locks/ReentrantLock;
        //    92: aload_0         /* this */
        //    93: new             Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //    96: dup            
        //    97: iconst_1       
        //    98: invokespecial   java/util/concurrent/locks/ReentrantReadWriteLock.<init>:(Z)V
        //   101: putfield        ly/img/android/pesdk/utils/PCMAudioData.bufferLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //   104: aload_0         /* this */
        //   105: new             Lly/img/android/pesdk/utils/PCMAudioData$bufferFillTask$1;
        //   108: dup            
        //   109: aload_0         /* this */
        //   110: invokespecial   ly/img/android/pesdk/utils/PCMAudioData$bufferFillTask$1.<init>:(Lly/img/android/pesdk/utils/PCMAudioData;)V
        //   113: checkcast       Lkotlin/jvm/functions/Function1;
        //   116: putfield        ly/img/android/pesdk/utils/PCMAudioData.bufferFillTask:Lkotlin/jvm/functions/Function1;
        //   119: aload_0         /* this */
        //   120: aload_0         /* this */
        //   121: getfield        ly/img/android/pesdk/utils/PCMAudioData.autoPreBuffer:Z
        //   124: ifeq            156
        //   127: new             Landroid/os/HandlerThread;
        //   130: dup            
        //   131: ldc             "audio decoder"
        //   133: invokespecial   android/os/HandlerThread.<init>:(Ljava/lang/String;)V
        //   136: astore_3       
        //   137: aload_3        
        //   138: astore          4
        //   140: astore          7
        //   142: iconst_0       
        //   143: istore          $i$a$-also-PCMAudioData$audioDecoderThread$1
        //   145: aload           it
        //   147: invokevirtual   android/os/HandlerThread.start:()V
        //   150: aload           7
        //   152: aload_3        
        //   153: goto            157
        //   156: aconst_null    
        //   157: putfield        ly/img/android/pesdk/utils/PCMAudioData.audioDecoderThread:Landroid/os/HandlerThread;
        //   160: aload_0         /* this */
        //   161: aload_0         /* this */
        //   162: getfield        ly/img/android/pesdk/utils/PCMAudioData.audioDecoderThread:Landroid/os/HandlerThread;
        //   165: dup            
        //   166: ifnull          203
        //   169: astore          5
        //   171: astore          7
        //   173: iconst_0       
        //   174: istore          $i$a$-let-PCMAudioData$audioDecoderHandler$1
        //   176: new             Landroid/os/Handler;
        //   179: dup            
        //   180: aload           it
        //   182: invokevirtual   android/os/HandlerThread.getLooper:()Landroid/os/Looper;
        //   185: aload_0         /* this */
        //   186: getfield        ly/img/android/pesdk/utils/PCMAudioData.bufferFillTask:Lkotlin/jvm/functions/Function1;
        //   189: invokedynamic   BootstrapMethod #0, handleMessage:(Lkotlin/jvm/functions/Function1;)Landroid/os/Handler$Callback;
        //   194: invokespecial   android/os/Handler.<init>:(Landroid/os/Looper;Landroid/os/Handler$Callback;)V
        //   197: aload           7
        //   199: swap           
        //   200: goto            205
        //   203: pop            
        //   204: aconst_null    
        //   205: putfield        ly/img/android/pesdk/utils/PCMAudioData.audioDecoderHandler:Landroid/os/Handler;
        //   208: aload_0         /* this */
        //   209: ldc2_w          9223372036854775807
        //   212: putfield        ly/img/android/pesdk/utils/PCMAudioData.lastSourceIndex:J
        //   215: aload_0         /* this */
        //   216: ldc2_w          -1
        //   219: putfield        ly/img/android/pesdk/utils/PCMAudioData.latestFetchedIndex:J
        //   222: return         
        //    StackMapTable: 00 06 FF 00 29 00 08 07 00 02 07 00 91 01 00 00 00 00 07 00 02 00 01 07 00 0B FF 00 08 00 08 07 00 02 07 00 91 01 07 00 1F 00 00 00 07 00 02 00 01 07 00 02 F7 00 69 07 00 02 FF 00 00 00 08 07 00 02 07 00 91 01 07 00 04 00 00 00 07 00 02 00 02 07 00 02 07 00 51 FF 00 2D 00 08 07 00 02 07 00 91 01 07 00 04 00 00 00 07 00 02 00 02 07 00 02 07 00 51 FF 00 01 00 08 07 00 02 07 00 91 01 07 00 04 00 00 00 07 00 02 00 02 07 00 02 07 00 5F
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                                                                              
        //  -----  -----  -----  -----  ----------------------------------------------------------------------------------
        //  23     38     41     50     Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder$InvalidAudioSource;
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
    
    @NotNull
    public final AudioSource getSource() {
        return this.source;
    }
    
    public final void setSource(@NotNull final AudioSource <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.source = <set-?>;
    }
    
    public final boolean getAutoPreBuffer() {
        return this.autoPreBuffer;
    }
    
    public final void setAutoPreBuffer(final boolean <set-?>) {
        this.autoPreBuffer = <set-?>;
    }
    
    private final Buffer getData() {
        return (Buffer)((Lazy)this.data$delegate).getValue();
    }
    
    private final void setCurrentIndex(final long value) {
        boolean b = false;
        Label_0040: {
            if (this.autoPreBuffer) {
                final Handler audioDecoderHandler = this.audioDecoderHandler;
                if (audioDecoderHandler != null && !audioDecoderHandler.hasMessages(0)) {
                    b = true;
                    break Label_0040;
                }
            }
            b = false;
        }
        final boolean outOfWork = b;
        if (this.currentIndex != value) {
            this.currentIndex = value;
            if (outOfWork) {
                final Handler audioDecoderHandler2 = this.audioDecoderHandler;
                if (audioDecoderHandler2 != null) {
                    audioDecoderHandler2.sendEmptyMessage(0);
                }
            }
        }
    }
    
    public final long getLastSourceIndex() {
        return this.lastSourceIndex;
    }
    
    public final void setLastSourceIndex(final long <set-?>) {
        this.lastSourceIndex = <set-?>;
    }
    
    public final long getLatestFetchedIndex() {
        return this.latestFetchedIndex;
    }
    
    public final void setLatestFetchedIndex(final long <set-?>) {
        this.latestFetchedIndex = <set-?>;
    }
    
    public final void fillBuffer(final long lastIndex) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/PCMAudioData.decoder:Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;
        //     4: dup            
        //     5: ifnonnull       10
        //     8: pop            
        //     9: return         
        //    10: astore_3        /* decoder */
        //    11: iconst_0       
        //    12: istore          $i$f$loopIfTrue
        //    14: iconst_0       
        //    15: istore          $i$a$-loopIfTrue-PCMAudioData$fillBuffer$1
        //    17: nop            
        //    18: aload_0         /* this */
        //    19: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getSourceLock$p:(Lly/img/android/pesdk/utils/PCMAudioData;)Ljava/util/concurrent/locks/ReentrantLock;
        //    22: checkcast       Ljava/util/concurrent/locks/Lock;
        //    25: astore          6
        //    27: aload           6
        //    29: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    34: nop            
        //    35: iconst_0       
        //    36: istore          $i$a$-withLock-PCMAudioData$fillBuffer$1$1
        //    38: aload_0         /* this */
        //    39: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getCurrentIndex$p:(Lly/img/android/pesdk/utils/PCMAudioData;)J
        //    42: lstore          currentIndex
        //    44: aload_0         /* this */
        //    45: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getData:(Lly/img/android/pesdk/utils/PCMAudioData;)Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //    48: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.getFormat$pesdk_backend_core_release:()Lly/img/android/pesdk/utils/PCMAudioData$Format;
        //    51: dup            
        //    52: ifnonnull       71
        //    55: pop            
        //    56: iconst_0       
        //    57: istore          10
        //    59: aload           6
        //    61: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    66: iload           10
        //    68: goto            284
        //    71: astore          format
        //    73: lload_1         /* lastIndex */
        //    74: ldc2_w          -1
        //    77: lcmp           
        //    78: ifne            95
        //    81: lload           currentIndex
        //    83: iconst_1       
        //    84: aload           format
        //    86: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Format.getSampleRate:()I
        //    89: imul           
        //    90: i2l            
        //    91: ladd           
        //    92: goto            96
        //    95: lload_1         /* lastIndex */
        //    96: aload_0         /* this */
        //    97: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData.getLastSourceIndex:()J
        //   100: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMax:(JJ)J
        //   103: lstore          minIndexToBuffer
        //   105: lload           currentIndex
        //   107: aload_0         /* this */
        //   108: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getData:(Lly/img/android/pesdk/utils/PCMAudioData;)Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //   111: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.getMinBuffered:()J
        //   114: lcmp           
        //   115: ifle            146
        //   118: aload_0         /* this */
        //   119: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getData:(Lly/img/android/pesdk/utils/PCMAudioData;)Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //   122: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.getMaxBuffered:()J
        //   125: lload           minIndexToBuffer
        //   127: lcmp           
        //   128: ifle            146
        //   131: iconst_0       
        //   132: istore          14
        //   134: aload           6
        //   136: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   141: iload           14
        //   143: goto            284
        //   146: new             Lkotlin/jvm/internal/Ref$BooleanRef;
        //   149: dup            
        //   150: invokespecial   kotlin/jvm/internal/Ref$BooleanRef.<init>:()V
        //   153: astore          bufferHasSpace
        //   155: aload           bufferHasSpace
        //   157: iconst_1       
        //   158: putfield        kotlin/jvm/internal/Ref$BooleanRef.element:Z
        //   161: aload_3         /* decoder */
        //   162: lconst_0       
        //   163: lconst_0       
        //   164: aconst_null    
        //   165: new             Lly/img/android/pesdk/utils/PCMAudioData$fillBuffer$1$1$hasDataLeft$1;
        //   168: dup            
        //   169: aload_0         /* this */
        //   170: aload           bufferHasSpace
        //   172: lload           minIndexToBuffer
        //   174: lload           currentIndex
        //   176: invokespecial   ly/img/android/pesdk/utils/PCMAudioData$fillBuffer$1$1$hasDataLeft$1.<init>:(Lly/img/android/pesdk/utils/PCMAudioData;Lkotlin/jvm/internal/Ref$BooleanRef;JJ)V
        //   179: checkcast       Lkotlin/jvm/functions/Function2;
        //   182: bipush          7
        //   184: aconst_null    
        //   185: invokestatic    ly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder.pullNextShortData$default:(Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;JJ[SLkotlin/jvm/functions/Function2;ILjava/lang/Object;)Z
        //   188: istore          hasDataLeft
        //   190: iload           hasDataLeft
        //   192: ifne            222
        //   195: aload_0         /* this */
        //   196: invokestatic    ly/img/android/pesdk/utils/PCMAudioData.access$getData:(Lly/img/android/pesdk/utils/PCMAudioData;)Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //   199: aload_0         /* this */
        //   200: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData.getLatestFetchedIndex:()J
        //   203: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.setLastIndex:(J)V
        //   206: aload_0         /* this */
        //   207: aload_0         /* this */
        //   208: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData.getLatestFetchedIndex:()J
        //   211: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData.setLastSourceIndex:(J)V
        //   214: aload_3         /* decoder */
        //   215: lconst_0       
        //   216: iconst_0       
        //   217: iconst_2       
        //   218: aconst_null    
        //   219: invokestatic    ly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder.seekTo$default:(Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;JIILjava/lang/Object;)V
        //   222: iload           hasDataLeft
        //   224: ifeq            239
        //   227: aload           bufferHasSpace
        //   229: getfield        kotlin/jvm/internal/Ref$BooleanRef.element:Z
        //   232: ifeq            239
        //   235: iconst_1       
        //   236: goto            240
        //   239: iconst_0       
        //   240: istore          null
        //   242: aload           6
        //   244: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   249: iload           7
        //   251: goto            266
        //   254: astore          7
        //   256: aload           6
        //   258: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   263: aload           7
        //   265: athrow         
        //   266: istore          6
        //   268: goto            281
        //   271: astore          e
        //   273: aload           e
        //   275: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   278: iconst_0       
        //   279: istore          6
        //   281: iload           6
        //   283: nop            
        //   284: ifne            14
        //   287: nop            
        //   288: return         
        //    StackMapTable: 00 0E 4A 07 00 1F FD 00 03 07 00 1F 01 FF 00 38 00 08 07 00 02 04 07 00 1F 01 01 07 00 C2 01 04 00 01 07 00 D6 FD 00 17 00 07 00 D6 40 04 FC 00 31 04 FE 00 4B 00 07 00 EA 01 10 40 01 FF 00 0D 00 06 07 00 02 04 07 00 1F 01 01 07 00 C2 00 01 07 01 14 FF 00 0B 00 0E 07 00 02 04 07 00 1F 01 01 07 00 C2 01 04 00 07 00 D6 04 00 07 00 EA 01 00 01 01 FF 00 04 00 05 07 00 02 04 07 00 1F 01 01 00 01 07 00 BC FC 00 09 01 FF 00 02 00 05 07 00 02 04 07 00 1F 01 01 00 01 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  34     59     254    266    Any
        //  71     134    254    266    Any
        //  146    242    254    266    Any
        //  254    256    254    266    Any
        //  17     268    271    281    Ljava/lang/Exception;
        // 
        // The error that occurred was:
        // 
        // java.lang.IllegalStateException: Inconsistent stack size at #0284 (coming from #0265).
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
    
    private final Format getCacheFormat() {
        Object format$pesdk_backend_core_release;
        if ((format$pesdk_backend_core_release = this.getData().getFormat$pesdk_backend_core_release()) == null) {
            final PCMAudioData $this$getCacheFormat_u24lambda_u2d7 = this;
            final int n = 0;
            final NativeAudioDecoder decoder2 = $this$getCacheFormat_u24lambda_u2d7.decoder;
            if (decoder2 == null) {
                return new Format(44100, 2);
            }
            final NativeAudioDecoder decoder = decoder2;
            decoder.streamingFormat();
            final AudioSource.FormatInfo it = decoder.getFormat();
            final int n2 = 0;
            final Format it2 = new Format(it.getSampleRate(), it.getChannelCount());
            final int n3 = 0;
            $this$getCacheFormat_u24lambda_u2d7.getData().setFormat$pesdk_backend_core_release(it2);
            format$pesdk_backend_core_release = it2;
        }
        return (Format)format$pesdk_backend_core_release;
    }
    
    @Override
    public long readData(@NotNull final short[] buffer, final long startIndex, final int destinationSampleRate, final int destinationOutputChannelCount) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "buffer"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: lconst_0       
        //     8: lstore          sampleIndex
        //    10: aload_1         /* buffer */
        //    11: arraylength    
        //    12: iload           destinationOutputChannelCount
        //    14: idiv           
        //    15: istore          sampleCount
        //    17: aload_0         /* this */
        //    18: getfield        ly/img/android/pesdk/utils/PCMAudioData.decoder:Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;
        //    21: astore          decoder
        //    23: aload           decoder
        //    25: ifnull          293
        //    28: aload_0         /* this */
        //    29: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.getCacheFormat:()Lly/img/android/pesdk/utils/PCMAudioData$Format;
        //    32: astore          format
        //    34: aload           format
        //    36: iload           destinationSampleRate
        //    38: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Format.getSampleFactor:(I)D
        //    41: dstore          factor
        //    43: lload_2         /* startIndex */
        //    44: l2d            
        //    45: dload           factor
        //    47: dmul           
        //    48: invokestatic    kotlin/math/MathKt.roundToLong:(D)J
        //    51: lstore          internalIndex
        //    53: lload_2         /* startIndex */
        //    54: iload           sampleCount
        //    56: i2l            
        //    57: ladd           
        //    58: l2d            
        //    59: dload           factor
        //    61: dmul           
        //    62: invokestatic    kotlin/math/MathKt.roundToLong:(D)J
        //    65: lstore          internalLastNeededIndex
        //    67: iconst_1       
        //    68: aload           format
        //    70: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Format.getSampleRate:()I
        //    73: imul           
        //    74: istore          seekThresholdInSampleCount
        //    76: lload           internalIndex
        //    78: aload_0         /* this */
        //    79: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.getData:()Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //    82: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.getMinBuffered:()J
        //    85: lcmp           
        //    86: iflt            106
        //    89: lload           internalIndex
        //    91: aload_0         /* this */
        //    92: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.getData:()Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //    95: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.getMaxBuffered:()J
        //    98: iload           seekThresholdInSampleCount
        //   100: i2l            
        //   101: ladd           
        //   102: lcmp           
        //   103: ifle            197
        //   106: aload_0         /* this */
        //   107: getfield        ly/img/android/pesdk/utils/PCMAudioData.sourceLock:Ljava/util/concurrent/locks/ReentrantLock;
        //   110: checkcast       Ljava/util/concurrent/locks/Lock;
        //   113: astore          18
        //   115: aload           18
        //   117: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //   122: nop            
        //   123: iconst_0       
        //   124: istore          $i$a$-withLock-PCMAudioData$readData$1
        //   126: aload           decoder
        //   128: getstatic       ly/img/android/pesdk/utils/PCMAudioData.Companion:Lly/img/android/pesdk/utils/PCMAudioData$Companion;
        //   131: lload_2         /* startIndex */
        //   132: aload           format
        //   134: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Format.getSampleRate:()I
        //   137: iconst_0       
        //   138: iconst_4       
        //   139: aconst_null    
        //   140: invokestatic    ly/img/android/pesdk/utils/PCMAudioData$Companion.sampleIndexToNanoTime$default:(Lly/img/android/pesdk/utils/PCMAudioData$Companion;JIIILjava/lang/Object;)J
        //   143: getstatic       java/util/concurrent/TimeUnit.NANOSECONDS:Ljava/util/concurrent/TimeUnit;
        //   146: getstatic       java/util/concurrent/TimeUnit.MICROSECONDS:Ljava/util/concurrent/TimeUnit;
        //   149: invokestatic    ly/img/android/pesdk/utils/TimeUtilsKt.convert:(JLjava/util/concurrent/TimeUnit;Ljava/util/concurrent/TimeUnit;)J
        //   152: lconst_0       
        //   153: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(JJ)J
        //   156: iconst_0       
        //   157: iconst_2       
        //   158: aconst_null    
        //   159: invokestatic    ly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder.seekTo$default:(Lly/img/android/pesdk/backend/decoder/audio/NativeAudioDecoder;JIILjava/lang/Object;)V
        //   162: nop            
        //   163: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   166: astore          19
        //   168: aload           18
        //   170: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   175: goto            190
        //   178: astore          19
        //   180: aload           18
        //   182: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   187: aload           19
        //   189: athrow         
        //   190: aload_0         /* this */
        //   191: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.getData:()Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //   194: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.clear:()V
        //   197: aload_0         /* this */
        //   198: lload           internalIndex
        //   200: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.setCurrentIndex:(J)V
        //   203: aload_0         /* this */
        //   204: lload           internalLastNeededIndex
        //   206: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData.fillBuffer:(J)V
        //   209: nop            
        //   210: aload_0         /* this */
        //   211: getfield        ly/img/android/pesdk/utils/PCMAudioData.bufferLock:Ljava/util/concurrent/locks/ReentrantReadWriteLock;
        //   214: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock.readLock:()Ljava/util/concurrent/locks/ReentrantReadWriteLock$ReadLock;
        //   217: astore          19
        //   219: aload           19
        //   221: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.lock:()V
        //   224: nop            
        //   225: iconst_0       
        //   226: istore          $i$a$-read-PCMAudioData$readData$2
        //   228: aload_0         /* this */
        //   229: invokespecial   ly/img/android/pesdk/utils/PCMAudioData.getData:()Lly/img/android/pesdk/utils/PCMAudioData$Buffer;
        //   232: aload_1         /* buffer */
        //   233: lload_2         /* startIndex */
        //   234: iload           destinationSampleRate
        //   236: iload           destinationOutputChannelCount
        //   238: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$Buffer.get16BitSamples:([SJII)J
        //   241: lstore          null
        //   243: aload           19
        //   245: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //   248: lload           20
        //   250: goto            263
        //   253: astore          20
        //   255: aload           19
        //   257: invokevirtual   java/util/concurrent/locks/ReentrantReadWriteLock$ReadLock.unlock:()V
        //   260: aload           20
        //   262: athrow         
        //   263: lstore          18
        //   265: goto            286
        //   268: astore          e
        //   270: aload           e
        //   272: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   275: aload_1         /* buffer */
        //   276: invokestatic    ly/img/android/pesdk/utils/FastArrayOp.clear:([S)V
        //   279: lload_2         /* startIndex */
        //   280: iload           sampleCount
        //   282: i2l            
        //   283: ladd           
        //   284: lstore          18
        //   286: lload           18
        //   288: lstore          sampleIndex
        //   290: goto            304
        //   293: aload_1         /* buffer */
        //   294: invokestatic    ly/img/android/pesdk/utils/FastArrayOp.clear:([S)V
        //   297: lload_2         /* startIndex */
        //   298: iload           sampleCount
        //   300: i2l            
        //   301: ladd           
        //   302: lstore          sampleIndex
        //   304: lload           sampleIndex
        //   306: lreturn        
        //    StackMapTable: 00 0A FF 00 6A 00 0D 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 07 00 D6 03 04 04 01 00 00 FF 00 47 00 0E 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 07 00 D6 03 04 04 01 07 00 C2 00 01 07 01 14 FC 00 0B 07 01 64 F9 00 06 FF 00 37 00 0F 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 07 00 D6 03 04 04 01 00 07 01 73 00 01 07 01 14 FF 00 09 00 10 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 07 00 D6 03 04 04 01 00 07 01 73 04 00 01 04 FF 00 04 00 0D 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 07 00 D6 03 04 04 01 00 01 07 00 BC FC 00 11 04 FF 00 06 00 08 07 00 02 07 01 8B 04 01 01 04 01 07 00 1F 00 00 0A
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  122    168    178    190    Any
        //  178    180    178    190    Any
        //  224    243    253    263    Any
        //  253    255    253    263    Any
        //  209    265    268    286    Ljava/lang/Exception;
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
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visitVariable(StackMappingVisitor.java:470)
        //     at com.strobel.assembler.ir.Instruction.accept(Instruction.java:556)
        //     at com.strobel.assembler.ir.StackMappingVisitor$InstructionAnalyzer.visit(StackMappingVisitor.java:403)
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
    
    @Override
    public float getBufferFillRate(final long startIndex, final long minIndex, final int destinationSampleRate) {
        final double factor = this.getCacheFormat().getSampleFactor(destinationSampleRate);
        return this.getBufferFillRate(MathKt.roundToLong(startIndex * factor), MathKt.roundToLong(minIndex * factor));
    }
    
    public final float getBufferFillRate(final long startIndex, final long minIndex) {
        return (this.getData().getMinBuffered() >= 0L) ? ((startIndex > this.getData().getMinBuffered()) ? ((this.getData().getMaxBuffered() - startIndex) / (float)(minIndex - startIndex)) : 0.0f) : -1.0f;
    }
    
    @Override
    public void release() {
        final Handler audioDecoderHandler = this.audioDecoderHandler;
        if (audioDecoderHandler != null) {
            audioDecoderHandler.removeCallbacksAndMessages((Object)null);
        }
        final HandlerThread audioDecoderThread = this.audioDecoderThread;
        if (audioDecoderThread != null) {
            audioDecoderThread.quit();
        }
        final NativeAudioDecoder decoder = this.decoder;
        this.decoder = null;
        final NativeAudioDecoder nativeAudioDecoder = decoder;
        if (nativeAudioDecoder != null) {
            nativeAudioDecoder.release();
        }
        final ReentrantReadWriteLock bufferLock = this.bufferLock;
        final ReentrantReadWriteLock.ReadLock lock = bufferLock.readLock();
        final int n = (bufferLock.getWriteHoldCount() == 0) ? bufferLock.getReadHoldCount() : 0;
        for (int i = 0; i < n; ++i) {
            lock.unlock();
        }
        final ReentrantReadWriteLock.WriteLock writeLock = bufferLock.writeLock();
        writeLock.lock();
        try {
            final int n2 = 0;
            this.getData().clear();
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            for (int j = 0; j < n; ++j) {
                lock.lock();
            }
            writeLock.unlock();
        }
    }
    
    @Override
    public void close() {
        DefaultImpls.close(this);
    }
    
    private static final boolean audioDecoderHandler$lambda-2$lambda-1(final Function1 $tmp0, final Message p0) {
        Intrinsics.checkNotNullParameter((Object)$tmp0, "$tmp0");
        Intrinsics.checkNotNullParameter((Object)p0, "p0");
        return (boolean)$tmp0.invoke((Object)p0);
    }
    
    @JvmStatic
    public static final long sampleIndexToNanoTime(@NotNull final short[] buffer, final int sampleRate, final int channelCount) {
        return PCMAudioData.Companion.sampleIndexToNanoTime(buffer, sampleRate, channelCount);
    }
    
    @JvmStatic
    public static final long sampleIndexToNanoTime(final int buffer, final int sampleRate, final int channelCount) {
        return PCMAudioData.Companion.sampleIndexToNanoTime(buffer, sampleRate, channelCount);
    }
    
    @JvmStatic
    public static final long sampleIndexToNanoTime(final long buffer, final int sampleRate, final int channelCount) {
        return PCMAudioData.Companion.sampleIndexToNanoTime(buffer, sampleRate, channelCount);
    }
    
    @JvmStatic
    public static final long nanoTimeToSampleIndex(final long time, final int sampleRate, final int channelCount) {
        return PCMAudioData.Companion.nanoTimeToSampleIndex(time, sampleRate, channelCount);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0017\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J&\u0010\b\u001a\u00020\t2\n\u0010\n\u001a\u00060\tj\u0002`\u000b2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J\"\u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\u00042\b\b\u0002\u0010\r\u001a\u00020\u0004H\u0007J \u0010\u000e\u001a\u00020\t2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/utils/PCMAudioData$Companion;", "", "()V", "BUFFER_TIME_IN_SEK", "", "DEBUG", "", "SEEK_THRESHOLD_IN_SEK", "nanoTimeToSampleIndex", "", "time", "Lly/img/android/pesdk/kotlin_extension/Nanoseconds;", "sampleRate", "channelCount", "sampleIndexToNanoTime", "buffer", "", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        public final long sampleIndexToNanoTime(@NotNull final short[] buffer, final int sampleRate, final int channelCount) {
            Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
            return this.sampleIndexToNanoTime(buffer.length, sampleRate, channelCount);
        }
        
        @JvmStatic
        public final long sampleIndexToNanoTime(final int buffer, final int sampleRate, final int channelCount) {
            return MathKt.roundToLong(1000000.0 * buffer / (sampleRate * channelCount)) * 1000;
        }
        
        @JvmStatic
        public final long sampleIndexToNanoTime(final long buffer, final int sampleRate, final int channelCount) {
            return MathKt.roundToLong(1000000.0 * buffer / (sampleRate * channelCount)) * 1000;
        }
        
        @JvmStatic
        public final long nanoTimeToSampleIndex(final long time, final int sampleRate, final int channelCount) {
            return MathKt.roundToLong(time * sampleRate * channelCount / 1.0E9);
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0017\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\n\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0080\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\t\u0010\u0013\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u001d\u0010\u0015\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u00c6\u0001J)\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0003¢\u0006\f\b\u0018\u0012\b\b\u0019\u0012\u0004\b\b(\u001a\u0012\u0004\u0012\u00020\u001b0\u00172\u0006\u0010\u001c\u001a\u00020\u0003J\u0013\u0010\u001d\u001a\u00020\u001e2\b\u0010\u001f\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\u000e\u0010 \u001a\u00020!2\u0006\u0010\u0002\u001a\u00020\u0003J\t\u0010\"\u001a\u00020\u0003H\u00d6\u0001J\u0016\u0010#\u001a\u00020\u001e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\t\u0010$\u001a\u00020%H\u00d6\u0001J\u000e\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\u0003R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001a\u0010\u000e\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\r\"\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\r¨\u0006)" }, d2 = { "Lly/img/android/pesdk/utils/PCMAudioData$Format;", "", "sampleRate", "", "channelCount", "(II)V", "channelBuffer", "", "getChannelBuffer", "()[S", "channelConverter", "Lly/img/android/pesdk/audio/PCMChannelConverter;", "getChannelCount", "()I", "maxBufferSize", "getMaxBufferSize", "setMaxBufferSize", "(I)V", "getSampleRate", "component1", "component2", "copy", "createChannelReaderOf", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "outputChannel", "", "outputChannelCount", "equals", "", "other", "getSampleFactor", "", "hashCode", "match", "toString", "", "updateMaxBufferSize", "", "bufferSize", "pesdk-backend-core_release" })
    public static final class Format
    {
        private final int sampleRate;
        private final int channelCount;
        private int maxBufferSize;
        @NotNull
        private final short[] channelBuffer;
        @NotNull
        private final PCMChannelConverter channelConverter;
        
        public Format(final int sampleRate, final int channelCount) {
            this.sampleRate = sampleRate;
            this.channelCount = channelCount;
            int i = 0;
            final int channelCount2 = this.channelCount;
            final short[] channelBuffer = new short[channelCount2];
            while (i < channelCount2) {
                channelBuffer[i] = 0;
                ++i;
            }
            this.channelBuffer = channelBuffer;
            this.channelConverter = new PCMChannelConverter(this.channelBuffer, this.channelCount);
        }
        
        public final int getSampleRate() {
            return this.sampleRate;
        }
        
        public final int getChannelCount() {
            return this.channelCount;
        }
        
        public final int getMaxBufferSize() {
            return this.maxBufferSize;
        }
        
        public final void setMaxBufferSize(final int <set-?>) {
            this.maxBufferSize = <set-?>;
        }
        
        @NotNull
        public final short[] getChannelBuffer() {
            return this.channelBuffer;
        }
        
        public final boolean match(final int sampleRate, final int channelCount) {
            return this.sampleRate == sampleRate && this.channelCount == channelCount;
        }
        
        public final double getSampleFactor(final int sampleRate) {
            return this.sampleRate / (double)sampleRate;
        }
        
        @NotNull
        public final Function1<Integer, Short> createChannelReaderOf(final int outputChannelCount) {
            return (Function1<Integer, Short>)this.channelConverter.getGetDataMapper().invoke((Object)outputChannelCount);
        }
        
        public final void updateMaxBufferSize(final int bufferSize) {
            this.maxBufferSize = Math.max(this.maxBufferSize, bufferSize);
        }
        
        public final int component1() {
            return this.sampleRate;
        }
        
        public final int component2() {
            return this.channelCount;
        }
        
        @NotNull
        public final Format copy(final int sampleRate, final int channelCount) {
            return new Format(sampleRate, channelCount);
        }
        
        @NotNull
        @Override
        public String toString() {
            return "Format(sampleRate=" + this.sampleRate + ", channelCount=" + this.channelCount + ')';
        }
        
        @Override
        public int hashCode() {
            int result = Integer.hashCode(this.sampleRate);
            result = result * 31 + Integer.hashCode(this.channelCount);
            return result;
        }
        
        @Override
        public boolean equals(@Nullable final Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof Format)) {
                return false;
            }
            final Format format = (Format)other;
            return this.sampleRate == format.sampleRate && this.channelCount == format.channelCount;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J&\u0010\u001c\u001a\u00020\u001d2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020\fJ\u0006\u0010$\u001a\u00020\u001dJ\u000e\u0010%\u001a\u00020\u001d2\u0006\u0010&\u001a\u00020\fJ\u000e\u0010'\u001a\u00020\u001d2\u0006\u0010(\u001a\u00020\fJ&\u0010)\u001a\u00020\f2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010#\u001a\u00020\f2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020!J\u0018\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.2\u0006\u0010/\u001a\u00020\u001fH\u0002R\u001c\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR\u001a\u0010\u000b\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u000eR\u0011\u0010\u0013\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0014\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00190\u0018X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u001a\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u00190\u001bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060" }, d2 = { "Lly/img/android/pesdk/utils/PCMAudioData$Buffer;", "", "name", "", "(Ljava/lang/String;)V", "format", "Lly/img/android/pesdk/utils/PCMAudioData$Format;", "getFormat$pesdk_backend_core_release", "()Lly/img/android/pesdk/utils/PCMAudioData$Format;", "setFormat$pesdk_backend_core_release", "(Lly/img/android/pesdk/utils/PCMAudioData$Format;)V", "lastIndex", "", "getLastIndex", "()J", "setLastIndex", "(J)V", "maxBuffered", "getMaxBuffered", "minBuffered", "getMinBuffered", "getName", "()Ljava/lang/String;", "takeBuffer", "Lly/img/android/pesdk/utils/ConditionalCache;", "Lly/img/android/pesdk/utils/PCMAudioData$BufferEntry;", "treeMap", "Ljava/util/TreeMap;", "add", "", "buffer", "", "sampleRate", "", "channelCount", "startIndex", "clear", "deleteBufferAfter", "higherIndex", "deleteBufferBefore", "lowerIndex", "get16BitSamples", "outputChannelCount", "take", "", "sampleIndex", "", "channels", "pesdk-backend-core_release" })
    @VisibleForTesting(otherwise = 2)
    public static final class Buffer
    {
        @NotNull
        private final String name;
        @Nullable
        private Format format;
        @NotNull
        private final TreeMap<Long, BufferEntry> treeMap;
        @NotNull
        private ConditionalCache<BufferEntry> takeBuffer;
        private long lastIndex;
        
        public Buffer(@NotNull final String name) {
            Intrinsics.checkNotNullParameter((Object)name, "name");
            this.name = name;
            this.treeMap = new TreeMap<Long, BufferEntry>();
            this.takeBuffer = new ConditionalCache<BufferEntry>(null, 1, null);
        }
        
        @NotNull
        public final String getName() {
            return this.name;
        }
        
        @Nullable
        public final Format getFormat$pesdk_backend_core_release() {
            return this.format;
        }
        
        public final void setFormat$pesdk_backend_core_release(@Nullable final Format <set-?>) {
            this.format = <set-?>;
        }
        
        public final long getLastIndex() {
            return this.lastIndex;
        }
        
        public final void setLastIndex(final long <set-?>) {
            this.lastIndex = <set-?>;
        }
        
        public final long getMinBuffered() {
            long longValue;
            if (MapsKt.none((Map)this.treeMap)) {
                longValue = -1L;
            }
            else {
                final Long firstKey = this.treeMap.firstKey();
                Intrinsics.checkNotNullExpressionValue((Object)firstKey, "treeMap.firstKey()");
                longValue = firstKey.longValue();
            }
            return longValue;
        }
        
        public final long getMaxBuffered() {
            long lastIndex;
            if (MapsKt.none((Map)this.treeMap)) {
                lastIndex = -1L;
            }
            else {
                final Map.Entry<Long, BufferEntry> lastEntry = this.treeMap.lastEntry();
                if (lastEntry != null) {
                    final BufferEntry bufferEntry = lastEntry.getValue();
                    if (bufferEntry != null) {
                        lastIndex = bufferEntry.getLastIndex();
                        return lastIndex;
                    }
                }
                lastIndex = -1L;
            }
            return lastIndex;
        }
        
        public final void deleteBufferAfter(final long higherIndex) {
            final long before = this.getMaxBuffered();
            Map.Entry entry = (Map.Entry)this.treeMap.higherEntry(higherIndex);
            boolean hasDeletedBuffer = false;
            while (entry != null) {
                this.treeMap.remove(entry.getKey());
                entry = (Map.Entry)this.treeMap.higherEntry(higherIndex);
                hasDeletedBuffer = true;
            }
        }
        
        public final void deleteBufferBefore(final long lowerIndex) {
            long searchIndex = lowerIndex;
            final long before = this.getMinBuffered();
            Map.Entry entry = (Map.Entry)this.treeMap.lowerEntry(searchIndex);
            boolean hasDeletedBuffer = false;
            while (entry != null) {
                if (((BufferEntry)entry.getValue()).getLastIndex() < lowerIndex) {
                    this.treeMap.remove(entry.getKey());
                }
                else {
                    final Number key = entry.getKey();
                    Intrinsics.checkNotNullExpressionValue((Object)key, "entry.key");
                    searchIndex = key.longValue();
                }
                entry = (Map.Entry)this.treeMap.lowerEntry(searchIndex);
                hasDeletedBuffer = true;
            }
        }
        
        public final void add(@NotNull final short[] buffer, final int sampleRate, final int channelCount, final long startIndex) {
            Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
            final Format format = this.format;
            if (format == null || !format.match(sampleRate, channelCount)) {
                this.format = new Format(sampleRate, channelCount);
            }
            final Format format2 = this.format;
            if (format2 != null) {
                format2.updateMaxBufferSize(buffer.length / channelCount);
            }
            this.deleteBufferAfter(startIndex);
            final BufferEntry entry = new BufferEntry(buffer, sampleRate, channelCount, startIndex);
            final Map.Entry<Long, BufferEntry> ceilingEntry = this.treeMap.ceilingEntry(startIndex);
            final BufferEntry next = (ceilingEntry != null) ? ceilingEntry.getValue() : null;
            if (this.treeMap.get(startIndex) == null && (next == null || next.getLastIndex() < startIndex)) {
                this.treeMap.put(startIndex, entry);
            }
            else {
                Log.e("Audio", "Buffer overlap " + next + " with " + entry);
            }
        }
        
        public final long get16BitSamples(@NotNull final short[] buffer, final long startIndex, final int sampleRate, final int outputChannelCount) {
            Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
            final Format format2 = this.format;
            if (format2 == null) {
                throw new RuntimeException("You need to fill with data first");
            }
            final Format format = format2;
            final double factor = format.getSampleFactor(sampleRate);
            final int sampleCount = buffer.length / outputChannelCount;
            int notBufferedSamples = 0;
            for (int i = 0; i < sampleCount; ++i) {
                final double internalIndex = (startIndex + i) * factor;
                final boolean hasTaken = this.take(internalIndex, format.getChannelBuffer());
                if (!hasTaken) {
                    Arrays.fill(format.getChannelBuffer(), (short)0);
                    if (this.lastIndex > -1L && internalIndex > this.lastIndex) {
                        FastArrayOp.clear(buffer, i);
                        break;
                    }
                    ++notBufferedSamples;
                }
                final int bufferIndex = i * outputChannelCount;
                final Function1 channelReadAt = format.createChannelReaderOf(outputChannelCount);
                for (int channelIndex = 0; channelIndex < outputChannelCount; ++channelIndex) {
                    buffer[bufferIndex + channelIndex] = ((Number)channelReadAt.invoke((Object)channelIndex)).shortValue();
                }
            }
            final long sourceStartIndex = (long)(startIndex * factor);
            if (notBufferedSamples > 0) {
                final String s = "get16BitSamples";
                final StringBuilder append = new StringBuilder().append("Audio ").append(notBufferedSamples).append(" of ").append(sampleCount).append('/').append(sampleRate).append(" Samples not buffered at index ").append(sourceStartIndex).append(", inRange: ");
                final long minBuffered = this.getMinBuffered();
                Log.e(s, append.append(sourceStartIndex <= this.getMaxBuffered() && minBuffered <= sourceStartIndex).append(' ').append(this.getMinBuffered()).append(" - ").append(this.getMaxBuffered()).append("... ").append(this.name).toString());
            }
            this.deleteBufferBefore(sourceStartIndex - format.getSampleRate() * 3);
            return startIndex + sampleCount;
        }
        
        private final boolean take(final double sampleIndex, final short[] channels) {
            // 
            // This method could not be decompiled.
            // 
            // Original Bytecode:
            // 
            //     1: invokestatic    kotlin/math/MathKt.roundToLong:(D)J
            //     4: lstore          nearestIndex
            //     6: aload_0         /* this */
            //     7: getfield        ly/img/android/pesdk/utils/PCMAudioData$Buffer.takeBuffer:Lly/img/android/pesdk/utils/ConditionalCache;
            //    10: astore          this_$iv
            //    12: iconst_0       
            //    13: istore          $i$f$useIf
            //    15: aload           this_$iv
            //    17: getfield        ly/img/android/pesdk/utils/ConditionalCache._bound:Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;
            //    20: aload           this_$iv
            //    22: getfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
            //    25: dup            
            //    26: ifnull          90
            //    29: checkcast       Lly/img/android/pesdk/utils/PCMAudioData$BufferEntry;
            //    32: astore          9
            //    34: astore          22
            //    36: iconst_0       
            //    37: istore          $i$a$-useIf-PCMAudioData$Buffer$take$buffer$1
            //    39: aload           it
            //    41: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$BufferEntry.getIndexRange:()Lkotlin/ranges/LongRange;
            //    44: astore          11
            //    46: aload           11
            //    48: invokevirtual   kotlin/ranges/LongRange.getFirst:()J
            //    51: lstore          12
            //    53: lload           nearestIndex
            //    55: aload           11
            //    57: invokevirtual   kotlin/ranges/LongRange.getLast:()J
            //    60: lcmp           
            //    61: ifgt            80
            //    64: lload           12
            //    66: lload           nearestIndex
            //    68: lcmp           
            //    69: ifgt            76
            //    72: iconst_1       
            //    73: goto            81
            //    76: iconst_0       
            //    77: goto            81
            //    80: iconst_0       
            //    81: istore          23
            //    83: aload           22
            //    85: iload           23
            //    87: goto            92
            //    90: pop            
            //    91: iconst_0       
            //    92: putfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.reuseCache:Z
            //    95: aload           this_$iv
            //    97: getfield        ly/img/android/pesdk/utils/ConditionalCache._bound:Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;
            //   100: astore          null
            //   102: nop            
            //   103: iconst_0       
            //   104: istore          $i$f$orCreate
            //   106: aload           this_$iv
            //   108: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
            //   111: getfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
            //   114: astore          value$iv
            //   116: aload           value$iv
            //   118: ifnull          134
            //   121: aload           this_$iv
            //   123: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.reuseCache:Z
            //   126: ifeq            134
            //   129: aload           value$iv
            //   131: goto            286
            //   134: aload           value$iv
            //   136: dup            
            //   137: ifnull          161
            //   140: astore          10
            //   142: aload           this_$iv
            //   144: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
            //   147: getfield        ly/img/android/pesdk/utils/ConditionalCache.finalize:Lkotlin/jvm/functions/Function1;
            //   150: aload           10
            //   152: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
            //   157: pop            
            //   158: goto            163
            //   161: pop            
            //   162: nop            
            //   163: iconst_0       
            //   164: istore          $i$a$-orCreate-PCMAudioData$Buffer$take$buffer$2
            //   166: aload_0         /* this */
            //   167: getfield        ly/img/android/pesdk/utils/PCMAudioData$Buffer.treeMap:Ljava/util/TreeMap;
            //   170: lload           nearestIndex
            //   172: invokestatic    java/lang/Long.valueOf:(J)Ljava/lang/Long;
            //   175: invokestatic    ly/img/android/pesdk/kotlin_extension/HelperKt.floorValue:(Ljava/util/TreeMap;Ljava/lang/Object;)Ljava/lang/Object;
            //   178: checkcast       Lly/img/android/pesdk/utils/PCMAudioData$BufferEntry;
            //   181: astore          12
            //   183: aload           12
            //   185: ifnull          262
            //   188: aload           12
            //   190: astore          13
            //   192: aload           13
            //   194: astore          it
            //   196: iconst_0       
            //   197: istore          $i$a$-takeIf-PCMAudioData$Buffer$take$buffer$2$1
            //   199: aload           it
            //   201: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$BufferEntry.getIndexRange:()Lkotlin/ranges/LongRange;
            //   204: astore          16
            //   206: aload           16
            //   208: invokevirtual   kotlin/ranges/LongRange.getFirst:()J
            //   211: lstore          17
            //   213: lload           nearestIndex
            //   215: aload           16
            //   217: invokevirtual   kotlin/ranges/LongRange.getLast:()J
            //   220: lcmp           
            //   221: ifgt            240
            //   224: lload           17
            //   226: lload           nearestIndex
            //   228: lcmp           
            //   229: ifgt            236
            //   232: iconst_1       
            //   233: goto            241
            //   236: iconst_0       
            //   237: goto            241
            //   240: iconst_0       
            //   241: ifeq            249
            //   244: aload           13
            //   246: goto            250
            //   249: aconst_null    
            //   250: astore          19
            //   252: aload           19
            //   254: ifnull          262
            //   257: aload           19
            //   259: goto            264
            //   262: iconst_0       
            //   263: ireturn        
            //   264: nop            
            //   265: astore          10
            //   267: aload           10
            //   269: astore          it$iv
            //   271: iconst_0       
            //   272: istore          $i$a$-also-ConditionalCache$BoundCache$orCreate$1$iv
            //   274: aload           this_$iv
            //   276: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
            //   279: aload           it$iv
            //   281: putfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
            //   284: aload           10
            //   286: nop            
            //   287: checkcast       Lly/img/android/pesdk/utils/PCMAudioData$BufferEntry;
            //   290: astore          buffer
            //   292: aload           buffer
            //   294: dload_1         /* sampleIndex */
            //   295: aload_3         /* channels */
            //   296: invokevirtual   ly/img/android/pesdk/utils/PCMAudioData$BufferEntry.get:(D[S)V
            //   299: iconst_1       
            //   300: ireturn        
            //    StackMapTable: 00 10 FF 00 4C 00 14 07 00 02 03 07 00 C6 04 00 07 00 1E 01 07 00 60 01 07 01 3A 04 00 00 00 00 00 00 00 00 07 01 42 00 00 03 40 01 FF 00 08 00 07 07 00 02 03 07 00 C6 04 00 07 00 1E 01 00 02 07 01 42 07 00 04 FF 00 01 00 07 07 00 02 03 07 00 C6 04 00 07 00 1E 01 00 02 07 01 42 01 FF 00 29 00 08 07 00 02 03 07 00 C6 04 00 07 01 42 01 07 00 04 00 00 5A 07 00 04 01 FF 00 48 00 10 07 00 02 03 07 00 C6 04 00 07 01 42 01 07 00 04 00 01 07 00 60 07 00 60 07 00 60 01 07 01 3A 04 00 00 03 40 01 07 40 07 00 60 FF 00 0B 00 0B 07 00 02 03 07 00 C6 04 00 07 01 42 01 07 00 04 00 01 07 00 60 00 00 FF 00 01 00 11 07 00 02 03 07 00 C6 04 00 07 01 42 01 07 00 04 00 01 07 00 60 07 00 60 07 00 60 01 07 01 3A 04 07 00 60 00 01 07 00 60 FF 00 15 00 08 07 00 02 03 07 00 C6 04 00 07 01 42 01 07 00 04 00 01 07 00 04
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
            //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:576)
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
        
        public final void clear() {
            this.treeMap.clear();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u0016\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#2\u0006\u0010$\u001a\u00020\u0003J\u0006\u0010%\u001a\u00020!R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u001e\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u001e\u0010\u0013\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\b@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\rR\u000e\u0010\u0017\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u001a0\u0019X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001bR$\u0010\u0007\u001a\u00020\b2\u0006\u0010\u001c\u001a\u00020\b@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001d\u0010\u0015\"\u0004\b\u001e\u0010\u001f¨\u0006&" }, d2 = { "Lly/img/android/pesdk/utils/PCMAudioData$BufferEntry;", "", "buffer", "", "sampleRate", "", "channelCount", "startIndex", "", "([SIIJ)V", "getBuffer", "()[S", "getChannelCount", "()I", "<set-?>", "Lkotlin/ranges/LongRange;", "indexRange", "getIndexRange", "()Lkotlin/ranges/LongRange;", "lastIndex", "getLastIndex", "()J", "getSampleRate", "sampleSize", "splineInterpolator", "", "Lly/img/android/pesdk/audio/AudioSampleInterpolator;", "[Lly/img/android/pesdk/audio/AudioSampleInterpolator;", "value", "getStartIndex", "setStartIndex", "(J)V", "get", "", "index", "", "channels", "reloadData", "pesdk-backend-core_release" })
    @VisibleForTesting(otherwise = 2)
    public static final class BufferEntry
    {
        @NotNull
        private final short[] buffer;
        private final int sampleRate;
        private final int channelCount;
        private final int sampleSize;
        private long startIndex;
        private long lastIndex;
        @NotNull
        private LongRange indexRange;
        @NotNull
        private final AudioSampleInterpolator[] splineInterpolator;
        
        public BufferEntry(@NotNull final short[] buffer, final int sampleRate, final int channelCount, final long startIndex) {
            Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
            this.buffer = buffer;
            this.sampleRate = sampleRate;
            this.channelCount = channelCount;
            this.sampleSize = this.buffer.length / this.channelCount;
            this.startIndex = startIndex;
            this.lastIndex = startIndex + this.buffer.length / this.channelCount;
            this.indexRange = new LongRange(startIndex, this.lastIndex);
            int i = 0;
            final int channelCount2 = this.channelCount;
            final AudioSampleInterpolator[] splineInterpolator = new AudioSampleInterpolator[channelCount2];
            while (i < channelCount2) {
                final int offset = i;
                splineInterpolator[offset] = new AudioSampleInterpolator(this.buffer, offset, this.channelCount, new float[this.sampleSize]);
                ++i;
            }
            this.splineInterpolator = splineInterpolator;
            this.reloadData();
        }
        
        @NotNull
        public final short[] getBuffer() {
            return this.buffer;
        }
        
        public final int getSampleRate() {
            return this.sampleRate;
        }
        
        public final int getChannelCount() {
            return this.channelCount;
        }
        
        public final long getStartIndex() {
            return this.startIndex;
        }
        
        public final void setStartIndex(final long value) {
            this.startIndex = value;
            this.lastIndex = value + this.buffer.length / this.channelCount;
            this.indexRange = new LongRange(value, this.lastIndex);
        }
        
        public final long getLastIndex() {
            return this.lastIndex;
        }
        
        @NotNull
        public final LongRange getIndexRange() {
            return this.indexRange;
        }
        
        public final void reloadData() {
            final Object[] $this$forEach$iv = this.splineInterpolator;
            final int $i$f$forEach = 0;
            for (int i = 0; i < $this$forEach$iv.length; ++i) {
                final AudioSampleInterpolator it;
                final Object element$iv = it = (AudioSampleInterpolator)$this$forEach$iv[i];
                final int n = 0;
                it.reloadData();
            }
        }
        
        public final void get(final double index, @NotNull final short[] channels) {
            Intrinsics.checkNotNullParameter((Object)channels, "channels");
            final double internalIndex = MathUtilsKt.clamp(index - this.startIndex, 0.0, this.sampleSize - 1.0);
            for (int channelIndex = 0; channelIndex < channels.length; ++channelIndex) {
                channels[channelIndex] = this.splineInterpolator[channelIndex].interpolate((float)internalIndex);
            }
        }
    }
}
