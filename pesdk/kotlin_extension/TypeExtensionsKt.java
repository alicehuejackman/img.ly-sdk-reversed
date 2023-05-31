// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.kotlin_extension;

import android.util.SparseArray;
import android.graphics.RectF;
import ly.img.android.pesdk.backend.model.chunk.MultiRect;
import ly.img.android.pesdk.backend.model.chunk.Recyclable;
import ly.img.android.pesdk.backend.model.chunk.Transformation;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import android.graphics.Matrix;
import kotlin.collections.ArraysKt;
import androidx.annotation.Size;
import ly.img.android.pesdk.utils.MathUtilsKt;
import android.graphics.Color;
import kotlin.math.MathKt;
import androidx.annotation.FloatRange;
import androidx.annotation.IntRange;
import androidx.annotation.ColorInt;
import androidx.annotation.CheckResult;
import ly.img.android.pesdk.utils.TimeUtilsKt;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 2, xi = 48, d1 = { "\u0000\u00c0\u0001\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u0014\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0015\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0013\n\u0002\u0018\u0002\n\u0002\b\u001e\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0018\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0013\u001a5\u0010Y\u001a\u00060\u001fj\u0002`Z2\b\b\u0003\u0010[\u001a\u00020\b2\b\b\u0001\u0010\\\u001a\u00020\u001f2\b\b\u0001\u0010]\u001a\u00020\u001f2\b\b\u0001\u0010^\u001a\u00020\u001fH\u0086\b\u001a\u0013\u0010Y\u001a\u00020\u001f2\b\b\u0001\u0010\u0007\u001a\u00020\u001fH\u0086\b\u001a5\u0010Y\u001a\u00060\u001fj\u0002`Z2\b\b\u0003\u0010[\u001a\u00020\u001f2\b\b\u0001\u0010\\\u001a\u00020\u001f2\b\b\u0001\u0010]\u001a\u00020\u001f2\b\b\u0001\u0010^\u001a\u00020\u001fH\u0086\b\u001a\u0013\u0010Y\u001a\u00020\u001f2\b\b\u0001\u0010\u0007\u001a\u00020\u0001H\u0086\b\u001a\r\u0010_\u001a\u00060\nj\u0002`\u001cH\u0087\b\u001a\u001d\u0010_\u001a\u00060\nj\u0002`\u001c2\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0087\b\u001a\r\u0010`\u001a\u00060\nj\u0002`\u0011H\u0087\b\u001a%\u0010`\u001a\u00060\nj\u0002`\u00112\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0087\b\u001a\r\u0010a\u001a\u00060\nj\u0002`\u000bH\u0087\b\u001a-\u0010a\u001a\u00060\nj\u0002`\u000b2\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010V\u001a\u00020\b2\u0006\u00101\u001a\u00020\bH\u0087\b\u001a-\u0010b\u001a\u00060\nj\u0002`c2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\bH\u0087\b\u001a-\u0010b\u001a\u00060\nj\u0002`c2\u0006\u0010\\\u001a\u00020\u001f2\u0006\u0010]\u001a\u00020\u001f2\u0006\u0010^\u001a\u00020\u001f2\u0006\u0010[\u001a\u00020\u001fH\u0087\b\u001a\u0019\u0010d\u001a\u00020\u00012\u0006\u0010\u0007\u001a\u00020\u00012\u0006\u0010e\u001a\u00020fH\u0086\b\u001a\r\u0010g\u001a\u00060\nj\u0002`;H\u0087\b\u001aM\u0010g\u001a\u00060\nj\u0002`;2\u0006\u0010:\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0087\b\u001a\u001d\u0010h\u001a\u00060\nj\u0002`'2\u0006\u00104\u001a\u00020\b2\u0006\u0010 \u001a\u00020\bH\u0087\b\u001a-\u0010i\u001a\u00060\nj\u0002`\u00152\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0014\u001a\u00020\b2\u0006\u0010.\u001a\u00020\b2\u0006\u0010+\u001a\u00020\bH\u0087\b\u001a\u001d\u0010j\u001a\u00060!j\u0002`\"2\u0006\u00104\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fH\u0087\b\u001a\u0015\u0010k\u001a\u00020\u001f2\n\u0010l\u001a\u00020m\"\u00020nH\u0086\b\u001a\u0015\u0010o\u001a\u00020p*\u00020p2\u0006\u0010q\u001a\u00020pH\u0087\u0004\u001a\u0015\u0010o\u001a\u00020\b*\u00020\b2\u0006\u0010q\u001a\u00020\bH\u0087\u0004\u001a\u0015\u0010o\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010q\u001a\u00020\u001fH\u0087\u0004\u001a\u0015\u0010o\u001a\u00020\u0001*\u00020\u00012\u0006\u0010q\u001a\u00020\u0001H\u0087\u0004\u001a\u0015\u0010r\u001a\u00020p*\u00020p2\u0006\u0010s\u001a\u00020pH\u0087\u0004\u001a\u0015\u0010r\u001a\u00020\b*\u00020\b2\u0006\u0010s\u001a\u00020\bH\u0087\u0004\u001a\u0015\u0010r\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010s\u001a\u00020\u001fH\u0087\u0004\u001a\u0015\u0010r\u001a\u00020\u0001*\u00020\u00012\u0006\u0010s\u001a\u00020\u0001H\u0087\u0004\u001a\r\u0010t\u001a\u00020\u001f*\u00020pH\u0087\b\u001a\r\u0010t\u001a\u00020\u001f*\u00020\bH\u0087\b\u001a\r\u0010u\u001a\u00020\u0001*\u00020pH\u0087\b\u001a\u001d\u0010v\u001a\u00020\u001f*\u00060!j\u0002`w2\n\u0010x\u001a\u00060!j\u0002`wH\u0086\n\u001a\u0015\u0010y\u001a\u00020\n*\u00020\n2\u0006\u0010z\u001a\u00020\nH\u0086\b\u001a\u001d\u0010{\u001a\u00020|*\u00060\u001fj\u0002`Z2\n\u0010}\u001a\u00060\nj\u0002`cH\u0086\b\u001a\u0015\u0010~\u001a\u00060\nj\u0002`c*\u00060\u001fj\u0002`ZH\u0086\b\u001a\f\u0010\u007f\u001a\u00020\u001f*\u00020\u001fH\u0007\u001a\f\u0010\u007f\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0017\u0010\u0080\u0001\u001a\u00020p*\u00020p2\u0007\u0010\u0081\u0001\u001a\u00020pH\u0087\f\u001a\u0017\u0010\u0080\u0001\u001a\u00020\b*\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0087\f\u001a\u0017\u0010\u0080\u0001\u001a\u00020\u001f*\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001fH\u0087\f\u001a\u0017\u0010\u0080\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0001H\u0087\f\u001aI\u0010\u0082\u0001\u001a\u00020|\"\u0005\b\u0000\u0010\u0083\u0001*\n\u0012\u0005\u0012\u0003H\u0083\u00010\u0084\u00012'\u0010\u0085\u0001\u001a\"\u0012\u0017\u0012\u0015H\u0083\u0001¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020|0\u0086\u0001H\u0086\b\u00f8\u0001\u0000\u001a\u0012\u0010\u008a\u0001\u001a\u00020n*\u00060!j\u0002`wH\u0086\b\u001a\u0017\u0010\u008b\u0001\u001a\u00020n*\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u00020\u001fH\u0087\f\u001a\u0017\u0010\u008b\u0001\u001a\u00020n*\u00020\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0001H\u0087\f\u001a\u0017\u0010\u008d\u0001\u001a\u00020n*\u00020\u001f2\u0007\u0010\u008c\u0001\u001a\u00020\u001fH\u0087\f\u001a\u0017\u0010\u008d\u0001\u001a\u00020n*\u00020\u00012\u0007\u0010\u008c\u0001\u001a\u00020\u0001H\u0087\f\u001a\u0016\u0010\u008e\u0001\u001a\u00020p*\u00020p2\u0006\u0010\u0007\u001a\u00020pH\u0087\f\u001a\u0016\u0010\u008e\u0001\u001a\u00020\b*\u00020\b2\u0006\u0010\u0007\u001a\u00020\bH\u0087\f\u001a.\u0010\u008f\u0001\u001a\u00060\u001fj\u0002`Z*\u00060\u001fj\u0002`Z2\r\b\u0001\u0010\u0090\u0001\u001a\u00060\u001fj\u0002`Z2\u0007\u0010\u0091\u0001\u001a\u00020\bH\u0086\b\u001a\u000e\u0010\u0092\u0001\u001a\u00020n*\u00020\bH\u0087\b\u001a<\u0010\u0093\u0001\u001a\u00020\n*\u00020\n2)\b\u0004\u0010\u0094\u0001\u001a\"\u0012\u0017\u0012\u00150\u0095\u0001¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020|0\u0086\u0001H\u0086\b\u00f8\u0001\u0000\u001a\u0018\u0010\u0096\u0001\u001a\u00020\n*\u00020\n2\b\u0010\u0097\u0001\u001a\u00030\u0095\u0001H\u0086\b\u001a>\u0010\u0098\u0001\u001a\u00030\u0099\u0001*\u00030\u0099\u00012)\b\u0004\u0010\u0094\u0001\u001a\"\u0012\u0017\u0012\u00150\u0095\u0001¢\u0006\u000f\b\u0087\u0001\u0012\n\b\u0088\u0001\u0012\u0005\b\b(\u0089\u0001\u0012\u0004\u0012\u00020|0\u0086\u0001H\u0086\b\u00f8\u0001\u0000\u001a(\u0010\u009a\u0001\u001a\u00060!j\u0002`w*\u00060!j\u0002`w2\u0007\u0010\u009b\u0001\u001a\u00020\u001f2\u0007\u0010\u009c\u0001\u001a\u00020\u001fH\u0086\b\u001a#\u0010\u009a\u0001\u001a\u00060!j\u0002`w*\u00060!j\u0002`w2\u000b\u0010\u009d\u0001\u001a\u00060!j\u0002`wH\u0086\b\u001a\u000e\u0010\u009e\u0001\u001a\u00020p*\u00020pH\u0087\b\u001a\u000e\u0010\u009e\u0001\u001a\u00020\b*\u00020\bH\u0087\b\u001a\u000e\u0010\u009e\u0001\u001a\u00020\u001f*\u00020\u001fH\u0087\b\u001a\u000e\u0010\u009e\u0001\u001a\u00020\u0001*\u00020\u0001H\u0087\b\u001a\u001a\u0010\u009f\u0001\u001a\u00020|*\u00060\nj\u0002`\u001c2\u0006\u0010\u0007\u001a\u00020\bH\u0086\b\u001a\u0017\u0010 \u0001\u001a\u00020p*\u00020p2\u0007\u0010\u0081\u0001\u001a\u00020pH\u0087\f\u001a\u0017\u0010 \u0001\u001a\u00020\b*\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0087\f\u001a\u0017\u0010 \u0001\u001a\u00020\u001f*\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001fH\u0087\f\u001a\u0017\u0010 \u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0001H\u0087\f\u001a&\u0010¡\u0001\u001a\u00060\nj\u0002`\u001c*\u00060\nj\u0002`\u001c2\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\bH\u0086\b\u001a.\u0010¡\u0001\u001a\u00060\nj\u0002`\u0011*\u00060\nj\u0002`\u00112\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010V\u001a\u00020\bH\u0086\b\u001a6\u0010¡\u0001\u001a\u00060\nj\u0002`\u000b*\u00060\nj\u0002`\u000b2\u0006\u00107\u001a\u00020\b2\u0006\u0010G\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010M\u001a\u00020\bH\u0086\b\u001a\u001f\u0010¡\u0001\u001a\u00060\nj\u0002`c*\u00060\nj\u0002`c2\u0007\u0010¢\u0001\u001a\u00020\u001fH\u0086\b\u001a6\u0010¡\u0001\u001a\u00060\nj\u0002`c*\u00060\nj\u0002`c2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\bH\u0086\b\u001a6\u0010¡\u0001\u001a\u00060\nj\u0002`c*\u00060\nj\u0002`c2\u0006\u0010(\u001a\u00020\u001f2\u0006\u0010\u001b\u001a\u00020\u001f2\u0006\u0010\u0010\u001a\u00020\u001f2\u0006\u0010\t\u001a\u00020\u001fH\u0086\b\u001aV\u0010¡\u0001\u001a\u00060\nj\u0002`;*\u00060\nj\u0002`;2\u0006\u0010:\u001a\u00020\b2\u0006\u0010J\u001a\u00020\b2\u0006\u0010>\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\u0006\u0010A\u001a\u00020\b2\u0006\u0010P\u001a\u00020\b2\u0006\u0010D\u001a\u00020\b2\u0006\u0010S\u001a\u00020\bH\u0086\b\u001a\u0016\u0010£\u0001\u001a\u00060!j\u0002`\"*\u00060!j\u0002`wH\u0086\b\u001a&\u0010¤\u0001\u001a\u00060!j\u0002`\"*\u00060!j\u0002`\"2\u0006\u00107\u001a\u00020\u001f2\u0006\u0010G\u001a\u00020\u001fH\u0086\b\u001a#\u0010¤\u0001\u001a\u00060!j\u0002`\"*\u00060!j\u0002`\"2\u000b\u0010¥\u0001\u001a\u00060!j\u0002`\"H\u0086\b\u001a\r\u0010¦\u0001\u001a\u00020\u001f*\u00020\u001fH\u0007\u001a\r\u0010¦\u0001\u001a\u00020\u0001*\u00020\u0001H\u0007\u001a\u0017\u0010§\u0001\u001a\u00020p*\u00020p2\u0007\u0010\u0081\u0001\u001a\u00020pH\u0087\f\u001a\u0017\u0010§\u0001\u001a\u00020\b*\u00020\b2\u0007\u0010\u0081\u0001\u001a\u00020\bH\u0087\f\u001a\u0017\u0010§\u0001\u001a\u00020\u001f*\u00020\u001f2\u0007\u0010\u0081\u0001\u001a\u00020\u001fH\u0087\f\u001a\u0017\u0010§\u0001\u001a\u00020\u0001*\u00020\u00012\u0007\u0010\u0081\u0001\u001a\u00020\u0001H\u0087\f\"\u0012\u0010\u0000\u001a\u00060\u0001j\u0002`\u0002X\u0086T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0003\u001a\u00060\u0001j\u0002`\u0004X\u0086T¢\u0006\u0002\n\u0000\"\u0012\u0010\u0005\u001a\u00060\u0001j\u0002`\u0006X\u0086T¢\u0006\u0002\n\u0000\".\u0010\t\u001a\u00020\b*\u00060\nj\u0002`\u000b2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f\".\u0010\u0010\u001a\u00020\b*\u00060\nj\u0002`\u00112\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0012\u0010\r\"\u0004\b\u0013\u0010\u000f\".\u0010\u0014\u001a\u00020\b*\u00060\nj\u0002`\u00152\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0016\u0010\r\"\u0004\b\u0017\u0010\u000f\".\u0010\u0018\u001a\u00020\b*\u00060\nj\u0002`\u00152\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u0019\u0010\r\"\u0004\b\u001a\u0010\u000f\".\u0010\u001b\u001a\u00020\b*\u00060\nj\u0002`\u001c2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b\u001d\u0010\r\"\u0004\b\u001e\u0010\u000f\".\u0010 \u001a\u00020\u001f*\u00060!j\u0002`\"2\u0006\u0010\u0007\u001a\u00020\u001f8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010$\"\u0004\b%\u0010&\".\u0010 \u001a\u00020\b*\u00060\nj\u0002`'2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b#\u0010\r\"\u0004\b%\u0010\u000f\".\u0010(\u001a\u00020\b*\u00060\nj\u0002`\u001c2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b)\u0010\r\"\u0004\b*\u0010\u000f\".\u0010+\u001a\u00020\b*\u00060\nj\u0002`\u00152\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b,\u0010\r\"\u0004\b-\u0010\u000f\".\u0010.\u001a\u00020\b*\u00060\nj\u0002`\u00152\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b/\u0010\r\"\u0004\b0\u0010\u000f\".\u00101\u001a\u00020\b*\u00060\nj\u0002`\u000b2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b2\u0010\r\"\u0004\b3\u0010\u000f\".\u00104\u001a\u00020\u001f*\u00060!j\u0002`\"2\u0006\u0010\u0007\u001a\u00020\u001f8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010$\"\u0004\b6\u0010&\".\u00104\u001a\u00020\b*\u00060\nj\u0002`'2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b5\u0010\r\"\u0004\b6\u0010\u000f\".\u00107\u001a\u00020\b*\u00060\nj\u0002`\u001c2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010\r\"\u0004\b9\u0010\u000f\".\u00107\u001a\u00020\u001f*\u00060!j\u0002`\"2\u0006\u0010\u0007\u001a\u00020\u001f8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b8\u0010$\"\u0004\b9\u0010&\".\u0010:\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b<\u0010\r\"\u0004\b=\u0010\u000f\".\u0010>\u001a\u00020\b*\u00060\nj\u0002`\u000b2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\b?\u0010\r\"\u0004\b@\u0010\u000f\".\u0010A\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bB\u0010\r\"\u0004\bC\u0010\u000f\".\u0010D\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bE\u0010\r\"\u0004\bF\u0010\u000f\".\u0010G\u001a\u00020\b*\u00060\nj\u0002`\u001c2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010\r\"\u0004\bI\u0010\u000f\".\u0010G\u001a\u00020\u001f*\u00060!j\u0002`\"2\u0006\u0010\u0007\u001a\u00020\u001f8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bH\u0010$\"\u0004\bI\u0010&\".\u0010J\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bK\u0010\r\"\u0004\bL\u0010\u000f\".\u0010M\u001a\u00020\b*\u00060\nj\u0002`\u000b2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bN\u0010\r\"\u0004\bO\u0010\u000f\".\u0010P\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bQ\u0010\r\"\u0004\bR\u0010\u000f\".\u0010S\u001a\u00020\b*\u00060\nj\u0002`;2\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bT\u0010\r\"\u0004\bU\u0010\u000f\".\u0010V\u001a\u00020\b*\u00060\nj\u0002`\u00112\u0006\u0010\u0007\u001a\u00020\b8\u00c6\u0002@\u00c6\u0002X\u0086\u000e¢\u0006\f\u001a\u0004\bW\u0010\r\"\u0004\bX\u0010\u000f*\n\u0010Y\"\u00020\u001f2\u00020\u001f*\n\u0010_\"\u00020\n2\u00020\n*\u000e\u0010`\"\u0002`\u001c2\u00060\nj\u0002`\u001c*\u000e\u0010a\"\u0002`\u00112\u00060\nj\u0002`\u0011*\n\u0010b\"\u00020\n2\u00020\n*\u000b\u0010¨\u0001\"\u00020!2\u00020!*\u000b\u0010©\u0001\"\u00020\u00012\u00020\u0001*\u000b\u0010ª\u0001\"\u00020\u00012\u00020\u0001*\n\u0010d\"\u00020\u00012\u00020\u0001*\u000e\u0010g\"\u0002`\u000b2\u00060\nj\u0002`\u000b*\u000b\u0010«\u0001\"\u00020\u00012\u00020\u0001*\u000e\u0010h\"\u0002`\u001c2\u00060\nj\u0002`\u001c*\u000e\u0010i\"\u0002`\u000b2\u00060\nj\u0002`\u000b*\u000e\u0010j\"\u0002`\"2\u00060!j\u0002`\"\u0082\u0002\u0007\n\u0005\b\u009920\u0001¨\u0006¬\u0001" }, d2 = { "ONE_SECONDS_IN_MICROSECONDS", "", "Lly/img/android/pesdk/kotlin_extension/Microseconds;", "ONE_SECONDS_IN_MILLISECONDS", "Lly/img/android/pesdk/kotlin_extension/Milliseconds;", "ONE_SECONDS_IN_NANOSECOND", "Lly/img/android/pesdk/kotlin_extension/Nanoseconds;", "value", "", "a", "", "Lly/img/android/pesdk/kotlin_extension/Float4;", "getA", "([F)F", "setA", "([FF)V", "b", "Lly/img/android/pesdk/kotlin_extension/Float3;", "getB", "setB", "firstHeight", "Lly/img/android/pesdk/kotlin_extension/Size2;", "getFirstHeight", "setFirstHeight", "firstWidth", "getFirstWidth", "setFirstWidth", "g", "Lly/img/android/pesdk/kotlin_extension/Float2;", "getG", "setG", "", "height", "", "Lly/img/android/pesdk/kotlin_extension/Int2;", "getHeight", "([I)I", "setHeight", "([II)V", "Lly/img/android/pesdk/kotlin_extension/Size;", "r", "getR", "setR", "secondHeight", "getSecondHeight", "setSecondHeight", "secondWidth", "getSecondWidth", "setSecondWidth", "w", "getW", "setW", "width", "getWidth", "setWidth", "x", "getX", "setX", "x1", "Lly/img/android/pesdk/kotlin_extension/RectCords;", "getX1", "setX1", "x2", "getX2", "setX2", "x3", "getX3", "setX3", "x4", "getX4", "setX4", "y", "getY", "setY", "y1", "getY1", "setY1", "y2", "getY2", "setY2", "y3", "getY3", "setY3", "y4", "getY4", "setY4", "z", "getZ", "setZ", "ColorValue", "Lly/img/android/pesdk/kotlin_extension/ColorValue;", "alpha", "red", "green", "blue", "Float2", "Float3", "Float4", "GlColor", "Lly/img/android/pesdk/kotlin_extension/GlColor;", "Nanoseconds", "unit", "Ljava/util/concurrent/TimeUnit;", "RectCords", "Size", "Size2", "SizeInt", "countTrue", "booleans", "", "", "butMax", "", "max", "butMin", "min", "ceilToInt", "ceilToLong", "compareTo", "Lly/img/android/pesdk/kotlin_extension/SizeInt;", "other", "copyFrom", "from", "copyToGlColor", "", "glColor", "createGlColor", "downscaleToLog2", "downscaleToMultipleOf", "v", "forEach", "T", "Landroid/util/SparseArray;", "block", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "it", "hasEmptySize", "hasFlag", "flag", "hasInvertedFlag", "ifNotFinite", "interpolateColor", "secondsColor", "progress", "isNotFinite", "mapPointsBy", "instructions", "Landroid/graphics/Matrix;", "mapPointsWith", "transformation", "mapRectBy", "Lly/img/android/pesdk/backend/model/chunk/MultiRect;", "maxButKeepAspect", "maxWidth", "maxHeight", "maxSize", "pow2", "scaleAll", "scaleToMultipleOf", "set", "argbAndroidColor", "setEmptySize", "setValue", "values", "upscaleToLog2", "upscaleToMultipleOf", "Int2", "Microseconds", "Milliseconds", "Seconds", "pesdk-backend-core_release" })
public final class TypeExtensionsKt
{
    public static final long ONE_SECONDS_IN_NANOSECOND = 1000000000L;
    public static final long ONE_SECONDS_IN_MICROSECONDS = 1000000L;
    public static final long ONE_SECONDS_IN_MILLISECONDS = 1000L;
    
