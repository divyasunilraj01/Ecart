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
import com.entity.laptop;
import com.entity.mobile;
import com.entity.order_details;
import com.entity.orders;
import com.entity.tv;
import com.entity.watch;

public class DAO3Test {

    private Connection connMock;
    private DAO3 dao;

    @Before
    public void setUp() throws Exception {
        connMock = mock(Connection.class);
        dao = new DAO3(connMock);
    }

    @Test
    public void testGetAlltv() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(1)).thenReturn("bname");
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from tv")).thenReturn(preparedStatementMock);

        List<tv> result = dao.getAlltv();

        assertEquals(1, result.size());
        assertEquals("bname", result.get(0).getBname());
    }

    @Test
    public void testCheckaddtocartnull() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true);
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from cart  where Name =? and bname=? and cname =? and pname = ? and pprice = ? and pimage = ?")).thenReturn(preparedStatementMock);

        cart cart = new cart();
        cart.setName("name");
        cart.setBname("bname");
        cart.setCname("cname");
        cart.setPname("pname");
        cart.setPprice(100);
        cart.setPimage("image");

        assertTrue(dao.checkaddtocartnull(cart));
    }
    @Test
    public void testGetAlllaptop() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(1)).thenReturn("bname1");
        when(resultSetMock.getString(2)).thenReturn("cname1");
        when(resultSetMock.getString(3)).thenReturn("pname1");
        when(resultSetMock.getInt(4)).thenReturn(100);
        when(resultSetMock.getInt(5)).thenReturn(5);
        when(resultSetMock.getString(6)).thenReturn("image1");
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from laptop")).thenReturn(preparedStatementMock);

        List<laptop> result = dao.getAlllaptop();

        assertEquals(1, result.size());
        assertEquals("bname1", result.get(0).getBname());
        assertEquals("cname1", result.get(0).getCname());
        assertEquals("pname1", result.get(0).getPname());
        assertEquals(100, result.get(0).getPprice());
        assertEquals(5, result.get(0).getPquantity());
        assertEquals("image1", result.get(0).getPimage());
    }
    @Test
    public void testGetAllmobile() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(1)).thenReturn("bname1");
        when(resultSetMock.getString(2)).thenReturn("cname1");
        when(resultSetMock.getString(3)).thenReturn("pname1");
        when(resultSetMock.getInt(4)).thenReturn(100);
        when(resultSetMock.getInt(5)).thenReturn(5);
        when(resultSetMock.getString(6)).thenReturn("image1");
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from mobile")).thenReturn(preparedStatementMock);

        List<mobile> result = dao.getAllmobile();

        assertEquals(1, result.size());
        assertEquals("bname1", result.get(0).getBname());
        assertEquals("cname1", result.get(0).getCname());
        assertEquals("pname1", result.get(0).getPname());
        assertEquals(100, result.get(0).getPprice());
        assertEquals(5, result.get(0).getPquantity());
        assertEquals("image1", result.get(0).getPimage());
    }
    @Test
    public void testGetAllwatch() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false);
        when(resultSetMock.getString(1)).thenReturn("bname1");
        when(resultSetMock.getString(2)).thenReturn("cname1");
        when(resultSetMock.getString(3)).thenReturn("pname1");
        when(resultSetMock.getInt(4)).thenReturn(100);
        when(resultSetMock.getInt(5)).thenReturn(5);
        when(resultSetMock.getString(6)).thenReturn("image1");
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from watch")).thenReturn(preparedStatementMock);

        List<watch> result = dao.getAllwatch();

        assertEquals(1, result.size());
        assertEquals("bname1", result.get(0).getBname());
        assertEquals("cname1", result.get(0).getCname());
        assertEquals("pname1", result.get(0).getPname());
        assertEquals(100, result.get(0).getPprice());
        assertEquals(5, result.get(0).getPquantity());
        assertEquals("image1", result.get(0).getPimage());
    }
    @Test
    public void testUpdateAddToCartNull() throws Exception {
        cart c = new cart();
        c.setName("TestName");
        c.setBname("TestBname");
        c.setCname("TestCname");
        c.setPname("TestPname");
        c.setPprice(100);
        c.setPimage("TestImage");

        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);
        // Mock Connection
        when(connMock.prepareStatement("update cart set pquantity = (pquantity + 1) where Name =? and bname = ? and cname = ? and pname = ? and pprice = ? and pimage = ?"))
                .thenReturn(preparedStatementMock);

        int result = dao.updateaddtocartnull(c);

        assertEquals(1, result);
    }
    @Test
    public void testAddToCartNull() throws Exception {
        cart c = new cart();
        c.setName("TestName");
        c.setBname("TestBname");
        c.setCname("TestCname");
        c.setPname("TestPname");
        c.setPprice(100);
        c.setPquantity(1);
        c.setPimage("TestImage");

        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeUpdate()).thenReturn(1);
        // Mock Connection
        when(connMock.prepareStatement("insert into cart values(?,?,?,?,?,?,?)")).thenReturn(preparedStatementMock);

        int result = dao.addtocartnull(c);

        assertEquals(1, result);
    }
    @Test
    public void testGetOrders() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Simulate one row of data
        when(resultSetMock.getInt(1)).thenReturn(1); // Order_Id
        when(resultSetMock.getString(2)).thenReturn("Customer1"); // Customer_Name
        when(resultSetMock.getString(3)).thenReturn("City1"); // Customer_City
        when(resultSetMock.getString(4)).thenReturn("2024-03-21"); // Date
        when(resultSetMock.getInt(5)).thenReturn(100); // Total_Price
        when(resultSetMock.getString(6)).thenReturn("Shipped"); // Status
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from orders where Customer_Name = ?")).thenReturn(preparedStatementMock);

        List<orders> result = dao.getOrders("Customer1");

        // Verify the result
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getOrder_Id());
        assertEquals("Customer1", result.get(0).getCustomer_Name());
        assertEquals("City1", result.get(0).getCustomer_City());
        assertEquals("2024-03-21", result.get(0).getDate());
        assertEquals(100, result.get(0).getTotal_Price());
        assertEquals("Shipped", result.get(0).getStatus());
    }
    @Test
    public void testGetOrdersByDate() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Simulate one row of data
        when(resultSetMock.getInt(1)).thenReturn(1); // Order_Id
        when(resultSetMock.getString(2)).thenReturn("Customer1"); // Customer_Name
        when(resultSetMock.getString(3)).thenReturn("City1"); // Customer_City
        when(resultSetMock.getString(4)).thenReturn("2024-03-21"); // Date
        when(resultSetMock.getInt(5)).thenReturn(100); // Total_Price
        when(resultSetMock.getString(6)).thenReturn("Shipped"); // Status
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from orders where Date = ?")).thenReturn(preparedStatementMock);

        List<orders> result = dao.getOrdersbydate("2024-03-21");

        // Verify the result
        assertEquals(1, result.size());
        assertEquals(1, result.get(0).getOrder_Id());
        assertEquals("Customer1", result.get(0).getCustomer_Name());
        assertEquals("City1", result.get(0).getCustomer_City());
        assertEquals("2024-03-21", result.get(0).getDate());
        assertEquals(100, result.get(0).getTotal_Price());
        assertEquals("Shipped", result.get(0).getStatus());
    }
    @Test
    public void testGetOrderDetails() throws Exception {
        // Mock ResultSet
        ResultSet resultSetMock = mock(ResultSet.class);
        when(resultSetMock.next()).thenReturn(true).thenReturn(false); // Simulate one row of data
        when(resultSetMock.getString(1)).thenReturn("2024-03-21"); // Date
        when(resultSetMock.getString(2)).thenReturn("Name1"); // Name
        when(resultSetMock.getString(3)).thenReturn("Bname1"); // Bname
        when(resultSetMock.getString(4)).thenReturn("Cname1"); // Cname
        when(resultSetMock.getString(5)).thenReturn("Pname1"); // Pname
        when(resultSetMock.getInt(6)).thenReturn(100); // Pprice
        when(resultSetMock.getInt(7)).thenReturn(2); // Pquantity
        when(resultSetMock.getString(8)).thenReturn("image1.jpg"); // Pimage
        
        // Mock PreparedStatement
        PreparedStatement preparedStatementMock = mock(PreparedStatement.class);
        when(preparedStatementMock.executeQuery()).thenReturn(resultSetMock);
        // Mock Connection
        when(connMock.prepareStatement("select * from Order_details where Date = ?")).thenReturn(preparedStatementMock);

        List<order_details> result = dao.getOrderdetails("2024-03-21");

        // Verify the result
        assertEquals(1, result.size());
        assertEquals("2024-03-21", result.get(0).getDate());
        assertEquals("Name1", result.get(0).getName());
        assertEquals("Bname1", result.get(0).getBname());
        assertEquals("Cname1", result.get(0).getCname());
        assertEquals("Pname1", result.get(0).getPname());
        assertEquals(100, result.get(0).getPprice());
        assertEquals(2, result.get(0).getPquantity());
        assertEquals("image1.jpg", result.get(0).getPimage());
    }

    // Write similar test methods for other public methods in DAO3
}
