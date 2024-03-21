package com.dao;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import org.junit.Before;
import org.junit.Test;

import com.entity.cart;
import com.entity.customer;
import com.entity.usermaster;
import com.entity.viewlist;

public class DAO2Test {

    private Connection connMock;
    private DAO2 dao;

    @Before
    public void setUp() throws Exception {
        connMock = mock(Connection.class);
        dao = new DAO2(connMock);
    }

    @Test
    public void testGetAllviewlist() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(1)).thenReturn("bname");
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from viewlist")).thenReturn(preparedStatementMock);

        List<viewlist> result = dao.getAllviewlist();

        assertEquals(1, result.size());
        assertEquals("bname", result.get(0).getBname());
    }

    @Test
    public void testCheckcust() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true);
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from customer  where Password=? and Email_Id=?")).thenReturn(preparedStatementMock);

        customer customer = new customer();
        customer.setPassword("password");
        customer.setEmail_Id("email@example.com");

        assertTrue(dao.checkcust(customer));
    }

    // Write similar test methods for other public methods in DAO2
}
