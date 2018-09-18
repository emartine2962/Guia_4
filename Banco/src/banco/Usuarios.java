/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package banco;

/**
 * Clase para manejar los datos de un usuario
 * @author Edga
 */
public class Usuarios {
    private int numeroCuenta;
    private String nombreTitular;
    private String apellidoTitular;
    private int cedulaTitular;
    private double monto;

    public Usuarios(int numeroCuenta, String nombreTitular, String apellidoTitular, int cedulaTitular, double monto) {
        this.numeroCuenta = numeroCuenta;
        this.nombreTitular = nombreTitular;
        this.apellidoTitular = apellidoTitular;
        this.cedulaTitular = cedulaTitular;
        this.monto = monto;
    }

    
    //-----------------------------------GETTERS-----------------------------------    
    public int getNumeroCuenta() {
        return numeroCuenta;
    }

    public String getNombreTitular() {
        return nombreTitular;
    }

    public String getApellidoTitular() {
        return apellidoTitular;
    }

    public int getCedulaTitular() {
        return cedulaTitular;
    }

    public double getMonto() {
        return monto;
    }
    
    //-----------------------------------SETTERS-----------------------------------

    public void setNumeroCuenta(int numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    public void setNombreTitular(String nombreTitular) {
        this.nombreTitular = nombreTitular;
    }

    public void setApellidoTitular(String apellidoTitular) {
        this.apellidoTitular = apellidoTitular;
    }

    public void setCedulaTitular(int cedulaTitular) {
        this.cedulaTitular = cedulaTitular;
    }

    public void setMonto(double monto) {
        this.monto = monto;
    }
    
    //-----------------------------------PRINT OUT-----------------------------------

    @Override
    public String toString() {
        return "Usuarios{" + "numeroCuenta=" + numeroCuenta + ", nombreTitular=" + nombreTitular + ", apellidoTitular=" + apellidoTitular + ", cedulaTitular=" + cedulaTitular + ", monto=" + monto + '}';
    }
    
}

