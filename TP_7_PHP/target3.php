<?php
$nombre = $_POST["nombre"];
$apellido = $_POST["apellido"];
$carrera = $_POST["carrera"];
$anio = $_POST["anio"];
$observaciones = $_POST["observaciones"];


$host = "localhost";
$user = "root";
$password = "mysql";
$puerto = "3306";
$dbname = "estudiante";

$conn = new mysqli($host, $user, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "INSERT INTO persona (nombre, apellido, carrera, anio, observaciones)"
        . "VALUES ('" . $nombre . "', " . 
        "'" . $apellido . "', " .
        "'" . $carrera . "', " .
        "'" . $anio . "', " .
        "'" . $observaciones . "'" .
        ")";

if ($conn->query($sql) === TRUE) {
    echo "Inserción exitosa";
}else{
    echo "ERROR: " . $sql . "<br>" . $conn->error;
}

$sql = "SELECT * FROM persona";
$result = $conn->query($sql);

if ($result->num_rows > 0) {
    echo "<table border=\"1\"><tr>"
            . "<td>ID</td>"
            . "<td>Nombre</td>"
            . "<td>Apellido</td>"
            . "<td>Carrera</td>"
            . "<td>Año</td>"
            . "<td>Observaciones</td>"
            . "</tr>";
  while($row = $result->fetch_assoc()) {
    echo "<tr><td>" . $row["id"]. "</td><td>" . 
         $row["nombre"]. "</td><td>" . $row["apellido"].
         "</td><td>" . $row["carrera"]. "</td><td>" . $row["anio"].
         "</td><td>" . $row["observaciones"].
         "</td></tr>";
  }
   echo "</table>";
} else {
  echo "0 results";
}
    
$conn->close();
?>

<form action="target4.php" method="post">
      <label for="id">Ingrese la ID del registro a borrar: </label>
      <input type="number" min="0" name ="id" id="id">
      <br><br>
      <input type="submit">
</form>

<br><br><br>
<h2>Actualizar registro</h2>
<form action="target5.php" method="post">
            <label for="id">ID: </label><input type="text" name ="id" id="id"><br>
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