    public static final long Nanoseconds(final long value, @NotNull final TimeUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        final int $i$f$Nanoseconds = 0;
        return TimeUtilsKt.convert(value, unit, TimeUnit.NANOSECONDS);
    }
    
    @CheckResult
    public static final float butMin(final float $this$butMin, final float min) {
        return Math.max($this$butMin, min);
    }
    
    @CheckResult
    public static final float butMax(final float $this$butMax, final float max) {
        return Math.min($this$butMax, max);
    }
    
    @CheckResult
    public static final int butMin(final int $this$butMin, final int min) {
        return Math.max($this$butMin, min);
    }
    
    @CheckResult
    public static final int butMax(final int $this$butMax, final int max) {
        return Math.min($this$butMax, max);
    }
    
    @CheckResult
    public static final long butMin(final long $this$butMin, final long min) {
        return Math.max($this$butMin, min);
    }
    
    @CheckResult
    public static final long butMax(final long $this$butMax, final long max) {
        return Math.min($this$butMax, max);
    }
    
    @CheckResult
    public static final double butMin(final double $this$butMin, final double min) {
        return Math.max($this$butMin, min);
    }
    
    @CheckResult
    public static final double butMax(final double $this$butMax, final double max) {
        return Math.min($this$butMax, max);
    }
    
