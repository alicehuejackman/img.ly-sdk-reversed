// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import android.util.Log;
import androidx.core.content.ContextCompat;
import ly.img.android.IMGLY;
import java.io.FileDescriptor;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.util.Locale;
import java.io.IOException;
import ly.img.android.pesdk.backend.encoder.Encoder;
import android.location.Location;
import org.jetbrains.annotations.Nullable;
import java.util.Date;
import android.net.Uri;
import ly.img.android.pesdk.backend.exif.Exify;
import android.os.Build$VERSION;
import java.io.InputStream;
import kotlin.jvm.JvmStatic;
import android.media.ExifInterface;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0007J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\rH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0007J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0012\u001a\u00020\u000fH\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0013\u001a\u00020\u0004H\u0007J\u0010\u0010\u0014\u001a\u00020\n2\u0006\u0010\u0015\u001a\u00020\u0016H\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\u0016J;\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u00162\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\u0006\u0010\u0012\u001a\u00020\u000f2\b\u0010\u001d\u001a\u0004\u0018\u00010\n2\b\u0010\u001e\u001a\u0004\u0018\u00010\u001fH\u0007¢\u0006\u0002\u0010 R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006!" }, d2 = { "Lly/img/android/pesdk/utils/ExifUtils;", "", "()V", "DATETIME_FORMAT", "", "DATE_FORMAT", "TAG", "TAG_GPS_DATE_STAMP", "TIME_FORMAT", "canReadLocationExifTags", "", "formatExifGpsDMS", "coordinate", "", "getAngle", "", "inputStream", "Ljava/io/InputStream;", "orientation", "filename", "isExifRedacted", "uri", "Landroid/net/Uri;", "printRedactionWarning", "", "save", "fileUri", "datetime", "Ljava/util/Date;", "flash", "location", "Landroid/location/Location;", "(Landroid/net/Uri;Ljava/util/Date;ILjava/lang/Boolean;Landroid/location/Location;)V", "pesdk-backend-core_release" })
public final class ExifUtils
{
    @NotNull
    public static final ExifUtils INSTANCE;
    @NotNull
    private static final String TAG = "ExifUtils";
    @NotNull
    private static final String DATE_FORMAT = "yyyy:MM:dd";
    @NotNull
    private static final String TIME_FORMAT = "HH:mm:ss";
    @NotNull
    private static final String TAG_GPS_DATE_STAMP = "GPSDateStamp";
    @NotNull
    private static final String DATETIME_FORMAT = "yyyy:MM:dd HH:mm:ss";
    
    private ExifUtils() {
    }
    
    @JvmStatic
    public static final int getAngle(@NotNull final String filename) {
        Intrinsics.checkNotNullParameter((Object)filename, "filename");
        int angle;
        try {
            angle = ExifUtils.INSTANCE.getAngle(new ExifInterface(filename).getAttributeInt("Orientation", 0));
        }
        catch (Exception e) {
            angle = 0;
        }
        return angle;
    }
    
    @JvmStatic
    public static final int getAngle(@NotNull final InputStream inputStream) {
        Intrinsics.checkNotNullParameter((Object)inputStream, "inputStream");
        int n2;
        try {
            int n;
            if (Build$VERSION.SDK_INT >= 24) {
                n = ExifUtils.INSTANCE.getAngle(new ExifInterface(inputStream).getAttributeInt("Orientation", 0));
            }
            else {
                final Exify exify = new Exify();
                exify.readExif(inputStream, 1);
                n = ExifUtils.INSTANCE.getAngle(exify.getTag(Exify.TAG.ORIENTATION).getValueAsInt(0));
            }
            n2 = n;
        }
        catch (Exception e) {
            n2 = 0;
        }
        return n2;
    }
    
    private final int getAngle(final int orientation) {
        int n = 0;
        switch (orientation) {
            case 7:
            case 8: {
                n = 270;
                break;
            }
            case 3:
            case 4: {
                n = 180;
                break;
            }
            case 5:
            case 6: {
                n = 90;
                break;
            }
            case 1: {
                n = 0;
                break;
            }
            default: {
                n = 0;
                break;
            }
        }
        return n;
    }
    
