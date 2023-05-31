// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android;

import ly.img.android.sdk.IMGLYConfig;
import androidx.annotation.Keep;

@Keep
public class PESDKInit
{
    @Keep
    public static String VERSION_NAME;
    
    @Keep
    private static void init() {
    }
    
    static {
        PESDKInit.VERSION_NAME = IMGLYConfig.versionName;
    }
}
