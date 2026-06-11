package accesoDatos;

import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;

public class miClaseConexion {
    private String driver="com.mysql.cj.jdbc.Driver";
    private String url="jdbc:mysql://mysql-23526b-jeanmarcosdioniciohuayta-a635.f.aivencloud.com:10622/defaultdb?sslMode=REQUIRED";
    private String login="avnadmin";
    private String password="AVNS_ArH-5KhygEv1ABiCmm_";

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