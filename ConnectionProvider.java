
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.swing.JOptionPane;
/**
 *
 * @author AmTechGuy
 */
public class ConnectionProvider {
    
    static Connection con;
    
    public static Connection getCon(){
    try{
        //Class.forName("com.mysql.cj.jdbc.Driver");
        //String username = "root";
        //String password = "oyeyemi";
        //String url = "jdbc:mysql://localhost:3306/cms";
        //con = DriverManager.getConnection(url, username, password);
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sis?useSSL=false", "root", "oyeyemi");
        return con;
    }
    catch(SQLException | ClassNotFoundException ex){
        JOptionPane.showMessageDialog(null, ex);
        return null;
    }
    }
}
