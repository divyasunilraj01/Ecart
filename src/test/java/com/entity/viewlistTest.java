package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class viewlistTest {

    private viewlist viewList;

    @Before
    public void setUp() {
        // Initialize a ViewList object for testing
        viewList = new viewlist();
        viewList.setBname("Sony");
        viewList.setCname("Electronics");
        viewList.setPname("Smart TV");
        viewList.setPprice(1200);
        viewList.setPquantity(3);
        viewList.setPimage("tv.jpg");
    }

    @Test
    public void testGetBname() {
        assertEquals("Sony", viewList.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", viewList.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Smart TV", viewList.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(1200, viewList.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(3, viewList.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("tv.jpg", viewList.getPimage());
    }
}
