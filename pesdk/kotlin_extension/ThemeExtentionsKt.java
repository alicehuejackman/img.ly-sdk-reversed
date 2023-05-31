// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import android.content.res.TypedArray;
import kotlin.jvm.internal.Intrinsics;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import androidx.annotation.StyleRes;
import androidx.annotation.AttrRes;
import androidx.annotation.StyleableRes;
import org.jetbrains.annotations.Nullable;
import android.util.AttributeSet;
import org.jetbrains.annotations.NotNull;
import android.content.res.Resources$Theme;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u00004\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a_\u0010\u0000\u001a\u00020\u0001*\u00060\u0002R\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0001\u0010\u0006\u001a\u00020\u00072\b\b\u0001\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\t2!\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00010\fH\u0086\b\u00f8\u0001\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0011" }, d2 = { "readStyledAttributes", "", "Landroid/content/res/Resources$Theme;", "Landroid/content/res/Resources;", "set", "Landroid/util/AttributeSet;", "attrs", "", "defStyleAttr", "", "defStyleRes", "block", "Lkotlin/Function1;", "Lly/img/android/pesdk/kotlin_extension/ExtendedTypedArray;", "Lkotlin/ParameterName;", "name", "it", "pesdk-backend-core_release" })
public final class ThemeExtentionsKt
{
    public static final void readStyledAttributes(@NotNull final Resources$Theme $this$readStyledAttributes, @Nullable final AttributeSet set, @StyleableRes @NotNull final int[] attrs, @AttrRes final int defStyleAttr, @StyleRes final int defStyleRes, @NotNull final Function1<? super ExtendedTypedArray, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$readStyledAttributes, "<this>");
        Intrinsics.checkNotNullParameter((Object)attrs, "attrs");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$readStyledAttributes = 0;
        final TypedArray it = $this$readStyledAttributes.obtainStyledAttributes(set, attrs, defStyleAttr, defStyleRes);
        final int n = 0;
        Intrinsics.checkNotNullExpressionValue((Object)it, "it");
        block.invoke((Object)new ExtendedTypedArray($this$readStyledAttributes, it));
        it.recycle();
    }
}
