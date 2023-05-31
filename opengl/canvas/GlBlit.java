// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import java.nio.Buffer;
import kotlin.jvm.internal.Intrinsics;
import android.opengl.GLES20;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.JvmField;
import org.jetbrains.annotations.Nullable;
import java.nio.FloatBuffer;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0017\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000b\u001a\u00020\fJ\b\u0010\r\u001a\u00020\fH\u0002J\u0006\u0010\u000e\u001a\u00020\fJ\u0006\u0010\u000f\u001a\u00020\fJF\u0010\u0010\u001a\u00020\f\"\b\b\u0000\u0010\u0011*\u00020\u00122\u0006\u0010\u0013\u001a\u0002H\u00112!\u0010\u0014\u001a\u001d\u0012\u0013\u0012\u0011H\u0011¢\u0006\f\b\u0016\u0012\b\b\u0017\u0012\u0004\b\b(\u0018\u0012\u0004\u0012\u00020\f0\u0015H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u0019J\u000e\u0010\u0010\u001a\u00020\f2\u0006\u0010\u0013\u001a\u00020\u0012J\b\u0010\u001a\u001a\u00020\fH\u0014J\b\u0010\u001b\u001a\u00020\fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001d" }, d2 = { "Lly/img/android/opengl/canvas/GlBlit;", "Lly/img/android/opengl/canvas/GlObject;", "()V", "attributePositions", "", "attributeTextureCoordinates", "handle", "vertexBufferSizeInvalid", "", "verticesDataBuffer", "Ljava/nio/FloatBuffer;", "attach", "", "attachBuffer", "disable", "draw", "enable", "T", "Lly/img/android/opengl/canvas/GlProgram;", "program", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "onRelease", "updateFloatBuffer", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public class GlBlit extends GlObject
{
    @NotNull
    public static final Companion Companion;
    private int handle;
    private boolean vertexBufferSizeInvalid;
    @Nullable
    private FloatBuffer verticesDataBuffer;
    private int attributePositions;
    private int attributeTextureCoordinates;
    @JvmField
    @NotNull
    public static final float[] FILL_VIEWPORT_VERTICES_DATA;
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
    
    public GlBlit() {
        super(null, 1, null);
        this.handle = -1;
        this.vertexBufferSizeInvalid = true;
        this.attributePositions = -1;
        this.attributeTextureCoordinates = -1;
    }
    
    private final void updateFloatBuffer() {
        final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
        FloatBuffer floatBuffer = null;
        Label_0082: {
            if (verticesDataBuffer != null) {
                final FloatBuffer it = verticesDataBuffer;
                final int n = 0;
                floatBuffer = ((it.capacity() == GlBlit.FILL_VIEWPORT_VERTICES_DATA.length) ? it : null);
                if (floatBuffer != null) {
                    break Label_0082;
                }
            }
            final GlBlit $this$updateFloatBuffer_u24lambda_u2d1 = this;
            final int n2 = 0;
            $this$updateFloatBuffer_u24lambda_u2d1.vertexBufferSizeInvalid = true;
            floatBuffer = ByteBuffer.allocateDirect(GlBlit.FILL_VIEWPORT_VERTICES_DATA.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        }
        final FloatBuffer $this$updateFloatBuffer_u24lambda_u2d2;
        final FloatBuffer buffer = $this$updateFloatBuffer_u24lambda_u2d2 = floatBuffer;
        final int n3 = 0;
        $this$updateFloatBuffer_u24lambda_u2d2.position(0);
        $this$updateFloatBuffer_u24lambda_u2d2.put(GlBlit.FILL_VIEWPORT_VERTICES_DATA);
        $this$updateFloatBuffer_u24lambda_u2d2.position(0);
        this.verticesDataBuffer = buffer;
    }
    
    public final void attach() {
        if (this.handle == -1) {
            this.handle = GlObject.Companion.glGenBuffer();
            this.updateFloatBuffer();
            this.attachBuffer();
        }
    }
    
    private final void attachBuffer() {
        GLES20.glBindBuffer(34962, this.handle);
        final int n = 34962;
        final FloatBuffer verticesDataBuffer = this.verticesDataBuffer;
        Intrinsics.checkNotNull((Object)verticesDataBuffer);
        GLES20.glBufferData(n, verticesDataBuffer.capacity() * 4, (Buffer)this.verticesDataBuffer, 35044);
        this.vertexBufferSizeInvalid = false;
        GLES20.glBindBuffer(34962, 0);
    }
    
    public final <T extends GlProgram> void enable(@NotNull final T program, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.enable(program);
        block.invoke((Object)program);
        this.disable();
    }
    
    public final void draw() {
        GLES20.glDrawArrays(5, 0, 4);
    }
    
    public final void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        this.attach();
        this.attributePositions = GlProgram.getAttribute$default(program, "a_position", false, 2, null);
        this.attributeTextureCoordinates = program.getAttribute("a_texCoord", false);
        GLES20.glBindBuffer(34962, this.handle);
        GlObject.Companion.safeGlVertexAttribPointer(this.attributePositions, 2, 5126, false, 16, 0);
        GlObject.Companion.safeGlVertexAttribPointer(this.attributeTextureCoordinates, 2, 5126, false, 16, 8);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributePositions);
        GlObject.Companion.safeGlEnableVertexAttribArray(this.attributeTextureCoordinates);
    }
    
    public final void disable() {
        if (this.handle != -1) {
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
        this.vertexBufferSizeInvalid = true;
    }
    
    static {
        Companion = new Companion(null);
        FILL_VIEWPORT_VERTICES_DATA = new float[] { -1.0f, 1.0f, 0.0f, 1.0f, -1.0f, -1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 0.0f };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\tX\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lly/img/android/opengl/canvas/GlBlit$Companion;", "", "()V", "DEFAULT_ATTRIBUTE_POSITION", "", "DEFAULT_ATTRIBUTE_TEXTURE_COORDINATE", "FILL_VIEWPORT_VERTICES_DATA", "", "FLOAT_SIZE_BYTES", "", "VERTICES_DATA_POS_OFFSET", "VERTICES_DATA_POS_SIZE", "VERTICES_DATA_STRIDE_BYTES", "VERTICES_DATA_UV_OFFSET", "VERTICES_DATA_UV_SIZE", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
