// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import androidx.annotation.NonNull;
import ly.img.android.pesdk.utils.Trace;
import android.opengl.GLES20;

public final class EGLLogWrapper
{
    public static void readGlError() {
        final int error = GLES20.glGetError();
        if (error != 0) {
            Trace.out("PESDK", "GlError: " + getErrorString(error), Trace.stackAll());
        }
    }
    
    @NonNull
    public static String getErrorString(final int error) {
        switch (error) {
            case 1280: {
                return "GL_INVALID_ENUM";
            }
            case 1281: {
                return "GL_INVALID_VALUE";
            }
            case 1282: {
                return "GL_INVALID_OPERATION";
            }
            case 1283: {
                return "GL_STACK_OVERFLOW";
            }
            case 1284: {
                return "GL_STACK_UNDERFLOW";
            }
            case 1285: {
                return "GL_OUT_OF_MEMORY";
            }
            case 1286: {
                return "GL_INVALID_FRAMEBUFFER_OPERATION";
            }
            case 1287: {
                return "GL_CONTEXT_LOST";
            }
            case 12288: {
                return "EGL_SUCCESS";
            }
            case 12289: {
                return "EGL_NOT_INITIALIZED";
            }
            case 12290: {
                return "EGL_BAD_ACCESS";
            }
            case 12291: {
                return "EGL_BAD_ALLOC";
            }
            case 12292: {
                return "EGL_BAD_ATTRIBUTE";
            }
            case 12293: {
                return "EGL_BAD_CONFIG";
            }
            case 12294: {
                return "EGL_BAD_CONTEXT";
            }
            case 12295: {
                return "EGL_BAD_CURRENT_SURFACE";
            }
            case 12296: {
                return "EGL_BAD_DISPLAY";
            }
            case 12297: {
                return "EGL_BAD_MATCH";
            }
            case 12298: {
                return "EGL_BAD_NATIVE_PIXMAP";
            }
            case 12299: {
                return "EGL_BAD_NATIVE_WINDOW";
            }
            case 12300: {
                return "EGL_BAD_PARAMETER";
            }
            case 12301: {
                return "EGL_BAD_SURFACE";
            }
            case 12302: {
                return "EGL_CONTEXT_LOST";
            }
            default: {
                return getHex(error);
            }
        }
    }
    
    @NonNull
    private static String getHex(final int value) {
        return "0x" + Integer.toHexString(value);
    }
}
