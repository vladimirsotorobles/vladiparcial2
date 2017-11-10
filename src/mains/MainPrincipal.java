/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mains;
import models.*;
import views.*;
import controllers.*;

/**
 *
 * @author equipo hp
 */
public class MainPrincipal {
    public static void main (String oamg[]){
        ModelPrincipal model_Principal = new ModelPrincipal();
        ModelPeliculas model_Peliculas = new ModelPeliculas(model_Principal);
        ModelClientes model_clientes = new ModelClientes(model_Principal);
        
        ViewPrincipal view_Principal = new ViewPrincipal();
        ViewPeliculas view_Peliculas = new ViewPeliculas();
        ViewClientes view_clientes= new ViewClientes();
        
        Object[] models = new Object[3];
        Object[] views = new Object[3];
        Object[] controllers = new Object[3];
        
        models[0] = model_Principal;
        models[1] = model_Peliculas;
        models[2] = model_clientes;
        
        views[0] = view_Principal;
        views[1] = view_Peliculas;
        views[2] = view_clientes;
        
        ControllerClientes controller_clientes = new ControllerClientes(models, views, controllers);
        controllers[0] = controller_clientes;
        
        ControllerPeliculas controller_Peliculas = new ControllerPeliculas(models, views, controllers);
        controllers[1] = controller_Peliculas;
        
        ControllerPrincipal ControllerPrincipal = new ControllerPrincipal(models, views, controllers);
        controllers[2] = ControllerPrincipal;
    }
}

