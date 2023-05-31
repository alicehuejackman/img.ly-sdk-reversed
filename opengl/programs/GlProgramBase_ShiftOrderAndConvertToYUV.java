// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import ly.img.android.opengl.textures.GlTexture;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_ShiftOrderAndConvertToYUV extends GlProgram
{
    private int u_image_handle;
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33984);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.u_image_handle = -1;
    }
    
    public GlProgramBase_ShiftOrderAndConvertToYUV() {
        super(new GlVertexShader("attribute vec4 a_position;\nattribute vec4 a_texCoord;\n\nvarying highp vec2 v_texCoord;\n\nvoid main() {\n    gl_Position = a_position;\n    v_texCoord = a_texCoord.xy;\n}"), new GlFragmentShader("precision mediump float;\n\nuniform mediump #INPUT_TYPE u_image;\nvarying mediump vec2 v_texCoord;\n\n\nvec3 rgbToYUV(const vec3 rgbValue) {\n    return rgbValue * mat3(\n     0.299,     0.587,    0.114,\n    -0.16874,  -0.33126,  0.5,\n     0.5,      -0.41869, -0.08131\n    ) + vec3(0.0, 0.5, 0.5);\n}\n\nvoid main() {\n    // Shift order 90° and flip horizontal\n    vec2 newPos = vec2(v_texCoord.y, 1.0 - v_texCoord.x);\n    vec4 color = texture2D(u_image, newPos).rgba;\n    gl_FragColor.bgra = vec4(rgbToYUV(color.rgb), color.a);\n}"));
        this.u_image_handle = -1;
    }
}
