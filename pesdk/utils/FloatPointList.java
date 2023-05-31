// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.Size;
import androidx.annotation.CheckResult;
import android.graphics.Matrix;
import java.util.Arrays;
import androidx.annotation.NonNull;

public class FloatPointList
{
    private static final int X = 0;
    private static final int Y = 1;
    private static final int DEFAULT_CAPACITY = 1000;
    private static final float[] EMPTY_ELEMENT_DATA;
    transient float[] elementData;
    private int size;
    private static final int MAX_ARRAY_SIZE = 2147483639;
    protected transient int modCount;
    
    public FloatPointList(final int initialCapacity) {
        this.modCount = 0;
        if (initialCapacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + initialCapacity);
        }
        this.elementData = new float[initialCapacity];
    }
    
    public FloatPointList(@NonNull final float[] points) {
        this.modCount = 0;
        this.elementData = Arrays.copyOf(points, points.length);
        this.size = points.length;
    }
    
    public float[] createArray() {
        return Arrays.copyOf(this.elementData, this.size);
    }
    
    public float[] rawArray() {
        return this.elementData;
    }
    
    public FloatPointList mapPoints(final Matrix matrix) {
        matrix.mapPoints(this.elementData, 0, this.elementData, 0, this.size >> 1);
        return this;
    }
    
    public FloatPointList() {
        this.modCount = 0;
        this.elementData = FloatPointList.EMPTY_ELEMENT_DATA;
    }
    
    public void trimToSize() {
        ++this.modCount;
        if (this.size < this.elementData.length) {
            this.elementData = Arrays.copyOf(this.elementData, this.size);
        }
    }
    
    public void ensureCapacity(final int minCapacity) {
        final int minExpand = (this.elementData != FloatPointList.EMPTY_ELEMENT_DATA) ? 0 : 1000;
        if (minCapacity > minExpand) {
            this.ensureExplicitCapacity(minCapacity);
        }
    }
    
    private void ensureCapacityInternal(int minCapacity) {
        if (this.elementData == FloatPointList.EMPTY_ELEMENT_DATA) {
            minCapacity = Math.max(1000, minCapacity);
        }
        this.ensureExplicitCapacity(minCapacity);
    }
    
    private void ensureExplicitCapacity(final int minCapacity) {
        ++this.modCount;
        if (minCapacity - this.elementData.length > 0) {
            this.grow(minCapacity);
        }
    }
    
    private void grow(final int minCapacity) {
        final int oldCapacity = this.elementData.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);
        if (newCapacity - minCapacity < 0) {
            newCapacity = minCapacity;
        }
        if (newCapacity - 2147483639 > 0) {
            newCapacity = hugeCapacity(minCapacity);
        }
        this.elementData = Arrays.copyOf(this.elementData, newCapacity);
    }
    
    private static int hugeCapacity(final int minCapacity) {
        if (minCapacity < 0) {
            throw new OutOfMemoryError();
        }
        return (minCapacity > 2147483639) ? Integer.MAX_VALUE : 2147483639;
    }
    
    public int size() {
        return this.size;
    }
    
    public int pointCount() {
        return this.size >> 1;
    }
    
    public boolean isEmpty() {
        return this.size == 0;
    }
    
    public float get(final int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        return this.elementData[index];
    }
    
    @CheckResult
    public float[] getPoint(final int pointIndex) {
        return this.getPoint(pointIndex, new float[2]);
    }
    
    @Size(2L)
    public float[] getPoint(final int pointIndex, @Size(2L) final float[] dst) {
        if (pointIndex >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(pointIndex));
        }
        int index = pointIndex << 1;
        dst[0] = this.elementData[index++];
        dst[1] = this.elementData[index];
        return dst;
    }
    
    public float set(final int index, final float element) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        final float oldValue = this.elementData[index];
        this.elementData[index] = element;
        return oldValue;
    }
    
    public void set(final int pointIndex, final float[] point) {
        int index = pointIndex << 1;
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        final float oldValue = this.elementData[index];
        this.elementData[index++] = point[0];
        this.elementData[index] = point[1];
    }
    
    public boolean add(final float e) {
        this.ensureCapacityInternal(this.size + 1);
        this.elementData[this.size++] = e;
        return true;
    }
    
    public boolean addPoint(@NonNull final float[] point) {
        this.ensureCapacityInternal(this.size + 2);
        this.elementData[this.size++] = point[0];
        this.elementData[this.size++] = point[1];
        return true;
    }
    
    public boolean addPoint(@NonNull final float x, final float y) {
        this.ensureCapacityInternal(this.size + 2);
        this.elementData[this.size++] = x;
        this.elementData[this.size++] = y;
        return true;
    }
    
    public void add(final int index, final float element) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        this.ensureCapacityInternal(this.size + 1);
        System.arraycopy(this.elementData, index, this.elementData, index + 1, this.size - index);
        this.elementData[index] = element;
        ++this.size;
    }
    
    public void addPoint(final int pointIndex, final float[] point) {
        if (pointIndex > this.size || pointIndex < 0) {
            throw new IndexOutOfBoundsException(this.pointOutOfBoundsMsg(pointIndex));
        }
        int index = pointIndex << 1;
        this.ensureCapacityInternal(this.size + 2);
        System.arraycopy(this.elementData, index, this.elementData, index + 2, this.size - index);
        this.elementData[index++] = point[0];
        this.elementData[index] = point[1];
        ++this.size;
    }
    
    public void addPoint(final int pointIndex, final float x, final float y) {
        if (pointIndex > this.size || pointIndex < 0) {
            throw new IndexOutOfBoundsException(this.pointOutOfBoundsMsg(pointIndex));
        }
        int index = pointIndex << 1;
        this.ensureCapacityInternal(this.size + 2);
        System.arraycopy(this.elementData, index, this.elementData, index + 2, this.size - pointIndex);
        this.elementData[index++] = x;
        this.elementData[index] = y;
        ++this.size;
    }
    
    public float remove(final int index) {
        if (index >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        ++this.modCount;
        final float oldValue = this.elementData[index];
        final int numMoved = this.size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, numMoved);
        }
        this.elementData[--this.size] = Float.NaN;
        return oldValue;
    }
    
    public void removePoint(final int pointIndex) {
        if (pointIndex >= this.size) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(pointIndex));
        }
        ++this.modCount;
        final int index = pointIndex << 1;
        final int numMoved = this.size - index - 2;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index + 2, this.elementData, index, numMoved);
        }
        this.elementData[--this.size] = Float.NaN;
        this.elementData[--this.size] = Float.NaN;
    }
    
    public boolean remove(final Object o) {
        if (o == null) {
            for (int index = 0; index < this.size; ++index) {
                if (this.elementData[index] == Float.NaN) {
                    this.fastRemove(index);
                    return true;
                }
            }
        }
        else {
            for (int index = 0; index < this.size; ++index) {
                if (o.equals(this.elementData[index])) {
                    this.fastRemove(index);
                    return true;
                }
            }
        }
        return false;
    }
    
    private void fastRemove(final int index) {
        ++this.modCount;
        final int numMoved = this.size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index + 1, this.elementData, index, numMoved);
        }
        this.elementData[--this.size] = Float.NaN;
    }
    
    public void clear() {
        ++this.modCount;
        this.size = 0;
    }
    
    public boolean addAll(final float[] a) {
        final int numNew = a.length;
        this.ensureCapacityInternal(this.size + numNew);
        System.arraycopy(a, 0, this.elementData, this.size, numNew);
        this.size += numNew;
        return numNew != 0;
    }
    
    public boolean addAll(final int index, final float[] a) {
        if (index > this.size || index < 0) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
        final int numNew = a.length;
        this.ensureCapacityInternal(this.size + numNew);
        final int numMoved = this.size - index;
        if (numMoved > 0) {
            System.arraycopy(this.elementData, index, this.elementData, index + numNew, numMoved);
        }
        System.arraycopy(a, 0, this.elementData, index, numNew);
        this.size += numNew;
        return numNew != 0;
    }
    
    protected void removeRange(final int fromIndex, final int toIndex) {
        if (toIndex < fromIndex) {
            throw new IndexOutOfBoundsException("toIndex < fromIndex");
        }
        ++this.modCount;
        final int numMoved = this.size - toIndex;
        System.arraycopy(this.elementData, toIndex, this.elementData, fromIndex, numMoved);
        int i;
        int newSize;
        for (newSize = (i = this.size - (toIndex - fromIndex)); i < this.size; ++i) {
            this.elementData[i] = Float.NaN;
        }
        this.size = newSize;
    }
    
    private String outOfBoundsMsg(final int index) {
        return "Index: " + index + ", Size: " + this.size;
    }
    
    private String pointOutOfBoundsMsg(final int index) {
        return "Index: " + index + ", Point Count: " + (this.size >> 1);
    }
    
    @Override
    public boolean equals(final Object o) {
        return o == this || (o instanceof FloatPointList && this.elementData.equals(o));
    }
    
    @Override
    public int hashCode() {
        return this.elementData.hashCode();
    }
    
    private void rangeCheckForAdd(final int index) {
        if (index < 0 || index > this.size()) {
            throw new IndexOutOfBoundsException(this.outOfBoundsMsg(index));
        }
    }
    
    static {
        EMPTY_ELEMENT_DATA = new float[0];
    }
}
