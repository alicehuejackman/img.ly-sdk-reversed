// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android;

import android.content.ContentValues;
import androidx.annotation.Nullable;
import android.database.Cursor;
import androidx.annotation.NonNull;
import android.net.Uri;
import android.content.Context;
import ly.img.android.sdk.IMGLYConfig;
import android.content.ContentProvider;

public class IMGLYAutoInit extends ContentProvider
{
    public boolean onCreate() {
        final Context context = this.getContext();
        if (context == null) {
            throw new RuntimeException("IMGYLAutoInit do not get context, this can happen while debug, please restart the device");
        }
        IMGLY.initSDK(context);
        PESDK.initSDK(IMGLYConfig.pesdkLicensePath);
        VESDK.initSDK(IMGLYConfig.vesdkLicensePath);
        IMGLY.authorize();
        return true;
    }
    
    @Nullable
    public Cursor query(@NonNull final Uri uri, final String[] projection, final String selection, final String[] selectionArgs, final String sortOrder) {
        return null;
    }
    
    @Nullable
    public String getType(@NonNull final Uri uri) {
        return null;
    }
    
    @Nullable
    public Uri insert(@NonNull final Uri uri, final ContentValues values) {
        return null;
    }
    
    public int delete(@NonNull final Uri uri, final String selection, final String[] selectionArgs) {
        return 0;
    }
    
    public int update(@NonNull final Uri uri, final ContentValues values, final String selection, final String[] selectionArgs) {
        return 0;
    }
}
