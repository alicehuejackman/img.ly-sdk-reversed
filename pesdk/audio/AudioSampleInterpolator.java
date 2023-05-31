// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.audio;

import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0014\n\u0002\b\r\n\u0002\u0010\n\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0002\u0010\tJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u001aR\u001a\u0010\u0007\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0012\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u000f\"\u0004\b\u0014\u0010\u0011¨\u0006\u001b" }, d2 = { "Lly/img/android/pesdk/audio/AudioSampleInterpolator;", "", "samples", "", "offset", "", "steps", "monotonicBuffer", "", "([SII[F)V", "getMonotonicBuffer", "()[F", "setMonotonicBuffer", "([F)V", "getOffset", "()I", "setOffset", "(I)V", "sampleSize", "getSteps", "setSteps", "interpolate", "", "x", "", "reloadData", "", "pesdk-backend-core_release" })
public final class AudioSampleInterpolator
{
    @NotNull
    private short[] samples;
    private int offset;
    private int steps;
    @NotNull
    private float[] monotonicBuffer;
    private final int sampleSize;
    
    public AudioSampleInterpolator(@NotNull final short[] samples, final int offset, final int steps, @NotNull final float[] monotonicBuffer) {
        Intrinsics.checkNotNullParameter((Object)samples, "samples");
        Intrinsics.checkNotNullParameter((Object)monotonicBuffer, "monotonicBuffer");
        this.samples = samples;
        this.offset = offset;
        this.steps = steps;
        this.monotonicBuffer = monotonicBuffer;
        this.sampleSize = this.samples.length / this.steps;
        this.reloadData();
    }
    
    public final int getOffset() {
        return this.offset;
    }
    
    public final void setOffset(final int <set-?>) {
        this.offset = <set-?>;
    }
    
    public final int getSteps() {
        return this.steps;
    }
    
    public final void setSteps(final int <set-?>) {
        this.steps = <set-?>;
    }
    
    @NotNull
    public final float[] getMonotonicBuffer() {
        return this.monotonicBuffer;
    }
    
    public final void setMonotonicBuffer(@NotNull final float[] <set-?>) {
        Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
        this.monotonicBuffer = <set-?>;
    }
    
    public final void reloadData() {
    }
    
    public final short interpolate(final float x) {
        if (this.sampleSize < 2) {
            final Short firstOrNull = ArraysKt.firstOrNull(this.samples);
            return (short)((firstOrNull != null) ? ((short)firstOrNull) : 0);
        }
        if (x <= 0.0f) {
            return this.samples[this.offset];
        }
        if (x >= this.sampleSize - 1) {
            return this.samples[this.offset + (this.sampleSize - 1) * this.steps];
        }
        final int i = (int)x;
        if (x == i) {
            return this.samples[this.offset + i * this.steps];
        }
        final float interpolation = x - i;
        return (short)(this.samples[this.offset + i * this.steps] * (1 - interpolation) + this.samples[this.offset + (i + 1) * this.steps] * interpolation);
    }
}
