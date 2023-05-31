// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import ly.img.android.opengl.textures.GlTexture;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_ConvertFromBGRA extends GlProgram
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
    
    public GlProgramBase_ConvertFromBGRA() {
        super(new GlVertexShader("attribute vec4 a_position;\nattribute vec4 a_texCoord;\n\nvarying highp vec2 v_texCoord;\n\nvoid main() {\n    gl_Position = a_position;\n    v_texCoord = a_texCoord.xy;\n}"), new GlFragmentShader("precision mediump float;\n\nuniform mediump #INPUT_TYPE u_image;\nvarying mediump vec2 v_texCoord;\n\nconst float EPSILON = 0.000001;\n\nvoid main() {\n    // Convert BGRA to RGBA\n    vec4 color = texture2D(u_image, vec2(v_texCoord.x, 1.0 - v_texCoord.y)).rgba;\n    gl_FragColor.bgra = vec4(color.rgb / max(color.a, EPSILON), color.a);\n}"));
        this.u_image_handle = -1;
    }
}
