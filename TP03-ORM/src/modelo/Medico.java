package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Medico extends Persona{
    private int idMedico;
    private int matricula;
    private long celular;
    private List<Especialidad> especialidades;
    private List<Turno> turnos;

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public long getCelular() {
        return celular;
    }

    public void setCelular(long celular) {
        this.celular = celular;
    }

    @ManyToMany(fetch=FetchType.LAZY,
    targetEntity=Especialidad.class,
    cascade=CascadeType.ALL)
    @JoinTable(
    name="MEDICO_ESPECIALIDADES",
    joinColumns=@JoinColumn(name="MEDICO_ID"),
    inverseJoinColumns=@JoinColumn(name="ESPECIALIDAD_ID")
    )
    public List<Especialidad> getEspecialidades() {
        return especialidades;
    }

    public void setEspecialidades(List<Especialidad> especialidades) {
        this.especialidades = especialidades;
    }

    @OneToMany(mappedBy = "medico", cascade = CascadeType.ALL)
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }   
}