    @CheckResult
    public static final int pow2(final int $this$pow2) {
        final int $i$f$pow2 = 0;
        return $this$pow2 * $this$pow2;
    }
    
    @CheckResult
    public static final long pow2(final long $this$pow2) {
        final int $i$f$pow2 = 0;
        return $this$pow2 * $this$pow2;
    }
    
    @CheckResult
    public static final float pow2(final float $this$pow2) {
        final int $i$f$pow2 = 0;
        return $this$pow2 * $this$pow2;
    }
    
    @CheckResult
    public static final double pow2(final double $this$pow2) {
        final int $i$f$pow2 = 0;
        return $this$pow2 * $this$pow2;
    }
    
    public static final int ColorValue(@ColorInt @IntRange(from = 0L, to = 4294967295L) final long value) {
        final int $i$f$ColorValue = 0;
        return (int)value;
    }
    
    public static final int ColorValue(@ColorInt @IntRange(from = 0L, to = 4294967295L) final int value) {
        final int $i$f$ColorValue = 0;
        return value;
    }
    
    public static final int ColorValue(@IntRange(from = 0L, to = 255L) final int alpha, @IntRange(from = 0L, to = 255L) final int red, @IntRange(from = 0L, to = 255L) final int green, @IntRange(from = 0L, to = 255L) final int blue) {
        final int $i$f$ColorValue = 0;
        return alpha << 24 | red << 16 | green << 8 | blue;
    }
    
    public static final int ColorValue(@FloatRange(from = 0.0, to = 1.0) final float alpha, @IntRange(from = 0L, to = 255L) final int red, @IntRange(from = 0L, to = 255L) final int green, @IntRange(from = 0L, to = 255L) final int blue) {
        final int $i$f$ColorValue = 0;
        final int alpha$iv = MathKt.roundToInt(alpha * 255);
        final int $i$f$ColorValue2 = 0;
        return alpha$iv << 24 | red << 16 | green << 8 | blue;
    }
    
    @NotNull
    public static final float[] createGlColor(final int $this$createGlColor) {
        final int $i$f$createGlColor = 0;
        return new float[$this$createGlColor];
    }
    
    public static final void copyToGlColor(final int $this$copyToGlColor, @NotNull final float[] glColor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "glColor"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore_2        /* $i$f$copyToGlColor */
        //     8: aload_1         /* glColor */
        //     9: astore_3        /* $this$set$iv */
        //    10: iconst_0       
        //    11: istore          $i$f$set
        //    13: aload_3         /* $this$set$iv */
        //    14: astore          5
        //    16: iload_0         /* $this$copyToGlColor */
        //    17: invokestatic    android/graphics/Color.red:(I)I
        //    20: i2f            
        //    21: ldc             255.0
        //    23: fdiv           
        //    24: fstore          6
        //    26: iload_0         /* $this$copyToGlColor */
        //    27: invokestatic    android/graphics/Color.green:(I)I
        //    30: i2f            
        //    31: ldc             255.0
        //    33: fdiv           
        //    34: fstore          7
        //    36: iload_0         /* $this$copyToGlColor */
        //    37: invokestatic    android/graphics/Color.blue:(I)I
        //    40: i2f            
        //    41: ldc             255.0
        //    43: fdiv           
        //    44: fstore          8
        //    46: iload_0         /* $this$copyToGlColor */
        //    47: invokestatic    android/graphics/Color.alpha:(I)I
        //    50: i2f            
        //    51: ldc             255.0
        //    53: fdiv           
        //    54: fstore          9
        //    56: nop            
        //    57: iconst_0       
        //    58: istore          $i$f$set
        //    60: aload           $this$set$iv$iv
        //    62: iconst_0       
        //    63: fload           x$iv$iv
        //    65: fastore        
        //    66: aload           $this$set$iv$iv
        //    68: iconst_1       
        //    69: fload           y$iv$iv
        //    71: fastore        
        //    72: aload           $this$set$iv$iv
        //    74: iconst_2       
        //    75: fload           x2$iv$iv
        //    77: fastore        
        //    78: aload           $this$set$iv$iv
        //    80: iconst_3       
        //    81: fload           y2$iv$iv
        //    83: fastore        
        //    84: nop            
        //    85: nop            
        //    86: return         
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
    
    public static final int interpolateColor(final int $this$interpolateColor, @ColorInt final int secondsColor, final float progress) {
        final int $i$f$interpolateColor = 0;
        final int oldRed = Color.red($this$interpolateColor);
        final int newRed = Color.red(secondsColor);
        final int oldGreen = Color.green($this$interpolateColor);
        final int newGreen = Color.green(secondsColor);
        final int oldBlue = Color.blue($this$interpolateColor);
        final int newBlue = Color.blue(secondsColor);
        final int oldAlpha = Color.alpha($this$interpolateColor);
        final int newAlpha = Color.alpha(secondsColor);
        final float clampedProgress = MathUtilsKt.clamp(progress, 0.0f, 1.0f);
        return Color.argb(MathKt.roundToInt(oldAlpha + (newAlpha - oldAlpha) * clampedProgress), MathKt.roundToInt(oldRed + (newRed - oldRed) * clampedProgress), MathKt.roundToInt(oldGreen + (newGreen - oldGreen) * clampedProgress), MathKt.roundToInt(oldBlue + (newBlue - oldBlue) * clampedProgress));
    }
    
    @Size(2L)
    @NotNull
    public static final float[] Float2(final float x, final float y) {
        final int $i$f$Float2 = 0;
        return new float[] { x, y };
    }
    
    @Size(2L)
    @NotNull
    public static final float[] Float2() {
        final int $i$f$Float2 = 0;
        return new float[] { 0.0f, 0.0f };
    }
    
    @Size(3L)
    @NotNull
    public static final float[] Float3(final float x, final float y, final float z) {
        final int $i$f$Float3 = 0;
        return new float[] { x, y, z };
    }
    
    @Size(3L)
    @NotNull
    public static final float[] Float3() {
        final int $i$f$Float3 = 0;
        return new float[] { 0.0f, 0.0f, 0.0f };
    }
    
    @Size(4L)
    @NotNull
    public static final float[] Float4(final float x, final float y, final float z, final float w) {
        final int $i$f$Float4 = 0;
        return new float[] { x, y, z, w };
    }
    
    @Size(4L)
    @NotNull
    public static final float[] GlColor(final int red, final int green, final int blue, final float alpha) {
        final int $i$f$GlColor = 0;
        return new float[] { red / 255.0f, green / 255.0f, blue / 255.0f, alpha };
    }
    
    @Size(4L)
    @NotNull
    public static final float[] GlColor(final int red, final int green, final int blue, final int alpha) {
        final int $i$f$GlColor = 0;
        return new float[] { red / 255.0f, green / 255.0f, blue / 255.0f, alpha / 255.0f };
    }
    
    @Size(4L)
    @NotNull
    public static final float[] Float4() {
        final int $i$f$Float4 = 0;
        return new float[] { 0.0f, 0.0f, 0.0f, 0.0f };
    }
    
    @Size(8L)
    @NotNull
    public static final float[] RectCords(final float x1, final float y1, final float x2, final float y2, final float x3, final float y3, final float x4, final float y4) {
        final int $i$f$RectCords = 0;
        return new float[] { x1, y1, x2, y2, x3, y3, x4, y4 };
    }
    
    @Size(8L)
    @NotNull
    public static final float[] RectCords() {
        final int $i$f$RectCords = 0;
        return new float[] { 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f };
    }
    
    @Size(2L)
    @NotNull
    public static final float[] Size(final float width, final float height) {
        final int $i$f$Size = 0;
        return new float[] { width, height };
    }
    
    @Size(2L)
    @NotNull
    public static final int[] SizeInt(final int width, final int height) {
        final int $i$f$SizeInt = 0;
        return new int[] { width, height };
    }
    
    @Size(4L)
    @NotNull
    public static final float[] Size2(final float firstWidth, final float firstHeight, final float secondWidth, final float secondHeight) {
        final int $i$f$Size2 = 0;
        return new float[] { firstWidth, firstHeight, secondWidth, secondHeight };
    }
    
    public static final void scaleAll(@NotNull final float[] $this$scaleAll, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$scaleAll, "<this>");
        final int $i$f$scaleAll = 0;
        for (int i = 0; i < $this$scaleAll.length; ++i) {
            final int n = i;
            $this$scaleAll[n] *= value;
        }
    }
    
