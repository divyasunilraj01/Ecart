package com.servlet;

import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.dao.DAO5;
import com.servlet.addContactus;

public class AddContactusTest {
    
    @Mock
    private HttpServletRequest request;
    
    @Mock
    private HttpServletResponse response;
    
    @Mock
    private RequestDispatcher requestDispatcher;
    
    private addContactus servlet;
    
    @Before
    public void setUp() throws ServletException {
        MockitoAnnotations.initMocks(this);
        servlet = new addContactus();
        ServletConfig servletConfig = mock(ServletConfig.class);
        ServletContext servletContext = mock(ServletContext.class);
        when(servletConfig.getServletContext()).thenReturn(servletContext);
        servlet.init(servletConfig);
    }
    
    @Test
    public void testDoPost_SuccessfulSubmission() throws Exception {
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");
        
        servlet.doPost(request, response);
        
        verify(response).sendRedirect("cupass.jsp");
    }
    
    @Test
    public void testDoPost_FailedSubmission() throws Exception {
        // Set up request parameters for a failed submission
        when(request.getParameter("Name")).thenReturn("John Doe");
        // Not setting Email_Id or Contact_No to simulate missing parameters
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");

        // Mock the behavior of DAO5 addContactus method to return 0,
        // indicating that the submission failed
        DAO5 daoMock = mock(DAO5.class);
        when(daoMock.addContactus(any())).thenReturn(0);
        
        servlet.doPost(request, response);
        
        // Verify that the response is redirected to "cufail.jsp"
        verify(response).sendRedirect("cufail.jsp");
    }
    
    @Test
    public void testDoPost_ExceptionThrown() throws Exception {
        when(request.getParameter("Name")).thenReturn("John Doe");
        when(request.getParameter("Email_Id")).thenReturn("john@example.com");
        when(request.getParameter("Contact_No")).thenReturn("1234567890");
        when(request.getParameter("Message")).thenReturn("Hello, I have a query.");
        
        // Simulate an exception being thrown by DAO5 addContactus method
        // This will trigger the catch block in the servlet
        
        servlet.doPost(request, response);
        
        verify(response).sendRedirect("error.jsp");
    }
}
