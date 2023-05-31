// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import kotlin.jvm.internal.Reflection;
import kotlin.jvm.internal.MutablePropertyReference1Impl;
import kotlin.jvm.internal.MutablePropertyReference1;
import kotlin.reflect.KProperty;
import android.util.Log;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import androidx.annotation.AnyThread;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.JvmOverloads;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import org.jetbrains.annotations.Nullable;
import android.graphics.Rect;
import org.jetbrains.annotations.NotNull;
import androidx.annotation.WorkerThread;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\u0013\b\u0007\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0006\u0010\n\u001a\u00020\u000bJ\u0006\u0010\f\u001a\u00020\u000bJ\u0010\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\bH\u0002J\u0016\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ,\u0010\f\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086\b\u00f8\u0001\u0000J&\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ<\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000f2\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086\b\u00f8\u0001\u0000J\u000e\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003J$\u0010\f\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u00032\u000e\b\u0004\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u000b0\u0012H\u0086\b\u00f8\u0001\u0000J(\u0010\u0016\u001a\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fH\u0007J\u0010\u0010\u0016\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0003H\u0007J&\u0010\u0017\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000f2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u000fJ\b\u0010\u0018\u001a\u00020\u000bH\u0002R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\u0000X\u0082\u000e¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u001a" }, d2 = { "Lly/img/android/opengl/canvas/GlViewport;", "", "crop", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "(Lly/img/android/pesdk/backend/model/chunk/MultiRect;)V", "glViewPort", "Landroid/graphics/Rect;", "isActive", "", "oldState", "disable", "", "enable", "setChainState", "width", "", "height", "block", "Lkotlin/Function0;", "x", "y", "viewPort", "set", "setAsDisplayViewPort", "setCurrentViewport", "Companion", "pesdk-backend-core_release" })
@WorkerThread
public final class GlViewport
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Rect glViewPort;
    @Nullable
    private GlViewport oldState;
    private boolean isActive;
    @NotNull
    private static final GlObject.GlContextBound<GlViewport> currentViewport$delegate;
    
    @JvmOverloads
    public GlViewport(@Nullable final MultiRect crop) {
        this.glViewPort = new Rect();
        if (crop != null) {
            final MultiRect it = crop;
            final int n = 0;
            this.set(it);
        }
    }
    
    @AnyThread
    @NotNull
    public final GlViewport set(final int x, final int y, final int width, final int height) {
        this.glViewPort.set(x, y, x + width, y + height);
        return this;
    }
    
    @AnyThread
    public final void set(@NotNull final MultiRect viewPort) {
        Intrinsics.checkNotNullParameter((Object)viewPort, "viewPort");
        this.glViewPort.set(viewPort.obtainRounded());
    }
    
    public final void setAsDisplayViewPort(final int x, final int y, final int width, final int height) {
        this.glViewPort.set(x, y, x + width, y + height);
        final GlViewport access$getCurrentViewport = GlViewport.Companion.getCurrentViewport();
        Object o3;
        Object o2;
        if (access$getCurrentViewport != null) {
            final Object $this$loopAsLongNotNull$iv = access$getCurrentViewport;
            final int $i$f$loopAsLongNotNull = 0;
            Object last$iv = $this$loopAsLongNotNull$iv;
            while (true) {
                final GlViewport chainedState = (GlViewport)last$iv;
                final int n = 0;
                final GlViewport access$getOldState$p = access$getOldState$p(chainedState);
                GlViewport glViewport2;
                Object o;
                if (access$getOldState$p != null) {
                    final GlViewport it;
                    final GlViewport glViewport = it = access$getOldState$p;
                    final int n2 = 0;
                    o = (glViewport2 = ((Intrinsics.areEqual((Object)access$getOldState$p(it), (Object)this) || Intrinsics.areEqual((Object)access$getOldState$p(it), (Object)chainedState)) ? null : glViewport));
                }
                else {
                    o = (glViewport2 = null);
                }
                if (glViewport2 == null) {
                    break;
                }
                last$iv = o;
            }
            o2 = (o3 = last$iv);
        }
        else {
            o2 = (o3 = null);
        }
        if (o3 != null) {
            ((GlViewport)o2).oldState = this;
        }
        if (GlViewport.Companion.getCurrentViewport() == null) {
            GlViewport.Companion.setCurrentViewport(this);
            this.enable();
        }
    }
    
    public final void enable(final int width, final int height) {
        this.enable(0, 0, width, height);
    }
    
    public final void enable(final int x, final int y, final int width, final int height) {
        this.set(x, y, width, height);
        this.enable();
    }
    
    public final void enable(@NotNull final MultiRect viewPort) {
        Intrinsics.checkNotNullParameter((Object)viewPort, "viewPort");
        this.set(viewPort);
        this.enable();
    }
    
    public final void enable(final int width, final int height, @NotNull final Function0<Unit> block) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "block"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore          $i$f$enable
        //     9: aload_0         /* this */
        //    10: astore          5
        //    12: iconst_0       
        //    13: istore          6
        //    15: iconst_0       
        //    16: istore          y$iv
        //    18: iconst_0       
        //    19: istore          $i$f$enable
        //    21: aload           this_$iv
        //    23: iload           x$iv
        //    25: iload           y$iv
        //    27: iload_1         /* width */
        //    28: iload_2         /* height */
        //    29: invokevirtual   ly/img/android/opengl/canvas/GlViewport.set:(IIII)Lly/img/android/opengl/canvas/GlViewport;
        //    32: pop            
        //    33: aload           this_$iv
        //    35: invokevirtual   ly/img/android/opengl/canvas/GlViewport.enable:()V
        //    38: aload_3         /* block */
        //    39: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    44: pop            
        //    45: aload           this_$iv
        //    47: invokevirtual   ly/img/android/opengl/canvas/GlViewport.disable:()V
        //    50: nop            
        //    51: return         
        //    Signature:
        //  (IILkotlin/jvm/functions/Function0<Lkotlin/Unit;>;)V
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
    
    public final void enable(final int x, final int y, final int width, final int height, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.set(x, y, width, height);
        this.enable();
        block.invoke();
        this.disable();
    }
    
    public final void enable(@NotNull final MultiRect viewPort, @NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)viewPort, "viewPort");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$enable = 0;
        this.set(viewPort);
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
        //     1: getfield        ly/img/android/opengl/canvas/GlViewport.isActive:Z
        //     4: ifne            87
        //     7: aload_0         /* this */
        //     8: iconst_1       
        //     9: putfield        ly/img/android/opengl/canvas/GlViewport.isActive:Z
        //    12: iload_1         /* setChainState */
        //    13: ifeq            52
        //    16: aload_0         /* this */
        //    17: getstatic       ly/img/android/opengl/canvas/GlViewport.Companion:Lly/img/android/opengl/canvas/GlViewport$Companion;
        //    20: invokestatic    ly/img/android/opengl/canvas/GlViewport$Companion.access$getCurrentViewport:(Lly/img/android/opengl/canvas/GlViewport$Companion;)Lly/img/android/opengl/canvas/GlViewport;
        //    23: dup            
        //    24: ifnull          47
        //    27: astore_2       
        //    28: aload_2        
        //    29: astore_3       
        //    30: astore          5
        //    32: iconst_0       
        //    33: istore          $i$a$-apply-GlViewport$enable$1
        //    35: aload_3         /* $this$enable_u24lambda_u2d3 */
        //    36: iconst_0       
        //    37: putfield        ly/img/android/opengl/canvas/GlViewport.isActive:Z
        //    40: nop            
        //    41: aload           5
        //    43: aload_2        
        //    44: goto            49
        //    47: pop            
        //    48: aconst_null    
        //    49: putfield        ly/img/android/opengl/canvas/GlViewport.oldState:Lly/img/android/opengl/canvas/GlViewport;
        //    52: aload_0         /* this */
        //    53: getfield        ly/img/android/opengl/canvas/GlViewport.glViewPort:Landroid/graphics/Rect;
        //    56: getfield        android/graphics/Rect.left:I
        //    59: aload_0         /* this */
        //    60: getfield        ly/img/android/opengl/canvas/GlViewport.glViewPort:Landroid/graphics/Rect;
        //    63: getfield        android/graphics/Rect.top:I
        //    66: aload_0         /* this */
        //    67: getfield        ly/img/android/opengl/canvas/GlViewport.glViewPort:Landroid/graphics/Rect;
        //    70: invokevirtual   android/graphics/Rect.width:()I
        //    73: aload_0         /* this */
        //    74: getfield        ly/img/android/opengl/canvas/GlViewport.glViewPort:Landroid/graphics/Rect;
        //    77: invokevirtual   android/graphics/Rect.height:()I
        //    80: invokestatic    android/opengl/GLES20.glViewport:(IIII)V
        //    83: aload_0         /* this */
        //    84: invokespecial   ly/img/android/opengl/canvas/GlViewport.setCurrentViewport:()V
        //    87: return         
        //    StackMapTable: 00 04 FF 00 2F 00 02 07 00 02 01 00 02 07 00 02 07 00 02 FF 00 01 00 02 07 00 02 01 00 02 07 00 02 07 00 02 02 22
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
    
    public final void disable() {
        if (this.isActive) {
            this.isActive = false;
            GlViewport.Companion.setCurrentViewport(null);
            final GlViewport oldState = this.oldState;
            if (oldState != null) {
                final GlViewport $this$disable_u24lambda_u2d4 = oldState;
                final int n = 0;
                $this$disable_u24lambda_u2d4.enable(false);
                $this$disable_u24lambda_u2d4.setCurrentViewport();
            }
        }
        else {
            Log.e("PESDK", "You tried to disable GlViewport in wrong order");
        }
    }
    
    private final void setCurrentViewport() {
        GlViewport.Companion.setCurrentViewport(this);
    }
    
    @JvmOverloads
    public GlViewport() {
        this(null, 1, null);
    }
    
    public static final /* synthetic */ GlObject.GlContextBound access$getCurrentViewport$delegate$cp() {
        return GlViewport.currentViewport$delegate;
    }
    
    public static final /* synthetic */ Rect access$getGlViewPort$p(final GlViewport $this) {
        return $this.glViewPort;
    }
    
    public static final /* synthetic */ GlViewport access$getOldState$p(final GlViewport $this) {
        return $this.oldState;
    }
    
    static {
        Companion = new Companion(null);
        currentViewport$delegate = new GlObject.GlContextBound((kotlin.jvm.functions.Function0<?>)GlViewport$Companion$currentViewport.GlViewport$Companion$currentViewport$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R/\u0010\u0005\u001a\u0004\u0018\u00010\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u00048B@BX\u0082\u008e\u0002¢\u0006\u0012\n\u0004\b\n\u0010\u000b\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u000f¨\u0006\u0012" }, d2 = { "Lly/img/android/opengl/canvas/GlViewport$Companion;", "", "()V", "<set-?>", "Lly/img/android/opengl/canvas/GlViewport;", "currentViewport", "getCurrentViewport", "()Lly/img/android/opengl/canvas/GlViewport;", "setCurrentViewport", "(Lly/img/android/opengl/canvas/GlViewport;)V", "currentViewport$delegate", "Lly/img/android/opengl/canvas/GlObject$GlContextBound;", "height", "", "getHeight", "()I", "width", "getWidth", "pesdk-backend-core_release" })
    public static final class Companion
    {
        static final /* synthetic */ KProperty<Object>[] $$delegatedProperties;
        
        private Companion() {
        }
        
        private final GlViewport getCurrentViewport() {
            return GlViewport.access$getCurrentViewport$delegate$cp().getValue(this, Companion.$$delegatedProperties[0]);
        }
        
        private final void setCurrentViewport(final GlViewport <set-?>) {
            GlViewport.access$getCurrentViewport$delegate$cp().setValue(this, Companion.$$delegatedProperties[0], <set-?>);
        }
        
        public final int getWidth() {
            final GlViewport currentViewport = this.getCurrentViewport();
            if (currentViewport != null) {
                final Rect access$getGlViewPort$p = GlViewport.access$getGlViewPort$p(currentViewport);
                if (access$getGlViewPort$p != null) {
                    final Rect rectViewPort = access$getGlViewPort$p;
                    return rectViewPort.width();
                }
            }
            throw new IllegalStateException("No current Viewport");
        }
        
        public final int getHeight() {
            final GlViewport currentViewport = this.getCurrentViewport();
            if (currentViewport != null) {
                final Rect access$getGlViewPort$p = GlViewport.access$getGlViewPort$p(currentViewport);
                if (access$getGlViewPort$p != null) {
                    final Rect rectViewPort = access$getGlViewPort$p;
                    return rectViewPort.height();
                }
            }
            throw new IllegalStateException("No current Viewport");
        }
        
        static {
            $$delegatedProperties = new KProperty[] { (KProperty)Reflection.mutableProperty1((MutablePropertyReference1)new MutablePropertyReference1Impl((Class)Companion.class, "currentViewport", "getCurrentViewport()Lly/img/android/opengl/canvas/GlViewport;", 0)) };
        }
    }
}
