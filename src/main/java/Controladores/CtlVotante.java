package Controladores;


import Clases.ClsMensaje;
import Clases.ClsVotante;
import Modelos.MdlVotante;
import java.util.LinkedList;

/**
 *
 * @author juand
 */
public class CtlVotante {
    
    MdlVotante modelovotante;
    
    public CtlVotante(){
        this.modelovotante = new MdlVotante();
    
    }
    
    public LinkedList<ClsVotante> obtenerVotantes(){
        
        LinkedList<ClsVotante> listaVotantes = this.modelovotante.obtenerVotantes();
        return listaVotantes;
    
    }
    
    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modelovotante.agregarVotante(votante);

        return mensaje;
    } 
    
        public ClsMensaje eliminarVotante(String id) {

        ClsMensaje mensaje = this.modelovotante.eliminarVotante(id);

        return mensaje;
    }

    public ClsMensaje actualizarVotante(ClsVotante votante) {

        ClsMensaje mensaje = this.modelovotante.actualizarVotante(votante);

        return mensaje;
        
    }
}
