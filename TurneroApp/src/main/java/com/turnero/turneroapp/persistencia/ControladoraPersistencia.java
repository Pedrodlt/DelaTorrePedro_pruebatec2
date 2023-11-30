/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turnero.turneroapp.persistencia;

import com.turnero.turneroapp.logica.Ciudadano;
import com.turnero.turneroapp.logica.Turno;
import com.turnero.turneroapp.persistencia.exceptions.NonexistentEntityException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author pedro
 */
public class ControladoraPersistencia {
    
    CiudadanoJpaController ciudadanoJPA = new CiudadanoJpaController();
    TurnoJpaController turnoJPA = new TurnoJpaController();
    
    //MÉTODOS PARA CIUDADANOS
    public void crearCiudadano (Ciudadano ciudadano) {
        ciudadanoJPA.create(ciudadano);
    }
    
    public void eliminarCiudadano (Long id) {
        try {
            ciudadanoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Ciudadano> traerCiudadanos () {
    return ciudadanoJPA.findCiudadanoEntities();
    }
    
    public void editarCiudadano (Ciudadano ciudadano) {
        try {
            ciudadanoJPA.edit(ciudadano);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public Ciudadano obtenerCiudadano(Long id) {
        return ciudadanoJPA.findCiudadano(id);
    }
     
     //Método para comprobar si existe un ciudadano por el dni
    public boolean traerCiudadanoConDNI (String dni){
        return ciudadanoJPA.existeCiudadanoConDNI(dni);
    }
    
    //MÉTODOS PARA TURNOS
    public void crearTurno (Turno turno) {
        turnoJPA.create(turno);
    }
    
    public void eliminarTurno (Long id) {
        try {
            turnoJPA.destroy(id);
        } catch (NonexistentEntityException ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public List<Turno> traerTurno () {
    return turnoJPA.findTurnoEntities();
    }
    
    public void editarTurno (Turno turno) {
        try {
            turnoJPA.edit(turno);
        } catch (Exception ex) {
            Logger.getLogger(ControladoraPersistencia.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    //Método para comprobar si existe un Turno con el mismo número en la base de datos
    public boolean traerTurnoConNumero (int numeroTurno){
        return turnoJPA.existeNumeroTurno(numeroTurno);
    }
    //Método para comprobar si existe un turno en la base de datos
    public Turno traerTurnoId(Long id) {
       return turnoJPA.findTurno(id);
    }
}
