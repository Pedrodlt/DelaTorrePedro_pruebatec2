package com.turnero.turneroapp.servlets;

import com.turnero.turneroapp.logica.Controladora;
import com.turnero.turneroapp.logica.Turno;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@WebServlet(name = "EditarEstadoTurnoSv", urlPatterns = {"/EditarEstadoTurnoSv"})
public class EditarEstadoTurnoSv extends HttpServlet {
    
    Controladora controlLogica = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }
    //Método Get para obtener los datos en el formulario de editar turnos.
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        Long id = Long.parseLong(request.getParameter("id"));
        Turno turno = controlLogica.traerTurnoId(id);
        
        HttpSession misession = request.getSession();
        misession.setAttribute("turnoEditar", turno);
        response.sendRedirect("editarTurnos.jsp");
    }

    //Método Post para mandar los datos editados del turno, en este caso solo editaremos el estado
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String estado = request.getParameter("estado");
        
        Turno turno = (Turno)request.getSession().getAttribute("turnoEditar");
        
        turno.setEstado(estado);
        controlLogica.editarTurno(turno);
        response.sendRedirect("TurnoSv");
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}
