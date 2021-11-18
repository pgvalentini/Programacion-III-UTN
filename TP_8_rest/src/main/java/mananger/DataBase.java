package mananger;

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBase {
    
   private Connection conexion = null;
    private String user = "root";
    private String password = "root";
    private String puerto = "3306";
    private String catalogo = "restdb?serverTimezone=UTC";
    private String host = "localhost";

    public Connection estableceConexion() {
        if (conexion != null) {
            return conexion;
        }
        try {
            Class.forName("com.mysql.jdbc.Driver");
            String urlConexion = "jdbc:mysql://" + host + ":" + puerto + "/" + catalogo;
            conexion = DriverManager.getConnection(urlConexion, user, password);
            conexion.setAutoCommit(false);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conexion;
    }

    public void cierraConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}