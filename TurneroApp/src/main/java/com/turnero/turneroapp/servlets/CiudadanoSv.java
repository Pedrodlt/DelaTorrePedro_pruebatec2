/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */
package com.turnero.turneroapp.servlets;

import com.turnero.turneroapp.logica.Ciudadano;
import com.turnero.turneroapp.logica.Controladora;
import java.io.IOException;
import java.util.List;
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
@WebServlet(name = "CiudadanoSv", urlPatterns = {"/CiudadanoSv"})
public class CiudadanoSv extends HttpServlet {
    
    Controladora controlLogica = new Controladora();

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
    }
    //Método Get para mostrar el listado de todos los usuarios
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        List<Ciudadano> listaCiudadanos = controlLogica.traerCiudadano();
        
        request.setAttribute("ciudadanos", listaCiudadanos);
        
        request.getRequestDispatcher("listadoUsuarios.jsp").forward(request, response);
        
        
    }
    //Método Post para crear un nuevo ciudadano
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        //Obtener datos desde el JSP
        String nombre = request.getParameter("nombre_ciudadano");
        String apellido = request.getParameter("apellido_ciudadano");
        String dni = request.getParameter("dni_ciudadano");
        String telefono = request.getParameter("telefono_ciudadano");

        // Verificar si ya existe un ciudadano con el mismo DNI. Si no, mostramos mensaje de error.
        if (controlLogica.traerCiudadanoDni(dni)) {
            // Ciudadano con el mismo DNI ya existe, manejar el error
            request.setAttribute("errors", "Ya existe un ciudadano con el mismo DNI.");
            RequestDispatcher dispatcher = request.getRequestDispatcher("registroUsuario.jsp");
            dispatcher.forward(request, response);
        } else {
            // No existe un ciudadano con el mismo DNI, proceder a crear y persistir el nuevo ciudadano
            Ciudadano ciudadano = new Ciudadano();
            ciudadano.setNombre(nombre);
            ciudadano.setApellido(apellido);
            ciudadano.setDni(dni);
            ciudadano.setTelefono(telefono);

            // Se persiste el ciudadano en la BD
            controlLogica.crearCiudadano(ciudadano);

            response.sendRedirect("index.jsp");
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }

}
