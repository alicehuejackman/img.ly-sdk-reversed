// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import android.graphics.Color;
import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007" }, d2 = { "Lly/img/android/opengl/programs/GlProgramCropMask;", "Lly/img/android/opengl/programs/GlProgramBase_CropMask;", "()V", "setUniformBgColor", "", "color", "", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_CropMask", vertexShaderCode = "\n        attribute vec4 a_position;\n        attribute vec4 a_texCoord;\n        \n        varying highp vec2 v_texCoord;\n        \n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord.xy;\n        }\n    ", fragmentShaderCode = "\n        precision highp float;\n        \n        varying vec2 v_texCoord;\n        \n        uniform #INPUT_TYPE u_image;\n        \n        uniform #RELATIVE float u_gradientSize;\n        uniform #RELATIVE float u_size;\n        uniform #RELATIVE vec2 u_startPosition;\n        \n        uniform vec4 u_bgColor;\n        uniform vec2 u_texSize;\n        \n        \n        void main() {\n        \n            vec4 color = texture2D(u_image, v_texCoord);\n            float aspect = u_texSize.x / u_texSize.y;\n        \n            vec2 diff = v_texCoord - vec2(u_startPosition.x, 1.0 - u_startPosition.y);\n            diff.y /= aspect;\n        \n            float pointDistance = sqrt(diff.x * diff.x + diff.y * diff.y);\n        \n            float radius = smoothstep(\n                0.0,\n                1.0,\n                (abs(pointDistance) - u_size) / u_gradientSize\n            );\n        \n            radius = 1.0 - radius;\n            vec4 resultColor = vec4(mix(u_bgColor.r * u_bgColor.a, color.r, radius),mix(u_bgColor.g * u_bgColor.a, color.g, radius),mix(u_bgColor.b * u_bgColor.a, color.b, radius),mix(u_bgColor.a * u_bgColor.a, color.a, radius));\n        \n            gl_FragColor = clamp(resultColor, 0.0, 1.0);\n        }\n    ")
public final class GlProgramCropMask extends GlProgramBase_CropMask
{
    public final void setUniformBgColor(final int color) {
        super.setUniformBgColor(Color.red(color) / 255.0f, Color.green(color) / 255.0f, Color.blue(color) / 255.0f, Color.alpha(color) / 255.0f);
    }
}
