// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import java.lang.annotation.Annotation;
import android.util.Log;
import kotlin.collections.ArraysKt;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import kotlin.jvm.JvmStatic;
import androidx.annotation.IntRange;
import androidx.annotation.CallSuper;
import ly.img.android.opengl.EGLLogWrapper;
import android.opengl.GLES20;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import kotlin.jvm.JvmField;
import java.util.concurrent.atomic.AtomicBoolean;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;
import ly.img.android.opengl.canvas.GlObject;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0010\t\n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0002\b\u000e\n\u0002\u0010\u000e\n\u0002\b\u0007\b'\u0018\u0000 ?2\u00020\u0001:\u0004?@ABB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010,\u001a\u00020-H\u0007J\u0010\u0010.\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0016J\u0018\u0010.\u001a\u00020-2\u0006\u00100\u001a\u00020\u00032\u0006\u0010/\u001a\u00020\u0003H\u0016J&\u00101\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003J\b\u00102\u001a\u00020-H\u0004J\u0010\u00103\u001a\u00020-2\u0006\u00104\u001a\u00020\u0003H&J\b\u00105\u001a\u00020-H\u0015J\b\u00106\u001a\u00020-H\u0015J\u0018\u00107\u001a\u00020-2\u0006\u00108\u001a\u00020\u00032\b\b\u0002\u00109\u001a\u00020\u0003J\u001e\u00107\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u00109\u001a\u00020\u0003J(\u00107\u001a\u00020-2\u0006\u0010\u000f\u001a\u00020\u00032\u0006\u0010$\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010(\u001a\u00020\u0003H\u0016J\b\u0010:\u001a\u00020-H\u0015J\b\u0010;\u001a\u00020<H\u0016J\b\u0010=\u001a\u00020-H\u0014J\b\u0010>\u001a\u00020\u0017H\u0016R\u001a\u0010\u0005\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\u0004R\u001a\u0010\t\u001a\u00020\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u0018\u0010\u000f\u001a\u00020\u00038\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0012\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0007R\u0018\u0010\u0014\u001a\u00020\u00038\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b\u0015\u0010\u0011R \u0010\u0018\u001a\u00020\u00172\u0006\u0010\u0016\u001a\u00020\u00178F@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\u0017X¦\u0004¢\u0006\u0006\u001a\u0004\b\u001a\u0010\u0019R$\u0010\u001c\u001a\u00020\u00032\u0006\u0010\u001b\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\u0007\"\u0004\b\u001e\u0010\u0004R\u0012\u0010\u001f\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b \u0010\u0007R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b!\u0010\u0007R\u0012\u0010\"\u001a\u00020\u0003X¦\u0004¢\u0006\u0006\u001a\u0004\b#\u0010\u0007R\u0018\u0010$\u001a\u00020\u00038\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b%\u0010\u0011R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000R\u0018\u0010(\u001a\u00020\u00038\u0004@\u0004X\u0085\u000e¢\u0006\b\n\u0000\u0012\u0004\b)\u0010\u0011R\u0011\u0010*\u001a\u00020\u00038F¢\u0006\u0006\u001a\u0004\b+\u0010\u0007¨\u0006C" }, d2 = { "Lly/img/android/opengl/textures/GlTexture;", "Lly/img/android/opengl/canvas/GlObject;", "textureTarget", "", "(I)V", "_textureHandle", "get_textureHandle", "()I", "set_textureHandle", "changeCount", "", "getChangeCount", "()J", "setChangeCount", "(J)V", "downScaleFiltering", "getDownScaleFiltering$annotations", "()V", "height", "getHeight", "horizontalWrap", "getHorizontalWrap$annotations", "<set-?>", "", "isAttached", "()Z", "isExternalTexture", "value", "textureHandle", "getTextureHandle", "setTextureHandle", "textureHeight", "getTextureHeight", "getTextureTarget", "textureWidth", "getTextureWidth", "upScaleFiltering", "getUpScaleFiltering$annotations", "updateNextFrame", "Ljava/util/concurrent/atomic/AtomicBoolean;", "verticalWrap", "getVerticalWrap$annotations", "width", "getWidth", "attach", "", "bindTexture", "slot", "uniform", "changeBehave", "markDirty", "onAttach", "handle", "onRebound", "onRelease", "setBehave", "filtering", "wrap", "textureChanged", "toString", "", "updateMipmapIfNeeded", "useMipmap", "Companion", "Filtering", "Slot", "Wrap", "pesdk-backend-core_release" })
@WorkerThread
public abstract class GlTexture extends GlObject
{
    @NotNull
    public static final Companion Companion;
    private final int textureTarget;
    private int _textureHandle;
    private long changeCount;
    @NotNull
    private final AtomicBoolean updateNextFrame;
    @JvmField
    protected int downScaleFiltering;
    @JvmField
    protected int upScaleFiltering;
    @JvmField
    protected int horizontalWrap;
    @JvmField
    protected int verticalWrap;
    private boolean isAttached;
    private static int MAX_VIEW_PORT;
    private static int MAX_FRAME_BUFFER;
    private static int MAX_TEXTURE_SIZE;
    private static int MAX_TEXTURE_UNITS;
    
