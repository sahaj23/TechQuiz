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
import techquizapp.dbutil.DBConnection;
import techquizapp.pojo.UserPojo;

/**
 *
 * @author Nitin
 */
public class UserDAO {
    
   public static Boolean validateUser(UserPojo user)throws SQLException
   {
        Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=? and password=? and usertype=?");
        ps.setString(1,user.getUserId());
        ps.setString(2, user.getPassword());
        ps.setString(3, user.getUserType());
        ResultSet rs=ps.executeQuery();
        return rs.next();
   }
   public static boolean addUser(UserPojo user) throws SQLException
   {
       Connection conn=DBConnection.getConnection();
        PreparedStatement ps=conn.prepareStatement("select * from users where userid=?");
        boolean status=true;
        ps.setString(1,user.getUserId());
        ResultSet rs=ps.executeQuery();
        if(rs.next())
         status =false;
        else
        {
            System.out.println("htyjtjtee");
            PreparedStatement ps1=conn.prepareStatement("insert into users values(?,?,?)");
            //System.out.println(user.getUserId()+" "+user.getPassword()+" "+user.getUserType());
            ps1.setString(1,user.getUserId());
            ps1.setString(2, user.getPassword());
            ps1.setString(3,user.getUserType());
            ps1.executeUpdate();
        }
        return status;
   }
   public static boolean updatePassword(UserPojo userPojo) throws SQLException
   {
       Connection conn=DBConnection.getConnection();
       PreparedStatement ps=conn.prepareStatement("update users set password=? where userid=?");
       System.out.println(userPojo.getPassword()+" "+userPojo.getUserId());
       ps.setString(1,userPojo.getPassword());
       ps.setString(2,userPojo.getUserId());
       int c=ps.executeUpdate();
       return (c==1);
   }
}
