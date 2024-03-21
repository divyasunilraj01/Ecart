package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrderDetailsTest {

    private order_details orderDetails;

    @Before
    public void setUp() {
        // Initialize an OrderDetails object for testing
        orderDetails = new order_details();
        orderDetails.setDate("2024-03-20");
        orderDetails.setName("John Doe");
        orderDetails.setBname("Electronics Store");
        orderDetails.setCname("Electronics");
        orderDetails.setPname("Smartphone");
        orderDetails.setPprice(800);
        orderDetails.setPquantity(2);
        orderDetails.setPimage("phone.jpg");
    }

    @Test
    public void testGetDate() {
        assertEquals("2024-03-20", orderDetails.getDate());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", orderDetails.getName());
    }

    @Test
    public void testGetBname() {
        assertEquals("Electronics Store", orderDetails.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Electronics", orderDetails.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Smartphone", orderDetails.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(800, orderDetails.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(2, orderDetails.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("phone.jpg", orderDetails.getPimage());
    }
}
