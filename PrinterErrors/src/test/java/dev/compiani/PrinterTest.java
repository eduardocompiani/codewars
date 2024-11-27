package dev.compiani;

import org.junit.Test;

import static org.junit.Assert.*;

public class PrinterTest {
    @Test
    public void testWithoutErrors() {
        assertEquals("0/13", Printer.printerError("aaabbbbhaijjj"));
    }

    @Test
    public void testWithErrors() {
        assertEquals("3/56", Printer.printerError("aaaaaaaaaaaaaaaabbbbbbbbbbbbbbbbbbmmmmmmmmmmmmmmmmmmmxyz"));
    }
}