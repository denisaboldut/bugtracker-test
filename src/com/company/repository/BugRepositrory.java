package com.company.repository;


import com.company.MySQL.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class BugRepositrory {
    private MySQLConnection mysql;
    private Statement stmt;
    private PreparedStatement pstmt;
    private final String INITAL_COMMENT = "bug deschis";


    public BugRepositrory(){
        mysql = new MySQLConnection();
        stmt = mysql.getStmt();
    }

    public boolean addBug(int id, int idProdus, String denumire, String status, String prioritate, String tag, String screenshot, String descriere, int idE){
        try {
            pstmt = mysql.getCon().prepareStatement("INSERT INTO `bug` VALUES(?,?,?,?,?,?,?,?)");
            pstmt.setInt(1, id);
            pstmt.setString(2, denumire);
            pstmt.setString(3,status);
            pstmt.setString(4, prioritate);
            pstmt.setString(5,tag);
            pstmt.setString(6, screenshot);
            pstmt.setString(7, descriere);
            pstmt.setInt(8, idProdus);

            pstmt.executeUpdate();

            pstmt=mysql.getCon().prepareStatement("INSERT INTO employee_has_bug VALUES(?,?,?) ");
            pstmt.setInt(1,idE);
            pstmt.setInt(2,id);
            pstmt.setString(3,INITAL_COMMENT);
            pstmt.executeUpdate();

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public void getBugAfterId(int id){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * from bug where idbug = " + id);
            rs.next();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    public void getAllBugs(){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * FROM bug");

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
