// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import android.opengl.GLES20;
import kotlin.reflect.KProperty;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import kotlin.Unit;
import android.graphics.RectF;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import org.jetbrains.annotations.Nullable;
import ly.img.android.pesdk.backend.model.chunk.RelativeRectFast;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0007\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001a2\u00020\u0001:\u0001\u001aB\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\nJ\u0006\u0010\u000b\u001a\u00020\nJ\u001a\u0010\u000b\u001a\u00020\n2\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086\b\u00f8\u0001\u0000J\u0010\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0006H\u0002J,\u0010\u000b\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u000e\b\u0004\u0010\f\u001a\b\u0012\u0004\u0012\u00020\n0\rH\u0086\b\u00f8\u0001\u0000J\b\u0010\u0012\u001a\u00020\nH\u0014J.\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\u0006\u0010\u0017\u001a\u00020\u00152\u0006\u0010\u0018\u001a\u00020\u0015J\u0016\u0010\u0013\u001a\u00020\u00002\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001b" }, d2 = { "Lly/img/android/opengl/canvas/GlClearScissor;", "Lly/img/android/opengl/canvas/GlObject;", "()V", "glCrop", "Lly/img/android/pesdk/backend/model/chunk/RelativeRectFast;", "hasCrop", "", "isActive", "oldState", "disable", "", "enable", "block", "Lkotlin/Function0;", "setChainState", "crop", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "contextRect", "onRelease", "set", "x", "", "y", "width", "height", "reference", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public final class GlClearScissor extends GlObject
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final RelativeRectFast glCrop;
    @Nullable
    private GlClearScissor oldState;
    private boolean isActive;
    private boolean hasCrop;
    @NotNull
    private static final GlContextBound<GlClearScissor> currentScissorState$delegate;
    
    public GlClearScissor() {
        super(null, 1, null);
        this.glCrop = new RelativeRectFast();
    }
    
    @NotNull
    public final GlClearScissor set(@NotNull final MultiRect crop, final float x, final float y, final float width, final float height) {
        Intrinsics.checkNotNullParameter((Object)crop, "crop");
        final Recyclable $this$recycleAfter$iv = MultiRect.obtain(x, y, x + width, y + height);
        final int $i$f$recycleAfter = 0;
        final Recyclable it$iv = $this$recycleAfter$iv;
        final int n = 0;
        final MultiRect it = (MultiRect)it$iv;
        final int n2 = 0;
        this.glCrop.set(it, crop);
        final Object $this$andRecycle$iv$iv = Unit.INSTANCE;
        final int $i$f$andRecycle = 0;
        final Object it$iv$iv = $this$andRecycle$iv$iv;
        final int n3 = 0;
        it$iv.recycle();
        this.glCrop.flipYCords();
        this.hasCrop = true;
        return this;
    }
    
    @NotNull
    public final GlClearScissor set(@NotNull final MultiRect crop, @NotNull final MultiRect reference) {
        Intrinsics.checkNotNullParameter((Object)crop, "crop");
        Intrinsics.checkNotNullParameter((Object)reference, "reference");
        this.glCrop.set(reference, crop);
        this.glCrop.flipYCords();
        this.hasCrop = true;
        return this;
    }
    
    public final void enable(@NotNull final MultiRect crop, @NotNull final MultiRect contextRect, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)crop, "crop");
        Intrinsics.checkNotNullParameter((Object)contextRect, "contextRect");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.set(crop, contextRect);
        final GlClearScissor this_$iv = this;
        final int $i$f$enable2 = 0;
        this_$iv.enable();
        block.invoke();
        this_$iv.disable();
        this.disable();
    }
    
    public final void enable(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.enable();
        block.invoke();
        this.disable();
    }
    
    public final void enable() {
        this.enable(true);
    }
    
    private final void enable(final boolean setChainState) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/opengl/canvas/GlClearScissor.isActive:Z
        //     4: ifne            137
        //     7: aload_0         /* this */
        //     8: iconst_1       
        //     9: putfield        ly/img/android/opengl/canvas/GlClearScissor.isActive:Z
        //    12: iload_1         /* setChainState */
        //    13: ifeq            43
        //    16: aload_0         /* this */
        //    17: getstatic       ly/img/android/opengl/canvas/GlClearScissor.Companion:Lly/img/android/opengl/canvas/GlClearScissor$Companion;
        //    20: invokestatic    ly/img/android/opengl/canvas/GlClearScissor$Companion.access$getCurrentScissorState:(Lly/img/android/opengl/canvas/GlClearScissor$Companion;)Lly/img/android/opengl/canvas/GlClearScissor;
        //    23: astore_2       
        //    24: aload_2        
        //    25: astore_3       
        //    26: astore          5
        //    28: iconst_0       
        //    29: istore          $i$a$-apply-GlClearScissor$enable$1
        //    31: aload_3         /* $this$enable_u24lambda_u2d1 */
        //    32: iconst_0       
        //    33: putfield        ly/img/android/opengl/canvas/GlClearScissor.isActive:Z
        //    36: nop            
        //    37: aload           5
        //    39: aload_2        
        //    40: putfield        ly/img/android/opengl/canvas/GlClearScissor.oldState:Lly/img/android/opengl/canvas/GlClearScissor;
        //    43: aload_0         /* this */
        //    44: getfield        ly/img/android/opengl/canvas/GlClearScissor.hasCrop:Z
        //    47: ifeq            124
        //    50: aload_0         /* this */
        //    51: getfield        ly/img/android/opengl/canvas/GlClearScissor.glCrop:Lly/img/android/pesdk/backend/model/chunk/RelativeRectFast;
        //    54: iconst_0       
        //    55: iconst_0       
        //    56: getstatic       ly/img/android/opengl/canvas/GlViewport.Companion:Lly/img/android/opengl/canvas/GlViewport$Companion;
        //    59: invokevirtual   ly/img/android/opengl/canvas/GlViewport$Companion.getWidth:()I
        //    62: getstatic       ly/img/android/opengl/canvas/GlViewport.Companion:Lly/img/android/opengl/canvas/GlViewport$Companion;
        //    65: invokevirtual   ly/img/android/opengl/canvas/GlViewport$Companion.getHeight:()I
        //    68: invokevirtual   ly/img/android/pesdk/backend/model/chunk/RelativeRectFast.obtainMultiRect:(IIII)Lly/img/android/pesdk/backend/model/chunk/MultiRect;
        //    71: astore_2        /* stageRef */
        //    72: aload_2         /* stageRef */
        //    73: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getLeft:()F
        //    76: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //    79: iconst_0       
        //    80: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //    83: aload_2         /* stageRef */
        //    84: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getTop:()F
        //    87: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //    90: iconst_0       
        //    91: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(II)I
        //    94: aload_2         /* stageRef */
        //    95: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getWidth:()F
        //    98: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   101: aload_2         /* stageRef */
        //   102: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.getHeight:()F
        //   105: invokestatic    kotlin/math/MathKt.roundToInt:(F)I
        //   108: invokestatic    android/opengl/GLES20.glScissor:(IIII)V
        //   111: aload_2         /* stageRef */
        //   112: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.recycle:()V
        //   115: sipush          3089
        //   118: invokestatic    android/opengl/GLES20.glEnable:(I)V
        //   121: goto            130
        //   124: sipush          3089
        //   127: invokestatic    android/opengl/GLES20.glDisable:(I)V
        //   130: getstatic       ly/img/android/opengl/canvas/GlClearScissor.Companion:Lly/img/android/opengl/canvas/GlClearScissor$Companion;
        //   133: aload_0         /* this */
        //   134: invokestatic    ly/img/android/opengl/canvas/GlClearScissor$Companion.access$setCurrentScissorState:(Lly/img/android/opengl/canvas/GlClearScissor$Companion;Lly/img/android/opengl/canvas/GlClearScissor;)V
        //   137: return         
        //    StackMapTable: 00 04 2B FB 00 50 05 06
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
    }
    
    public final void disable() {
        if (this.isActive) {
            this.isActive = false;
            final GlClearScissor oldState = this.oldState;
            if (oldState != null) {
                oldState.enable();
            }
        }
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void viewPortClear(final float red, final float green, final float blue, final float alpha) {
        GlClearScissor.Companion.viewPortClear(red, green, blue, alpha);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void viewPortClear(final float red, final float green, final float blue) {
        GlClearScissor.Companion.viewPortClear(red, green, blue);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void viewPortClear(final float red, final float green) {
        GlClearScissor.Companion.viewPortClear(red, green);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void viewPortClear(final float red) {
        GlClearScissor.Companion.viewPortClear(red);
    }
    
    @JvmStatic
    @JvmOverloads
    public static final void viewPortClear() {
        GlClearScissor.Companion.viewPortClear();
    }
    
    public static final /* synthetic */ GlContextBound access$getCurrentScissorState$delegate$cp() {
        return GlClearScissor.currentScissorState$delegate;
    }
    
    public static final /* synthetic */ boolean access$isActive$p(final GlClearScissor $this) {
        return $this.isActive;
    }
    
    public static final /* synthetic */ boolean access$getHasCrop$p(final GlClearScissor $this) {
        return $this.hasCrop;
    }
    
    static {
        Companion = new Companion(null);
        currentScissorState$delegate = new GlContextBound((kotlin.jvm.functions.Function0<?>)GlClearScissor$Companion$currentScissorState.GlClearScissor$Companion$currentScissorState$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u000f2\b\b\u0002\u0010\u0011\u001a\u00020\u000f2\b\b\u0002\u0010\u0012\u001a\u00020\u000fH\u0007R+\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\t¨\u0006\u0013" }, d2 = { "Lly/img/android/opengl/canvas/GlClearScissor$Companion;", "", "()V", "<set-?>", "Lly/img/android/opengl/canvas/GlClearScissor;", "currentScissorState", "getCurrentScissorState", "()Lly/img/android/opengl/canvas/GlClearScissor;", "setCurrentScissorState", "(Lly/img/android/opengl/canvas/GlClearScissor;)V", "currentScissorState$delegate", "Lly/img/android/opengl/canvas/GlObject$GlContextBound;", "viewPortClear", "", "red", "", "green", "blue", "alpha", "pesdk-backend-core_release" })
    public static final class Companion
    {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        
        private Companion() {
        }
        
        private final GlClearScissor getCurrentScissorState() {
            return GlClearScissor.access$getCurrentScissorState$delegate$cp().getValue(this, Companion.$$delegatedProperties[0]);
        }
        
        private final void setCurrentScissorState(final GlClearScissor <set-?>) {
            GlClearScissor.access$getCurrentScissorState$delegate$cp().setValue(this, Companion.$$delegatedProperties[0], <set-?>);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void viewPortClear(final float red, final float green, final float blue, final float alpha) {
            final boolean needScissorReflate = GlClearScissor.access$isActive$p(this.getCurrentScissorState()) && GlClearScissor.access$getHasCrop$p(this.getCurrentScissorState());
            GLES20.glDisable(3089);
            GLES20.glClearColor(red, green, blue, alpha);
            GLES20.glClear(16640);
            if (needScissorReflate) {
                GLES20.glEnable(3089);
            }
        }
        
        public static /* synthetic */ void viewPortClear$default(final Companion companion, float red, float green, float blue, float alpha, final int n, final Object o) {
            if ((n & 0x1) != 0x0) {
                red = 0.0f;
            }
            if ((n & 0x2) != 0x0) {
                green = 0.0f;
            }
            if ((n & 0x4) != 0x0) {
                blue = 0.0f;
            }
            if ((n & 0x8) != 0x0) {
                alpha = 0.0f;
            }
            companion.viewPortClear(red, green, blue, alpha);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void viewPortClear(final float red, final float green, final float blue) {
            viewPortClear$default(this, red, green, blue, 0.0f, 8, null);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void viewPortClear(final float red, final float green) {
            viewPortClear$default(this, red, green, 0.0f, 0.0f, 12, null);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void viewPortClear(final float red) {
            viewPortClear$default(this, red, 0.0f, 0.0f, 0.0f, 14, null);
        }
        
        @JvmStatic
        @JvmOverloads
        public final void viewPortClear() {
            viewPortClear$default(this, 0.0f, 0.0f, 0.0f, 0.0f, 15, null);
        }
        
        static {
            $$delegatedProperties = new KProperty[] { (KProperty)Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((Class)Companion.class, "currentScissorState", "getCurrentScissorState()Lly/img/android/opengl/canvas/GlClearScissor;", 0)) };
        }
    }
}
