// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.NonNull;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import ly.img.android.pesdk.backend.model.chunk.RectRecycler;
import android.graphics.Rect;

public class ImageViewUtil
{
    @NonNull
    public static Rect getBitmapRectCenterInside(final float imageWidth, final float imageHeight, final float viewWidth, final float viewHeight) {
        final Rect rect = RectRecycler.obtain();
        final MultiRect multiRect = getBitmapRectCenterInsideHelper(imageWidth, imageHeight, viewWidth, viewHeight);
        multiRect.round(rect);
        multiRect.recycle();
        return rect;
    }
    
    @NonNull
    public static MultiRect getBitmapRectFCenterInside(final float imageWidth, final float imageHeight, final float viewWidth, final float viewHeight) {
        return getBitmapRectCenterInsideHelper(imageWidth, imageHeight, viewWidth, viewHeight);
    }
    
    @NonNull
    private static MultiRect getBitmapRectCenterInsideHelper(final float imageWidth, final float imageHeight, final float viewWidth, final float viewHeight) {
        final float viewToBitmapWidthRatio = viewWidth / imageWidth;
        final float viewToBitmapHeightRatio = viewHeight / imageHeight;
        float resultWidth;
        float resultHeight;
        if (viewToBitmapWidthRatio != Double.POSITIVE_INFINITY || viewToBitmapHeightRatio != Double.POSITIVE_INFINITY) {
            if (viewToBitmapWidthRatio <= viewToBitmapHeightRatio) {
                resultWidth = viewWidth;
                resultHeight = imageHeight * resultWidth / imageWidth;
            }
            else {
                resultHeight = viewHeight;
                resultWidth = imageWidth * resultHeight / imageHeight;
            }
        }
        else {
            resultHeight = imageHeight;
            resultWidth = imageWidth;
        }
        float resultX;
        float resultY;
        if (resultWidth == viewWidth) {
            resultX = 0.0f;
            resultY = (viewHeight - resultHeight) / 2.0f;
        }
        else if (resultHeight == viewHeight) {
            resultX = (viewWidth - resultWidth) / 2.0f;
            resultY = 0.0f;
        }
        else {
            resultX = (viewWidth - resultWidth) / 2.0f;
            resultY = (viewHeight - resultHeight) / 2.0f;
        }
        return MultiRect.obtain(resultX, resultY, resultX + resultWidth, resultY + resultHeight);
    }
}
