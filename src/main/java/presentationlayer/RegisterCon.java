/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LogicFacade;
import functionlayer.LoginException;
import functionlayer.User;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author mwn
 */
public class RegisterCon extends Command {

    @Override
    String execute(HttpServletRequest request, HttpServletResponse response) throws LoginException {
        String firstName = request.getParameter("firstName");
        String lastName = request.getParameter("lastName");
        String email = request.getParameter("email");
        String password1 = request.getParameter("password1");
        String password2 = request.getParameter("password2");
        if (password1.equals(password2)) {
            User user = LogicFacade.createUser(firstName, lastName, email, password1);
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            session.setAttribute("role", user.getRole());
            return "/WEB-INF/" + user.getRole() + "page";
        } else {
            throw new LoginException("the two passwords did not match");
        }
    }

}
