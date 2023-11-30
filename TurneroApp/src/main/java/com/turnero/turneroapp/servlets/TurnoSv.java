/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.turnero.turneroapp.servlets;

import com.turnero.turneroapp.logica.Controladora;
import com.turnero.turneroapp.logica.Turno;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author pedro
 */
@WebServlet(name = "TurnoSv", urlPatterns = {"/TurnoSv"})
public class TurnoSv extends HttpServlet {
    
    Controladora controlLogica = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        
    }
    //Método Get para mostrar el listado de todos los turnos
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
        List<Turno> listTurnos = controlLogica.traerTurno();
        
        request.setAttribute("turnos", listTurnos);
        
        request.getRequestDispatcher("listadoTurnos.jsp").forward(request, response);
    }

    //Método Post para crear un nuevo turno
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
         //Obtener datos desde el JSP
        int numeroTurno = Integer.parseInt(request.getParameter("numero_turno"));
        String fechaIngresada = request.getParameter("fecha_turno");  
        String idCiudadano = request.getParameter("id_ciudadano");
        String descripcionTramite = request.getParameter("tramite_turno");
        String estado = request.getParameter("estado");
        
        //Primero comprobamos si existe un turno con el mismo numero. Si no, mostramos mensaje de error
        if(controlLogica.traerTurnoNumero(numeroTurno)){
            request.setAttribute("errors", "Ya existe un turno con el mismo número. Comprueba el Listado de Turnos.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registroTurno.jsp");
            dispatcher.forward(request, response);
        }else{ 
            //Si pasa el primer filtro, comprobamos si existe el id del ciudadano en la base de datos. Si no, mostramos mensaje de error
            if(controlLogica.obtenerCiudadano(Long.parseLong(idCiudadano))!=null){
                try {
                 //Convertimos la fecha
                 SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
                 Date fecha = sdf.parse(fechaIngresada);
                 //Creamos el nuevo turno
                 Turno turno = new Turno();
                 turno.setNumero(numeroTurno);
                 turno.setFecha(fecha);
                 turno.setTramite(descripcionTramite);
                 turno.setEstado(estado);

                 controlLogica.crearTurno(turno, Long.parseLong(idCiudadano));

                 request.getRequestDispatcher("index.jsp").forward(request, response);               

             } catch (ParseException ex) {
                 Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
             }
            }else{
                request.setAttribute("errors", "El ciudadano con el ID proporcionado no existe. Comprueba el Listado de Ciudadanos.");
                RequestDispatcher dispatcher = request.getRequestDispatcher("registroTurno.jsp");
                dispatcher.forward(request, response);
            }
            
        }   
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
