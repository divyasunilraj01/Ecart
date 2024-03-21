package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ProductTest {

    private Product product;

    @Before
    public void setUp() {
        // Initialize a Product object for testing
        product = new Product();
        product.setPid(1);
        product.setPname("Smartphone");
        product.setPprice(800);
        product.setPquantity(5);
        product.setPimage("phone.jpg");
        product.setBid(101);
        product.setCid(201);
    }

    @Test
    public void testGetPid() {
        assertEquals(1, product.getPid());
    }

    @Test
    public void testGetPname() {
        assertEquals("Smartphone", product.getPname());
    }

    @Test
    public void testGetPprice() {
        assertEquals(800, product.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(5, product.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("phone.jpg", product.getPimage());
    }

    @Test
    public void testGetBid() {
        assertEquals(101, product.getBid());
    }

    @Test
    public void testGetCid() {
        assertEquals(201, product.getCid());
    }
}
