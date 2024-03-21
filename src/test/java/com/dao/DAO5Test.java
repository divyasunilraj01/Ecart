package com.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.cart;
import com.entity.contactus;
import com.entity.order_details;
import com.entity.orders;

public class DAO5Test {

    private Connection connMock;
    private DAO5 dao;

    @Before
    public void setUp() throws Exception {
        connMock = mock(Connection.class);
        dao = new DAO5(connMock);
    }

    @Test
    public void testGetAllcart() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true, false); // Simulate one row
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        
        // Mock Connection
        when(connMock.prepareStatement("select * from cart")).thenReturn(preparedStatementMock);

        List<cart> result = dao.getAllcart();

        // Verify the result
        assertEquals(1, result.size());
    }

    @Test
    public void testGetAllorders() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true, false); // Simulate one row
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        
        // Mock Connection
        when(connMock.prepareStatement("select * from orders")).thenReturn(preparedStatementMock);

        List<orders> result = dao.getAllorders();

        // Verify the result
        assertEquals(1, result.size());
    }

    @Test
    public void testGetAllorder_details() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true, false); // Simulate one row
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        
        // Mock Connection
        when(connMock.prepareStatement("select * from order_details")).thenReturn(preparedStatementMock);

        List<order_details> result = dao.getAllorder_details();

        // Verify the result
        assertEquals(1, result.size());
    }

    @Test
    public void testRemoveorder_details() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("delete from order_details where Date= ? and pimage= ?"))
            .thenReturn(preparedStatementMock);

        order_details od = new order_details();
        od.setDate("2024-03-21");
        od.setPimage("image.jpg");

        int result = dao.removeorder_details(od);

        // Verify the result
        assertEquals(1, result);
    }

    @Test
    public void testAddContactus() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("insert into Contactus(Name,Email_Id,Contact_No,Message) values(?,?,?,?)"))
            .thenReturn(preparedStatementMock);

        contactus c = new contactus();
        c.setName("John Doe");
        c.setEmail_Id("john@example.com");
        c.setContact_No(123456789);
        c.setMessage("Test message");

        int result = dao.addContactus(c);

        // Verify the result
        assertEquals(1, result);
    }

    @Test
    public void testGetcontactus() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true, false); // Simulate one row
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        
        // Mock Connection
        when(connMock.prepareStatement("select * from Contactus")).thenReturn(preparedStatementMock);

        List<contactus> result = dao.getcontactus();

        // Verify the result
        assertEquals(1, result.size());
    }

    @Test
    public void testRemovecont() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("delete from Contactus where id= ?"))
            .thenReturn(preparedStatementMock);

        contactus c = new contactus();
        c.setId(1);

        int result = dao.removecont(c);

        // Verify the result
        assertEquals(1, result);
    }
}
