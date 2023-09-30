public class Candidato extends Ciudadano {
    private boolean partido;
    private String promesas[];
    private int votos;

    public Candidato(String nombre, String cedula, boolean partido, String[] promesas, int votos) {
        super(nombre, cedula);
        this.partido = partido;
        this.promesas = promesas;
        this.votos = votos;
    }
    public boolean isPartido() {
        return partido;
    }
    public void setPartido(boolean partido) {
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
