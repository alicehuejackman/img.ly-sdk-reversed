// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import android.graphics.Bitmap;
import ly.img.android.pesdk.utils.BitmapFactoryUtils;
import ly.img.android.R$drawable;
import ly.img.android.PESDK;
import ly.img.android.opengl.textures.GlImageTexture;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.opengl.textures.GlTexture;
import org.jetbrains.annotations.NotNull;
import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0005\u001a\u00020\u0006J\b\u0010\u0007\u001a\u00020\u0006H\u0014J\u0010\u0010\b\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\u0004H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b" }, d2 = { "Lly/img/android/opengl/programs/GlProgramJPEG;", "Lly/img/android/opengl/programs/GlProgramBase_JPEG;", "()V", "quantisationLut", "Lly/img/android/opengl/textures/GlTexture;", "init", "", "onRelease", "setUniformImage", "u_image", "Companion", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_JPEG", vertexShaderCode = "\n        attribute vec4 a_position;\n        \n        void main() {\n            gl_Position = a_position;\n        }\n    ", fragmentShaderCode = "\n        precision highp float;\n        precision highp int;\n        \n        uniform int quality; // 1 to 100\n        uniform float aanScaleFactor[8];\n        \n        uniform sampler2D quantisationLut;\n        \n        uniform sampler2D u_image;\n        uniform vec2 u_resolution;\n        \n        const int NB_FREQ = 8;\n        const float NB_FREQ_f = 8.0;\n        const float PI = 3.1415972;\n        const float SQRT2 = 0.70710678118;\n        const float COLOR_PRECISION = 255.0;\n        \n        float calculatDctCoefficient(const vec2 index2D, const vec2 referanceBlockCoord) {\n            return cos(PI * index2D.x * referanceBlockCoord.x)\n                 * cos(PI * index2D.y * referanceBlockCoord.y)\n                 * (index2D.x < 1.0 ? SQRT2 : 1.0)\n                 * (index2D.y < 1.0 ? SQRT2 : 1.0);\n        }\n        \n        vec3 rgbToYUV(const vec3 rgbValue) {\n            return rgbValue * mat3(\n                 0.299,  0.587,  0.114,\n                -0.169, -0.331,  0.5,\n                 0.5,   -0.419, -0.091\n            ) + vec3(0.0, 0.5, 0.5);\n        }\n        \n        vec3 quantification(vec3 value, vec3 divisor) {\n            return floor(value / divisor + 0.5) * (divisor);\n        }\n        \n        float scaleFactor(vec2 index2D) {\n            return aanScaleFactor[int(index2D.x)] * aanScaleFactor[int(index2D.y)];\n        }\n        \n        vec2 quantumLUT(vec2 index2D) {\n            vec2 lutValue = texture2D(quantisationLut, index2D / vec2(16.0, 16.0)).rg;\n            return floor(lutValue.rg * COLOR_PRECISION + 0.5);\n        }\n        \n        void main() {\n            vec2 coord = vec2(floor(gl_FragCoord.xy));\n            vec2 innerBlockCoord = mod(coord, NB_FREQ_f);\n            vec2 blockCoord = coord - (innerBlockCoord);\n        \n            vec3 dctValue = vec3(0.0);\n        \n            // TODO: For better performance try to use 1D-DCT: https://unix4lyfe.org/dct/\n            // Converting a 8x8 block into frequency with discrete cosine transformation.\n            for (lowp int x = 0; x < NB_FREQ; x++) for (lowp int y = 0; y < NB_FREQ; y++) {\n                vec2 index2D = vec2(x, y) + 0.5;\n                vec2 textureCord = (blockCoord + index2D) / u_resolution.xy;\n                     textureCord.y = 1.0 - textureCord.y;\n                vec3 rgbValue = texture2D(u_image, textureCord).rgb;\n                vec3 yuvValue = rgbToYUV(rgbValue);\n                float coefficient = calculatDctCoefficient(innerBlockCoord, index2D / NB_FREQ_f);\n                dctValue += yuvValue * coefficient;\n            }\n        \n            vec3 frequency = dctValue / 4.0;\n        \n            // frequency discretized quantification step.\n            float qualityFactor = float((quality < 50) ? (5000 / quality) : (200 - quality * 2));\n            float scaleFactor = scaleFactor(innerBlockCoord) / NB_FREQ_f;\n            vec2 quantumValue = clamp((quantumLUT(innerBlockCoord) * qualityFactor + 50.0) / 100.0, 1.0, COLOR_PRECISION);\n            vec2 quantizeDivisors = (scaleFactor * quantumValue) / COLOR_PRECISION;\n        \n            frequency = quantification(\n                frequency,\n                quantizeDivisors.xyy\n            );\n        \n            gl_FragColor = vec4(frequency.rrr, 1.0);\n        }\n    ")
public final class GlProgramJPEG extends GlProgramBase_JPEG
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final GlTexture quantisationLut;
    @NotNull
    private static final float[] AAN_SCALE_FACTOR;
    
    public GlProgramJPEG() {
        this.quantisationLut = GlProgramJPEG.Companion.loadLut();
    }
    
    @Override
    protected void onRelease() {
        this.quantisationLut.releaseGlContext();
    }
    
    @Override
    public void setUniformImage(@NotNull final GlTexture u_image) {
        Intrinsics.checkNotNullParameter((Object)u_image, "u_image");
        super.setUniformImage(u_image);
        this.setUniformResolution((float)u_image.getWidth(), (float)u_image.getHeight());
    }
    
    public final void init() {
        this.setQuantisationLut(this.quantisationLut);
        this.setAanScaleFactor(GlProgramJPEG.AAN_SCALE_FACTOR);
    }
    
    static {
        Companion = new Companion(null);
        AAN_SCALE_FACTOR = new float[] { 1.0f, 1.3870399f, 1.306563f, 1.1758755f, 1.0f, 0.78569496f, 0.5411961f, 0.27589938f };
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\u0005\u001a\u00020\u0006H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lly/img/android/opengl/programs/GlProgramJPEG$Companion;", "", "()V", "AAN_SCALE_FACTOR", "", "loadLut", "Lly/img/android/opengl/textures/GlTexture;", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        private final GlTexture loadLut() {
            final GlImageTexture texture = new GlImageTexture();
            texture.setBehave(9728, 33071);
            final GlImageTexture glImageTexture = texture;
            final Bitmap decodeResource = BitmapFactoryUtils.decodeResource(PESDK.getAppResource(), R$drawable.imgly_dct_table_lut);
            Intrinsics.checkNotNullExpressionValue((Object)decodeResource, "decodeResource(PESDK.get\u2026able.imgly_dct_table_lut)");
            glImageTexture.setBitmap(decodeResource);
            return texture;
        }
    }
}
