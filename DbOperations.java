
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javax.swing.JOptionPane;
/**
 *
 * @author AmTechGuy
 */
public class DbOperations {
    
    public static void setDataOrDelete(String query, String message){
        
        try{
           Connection con = ConnectionProvider.getCon();
            Statement st = con.createStatement();
            st.executeUpdate(query);
            if(!message.equals("")){
                JOptionPane.showMessageDialog(null, message);
            }
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null,e);
        }
    }
    
    public static ResultSet getData(String query){
        Connection con = null;
        Statement st = null;
        
        try{
             Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/sis?useSSL=false", "root", "oyeyemi");
             st = con.createStatement();
             ResultSet rs = st.executeQuery(query);
             return rs;
            
        }
        catch(Exception ex){
           JOptionPane.showMessageDialog(null,ex);
           return null;
        }
    }
    
    
}
