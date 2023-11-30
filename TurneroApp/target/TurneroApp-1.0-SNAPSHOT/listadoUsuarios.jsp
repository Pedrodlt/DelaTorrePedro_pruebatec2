<%-- 
    Document   : listadoUsuarios
    Created on : 28 nov 2023, 2:12:28
    Author     : pedro
--%>

<%@page import="com.turnero.turneroapp.logica.Ciudadano"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@include file="components/header.jsp"%>
<%@include file="components/navbarBody.jsp"%>

<!-- Begin Page Content -->
<div class="container-fluid">

    <!-- DataTales Example -->
    <div class="card shadow mb-4">
        <div class="card-header py-3">
            <h6 class="m-0 font-weight-bold text-primary">Listado de Ciudadanos</h6>
        </div>
        <div class="card-body">
            <div class="table-responsive">
                <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                    <thead>
                        <tr>
                            <th>Id Ciudadano</th>
                            <th>Nombre</th>
                            <th>Apellido</th>
                            <th>DNI</th>
                            <th>Teléfono</th>
                        </tr>
                    </thead>
                    
                    <tbody>
                        <% for (Ciudadano ciudadano : (List<Ciudadano>) request.getAttribute("ciudadanos")) { %>
                        <tr>
                            <td><%= ciudadano.getId()%></td>
                            <td><%= ciudadano.getNombre()%></td>
                            <td><%=ciudadano.getApellido()%></td>
                            <td><%=ciudadano.getDni()%></td>
                            <td><%=ciudadano.getTelefono()%></td>
                        </tr>
                       <% } %>
                    </tbody>
                </table>
            </div>
        </div>
    </div>

</div>
<!-- /.container-fluid -->

<%@include file="components/bodyFooter.jsp"%>
