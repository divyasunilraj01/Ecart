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

public class addcustomerTest {

    private addcustomer servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private StringWriter stringWriter;
    private PrintWriter writer;

    @Before
    public void setUp() throws Exception {
        servlet = new addcustomer();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        stringWriter = new StringWriter();
        writer = new PrintWriter(stringWriter);

        when(response.getWriter()).thenReturn(writer);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Mocking request parameters
        when(request.getParameter("Username")).thenReturn("testUser");
        when(request.getParameter("Password")).thenReturn("testPassword");
        when(request.getParameter("Email_Id")).thenReturn("test@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Total")).thenReturn("100");
        when(request.getParameter("CusName")).thenReturn("TestCustomer");

        // Calling doPost method of the servlet
        servlet.doPost(request, response);

        // Verifying redirection
        verify(response).sendRedirect("customerlogin.jsp?Total=100&CusName=TestCustomer");

        // Verifying output
        writer.flush();
        assertEquals("", stringWriter.toString());
    }
}
