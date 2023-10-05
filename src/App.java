import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        ArrayList<Candidato> candidatos = new ArrayList<Candidato>();
        Scanner scanner = new Scanner(System.in);
        int opcion;

        do {
            System.out.println("MENU");
            System.out.println("1. Insertar candidato");
            System.out.println("2. Actualizar candidato");
            System.out.println("3. Eliminar candidato");
            System.out.println("4. Buscar candidato por nombre");
            System.out.println("5. Listar todos los candidatos");
            System.out.println("6. Continuar con el conteo de votos");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();

            switch(opcion){
                case 1: Crud.insertarCandidato(candidatos); break;
                case 2: Crud.actualizarCandidato (candidatos); break;
                case 3: Crud.eliminarCandidato (candidatos); break;
                case 4: Crud.buscarCandidato (candidatos); break;
                case 5: Crud.listarCandidatos (candidatos); break;
                case 6: {
                    if(candidatos.size() == 0) System.out.println("\nAun no hay ningun candidato.\n");

                    candidatos.forEach((candidato) -> {
                        System.out.println("\nIngrese el numero de votos del candidato " + (candidatos.indexOf(candidato) + 1) + " de nombre " + candidato.getNombre() + ": ");
                        int votos = scanner.nextInt();
                        candidato.setVotos(votos);
                    });

                    System.out.println(""); // Salto de linea

                    // Partidos con mas candidatos inscritos
                    ArrayList<Short> numPartidos = new ArrayList<Short>();
                    ArrayList<Partidos> partidoCandidatos = new ArrayList<Partidos>();
                    Partidos partidosRepetidos[] = new Partidos[candidatos.size()];
                    short contador = 0;

                    for(Candidato candidato : candidatos) {
                        partidosRepetidos[candidatos.indexOf(candidato)] = candidato.getPartido();
                    }
                    
                    for(Partidos partido : Partidos.values()) {
                        contador = 0;

                        for(Partidos partidoRepetido : partidosRepetidos) {
                            if(partido.equals(partidoRepetido)) contador++;
                        }

                        if(contador > 0) {
                            numPartidos.add(contador);
                            partidoCandidatos.add(partido);
                        }
                    }

                    short maxPartido = numPartidos.get(0);
                    int indicePartido = 0;

                    for(short i = 0; i < numPartidos.size(); i++) {
                        if(maxPartido < numPartidos.get(i)) {
                            maxPartido = numPartidos.get(i);
                            indicePartido = numPartidos.indexOf(numPartidos.get(i));
                        }
                    }

                    System.out.println("El partido con mas candidatos es " + partidoCandidatos.get(indicePartido).toString().replace("_", " "));
                    System.out.println(""); // Salto de linea
                    break;
                }
                case 7: break;
                default: System.out.println("Ingrese una opción válida");
            }
        } while(opcion != 7);
    }
}    
