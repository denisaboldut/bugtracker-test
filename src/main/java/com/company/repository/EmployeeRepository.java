package com.company.repository;

import com.company.model.Employee;
import com.company.MySQL.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeRepository {
    private Statement stmt;
    private PreparedStatement pstmt;
    private MySQLConnection mysql;

    public EmployeeRepository(){
        mysql = new MySQLConnection();
        stmt = mysql.getStmt();
    }

    public boolean createEmployee(Employee employee){
        try {
            ResultSet rs = stmt.executeQuery("SELECT * from employee where idemployee = " + employee.getIdemployee());
            if (!rs.next()){
                pstmt = mysql.getCon().prepareStatement("INSERT INTO employee VALUES(?, ?, ?)");
                pstmt.setInt(1, employee.getIdemployee());
                pstmt.setString(2, employee.getNume());
                pstmt.setString(3, employee.getMail());

                pstmt.executeUpdate();

                return true;
            } else {
                System.err.println("java.Employee with this id already exists :)");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }



    public boolean addCommentforBug(int idBug, String comment){
        try {
            pstmt=mysql.getCon().prepareStatement("UPDATE `employee_has_bug` SET comentarii=CONCAT(comentarii,?) WHERE bug_idbug="+idBug);
            pstmt.setString(1,comment);
            pstmt.executeUpdate();

            System.out.println("Comment added successfully");

            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
