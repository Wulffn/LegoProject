/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginException;
import functionlayer.OrderException;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
public class Confirmation extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException, OrderException {
        int length = Integer.valueOf(request.getParameter("length"));
        int width = Integer.valueOf(request.getParameter("width"));
        int height = Integer.valueOf(request.getParameter("height"));
        User u = (User) request.getSession().getAttribute("user");
        LogicFacade.createOrder(u.getId(), length, width, height);
        return "WEB-INF/confirmation";
    }
    
}
