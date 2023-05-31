// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import androidx.annotation.AnyThread;
import kotlin.jvm.JvmStatic;
import ly.img.android.opengl.EGLLogWrapper;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.nio.Buffer;
import android.opengl.GLES20;
import android.util.Log;
import ly.img.android.pesdk.utils.Trace;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import java.nio.FloatBuffer;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0017\u0018\u0000 )2\u00020\u0001:\u0001)B\u0011\b\u0017\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\u0006\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0002J\b\u0010\u0016\u001a\u00020\u0014H\u0016JF\u0010\u0017\u001a\u00020\u0014\"\b\b\u0000\u0010\u0018*\u00020\u00192\u0006\u0010\u001a\u001a\u0002H\u00182!\u0010\u001b\u001a\u001d\u0012\u0013\u0012\u0011H\u0018¢\u0006\f\b\u001d\u0012\b\b\u001e\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u00140\u001cH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010 J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u001a\u001a\u00020\u0019H\u0016J\b\u0010!\u001a\u00020\u0014H\u0014J\u0010\u0010\"\u001a\u00020\u00142\u0006\u0010#\u001a\u00020\u0006H\u0002J\u0018\u0010\"\u001a\u00020\u00142\u0006\u0010$\u001a\u00020\u00062\u0006\u0010%\u001a\u00020\u0006H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\u00062\u0006\u0010(\u001a\u00020\u0006H\u0016R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006*" }, d2 = { "Lly/img/android/opengl/canvas/GlShape;", "Lly/img/android/opengl/canvas/GlObject;", "hasStaticData", "", "(Z)V", "verticesData", "", "([FZ)V", "textureData", "([F[FZ)V", "attributePositions", "", "attributeTextureCoordinates", "dataLength", "handle", "hasChainedOrder", "vertexBufferSizeInvalid", "verticesDataBuffer", "Ljava/nio/FloatBuffer;", "attach", "", "attachBuffer", "disable", "enable", "T", "Lly/img/android/opengl/canvas/GlProgram;", "program", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "onRelease", "updateFloatBuffer", "data", "dataShapePos", "dataTexturePos", "updateVerticesData", "shapePos", "texturePos", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public class GlShape extends GlObject
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
    @JvmField
    @NotNull
    public static final float[] FILL_STAGE_VERTICES_CORDS;
    @JvmField
    @NotNull
    public static final float[] GL_ORDER_TEXTURE_CORDS;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA_VERTICAL_FLIPPED;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA_90_DEG_CORRECTION;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA_180_DEG_CORRECTION;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA_270_DEG_CORRECTION;
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_POSITION = "a_position";
    @NotNull
    private static final String DEFAULT_ATTRIBUTE_TEXTURE_COORDINATE = "a_texCoord";
    private static final int FLOAT_SIZE_BYTES = 4;
    private static final int VERTICES_DATA_UV_SIZE = 2;
    private static final int VERTICES_DATA_POS_SIZE = 2;
    private static final int VERTICES_DATA_POS_OFFSET = 0;
    private static final int VERTICES_DATA_STRIDE_BYTES = 16;
    private static final int VERTICES_DATA_UV_OFFSET = 8;
    
    @JvmOverloads
    public GlShape(final boolean hasStaticData) {
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
        this.hasStaticData = hasStaticData;
        this.updateFloatBuffer(GlShape.FILL_VIEWPORT_VERTICES_DATA);
    }
    
    public GlShape(@NotNull final float[] verticesData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
        this.hasStaticData = hasStaticData;
        this.updateFloatBuffer(verticesData);
    }
    
    public GlShape(@NotNull final float[] verticesData, @NotNull final float[] textureData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        Intrinsics.checkNotNullParameter((Object)textureData, "textureData");
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
        this.hasStaticData = hasStaticData;
        this.updateFloatBuffer(verticesData, textureData);
    }
    
    private final void updateFloatBuffer(final float[] data) {
        this.hasChainedOrder = false;
        final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
        FloatBuffer floatBuffer = null;
        Label_0083: {
            if (verticesDataBuffer != null) {
                final FloatBuffer it = verticesDataBuffer;
                final int n = 0;
                floatBuffer = ((it.capacity() == data.length) ? it : null);
                if (floatBuffer != null) {
                    break Label_0083;
                }
            }
            final GlShape $this$updateFloatBuffer_u24lambda_u2d1 = this;
            final int n2 = 0;
            $this$updateFloatBuffer_u24lambda_u2d1.vertexBufferSizeInvalid = true;
            floatBuffer = ByteBuffer.allocateDirect(data.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        final FloatBuffer $this$updateFloatBuffer_u24lambda_u2d2;
        final FloatBuffer buffer = $this$updateFloatBuffer_u24lambda_u2d2 = floatBuffer;
        final int n3 = 0;
        $this$updateFloatBuffer_u24lambda_u2d2.position(0);
        $this$updateFloatBuffer_u24lambda_u2d2.put(data);
        $this$updateFloatBuffer_u24lambda_u2d2.position(0);
        this.verticesDataBuffer = buffer;
    }
    
    private final void updateFloatBuffer(final float[] dataShapePos, final float[] dataTexturePos) {
        this.dataLength = dataShapePos.length;
        this.hasChainedOrder = true;
        final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
        FloatBuffer floatBuffer = null;
        Label_0105: {
            if (verticesDataBuffer != null) {
                final FloatBuffer it = verticesDataBuffer;
                final int n = 0;
                floatBuffer = ((it.capacity() == this.dataLength + this.dataLength) ? it : null);
                if (floatBuffer != null) {
                    break Label_0105;
                }
            }
            final GlShape $this$updateFloatBuffer_u24lambda_u2d4 = this;
            final int n2 = 0;
            $this$updateFloatBuffer_u24lambda_u2d4.vertexBufferSizeInvalid = true;
            floatBuffer = ByteBuffer.allocateDirect(($this$updateFloatBuffer_u24lambda_u2d4.dataLength + $this$updateFloatBuffer_u24lambda_u2d4.dataLength) * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        final FloatBuffer $this$updateFloatBuffer_u24lambda_u2d5;
        final FloatBuffer buffer = $this$updateFloatBuffer_u24lambda_u2d5 = floatBuffer;
        final int n3 = 0;
        $this$updateFloatBuffer_u24lambda_u2d5.position(0);
        $this$updateFloatBuffer_u24lambda_u2d5.put(dataShapePos);
        $this$updateFloatBuffer_u24lambda_u2d5.put(dataTexturePos);
        $this$updateFloatBuffer_u24lambda_u2d5.position(0);
        this.verticesDataBuffer = buffer;
    }
    
    public void updateVerticesData(@NotNull final float[] shapePos, @NotNull final float[] texturePos) {
        Intrinsics.checkNotNullParameter((Object)shapePos, "shapePos");
        Intrinsics.checkNotNullParameter((Object)texturePos, "texturePos");
        if (this.hasStaticData) {
            Log.e("OpenGl", "Do not change the vertices data of an static GlShape! " + Trace.stackAll());
            this.vertexBufferSizeInvalid = true;
        }
        this.attach();
        this.updateFloatBuffer(shapePos, texturePos);
        this.attachBuffer();
    }
    
    public void attach() {
        if (this.handle == -1) {
            this.handle = GlObject.Companion.glGenBuffer();
            this.attachBuffer();
        }
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
    }
    
    public void updateVerticesData(@NotNull final float[] verticesData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        if (this.hasStaticData) {
            Log.e("OpenGl", "Do not change the vertices data of an static GlShape! " + Trace.calle$default(0, 1, null));
            this.vertexBufferSizeInvalid = true;
        }
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
    
    public void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        program.use();
        this.attach();
        if (this.attributePositions == -1) {
            this.attributePositions = GlProgram.getAttribute$default(program, "a_position", false, 2, null);
            this.attributeTextureCoordinates = program.getAttribute("a_texCoord", false);
        }
        GLES20.glBindBuffer(34962, this.handle);
        final int lengthInBytes = this.dataLength * 4;
        if (this.hasChainedOrder) {
            GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, 2, 5126, false, 0, 0);
            GlObject.Companion.safeGlVertexAttribPointer(this.attributeTextureCoordinates, 2, 5126, false, 0, lengthInBytes);
        }
        else {
            GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, 2, 5126, false, 16, 0);
            GlObject.Companion.safeGlVertexAttribPointer(this.attributeTextureCoordinates, 2, 5126, false, 16, 8);
        }
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributePositions);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributeTextureCoordinates);
        EGLLogWrapper.readGlError();
        GLES20.glBindBuffer(34962, 0);
    }
    
    public void disable() {
        if (this.handle != -1) {
            GLES20.glBindBuffer(34962, this.handle);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributePositions);
            GlObject.Companion.safeGlDisableVertexAttribArray(this.attributeTextureCoordinates);
            GLES20.glBindBuffer(34962, 0);
        }
    }
    
    @Override
    protected void onRelease() {
        if (this.handle != -1) {
            GlObject.Companion.glDeleteBuffer(this.handle);
            this.handle = -1;
        }
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
    }
    
    @JvmOverloads
    public GlShape() {
        this(false, 1, null);
    }
    
    @JvmStatic
    @AnyThread
    @JvmOverloads
    public static final void normalizeToTextureCords(@NotNull final float[] absolutePosData, final float width, final float height, final boolean doFlip) {
        GlShape.Companion.normalizeToTextureCords(absolutePosData, width, height, doFlip);
    }
    
    @JvmStatic
    @AnyThread
    @JvmOverloads
    public static final void normalizeToTextureCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance, final boolean doFlip) {
        GlShape.Companion.normalizeToTextureCords(absolutePosData, referance, doFlip);
    }
    
    @JvmStatic
    @AnyThread
    public static final void normalizeToVertexCords(@NotNull final float[] absolutePosData, final float width, final float height) {
        GlShape.Companion.normalizeToVertexCords(absolutePosData, width, height);
    }
    
    @JvmStatic
    @AnyThread
    public static final void normalizeToVertexCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance) {
        GlShape.Companion.normalizeToVertexCords(absolutePosData, referance);
    }
    
    @JvmStatic
    @AnyThread
    @JvmOverloads
    public static final void normalizeToTextureCords(@NotNull final float[] absolutePosData, final float width, final float height) {
        GlShape.Companion.normalizeToTextureCords(absolutePosData, width, height);
    }
    
    @JvmStatic
    @AnyThread
    @JvmOverloads
    public static final void normalizeToTextureCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance) {
        GlShape.Companion.normalizeToTextureCords(absolutePosData, referance);
    }
    
    static {
        Companion = new Companion(null);
        FILL_STAGE_VERTICES_CORDS = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        GL_ORDER_TEXTURE_CORDS = new float[] { 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f };
        FILL_VIEWPORT_VERTICES_DATA = new float[] { -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f };
        FILL_VIEWPORT_VERTICES_DATA_VERTICAL_FLIPPED = new float[] { -1.0f, 1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 1.0f, 1.0f };
        FILL_VIEWPORT_VERTICES_DATA_90_DEG_CORRECTION = new float[] { -1.0f, 1.0f, 0.0f, 0.0f, -1.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f };
        FILL_VIEWPORT_VERTICES_DATA_180_DEG_CORRECTION = new float[] { -1.0f, 1.0f, 1.0f, 0.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f };
        FILL_VIEWPORT_VERTICES_DATA_270_DEG_CORRECTION = new float[] { -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J*\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001e2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0007J \u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0019H\u0007J\u0018\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u001d\u001a\u00020\u001eH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u000eX\u0082T¢\u0006\u0002\n\u0000¨\u0006 " }, d2 = { "Lly/img/android/opengl/canvas/GlShape$Companion;", "", "()V", "DEFAULT_ATTRIBUTE_POSITION", "", "DEFAULT_ATTRIBUTE_TEXTURE_COORDINATE", "FILL_STAGE_VERTICES_CORDS", "", "FILL_VIEWPORT_VERTICES_DATA", "FILL_VIEWPORT_VERTICES_DATA_180_DEG_CORRECTION", "FILL_VIEWPORT_VERTICES_DATA_270_DEG_CORRECTION", "FILL_VIEWPORT_VERTICES_DATA_90_DEG_CORRECTION", "FILL_VIEWPORT_VERTICES_DATA_VERTICAL_FLIPPED", "FLOAT_SIZE_BYTES", "", "GL_ORDER_TEXTURE_CORDS", "VERTICES_DATA_POS_OFFSET", "VERTICES_DATA_POS_SIZE", "VERTICES_DATA_STRIDE_BYTES", "VERTICES_DATA_UV_OFFSET", "VERTICES_DATA_UV_SIZE", "normalizeToTextureCords", "", "absolutePosData", "width", "", "height", "doFlip", "", "referance", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "normalizeToVertexCords", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        @AnyThread
        @JvmOverloads
        public final void normalizeToTextureCords(@NotNull final float[] absolutePosData, final float width, final float height, final boolean doFlip) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            if (doFlip) {
                for (int i = 0; i < absolutePosData.length; ++i) {
                    if ((i & 0x1) == 0x0) {
                        absolutePosData[i] /= width;
                    }
                    else {
                        absolutePosData[i] = 1.0f - absolutePosData[i] / height;
                    }
                }
            }
            else {
                for (int i = 0; i < absolutePosData.length; ++i) {
                    if ((i & 0x1) == 0x0) {
                        absolutePosData[i] /= width;
                    }
                    else {
                        absolutePosData[i] /= height;
                    }
                }
            }
        }
        
        public static /* synthetic */ void normalizeToTextureCords$default(final Companion companion, final float[] absolutePosData, final float width, final float height, boolean doFlip, final int n, final Object o) {
            if ((n & 0x8) != 0x0) {
                doFlip = true;
            }
            companion.normalizeToTextureCords(absolutePosData, width, height, doFlip);
        }
        
        @JvmStatic
        @AnyThread
        @JvmOverloads
        public final void normalizeToTextureCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance, final boolean doFlip) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            Intrinsics.checkNotNullParameter((Object)referance, "referance");
            final float xOffset = -referance.getLeft();
            final float yOffset = -referance.getTop();
            final float width = referance.getWidth();
            final float height = referance.getHeight();
            if (doFlip) {
                for (int i = 0; i < absolutePosData.length; ++i) {
                    if ((i & 0x1) == 0x0) {
                        absolutePosData[i] = (xOffset + absolutePosData[i]) / width;
                    }
                    else {
                        absolutePosData[i] = 1.0f - (yOffset + absolutePosData[i]) / height;
                    }
                }
            }
            else {
                for (int i = 0; i < absolutePosData.length; ++i) {
                    if ((i & 0x1) == 0x0) {
                        absolutePosData[i] = (xOffset + absolutePosData[i]) / width;
                    }
                    else {
                        absolutePosData[i] = (yOffset + absolutePosData[i]) / height;
                    }
                }
            }
        }
        
        public static /* synthetic */ void normalizeToTextureCords$default(final Companion companion, final float[] absolutePosData, final MultiRect referance, boolean doFlip, final int n, final Object o) {
            if ((n & 0x4) != 0x0) {
                doFlip = true;
            }
            companion.normalizeToTextureCords(absolutePosData, referance, doFlip);
        }
        
        @JvmStatic
        @AnyThread
        public final void normalizeToVertexCords(@NotNull final float[] absolutePosData, final float width, final float height) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            final float dividerX = width / 2.0f;
            final float dividerY = height / 2.0f;
            for (int i = 0; i < absolutePosData.length; ++i) {
                if ((i & 0x1) == 0x0) {
                    absolutePosData[i] = -1.0f + absolutePosData[i] / dividerX;
                }
                else {
                    absolutePosData[i] = 1.0f - absolutePosData[i] / dividerY;
                }
            }
        }
        
        @JvmStatic
        @AnyThread
        public final void normalizeToVertexCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            Intrinsics.checkNotNullParameter((Object)referance, "referance");
            final float xOffset = -referance.getLeft();
            final float yOffset = -referance.getTop();
            final float dividerX = referance.getWidth() / 2.0f;
            final float dividerY = referance.getHeight() / 2.0f;
            for (int i = 0; i < absolutePosData.length; ++i) {
                if ((i & 0x1) == 0x0) {
                    absolutePosData[i] = -1.0f + (xOffset + absolutePosData[i]) / dividerX;
                }
                else {
                    absolutePosData[i] = 1.0f - (yOffset + absolutePosData[i]) / dividerY;
                }
            }
        }
        
        @JvmStatic
        @AnyThread
        @JvmOverloads
        public final void normalizeToTextureCords(@NotNull final float[] absolutePosData, final float width, final float height) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            normalizeToTextureCords$default(this, absolutePosData, width, height, false, 8, null);
        }
        
        @JvmStatic
        @AnyThread
        @JvmOverloads
        public final void normalizeToTextureCords(@NotNull final float[] absolutePosData, @NotNull final MultiRect referance) {
            Intrinsics.checkNotNullParameter((Object)absolutePosData, "absolutePosData");
            Intrinsics.checkNotNullParameter((Object)referance, "referance");
            normalizeToTextureCords$default(this, absolutePosData, referance, false, 4, null);
        }
    }
}
