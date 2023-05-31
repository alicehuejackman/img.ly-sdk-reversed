// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.textures;

import kotlin.Unit;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import androidx.annotation.AnyThread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.atomic.AtomicBoolean;
import android.graphics.SurfaceTexture;
import org.jetbrains.annotations.Nullable;
import android.view.Surface;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000B\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u0002\n\u0002\b\u0010\b\u0016\u0018\u00002\u00020\u00012\u00020\u0002B\u0019\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004¢\u0006\u0002\u0010\u0006J\u0018\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016J\u0018\u0010%\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00042\u0006\u0010$\u001a\u00020\u0004H\u0016J\b\u0010&\u001a\u00020\"H\u0016J\u0010\u0010'\u001a\u00020\"2\u0006\u0010(\u001a\u00020\u0004H\u0016J\b\u0010)\u001a\u00020\"H\u0014J(\u0010*\u001a\u00020\"2\u0006\u0010+\u001a\u00020\u00042\u0006\u0010,\u001a\u00020\u00042\u0006\u0010-\u001a\u00020\u00042\u0006\u0010.\u001a\u00020\u0004H\u0016J\u0018\u0010/\u001a\u00020\"2\u0006\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004H\u0016J\b\u00100\u001a\u00020\"H\u0014J\b\u00101\u001a\u00020\bH\u0016R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\"\u0010\u0016\u001a\u0004\u0018\u00010\u00152\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R&\u0010\u0019\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048W@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR&\u0010\u001e\u001a\u00020\u00042\u0006\u0010\u0014\u001a\u00020\u00048W@TX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u001b\"\u0004\b \u0010\u001d¨\u00062" }, d2 = { "Lly/img/android/opengl/textures/GlSurfaceTexture;", "Lly/img/android/opengl/textures/GlTexture;", "Lly/img/android/opengl/textures/AsyncTextureInterface;", "width", "", "height", "(II)V", "isExternalTexture", "", "()Z", "mipMapTexture", "Lly/img/android/opengl/textures/GlFrameBufferTexture;", "needUpdateNextFrame", "Ljava/util/concurrent/atomic/AtomicBoolean;", "surface", "Landroid/view/Surface;", "getSurface", "()Landroid/view/Surface;", "setSurface", "(Landroid/view/Surface;)V", "<set-?>", "Landroid/graphics/SurfaceTexture;", "surfaceTexture", "getSurfaceTexture", "()Landroid/graphics/SurfaceTexture;", "textureHeight", "getTextureHeight", "()I", "setTextureHeight", "(I)V", "textureWidth", "getTextureWidth", "setTextureWidth", "bindBaseTexture", "", "uniform", "slot", "bindTexture", "invalidateSurface", "onAttach", "handle", "onRelease", "setBehave", "downScaleFiltering", "upScaleFiltering", "horizontalWrap", "verticalWrap", "setSize", "updateMipmapIfNeeded", "updateTexture", "pesdk-backend-core_release" })
public class GlSurfaceTexture extends GlTexture implements AsyncTextureInterface
{
    @Nullable
    private Surface surface;
    @Nullable
    private SurfaceTexture surfaceTexture;
    private int textureWidth;
    private int textureHeight;
    @NotNull
    private volatile AtomicBoolean needUpdateNextFrame;
    @Nullable
    private GlFrameBufferTexture mipMapTexture;
    
    public GlSurfaceTexture(final int width, final int height) {
        super(36197);
        this.needUpdateNextFrame = new AtomicBoolean(false);
        this.setTextureWidth(width);
        this.setTextureHeight(height);
    }
    
    @Nullable
    protected final Surface getSurface() {
        return this.surface;
    }
    
    protected final void setSurface(@Nullable final Surface <set-?>) {
        this.surface = <set-?>;
    }
    
    @Nullable
    public final SurfaceTexture getSurfaceTexture() {
        return this.surfaceTexture;
    }
    
    @AnyThread
    @Override
    public int getTextureWidth() {
        return this.textureWidth;
    }
    
