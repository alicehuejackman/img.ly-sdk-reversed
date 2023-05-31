// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

public class FastArrayOp
{
    public static void byteFill(final byte[] array, final byte value) {
        final int len = array.length;
        if (len > 0) {
            array[0] = value;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final byte[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = 0;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final short[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = 0;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final short[] array, final int offset) {
        final int len = array.length - offset;
        if (len > 0) {
            array[offset] = 0;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, offset, array, offset + i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final int[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = 0;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final double[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = 0.0;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final float[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = 0.0f;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
    
    public static void clear(final boolean[] array) {
        final int len = array.length;
        if (len > 0) {
            array[0] = false;
        }
        for (int i = 1; i < len; i += i) {
            System.arraycopy(array, 0, array, i, Math.min(len - i, i));
        }
    }
}
