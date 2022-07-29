
package Clases;

/**
 *
 * @author juand
 */
public class ClsVoto {
    
    private String idVoto;
    private String idEleccion;
    private String idCandidato;
    private String idVotante;

    public ClsVoto(String idVoto, String idEleccion, String idCandidato, String idVotante) {
        this.idVoto = idVoto;
        this.idEleccion = idEleccion;
        this.idCandidato = idCandidato;
        this.idVotante = idVotante;
    }

    public String getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(String idVoto) {
        this.idVoto = idVoto;
    }

    public String getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(String idEleccion) {
        this.idEleccion = idEleccion;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(String idVotante) {
        this.idVotante = idVotante;
    }

 

}


