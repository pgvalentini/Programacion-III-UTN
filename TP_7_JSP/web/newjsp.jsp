<table border="1">
<%
    int filas = 0, col = 0;

    if(request.getParameter("filas") != null){
        filas = Integer.parseInt(request.getParameter("filas"));
    }
    
    if(request.getParameter("col") != null){
        col = Integer.parseInt(request.getParameter("col"));
    }

    for(int fila = 0; fila < filas; fila++){
        out.print("<tr>");
        for(int columna = 0; columna < col; columna++){
            out.println("<td>"+(fila+1)+"."+(columna+1)+"</td>");
        }
        out.print("</tr>");
    }
%>
</table>
