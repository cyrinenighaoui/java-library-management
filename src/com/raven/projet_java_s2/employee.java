/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.projet_java_s2;

import com.raven.go.Tools;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class employee {
    private int employee_id;
    private int cin;
    private String prenom;
    private String nom;
    private LocalDateTime date_naissance;
    private float salaire;

    /*public employee(int employee_id, int cin, String prenom, String nom, LocalDate date_naissance, float salaire) {
        this.employee_id = employee_id;
        this.cin = cin;
        this.prenom = prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.salaire = salaire;
    }*/
    
    public employee(int employee_id, int cin, String prenom, String nom, LocalDateTime date_naissance, float salaire)
    {
        this.employee_id = employee_id;
        this.cin=cin;
        this.prenom=prenom;
        this.nom = nom;
        this.date_naissance = date_naissance;
        this.salaire = salaire;
    }

    public employee() {
        Scanner sc = new Scanner(System.in);
        System.out.println("donner l'id");
        this.employee_id=sc.nextInt();
        do{
            System.out.println("donner le cin");
            this.cin=sc.nextInt();
        }while((!com.raven.go.Tools.verifNumeric(String.valueOf(this.cin)))||String.valueOf(this.cin).length()!=8);
        do{
            System.out.println("donner le nom ");
            this.nom=sc.next();
        }while((!com.raven.go.Tools.verifAlpha(this.nom)));
        do{
            System.out.println("donner le prenom");
            this.prenom=sc.next();
        }while(!(com.raven.go.Tools.verifAlpha(this.prenom)));
        String pattern = "\\d{2}-\\d{2}-\\d{4}";
        String date="";
        do{
            System.out.println("donner le date de naissance");
            date = sc.next();
        }while(!date.matches(pattern));        
        DateTimeFormatter d = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        this.date_naissance=LocalDateTime.parse(date,d);
        do{
            System.out.println("donner le salaire");
            this.salaire=sc.nextFloat();
        }while(this.salaire<=0); 
    }
    public employee(int i)
    {
        
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getCin() {
        return cin;
    }

    public void setCin(int cin) {
        this.cin = cin;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public LocalDateTime getDate_naissance() {
        return date_naissance;
    }

    public void setDate_naissance(LocalDateTime date_naissance) {
        this.date_naissance = date_naissance;
    }

    public float getSalaire() {
        return salaire;
    }

    public void setSalaire(float salaire) {
        this.salaire = salaire;
    }

    @Override
    public String toString() {
        return "employee{" + "employee_id=" + employee_id + ", cin=" + cin + ", prenom=" + prenom + ", nom=" + nom + ", date_naissance=" + date_naissance + ", salaire=" + salaire + '}';
    }

    public void add(employee emp) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    
}
