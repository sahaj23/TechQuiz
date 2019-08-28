
package techquizapp.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.ExamPojo;

/**
 *
 * @author Nitin
 */
public class ExamDAO {
    
//    public static String getExamId()throws SQLException
//    {
//        Connection conn=DBConnection.getConnection();
//        Statement st=conn.createStatement();
//        ResultSet rs=st.executeQuery("select count(*) as totalrows from exam");
//        int rowCount=0;
//        if(rs.next())
//        rowCount=rs.getInt(1);
//        
//        return "EX-"+(rowCount+1);
//    }

    public static String getExamId() throws SQLException{
        Connection conn=DBConnection.getConnection();
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("select count(*) as totalrows from exam");
        int rowCount=0;
        if(rs.next())
        rowCount=rs.getInt(1);
        
        return "EX-"+(rowCount+1);
    }
    public static Boolean addExam(ExamPojo newExam) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("insert into exam values(?,?,?)");
        ps.setString(1,newExam.getExamId());
        ps.setString(2,newExam.getLanguage());
        ps.setInt(3,newExam.getTotalQuestions());
        int ans=ps.executeUpdate();
        
        return (ans==1);
    }
   
    public static boolean isPaperSet(String language) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=?");
        ps.setString(1, language);
        ResultSet rs=ps.executeQuery();
        return rs.next();
                
    }
    public static ArrayList<String> getExamIdBySubject(String userid,String subject) throws SQLException
    {
        ArrayList<String> examList=new ArrayList<>();
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select examid from exam where language=? minus select examid from performance where userid=?");
        ps.setString(1, subject);
        ps.setString(2, userid);
        ResultSet rs=ps.executeQuery();
        while(rs.next())
            examList.add(rs.getString(1));
        return examList;
    }
    public static int getQuestionCountByExam (String examId) throws SQLException
    {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select total_question from exam where examid=?");
        ps.setString(1, examId);
        ResultSet rs=ps.executeQuery();
        rs.next();
        int rowCount=rs.getInt(1);
        return rowCount;
    }
    
}