// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import kotlin.reflect.KProperty;
import ly.img.android.pesdk.backend.model.chunk.Recycler;
import kotlin.jvm.JvmStatic;
import android.graphics.Matrix;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import kotlin.jvm.internal.InlineMarker;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;
import ly.img.android.pesdk.backend.model.chunk.Resettable;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000~\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0010\u0007\n\u0002\b\b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b9\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\b\u0016\u0018\u0000 \u0095\u00012\u00020\u00012\u00020\u0002:\u0006\u0095\u0001\u0096\u0001\u0097\u0001B\u000f\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010v\u001a\u00020wH\u0004J(\u0010x\u001a\u00020w2\n\b\u0002\u0010u\u001a\u0004\u0018\u0001052\b\b\u0002\u0010p\u001a\u00020=2\b\b\u0002\u0010[\u001a\u00020=H\u0002J\b\u0010y\u001a\u00020wH\u0016J\b\u0010z\u001a\u00020wH\u0016J\u001a\u0010{\u001a\u00020w2\f\u0010|\u001a\b\u0012\u0004\u0012\u00020w0}H\u0084\b\u00f8\u0001\u0000J3\u0010~\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020\f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0081\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J:\u0010~\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020\f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\u0007\u0010\u0083\u0001\u001a\u00020\f2\u0007\u0010\u0084\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J\u001a\u0010\u0085\u0001\u001a\u00020w2\u0006\u0010\u007f\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J\u001b\u0010\u0086\u0001\u001a\u00020w2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0088\u0001\u001a\u00020\fH\u0016J=\u0010\u0089\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020=2\t\b\u0002\u0010\u0080\u0001\u001a\u00020=2\u0007\u0010\u0083\u0001\u001a\u00020=2\t\b\u0002\u0010\u0084\u0001\u001a\u00020=2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J2\u0010\u0089\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020=2\t\b\u0002\u0010\u0080\u0001\u001a\u00020=2\u0007\u0010\u0081\u0001\u001a\u00020=2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J)\u0010\u0089\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020=2\t\b\u0002\u0010\u0080\u0001\u001a\u00020=2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J\u001a\u0010\u008a\u0001\u001a\u00020w2\u0006\u0010\u007f\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J)\u0010\u008b\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020\f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J2\u0010\u008b\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020\f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\u0007\u0010\u0081\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J;\u0010\u008b\u0001\u001a\u00020w2\b\b\u0002\u0010\u007f\u001a\u00020\f2\t\b\u0002\u0010\u0080\u0001\u001a\u00020\f2\u0007\u0010\u0083\u0001\u001a\u00020\f2\u0007\u0010\u0084\u0001\u001a\u00020\f2\t\b\u0002\u0010\u0082\u0001\u001a\u00020\fH\u0016J\u001a\u0010\u008c\u0001\u001a\u00020w2\u0006\u0010\u007f\u001a\u00020\f2\u0007\u0010\u0080\u0001\u001a\u00020\fH\u0016J\u001b\u0010\u008d\u0001\u001a\u00020w2\u0007\u0010\u0087\u0001\u001a\u00020\f2\u0007\u0010\u0088\u0001\u001a\u00020\fH\u0016J\n\u0010\u008e\u0001\u001a\u00030\u008f\u0001H\u0016J\u001d\u0010\u0090\u0001\u001a\u00020w2\b\u0010\u0091\u0001\u001a\u00030\u0092\u00012\b\u0010\u0093\u0001\u001a\u00030\u0092\u0001H\u0016J)\u0010\u0090\u0001\u001a\u00020w2\n\b\u0002\u0010u\u001a\u0004\u0018\u0001052\b\b\u0002\u0010Z\u001a\u00020=2\b\b\u0002\u0010Y\u001a\u00020=H\u0016J%\u0010\u0090\u0001\u001a\u00020w2\n\b\u0002\u0010u\u001a\u0004\u0018\u0001052\u0006\u0010Z\u001a\u00020\f2\u0006\u0010Y\u001a\u00020\fH\u0016J'\u0010\u0090\u0001\u001a\u00020w2\n\b\u0002\u0010u\u001a\u0004\u0018\u0001052\u0007\u0010Z\u001a\u00030\u0094\u00012\u0007\u0010Y\u001a\u00030\u0094\u0001H\u0016R\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0001X\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0007\u0010\b\"\u0004\b\t\u0010\nR+\u0010\r\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b\u0012\u0010\u0013\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0012\u0010\u0014\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010\u0016\u001a\u00060\u0017j\u0002`\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u0019\u0010\u001aR\"\u0010\u001d\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\b\u0012\u00060\u0017j\u0002`\u00180\u001eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u001f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b \u0010\u000fR\u0011\u0010!\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\b\"\u0010\u000fR$\u0010$\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b%\u0010\u000f\"\u0004\b&\u0010\u0011R+\u0010'\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b*\u0010\u0013\u001a\u0004\b(\u0010\u000f\"\u0004\b)\u0010\u0011R\u0012\u0010+\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010,\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b/\u0010\u0013\u001a\u0004\b-\u0010\u000f\"\u0004\b.\u0010\u0011R\u0012\u00100\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u00101\u001a\u00060\u0017j\u0002`2X\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u00103\u001a\u00060\u0017j\u0002`2X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u00104\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0003\u001a\u00020\u0004X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0003\u00106\"\u0004\b7\u0010\u0005R\u0014\u00108\u001a\u000209X\u0084\u0004¢\u0006\b\n\u0000\u001a\u0004\b:\u0010;R\u0014\u0010<\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b>\u0010?R$\u0010@\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bA\u0010?\"\u0004\bB\u0010CR$\u0010D\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010?\"\u0004\bF\u0010CR\u0011\u0010G\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bH\u0010?R\u0011\u0010I\u001a\u00020=8F¢\u0006\u0006\u001a\u0004\bJ\u0010?R$\u0010K\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bL\u0010?\"\u0004\bM\u0010CR$\u0010N\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bO\u0010?\"\u0004\bP\u0010CR$\u0010Q\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bR\u0010?\"\u0004\bS\u0010CR$\u0010T\u001a\u00020=2\u0006\u0010#\u001a\u00020=8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bU\u0010?\"\u0004\bV\u0010CR\u0014\u0010W\u001a\u00020=8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\bX\u0010?R\u000e\u0010Y\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010Z\u001a\u00020=X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010[\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\b^\u0010\u0013\u001a\u0004\b\\\u0010\u000f\"\u0004\b]\u0010\u0011R\u0012\u0010_\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u001f\u0010`\u001a\u00060\u0017j\u0002`\u00188BX\u0082\u0084\u0002¢\u0006\f\n\u0004\bb\u0010\u001c\u001a\u0004\ba\u0010\u001aR\"\u0010c\u001a\u0016\u0012\u0004\u0012\u00020\u0000\u0012\b\u0012\u00060\u0017j\u0002`\u00180\u001eR\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u0011\u0010d\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\be\u0010\u000fR\u0011\u0010f\u001a\u00020\f8F¢\u0006\u0006\u001a\u0004\bg\u0010\u000fR$\u0010h\u001a\u00020\f2\u0006\u0010#\u001a\u00020\f8F@FX\u0086\u000e¢\u0006\f\u001a\u0004\bi\u0010\u000f\"\u0004\bj\u0010\u0011R+\u0010k\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bn\u0010\u0013\u001a\u0004\bl\u0010\u000f\"\u0004\bm\u0010\u0011R\u0012\u0010o\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R+\u0010p\u001a\u00020\f2\u0006\u0010\u000b\u001a\u00020\f8F@FX\u0086\u008e\u0002¢\u0006\u0012\n\u0004\bs\u0010\u0013\u001a\u0004\bq\u0010\u000f\"\u0004\br\u0010\u0011R\u0012\u0010t\u001a\u00060\u0015R\u00020\u0000X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010u\u001a\u000205X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006\u0098\u0001" }, d2 = { "Lly/img/android/pesdk/utils/TransformedVector;", "Lly/img/android/pesdk/backend/model/chunk/Recyclable;", "Lly/img/android/pesdk/backend/model/chunk/Resettable;", "isAtomic", "", "(Z)V", "alsoRecyclable", "getAlsoRecyclable", "()Lly/img/android/pesdk/backend/model/chunk/Recyclable;", "setAlsoRecyclable", "(Lly/img/android/pesdk/backend/model/chunk/Recyclable;)V", "<set-?>", "", "destinationHeight", "getDestinationHeight", "()F", "setDestinationHeight", "(F)V", "destinationHeight$delegate", "Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;", "destinationHeightRaw", "Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;", "destinationPosition", "", "Lly/img/android/pesdk/kotlin_extension/Float2;", "getDestinationPosition", "()[F", "destinationPosition$delegate", "Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;", "destinationPositionRaw", "Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;", "destinationPositionX", "getDestinationPositionX", "destinationPositionY", "getDestinationPositionY", "value", "destinationRadius", "getDestinationRadius", "setDestinationRadius", "destinationRotation", "getDestinationRotation", "setDestinationRotation", "destinationRotation$delegate", "destinationRotationRaw", "destinationWidth", "getDestinationWidth", "setDestinationWidth", "destinationWidth$delegate", "destinationWidthRaw", "dummyDestinationShape", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "dummySourceShape", "invertedTransformation", "Lly/img/android/pesdk/backend/model/chunk/Transformation;", "()Z", "setAtomic", "lock", "Ljava/util/concurrent/locks/ReentrantLock;", "getLock", "()Ljava/util/concurrent/locks/ReentrantLock;", "longSide", "", "getLongSide", "()D", "relativeSourceHeightLongSide", "getRelativeSourceHeightLongSide", "setRelativeSourceHeightLongSide", "(D)V", "relativeSourceHeightShortSide", "getRelativeSourceHeightShortSide", "setRelativeSourceHeightShortSide", "relativeSourcePositionX", "getRelativeSourcePositionX", "relativeSourcePositionY", "getRelativeSourcePositionY", "relativeSourceRadiusLongSide", "getRelativeSourceRadiusLongSide", "setRelativeSourceRadiusLongSide", "relativeSourceRadiusShortSide", "getRelativeSourceRadiusShortSide", "setRelativeSourceRadiusShortSide", "relativeSourceWidthLongSide", "getRelativeSourceWidthLongSide", "setRelativeSourceWidthLongSide", "relativeSourceWidthShortSide", "getRelativeSourceWidthShortSide", "setRelativeSourceWidthShortSide", "shortSide", "getShortSide", "sourceContextHeight", "sourceContextWidth", "sourceHeight", "getSourceHeight", "setSourceHeight", "sourceHeight$delegate", "sourceHeightRaw", "sourcePosition", "getSourcePosition", "sourcePosition$delegate", "sourcePositionRaw", "sourcePositionX", "getSourcePositionX", "sourcePositionY", "getSourcePositionY", "sourceRadius", "getSourceRadius", "setSourceRadius", "sourceRotation", "getSourceRotation", "setSourceRotation", "sourceRotation$delegate", "sourceRotationRaw", "sourceWidth", "getSourceWidth", "setSourceWidth", "sourceWidth$delegate", "sourceWidthRaw", "transformation", "finalize", "", "internalUpdateTransformation", "recycle", "reset", "respectLock", "block", "Lkotlin/Function0;", "setDestination", "x", "y", "radius", "rotation", "width", "height", "setDestinationPosition", "setDestinationPositionOffset", "offsetX", "offsetY", "setRelativeSource", "setRelativeSourcePosition", "setSource", "setSourcePosition", "setSourcePositionOffset", "toString", "", "updateTransformation", "source", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "destination", "", "Companion", "TransformableFloat", "TransformableValue", "pesdk-backend-core_release" })
public class TransformedVector implements Recyclable, Resettable
{
    @NotNull
    public static final Companion Companion;
    private boolean isAtomic;
    @Nullable
    private Recyclable alsoRecyclable;
    @NotNull
    private final ReentrantLock lock;
    private double sourceContextWidth;
    private double sourceContextHeight;
    @NotNull
    private final Transformation transformation;
    @NotNull
    private final Transformation invertedTransformation;
    @NotNull
    private TransformableFloat sourceRotationRaw;
    @NotNull
    private TransformableFloat destinationRotationRaw;
    @NotNull
    private TransformableFloat sourceWidthRaw;
    @NotNull
    private TransformableFloat destinationWidthRaw;
    @NotNull
    private TransformableFloat sourceHeightRaw;
    @NotNull
    private TransformableFloat destinationHeightRaw;
    @NotNull
    private TransformableValue<? super TransformedVector, float[]> sourcePositionRaw;
    @NotNull
    private TransformableValue<? super TransformedVector, float[]> destinationPositionRaw;
    @NotNull
    private final TransformableValue sourcePosition$delegate;
    @NotNull
    private final TransformableValue destinationPosition$delegate;
    @NotNull
    private final TransformableFloat sourceRotation$delegate;
    @NotNull
    private final TransformableFloat destinationRotation$delegate;
    @NotNull
    private final TransformableFloat sourceWidth$delegate;
    @NotNull
    private final TransformableFloat destinationWidth$delegate;
    @NotNull
    private final TransformableFloat sourceHeight$delegate;
    @NotNull
    private final TransformableFloat destinationHeight$delegate;
    @NotNull
    private final float[] dummySourceShape;
    @NotNull
    private final float[] dummyDestinationShape;
    
