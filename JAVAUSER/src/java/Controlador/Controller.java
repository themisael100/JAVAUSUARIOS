
package Controlador;

import Modelo.Usuarios;
import ModeloDAL.UsuariosDAL;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Controller", urlPatterns = {"/Controller"})
public class Controller extends HttpServlet {

    String listar="vistas/listar.jsp";
    String add="vistas/add.jsp";
    String edit="vistas/edit.jsp";
    Usuarios L=new Usuarios();
    UsuariosDAL dao=new UsuariosDAL();
    int id;
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet Controlador</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet Controlador at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acceso="";
        String action=request.getParameter("accion");
        if(action.equalsIgnoreCase("listar")){
            acceso=listar;            
        }else if(action.equalsIgnoreCase("add")){
            acceso=add;
        }
        else if(action.equalsIgnoreCase("Agregar")){
            String nombre=request.getParameter("txtNombre");
            String apellido=request.getParameter("txtApellido");
            String correo=request.getParameter("txtCorreo");
            String puesto=request.getParameter("txtPuesto");
            L.setNombre(nombre);
            L.setApellido(apellido);
             L.setCorreo(correo);
              L.setPuesto(puesto);
            dao.add(L);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("editar")){
            request.setAttribute("idus",request.getParameter("id"));
            acceso=edit;
        }
        else if(action.equalsIgnoreCase("Actualizar")){
            id=Integer.parseInt(request.getParameter("txtid"));
            String nombre=request.getParameter("txtNombre");
            String apellido=request.getParameter("txtApellido");
              String correo=request.getParameter("txtCorreo");
            String puesto=request.getParameter("txtPuesto");
            L.setId(id);
            L.setNombre(nombre);
            L.setApellido(apellido);
              L.setCorreo(correo);
              L.setPuesto(puesto);
            dao.edit(L);
            acceso=listar;
        }
        else if(action.equalsIgnoreCase("eliminar")){
            id=Integer.parseInt(request.getParameter("id"));
            L.setId(id);
            dao.eliminar(id);
            acceso=listar;
        }
        RequestDispatcher vista=request.getRequestDispatcher(acceso);
        vista.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

   
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
