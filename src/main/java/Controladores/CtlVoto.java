
package Controladores;

import Clases.ClsMensaje;
import Clases.ClsVoto;
import Modelos.MdlVoto;
import java.util.LinkedList;



/**
 *
 * @author juand
 */
public class CtlVoto {
    
     MdlVoto modeloVoto;
    
    public CtlVoto(){
        this.modeloVoto = new MdlVoto();
    
    }
      
    public ClsMensaje agregarVoto(ClsVoto voto) {

        ClsMensaje mensaje = this.modeloVoto.agregarVoto(voto);

        return mensaje;
    }
  
    public LinkedList<ClsVoto> obtenerResultados(){
        
        LinkedList<ClsVoto> listaResultados = this.modeloVoto.obtenerResultados();
        return listaResultados;
    
    }

    
}
