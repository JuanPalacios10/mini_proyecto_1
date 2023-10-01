import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        String promesas[] = {"Comprar papaya"};
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();

        candidatos.add(new Candidato("Juan", "1029191", Ideologia.Izquierda, promesas, 1000));
        candidatos.add(new Candidato("Carlos", "2929122", Ideologia.Derecha, promesas, 5000));

        Crud.actualizar(candidatos);
    }
}
