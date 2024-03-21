package com.servlet;

import static org.mockito.Mockito.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dao.DAO2;
import com.entity.cart;

public class removetable_cartTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGetRemoveCartNotNull() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("id")).thenReturn("someId");
        when(request.getParameter("ie")).thenReturn("someImage");

        // Mocking DAO2
        DAO2 daoMock = mock(DAO2.class);
        when(daoMock.removecart(any(cart.class))).thenReturn(1);
        
        // Creating servlet instance
        removetable_cart servlet = new removetable_cart();
        
        // Injecting mocked DAO2 into servlet
        servlet.setDAO2(daoMock);
        
        // Calling doGet method
        servlet.doGet(request, response);
        
        // Verifying the behavior
        verify(request).getParameter("id");
        verify(request).getParameter("ie");
        verify(daoMock).removecart(any(cart.class));
        verify(response).sendRedirect("table_cart.jsp");
    }

    @Test
    public void testDoGetRemoveCartNull() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("id")).thenReturn("null");
        when(request.getParameter("ie")).thenReturn("someImage");

        // Mocking DAO2
        DAO2 daoMock = mock(DAO2.class);
        when(daoMock.removecartnull(any(cart.class))).thenReturn(1);
        
        // Creating servlet instance
        removetable_cart servlet = new removetable_cart();
        
        // Injecting mocked DAO2 into servlet
        servlet.setDAO2(daoMock);
        
        // Calling doGet method
        servlet.doGet(request, response);
        
        // Verifying the behavior
        verify(request).getParameter("id");
        verify(request).getParameter("ie");
        verify(daoMock).removecartnull(any(cart.class));
        verify(response).sendRedirect("table_cart.jsp");
    }
}
