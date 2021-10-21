<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>TP 6 Programación 3</title>
    </head>
    <body>
        <form action="newjsp.jsp">
            <h1>Punto 1</h1>
            <p>Ingrese la cantidad de filas</p><input type="text" name="filas" id="filas"/>
            <p>Ingrese la cantidad de columnas</p><input type="text" name="col" id="col"/>
            <br><br><br>
            <button type="submit">Enviar</button>
        </form>
        <br><br>
        <form action="punto2.jsp">
            <h1>Punto 2 y 3</h1>
            <p>Ingrese el DNI</p><input type="text" name="dni" id="dni"/>
            <p>Ingrese el Nombre</p><input type="text" name="nombre" id="nombre"/>
            <p>Ingrese el Domicilio</p><input type="text" name="domicilio" id="domicilio"/>
            <br><br><br>
            <button type="submit">Enviar</button>
        </form>
    </body>
</html>
