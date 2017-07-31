package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleHashMapTest {
    private String firstKey = "firstKey";
    private String firstValue = "firstValue";
    private String secondKey = "secondKey";
    private String secondValue = "secondValue";


    @Test
    public void itShouldInstantiate() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        assertNotNull(map);
        assertEquals(0, map.getSize());
        assertTrue(map.isEmpty());
    }

    @Test
    public void itShouldPutAValue() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(firstKey, firstValue);
        assertEquals(1, map.getSize());
        assertEquals(firstValue, map.get(firstKey));
    }

    @Test
    public void itShouldPutIdenticalKeys() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(firstKey, firstValue);
        map.put(firstKey, secondValue);
        assertEquals(1, map.getSize());
        assertEquals(secondValue, map.get(firstKey));
    }

    @Test
    public void itShouldPutMultipleValues() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(firstKey, firstValue);
        map.put(secondKey, secondValue);
        assertEquals(2, map.getSize());
        assertEquals(firstValue, map.get(firstKey));
        assertEquals(secondValue, map.get(secondKey));
    }

    @Test
    public void itShouldTestResizing() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
            assertEquals(i + 1, map.getSize());

            for (int j = 0; j <= i; j++) {
                assertEquals(Integer.valueOf(j), map.get(j));
            }
        }
    }

    @Test
    public void itShouldTestNullKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(null, firstValue);
        assertEquals(1, map.getSize());
        assertEquals(firstValue, map.get(null));
    }

    @Test
    public void itShouldTestContainsNonNullKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(firstKey, firstValue);
        assertTrue(map.containsKey(firstKey));
    }

    @Test
    public void itShouldTestContainsNullKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(null, firstValue);
        assertTrue(map.containsKey(null));
    }

    @Test
    public void itShouldTestRemovingNonNullKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(firstKey, firstValue);
        map.remove(firstKey);
        assertEquals(0, map.getSize());
    }

    @Test
    public void itShouldTestRemovingNullKey() {
        SimpleHashMap<String, String> map = new SimpleHashMap<>();
        map.put(null, firstValue);
        map.remove(null);
        assertEquals(0, map.getSize());
    }

    @Test
    public void itShouldTestRemoving() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (int i = 99; i >= 0; i--) {
            map.remove(i);
            assertEquals(i, map.getSize());
            assertFalse(map.containsKey(i));
        }
    }

    @Test
    public void itShouldTestContainsValue() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        for (int i = 0; i < 100; i++) {
            map.put(i, i);
        }

        for (int i = 0; i < 100; i++) {
            assertTrue(map.containsValue(i));
        }

        for (int i = 100; i < 200; i++) {
            assertFalse(map.containsValue(i));
        }
    }

    @Test
    public void itShouldTestContainsNullValue() {
        SimpleHashMap<Integer, Integer> map = new SimpleHashMap<>();
        map.put(101, null);
        assertTrue(map.containsValue(null));
    }
}