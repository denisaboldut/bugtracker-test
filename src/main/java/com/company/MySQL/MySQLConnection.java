package com.company.MySQL;

import java.sql.*;
public class MySQLConnection{

    private Statement stmt;
    private Connection con;

    public Connection getCon() {
        return con;
    }
    public Statement getStmt() {
        return stmt;
    }


    public MySQLConnection(){

        try{
                Class.forName("com.mysql.jdbc.Driver");
                con=DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/mydb","root","");
                stmt=con.createStatement();
            } catch(Exception e){
                System.out.println(e);
            }
        }

}