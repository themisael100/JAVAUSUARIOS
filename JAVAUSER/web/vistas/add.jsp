<%-- 
    Document   : add
    Created on : 30-ago-2018, 19:58:16
    Author     : Joel
--%>

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
                <h1>Agregar Empleado</h1>
                <form action="Controller">
                    Nombre<br>
                    <input class="form-control" type="text" name="txtNombre"><br>
                    Apellido <br>
                    <input class="form-control" type="text" name="txtApellido"><br>
                      Correo <br>
                    <input class="form-control" type="text" name="txtCorreo"><br>
                     Puesto <br>
                    <input class="form-control" type="text" name="txtPuesto"><br>
                    
                    <input class="btn btn-primary" type="submit" name="accion" value="Agregar">
                    <a href="Controller?accion=listar">Regresar</a>
                </form>
            </div>

        </div>
    </body>
</html>
