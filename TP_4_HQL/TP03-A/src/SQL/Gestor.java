package SQL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Gestor {

    BaseDeDatos bd = new BaseDeDatos();
    Connection conexion = bd.estableceConexion();

    public void cerrarConexion() {
        try {
            conexion.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void insertarComputadora(String codigo, String marca, String modelo, ArrayList<Componente> componentes) throws SQLException{
        PreparedStatement ps1 = null;
        
        try {
                ps1 = conexion.prepareStatement("INSERT INTO computadora (codigo, marca, modelo) VALUES (?, ?, ?)");

                ps1.setString(1, codigo);
                ps1.setString(2, marca);
                ps1.setString(3, modelo);
                ps1.executeUpdate();
                
                for(Componente c : componentes){
                    PreparedStatement ps2 = conexion.prepareStatement("INSERT INTO componente (nombre, nroSerie, idComputadora) VALUES (?, ?, ?)");
                    ps2.setString(1, c.getNombre());
                    ps2.setString(2, c.getNroSerie());
                    ps2.setLong(3, c.getIdComputadora());
                    ps2.executeUpdate();
                }
                
                
                conexion.commit();
                
                System.out.println("Computadora guardada");
                
        }catch (SQLException ex) {
                conexion.rollback();
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (ps1 != null){
                ps1.close();
            }
        } 
    }
    
    public void insertarComponente(String nombre, String nroSerie, long idComputadora) throws SQLException{
        PreparedStatement ps = null;
        try {
                

                ps.setString(1, nombre);
                ps.setString(2, nroSerie);
                ps.setLong(3, idComputadora);
                ps.executeUpdate();
                
                conexion.commit();
                
                System.out.println("Componente guardado");
                
        }catch (SQLException ex) {
            conexion.rollback();
            Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (ps != null){
                ps.close();
            }
        }
    }
}
