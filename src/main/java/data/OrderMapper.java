/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import functionlayer.Order;
import functionlayer.OrderException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mwn
 */
public class OrderMapper {

    public static void createOrder(Order order) throws OrderException {
        try {
            PreparedStatement ps = null;
            Connection con = DBConnector.connection();
            String sqlOrders = "INSERT INTO `lego`.`orders` (`userId`) VALUES (?);";
            String sqlDetails = "INSERT INTO `lego`.`orderDetails` (`orderId`, `houseLength`, `houseWidth`, `houseHeight`) VALUES (?, ?, ?, ?);";
            ps = con.prepareStatement(sqlOrders, Statement.RETURN_GENERATED_KEYS);
            ps.setInt(1, order.getCustomerId());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            order.setOrderId(ids.getInt(1));
            ps = con.prepareStatement(sqlDetails);
            ps.setInt(1, order.getOrderId());
            ps.setInt(2, order.getLength());
            ps.setInt(3, order.getWidth());
            ps.setInt(4, order.getHeight());
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static List<Order> getAllOrders() throws OrderException {
        List<Order> orders = new ArrayList();
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT orders.orderId,  orders.userId, houseLength, houseWidth, houseHeight, `status` FROM orders natural join orderDetails;";
            PreparedStatement ps = con.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int customerId = rs.getInt("userId");
                int length = rs.getInt("houseLength");
                int width = rs.getInt("houseWidth");
                int height = rs.getInt("houseHeight");
                String status = rs.getString("status");
                orders.add(new Order(orderId, customerId, length, width, height, status));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
        return orders;
    }

    public static List<Order> getOrderByCustomerId(int id) throws OrderException {
        List<Order> orders = new ArrayList();
        try {
            Connection con = DBConnector.connection();
            String sql = "SELECT orderId, orders.userId, houseLength, houseWidth, houseHeight, `status` FROM orders natural join orderDetails where orders.userId = ?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int orderId = rs.getInt("orderId");
                int length = rs.getInt("houseLength");
                int width = rs.getInt("houseWidth");
                int height = rs.getInt("houseHeight");
                String status = rs.getString("status");
                orders.add(new Order(orderId, id, length, width, height, status));
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
        return orders;
    }

    public static void changeOrderStatus(int orderId, String status) throws OrderException {
        try {
            Connection con = DBConnector.connection();
            String sql = "UPDATE `lego`.`orderDetails` SET `status` = ? WHERE (`orderId` = ?);";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, status);
            ps.setInt(2, orderId);
            ps.executeUpdate();
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
    }

    public static Order getSingleOrderById(int orderId) throws OrderException {
        Order order = null;
        try {
            Connection con = DBConnector.connection();
            String sql = "select userId, houseLength, houseWidth, houseHeight, status from orders natural join orderDetails where orders.orderId=?;";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, orderId);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int customerId = rs.getInt("userId");
                int length = rs.getInt("houseLength");
                int width = rs.getInt("houseWidth");
                int height = rs.getInt("houseHeight");
                String status = rs.getString("status");
                order = new Order(orderId, customerId, length, width, height, status);
            } else {
                throw new OrderException("Couldnt find order");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new OrderException(ex.getMessage());
        }
        return order;
    }

}
