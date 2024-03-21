package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class tvTest {

    private tv Tv;

    @Before
    public void setUp() {
        // Initialize a TV object for testing
        Tv = new tv();
        Tv.setBname("Sony");
        Tv.setCname("Electronics");
        Tv.setPname("Smart LED TV");
        Tv.setPprice(1200);
        Tv.setPquantity(3);
        Tv.setPimage("tv.jpg");
    }

    @Test
    public void testGetBname() {
        assertEquals("Sony", Tv.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", Tv.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Smart LED TV", Tv.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(1200, Tv.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(3, Tv.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("tv.jpg", Tv.getPimage());
    }
}
