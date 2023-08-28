
package ModeloDAL;

import ComunDB.ComunDB;
import Interface.Users;
import Modelo.Usuarios;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author themi
 */
public class UsuariosDAL implements Users {
    ComunDB cn=new ComunDB();
    Connection con;
    PreparedStatement ps;
    ResultSet rs;
    Usuarios U =new Usuarios();
    
    @Override
    public List listar() {
             ArrayList<Usuarios>list=new ArrayList<>();
        String sql="select * from usuarios";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){
                Usuarios Us=new Usuarios();
                Us.setId(rs.getInt("Id"));
                Us.setNombre(rs.getString("Nombre"));
                Us.setApellido(rs.getString("Apellido"));
                Us.setCorreo(rs.getString("Correo"));
                Us.setPuesto(rs.getString("Puesto"));
                list.add(Us);
            }
        } catch (Exception e) {
        }
        return list;
    }


    @Override
    public Usuarios list(int id) {
            String sql="select * from usuarios where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            rs=ps.executeQuery();
            while(rs.next()){                
                U.setId(rs.getInt("Id"));
                U.setNombre(rs.getString("Nombre"));
                U.setApellido(rs.getString("Apellido"));
                U.setCorreo(rs.getString("Correo"));
                U.setPuesto(rs.getString("Puesto"));
            }
        } catch (Exception e) {
        }
        return U;
    }
    @Override
    public boolean add(Usuarios us) {
        String sql="insert into usuarios(Nombre, Apellido, Correo, Puesto)values('"+us.getNombre()+"','"+us.getApellido()+",'"+us.getCorreo()+"','"+us.getPuesto()+"')";
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
       return false;
    }

    @Override
    public boolean edit(Usuarios us) {
          String sql="update usuarios set Nombre='"+us.getNombre()+"',Apellido='"+us.getApellido()+",Correo='"+us.getCorreo()+"' Puesto='"+us.getPuesto()+"where Id="+us.getId();
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }

    @Override
    public boolean eliminar(int id) {
         String sql="delete from usuarios where Id="+id;
        try {
            con=cn.getConnection();
            ps=con.prepareStatement(sql);
            ps.executeUpdate();
        } catch (Exception e) {
        }
        return false;
    }
}
