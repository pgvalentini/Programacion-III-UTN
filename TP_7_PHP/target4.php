<?php
$id = $_POST["id"];

$host = "localhost";
$user = "root";
$password = "mysql";
$puerto = "3306";
$dbname = "estudiante";

$conn = new mysqli($host, $user, $password, $dbname);

if ($conn->connect_error) {
    die("Connection failed: " . $conn->connect_error);
}

$sql = "DELETE FROM persona WHERE id=$id";

echo $sql;

if ($conn->query($sql) === TRUE) {
  echo "Borrado exitosamente";
} else {
  echo "Error borrando registro: " . $conn->error;
}

$conn->close();
?>

