/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import connexion.Connexion;
import entities.Admin;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author HP
 */
public class AdminService {

    public Admin findByUsername(String username) {
        try {
            String req = "select * from admin where username = ?";
            PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
            pr.setString(1, username);
            ResultSet rs = pr.executeQuery();
            if (rs.next()) {
                return new Admin(rs.getInt("id"), rs.getString("username"), rs.getString("password"));
            }
        } catch (SQLException e) {
            System.out.println("Erreur :: User : FindUsername ");
        }

        return null;
    }

}
/*package service;



 import connexion.Connexion;
 import dao.IDao;
 import entities.User;
 import java.sql.PreparedStatement;
 import java.sql.ResultSet;
 import java.sql.SQLException;
 import java.util.ArrayList;
 import java.util.List;



 /**
 *
 * @author OTHMANE
 */
/*public class USerService implements IDao<User>{



@Override
public boolean create(User o) {
try {
String req = "insert into user values (null, ?,?,?,?,?)";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
pr.setString(1, o.getNom());
pr.setString(2, o.getPrenom());
pr.setString(3, o.getUsername());
pr.setString(4, o.getPassword());
pr.setString(5, o.getRole());
if (pr.executeUpdate() != 0) {
return true;
}
} catch (SQLException e) {
e.printStackTrace();
}



return false;
}



@Override
public boolean update(User o) {
try {
String req = "update user set nom = ? ,prenom = ?,username = ?, password = ? , role = ? where id = ?";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
pr.setString(1, o.getNom());
pr.setString(2, o.getPrenom());
pr.setString(3, o.getUsername());
pr.setString(4, o.getPassword());
pr.setString(5, o.getRole());
pr.setInt(6, o.getId());
if (pr.executeUpdate() != 0) {
return true;
}
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}



@Override
public boolean delete(User o) {
try {
String req = "delete from user where id = ?";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
pr.setInt(1, o.getId());
if (pr.executeUpdate() != 0) {
return true;
}
} catch (SQLException e) {

}
return false;
}



@Override
public User findById(int id) {
try {
String req = "select * from user where id = ?";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
pr.setInt(1, id);
ResultSet rs = pr.executeQuery();
if (rs.next()) {
return new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("username"),rs.getString("password"),rs.getString("role"));
}
} catch (SQLException e) {
e.printStackTrace();
}
return null;
}



@Override
public List<User> findAll() {
List<User> users = new ArrayList<User>();
try {
String req = "select * from user";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
ResultSet rs = pr.executeQuery();
while (rs.next()) {
users.add(new User(rs.getInt("id"), rs.getString("nom"),rs.getString("prenom"),rs.getString("username"),rs.getString("password"),rs.getString("role")));
}
} catch (SQLException e) {
e.printStackTrace();
}
return users;
}

public boolean checkAuth(String username,String pass){
try {
String req = "select * from user where username = ? and password = ? ";
PreparedStatement pr = Connexion.getConnection().prepareStatement(req);
pr.setString(1, username);
pr.setString(2, pass);
ResultSet rs = pr.executeQuery();
if (rs.next()) {
return true;
}
} catch (SQLException e) {
e.printStackTrace();
}
return false;
}

}
*/
