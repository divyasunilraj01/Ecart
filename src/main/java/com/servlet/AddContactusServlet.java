package com.servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.conn.DBConnect;

@WebServlet("/addContactus")
public class AddContactusServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public AddContactusServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String name = request.getParameter("Name");
        String email = request.getParameter("Email_Id");
        String contactNoStr = request.getParameter("Contact_No");
        String message = request.getParameter("Message");

        // Convert contactNoStr to Integer
        int contactNo = 0;
        try {
            contactNo = Integer.parseInt(contactNoStr);
        } catch (NumberFormatException e) {
            // Handle invalid input for Contact_No
            response.sendRedirect("error.jsp");
            return;
        }

        // Insert data into database
        try (Connection conn = DBConnect.getConn()) {
            String sql = "INSERT INTO contactus (Name, Email_Id, Contact_No, Message) VALUES (?, ?, ?, ?)";
            try (PreparedStatement statement = conn.prepareStatement(sql)) {
                statement.setString(1, name);
                statement.setString(2, email);
                statement.setInt(3, contactNo);
                statement.setString(4, message);
                int rowsInserted = statement.executeUpdate();
                if (rowsInserted > 0) {
                    // Insertion successful
                    response.sendRedirect("cupass.jsp");
                } else {
                    // Insertion failed
                    response.sendRedirect("cufail.jsp");
                }
            }
        } catch (SQLException e) {
            // Handle database error
            e.printStackTrace();
            response.sendRedirect("error.jsp");
        }
    }
}
