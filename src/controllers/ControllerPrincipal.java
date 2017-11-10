/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.*;
import views.*;
/**
 *
 * @author equipo hp
 */
public class ControllerPrincipal {
    private final ModelPeliculas model_Peliculas;
    private final ModelClientes model_clientes;
    private final ViewPrincipal view_Principal;
    private final ViewPeliculas view_Peliculas;
    private final ViewClientes view_clientes;
    private final ControllerClientes controller_clientes;
    private final ControllerPeliculas controller_Peliculas;
    
    public ControllerPrincipal(Object models[], Object views[], Object controllers[]){
        this.model_Peliculas = (ModelPeliculas)models[1];
        this.model_clientes = (ModelClientes)models[2];
        this.view_Principal = (ViewPrincipal)views[0];
        this.view_Peliculas = (ViewPeliculas)views[1];
        this.view_clientes = (ViewClientes)views[2];
        this.controller_clientes = (ControllerClientes)controllers[0];
        this.controller_Peliculas = (ControllerPeliculas)controllers[1];
        initView();
    }
    
    public void initView(){
        view_Principal.setTitle("Blockbuster");
        view_Principal.setLocationRelativeTo(null);
        view_Principal.setVisible(true);
        view_Principal.jmi_Peliculas.addActionListener(e ->jmi_PeliculasMouseClicked());
        view_Principal.jmi_Cliente.addActionListener(e -> jmi_ClienteMouseClicked());
    }
    
    public void jmi_PeliculasMouseClicked(){
        view_Principal.setContentPane(view_Peliculas);
        view_Principal.revalidate();
        view_Principal.repaint();
        controller_Peliculas.Actualizar_Interfaz();
    }
    
    public void jmi_ClienteMouseClicked(){
        view_Principal.setContentPane(view_clientes);
        view_Principal.revalidate();
        view_Principal.repaint();
        controller_clientes.Actualizar_Interfaz();
    }
}