    public TransformedVector(final boolean isAtomic) {
        this.isAtomic = isAtomic;
        this.lock = new ReentrantLock();
        this.sourceContextWidth = 1.0;
        this.sourceContextHeight = 1.0;
        final Transformation permanent = Transformation.permanent();
        Intrinsics.checkNotNullExpressionValue((Object)permanent, "permanent()");
        this.transformation = permanent;
        final Transformation permanent2 = Transformation.permanent();
        Intrinsics.checkNotNullExpressionValue((Object)permanent2, "permanent()");
        this.invertedTransformation = permanent2;
        this.sourceRotationRaw = (TransformableFloat)new TransformedVector$sourceRotationRaw.TransformedVector$sourceRotationRaw$1(this, new TransformedVector$sourceRotationRaw.TransformedVector$sourceRotationRaw$2(this));
        this.destinationRotationRaw = (TransformableFloat)new TransformedVector$destinationRotationRaw.TransformedVector$destinationRotationRaw$1(this, new TransformedVector$destinationRotationRaw.TransformedVector$destinationRotationRaw$2(this));
        this.sourceWidthRaw = (TransformableFloat)new TransformedVector$sourceWidthRaw.TransformedVector$sourceWidthRaw$1(this, new TransformedVector$sourceWidthRaw.TransformedVector$sourceWidthRaw$2(this));
        this.destinationWidthRaw = (TransformableFloat)new TransformedVector$destinationWidthRaw.TransformedVector$destinationWidthRaw$1(this, new TransformedVector$destinationWidthRaw.TransformedVector$destinationWidthRaw$2(this));
        this.sourceHeightRaw = (TransformableFloat)new TransformedVector$sourceHeightRaw.TransformedVector$sourceHeightRaw$1(this, new TransformedVector$sourceHeightRaw.TransformedVector$sourceHeightRaw$2(this));
        this.destinationHeightRaw = (TransformableFloat)new TransformedVector$destinationHeightRaw.TransformedVector$destinationHeightRaw$1(this, new TransformedVector$destinationHeightRaw.TransformedVector$destinationHeightRaw$2(this));
        int $i$f$Float2 = 0;
        this.sourcePositionRaw = new TransformableValue<Object, float[]>(new float[] { 0.0f, 0.0f }, (kotlin.jvm.functions.Function1<? super float[], ? extends float[]>)new TransformedVector$sourcePositionRaw.TransformedVector$sourcePositionRaw$1(this), (Function0<Unit>)new TransformedVector$sourcePositionRaw.TransformedVector$sourcePositionRaw$2(this));
        $i$f$Float2 = 0;
        this.destinationPositionRaw = new TransformableValue<Object, float[]>(new float[] { 0.0f, 0.0f }, (kotlin.jvm.functions.Function1<? super float[], ? extends float[]>)new TransformedVector$destinationPositionRaw.TransformedVector$destinationPositionRaw$1(this), (Function0<Unit>)new TransformedVector$destinationPositionRaw.TransformedVector$destinationPositionRaw$2(this));
        this.sourcePosition$delegate = this.sourcePositionRaw;
        this.destinationPosition$delegate = this.destinationPositionRaw;
        this.sourceRotation$delegate = this.sourceRotationRaw;
        this.destinationRotation$delegate = this.destinationRotationRaw;
        this.sourceWidth$delegate = this.sourceWidthRaw;
        this.destinationWidth$delegate = this.destinationWidthRaw;
        this.sourceHeight$delegate = this.sourceHeightRaw;
        this.destinationHeight$delegate = this.destinationHeightRaw;
        int $i$f$RectCords = 0;
        this.dummySourceShape = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
        $i$f$RectCords = 0;
        this.dummyDestinationShape = new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    }
    
    public final boolean isAtomic() {
        return this.isAtomic;
    }
    
    public final void setAtomic(final boolean <set-?>) {
        this.isAtomic = <set-?>;
    }
    
    @Nullable
    @Override
    public Recyclable getAlsoRecyclable() {
        return this.alsoRecyclable;
    }
    
    @Override
    public void setAlsoRecyclable(@Nullable final Recyclable <set-?>) {
        this.alsoRecyclable = <set-?>;
    }
    
    @NotNull
    protected final ReentrantLock getLock() {
        return this.lock;
    }
    
