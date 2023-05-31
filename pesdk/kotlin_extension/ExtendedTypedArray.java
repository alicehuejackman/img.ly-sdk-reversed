// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import kotlin.math.MathKt;
import org.jetbrains.annotations.Nullable;
import androidx.annotation.StyleableRes;
import kotlin.jvm.internal.Intrinsics;
import android.util.TypedValue;
import android.content.res.TypedArray;
import org.jetbrains.annotations.NotNull;
import android.content.res.Resources$Theme;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0007\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\u0010\r\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0019\u0012\n\u0010\u0002\u001a\u00060\u0003R\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007J\u0010\u0010\f\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0010\u001a\u00020\r2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\rJ\u0018\u0010\u0012\u001a\u00020\u00132\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0013J\u0018\u0010\u0014\u001a\u00020\u000f2\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u000fJ\u0018\u0010\u0015\u001a\u00020\u00132\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0013J\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u00172\b\b\u0001\u0010\u000e\u001a\u00020\u000fJ\u0018\u0010\u0016\u001a\u00020\u00182\b\b\u0001\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u0017J\u0014\u0010\u0019\u001a\u0004\u0018\u00010\t2\b\b\u0001\u0010\u000e\u001a\u00020\u000fH\u0002J\u0014\u0010\u001a\u001a\u00020\r*\u00020\t2\u0006\u0010\u0011\u001a\u00020\rH\u0002J\u0014\u0010\u001b\u001a\u00020\u0013*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0013H\u0002J\u0014\u0010\u001c\u001a\u00020\u000f*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u000fH\u0002J\u0014\u0010\u001d\u001a\u00020\u0013*\u00020\t2\u0006\u0010\u0011\u001a\u00020\u0013H\u0002R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0015\u0010\u0002\u001a\u00060\u0003R\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "", "theme", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "typedArray", "Landroid/content/res/TypedArray;", "(Landroid/content/res/Resources$Theme;Landroid/content/res/TypedArray;)V", "cache", "Landroid/util/TypedValue;", "getTheme", "()Landroid/content/res/Resources$Theme;", "exists", "", "key", "", "getBoolean", "default", "getFloat", "", "getInt", "getSize", "getString", "", "", "readTypedValue", "asBoolean", "asFloat", "asInt", "asSize", "pesdk-backend-core_release" })
public final class ExtendedTypedArray
{
    @NotNull
    private final Resources$Theme theme;
    @NotNull
    private final TypedArray typedArray;
    @NotNull
    private final TypedValue cache;
    
    public ExtendedTypedArray(@NotNull final Resources$Theme theme, @NotNull final TypedArray typedArray) {
        Intrinsics.checkNotNullParameter((Object)theme, "theme");
        Intrinsics.checkNotNullParameter((Object)typedArray, "typedArray");
        this.theme = theme;
        this.typedArray = typedArray;
        this.cache = new TypedValue();
    }
    
    @NotNull
    public final Resources$Theme getTheme() {
        return this.theme;
    }
    
    private final TypedValue readTypedValue(@StyleableRes final int key) {
        final TypedValue it;
        final TypedValue typedValue = it = this.cache;
        final int n = 0;
        return ((this.typedArray.getType(key) == 2) ? this.theme.resolveAttribute(key, it, false) : this.typedArray.getValue(key, it)) ? typedValue : null;
    }
    
    public final boolean exists(@StyleableRes final int key) {
        return this.typedArray.hasValue(key);
    }
    
    public final int getInt(@StyleableRes final int key, final int default) {
        final TypedValue typedValue = this.readTypedValue(key);
        return (typedValue != null) ? this.asInt(typedValue, default) : default;
    }
    
    public final float getFloat(@StyleableRes final int key, final float default) {
        final TypedValue typedValue = this.readTypedValue(key);
        return (typedValue != null) ? this.asFloat(typedValue, default) : default;
    }
    
    public final float getSize(@StyleableRes final int key, final float default) {
        final TypedValue typedValue = this.readTypedValue(key);
        return (typedValue != null) ? this.asSize(typedValue, default) : default;
    }
    
    @NotNull
    public final CharSequence getString(@StyleableRes final int key, @NotNull final String default) {
        Intrinsics.checkNotNullParameter((Object)default, "default");
        final TypedValue typedValue = this.readTypedValue(key);
        CharSequence charSequence = (typedValue != null) ? typedValue.string : null;
        if (charSequence == null) {
            charSequence = default;
        }
        return charSequence;
    }
    
    @Nullable
    public final String getString(@StyleableRes final int key) {
        final TypedValue typedValue = this.readTypedValue(key);
        if (typedValue != null) {
            final CharSequence string = typedValue.string;
            if (string != null) {
                return string.toString();
            }
        }
        return null;
    }
    
    public final boolean getBoolean(@StyleableRes final int key, final boolean default) {
        final TypedValue typedValue = this.readTypedValue(key);
        return (typedValue != null) ? this.asBoolean(typedValue, default) : default;
    }
    
    private final boolean asBoolean(final TypedValue $this$asBoolean, final boolean default) {
        boolean b;
        if ($this$asBoolean.type == 0) {
            b = default;
        }
        else {
            if ($this$asBoolean.type < 16 || $this$asBoolean.type > 31) {
                throw new RuntimeException("Type mismatch");
            }
            b = ($this$asBoolean.data != 0);
        }
        return b;
    }
    
    private final int asInt(final TypedValue $this$asInt, final int default) {
        int n;
        if ($this$asInt.type == 0) {
            n = default;
        }
        else if ($this$asInt.type == 4) {
            n = MathKt.roundToInt($this$asInt.getFloat());
        }
        else {
            if ($this$asInt.type < 16 || $this$asInt.type > 31) {
                throw new RuntimeException("Type mismatch");
            }
            n = $this$asInt.data;
        }
        return n;
    }
    
    private final float asFloat(final TypedValue $this$asFloat, final float default) {
        float float1;
        if ($this$asFloat.type == 0) {
            float1 = default;
        }
        else if ($this$asFloat.type == 4) {
            float1 = $this$asFloat.getFloat();
        }
        else {
            if ($this$asFloat.type < 16 || $this$asFloat.type > 31) {
                throw new RuntimeException("Type mismatch");
            }
            float1 = (float)$this$asFloat.data;
        }
        return float1;
    }
    
    private final float asSize(final TypedValue $this$asSize, final float default) {
        float float1;
        if ($this$asSize.type == 0) {
            float1 = default;
        }
        else if ($this$asSize.type == 4) {
            float1 = $this$asSize.getFloat();
        }
        else {
            if ($this$asSize.type < 16 || $this$asSize.type > 31) {
                throw new RuntimeException("Type mismatch");
            }
            float1 = (float)$this$asSize.data;
        }
        return float1 * $this$asSize.density;
    }
}