    public GlTexture(final int textureTarget) {
        super(null, 1, null);
        this.textureTarget = textureTarget;
        this._textureHandle = -1;
        this.updateNextFrame = new AtomicBoolean();
        this.downScaleFiltering = 9728;
        this.upScaleFiltering = 9728;
        this.horizontalWrap = 33071;
        this.verticalWrap = 33071;
    }
    
    public final int getTextureTarget() {
        return this.textureTarget;
    }
    
    protected final int get_textureHandle() {
        return this._textureHandle;
    }
    
    protected final void set_textureHandle(final int <set-?>) {
        this._textureHandle = <set-?>;
    }
    
    public final int getTextureHandle() {
        if (this._textureHandle == -1) {
            this.attach();
        }
        return this._textureHandle;
    }
    
    public final void setTextureHandle(final int value) {
        this._textureHandle = value;
    }
    
    public final long getChangeCount() {
        return this.changeCount;
    }
    
    public final void setChangeCount(final long <set-?>) {
        this.changeCount = <set-?>;
    }
    
    public abstract boolean isExternalTexture();
    
    public final int getWidth() {
        return this.getTextureWidth();
    }
    
    public final int getHeight() {
        return this.getTextureHeight();
    }
    
    public abstract int getTextureWidth();
    
    public abstract int getTextureHeight();
    
    public void bindTexture(final int uniform, final int slot) {
        GLES20.glUniform1i(uniform, slot - 33984);
        GLES20.glActiveTexture(slot);
        GLES20.glBindTexture(this.textureTarget, this.getTextureHandle());
        EGLLogWrapper.readGlError();
    }
    
    public int bindTexture(final int slot) {
        GLES20.glActiveTexture(slot);
        GLES20.glBindTexture(this.textureTarget, this.getTextureHandle());
        EGLLogWrapper.readGlError();
        return slot - 33984;
    }
    
    protected final void markDirty() {
        this.updateNextFrame.set(true);
    }
    
    @WorkerThread
    protected void textureChanged() {
        this.updateMipmapIfNeeded();
        ++this.changeCount;
    }
    
    public final boolean isAttached() {
        return this.isAttached && this._textureHandle != -1;
    }
    
    @CallSuper
    public final void attach() {
        if (this._textureHandle == -1) {
            this._textureHandle = GlTexture.Companion.glGenTexture();
            if (this._textureHandle == -1) {
                final int n = 0;
                throw new IllegalArgumentException(("Can't create texture: " + GLES20.glGetError()).toString());
            }
            this.onAttach(this._textureHandle);
            this.isAttached = true;
        }
    }
    
    public abstract void onAttach(final int p0);
    
    @CallSuper
    @Override
    protected void onRelease() {
        if (this._textureHandle != -1) {
            GlTexture.Companion.glDeleteTexture(this._textureHandle);
            this._textureHandle = -1;
        }
    }
    
    @CallSuper
    @Override
    protected void onRebound() {
        super.onRebound();
        this.setBehave(this.downScaleFiltering, this.upScaleFiltering, this.horizontalWrap, this.verticalWrap);
    }
    
    public final void setBehave(final int filtering, final int wrap) {
        this.setBehave(filtering, filtering, wrap, wrap);
    }
    
