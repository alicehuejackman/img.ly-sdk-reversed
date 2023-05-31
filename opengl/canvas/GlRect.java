// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import java.util.Arrays;
import android.opengl.GLES20;
import kotlin.jvm.functions.Function1;
import android.graphics.Matrix;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import kotlin.Unit;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u000f\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005B\u0017\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\bB\u001f\b\u0016\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\nJ\u0006\u0010\u0017\u001a\u00020\u0018JF\u0010\u0019\u001a\u00020\u0018\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u0002H\u001a2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00180\u001eH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010!J\u0010\u0010\"\u001a\u00020\u00182\u0006\u0010\u001c\u001a\u00020\u001bH\u0016J\b\u0010#\u001a\u00020\u0018H\u0014JF\u0010$\u001a\u00020\u0018\"\b\b\u0000\u0010\u001a*\u00020\u001b2\u0006\u0010\u001c\u001a\u0002H\u001a2!\u0010\u001d\u001a\u001d\u0012\u0013\u0012\u0011H\u001a¢\u0006\f\b\u001f\u0012\b\b \u0012\u0004\b\b(\u001c\u0012\u0004\u0012\u00020\u00180\u001eH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010!J*\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+J,\u0010%\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010-\u001a\u00020'2\b\b\u0002\u0010.\u001a\u00020\u0004J\u001a\u0010/\u001a\u00020\u00182\u0006\u0010&\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)J>\u00100\u001a\u00020\u00182\u0006\u00101\u001a\u00020'2\n\b\u0002\u0010(\u001a\u0004\u0018\u00010)2\u0006\u0010*\u001a\u00020+2\u0006\u0010,\u001a\u00020+2\b\b\u0002\u00102\u001a\u00020+2\b\b\u0002\u00103\u001a\u000204J\b\u00105\u001a\u000206H\u0016R\u001a\u0010\u000b\u001a\u00020\u0004X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u0005R\u001a\u0010\u000f\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0007X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00067" }, d2 = { "Lly/img/android/opengl/canvas/GlRect;", "Lly/img/android/opengl/canvas/GlShape;", "()V", "hasStaticData", "", "(Z)V", "verticesData", "", "([FZ)V", "textureData", "([F[FZ)V", "needUpdate", "getNeedUpdate$pesdk_backend_core_release", "()Z", "setNeedUpdate$pesdk_backend_core_release", "textureCords", "getTextureCords", "()[F", "setTextureCords", "([F)V", "vertexCords", "getVertexCords", "setVertexCords", "draw", "", "drawWith", "T", "Lly/img/android/opengl/canvas/GlProgram;", "program", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "enable", "onRebound", "runWith", "setShape", "rect", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "transformation", "Lly/img/android/pesdk/backend/model/chunk/Transformation;", "contextWidth", "", "contextHeight", "contextRect", "destinationFlip", "setShapeInViewport", "setTexture", "tileRect", "sourceRotation", "destinationRotation", "", "toString", "", "pesdk-backend-core_release" })
@WorkerThread
public final class GlRect extends GlShape
{
    @NotNull
    private float[] vertexCords;
    @NotNull
    private float[] textureCords;
    private boolean needUpdate;
    
    @NotNull
    protected final float[] getVertexCords() {
        return this.vertexCords;
    }
    
    protected final void setVertexCords(@NotNull final float[] <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.vertexCords = <set-?>;
    }
    
    @NotNull
    protected final float[] getTextureCords() {
        return this.textureCords;
    }
    
    protected final void setTextureCords(@NotNull final float[] <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.textureCords = <set-?>;
    }
    
    public final boolean getNeedUpdate$pesdk_backend_core_release() {
        return this.needUpdate;
    }
    
    public final void setNeedUpdate$pesdk_backend_core_release(final boolean <set-?>) {
        this.needUpdate = <set-?>;
    }
    
    public GlRect() {
        super(false);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
    }
    
    public GlRect(final boolean hasStaticData) {
        super(hasStaticData);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
    }
    
    public GlRect(@NotNull final float[] verticesData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        int i = 0;
        final float[] array = new float[8];
        while (i < 8) {
            final int n = i;
            array[n] = verticesData[n * 2 - n % 2];
            ++i;
        }
        final float[] array2 = array;
        int j = 0;
        final float[] textureData = new float[8];
        final float[] verticesData2 = array2;
        while (j < 8) {
            final int n2 = j;
            textureData[n2] = verticesData[n2 * 2 + 2 - n2 % 2];
            ++j;
        }
        super(verticesData2, textureData, hasStaticData);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
    }
    
    @Override
    protected void onRebound() {
        this.needUpdate = true;
    }
    
