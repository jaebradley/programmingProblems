package problems.impl;

import org.junit.Test;

import static org.junit.Assert.*;

public class HexadecimalPerfectSquareSplitterTest {

    @Test
    public void shouldReturn1For896bb1() {
        assertEquals(1, HexadecimalPerfectSquareSplitter.getMin("896bb1"));
    }

    @Test
    public void shouldReturn3For1a919() {
        assertEquals(3, HexadecimalPerfectSquareSplitter.getMin("1a919"));
    }

    @Test
    public void shouldReturnNegative1For00002() {
        assertEquals(-1, HexadecimalPerfectSquareSplitter.getMin("00002"));
    }
}