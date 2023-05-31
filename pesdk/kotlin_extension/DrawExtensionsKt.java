// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import android.graphics.Paint$FontMetrics;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Color;
import android.graphics.ColorFilter;
import androidx.annotation.ColorInt;
import android.graphics.NinePatch;
import ly.img.android.PESDK;
import java.nio.ByteOrder;
import java.nio.ByteBuffer;
import android.graphics.drawable.NinePatchDrawable;
import android.graphics.Bitmap;
import android.graphics.RectF;
import ly.img.android.pesdk.utils.BitmapFactoryUtils;
import kotlin.math.MathKt;
import kotlin.NoWhenBranchMatchedException;
import org.jetbrains.annotations.Nullable;
import android.graphics.Paint;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import ly.img.android.pesdk.backend.decoder.ImageSource;
import android.graphics.Rect;
import kotlin.jvm.internal.Intrinsics;
import android.text.Layout;
import org.jetbrains.annotations.NotNull;
import android.graphics.Canvas;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000T\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a\u0012\u0010\u0002\u001a\u00020\u0003*\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u001a\u0012\u0010\u0007\u001a\u00020\b*\u00020\t2\u0006\u0010\n\u001a\u00020\u000b\u001a6\u0010\f\u001a\u00020\b*\u00020\t2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u001a\n\u0010\u0015\u001a\u00020\u0016*\u00020\u0006\u001a\n\u0010\u0017\u001a\u00020\u0018*\u00020\u0019\u001a\u0014\u0010\u001a\u001a\u00020\b*\u00020\u00122\b\b\u0001\u0010\u001b\u001a\u00020\u0001\u001a\n\u0010\u001c\u001a\u00020\u0018*\u00020\u0019\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u001d" }, d2 = { "NO_COLOR", "", "createNinePatch", "Landroid/graphics/drawable/NinePatchDrawable;", "Landroid/graphics/Bitmap;", "capInsets", "Landroid/graphics/Rect;", "draw", "", "Landroid/graphics/Canvas;", "layout", "Landroid/text/Layout;", "drawImage", "image", "Lly/img/android/pesdk/backend/decoder/ImageSource;", "destination", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "paint", "Landroid/graphics/Paint;", "mode", "Lly/img/android/pesdk/kotlin_extension/ImageDrawMode;", "isZero", "", "lineHeigth", "", "Landroid/graphics/Paint$FontMetrics;", "setTintColorFilter", "color", "yOffset", "pesdk-backend-core_release" })
public final class DrawExtensionsKt
{
    public static final int NO_COLOR = 1;
    
    public static final void draw(@NotNull final Canvas $this$draw, @NotNull final Layout layout) {
        Intrinsics.checkNotNullParameter((Object)$this$draw, "<this>");
        Intrinsics.checkNotNullParameter((Object)layout, "layout");
        layout.draw($this$draw);
    }
    
    public static final boolean isZero(@NotNull final Rect $this$isZero) {
        Intrinsics.checkNotNullParameter((Object)$this$isZero, "<this>");
        return $this$isZero.top == 0 && $this$isZero.left == 0 && $this$isZero.right == 0 && $this$isZero.bottom == 0;
    }
    
