function validate() {
    var edad = document.querySelector('input[name="edad"]:checked').value;

    if (edad == "Si") {
        alert("Felicitaciones, usted puede ingresar al sitio");
    } else {
        alert("Usted no puede ingresar al sitio");
    }
}