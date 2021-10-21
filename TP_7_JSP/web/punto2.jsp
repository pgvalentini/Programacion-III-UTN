<%@page import="Conexion.BaseDeDatos"%>
<%@page import="Conexion.Gestor"%>
<%@page import="Conexion.Persona"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<table border="1">
<%

String dni = null, nombre = null, domicilio = null;
Gestor gestor = new Gestor();
List<Persona> personas = new ArrayList<Persona>();

    if(request.getParameter("dni") != null){
        dni = request.getParameter("dni");
    }
    
    if(request.getParameter("nombre") != null){
        nombre = request.getParameter("nombre");
    }
    
    if(request.getParameter("domicilio") != null){
        domicilio = request.getParameter("domicilio");
    }
    
if(dni != null && nombre != null && domicilio != null){
    gestor.insertarPersona(dni, nombre, domicilio);
}


personas = gestor.consultarPersonas();
    
    out.print("<tr>");
            out.println("<td>DNI</td>");
            out.println("<td>Nombre</td>");
            out.println("<td>Domicilio</td>");
    out.print("</tr>");
    for(Persona persona : personas){
        out.println("<td>"+persona.getDni()+"</td>");
        out.println("<td>"+persona.getNombre()+"</td>");
        out.println("<td>"+persona.getDomicilio()+"</td>");
    }

%>
</table>
