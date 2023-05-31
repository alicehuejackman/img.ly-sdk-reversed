// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import ly.img.android.opengl.textures.GlTexture;
import android.opengl.GLES20;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_BlitInAspect extends GlProgram
{
    private int u_aspect_handle;
    private int u_image_handle;
    
    public void setUniformAspect(final float u_aspect) {
        if (this.u_aspect_handle == -1) {
            this.u_aspect_handle = this.getUniform("u_aspect");
        }
        GLES20.glUniform1f(this.u_aspect_handle, u_aspect);
    }
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33984);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.u_aspect_handle = -1;
        this.u_image_handle = -1;
    }
    
    public GlProgramBase_BlitInAspect() {
        super(new GlVertexShader("attribute vec4 a_position;\nattribute vec4 a_texCoord;\n\nvarying mediump vec2 v_texCoord;\n\nuniform float u_aspect;\n\nvoid main() {\n    gl_Position = a_position;\n    if (u_aspect > 1.0) {\n        gl_Position.x /= u_aspect;\n    } else {\n        gl_Position.y *= u_aspect;\n    }\n    v_texCoord = a_texCoord.xy;\n}"), new GlFragmentShader("precision mediump float;\n\nvarying mediump vec2 v_texCoord;\nuniform mediump #INPUT_TYPE u_image;\n\nvoid main() {\n    vec4 color = texture2D(u_image, v_texCoord);\n    gl_FragColor = color;\n}"));
        this.u_aspect_handle = -1;
        this.u_image_handle = -1;
    }
}
