// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import androidx.annotation.Size;
import android.opengl.GLES20;
import ly.img.android.opengl.textures.GlTexture;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_CropMask extends GlProgram
{
    private int u_image_handle;
    private int u_gradientSize_handle;
    private int u_size_handle;
    private int u_startPosition_handle;
    private int u_texSize_handle;
    private int u_bgColor_handle;
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33984);
    }
    
    public void setUniformGradientSize(final float u_gradientSize) {
        this.setUniformGradientSizeRawData(this.convertRelative(u_gradientSize));
    }
    
    public void setUniformGradientSizeRawData(final float u_gradientSize) {
        if (this.u_gradientSize_handle == -1) {
            this.u_gradientSize_handle = this.getUniform("u_gradientSize");
        }
        GLES20.glUniform1f(this.u_gradientSize_handle, u_gradientSize);
    }
    
    public void setUniformSize(final float u_size) {
        this.setUniformSizeRawData(this.convertRelative(u_size));
    }
    
    public void setUniformSizeRawData(final float u_size) {
        if (this.u_size_handle == -1) {
            this.u_size_handle = this.getUniform("u_size");
        }
        GLES20.glUniform1f(this.u_size_handle, u_size);
    }
    
    public void setUniformStartPosition(final float u_startPositionX, final float u_startPositionY) {
        this.setUniformStartPositionRawData(this.convertRelative(u_startPositionX, u_startPositionY));
    }
    
    public void setUniformStartPositionRawData(final float u_startPositionX, final float u_startPositionY) {
        if (this.u_startPosition_handle == -1) {
            this.u_startPosition_handle = this.getUniform("u_startPosition");
        }
        GLES20.glUniform2f(this.u_startPosition_handle, u_startPositionX, u_startPositionY);
    }
    
    public void setUniformStartPositionRawData(@Size(2L) final float[] u_startPosition) {
        if (this.u_startPosition_handle == -1) {
            this.u_startPosition_handle = this.getUniform("u_startPosition");
        }
        GLES20.glUniform2fv(this.u_startPosition_handle, 1, u_startPosition, 0);
    }
    
    public void setUniformTexSize(final float u_texSizeX, final float u_texSizeY) {
        if (this.u_texSize_handle == -1) {
            this.u_texSize_handle = this.getUniform("u_texSize");
        }
        GLES20.glUniform2f(this.u_texSize_handle, u_texSizeX, u_texSizeY);
    }
    
    public void setUniformTexSize(@Size(2L) final float[] u_texSize) {
        if (this.u_texSize_handle == -1) {
            this.u_texSize_handle = this.getUniform("u_texSize");
        }
        GLES20.glUniform2fv(this.u_texSize_handle, 1, u_texSize, 0);
    }
    
    public void setUniformBgColor(final float u_bgColorX, final float u_bgColorY, final float u_bgColorZ, final float u_bgColorW) {
        if (this.u_bgColor_handle == -1) {
            this.u_bgColor_handle = this.getUniform("u_bgColor");
        }
        GLES20.glUniform4f(this.u_bgColor_handle, u_bgColorX, u_bgColorY, u_bgColorZ, u_bgColorW);
    }
    
    public void setUniformBgColor(@Size(4L) final float[] u_bgColor) {
        if (this.u_bgColor_handle == -1) {
            this.u_bgColor_handle = this.getUniform("u_bgColor");
        }
        GLES20.glUniform4fv(this.u_bgColor_handle, 1, u_bgColor, 0);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.u_image_handle = -1;
        this.u_gradientSize_handle = -1;
        this.u_size_handle = -1;
        this.u_startPosition_handle = -1;
        this.u_texSize_handle = -1;
        this.u_bgColor_handle = -1;
    }
    
    public GlProgramBase_CropMask() {
        super(new GlVertexShader("attribute vec4 a_position;\nattribute vec4 a_texCoord;\n\nvarying highp vec2 v_texCoord;\n\nvoid main() {\n    gl_Position = a_position;\n    v_texCoord = a_texCoord.xy;\n}"), new GlFragmentShader("precision highp float;\n\nvarying vec2 v_texCoord;\n\nuniform #INPUT_TYPE u_image;\n\nuniform #RELATIVE float u_gradientSize;\nuniform #RELATIVE float u_size;\nuniform #RELATIVE vec2 u_startPosition;\n\nuniform vec4 u_bgColor;\nuniform vec2 u_texSize;\n\n\nvoid main() {\n\n    vec4 color = texture2D(u_image, v_texCoord);\n    float aspect = u_texSize.x / u_texSize.y;\n\n    vec2 diff = v_texCoord - vec2(u_startPosition.x, 1.0 - u_startPosition.y);\n    diff.y /= aspect;\n\n    float pointDistance = sqrt(diff.x * diff.x + diff.y * diff.y);\n\n    float radius = smoothstep(\n        0.0,\n        1.0,\n        (abs(pointDistance) - u_size) / u_gradientSize\n    );\n\n    radius = 1.0 - radius;\n    vec4 resultColor = vec4(mix(u_bgColor.r * u_bgColor.a, color.r, radius),mix(u_bgColor.g * u_bgColor.a, color.g, radius),mix(u_bgColor.b * u_bgColor.a, color.b, radius),mix(u_bgColor.a * u_bgColor.a, color.a, radius));\n\n    gl_FragColor = clamp(resultColor, 0.0, 1.0);\n}"));
        this.u_image_handle = -1;
        this.u_gradientSize_handle = -1;
        this.u_size_handle = -1;
        this.u_startPosition_handle = -1;
        this.u_texSize_handle = -1;
        this.u_bgColor_handle = -1;
    }
}
