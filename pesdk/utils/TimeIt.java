// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.functions.Function0;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u0007\u001a\u00020\bJ-\u0010\t\u001a\u0002H\n\"\u0004\b\u0000\u0010\n2\u0006\u0010\u0003\u001a\u00020\u00042\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u0002H\n0\fH\u0086\b\u00f8\u0001\u0000¢\u0006\u0002\u0010\rJ\u000e\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0003\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u000f" }, d2 = { "Lly/img/android/pesdk/utils/TimeIt;", "", "()V", "name", "", "time", "", "count", "", "measure", "T", "block", "Lkotlin/Function0;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;)Ljava/lang/Object;", "start", "pesdk-backend-core_release" })
public final class TimeIt
{
    private long time;
    @NotNull
    private String name;
    
    public TimeIt() {
        this.name = "";
    }
    
    public final void start(@NotNull final String name) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        this.name = name;
        this.time = System.nanoTime();
    }
    
    public final void count() {
        final long taken = System.nanoTime() - this.time;
        Log.i("TimeIt", this.name + " take " + taken / 1000000.0f + "ms");
    }
    
    public final <T> T measure(@NotNull final String name, @NotNull final Function0<? extends T> block) {
        Intrinsics.checkNotNullParameter((Object)name, "name");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$measure = 0;
        this.start(name);
        try {
            return (T)block.invoke();
        }
        finally {
            InlineMarker.finallyStart(1);
            this.count();
            InlineMarker.finallyEnd(1);
        }
    }
}
