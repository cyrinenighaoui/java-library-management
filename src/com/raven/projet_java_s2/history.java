/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.raven.projet_java_s2;

import java.time.LocalDate;
import java.util.Scanner;

/**
 *
 * @author saif
 */
public class history {
    private int action_id;
    private String action;
    private LocalDate date_action;
    private int employee_id;
    private int abonne_id;

    public history(int id, String action_made, LocalDate date_action, int employee_id, int abonne_id) {
        this.action_id = id;
        this.action =action_made;
        this.date_action = date_action;
        this.employee_id = employee_id;
        this.abonne_id = abonne_id;
    }
    
    public history(int i)
    {
        
    }

    public int getAction_id() {
        return action_id;
    }

    public void setAction_id(int action_id) {
        this.action_id = action_id;
    }

    public String getAction() {
        return action;
    }

    public void setAction(String action) {
        this.action = action;
    }

    public LocalDate getDate_action() {
        return date_action;
    }

    public void setDate_action(LocalDate date_action) {
        this.date_action = date_action;
    }

    public int getEmployee_id() {
        return employee_id;
    }

    public void setEmployee_id(int employee_id) {
        this.employee_id = employee_id;
    }

    public int getAbonne_id() {
        return abonne_id;
    }

    public void setAbonne_id(int abonne_id) {
        this.abonne_id = abonne_id;
    }

    @Override
    public String toString() {
        return "history{" + "action_id=" + action_id + ", action=" + action + ", date_action=" + date_action + ", employee_id=" + employee_id + ", abonne_id=" + abonne_id + '}';
    }
    
}
