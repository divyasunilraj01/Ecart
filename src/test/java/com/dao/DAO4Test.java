package com.dao;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import org.junit.Before;
import org.junit.Test;

import com.entity.orders;
import com.entity.order_details;

public class DAO4Test {

    private Connection connMock;
    private DAO4 dao;

    @Before
    public void setUp() throws Exception {
        connMock = mock(Connection.class);
        dao = new DAO4(connMock);
    }

    @Test
    public void testCheckCart() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Simulate one row of data
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from cart  where Name is NULL")).thenReturn(preparedStatementMock);

        boolean result = dao.checkcart();

        // Verify the result
        assertEquals(true, result);
    }
    @Test
    public void testCheckCart2() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Simulate one row of data
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from cart  where Name= ?")).thenReturn(preparedStatementMock);

        boolean result = dao.checkcart2("John");

        // Verify the result
        assertEquals(true, result);
    }
    @Test
    public void testAddOrders() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("insert into orders(Customer_Name,Customer_City,Date,Total_Price,Status) values(?,?,?,?,?)")).thenReturn(preparedStatementMock);

        orders testOrder = new orders();
        testOrder.setCustomer_Name("John");
        testOrder.setCustomer_City("New York");
        testOrder.setDate("2024-03-21");
        testOrder.setTotal_Price(100);
        testOrder.setStatus("Pending");

        int result = dao.addOrders(testOrder);

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testAddOrderDetails() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("insert into order_details(Name,bname,cname,pname,pprice,pquantity,pimage) select * from cart where Name is NULL")).thenReturn(preparedStatementMock);

        int result = dao.addOrder_details();

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testAddOrderDetails2() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("insert into order_details(Name,bname,cname,pname,pprice,pquantity,pimage) select * from cart where Name = ?"))
            .thenReturn(preparedStatementMock);

        String name = "John Doe";

        int result = dao.addOrder_details2(name);

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testDeleteCart() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("delete from cart where Name is NULL")).thenReturn(preparedStatementMock);

        int result = dao.deletecart();

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testDeleteCart2() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("delete from cart where Name = ?")).thenReturn(preparedStatementMock);

        String name = "John Doe";

        int result = dao.deletecart2(name);

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testUpdateOrderDetails() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("update order_details set Date = ? , Name=? where Date is NULL")).thenReturn(preparedStatementMock);

        order_details od = new order_details();
        od.setDate("2024-03-21");
        od.setName("John Doe");

        int result = dao.updateOrder_details(od);

        // Verify the result
        assertEquals(1, result);
    }
    @Test
    public void testUpdateOrderDetails2() throws Exception {
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1); // Simulate one row affected
        
        // Mock Connection
        when(connMock.prepareStatement("update order_details set Date = ? where Date is NULL")).thenReturn(preparedStatementMock);

        order_details od = new order_details();
        od.setDate("2024-03-21");

        int result = dao.updateOrder_details2(od);

        // Verify the result
        assertEquals(1, result);
    }

    // Similar tests can be written for other methods in DAO4 class
}
