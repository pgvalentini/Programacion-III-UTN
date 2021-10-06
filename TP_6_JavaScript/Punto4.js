function miFuncion() {
    let nombre = prompt("Ingrese su nombre", "Nombre Apellido")
    let sueldo = parseInt(prompt("Ingrese su sueldo", ""));
    let antig = parseInt(prompt("Ingrese su antiguedad", ""));
    if (sueldo < 500 && antig > 10) {
        resultado = sueldo * 1.2
    } else if (sueldo < 500 && antig < 10) {
        resultado = sueldo * 1.05
    } else if (sueldo >= 500) {
        resultado = sueldo
    }
    document.write(resultado)
}
