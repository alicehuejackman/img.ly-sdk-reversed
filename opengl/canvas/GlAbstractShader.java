// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.opengl.canvas;

import java.lang.annotation.RetentionPolicy;
import kotlin.annotation.AnnotationRetention;
import kotlin.annotation.Retention;
import java.lang.annotation.Annotation;
import java.nio.charset.Charset;
import android.content.res.Resources;
import java.io.Closeable;
import kotlin.io.CloseableKt;
import java.io.InputStream;
import java.io.ByteArrayOutputStream;
import ly.img.android.PESDK;
import ly.img.android.opengl.EGLLogWrapper;
import android.util.Log;
import androidx.annotation.AnyRes;
import kotlin.jvm.JvmStatic;
import android.opengl.GLES20;
import androidx.annotation.CallSuper;
import kotlin.jvm.internal.Intrinsics;
import androidx.annotation.WorkerThread;
import java.io.IOException;
import kotlin.jvm.internal.DefaultConstructorMarker;
import ly.img.android.opengl.GlThreadRunner;
import androidx.annotation.XmlRes;
import org.jetbrains.annotations.NotNull;
import kotlin.Metadata;

@Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0002\b\u0005\b&\u0018\u0000 \u001b2\u00020\u0001:\u0002\u001b\u001cB\u0019\b\u0017\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005B\u0017\b\u0017\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0004J\b\u0010\u0019\u001a\u00020\u0018H\u0014J\u0010\u0010\u001a\u001a\u00020\u00072\u0006\u0010\u0006\u001a\u00020\u0007H\u0015R\u001a\u0010\t\u001a\u00020\u0003X\u0084\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR$\u0010\u000f\u001a\u00020\u00032\u0006\u0010\u000e\u001a\u00020\u00038F@FX\u0086\u000e¢\u0006\f\u001a\u0004\b\u0010\u0010\u000b\"\u0004\b\u0011\u0010\rR\u0013\u0010\u0006\u001a\u00020\u00078F¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0004\u001a\u00020\u0003X\u0084\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\u0014\u0010\u0015\u001a\u0004\b\u0016\u0010\u000b¨\u0006\u001d" }, d2 = { "Lly/img/android/opengl/canvas/GlAbstractShader;", "Lly/img/android/opengl/canvas/GlObject;", "sourceCodeResId", "", "type", "(II)V", "sourceCode", "", "(Ljava/lang/String;I)V", "_handle", "get_handle", "()I", "set_handle", "(I)V", "value", "handle", "getHandle", "setHandle", "getSourceCode", "()Ljava/lang/String;", "getType$annotations", "()V", "getType", "attach", "", "onRelease", "prepareSourceCode", "Companion", "TYPE", "pesdk-backend-core_release" })
public abstract class GlAbstractShader extends GlObject
{
    @NotNull
    public static final Companion Companion;
    private final int type;
    @NotNull
    private final String sourceCode;
    private int _handle;
    
    protected final int getType() {
        return this.type;
    }
    
    @NotNull
    public final String getSourceCode() {
        return this.prepareSourceCode(this.sourceCode);
    }
    
    protected final int get_handle() {
        return this._handle;
    }
    
    protected final void set_handle(final int <set-?>) {
        this._handle = <set-?>;
    }
    
    public final int getHandle() {
        this.attach();
        return this._handle;
    }
    
    public final void setHandle(final int value) {
        this._handle = value;
    }
    
    @WorkerThread
    public GlAbstractShader(@XmlRes final int sourceCodeResId, final int type) {
        super(null, 1, null);
        this._handle = -1;
        try {
            this.sourceCode = GlAbstractShader.Companion.getStringResource(sourceCodeResId);
        }
        catch (IOException e) {
            throw new RuntimeException("Can't read shader SourceCode from resource with id: '" + sourceCodeResId);
        }
        this.type = type;
    }
    
    @WorkerThread
    public GlAbstractShader(@NotNull final String sourceCode, final int type) {
        Intrinsics.checkNotNullParameter((Object)sourceCode, "sourceCode");
        super(null, 1, null);
        this._handle = -1;
        this.sourceCode = sourceCode;
        this.type = type;
    }
    
    protected final void attach() {
        if (this._handle == -1) {
            final Companion companion = GlAbstractShader.Companion;
            this._handle = generateShader(this.prepareSourceCode(this.getSourceCode()), this.type);
        }
    }
    
