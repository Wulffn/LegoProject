/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

import data.OrderMapper;
import data.UserMapper;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author mwn
 */
public class LogicFacade {

    public static User login(String email, String password) throws LoginException {
        return UserMapper.login(email, password);
    }

    public static User createUser(String firstName, String lastName, String email, String password) throws LoginException {
        User user = new User(firstName, lastName, email, password, "customer");
        UserMapper.createUser(user);
        return user;
    }

    public static List<Order> getAllOrders() throws OrderException {
        List<Order> orders = OrderMapper.getAllOrders();
        for (Order order : orders) {
            order.setHouse(getHouse(order.getLength(), order.getWidth(), order.getHeight()));
        }
        return orders;
    }

    public static List<Order> getAllOrdersByCustomer(int customerId) throws OrderException {
        List<Order> orders = OrderMapper.getOrderByCustomerId(customerId);
        for (Order order : orders) {
            order.setHouse(getHouse(order.getLength(), order.getWidth(), order.getHeight()));
        }
        return orders;
    }

    public static Order getOrderById(int orderId) throws OrderException {
        Order order = OrderMapper.getSingleOrderById(orderId);
        order.setHouse(getHouse(order.getLength(), order.getWidth(), order.getHeight()));
        return order;
    }
    
    public static void createOrder(int customerId, int length, int width, int height) throws OrderException {
        Order order = new Order(customerId, length, width, height);
        OrderMapper.createOrder(order);
    }

    private static Wall buildWall(String wallName, int length, int heigth) {
        List<Brick> brickList = new ArrayList();

        Brick small = new Brick("1x2", 1, 2);
        Brick medium = new Brick("2x2", 2, 2);
        Brick large = new Brick("4x2", 4, 2);

        int sm = 0;
        int md = 0;
        int lg = 0;

        for (int i = 0; i < heigth; i++) {
            int l = length;
            while (l > 0) {
                if (l - large.getLength() >= 0) {
                    brickList.add(large);
                    lg++;
                    l -= 4;
                }
                if (l - medium.getLength() >= 0) {
                    brickList.add(medium);
                    md++;
                    l -= 2;
                }
                if (l - small.getLength() >= 0) {
                    brickList.add(small);
                    sm++;
                    l -= 1;
                }
            }
        }
        return new Wall(wallName, brickList, sm, md, lg);
    }

    private static House getHouse(int length, int width, int heigth) {
        List<Wall> walls = new ArrayList();
        walls.add(buildWall("A", length, heigth));
        walls.add(buildWall("B", width-4, heigth));
        walls.add(buildWall("C", length, heigth));
        walls.add(buildWall("D", width-4, heigth));
        House h = new House();
        h.setWalls(walls);
        return h;
    }

    public static void updateOrderStatus(int orderNumber, String status) throws OrderException {
        OrderMapper.changeOrderStatus(orderNumber, status);
    }
}
