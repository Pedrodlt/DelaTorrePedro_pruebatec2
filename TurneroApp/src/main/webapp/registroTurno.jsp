<%-- 
    Document   : RegistroTurno
    Created on : 25 nov 2023, 16:52:28
    Author     : pedro
--%>


<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/navbarBody.jsp"%>
<%@page import="java.util.Objects"%>

<%
    String error = (String) request.getAttribute("errors");
    if (Objects.nonNull(error)) {
%>
    <div class="alert alert-danger">
        <%= error %>
    </div>
<%
    }
%>

<div class="container mt-4">
    <h2>Registro Nuevo Turno</h2>
    <form action="TurnoSv" method="POST">
        <div class="form-group">
            <label for="numero">Número de turno:</label>
            <input type="text" class="form-control" id="numero_turno" name="numero_turno" required>
        </div> 
        <div class="form-group">
            <label for="fecha">Fecha:</label>
            <input type="date" class="form-control" id="fecha_turno" name="fecha_turno" required>
        </div>     
        <div class="form-group">
            <label for="ciudadano">Id Ciudadano:</label>
            <input type="text" class="form-control" id="id_ciudadano" name="id_ciudadano" required>
        </div>                                                
        <div class="form-group">
            <label for="tramite">Descripción del trámite:</label>
            <input type="text" class="form-control" id="tramite_turno" name="tramite_turno" required>
        </div>                 
        <div class="form-group">
            <label for="estado">Estado turno:</label>
            <select name="estado" required class="form-control">
                <option value="En espera">En espera</option>
                <option value="Ya atendido">Ya atendido</option>
            </select>
        </div>                  

        <button type="submit" class="btn btn-primary">Registrar</button>
    </form>    
</div>
               
<%@include file="components/bodyFooter.jsp"%>
