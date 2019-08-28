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
import java.util.ArrayList;
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.QuestionPojo;
import techquizapp.pojo.QuestionStore;

/**
 *
 * @author Nitin
 */
public class QuestionDAO {

    public static void addQuestions(QuestionStore obj) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps = conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<QuestionPojo> questionList = obj.getAllQuestions();
        for (QuestionPojo qList : questionList) {
            ps.setString(1, qList.getExamId());
            ps.setInt(2,    qList.getQno());
            ps.setString(3, qList.getQuestion());
            ps.setString(4, qList.getAnswer1());
            ps.setString(5, qList.getAnswer2());
            ps.setString(6, qList.getAnswer3());
            ps.setString(7, qList.getAnswer4());
            ps.setString(8, qList.getCorrectAnswer());
            ps.setString(9, qList.getLanguage());
            ps.executeUpdate();
        }
    }
    
     public static void updateQuestions(QuestionStore obj,String examId) throws SQLException {
        Connection conn = DBConnection.getConnection();
        PreparedStatement ps1=conn.prepareStatement("delete from questions where examid=?");
        ps1.setString(1,examId);
        System.out.println(ps1.executeUpdate());
        
        PreparedStatement ps = conn.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?,?)");
        ArrayList<QuestionPojo> questionList = obj.getAllQuestions();
         System.out.println(questionList);
         System.out.println(questionList.size());
        for (QuestionPojo qList : questionList) {
            ps.setString(1, qList.getExamId());
            ps.setInt(2,    qList.getQno());
            ps.setString(3, qList.getQuestion());
            ps.setString(4, qList.getAnswer1());
            ps.setString(5, qList.getAnswer2());
            ps.setString(6, qList.getAnswer3());
            ps.setString(7, qList.getAnswer4());
            ps.setString(8, qList.getCorrectAnswer());
            ps.setString(9, qList.getLanguage());
            ps.executeUpdate();
        }
     }
        
     public static ArrayList<QuestionPojo> getQuestionsByExamId(String examId) throws SQLException
     {
         Connection conn=DBConnection.getConnection();
         PreparedStatement ps=conn.prepareStatement("select * from questions where examid=? order by qno");
         ArrayList<QuestionPojo> questionList=new ArrayList<>();
         ps.setString(1, examId);
         ResultSet rs=ps.executeQuery();
         while(rs.next())
         {
             int qno=rs.getInt(2);
             String question=rs.getString(3);
             String option1=rs.getString(4);
             String option2=rs.getString(5);
             String option3=rs.getString(6);
             String option4=rs.getString(7);
             String correctAnswer=rs.getString(8);
             String language=rs.getString(9);
             QuestionPojo obj=new QuestionPojo(examId,language,option1,option2,option3,option4,correctAnswer,question,qno);
             questionList.add(obj);
         }
         return questionList;
     }
    
    
}
