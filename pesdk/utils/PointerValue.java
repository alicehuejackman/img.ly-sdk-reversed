// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0007\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00028\u0000¢\u0006\u0002\u0010\u0004R\u001c\u0010\u0003\u001a\u00028\u0000X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\b\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\u0004¨\u0006\t" }, d2 = { "Lly/img/android/pesdk/utils/PointerValue;", "TYPE", "", "value", "(Ljava/lang/Object;)V", "getValue", "()Ljava/lang/Object;", "setValue", "Ljava/lang/Object;", "pesdk-backend-core_release" })
public final class PointerValue<TYPE>
{
    private TYPE value;
    
    public PointerValue(final TYPE value) {
        this.value = value;
    }
    
    public final TYPE getValue() {
        return this.value;
    }
    
    public final void setValue(final TYPE <set-?>) {
        this.value = <set-?>;
    }
}
