/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package functionlayer;

/**
 *
 * @author mwn
 */
public class Order {
    
    private int orderId, customerId, length, width, height;
    private House house;
    private String status;

    public Order(int orderId, int customerId, int length, int width, int height, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.length = length;
        this.width = width;
        this.height = height;
        this.status = status;
    }

    public Order(int orderId, int customerId, House house, String status) {
        this.orderId = orderId;
        this.customerId = customerId;
        this.house = house;
        this.status = status;
    }

    public Order(int customerId, int length, int width, int height) {
        this.customerId = customerId;
        this.length = length;
        this.width = width;
        this.height = height;
    }
    
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getWidth() {
        return width;
    }

    public void setWidth(int width) {
        this.width = width;
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public House getHouse() {
        return house;
    }

    public void setHouse(House house) {
        this.house = house;
    }
    
    
    
    
}
