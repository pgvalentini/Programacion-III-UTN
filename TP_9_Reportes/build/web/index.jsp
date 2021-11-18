<%-- 
    Document   : index
    Created on : 15 nov. 2021, 22:34:10
    Author     : pablo
--%>

<%@page import="controlador.ControladorReportes"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <form action="generararchivo.jsp" method="post">
             Ingrese el país <input type="text" name="pais">
             <br>
             Seleccione la región 
             <select name="region" id="region">
                <% 
                ControladorReportes contr = new ControladorReportes();
                List<String> regiones = new ArrayList<String>();
                regiones = contr.getListaRegiones();
                out.print("Lista: " + regiones.size());
                for(String region : regiones){
                    out.print("<option value='" + region + "'>" + region + "</option>");
                    }
                %>
                
             </select>
                <br>
                <br>
                <input type="submit" name="pdf" value="Generar PDF">
                <input type="submit" name="excel" value="Generar Excel">
                
                <%-- 
                <button> Generar PDF</button>
                <button> Generar Excel</button>
                --%>
            
        </form>
    </body>
</html>
