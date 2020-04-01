package com.company.model;

import com.company.repository.BugRepositrory;
import com.company.repository.EmployeeRepository;

import java.util.ArrayList;
import java.util.List;

public class Employee {

    private int idemployee;
    private String nume;
    private String mail;

    public Employee(int idemployee, String nume, String mail) {
        this.idemployee = idemployee;
        this.nume = nume;
        this.mail = mail;
        comentarii = new ArrayList<>();

        new EmployeeRepository().createEmployee(this);
    }

    private List<String> comentarii;

    public String getNume() {
        return nume;
    }

    public String getMail() {
        return mail;
    }

    public int getIdemployee() {
        return idemployee;
    }

    public boolean addBug(int id, int idProdus, String denumire, String status, String prioritate, String tag, String screenshot, String descriere, int idE){
        boolean addedBug = new BugRepositrory().addBug(id, idProdus, denumire, status, prioritate, tag, screenshot, descriere, idE);

        return addedBug;
    }

    public boolean addCommentForBug(int idBug, String comment){
        boolean commentAdded = new EmployeeRepository().addCommentforBug(idBug, comment);

        return commentAdded;
    }

}
