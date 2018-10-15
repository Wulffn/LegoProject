/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginException;
import functionlayer.Order;
import functionlayer.OrderException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class Employee extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        int ordersWaiting = 0;
        List<Order> orders = LogicFacade.getAllOrders();
        for (Order order : orders) {
            if(order.getStatus().equalsIgnoreCase("waiting")) ordersWaiting++;
        }
        request.setAttribute("orderswaiting", ordersWaiting);
        return "/WEB-INF/employeepage";
    }
    
}
