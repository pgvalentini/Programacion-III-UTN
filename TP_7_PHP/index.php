<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title></title>
    </head>
    <body>
        <h1>Programación 3 TP 7 German Dartsch</h1>
        <br><br>
        <h2>Punto 1</h2>
        <br><br>
        <form action="target.php" method="post">
            <label for="valor1">Valor 1: </label>
            <input type="number" min="2" name ="valor1" id="valor1">
            <br><br>
            <label for="valor2" >Valor 2: </label>
            <input type="number" min="2" name ="valor2" id="valor2">
            <br><br>
            <input type="submit">
        </form>
        <br><br>
        <h2>Punto 2</h2>
        <br><br>
        <form action="target1.php" method="post">
            <label for="cadena">Cadena: </label>
            <input type="text" name ="cadena" id="cadena">
            <br><br>
            <input type="submit">
        </form>
        <br><br>
        <h2>Punto 3</h2>
        <br><br>
        <form action="target2.php" method="post">
            <label for="texto">Ingrese el texto a escribir: </label>
            <input type="text" name ="texto" id="texto">
            <br><br>
            <input type="submit">
        </form>
        <br><br>
        <h2>Punto 4</h2>
        <br><br>
        <form action="target3.php" method="post">
            <label for="nombre">Nombre: </label><input type="text" name ="nombre" id="nombre"><br>
            <label for="apellido">Apellido: </label><input type="text" name ="apellido" id="apellido"><br>
            <label for="carrera">Carrera: </label><select name="carrera"><br>
                <option value="sistemas">Sistemas</option>
                <option value="fisica">Fisica</option>  
                <option value="civil">Civil</option>
            <br><br><input type="radio" id="anio" name="anio" value="primero">
            <label for="anio">Cursando primer año</label><br>
            <input type="radio" id="anio" name="anio" value="segundo">
            <label for="anio">Cursando segundo año</label><br>
            <textarea name="observaciones" id="observaciones" cols="40" rows="4" >Observaciones...</textarea><br>
            </select><br><br>
            <input type="submit">
        </form>
        <?php
        // put your code here
        ?>
    </body>
</html>
