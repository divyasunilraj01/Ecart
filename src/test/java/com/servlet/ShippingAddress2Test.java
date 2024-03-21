package com.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

public class ShippingAddress2Test {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoPostCash() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("CName")).thenReturn("John");
        when(request.getParameter("City")).thenReturn("New York");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("CusName")).thenReturn("Customer");
        when(request.getParameter("cash")).thenReturn("cash");
        when(request.getParameter("online")).thenReturn(null);

        // Creating servlet instance
        ShippingAddress2 servlet = new ShippingAddress2();

        // Calling doPost method
        servlet.doPost(request, response);

        // Verifying the behavior
        verify(response).sendRedirect("confirmpayment.jsp?CName=John&City=New%20York&Total=100&CusName=Customer");
    }

    @Test
    public void testDoPostOnline() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("CName")).thenReturn("John");
        when(request.getParameter("City")).thenReturn("New York");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("CusName")).thenReturn("Customer");
        when(request.getParameter("cash")).thenReturn(null);
        when(request.getParameter("online")).thenReturn("online");

        // Creating servlet instance
        ShippingAddress2 servlet = new ShippingAddress2();

        // Calling doPost method
        servlet.doPost(request, response);

        // Verifying the behavior
        verify(response).sendRedirect("confirmonline.jsp?CName=John&City=New%20York&Total=100&CusName=Customer");
    }
}
