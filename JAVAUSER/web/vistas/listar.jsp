
<%@page import="java.util.Iterator"%>
<%@page import="Modelo.Usuarios"%>
<%@page import="java.util.List"%>
<%@page import="ModeloDAL.UsuariosDAL"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/bootstrap.css" rel="stylesheet" type="text/css"/>
        <title>JSP Page</title>
    </head>
    <body>
        <div class="container">
            <h1>Empleados</h1>
            <a class="btn btn-success" href="Controller?accion=add"> Nuevo</a>
            <br>
            <br>
            <table class="table table-bordered">
                <thead>
                    <tr>
                        <th class="text-center">ID</th>
                        <th class="text-center">NOMBRE</th>
                        <th class="text-center">APELLIDO</th>
                         <th class="text-center">CORREO</th>
                           <th class="text-center">PUESTO</th>
                        <th class="text-center">ACCIONES</th>
                    </tr>
                </thead>
                <%
                    UsuariosDAL dal=new UsuariosDAL();
                    List<Usuarios>list=dal.listar();
                    Iterator<Usuarios>iter=list.iterator();
                    Usuarios Us=null;
                    while(iter.hasNext()){
                        Us=iter.next();
                    
                %>
                <tbody>
                    <tr>
                        <td class="text-center"><%= Us.getId()%></td>
                        <td class="text-center"><%= Us.getNombre()%></td>
                        <td class="text-center"><%= Us.getApellido()%></td>
                        <td class="text-center"><%= Us.getCorreo()%></td>
                         <td class="text-center"><%= Us.getPuesto()%></td>
                        <td class="text-center">
                            <a class="btn btn-warning" href="Controller?accion=editar&id=<%= Us.getId()%>">Editar</a>
                            <a class="btn btn-danger" href="Controller?accion=eliminar&id=<%= Us.getId()%>">Remove</a>
                        </td>
                    </tr>
                    <%}%>
                </tbody>
            </table>

        </div>
    </body>
</html>
