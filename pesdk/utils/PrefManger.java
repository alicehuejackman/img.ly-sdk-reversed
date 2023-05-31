// 
// Decompiled by Procyon v0.5.36
// 

package ly.img.android.pesdk.utils;

import androidx.annotation.Nullable;
import java.util.Set;
import androidx.annotation.NonNull;
import ly.img.android.PESDK;
import android.content.SharedPreferences;

public class PrefManger<T>
{
    private static final String PREFERENCES_NAME = "imgLyPreferences";
    private static SharedPreferences preferences;
    
    private PrefManger() {
        if (PrefManger.preferences == null) {
            PrefManger.preferences = PESDK.getAppContext().getSharedPreferences("imgLyPreferences", 0);
        }
    }
    
    @NonNull
    private T get(@NonNull final PropertyConfig property) {
        Object result = null;
        switch (property.type) {
            case BOOLEAN: {
                result = PrefManger.preferences.getBoolean(property.name, (boolean)property.value);
                break;
            }
            case INTEGER: {
                result = PrefManger.preferences.getInt(property.name, (int)property.value);
                break;
            }
            case LONG: {
                result = PrefManger.preferences.getLong(property.name, (long)property.value);
                break;
            }
            case FLOAT: {
                result = PrefManger.preferences.getFloat(property.name, (float)property.value);
                break;
            }
            case STRING: {
                result = PrefManger.preferences.getString(property.name, (String)property.value);
                break;
            }
            case STRING_SET: {
                result = PrefManger.preferences.getStringSet(property.name, (Set)property.value);
                break;
            }
            case ENUM: {
                result = PrefManger.preferences.getString(property.name, ((Enum)property.value).name());
                break;
            }
            default: {
                throw new RuntimeException("Unsupported Type");
            }
        }
        return (T)result;
    }
    
    private void set(@NonNull final PropertyConfig property, @Nullable final Enum value) {
        PrefManger.preferences.edit().putString(property.name, (value != null) ? value.name() : "").apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final int value) {
        PrefManger.preferences.edit().putInt(property.name, value).apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final float value) {
        PrefManger.preferences.edit().putFloat(property.name, value).apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final long value) {
        PrefManger.preferences.edit().putLong(property.name, value).apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final boolean value) {
        PrefManger.preferences.edit().putBoolean(property.name, value).apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final String value) {
        PrefManger.preferences.edit().putString(property.name, value).apply();
    }
    
    private void set(@NonNull final PropertyConfig property, final Set<String> value) {
        PrefManger.preferences.edit().putStringSet(property.name, (Set)value).apply();
    }
    
    private enum TYPE
    {
        BOOLEAN, 
        INTEGER, 
        LONG, 
        FLOAT, 
        STRING, 
        STRING_SET, 
        ENUM;
        
        private static /* synthetic */ TYPE[] $values() {
            return new TYPE[] { TYPE.BOOLEAN, TYPE.INTEGER, TYPE.LONG, TYPE.FLOAT, TYPE.STRING, TYPE.STRING_SET, TYPE.ENUM };
        }
        
        static {
            $VALUES = $values();
        }
    }
    
    public static class PropertyConfig
    {
        final String name;
        final Object value;
        TYPE type;
        
        public PropertyConfig(final String name, final Object value) {
            this.name = name;
            this.value = value;
            if (value instanceof Boolean) {
                this.type = TYPE.BOOLEAN;
            }
            else if (value instanceof Integer) {
                this.type = TYPE.INTEGER;
            }
            else if (value instanceof Long) {
                this.type = TYPE.LONG;
            }
            else if (value instanceof Float) {
                this.type = TYPE.FLOAT;
            }
            else if (value instanceof Enum) {
                this.type = TYPE.ENUM;
            }
            else if (value instanceof String) {
                this.type = TYPE.STRING;
            }
            else {
                if (!(value instanceof Set)) {
                    throw new RuntimeException("ValueType is not Supported");
                }
                this.type = TYPE.STRING_SET;
            }
        }
    }
    
    public abstract static class Config<K extends TYPE_PROPERTY>
    {
        public static class IntegerPref extends TypePreference<Integer>
        {
            public IntegerPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public IntegerPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.INTEGER);
            }
            
            public void set(final int value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            public int get() {
                return (int)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        public static class StringPref extends TypePreference<String>
        {
            public StringPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public StringPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.STRING);
            }
            
            public void set(final String value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            @NonNull
            public String get() {
                return (String)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        public static class FloatPref extends TypePreference<Float>
        {
            public FloatPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public FloatPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.FLOAT);
            }
            
            public void set(final float value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            public float get() {
                return (float)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        public static class LongPref extends TypePreference<Long>
        {
            public LongPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public LongPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.LONG);
            }
            
            public void set(final long value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            public long get() {
                return (long)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        public static class BooleanPref extends TypePreference<Boolean>
        {
            public BooleanPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public BooleanPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.BOOLEAN);
            }
            
            public synchronized void set(final boolean value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            public synchronized boolean get() {
                return (boolean)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        public static class EnumPref<T extends Enum> extends TypePreference<String>
        {
            public EnumPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public EnumPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.ENUM);
            }
            
            public void set(final T value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            @NonNull
            public T get() {
                final Class<Enum> c = (Class<Enum>)this.config.value.getClass();
                try {
                    return Enum.valueOf((Class<T>)c, (String)((PrefManger<Object>)this.manger).get(this.config));
                }
                catch (IllegalArgumentException ignored) {
                    return (T)this.config.value;
                }
            }
        }
        
        public static class StringSetPref extends TypePreference<Set<String>>
        {
            public StringSetPref(@NonNull final TYPE_PROPERTY property) {
                this(property.getConfig());
            }
            
            public StringSetPref(@NonNull final PropertyConfig property) {
                super(property, TYPE.STRING_SET);
            }
            
            public void set(final Set<String> value) {
                ((PrefManger<Object>)this.manger).set(this.config, value);
            }
            
            @NonNull
            public Set<String> get() {
                return (Set<String>)((PrefManger<Object>)this.manger).get(this.config);
            }
        }
        
        private abstract static class TypePreference<T>
        {
            @NonNull
            protected final PropertyConfig config;
            protected PrefManger<T> manger;
            
            public TypePreference(@NonNull final PropertyConfig config, final TYPE matchType) {
                this.config = config;
                if (config.type != matchType) {
                    throw new RuntimeException("Wrong Property Type: " + config.name + " is " + config.type);
                }
                this.manger = new PrefManger<T>(null);
            }
        }
    }
    
    public interface TYPE_PROPERTY
    {
        PropertyConfig getConfig();
    }
}
