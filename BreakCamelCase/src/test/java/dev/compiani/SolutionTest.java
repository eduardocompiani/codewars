package dev.compiani;

import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SolutionTest {
    @Test
    public void testSingleBreak() {
        assertEquals("camel Casing", Solution.camelCase("camelCasing"));
    }

    @Test
    public void testMultipleBreak() {
        assertEquals("camel Casing Test", Solution.camelCase("camelCasingTest"));
    }

    @Test
    public void testInvalid() {
        assertEquals("camelcasingtest", Solution.camelCase("camelcasingtest"));
    }
}
