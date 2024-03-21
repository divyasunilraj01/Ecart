package com.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.dao.DAO2;

public class checkcustomerTest {
    
    private checkcustomer servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        servlet = new checkcustomer();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoPost_CustomerExists() throws Exception {
        // Mock request parameters
        when(request.getParameter("Email_Id")).thenReturn("customer@example.com");
        when(request.getParameter("Password")).thenReturn("password");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("CusName")).thenReturn("customerName");
        
        // Mock DAO and its method to return true
        DAO2 dao = mock(DAO2.class);
        when(dao.checkcust(any())).thenReturn(true);
        
        // Mock Cookie
        Cookie cookie = new Cookie("cname", "customer@example.com");
        
        // Invoke servlet doPost method
        servlet.doPost(request, response);
        
        // Verify that the DAO method was called
        verify(dao).checkcust(any());
        
        // Verify that the appropriate cookie was added
        verify(response).addCookie(cookie);
        
        // Verify redirection
        verify(response).sendRedirect("customerhome.jsp");
    }
    
    @Test
    public void testDoPost_CustomerDoesNotExist() throws Exception {
        // Mock request parameters
        when(request.getParameter("Email_Id")).thenReturn("nonexistent@example.com");
        when(request.getParameter("Password")).thenReturn("password");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("CusName")).thenReturn("customerName");
        
        // Mock DAO and its method to return false
        DAO2 dao = mock(DAO2.class);
        when(dao.checkcust(any())).thenReturn(false);
        
        // Mock Cookie
        Cookie cookie = new Cookie("un", "up");
        
        // Invoke servlet doPost method
        servlet.doPost(request, response);
        
        // Verify that the DAO method was called
        verify(dao).checkcust(any());
        
        // Verify that the appropriate cookie was added
        verify(response).addCookie(cookie);
        
        // Verify redirection
        verify(response).sendRedirect("customerlogin.jsp?Total=100&CusName=customerName");
    }
}
