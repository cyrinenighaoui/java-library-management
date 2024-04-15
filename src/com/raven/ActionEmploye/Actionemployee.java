/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package com.raven.ActionEmploye;

import com.raven.main.Reclamation;
import com.raven.projet_java_s2.emprunt;
import java.util.Vector;
import com.raven.projet_java_s2.employee;

/**
 *
 * @author USER
 */
public interface Actionemployee {
       Vector<employee>   AfficherEmployee();
       Vector<emprunt>   AfficherEmprunt();
   Vector<Reclamation> AfficherReclamation();
    
}
