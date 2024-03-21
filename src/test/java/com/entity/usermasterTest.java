package com.entity;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class usermasterTest {

    private usermaster userMaster;

    @Before
    public void setUp() {
        // Initialize a UserMaster object for testing
        userMaster = new usermaster();
        userMaster.setName("JohnDoe");
        userMaster.setPassword("secure123");
    }

    @Test
    public void testGetName() {
        assertEquals("JohnDoe", userMaster.getName());
    }

    @Test
    public void testSetName() {
        userMaster.setName("JaneSmith");
        assertEquals("JaneSmith", userMaster.getName());
    }

    @Test
    public void testGetPassword() {
        assertEquals("secure123", userMaster.getPassword());
    }

    @Test
    public void testSetPassword() {
        userMaster.setPassword("newPassword");
        assertEquals("newPassword", userMaster.getPassword());
    }
}
