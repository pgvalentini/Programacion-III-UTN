function miLetra() {
    const letras = ['T', 'R', 'W', 'A', 'G', 'M', 'Y', 'F', 'P', 'D', 'X', 'B', 'N', 'J', 'Z', 'S', 'Q', 'V', 'H', 'L', 'C', 'K', 'E', 'T'];
    dni = validarDni(parseInt(prompt("Ingrese su dni", "")));
    letraDni = parseInt(prompt("Ingrese la letra de su dni", ""));
    function validarDni(nro) {
        if (nro < 0 || nro > 99999999) {
            alert("Numero no valido, ingrese nuevamente")
            dni = parseInt(prompt("Ingrese su dni", ""));
            validarDni(dni);
        }
        return nro
    }
    let resultado = dni % 23
    let letra = letras[resultado]
    if (letra != letraDni) {
        alert("El numero y la letra NO son correctos"+letra)
    } else alert("El numero y la letra  son correctos"+letra)
}