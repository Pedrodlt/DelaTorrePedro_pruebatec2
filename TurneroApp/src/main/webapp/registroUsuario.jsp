<%-- 
    Document   : index
    Created on : 24 nov 2023, 22:10:28
    Author     : pedro
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/navbarBody.jsp"%>
<%@ page import="java.util.Objects" %>

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
    <h2>Alta Nuevo Ciudadano</h2>
    <form action="CiudadanoSv" method="POST">
        <div class="form-group">
            <label for="nombre">Nombre:</label>
            <input type="text" class="form-control" id="nombre_ciudadano" name="nombre_ciudadano" required>
        </div>
        <div class="form-group">
            <label for="apellido">Apellido:</label>
            <input type="text" class="form-control" id="apellido_ciudadano" name="apellido_ciudadano" required>
        </div>  
        <div class="form-group">
            <label for="dni">DNI:</label>
            <input type="text" class="form-control" id="dni_ciudadano" name="dni_ciudadano" required>
        </div>
        <div class="form-group">
            <label for="telefono">Teléfono:</label>
            <input type="text" class="form-control" id="telefono_ciudadano" name="telefono_ciudadano" required>
        </div>

        <button type="submit" class="btn btn-primary">Registrar</button>
    </form>
</div>
            
<%@include file="components/bodyFooter.jsp"%>