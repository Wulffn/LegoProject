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
import functionlayer.User;
import java.util.List;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mwn
 */
public class LoginCon extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        int ordersWaiting = 0;
        List<Order> orders = LogicFacade.getAllOrders();
        for (Order order : orders) {
            if(order.getStatus().equalsIgnoreCase("waiting")) ordersWaiting++;
        }
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        User user = LogicFacade.login(email, password);
        HttpSession session = request.getSession();
        request.setAttribute("orderswaiting", ordersWaiting);
        session.setAttribute("user", user);
        session.setAttribute("role", user.getRole());
        return "/WEB-INF/" + user.getRole() + "page";
    }
}