    public GlRect(@NotNull final float[] verticesData, @NotNull final float[] textureData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        Intrinsics.checkNotNullParameter((Object)textureData, "textureData");
        super(verticesData, textureData, hasStaticData);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.vertexCords = verticesData;
        this.textureCords = textureData;
    }
    
    public final void setShapeInViewport(@NotNull final MultiRect rect, @Nullable final Transformation transformation) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        this.setShape(rect, transformation, GlViewport.Companion.getWidth(), GlViewport.Companion.getHeight());
    }
    
    public final void setShape(@NotNull final MultiRect rect, @Nullable final Transformation transformation, final int contextWidth, final int contextHeight) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        rect.getEdges(this.vertexCords);
        if (transformation != null) {
            transformation.mapPoints(this.vertexCords);
        }
        GlShape.Companion.normalizeToVertexCords(this.vertexCords, (float)contextWidth, (float)contextHeight);
        this.needUpdate = true;
    }
    
    public final void setShape(@NotNull final MultiRect rect, @Nullable final Transformation transformation, @NotNull final MultiRect contextRect, final boolean destinationFlip) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        Intrinsics.checkNotNullParameter((Object)contextRect, "contextRect");
        rect.getEdges(this.vertexCords);
        if (transformation != null) {
            transformation.mapPoints(this.vertexCords);
        }
        GlShape.Companion.normalizeToVertexCords(this.vertexCords, contextRect);
        if (destinationFlip) {
            final float[] $this$mapPointsBy$iv = this.vertexCords;
            final int $i$f$mapPointsBy = 0;
            final Recyclable $this$recycleAfter$iv$iv = Transformation.obtain();
            final int $i$f$recycleAfter = 0;
            final Recyclable it$iv$iv = $this$recycleAfter$iv$iv;
            final int n = 0;
            final Transformation it$iv = (Transformation)it$iv$iv;
            final int n2 = 0;
            final Matrix it = it$iv;
            final int n3 = 0;
            it.setScale(1.0f, -1.0f, 0.5f, 0.5f);
            it$iv.mapPoints($this$mapPointsBy$iv);
            final Object $this$andRecycle$iv$iv$iv = Unit.INSTANCE;
            final int $i$f$andRecycle = 0;
            final Object it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
            final int n4 = 0;
            it$iv$iv.recycle();
        }
        this.needUpdate = true;
    }
    
    public final void setTexture(@NotNull final MultiRect tileRect, @Nullable final Transformation transformation, final int contextWidth, final int contextHeight, final int sourceRotation, final float destinationRotation) {
        Intrinsics.checkNotNullParameter((Object)tileRect, "tileRect");
        tileRect.getEdges(this.textureCords, true, sourceRotation);
        if (transformation != null) {
            transformation.mapPoints(this.textureCords);
        }
        GlShape.Companion.normalizeToTextureCords(this.textureCords, (float)contextWidth, (float)contextHeight, false);
        if (destinationRotation != 0.0f) {
            final float[] $this$mapPointsBy$iv = this.textureCords;
            final int $i$f$mapPointsBy = 0;
            final Recyclable $this$recycleAfter$iv$iv = Transformation.obtain();
            final int $i$f$recycleAfter = 0;
            final Recyclable it$iv$iv = $this$recycleAfter$iv$iv;
            final int n = 0;
            final Transformation it$iv = (Transformation)it$iv$iv;
            final int n2 = 0;
            final Matrix it = it$iv;
            final int n3 = 0;
            it.setRotate(destinationRotation, 0.5f, 0.5f);
            it$iv.mapPoints($this$mapPointsBy$iv);
            final Object $this$andRecycle$iv$iv$iv = Unit.INSTANCE;
            final int $i$f$andRecycle = 0;
            final Object it$iv$iv$iv = $this$andRecycle$iv$iv$iv;
            final int n4 = 0;
            it$iv$iv.recycle();
        }
        this.needUpdate = true;
    }
    
    @Override
    public void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        if (this.needUpdate) {
            this.needUpdate = false;
            this.updateVerticesData(this.vertexCords, this.textureCords);
        }
        super.enable(program);
    }
    
    public final <T extends GlProgram> void runWith(@NotNull final T program, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$runWith = 0;
        this.enable(program);
        block.invoke((Object)program);
        this.disable();
    }
    
    public final <T extends GlProgram> void drawWith(@NotNull final T program, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$drawWith = 0;
        this.enable(program);
        block.invoke((Object)program);
        this.draw();
        this.disable();
    }
    
    public final void draw() {
        GLES20.glDrawArrays(5, 0, 4);
    }
    
    @NotNull
    @Override
    public String toString() {
        return "GlRect(vertexCords=" + Arrays.toString(this.vertexCords) + ", textureCords=" + Arrays.toString(this.textureCords) + ", needUpdate=" + this.needUpdate + ')';
    }
}
