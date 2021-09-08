package modelo;

import java.util.Date;
import javax.persistence.*;

@Entity
public class Turno extends EntityBean implements java.io.Serializable{
    private int idTurno;
    private Date fecha;
    private int hora;
    private int minutos;
    private Medico medico;
    private Paciente paciente;

    public int getIdTurno() {
        return idTurno;
    }

    public void setIdTurno(int idTurno) {
        this.idTurno = idTurno;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getHora() {
        return hora;
    }

    public void setHora(int hora) {
        this.hora = hora;
    }

    public int getMinutos() {
        return minutos;
    }

    public void setMinutos(int minutos) {
        this.minutos = minutos;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idMedico")
    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idPaciente")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
    
    
}
