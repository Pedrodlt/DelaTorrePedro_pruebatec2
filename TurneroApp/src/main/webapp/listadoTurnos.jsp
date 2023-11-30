<%-- 
    Document   : listadoTurnos
    Created on : 29 nov 2023, 23:48:10
    Author     : pedro
--%>
<%@page import="java.util.List"%>
<%@page import="com.turnero.turneroapp.logica.Turno"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/navbarBody.jsp"%>
<!-- Begin Page Content -->
            
<div class="container-fluid">
    <% if (request.getAttribute("turnos") != null) { %>

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Listado de Turnos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Fecha Turno</th>
                            <th>Número Turno</th>
                            <th>Trámite</th>
                            <th>Id ciudadano</th>
                            <th>Nombre Ciudadano</th>
                            <th>Estado</th>
                            <th>Acción</th>
                        </tr>
                    </thead>

                    <tbody>
                        <% for (Turno turno : (List<Turno>) request.getAttribute("turnos")) { %>
                        <tr>
                            <td><%= turno.getFechaFormateada()%></td>
                            <td><%= turno.getNumero()%></td>
                            <td><%=turno.getTramite()%></td>
                            <td><%=turno.getCiudadano().getId()%></td>
                            <td><%=turno.getCiudadano().getNombre()%></td>
                            <td><%=turno.getEstado()%></td>
                            <td>
                                <form name="editar" action="EditarEstadoTurnoSv" method="GET">
                                    <button type="submit" class="btn btn-primary">
                                        <i class="fas fa-pencil-alt"></i>Editar
                                    </button>
                                    <input type="hidden" name="id" value="<%=turno.getId()%>">
                                </form>
                            </td>
                        </tr>
                       <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>
<% } %>
</div>

<%@include file="components/bodyFooter.jsp"%>
