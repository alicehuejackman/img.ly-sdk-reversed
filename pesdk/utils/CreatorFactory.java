// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.os.Parcel;
import android.os.Parcelable;

public class CreatorFactory
{
    public static <T> Parcelable.Creator<T> generate(final CreateFromParcel<T> c, final NewArray<T> a) {
        return (Parcelable.Creator<T>)new Parcelable.Creator<T>() {
            public T createFromParcel(final Parcel source) {
                return c.createFromParcel(source);
            }
            
            public T[] newArray(final int size) {
                return a.newArray(size);
            }
        };
    }
    
    public interface CreateFromParcel<T>
    {
        T createFromParcel(final Parcel p0);
    }
    
    public interface NewArray<T>
    {
        T[] newArray(final int p0);
    }
}
