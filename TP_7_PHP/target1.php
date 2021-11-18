<?php
    $cadena = $_POST["cadena"];
    $arreglo = str_split($cadena);
    
    foreach ($arreglo as $value) {
        print_r($value . "<br>");
    }
?>

