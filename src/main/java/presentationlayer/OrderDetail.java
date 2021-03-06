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
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class OrderDetail extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        String orderId = request.getParameter("orderid");
        Order order = LogicFacade.getOrderById(Integer.valueOf(orderId));
        request.setAttribute("order", order);
        return "/WEB-INF/orderdetail";
    }
    
}
