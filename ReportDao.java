
package dao;

import java.sql.ResultSet;
import java.util.ArrayList;
import model.Report;
import model.Student;
/**
 *
 * @author AmTechGuy
 */
public class ReportDao {
    
     public static void save(Report report){
        String query = "insert into report(date, time, studentId, name, level, report) "
                + "values('"+report.getDate()+"', '"+report.getTime()+"', '"+report.getId()+"', "
                + "'"+report.getName()+"', '"+report.getLevel()+"', '"+report.getReport()+"')";
        DbOperations.setDataOrDelete(query, "Complains log!");
    }
    
    public static ArrayList<Report> getAllStudentsName(String id){
        ArrayList<Report> arrayList = new ArrayList<>();
        try{
            ResultSet rs = DbOperations.getData("select name from student where name = '"+id+"'");
            while(rs.next()){
                Report report = new Report();
                report.setName(rs.getString("name"));
                arrayList.add(report);
             }
         
         }
         catch(Exception e){
             e.printStackTrace();
         }
         return arrayList;
     }
     public static Report getAllComplains(String name){
        Report report = null;
        try{
            ResultSet res = DbOperations.getData("select * from report where name = '"+name+"'");
            while(res.next()){
                report = new Report();
                report.setDate(res.getString("date"));
                report.setTime(res.getString("time"));
                report.setId(res.getString("studentId"));
                report.setName(res.getString("name"));
                report.setLevel(res.getString("level"));
                report.setReport(res.getString("report"));
                
            }
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return report;
    }
     
     
}
