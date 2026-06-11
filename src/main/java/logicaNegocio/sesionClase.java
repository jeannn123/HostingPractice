/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package logicaNegocio;

import accesoDatos.miClaseConexion;
import java.sql.*;
import java.util.Vector;

public class sesionClase {
    static public String ejecuta(String parametroSql){
        String varMensaje=null;
        try{
            miClaseConexion miObjetoClaseConexionCN= new miClaseConexion();
            Connection miObjetoConexionCN =miObjetoClaseConexionCN.getConnection();
            if(miObjetoConexionCN==null){
                varMensaje="No existe conexion";
            }else{
                Statement declararObjetoBdST =miObjetoConexionCN.createStatement();
                declararObjetoBdST.execute(parametroSql);
                declararObjetoBdST.close();
                miObjetoConexionCN.close();
            }
        }catch(SQLException e){
            varMensaje=e.getMessage();
        }catch(Exception e){
            varMensaje=e.getMessage();
        }
        return varMensaje;
    }
    
    static public Vector consulta(String parametroSql){
    Vector registrosVector =new Vector();
    try{
        miClaseConexion miObjetoClaseConexionCN= new miClaseConexion();
        Connection miObjetoConexionCN =miObjetoClaseConexionCN.getConnection();
        if(miObjetoConexionCN==null){
            registrosVector=null;
        }else{
            Statement declararObjetoBdST =miObjetoConexionCN.createStatement();
            ResultSet datosObtenidosRs =declararObjetoBdST.executeQuery(parametroSql);
            ResultSetMetaData identificaDatosObtenidos=datosObtenidosRs.getMetaData();
            int numeroColumnas =identificaDatosObtenidos.getColumnCount();
            String[] tituloColumnas=new String[numeroColumnas];
            for(int i=0; i<numeroColumnas;++i)
                tituloColumnas[i]=identificaDatosObtenidos.getColumnName(i+1);
            registrosVector.add(tituloColumnas);
            while(datosObtenidosRs.next()){
                String []registroIdentificado=new String [numeroColumnas];
                for(int i=0; i<numeroColumnas; i++){
                    registroIdentificado[i]=datosObtenidosRs.getString(i+1);
                }
                registrosVector.add(registroIdentificado);
            }
            datosObtenidosRs.close();
            declararObjetoBdST.close();
            miObjetoConexionCN.close();
        }
    }catch(SQLException e){
    e.printStackTrace();
    System.out.println("Error SQL en consulta: " + e.getMessage());
    registrosVector=null;
}catch(Exception e){
    e.printStackTrace();
    System.out.println("Error general en consulta: " + e.getMessage());
    registrosVector=null;
}
    return registrosVector;
}
    //RETORNA UNA SOLA FILA
static public String[] getFila(String parametroSql){
    Vector registrosVectorConsultados=consulta(parametroSql);
    String[]fila=null;
    if(registrosVectorConsultados!=null)
        if(registrosVectorConsultados.size()>1) //Si existen filas
            fila=(String[])registrosVectorConsultados.get(1); //En 0 estan los titulos
    return fila;
}

static public String getCampo(String parametroSql){
    String []fila=getFila(parametroSql);
    String campo=null;
    if (fila!=null) //No hay campo
        campo=fila[0];
    return campo;
}
}