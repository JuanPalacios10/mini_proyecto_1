import java.util.ArrayList;
import java.util.Arrays;

public class App {
    public static void main(String[] args) throws Exception {
        String promesas[] = {"Comprar papaya"};
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

        candidatos.add(new Candidato("Juan", "1029191", Ciudades.Cali, Ideologia.Izquierda, Partidos.Cambio_Radical, promesas, 1000));
        candidatos.add(new Candidato("Carlos", "2929122", Ciudades.Palmira, Ideologia.Derecha, Partidos.Conservador, promesas, 5000));

        

        // candidatos.forEach((candidato) -> {
        //     System.out.println("\n");
        //     System.out.println(candidato.getNombre());
        //     System.out.println(candidato.getCedula());
        //     System.out.println(candidato.getCiudad());
        //     System.out.println(candidato.getIdeologia());
        //     System.out.println(candidato.getPartido());
        //     System.out.println(Arrays.toString(candidato.getPromesas()));
        //     System.out.println(candidato.getVotos());
        // });
    }
}
