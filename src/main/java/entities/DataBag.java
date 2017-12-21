package entities;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by dsanchez on 12/2/17.
 */
public class DataBag {String
    private Map<, Object> keyValues;

    public DataBag( Map<String,Object> keyValues) {

        this.keyValues = keyValues;
    }

    public DataBag() {

        this.keyValues = new HashMap<>();
    }

    public void replaceValueWith(Object value, Object newValue) {
        for( Map.Entry<String, Object> entry : this.keyValues.entrySet() ) {
            if ( this.keyValues.get( entry.getKey() ).equals(value) ) {
                this.keyValues.put( entry.getKey(), newValue);
            }
        }

    }

    public <T> T get(Object key) {

        return (T)this.keyValues.get(key);
    }

    public <T> List<T> getList(Object key) {
        return get(key);
    }

    public void put(Object key, Object value) {

        this.keyValues.put(key.toString(), value);
    }

    public DataBag pick(Object ... keys) {

        return this.copyKeys(keys);
    }

    private DataBag copyKeys(Object ... keys) {
        DataBag result = new DataBag();

        for( Object k : keys) {
            result.put(k, this.get(k));
        }

        return result;
    }

    public boolean equals(Object another) {
        if ( !another.getClass().equals(this.getClass())) {
            return false;
        }

        DataBag casted = (DataBag)another;

        return this.keyValues.equals( casted.keyValues );
    }

    public String toString() {
        return this.keyValues.toString();
    }

    public DataBag merge(DataBag source) {
        for( String k : source.keyValues.keySet() ) {
            this.keyValues.put(k, source.keyValues.get(k));
        }

        return this;
    }

    public final Map<String, Object> asMap() {
        return this.keyValues;
    }
}
