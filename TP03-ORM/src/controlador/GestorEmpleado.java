package controlador;

import persistencia.ConfigHibernate;

public class GestorEmpleado extends Gestor {

    public GestorEmpleado() {
        sesion = ConfigHibernate.openSession();
    }
}