    public final void setBehave(final int downScaleFiltering, final int upScaleFiltering, final int wrap) {
        this.setBehave(downScaleFiltering, upScaleFiltering, wrap, wrap);
    }
    
    public void setBehave(final int downScaleFiltering, final int upScaleFiltering, final int horizontalWrap, final int verticalWrap) {
        this.downScaleFiltering = downScaleFiltering;
        this.upScaleFiltering = GlTexture.Companion.getFilterModeWithoutMipmap(upScaleFiltering);
        this.horizontalWrap = horizontalWrap;
        this.verticalWrap = verticalWrap;
        if (this.getTextureHandle() == -1) {
            this.attach();
        }
        else {
            GLES20.glBindTexture(this.textureTarget, this.getTextureHandle());
            GLES20.glPixelStorei(3317, 1);
            GLES20.glTexParameteri(this.textureTarget, 10241, this.downScaleFiltering);
            GLES20.glTexParameteri(this.textureTarget, 10240, this.upScaleFiltering);
            GLES20.glTexParameteri(this.textureTarget, 10242, this.horizontalWrap);
            GLES20.glTexParameteri(this.textureTarget, 10243, this.verticalWrap);
            EGLLogWrapper.readGlError();
        }
    }
    
    protected void updateMipmapIfNeeded() {
        if (this.useMipmap()) {
            GLES20.glBindTexture(this.textureTarget, this.getTextureHandle());
            GLES20.glGenerateMipmap(this.textureTarget);
            EGLLogWrapper.readGlError();
        }
    }
    
    public boolean useMipmap() {
        return GlTexture.Companion.isMipmapFilterMode(this.downScaleFiltering);
    }
    
    public final void changeBehave(final int downScaleFiltering, final int upScaleFiltering, final int horizontalWrap, final int verticalWrap) {
        if (this.downScaleFiltering != downScaleFiltering || this.upScaleFiltering != upScaleFiltering || this.horizontalWrap != horizontalWrap || this.verticalWrap != verticalWrap) {
            this.setBehave(downScaleFiltering, upScaleFiltering, horizontalWrap, verticalWrap);
        }
    }
    
