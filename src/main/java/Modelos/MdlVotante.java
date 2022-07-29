package Modelos;

import Clases.ClsCandidato;
import Clases.ClsJdbc;
import Clases.ClsMensaje;
import Clases.ClsVotante;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.LinkedList;

/**
 *
 * @author juand
 */
public class MdlVotante {
    
ClsJdbc jdbc;

    public MdlVotante() {

        this.jdbc = new ClsJdbc();
        this.jdbc.CrearConexion();

    }
public ClsMensaje agregarVotante(ClsVotante votante) {
        
        ClsMensaje mensaje;
        try {
            
            String sql = "INSERT INTO tbl_votantes VALUES (?, ?, ?, ?, ?)";
            PreparedStatement sentencia = this.jdbc.conexion.prepareCall(sql);
            sentencia.setString(1, votante.getNumeroCedula());
            sentencia.setString(2, votante.getNombre());
            sentencia.setString(3, votante.getCorreo());
            sentencia.setString(4, votante.getTelefono());
            sentencia.setString(5, votante.getDireccion());
 
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has creado un candidato exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }   

 public LinkedList<ClsVotante> obtenerVotantes(){

        try {
            LinkedList<ClsVotante> lista = new LinkedList<>();
            
            String consulta = "SELECT * FROM tbl_votantes";
            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(consulta);
            ResultSet resultados = sentencia.executeQuery();

            while(resultados.next()){

                
                String cedula = resultados.getString("id_votante");
                String nombre = resultados.getString("nombre");
                String correo = resultados.getString("correo");
                String telefono = resultados.getString("telefono");
                String direccion = resultados.getString("direccion");

                ClsVotante votante = new ClsVotante(cedula, nombre, correo, telefono, correo, direccion);
                lista.add(votante);
            }

            return lista;

        } catch (Exception e) {

            return null;
        }

    }
  public ClsMensaje eliminarVotante(String id) {

        ClsMensaje mensaje;

        try {
            String sql = "DELETE FROM tbl_votantes WHERE id_votante = ?";

            PreparedStatement sentencia = this.jdbc.conexion.prepareStatement(sql);
            sentencia.setString(1, id);

            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Has eliminado un votante exitosamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
  
  public ClsMensaje actualizarVotante(ClsVotante votante) {
        
        ClsMensaje mensaje;
        try {
            
            String sql = "UPDATE tbl_votantes SET nombre = ?, correo = ?, telefono = ?, " +
                    "direccion = ? WHERE id_votante = ?";
            PreparedStatement sentencia = this.jdbc.conexion.prepareCall(sql);
            
            sentencia.setString(1, votante.getNombre());
            sentencia.setString(2, votante.getCorreo());
            sentencia.setString(3, votante.getTelefono());
            sentencia.setString(4, votante.getDireccion());
            sentencia.setString(5, votante.getNumeroCedula());
            
            int resultado = sentencia.executeUpdate();

            if (resultado >= 1) {

                mensaje = new ClsMensaje(ClsMensaje.OK, "Se ha actualizado correctamente");
                return mensaje;
            }

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error");
            return mensaje;

        } catch (Exception excepcion) {

            mensaje = new ClsMensaje(ClsMensaje.ERROR, "Uy ocurrió un error: " + excepcion.getMessage());
            return mensaje;
        }

    }
  
}
