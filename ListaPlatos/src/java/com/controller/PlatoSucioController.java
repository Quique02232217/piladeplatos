package com.controller;

import com.modelo.Plato;
import javax.faces.bean.ManagedBean;
import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author User
 */
@ManagedBean
@SessionScoped
public class PlatoSucioController {

    private List<Plato> listaplatosentregados = new ArrayList<>();
    private Stack<Plato> piladeplatosentregados = new Stack<>();
    private List<Plato> listadeplatosenproceso = new ArrayList<>();
    private List<Plato> listadeplatoslimpios = new ArrayList<>();
    private List<Plato> listadeplatosdañados = new ArrayList<>();
    
    private Plato platoentregado = new Plato("sucio");
    
    public PlatoSucioController() {
    }
    
    public void limpiarPlatos(Plato platolimpio){
        listadeplatosenproceso.remove(platolimpio);
        listadeplatoslimpios.add(platolimpio);
        platolimpio = new Plato("Limpio");
    }
    
    public void identificarPlatosDañados(Plato platodañado){
        listadeplatosenproceso.remove(platodañado);
        listadeplatosdañados.add(platodañado);
        platodañado = new Plato("Dañado");
    }
    
    public void identificarPlatosnolimpios(Plato platonolimpio){
        listadeplatosenproceso.remove(platonolimpio);
        piladeplatosentregados.push(platonolimpio);
        
    }
    
    
    
    public void procesarPlatos(Plato platoProceso){
        piladeplatosentregados.pop();
        listadeplatosenproceso.add(platoProceso);
    }

    public Plato agregarALaTablaEntregados() {
        listaplatosentregados.add(platoentregado);
        return platoentregado = new Plato("sucio");
    }

    public Plato agregarAlaPilaParaLavar(Plato pla) {
        piladeplatosentregados.push(pla);
        listaplatosentregados.remove(pla);
        return pla;
    }

    public List<Plato> getListadeplatoslimpios() {
        return listadeplatoslimpios;
    }

    public void setListadeplatoslimpios(List<Plato> listadeplatoslimpios) {
        this.listadeplatoslimpios = listadeplatoslimpios;
    }

    public List<Plato> getListadeplatosdañados() {
        return listadeplatosdañados;
    }

    public void setListadeplatosdañados(List<Plato> listadeplatosdañados) {
        this.listadeplatosdañados = listadeplatosdañados;
    }
    
    

    public List<Plato> getListadeplatosenproceso() {
        return listadeplatosenproceso;
    }

    public void setListadeplatosenproceso(List<Plato> listadeplatosenproceso) {
        this.listadeplatosenproceso = listadeplatosenproceso;
    }
    

    public Stack<Plato> getPiladeplatosentregados() {
        return piladeplatosentregados;
    }

    public void setPiladeplatosentregados(Stack<Plato> piladeplatosentregados) {
        this.piladeplatosentregados = piladeplatosentregados;
    }

    public List<Plato> getListaplatosentregados() {
        return listaplatosentregados;
    }

    public void setListaplatosentregados(List<Plato> listaplatosentregados) {
        this.listaplatosentregados = listaplatosentregados;
    }

    public Plato getPlatoentregado() {
        return platoentregado;
    }

    public void setPlatoentregado(Plato platoentregado) {
        this.platoentregado = platoentregado;
    }

}
