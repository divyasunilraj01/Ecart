package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class watchTest {

    private watch Watch;

    @Before
    public void setUp() {
        // Initialize a Watch object for testing
        Watch = new watch();
        Watch.setBname("Casio");
        Watch.setCname("Accessories");
        Watch.setPname("Analog Wristwatch");
        Watch.setPprice(100);
        Watch.setPquantity(10);
        Watch.setPimage("watch.jpg");
    }

    @Test
    public void testGetBname() {
        assertEquals("Casio", Watch.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Accessories", Watch.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Analog Wristwatch", Watch.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(100, Watch.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(10, Watch.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("watch.jpg", Watch.getPimage());
    }
}
