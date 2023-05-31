// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.os.Parcel;
import androidx.annotation.NonNull;
import androidx.annotation.WorkerThread;
import android.graphics.Color;
import android.graphics.LightingColorFilter;
import android.graphics.ColorFilter;
import android.graphics.Canvas;
import ly.img.android.pesdk.backend.model.ImageSize;
import android.graphics.Paint;
import android.graphics.Bitmap;
import androidx.annotation.Nullable;
import ly.img.android.pesdk.backend.decoder.ImageSource;
import android.os.Parcelable;

public class ColorFillSource implements Parcelable
{
    @Nullable
    private ImageSource colorFillSource;
    @Nullable
    private ImageSource backgroundSource;
    private Bitmap result;
    private Paint paint;
    public static final Parcelable.Creator<ColorFillSource> CREATOR;
    
    public ColorFillSource(@Nullable final ImageSource background, @Nullable final ImageSource colorFill) {
        this.paint = new Paint();
        this.colorFillSource = colorFill;
        this.backgroundSource = background;
    }
    
    @WorkerThread
    @NonNull
    public Bitmap getColoredBitmap(final int color) {
        final Bitmap colorFill = (this.colorFillSource != null) ? this.colorFillSource.getBitmap() : null;
        final Bitmap background = (this.backgroundSource != null) ? this.backgroundSource.getBitmap() : null;
        ImageSize size;
        if (this.backgroundSource != null) {
            size = this.backgroundSource.getSize();
        }
        else if (this.colorFillSource != null) {
            size = this.colorFillSource.getSize();
        }
        else {
            size = ImageSize.ZERO;
        }
        if (!size.isZero()) {
            this.result = UnusedBitmapPool.get().createBitmap(size.width, size.height, Bitmap.Config.ARGB_8888);
            final Canvas canvas = new Canvas(this.result);
            if (background != null) {
                this.paint.setColorFilter((ColorFilter)null);
                this.paint.setAlpha(255);
                canvas.drawBitmap(background, 0.0f, 0.0f, this.paint);
            }
            if (colorFill != null) {
                this.paint.setColorFilter((ColorFilter)new LightingColorFilter(color, 1));
                this.paint.setAlpha(Color.alpha(color));
                canvas.drawBitmap(colorFill, 0.0f, 0.0f, this.paint);
            }
        }
        else {
            this.result = BitmapFactoryUtils.NOTHING_BITMAP;
        }
        return this.result;
    }
    
    public void recycle() {
        UnusedBitmapPool.get().recycle(this.result);
        if (this.backgroundSource != null) {
            this.backgroundSource.recycle();
        }
        if (this.colorFillSource != null) {
            this.colorFillSource.recycle();
        }
        this.backgroundSource = null;
        this.colorFillSource = null;
        this.result = null;
    }
    
    public int describeContents() {
        return 0;
    }
    
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeParcelable((Parcelable)this.colorFillSource, flags);
        dest.writeParcelable((Parcelable)this.backgroundSource, flags);
    }
    
    protected ColorFillSource(final Parcel in) {
        this.paint = new Paint();
        this.colorFillSource = (ImageSource)in.readParcelable(ImageSource.class.getClassLoader());
        this.backgroundSource = (ImageSource)in.readParcelable(ImageSource.class.getClassLoader());
    }
    
    static {
        CREATOR = (Parcelable.Creator)new Parcelable.Creator<ColorFillSource>() {
            public ColorFillSource createFromParcel(final Parcel source) {
                return new ColorFillSource(source);
            }
            
            public ColorFillSource[] newArray(final int size) {
                return new ColorFillSource[size];
            }
        };
    }
}
