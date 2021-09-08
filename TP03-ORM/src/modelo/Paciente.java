package modelo;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.*;

@Entity
public class Paciente extends Persona{
    private int idPaciente;
    private int nroSocio;
    private HistoriaClinica historiaClinica;
    private List<Turno> turnos;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getNroSocio() {
        return nroSocio;
    }

    public void setNroSocio(int nroSocio) {
        this.nroSocio = nroSocio;
    }

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "idHistoriaClinica")
    public HistoriaClinica getHistoriaClinica() {
        return historiaClinica;
    }

    public void setHistoriaClinica(HistoriaClinica historiaClinica) {
        this.historiaClinica = historiaClinica;
    }

    @OneToMany(mappedBy = "paciente", cascade = CascadeType.ALL)
    public List<Turno> getTurnos() {
        return turnos;
    }

    public void setTurnos(List<Turno> turnos) {
        this.turnos = turnos;
    }
    
    
}
