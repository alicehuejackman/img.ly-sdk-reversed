// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0003" }, d2 = { "Lly/img/android/opengl/programs/GlProgramBlitInAspect;", "Lly/img/android/opengl/programs/GlProgramBase_BlitInAspect;", "()V", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_BlitInAspect", vertexShaderCode = "\n        attribute vec4 a_position;\n        attribute vec4 a_texCoord;\n        \n        varying mediump vec2 v_texCoord;\n        \n        uniform float u_aspect;\n        \n        void main() {\n            gl_Position = a_position;\n            if (u_aspect > 1.0) {\n                gl_Position.x /= u_aspect;\n            } else {\n                gl_Position.y *= u_aspect;\n            }\n            v_texCoord = a_texCoord.xy;\n        }\n    ", fragmentShaderCode = "\n        precision mediump float;\n        \n        varying mediump vec2 v_texCoord;\n        uniform mediump #INPUT_TYPE u_image;\n        \n        void main() {\n            vec4 color = texture2D(u_image, v_texCoord);\n            gl_FragColor = color;\n        }\n    ")
public final class GlProgramBlitInAspect extends GlProgramBase_BlitInAspect
{
}
