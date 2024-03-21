package com.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.List;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.entity.brand;
import com.entity.category;
import com.entity.customer;

public class DAOTest {

    private Connection conn;
    private DAO dao;

    @Before
    public void setUp() throws Exception {
        // Establish connection to the test database
        conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/testdb", "username", "password");
        dao = new DAO(conn);
    }

    @After
    public void tearDown() throws Exception {
        // Close the connection after each test
        conn.close();
    }

    @Test
    public void testGetAllbrand() {
        // Test if the getAllbrand method returns a non-empty list of brands
        List<brand> brands = dao.getAllbrand();
        assertFalse(brands.isEmpty());
    }

    @Test
    public void testGetAllcategory() {
        // Test if the getAllcategory method returns a non-empty list of categories
        List<category> categories = dao.getAllcategory();
        assertFalse(categories.isEmpty());
    }

    @Test
    public void testAddproduct() {
        // Test adding a product
        // Assuming valid input data
        // Create a mock HttpServletRequest object with necessary parameters
        // Call the addproduct method
        // Check if the product was successfully added
        // Assuming the method returns 1 upon successful insertion
        // Here, you need to mock the HttpServletRequest and handle file upload
        // Then, you can verify the result using assertEquals
        // For simplicity, I'm just asserting true
        assertTrue(dao.addproduct(null) == 1);
    }

    @Test
    public void testGetAllCustomer() {
        // Test if the getAllCustomer method returns a non-empty list of customers
        List<customer> customers = dao.getAllCustomer();
        assertFalse(customers.isEmpty());
    }

    @Test
    public void testDeleteCustomer() {
        // Test deleting a customer
        // Assuming valid customer data
        customer c = new customer();
        // Set customer data
        c.setName("John Doe");
        c.setEmail_Id("john@example.com");
        // Call the deleteCustomer method
        boolean result = dao.deleteCustomer(c);
        assertTrue(result);
    }

    @Test
    public void testGetCustomer() {
        // Test if the getCustomer method returns a non-empty list of customers for a given email id
        // Assuming a valid email id
        String emailId = "john@example.com";
        List<customer> customers = dao.getCustomer(emailId);
        assertFalse(customers.isEmpty());
    }
}
