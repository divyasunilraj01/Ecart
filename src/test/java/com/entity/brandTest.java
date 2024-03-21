package com.entity;
import junit.framework.TestCase;

public class brandTest extends TestCase {
	private brand Brand;

    @Before
    public void setUp() {
        // Initialize a Brand object for testing
        Brand = new brand();
        Brand.setBid(1);
        Brand.setBname("Nike");
    }

    @Test
    public void testGetBid() {
        assertEquals(1, Brand.getBid());
    }
    @Test
    public void testSetBid() {
        Brand.setBid(2);
        assertEquals(2, Brand.getBid());
    }

    @Test
    public void testGetBname() {
        assertEquals("Nike", Brand.getBname());
    }
    @Test
    public void testSetBname() {
        Brand.setBname("Adidas");
        assertEquals("Adidas", Brand.getBname());
    }
    
    
}
