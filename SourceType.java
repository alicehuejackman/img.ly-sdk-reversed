// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android;

import androidx.annotation.WorkerThread;
import ly.img.android.pesdk.backend.decoder.VideoSource;
import ly.img.android.pesdk.backend.decoder.ImageSource;
import android.net.Uri;

public enum SourceType
{
    IMAGE, 
    VIDEO, 
    UNKNOWN;
    
    @WorkerThread
    public static SourceType detectTypeSafe(final Uri uri) {
        if (uri != null) {
            if (!ImageSource.create(uri).getSize().isZero()) {
                return SourceType.IMAGE;
            }
            final VideoSource.FormatInfo formatInfo = VideoSource.create(uri).fetchFormatInfo();
            if (formatInfo != null && !formatInfo.getSize().isZero()) {
                return SourceType.VIDEO;
            }
        }
        return SourceType.UNKNOWN;
    }
    
    private static /* synthetic */ SourceType[] $values() {
        return new SourceType[] { SourceType.IMAGE, SourceType.VIDEO, SourceType.UNKNOWN };
    }
    
    static {
        $VALUES = $values();
    }
}
