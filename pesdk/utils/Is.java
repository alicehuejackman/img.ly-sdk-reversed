// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.math.BigDecimal;

public class Is
{
    BigDecimal value1;
    
    private Is(final BigDecimal bigDecimal) {
        this.value1 = bigDecimal;
    }
    
    public static Is value(final BigDecimal value1) {
        return new Is(value1);
    }
    
    public boolean graterThan(final BigDecimal value2) {
        if (this.value1 == null || value2 == null) {
            return false;
        }
        final BigDecimal max = this.value1.max(value2);
        return max.compareTo(this.value1) == 0 && max.compareTo(value2) != 0;
    }
    
    public boolean graterOrEqual(final BigDecimal value2) {
        return this.value1 != null && value2 != null && this.value1.max(value2).compareTo(this.value1) == 0;
    }
    
    public boolean equal(final BigDecimal value2) {
        return (this.value1 != null && value2 != null && this.value1.compareTo(value2) == 0) || (this.value1 == null && value2 == null);
    }
    
    public boolean nonEqual(final BigDecimal value2) {
        return (this.value1 != null || value2 != null) && (this.value1 == null || value2 == null || this.value1.compareTo(value2) != 0);
    }
    
    public boolean lessOrEqual(final BigDecimal value2) {
        return this.value1 != null && value2 != null && this.value1.min(value2).compareTo(this.value1) == 0;
    }
    
    public boolean lessThan(final BigDecimal value2) {
        if (this.value1 == null || value2 == null) {
            return false;
        }
        final BigDecimal min = this.value1.min(value2);
        return min.compareTo(this.value1) == 0 && min.compareTo(value2) != 0;
    }
}
