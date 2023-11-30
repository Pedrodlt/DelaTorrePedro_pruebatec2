<%@page import="com.turnero.turneroapp.logica.Turno"%>
<%@page import="java.util.Objects"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/navbarBody.jsp"%>

<div class="container mt-4">
    <h2>Editar Estado Turno</h2>

    <%Turno turno = (Turno)request.getSession().getAttribute("turnoEditar");%>
    <form action="EditarEstadoTurnoSv" method="POST">
        <div class="form-group">
            <label for="numero">Número de turno:</label>
            <input type="text" class="form-control" id="numero_turno" name="numero_turno" value="<%=turno.getNumero()%>" readonly>
        </div> 
        <div class="form-group">
            <label for="fecha">Fecha:</label>
            <input type="text" class="form-control" id="fecha_turno" name="fecha_turno" value="<%=turno.getFechaFormateada()%>" readonly>
        </div>     
        <div class="form-group">
            <label for="ciudadano">Id Ciudadano:</label>
            <input type="text" class="form-control" id="id_ciudadano" name="id_ciudadano" value="<%=turno.getCiudadano().getId()%>" readonly>
        </div>                                                
        <div class="form-group">
            <label for="tramite">Descripción del trámite:</label>
            <input type="text" class="form-control" id="tramite_turno" name="tramite_turno" value="<%=turno.getTramite()%>" readonly>
        </div>                 
        <div class="form-group">
            <label for="estado">Estado turno:</label>
            <select name="estado" required class="form-control">
                <option value="En espera">En espera</option>
                <option value="Ya atendido">Ya atendido</option>
            </select>
        </div>                  

        <button type="submit" class="btn btn-primary">Editar</button>
    </form>    
</div>
               
<%@include file="components/bodyFooter.jsp"%>