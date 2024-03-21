package com.entity;

import junit.framework.TestCase;
import static org.junit.Assert.*;

public class CartTest extends TestCase {
	private cart Cart;

    @Before
    public void setUp() {
        // Initialize a Cart object for testing
        Cart = new cart();
        Cart.setName("John");
        Cart.setBname("Nike");
        Cart.setCname("Sports");
        Cart.setPname("Running Shoes");
        Cart.setPprice(100);
        Cart.setPquantity(2);
        Cart.setPimage("shoes.jpg");
    }
    @Test
    public void testGetName() {
        assertEquals("John", Cart.getName());
    }

    @Test
    public void testGetBname() {
        assertEquals("Nike", Cart.getBname());
    }

    @Test
    public void testGetCname() {
        assertEquals("Sports", Cart.getCname());
    }

    @Test
    public void testGetPname() {
        assertEquals("Running Shoes", Cart.getPname());
    }
    @Test
    public void testGetPprice() {
        assertEquals(100, Cart.getPprice());
    }

    @Test
    public void testGetPquantity() {
        assertEquals(2, Cart.getPquantity());
    }

    @Test
    public void testGetPimage() {
        assertEquals("shoes.jpg", Cart.getPimage());
    }

	

}