    @JvmStatic
    public static final void save(@NotNull final Uri fileUri, @Nullable final Date datetime, final int orientation, @Nullable final Boolean flash, @Nullable final Location location) throws IOException {
        Intrinsics.checkNotNullParameter((Object)fileUri, "fileUri");
        ExifInterface exifInterface;
        if (Build$VERSION.SDK_INT >= 24) {
            final ExifInterface exifInterface2;
            exifInterface = exifInterface2;
            final FileDescriptor fileDescriptor = Encoder.Companion.getFileDescriptor(fileUri);
            if (fileDescriptor == null) {
                throw new IOException();
            }
            exifInterface2 = new ExifInterface(fileDescriptor);
        }
        else {
            final ExifInterface exifInterface3;
            exifInterface = exifInterface3;
            final String path = fileUri.getPath();
            if (path == null) {
                throw new IOException();
            }
            exifInterface3 = new ExifInterface(path);
        }
        final ExifInterface exif = exifInterface;
        if (datetime != null) {
            final ExifInterface exifInterface4 = exif;
            final String s = "DateTime";
            final ExifUtils instance = ExifUtils.INSTANCE;
            exifInterface4.setAttribute(s, new SimpleDateFormat("yyyy:MM:dd HH:mm:ss", Locale.ENGLISH).format(datetime));
        }
        exif.setAttribute("Make", Build.MANUFACTURER);
        exif.setAttribute("Model", Build.MODEL);
        exif.setAttribute("Orientation", String.valueOf(orientation));
        if (flash != null) {
            exif.setAttribute("Flash", ((boolean)flash) ? "1" : "0");
        }
        if (location != null) {
            final double latitude = location.getLatitude();
            final double longitude = location.getLongitude();
            exif.setAttribute("GPSLatitudeRef", "N");
            exif.setAttribute("GPSLatitude", ExifUtils.INSTANCE.formatExifGpsDMS(latitude));
            exif.setAttribute("GPSLongitudeRef", "E");
            exif.setAttribute("GPSLongitude", ExifUtils.INSTANCE.formatExifGpsDMS(longitude));
            exif.setAttribute("GPSLatitudeRef", (latitude > 0.0) ? "N" : "S");
            exif.setAttribute("GPSLongitudeRef", (longitude > 0.0) ? "E" : "W");
            if (datetime != null) {
                final ExifInterface exifInterface5 = exif;
                final ExifUtils instance2 = ExifUtils.INSTANCE;
                final String s2 = "GPSDateStamp";
                final ExifUtils instance3 = ExifUtils.INSTANCE;
                exifInterface5.setAttribute(s2, new SimpleDateFormat("yyyy:MM:dd", Locale.ENGLISH).format(datetime));
            }
        }
        exif.saveAttributes();
    }
    
    private final String formatExifGpsDMS(final double coordinate) {
        final double absDegree = Math.abs(coordinate);
        final double minutes = absDegree % 1 * 60;
        final double seconds = minutes % 1 * 60000;
        return (int)absDegree + "/1," + (int)minutes + "/1," + (int)seconds + "/1000";
    }
    
    @JvmStatic
    public static final boolean isExifRedacted(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        return Build$VERSION.SDK_INT >= 29 && Intrinsics.areEqual((Object)"media", (Object)uri.getAuthority());
    }
    
    @JvmStatic
    public static final boolean canReadLocationExifTags() {
        return Build$VERSION.SDK_INT < 29 || ContextCompat.checkSelfPermission(IMGLY.getAppContext(), "android.permission.ACCESS_MEDIA_LOCATION") == 0;
    }
    
    public final void printRedactionWarning(@NotNull final Uri uri) {
        Intrinsics.checkNotNullParameter((Object)uri, "uri");
        if (isExifRedacted(uri) && !canReadLocationExifTags()) {
            Log.w("ExifUtils", "To preserve GPS-IFD tags in the exported image, ACCESS_MEDIA_LOCATION permission is required.\nhttps://developer.android.com/training/data-storage/shared/media#media-location-permission");
        }
    }
    
    static {
        INSTANCE = new ExifUtils();
    }
}
