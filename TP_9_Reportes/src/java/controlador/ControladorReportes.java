package controlador;

import conexion.BaseDeDatos;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import modelo.Reporte;

public class ControladorReportes {
    
    BaseDeDatos bd = new BaseDeDatos();
    Connection conexion = bd.estableceConexion();
    
    public List<String> getListaRegiones(){
        ResultSet rs = null;
        String region;
        List <String> regiones = new ArrayList();
        
        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT DISTINCT region FROM world.country");
            while(rs.next()){
                region = rs.getString("region");
                regiones.add(region);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return regiones;
    }
    
    public List<Reporte> getReporte(String nombreRegion, String nombrePais){
        ResultSet rs = null;
        Reporte reporte = new Reporte();
        List<Reporte> reportes = new ArrayList();
        try {
            Statement s = conexion.createStatement();
            rs = s.executeQuery("SELECT city.name, city.population, country.name as pais, city.district "
                    + "FROM world.city INNER JOIN world.country ON city.CountryCode = country.code "
                    + "WHERE country.region = '" + nombreRegion + "' "
                            + "AND country.name LIKE '%" + nombrePais + "%' ORDER BY country.name");
            while(rs.next()){
                reporte = new Reporte();
                reporte.setCiudad(rs.getString(1));
                reporte.setPoblacion(rs.getString(2));
                reporte.setPais(rs.getString(3));
                reporte.setRegion(rs.getString(4));
                
                reportes.add(reporte);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return reportes;
    }
    
}
