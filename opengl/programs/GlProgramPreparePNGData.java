// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lly/img/android/opengl/programs/GlProgramPreparePNGData;", "Lly/img/android/opengl/programs/GlProgramBase_ConvertFromBGRA;", "()V", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_ConvertFromBGRA", vertexShaderCode = "\n        attribute vec4 a_position;\n        attribute vec4 a_texCoord;\n        \n        varying highp vec2 v_texCoord;\n        \n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord.xy;\n        }\n    ", fragmentShaderCode = "\n        precision mediump float;\n        \n        uniform mediump #INPUT_TYPE u_image;\n        varying mediump vec2 v_texCoord;\n        \n        const float EPSILON = 0.000001;\n        \n        void main() {\n            // Convert BGRA to RGBA\n            vec4 color = texture2D(u_image, vec2(v_texCoord.x, 1.0 - v_texCoord.y)).rgba;\n            gl_FragColor.bgra = vec4(color.rgb / max(color.a, EPSILON), color.a);\n        }\n    ")
public final class GlProgramPreparePNGData extends GlProgramBase_ConvertFromBGRA
{
}
