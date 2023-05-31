// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import ly.img.android.opengl.textures.GlTexture;
import android.opengl.GLES20;
import androidx.annotation.Size;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_JPEG extends GlProgram
{
    private int aanScaleFactor_handle;
    private int quality_handle;
    private int quantisationLut_handle;
    private int u_image_handle;
    private int u_resolution_handle;
    
    public void setAanScaleFactor(@Size(8L) final float[] aanScaleFactor) {
        if (this.aanScaleFactor_handle == -1) {
            this.aanScaleFactor_handle = this.getUniform("aanScaleFactor");
        }
        GLES20.glUniform1fv(this.aanScaleFactor_handle, 8, aanScaleFactor, 0);
    }
    
    public void setQuality(final int quality) {
        if (this.quality_handle == -1) {
            this.quality_handle = this.getUniform("quality");
        }
        GLES20.glUniform1i(this.quality_handle, quality);
    }
    
    public void setQuantisationLut(final GlTexture quantisationLut) {
        if (this.quantisationLut_handle == -1) {
            this.quantisationLut_handle = this.getUniform("quantisationLut");
        }
        quantisationLut.bindTexture(this.quantisationLut_handle, 33984);
    }
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33985);
    }
    
    public void setUniformResolution(final float u_resolutionX, final float u_resolutionY) {
        if (this.u_resolution_handle == -1) {
            this.u_resolution_handle = this.getUniform("u_resolution");
        }
        GLES20.glUniform2f(this.u_resolution_handle, u_resolutionX, u_resolutionY);
    }
    
    public void setUniformResolution(@Size(2L) final float[] u_resolution) {
        if (this.u_resolution_handle == -1) {
            this.u_resolution_handle = this.getUniform("u_resolution");
        }
        GLES20.glUniform2fv(this.u_resolution_handle, 1, u_resolution, 0);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.aanScaleFactor_handle = -1;
        this.quality_handle = -1;
        this.quantisationLut_handle = -1;
        this.u_image_handle = -1;
        this.u_resolution_handle = -1;
    }
    
    public GlProgramBase_JPEG() {
        super(new GlVertexShader("attribute vec4 a_position;\n\nvoid main() {\n    gl_Position = a_position;\n}"), new GlFragmentShader("precision highp float;\nprecision highp int;\n\nuniform int quality; // 1 to 100\nuniform float aanScaleFactor[8];\n\nuniform sampler2D quantisationLut;\n\nuniform sampler2D u_image;\nuniform vec2 u_resolution;\n\nconst int NB_FREQ = 8;\nconst float NB_FREQ_f = 8.0;\nconst float PI = 3.1415972;\nconst float SQRT2 = 0.70710678118;\nconst float COLOR_PRECISION = 255.0;\n\nfloat calculatDctCoefficient(const vec2 index2D, const vec2 referanceBlockCoord) {\n    return cos(PI * index2D.x * referanceBlockCoord.x)\n         * cos(PI * index2D.y * referanceBlockCoord.y)\n         * (index2D.x < 1.0 ? SQRT2 : 1.0)\n         * (index2D.y < 1.0 ? SQRT2 : 1.0);\n}\n\nvec3 rgbToYUV(const vec3 rgbValue) {\n    return rgbValue * mat3(\n         0.299,  0.587,  0.114,\n        -0.169, -0.331,  0.5,\n         0.5,   -0.419, -0.091\n    ) + vec3(0.0, 0.5, 0.5);\n}\n\nvec3 quantification(vec3 value, vec3 divisor) {\n    return floor(value / divisor + 0.5) * (divisor);\n}\n\nfloat scaleFactor(vec2 index2D) {\n    return aanScaleFactor[int(index2D.x)] * aanScaleFactor[int(index2D.y)];\n}\n\nvec2 quantumLUT(vec2 index2D) {\n    vec2 lutValue = texture2D(quantisationLut, index2D / vec2(16.0, 16.0)).rg;\n    return floor(lutValue.rg * COLOR_PRECISION + 0.5);\n}\n\nvoid main() {\n    vec2 coord = vec2(floor(gl_FragCoord.xy));\n    vec2 innerBlockCoord = mod(coord, NB_FREQ_f);\n    vec2 blockCoord = coord - (innerBlockCoord);\n\n    vec3 dctValue = vec3(0.0);\n\n    // TODO: For better performance try to use 1D-DCT: https://unix4lyfe.org/dct/\n    // Converting a 8x8 block into frequency with discrete cosine transformation.\n    for (lowp int x = 0; x < NB_FREQ; x++) for (lowp int y = 0; y < NB_FREQ; y++) {\n        vec2 index2D = vec2(x, y) + 0.5;\n        vec2 textureCord = (blockCoord + index2D) / u_resolution.xy;\n             textureCord.y = 1.0 - textureCord.y;\n        vec3 rgbValue = texture2D(u_image, textureCord).rgb;\n        vec3 yuvValue = rgbToYUV(rgbValue);\n        float coefficient = calculatDctCoefficient(innerBlockCoord, index2D / NB_FREQ_f);\n        dctValue += yuvValue * coefficient;\n    }\n\n    vec3 frequency = dctValue / 4.0;\n\n    // frequency discretized quantification step.\n    float qualityFactor = float((quality < 50) ? (5000 / quality) : (200 - quality * 2));\n    float scaleFactor = scaleFactor(innerBlockCoord) / NB_FREQ_f;\n    vec2 quantumValue = clamp((quantumLUT(innerBlockCoord) * qualityFactor + 50.0) / 100.0, 1.0, COLOR_PRECISION);\n    vec2 quantizeDivisors = (scaleFactor * quantumValue) / COLOR_PRECISION;\n\n    frequency = quantification(\n        frequency,\n        quantizeDivisors.xyy\n    );\n\n    gl_FragColor = vec4(frequency.rrr, 1.0);\n}"));
        this.aanScaleFactor_handle = -1;
        this.quality_handle = -1;
        this.quantisationLut_handle = -1;
        this.u_image_handle = -1;
        this.u_resolution_handle = -1;
    }
}
