/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.House;
import functionlayer.LogicFacade;
import functionlayer.LoginException;
import functionlayer.Order;
import functionlayer.OrderException;
import functionlayer.User;
import functionlayer.Wall;
import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class CustomerOrders extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        User u = (User) request.getSession().getAttribute("user");
        List<Order> orders = LogicFacade.getAllOrdersByCustomer(u.getId());
        request.setAttribute("userorders", orders);
        return "/WEB-INF/customerorder";
    }
    
}
