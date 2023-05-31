// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.utils;

import java.util.LinkedHashMap;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import java.io.Serializable;
import kotlin.jvm.internal.Intrinsics;
import android.os.Parcel;
import java.util.Map;
import java.util.concurrent.locks.ReentrantLock;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\t\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\rH\u0007J\u001c\u0010\u000e\u001a\u00020\n2\n\u0010\u000b\u001a\u0006\u0012\u0002\b\u00030\u00062\u0006\u0010\f\u001a\u00020\rH\u0007R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u0005\u0012\b\u0012\u0006\u0012\u0002\b\u00030\u00060\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000f" }, d2 = { "Lly/img/android/utils/ParcelGuard;", "", "()V", "info", "", "Ljava/lang/Thread;", "Ljava/lang/Class;", "parcelLook", "Ljava/util/concurrent/locks/ReentrantLock;", "startReadOf", "", "currentClass", "parcel", "Landroid/os/Parcel;", "startWriteOf", "pesdk-backend-core_release" })
public final class ParcelGuard
{
    @NotNull
    public static final ParcelGuard INSTANCE;
    @NotNull
    private static final ReentrantLock parcelLook;
    @NotNull
    private static final Map<Thread, Class<?>> info;
    
    private ParcelGuard() {
    }
    
    @JvmStatic
    public static final void startWriteOf(@NotNull final Class<?> currentClass, @NotNull final Parcel parcel) {
        Intrinsics.checkNotNullParameter((Object)currentClass, "currentClass");
        Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
        parcel.writeSerializable((Serializable)currentClass);
    }
    
    @JvmStatic
    public static final void startReadOf(@NotNull final Class<?> currentClass, @NotNull final Parcel parcel) {
        Intrinsics.checkNotNullParameter((Object)currentClass, "currentClass");
        Intrinsics.checkNotNullParameter((Object)parcel, "parcel");
        final Serializable serializable = parcel.readSerializable();
        if (serializable == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.Class<*>");
        }
        final Class loadedClass = (Class)serializable;
        if (!Intrinsics.areEqual((Object)loadedClass, (Object)currentClass)) {
            final ReentrantLock reentrantLock = ParcelGuard.parcelLook;
            reentrantLock.lock();
            try {
                final int n = 0;
                throw new RuntimeException("Parcel Series is broken " + loadedClass + " != " + currentClass + ", maybe an issue in " + ParcelGuard.info.get(Thread.currentThread()));
            }
            finally {
                reentrantLock.unlock();
            }
        }
        final ReentrantLock reentrantLock2 = ParcelGuard.parcelLook;
        reentrantLock2.lock();
        try {
            final int n2 = 0;
            final Map<Thread, Class<?>> info = ParcelGuard.info;
            final Thread currentThread = Thread.currentThread();
            Intrinsics.checkNotNullExpressionValue((Object)currentThread, "currentThread()");
            info.put(currentThread, currentClass);
            final Unit instance = Unit.INSTANCE;
        }
        finally {
            reentrantLock2.unlock();
        }
    }
    
    static {
        INSTANCE = new ParcelGuard();
        parcelLook = new ReentrantLock();
        info = new LinkedHashMap<Thread, Class<?>>();
    }
}
