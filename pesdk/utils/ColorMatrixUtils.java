// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import android.graphics.ColorMatrix;

public final class ColorMatrixUtils
{
    private ColorMatrixUtils() {
    }
    
    @NonNull
    public static ColorMatrix generateExposureMatrix(final float exposure) {
        final float scale = (float)Math.pow(2.0, exposure);
        final float[] array = { scale, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, scale, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, scale, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f };
        return new ColorMatrix(array);
    }
    
    @NonNull
    public static ColorMatrix generateSaturationMatrix(final float saturation) {
        final ColorMatrix matrix = new ColorMatrix();
        matrix.setSaturation(saturation + 1.0f);
        return matrix;
    }
    
    @NonNull
    public static ColorMatrix generateContrastMatrix(final float contrast) {
        final float scale = contrast + 1.0f;
        final float translate = (-0.5f * scale + 0.5f) * 255.0f;
        final float[] array = { scale, 0.0f, 0.0f, 0.0f, translate, 0.0f, scale, 0.0f, 0.0f, translate, 0.0f, 0.0f, scale, 0.0f, translate, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f };
        return new ColorMatrix(array);
    }
    
    @NonNull
    public static ColorMatrix generateBrightnessMatrix(final float brightness) {
        final float translate = brightness * 255.0f;
        final float[] array = { 1.0f, 0.0f, 0.0f, 0.0f, translate, 0.0f, 1.0f, 0.0f, 0.0f, translate, 0.0f, 0.0f, 1.0f, 0.0f, translate, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f };
        return new ColorMatrix(array);
    }
    
    @NonNull
    public static ColorMatrix generateOpacityMatrix(@FloatRange(from = 0.0, to = 1.0) final float opacity) {
        final float[] array = { 1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, opacity, 0.0f };
        return new ColorMatrix(array);
    }
}
