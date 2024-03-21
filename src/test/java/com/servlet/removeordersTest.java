package com.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dao.DAO2;
import com.entity.orders;

public class removeordersTest {
    
    @Mock
    HttpServletRequest request;
    
    @Mock
    HttpServletResponse response;
    
    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("id")).thenReturn("1");

        // Mocking DAO2
        DAO2 daoMock = mock(DAO2.class);
        when(daoMock.removeorders(new orders())).thenReturn(1);
        
        // Creating servlet instance
        removeorders servlet = new removeorders();
        
        // Injecting mocked DAO2 into servlet
        servlet.setDAO2(daoMock);
        
        // Calling doGet method
        servlet.doGet(request, response);
        
        // Verifying the behavior
        verify(request).getParameter("id");
        verify(daoMock).removeorders(new orders()); // verify that removeorders method is invoked with the correct argument
        verify(response).sendRedirect("orders.jsp");
    }
}
