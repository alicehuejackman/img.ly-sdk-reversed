// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl;

import ly.img.android.pesdk.utils.Trace;
import androidx.annotation.Nullable;
import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.egl.EGLDisplay;
import javax.microedition.khronos.egl.EGL10;
import androidx.annotation.NonNull;
import ly.img.android.opengl.egl.EGLConfigChooser;

public class ConfigChooser implements EGLConfigChooser
{
    private static final boolean USE_RGB_8888 = true;
    private static final int EGL_OPENGL_ES2_BIT = 4;
    private static final int EGL_RECORDABLE_ANDROID = 12610;
    @NonNull
    private final int[] configSpec;
    private final int redSize;
    private final int greenSize;
    private final int blueSize;
    private final int alphaSize;
    private final int depthSize;
    private final int stencilSize;
    
    public ConfigChooser(final boolean withDepthBuffer, final int version) {
        this(8, 8, 8, 8, withDepthBuffer ? 16 : 0, 0, version);
    }
    
    public ConfigChooser(final int redSize, final int greenSize, final int blueSize, final int alphaSize, final int depthSize, final int stencilSize, final int version) {
        this.configSpec = this.filterConfigSpec(version, 12324, redSize, 12323, greenSize, 12322, blueSize, 12321, alphaSize, 12325, depthSize, 12326, stencilSize, 12344);
        this.redSize = redSize;
        this.greenSize = greenSize;
        this.blueSize = blueSize;
        this.alphaSize = alphaSize;
        this.depthSize = depthSize;
        this.stencilSize = stencilSize;
    }
    
    @NonNull
    private int[] filterConfigSpec(final int version, @NonNull final int... configSpec) {
        if (version != 2) {
            return configSpec;
        }
        final int len = configSpec.length - 1;
        final int[] newConfigSpec = new int[len + 5];
        System.arraycopy(configSpec, 0, newConfigSpec, 0, len);
        newConfigSpec[len] = 12352;
        newConfigSpec[len + 1] = 4;
        newConfigSpec[len + 2] = 12610;
        newConfigSpec[len + 3] = 1;
        newConfigSpec[len + 4] = 12344;
        return newConfigSpec;
    }
    
    @Nullable
    @Override
    public EGLConfig chooseConfig(@NonNull final EGL10 egl, final EGLDisplay display) {
        final int[] num_config = { 0 };
        if (!egl.eglChooseConfig(display, this.configSpec, (EGLConfig[])null, 0, num_config)) {
            throw new IllegalArgumentException("eglChooseConfig failed");
        }
        final int config_size = num_config[0];
        if (config_size <= 0) {
            throw new IllegalArgumentException("No configs match configSpec");
        }
        final EGLConfig[] configs = new EGLConfig[config_size];
        if (!egl.eglChooseConfig(display, this.configSpec, configs, config_size, num_config)) {
            throw new IllegalArgumentException("eglChooseConfig#2 failed");
        }
        final EGLConfig config = this.chooseConfig(egl, display, configs);
        if (config == null) {
            throw new IllegalArgumentException("No config chosen");
        }
        return config;
    }
    
    @Nullable
    private EGLConfig chooseConfig(@NonNull final EGL10 egl, final EGLDisplay display, @NonNull final EGLConfig[] configs) {
        for (final EGLConfig config : configs) {
            final int d = this.findConfigAttribute(egl, display, config, 12325, 0);
            final int s = this.findConfigAttribute(egl, display, config, 12326, 0);
            if (d >= this.depthSize && s >= this.stencilSize) {
                final int r = this.findConfigAttribute(egl, display, config, 12324, 0);
                final int g = this.findConfigAttribute(egl, display, config, 12323, 0);
                final int b = this.findConfigAttribute(egl, display, config, 12322, 0);
                final int a = this.findConfigAttribute(egl, display, config, 12321, 0);
                if (r == this.redSize && g == this.greenSize && b == this.blueSize && a == this.alphaSize) {
                    return config;
                }
            }
        }
        Trace.out("EGL", "config is null");
        return null;
    }
    
    private int findConfigAttribute(@NonNull final EGL10 egl, final EGLDisplay display, final EGLConfig config, final int attribute, final int defaultValue) {
        final int[] value = { 0 };
        return egl.eglGetConfigAttrib(display, config, attribute, value) ? value[0] : defaultValue;
    }
}
