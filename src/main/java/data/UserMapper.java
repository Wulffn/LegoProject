/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package data;

import functionlayer.LoginException;
import functionlayer.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author mwn
 */
public class UserMapper {

    public static void createUser(User user) throws LoginException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "INSERT INTO users (firstName, lastName, email, password, role) VALUES (?, ?, ?, ?, ?);";
            PreparedStatement ps = con.prepareStatement(SQL, Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, user.getFirstName());
            ps.setString(2, user.getLastName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getPassword());
            ps.setString(5, user.getRole());
            ps.executeUpdate();
            ResultSet ids = ps.getGeneratedKeys();
            ids.next();
            int id = ids.getInt(1);
            user.setId(id);
        } catch (SQLException | ClassNotFoundException ex) {
            throw new LoginException(ex.getMessage());
        }
    }

    public static User login(String email, String password) throws LoginException {
        try {
            Connection con = DBConnector.connection();
            String SQL = "select idUser, firstName, lastName, role from users where email = ? and password = ?;";
            PreparedStatement ps = con.prepareStatement(SQL);
            ps.setString(1, email);
            ps.setString(2, password);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int id = rs.getInt("idUser");
                String firstName = rs.getString("firstName");
                String lastName = rs.getString("lastName");
                String role = rs.getString("role");
                User user = new User(firstName, lastName, email, password, role);
                user.setId(id);
                return user;
            } else {
                throw new LoginException("Could not validate user");
            }
        } catch (ClassNotFoundException | SQLException ex) {
            throw new LoginException(ex.getMessage());
        }
    }

}