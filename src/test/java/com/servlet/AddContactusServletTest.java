package com.servlet;
import static org.mockito.Mockito.*;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.servlet.AddContactusServlet;

public class AddContactusServletTest {

    private HttpServletRequest request;
    private HttpServletResponse response;
    private AddContactusServlet servlet;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        servlet = new AddContactusServlet();
    }

    @Test
    public void testDoPost_SuccessfulInsertion() throws ServletException, IOException, SQLException {
        // Mock request parameters
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");

        // Mock database connection and prepared statement
        Connection conn = mock(Connection.class);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(conn.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(1); // Indicate successful insertion

        // Set up StringWriter to capture response
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Call the doPost method of the servlet
        servlet.doPost(request, response);

        // Verify behavior
        verify(response).sendRedirect("cupass.jsp");
    }

    @Test
    public void testDoPost_FailedInsertion() throws ServletException, IOException, SQLException {
        // Mock request parameters
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");

        // Mock database connection and prepared statement
        Connection conn = mock(Connection.class);
        PreparedStatement statement = mock(PreparedStatement.class);
        when(conn.prepareStatement(anyString())).thenReturn(statement);
        when(statement.executeUpdate()).thenReturn(0); // Indicate failed insertion

        // Set up StringWriter to capture response
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Call the doPost method of the servlet
        servlet.doPost(request, response);

        // Verify behavior
        verify(response).sendRedirect("cufail.jsp");
    }

    @Test
    public void testDoPost_ExceptionHandling() throws ServletException, IOException, SQLException {
        // Mock request parameters
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");

        // Mock database connection and prepared statement to throw SQLException
        Connection conn = mock(Connection.class);
        when(conn.prepareStatement(anyString())).thenThrow(SQLException.class);

        // Call the doPost method of the servlet
        servlet.doPost(request, response);

        // Verify behavior
        verify(response).sendRedirect("error.jsp");
    }
}
