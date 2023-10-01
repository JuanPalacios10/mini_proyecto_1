public class Candidato extends Ciudadano {
    private Ideologia ideologia;
    private Partidos partido;
    private String promesas[];
    private int votos;

    public Candidato(String nombre, String cedula, Ciudades ciudad, Ideologia ideologia, Partidos partido, String[] promesas) {
        super(nombre, cedula, ciudad);
        this.ideologia = ideologia;
        this.partido = partido;
        this.promesas = promesas;
    }

    public Ideologia getIdeologia() {
        return ideologia;
    }

    public void setIdeologia(Ideologia ideologia) {
        this.ideologia = ideologia;
    }

    public Partidos getPartido() {
        return partido;
    }

    public void setPartido(Partidos partido) {
        this.partido = partido;
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
