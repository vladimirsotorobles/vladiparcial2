/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controllers;
import models.ModelPrincipal;
import views.*;
/**
 *
 * @author equipo hp
 */
public class ControllerPrincipal {
    private final ModelPrincipal model_Principal;
    private final ViewPeliculas view_Principal;
    
    public ControllerPrincipal(ModelPrincipal model_Principal, Object views[]){
        this.model_Principal = model_Principal;
        this.view_Principal = (ViewPrincipal) views[0];
        initView();
    }
    public void initView(){
        view_Principal.setTitle("VladiParcial2MVC");
        view_Principal.jmi_Peliculas.addActionListener(e -> jmi_PeliculasMouseClicked());
        view_Principal.jmi_salir.addActionListener(e -> jmi_salirMouseClicked());
        view_Principal.setLocationRelativeTo(null);
        view_Principal.setVisible(true);
    }
    public void jmi_PeliculasMouseClicked(){
        view_Principal.setContentPane(view_Principal);
        view_Principal.revalidate();
        view_Principal.repaint();
    }
    
}
