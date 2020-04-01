package com.company.repository;

import com.company.MySQL.MySQLConnection;
import com.company.model.Product;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ProductRepository {
    private MySQLConnection mysql;
    private Statement stmt;
    private PreparedStatement pstmt;

    public ProductRepository(){
        mysql = new MySQLConnection();
        stmt = mysql.getStmt();
    }

    public void createProduct(Product product){
        boolean productExists = searchProductById(product.getIdproduct());
        if(productExists){
            System.out.println("Error, product already exists");
            return;
        }

        try {
            pstmt=mysql.getCon().prepareStatement("INSERT INTO product VALUES (?,?,?,?)");

            pstmt.setInt(1,product.getIdproduct());
            pstmt.setString(2,product.getDenumire());
            pstmt.setString(3,product.getData_lansarii());
            pstmt.setString(4,product.getDescriere());

            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("java.Product created successfully");

    }

    //read
    private boolean searchProductById(int id){
        try {
            ResultSet rst = mysql.getStmt().executeQuery("SELECT * FROM product WHERE idproduct="+id);
            if(rst.next()){
                //  System.out.println(rst.getInt(1)+" "+rst.getString(2)+" "+rst.getString(3)+" "+rst.getString(4));
                return true;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;

    }

    //update
    public boolean updateProduct (String denumire, String data_lansare, String descriere, Product product){
        boolean productExists = searchProductById(product.getIdproduct());
        if(productExists){
            try {
                pstmt=mysql.getCon().prepareStatement("UPDATE `product` SET denumire=(?),data_lansarii=(?),descriere=(?) WHERE idproduct="+product.getIdproduct());
                pstmt.setString(1,denumire);
                pstmt.setString(2,data_lansare);
                pstmt.setString(3,descriere);
                pstmt.executeUpdate();
                System.out.println("java.Product updated successfully");
                return true;
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }

        return  false;
    }

    //delete
    public boolean deleteProduct(int idP){

        try {
            pstmt= mysql.getCon().prepareStatement("DELETE from product where idproduct="+idP);
            pstmt.executeUpdate();
            System.out.println("java.Product deleted successfully");
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return  false;
    }
}
