<?php
try {
    $texto = $_POST["texto"];
    $archivo = fopen("archivo.txt", "w") or die("Unable to open file!");
    fwrite($archivo, $texto);
    fclose($archivo);
    
    $archivo = fopen("archivo.txt", "r") or die("Unable to open file!");
    echo fread($archivo,filesize("archivo.txt"));

    fclose($archivo);
    
} catch (Exception $ex) {
    echo "No se pudo escribir o leer el archivo";
}
    
?>

