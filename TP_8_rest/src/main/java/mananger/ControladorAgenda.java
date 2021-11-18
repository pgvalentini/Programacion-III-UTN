package mananger;

import modelo.Agenda;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ControladorAgenda {
    
    DataBase bd = new DataBase();
    Connection conexion = bd.estableceConexion();
    
    
    
    public void insertarContacto(String nombre, String apellido, int telefono, String email, String domicilio) throws SQLException{
        PreparedStatement ps = null;
        
        try {
            
            ps = conexion.prepareStatement("INSERT INTO agenda (nombre, apellido, telefono, email, domicilio) VALUES (?, ?, ?, ?, ?)");
            ps.setString(2, nombre);
            ps.setString(3, apellido);
            ps.setInt(4, telefono);
            ps.setString(5, email);
            ps.setString(6, domicilio);
            ps.executeUpdate();
            conexion.commit();
            
            //return true;
        } catch (SQLException e) {
            conexion.rollback();
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
            //return false;
        } catch (Exception e){
            conexion.rollback();
            Logger.getLogger(DataBase.class.getName()).log(Level.SEVERE, null, e);
            //return false;
        }  
        finally {
            if(ps!=null) ps.close();
        }
    }
    
    public List<Agenda> getListaContactos(){
        ResultSet rs = null;
        Agenda agenda = new Agenda();
        List <Agenda> contactos = new ArrayList();
        
        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT * FROM prog3practico6.persona");
            while(rs.next()){
                agenda = new Agenda();
                agenda.setId(rs.getLong("id"));
                agenda.setNombre(rs.getString("nombre"));
                agenda.setApellido(rs.getString("apellido"));
                agenda.setTelefono(rs.getInt("telefono"));
                agenda.setEmail(rs.getString("email"));
                agenda.setDomicilio(rs.getString("domicilio"));
                

                contactos.add(agenda);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return contactos;
    }
    
    public Agenda getContactoXId(long id) {
        for(Agenda a : getListaContactos()){
            if(a.getId() == id){
                return a;
            }
        }
        return null;
    }
    
    
    public void deleteContactoXId(long id) {
        //DELETE FROM table_name WHERE condition;
        
        ResultSet rs = null;
                
        try {
            PreparedStatement s = conexion.prepareStatement("DELETE FROM restdb.agenda WHERE id='" + id + "'");
            s.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
    }
    
    

    
    public void updateContactoXId(long id, String nombre, String apellido, int telefono, String email, String domicilio) {
        try {
            PreparedStatement s = conexion.prepareStatement("UPDATE restdb.agenda SET nombre=" + nombre + ", apellido=" + apellido + ", telefono=" + telefono + ", email=" + email + ", domicilio=" + domicilio  + " WHERE id='" + id + "'");
            s.executeUpdate();
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
