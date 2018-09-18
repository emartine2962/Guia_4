/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

import java.sql.*;
import java.util.*;


/**
 * Mantiene la informacion del Banco
 * @author Edga
 */
public class InformacionBanco {
    private String nombreBanco;
    private String direccionBanco;
    private int telefonoBanco;

    public InformacionBanco(String nombreBanco, String direccionBanco, int telefonoBanco) {
        this.nombreBanco = nombreBanco;
        this.direccionBanco = direccionBanco;
        this.telefonoBanco = telefonoBanco;
    }
    
    //-----------------------------------GETTERS----------------------------------- 

    public String getNombreBanco() {
        return nombreBanco;
    }

    public String getDireccionBanco() {
        return direccionBanco;
    }

    public int getTelefonoBanco() {
        return telefonoBanco;
    }
    
    //-----------------------------------PRINT OUT----------------------------------- 

    @Override
    public String toString() {
        return "InformacionBanco{" + "nombreBanco=" + nombreBanco + ", direccionBanco=" + direccionBanco + ", telefonoBanco=" + telefonoBanco + '}';
    }
    
    //-----------------------------------CONEXION------------------------------------
    static Connection conexión;
    
    public static void abrirConexión() {
        try {
            Class.forName("org.h2.Driver");
            conexión = DriverManager.getConnection("jdbc:h2:c:/temp/banco", "sa", "");
        }
        catch(Exception ex) {
            conexión = null;
            System.err.println( "Error de conexión con la BD" );
            ex.printStackTrace();
        }
    }
    
    public static void cerrarConexión() {
        try {
            if (conexión != null) {
                conexión.close();
            }
        }
        catch (Exception ex) {}
    }    
    
    //----------------------------Guardar Cuenta-------------------------
    
    public static void guardarCuenta(Usuarios u) {
        PreparedStatement ps;
        String sql = "INSERT INTO CUENTAS VALUES (?, ?, ?, ?, ?)";
        
        try {
            ps = conexión.prepareStatement(sql);
            ps.setInt(1, u.getNumeroCuenta());
            ps.setString(2, u.getNombreTitular());
            ps.setString(3, u.getApellidoTitular());
            ps.setInt(4, u.getCedulaTitular());
            ps.setDouble(5, u.getMonto());
            
            ps.executeUpdate();
            
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
            
        
    }
    
    public static List<Usuarios> obtenerCuentas(){
        List<Usuarios> user = new ArrayList<>();
        try {
            Statement st;
            String sql = "SELECT * FROM CUENTAS";
            
            st = conexión.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while (rs.next()) {
                int numeroCuenta = rs.getInt("NUMEROCUENTA");
                String nombreTitular = rs.getString("NOMBRETITULAR");
                String apellidoTitular = rs.getString("APELLIDOTITULAR");
                int cedulaTitular = rs.getInt("CEDULATITULAR");
                int monto = rs.getInt("MONTO");
                
                Usuarios usu = new Usuarios(numeroCuenta, nombreTitular, apellidoTitular, cedulaTitular, monto);
                user.add(usu);
            }
            rs.close();
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
        return user;
    }
    
    
        public static void modificarCuenta(Usuarios u) {
        PreparedStatement ps;
        String sql = "UPDATE CUENTAS SET NOMBRETITULAR = (?), APELLIDOTITULAR = (?), CEDULATITULAR = (?), MONTO = (?) WHERE NUMEROCUENTA = (?)";
        
        try {
            ps = conexión.prepareStatement(sql);
            ps.setString(1, u.getNombreTitular());
            ps.setString(2, u.getApellidoTitular());
            ps.setInt(3, u.getCedulaTitular());
            ps.setDouble(4, u.getMonto());
            ps.setInt(5, u.getNumeroCuenta());
            
            ps.executeUpdate();
            
            
        }
        catch (Exception ex) {
            ex.printStackTrace();
        }
            
        
    }
}
