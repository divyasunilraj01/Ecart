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
import com.entity.cart;
import com.conn.DBConnect; // Import DBConnect

public class removecartaTest {
    
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
        when(request.getParameter("id")).thenReturn("sampleId");
        when(request.getParameter("ie")).thenReturn("sampleIe");

        // Mocking DBConnect
        DBConnect dbConnectMock = mock(DBConnect.class);
    //    when(dbConnectMock.getConn()).thenReturn("sampleConnection");

        // Mocking DAO2
        DAO2 daoMock = mock(DAO2.class);
        when(daoMock.removecart(new cart())).thenReturn(1);
        
        // Injecting mocked DBConnect into servlet
        removecarta servlet = new removecarta();
        servlet.setDBConnect(dbConnectMock);
        
        servlet.doGet(request, response);
        
        // Verify the redirect URL
        verify(response).sendRedirect("carta.jsp?custname=sampleId");
    }
}
