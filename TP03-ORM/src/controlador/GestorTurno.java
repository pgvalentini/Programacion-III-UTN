package controlador;

import persistencia.ConfigHibernate;

public class GestorTurno extends Gestor {

    public GestorTurno() {
        sesion = ConfigHibernate.openSession();
    }
}
