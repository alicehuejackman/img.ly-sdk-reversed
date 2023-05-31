// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import android.opengl.GLES20;
import ly.img.android.opengl.textures.GlTexture;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_TileDraw extends GlProgram
{
    private int u_image_handle;
    private int u_cutEdged_handle;
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33984);
    }
    
    public void setUniformCutEdged(final int u_cutEdged) {
        if (this.u_cutEdged_handle == -1) {
            this.u_cutEdged_handle = this.getUniform("u_cutEdged");
        }
        GLES20.glUniform1i(this.u_cutEdged_handle, u_cutEdged);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.u_image_handle = -1;
        this.u_cutEdged_handle = -1;
    }
    
    public GlProgramBase_TileDraw() {
        super(new GlVertexShader("attribute highp vec4 a_position;\nattribute highp vec4 a_texCoord;\n\nvarying highp vec2 v_texCoord;\n\nvoid main() {\n    gl_Position = a_position;\n    v_texCoord = a_texCoord.xy;\n}"), new GlFragmentShader("precision highp float;\n\nvarying vec2 v_texCoord;\nuniform #INPUT_TYPE u_image;\n\nuniform int u_cutEdged;\n\nvoid main() {\n    if (u_cutEdged == 1) {\n        vec4 color = texture2D(u_image, v_texCoord);\n        gl_FragColor = mix(\n            color,\n            vec4(0.,0.,0., 0.),\n            float(\n                v_texCoord.x < 0.0 || // Left\n                v_texCoord.y < 0.0 || // Top\n                v_texCoord.x > 1.0 || // Right\n                v_texCoord.y > 1.0    // Bottom\n            )\n        );\n    } else {\n        vec4 color = texture2D(u_image, v_texCoord);\n        gl_FragColor = color;\n    }\n}"));
        this.u_image_handle = -1;
        this.u_cutEdged_handle = -1;
    }
}
