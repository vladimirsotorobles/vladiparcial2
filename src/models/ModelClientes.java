/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author equipo hp
 */
public class ModelClientes {
     private final ModelPrincipal model_Principal;
    
    private String id_cliente;
    private String nombre;
    private String telefono;
    private String email;
    private String direccion;
    
    public ModelClientes(ModelPrincipal model_Principal){
        this.model_Principal = model_Principal;
    }
    
    public void Actualizar_Datos(){
        model_Principal.setSQL_String("SELECT * FROM Clientes ORDER BY ClienteID ASC;");
        model_Principal.Ejecutar_Consulta();
        model_Principal.Mover_Primero();
        Asignar_Datos();
    }
    
    public void Asignar_Datos() {
        try{
            id_cliente = model_Principal.getSQL_Result_Set().getString("id_cliente");
            nombre = model_Principal.getSQL_Result_Set().getString("nombre");
            telefono = model_Principal.getSQL_Result_Set().getString("telefono");
            email = model_Principal.getSQL_Result_Set().getString("email");
            direccion = model_Principal.getSQL_Result_Set().getString("direccion");
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al asignar datos de clientes: " + e);
        }
    }
    
    public void Insertar_Cliente(){
        try{
            model_Principal.setSQL_String("INSERT INTO Clientes(nombre, telefono, email, direccion) VALUES(?, ?, ?, ?);");
            model_Principal.Preparar_Statement();
            model_Principal.getSQL_Prepared_Statement().setString(1, nombre);
            model_Principal.getSQL_Prepared_Statement().setString(2, telefono);
            model_Principal.getSQL_Prepared_Statement().setString(3, email);
            model_Principal.getSQL_Prepared_Statement().setString(4, direccion);
            model_Principal.Ejecutar_Actualizacion();
        }
        catch(SQLException e){
            JOptionPane.showMessageDialog(null, "Error al insertar cliente: " + e);
        }
    }
    
    public void Modificar_Cliente(){
        try {
            model_Principal.setSQL_String("UPDATE Clientes SET nombre = ?, telefono = ?, email = ?, direccion = ? WHERE ClienteID = ?;");
            model_Principal.Preparar_Statement();
            model_Principal.getSQL_Prepared_Statement().setString(1, nombre);
            model_Principal.getSQL_Prepared_Statement().setString(2, telefono);
            model_Principal.getSQL_Prepared_Statement().setString(3, email);
            model_Principal.getSQL_Prepared_Statement().setString(4, direccion);
            model_Principal.getSQL_Prepared_Statement().setInt(5, Integer.parseInt(id_cliente));
            model_Principal.Ejecutar_Actualizacion();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al modificar cliente: " + e);
        }
    }
    
    public void Eliminar_Cliente(){
        try {
            model_Principal.setSQL_String("DELETE FROM Clientes WHERE id_cliente = ?;");
            model_Principal.Preparar_Statement();
            model_Principal.getSQL_Prepared_Statement().setInt(1, Integer.parseInt(id_cliente));
            model_Principal.Ejecutar_Actualizacion();
        } 
        catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Error al eliminar cliente: " + e);
        }
    }
    
    public String getid_cliente(){
        return id_cliente;
    }
    
    public String getnombre(){
        return nombre;
    }
    
    public String gettelefono(){
        return telefono;
    }
    
    public String getemail(){
        return email;
    }
    
    public String getdireccion(){
        return direccion;
    }
    
    public void setid_cliente(String id_cliente){
        this.id_cliente = id_cliente;
    }
    
    public void setnombre(String nombre){
        this.nombre = nombre;
    }
    
    public void settelefono(String telefono){
        this.telefono = telefono;
    }
    
    public void setemail(String email){
        this.email = email;
    }
    
    public void setdireccion(String direccion){
        this.direccion = direccion;
    }
}

