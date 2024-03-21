package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class MobileTest {

    private mobile Mobile;

    @Before
    public void setUp() {
        // Initialize a Mobile object for testing
        Mobile = new mobile();
        Mobile.setBname("Samsung");
        Mobile.setCname("Electronics");
        Mobile.setPname("Galaxy S21");
        Mobile.setPprice(1000);
        Mobile.setPquantity(3);
        Mobile.setPimage("s21.jpg");
    }

    @Test
    public void testGetBname() {
        assertEquals("Samsung", Mobile.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", Mobile.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Galaxy S21", Mobile.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(1000, Mobile.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(3, Mobile.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("s21.jpg", Mobile.getPimage());
    }
}
