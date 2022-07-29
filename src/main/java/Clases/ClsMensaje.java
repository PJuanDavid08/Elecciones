package Clases;

import javax.swing.JOptionPane;

/**
 *
 * @author juand
 */
public class ClsMensaje {
    
    public final static String OK = "OK";
    public final static String ERROR = "ERORR";
    public final static String ADVERTENCIA = "ADVERTENCIA";
    
    private String tipo;
    private String texto;

    public ClsMensaje(String tipo, String texto) {
        this.tipo = tipo;
        this.texto = texto;
    }

    public String getTipo() {
        return tipo;
    }

    public String getTexto() {
        return texto;
    }
    
    public void mostrarMensaje() {

      JOptionPane.showMessageDialog(null, this.getTexto());

    }
    
}
