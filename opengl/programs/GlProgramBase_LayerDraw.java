// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.opengl.canvas.GlFragmentShader;
import ly.img.android.opengl.canvas.GlVertexShader;
import android.opengl.GLES20;
import ly.img.android.opengl.textures.GlTexture;
import ly.img.android.opengl.canvas.GlProgram;

public abstract class GlProgramBase_LayerDraw extends GlProgram
{
    private int u_backgroundImage_handle;
    private int u_alpha_handle;
    private int u_blendmode_handle;
    private int u_image_handle;
    
    public void setUniformBackgroundImage(final GlTexture u_backgroundImage) {
        if (this.u_backgroundImage_handle == -1) {
            this.u_backgroundImage_handle = this.getUniform("u_backgroundImage");
        }
        u_backgroundImage.bindTexture(this.u_backgroundImage_handle, 33984);
    }
    
    public void setUniformAlpha(final float u_alpha) {
        if (this.u_alpha_handle == -1) {
            this.u_alpha_handle = this.getUniform("u_alpha");
        }
        GLES20.glUniform1f(this.u_alpha_handle, u_alpha);
    }
    
    public void setUniformBlendmode(final int u_blendmode) {
        if (this.u_blendmode_handle == -1) {
            this.u_blendmode_handle = this.getUniform("u_blendmode");
        }
        GLES20.glUniform1i(this.u_blendmode_handle, u_blendmode);
    }
    
    public void setUniformImage(final GlTexture u_image) {
        if (this.u_image_handle == -1) {
            this.u_image_handle = this.getUniform("u_image");
        }
        u_image.bindTexture(this.u_image_handle, 33985);
    }
    
    @Override
    public void onHandlesInvalid() {
        this.u_backgroundImage_handle = -1;
        this.u_alpha_handle = -1;
        this.u_blendmode_handle = -1;
        this.u_image_handle = -1;
    }
    
    public GlProgramBase_LayerDraw() {
        super(new GlVertexShader("attribute vec4 a_position;\nattribute vec4 a_texCoord;\nattribute vec4 a_backgroundTexCoord;\n\nvarying vec2 v_texCoord;\nvarying vec2 v_backgroundTexCoord;\n\nvoid main() {\n    gl_Position = a_position;\n    v_texCoord = a_texCoord.xy;\n    v_backgroundTexCoord = a_backgroundTexCoord.xy;\n}"), new GlFragmentShader("precision mediump float;\n\nvarying vec2 v_texCoord;\nvarying vec2 v_backgroundTexCoord;\n\nuniform #INPUT_TYPE u_backgroundImage;\nuniform sampler2D u_image;\n\nuniform float u_alpha;\n\n/*\nALPHA: 0,\nOVERLAY: 1,\nHARD_LIGHT: 2,\nSOFT_LIGHT: 3,\nMULTIPLY: 4,\nDARKEN: 5,\nLIGHTEN: 6,\nSCREEN: 7,\nCOLOR_BURN: 8\n*/\nuniform int u_blendmode;\n\nconst float EPSILON = 0.000001;\n\n// https://en.wikipedia.org/wiki/Blend_modes\n\nvec4 overlay(vec4 a, vec4 b) {\n    vec3 result = mix(\n          1.0 - 2.0 * (1.0 - a.rgb) * (1.0 - b.rgb),\n          2.0 * a.rgb * b.rgb,\n          vec3(a.r < 0.5, a.g < 0.5, a.b < 0.5)\n      );\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 hardLight(vec4 b, vec4 a) {\n    vec3 result = mix(\n          1.0 - 2.0 * (1.0 - a.rgb) * (1.0 - b.rgb),\n          2.0 * a.rgb * b.rgb,\n          vec3(a.r < 0.5, a.g < 0.5, a.b < 0.5)\n      );\n    return mix(b, vec4(result, b.a), u_alpha * a.a);\n}\n\nvec4 softLight(vec4 a, vec4 b) {\n    vec3 result = mix(\n          2.0 * a.rgb * (1.0 - b.rgb) + (2.0 * b.rgb - 1.0) * sqrt(a.rgb),\n          2.0 * a.rgb * b.rgb + a.rgb * a.rgb * (1.0 - 2.0 * b.rgb),\n          vec3(b.r < 0.5, b.g < 0.5, b.b < 0.5)\n      );\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 multiply(vec4 a, vec4 b) {\n    vec3 result = a.rgb * b.rgb;\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 darken(vec4 a, vec4 b) {\n    vec3 result = min(a.rgb, b.rgb);\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 lighten(vec4 a, vec4 b) {\n    vec3 result = max(a.rgb, b.rgb);\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 screen(vec4 a, vec4 b) {\n    vec3 result = 1.0 - (1.0 - a.rgb) * (1.0 - b.rgb);\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 colorBurn(vec4 a, vec4 b) {\n    vec3 result = clamp(1.0 - (1.0 - a.rgb) / max(b.rgb, EPSILON), 0.0, 1.0);\n    return mix(a, vec4(result, a.a), u_alpha * b.a);\n}\n\nvec4 normal(vec4 a, vec4 b) {\n    return mix(a, vec4(b.rgb, a.a), u_alpha * b.a);\n}\n\nvoid main() {\n\n  vec4 backgroundColor = texture2D(u_backgroundImage, v_backgroundTexCoord);\n  vec4 layerColor      = texture2D(u_image, v_texCoord);\n\n  backgroundColor.rgb /= max(backgroundColor.a, EPSILON);\n  layerColor.rgb      /= max(layerColor.a, EPSILON);\n\n  vec4 resultColor;\n  if (u_blendmode == 0) {\n    resultColor = normal(backgroundColor, layerColor);\n  } else if (u_blendmode == 1) {\n    resultColor = overlay(backgroundColor, layerColor);\n  } else if (u_blendmode == 2) {\n    resultColor = hardLight(backgroundColor, layerColor);\n  } else if (u_blendmode == 3) {\n    resultColor = softLight(backgroundColor, layerColor);\n  } else if (u_blendmode == 4) {\n    resultColor = multiply(backgroundColor, layerColor);\n  } else if (u_blendmode == 5) {\n    resultColor = darken(backgroundColor, layerColor);\n  } else if (u_blendmode == 6) {\n    resultColor = lighten(backgroundColor, layerColor);\n  } else if (u_blendmode == 7) {\n    resultColor = screen(backgroundColor, layerColor);\n  } else if (u_blendmode == 8) {\n    resultColor = colorBurn(backgroundColor, layerColor);\n  }\n\n  gl_FragColor = vec4(vec3(resultColor.rgb * resultColor.a), resultColor.a);\n}"));
        this.u_backgroundImage_handle = -1;
        this.u_alpha_handle = -1;
        this.u_blendmode_handle = -1;
        this.u_image_handle = -1;
    }
}
