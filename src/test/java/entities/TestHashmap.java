package entities;

import org.junit.Test;

import java.util.HashMap;
import java.util.regex.Pattern;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by dsanchez on 12/2/17.
 */
public class TestHashmap {
    @Test
    public void testEquality() {
        HashMap<String, Object> a = new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", "a");
        }};

        HashMap<String, Object> b =new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", "a");
        }};

        assertEquals(a,b);
    }

    @Test
    public void testEquality_2() {
        HashMap<String, Object> a = new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", ".");
        }};

        HashMap<String, Object> b =new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", ".");
        }};

        assertEquals(a,b);
    }

    @Test
    public void testNotEquals() {
        HashMap<String, Object> a = new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", "a");
        }};

        HashMap<String, Object> b =new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", "b");
        }};

        assertFalse(a.equals(b));
    }

    @Test
    public void testReplaceValueAndBecameEquals() {
        HashMap<String, Object> a = new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", "*");
        }};

        HashMap<String, Object> expected = new HashMap<String, Object>(){{
            put("key1", 1);
            put("key2", ".");
        }};


        a.put("key2", ".");
        assertEquals(expected, a);
    }

    @Test

    public void testPattern() {
        assertFalse(Pattern.compile(".").equals(Pattern.compile(".")));
    }

}
