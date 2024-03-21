package com.servlet;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.dao.DAO4;

public class payprocessTest {
    
    private payprocess servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        servlet = new payprocess();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoPost_WithValidDataAndEmptyCustomerName() throws Exception {
        // Mock request parameters
        when(request.getParameter("CName")).thenReturn("John Doe");
        when(request.getParameter("CusName")).thenReturn("empty");
        when(request.getParameter("City")).thenReturn("New York");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("N2")).thenReturn("Item1");
        
        // Mock DAO4 methods to return true
        DAO4 dao = mock(DAO4.class);
        when(dao.checkcart()).thenReturn(true);
        when(dao.addOrders(any())).thenReturn(1);
        when(dao.addOrder_details()).thenReturn(1);
        when(dao.deletecart()).thenReturn(1);
        when(dao.updateOrder_details(any())).thenReturn(1);
        
        // Invoke servlet doPost method
        servlet.doPost(request, response);
        
        // Verify redirection
        verify(response).sendRedirect("orders.jsp");
    }
    
    @Test
    public void testDoPost_WithValidDataAndNonEmptyCustomerName() throws Exception {
        // Mock request parameters
        when(request.getParameter("CName")).thenReturn("John Doe");
        when(request.getParameter("CusName")).thenReturn("nonempty");
        when(request.getParameter("City")).thenReturn("New York");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("N2")).thenReturn("Item1");
        
        // Mock DAO4 methods to return true
        DAO4 dao = mock(DAO4.class);
        when(dao.checkcart2(any())).thenReturn(true);
        when(dao.addOrders(any())).thenReturn(1);
        when(dao.addOrder_details2(any())).thenReturn(1);
        when(dao.deletecart2(any())).thenReturn(1);
        when(dao.updateOrder_details2(any())).thenReturn(1);
        
        // Invoke servlet doPost method
        servlet.doPost(request, response);
        
        // Verify redirection
        verify(response).sendRedirect("orders.jsp");
    }
}
