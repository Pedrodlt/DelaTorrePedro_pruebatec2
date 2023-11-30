/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.turnero.turneroapp.logica;

import com.turnero.turneroapp.persistencia.ControladoraPersistencia;
import java.util.Date;
import java.util.List;

/**
 *
 * @author pedro
 */
public class Controladora {
    
    ControladoraPersistencia controlPersis = new ControladoraPersistencia();
    
    //Métodos para los Ciudadanos
    
     public void crearCiudadano (Ciudadano ciudadano) {
        controlPersis.crearCiudadano(ciudadano);
    }
    
    public void eliminarCiudadano (Long id) {
        controlPersis.eliminarCiudadano(id);
    }
    
    public List<Ciudadano> traerCiudadano() {
        return controlPersis.traerCiudadanos();
    }
    
    public void editarCiudadano (Ciudadano ciudadano) {
        controlPersis.editarCiudadano(ciudadano);
    }
    
    public List<Ciudadano> mostrarCiudadanos(){
        List <Ciudadano> ciudadanosCoincidentes =controlPersis.traerCiudadanos().stream()
                 .toList(); 
        return ciudadanosCoincidentes;
    
    }
    //Método para comprobar si existe un Ciudadano con el mismo DNI
    public boolean traerCiudadanoDni(String dni){
        return controlPersis.traerCiudadanoConDNI(dni);
    }
    
    public Ciudadano obtenerCiudadano (Long id){
        return controlPersis.obtenerCiudadano(id);
    }
    
    //Métodos para los Turnos
    
    public void crearTurno(Turno turno, Long idCiudadano) {
        //A partir de los IDs se obtienen los ciudadanos
        Ciudadano ciudadano = controlPersis.obtenerCiudadano(idCiudadano);
        
        //Lo seteamos en el turno antes de persistir
        turno.setCiudadano(ciudadano);
        
        //Creamos el Turno
        controlPersis.crearTurno(turno);
    }    
    
    public void eliminarTurno (Long id) {
        controlPersis.eliminarTurno(id);
    }
    
    public List<Turno> traerTurno () {
        return controlPersis.traerTurno();
    }
    
    public void editarTurno (Turno turno) {
        controlPersis.editarTurno(turno);
    }
    //Método para filtrar los turnos por fecha
    public List<Turno> filtrarFecha(Date fecha){
        List <Turno> fechaCoincidente =controlPersis.traerTurno().stream()
                 .filter(p->p.getFecha().equals(fecha))
                 .toList(); 
        return fechaCoincidente;
    
    }
  
    //Método para comprobar si existe un turno con el mismo número
    public boolean traerTurnoNumero (int numeroTurno){
        return controlPersis.traerTurnoConNumero(numeroTurno);
    }
    //Método para comprobar si existe un turno en la base de datos
    public Turno traerTurnoId(Long id) {
        return controlPersis.traerTurnoId(id);
    }
}

