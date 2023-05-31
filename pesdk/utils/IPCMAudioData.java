// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import ly.img.android.pesdk.backend.model.chunk.Releasable;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0017\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J \u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\bH&J(\u0010\t\u001a\u00020\u00052\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH&¨\u0006\r" }, d2 = { "Lly/img/android/pesdk/utils/IPCMAudioData;", "Lly/img/android/pesdk/backend/model/chunk/Releasable;", "getBufferFillRate", "", "startIndex", "", "minIndex", "destinationSampleRate", "", "readData", "buffer", "", "destinationOutputChannelCount", "pesdk-backend-core_release" })
public interface IPCMAudioData extends Releasable
{
    long readData(@NotNull final short[] p0, final long p1, final int p2, final int p3);
    
    float getBufferFillRate(final long p0, final long p1, final int p2);
    
    @Metadata(mv = { 1, 6, 0 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        public static void close(@NotNull final IPCMAudioData this) {
            Releasable.DefaultImpls.close(this);
        }
    }
}