    @CallSuper
    @NotNull
    protected String prepareSourceCode(@NotNull final String sourceCode) {
        Intrinsics.checkNotNullParameter((Object)sourceCode, "sourceCode");
        return sourceCode;
    }
    
    @Override
    protected void onRelease() {
        if (this._handle != -1) {
            GLES20.glDeleteShader(this._handle);
            this._handle = -1;
        }
    }
    
    @JvmStatic
    protected static final int generateShader(@NotNull final String shader, final int type) {
        return GlAbstractShader.Companion.generateShader(shader, type);
    }
    
    @JvmStatic
    private static final byte[] getResource(@AnyRes final int id) throws IOException {
        return GlAbstractShader.Companion.getResource(id);
    }
    
    @JvmStatic
    @NotNull
    public static final String getStringResource(final int id) throws IOException {
        return GlAbstractShader.Companion.getStringResource(id);
    }
    
    static {
        Companion = new Companion(null);
    }
    
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u0004H\u0005J\u0012\u0010\b\u001a\u00020\t2\b\b\u0001\u0010\n\u001a\u00020\u0004H\u0003J\u0010\u0010\u000b\u001a\u00020\u00062\u0006\u0010\n\u001a\u00020\u0004H\u0007¨\u0006\f" }, d2 = { "Lly/img/android/opengl/canvas/GlAbstractShader$Companion;", "", "()V", "generateShader", "", "shader", "", "type", "getResource", "", "id", "getStringResource", "pesdk-backend-core_release" })
    public static final class Companion
    {
        private Companion() {
        }
        
        @JvmStatic
        protected final int generateShader(@NotNull final String shader, final int type) {
            Intrinsics.checkNotNullParameter((Object)shader, "shader");
            final int[] compiled = { 0 };
            final int it;
            final int n = it = GLES20.glCreateShader(type);
            final int n2 = 0;
            GLES20.glShaderSource(it, shader);
            GLES20.glCompileShader(it);
            GLES20.glGetShaderiv(it, 35713, compiled, 0);
            if (compiled[0] == 0) {
                Log.d("GlShader", " Shader compilation error \n" + GLES20.glGetShaderInfoLog(it) + '\n' + shader);
                return 0;
            }
            EGLLogWrapper.readGlError();
            return n;
        }
        
        @JvmStatic
        private final byte[] getResource(@AnyRes final int id) throws IOException {
            final Resources appResource = PESDK.getAppResource();
            Intrinsics.checkNotNullExpressionValue((Object)appResource, "getAppResource()");
            final Resources resources = appResource;
            final ByteArrayOutputStream bout = new ByteArrayOutputStream();
            final byte[] readBuffer = new byte[4096];
            final InputStream inputStream = resources.openRawResource(id);
            Throwable t = null;
            try {
                final InputStream stream = inputStream;
                final int n = 0;
                int read = 0;
                while (true) {
                    read = stream.read(readBuffer, 0, readBuffer.length);
                    if (read == -1) {
                        break;
                    }
                    bout.write(readBuffer, 0, read);
                }
                final byte[] byteArray = bout.toByteArray();
                Intrinsics.checkNotNullExpressionValue((Object)byteArray, "bout.toByteArray()");
                return byteArray;
            }
            catch (Throwable t2) {
                t = t2;
                throw t2;
            }
            finally {
                CloseableKt.closeFinally((Closeable)inputStream, t);
            }
        }
        
        @JvmStatic
        @NotNull
        public final String getStringResource(final int id) throws IOException {
            final byte[] resource = this.getResource(id);
            final Charset forName = Charset.forName("UTF-8");
            Intrinsics.checkNotNullExpressionValue((Object)forName, "forName(\"UTF-8\")");
            return new String(resource, forName);
        }
    }
    
    @Retention(AnnotationRetention.SOURCE)
    @java.lang.annotation.Retention(RetentionPolicy.SOURCE)
    @Metadata(mv = { 1, 6, 0 }, k = 1, xi = 48, d1 = { "\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u001b\n\u0000\b\u0083\u0002\u0018\u00002\u00020\u0001B\u0000¨\u0006\u0002" }, d2 = { "Lly/img/android/opengl/canvas/GlAbstractShader$TYPE;", "", "pesdk-backend-core_release" })
    private @interface TYPE {
    }
}
