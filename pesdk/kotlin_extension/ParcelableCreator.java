// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import android.os.Parcel;
import kotlin.jvm.functions.Function1;
import kotlin.Metadata;
import android.os.Parcelable$Creator;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000*\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0016\u0018\u0000*\u0004\b\u0000\u0010\u00012\b\u0012\u0004\u0012\u0002H\u00010\u0002B(\u0012!\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\u0002\u0010\tJ\u0015\u0010\f\u001a\u00028\u00002\u0006\u0010\b\u001a\u00020\u0005H\u0016¢\u0006\u0002\u0010\rJ\u001d\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00028\u00000\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016¢\u0006\u0002\u0010\u0012R,\u0010\u0003\u001a\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0004\u0012\u00028\u00000\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ParcelableCreator;", "T", "Landroid/os/Parcelable$Creator;", "create", "Lkotlin/Function1;", "Landroid/os/Parcel;", "Lkotlin/ParameterName;", "name", "source", "(Lkotlin/jvm/functions/Function1;)V", "getCreate", "()Lkotlin/jvm/functions/Function1;", "createFromParcel", "(Landroid/os/Parcel;)Ljava/lang/Object;", "newArray", "", "size", "", "(I)[Ljava/lang/Object;", "pesdk-backend-core_release" })
public class ParcelableCreator<T> implements Parcelable$Creator<T>
{
    @NotNull
    private final Function1<Parcel, T> create;
    
    public ParcelableCreator(@NotNull final Function1<? super Parcel, ? extends T> create) {
        Intrinsics.checkNotNullParameter((Object)create, "create");
        this.create = (Function1<Parcel, T>)create;
    }
    
    @NotNull
    public final Function1<Parcel, T> getCreate() {
        return this.create;
    }
    
    public T createFromParcel(@NotNull final Parcel source) {
        Intrinsics.checkNotNullParameter((Object)source, "source");
        return (T)this.create.invoke((Object)source);
    }
    
    @NotNull
    public T[] newArray(final int size) {
        int i = 0;
        final Object[] array = new Object[size];
        while (i < size) {
            array[i] = null;
            ++i;
        }
        return (T[])array;
    }
}
