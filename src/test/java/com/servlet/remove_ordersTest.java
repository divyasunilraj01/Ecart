package com.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.conn.DBConnect;
import com.dao.DAO2;
import com.entity.orders;

public class remove_ordersTest {

    private remove_orders servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        servlet = new remove_orders();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet_WithValidId() throws Exception {
        // Mock request parameter
        when(request.getParameter("id")).thenReturn("1");

        // Mock DAO2 methods
        DAO2 dao = mock(DAO2.class);
        when(dao.removeorders(new orders())).thenReturn(1);

        // Invoke servlet doGet method
        servlet.doGet(request, response);

        // Verify redirection
        verify(response).sendRedirect("table_orders.jsp");
    }

    @Test
    public void testDoGet_WithInvalidId() throws Exception {
        // Mock request parameter
        when(request.getParameter("id")).thenReturn("100"); // Assuming this ID does not exist

        // Mock DAO2 methods
        DAO2 dao = mock(DAO2.class);
        when(dao.removeorders(new orders())).thenReturn(0);

        // Invoke servlet doGet method
        servlet.doGet(request, response);

        // Verify redirection
        verify(response).sendRedirect("table_orders.jsp");
    }
}
