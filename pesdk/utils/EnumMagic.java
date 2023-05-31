// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationTargetException;
import androidx.annotation.IntRange;
import androidx.annotation.Nullable;

public class EnumMagic
{
    @Nullable
    public static <T extends Enum> T convertTo(final Class<T> enumClass, final String value) {
        try {
            return Enum.valueOf(enumClass, value);
        }
        catch (IllegalArgumentException ignored) {
            return null;
        }
    }
    
    public static <T extends Enum> T convertTo(final Class<T> enumClass, final Enum value) {
        try {
            return Enum.valueOf(enumClass, value.name());
        }
        catch (IllegalArgumentException ignored) {
            return null;
        }
    }
    
    public static <T extends Enum> T wrapTo(final Class<T> enumClass, @IntRange(from = 0L) final int value) {
        try {
            final Method method = enumClass.getMethod("values", (Class<?>[])new Class[0]);
            final T[] values = (T[])method.invoke(null, new Object[0]);
            if (values == null || values.length <= value) {
                return null;
            }
            return values[value];
        }
        catch (NoSuchMethodException e) {
            return null;
        }
        catch (IllegalAccessException e2) {
            return null;
        }
        catch (InvocationTargetException e3) {
            return null;
        }
    }
}
