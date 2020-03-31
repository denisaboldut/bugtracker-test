package com.company;

import com.company.model.Employee;

public class Main {
    public static void main(String[] args) {
        //java.Employee employee = new java.Employee(1, "Radu", "radu@mail.com");
        //employee.addBug(7,2,"desciere bug", "deschis", "3", "mobile", "mobile.jpg", "this is a bug",employee.getIdemployee());
        //bug.addBug(1,2,"desciere bug", "deschis", "3", "mobile", "mobile.jpg", "this is a bug");
        //java.Product product=new java.Product(3,"bazededate","12-12-2011","stoc");
        //java.Product product2=new java.Product(4,"cazino","09-12-2008","aplication");
        //java.Employee employee1= new java.Employee(2, "Mircea", "mircea@mail.com");
        //java.Employee employee2= new java.Employee(3, "Adrian", "adi@mail.com");
        //java.Employee employee3= new java.Employee(5, "Elizabeta", "eliza@mail.com");
        //employee.addCommentforBug(1,"bug closed ");
        //employee.addCommentforBug(6,"bug in progress");
        //product2.updateProduct("produs cazino","03-12-2008","aplicatie mobila");
        //java.Product product3=new java.Product(5,"stire","09-12-2008","aplication");
        //product2.deleteProduct(5);
        Employee employee =new Employee(10,"Costel","costel@mail.com");
        employee.addCommentForBug(1,"bug closed");
       // employee.addBug(8,4,"problem with the app","open","1","input","ss.jpg","can't open app",employee.getIdemployee());
        //employee.addCommentforBug(8,"in progress");
        //employee.addCommentforBug(8," closed");
    }
}
