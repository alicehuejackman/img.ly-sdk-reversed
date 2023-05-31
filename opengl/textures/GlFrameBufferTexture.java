// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import ly.img.android.pesdk.utils.SpeedDeque;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.PropertyReference1;
import kotlin.reflect.KProperty;
import android.graphics.Bitmap;
import java.nio.IntBuffer;
import ly.img.android.opengl.GlRawTextureData;
import ly.img.android.pesdk.utils.ConditionalCache;
import androidx.annotation.IntRange;
import ly.img.android.opengl.GlRawBitmap;
import ly.img.android.opengl.egl.GLThread;
import ly.img.android.pesdk.utils.ThreadUtils;
import java.nio.Buffer;
import android.graphics.Color;
import ly.img.android.opengl.canvas.GlClearScissor;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import ly.img.android.opengl.EGLLogWrapper;
import android.opengl.GLES20;
import ly.img.android.opengl.programs.GlProgramTileDraw;
import ly.img.android.opengl.canvas.GlRect;
import ly.img.android.opengl.programs.GlProgramShapeDraw;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import ly.img.android.opengl.canvas.GlObject;
import kotlin.Lazy;
import org.jetbrains.annotations.Nullable;
import ly.img.android.opengl.canvas.GlViewport;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0080\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 e2\u00020\u0001:\u0001eB\u0019\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005J\u001a\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u0003H\u0002J\u0018\u00100\u001a\u00020-2\u0006\u00101\u001a\u00020\u00032\u0006\u00102\u001a\u00020\u0003H\u0016J\u0016\u00103\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0003J\u0010\u00103\u001a\u00020-2\b\u00104\u001a\u0004\u0018\u00010\u0001JH\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020\u00012\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010;\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u0003J>\u00105\u001a\u00020-2\u0006\u00106\u001a\u00020=2\u0006\u00107\u001a\u0002082\b\b\u0002\u00109\u001a\u00020\u00032\b\b\u0002\u0010:\u001a\u00020\u00032\b\b\u0002\u0010<\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u0003J\"\u0010>\u001a\u00020-2\u0006\u00106\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003J\u001c\u0010?\u001a\u00020@2\b\b\u0002\u0010A\u001a\u00020\u001c2\b\b\u0002\u0010B\u001a\u00020\u001cH\u0007J&\u0010?\u001a\u00020@2\u0006\u0010C\u001a\u00020\u00032\u0006\u0010D\u001a\u00020\u00032\u0006\u0010E\u001a\u00020\u00032\u0006\u0010F\u001a\u00020\u0003J8\u0010G\u001a\u00020-2\u0006\u0010H\u001a\u00020I2\b\b\u0003\u0010C\u001a\u00020\u00032\b\b\u0003\u0010D\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J<\u0010J\u001a\u00020K2\n\b\u0002\u0010L\u001a\u0004\u0018\u00010K2\b\b\u0003\u0010C\u001a\u00020\u00032\b\b\u0003\u0010D\u001a\u00020\u00032\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0003H\u0007J\u0014\u0010M\u001a\u00020N2\n\b\u0002\u0010O\u001a\u0004\u0018\u00010NH\u0007J\u0016\u0010M\u001a\u00020N2\f\u0010P\u001a\b\u0012\u0004\u0012\u00020N0QH\u0007J\u0006\u0010R\u001a\u00020\u0003J\u0010\u0010S\u001a\u00020N2\u0006\u0010T\u001a\u00020NH\u0002J\u0010\u0010U\u001a\u00020-2\u0006\u0010V\u001a\u00020\u0003H\u0016J\b\u0010W\u001a\u00020-H\u0014J\u001a\u0010X\u001a\u00020-2\f\u0010Y\u001a\b\u0012\u0004\u0012\u00020-0ZH\u0086\b\u00f8\u0001\u0000J.\u0010[\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u00032\f\u0010\\\u001a\b\u0012\u0004\u0012\u00020-0ZH\u0086\b\u00f8\u0001\u0000J6\u0010[\u001a\u00020-2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010.\u001a\u00020\u001c2\u000e\b\u0004\u0010\\\u001a\b\u0012\u0004\u0012\u00020-0ZH\u0086\b\u00f8\u0001\u0000J.\u0010[\u001a\u00020-2\u0006\u0010]\u001a\u00020\u00012\b\b\u0002\u0010.\u001a\u00020\u001c2\u000e\b\u0004\u0010\\\u001a\b\u0012\u0004\u0012\u00020-0ZH\u0086\b\u00f8\u0001\u0000J(\u0010^\u001a\u00020-2\u0006\u0010_\u001a\u00020\u00032\u0006\u0010`\u001a\u00020\u00032\u0006\u0010a\u001a\u00020\u00032\u0006\u0010b\u001a\u00020\u0003H\u0016J\u001c\u0010c\u001a\u00020-2\b\b\u0002\u0010.\u001a\u00020\u001c2\b\b\u0002\u0010/\u001a\u00020\u0003H\u0007J\u0006\u0010d\u001a\u00020-R\u001b\u0010\u0006\u001a\u00020\u00078BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\n\u0010\u000b\u001a\u0004\b\b\u0010\tR\u000e\u0010\f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001b\u0010\r\u001a\u00020\u000e8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000b\u001a\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000b\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0017\u001a\u00020\u0018¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u001b\u001a\u00020\u001cX\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001dR\u001e\u0010\u001f\u001a\u00020\u001c2\u0006\u0010\u001e\u001a\u00020\u001c@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010\u001dR\u0011\u0010 \u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u000e\u0010#\u001a\u00020\u001cX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010$\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R$\u0010%\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b&\u0010\"\"\u0004\b'\u0010(R$\u0010)\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b*\u0010\"\"\u0004\b+\u0010(\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006f" }, d2 = { "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "Lly/img/android/opengl/textures/GlTexture;", "width", "", "height", "(II)V", "copyProgram", "Lly/img/android/opengl/programs/GlProgramShapeDraw;", "getCopyProgram", "()Lly/img/android/opengl/programs/GlProgramShapeDraw;", "copyProgram$delegate", "Lkotlin/Lazy;", "frameBufferHandle", "glProgramTileDraw", "Lly/img/android/opengl/programs/GlProgramTileDraw;", "getGlProgramTileDraw", "()Lly/img/android/opengl/programs/GlProgramTileDraw;", "glProgramTileDraw$delegate", "glTileRect", "Lly/img/android/opengl/canvas/GlRect;", "getGlTileRect", "()Lly/img/android/opengl/canvas/GlRect;", "glTileRect$delegate", "glViewport", "Lly/img/android/opengl/canvas/GlViewport;", "getGlViewport", "()Lly/img/android/opengl/canvas/GlViewport;", "isExternalTexture", "", "()Z", "<set-?>", "isRecording", "memoryUsage", "getMemoryUsage", "()I", "needInitialClear", "oldActiveFrameBuffer", "textureHeight", "getTextureHeight", "setTextureHeight", "(I)V", "textureWidth", "getTextureWidth", "setTextureWidth", "bindBuffer", "", "doClear", "clearColor", "bindTexture", "uniform", "slot", "changeSize", "textureToEqualize", "copyChunkOf", "texture", "chunkRect", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "contextWidth", "contextHeight", "rotation", "cutEdges", "Lly/img/android/opengl/textures/GlVideoTexture;", "copyFrom", "copyToBitmap", "Landroid/graphics/Bitmap;", "correctFlip", "correctColor", "x", "y", "w", "h", "copyToIntBuffer", "buffer", "Ljava/nio/IntBuffer;", "copyToRaw", "Lly/img/android/opengl/GlRawBitmap;", "preAllocatedRawBitmap", "copyToRawTextureData", "Lly/img/android/opengl/GlRawTextureData;", "preAllocatedRawTextureData", "cache", "Lly/img/android/pesdk/utils/ConditionalCache;", "getFrameBufferId", "internalCopyToRawTextureData", "glRawTextureData", "onAttach", "handle", "onRelease", "prepareForNativeRead", "readReady", "Lkotlin/Function0;", "record", "block", "withSizeOf", "setBehave", "downScaleFiltering", "upScaleFiltering", "horizontalWrap", "verticalWrap", "startRecord", "stopRecord", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public class GlFrameBufferTexture extends GlTexture
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final GlViewport glViewport;
    private int frameBufferHandle;
    private int textureWidth;
    private int textureHeight;
    private boolean isRecording;
    private boolean needInitialClear;
    @Nullable
    private GlFrameBufferTexture oldActiveFrameBuffer;
    private final boolean isExternalTexture;
    @NotNull
    private final Lazy copyProgram$delegate;
    @NotNull
    private final Lazy glTileRect$delegate;
    @NotNull
    private final Lazy glProgramTileDraw$delegate;
    @NotNull
    private static final GlSurfaceBound<Companion.Pool> poolInstance$delegate;
    @NotNull
    private static final GlContextBound<GlFrameBufferTexture> currentFrameBuffer$delegate;
    
    public GlFrameBufferTexture(final int width, final int height) {
        super(3553);
        this.glViewport = new GlViewport(null, 1, null);
        this.frameBufferHandle = -1;
        this.needInitialClear = true;
        this.copyProgram$delegate = LazyKt.lazy((Function0)GlFrameBufferTexture$copyProgram.GlFrameBufferTexture$copyProgram$2.INSTANCE);
        this.glTileRect$delegate = LazyKt.lazy((Function0)GlFrameBufferTexture$glTileRect.GlFrameBufferTexture$glTileRect$2.INSTANCE);
        this.glProgramTileDraw$delegate = LazyKt.lazy((Function0)GlFrameBufferTexture$glProgramTileDraw.GlFrameBufferTexture$glProgramTileDraw$2.INSTANCE);
        final int maxSize = GlTexture.Companion.getMaxTextureSize();
        this.setTextureWidth(TypeExtensionsKt.butMax(width, maxSize));
        this.setTextureHeight(TypeExtensionsKt.butMax(height, maxSize));
    }
    
    @NotNull
    public final GlViewport getGlViewport() {
        return this.glViewport;
    }
    
    @Override
    public int getTextureWidth() {
        return this.textureWidth;
    }
    
    protected void setTextureWidth(final int <set-?>) {
        this.textureWidth = <set-?>;
    }
    
    @Override
    public int getTextureHeight() {
        return this.textureHeight;
    }
    
    protected void setTextureHeight(final int <set-?>) {
        this.textureHeight = <set-?>;
    }
    
    public final boolean isRecording() {
        return this.isRecording;
    }
    
    public final int getMemoryUsage() {
        return this.getWidth() * this.getHeight() * (this.useMipmap() ? 43 : 32);
    }
    
    @Override
    public boolean isExternalTexture() {
        return this.isExternalTexture;
    }
    
    private final GlProgramShapeDraw getCopyProgram() {
        return (GlProgramShapeDraw)this.copyProgram$delegate.getValue();
    }
    
    private final GlRect getGlTileRect() {
        return (GlRect)this.glTileRect$delegate.getValue();
    }
    
    private final GlProgramTileDraw getGlProgramTileDraw() {
        return (GlProgramTileDraw)this.glProgramTileDraw$delegate.getValue();
    }
    
    public final int getFrameBufferId() {
        return this.frameBufferHandle;
    }
    
    @Override
    public void onAttach(final int handle) {
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle = GlTexture.Companion.glGenFramebuffer());
        this.setBehave(this.downScaleFiltering, this.upScaleFiltering, this.horizontalWrap, this.verticalWrap);
        GLES20.glFramebufferTexture2D(36160, 36064, this.getTextureTarget(), this.getTextureHandle(), 0);
        GLES20.glBindTexture(this.getTextureTarget(), 0);
        GLES20.glBindFramebuffer(36160, 0);
        EGLLogWrapper.readGlError();
    }
    
    public final void changeSize(@Nullable final GlTexture textureToEqualize) {
        if (textureToEqualize != null) {
            this.changeSize(textureToEqualize.getTextureWidth(), textureToEqualize.getTextureHeight());
        }
    }
    
    public final void changeSize(final int width, final int height) {
        if (width > 0 && height > 0 && (this.getTextureWidth() != width || this.getTextureHeight() != height)) {
            this.setTextureWidth(width);
            this.setTextureHeight(height);
            this.setBehave(this.downScaleFiltering, this.upScaleFiltering, this.horizontalWrap, this.verticalWrap);
        }
    }
    
    @Override
    public void bindTexture(final int uniform, final int slot) {
        this.attach();
        GLES20.glUniform1i(uniform, slot - 33984);
        GLES20.glActiveTexture(slot);
        GLES20.glBindTexture(this.getTextureTarget(), this.getTextureHandle());
        EGLLogWrapper.readGlError();
    }
    
    public final void record(@NotNull final GlTexture withSizeOf, final boolean doClear, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)withSizeOf, "withSizeOf");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$record = 0;
        this.changeSize(withSizeOf);
        final int clearColor$iv = 0;
        final int $i$f$record2 = 0;
        try {
            this.startRecord(doClear, clearColor$iv);
            block.invoke();
        }
        catch (Exception e$iv) {
            e$iv.printStackTrace();
        }
        finally {
            InlineMarker.finallyStart(1);
            this.stopRecord();
            InlineMarker.finallyEnd(1);
        }
    }
    
    public final void record(final int width, final int height, final boolean doClear, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$record = 0;
        this.changeSize(width, height);
        final int clearColor$iv = 0;
        final int $i$f$record2 = 0;
        try {
            this.startRecord(doClear, clearColor$iv);
            block.invoke();
        }
        catch (Exception e$iv) {
            e$iv.printStackTrace();
        }
        finally {
            InlineMarker.finallyStart(1);
            this.stopRecord();
            InlineMarker.finallyEnd(1);
        }
    }
    
    public final void record(final boolean doClear, final int clearColor, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$record = 0;
        try {
            this.startRecord(doClear, clearColor);
            block.invoke();
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            InlineMarker.finallyStart(1);
            this.stopRecord();
            InlineMarker.finallyEnd(1);
        }
    }
    
    @JvmOverloads
    public final void startRecord(final boolean doClear, final int clearColor) {
        if (!this.isRecording) {
            this.oldActiveFrameBuffer = GlFrameBufferTexture.Companion.getCurrentFrameBuffer();
            this.isRecording = true;
            this.glViewport.enable(this.getTextureWidth(), this.getTextureHeight());
            this.bindBuffer(doClear, clearColor);
        }
    }
    
    public static /* synthetic */ void startRecord$default(final GlFrameBufferTexture glFrameBufferTexture, boolean doClear, int clearColor, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: startRecord");
        }
        if ((n & 0x1) != 0x0) {
            doClear = true;
        }
        if ((n & 0x2) != 0x0) {
            clearColor = 0;
        }
        glFrameBufferTexture.startRecord(doClear, clearColor);
    }
    
    public final void stopRecord() {
        if (this.isRecording) {
            this.isRecording = false;
            GlFrameBufferTexture.Companion.setCurrentFrameBuffer(null);
            GLES20.glBindFramebuffer(36160, 0);
            this.glViewport.disable();
            this.textureChanged();
            final GlFrameBufferTexture oldActiveFrameBuffer = this.oldActiveFrameBuffer;
            if (oldActiveFrameBuffer != null) {
                bindBuffer$default(oldActiveFrameBuffer, false, 0, 2, null);
            }
        }
    }
    
    private final void bindBuffer(final boolean doClear, final int clearColor) {
        GlFrameBufferTexture.Companion.setCurrentFrameBuffer(this);
        this.attach();
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        if (doClear || this.needInitialClear) {
            this.needInitialClear = false;
            if (clearColor == 0) {
                GlClearScissor.Companion.viewPortClear$default(GlClearScissor.Companion, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
            }
            else {
                GlClearScissor.Companion.viewPortClear(Color.red(clearColor) / 255.0f, Color.green(clearColor) / 255.0f, Color.blue(clearColor) / 255.0f, Color.alpha(clearColor) / 255.0f);
            }
        }
        EGLLogWrapper.readGlError();
    }
    
    static /* synthetic */ void bindBuffer$default(final GlFrameBufferTexture glFrameBufferTexture, final boolean doClear, int clearColor, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: bindBuffer");
        }
        if ((n & 0x2) != 0x0) {
            clearColor = 0;
        }
        glFrameBufferTexture.bindBuffer(doClear, clearColor);
    }
    
    @Override
    public void setBehave(final int downScaleFiltering, final int upScaleFiltering, final int horizontalWrap, final int verticalWrap) {
        super.setBehave(downScaleFiltering, upScaleFiltering, horizontalWrap, verticalWrap);
        final GlObject.Companion this_$iv = GlObject.Companion;
        final int $i$f$tryGlAllocate = 0;
        int rounds$iv = 5;
    Label_0109:
        while (rounds$iv-- > 0) {
            int maxRoundTries$iv = 10;
            while (maxRoundTries$iv-- > 0) {
                final int n = 0;
                GLES20.glTexImage2D(3553, 0, 6408, this.getTextureWidth(), this.getTextureHeight(), 0, 6408, 5121, (Buffer)null);
                if (!this_$iv.glIsOutOfMemory()) {
                    continue Label_0109;
                }
                final GLThread glRenderIfExists = ThreadUtils.Companion.getGlRenderIfExists();
                if (glRenderIfExists == null) {
                    continue;
                }
                glRenderIfExists.freeMemory();
            }
            Thread.sleep(1L);
            continue;
        }
    }
    
    @Override
    protected void onRelease() {
        if (this.frameBufferHandle != -1) {
            this.downScaleFiltering = 9728;
            this.upScaleFiltering = 9728;
            this.changeSize(64, 64);
            startRecord$default(this, true, 0, 2, null);
            this.stopRecord();
        }
        super.onRelease();
        if (this.frameBufferHandle != -1) {
            GlTexture.Companion.glDeleteFramebuffer(this.frameBufferHandle);
            this.frameBufferHandle = -1;
        }
        if (GlFrameBufferTexture.Companion.getCurrentFrameBuffer() == this) {
            GlFrameBufferTexture.Companion.setCurrentFrameBuffer(null);
        }
    }
    
    public final void copyFrom(@NotNull final GlTexture texture, final int width, final int height) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "texture"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_0         /* this */
        //     8: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.getCopyProgram:()Lly/img/android/opengl/programs/GlProgramShapeDraw;
        //    11: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //    14: aload_1         /* texture */
        //    15: invokevirtual   ly/img/android/opengl/textures/GlTexture.isExternalTexture:()Z
        //    18: ifne            28
        //    21: aload_1         /* texture */
        //    22: instanceof      Lly/img/android/opengl/textures/GlCanvasTexture;
        //    25: ifeq            32
        //    28: iconst_1       
        //    29: goto            33
        //    32: iconst_0       
        //    33: aconst_null    
        //    34: iconst_0       
        //    35: bipush          6
        //    37: aconst_null    
        //    38: invokestatic    ly/img/android/opengl/canvas/GlProgram.setProgramConfig$default:(Lly/img/android/opengl/canvas/GlProgram;ZLly/img/android/opengl/textures/GlVirtualMipMapTexture$VirtualTextureType;IILjava/lang/Object;)V
        //    41: aload_0         /* this */
        //    42: astore          4
        //    44: iconst_1       
        //    45: istore          doClear$iv
        //    47: iconst_0       
        //    48: istore          $i$f$record
        //    50: aload           this_$iv
        //    52: iload_2         /* width */
        //    53: iload_3         /* height */
        //    54: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.changeSize:(II)V
        //    57: nop            
        //    58: iconst_0       
        //    59: istore          clearColor$iv$iv
        //    61: iconst_0       
        //    62: istore          $i$f$record
        //    64: nop            
        //    65: aload           this_$iv
        //    67: iload           doClear$iv
        //    69: iload           clearColor$iv$iv
        //    71: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //    74: iconst_0       
        //    75: istore          $i$a$-record-GlFrameBufferTexture$copyFrom$1
        //    77: aload_0         /* this */
        //    78: invokestatic    ly/img/android/opengl/textures/GlFrameBufferTexture.access$getCopyProgram:(Lly/img/android/opengl/textures/GlFrameBufferTexture;)Lly/img/android/opengl/programs/GlProgramShapeDraw;
        //    81: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //    84: astore          $this$render$iv
        //    86: iconst_0       
        //    87: istore          $i$f$render
        //    89: aload           $this$render$iv
        //    91: invokevirtual   ly/img/android/opengl/canvas/GlProgram.use:()V
        //    94: aload           $this$render$iv
        //    96: checkcast       Lly/img/android/opengl/programs/GlProgramShapeDraw;
        //    99: astore          it
        //   101: iconst_0       
        //   102: istore          $i$a$-render-GlFrameBufferTexture$copyFrom$1$1
        //   104: aload_1         /* texture */
        //   105: instanceof      Lly/img/android/opengl/textures/GlCanvasTexture;
        //   108: ifeq            128
        //   111: aload_1         /* texture */
        //   112: aload           it
        //   114: ldc_w           "u_image"
        //   117: invokevirtual   ly/img/android/opengl/programs/GlProgramShapeDraw.getUniform:(Ljava/lang/String;)I
        //   120: ldc             33984
        //   122: invokevirtual   ly/img/android/opengl/textures/GlTexture.bindTexture:(II)V
        //   125: goto            134
        //   128: aload           it
        //   130: aload_1         /* texture */
        //   131: invokevirtual   ly/img/android/opengl/programs/GlProgramShapeDraw.setUniformImage:(Lly/img/android/opengl/textures/GlTexture;)V
        //   134: nop            
        //   135: aload           $this$render$iv
        //   137: invokevirtual   ly/img/android/opengl/canvas/GlProgram.blitToViewPort:()V
        //   140: nop            
        //   141: nop            
        //   142: aload           this_$iv
        //   144: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   147: goto            175
        //   150: astore          e$iv$iv
        //   152: aload           e$iv$iv
        //   154: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   157: aload           this_$iv
        //   159: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   162: goto            175
        //   165: astore          14
        //   167: aload           this_$iv
        //   169: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   172: aload           14
        //   174: athrow         
        //   175: nop            
        //   176: nop            
        //   177: return         
        //    StackMapTable: 00 08 5C 07 01 91 43 07 01 91 FF 00 00 00 04 07 00 02 07 00 04 01 01 00 02 07 01 91 01 FF 00 5E 00 0E 07 00 02 07 00 04 01 01 07 00 02 01 01 01 01 01 07 01 91 01 07 00 81 01 00 00 05 FF 00 0F 00 09 07 00 02 07 00 04 01 01 07 00 02 01 01 01 01 00 01 07 00 D8 4E 07 01 01 09
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  64     142    150    165    Ljava/lang/Exception;
        //  64     142    165    175    Any
        //  150    157    165    175    Any
        //  165    167    165    175    Any
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
    
    public final void copyChunkOf(@NotNull final GlVideoTexture texture, @NotNull final MultiRect chunkRect, final int contextWidth, final int contextHeight, final boolean cutEdges, final int clearColor) {
        Intrinsics.checkNotNullParameter((Object)texture, "texture");
        Intrinsics.checkNotNullParameter((Object)chunkRect, "chunkRect");
        final int rotation = texture.getRotation();
        final boolean swappedSize = rotation % 180 != 0;
        this.copyChunkOf(texture, chunkRect, swappedSize ? contextHeight : contextWidth, swappedSize ? contextWidth : contextHeight, texture.getRotation(), cutEdges, clearColor);
    }
    
    public final void copyChunkOf(@NotNull final GlTexture texture, @NotNull final MultiRect chunkRect, final int contextWidth, final int contextHeight, final int rotation, final boolean cutEdges, final int clearColor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "texture"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* chunkRect */
        //     8: ldc_w           "chunkRect"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_0         /* this */
        //    15: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.getGlTileRect:()Lly/img/android/opengl/canvas/GlRect;
        //    18: aload_2         /* chunkRect */
        //    19: aconst_null    
        //    20: iload_3         /* contextWidth */
        //    21: iload           contextHeight
        //    23: iconst_0       
        //    24: iload           rotation
        //    26: i2f            
        //    27: fneg           
        //    28: bipush          18
        //    30: aconst_null    
        //    31: invokestatic    ly/img/android/opengl/canvas/GlRect.setTexture$default:(Lly/img/android/opengl/canvas/GlRect;Lly/img/android/pesdk/backend/model/chunk/MultiRect;Lly/img/android/pesdk/backend/model/chunk/Transformation;IIIFILjava/lang/Object;)V
        //    34: aload_0         /* this */
        //    35: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.getGlProgramTileDraw:()Lly/img/android/opengl/programs/GlProgramTileDraw;
        //    38: aload_1         /* texture */
        //    39: invokevirtual   ly/img/android/opengl/textures/GlTexture.isExternalTexture:()Z
        //    42: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUseDynamicInput:(Z)V
        //    45: aload_0         /* this */
        //    46: astore          8
        //    48: iconst_1       
        //    49: istore          doClear$iv
        //    51: iconst_0       
        //    52: istore          $i$f$record
        //    54: nop            
        //    55: aload           this_$iv
        //    57: iload           doClear$iv
        //    59: iload           clearColor
        //    61: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.startRecord:(ZI)V
        //    64: iconst_0       
        //    65: istore          $i$a$-record-GlFrameBufferTexture$copyChunkOf$1
        //    67: sipush          3042
        //    70: invokestatic    android/opengl/GLES20.glEnable:(I)V
        //    73: sipush          770
        //    76: sipush          771
        //    79: invokestatic    android/opengl/GLES20.glBlendFunc:(II)V
        //    82: aload_0         /* this */
        //    83: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.getGlTileRect:()Lly/img/android/opengl/canvas/GlRect;
        //    86: astore          12
        //    88: aload_0         /* this */
        //    89: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.getGlProgramTileDraw:()Lly/img/android/opengl/programs/GlProgramTileDraw;
        //    92: checkcast       Lly/img/android/opengl/canvas/GlProgram;
        //    95: astore          program$iv
        //    97: iconst_0       
        //    98: istore          $i$f$drawWith
        //   100: aload           this_$iv
        //   102: aload           program$iv
        //   104: invokevirtual   ly/img/android/opengl/canvas/GlRect.enable:(Lly/img/android/opengl/canvas/GlProgram;)V
        //   107: aload           program$iv
        //   109: checkcast       Lly/img/android/opengl/programs/GlProgramTileDraw;
        //   112: astore          it
        //   114: iconst_0       
        //   115: istore          $i$a$-drawWith-GlFrameBufferTexture$copyChunkOf$1$1
        //   117: aload           it
        //   119: aload_1         /* texture */
        //   120: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setUniformImage:(Lly/img/android/opengl/textures/GlTexture;)V
        //   123: aload           it
        //   125: iload           cutEdges
        //   127: invokevirtual   ly/img/android/opengl/programs/GlProgramTileDraw.setCutEdges:(Z)V
        //   130: nop            
        //   131: aload           this_$iv
        //   133: invokevirtual   ly/img/android/opengl/canvas/GlRect.draw:()V
        //   136: aload           this_$iv
        //   138: invokevirtual   ly/img/android/opengl/canvas/GlRect.disable:()V
        //   141: nop            
        //   142: iconst_1       
        //   143: sipush          771
        //   146: invokestatic    android/opengl/GLES20.glBlendFunc:(II)V
        //   149: nop            
        //   150: aload           this_$iv
        //   152: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   155: goto            183
        //   158: astore          e$iv
        //   160: aload           e$iv
        //   162: invokevirtual   java/lang/Exception.printStackTrace:()V
        //   165: aload           this_$iv
        //   167: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   170: goto            183
        //   173: astore          17
        //   175: aload           this_$iv
        //   177: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.stopRecord:()V
        //   180: aload           17
        //   182: athrow         
        //   183: nop            
        //   184: return         
        //    StackMapTable: 00 03 FF 00 9E 00 0B 07 00 02 07 00 04 07 01 D5 01 01 01 01 01 07 00 02 01 01 00 01 07 00 D8 4E 07 01 01 09
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type                 
        //  -----  -----  -----  -----  ---------------------
        //  54     150    158    173    Ljava/lang/Exception;
        //  54     150    173    183    Any
        //  158    165    173    183    Any
        //  173    175    173    183    Any
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
    @NotNull
    public final GlRawBitmap copyToRaw(@Nullable final GlRawBitmap preAllocatedRawBitmap, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y, final int width, final int height) {
        GlRawBitmap glRawBitmap3 = null;
        Label_0087: {
            if (preAllocatedRawBitmap != null) {
                final GlRawBitmap it = preAllocatedRawBitmap;
                final int n = 0;
                final GlRawBitmap glRawBitmap2 = (preAllocatedRawBitmap.getWidth() == width && preAllocatedRawBitmap.getHeight() == height) ? preAllocatedRawBitmap : null;
                if (glRawBitmap2 != null) {
                    glRawBitmap3 = glRawBitmap2;
                    break Label_0087;
                }
            }
            glRawBitmap3 = new GlRawBitmap(TypeExtensionsKt.butMax(width, this.getTextureWidth() - x), TypeExtensionsKt.butMax(height, this.getTextureHeight() - y));
        }
        final GlRawBitmap glRawBitmap = glRawBitmap3;
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        this.glViewport.enable(this.getTextureWidth(), this.getTextureHeight());
        GLES20.glFinish();
        GlRawBitmap.glReadPixels$default(glRawBitmap, TypeExtensionsKt.butMin(x, 0), TypeExtensionsKt.butMin(y, 0), 0, 0, 0, 0, 60, null);
        EGLLogWrapper.readGlError();
        GLES20.glBindFramebuffer(36160, 0);
        this.glViewport.disable();
        return glRawBitmap;
    }
    
    public static /* synthetic */ GlRawBitmap copyToRaw$default(final GlFrameBufferTexture glFrameBufferTexture, GlRawBitmap preAllocatedRawBitmap, int x, int y, int textureWidth, int textureHeight, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyToRaw");
        }
        if ((n & 0x1) != 0x0) {
            preAllocatedRawBitmap = null;
        }
        if ((n & 0x2) != 0x0) {
            x = 0;
        }
        if ((n & 0x4) != 0x0) {
            y = 0;
        }
        if ((n & 0x8) != 0x0) {
            textureWidth = glFrameBufferTexture.getTextureWidth();
        }
        if ((n & 0x10) != 0x0) {
            textureHeight = glFrameBufferTexture.getTextureHeight();
        }
        return glFrameBufferTexture.copyToRaw(preAllocatedRawBitmap, x, y, textureWidth, textureHeight);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawTextureData copyToRawTextureData(@NotNull final ConditionalCache<GlRawTextureData> cache) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "cache"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_0         /* this */
        //     8: aload_1         /* cache */
        //     9: astore_2        /* this_$iv */
        //    10: iconst_0       
        //    11: istore_3        /* $i$f$useIf */
        //    12: aload_2         /* this_$iv */
        //    13: getfield        ly/img/android/pesdk/utils/ConditionalCache._bound:Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;
        //    16: aload_2         /* this_$iv */
        //    17: getfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
        //    20: dup            
        //    21: ifnull          76
        //    24: checkcast       Lly/img/android/opengl/GlRawTextureData;
        //    27: astore          4
        //    29: astore          10
        //    31: astore          9
        //    33: iconst_0       
        //    34: istore          $i$a$-useIf-GlFrameBufferTexture$copyToRawTextureData$1
        //    36: aload           it
        //    38: invokevirtual   ly/img/android/opengl/GlRawTextureData.getWidth:()I
        //    41: aload_0         /* this */
        //    42: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getWidth:()I
        //    45: if_icmpne       64
        //    48: aload           it
        //    50: invokevirtual   ly/img/android/opengl/GlRawTextureData.getHeight:()I
        //    53: aload_0         /* this */
        //    54: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getHeight:()I
        //    57: if_icmpne       64
        //    60: iconst_1       
        //    61: goto            65
        //    64: iconst_0       
        //    65: istore          11
        //    67: aload           9
        //    69: aload           10
        //    71: iload           11
        //    73: goto            78
        //    76: pop            
        //    77: iconst_0       
        //    78: putfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.reuseCache:Z
        //    81: aload_2         /* this_$iv */
        //    82: getfield        ly/img/android/pesdk/utils/ConditionalCache._bound:Lly/img/android/pesdk/utils/ConditionalCache$BoundCache;
        //    85: astore_2        /* this_$iv */
        //    86: nop            
        //    87: iconst_0       
        //    88: istore_3        /* $i$f$orCreate */
        //    89: aload_2         /* this_$iv */
        //    90: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
        //    93: getfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
        //    96: astore          value$iv
        //    98: aload           value$iv
        //   100: ifnull          115
        //   103: aload_2         /* this_$iv */
        //   104: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.reuseCache:Z
        //   107: ifeq            115
        //   110: aload           value$iv
        //   112: goto            191
        //   115: aload           value$iv
        //   117: dup            
        //   118: ifnull          141
        //   121: astore          5
        //   123: aload_2         /* this_$iv */
        //   124: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
        //   127: getfield        ly/img/android/pesdk/utils/ConditionalCache.finalize:Lkotlin/jvm/functions/Function1;
        //   130: aload           5
        //   132: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: pop            
        //   138: goto            143
        //   141: pop            
        //   142: nop            
        //   143: astore          9
        //   145: iconst_0       
        //   146: istore          $i$a$-orCreate-GlFrameBufferTexture$copyToRawTextureData$2
        //   148: new             Lly/img/android/opengl/GlRawTextureData;
        //   151: dup            
        //   152: aload_0         /* this */
        //   153: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getTextureWidth:()I
        //   156: aload_0         /* this */
        //   157: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.getTextureHeight:()I
        //   160: iconst_0       
        //   161: iconst_0       
        //   162: bipush          12
        //   164: aconst_null    
        //   165: invokespecial   ly/img/android/opengl/GlRawTextureData.<init>:(IIIIILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //   168: aload           9
        //   170: swap           
        //   171: astore          5
        //   173: aload           5
        //   175: astore          it$iv
        //   177: iconst_0       
        //   178: istore          $i$a$-also-ConditionalCache$BoundCache$orCreate$1$iv
        //   180: aload_2         /* this_$iv */
        //   181: getfield        ly/img/android/pesdk/utils/ConditionalCache$BoundCache.parent:Lly/img/android/pesdk/utils/ConditionalCache;
        //   184: aload           it$iv
        //   186: putfield        ly/img/android/pesdk/utils/ConditionalCache.cache:Ljava/lang/Object;
        //   189: aload           5
        //   191: nop            
        //   192: checkcast       Lly/img/android/opengl/GlRawTextureData;
        //   195: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.internalCopyToRawTextureData:(Lly/img/android/opengl/GlRawTextureData;)Lly/img/android/opengl/GlRawTextureData;
        //   198: areturn        
        //    Signature:
        //  (Lly/img/android/pesdk/utils/ConditionalCache<Lly/img/android/opengl/GlRawTextureData;>;)Lly/img/android/opengl/GlRawTextureData;
        //    StackMapTable: 00 08 FF 00 40 00 0B 07 00 02 07 02 29 07 02 29 01 07 02 32 01 00 00 00 07 00 02 07 02 36 00 00 40 01 FF 00 0A 00 04 07 00 02 07 02 29 07 02 29 01 00 03 07 00 02 07 02 36 07 02 57 FF 00 01 00 04 07 00 02 07 02 29 07 02 29 01 00 03 07 00 02 07 02 36 01 FF 00 24 00 05 07 00 02 07 02 29 07 02 36 01 07 02 57 00 01 07 00 02 FF 00 19 00 05 07 00 02 07 02 29 07 02 36 01 07 02 57 00 02 07 00 02 07 02 57 41 07 00 02 FF 00 2F 00 05 07 00 02 07 02 29 07 02 36 01 07 02 57 00 02 07 00 02 07 02 57
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
    @NotNull
    public final GlRawTextureData copyToRawTextureData(@Nullable final GlRawTextureData preAllocatedRawTextureData) {
        GlRawTextureData glRawTextureData3 = null;
        Label_0079: {
            if (preAllocatedRawTextureData != null) {
                final GlRawTextureData it = preAllocatedRawTextureData;
                final int n = 0;
                final GlRawTextureData glRawTextureData2 = (preAllocatedRawTextureData.getWidth() == this.getWidth() && preAllocatedRawTextureData.getHeight() == this.getHeight()) ? preAllocatedRawTextureData : null;
                if (glRawTextureData2 != null) {
                    glRawTextureData3 = glRawTextureData2;
                    break Label_0079;
                }
            }
            glRawTextureData3 = new GlRawTextureData(this.getTextureWidth(), this.getTextureHeight(), 0, 0, 12, null);
        }
        final GlRawTextureData glRawTextureData = glRawTextureData3;
        return this.internalCopyToRawTextureData(glRawTextureData);
    }
    
    public static /* synthetic */ GlRawTextureData copyToRawTextureData$default(final GlFrameBufferTexture glFrameBufferTexture, GlRawTextureData preAllocatedRawTextureData, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyToRawTextureData");
        }
        if ((n & 0x1) != 0x0) {
            preAllocatedRawTextureData = null;
        }
        return glFrameBufferTexture.copyToRawTextureData(preAllocatedRawTextureData);
    }
    
    private final GlRawTextureData internalCopyToRawTextureData(final GlRawTextureData glRawTextureData) {
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        this.glViewport.enable(this.getTextureWidth(), this.getTextureHeight());
        GLES20.glFinish();
        glRawTextureData.glReadPixels();
        EGLLogWrapper.readGlError();
        GLES20.glBindFramebuffer(36160, 0);
        this.glViewport.disable();
        return glRawTextureData;
    }
    
    @JvmOverloads
    public final void copyToIntBuffer(@NotNull final IntBuffer buffer, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y, final int width, final int height) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        GLES20.glBindFramebuffer(36160, this.frameBufferHandle);
        this.glViewport.enable(this.getTextureWidth(), this.getTextureHeight());
        GLES20.glFinish();
        GLES20.glReadPixels(x, y, width, height, 6408, 5121, (Buffer)buffer);
        EGLLogWrapper.readGlError();
        GLES20.glBindFramebuffer(36160, 0);
        this.glViewport.disable();
    }
    
    public static /* synthetic */ void copyToIntBuffer$default(final GlFrameBufferTexture glFrameBufferTexture, final IntBuffer buffer, int x, int y, int textureWidth, int textureHeight, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyToIntBuffer");
        }
        if ((n & 0x2) != 0x0) {
            x = 0;
        }
        if ((n & 0x4) != 0x0) {
            y = 0;
        }
        if ((n & 0x8) != 0x0) {
            textureWidth = glFrameBufferTexture.getTextureWidth();
        }
        if ((n & 0x10) != 0x0) {
            textureHeight = glFrameBufferTexture.getTextureHeight();
        }
        glFrameBufferTexture.copyToIntBuffer(buffer, x, y, textureWidth, textureHeight);
    }
    
    public final void prepareForNativeRead(@NotNull final Function0<Unit> readReady) {
        Intrinsics.checkNotNullParameter((Object)readReady, "readReady");
        final int $i$f$prepareForNativeRead = 0;
        GLES20.glBindFramebuffer(36160, this.getFrameBufferId());
        this.getGlViewport().enable(this.getTextureWidth(), this.getTextureHeight());
        GLES20.glFinish();
        readReady.invoke();
        EGLLogWrapper.readGlError();
        GLES20.glBindFramebuffer(36160, 0);
        this.getGlViewport().disable();
    }
    
    @JvmOverloads
    @NotNull
    public final Bitmap copyToBitmap(final boolean correctFlip, final boolean correctColor) {
        return copyToRaw$default(this, null, 0, 0, 0, 0, 30, null).createBitmap(correctFlip, correctColor);
    }
    
    public static /* synthetic */ Bitmap copyToBitmap$default(final GlFrameBufferTexture glFrameBufferTexture, boolean correctFlip, boolean correctColor, final int n, final Object o) {
        if (o != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: copyToBitmap");
        }
        if ((n & 0x1) != 0x0) {
            correctFlip = true;
        }
        if ((n & 0x2) != 0x0) {
            correctColor = true;
        }
        return glFrameBufferTexture.copyToBitmap(correctFlip, correctColor);
    }
    
    @NotNull
    public final Bitmap copyToBitmap(final int x, final int y, final int w, final int h) {
        return GlRawBitmap.createBitmap$default(this.copyToRaw(null, x, y, w, h), false, 1, null);
    }
    
    @JvmOverloads
    public final void startRecord(final boolean doClear) {
        startRecord$default(this, doClear, 0, 2, null);
    }
    
    @JvmOverloads
    public final void startRecord() {
        startRecord$default(this, false, 0, 3, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawBitmap copyToRaw(@Nullable final GlRawBitmap preAllocatedRawBitmap, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y, final int width) {
        return copyToRaw$default(this, preAllocatedRawBitmap, x, y, width, 0, 16, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawBitmap copyToRaw(@Nullable final GlRawBitmap preAllocatedRawBitmap, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y) {
        return copyToRaw$default(this, preAllocatedRawBitmap, x, y, 0, 0, 24, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawBitmap copyToRaw(@Nullable final GlRawBitmap preAllocatedRawBitmap, @IntRange(from = 0L) final int x) {
        return copyToRaw$default(this, preAllocatedRawBitmap, x, 0, 0, 0, 28, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawBitmap copyToRaw(@Nullable final GlRawBitmap preAllocatedRawBitmap) {
        return copyToRaw$default(this, preAllocatedRawBitmap, 0, 0, 0, 0, 30, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawBitmap copyToRaw() {
        return copyToRaw$default(this, null, 0, 0, 0, 0, 31, null);
    }
    
    @JvmOverloads
    @NotNull
    public final GlRawTextureData copyToRawTextureData() {
        return copyToRawTextureData$default(this, null, 1, null);
    }
    
    @JvmOverloads
    public final void copyToIntBuffer(@NotNull final IntBuffer buffer, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y, final int width) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToIntBuffer$default(this, buffer, x, y, width, 0, 16, null);
    }
    
    @JvmOverloads
    public final void copyToIntBuffer(@NotNull final IntBuffer buffer, @IntRange(from = 0L) final int x, @IntRange(from = 0L) final int y) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToIntBuffer$default(this, buffer, x, y, 0, 0, 24, null);
    }
    
    @JvmOverloads
    public final void copyToIntBuffer(@NotNull final IntBuffer buffer, @IntRange(from = 0L) final int x) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToIntBuffer$default(this, buffer, x, 0, 0, 0, 28, null);
    }
    
    @JvmOverloads
    public final void copyToIntBuffer(@NotNull final IntBuffer buffer) {
        Intrinsics.checkNotNullParameter((Object)buffer, "buffer");
        copyToIntBuffer$default(this, buffer, 0, 0, 0, 0, 30, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Bitmap copyToBitmap(final boolean correctFlip) {
        return copyToBitmap$default(this, correctFlip, false, 2, null);
    }
    
    @JvmOverloads
    @NotNull
    public final Bitmap copyToBitmap() {
        return copyToBitmap$default(this, false, false, 3, null);
    }
    
    public GlFrameBufferTexture() {
        this(0, 0, 3, null);
    }
    
    public static final /* synthetic */ GlSurfaceBound access$getPoolInstance$delegate$cp() {
        return GlFrameBufferTexture.poolInstance$delegate;
    }
    
    public static final /* synthetic */ GlContextBound access$getCurrentFrameBuffer$delegate$cp() {
        return GlFrameBufferTexture.currentFrameBuffer$delegate;
    }
    
    static {
        Companion = new Companion(null);
        poolInstance$delegate = new GlSurfaceBound((kotlin.jvm.functions.Function0<?>)GlFrameBufferTexture$Companion$poolInstance.GlFrameBufferTexture$Companion$poolInstance$2.INSTANCE);
        currentFrameBuffer$delegate = new GlContextBound((kotlin.jvm.functions.Function0<?>)GlFrameBufferTexture$Companion$currentFrameBuffer.GlFrameBufferTexture$Companion$currentFrameBuffer$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001:\u0001\u0018B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0012\u001a\u00020\u0013J\u0016\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001b\u0010\f\u001a\u00020\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0019" }, d2 = { "Lly/img/android/opengl/textures/GlFrameBufferTexture$Companion;", "", "()V", "<set-?>", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "currentFrameBuffer", "getCurrentFrameBuffer", "()Lly/img/android/opengl/textures/GlFrameBufferTexture;", "setCurrentFrameBuffer", "(Lly/img/android/opengl/textures/GlFrameBufferTexture;)V", "currentFrameBuffer$delegate", "Lly/img/android/opengl/canvas/GlObject$GlContextBound;", "poolInstance", "Lly/img/android/opengl/textures/GlFrameBufferTexture$Companion$Pool;", "getPoolInstance", "()Lly/img/android/opengl/textures/GlFrameBufferTexture$Companion$Pool;", "poolInstance$delegate", "Lly/img/android/opengl/canvas/GlObject$GlSurfaceBound;", "endOfRoundTrip", "", "tempFrameBufferTexture", "width", "", "height", "Pool", "pesdk-backend-core_release" })
    public static final class Companion
    {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        
        private Companion() {
        }
        
        private final Pool getPoolInstance() {
            return GlFrameBufferTexture.access$getPoolInstance$delegate$cp().getValue(this, Companion.$$delegatedProperties[0]);
        }
        
        @NotNull
        public final GlFrameBufferTexture tempFrameBufferTexture(final int width, final int height) {
            return this.getPoolInstance().get(width, height);
        }
        
        public final void endOfRoundTrip() {
            this.getPoolInstance().endRoundTrip();
        }
        
        @Nullable
        public final GlFrameBufferTexture getCurrentFrameBuffer() {
            return GlFrameBufferTexture.access$getCurrentFrameBuffer$delegate$cp().getValue(this, Companion.$$delegatedProperties[1]);
        }
        
        public final void setCurrentFrameBuffer(@Nullable final GlFrameBufferTexture <set-?>) {
            GlFrameBufferTexture.access$getCurrentFrameBuffer$delegate$cp().setValue(this, Companion.$$delegatedProperties[1], <set-?>);
        }
        
        static {
            $$delegatedProperties = new KProperty[] { (KProperty)Reflection.property1((PropertyReference1)new PropertyReference1Impl((Class)Companion.class, "poolInstance", "getPoolInstance()Lly/img/android/opengl/textures/GlFrameBufferTexture$Companion$Pool;", 0)), (KProperty)Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((Class)Companion.class, "currentFrameBuffer", "getCurrentFrameBuffer()Lly/img/android/opengl/textures/GlFrameBufferTexture;", 0)) };
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ\u0016\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000bR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r" }, d2 = { "Lly/img/android/opengl/textures/GlFrameBufferTexture$Companion$Pool;", "", "()V", "takePool", "Lly/img/android/pesdk/utils/SpeedDeque;", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "takenPool", "endRoundTrip", "", "get", "width", "", "height", "pesdk-backend-core_release" })
        private static final class Pool
        {
            @NotNull
            private final SpeedDeque<GlFrameBufferTexture> takenPool;
            @NotNull
            private final SpeedDeque<GlFrameBufferTexture> takePool;
            
            public Pool() {
                this.takenPool = new SpeedDeque<GlFrameBufferTexture>();
                this.takePool = new SpeedDeque<GlFrameBufferTexture>();
            }
            
            @NotNull
            public final GlFrameBufferTexture get(final int width, final int height) {
                final GlFrameBufferTexture glFrameBufferTexture = this.takePool.poll();
                GlFrameBufferTexture glFrameBufferTexture2;
                if (glFrameBufferTexture != null) {
                    final GlFrameBufferTexture it = glFrameBufferTexture;
                    final int n = 0;
                    it.changeSize(width, height);
                    glFrameBufferTexture2 = it;
                }
                else {
                    glFrameBufferTexture2 = new GlFrameBufferTexture(width, height);
                }
                final GlFrameBufferTexture take = glFrameBufferTexture2;
                this.takenPool.put(take);
                return take;
            }
            
            public final void endRoundTrip() {
                Unit instance;
                do {
                    final GlFrameBufferTexture glFrameBufferTexture = this.takePool.poll();
                    if (glFrameBufferTexture != null) {
                        glFrameBufferTexture.releaseGlContext();
                        instance = Unit.INSTANCE;
                    }
                    else {
                        instance = null;
                    }
                } while (instance != null);
                GlFrameBufferTexture taken = null;
                while (true) {
                    final GlFrameBufferTexture glFrameBufferTexture2 = this.takenPool.poll();
                    if (glFrameBufferTexture2 == null) {
                        break;
                    }
                    taken = glFrameBufferTexture2;
                    this.takePool.put(taken);
                }
            }
        }
    }
}
