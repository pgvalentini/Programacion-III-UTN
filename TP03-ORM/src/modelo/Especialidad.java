package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Especialidad extends EntityBean implements java.io.Serializable{
    private int idEspecialidad;
    private String denominacion;
    private List<Medico> medicos;

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

    public String getDenominacion() {
        return denominacion;
    }

    public void setDenominacion(String denominacion) {
        this.denominacion = denominacion;
    }

    @ManyToMany(
    cascade = {CascadeType.PERSIST, CascadeType.MERGE},
    mappedBy = "especialidades",
    targetEntity = Medico.class
    )
    public List<Medico> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<Medico> medicos) {
        this.medicos = medicos;
    }
}