    protected final void respectLock(@NotNull final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$respectLock = 0;
        if (this.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this);
            reentrantLock.lock();
            try {
                final int n = 0;
                block.invoke();
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                InlineMarker.finallyStart(1);
                reentrantLock.unlock();
                InlineMarker.finallyEnd(1);
            }
        }
        block.invoke();
    }
    
    private final double getShortSide() {
        return Math.min(this.sourceContextWidth, this.sourceContextHeight);
    }
    
    private final double getLongSide() {
        return Math.max(this.sourceContextWidth, this.sourceContextHeight);
    }
    
    private final float[] getSourcePosition() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePosition$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableValue.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            108
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableValue$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.isDirty:()Z
        //    54: ifeq            79
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getUpdateFromRaw:()Lkotlin/jvm/functions/Function1;
        //    67: aload_1         /* this_$iv */
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    71: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    76: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setValue:(Ljava/lang/Object;)V
        //    79: nop            
        //    80: nop            
        //    81: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    84: astore          7
        //    86: aload           6
        //    88: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    93: goto            141
        //    96: astore          7
        //    98: aload           6
        //   100: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   105: aload           7
        //   107: athrow         
        //   108: iconst_0       
        //   109: istore          $i$a$-respectLock-TransformedVector$TransformableValue$getValue$1$iv
        //   111: aload_1         /* this_$iv */
        //   112: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.isDirty:()Z
        //   115: ifeq            140
        //   118: aload_1         /* this_$iv */
        //   119: iconst_0       
        //   120: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   123: aload_1         /* this_$iv */
        //   124: aload_1         /* this_$iv */
        //   125: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getUpdateFromRaw:()Lkotlin/jvm/functions/Function1;
        //   128: aload_1         /* this_$iv */
        //   129: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   132: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setValue:(Ljava/lang/Object;)V
        //   140: nop            
        //   141: nop            
        //   142: aload_1         /* this_$iv */
        //   143: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   146: checkcast       [F
        //   149: areturn        
        //    StackMapTable: 00 05 FF 00 4F 00 09 07 00 02 07 00 7D 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 7D 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1F 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     86     96     108    Any
        //  96     98     96     108    Any
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
    
    private final float[] getDestinationPosition() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPosition$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableValue.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            108
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableValue$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.isDirty:()Z
        //    54: ifeq            79
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getUpdateFromRaw:()Lkotlin/jvm/functions/Function1;
        //    67: aload_1         /* this_$iv */
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    71: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //    76: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setValue:(Ljava/lang/Object;)V
        //    79: nop            
        //    80: nop            
        //    81: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    84: astore          7
        //    86: aload           6
        //    88: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    93: goto            141
        //    96: astore          7
        //    98: aload           6
        //   100: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   105: aload           7
        //   107: athrow         
        //   108: iconst_0       
        //   109: istore          $i$a$-respectLock-TransformedVector$TransformableValue$getValue$1$iv
        //   111: aload_1         /* this_$iv */
        //   112: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.isDirty:()Z
        //   115: ifeq            140
        //   118: aload_1         /* this_$iv */
        //   119: iconst_0       
        //   120: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   123: aload_1         /* this_$iv */
        //   124: aload_1         /* this_$iv */
        //   125: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getUpdateFromRaw:()Lkotlin/jvm/functions/Function1;
        //   128: aload_1         /* this_$iv */
        //   129: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   132: invokeinterface kotlin/jvm/functions/Function1.invoke:(Ljava/lang/Object;)Ljava/lang/Object;
        //   137: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setValue:(Ljava/lang/Object;)V
        //   140: nop            
        //   141: nop            
        //   142: aload_1         /* this_$iv */
        //   143: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   146: checkcast       [F
        //   149: areturn        
        //    StackMapTable: 00 05 FF 00 4F 00 09 07 00 02 07 00 7D 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 7D 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1F 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     86     96     108    Any
        //  96     98     96     108    Any
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
    
    public final float getSourceRotation() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceRotation$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setSourceRotation(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceRotation$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getDestinationRotation() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationRotation$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setDestinationRotation(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationRotation$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getSourceWidth() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceWidth$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setSourceWidth(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceWidth$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getDestinationWidth() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationWidth$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setDestinationWidth(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationWidth$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getSourceHeight() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceHeight$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setSourceHeight(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceHeight$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getDestinationHeight() {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationHeight$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_1       
        //     5: aconst_null    
        //     6: astore_2        /* property$iv */
        //     7: iconst_0       
        //     8: istore_3        /* $i$f$getValue */
        //     9: aload_1         /* this_$iv */
        //    10: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    13: astore          this_$iv$iv
        //    15: iconst_0       
        //    16: istore          $i$f$respectLock
        //    18: aload           this_$iv$iv
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            103
        //    26: aload           this_$iv$iv
        //    28: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    31: checkcast       Ljava/util/concurrent/locks/Lock;
        //    34: astore          6
        //    36: aload           6
        //    38: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    43: nop            
        //    44: iconst_0       
        //    45: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //    50: aload_1         /* this_$iv */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //    54: ifeq            74
        //    57: aload_1         /* this_$iv */
        //    58: iconst_0       
        //    59: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    62: aload_1         /* this_$iv */
        //    63: aload_1         /* this_$iv */
        //    64: aload_1         /* this_$iv */
        //    65: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //    68: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    74: nop            
        //    75: nop            
        //    76: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    79: astore          7
        //    81: aload           6
        //    83: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    88: goto            131
        //    91: astore          7
        //    93: aload           6
        //    95: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   100: aload           7
        //   102: athrow         
        //   103: iconst_0       
        //   104: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$getValue$1$iv
        //   106: aload_1         /* this_$iv */
        //   107: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.isDirty:()Z
        //   110: ifeq            130
        //   113: aload_1         /* this_$iv */
        //   114: iconst_0       
        //   115: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   118: aload_1         /* this_$iv */
        //   119: aload_1         /* this_$iv */
        //   120: aload_1         /* this_$iv */
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   124: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.updateFromRaw:(F)F
        //   127: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   130: nop            
        //   131: nop            
        //   132: aload_1         /* this_$iv */
        //   133: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getValue:()F
        //   136: freturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 01 01 00 00 FF 00 10 00 07 07 00 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 1A 00 00 01 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  43     81     91     103    Any
        //  91     93     91     103    Any
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
    
    public final void setDestinationHeight(final float <set-?>) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationHeight$delegate:Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;
        //     4: astore_2       
        //     5: aconst_null    
        //     6: astore_3        /* property$iv */
        //     7: iconst_0       
        //     8: istore          $i$f$setValue
        //    10: aload_2         /* this_$iv */
        //    11: invokestatic    ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.access$getThis$0$p:(Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;)Lly/img/android/pesdk/utils/TransformedVector;
        //    14: astore          this_$iv$iv
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload           this_$iv$iv
        //    21: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    24: ifeq            100
        //    27: aload           this_$iv$iv
        //    29: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    32: checkcast       Ljava/util/concurrent/locks/Lock;
        //    35: astore          7
        //    37: aload           7
        //    39: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    44: nop            
        //    45: iconst_0       
        //    46: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv$iv
        //    48: iconst_0       
        //    49: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //    51: aload_2         /* this_$iv */
        //    52: fload_1         /* <set-?> */
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //    56: aload_2         /* this_$iv */
        //    57: iconst_0       
        //    58: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //    61: aload_2         /* this_$iv */
        //    62: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //    65: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //    70: pop            
        //    71: nop            
        //    72: nop            
        //    73: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //    76: astore          8
        //    78: aload           7
        //    80: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    85: goto            124
        //    88: astore          8
        //    90: aload           7
        //    92: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //    97: aload           8
        //    99: athrow         
        //   100: iconst_0       
        //   101: istore          $i$a$-respectLock-TransformedVector$TransformableFloat$setValue$1$iv
        //   103: aload_2         /* this_$iv */
        //   104: fload_1         /* <set-?> */
        //   105: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setValue:(F)V
        //   108: aload_2         /* this_$iv */
        //   109: iconst_0       
        //   110: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.setDirty:(Z)V
        //   113: aload_2         /* this_$iv */
        //   114: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableFloat.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   117: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   122: pop            
        //   123: nop            
        //   124: nop            
        //   125: nop            
        //   126: return         
        //    StackMapTable: 00 03 FF 00 58 00 08 07 00 02 02 07 00 40 05 01 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FE 00 17 00 00 01
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  44     78     88     100    Any
        //  88     90     88     100    Any
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
    
    public final float getSourceRadius() {
        float $this$isNotFinite$iv = this.getSourceWidth();
        int $i$f$isNotFinite = 0;
        final float n = $this$isNotFinite$iv;
        float sourceHeight;
        if (Float.isInfinite(n) || Float.isNaN(n)) {
            sourceHeight = this.getSourceHeight();
        }
        else {
            $this$isNotFinite$iv = this.getSourceHeight();
            $i$f$isNotFinite = 0;
            final float n2 = $this$isNotFinite$iv;
            sourceHeight = ((!Float.isInfinite(n2) && !Float.isNaN(n2)) ? Math.max(this.getSourceWidth(), this.getSourceHeight()) : this.getSourceWidth());
        }
        return sourceHeight;
    }
    
    public final void setSourceRadius(final float value) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourceWidth:()F
        //     4: aload_0         /* this */
        //     5: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourceHeight:()F
        //     8: fdiv           
        //     9: fstore_3       
        //    10: fconst_1       
        //    11: fstore          value$iv
        //    13: iconst_0       
        //    14: istore          $i$f$ifNotFinite
        //    16: fload_3         /* $this$ifNotFinite$iv */
        //    17: fstore          6
        //    19: fload           6
        //    21: invokestatic    java/lang/Float.isInfinite:(F)Z
        //    24: ifne            39
        //    27: fload           6
        //    29: invokestatic    java/lang/Float.isNaN:(F)Z
        //    32: ifne            39
        //    35: iconst_1       
        //    36: goto            40
        //    39: iconst_0       
        //    40: ifeq            47
        //    43: fload_3         /* $this$ifNotFinite$iv */
        //    44: goto            49
        //    47: fload           value$iv
        //    49: fstore_2        /* aspect */
        //    50: aload_0         /* this */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourceWidth:()F
        //    54: aload_0         /* this */
        //    55: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourceHeight:()F
        //    58: fcmpl          
        //    59: iflt            77
        //    62: aload_0         /* this */
        //    63: fload_1         /* value */
        //    64: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceWidth:(F)V
        //    67: aload_0         /* this */
        //    68: fload_1         /* value */
        //    69: fload_2         /* aspect */
        //    70: fdiv           
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceHeight:(F)V
        //    74: goto            89
        //    77: aload_0         /* this */
        //    78: fload_1         /* value */
        //    79: fload_2         /* aspect */
        //    80: fmul           
        //    81: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceWidth:(F)V
        //    84: aload_0         /* this */
        //    85: fload_1         /* value */
        //    86: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceHeight:(F)V
        //    89: return         
        //    StackMapTable: 00 06 FF 00 27 00 07 07 00 02 02 00 02 02 01 02 00 00 40 01 06 41 02 FF 00 1B 00 07 07 00 02 02 02 02 02 01 02 00 00 0B
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
    
    public final float getDestinationRadius() {
        float $this$isNotFinite$iv = this.getDestinationWidth();
        int $i$f$isNotFinite = 0;
        final float n = $this$isNotFinite$iv;
        float destinationHeight;
        if (Float.isInfinite(n) || Float.isNaN(n)) {
            destinationHeight = this.getDestinationHeight();
        }
        else {
            $this$isNotFinite$iv = this.getDestinationHeight();
            $i$f$isNotFinite = 0;
            final float n2 = $this$isNotFinite$iv;
            destinationHeight = ((!Float.isInfinite(n2) && !Float.isNaN(n2)) ? Math.max(this.getDestinationWidth(), this.getDestinationHeight()) : this.getDestinationWidth());
        }
        return destinationHeight;
    }
    
    public final void setDestinationRadius(final float value) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationWidth:()F
        //     4: aload_0         /* this */
        //     5: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationHeight:()F
        //     8: fdiv           
        //     9: fstore_3       
        //    10: fconst_1       
        //    11: fstore          value$iv
        //    13: iconst_0       
        //    14: istore          $i$f$ifNotFinite
        //    16: fload_3         /* $this$ifNotFinite$iv */
        //    17: fstore          6
        //    19: fload           6
        //    21: invokestatic    java/lang/Float.isInfinite:(F)Z
        //    24: ifne            39
        //    27: fload           6
        //    29: invokestatic    java/lang/Float.isNaN:(F)Z
        //    32: ifne            39
        //    35: iconst_1       
        //    36: goto            40
        //    39: iconst_0       
        //    40: ifeq            47
        //    43: fload_3         /* $this$ifNotFinite$iv */
        //    44: goto            49
        //    47: fload           value$iv
        //    49: fstore_2        /* aspect */
        //    50: aload_0         /* this */
        //    51: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationWidth:()F
        //    54: aload_0         /* this */
        //    55: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationHeight:()F
        //    58: fcmpl          
        //    59: iflt            77
        //    62: aload_0         /* this */
        //    63: fload_1         /* value */
        //    64: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setDestinationWidth:(F)V
        //    67: aload_0         /* this */
        //    68: fload_1         /* value */
        //    69: fload_2         /* aspect */
        //    70: fdiv           
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setDestinationHeight:(F)V
        //    74: goto            89
        //    77: aload_0         /* this */
        //    78: fload_1         /* value */
        //    79: fload_2         /* aspect */
        //    80: fmul           
        //    81: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setDestinationWidth:(F)V
        //    84: aload_0         /* this */
        //    85: fload_1         /* value */
        //    86: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setDestinationHeight:(F)V
        //    89: return         
        //    StackMapTable: 00 06 FF 00 27 00 07 07 00 02 02 00 02 02 01 02 00 00 40 01 06 41 02 FF 00 1B 00 07 07 00 02 02 02 02 02 01 02 00 00 0B
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
    
    public final double getRelativeSourceRadiusShortSide() {
        return this.getSourceRadius() / this.getShortSide();
    }
    
    public final void setRelativeSourceRadiusShortSide(final double value) {
        this.setSourceRadius((float)(value * this.getShortSide()));
    }
    
    public final double getRelativeSourceRadiusLongSide() {
        return this.getSourceRadius() / this.getLongSide();
    }
    
    public final void setRelativeSourceRadiusLongSide(final double value) {
        this.setSourceRadius((float)(value * this.getLongSide()));
    }
    
    public final double getRelativeSourceWidthShortSide() {
        return this.getSourceWidth() / this.getShortSide();
    }
    
    public final void setRelativeSourceWidthShortSide(final double value) {
        this.setSourceWidth((float)(value * this.getShortSide()));
    }
    
    public final double getRelativeSourceWidthLongSide() {
        return this.getSourceWidth() / this.getLongSide();
    }
    
    public final void setRelativeSourceWidthLongSide(final double value) {
        this.setSourceWidth((float)(value * this.getLongSide()));
    }
    
    public final double getRelativeSourceHeightShortSide() {
        return this.getSourceHeight() / this.getShortSide();
    }
    
    public final void setRelativeSourceHeightShortSide(final double value) {
        this.setSourceHeight((float)(value * this.getShortSide()));
    }
    
    public final double getRelativeSourceHeightLongSide() {
        return this.getSourceHeight() / this.getLongSide();
    }
    
    public final void setRelativeSourceHeightLongSide(final double value) {
        this.setSourceHeight((float)(value * this.getLongSide()));
    }
    
    public final double getRelativeSourcePositionX() {
        final float[] $this$x$iv = this.getSourcePosition();
        final int $i$f$getX = 0;
        return $this$x$iv[0] / this.sourceContextWidth;
    }
    
    public final double getRelativeSourcePositionY() {
        final float[] $this$y$iv = this.getSourcePosition();
        final int $i$f$getY = 0;
        return $this$y$iv[1] / this.sourceContextHeight;
    }
    
    public final float getSourcePositionX() {
        final float[] $this$x$iv = this.getSourcePosition();
        final int $i$f$getX = 0;
        return $this$x$iv[0];
    }
    
    public final float getSourcePositionY() {
        final float[] $this$y$iv = this.getSourcePosition();
        final int $i$f$getY = 0;
        return $this$y$iv[1];
    }
    
    public final float getDestinationPositionX() {
        final float[] $this$x$iv = this.getDestinationPosition();
        final int $i$f$getX = 0;
        return $this$x$iv[0];
    }
    
    public final float getDestinationPositionY() {
        final float[] $this$y$iv = this.getDestinationPosition();
        final int $i$f$getY = 0;
        return $this$y$iv[1];
    }
    
    @Override
    public void recycle() {
        TransformedVector.Companion.recycle(this);
    }
    
    @Override
    public void reset() {
        this.invertedTransformation.reset();
        this.transformation.reset();
        this.sourceContextWidth = 1.0;
        this.sourceContextHeight = 1.0;
        this.sourceWidthRaw.setDirty(true);
        this.sourceHeightRaw.setDirty(true);
        this.sourcePositionRaw.setDirty(true);
        this.sourceRotationRaw.setDirty(true);
        this.destinationWidthRaw.setDirty(true);
        this.destinationHeightRaw.setDirty(true);
        this.destinationPositionRaw.setDirty(true);
        this.destinationRotationRaw.setDirty(true);
    }
    
    public void setRelativeSource(final double x, final double y, final float rotation) {
        this.setRelativeSource(x, y, Double.NaN, Double.NaN, rotation);
    }
    
    public void setRelativeSource(final double x, final double y, final double radius, final float rotation) {
        this.setRelativeSource(x, y, radius, Double.NaN, rotation);
    }
    
    public void setRelativeSource(final double x, final double y, final double width, final double height, final float rotation) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore          this_$iv
        //     3: iconst_0       
        //     4: istore          $i$f$respectLock
        //     6: aload           this_$iv
        //     8: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    11: ifeq            493
        //    14: aload           this_$iv
        //    16: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    19: checkcast       Ljava/util/concurrent/locks/Lock;
        //    22: astore          12
        //    24: aload           12
        //    26: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    31: nop            
        //    32: iconst_0       
        //    33: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv
        //    35: iconst_0       
        //    36: istore          $i$a$-respectLock-TransformedVector$setRelativeSource$1
        //    38: dload           width
        //    40: dstore          15
        //    42: dload           15
        //    44: invokestatic    java/lang/Double.isInfinite:(D)Z
        //    47: ifne            62
        //    50: dload           15
        //    52: invokestatic    java/lang/Double.isNaN:(D)Z
        //    55: ifne            62
        //    58: iconst_1       
        //    59: goto            63
        //    62: iconst_0       
        //    63: ifeq            109
        //    66: dload           height
        //    68: dstore          15
        //    70: dload           15
        //    72: invokestatic    java/lang/Double.isInfinite:(D)Z
        //    75: ifne            90
        //    78: dload           15
        //    80: invokestatic    java/lang/Double.isNaN:(D)Z
        //    83: ifne            90
        //    86: iconst_1       
        //    87: goto            91
        //    90: iconst_0       
        //    91: ifne            109
        //    94: aload_0         /* this */
        //    95: dload           width
        //    97: aload_0         /* this */
        //    98: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   101: dmul           
        //   102: d2f            
        //   103: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRadius:(F)V
        //   106: goto            260
        //   109: dload           width
        //   111: dstore          15
        //   113: dload           15
        //   115: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   118: ifne            133
        //   121: dload           15
        //   123: invokestatic    java/lang/Double.isNaN:(D)Z
        //   126: ifne            133
        //   129: iconst_1       
        //   130: goto            134
        //   133: iconst_0       
        //   134: ifne            180
        //   137: dload           height
        //   139: dstore          15
        //   141: dload           15
        //   143: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   146: ifne            161
        //   149: dload           15
        //   151: invokestatic    java/lang/Double.isNaN:(D)Z
        //   154: ifne            161
        //   157: iconst_1       
        //   158: goto            162
        //   161: iconst_0       
        //   162: ifeq            180
        //   165: aload_0         /* this */
        //   166: dload           height
        //   168: aload_0         /* this */
        //   169: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   172: dmul           
        //   173: d2f            
        //   174: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRadius:(F)V
        //   177: goto            260
        //   180: dload           width
        //   182: dstore          15
        //   184: dload           15
        //   186: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   189: ifne            204
        //   192: dload           15
        //   194: invokestatic    java/lang/Double.isNaN:(D)Z
        //   197: ifne            204
        //   200: iconst_1       
        //   201: goto            205
        //   204: iconst_0       
        //   205: ifeq            260
        //   208: dload           height
        //   210: dstore          15
        //   212: dload           15
        //   214: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   217: ifne            232
        //   220: dload           15
        //   222: invokestatic    java/lang/Double.isNaN:(D)Z
        //   225: ifne            232
        //   228: iconst_1       
        //   229: goto            233
        //   232: iconst_0       
        //   233: ifeq            260
        //   236: aload_0         /* this */
        //   237: dload           width
        //   239: aload_0         /* this */
        //   240: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   243: dmul           
        //   244: d2f            
        //   245: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceWidth:(F)V
        //   248: aload_0         /* this */
        //   249: dload           height
        //   251: aload_0         /* this */
        //   252: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   255: dmul           
        //   256: d2f            
        //   257: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceHeight:(F)V
        //   260: fload           rotation
        //   262: fstore          17
        //   264: fload           17
        //   266: invokestatic    java/lang/Float.isInfinite:(F)Z
        //   269: ifne            284
        //   272: fload           17
        //   274: invokestatic    java/lang/Float.isNaN:(F)Z
        //   277: ifne            284
        //   280: iconst_1       
        //   281: goto            285
        //   284: iconst_0       
        //   285: ifeq            294
        //   288: aload_0         /* this */
        //   289: fload           rotation
        //   291: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRotation:(F)V
        //   294: dload_1         /* x */
        //   295: dstore          15
        //   297: dload           15
        //   299: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   302: ifne            317
        //   305: dload           15
        //   307: invokestatic    java/lang/Double.isNaN:(D)Z
        //   310: ifne            317
        //   313: iconst_1       
        //   314: goto            318
        //   317: iconst_0       
        //   318: ifeq            379
        //   321: aload_0         /* this */
        //   322: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   325: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   328: checkcast       [F
        //   331: astore          17
        //   333: dload_1         /* x */
        //   334: aload_0         /* this */
        //   335: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextWidth:D
        //   338: dmul           
        //   339: d2f            
        //   340: fstore          value$iv
        //   342: iconst_0       
        //   343: istore          $i$f$setX
        //   345: aload           $this$x$iv
        //   347: iconst_0       
        //   348: fload           value$iv
        //   350: fastore        
        //   351: nop            
        //   352: aload_0         /* this */
        //   353: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   356: astore          this_$iv
        //   358: iconst_0       
        //   359: istore          $i$f$setUpdatedFlag
        //   361: aload           this_$iv
        //   363: iconst_0       
        //   364: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   367: aload           this_$iv
        //   369: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   372: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   377: pop            
        //   378: nop            
        //   379: dload_3         /* y */
        //   380: dstore          15
        //   382: dload           15
        //   384: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   387: ifne            402
        //   390: dload           15
        //   392: invokestatic    java/lang/Double.isNaN:(D)Z
        //   395: ifne            402
        //   398: iconst_1       
        //   399: goto            403
        //   402: iconst_0       
        //   403: ifeq            464
        //   406: aload_0         /* this */
        //   407: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   410: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   413: checkcast       [F
        //   416: astore          17
        //   418: dload_3         /* y */
        //   419: aload_0         /* this */
        //   420: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextHeight:D
        //   423: dmul           
        //   424: d2f            
        //   425: fstore          value$iv
        //   427: iconst_0       
        //   428: istore          $i$f$setY
        //   430: aload           $this$y$iv
        //   432: iconst_1       
        //   433: fload           value$iv
        //   435: fastore        
        //   436: nop            
        //   437: aload_0         /* this */
        //   438: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   441: astore          this_$iv
        //   443: iconst_0       
        //   444: istore          $i$f$setUpdatedFlag
        //   446: aload           this_$iv
        //   448: iconst_0       
        //   449: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   452: aload           this_$iv
        //   454: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   457: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   462: pop            
        //   463: nop            
        //   464: nop            
        //   465: nop            
        //   466: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   469: astore          13
        //   471: aload           12
        //   473: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   478: goto            923
        //   481: astore          13
        //   483: aload           12
        //   485: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   490: aload           13
        //   492: athrow         
        //   493: iconst_0       
        //   494: istore          $i$a$-respectLock-TransformedVector$setRelativeSource$1
        //   496: dload           width
        //   498: dstore          15
        //   500: dload           15
        //   502: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   505: ifne            520
        //   508: dload           15
        //   510: invokestatic    java/lang/Double.isNaN:(D)Z
        //   513: ifne            520
        //   516: iconst_1       
        //   517: goto            521
        //   520: iconst_0       
        //   521: ifeq            567
        //   524: dload           height
        //   526: dstore          15
        //   528: dload           15
        //   530: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   533: ifne            548
        //   536: dload           15
        //   538: invokestatic    java/lang/Double.isNaN:(D)Z
        //   541: ifne            548
        //   544: iconst_1       
        //   545: goto            549
        //   548: iconst_0       
        //   549: ifne            567
        //   552: aload_0         /* this */
        //   553: dload           width
        //   555: aload_0         /* this */
        //   556: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   559: dmul           
        //   560: d2f            
        //   561: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRadius:(F)V
        //   564: goto            718
        //   567: dload           width
        //   569: dstore          15
        //   571: dload           15
        //   573: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   576: ifne            591
        //   579: dload           15
        //   581: invokestatic    java/lang/Double.isNaN:(D)Z
        //   584: ifne            591
        //   587: iconst_1       
        //   588: goto            592
        //   591: iconst_0       
        //   592: ifne            638
        //   595: dload           height
        //   597: dstore          15
        //   599: dload           15
        //   601: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   604: ifne            619
        //   607: dload           15
        //   609: invokestatic    java/lang/Double.isNaN:(D)Z
        //   612: ifne            619
        //   615: iconst_1       
        //   616: goto            620
        //   619: iconst_0       
        //   620: ifeq            638
        //   623: aload_0         /* this */
        //   624: dload           height
        //   626: aload_0         /* this */
        //   627: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   630: dmul           
        //   631: d2f            
        //   632: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRadius:(F)V
        //   635: goto            718
        //   638: dload           width
        //   640: dstore          15
        //   642: dload           15
        //   644: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   647: ifne            662
        //   650: dload           15
        //   652: invokestatic    java/lang/Double.isNaN:(D)Z
        //   655: ifne            662
        //   658: iconst_1       
        //   659: goto            663
        //   662: iconst_0       
        //   663: ifeq            718
        //   666: dload           height
        //   668: dstore          15
        //   670: dload           15
        //   672: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   675: ifne            690
        //   678: dload           15
        //   680: invokestatic    java/lang/Double.isNaN:(D)Z
        //   683: ifne            690
        //   686: iconst_1       
        //   687: goto            691
        //   690: iconst_0       
        //   691: ifeq            718
        //   694: aload_0         /* this */
        //   695: dload           width
        //   697: aload_0         /* this */
        //   698: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   701: dmul           
        //   702: d2f            
        //   703: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceWidth:(F)V
        //   706: aload_0         /* this */
        //   707: dload           height
        //   709: aload_0         /* this */
        //   710: invokespecial   ly/img/android/pesdk/utils/TransformedVector.getShortSide:()D
        //   713: dmul           
        //   714: d2f            
        //   715: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceHeight:(F)V
        //   718: fload           rotation
        //   720: fstore          17
        //   722: fload           17
        //   724: invokestatic    java/lang/Float.isInfinite:(F)Z
        //   727: ifne            742
        //   730: fload           17
        //   732: invokestatic    java/lang/Float.isNaN:(F)Z
        //   735: ifne            742
        //   738: iconst_1       
        //   739: goto            743
        //   742: iconst_0       
        //   743: ifeq            752
        //   746: aload_0         /* this */
        //   747: fload           rotation
        //   749: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.setSourceRotation:(F)V
        //   752: dload_1         /* x */
        //   753: dstore          15
        //   755: dload           15
        //   757: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   760: ifne            775
        //   763: dload           15
        //   765: invokestatic    java/lang/Double.isNaN:(D)Z
        //   768: ifne            775
        //   771: iconst_1       
        //   772: goto            776
        //   775: iconst_0       
        //   776: ifeq            837
        //   779: aload_0         /* this */
        //   780: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   783: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   786: checkcast       [F
        //   789: astore          17
        //   791: dload_1         /* x */
        //   792: aload_0         /* this */
        //   793: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextWidth:D
        //   796: dmul           
        //   797: d2f            
        //   798: fstore          value$iv
        //   800: iconst_0       
        //   801: istore          $i$f$setX
        //   803: aload           $this$x$iv
        //   805: iconst_0       
        //   806: fload           value$iv
        //   808: fastore        
        //   809: nop            
        //   810: aload_0         /* this */
        //   811: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   814: astore          this_$iv
        //   816: iconst_0       
        //   817: istore          $i$f$setUpdatedFlag
        //   819: aload           this_$iv
        //   821: iconst_0       
        //   822: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   825: aload           this_$iv
        //   827: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   830: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   835: pop            
        //   836: nop            
        //   837: dload_3         /* y */
        //   838: dstore          15
        //   840: dload           15
        //   842: invokestatic    java/lang/Double.isInfinite:(D)Z
        //   845: ifne            860
        //   848: dload           15
        //   850: invokestatic    java/lang/Double.isNaN:(D)Z
        //   853: ifne            860
        //   856: iconst_1       
        //   857: goto            861
        //   860: iconst_0       
        //   861: ifeq            922
        //   864: aload_0         /* this */
        //   865: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   868: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   871: checkcast       [F
        //   874: astore          17
        //   876: dload_3         /* y */
        //   877: aload_0         /* this */
        //   878: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextHeight:D
        //   881: dmul           
        //   882: d2f            
        //   883: fstore          value$iv
        //   885: iconst_0       
        //   886: istore          $i$f$setY
        //   888: aload           $this$y$iv
        //   890: iconst_1       
        //   891: fload           value$iv
        //   893: fastore        
        //   894: nop            
        //   895: aload_0         /* this */
        //   896: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   899: astore          this_$iv
        //   901: iconst_0       
        //   902: istore          $i$f$setUpdatedFlag
        //   904: aload           this_$iv
        //   906: iconst_0       
        //   907: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   910: aload           this_$iv
        //   912: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   915: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   920: pop            
        //   921: nop            
        //   922: nop            
        //   923: nop            
        //   924: return         
        //    StackMapTable: 00 33 FF 00 3E 00 0C 07 00 02 03 03 03 03 02 07 00 02 01 07 00 DD 01 01 03 00 00 40 01 1A 40 01 11 17 40 01 1A 40 01 11 17 40 01 1A 40 01 1A FC 00 17 02 40 01 08 16 40 01 FA 00 3C 16 40 01 3C FF 00 10 00 09 07 00 02 03 03 03 03 02 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FF 00 1A 00 0C 07 00 02 03 03 03 03 02 07 00 02 01 00 00 01 03 00 00 40 01 1A 40 01 11 17 40 01 1A 40 01 11 17 40 01 1A 40 01 1A FC 00 17 02 40 01 08 16 40 01 FA 00 3C 16 40 01 3C 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  31     471    481    493    Any
        //  481    483    481    493    Any
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public void setSource(final float x, final float y, final float rotation) {
        this.setSource(x, y, Float.NaN, Float.NaN, rotation);
    }
    
    public void setSource(final float x, final float y, final float radius, final float rotation) {
        this.setSource(x, y, radius, Float.NaN, rotation);
    }
    
    public void setSource(final float x, final float y, final float width, final float height, final float rotation) {
        final TransformedVector this_$iv = this;
        final int $i$f$respectLock = 0;
        if (this_$iv.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this_$iv);
            reentrantLock.lock();
            try {
                final int n = 0;
                final int n2 = 0;
                if (!Float.isInfinite(width) && !Float.isNaN(width) && (Float.isInfinite(height) || Float.isNaN(height))) {
                    this.setSourceRadius(width);
                }
                else if ((Float.isInfinite(width) || Float.isNaN(width)) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
                    this.setSourceRadius(height);
                }
                else if (!Float.isInfinite(width) && !Float.isNaN(width) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
                    this.setSourceWidth(width);
                    this.setSourceHeight(height);
                }
                this.setSourceRotation(rotation);
                final float[] $this$x$iv = this.sourcePositionRaw.getValue();
                final int $i$f$setX = 0;
                $this$x$iv[0] = x;
                final float[] $this$y$iv = this.sourcePositionRaw.getValue();
                final int $i$f$setY = 0;
                $this$y$iv[1] = y;
                final TransformableValue this_$iv2 = this.sourcePositionRaw;
                final int $i$f$setUpdatedFlag = 0;
                this_$iv2.setDirty(false);
                this_$iv2.getOnSet().invoke();
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final int n2 = 0;
        if (!Float.isInfinite(width) && !Float.isNaN(width) && (Float.isInfinite(height) || Float.isNaN(height))) {
            this.setSourceRadius(width);
        }
        else if ((Float.isInfinite(width) || Float.isNaN(width)) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
            this.setSourceRadius(height);
        }
        else if (!Float.isInfinite(width) && !Float.isNaN(width) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
            this.setSourceWidth(width);
            this.setSourceHeight(height);
        }
        this.setSourceRotation(rotation);
        final float[] $this$x$iv = this.sourcePositionRaw.getValue();
        final int $i$f$setX = 0;
        $this$x$iv[0] = x;
        final float[] $this$y$iv = this.sourcePositionRaw.getValue();
        final int $i$f$setY = 0;
        $this$y$iv[1] = y;
        final TransformableValue this_$iv2 = this.sourcePositionRaw;
        final int $i$f$setUpdatedFlag = 0;
        this_$iv2.setDirty(false);
        this_$iv2.getOnSet().invoke();
    }
    
    public void setDestination(final float x, final float y, final float radius, final float rotation) {
        this.setDestination(x, y, radius, Float.NaN, rotation);
    }
    
    public void setDestination(final float x, final float y, final float width, final float height, final float rotation) {
        final TransformedVector this_$iv = this;
        final int $i$f$respectLock = 0;
        if (this_$iv.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this_$iv);
            reentrantLock.lock();
            try {
                final int n = 0;
                final int n2 = 0;
                if (!Float.isInfinite(width) && !Float.isNaN(width) && (Float.isInfinite(height) || Float.isNaN(height))) {
                    this.setDestinationRadius(width);
                }
                else if ((Float.isInfinite(width) || Float.isNaN(width)) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
                    this.setDestinationRadius(height);
                }
                else if (!Float.isInfinite(width) && !Float.isNaN(width) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
                    this.setDestinationWidth(width);
                    this.setDestinationHeight(height);
                }
                if (!Float.isInfinite(rotation) && !Float.isNaN(rotation)) {
                    this.setDestinationRotation(rotation);
                }
                boolean posNeedUpdate = false;
                if (!Float.isInfinite(x) && !Float.isNaN(x)) {
                    final float[] $this$x$iv = this.destinationPositionRaw.getValue();
                    final int $i$f$setX = 0;
                    $this$x$iv[0] = x;
                    posNeedUpdate = true;
                }
                if (!Float.isInfinite(y) && !Float.isNaN(y)) {
                    final float[] $this$y$iv = this.destinationPositionRaw.getValue();
                    final int $i$f$setY = 0;
                    $this$y$iv[1] = y;
                    posNeedUpdate = true;
                }
                if (posNeedUpdate) {
                    final TransformableValue this_$iv2 = this.destinationPositionRaw;
                    final int $i$f$setUpdatedFlag = 0;
                    this_$iv2.setDirty(false);
                    this_$iv2.getOnSet().invoke();
                }
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final int n2 = 0;
        if (!Float.isInfinite(width) && !Float.isNaN(width) && (Float.isInfinite(height) || Float.isNaN(height))) {
            this.setDestinationRadius(width);
        }
        else if ((Float.isInfinite(width) || Float.isNaN(width)) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
            this.setDestinationRadius(height);
        }
        else if (!Float.isInfinite(width) && !Float.isNaN(width) && (!Float.isInfinite(height) && !Float.isNaN(height))) {
            this.setDestinationWidth(width);
            this.setDestinationHeight(height);
        }
        if (!Float.isInfinite(rotation) && !Float.isNaN(rotation)) {
            this.setDestinationRotation(rotation);
        }
        boolean posNeedUpdate = false;
        if (!Float.isInfinite(x) && !Float.isNaN(x)) {
            final float[] $this$x$iv = this.destinationPositionRaw.getValue();
            final int $i$f$setX = 0;
            $this$x$iv[0] = x;
            posNeedUpdate = true;
        }
        if (!Float.isInfinite(y) && !Float.isNaN(y)) {
            final float[] $this$y$iv = this.destinationPositionRaw.getValue();
            final int $i$f$setY = 0;
            $this$y$iv[1] = y;
            posNeedUpdate = true;
        }
        if (posNeedUpdate) {
            final TransformableValue this_$iv2 = this.destinationPositionRaw;
            final int $i$f$setUpdatedFlag = 0;
            this_$iv2.setDirty(false);
            this_$iv2.getOnSet().invoke();
        }
    }
    
    public void setRelativeSourcePosition(final float x, final float y) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: astore_3        /* this_$iv */
        //     2: iconst_0       
        //     3: istore          $i$f$respectLock
        //     5: aload_3         /* this_$iv */
        //     6: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //     9: ifeq            155
        //    12: aload_3         /* this_$iv */
        //    13: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    16: checkcast       Ljava/util/concurrent/locks/Lock;
        //    19: astore          5
        //    21: aload           5
        //    23: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    28: nop            
        //    29: iconst_0       
        //    30: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv
        //    32: iconst_0       
        //    33: istore          $i$a$-respectLock-TransformedVector$setRelativeSourcePosition$1
        //    35: aload_0         /* this */
        //    36: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    39: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    42: checkcast       [F
        //    45: astore          8
        //    47: fload_1         /* x */
        //    48: f2d            
        //    49: aload_0         /* this */
        //    50: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextWidth:D
        //    53: dmul           
        //    54: d2f            
        //    55: fstore          value$iv
        //    57: iconst_0       
        //    58: istore          $i$f$setX
        //    60: aload           $this$x$iv
        //    62: iconst_0       
        //    63: fload           value$iv
        //    65: fastore        
        //    66: nop            
        //    67: aload_0         /* this */
        //    68: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    71: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    74: checkcast       [F
        //    77: astore          8
        //    79: fload_2         /* y */
        //    80: f2d            
        //    81: aload_0         /* this */
        //    82: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextHeight:D
        //    85: dmul           
        //    86: d2f            
        //    87: fstore          value$iv
        //    89: iconst_0       
        //    90: istore          $i$f$setY
        //    92: aload           $this$y$iv
        //    94: iconst_1       
        //    95: fload           value$iv
        //    97: fastore        
        //    98: nop            
        //    99: aload_0         /* this */
        //   100: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   103: astore          this_$iv
        //   105: iconst_0       
        //   106: istore          $i$f$setUpdatedFlag
        //   108: aload           this_$iv
        //   110: iconst_0       
        //   111: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   114: aload           this_$iv
        //   116: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   119: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   124: pop            
        //   125: nop            
        //   126: nop            
        //   127: nop            
        //   128: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   131: astore          6
        //   133: aload           5
        //   135: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   140: goto            250
        //   143: astore          6
        //   145: aload           5
        //   147: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   152: aload           6
        //   154: athrow         
        //   155: iconst_0       
        //   156: istore          $i$a$-respectLock-TransformedVector$setRelativeSourcePosition$1
        //   158: aload_0         /* this */
        //   159: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   162: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   165: checkcast       [F
        //   168: astore          8
        //   170: fload_1         /* x */
        //   171: f2d            
        //   172: aload_0         /* this */
        //   173: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextWidth:D
        //   176: dmul           
        //   177: d2f            
        //   178: fstore          value$iv
        //   180: iconst_0       
        //   181: istore          $i$f$setX
        //   183: aload           $this$x$iv
        //   185: iconst_0       
        //   186: fload           value$iv
        //   188: fastore        
        //   189: nop            
        //   190: aload_0         /* this */
        //   191: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   194: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   197: checkcast       [F
        //   200: astore          8
        //   202: fload_2         /* y */
        //   203: f2d            
        //   204: aload_0         /* this */
        //   205: getfield        ly/img/android/pesdk/utils/TransformedVector.sourceContextHeight:D
        //   208: dmul           
        //   209: d2f            
        //   210: fstore          value$iv
        //   212: iconst_0       
        //   213: istore          $i$f$setY
        //   215: aload           $this$y$iv
        //   217: iconst_1       
        //   218: fload           value$iv
        //   220: fastore        
        //   221: nop            
        //   222: aload_0         /* this */
        //   223: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   226: astore          this_$iv
        //   228: iconst_0       
        //   229: istore          $i$f$setUpdatedFlag
        //   231: aload           this_$iv
        //   233: iconst_0       
        //   234: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   237: aload           this_$iv
        //   239: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   242: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   247: pop            
        //   248: nop            
        //   249: nop            
        //   250: nop            
        //   251: return         
        //    StackMapTable: 00 03 FF 00 8F 00 06 07 00 02 02 02 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FF 00 5E 00 0B 07 00 02 02 02 07 00 02 01 00 00 01 07 00 7D 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  28     133    143    155    Any
        //  143    145    143    155    Any
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
    
    public void setSourcePosition(final float x, final float y) {
        final TransformedVector this_$iv = this;
        final int $i$f$respectLock = 0;
        if (this_$iv.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this_$iv);
            reentrantLock.lock();
            try {
                final int n = 0;
                final int n2 = 0;
                final float[] $this$x$iv = this.sourcePositionRaw.getValue();
                final int $i$f$setX = 0;
                $this$x$iv[0] = x;
                final float[] $this$y$iv = this.sourcePositionRaw.getValue();
                final int $i$f$setY = 0;
                $this$y$iv[1] = y;
                final TransformableValue this_$iv2 = this.sourcePositionRaw;
                final int $i$f$setUpdatedFlag = 0;
                this_$iv2.setDirty(false);
                this_$iv2.getOnSet().invoke();
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final int n2 = 0;
        final float[] $this$x$iv = this.sourcePositionRaw.getValue();
        final int $i$f$setX = 0;
        $this$x$iv[0] = x;
        final float[] $this$y$iv = this.sourcePositionRaw.getValue();
        final int $i$f$setY = 0;
        $this$y$iv[1] = y;
        final TransformableValue this_$iv2 = this.sourcePositionRaw;
        final int $i$f$setUpdatedFlag = 0;
        this_$iv2.setDirty(false);
        this_$iv2.getOnSet().invoke();
    }
    
    public void setDestinationPosition(final float x, final float y) {
        final TransformedVector this_$iv = this;
        final int $i$f$respectLock = 0;
        if (this_$iv.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this_$iv);
            reentrantLock.lock();
            try {
                final int n = 0;
                final int n2 = 0;
                final float[] $this$x$iv = this.destinationPositionRaw.getValue();
                final int $i$f$setX = 0;
                $this$x$iv[0] = x;
                final float[] $this$y$iv = this.destinationPositionRaw.getValue();
                final int $i$f$setY = 0;
                $this$y$iv[1] = y;
                final TransformableValue this_$iv2 = this.destinationPositionRaw;
                final int $i$f$setUpdatedFlag = 0;
                this_$iv2.setDirty(false);
                this_$iv2.getOnSet().invoke();
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final int n2 = 0;
        final float[] $this$x$iv = this.destinationPositionRaw.getValue();
        final int $i$f$setX = 0;
        $this$x$iv[0] = x;
        final float[] $this$y$iv = this.destinationPositionRaw.getValue();
        final int $i$f$setY = 0;
        $this$y$iv[1] = y;
        final TransformableValue this_$iv2 = this.destinationPositionRaw;
        final int $i$f$setUpdatedFlag = 0;
        this_$iv2.setDirty(false);
        this_$iv2.getOnSet().invoke();
    }
    
    public void setSourcePositionOffset(final float offsetX, final float offsetY) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourcePositionX:()F
        //     4: fstore_3        /* currentX */
        //     5: aload_0         /* this */
        //     6: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getSourcePositionY:()F
        //     9: fstore          currentY
        //    11: aload_0         /* this */
        //    12: astore          this_$iv
        //    14: iconst_0       
        //    15: istore          $i$f$respectLock
        //    17: aload           this_$iv
        //    19: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    22: ifeq            160
        //    25: aload           this_$iv
        //    27: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    30: checkcast       Ljava/util/concurrent/locks/Lock;
        //    33: astore          7
        //    35: aload           7
        //    37: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    42: nop            
        //    43: iconst_0       
        //    44: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv
        //    46: iconst_0       
        //    47: istore          $i$a$-respectLock-TransformedVector$setSourcePositionOffset$1
        //    49: aload_0         /* this */
        //    50: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    56: checkcast       [F
        //    59: astore          10
        //    61: fload_3         /* currentX */
        //    62: fload_1         /* offsetX */
        //    63: fadd           
        //    64: fstore          value$iv
        //    66: iconst_0       
        //    67: istore          $i$f$setX
        //    69: aload           $this$x$iv
        //    71: iconst_0       
        //    72: fload           value$iv
        //    74: fastore        
        //    75: nop            
        //    76: aload_0         /* this */
        //    77: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    80: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    83: checkcast       [F
        //    86: astore          10
        //    88: fload           currentY
        //    90: fload_2         /* offsetY */
        //    91: fadd           
        //    92: fstore          value$iv
        //    94: iconst_0       
        //    95: istore          $i$f$setY
        //    97: aload           $this$y$iv
        //    99: iconst_1       
        //   100: fload           value$iv
        //   102: fastore        
        //   103: nop            
        //   104: aload_0         /* this */
        //   105: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   108: astore          this_$iv
        //   110: iconst_0       
        //   111: istore          $i$f$setUpdatedFlag
        //   113: aload           this_$iv
        //   115: iconst_0       
        //   116: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   119: aload           this_$iv
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   124: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   129: pop            
        //   130: nop            
        //   131: nop            
        //   132: nop            
        //   133: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   136: astore          8
        //   138: aload           7
        //   140: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   145: goto            246
        //   148: astore          8
        //   150: aload           7
        //   152: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   157: aload           8
        //   159: athrow         
        //   160: iconst_0       
        //   161: istore          $i$a$-respectLock-TransformedVector$setSourcePositionOffset$1
        //   163: aload_0         /* this */
        //   164: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   167: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   170: checkcast       [F
        //   173: astore          10
        //   175: fload_3         /* currentX */
        //   176: fload_1         /* offsetX */
        //   177: fadd           
        //   178: fstore          value$iv
        //   180: iconst_0       
        //   181: istore          $i$f$setX
        //   183: aload           $this$x$iv
        //   185: iconst_0       
        //   186: fload           value$iv
        //   188: fastore        
        //   189: nop            
        //   190: aload_0         /* this */
        //   191: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   194: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   197: checkcast       [F
        //   200: astore          10
        //   202: fload           currentY
        //   204: fload_2         /* offsetY */
        //   205: fadd           
        //   206: fstore          value$iv
        //   208: iconst_0       
        //   209: istore          $i$f$setY
        //   211: aload           $this$y$iv
        //   213: iconst_1       
        //   214: fload           value$iv
        //   216: fastore        
        //   217: nop            
        //   218: aload_0         /* this */
        //   219: getfield        ly/img/android/pesdk/utils/TransformedVector.sourcePositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   222: astore          this_$iv
        //   224: iconst_0       
        //   225: istore          $i$f$setUpdatedFlag
        //   227: aload           this_$iv
        //   229: iconst_0       
        //   230: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   233: aload           this_$iv
        //   235: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   238: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   243: pop            
        //   244: nop            
        //   245: nop            
        //   246: nop            
        //   247: return         
        //    StackMapTable: 00 03 FF 00 94 00 08 07 00 02 02 02 02 02 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FF 00 55 00 0D 07 00 02 02 02 02 02 07 00 02 01 00 00 01 07 00 7D 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  42     138    148    160    Any
        //  148    150    148    160    Any
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
    
    public void setDestinationPositionOffset(final float offsetX, final float offsetY) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationPositionX:()F
        //     4: fstore_3        /* currentX */
        //     5: aload_0         /* this */
        //     6: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.getDestinationPositionY:()F
        //     9: fstore          currentY
        //    11: aload_0         /* this */
        //    12: astore          this_$iv
        //    14: iconst_0       
        //    15: istore          $i$f$respectLock
        //    17: aload           this_$iv
        //    19: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    22: ifeq            160
        //    25: aload           this_$iv
        //    27: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    30: checkcast       Ljava/util/concurrent/locks/Lock;
        //    33: astore          7
        //    35: aload           7
        //    37: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    42: nop            
        //    43: iconst_0       
        //    44: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv
        //    46: iconst_0       
        //    47: istore          $i$a$-respectLock-TransformedVector$setDestinationPositionOffset$1
        //    49: aload_0         /* this */
        //    50: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    53: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    56: checkcast       [F
        //    59: astore          10
        //    61: fload_3         /* currentX */
        //    62: fload_1         /* offsetX */
        //    63: fadd           
        //    64: fstore          value$iv
        //    66: iconst_0       
        //    67: istore          $i$f$setX
        //    69: aload           $this$x$iv
        //    71: iconst_0       
        //    72: fload           value$iv
        //    74: fastore        
        //    75: nop            
        //    76: aload_0         /* this */
        //    77: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //    80: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //    83: checkcast       [F
        //    86: astore          10
        //    88: fload           currentY
        //    90: fload_2         /* offsetY */
        //    91: fadd           
        //    92: fstore          value$iv
        //    94: iconst_0       
        //    95: istore          $i$f$setY
        //    97: aload           $this$y$iv
        //    99: iconst_1       
        //   100: fload           value$iv
        //   102: fastore        
        //   103: nop            
        //   104: aload_0         /* this */
        //   105: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   108: astore          this_$iv
        //   110: iconst_0       
        //   111: istore          $i$f$setUpdatedFlag
        //   113: aload           this_$iv
        //   115: iconst_0       
        //   116: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   119: aload           this_$iv
        //   121: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   124: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   129: pop            
        //   130: nop            
        //   131: nop            
        //   132: nop            
        //   133: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   136: astore          8
        //   138: aload           7
        //   140: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   145: goto            246
        //   148: astore          8
        //   150: aload           7
        //   152: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   157: aload           8
        //   159: athrow         
        //   160: iconst_0       
        //   161: istore          $i$a$-respectLock-TransformedVector$setDestinationPositionOffset$1
        //   163: aload_0         /* this */
        //   164: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   167: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   170: checkcast       [F
        //   173: astore          10
        //   175: fload_3         /* currentX */
        //   176: fload_1         /* offsetX */
        //   177: fadd           
        //   178: fstore          value$iv
        //   180: iconst_0       
        //   181: istore          $i$f$setX
        //   183: aload           $this$x$iv
        //   185: iconst_0       
        //   186: fload           value$iv
        //   188: fastore        
        //   189: nop            
        //   190: aload_0         /* this */
        //   191: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   194: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getValue:()Ljava/lang/Object;
        //   197: checkcast       [F
        //   200: astore          10
        //   202: fload           currentY
        //   204: fload_2         /* offsetY */
        //   205: fadd           
        //   206: fstore          value$iv
        //   208: iconst_0       
        //   209: istore          $i$f$setY
        //   211: aload           $this$y$iv
        //   213: iconst_1       
        //   214: fload           value$iv
        //   216: fastore        
        //   217: nop            
        //   218: aload_0         /* this */
        //   219: getfield        ly/img/android/pesdk/utils/TransformedVector.destinationPositionRaw:Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;
        //   222: astore          this_$iv
        //   224: iconst_0       
        //   225: istore          $i$f$setUpdatedFlag
        //   227: aload           this_$iv
        //   229: iconst_0       
        //   230: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.setDirty:(Z)V
        //   233: aload           this_$iv
        //   235: invokevirtual   ly/img/android/pesdk/utils/TransformedVector$TransformableValue.getOnSet:()Lkotlin/jvm/functions/Function0;
        //   238: invokeinterface kotlin/jvm/functions/Function0.invoke:()Ljava/lang/Object;
        //   243: pop            
        //   244: nop            
        //   245: nop            
        //   246: nop            
        //   247: return         
        //    StackMapTable: 00 03 FF 00 94 00 08 07 00 02 02 02 02 02 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FF 00 55 00 0D 07 00 02 02 02 02 02 07 00 02 01 00 00 01 07 00 7D 01 01 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  42     138    148    160    Any
        //  148    150    148    160    Any
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
    
    public void updateTransformation(@NotNull final MultiRect source, @NotNull final MultiRect destination) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc_w           "source"
        //     4: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     7: aload_2         /* destination */
        //     8: ldc_w           "destination"
        //    11: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    14: aload_0         /* this */
        //    15: astore_3        /* this_$iv */
        //    16: iconst_0       
        //    17: istore          $i$f$respectLock
        //    19: aload_3         /* this_$iv */
        //    20: invokevirtual   ly/img/android/pesdk/utils/TransformedVector.isAtomic:()Z
        //    23: ifeq            170
        //    26: aload_3         /* this_$iv */
        //    27: invokestatic    ly/img/android/pesdk/utils/TransformedVector.access$getLock:(Lly/img/android/pesdk/utils/TransformedVector;)Ljava/util/concurrent/locks/ReentrantLock;
        //    30: checkcast       Ljava/util/concurrent/locks/Lock;
        //    33: astore          5
        //    35: aload           5
        //    37: invokeinterface java/util/concurrent/locks/Lock.lock:()V
        //    42: nop            
        //    43: iconst_0       
        //    44: istore          $i$a$-withLock-TransformedVector$respectLock$1$iv
        //    46: iconst_0       
        //    47: istore          $i$a$-respectLock-TransformedVector$updateTransformation$1
        //    49: aload_0         /* this */
        //    50: getfield        ly/img/android/pesdk/utils/TransformedVector.transformation:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //    53: aload_0         /* this */
        //    54: getfield        ly/img/android/pesdk/utils/TransformedVector.dummySourceShape:[F
        //    57: astore          8
        //    59: aload           8
        //    61: astore          9
        //    63: astore          10
        //    65: iconst_0       
        //    66: istore          $i$a$-also-TransformedVector$updateTransformation$1$1
        //    68: aload_1         /* source */
        //    69: aload           it
        //    71: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.toShape:([F)V
        //    74: aload           10
        //    76: aload           8
        //    78: iconst_0       
        //    79: aload_0         /* this */
        //    80: getfield        ly/img/android/pesdk/utils/TransformedVector.dummyDestinationShape:[F
        //    83: astore          8
        //    85: aload           8
        //    87: astore          9
        //    89: istore          12
        //    91: astore          13
        //    93: astore          10
        //    95: iconst_0       
        //    96: istore          $i$a$-also-TransformedVector$updateTransformation$1$2
        //    98: aload_2         /* destination */
        //    99: aload           it
        //   101: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.toShape:([F)V
        //   104: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   107: astore          14
        //   109: aload           10
        //   111: aload           13
        //   113: iload           12
        //   115: aload           8
        //   117: iconst_0       
        //   118: iconst_4       
        //   119: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.setPolyToPoly:([FI[FII)Z
        //   122: pop            
        //   123: aload_0         /* this */
        //   124: aload_0         /* this */
        //   125: getfield        ly/img/android/pesdk/utils/TransformedVector.transformation:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //   128: aload_1         /* source */
        //   129: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.width:()F
        //   132: f2d            
        //   133: aload_1         /* source */
        //   134: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.height:()F
        //   137: f2d            
        //   138: invokespecial   ly/img/android/pesdk/utils/TransformedVector.internalUpdateTransformation:(Lly/img/android/pesdk/backend/model/chunk/Transformation;DD)V
        //   141: nop            
        //   142: nop            
        //   143: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   146: astore          6
        //   148: aload           5
        //   150: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   155: goto            266
        //   158: astore          6
        //   160: aload           5
        //   162: invokeinterface java/util/concurrent/locks/Lock.unlock:()V
        //   167: aload           6
        //   169: athrow         
        //   170: iconst_0       
        //   171: istore          $i$a$-respectLock-TransformedVector$updateTransformation$1
        //   173: aload_0         /* this */
        //   174: getfield        ly/img/android/pesdk/utils/TransformedVector.transformation:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //   177: aload_0         /* this */
        //   178: getfield        ly/img/android/pesdk/utils/TransformedVector.dummySourceShape:[F
        //   181: astore          8
        //   183: aload           8
        //   185: astore          9
        //   187: astore          10
        //   189: iconst_0       
        //   190: istore          $i$a$-also-TransformedVector$updateTransformation$1$1
        //   192: aload_1         /* source */
        //   193: aload           it
        //   195: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.toShape:([F)V
        //   198: aload           10
        //   200: aload           8
        //   202: iconst_0       
        //   203: aload_0         /* this */
        //   204: getfield        ly/img/android/pesdk/utils/TransformedVector.dummyDestinationShape:[F
        //   207: astore          8
        //   209: aload           8
        //   211: astore          9
        //   213: istore          12
        //   215: astore          13
        //   217: astore          10
        //   219: iconst_0       
        //   220: istore          $i$a$-also-TransformedVector$updateTransformation$1$2
        //   222: aload_2         /* destination */
        //   223: aload           it
        //   225: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.toShape:([F)V
        //   228: getstatic       kotlin/Unit.INSTANCE:Lkotlin/Unit;
        //   231: astore          14
        //   233: aload           10
        //   235: aload           13
        //   237: iload           12
        //   239: aload           8
        //   241: iconst_0       
        //   242: iconst_4       
        //   243: invokevirtual   ly/img/android/pesdk/backend/model/chunk/Transformation.setPolyToPoly:([FI[FII)Z
        //   246: pop            
        //   247: aload_0         /* this */
        //   248: aload_0         /* this */
        //   249: getfield        ly/img/android/pesdk/utils/TransformedVector.transformation:Lly/img/android/pesdk/backend/model/chunk/Transformation;
        //   252: aload_1         /* source */
        //   253: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.width:()F
        //   256: f2d            
        //   257: aload_1         /* source */
        //   258: invokevirtual   ly/img/android/pesdk/backend/model/chunk/MultiRect.height:()F
        //   261: f2d            
        //   262: invokespecial   ly/img/android/pesdk/utils/TransformedVector.internalUpdateTransformation:(Lly/img/android/pesdk/backend/model/chunk/Transformation;DD)V
        //   265: nop            
        //   266: nop            
        //   267: return         
        //    StackMapTable: 00 03 FF 00 9E 00 06 07 00 02 07 02 0F 07 02 0F 07 00 02 01 07 00 DD 00 01 07 00 FA FA 00 0B FF 00 5F 00 0F 07 00 02 07 02 0F 07 02 0F 07 00 02 01 00 00 01 07 01 21 07 01 21 07 00 21 01 01 07 01 21 07 00 E5 00 00
        //    Exceptions:
        //  Try           Handler
        //  Start  End    Start  End    Type
        //  -----  -----  -----  -----  ----
        //  42     148    158    170    Any
        //  158    160    158    170    Any
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
    
    public void updateTransformation(@Nullable final Transformation transformation, final int sourceContextWidth, final int sourceContextHeight) {
        this.updateTransformation(transformation, sourceContextWidth, (double)sourceContextHeight);
    }
    
    public void updateTransformation(@Nullable final Transformation transformation, final float sourceContextWidth, final float sourceContextHeight) {
        this.updateTransformation(transformation, sourceContextWidth, (double)sourceContextHeight);
    }
    
    public void updateTransformation(@Nullable final Transformation transformation, final double sourceContextWidth, final double sourceContextHeight) {
        final TransformedVector this_$iv = this;
        final int $i$f$respectLock = 0;
        if (this_$iv.isAtomic()) {
            final ReentrantLock reentrantLock = access$getLock(this_$iv);
            reentrantLock.lock();
            try {
                final int n = 0;
                final int n2 = 0;
                this.internalUpdateTransformation(transformation, sourceContextWidth, sourceContextHeight);
                final Unit instance = Unit.INSTANCE;
                return;
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final int n2 = 0;
        this.internalUpdateTransformation(transformation, sourceContextWidth, sourceContextHeight);
    }
    
    private final void internalUpdateTransformation(final Transformation transformation, final double sourceWidth, final double sourceHeight) {
        this.sourceContextWidth = sourceWidth;
        this.sourceContextHeight = sourceHeight;
        if (transformation == null) {
            this.transformation.reset();
        }
        else {
            this.transformation.set((Matrix)transformation);
        }
        this.transformation.invert((Matrix)this.invertedTransformation);
        this.destinationWidthRaw.setDirty(!this.sourceWidthRaw.isDirty());
        this.destinationHeightRaw.setDirty(!this.sourceHeightRaw.isDirty());
        this.destinationPositionRaw.setDirty(!this.sourcePositionRaw.isDirty());
        this.destinationRotationRaw.setDirty(!this.sourceRotationRaw.isDirty());
    }
    
    @NotNull
    @Override
    public String toString() {
        return "TransformedVector(sourceContextWidth=" + this.sourceContextWidth + ", sourceContextHeight=" + this.sourceContextHeight + ", transformation=" + this.transformation + ", sourceRotationRaw=" + this.getSourceRotation() + ", destinationRotationRaw=" + this.getDestinationRotation() + ", sourceRadiusRaw=" + this.getSourceRadius() + ", destinationRadiusRaw=" + this.getDestinationRadius() + ", sourcePositionRaw=" + this.getSourcePosition() + ", destinationPositionRaw=" + this.getDestinationPosition() + ')';
    }
    
    @Override
    protected final void finalize() {
        TransformedVector.Companion.wastedObjectDetected(this);
    }
    
    @Override
    public void onRecycle() {
        DefaultImpls.onRecycle(this);
    }
    
    public TransformedVector() {
        this(false, 1, null);
    }
    
    @JvmStatic
    @NotNull
    public static TransformedVector obtain() {
        return TransformedVector.Companion.obtain();
    }
    
    public static final /* synthetic */ ReentrantLock access$getLock(final TransformedVector $this) {
        return $this.lock;
    }
    
    static {
        Companion = new Companion((DefaultConstructorMarker)null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0002H\u0017¨\u0006\u0005" }, d2 = { "Lly/img/android/pesdk/utils/TransformedVector$Companion;", "Lly/img/android/pesdk/backend/model/chunk/Recycler;", "Lly/img/android/pesdk/utils/TransformedVector;", "()V", "obtain", "pesdk-backend-core_release" })
    public static final class Companion extends Recycler<TransformedVector>
    {
        private Companion() {
            super(1000, (Function0)TransformedVector$Companion$1.INSTANCE);
        }
        
        @JvmStatic
        @NotNull
        @Override
        public TransformedVector obtain() {
            return super.obtain();
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00008\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0012\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0084\u0004\u0018\u0000*\u0006\b\u0000\u0010\u0001 \u0000*\u0004\b\u0001\u0010\u00022\u00020\u0003B>\u0012\u0006\u0010\u0004\u001a\u00028\u0001\u0012!\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00028\u00010\u0006\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n¢\u0006\u0002\u0010\fJ\"\u0010\u001a\u001a\u00028\u00012\u0006\u0010\u001f\u001a\u00028\u00002\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!H\u0086\n¢\u0006\u0002\u0010\"J\t\u0010#\u001a\u00020\u000bH\u0086\bJ*\u0010\u001c\u001a\u00020\u000b2\u0006\u0010\u001f\u001a\u00028\u00002\n\u0010 \u001a\u0006\u0012\u0002\b\u00030!2\u0006\u0010\u0004\u001a\u00028\u0001H\u0086\n¢\u0006\u0002\u0010$R\u001a\u0010\r\u001a\u00020\u000eX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000f\"\u0004\b\u0010\u0010\u0011R \u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R5\u0010\u0005\u001a\u001d\u0012\u0013\u0012\u00118\u0001¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u0004\u0012\u0004\u0012\u00028\u00010\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001c\u0010\u0004\u001a\u00028\u0001X\u0086\u000e¢\u0006\u0010\n\u0002\u0010\u001e\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001d¨\u0006%" }, d2 = { "Lly/img/android/pesdk/utils/TransformedVector$TransformableValue;", "R", "T", "", "value", "updateFromRaw", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "onSet", "Lkotlin/Function0;", "", "(Lly/img/android/pesdk/utils/TransformedVector;Ljava/lang/Object;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "isDirty", "", "()Z", "setDirty", "(Z)V", "getOnSet", "()Lkotlin/jvm/functions/Function0;", "setOnSet", "(Lkotlin/jvm/functions/Function0;)V", "getUpdateFromRaw", "()Lkotlin/jvm/functions/Function1;", "setUpdateFromRaw", "(Lkotlin/jvm/functions/Function1;)V", "getValue", "()Ljava/lang/Object;", "setValue", "(Ljava/lang/Object;)V", "Ljava/lang/Object;", "thisRef", "property", "Lkotlin/reflect/KProperty;", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;)Ljava/lang/Object;", "setUpdatedFlag", "(Ljava/lang/Object;Lkotlin/reflect/KProperty;Ljava/lang/Object;)V", "pesdk-backend-core_release" })
    protected final class TransformableValue<R, T>
    {
        private T value;
        @NotNull
        private Function1<? super T, ? extends T> updateFromRaw;
        @NotNull
        private Function0<Unit> onSet;
        private boolean isDirty;
        final /* synthetic */ TransformedVector this$0;
        
        public TransformableValue(@NotNull final T value, @NotNull final Function1<? super T, ? extends T> updateFromRaw, final Function0<Unit> onSet) {
            Intrinsics.checkNotNullParameter((Object)updateFromRaw, "updateFromRaw");
            Intrinsics.checkNotNullParameter((Object)onSet, "onSet");
            this.value = value;
            this.updateFromRaw = updateFromRaw;
            this.onSet = onSet;
            this.isDirty = true;
        }
        
        public final T getValue() {
            return this.value;
        }
        
        public final void setValue(final T <set-?>) {
            this.value = <set-?>;
        }
        
        @NotNull
        public final Function1<T, T> getUpdateFromRaw() {
            return (Function1<T, T>)this.updateFromRaw;
        }
        
        public final void setUpdateFromRaw(@NotNull final Function1<? super T, ? extends T> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.updateFromRaw = <set-?>;
        }
        
        @NotNull
        public final Function0<Unit> getOnSet() {
            return this.onSet;
        }
        
        public final void setOnSet(@NotNull final Function0<Unit> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.onSet = <set-?>;
        }
        
        public final void setUpdatedFlag() {
            final int $i$f$setUpdatedFlag = 0;
            this.setDirty(false);
            this.getOnSet().invoke();
        }
        
        public final boolean isDirty() {
            return this.isDirty;
        }
        
        public final void setDirty(final boolean <set-?>) {
            this.isDirty = <set-?>;
        }
        
        public final T getValue(final R thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final int $i$f$getValue = 0;
            final TransformedVector this_$iv = access$getThis$0$p(this);
            final int $i$f$respectLock = 0;
            if (this_$iv.isAtomic()) {
                final ReentrantLock reentrantLock = TransformedVector.access$getLock(this_$iv);
                reentrantLock.lock();
                try {
                    final int n = 0;
                    final int n2 = 0;
                    if (this.isDirty()) {
                        this.setDirty(false);
                        this.setValue(this.getUpdateFromRaw().invoke(this.getValue()));
                    }
                    final Unit instance = Unit.INSTANCE;
                    return this.getValue();
                }
                finally {
                    InlineMarker.finallyStart(1);
                    reentrantLock.unlock();
                    InlineMarker.finallyEnd(1);
                }
            }
            final int n2 = 0;
            if (this.isDirty()) {
                this.setDirty(false);
                this.setValue(this.getUpdateFromRaw().invoke(this.getValue()));
            }
            return this.getValue();
        }
        
        public final void setValue(final R thisRef, @NotNull final KProperty<?> property, final T value) {
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final int $i$f$setValue = 0;
            final TransformedVector this_$iv = access$getThis$0$p(this);
            final int $i$f$respectLock = 0;
            if (this_$iv.isAtomic()) {
                final ReentrantLock reentrantLock = TransformedVector.access$getLock(this_$iv);
                reentrantLock.lock();
                try {
                    final int n = 0;
                    final int n2 = 0;
                    this.setValue(value);
                    this.setDirty(false);
                    this.getOnSet().invoke();
                    final Unit instance = Unit.INSTANCE;
                    return;
                }
                finally {
                    InlineMarker.finallyStart(1);
                    reentrantLock.unlock();
                    InlineMarker.finallyEnd(1);
                }
            }
            final int n2 = 0;
            this.setValue(value);
            this.setDirty(false);
            this.getOnSet().invoke();
        }
        
        public static final /* synthetic */ TransformedVector access$getThis$0$p(final TransformableValue $this) {
            return $this.this$0;
        }
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b¤\u0004\u0018\u00002\u00020\u0001B\u001b\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0002\u0010\u0007J\u001d\u0010\u0011\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u0018H\u0086\nJ\t\u0010\u0019\u001a\u00020\u0006H\u0086\bJ%\u0010\u0013\u001a\u00020\u00062\u0006\u0010\u0015\u001a\u00020\u00162\n\u0010\u0017\u001a\u0006\u0012\u0002\b\u00030\u00182\u0006\u0010\u0002\u001a\u00020\u0003H\u0086\nJ\u0010\u0010\u001a\u001a\u00020\u00032\u0006\u0010\u0002\u001a\u00020\u0003H&R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\n\"\u0004\b\u000b\u0010\fR \u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001b" }, d2 = { "Lly/img/android/pesdk/utils/TransformedVector$TransformableFloat;", "", "value", "", "onSet", "Lkotlin/Function0;", "", "(Lly/img/android/pesdk/utils/TransformedVector;FLkotlin/jvm/functions/Function0;)V", "isDirty", "", "()Z", "setDirty", "(Z)V", "getOnSet", "()Lkotlin/jvm/functions/Function0;", "setOnSet", "(Lkotlin/jvm/functions/Function0;)V", "getValue", "()F", "setValue", "(F)V", "thisRef", "Lly/img/android/pesdk/utils/TransformedVector;", "property", "Lkotlin/reflect/KProperty;", "setUpdatedFlag", "updateFromRaw", "pesdk-backend-core_release" })
    protected abstract class TransformableFloat
    {
        private float value;
        @NotNull
        private Function0<Unit> onSet;
        private boolean isDirty;
        final /* synthetic */ TransformedVector this$0;
        
        public TransformableFloat(@NotNull final float value, final Function0<Unit> onSet) {
            Intrinsics.checkNotNullParameter((Object)onSet, "onSet");
            this.value = value;
            this.onSet = onSet;
            this.isDirty = true;
        }
        
        public final float getValue() {
            return this.value;
        }
        
        public final void setValue(final float <set-?>) {
            this.value = <set-?>;
        }
        
        @NotNull
        public final Function0<Unit> getOnSet() {
            return this.onSet;
        }
        
        public final void setOnSet(@NotNull final Function0<Unit> <set-?>) {
            Intrinsics.checkNotNullParameter((Object)<set-?>, "<set-?>");
            this.onSet = <set-?>;
        }
        
        public abstract float updateFromRaw(final float p0);
        
        public final void setUpdatedFlag() {
            final int $i$f$setUpdatedFlag = 0;
            this.setDirty(false);
            this.getOnSet().invoke();
        }
        
        public final boolean isDirty() {
            return this.isDirty;
        }
        
        public final void setDirty(final boolean <set-?>) {
            this.isDirty = <set-?>;
        }
        
        public final float getValue(@NotNull final TransformedVector thisRef, @NotNull final KProperty<?> property) {
            Intrinsics.checkNotNullParameter((Object)thisRef, "thisRef");
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final int $i$f$getValue = 0;
            final TransformedVector this_$iv = access$getThis$0$p(this);
            final int $i$f$respectLock = 0;
            if (this_$iv.isAtomic()) {
                final ReentrantLock reentrantLock = TransformedVector.access$getLock(this_$iv);
                reentrantLock.lock();
                try {
                    final int n = 0;
                    final int n2 = 0;
                    if (this.isDirty()) {
                        this.setDirty(false);
                        this.setValue(this.updateFromRaw(this.getValue()));
                    }
                    final Unit instance = Unit.INSTANCE;
                    return this.getValue();
                }
                finally {
                    InlineMarker.finallyStart(1);
                    reentrantLock.unlock();
                    InlineMarker.finallyEnd(1);
                }
            }
            final int n2 = 0;
            if (this.isDirty()) {
                this.setDirty(false);
                this.setValue(this.updateFromRaw(this.getValue()));
            }
            return this.getValue();
        }
        
        public final void setValue(@NotNull final TransformedVector thisRef, @NotNull final KProperty<?> property, final float value) {
            Intrinsics.checkNotNullParameter((Object)thisRef, "thisRef");
            Intrinsics.checkNotNullParameter((Object)property, "property");
            final int $i$f$setValue = 0;
            final TransformedVector this_$iv = access$getThis$0$p(this);
            final int $i$f$respectLock = 0;
            if (this_$iv.isAtomic()) {
                final ReentrantLock reentrantLock = TransformedVector.access$getLock(this_$iv);
                reentrantLock.lock();
                try {
                    final int n = 0;
                    final int n2 = 0;
                    this.setValue(value);
                    this.setDirty(false);
                    this.getOnSet().invoke();
                    final Unit instance = Unit.INSTANCE;
                    return;
                }
                finally {
                    InlineMarker.finallyStart(1);
                    reentrantLock.unlock();
                    InlineMarker.finallyEnd(1);
                }
            }
            final int n2 = 0;
            this.setValue(value);
            this.setDirty(false);
            this.getOnSet().invoke();
        }
        
        public static final /* synthetic */ TransformedVector access$getThis$0$p(final TransformableFloat $this) {
            return $this.this$0;
        }
    }
}
