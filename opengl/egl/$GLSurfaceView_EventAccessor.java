// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.egl;

import ly.img.android.pesdk.backend.model.EventSetInterface;
import androidx.annotation.NonNull;
import java.util.Map;
import java.util.TreeMap;
import ly.img.android.pesdk.backend.model.EventAccessorInterface;

public class $GLSurfaceView_EventAccessor implements EventAccessorInterface
{
    private static final TreeMap<String, Call> synchronyCalls;
    private static final TreeMap<String, Call> mainThreadCalls;
    private static final TreeMap<String, Call> workerThreadCalls;
    private static Call initCall;
    
    @NonNull
    @Override
    public Map<String, Call> getSynchronyCalls() {
        return $GLSurfaceView_EventAccessor.synchronyCalls;
    }
    
    @NonNull
    @Override
    public Map<String, Call> getMainThreadCalls() {
        return $GLSurfaceView_EventAccessor.mainThreadCalls;
    }
    
    @NonNull
    @Override
    public Map<String, Call> getWorkerThreadCalls() {
        return $GLSurfaceView_EventAccessor.workerThreadCalls;
    }
    
    @NonNull
    @Override
    public Call getInitCall() {
        return $GLSurfaceView_EventAccessor.initCall;
    }
    
    static {
        final GLSurfaceView object;
        (synchronyCalls = new TreeMap<String, Call>()).put("EditorShowState.PAUSE", (caller, rawObject, isRevert) -> {
            object = rawObject;
            if (isRevert) {
                return;
            }
            else {
                object.onPauseEvent();
                return;
            }
        });
        final GLSurfaceView object2;
        $GLSurfaceView_EventAccessor.synchronyCalls.put("EditorShowState.RESUME", (caller, rawObject, isRevert) -> {
            object2 = rawObject;
            if (isRevert) {
                return;
            }
            else {
                object2.onResumeEvent();
                return;
            }
        });
        mainThreadCalls = new TreeMap<String, Call>();
        workerThreadCalls = new TreeMap<String, Call>();
        final GLSurfaceView object3;
        $GLSurfaceView_EventAccessor.initCall = ((caller, rawObject, isRevert) -> object3 = rawObject);
    }
}
