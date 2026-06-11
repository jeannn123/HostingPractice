package accesoDatos;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class miClaseConexion {
    private String driver="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://localhost/SistemaRegistrosEpp";
    private String login="root";
    private String password="root";

    public Connection getConnection(){
        Connection miConexionCN=null;
        try{
            Class.forName(driver).newInstance();
            miConexionCN=DriverManager.getConnection(url,login,password);
        }catch(SQLException e){
            System.out.println(e.toString());
            miConexionCN=null;
        }catch(Exception e){
            System.out.println(e.toString());
            miConexionCN=null;
        }
        return miConexionCN;
    }
}