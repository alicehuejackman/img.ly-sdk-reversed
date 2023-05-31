// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import org.jetbrains.annotations.Nullable;
import kotlin.jvm.JvmStatic;
import java.io.Serializable;
import android.os.Parcelable;
import java.util.Locale;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import android.content.Intent;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J1\u0010\u0003\u001a\u0004\u0018\u0001H\u0004\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\nH\u0007¢\u0006\u0002\u0010\u000bJ9\u0010\f\u001a\u00020\r\"\u0004\b\u0000\u0010\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\n\u0010\t\u001a\u0006\u0012\u0002\b\u00030\n2\b\u0010\u000e\u001a\u0004\u0018\u0001H\u0004H\u0007¢\u0006\u0002\u0010\u000f¨\u0006\u0010" }, d2 = { "Lly/img/android/pesdk/kotlin_extension/IntentHelper;", "", "()V", "read", "T", "intent", "Landroid/content/Intent;", "id", "", "typeClass", "Lkotlin/reflect/KClass;", "(Landroid/content/Intent;Ljava/lang/String;Lkotlin/reflect/KClass;)Ljava/lang/Object;", "write", "", "value", "(Landroid/content/Intent;Ljava/lang/String;Lkotlin/reflect/KClass;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
public final class IntentHelper
{
    @NotNull
    public static final IntentHelper INSTANCE;
    
    private IntentHelper() {
    }
    
    @JvmStatic
    @Nullable
    public static final <T> T read(@NotNull final Intent intent, @NotNull final String id, @NotNull final KClass<?> typeClass) {
        Intrinsics.checkNotNullParameter((Object)intent, "intent");
        Intrinsics.checkNotNullParameter((Object)id, "id");
        Intrinsics.checkNotNullParameter((Object)typeClass, "typeClass");
        final String simpleName2 = JvmClassMappingKt.getJavaClass((KClass)typeClass).getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)simpleName2, "typeClass.java.simpleName");
        final String s = simpleName2;
        final Locale root = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue((Object)root, "ROOT");
        final String lowerCase = s.toLowerCase(root);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(locale)");
        final String simpleName = lowerCase;
        if (!intent.hasExtra(id)) {
            return null;
        }
        Object o;
        if (Intrinsics.areEqual((Object)simpleName, (Object)"boolean")) {
            o = intent.getBooleanExtra(id, false);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"byte")) {
            o = intent.getByteExtra(id, (byte)(-1));
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"short")) {
            o = intent.getShortExtra(id, (short)(-1));
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"long")) {
            o = intent.getLongExtra(id, -1L);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"char")) {
            o = intent.getCharExtra(id, ' ');
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"int") || Intrinsics.areEqual((Object)simpleName, (Object)"integer")) {
            o = intent.getIntExtra(id, -1);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"double")) {
            o = intent.getDoubleExtra(id, Double.NaN);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"float")) {
            o = intent.getFloatExtra(id, Float.NaN);
        }
        else if (Parcelable.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass)typeClass))) {
            if ((o = intent.getParcelableExtra(id)) == null) {
                o = null;
            }
        }
        else {
            if (!Serializable.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass)typeClass))) {
                throw new IllegalArgumentException();
            }
            if ((o = intent.getSerializableExtra(id)) == null) {
                o = null;
            }
        }
        final Object o2 = o;
        if (o2 == null) {}
        return (T)o2;
    }
    
    @JvmStatic
    public static final <T> void write(@NotNull final Intent intent, @NotNull final String id, @NotNull final KClass<?> typeClass, @Nullable final T value) {
        Intrinsics.checkNotNullParameter((Object)intent, "intent");
        Intrinsics.checkNotNullParameter((Object)id, "id");
        Intrinsics.checkNotNullParameter((Object)typeClass, "typeClass");
        final String simpleName2 = JvmClassMappingKt.getJavaClass((KClass)typeClass).getSimpleName();
        Intrinsics.checkNotNullExpressionValue((Object)simpleName2, "typeClass.java.simpleName");
        final String s = simpleName2;
        final Locale root = Locale.ROOT;
        Intrinsics.checkNotNullExpressionValue((Object)root, "ROOT");
        final String lowerCase = s.toLowerCase(root);
        Intrinsics.checkNotNullExpressionValue((Object)lowerCase, "this as java.lang.String).toLowerCase(locale)");
        final String simpleName = lowerCase;
        if (Intrinsics.areEqual((Object)simpleName, (Object)"boolean")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"byte")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"short")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"long")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"char")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"int") || Intrinsics.areEqual((Object)simpleName, (Object)"integer")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"double")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Intrinsics.areEqual((Object)simpleName, (Object)"float")) {
            intent.putExtra(id, (Serializable)value);
        }
        else if (Parcelable.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass)typeClass))) {
            intent.putExtra(id, (Parcelable)value);
        }
        else {
            if (!Serializable.class.isAssignableFrom(JvmClassMappingKt.getJavaClass((KClass)typeClass))) {
                throw new IllegalArgumentException();
            }
            intent.putExtra(id, (Serializable)value);
        }
    }
    
    static {
        INSTANCE = new IntentHelper();
    }
}
