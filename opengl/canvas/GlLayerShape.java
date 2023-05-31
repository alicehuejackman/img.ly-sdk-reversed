// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import ly.img.android.opengl.EGLLogWrapper;
import java.nio.Buffer;
import android.opengl.GLES20;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import android.util.Log;
import ly.img.android.pesdk.utils.Trace;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import java.nio.FloatBuffer;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\f\b\u0017\u0018\u0000 #2\u00020\u0001:\u0001#B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0007J\u0006\u0010\u0012\u001a\u00020\u0013J\b\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0013J\u0010\u0010\u0016\u001a\u00020\u00132\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0013H\u0014J\u0010\u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001b\u001a\u00020\u0003H\u0002J \u0010\u001a\u001a\u00020\u00132\u0006\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001d\u001a\u00020\u00032\u0006\u0010\u001e\u001a\u00020\u0003H\u0002J\u000e\u0010\u001f\u001a\u00020\u00132\u0006\u0010\u0002\u001a\u00020\u0003J\u001e\u0010\u001f\u001a\u00020\u00132\u0006\u0010 \u001a\u00020\u00032\u0006\u0010!\u001a\u00020\u00032\u0006\u0010\"\u001a\u00020\u0003R\u000e\u0010\b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006$" }, d2 = { "Lly/img/android/opengl/canvas/GlLayerShape;", "Lly/img/android/opengl/canvas/GlObject;", "verticesData", "", "hasStaticData", "", "([FZ)V", "(Z)V", "attributeBackgroundCoordinates", "", "attributePositions", "attributeTextureCoordinates", "dataLength", "handle", "hasChainedOrder", "vertexBufferSizeInvalid", "verticesDataBuffer", "Ljava/nio/FloatBuffer;", "attach", "", "attachBuffer", "disable", "enable", "program", "Lly/img/android/opengl/canvas/GlProgram;", "onRelease", "updateFloatBuffer", "data", "dataShapePos", "dataTexturePos", "dataBackgroundTexturePos", "updateVerticesData", "shapePos", "texturePos", "backgroundTexturePos", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public class GlLayerShape extends GlObject
{
    @NotNull
    public static final Companion Companion;
    private final boolean hasStaticData;
    private boolean hasChainedOrder;
    private int handle;
    private int dataLength;
    private boolean vertexBufferSizeInvalid;
    @Nullable
    private FloatBuffer verticesDataBuffer;
    private int attributePositions;
    private int attributeTextureCoordinates;
    private int attributeBackgroundCoordinates;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA;
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_POSITION = "a_position";
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_TEXTURE_COORDINATE = "a_texCoord";
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_BACKGROUND_TEXTURE_COORDINATE = "a_backgroundTexCoord";
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final int VERTICES_DATA_UV_SIZE = 2;
    private static final int VERTICES_DATA_POS_SIZE = 2;
    private static final int VERTICES_DATA_POS_OFFSET = 0;
    private static final int VERTICES_DATA_STRIDE_BYTES = 24;
    private static final int VERTICES_DATA_UV_OFFSET = 8;
    private static final int VERTICES_DATA_BACKGROUND_UV_OFFSET = 16;
    
    public GlLayerShape(@NotNull final float[] verticesData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
        this.attributeBackgroundCoordinates = -1;
        this.hasStaticData = hasStaticData;
        this.updateFloatBuffer(verticesData);
    }
    
    @JvmOverloads
    public GlLayerShape(final boolean hasStaticData) {
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
        this.attributeBackgroundCoordinates = -1;
        this.hasStaticData = hasStaticData;
        this.updateFloatBuffer(GlLayerShape.FILL_VIEWPORT_VERTICES_DATA);
    }
    
    public final void updateVerticesData(@NotNull final float[] verticesData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        if (this.hasStaticData) {
            Log.e("OpenGl", "Do not change the vertices data of an static GlLayerShape! " + Trace.calle$default(0, 1, null));
            this.vertexBufferSizeInvalid = true;
        }
        this.attach();
        this.updateFloatBuffer(verticesData);
        this.attachBuffer();
    }
    
    public final void attach() {
        if (this.handle == -1) {
            this.handle = GlObject.Companion.glGenBuffer();
            this.attachBuffer();
        }
    }
    
    public final void updateVerticesData(@NotNull final float[] shapePos, @NotNull final float[] texturePos, @NotNull final float[] backgroundTexturePos) {
        Intrinsics.checkNotNullParameter((Object)shapePos, "shapePos");
        Intrinsics.checkNotNullParameter((Object)texturePos, "texturePos");
        Intrinsics.checkNotNullParameter((Object)backgroundTexturePos, "backgroundTexturePos");
        if (this.hasStaticData) {
            Log.e("OpenGl", "Do not change the vertices data of an static GlLayerShape! " + Trace.calle$default(0, 1, null));
            this.vertexBufferSizeInvalid = true;
        }
        this.attach();
        this.updateFloatBuffer(shapePos, texturePos, backgroundTexturePos);
        this.attachBuffer();
    }
    
    private final void updateFloatBuffer(final float[] data) {
        this.hasChainedOrder = false;
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
        if (data.length != capacity) {
            buffer = ByteBuffer.allocateDirect(data.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.vertexBufferSizeInvalid = true;
        }
        final FloatBuffer floatBuffer = buffer;
        Intrinsics.checkNotNull((Object)floatBuffer);
        floatBuffer.put(data).position(0);
        this.verticesDataBuffer = buffer;
    }
    
    private final void updateFloatBuffer(final float[] dataShapePos, final float[] dataTexturePos, final float[] dataBackgroundTexturePos) {
        this.dataLength = dataShapePos.length;
        this.hasChainedOrder = true;
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
        if (this.dataLength * 3 != capacity) {
            buffer = ByteBuffer.allocateDirect(this.dataLength * 3 * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
            this.vertexBufferSizeInvalid = true;
        }
        final FloatBuffer floatBuffer = buffer;
        Intrinsics.checkNotNull((Object)floatBuffer);
        floatBuffer.position(0);
        buffer.put(dataShapePos).put(dataTexturePos).put(dataBackgroundTexturePos).position(0);
        this.verticesDataBuffer = buffer;
    }
    
    private final void attachBuffer() {
        GLES20.glBindBuffer(34962, this.handle);
        if (this.vertexBufferSizeInvalid) {
            final int n = 34962;
            final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
            Intrinsics.checkNotNull((Object)verticesDataBuffer);
            GLES20.glBufferData(n, verticesDataBuffer.capacity() * 4, (Buffer)this.verticesDataBuffer, this.hasStaticData ? 35044 : 35048);
            this.vertexBufferSizeInvalid = false;
        }
        else {
            final int n2 = 34962;
            final int n3 = 0;
            final FloatBuffer verticesDataBuffer2 = this.verticesDataBuffer;
            Intrinsics.checkNotNull((Object)verticesDataBuffer2);
            GLES20.glBufferSubData(n2, n3, verticesDataBuffer2.capacity() * 4, (Buffer)this.verticesDataBuffer);
        }
        GLES20.glBindBuffer(34962, 0);
        EGLLogWrapper.readGlError();
    }
    
    public void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        program.use();
        this.attach();
        if (this.attributePositions == -1) {
            this.attributePositions = GlProgram.getAttribute$default(program, "a_position", false, 2, null);
            try {
                this.attributeTextureCoordinates = GlProgram.getAttribute$default(program, "a_texCoord", false, 2, null);
            }
            catch (IllegalStateException ex) {}
            try {
                this.attributeBackgroundCoordinates = program.getAttribute("a_backgroundTexCoord", false);
            }
            catch (IllegalStateException ex2) {}
        }
        GLES20.glBindBuffer(34962, this.handle);
        if (this.hasChainedOrder) {
            final int lengthInBytes = this.dataLength * 4;
            GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, 2, 5126, false, 0, 0);
            GlObject.Companion.safeGlVertexAttribPointer(this.attributeTextureCoordinates, 2, 5126, false, 0, lengthInBytes);
            if (this.attributeBackgroundCoordinates >= 0) {
                GlObject.Companion.safeGlVertexAttribPointer(this.attributeBackgroundCoordinates, 2, 5126, false, 0, lengthInBytes + lengthInBytes);
            }
        }
        else {
            GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, 2, 5126, false, 24, 0);
            GlObject.Companion.safeGlVertexAttribPointer(this.attributeTextureCoordinates, 2, 5126, false, 24, 8);
            if (this.attributeBackgroundCoordinates >= 0) {
                GlObject.Companion.safeGlVertexAttribPointer(this.attributeBackgroundCoordinates, 2, 5126, false, 24, 16);
            }
        }
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributePositions);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributeTextureCoordinates);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributeBackgroundCoordinates);
        GLES20.glBindBuffer(34962, 0);
        EGLLogWrapper.readGlError();
    }
    
    public final void disable() {
        if (this.handle != -1) {
            GLES20.glBindBuffer(34962, this.handle);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributePositions);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributeTextureCoordinates);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributeBackgroundCoordinates);
            GLES20.glBindBuffer(34962, 0);
            EGLLogWrapper.readGlError();
        }
    }
    
    @Override
    protected void onRelease() {
        if (this.handle != -1) {
            GlObject.Companion.glDeleteBuffer(this.handle);
            this.handle = -1;
        }
    }
    
    @JvmOverloads
    public GlLayerShape() {
        this(false, 1, null);
    }
    
    static {
        Companion = new Companion(null);
        FILL_VIEWPORT_VERTICES_DATA = new float[] { -1.0f, 1.0f, 0.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 0.0f };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\nX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0011" }, d2 = { "Lly/img/android/opengl/canvas/GlLayerShape$Companion;", "", "()V", "DEFAULT_ATTRIBUTE_BACKGROUND_TEXTURE_COORDINATE", "", "DEFAULT_ATTRIBUTE_POSITION", "DEFAULT_ATTRIBUTE_TEXTURE_COORDINATE", "FILL_VIEWPORT_VERTICES_DATA", "", "FLOAT_SIZE_BYTES", "", "VERTICES_DATA_BACKGROUND_UV_OFFSET", "VERTICES_DATA_POS_OFFSET", "VERTICES_DATA_POS_SIZE", "VERTICES_DATA_STRIDE_BYTES", "VERTICES_DATA_UV_OFFSET", "VERTICES_DATA_UV_SIZE", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
