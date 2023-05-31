// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.io.IOException;
import java.io.InputStream;
import java.io.FilterInputStream;

public class FlushedInputStream extends FilterInputStream
{
    public FlushedInputStream(final InputStream inputStream) {
        super(inputStream);
    }
    
    @Override
    public long skip(final long n) throws IOException {
        long totalBytesSkipped;
        long bytesSkipped;
        for (totalBytesSkipped = 0L; totalBytesSkipped < n; totalBytesSkipped += bytesSkipped) {
            bytesSkipped = this.in.skip(n - totalBytesSkipped);
            if (bytesSkipped == 0L) {
                final int bytesRead = this.read();
                if (bytesRead < 0) {
                    break;
                }
                bytesSkipped = 1L;
            }
        }
        return totalBytesSkipped;
    }
}
