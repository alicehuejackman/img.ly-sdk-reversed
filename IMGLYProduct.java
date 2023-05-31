// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android;

import ly.img.android.pesdk.ui.activity.ImgLyContext;
import android.content.Context;
import androidx.annotation.VisibleForTesting;
import java.util.HashSet;

public enum IMGLYProduct
{
    UNKNOWN(0) {
        @Override
        public final boolean hasFeature(final Feature feature) {
            return true;
        }
        
        @Override
        public final boolean isEnabled() {
            return true;
        }
        
        @Override
        public final boolean hasWatermark() {
            return true;
        }
        
        @Override
        public boolean hasBranding() {
            return true;
        }
        
        @Override
        public void saveEdit() {
        }
    }, 
    PESDK(1) {
        @Override
        public final boolean hasFeature(final Feature feature) {
            return feature == null || (ly.img.android.PESDK.hasFeature(feature) && !IMGLYProduct$2.forbiddenForTesting.contains(feature));
        }
        
        @Override
        public final boolean isEnabled() {
            return true;
        }
        
        @Override
        public final boolean hasWatermark() {
            return ly.img.android.PESDK.hasWatermark();
        }
        
        @Override
        public void saveEdit() {
            ly.img.android.PESDK.saveEdit();
        }
    }, 
    VESDK(2) {
        @Override
        public final boolean hasFeature(final Feature feature) {
            return feature == null || (ly.img.android.VESDK.hasFeature(feature) && !IMGLYProduct$3.forbiddenForTesting.contains(feature));
        }
        
        @Override
        public final boolean isEnabled() {
            return true;
        }
        
        @Override
        public final boolean hasWatermark() {
            return ly.img.android.VESDK.hasWatermark();
        }
        
        @Override
        public void saveEdit() {
            ly.img.android.VESDK.saveEdit();
        }
    };
    
    @VisibleForTesting(otherwise = 2)
    public static HashSet<Feature> forbiddenForTesting;
    
    public static IMGLYProduct getProductOfContext(final Context context) {
        if (context instanceof ImgLyContext) {
            final ImgLyContext imgLyContext = (ImgLyContext)context;
            return imgLyContext.getConfig().getProduct();
        }
        return IMGLYProduct.UNKNOWN;
    }
    
    public abstract void saveEdit();
    
    public abstract boolean isEnabled();
    
    public abstract boolean hasWatermark();
    
    public abstract boolean hasFeature(final Feature p0);
    
    public boolean hasBranding() {
        return !this.hasFeature(Feature.WHITE_LABEL);
    }
    
    private static /* synthetic */ IMGLYProduct[] $values() {
        return new IMGLYProduct[] { IMGLYProduct.UNKNOWN, IMGLYProduct.PESDK, IMGLYProduct.VESDK };
    }
    
    static {
        $VALUES = $values();
        IMGLYProduct.forbiddenForTesting = new HashSet<Feature>();
    }
}
