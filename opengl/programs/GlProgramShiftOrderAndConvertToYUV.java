// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lly/img/android/opengl/programs/GlProgramShiftOrderAndConvertToYUV;", "Lly/img/android/opengl/programs/GlProgramBase_ShiftOrderAndConvertToYUV;", "()V", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_ShiftOrderAndConvertToYUV", vertexShaderCode = "\n        attribute vec4 a_position;\n        attribute vec4 a_texCoord;\n        \n        varying highp vec2 v_texCoord;\n        \n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord.xy;\n        }\n    ", fragmentShaderCode = "\n        precision mediump float;\n        \n        uniform mediump #INPUT_TYPE u_image;\n        varying mediump vec2 v_texCoord;\n        \n        \n        vec3 rgbToYUV(const vec3 rgbValue) {\n            return rgbValue * mat3(\n             0.299,     0.587,    0.114,\n            -0.16874,  -0.33126,  0.5,\n             0.5,      -0.41869, -0.08131\n            ) + vec3(0.0, 0.5, 0.5);\n        }\n        \n        void main() {\n            // Shift order 90° and flip horizontal\n            vec2 newPos = vec2(v_texCoord.y, 1.0 - v_texCoord.x);\n            vec4 color = texture2D(u_image, newPos).rgba;\n            gl_FragColor.bgra = vec4(rgbToYUV(color.rgb), color.a);\n        }\n    ")
public final class GlProgramShiftOrderAndConvertToYUV extends GlProgramBase_ShiftOrderAndConvertToYUV
{
}
