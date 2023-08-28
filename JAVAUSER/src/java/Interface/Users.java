/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package Interface;

import Modelo.Usuarios;
import java.util.List;

/**
 *
 * @author themi
 */
public interface Users {
    public List listar();
    public Usuarios list(int id);
    public boolean add(Usuarios us);
    public boolean edit(Usuarios us);
    public boolean eliminar(int id);
}
