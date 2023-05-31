// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import androidx.annotation.CallSuper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import ly.img.android.opengl.EGLLogWrapper;
import java.nio.Buffer;
import android.opengl.GLES20;
import ly.img.android.pesdk.utils.FloatPointList;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import java.nio.FloatBuffer;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 #2\u00020\u0001:\u0001#B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0007\b\u0016¢\u0006\u0002\u0010\u0005J\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u000fH\u0002J\u0006\u0010\u0011\u001a\u00020\u000fJ\u0006\u0010\u0012\u001a\u00020\u000fJF\u0010\u0013\u001a\u00020\u000f\"\b\b\u0000\u0010\u0014*\u00020\u00152\u0006\u0010\u0016\u001a\u0002H\u00142!\u0010\u0017\u001a\u001d\u0012\u0013\u0012\u0011H\u0014¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u000f0\u0018H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u001cJ\u000e\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0016\u001a\u00020\u0015J\b\u0010\u001d\u001a\u00020\u000fH\u0015J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u0003H\u0002J\u0010\u0010\u001e\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010\"\u001a\u00020\u000f2\u0006\u0010 \u001a\u00020!R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006$" }, d2 = { "Lly/img/android/opengl/canvas/GlParticles;", "Lly/img/android/opengl/canvas/GlObject;", "verticesData", "", "([F)V", "()V", "attributePositions", "", "dataLength", "handle", "vertexBufferSizeInvalid", "", "verticesDataBuffer", "Ljava/nio/FloatBuffer;", "attach", "", "attachBuffer", "disable", "drawAll", "enable", "T", "Lly/img/android/opengl/canvas/GlProgram;", "program", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "onRelease", "updateFloatBuffer", "data", "floatPointList", "Lly/img/android/pesdk/utils/FloatPointList;", "updateVerticesData", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public final class GlParticles extends GlObject
{
    @NotNull
    public static final Companion Companion;
    private int handle;
    private int dataLength;
    private boolean vertexBufferSizeInvalid;
    @Nullable
    private FloatBuffer verticesDataBuffer;
    private int attributePositions;
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_POSITION;
    private static final int FLOAT_SIZE_BYTES;
    private static final int VERTICES_DATA_POS_SIZE;
    
    public GlParticles(@NotNull final float[] verticesData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.updateFloatBuffer(verticesData);
    }
    
    private final void updateFloatBuffer(final float[] data) {
        if (this.dataLength != data.length) {
            this.vertexBufferSizeInvalid = true;
        }
        this.dataLength = data.length;
        FloatBuffer buffer = this.verticesDataBuffer;
        int capacity2;
        if (this.verticesDataBuffer != null) {
            final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
            Intrinsics.checkNotNull((Object)verticesDataBuffer);
            capacity2 = verticesDataBuffer.capacity();
        }
        else {
            capacity2 = -1;
        }
        final int capacity = capacity2;
        if (data.length > capacity) {
            buffer = ByteBuffer.allocateDirect(data.length * 2 * GlParticles.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.vertexBufferSizeInvalid = true;
        }
        final FloatBuffer floatBuffer = buffer;
        Intrinsics.checkNotNull((Object)floatBuffer);
        floatBuffer.limit(this.dataLength);
        buffer.put(data).position(0);
        this.verticesDataBuffer = buffer;
    }
    
    private final void updateFloatBuffer(final FloatPointList floatPointList) {
        if (this.dataLength != floatPointList.size()) {
            this.vertexBufferSizeInvalid = true;
        }
        this.dataLength = floatPointList.size();
        final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
        Intrinsics.checkNotNull((Object)verticesDataBuffer);
        FloatBuffer buffer = verticesDataBuffer;
        int capacity2;
        if (this.verticesDataBuffer != null) {
            final FloatBuffer verticesDataBuffer2 = this.verticesDataBuffer;
            Intrinsics.checkNotNull((Object)verticesDataBuffer2);
            capacity2 = verticesDataBuffer2.capacity();
        }
        else {
            capacity2 = -1;
        }
        final int capacity = capacity2;
        if (this.dataLength > capacity) {
            final FloatBuffer floatBuffer = ByteBuffer.allocateDirect(this.dataLength * 2 * GlParticles.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
            Intrinsics.checkNotNullExpressionValue((Object)floatBuffer, "allocateDirect(dataLengt\u2026         .asFloatBuffer()");
            buffer = floatBuffer;
            this.vertexBufferSizeInvalid = true;
        }
        buffer.limit(this.dataLength);
        buffer.put(floatPointList.rawArray(), 0, this.dataLength).position(0);
        this.verticesDataBuffer = buffer;
    }
    
    public GlParticles() {
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.updateFloatBuffer(new float[0]);
    }
    
    public final void drawAll() {
        GLES20.glDrawArrays(0, 0, this.dataLength / 2);
    }
    
    public final void attach() {
        if (this.handle == -1) {
            this.handle = GlObject.Companion.glGenBuffer();
            this.attachBuffer();
        }
    }
    
    private final void attachBuffer() {
        GLES20.glBindBuffer(34962, this.handle);
        if (this.vertexBufferSizeInvalid) {
            GLES20.glBufferData(34962, this.dataLength * GlParticles.FLOAT_SIZE_BYTES, (Buffer)this.verticesDataBuffer, 35048);
            this.vertexBufferSizeInvalid = false;
        }
        else {
            GLES20.glBufferSubData(34962, 0, this.dataLength * GlParticles.FLOAT_SIZE_BYTES, (Buffer)this.verticesDataBuffer);
        }
        GLES20.glBindBuffer(34962, 0);
        EGLLogWrapper.readGlError();
    }
    
    public final void updateVerticesData(@NotNull final FloatPointList floatPointList) {
        Intrinsics.checkNotNullParameter((Object)floatPointList, "floatPointList");
        this.attach();
        this.updateFloatBuffer(floatPointList);
        this.attachBuffer();
    }
    
    public final void updateVerticesData(@NotNull final float[] verticesData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        this.attach();
        this.updateFloatBuffer(verticesData);
        this.attachBuffer();
    }
    
    public final <T extends GlProgram> void enable(@NotNull final T program, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.enable(program);
        block.invoke((Object)program);
        this.disable();
    }
    
    public final void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        program.use();
        this.attach();
        if (this.attributePositions == -1) {
            this.attributePositions = GlProgram.getAttribute$default(program, GlParticles.DEFAULT_ATTRIBUTE_POSITION, false, 2, null);
        }
        GLES20.glBindBuffer(34962, this.handle);
        GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, GlParticles.VERTICES_DATA_POS_SIZE, 5126, false, 0, 0);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributePositions);
        GLES20.glBindBuffer(34962, 0);
        EGLLogWrapper.readGlError();
    }
    
    public final void disable() {
        if (this.handle != -1) {
            GLES20.glBindBuffer(34962, this.handle);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributePositions);
            GLES20.glBindBuffer(34962, 0);
            EGLLogWrapper.readGlError();
        }
    }
    
    @CallSuper
    @Override
    protected void onRelease() {
        if (this.handle != -1) {
            GlObject.Companion.glDeleteBuffer(this.handle);
            this.handle = -1;
        }
    }
    
    static {
        Companion = new Companion(null);
        DEFAULT_ATTRIBUTE_POSITION = "a_position";
        FLOAT_SIZE_BYTES = 4;
        VERTICES_DATA_POS_SIZE = 2;
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082D¢\u0006\u0002\n\u0000¨\u0006\b" }, d2 = { "Lly/img/android/opengl/canvas/GlParticles$Companion;", "", "()V", "DEFAULT_ATTRIBUTE_POSITION", "", "FLOAT_SIZE_BYTES", "", "VERTICES_DATA_POS_SIZE", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
