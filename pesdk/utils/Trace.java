// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import android.util.Log;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0000\n\u0002\u0010\u0005\n\u0000\n\u0002\u0010\u0012\n\u0002\u0010\u0013\n\u0002\u0010\u0014\n\u0002\u0010\u0015\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\n\u001a\u00020\u00062\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007J\u0019\u0010\r\u001a\u00020\u00062\n\u0010\u000e\u001a\u0006\u0012\u0002\b\u00030\u000fH\u0002¢\u0006\u0002\u0010\u0010J\u001b\u0010\r\u001a\u00020\u00062\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00110\u000fH\u0002¢\u0006\u0002\u0010\u0012J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0013H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0014H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0015H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0016H\u0002J\u0010\u0010\r\u001a\u00020\u00062\u0006\u0010\u000e\u001a\u00020\u0017H\u0002J/\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u00062\u0016\u0010\u001b\u001a\f\u0012\b\b\u0001\u0012\u0004\u0018\u00010\u00010\u000f\"\u0004\u0018\u00010\u0001H\u0007¢\u0006\u0002\u0010\u001cJ\b\u0010\u001d\u001a\u00020\u0006H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u00020\u0006X\u0080D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0007\u0010\u0002\u001a\u0004\b\b\u0010\t¨\u0006\u001e" }, d2 = { "Lly/img/android/pesdk/utils/Trace;", "", "()V", "DEBUG", "", "UNKNOWN_ELEMENT", "", "getUNKNOWN_ELEMENT$pesdk_backend_core_release$annotations", "getUNKNOWN_ELEMENT$pesdk_backend_core_release", "()Ljava/lang/String;", "calle", "offset", "", "getArray", "array", "", "([Ljava/lang/Object;)Ljava/lang/String;", "", "([Ljava/lang/Byte;)Ljava/lang/String;", "", "", "", "", "", "out", "", "tag", "values", "(Ljava/lang/String;[Ljava/lang/Object;)V", "stackAll", "pesdk-backend-core_release" })
public final class Trace
{
    @NotNull
    public static final Trace INSTANCE;
    private static final boolean DEBUG = true;
    @NotNull
    private static final String UNKNOWN_ELEMENT;
    
    private Trace() {
    }
    
    @JvmStatic
    public static final void out(@Nullable final String tag, @NotNull final Object... values) {
        Intrinsics.checkNotNullParameter((Object)values, "values");
        final Trace instance = Trace.INSTANCE;
        String str = "";
        boolean first = true;
        for (int i = 0; i < values.length; ++i) {
            final Object value = values[i];
            String valueStr = "NULL";
            if (value instanceof float[]) {
                valueStr = Trace.INSTANCE.getArray((float[])value);
            }
            else if (value instanceof byte[]) {
                valueStr = Trace.INSTANCE.getArray((byte[])value);
            }
            else if (value instanceof short[]) {
                valueStr = Trace.INSTANCE.getArray((short[])value);
            }
            else if (value instanceof int[]) {
                valueStr = Trace.INSTANCE.getArray((int[])value);
            }
            else if (value instanceof double[]) {
                valueStr = Trace.INSTANCE.getArray((double[])value);
            }
            else if (value instanceof Object[]) {
                valueStr = Trace.INSTANCE.getArray((Object[])value);
            }
            else if (value != null) {
                valueStr = value.toString();
            }
            str = str + (first ? "" : " ") + valueStr;
            first = false;
        }
        Log.i(tag, str);
    }
    
    private final String getArray(final int[] array) {
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final int value = array[i];
            string = string + value + "; ";
        }
        return string + ']';
    }
    
    private final String getArray(final short[] array) {
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final short value = array[i];
            string = string + value + "; ";
        }
        return string + ']';
    }
    
    private final String getArray(final byte[] array) {
        final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final byte value = array[i];
            final byte uValue = (value < 0) ? ((byte)(value + 128)) : value;
            string = string + "0x" + hex[uValue / 16 % 16] + hex[uValue % 16] + "; ";
        }
        return string + ']';
    }
    
    private final String getArray(final Byte[] array) {
        final char[] hex = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final byte value = array[i];
            final StringBuilder append = new StringBuilder().append(string);
            final Trace trace = this;
            final StringBuilder sb = append;
            final int n = 0;
            final int uValue = (value < 0) ? (value + 127) : value;
            string = sb.append("0x" + hex[uValue / 16 % 16] + hex[uValue % 16] + "; ").toString();
        }
        return string + ']';
    }
    
    private final String getArray(final float[] array) {
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final float value = array[i];
            string = string + value + "; ";
        }
        return string + ']';
    }
    
    private final String getArray(final double[] array) {
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final double value = array[i];
            string = string + value + "; ";
        }
        return string + ']';
    }
    
    private final String getArray(final Object[] array) {
        String string = "[";
        for (int i = 0; i < array.length; ++i) {
            final Object value = array[i];
            string = string + value + "; ";
        }
        return string + ']';
    }
    
    @JvmStatic
    @NotNull
    public static final String stackAll() {
        int level = 1;
        final StringBuilder result = new StringBuilder();
        String latest = null;
        while (true) {
            final Trace instance = Trace.INSTANCE;
            final String calle;
            latest = (calle = calle(level++));
            final Trace instance2 = Trace.INSTANCE;
            if (calle == Trace.UNKNOWN_ELEMENT) {
                break;
            }
            result.append(latest).append('\n');
        }
        final String string = result.toString();
        Intrinsics.checkNotNullExpressionValue((Object)string, "result.toString()");
        return string;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String calle(final int offset) {
        final StackTraceElement[] elements = Thread.currentThread().getStackTrace();
        final StackTraceElement element = (elements.length > 4 + offset) ? elements[4 + offset] : null;
        String s;
        if (element == null) {
            final Trace instance = Trace.INSTANCE;
            s = Trace.UNKNOWN_ELEMENT;
        }
        else {
            s = element.getClassName() + '.' + element.getMethodName() + " Line:" + element.getLineNumber();
        }
        return s;
    }
    
    public static /* synthetic */ String calle$default(int offset, final int n, final Object o) {
        if ((n & 0x1) != 0x0) {
            offset = 1;
        }
        return calle(offset);
    }
    
    @NotNull
    public final String getUNKNOWN_ELEMENT$pesdk_backend_core_release() {
        return Trace.UNKNOWN_ELEMENT;
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String calle() {
        return calle$default(0, 1, null);
    }
    
    static {
        INSTANCE = new Trace();
        UNKNOWN_ELEMENT = "[Unknown]";
    }
}
