package com.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class addtocartnullTest {

    private addtocartnull servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;

    @Before
    public void setUp() throws Exception {
        servlet = new addtocartnull();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("id")).thenReturn("123");
        when(request.getParameter("ie")).thenReturn("Category");
        when(request.getParameter("ig")).thenReturn("Product");
        when(request.getParameter("ih")).thenReturn("50");
        when(request.getParameter("ii")).thenReturn("2");
        when(request.getParameter("ij")).thenReturn("image.jpg");

        // Calling doGet method of the servlet
        servlet.doGet(request, response);

        // Verifying redirection
        verify(response).sendRedirect("cartnull.jsp");

        // Verifying output
        writer.flush();
        assertEquals("", stringWriter.toString());
    }
}
