// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import ly.img.android.pesdk.ui.model.state.UiConfigTheme;
import androidx.annotation.NonNull;
import ly.img.android.pesdk.backend.model.state.manager.StateHandler;
import androidx.annotation.ColorInt;
import androidx.annotation.AnyRes;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.Resources;
import ly.img.android.R;
import ly.img.android.PESDK;
import java.util.Iterator;
import android.util.Log;
import java.util.ArrayList;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.reflect.KClass;
import androidx.annotation.ArrayRes;

public class ResourceUtils
{
    public static <T> Class<? extends T>[] recursiveClassArrayLoad(@ArrayRes final int arrayRes, final KClass<? extends T> type) {
        return (Class<? extends T>[])recursiveClassArrayLoad(arrayRes, (Class<?>)JvmClassMappingKt.getJavaClass((KClass)type));
    }
    
    public static <T> Class<? extends T>[] recursiveClassArrayLoad(@ArrayRes final int arrayRes, final Class<? extends T> type) {
        final ArrayList<String> potentialClasses = new ArrayList<String>();
        recursiveStringArrayLoad(arrayRes, potentialClasses);
        final ArrayList<Class<? extends T>> classes = new ArrayList<Class<? extends T>>();
        for (final String className : potentialClasses) {
            try {
                final Class potentialClass = Class.forName(className);
                if (!type.isAssignableFrom(potentialClass)) {
                    continue;
                }
                classes.add(potentialClass);
            }
            catch (ClassNotFoundException e) {
                Log.i("PESDK", "Info: \"" + className + "\" not found. This is just an info, if you don't have integrated the specific module.");
            }
        }
        return classes.toArray(new Class[classes.size()]);
    }
    
    public static void recursiveStringArrayLoad(@ArrayRes final int arrayRes, final ArrayList<String> strings) {
        final Resources resources = PESDK.getAppResource();
        final TypedArray typedArray = resources.obtainTypedArray(arrayRes);
        for (int i = 0, l = typedArray.length(); i < l; ++i) {
            final int subArrayId = typedArray.getResourceId(i, R.array.imgly_empty_array);
            if (subArrayId == R.array.imgly_empty_array) {
                final String className = typedArray.getString(i);
                strings.add(className);
            }
            else {
                recursiveStringArrayLoad(subArrayId, strings);
            }
        }
    }
    
    public static int getStyledColor(final Context context, @AnyRes final int resourceId, @ColorInt final Integer staticColor) {
        StateHandler stateHandler = null;
        try {
            stateHandler = StateHandler.findInViewContext(context);
        }
        catch (StateHandler.StateHandlerNotFoundException e) {
            e.printStackTrace();
        }
        if (stateHandler == null) {
            return -65281;
        }
        return getStyledColor(stateHandler, resourceId, staticColor);
    }
    
    public static int getStyledColor(@NonNull final StateHandler stateHandler, @AnyRes final int resourceId, @ColorInt final Integer staticColor) {
        if (staticColor == null) {
            final TypedArray typedArray = PESDK.getAppContext().obtainStyledAttributes(stateHandler.getStateModel(UiConfigTheme.class).getTheme(), new int[] { resourceId });
            final int colorToReturn = typedArray.getColor(0, -65281);
            typedArray.recycle();
            return colorToReturn;
        }
        return staticColor;
    }
}
