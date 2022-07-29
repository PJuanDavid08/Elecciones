
package Controladores;

import Clases.ClsCandidato;
import Clases.ClsMensaje;
import Modelos.MdlCandidato;
import java.util.LinkedList;
/**
 *
 * @author juand
 */
public class CtlCandidato {
    
    MdlCandidato modeloCandidato;
    
    public CtlCandidato(){
        this.modeloCandidato = new MdlCandidato();
    
    }
    
    public LinkedList<ClsCandidato> ObtenerCandidatos(){
        
        LinkedList<ClsCandidato> listaCandidatos = this.modeloCandidato.ObtenerCandidatos();
        return listaCandidatos;
    
    }
    
    public ClsMensaje agregarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = this.modeloCandidato.agregarCandidato(candidato);

        return mensaje;
    }

    public ClsMensaje eliminarCandidato(String id) {

        ClsMensaje mensaje = this.modeloCandidato.eliminarCandidato(id);

        return mensaje;
    }

    public ClsMensaje actualizarCandidato(ClsCandidato candidato) {

        ClsMensaje mensaje = this.modeloCandidato.actualizarCandidato(candidato);

        return mensaje;
    }

}
