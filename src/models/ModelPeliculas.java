/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.Time;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author equipo hp
 */
public class ModelPeliculas {
   private final ModelPrincipal model_Principal;
    
    private String id_pelicula;
    private String nombre_;
    private String formato;
    private String duracion;
    private String genero;
    private String nombre;
    
    public ModelPeliculas(ModelPrincipal model_Principal){
        this.model_Principal = model_Principal;
    }
     public void Actualizar_Datos(){
        model_Principal.setSQL_String("SELECT * FROM películas ORDER BY id_cliente ASC;");
        model_Principal.Ejecutar_Consulta();
        model_Principal.Mover_Primero();
        Asignar_Datos();
    }
    
    public void Asignar_Datos() {
        try {
            id_pelicula = model_Principal.getSQL_Result_Set().getString("id_pelicula");
            nombre_= model_Principal.getSQL_Result_Set().getString("nombre");
            formato = model_Principal.getSQL_Result_Set().getString("formato");
            duracion= model_Principal.getSQL_Result_Set().getString("duración");
            genero = model_Principal.getSQL_Result_Set().getString("genero");
        } 
        catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Error al asignar datos: " + ex);
        }
    }
    
    public void Insertar_Pelicula(){
        try{
            model_Principal.setSQL_String("INSERT INTO Películas(nombre, formato, duración, genero) VALUES(?, ?, ?, ?);");
             model_Principal.Preparar_Statement();
             model_Principal.getSQL_Prepared_Statement().setString(1, nombre);
             model_Principal.getSQL_Prepared_Statement().setString(2, formato);
             model_Principal.getSQL_Prepared_Statement().setTime(3, Time.valueOf(duracion));
             model_Principal.getSQL_Prepared_Statement().setString(4, genero);
             model_Principal.Ejecutar_Actualizacion();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al insertar registro: " + e);
        }
    }
    
    public void Modificar_Pelicula(){
        try{
            model_Principal.setSQL_String("UPDATE Películas SET nombre = ?, formato = ?, duración = ?, genero = ? WHERE id_pelicula = ?;");
            model_Principal.Preparar_Statement();
            model_Principal.getSQL_Prepared_Statement().setString(1, nombre);
            model_Principal.getSQL_Prepared_Statement().setString(2, formato);
            model_Principal.getSQL_Prepared_Statement().setTime(3, Time.valueOf(duracion));
            model_Principal.getSQL_Prepared_Statement().setString(4, genero);
            model_Principal.getSQL_Prepared_Statement().setInt(5, Integer.parseInt(id_pelicula));
            model_Principal.Ejecutar_Actualizacion();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al modificar registro: " + e);
        }
    }
    
    public void Eliminar_Pelicula(){
        try{
             model_Principal.setSQL_String("DELETE FROM Películas WHERE id_cliente = ? ;");
             model_Principal.Preparar_Statement();
             model_Principal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_pelicula));
             model_Principal.Ejecutar_Actualizacion();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al eliminar registro: " + e);
        }
    }
    
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    public void setgenero(String genero){
        this.genero = genero;
    }
    public void setformato(String formato){
        this.formato = formato;
    }
    public void setduracion(String duracion){
        this.duracion = duracion;
    }
    public String getnombre(){
        return nombre;
    }
    public String getgenero(){
        return genero;
    }
    public String getformato(){
        return formato;
    }
    public String getduracion(){
        return duracion;
    }

    public void setid_pelicula(String text) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public String getid_pelicula() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
    
            
    

