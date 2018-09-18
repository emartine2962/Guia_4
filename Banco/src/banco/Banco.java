
package banco;

/**
 *
 * @author Edgar
 * Clase para el manejar el funcionamiento de un banco
 */
import java.util.*;

public class Banco {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        InformacionBanco.abrirConexión();
        System.out.println("Conexion Realizada");
        
        List<Usuarios> losUsuarios = InformacionBanco.obtenerCuentas();
        for (Usuarios u : losUsuarios) {
            System.out.println(u);
        }
        
        InformacionBanco.cerrarConexión();   
    }
    
}
