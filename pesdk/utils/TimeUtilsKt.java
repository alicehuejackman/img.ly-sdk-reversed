// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u0014\n\u0000\n\u0002\u0010\t\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004\u001a\u001a\u0010\u0000\u001a\u00020\u0001*\u00020\u00012\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004¨\u0006\u0006" }, d2 = { "convert", "", "", "from", "Ljava/util/concurrent/TimeUnit;", "to", "pesdk-backend-core_release" })
public final class TimeUtilsKt
{
    public static final long convert(final int $this$convert, @NotNull final TimeUnit from, @NotNull final TimeUnit to) {
        Intrinsics.checkNotNullParameter((Object)from, "from");
        Intrinsics.checkNotNullParameter((Object)to, "to");
        return convert((long)$this$convert, from, to);
    }
    
    public static final long convert(final long $this$convert, @NotNull final TimeUnit from, @NotNull final TimeUnit to) {
        Intrinsics.checkNotNullParameter((Object)from, "from");
        Intrinsics.checkNotNullParameter((Object)to, "to");
        return (from == to) ? $this$convert : to.convert($this$convert, from);
    }
}
