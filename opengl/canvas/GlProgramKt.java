// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import ly.img.android.opengl.textures.GlFrameBufferTexture;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aB\u0010\u0000\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\t\u001aB\u0010\n\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\t\u001aJ\u0010\u000b\u001a\u00020\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0003*\u0002H\u00022\u0006\u0010\f\u001a\u00020\r2!\u0010\u0004\u001a\u001d\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\u000e\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f" }, d2 = { "enable", "", "T", "Lly/img/android/opengl/canvas/GlProgram;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "program", "(Lly/img/android/opengl/canvas/GlProgram;Lkotlin/jvm/functions/Function1;)V", "render", "renderTo", "frameBuffer", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "(Lly/img/android/opengl/canvas/GlProgram;Lly/img/android/opengl/textures/GlFrameBufferTexture;Lkotlin/jvm/functions/Function1;)V", "pesdk-backend-core_release" })
public final class GlProgramKt
{
    public static final <T extends GlProgram> void render(@NotNull final T $this$render, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$render, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$render = 0;
        $this$render.use();
        block.invoke((Object)$this$render);
        $this$render.blitToViewPort();
    }
    
    public static final <T extends GlProgram> void renderTo(@NotNull final T $this$renderTo, @NotNull final GlFrameBufferTexture frameBuffer, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$renderTo, "<this>");
        Intrinsics.checkNotNullParameter((Object)frameBuffer, "frameBuffer");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$renderTo = 0;
        $this$renderTo.use();
        block.invoke((Object)$this$renderTo);
        $this$renderTo.blitToViewPort();
    }
    
    public static final <T extends GlProgram> void enable(@NotNull final T $this$enable, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$enable, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        $this$enable.use();
        block.invoke((Object)$this$enable);
    }
}
