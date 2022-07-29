/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controladores;

import Clases.ClsCandidato;
import Clases.ClsEleccion;
import Clases.ClsMensaje;
import Modelos.MdlEleccion;
import java.util.LinkedList;

/**
 *
 * @author juand
 */
public class CtlEleccion {
    
    MdlEleccion modelo;

    public CtlEleccion() {
        this.modelo = new MdlEleccion();
    }

    public ClsMensaje agregarEleccion(ClsEleccion eleccion) {

        return this.modelo.agregarEleccion(eleccion);

    }

    public LinkedList<ClsEleccion> obtenerElecciones() {

        return this.modelo.obtenerElecciones();

    }

    public ClsMensaje asociarCandidato(String idCandidato, String idEleccion) {

        return this.modelo.asociarCandidato(idCandidato, idEleccion);

    }

    public LinkedList<ClsCandidato> obtenerCandidatosEleccion(String idEleccion) {

        return this.modelo.obtenerCandidatosEleccion(idEleccion);

    }
    
    public ClsMensaje actualizarEleccion(ClsEleccion eleccion) {

        ClsMensaje mensaje = this.modelo.actualizarEleccion(eleccion);

        return mensaje;
    }
}