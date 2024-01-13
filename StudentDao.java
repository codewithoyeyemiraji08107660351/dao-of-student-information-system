
package dao;

import java.sql.ResultSet;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import model.Student;
/**
 *
 * @author AmTechGuy
 */
public class StudentDao {
    
     public static void save(Student student){
//       String query = "insert into student(studentId, name, password, dob, gender, level, language, address, "
//               + "fatherName, fatherQualification, fatherMobileNumber, fatherOccupation, motherName, motherQualification,"
//               + "motherMobileNumber, motherOccupation) values('"+user.getStudentId()+"', '"+user.getName()+"',"
//               + " '"+user.getPassword()+"','"+user.getDob()+"', '"+user.getGender()+"', '"+user.getLevel()+"', "
//               + "'"+user.getLanguage()+"', '"+user.getAddress()+"', '"+user.getFatherName()+"', '"+user.getFatherQualification()+"',"
//               + "'"+user.getFatherMobileNumber()+"', '"+user.getFatherOccupation()+"', '"+user.getMotherName()+"', "
//               + "'"+user.getMotherQualification()+"', '"+user.getMotherMobileNumber()+"', '"+user.getMotherOccupation()+"')";
//        DbOperation.setDataOrDelete(query, "Registration Successful, proceed to Dashboard to upload your credentials!");
        String query = "INSERT INTO student(studentId, name, password, dob, gender, level, "
                + "language, address) "
                + "VALUES(?,?,?,?,?,?,?,?,?)";
                String path  = null;
                
                try(Connection connection = ConnectionProvider.getCon();
                    PreparedStatement ps = connection.prepareStatement(query)){
                    ps.setString(1, student.getStudentId());
                    ps.setString(2, student.getName());
                    ps.setString(3, student.getPassword());
                    ps.setString(4, student.getDob());
                    ps.setString(5, student.getGender());
                    ps.setString(6, student.getLevel());
                    ps.setString(7, student.getLanguage());
                    ps.setString(8, student.getAddress());
                    //ps.setBlob(9, );
                    
                    ps.executeUpdate();
                    JOptionPane.showMessageDialog(null, "Enrollment Successfull!!");
                
                }
                catch(SQLException e){
                    e.printStackTrace();
                }
    }
    
     public static Student login(String studentId, String password){
        Student student = null;
        try{
            ResultSet rs = DbOperations.getData("SELECT * FROM student where studentId = '"+studentId+"' AND password = '"+password+"'");
            while(rs.next()){
                student = new Student();
                student.setStudentId(rs.getString("studentId"));
                JOptionPane.showMessageDialog(null, "Login successful!");
            }            
        
        } 
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, e);
        
        } 
        return  student;
    }
     
    public static ArrayList<Student> getAllRecords(){
        ArrayList<Student> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select name from student");
            while(rs.next()){
                Student student = new Student();
                student.setName(rs.getString("name"));
                arrayList.add(student);
             }
         
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return arrayList;
     }
    
    public static ArrayList<Student> getAllStudentsID(){
        ArrayList<Student> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select studentId from student");
            while(rs.next()){
                Student student = new Student();
                student.setStudentId(rs.getString("studentId"));
                arrayList.add(student);
             }
         
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return arrayList;
     }
     public static ArrayList<Student> getAllStudentsLevel(){
        ArrayList<Student> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select level from student");
            while(rs.next()){
                Student student = new Student();
                student.setLevel(rs.getString("level"));
                arrayList.add(student);
             }
         
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return arrayList;
     }
}
