// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.linker;

import android.os.Parcel;
import ly.img.android.pesdk.backend.model.config.AbstractAsset;
import java.util.HashMap;
import android.util.SparseArray;
import android.os.Parcelable;

public class UIDataMap<Data> implements Parcelable
{
    private SparseArray<HashMap<Data, Object>> types;
    public static final Parcelable.Creator<UIDataMap> CREATOR;
    
    public <Type> Type getDataConfig(final DataType<Type> dataType, final AbstractAsset config) {
        final HashMap<Data, Object> dataMap = (HashMap<Data, Object>)this.types.get(dataType.getTypeId());
        return (Type)dataMap.get(config);
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeSparseArray((SparseArray)this.types);
    }
    
    public UIDataMap() {
        this.types = (SparseArray<HashMap<Data, Object>>)new SparseArray();
    }
    
    protected UIDataMap(final Parcel in) {
        this.types = (SparseArray<HashMap<Data, Object>>)new SparseArray();
        this.types = (SparseArray<HashMap<Data, Object>>)in.readSparseArray(HashMap.class.getClassLoader());
    }
    
    static {
        CREATOR = (Parcelable.Creator)new Parcelable.Creator<UIDataMap>() {
            public UIDataMap createFromParcel(final Parcel source) {
                return new UIDataMap(source);
            }
            
            public UIDataMap[] newArray(final int size) {
                return new UIDataMap[size];
            }
        };
    }
    
    public interface DataType<Type>
    {
        int getTypeId();
    }
}
