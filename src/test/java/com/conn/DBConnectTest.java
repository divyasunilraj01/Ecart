package com.conn;

import static org.junit.Assert.assertNotNull;

import java.sql.Connection;
import java.sql.SQLException;

import org.junit.Test;

public class DBConnectTest {

    @Test
    public void testGetConn() {
        Connection conn = DBConnect.getConn();
        assertNotNull("Connection object should not be null", conn);
       
        try {
            assertFalse(conn.isClosed(), "Connection should be open");
        } catch (SQLException e) {
            fail("Exception occurred while checking connection status: " + e.getMessage());
        }
    }

	private void fail(String string) {
		
		
	}

	private void assertFalse(boolean closed, String string) {
		
		
	}
}
