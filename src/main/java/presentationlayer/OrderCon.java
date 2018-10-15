/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginException;
import functionlayer.OrderException;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class OrderCon extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        String shippingStatus = request.getParameter("shippingstatus");
        if(shippingStatus != null) {
            String orderNumber = request.getParameter("orderid");
            LogicFacade.updateOrderStatus(Integer.valueOf(orderNumber), shippingStatus);
        }
        List<OrderCon> orders = (List) LogicFacade.getAllOrders();
        request.setAttribute("orders", orders);
        return "/WEB-INF/order";
    }
    
}
