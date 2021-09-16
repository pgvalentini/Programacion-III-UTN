package SQL;

public class Componente {
    private long id = 0;
    private String nombre;
    private String nroSerie;
    private long idComputadora;

    public Componente(){
        id++;
        setId(id);
    }
    
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getNroSerie() {
        return nroSerie;
    }

    public void setNroSerie(String nroSerie) {
        this.nroSerie = nroSerie;
    }

    public long getIdComputadora() {
        return idComputadora;
    }

    public void setIdComputadora(long idComputadora) {
        this.idComputadora = idComputadora;
    }
}