    @NotNull
    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "(textureHandle=" + this._textureHandle + ", textureWidth=" + this.getTextureWidth() + ", textureHeight=" + this.getTextureHeight() + ", isExternalTexture=" + this.isExternalTexture() + ')';
    }
    
    @WorkerThread
    public static final int getMaxTextureUnits() {
        return GlTexture.Companion.getMaxTextureUnits();
    }
    
    @WorkerThread
    public static final int getMaxTextureSize() {
        return GlTexture.Companion.getMaxTextureSize();
    }
    
    @WorkerThread
    public static final int getMaxViewPortSize() {
        return GlTexture.Companion.getMaxViewPortSize();
    }
    
    @WorkerThread
    public static final int getMaxFrameBufferSize() {
        return GlTexture.Companion.getMaxFrameBufferSize();
    }
    
    @JvmStatic
    public static final int upscaleValueToPowOfTwo(@IntRange(from = 2L, to = 65536L) final int value) {
        return GlTexture.Companion.upscaleValueToPowOfTwo(value);
    }
    
    @JvmStatic
    public static final boolean isMipmapFilterMode(final int filterMode) {
        return GlTexture.Companion.isMipmapFilterMode(filterMode);
    }
    
    @JvmStatic
    public static final int getFilterModeWithoutMipmap(final int filterMode) {
        return GlTexture.Companion.getFilterModeWithoutMipmap(filterMode);
    }
    
    public static final /* synthetic */ int access$getMAX_TEXTURE_UNITS$cp() {
        return GlTexture.MAX_TEXTURE_UNITS;
    }
    
    public static final /* synthetic */ void access$setMAX_TEXTURE_UNITS$cp(final int <set-?>) {
        GlTexture.MAX_TEXTURE_UNITS = <set-?>;
    }
    
    public static final /* synthetic */ int access$getMAX_TEXTURE_SIZE$cp() {
        return GlTexture.MAX_TEXTURE_SIZE;
    }
    
    public static final /* synthetic */ void access$setMAX_TEXTURE_SIZE$cp(final int <set-?>) {
        GlTexture.MAX_TEXTURE_SIZE = <set-?>;
    }
    
    public static final /* synthetic */ void access$setMAX_FRAME_BUFFER$cp(final int <set-?>) {
        GlTexture.MAX_FRAME_BUFFER = <set-?>;
    }
    
    public static final /* synthetic */ int access$getMAX_VIEW_PORT$cp() {
        return GlTexture.MAX_VIEW_PORT;
    }
    
    public static final /* synthetic */ void access$setMAX_VIEW_PORT$cp(final int <set-?>) {
        GlTexture.MAX_VIEW_PORT = <set-?>;
    }
    
    public static final /* synthetic */ int access$getMAX_FRAME_BUFFER$cp() {
        return GlTexture.MAX_FRAME_BUFFER;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0013\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0015\u001a\u00020\u00042\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u000e\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001a\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u000e\u0010\u001b\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004J\u0006\u0010\u001c\u001a\u00020\u0004J\u0006\u0010\u001d\u001a\u00020\u0004J\u0006\u0010\u001e\u001a\u00020\u0004J\u0010\u0010\u001f\u001a\u00020 2\u0006\u0010\u0016\u001a\u00020\u0004H\u0007J\u0012\u0010!\u001a\u00020\u00042\b\b\u0001\u0010\"\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0002\u001a\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u0002\u001a\u0004\b\u000e\u0010\u000bR\u001a\u0010\u000f\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0010\u0010\u0002\u001a\u0004\b\u0011\u0010\u000bR\u001a\u0010\u0012\u001a\u00020\u00048GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0013\u0010\u0002\u001a\u0004\b\u0014\u0010\u000b¨\u0006#" }, d2 = { "Lly/img/android/opengl/textures/GlTexture$Companion;", "", "()V", "MAX_FRAME_BUFFER", "", "MAX_TEXTURE_SIZE", "MAX_TEXTURE_UNITS", "MAX_VIEW_PORT", "maxFrameBufferSize", "getMaxFrameBufferSize$annotations", "getMaxFrameBufferSize", "()I", "maxTextureSize", "getMaxTextureSize$annotations", "getMaxTextureSize", "maxTextureUnits", "getMaxTextureUnits$annotations", "getMaxTextureUnits", "maxViewPortSize", "getMaxViewPortSize$annotations", "getMaxViewPortSize", "getFilterModeWithoutMipmap", "filterMode", "glDeleteFramebuffer", "", "handle", "glDeleteRenderbuffer", "glDeleteTexture", "glGenFramebuffer", "glGenRenderbuffer", "glGenTexture", "isMipmapFilterMode", "", "upscaleValueToPowOfTwo", "value", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @WorkerThread
        public final int getMaxTextureUnits() {
            if (GlTexture.access$getMAX_TEXTURE_UNITS$cp() == 0) {
                final int[] it = { 0 };
                final int n = 0;
                GLES20.glGetIntegerv(34930, it, 0);
                GlTexture.access$setMAX_TEXTURE_UNITS$cp(it[0]);
            }
            return GlTexture.access$getMAX_TEXTURE_UNITS$cp();
        }
        
        @WorkerThread
        public final int getMaxTextureSize() {
            if (GlTexture.access$getMAX_TEXTURE_SIZE$cp() == 0) {
                final int[] it = { 0 };
                final int n = 0;
                GLES20.glGetIntegerv(3379, it, 0);
                GlTexture.access$setMAX_TEXTURE_SIZE$cp(it[0]);
                GlTexture.access$setMAX_FRAME_BUFFER$cp(TypeExtensionsKt.butMax(GlTexture.access$getMAX_TEXTURE_SIZE$cp(), GlTexture.access$getMAX_VIEW_PORT$cp()));
            }
            return GlTexture.access$getMAX_TEXTURE_SIZE$cp();
        }
        
        @WorkerThread
        public final int getMaxViewPortSize() {
            if (GlTexture.access$getMAX_VIEW_PORT$cp() == 0) {
                final int[] it = new int[2];
                final int n = 0;
                GLES20.glGetIntegerv(3386, it, 0);
                final Integer minOrNull = ArraysKt.minOrNull(it);
                GlTexture.access$setMAX_VIEW_PORT$cp((minOrNull != null) ? ((int)minOrNull) : 1024);
                GlTexture.access$setMAX_FRAME_BUFFER$cp(TypeExtensionsKt.butMax(GlTexture.access$getMAX_VIEW_PORT$cp(), GlTexture.access$getMAX_TEXTURE_SIZE$cp()));
            }
            return GlTexture.access$getMAX_TEXTURE_SIZE$cp();
        }
        
        @WorkerThread
        public final int getMaxFrameBufferSize() {
            if (GlTexture.access$getMAX_FRAME_BUFFER$cp() == 0) {
                GlTexture.access$setMAX_FRAME_BUFFER$cp(Math.max(this.getMaxTextureSize(), this.getMaxViewPortSize()));
            }
            return GlTexture.access$getMAX_FRAME_BUFFER$cp();
        }
        
        @JvmStatic
        public final int upscaleValueToPowOfTwo(@IntRange(from = 2L, to = 65536L) final int value) {
            int n2;
            if ((value & value - 1) != 0x0) {
                int n = value - 1;
                n |= n >> 1;
                n |= n >> 2;
                n |= n >> 4;
                n |= n >> 8;
                n2 = n + 1;
            }
            else {
                n2 = value;
            }
            return n2;
        }
        
        @JvmStatic
        public final boolean isMipmapFilterMode(final int filterMode) {
            boolean b = false;
            switch (filterMode) {
                case 9984:
                case 9985:
                case 9986:
                case 9987: {
                    b = true;
                    break;
                }
                case 9728:
                case 9729: {
                    b = false;
                    break;
                }
                default: {
                    Log.e("GLT", "Error: filterMode is unknown MipMap is not created and texture is maybe black.");
                    b = false;
                    break;
                }
            }
            return b;
        }
        
        @JvmStatic
        public final int getFilterModeWithoutMipmap(final int filterMode) {
            int n = 0;
            switch (filterMode) {
                case 9985:
                case 9987: {
                    n = 9729;
                    break;
                }
                case 9984:
                case 9986: {
                    n = 9728;
                    break;
                }
                default: {
                    n = filterMode;
                    break;
                }
            }
            return n;
        }
        
        public final int glGenTexture() {
            final int[] it;
            final int[] array = it = new int[] { 0 };
            final int n = 0;
            GlObject.Companion.freeMemory();
            GLES20.glGenTextures(it.length, it, 0);
            return array[0];
        }
        
        public final int glGenFramebuffer() {
            final int[] it;
            final int[] array = it = new int[] { 0 };
            final int n = 0;
            GlObject.Companion.freeMemory();
            GLES20.glGenFramebuffers(it.length, it, 0);
            return array[0];
        }
        
        public final int glGenRenderbuffer() {
            final int[] it;
            final int[] array = it = new int[] { 0 };
            final int n = 0;
            GlObject.Companion.freeMemory();
            GLES20.glGenRenderbuffers(it.length, it, 0);
            return array[0];
        }
        
        public final void glDeleteFramebuffer(final int handle) {
            final int[] it = { handle };
            final int n = 0;
            GLES20.glDeleteFramebuffers(it.length, it, 0);
            GLES20.glFinish();
        }
        
        public final void glDeleteRenderbuffer(final int handle) {
            final int[] it = { handle };
            final int n = 0;
            GLES20.glDeleteRenderbuffers(it.length, it, 0);
            GLES20.glFinish();
        }
        
        public final void glDeleteTexture(final int handle) {
            final int[] it = { handle };
            final int n = 0;
            GLES20.glDeleteTextures(it.length, it, 0);
            GLES20.glFinish();
        }
    }
    
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002" }, d2 = { "Lly/img/android/opengl/textures/GlTexture$Filtering;", "", "pesdk-backend-core_release" })
    public @interface Filtering {
    }
    
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002" }, d2 = { "Lly/img/android/opengl/textures/GlTexture$Wrap;", "", "pesdk-backend-core_release" })
    public @interface Wrap {
    }
    
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0087\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002" }, d2 = { "Lly/img/android/opengl/textures/GlTexture$Slot;", "", "pesdk-backend-core_release" })
    public @interface Slot {
    }
}