    @NotNull
    public static final int[] setEmptySize(@NotNull final int[] $this$setEmptySize) {
        Intrinsics.checkNotNullParameter((Object)$this$setEmptySize, "<this>");
        final int $i$f$setEmptySize = 0;
        $this$setEmptySize[1] = ($this$setEmptySize[0] = 0);
        return $this$setEmptySize;
    }
    
    public static final boolean hasEmptySize(@NotNull final int[] $this$hasEmptySize) {
        Intrinsics.checkNotNullParameter((Object)$this$hasEmptySize, "<this>");
        final int $i$f$hasEmptySize = 0;
        return $this$hasEmptySize[0] == 0 || $this$hasEmptySize[1] == 0;
    }
    
    @NotNull
    public static final int[] maxButKeepAspect(@NotNull final int[] $this$maxButKeepAspect, @NotNull final int[] maxSize) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: aload_1         /* maxSize */
        //     7: ldc             "maxSize"
        //     9: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //    12: iconst_0       
        //    13: istore_2        /* $i$f$maxButKeepAspect */
        //    14: aload_0         /* $this$maxButKeepAspect */
        //    15: astore_3       
        //    16: aload_1         /* maxSize */
        //    17: astore          $this$width$iv
        //    19: iconst_0       
        //    20: istore          $i$f$getWidth
        //    22: aload           $this$width$iv
        //    24: iconst_0       
        //    25: iaload         
        //    26: istore          null
        //    28: aload_1         /* maxSize */
        //    29: astore          $this$height$iv
        //    31: iconst_0       
        //    32: istore          $i$f$getHeight
        //    34: aload           $this$height$iv
        //    36: iconst_1       
        //    37: iaload         
        //    38: istore          null
        //    40: nop            
        //    41: iconst_0       
        //    42: istore          $i$f$maxButKeepAspect
        //    44: aload_3         /* $this$maxButKeepAspect$iv */
        //    45: astore          $this$width$iv$iv
        //    47: iconst_0       
        //    48: istore          $i$f$getWidth
        //    50: aload           $this$width$iv$iv
        //    52: iconst_0       
        //    53: iaload         
        //    54: iload           maxWidth$iv
        //    56: if_icmpgt       74
        //    59: aload_3         /* $this$maxButKeepAspect$iv */
        //    60: astore          $this$height$iv$iv
        //    62: iconst_0       
        //    63: istore          $i$f$getHeight
        //    65: aload           $this$height$iv$iv
        //    67: iconst_1       
        //    68: iaload         
        //    69: iload           maxHeight$iv
        //    71: if_icmple       277
        //    74: aload_3         /* $this$maxButKeepAspect$iv */
        //    75: astore          $this$width$iv$iv
        //    77: iconst_0       
        //    78: istore          $i$f$getWidth
        //    80: aload           $this$width$iv$iv
        //    82: iconst_0       
        //    83: iaload         
        //    84: i2f            
        //    85: iload           maxWidth$iv
        //    87: i2f            
        //    88: fconst_1       
        //    89: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(FF)F
        //    92: fdiv           
        //    93: fstore          viewToBitmapWidthRatio$iv
        //    95: aload_3         /* $this$maxButKeepAspect$iv */
        //    96: astore          $this$height$iv$iv
        //    98: iconst_0       
        //    99: istore          $i$f$getHeight
        //   101: aload           $this$height$iv$iv
        //   103: iconst_1       
        //   104: iaload         
        //   105: i2f            
        //   106: iload           maxHeight$iv
        //   108: i2f            
        //   109: fconst_1       
        //   110: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(FF)F
        //   113: fdiv           
        //   114: fstore          viewToBitmapHeightRatio$iv
        //   116: fload           viewToBitmapWidthRatio$iv
        //   118: fload           viewToBitmapHeightRatio$iv
        //   120: fcmpg          
        //   121: ifgt            128
        //   124: iconst_1       
        //   125: goto            129
        //   128: iconst_0       
        //   129: istore          hasLowerAspect$iv
        //   131: iload           hasLowerAspect$iv
        //   133: ifeq            208
        //   136: aload_3         /* $this$maxButKeepAspect$iv */
        //   137: astore          $this$width$iv$iv
        //   139: iconst_0       
        //   140: istore          $i$f$getWidth
        //   142: aload           $this$width$iv$iv
        //   144: iconst_0       
        //   145: iaload         
        //   146: istore          oldWidth$iv
        //   148: aload_3         /* $this$maxButKeepAspect$iv */
        //   149: astore          $this$width$iv$iv
        //   151: iconst_0       
        //   152: istore          $i$f$setWidth
        //   154: aload           $this$width$iv$iv
        //   156: iconst_0       
        //   157: iload           maxWidth$iv
        //   159: iastore        
        //   160: nop            
        //   161: aload_3         /* $this$maxButKeepAspect$iv */
        //   162: astore          11
        //   164: aload_3         /* $this$maxButKeepAspect$iv */
        //   165: astore          $this$height$iv$iv
        //   167: iconst_0       
        //   168: istore          $i$f$getHeight
        //   170: aload           $this$height$iv$iv
        //   172: iconst_1       
        //   173: iaload         
        //   174: aload_3         /* $this$maxButKeepAspect$iv */
        //   175: astore          $this$width$iv$iv
        //   177: iconst_0       
        //   178: istore          $i$f$getWidth
        //   180: aload           $this$width$iv$iv
        //   182: iconst_0       
        //   183: iaload         
        //   184: imul           
        //   185: i2d            
        //   186: iload           oldWidth$iv
        //   188: i2d            
        //   189: ddiv           
        //   190: invokestatic    kotlin/math/MathKt.roundToInt:(D)I
        //   193: istore          value$iv$iv
        //   195: iconst_0       
        //   196: istore          $i$f$setHeight
        //   198: aload           $this$height$iv$iv
        //   200: iconst_1       
        //   201: iload           value$iv$iv
        //   203: iastore        
        //   204: nop            
        //   205: goto            277
        //   208: aload_3         /* $this$maxButKeepAspect$iv */
        //   209: astore          $this$height$iv$iv
        //   211: iconst_0       
        //   212: istore          $i$f$getHeight
        //   214: aload           $this$height$iv$iv
        //   216: iconst_1       
        //   217: iaload         
        //   218: istore          oldHeight$iv
        //   220: aload_3         /* $this$maxButKeepAspect$iv */
        //   221: astore          $this$height$iv$iv
        //   223: iconst_0       
        //   224: istore          $i$f$setHeight
        //   226: aload           $this$height$iv$iv
        //   228: iconst_1       
        //   229: iload           maxHeight$iv
        //   231: iastore        
        //   232: nop            
        //   233: aload_3         /* $this$maxButKeepAspect$iv */
        //   234: astore          11
        //   236: aload_3         /* $this$maxButKeepAspect$iv */
        //   237: astore          $this$width$iv$iv
        //   239: iconst_0       
        //   240: istore          $i$f$getWidth
        //   242: aload           $this$width$iv$iv
        //   244: iconst_0       
        //   245: iaload         
        //   246: aload_3         /* $this$maxButKeepAspect$iv */
        //   247: astore          $this$height$iv$iv
        //   249: iconst_0       
        //   250: istore          $i$f$getHeight
        //   252: aload           $this$height$iv$iv
        //   254: iconst_1       
        //   255: iaload         
        //   256: imul           
        //   257: i2d            
        //   258: iload           oldHeight$iv
        //   260: i2d            
        //   261: ddiv           
        //   262: invokestatic    kotlin/math/MathKt.roundToInt:(D)I
        //   265: istore          value$iv$iv
        //   267: iconst_0       
        //   268: istore          $i$f$setWidth
        //   270: aload           $this$width$iv$iv
        //   272: iconst_0       
        //   273: iload           value$iv$iv
        //   275: iastore        
        //   276: nop            
        //   277: aload_3         /* $this$maxButKeepAspect$iv */
        //   278: areturn        
        //    StackMapTable: 00 05 FF 00 4A 00 09 07 00 FD 07 00 FD 01 07 00 FD 01 01 01 07 00 FD 01 00 00 FF 00 35 00 0B 07 00 FD 07 00 FD 01 07 00 FD 01 01 01 02 02 07 00 FD 01 00 00 40 01 FF 00 4E 00 0B 07 00 FD 07 00 FD 01 07 00 FD 01 01 01 02 02 01 01 00 00 FF 00 44 00 07 07 00 FD 07 00 FD 01 07 00 FD 01 01 01 00 00
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
    
