// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import java.util.Iterator;
import android.graphics.Paint;
import java.util.Map;
import androidx.annotation.NonNull;
import android.view.View;
import java.util.HashMap;
import android.animation.Animator;

public class SetHardwareAnimatedViews implements Animator.AnimatorListener
{
    @NonNull
    private final HashMap<View, Integer> viewsHash;
    
    public SetHardwareAnimatedViews(@NonNull final View mainView, @NonNull final View... views) {
        (this.viewsHash = new HashMap<View, Integer>()).put(mainView, mainView.getLayerType());
        for (final View view : views) {
            this.viewsHash.put(view, view.getLayerType());
        }
    }
    
    public final void onAnimationStart(final Animator animator) {
        for (final Map.Entry<View, Integer> entry : this.viewsHash.entrySet()) {
            final View view = entry.getKey();
            entry.setValue(view.getLayerType());
            view.setLayerType(2, (Paint)null);
        }
    }
    
    public final void onAnimationEnd(final Animator animator) {
        for (final Map.Entry<View, Integer> entry : this.viewsHash.entrySet()) {
            final View view = entry.getKey();
            view.setLayerType((int)entry.getValue(), (Paint)null);
        }
    }
    
    public final void onAnimationCancel(final Animator animator) {
    }
    
    public final void onAnimationRepeat(final Animator animator) {
    }
}
