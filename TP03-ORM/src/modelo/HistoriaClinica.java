package modelo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.*;

@Entity
public class HistoriaClinica extends EntityBean implements java.io.Serializable{
    private int idHistoriaClinica;
    private int numero;
    private Date fechaAlta;
    private Paciente paciente;
    private List<DetalleHistoriaClinica> detalleHistoriaClinica;

    public int getIdHistoriaClinica() {
        return idHistoriaClinica;
    }

    public void setIdHistoriaClinica(int idHistoriaClinica) {
        this.idHistoriaClinica = idHistoriaClinica;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public Date getFechaAlta() {
        return fechaAlta;
    }

    public void setFechaAlta(Date fechaAlta) {
        this.fechaAlta = fechaAlta;
    }

    @OneToOne(cascade={CascadeType.ALL})
    @JoinColumn(name = "idPaciente")
    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }

    @OneToMany(mappedBy = "historiaClinica", cascade = CascadeType.ALL)
    public List<DetalleHistoriaClinica> getDetalleHistoriaClinica() {
        return detalleHistoriaClinica;
    }

    public void setDetalleHistoriaClinica(List<DetalleHistoriaClinica> detalleHistoriaClinica) {
        this.detalleHistoriaClinica = detalleHistoriaClinica;
    }
    
    
}
