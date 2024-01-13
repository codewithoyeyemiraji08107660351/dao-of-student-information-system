
package dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.TeacherModel;
/**
 *
 * @author AmTechGuy
 */
public class TeacherDao {
    
     public static void save(TeacherModel teacher){
        String query = "insert into teacher(teacherId, name, mobileNumber, password, gender, qualification, address) "
                + "values('"+teacher.getTeacherId()+"', '"+teacher.getName()+"', '"+teacher.getMobileNumber()+"', "
                + "'"+teacher.getPassword()+"','"+teacher.getGender()+"', '"+teacher.getQualification()+"', '"+teacher.getAddress()+"')";
        DbOperations.setDataOrDelete(query, "Registration successful!");
    }
    
    public static TeacherModel login(String teacherId, String password){
        TeacherModel teacher = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM teacher where teacherId = '"+teacherId+"' AND password = '"+password+"'");
            while(rs.next()){
                teacher = new TeacherModel();
                teacher.setTeacherId(rs.getString("teacherId"));
                JOptionPane.showMessageDialog(null, "Login successful!");
            }            
        
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        } 
        return teacher;
    }
    
    public static ArrayList<TeacherModel> getAllRecords(){
        ArrayList<TeacherModel> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select name from teacher category");
            while(rs.next()){
                TeacherModel teacher = new TeacherModel();
                teacher.setName(rs.getString("name"));
                arrayList.add(teacher);
             }
         
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return arrayList;
     }
}
