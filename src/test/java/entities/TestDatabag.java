package entities;

import org.junit.Test;

import java.util.HashMap;

import static junit.framework.Assert.assertFalse;
import static junit.framework.TestCase.assertEquals;

/**
 * Created by dsanchez on 12/2/17.
 */
public class TestDatabag {

    @Test
    public void testEquality() {
        DataBag a = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "a");
                }}
        );
        DataBag b = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "a");
                }}
        );

        assertEquals(a,b);
    }

    @Test
    public void testNotEqual() {
        DataBag a = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "*");
                }}
        );
        DataBag b = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", ".");
                }}
        );

        assertFalse(a.equals(b));
    }

    @Test
    public void testReplaceValueWithNewOne() {
        DataBag original = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "*");
                }}
        );
        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", ".");
                }}
        );

        original.replaceValueWith("*", ".");

        assertEquals(expected, original);

    }

    @Test
    public void testReplaceEveryValueWithNewOne() {
        DataBag original = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "*");
                    put("key3", 1);
                }}
        );
        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 2);
                    put("key2", "*");
                    put("key3", 2);
                }}
        );

        original.replaceValueWith(1, 2);

        assertEquals(expected, original);

    }

    @Test
    public void testPickProperties() {
        DataBag source = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "*");
                    put("key3", 1);
                }}
        );

        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key3", 1);
                }}
        );

        DataBag actual = source.pick("key1", "key3");

        assertEquals(expected, actual);


    }

    @Test
    public void testMergeTwoDataBag() {
        DataBag source = new DataBag(
            new HashMap<String, Object>(){{
                put("key1", 1);
                put("key2", "*");
            }}
        );

        DataBag destination = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "abc");
                    put("key3", 9);
                }}
        );

        DataBag expected = new DataBag(
                new HashMap<String, Object>(){{
                    put("key1", 1);
                    put("key2", "*");
                    put("key3", 9);
                }}
        );

        destination.merge( source );
        assertEquals(expected, destination);

    }
}
