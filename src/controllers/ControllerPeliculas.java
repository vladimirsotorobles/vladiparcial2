/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelPrincipal;
import models.ModelPeliculas;
import views.ViewPeliculas;

/**
 *
 * @author equipo hp
 */
public class ControllerPeliculas {
    private final ModelPrincipal model_Principal;
    private final ModelPeliculas model_peliculas;
    private final ViewPeliculas view_peliculas;
    
     public ControllerPeliculas(Object models[], Object views[], Object controllers[]){
        this.model_Principal = (ModelPrincipal)models[0];
        this.model_peliculas = (ModelPeliculas)models[1];
        this.view_peliculas = (ViewPeliculas)views[1];
        initView();
    }
        
     public void initView(){
        view_peliculas.jButton_primero.addActionListener(e -> jButton_primeroMouseClicked());
        view_peliculas.jButton_anterior.addActionListener(e -> jButton_anteriorMouseClicked());
        view_peliculas.jButton_siguiente.addActionListener(e -> jButton_siguienteMouseClicked());
        view_peliculas.jButton_ultimo.addActionListener(e -> jButton_ultimoMouseClicked());
        view_peliculas.jButton1_Almacenar.addActionListener(e -> jButton1_AlmacenarMouseClicked());
        view_peliculas.jButton2_Modificar.addActionListener(e -> jButton2_ModificarMouseClicked());
        view_peliculas.jButton3_Eliminar.addActionListener(e -> jButton3_EliminarMouseClicked());
        view_peliculas.jButton1_nuevo.addActionListener(e -> jButton1_nuevoMouseClicked());
        view_peliculas.jTextField1_id_pelicula.setEnabled(false);
    }
    
    public void getDatos(){
        view_peliculas.jTextField1_id_pelicula.setText(model_peliculas.getid_pelicula());
        view_peliculas.jTextField2_NOMBRE.setText(model_peliculas.getnombre());
        view_peliculas.jcb_formato.setSelectedItem(model_peliculas.getformato());
        view_peliculas.jTextField5_DURACION.setText(model_peliculas.getduracion());
        view_peliculas.jTextField3_GENERO.setText(model_peliculas.getgenero());
    }
    
    public void setDatos(){
        model_peliculas.setid_pelicula(view_peliculas.jTextField1_id_pelicula.getText());
        model_peliculas.setnombre(view_peliculas.jTextField2_NOMBRE.getText());
        model_peliculas.setformato("" + view_peliculas.jcb_formato.getSelectedItem());
        model_peliculas.setduracion(view_peliculas.jTextField5_DURACION.getText());
        model_peliculas.setgenero(view_peliculas.jTextField3_GENERO.getText());
    }
    
    public void Actualizar_Interfaz(){
        model_peliculas.Actualizar_Datos();
        getDatos();
    }
    
    public void jButton_primeroMouseClicked(){
        model_Principal.Mover_Primero();
        model_peliculas.Asignar_Datos();
        getDatos();
        
    }
    
    public void jButton_anteriorMouseClicked(){
        model_Principal.Mover_Anterior();
        model_peliculas.Asignar_Datos();
        getDatos();
    }
    
    public void jButton_siguienteMouseClicked(){
        model_Principal.Mover_Siguiente();
        model_peliculas.Asignar_Datos();
        getDatos();
    }
    
    public void jButton_ultimoMouseClicked(){
        model_Principal.Mover_Ultimo();
        model_peliculas.Asignar_Datos();
        getDatos();
    }
    
    public void jButton1_AlmacenarMouseClicked(){
        setDatos();
        model_peliculas.Insertar_Pelicula();
        Actualizar_Interfaz();
    }
    
    public void jButton2_ModificarMouseClicked(){
        setDatos();
        model_peliculas.Modificar_Pelicula();
        Actualizar_Interfaz();
    }
    
    public void jButton3_EliminarMouseClicked(){
        model_peliculas.setid_pelicula(view_peliculas.jTextField1_id_pelicula.getText());
        model_peliculas.Eliminar_Pelicula();
        Actualizar_Interfaz();
    }
    
    public void jButton1_nuevoMouseClicked(){
        view_peliculas.jTextField1_id_pelicula.setText("");
        view_peliculas.jTextField2_NOMBRE.setText("");
        view_peliculas.jcb_formato.setSelectedItem("DVD");
        view_peliculas.jTextField5_DURACION.setText("");
        view_peliculas.jTextField3_GENERO.setText("");
    }
    
}
