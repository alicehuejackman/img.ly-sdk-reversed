// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.Size;
import android.graphics.Rect;

public class RelativeContext
{
    private final double absoluteWidth;
    private final double absoluteHeight;
    private final double absoluteMinSize;
    private final double absoluteTranslateX;
    private final double absoluteTranslateY;
    
    public RelativeContext(final Rect rect) {
        this.absoluteWidth = rect.width();
        this.absoluteHeight = rect.height();
        this.absoluteMinSize = Math.min(this.absoluteWidth, this.absoluteHeight);
        this.absoluteTranslateX = rect.left;
        this.absoluteTranslateY = rect.top;
    }
    
    @Size(2L)
    public float[] toAbsolute(@Size(2L) final float[] relativePoint) {
        relativePoint[0] = (float)this.toAbsoluteX(relativePoint[0]);
        relativePoint[1] = (float)this.toAbsoluteY(relativePoint[1]);
        return relativePoint;
    }
    
    public double toAbsoluteX(final double relativeX) {
        return relativeX * this.absoluteWidth + this.absoluteTranslateX;
    }
    
    public double toAbsoluteY(final double relativeY) {
        return relativeY * this.absoluteHeight + this.absoluteTranslateY;
    }
    
    public double toAbsoluteSize(final double relativeSize) {
        return relativeSize * this.absoluteMinSize;
    }
    
    public double toRelativeSize(final double relativeWidth) {
        return relativeWidth / this.absoluteMinSize;
    }
    
    @Size(2L)
    public float[] toRelative(@Size(2L) final float[] absolutePoint) {
        absolutePoint[0] = (float)this.toRelativeX(absolutePoint[0]);
        absolutePoint[1] = (float)this.toRelativeY(absolutePoint[1]);
        return absolutePoint;
    }
    
    public double toRelativeX(final double absoluteX) {
        return (absoluteX - this.absoluteTranslateX) / this.absoluteWidth;
    }
    
    public double toRelativeY(final double absoluteY) {
        return (absoluteY - this.absoluteTranslateY) / this.absoluteHeight;
    }
}
