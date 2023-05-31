// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import android.opengl.GLES20;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import android.graphics.Matrix;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u0007\b\u0016¢\u0006\u0002\u0010\u0002B\u0017\b\u0016\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u000f\b\u0016\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\bJ\u0006\u0010\u001a\u001a\u00020\u001bJF\u0010\u001c\u001a\u00020\u001b\"\b\b\u0000\u0010\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u0002H\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001b0!H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010$J\u0010\u0010%\u001a\u00020\u001b2\u0006\u0010\u001f\u001a\u00020\u001eH\u0016JF\u0010&\u001a\u00020\u001b\"\b\b\u0000\u0010\u001d*\u00020\u001e2\u0006\u0010\u001f\u001a\u0002H\u001d2!\u0010 \u001a\u001d\u0012\u0013\u0012\u0011H\u001d¢\u0006\f\b\"\u0012\b\b#\u0012\u0004\b\b(\u001f\u0012\u0004\u0012\u00020\u001b0!H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010$J*\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\"\u0010'\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020)J*\u00100\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-J\"\u00100\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\n\b\u0002\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010/\u001a\u00020)J(\u00101\u001a\u00020\u001b2\u0006\u0010(\u001a\u00020)2\b\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010,\u001a\u00020-2\u0006\u0010.\u001a\u00020-R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u000b\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0006X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\bR\u001a\u0010\u0014\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\r\"\u0004\b\u0016\u0010\u000fR\u001a\u0010\u0017\u001a\u00020\u0004X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\r\"\u0004\b\u0019\u0010\u000f\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u00062" }, d2 = { "Lly/img/android/opengl/canvas/GlLayerRect;", "Lly/img/android/opengl/canvas/GlLayerShape;", "()V", "verticesData", "", "hasStaticData", "", "([FZ)V", "(Z)V", "backgroundMatrix", "Landroid/graphics/Matrix;", "backgroundTextureCords", "getBackgroundTextureCords", "()[F", "setBackgroundTextureCords", "([F)V", "needUpdate", "getNeedUpdate$pesdk_backend_core_release", "()Z", "setNeedUpdate$pesdk_backend_core_release", "textureCords", "getTextureCords", "setTextureCords", "vertexCords", "getVertexCords", "setVertexCords", "draw", "", "drawWith", "T", "Lly/img/android/opengl/canvas/GlProgram;", "program", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "enable", "runWith", "setBackgroundTexture", "rect", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "transformation", "Lly/img/android/pesdk/backend/model/chunk/Transformation;", "contextWidth", "", "contextHeight", "contextRect", "setShape", "setTexture", "pesdk-backend-core_release" })
@WorkerThread
public final class GlLayerRect extends GlLayerShape
{
    @NotNull
    private float[] vertexCords;
    @NotNull
    private float[] textureCords;
    @NotNull
    private float[] backgroundTextureCords;
    private boolean needUpdate;
    @NotNull
    private final Matrix backgroundMatrix;
    
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
    
    @NotNull
    protected final float[] getBackgroundTextureCords() {
        return this.backgroundTextureCords;
    }
    
    protected final void setBackgroundTextureCords(@NotNull final float[] <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.backgroundTextureCords = <set-?>;
    }
    
    public final boolean getNeedUpdate$pesdk_backend_core_release() {
        return this.needUpdate;
    }
    
    public final void setNeedUpdate$pesdk_backend_core_release(final boolean <set-?>) {
        this.needUpdate = <set-?>;
    }
    
    public GlLayerRect() {
        super(false, 1, null);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.backgroundTextureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.needUpdate = true;
        this.backgroundMatrix = new Matrix();
    }
    
    public GlLayerRect(@NotNull final float[] verticesData, final boolean hasStaticData) {
        Intrinsics.checkNotNullParameter((Object)verticesData, "verticesData");
        super(verticesData, hasStaticData);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.backgroundTextureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.needUpdate = true;
        this.backgroundMatrix = new Matrix();
    }
    
    public GlLayerRect(final boolean hasStaticData) {
        super(hasStaticData);
        this.vertexCords = new float[] { -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f };
        this.textureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.backgroundTextureCords = new float[] { 0.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f };
        this.needUpdate = true;
        this.backgroundMatrix = new Matrix();
    }
    
    public final void setShape(@NotNull final MultiRect rect, @Nullable final Transformation transformation, @NotNull final MultiRect contextRect) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        Intrinsics.checkNotNullParameter((Object)contextRect, "contextRect");
        this.needUpdate = true;
        rect.getEdges(this.vertexCords);
        if (transformation != null) {
            transformation.mapPoints(this.vertexCords);
        }
        GlShape.Companion.normalizeToVertexCords(this.vertexCords, contextRect);
    }
    
    public final void setShape(@NotNull final MultiRect rect, @Nullable final Transformation transformation, final int contextWidth, final int contextHeight) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        this.needUpdate = true;
        rect.getEdges(this.vertexCords);
        if (transformation != null) {
            transformation.mapPoints(this.vertexCords);
        }
        GlShape.Companion.normalizeToVertexCords(this.vertexCords, (float)contextWidth, (float)contextHeight);
    }
    
    public final void setTexture(@NotNull final MultiRect rect, @Nullable final Transformation transformation, final int contextWidth, final int contextHeight) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        this.needUpdate = true;
        rect.getEdges(this.textureCords);
        if (transformation != null) {
            transformation.mapPoints(this.textureCords);
        }
        GlShape.Companion.normalizeToTextureCords$default(GlShape.Companion, this.textureCords, (float)contextWidth, (float)contextHeight, false, 8, null);
    }
    
    public final void setBackgroundTexture(@NotNull final MultiRect rect, @Nullable final Transformation transformation, final int contextWidth, final int contextHeight) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        this.needUpdate = true;
        rect.getEdges(this.backgroundTextureCords);
        if (transformation != null) {
            transformation.mapPoints(this.backgroundTextureCords);
        }
        GlShape.Companion.normalizeToTextureCords$default(GlShape.Companion, this.backgroundTextureCords, (float)contextWidth, (float)contextHeight, false, 8, null);
    }
    
    public final void setBackgroundTexture(@NotNull final MultiRect rect, @Nullable final Transformation transformation, @NotNull final MultiRect contextRect) {
        Intrinsics.checkNotNullParameter((Object)rect, "rect");
        Intrinsics.checkNotNullParameter((Object)contextRect, "contextRect");
        this.needUpdate = true;
        rect.getEdges(this.backgroundTextureCords);
        if (transformation != null) {
            transformation.mapPoints(this.backgroundTextureCords);
        }
        GlShape.Companion.normalizeToTextureCords$default(GlShape.Companion, this.backgroundTextureCords, contextRect, false, 4, null);
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
    
    @Override
    public void enable(@NotNull final GlProgram program) {
        Intrinsics.checkNotNullParameter((Object)program, "program");
        if (this.needUpdate) {
            this.updateVerticesData(this.vertexCords, this.textureCords, this.backgroundTextureCords);
        }
        super.enable(program);
    }
    
    public final void draw() {
        GLES20.glDrawArrays(5, 0, 4);
    }
}