    @NotNull
    public static final int[] maxButKeepAspect(@NotNull final int[] $this$maxButKeepAspect, final int maxWidth, final int maxHeight) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore_3        /* $i$f$maxButKeepAspect */
        //     8: aload_0         /* $this$maxButKeepAspect */
        //     9: astore          $this$width$iv
        //    11: iconst_0       
        //    12: istore          $i$f$getWidth
        //    14: aload           $this$width$iv
        //    16: iconst_0       
        //    17: iaload         
        //    18: iload_1         /* maxWidth */
        //    19: if_icmpgt       36
        //    22: aload_0         /* $this$maxButKeepAspect */
        //    23: astore          $this$height$iv
        //    25: iconst_0       
        //    26: istore          $i$f$getHeight
        //    28: aload           $this$height$iv
        //    30: iconst_1       
        //    31: iaload         
        //    32: iload_2         /* maxHeight */
        //    33: if_icmple       235
        //    36: aload_0         /* $this$maxButKeepAspect */
        //    37: astore          $this$width$iv
        //    39: iconst_0       
        //    40: istore          $i$f$getWidth
        //    42: aload           $this$width$iv
        //    44: iconst_0       
        //    45: iaload         
        //    46: i2f            
        //    47: iload_1         /* maxWidth */
        //    48: i2f            
        //    49: fconst_1       
        //    50: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(FF)F
        //    53: fdiv           
        //    54: fstore          viewToBitmapWidthRatio
        //    56: aload_0         /* $this$maxButKeepAspect */
        //    57: astore          $this$height$iv
        //    59: iconst_0       
        //    60: istore          $i$f$getHeight
        //    62: aload           $this$height$iv
        //    64: iconst_1       
        //    65: iaload         
        //    66: i2f            
        //    67: iload_2         /* maxHeight */
        //    68: i2f            
        //    69: fconst_1       
        //    70: invokestatic    ly/img/android/pesdk/kotlin_extension/TypeExtensionsKt.butMin:(FF)F
        //    73: fdiv           
        //    74: fstore          viewToBitmapHeightRatio
        //    76: fload           viewToBitmapWidthRatio
        //    78: fload           viewToBitmapHeightRatio
        //    80: fcmpg          
        //    81: ifgt            88
        //    84: iconst_1       
        //    85: goto            89
        //    88: iconst_0       
        //    89: istore          hasLowerAspect
        //    91: iload           hasLowerAspect
        //    93: ifeq            167
        //    96: aload_0         /* $this$maxButKeepAspect */
        //    97: astore          $this$width$iv
        //    99: iconst_0       
        //   100: istore          $i$f$getWidth
        //   102: aload           $this$width$iv
        //   104: iconst_0       
        //   105: iaload         
        //   106: istore          oldWidth
        //   108: aload_0         /* $this$maxButKeepAspect */
        //   109: astore          $this$width$iv
        //   111: iconst_0       
        //   112: istore          $i$f$setWidth
        //   114: aload           $this$width$iv
        //   116: iconst_0       
        //   117: iload_1         /* maxWidth */
        //   118: iastore        
        //   119: nop            
        //   120: aload_0         /* $this$maxButKeepAspect */
        //   121: astore          8
        //   123: aload_0         /* $this$maxButKeepAspect */
        //   124: astore          $this$height$iv
        //   126: iconst_0       
        //   127: istore          $i$f$getHeight
        //   129: aload           $this$height$iv
        //   131: iconst_1       
        //   132: iaload         
        //   133: aload_0         /* $this$maxButKeepAspect */
        //   134: astore          $this$width$iv
        //   136: iconst_0       
        //   137: istore          $i$f$getWidth
        //   139: aload           $this$width$iv
        //   141: iconst_0       
        //   142: iaload         
        //   143: imul           
        //   144: i2d            
        //   145: iload           oldWidth
        //   147: i2d            
        //   148: ddiv           
        //   149: invokestatic    kotlin/math/MathKt.roundToInt:(D)I
        //   152: istore          value$iv
        //   154: iconst_0       
        //   155: istore          $i$f$setHeight
        //   157: aload           $this$height$iv
        //   159: iconst_1       
        //   160: iload           value$iv
        //   162: iastore        
        //   163: nop            
        //   164: goto            235
        //   167: aload_0         /* $this$maxButKeepAspect */
        //   168: astore          $this$height$iv
        //   170: iconst_0       
        //   171: istore          $i$f$getHeight
        //   173: aload           $this$height$iv
        //   175: iconst_1       
        //   176: iaload         
        //   177: istore          oldHeight
        //   179: aload_0         /* $this$maxButKeepAspect */
        //   180: astore          $this$height$iv
        //   182: iconst_0       
        //   183: istore          $i$f$setHeight
        //   185: aload           $this$height$iv
        //   187: iconst_1       
        //   188: iload_2         /* maxHeight */
        //   189: iastore        
        //   190: nop            
        //   191: aload_0         /* $this$maxButKeepAspect */
        //   192: astore          8
        //   194: aload_0         /* $this$maxButKeepAspect */
        //   195: astore          $this$width$iv
        //   197: iconst_0       
        //   198: istore          $i$f$getWidth
        //   200: aload           $this$width$iv
        //   202: iconst_0       
        //   203: iaload         
        //   204: aload_0         /* $this$maxButKeepAspect */
        //   205: astore          $this$height$iv
        //   207: iconst_0       
        //   208: istore          $i$f$getHeight
        //   210: aload           $this$height$iv
        //   212: iconst_1       
        //   213: iaload         
        //   214: imul           
        //   215: i2d            
        //   216: iload           oldHeight
        //   218: i2d            
        //   219: ddiv           
        //   220: invokestatic    kotlin/math/MathKt.roundToInt:(D)I
        //   223: istore          value$iv
        //   225: iconst_0       
        //   226: istore          $i$f$setWidth
        //   228: aload           $this$width$iv
        //   230: iconst_0       
        //   231: iload           value$iv
        //   233: iastore        
        //   234: nop            
        //   235: aload_0         /* $this$maxButKeepAspect */
        //   236: areturn        
        //    StackMapTable: 00 05 FE 00 24 01 07 00 FD 01 FF 00 33 00 08 07 00 FD 01 01 01 02 02 07 00 FD 01 00 00 40 01 FF 00 4D 00 08 07 00 FD 01 01 01 02 02 01 01 00 00 FF 00 43 00 04 07 00 FD 01 01 01 00 00
        // 
        // The error that occurred was:
        // 
        // java.lang.NullPointerException
        // 
        throw new IllegalStateException("An error occurred while decompiling this method.");
    }
    
    public static final int compareTo(@NotNull final int[] $this$compareTo, @NotNull final int[] other) {
        Intrinsics.checkNotNullParameter((Object)$this$compareTo, "<this>");
        Intrinsics.checkNotNullParameter((Object)other, "other");
        final int $i$f$compareTo = 0;
        int[] $this$width$iv = $this$compareTo;
        int $i$f$getWidth = 0;
        final int n = $this$width$iv[0];
        int[] $this$height$iv = $this$compareTo;
        int $i$f$getHeight = 0;
        final int n2 = n * $this$height$iv[1];
        $this$width$iv = other;
        $i$f$getWidth = 0;
        final int n3 = $this$width$iv[0];
        $this$height$iv = other;
        $i$f$getHeight = 0;
        return Intrinsics.compare(n2, n3 * $this$height$iv[1]);
    }
    
    @NotNull
    public static final int[] setValue(@NotNull final int[] $this$setValue, @NotNull final int[] values) {
        Intrinsics.checkNotNullParameter((Object)$this$setValue, "<this>");
        Intrinsics.checkNotNullParameter((Object)values, "values");
        final int $i$f$setValue = 0;
        $this$setValue[0] = values[0];
        $this$setValue[1] = values[1];
        return $this$setValue;
    }
    
    @NotNull
    public static final int[] setValue(@NotNull final int[] $this$setValue, final int x, final int y) {
        Intrinsics.checkNotNullParameter((Object)$this$setValue, "<this>");
        final int $i$f$setValue = 0;
        $this$setValue[0] = x;
        $this$setValue[1] = y;
        return $this$setValue;
    }
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final float x, final float y) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        final int $i$f$set = 0;
        $this$set[0] = x;
        $this$set[1] = y;
        return $this$set;
    }
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final float x, final float y, final float z) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        final int $i$f$set = 0;
        $this$set[0] = x;
        $this$set[1] = y;
        $this$set[2] = z;
        return $this$set;
    }
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final float x, final float y, final float x2, final float y2) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        final int $i$f$set = 0;
        $this$set[0] = x;
        $this$set[1] = y;
        $this$set[2] = x2;
        $this$set[3] = y2;
        return $this$set;
    }
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final int argbAndroidColor) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore_2        /* $i$f$set */
        //     8: aload_0         /* $this$set */
        //     9: astore_3       
        //    10: iload_1         /* argbAndroidColor */
        //    11: invokestatic    android/graphics/Color.red:(I)I
        //    14: i2f            
        //    15: ldc             255.0
        //    17: fdiv           
        //    18: fstore          4
        //    20: iload_1         /* argbAndroidColor */
        //    21: invokestatic    android/graphics/Color.green:(I)I
        //    24: i2f            
        //    25: ldc             255.0
        //    27: fdiv           
        //    28: fstore          5
        //    30: iload_1         /* argbAndroidColor */
        //    31: invokestatic    android/graphics/Color.blue:(I)I
        //    34: i2f            
        //    35: ldc             255.0
        //    37: fdiv           
        //    38: fstore          6
        //    40: iload_1         /* argbAndroidColor */
        //    41: invokestatic    android/graphics/Color.alpha:(I)I
        //    44: i2f            
        //    45: ldc             255.0
        //    47: fdiv           
        //    48: fstore          7
        //    50: nop            
        //    51: iconst_0       
        //    52: istore          $i$f$set
        //    54: aload_3         /* $this$set$iv */
        //    55: iconst_0       
        //    56: fload           x$iv
        //    58: fastore        
        //    59: aload_3         /* $this$set$iv */
        //    60: iconst_1       
        //    61: fload           y$iv
        //    63: fastore        
        //    64: aload_3         /* $this$set$iv */
        //    65: iconst_2       
        //    66: fload           x2$iv
        //    68: fastore        
        //    69: aload_3         /* $this$set$iv */
        //    70: iconst_3       
        //    71: fload           y2$iv
        //    73: fastore        
        //    74: aload_3         /* $this$set$iv */
        //    75: areturn        
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
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final int r, final int g, final int b, final int a) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore          $i$f$set
        //     9: aload_0         /* $this$set */
        //    10: astore          6
        //    12: iload_1         /* r */
        //    13: i2f            
        //    14: ldc             255.0
        //    16: fdiv           
        //    17: fstore          7
        //    19: iload_2         /* g */
        //    20: i2f            
        //    21: ldc             255.0
        //    23: fdiv           
        //    24: fstore          8
        //    26: iload_3         /* b */
        //    27: i2f            
        //    28: ldc             255.0
        //    30: fdiv           
        //    31: fstore          9
        //    33: iload           a
        //    35: i2f            
        //    36: ldc             255.0
        //    38: fdiv           
        //    39: fstore          y2$iv
        //    41: iconst_0       
        //    42: istore          $i$f$set
        //    44: aload           $this$set$iv
        //    46: iconst_0       
        //    47: fload           x$iv
        //    49: fastore        
        //    50: aload           $this$set$iv
        //    52: iconst_1       
        //    53: fload           y$iv
        //    55: fastore        
        //    56: aload           $this$set$iv
        //    58: iconst_2       
        //    59: fload           x2$iv
        //    61: fastore        
        //    62: aload           $this$set$iv
        //    64: iconst_3       
        //    65: fload           y2$iv
        //    67: fastore        
        //    68: aload           $this$set$iv
        //    70: areturn        
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
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final int r, final int g, final int b, final float a) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: ldc             "<this>"
        //     3: invokestatic    kotlin/jvm/internal/Intrinsics.checkNotNullParameter:(Ljava/lang/Object;Ljava/lang/String;)V
        //     6: iconst_0       
        //     7: istore          $i$f$set
        //     9: aload_0         /* $this$set */
        //    10: astore          6
        //    12: iload_1         /* r */
        //    13: i2f            
        //    14: ldc             255.0
        //    16: fdiv           
        //    17: fstore          7
        //    19: iload_2         /* g */
        //    20: i2f            
        //    21: ldc             255.0
        //    23: fdiv           
        //    24: fstore          8
        //    26: iload_3         /* b */
        //    27: i2f            
        //    28: ldc             255.0
        //    30: fdiv           
        //    31: fstore          x2$iv
        //    33: iconst_0       
        //    34: istore          $i$f$set
        //    36: aload           $this$set$iv
        //    38: iconst_0       
        //    39: fload           x$iv
        //    41: fastore        
        //    42: aload           $this$set$iv
        //    44: iconst_1       
        //    45: fload           y$iv
        //    47: fastore        
        //    48: aload           $this$set$iv
        //    50: iconst_2       
        //    51: fload           x2$iv
        //    53: fastore        
        //    54: aload           $this$set$iv
        //    56: iconst_3       
        //    57: fload           a
        //    59: fastore        
        //    60: aload           $this$set$iv
        //    62: areturn        
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
    
    @NotNull
    public static final float[] set(@NotNull final float[] $this$set, final float x1, final float y1, final float x2, final float y2, final float x3, final float y3, final float x4, final float y4) {
        Intrinsics.checkNotNullParameter((Object)$this$set, "<this>");
        final int $i$f$set = 0;
        $this$set[0] = x1;
        $this$set[1] = y1;
        $this$set[2] = x2;
        $this$set[3] = y2;
        $this$set[4] = x3;
        $this$set[5] = y3;
        $this$set[6] = x4;
        $this$set[7] = y4;
        return $this$set;
    }
    
    public static final float getX(@NotNull final float[] $this$x) {
        Intrinsics.checkNotNullParameter((Object)$this$x, "<this>");
        final int $i$f$getX = 0;
        return $this$x[0];
    }
    
    public static final void setX(@NotNull final float[] $this$x, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$x, "<this>");
        final int $i$f$setX = 0;
        $this$x[0] = value;
    }
    
    public static final float getY(@NotNull final float[] $this$y) {
        Intrinsics.checkNotNullParameter((Object)$this$y, "<this>");
        final int $i$f$getY = 0;
        return $this$y[1];
    }
    
    public static final void setY(@NotNull final float[] $this$y, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$y, "<this>");
        final int $i$f$setY = 0;
        $this$y[1] = value;
    }
    
    public static final int getX(@NotNull final int[] $this$x) {
        Intrinsics.checkNotNullParameter((Object)$this$x, "<this>");
        final int $i$f$getX = 0;
        return $this$x[0];
    }
    
    public static final void setX(@NotNull final int[] $this$x, final int value) {
        Intrinsics.checkNotNullParameter((Object)$this$x, "<this>");
        final int $i$f$setX = 0;
        $this$x[0] = value;
    }
    
    public static final int getY(@NotNull final int[] $this$y) {
        Intrinsics.checkNotNullParameter((Object)$this$y, "<this>");
        final int $i$f$getY = 0;
        return $this$y[1];
    }
    
    public static final void setY(@NotNull final int[] $this$y, final int value) {
        Intrinsics.checkNotNullParameter((Object)$this$y, "<this>");
        final int $i$f$setY = 0;
        $this$y[1] = value;
    }
    
    public static final int getWidth(@NotNull final int[] $this$width) {
        Intrinsics.checkNotNullParameter((Object)$this$width, "<this>");
        final int $i$f$getWidth = 0;
        return $this$width[0];
    }
    
    public static final void setWidth(@NotNull final int[] $this$width, final int value) {
        Intrinsics.checkNotNullParameter((Object)$this$width, "<this>");
        final int $i$f$setWidth = 0;
        $this$width[0] = value;
    }
    
    public static final int getHeight(@NotNull final int[] $this$height) {
        Intrinsics.checkNotNullParameter((Object)$this$height, "<this>");
        final int $i$f$getHeight = 0;
        return $this$height[1];
    }
    
    public static final void setHeight(@NotNull final int[] $this$height, final int value) {
        Intrinsics.checkNotNullParameter((Object)$this$height, "<this>");
        final int $i$f$setHeight = 0;
        $this$height[1] = value;
    }
    
    public static final float getZ(@NotNull final float[] $this$z) {
        Intrinsics.checkNotNullParameter((Object)$this$z, "<this>");
        final int $i$f$getZ = 0;
        return $this$z[2];
    }
    
    public static final void setZ(@NotNull final float[] $this$z, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$z, "<this>");
        final int $i$f$setZ = 0;
        $this$z[2] = value;
    }
    
    public static final float getW(@NotNull final float[] $this$w) {
        Intrinsics.checkNotNullParameter((Object)$this$w, "<this>");
        final int $i$f$getW = 0;
        return $this$w[3];
    }
    
    public static final void setW(@NotNull final float[] $this$w, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$w, "<this>");
        final int $i$f$setW = 0;
        $this$w[3] = value;
    }
    
    public static final float getR(@NotNull final float[] $this$r) {
        Intrinsics.checkNotNullParameter((Object)$this$r, "<this>");
        final int $i$f$getR = 0;
        return $this$r[0];
    }
    
    public static final void setR(@NotNull final float[] $this$r, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$r, "<this>");
        final int $i$f$setR = 0;
        $this$r[0] = value;
    }
    
    public static final float getG(@NotNull final float[] $this$g) {
        Intrinsics.checkNotNullParameter((Object)$this$g, "<this>");
        final int $i$f$getG = 0;
        return $this$g[1];
    }
    
    public static final void setG(@NotNull final float[] $this$g, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$g, "<this>");
        final int $i$f$setG = 0;
        $this$g[1] = value;
    }
    
    public static final float getB(@NotNull final float[] $this$b) {
        Intrinsics.checkNotNullParameter((Object)$this$b, "<this>");
        final int $i$f$getB = 0;
        return $this$b[2];
    }
    
    public static final void setB(@NotNull final float[] $this$b, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$b, "<this>");
        final int $i$f$setB = 0;
        $this$b[2] = value;
    }
    
    public static final float getA(@NotNull final float[] $this$a) {
        Intrinsics.checkNotNullParameter((Object)$this$a, "<this>");
        final int $i$f$getA = 0;
        return $this$a[3];
    }
    
    public static final void setA(@NotNull final float[] $this$a, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$a, "<this>");
        final int $i$f$setA = 0;
        $this$a[3] = value;
    }
    
    public static final float getX1(@NotNull final float[] $this$x1) {
        Intrinsics.checkNotNullParameter((Object)$this$x1, "<this>");
        final int $i$f$getX1 = 0;
        return $this$x1[0];
    }
    
    public static final void setX1(@NotNull final float[] $this$x1, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$x1, "<this>");
        final int $i$f$setX1 = 0;
        $this$x1[0] = value;
    }
    
    public static final float getY1(@NotNull final float[] $this$y1) {
        Intrinsics.checkNotNullParameter((Object)$this$y1, "<this>");
        final int $i$f$getY1 = 0;
        return $this$y1[1];
    }
    
    public static final void setY1(@NotNull final float[] $this$y1, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$y1, "<this>");
        final int $i$f$setY1 = 0;
        $this$y1[1] = value;
    }
    
    public static final float getX2(@NotNull final float[] $this$x2) {
        Intrinsics.checkNotNullParameter((Object)$this$x2, "<this>");
        final int $i$f$getX2 = 0;
        return $this$x2[2];
    }
    
    public static final void setX2(@NotNull final float[] $this$x2, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$x2, "<this>");
        final int $i$f$setX2 = 0;
        $this$x2[2] = value;
    }
    
    public static final float getY2(@NotNull final float[] $this$y2) {
        Intrinsics.checkNotNullParameter((Object)$this$y2, "<this>");
        final int $i$f$getY2 = 0;
        return $this$y2[3];
    }
    
    public static final void setY2(@NotNull final float[] $this$y2, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$y2, "<this>");
        final int $i$f$setY2 = 0;
        $this$y2[3] = value;
    }
    
    public static final float getX3(@NotNull final float[] $this$x3) {
        Intrinsics.checkNotNullParameter((Object)$this$x3, "<this>");
        final int $i$f$getX3 = 0;
        return $this$x3[4];
    }
    
    public static final void setX3(@NotNull final float[] $this$x3, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$x3, "<this>");
        final int $i$f$setX3 = 0;
        $this$x3[4] = value;
    }
    
    public static final float getY3(@NotNull final float[] $this$y3) {
        Intrinsics.checkNotNullParameter((Object)$this$y3, "<this>");
        final int $i$f$getY3 = 0;
        return $this$y3[5];
    }
    
    public static final void setY3(@NotNull final float[] $this$y3, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$y3, "<this>");
        final int $i$f$setY3 = 0;
        $this$y3[5] = value;
    }
    
    public static final float getX4(@NotNull final float[] $this$x4) {
        Intrinsics.checkNotNullParameter((Object)$this$x4, "<this>");
        final int $i$f$getX4 = 0;
        return $this$x4[6];
    }
    
    public static final void setX4(@NotNull final float[] $this$x4, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$x4, "<this>");
        final int $i$f$setX4 = 0;
        $this$x4[6] = value;
    }
    
    public static final float getY4(@NotNull final float[] $this$y4) {
        Intrinsics.checkNotNullParameter((Object)$this$y4, "<this>");
        final int $i$f$getY4 = 0;
        return $this$y4[7];
    }
    
    public static final void setY4(@NotNull final float[] $this$y4, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$y4, "<this>");
        final int $i$f$setY4 = 0;
        $this$y4[7] = value;
    }
    
    public static final float getWidth(@NotNull final float[] $this$width) {
        Intrinsics.checkNotNullParameter((Object)$this$width, "<this>");
        final int $i$f$getWidth = 0;
        return $this$width[0];
    }
    
    public static final void setWidth(@NotNull final float[] $this$width, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$width, "<this>");
        final int $i$f$setWidth = 0;
        $this$width[0] = value;
    }
    
    public static final float getHeight(@NotNull final float[] $this$height) {
        Intrinsics.checkNotNullParameter((Object)$this$height, "<this>");
        final int $i$f$getHeight = 0;
        return $this$height[1];
    }
    
    public static final void setHeight(@NotNull final float[] $this$height, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$height, "<this>");
        final int $i$f$setHeight = 0;
        $this$height[1] = value;
    }
    
    public static final float getFirstWidth(@NotNull final float[] $this$firstWidth) {
        Intrinsics.checkNotNullParameter((Object)$this$firstWidth, "<this>");
        final int $i$f$getFirstWidth = 0;
        return $this$firstWidth[0];
    }
    
    public static final void setFirstWidth(@NotNull final float[] $this$firstWidth, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$firstWidth, "<this>");
        final int $i$f$setFirstWidth = 0;
        $this$firstWidth[0] = value;
    }
    
    public static final float getFirstHeight(@NotNull final float[] $this$firstHeight) {
        Intrinsics.checkNotNullParameter((Object)$this$firstHeight, "<this>");
        final int $i$f$getFirstHeight = 0;
        return $this$firstHeight[1];
    }
    
    public static final void setFirstHeight(@NotNull final float[] $this$firstHeight, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$firstHeight, "<this>");
        final int $i$f$setFirstHeight = 0;
        $this$firstHeight[1] = value;
    }
    
    public static final float getSecondWidth(@NotNull final float[] $this$secondWidth) {
        Intrinsics.checkNotNullParameter((Object)$this$secondWidth, "<this>");
        final int $i$f$getSecondWidth = 0;
        return $this$secondWidth[2];
    }
    
    public static final void setSecondWidth(@NotNull final float[] $this$secondWidth, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$secondWidth, "<this>");
        final int $i$f$setSecondWidth = 0;
        $this$secondWidth[2] = value;
    }
    
    public static final float getSecondHeight(@NotNull final float[] $this$secondHeight) {
        Intrinsics.checkNotNullParameter((Object)$this$secondHeight, "<this>");
        final int $i$f$getSecondHeight = 0;
        return $this$secondHeight[3];
    }
    
    public static final void setSecondHeight(@NotNull final float[] $this$secondHeight, final float value) {
        Intrinsics.checkNotNullParameter((Object)$this$secondHeight, "<this>");
        final int $i$f$setSecondHeight = 0;
        $this$secondHeight[3] = value;
    }
    
    @NotNull
    public static final float[] copyFrom(@NotNull final float[] $this$copyFrom, @NotNull final float[] from) {
        Intrinsics.checkNotNullParameter((Object)$this$copyFrom, "<this>");
        Intrinsics.checkNotNullParameter((Object)from, "from");
        final int $i$f$copyFrom = 0;
        ArraysKt.copyInto$default(from, $this$copyFrom, 0, 0, 0, 14, (Object)null);
        return $this$copyFrom;
    }
    
    @NotNull
    public static final float[] mapPointsWith(@NotNull final float[] $this$mapPointsWith, @NotNull final Matrix transformation) {
        Intrinsics.checkNotNullParameter((Object)$this$mapPointsWith, "<this>");
        Intrinsics.checkNotNullParameter((Object)transformation, "transformation");
        final int $i$f$mapPointsWith = 0;
        transformation.mapPoints($this$mapPointsWith);
        return $this$mapPointsWith;
    }
    
    @NotNull
    public static final float[] mapPointsBy(@NotNull final float[] $this$mapPointsBy, @NotNull final Function1<? super Matrix, Unit> instructions) {
        Intrinsics.checkNotNullParameter((Object)$this$mapPointsBy, "<this>");
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        final int $i$f$mapPointsBy = 0;
        final Recyclable $this$recycleAfter$iv = Transformation.obtain();
        final int $i$f$recycleAfter = 0;
        final Recyclable it$iv = $this$recycleAfter$iv;
        final int n = 0;
        final Transformation it = (Transformation)it$iv;
        final int n2 = 0;
        instructions.invoke((Object)it);
        it.mapPoints($this$mapPointsBy);
        final Object $this$andRecycle$iv$iv = Unit.INSTANCE;
        final int $i$f$andRecycle = 0;
        final Object it$iv$iv = $this$andRecycle$iv$iv;
        final int n3 = 0;
        it$iv.recycle();
        return $this$mapPointsBy;
    }
    
    @NotNull
    public static final MultiRect mapRectBy(@NotNull final MultiRect $this$mapRectBy, @NotNull final Function1<? super Matrix, Unit> instructions) {
        Intrinsics.checkNotNullParameter((Object)$this$mapRectBy, "<this>");
        Intrinsics.checkNotNullParameter((Object)instructions, "instructions");
        final int $i$f$mapRectBy = 0;
        final Recyclable $this$recycleAfter$iv = Transformation.obtain();
        final int $i$f$recycleAfter = 0;
        final Recyclable it$iv = $this$recycleAfter$iv;
        final int n = 0;
        final Transformation it = (Transformation)it$iv;
        final int n2 = 0;
        instructions.invoke((Object)it);
        final boolean $this$andRecycle$iv$iv = it.mapRect((RectF)$this$mapRectBy);
        final int $i$f$andRecycle = 0;
        final boolean it$iv$iv = $this$andRecycle$iv$iv;
        final int n3 = 0;
        it$iv.recycle();
        return $this$mapRectBy;
    }
    
    @CheckResult
    public static final boolean isNotFinite(final float $this$isNotFinite) {
        final int $i$f$isNotFinite = 0;
        return Float.isInfinite($this$isNotFinite) || Float.isNaN($this$isNotFinite);
    }
    
    @CheckResult
    public static final float ifNotFinite(final float $this$ifNotFinite, final float value) {
        final int $i$f$ifNotFinite = 0;
        return (!Float.isInfinite($this$ifNotFinite) && !Float.isNaN($this$ifNotFinite)) ? $this$ifNotFinite : value;
    }
    
    @CheckResult
    public static final double ifNotFinite(final double $this$ifNotFinite, final double value) {
        final int $i$f$ifNotFinite = 0;
        return (!Double.isInfinite($this$ifNotFinite) && !Double.isNaN($this$ifNotFinite)) ? $this$ifNotFinite : value;
    }
    
    @CheckResult
    public static final int scaleToMultipleOf(final int $this$scaleToMultipleOf, final int v) {
        final int $i$f$scaleToMultipleOf = 0;
        int n;
        if ($this$scaleToMultipleOf / (float)v < 0.5) {
            final int $this$downscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$downscaleToMultipleOf = 0;
            n = $this$downscaleToMultipleOf$iv - $this$downscaleToMultipleOf$iv % v;
        }
        else {
            final int $this$upscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$upscaleToMultipleOf = 0;
            n = $this$upscaleToMultipleOf$iv + (v - $this$upscaleToMultipleOf$iv % v) % v;
        }
        return n;
    }
    
    @CheckResult
    public static final long scaleToMultipleOf(final long $this$scaleToMultipleOf, final long v) {
        final int $i$f$scaleToMultipleOf = 0;
        long n;
        if ($this$scaleToMultipleOf / (double)v < 0.5) {
            final long $this$downscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$downscaleToMultipleOf = 0;
            n = $this$downscaleToMultipleOf$iv - $this$downscaleToMultipleOf$iv % v;
        }
        else {
            final long $this$upscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$upscaleToMultipleOf = 0;
            n = $this$upscaleToMultipleOf$iv + (v - $this$upscaleToMultipleOf$iv % v) % v;
        }
        return n;
    }
    
    @CheckResult
    public static final float scaleToMultipleOf(final float $this$scaleToMultipleOf, final float v) {
        final int $i$f$scaleToMultipleOf = 0;
        float n;
        if ($this$scaleToMultipleOf / v < 0.5) {
            final float $this$downscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$downscaleToMultipleOf = 0;
            n = $this$downscaleToMultipleOf$iv - $this$downscaleToMultipleOf$iv % v;
        }
        else {
            final float $this$upscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$upscaleToMultipleOf = 0;
            n = $this$upscaleToMultipleOf$iv + (v - $this$upscaleToMultipleOf$iv % v) % v;
        }
        return n;
    }
    
    @CheckResult
    public static final double scaleToMultipleOf(final double $this$scaleToMultipleOf, final double v) {
        final int $i$f$scaleToMultipleOf = 0;
        double n;
        if ($this$scaleToMultipleOf / v < 0.5) {
            final double $this$downscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$downscaleToMultipleOf = 0;
            n = $this$downscaleToMultipleOf$iv - $this$downscaleToMultipleOf$iv % v;
        }
        else {
            final double $this$upscaleToMultipleOf$iv = $this$scaleToMultipleOf;
            final int $i$f$upscaleToMultipleOf = 0;
            n = $this$upscaleToMultipleOf$iv + (v - $this$upscaleToMultipleOf$iv % v) % v;
        }
        return n;
    }
    
    @CheckResult
    public static final int upscaleToMultipleOf(final int $this$upscaleToMultipleOf, final int v) {
        final int $i$f$upscaleToMultipleOf = 0;
        return $this$upscaleToMultipleOf + (v - $this$upscaleToMultipleOf % v) % v;
    }
    
    @CheckResult
    public static final long upscaleToMultipleOf(final long $this$upscaleToMultipleOf, final long v) {
        final int $i$f$upscaleToMultipleOf = 0;
        return $this$upscaleToMultipleOf + (v - $this$upscaleToMultipleOf % v) % v;
    }
    
    @CheckResult
    public static final float upscaleToMultipleOf(final float $this$upscaleToMultipleOf, final float v) {
        final int $i$f$upscaleToMultipleOf = 0;
        return $this$upscaleToMultipleOf + (v - $this$upscaleToMultipleOf % v) % v;
    }
    
    @CheckResult
    public static final double upscaleToMultipleOf(final double $this$upscaleToMultipleOf, final double v) {
        final int $i$f$upscaleToMultipleOf = 0;
        return $this$upscaleToMultipleOf + (v - $this$upscaleToMultipleOf % v) % v;
    }
    
    @CheckResult
    public static final int downscaleToMultipleOf(final int $this$downscaleToMultipleOf, final int v) {
        final int $i$f$downscaleToMultipleOf = 0;
        return $this$downscaleToMultipleOf - $this$downscaleToMultipleOf % v;
    }
    
    @CheckResult
    public static final long downscaleToMultipleOf(final long $this$downscaleToMultipleOf, final long v) {
        final int $i$f$downscaleToMultipleOf = 0;
        return $this$downscaleToMultipleOf - $this$downscaleToMultipleOf % v;
    }
    
    @CheckResult
    public static final float downscaleToMultipleOf(final float $this$downscaleToMultipleOf, final float v) {
        final int $i$f$downscaleToMultipleOf = 0;
        return $this$downscaleToMultipleOf - $this$downscaleToMultipleOf % v;
    }
    
    @CheckResult
    public static final double downscaleToMultipleOf(final double $this$downscaleToMultipleOf, final double v) {
        final int $i$f$downscaleToMultipleOf = 0;
        return $this$downscaleToMultipleOf - $this$downscaleToMultipleOf % v;
    }
    
    @CheckResult
    public static final boolean hasInvertedFlag(final int $this$hasInvertedFlag, final int flag) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore_2        /* $i$f$hasInvertedFlag */
        //     2: iload_0         /* $this$hasInvertedFlag */
        //     3: iconst_m1      
        //     4: ixor           
        //     5: istore_3       
        //     6: iload_1         /* flag */
        //     7: iconst_m1      
        //     8: ixor           
        //     9: istore          flag$iv
        //    11: iconst_0       
        //    12: istore          $i$f$hasFlag
        //    14: iload_3         /* $this$hasFlag$iv */
        //    15: iload           flag$iv
        //    17: iand           
        //    18: ifeq            25
        //    21: iconst_1       
        //    22: goto            26
        //    25: iconst_0       
        //    26: ireturn        
        //    StackMapTable: 00 02 FF 00 19 00 06 01 01 01 01 01 01 00 00 40 01
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
    
    @CheckResult
    public static final boolean hasInvertedFlag(final long $this$hasInvertedFlag, final long flag) {
        // 
        // This method could not be decompiled.
        // 
        // Original Bytecode:
        // 
        //     1: istore          $i$f$hasInvertedFlag
        //     3: lload_0         /* $this$hasInvertedFlag */
        //     4: ldc2_w          -1
        //     7: lxor           
        //     8: lstore          5
        //    10: lload_2         /* flag */
        //    11: ldc2_w          -1
        //    14: lxor           
        //    15: lstore          flag$iv
        //    17: iconst_0       
        //    18: istore          $i$f$hasFlag
        //    20: lload           $this$hasFlag$iv
        //    22: lload           flag$iv
        //    24: land           
        //    25: lconst_0       
        //    26: lcmp           
        //    27: ifeq            34
        //    30: iconst_1       
        //    31: goto            35
        //    34: iconst_0       
        //    35: ireturn        
        //    StackMapTable: 00 02 FF 00 22 00 06 04 04 01 04 04 01 00 00 40 01
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
    
    @CheckResult
    public static final boolean hasFlag(final int $this$hasFlag, final int flag) {
        final int $i$f$hasFlag = 0;
        return ($this$hasFlag & flag) != 0x0;
    }
    
    @CheckResult
    public static final boolean hasFlag(final long $this$hasFlag, final long flag) {
        final int $i$f$hasFlag = 0;
        return ($this$hasFlag & flag) != 0x0L;
    }
    
    @CheckResult
    public static final int ceilToInt(final float $this$ceilToInt) {
        final int $i$f$ceilToInt = 0;
        return (int)(float)Math.ceil($this$ceilToInt);
    }
    
    @CheckResult
    public static final int ceilToInt(final double $this$ceilToInt) {
        final int $i$f$ceilToInt = 0;
        return (int)Math.ceil($this$ceilToInt);
    }
    
    @CheckResult
    public static final long ceilToLong(final double $this$ceilToLong) {
        final int $i$f$ceilToLong = 0;
        return (long)Math.ceil($this$ceilToLong);
    }
    
    @CheckResult
    public static final int downscaleToLog2(final int $this$downscaleToLog2) {
        final int result = upscaleToLog2($this$downscaleToLog2);
        return (result == $this$downscaleToLog2) ? $this$downscaleToLog2 : ($this$downscaleToLog2 << 1);
    }
    
    @CheckResult
    public static final long downscaleToLog2(final long $this$downscaleToLog2) {
        final long result = upscaleToLog2($this$downscaleToLog2);
        return (result == $this$downscaleToLog2) ? $this$downscaleToLog2 : ($this$downscaleToLog2 << 1);
    }
    
    @CheckResult
    public static final int upscaleToLog2(final int $this$upscaleToLog2) {
        int n2;
        if (($this$upscaleToLog2 & $this$upscaleToLog2 - 1) != 0x0) {
            int n = $this$upscaleToLog2 - 1;
            n |= n >> 1;
            n |= n >> 2;
            n |= n >> 4;
            n |= n >> 8;
            n |= n >> 16;
            n2 = n + 1;
        }
        else {
            n2 = $this$upscaleToLog2;
        }
        return n2;
    }
    
    @CheckResult
    public static final long upscaleToLog2(final long $this$upscaleToLog2) {
        long n2;
        if (($this$upscaleToLog2 & $this$upscaleToLog2 - 1L) != 0x0L) {
            long n = $this$upscaleToLog2 - 1L;
            n |= n >> 1;
            n |= n >> 2;
            n |= n >> 4;
            n |= n >> 8;
            n |= n >> 16;
            n |= n >> 32;
            n2 = n + 1L;
        }
        else {
            n2 = $this$upscaleToLog2;
        }
        return n2;
    }
    
    public static final int countTrue(@NotNull final boolean... booleans) {
        Intrinsics.checkNotNullParameter((Object)booleans, "booleans");
        final int $i$f$countTrue = 0;
        int count = 0;
        for (int i = 0; i < booleans.length; ++i) {
            final boolean bool = booleans[i];
            if (bool) {
                ++count;
            }
        }
        return count;
    }
    
    public static final <T> void forEach(@NotNull final SparseArray<T> $this$forEach, @NotNull final Function1<? super T, Unit> block) {
        Intrinsics.checkNotNullParameter((Object)$this$forEach, "<this>");
        Intrinsics.checkNotNullParameter((Object)block, "block");
        final int $i$f$forEach = 0;
        for (int index = 0; index < $this$forEach.size(); ++index) {
            block.invoke($this$forEach.valueAt(index));
        }
    }
}