    protected void setTextureWidth(final int <set-?>) {
        this.textureWidth = <set-?>;
    }
    
    @AnyThread
    @Override
    public int getTextureHeight() {
        return this.textureHeight;
    }
    
    protected void setTextureHeight(final int <set-?>) {
        this.textureHeight = <set-?>;
    }
    
    @Override
    public boolean isExternalTexture() {
        return this.mipMapTexture == null;
    }
    
    @Override
    public void onAttach(final int handle) {
        this.setBehave(this.upScaleFiltering, this.downScaleFiltering, this.horizontalWrap, this.verticalWrap);
        if (this.surfaceTexture == null) {
            this.surfaceTexture = new SurfaceTexture(handle);
        }
        final int textureWidth = this.getTextureWidth();
        final int textureHeight = this.getTextureHeight();
        this.setTextureWidth(0);
        this.setTextureHeight(0);
        this.setSize(textureWidth, textureHeight);
        if (this.surface == null) {
            this.surface = new Surface(this.surfaceTexture);
        }
    }
    
    @Override
    public void setBehave(final int downScaleFiltering, final int upScaleFiltering, final int horizontalWrap, final int verticalWrap) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getstatic       ly/img/android/opengl/textures/GlTexture.Companion:Lly/img/android/opengl/textures/GlTexture$Companion;
        //     4: iload_1         /* downScaleFiltering */
        //     5: invokevirtual   ly/img/android/opengl/textures/GlTexture$Companion.getFilterModeWithoutMipmap:(I)I
        //     8: iload_2         /* upScaleFiltering */
        //     9: iload_3         /* horizontalWrap */
        //    10: iload           verticalWrap
        //    12: invokespecial   ly/img/android/opengl/textures/GlTexture.setBehave:(IIII)V
        //    15: aload_0         /* this */
        //    16: getstatic       ly/img/android/opengl/textures/GlTexture.Companion:Lly/img/android/opengl/textures/GlTexture$Companion;
        //    19: iload_1         /* downScaleFiltering */
        //    20: invokevirtual   ly/img/android/opengl/textures/GlTexture$Companion.isMipmapFilterMode:(I)Z
        //    23: ifeq            75
        //    26: aload_0         /* this */
        //    27: getfield        ly/img/android/opengl/textures/GlSurfaceTexture.mipMapTexture:Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //    30: dup            
        //    31: ifnonnull       46
        //    34: pop            
        //    35: new             Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //    38: dup            
        //    39: iconst_0       
        //    40: iconst_0       
        //    41: iconst_3       
        //    42: aconst_null    
        //    43: invokespecial   ly/img/android/opengl/textures/GlFrameBufferTexture.<init>:(IIILkotlin/jvm/internal/DefaultConstructorMarker;)V
        //    46: astore          5
        //    48: aload           5
        //    50: astore          6
        //    52: astore          8
        //    54: iconst_0       
        //    55: istore          $i$a$-apply-GlSurfaceTexture$setBehave$1
        //    57: aload           $this$setBehave_u24lambda_u2d0
        //    59: iload_1         /* downScaleFiltering */
        //    60: iload_2         /* upScaleFiltering */
        //    61: iload_3         /* horizontalWrap */
        //    62: iload           verticalWrap
        //    64: invokevirtual   ly/img/android/opengl/textures/GlFrameBufferTexture.setBehave:(IIII)V
        //    67: nop            
        //    68: aload           8
        //    70: aload           5
        //    72: goto            76
        //    75: aconst_null    
        //    76: putfield        ly/img/android/opengl/textures/GlSurfaceTexture.mipMapTexture:Lly/img/android/opengl/textures/GlFrameBufferTexture;
        //    79: return         
        //    StackMapTable: 00 03 FF 00 2E 00 05 07 00 02 01 01 01 01 00 02 07 00 02 07 00 75 5C 07 00 02 FF 00 00 00 05 07 00 02 01 01 01 01 00 02 07 00 02 07 00 75
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        //     at com.strobel.decompiler.ast.AstBuilder.convertLocalVariables(AstBuilder.java:2895)
        //     at com.strobel.decompiler.ast.AstBuilder.performStackAnalysis(AstBuilder.java:2445)
        //     at com.strobel.decompiler.ast.AstBuilder.build(AstBuilder.java:108)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:211)
        //     at com.strobel.decompiler.languages.java.ast.AstMethodBodyBuilder.createMethodBody(AstMethodBodyBuilder.java:99)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethodBody(AstBuilder.java:782)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createMethod(AstBuilder.java:675)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addTypeMembers(AstBuilder.java:552)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeCore(AstBuilder.java:519)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createTypeNoCache(AstBuilder.java:161)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.createType(AstBuilder.java:150)
        //     at com.strobel.decompiler.languages.java.ast.AstBuilder.addType(AstBuilder.java:125)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.buildAst(JavaLanguage.java:71)
        //     at com.strobel.decompiler.languages.java.JavaLanguage.decompileType(JavaLanguage.java:59)
        //     at com.strobel.decompiler.DecompilerDriver.decompileType(DecompilerDriver.java:330)
        //     at com.strobel.decompiler.DecompilerDriver.decompileJar(DecompilerDriver.java:251)
        //     at com.strobel.decompiler.DecompilerDriver.main(DecompilerDriver.java:126)
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    @Override
    protected void onRelease() {
        super.onRelease();
        this.surfaceTexture = null;
        final Surface surface = this.surface;
        this.surface = null;
        final Surface surface2 = surface;
        if (surface2 != null) {
            surface2.release();
        }
    }
    
