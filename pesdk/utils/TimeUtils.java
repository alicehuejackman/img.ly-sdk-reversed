// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import ly.img.android.R$string;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.pesdk.kotlin_extension.TypeExtensionsKt;
import ly.img.android.PESDK;
import androidx.annotation.StringRes;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import java.text.DecimalFormat;
import kotlin.jvm.JvmOverloads;
import kotlin.jvm.JvmStatic;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import java.util.ArrayList;
import org.jetbrains.annotations.Nullable;
import kotlin.jvm.internal.Intrinsics;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\b\u00c6\u0002\u0018\u00002\u00020\u0001:\u0001\u0012B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000eH\u0007J\u000e\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011R\u001b\u0010\u0003\u001a\u00020\u00048BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0007\u0010\b\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0013" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils;", "", "()V", "decimalFormatter", "Ljava/text/DecimalFormat;", "getDecimalFormatter", "()Ljava/text/DecimalFormat;", "decimalFormatter$delegate", "Lkotlin/Lazy;", "convertDurationInText", "", "duration", "", "unit", "Ljava/util/concurrent/TimeUnit;", "decimalToString", "value", "", "TimeUnitConverter", "pesdk-backend-core_release" })
public final class TimeUtils
{
    @NotNull
    public static final TimeUtils INSTANCE;
    @NotNull
    private static final Lazy decimalFormatter$delegate;
    
