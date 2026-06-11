/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

/**
 *
 * @author USER
 */
public class mantenimientoUsuarioClase {
   

    public mantenimientoUsuarioClase() {
        this.varCodigo="";
        this.varUsuario="";
        this.varNombres="";
        this.varApellidos="";
    }

    public mantenimientoUsuarioClase(String varCodigo, String varUsuario, String varPassword, String varNombres, String varApellidos) {
        this.varCodigo = varCodigo;
        this.varUsuario = varUsuario;
        this.varPassword = varPassword;
        this.varNombres = varNombres;
        this.varApellidos = varApellidos;
    }
    
    

    public void setVarCodigo(String varCodigo) {
        this.varCodigo = varCodigo;
    }

    public void setVarUsuario(String varUsuario) {
        this.varUsuario = varUsuario;
    }

    public void setVarPassword(String varPassword) {
        this.varPassword = varPassword;
    }

    public void setVarNombres(String varNombres) {
        this.varNombres = varNombres;
    }

    public void setVarApellidos(String varApellidos) {
        this.varApellidos = varApellidos;
    }

    public String getVarCodigo() {
        return varCodigo;
    }

    public String getVarUsuario() {
        return varUsuario;
    }

    public String getVarPassword() {
        return varPassword;
    }

    public String getVarNombres() {
        return varNombres;
    }

    public String getVarApellidos() {
        return varApellidos;
    }
    
     private String varCodigo;
    private String varUsuario;
    private String varPassword;
    private String varNombres;
    private String varApellidos;
    
    
}
