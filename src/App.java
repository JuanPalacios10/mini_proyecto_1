import java.util.ArrayList;
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
                    Crud.encontrarGanador(candidatos);
                    Crud.encontrarPartido(candidatos);
                    Crud.encontrarTopCiudades(candidatos);
                    System.out.println(""); // Salto de linea
                    break;
                }
                case 7: break;
                default: System.out.println("Ingrese una opción válida");
            }
        } while(opcion != 7);

        scanner.close();
    }
    
}    