    private TimeUtils() {
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String convertDurationInText(final long duration, @NotNull final TimeUnit unit) {
        Intrinsics.checkNotNullParameter((Object)unit, "unit");
        long rest = TimeUtilsKt.convert(duration, unit, TimeUnit.NANOSECONDS);
        final ArrayList parts = new ArrayList();
        final TimeUnitConverter[] values = TimeUnitConverter.values();
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00005\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\u008a\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\"\u0010\u0011\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001¢\u0006\u0002\u0010\u0012J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0016\u001a\u00020\u0017H\u00d6\u0001J\t\u0010\u0018\u001a\u00020\u0019H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\n8F¢\u0006\u0006\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e¨\u0006\u001a" }, d2 = { "ly/img/android/pesdk/utils/TimeUtils$convertDurationInText$Part", "", "converter", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "value", "", "(Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;J)V", "getConverter", "()Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "getValue", "()J", "component1", "component2", "copy", "(Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;J)Lly/img/android/pesdk/utils/TimeUtils$convertDurationInText$Part;", "equals", "", "other", "hashCode", "", "toString", "", "pesdk-backend-core_release" })
        public static final class Part
        {
            @NotNull
            private final TimeUnitConverter converter;
            private final long value;
            
            public Part(@NotNull final TimeUnitConverter converter, final long value) {
                Intrinsics.checkNotNullParameter((Object)converter, "converter");
                this.converter = converter;
                this.value = value;
            }
            
            @NotNull
            public final TimeUnitConverter getConverter() {
                return this.converter;
            }
            
            public final long getValue() {
                return this.value;
            }
            
            @NotNull
            public final TimeUnit getTimeUnit() {
                return this.converter.getTimeUnit();
            }
            
            @NotNull
            public final TimeUnitConverter component1() {
                return this.converter;
            }
            
            public final long component2() {
                return this.value;
            }
            
            @NotNull
            public final Part copy(@NotNull final TimeUnitConverter converter, final long value) {
                Intrinsics.checkNotNullParameter((Object)converter, "converter");
                return new Part(converter, value);
            }
            
            @NotNull
            @Override
            public String toString() {
                return "Part(converter=" + this.converter + ", value=" + this.value + ')';
            }
            
            @Override
            public int hashCode() {
                int result = this.converter.hashCode();
                result = result * 31 + Long.hashCode(this.value);
                return result;
            }
            
            @Override
            public boolean equals(@Nullable final Object other) {
                if (this == other) {
                    return true;
                }
                if (!(other instanceof Part)) {
                    return false;
                }
                final Part part = (Part)other;
                return this.converter == part.converter && this.value == part.value;
            }
        }
        for (int i = 0; i < values.length; ++i) {
            final TimeUnitConverter partUnit = values[i];
            final long fillUnitsCount = TimeUtilsKt.convert(rest, TimeUnit.NANOSECONDS, partUnit.getTimeUnit());
            if (fillUnitsCount > 0L) {
                rest -= TimeUtilsKt.convert(fillUnitsCount, partUnit.getTimeUnit(), TimeUnit.NANOSECONDS);
                parts.add(new TimeUtils$convertDurationInText.Part(partUnit, fillUnitsCount));
            }
        }
        String stringWithUnit;
        if (parts.size() == 0) {
            stringWithUnit = TimeUnitConverter.SECONDS.asStringWithUnit(0L);
        }
        else if (parts.size() == 1) {
            final TimeUtils$convertDurationInText.Part value = parts.get(0);
            Intrinsics.checkNotNullExpressionValue((Object)value, "parts[0]");
            final TimeUtils$convertDurationInText.Part part = value;
            final TimeUnitConverter converter = part.getConverter();
            stringWithUnit = (converter.presentationCanBeHigher(part.getValue()) ? converter.getHigherRepresentation().asStringWithUnit(part.getValue(), converter.getTimeUnit()) : converter.asStringWithUnit(part.getValue()));
        }
        else {
            stringWithUnit = ((parts.size() == 2 && parts.get(1).getConverter().getHigherRepresentation() == parts.get(0).getConverter() && parts.get(1).getConverter().presentationCanBeHigher(parts.get(1).getValue())) ? parts.get(0).getConverter().asStringWithUnit(parts.get(1).getValue() + TimeUtilsKt.convert(parts.get(0).getValue(), parts.get(0).getTimeUnit(), parts.get(1).getTimeUnit()), parts.get(1).getTimeUnit()) : CollectionsKt.joinToString$default((Iterable)parts, (CharSequence)" ", (CharSequence)null, (CharSequence)null, 0, (CharSequence)null, (Function1)TimeUtils$convertDurationInText.TimeUtils$convertDurationInText$1.INSTANCE, 30, (Object)null));
        }
        return stringWithUnit;
    }
    
    public static /* synthetic */ String convertDurationInText$default(final long duration, TimeUnit nanoseconds, final int n, final Object o) {
        if ((n & 0x2) != 0x0) {
            nanoseconds = TimeUnit.NANOSECONDS;
        }
        return convertDurationInText(duration, nanoseconds);
    }
    
    private final DecimalFormat getDecimalFormatter() {
        return (DecimalFormat)TimeUtils.decimalFormatter$delegate.getValue();
    }
    
    @NotNull
    public final String decimalToString(final double value) {
        return this.getDecimalFormatter().format(value).toString();
    }
    
    @JvmStatic
    @JvmOverloads
    @NotNull
    public static final String convertDurationInText(final long duration) {
        return convertDurationInText$default(duration, null, 2, null);
    }
    
    static {
        INSTANCE = new TimeUtils();
        decimalFormatter$delegate = LazyKt.lazy((Function0)TimeUtils$decimalFormatter.TimeUtils$decimalFormatter$2.INSTANCE);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0082\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u000f\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u0011J\u0016\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u0003J\u0006\u0010\u0013\u001a\u00020\u0000J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0010\u001a\u00020\u0011H&R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006R\u0011\u0010\u0007\u001a\u00020\b8F¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u00020\f8gX¦\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000ej\u0002\b\u0016j\u0002\b\u0017j\u0002\b\u0018j\u0002\b\u0019j\u0002\b\u001aj\u0002\b\u001b¨\u0006\u001c" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "", "timeUnit", "Ljava/util/concurrent/TimeUnit;", "(Ljava/lang/String;ILjava/util/concurrent/TimeUnit;)V", "getTimeUnit", "()Ljava/util/concurrent/TimeUnit;", "unit", "", "getUnit", "()Ljava/lang/String;", "unitRes", "", "getUnitRes", "()I", "asStringWithUnit", "count", "", "countUnit", "getHigherRepresentation", "presentationCanBeHigher", "", "HOURS", "MINUTES", "SECONDS", "MILLISECONDS", "MICROSECONDS", "NANOSECONDS", "pesdk-backend-core_release" })
    private enum TimeUnitConverter
    {
        @NotNull
        private final TimeUnit timeUnit;
        
        HOURS, 
        MINUTES, 
        SECONDS, 
        MILLISECONDS, 
        MICROSECONDS, 
        NANOSECONDS;
        
        private TimeUnitConverter(final TimeUnit timeUnit) {
            this.timeUnit = timeUnit;
        }
        
        @NotNull
        public final TimeUnit getTimeUnit() {
            return this.timeUnit;
        }
        
        @StringRes
        public abstract int getUnitRes();
        
        public abstract boolean presentationCanBeHigher(final long p0);
        
        @NotNull
        public final String getUnit() {
            final String string = PESDK.getAppResource().getString(this.getUnitRes());
            Intrinsics.checkNotNullExpressionValue((Object)string, "getAppResource().getString(unitRes)");
            return string;
        }
        
        @NotNull
        public final String asStringWithUnit(final long count) {
            return count + this.getUnit();
        }
        
        @NotNull
        public final String asStringWithUnit(final long count, @NotNull final TimeUnit countUnit) {
            Intrinsics.checkNotNullParameter((Object)countUnit, "countUnit");
            final long divider = TypeExtensionsKt.butMin(TimeUtilsKt.convert(1, this.timeUnit, countUnit), 1L);
            return (count % divider == 0L) ? (count / divider + this.getUnit()) : (TimeUtils.INSTANCE.decimalToString(count / (double)divider) + this.getUnit());
        }
        
        @NotNull
        public final TimeUnitConverter getHigherRepresentation() {
            return (this == TimeUnitConverter.HOURS) ? TimeUnitConverter.HOURS : values()[this.ordinal() - 1];
        }
        
        private static final /* synthetic */ TimeUnitConverter[] $values() {
            return new TimeUnitConverter[] { TimeUnitConverter.HOURS, TimeUnitConverter.MINUTES, TimeUnitConverter.SECONDS, TimeUnitConverter.MILLISECONDS, TimeUnitConverter.MICROSECONDS, TimeUnitConverter.NANOSECONDS };
        }
        
        static {
            $VALUES = $values();
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$HOURS;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class HOURS extends TimeUnitConverter
        {
            private final int unitRes;
            
            HOURS(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.HOURS, null);
                this.unitRes = R$string.imgly_hour_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return false;
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$MINUTES;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class MINUTES extends TimeUnitConverter
        {
            private final int unitRes;
            
            MINUTES(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.MINUTES, null);
                this.unitRes = R$string.imgly_minute_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return count % 15 == 0L;
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$SECONDS;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class SECONDS extends TimeUnitConverter
        {
            private final int unitRes;
            
            SECONDS(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.SECONDS, null);
                this.unitRes = R$string.imgly_second_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return count % 15 == 0L;
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$MILLISECONDS;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class MILLISECONDS extends TimeUnitConverter
        {
            private final int unitRes;
            
            MILLISECONDS(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.MILLISECONDS, null);
                this.unitRes = R$string.imgly_millis_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return count % 250 == 0L;
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$MICROSECONDS;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class MICROSECONDS extends TimeUnitConverter
        {
            private final int unitRes;
            
            MICROSECONDS(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.MICROSECONDS, null);
                this.unitRes = R$string.imgly_micros_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return count % 250 == 0L;
            }
        }
        
        @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\b\u00c6\u0001\u0018\u00002\u00020\u0001J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH\u0016R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0004\u0010\u0005¨\u0006\n" }, d2 = { "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter$NANOSECONDS;", "Lly/img/android/pesdk/utils/TimeUtils$TimeUnitConverter;", "unitRes", "", "getUnitRes", "()I", "presentationCanBeHigher", "", "count", "", "pesdk-backend-core_release" })
        static final class NANOSECONDS extends TimeUnitConverter
        {
            private final int unitRes;
            
            NANOSECONDS(final String $enum$name, final int $enum$ordinal) {
                super($enum$name, $enum$ordinal, TimeUnit.NANOSECONDS, null);
                this.unitRes = R$string.imgly_nanos_unit;
            }
            
            @Override
            public int getUnitRes() {
                return this.unitRes;
            }
            
            @Override
            public boolean presentationCanBeHigher(final long count) {
                return count % 250 == 0L;
            }
        }
    }
}
