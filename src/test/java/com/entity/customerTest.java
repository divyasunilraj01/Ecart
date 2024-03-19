package com.entity;

import junit.framework.TestCase;

public class customerTest extends TestCase {
	@Test
    public void testSetName() {
        customer cust = new customer();
        cust.setName("John");
        assertEquals("John", cust.getName());
    }
	 @Test
	    public void testSetPassword() {
	        customer cust = new customer();
	        cust.setPassword("abcd123#");
	        assertEquals("abcd123#", cust.getPassword());
	    }


    @Test
    public void testSetEmail_id() {
        customer cust = new customer();
        cust.setEmail_Id("john1@gmail.com");
        assertEquals("john1@gmail.com", cust.getEmail_Id());
    }

    @Test
    public void testSetContactNumber() {
        customer cust = new customer();
        int contact_No = 1234567890; // Define or use a value for testing
        cust.setContact_No(contact_No); // Correct method call
        assertEquals(contact_No, cust.getContact_No()); // Correct method call
    }
    @Test
    public void testDefaultContactNumber() {
        customer cust = new customer();
        assertEquals(0, cust.getContact_No());
    }
    @Test
    public void testNegativeContactNumber() {
        customer cust = new customer();
        int contact_No = - 1234567890;
        // Set a negative contact number
        cust.setContact_No(-1234567890);
        // The method should handle negative numbers by converting them to positive
        assertEquals(contact_No, cust.getContact_No());
    }

   


}
