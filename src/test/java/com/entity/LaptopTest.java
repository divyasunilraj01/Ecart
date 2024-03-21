package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class LaptopTest {

    private laptop Laptop;

    @Before
    public void setUp() {
        // Initialize a Laptop object for testing
        Laptop = new laptop();
        Laptop.setBname("Dell");
        Laptop.setCname("Electronics");
        Laptop.setPname("Inspiron 15");
        Laptop.setPprice(800);
        Laptop.setPquantity(5);
        Laptop.setPimage("laptop.jpg");
    }

    @Test
    public void testGetBname() {
        assertEquals("Dell", Laptop.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", Laptop.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Inspiron 15", Laptop.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(800, Laptop.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(5, Laptop.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("laptop.jpg", Laptop.getPimage());
    }
}
