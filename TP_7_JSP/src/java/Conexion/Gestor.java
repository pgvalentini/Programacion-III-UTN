package Conexion;

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

    public void insertarPersona(String dni, String nombre, String domicilio) throws SQLException{
        PreparedStatement ps1 = null;
        
        try {
                ps1 = conexion.prepareStatement("INSERT INTO persona (dni, nombre, domicilio) VALUES (?, ?, ?)");

                ps1.setString(1, dni);
                ps1.setString(2, nombre);
                ps1.setString(3, domicilio);
                ps1.executeUpdate();              
                
                conexion.commit();
                
                System.out.println("Persona guardada");
                
        }catch (SQLException ex) {
                conexion.rollback();
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (ps1 != null){
                ps1.close();
            }
        }
    }
    
    public List<Persona> consultarPersonas() throws SQLException{
        PreparedStatement ps1 = null;
        ResultSet rs = null;
        Persona persona;
        List<Persona> personas = new ArrayList<>();
        
        try {
                ps1 = conexion.prepareStatement("SELECT * FROM persona");
                
                rs = ps1.executeQuery();        
                
                 while (rs.next()) {
                persona = new Persona();

                persona.setDni(rs.getString(1));
                persona.setNombre(rs.getString(2));
                persona.setDomicilio(rs.getString(3));

                personas.add(persona);

            }
                
        }catch (SQLException ex) {
                conexion.rollback();
                Logger.getLogger(BaseDeDatos.class.getName()).log(Level.SEVERE, null, ex);
        }finally{
            if (ps1 != null){
                ps1.close();
            }
        }
        return personas;
    }
}
