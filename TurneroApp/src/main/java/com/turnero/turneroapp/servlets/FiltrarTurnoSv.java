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
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "FiltrarTurnoSv", urlPatterns = {"/FiltrarTurnoSv"})
public class FiltrarTurnoSv extends HttpServlet {

    Controladora controlLogica = new Controladora();
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
       
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    //Método Post para filtrar los turnos por fecha y por estado
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        // Obtener la fecha y el estado del formulario
        String fechaIngresada = request.getParameter("fecha");
        String estado = request.getParameter("estado");

         try {
             //Convertimos la fecha
             SimpleDateFormat sdf = new SimpleDateFormat("yyyyy-mm-dd");
             Date fecha = sdf.parse(fechaIngresada);
             //Creamos el listado de turnos, y utilizamos el método filtrarFecha de la controladora para filtrar los turnos
             List<Turno> turnosFiltrados = controlLogica.filtrarFecha(fecha);
             
             //Comprobamos si el estado existe o está vacio, si no, filtramos por el estado del turno
             if (estado != null && !estado.isEmpty()) {
                turnosFiltrados = turnosFiltrados.stream()
                    .filter(turno -> turno.getEstado().equals(estado))
                    .toList();
            }
             
             request.setAttribute("turnos", turnosFiltrados);

             // Redirigir de vuelta al formulario
             request.getRequestDispatcher("filtradoTurno.jsp").forward(request, response);               

         } catch (ParseException ex) {
             Logger.getLogger(TurnoSv.class.getName()).log(Level.SEVERE, null, ex);
         }
    }
  
    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
