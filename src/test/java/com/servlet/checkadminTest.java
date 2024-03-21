package com.servlet;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

public class checkadminTest {

    private checkadmin servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;

    @Before
    public void setUp() throws Exception {
        servlet = new checkadmin();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoPost_AdminExists() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("Username")).thenReturn("admin");
        when(request.getParameter("Password")).thenReturn("admin123");

        // Calling doPost method of the servlet
        servlet.doPost(request, response);

        // Verifying cookie setting
        verify(response).addCookie(new Cookie("tname", "admin"));
        


        // Verifying redirection
        verify(response).sendRedirect("adminhome.jsp");

        // Verifying output
        writer.flush();
        assertEquals("", stringWriter.toString());
    }
}
