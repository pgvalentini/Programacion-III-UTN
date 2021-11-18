package aplicacion;

import com.google.gson.Gson;
import mananger.ControladorAgenda;
import modelo.Agenda;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("agenda")
public class AgendaRest {
    
    
    @GET                                  //GET para obtener información
    @Path("lista")                        //Path para acceder al método
    @Produces(MediaType.TEXT_HTML)       //Cómo devolverá la información (en este caso html)
     public String getContactosTxt() {
        //Ejemplo http://localhost:8080//Prog3Practico08Rest2/rest/agenda/lista
        ControladorAgenda contr = new ControladorAgenda();
        List<Agenda> contactos = new ArrayList();
        contactos = contr.getListaContactos();
        String resultado = "";
        for(Agenda agenda : contactos){
            resultado += "<tr>"
                    + "<td>" + agenda.getId() + "</td>"
                    + "<td>" + agenda.getNombre() + "</td>"
                    + "<td>" + agenda.getApellido() + "</td>"
                    + "<td>" + agenda.getTelefono() + "</td>"
                    + "<td>" + agenda.getEmail() + "</td>"
                    + "<td>" + agenda.getDomicilio() + "</td>"
                    + "<td><a href='http://localhost:8080//Prog3Practico08Rest2/rest/agenda/" + agenda.getId() + "' Borrar</a></td>" 
                    + "<td><a href='http://localhost:8080//Prog3Practico08Rest2/rest/agenda/?id=" + agenda.getId() + "' Modificar</a></td>" 
                    + "</tr>";
        }
        return "<table border=\"1\">"
                + "<tr>"
                + "<td>ID</td>"
                + "<td>Nombre</td>"
                + "<td>Apellido</td>"
                + "<td>Telefono</td>"
                + "<td>Email</td>"
                + "<td>Domicilio</td>" 
                
                + "</tr>"
                + resultado
                + "</table>";
    }
     
     
    
    @POST
    @Produces(MediaType.TEXT_HTML)
    public String crearContacto(@FormParam("nombre") String nombre,@FormParam("apellido") String apellido, @FormParam("telefono") int telefono, 
            @FormParam("email") String email, @FormParam("domicilio") String domicilio) throws SQLException {
        ControladorAgenda contr = new ControladorAgenda();
        contr.insertarContacto(nombre, apellido, telefono, email, domicilio);
        String json = new Gson().toJson(contr.getListaContactos());
        return "<A HREF='http://localhost:8080/Prog3Practico08Rest2/index.html'> volver a la página principal </A> <br> " + json;
    }
    
    @DELETE
    @Path("/{contactoId}")
    @Produces(MediaType.TEXT_HTML)
    public String deleteContacto(@PathParam("contactoId") long id){
        //Ejemplo http://localhost:8080//Prog3Practico08Rest2/rest/agenda/lista
        ControladorAgenda contr = new ControladorAgenda();
        contr.deleteContactoXId(id);
        return "<A HREF='http://localhost:8080/Prog3Practico08Rest2/index.html'> volver a la página principal </A> <br> ";
    }
    
    @PUT      //Hace un update
    @Path("/{contactoId}")
    @Consumes(MediaType.APPLICATION_JSON)     //Recibe un Json (y lo transformará a cliente)
    @Produces(MediaType.TEXT_HTML)   
    public String actualizarContacto(@PathParam("contactoId") long id, @FormParam("nombre") String nombre,@FormParam("apellido") String apellido, @FormParam("telefono") int telefono, 
            @FormParam("email") String email, @FormParam("domicilio") String domicilio) throws SQLException {
      
        ControladorAgenda contr = new ControladorAgenda();
        contr.updateContactoXId(id, nombre, apellido, telefono, email, domicilio);
        
        return "<A HREF='http://localhost:8080/Prog3Practico08Rest2/index.html'> volver a la página principal </A> <br> ";
    }
}
