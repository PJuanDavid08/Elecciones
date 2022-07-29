
package Modelos;


import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVoto;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author juand
 */
public class MdlVoto {
        ClsJdbc jdbc;

    public MdlVoto() {

        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();
    }

    public ClsMensaje agregarVoto(ClsVoto voto) {
        
        ClsMensaje mensaje;
        try {
            
            String sql = "INSERT INTO tbl_votos VALUES (?, ?, ?, ?, NOW())";
            PreparedStatement sentencia = this.jdbc.conexion.prepareCall(sql);
            sentencia.setString(1, voto.getIdVoto());
            sentencia.setString(2, voto.getIdEleccion());
            sentencia.setString(3, voto.getIdCandidato());
            sentencia.setString(4, voto.getIdVotante());

            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has Votado correctamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }  
    
    
    public LinkedList<ClsVoto> obtenerResultados(){

        try {
            LinkedList<ClsVoto> lista = new LinkedList<>();
            
            String consulta = "SELECT * FROM tbl_votos";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while(resultados.next()){

                
                String idVoto = resultados.getString("id_votos");
                String idEleccion = resultados.getString("id_eleccions");
                String idCandidato = resultados.getString("id_candidatos");
                String idVotante = resultados.getString("id_votantes");

            
                ClsVoto voto = new ClsVoto(idVoto, idEleccion, idCandidato, idVotante);
            
                lista.add(voto);
            }

            return lista;

        } catch (Exception e) {

            return null;
        }

    }

}


