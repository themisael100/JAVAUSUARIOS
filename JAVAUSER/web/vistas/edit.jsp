
<%@page import="Modelo.Usuarios"%>
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
            <div class="col-lg-6">
              <%
              UsuariosDAL dal=new UsuariosDAL();
              int id=Integer.parseInt((String)request.getAttribute("idus"));
              Usuarios U=(Usuarios)dal.list(id);
          %>
            <h1>Modificar Empleado</h1>
            <form action="Controlador">
                Nomre:<br>
                <input class="form-control" type="text" name="txtNombre" value="<%= U.getNombre()%>"><br>
                Apellido: <br>
                <input class="form-control" type="text" name="txtApellido" value="<%= U.getApellido()%>"><br>
                  Correo <br>
                <input class="form-control" type="text" name="txtCorreo" value="<%= U.getCorreo()%>"><br>
                 Puesto <br>
                <input class="form-control" type="text" name="txtPuesto" value="<%= U.getPuesto()%>"><br>
                
                <input type="hidden" name="txtid" value="<%= U.getId()%>">
                <input class="btn btn-primary" type="submit" name="accion" value="Actualizar"> 
                <a href="Controller?accion=listar">Regresar</a>
            </form>
          </div>
          
        </div>
    </body>
</html>
