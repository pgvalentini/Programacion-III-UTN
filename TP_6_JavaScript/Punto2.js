function mostrarMeses() {
    var meses = ["Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Setiembre", "Octubre", "Noviembre", "Diciembre"]
    for (i = 0; i < 12; i++) {
        document.write(meses[i] + " ")
    }
    j = 0;
    while (j < 12) {
        document.write(meses[j] + " ")
        j++;
    }
}
