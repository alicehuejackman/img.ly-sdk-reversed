// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.audio;

import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.functions.Function1;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0017\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\n\n\u0002\b\u0004\b\u0000\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006RG\u0010\u0007\u001a8\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\u000b\u0012\u001f\u0012\u001d\u0012\u0013\u0012\u00110\u0005¢\u0006\f\b\t\u0012\b\b\n\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\r0\b0\b¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000f¨\u0006\u0011" }, d2 = { "Lly/img/android/pesdk/audio/PCMChannelConverter;", "", "channelBuffer", "", "channelCount", "", "([SI)V", "getDataMapper", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "outputCount", "outputChannel", "", "getGetDataMapper", "()Lkotlin/jvm/functions/Function1;", "Companion", "pesdk-backend-core_release" })
public final class PCMChannelConverter
{
    @NotNull
    public static final Companion Companion;
    @NotNull
    private final Function1<Integer, Function1<Integer, Short>> getDataMapper;
    public static final int LEFT = 0;
    public static final int RIGHT = 1;
    public static final int CENTER_C3 = 2;
    public static final int CENTER_C5 = 2;
    public static final int CENTER_C6 = 2;
    public static final int SUBWOOFER_C5 = 3;
    public static final int SUBWOOFER_C6 = 3;
    public static final int REAR_LEFT_C4 = 3;
    public static final int REAR_LEFT_C5 = 4;
    public static final int REAR_LEFT_C6 = 4;
    public static final int REAR_RIGHT_C4 = 4;
    public static final int REAR_RIGHT_C5 = 5;
    public static final int REAR_RIGHT_C6 = 5;
    public static final int REAR_CENTER_C6 = 6;
    
    public PCMChannelConverter(@NotNull final short[] channelBuffer, final int channelCount) {
        Intrinsics.checkNotNullParameter((Object)channelBuffer, "channelBuffer");
        Function1 getDataMapper = null;
        switch (channelCount) {
            case 1: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$1(channelBuffer);
                break;
            }
            case 2: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$2(channelBuffer);
                break;
            }
            case 3: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$3(channelBuffer);
                break;
            }
            case 4: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$4(channelBuffer);
                break;
            }
            case 5: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$5(channelBuffer);
                break;
            }
            default: {
                getDataMapper = (Function1)new PCMChannelConverter$getDataMapper.PCMChannelConverter$getDataMapper$6(channelBuffer, channelCount);
                break;
            }
        }
        this.getDataMapper = (Function1<Integer, Function1<Integer, Short>>)getDataMapper;
    }
    
    @NotNull
    public final Function1<Integer, Function1<Integer, Short>> getGetDataMapper() {
        return this.getDataMapper;
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0012" }, d2 = { "Lly/img/android/pesdk/audio/PCMChannelConverter$Companion;", "", "()V", "CENTER_C3", "", "CENTER_C5", "CENTER_C6", "LEFT", "REAR_CENTER_C6", "REAR_LEFT_C4", "REAR_LEFT_C5", "REAR_LEFT_C6", "REAR_RIGHT_C4", "REAR_RIGHT_C5", "REAR_RIGHT_C6", "RIGHT", "SUBWOOFER_C5", "SUBWOOFER_C6", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
    }
}
