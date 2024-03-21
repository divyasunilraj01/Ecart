package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ContactUsTest {

    private contactus ContactUs;

    @Before
    public void setUp() {
        // Initialize a ContactUs object for testing
        ContactUs = new contactus();
        ContactUs.setId(1);
        ContactUs.setName("John Doe");
        ContactUs.setEmail_Id("john@example.com");
        ContactUs.setContact_No(1234567890);
        ContactUs.setMessage("Hello, I have a query.");
    }

    @Test
    public void testGetId() {
        assertEquals(1, ContactUs.getId());
    }

    @Test
    public void testGetName() {
        assertEquals("John Doe", ContactUs.getName());
    }

    @Test
    public void testGetEmail_Id() {
        assertEquals("john@example.com", ContactUs.getEmail_Id());
    }

    @Test
    public void testGetContact_No() {
        assertEquals(1234567890, ContactUs.getContact_No());
    }

    @Test
    public void testGetMessage() {
        assertEquals("Hello, I have a query.", ContactUs.getMessage());
    }
}
