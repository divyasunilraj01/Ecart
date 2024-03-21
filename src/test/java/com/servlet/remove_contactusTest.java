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
import com.dao.DAO5;
import com.entity.contactus;

public class remove_contactusTest {

    private remove_contactus servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;

    @Before
    public void setUp() throws Exception {
        servlet = new remove_contactus();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
    }

    @Test
    public void testDoGet_WithValidId() throws Exception {
        // Mock request parameter
        when(request.getParameter("id")).thenReturn("1");

        // Mock DAO5 methods
        DAO5 dao = mock(DAO5.class);
        when(dao.removecont(new contactus())).thenReturn(1);

        // Invoke servlet doGet method
        servlet.doGet(request, response);

        // Verify redirection
        verify(response).sendRedirect("table_contactus.jsp");
    }

    @Test
    public void testDoGet_WithInvalidId() throws Exception {
        // Mock request parameter
        when(request.getParameter("id")).thenReturn("100"); // Assuming this ID does not exist

        // Mock DAO5 methods
        DAO5 dao = mock(DAO5.class);
        when(dao.removecont(new contactus())).thenReturn(0);

        // Invoke servlet doGet method
        servlet.doGet(request, response);

        // Verify redirection
        verify(response).sendRedirect("table_contactus.jsp");
    }
}
