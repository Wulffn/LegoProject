/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package presentationlayer;

import functionlayer.LoginException;
import functionlayer.OrderException;
import java.util.HashMap;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author mwn
 */
abstract class Command {

    private static HashMap<String, Command> commands;

    private static void initCommands() {
        commands = new HashMap<>();
        commands.put("login", new LoginCon());
        commands.put("register", new RegisterCon());
        commands.put("employee", new Employee());
        commands.put("customer", new Customer());
        commands.put("customerorders", new CustomerOrders());
        commands.put("order", new OrderCon());
        commands.put("logout", new Logout());
        commands.put("orderdetail", new OrderDetail());
        commands.put("orderconf", new Confirmation());
    }

    static Command from(HttpServletRequest request) {
        String commandName = request.getParameter("command");
        if (commands == null) {
            initCommands();
        }
        return commands.getOrDefault(commandName, new UnknownCommand() );
    }

    abstract String execute(HttpServletRequest request, HttpServletResponse response) 
            throws LoginException, OrderException;

}
