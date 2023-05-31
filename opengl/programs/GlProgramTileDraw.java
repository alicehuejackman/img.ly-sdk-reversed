// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.programs;

import ly.img.android.pesdk.annotations.gl.GlProgramCreate;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u0007" }, d2 = { "Lly/img/android/opengl/programs/GlProgramTileDraw;", "Lly/img/android/opengl/programs/GlProgramBase_TileDraw;", "()V", "setCutEdges", "", "enabled", "", "pesdk-backend-core_release" })
@WorkerThread
@GlProgramCreate(create = "GlProgramBase_TileDraw", vertexShaderCode = "\n        attribute highp vec4 a_position;\n        attribute highp vec4 a_texCoord;\n        \n        varying highp vec2 v_texCoord;\n        \n        void main() {\n            gl_Position = a_position;\n            v_texCoord = a_texCoord.xy;\n        }\n    ", fragmentShaderCode = "\n        precision highp float;\n\n        varying vec2 v_texCoord;\n        uniform #INPUT_TYPE u_image;\n        \n        uniform int u_cutEdged;\n        \n        void main() {\n            if (u_cutEdged == 1) {\n                vec4 color = texture2D(u_image, v_texCoord);\n                gl_FragColor = mix(\n                    color,\n                    vec4(0.,0.,0., 0.),\n                    float(\n                        v_texCoord.x < 0.0 || // Left\n                        v_texCoord.y < 0.0 || // Top\n                        v_texCoord.x > 1.0 || // Right\n                        v_texCoord.y > 1.0    // Bottom\n                    )\n                );\n            } else {\n                vec4 color = texture2D(u_image, v_texCoord);\n                gl_FragColor = color;\n            }\n        }\n    ")
public final class GlProgramTileDraw extends GlProgramBase_TileDraw
{
    public final void setCutEdges(final boolean enabled) {
        this.setUniformCutEdged(enabled ? 1 : 0);
    }
}