    public static final void drawImage(@NotNull final Canvas $this$drawImage, @NotNull final ImageSource image, @NotNull final MultiRect destination, @NotNull final Paint paint, @NotNull final ImageDrawMode mode, @Nullable final Rect capInsets) {
        Intrinsics.checkNotNullParameter((Object)$this$drawImage, "<this>");
        Intrinsics.checkNotNullParameter((Object)image, "image");
        Intrinsics.checkNotNullParameter((Object)destination, "destination");
        Intrinsics.checkNotNullParameter((Object)paint, "paint");
        Intrinsics.checkNotNullParameter((Object)mode, "mode");
        MultiRect setCenter = null;
        switch (WhenMappings.$EnumSwitchMapping$0[mode.ordinal()]) {
            case 1: {
                setCenter = destination;
                break;
            }
            case 2: {
                setCenter = MultiRect.generateCenteredRect(image.getSize().width, image.getSize().height, destination.width(), destination.height()).setCenter(destination.centerX(), destination.centerY());
                break;
            }
            default: {
                throw new NoWhenBranchMatchedException();
            }
        }
        final MultiRect drawDestination = setCenter;
        Bitmap bitmap;
        if ((bitmap = image.getBitmap(MathKt.roundToInt(drawDestination.width()), MathKt.roundToInt(drawDestination.height()), false)) == null) {
            bitmap = BitmapFactoryUtils.NOTHING_BITMAP;
        }
        final Bitmap imageBitmap = bitmap;
        if (capInsets == null || isZero(capInsets)) {
            $this$drawImage.drawBitmap(imageBitmap, (Rect)null, (RectF)drawDestination, paint);
        }
        else {
            Intrinsics.checkNotNullExpressionValue((Object)imageBitmap, "imageBitmap");
            final NinePatchDrawable $this$drawImage_u24lambda_u2d1;
            final NinePatchDrawable ninePatchDrawable = $this$drawImage_u24lambda_u2d1 = createNinePatch(imageBitmap, capInsets);
            final int n = 0;
            $this$drawImage_u24lambda_u2d1.setBounds(MathKt.roundToInt(drawDestination.getLeft()), MathKt.roundToInt(drawDestination.getTop()), MathKt.roundToInt(drawDestination.getRight()), MathKt.roundToInt(drawDestination.getBottom()));
            final Paint $this$drawImage_u24lambda_u2d1_u24lambda_u2d0 = $this$drawImage_u24lambda_u2d1.getPaint();
            final int n2 = 0;
            $this$drawImage_u24lambda_u2d1_u24lambda_u2d0.set(paint);
            $this$drawImage_u24lambda_u2d1_u24lambda_u2d0.setAntiAlias(false);
            ninePatchDrawable.draw($this$drawImage);
        }
        imageBitmap.recycle();
        if (mode != ImageDrawMode.FIT) {
            drawDestination.recycle();
        }
    }
    
    @NotNull
    public static final NinePatchDrawable createNinePatch(@NotNull final Bitmap $this$createNinePatch, @NotNull final Rect capInsets) {
        Intrinsics.checkNotNullParameter((Object)$this$createNinePatch, "<this>");
        Intrinsics.checkNotNullParameter((Object)capInsets, "capInsets");
        final ByteBuffer buffer = ByteBuffer.allocate(84).order(ByteOrder.nativeOrder());
        buffer.put((byte)1);
        buffer.put((byte)2);
        buffer.put((byte)2);
        buffer.put((byte)9);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(0);
        buffer.putInt(capInsets.left);
        buffer.putInt($this$createNinePatch.getWidth() - capInsets.right);
        buffer.putInt(capInsets.top);
        buffer.putInt($this$createNinePatch.getHeight() - capInsets.bottom);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        buffer.putInt(1);
        return new NinePatchDrawable(PESDK.getAppResource(), new NinePatch($this$createNinePatch, buffer.array(), (String)null));
    }
    
    public static final void setTintColorFilter(@NotNull final Paint $this$setTintColorFilter, @ColorInt final int color) {
        Intrinsics.checkNotNullParameter((Object)$this$setTintColorFilter, "<this>");
        $this$setTintColorFilter.setColorFilter((ColorFilter)new ColorMatrixColorFilter(new float[] { 0.0f, 0.0f, 0.0f, 0.0f, (float)Color.red(color), 0.0f, 0.0f, 0.0f, 0.0f, (float)Color.green(color), 0.0f, 0.0f, 0.0f, 0.0f, (float)Color.blue(color), 0.0f, 0.0f, 0.0f, Color.alpha(color) / 255.0f, 0.0f }));
    }
    
    public static final float lineHeigth(@NotNull final Paint$FontMetrics $this$lineHeigth) {
        Intrinsics.checkNotNullParameter((Object)$this$lineHeigth, "<this>");
        return $this$lineHeigth.bottom - $this$lineHeigth.top;
    }
    
    public static final float yOffset(@NotNull final Paint$FontMetrics $this$yOffset) {
        Intrinsics.checkNotNullParameter((Object)$this$yOffset, "<this>");
        return $this$yOffset.ascent - $this$yOffset.top;
    }
}