    public void setSize(final int width, final int height) {
        final int w = TypeExtensionsKt.butMax(width, GlTexture.Companion.getMaxFrameBufferSize());
        final int h = TypeExtensionsKt.butMax(height, GlTexture.Companion.getMaxFrameBufferSize());
        if (this.getTextureWidth() != w || this.getTextureHeight() != h) {
            final SurfaceTexture surfaceTexture = this.surfaceTexture;
            if (surfaceTexture != null) {
                surfaceTexture.setDefaultBufferSize(w, h);
            }
            this.setTextureWidth(w);
            this.setTextureHeight(h);
        }
    }
    
    @Override
    public boolean updateTexture() {
        if (this.needUpdateNextFrame.compareAndSet(true, false) && this.surfaceTexture != null) {
            try {
                final SurfaceTexture surfaceTexture = this.surfaceTexture;
                Unit instance;
                if (surfaceTexture != null) {
                    surfaceTexture.updateTexImage();
                    instance = Unit.INSTANCE;
                }
                else {
                    instance = null;
                }
                if (instance == null) {
                    return false;
                }
            }
            catch (IllegalStateException e) {
                return false;
            }
            this.textureChanged();
        }
        return true;
    }
    
    @Override
    protected void updateMipmapIfNeeded() {
        final GlFrameBufferTexture mipMapTexture = this.mipMapTexture;
        if (mipMapTexture != null) {
            GlFrameBufferTexture.copyFrom$default(mipMapTexture, this, 0, 0, 6, null);
        }
    }
    
    public void invalidateSurface() {
        this.needUpdateNextFrame.set(true);
        this.setChangeCount(this.getChangeCount() + 1L);
        this.markDirty();
    }
    
    public void bindBaseTexture(final int uniform, final int slot) {
        super.bindTexture(uniform, slot);
    }
    
    @Override
    public void bindTexture(final int uniform, final int slot) {
        this.updateTexture();
        final GlFrameBufferTexture mipMapTexture = this.mipMapTexture;
        Unit instance;
        if (mipMapTexture != null) {
            mipMapTexture.bindTexture(uniform, slot);
            instance = Unit.INSTANCE;
        }
        else {
            instance = null;
        }
        if (instance == null) {
            super.bindTexture(uniform, slot);
        }
    }
    
    public GlSurfaceTexture() {
        this(0, 0, 3, null);
    }
}
