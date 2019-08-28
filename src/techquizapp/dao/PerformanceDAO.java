/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.PerformancePojo;
import techquizapp.pojo.StudentScorePojo;

/**
 *
 * @author Nitin
 */
public class PerformanceDAO {
    
  public static ArrayList<String> getAllStudentId() throws SQLException
  {
    Connection conn=DBConnection.getConnection();
    PreparedStatement ps=conn.prepareStatement("select userid from performance");
     PreparedStatement ps1=conn.prepareStatement("select count(*) from performance");
    ResultSet rs=ps.executeQuery();      
    ArrayList<String> studentIdList=new ArrayList<>();
    while(rs.next())
    {
        String id=rs.getString(1);
        System.out.println(id);
        studentIdList.add(id);
    }
     return studentIdList;
  }
  
  public static ArrayList<String> getAllExamId(String studentId) throws SQLException
  {
      Connection conn=DBConnection.getConnection();
      ArrayList<String> examIdList=new ArrayList<>();
      PreparedStatement ps=conn.prepareStatement("select examid from performance where userid=?");
      ps.setString(1, studentId);
      ResultSet rs=ps.executeQuery();
      while(rs.next())
      {
          System.out.println(rs.getString(1));
          examIdList.add(rs.getString(1));
      }
      return examIdList;
  }
  
  public static StudentScorePojo getScore(String studentId,String examId) throws SQLException
  {
      Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("select language,per from performance where userid=? and examid=?");
      ps.setString(1, studentId);
      ps.setString(2,examId);
      ResultSet rs=ps.executeQuery();
      rs.next();
      StudentScorePojo scoreObj=new StudentScorePojo(rs.getString(1),rs.getDouble(2));
      
      return scoreObj;
  }
   public static void addPerformance(PerformancePojo performance) throws SQLException
   {
       Connection conn=DBConnection.getConnection();
      PreparedStatement ps=conn.prepareStatement("insert into performance values(?,?,?,?,?,?,?)");
      ps.setString(1,performance.getUserId());
      ps.setString(2,performance.getExamId());
      ps.setInt(3,performance.getRight());
      ps.setInt(4, performance.getWrong());
      ps.setInt(5,performance.getUnattempted());
      ps.setDouble(6,performance.getPer());
      ps.setString(7,performance.getLanguage());
      ps.executeUpdate();
   }
    public static ArrayList<PerformancePojo> getAllPerformance() throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        Statement ps=conn.createStatement();
        ArrayList<PerformancePojo> performanceList=new ArrayList<PerformancePojo>();
        ResultSet rs=ps.executeQuery("select * from performance");
        while(rs.next())
        {
            String userId=rs.getString("userid");
            String examId=rs.getString("examid");
            String language=rs.getString("language");
            int right=rs.getInt("right");
            int unattempted=rs.getInt("unattempted");
            int wrong=rs.getInt("wrong");
            double per=rs.getDouble("per");
            PerformancePojo p=new PerformancePojo(examId,language,userId,right,wrong,unattempted,per);
            performanceList.add(p);
            
        }
        return performanceList;
    }
  
}
