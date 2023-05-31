// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import org.jetbrains.annotations.NotNull;
import android.os.Parcel;
import kotlin.Metadata;
import android.os.Parcelable;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0018\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\u0003H&¨\u0006\t" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/KParcelable;", "Landroid/os/Parcelable;", "describeContents", "", "writeToParcel", "", "dest", "Landroid/os/Parcel;", "flags", "pesdk-backend-core_release" })
public interface KParcelable extends Parcelable
{
    int describeContents();
    
    void writeToParcel(@NotNull final Parcel p0, final int p1);
    
    @Metadata(mv = { 1, 6, 0 }, k = 3, xi = 48)
    public static final class DefaultImpls
    {
        public static int describeContents(@NotNull final KParcelable this) {
            return 0;
        }
    }
}
