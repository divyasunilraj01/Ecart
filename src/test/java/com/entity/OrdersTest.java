package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class OrdersTest {

    private orders Orders;

    @Before
    public void setUp() {
        // Initialize an Orders object for testing
        Orders = new orders();
        Orders.setOrder_Id(1);
        Orders.setCustomer_Name("John Doe");
        Orders.setCustomer_City("New York");
        Orders.setDate("2024-03-20");
        Orders.setTotal_Price(1500);
        Orders.setStatus("Shipped");
    }

    @Test
    public void testGetOrder_Id() {
        assertEquals(1, Orders.getOrder_Id());
    }

    @Test
    public void testGetCustomer_Name() {
        assertEquals("John Doe", Orders.getCustomer_Name());
    }

    @Test
    public void testGetCustomer_City() {
        assertEquals("New York", Orders.getCustomer_City());
    }

    @Test
    public void testGetDate() {
        assertEquals("2024-03-20", Orders.getDate());
    }

    @Test
    public void testGetTotal_Price() {
        assertEquals(1500, Orders.getTotal_Price());
    }

    @Test
    public void testGetStatus() {
        assertEquals("Shipped", Orders.getStatus());
    }
}
