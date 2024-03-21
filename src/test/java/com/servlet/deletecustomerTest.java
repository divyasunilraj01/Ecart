package com.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.dao.DAO;

public class deletecustomerTest {
    
    private deletecustomer servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        servlet = new deletecustomer();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet_CustomerDeletedSuccessfully() throws Exception {
        // Mock request parameters
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        
        // Mock DAO and its method to return true
        DAO dao = mock(DAO.class);
        when(dao.deleteCustomer(any())).thenReturn(true);
        
        // Invoke servlet doGet method
        servlet.doGet(request, response);
        
        // Verify that the DAO method was called
        verify(dao).deleteCustomer(any());
        
        // Verify redirection
        verify(response).sendRedirect("managecustomers.jsp");
    }
    
    @Test
    public void testDoGet_CustomerDeletionFailed() throws Exception {
        // Mock request parameters
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        
        // Mock DAO and its method to return false
        DAO dao = mock(DAO.class);
        when(dao.deleteCustomer(any())).thenReturn(false);
        
        // Invoke servlet doGet method
        servlet.doGet(request, response);
        
        // Verify that the DAO method was called
        verify(dao).deleteCustomer(any());
        
        // Verify redirection
        verify(response).sendRedirect("managecustomers.jsp");
    }
}
