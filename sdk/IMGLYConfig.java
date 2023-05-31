// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.sdk;

import kotlin.jvm.JvmField;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0010\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\u0002\n\u0000¨\u0006\u0007" }, d2 = { "Lly/img/android/sdk/IMGLYConfig;", "", "()V", "pesdkLicensePath", "", "versionName", "vesdkLicensePath", "pesdk-backend-core_release" })
public final class IMGLYConfig
{
    @NotNull
    public static final IMGLYConfig INSTANCE;
    @JvmField
    @NotNull
    public static final String versionName;
    @JvmField
    @NotNull
    public static final String pesdkLicensePath;
    @JvmField
    @NotNull
    public static final String vesdkLicensePath;
    
    private IMGLYConfig() {
    }
    
    static {
        INSTANCE = new IMGLYConfig();
        try {
            versionName = _IMGLYInternalConfig_.versionName;
            pesdkLicensePath = _IMGLYInternalConfig_.pesdkLicensePath;
            vesdkLicensePath = _IMGLYInternalConfig_.vesdkLicensePath;
        }
        catch (NoClassDefFoundError error) {
            throw new RuntimeException("\u250c\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2510\n\u2502 SDK cannot find the final configuration. This could be the result of a misconfiguration. \u2502\n\u2502 Choose one of the following configurations to fix it.                                    \u2502   \n\u2502                                                                                          \u2502   \n\u2502  1. If you have fully integrated the SDK into a library module,                          \u2502 \n\u2502     set finalModule = true in your modules imglyConfig block.                            \u2502\n\u2502                                                                                          \u2502   \n\u2502  2. Include the IMG.LY Gradle Plugin and imglyConfig in your application module as well. \u2502\n\u2502                                                                                          \u2502\n\u2502 If this issue persists,                                                                  \u2502\n\u2502 please contact Support with information about your project structure.                    \u2502\n\u2514\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2500\u2518");
        }
    }
}
