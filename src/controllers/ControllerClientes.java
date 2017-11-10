/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelPrincipal;
import models.ModelClientes;
import views.ViewClientes;
/**
 *
 * @author equipo hp
 */
public class ControllerClientes {
    private final ModelPrincipal model_Principal;
    private final ModelClientes model_Clientes;
    private final ViewClientes view_Clientes;
    
    public ControllerClientes(Object models[], Object views[], Object controllers[]){
        this.model_Principal = (ModelPrincipal)models[0];
        this.model_Clientes = (ModelClientes)models[2];
        this.view_Clientes = (ViewClientes)views[2];
        initView();
    }
    
    public void initView(){
        view_Clientes.jButton_primero1.addActionListener(e -> jButton_primero1MouseClicked());
        view_Clientes.jButton_anterior1.addActionListener(e -> jButton_anterior1MouseClicked());
        view_Clientes.jButton_siguiente1.addActionListener(e -> jButton_siguiente1MouseClicked());
        view_Clientes.jButton_ultimo1.addActionListener(e -> jButton_ultimo1MouseClicked());
        view_Clientes.jButton1_Almacenar1.addActionListener(e -> jButton1_Almacenar1MouseClicked());
        view_Clientes.jButton2_Modificar1.addActionListener(e -> jButton2_Modificar1MouseClicked());
        view_Clientes.jButton3_Eliminar1.addActionListener(e -> jButton3_Eliminar1MouseClicked());
        view_Clientes.jButton1_nuevo1.addActionListener(e -> jButton1_nuevo1MouseClicked());
        view_Clientes.jTextField1_id_cliente.setEnabled(false);
    }
    
    public void getDatos(){
        view_Clientes.jTextField1_id_cliente.setText(model_Clientes.getid_cliente());
        view_Clientes.jTextField2_nombre.setText(model_Clientes.getnombre());
        view_Clientes.jTextField3_telefono.setText(model_Clientes.gettelefono());
        view_Clientes.jTextField4_email.setText(model_Clientes.getemail());
        view_Clientes.jTextField5_direccion.setText(model_Clientes.getdireccion());
    }
    
    public void setDatos(){
        model_Clientes.setid_cliente(view_Clientes.jTextField1_id_cliente.getText());
        model_Clientes.setnombre(view_Clientes.jTextField2_nombre.getText());
        model_Clientes.settelefono(view_Clientes.jTextField3_telefono.getText());
        model_Clientes.setemail(view_Clientes.jTextField4_email.getText());
        model_Clientes.setdireccion(view_Clientes.jTextField5_direccion.getText());
    }
    
    public void Actualizar_Interfaz() {
        model_Clientes.Actualizar_Datos();
        getDatos();
    }
    
    public void jButton_primero1MouseClicked(){
        model_Principal.Mover_Primero();
        model_Clientes.Asignar_Datos();
        getDatos();
    }
    
    public void jButton_anterior1MouseClicked(){
        model_Principal.Mover_Anterior();
        model_Clientes.Asignar_Datos();
        getDatos();
    }
    
    public void jButton_siguiente1MouseClicked(){
        model_Principal.Mover_Siguiente();
        model_Clientes.Asignar_Datos();
        getDatos();
    }
    
    public void jButton_ultimo1MouseClicked(){
        model_Principal.Mover_Ultimo();
        model_Clientes.Asignar_Datos();
        getDatos();
    }
    
    public void jButton1_Almacenar1MouseClicked(){
        setDatos();
        model_Clientes.Insertar_Cliente();
        Actualizar_Interfaz();
    }
    
    public void jButton2_Modificar1MouseClicked(){
        setDatos();
        model_Clientes.Modificar_Cliente();
        Actualizar_Interfaz();
    }
    
    public void jButton3_Eliminar1MouseClicked(){
        model_Clientes.setid_cliente(view_Clientes.jTextField1_id_cliente.getText());
        model_Clientes.Eliminar_Cliente();
        Actualizar_Interfaz();
    }
    
    public void jButton1_nuevo1MouseClicked(){
        view_Clientes.jTextField1_id_cliente.setText("");
        view_Clientes.jTextField2_nombre.setText("");
        view_Clientes.jTextField3_telefono.setText("");
        view_Clientes.jTextField4_email.setText("");
        view_Clientes.jTextField5_direccion.setText("");
    }
    
}


