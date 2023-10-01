public class Candidato extends Ciudadano {
    private Ideologia ideologia;
    private String promesas[];
    private int votos;

    public Candidato(String nombre, String cedula, Ideologia ideologia, String[] promesas, int votos) {
        super(nombre, cedula);
        this.ideologia = ideologia;
        this.promesas = promesas;
        this.votos = votos;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }
    
    public String[] getPromesas() {
        return promesas;
    }
    public void setPromesas(String[] promesas) {
        this.promesas = promesas;
    }
    public int getVotos() {
        return votos;
    }
    public void setVotos(int votos) {
        this.votos = votos;
    }
}
