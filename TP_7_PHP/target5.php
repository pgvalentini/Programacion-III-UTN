<?php

$id = $_POST["id"];
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

$sql = "UPDATE persona " .
        "SET nombre='$nombre', " . 
        "apellido='$apellido', " .
        "carrera='$carrera', " .
        "anio='$anio', " .
        "observaciones='$observaciones'" .
        "WHERE id=$id";

if ($conn->query($sql) === TRUE) {
  echo "Registro actualizado exitosamente";
} else {
  echo "Error actualizando el registro: " . $conn->error;
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

