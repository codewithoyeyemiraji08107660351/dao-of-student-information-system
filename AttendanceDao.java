
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Attendance;
import model.TeacherModel;
import model.Student;
/**
 *
 * @author AmTechGuy
 */
public class AttendanceDao {
    
    public static void save(Attendance attendance){
        String query = "insert into attendance(date, time, teacherName, studentName, level, subject, status) "
                + "values('"+attendance.getDate()+"', '"+attendance.getTime()+"', '"+attendance.getTeacherName()+"',"
                + "'"+attendance.getStudentName()+"', '"+attendance.getLevel()+"', '"+attendance.getSubject()+"', '"+attendance.getStatus()+"')";
        DbOperations.setDataOrDelete(query, "Attendance Records Saved!");
    }
    
    public static ArrayList<TeacherModel> getAllTeacherName(){
        ArrayList<TeacherModel> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select name from teacher");
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
    
    public static ArrayList<Student> getAllStudentName(){
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
