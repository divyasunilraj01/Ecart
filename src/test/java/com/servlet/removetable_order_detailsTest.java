package com.servlet;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dao.DAO5;
import com.entity.order_details;

public class removetable_order_detailsTest {

    @Mock
    HttpServletRequest request;

    @Mock
    HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testDoGetRemoveOrderDetails() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("id")).thenReturn("someId");
        when(request.getParameter("ie")).thenReturn("someImage");

        // Mocking DAO5
        DAO5 daoMock = mock(DAO5.class);
        when(daoMock.removeorder_details(any(order_details.class))).thenReturn(1);
        
        // Creating servlet instance
        removetable_order_details servlet = new removetable_order_details();
        
        // Injecting mocked DAO5 into servlet
        servlet.setDAO5(daoMock);
        
        // Calling doGet method
        servlet.doGet(request, response);
        
        // Verifying the behavior
        verify(request).getParameter("id");
        verify(request).getParameter("ie");
        verify(daoMock).removeorder_details(any(order_details.class));
        verify(response).sendRedirect("table_order_details.jsp");
    }
}
