import java.util.ArrayList;
import java.util.Scanner;

public abstract class Crud {
    private static int indice = -1;

    public static void actualizar(ArrayList<Candidato> candidatos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Ingrese el nombre del candidato a actualizar: ");
        String busqueda = scanner.nextLine();
        
        candidatos.forEach((candidato) -> {
            if(candidato.getNombre().equals(busqueda)) {
                indice = candidatos.indexOf(candidato);
            }
        });

        if(indice != -1) {
            System.out.println("\nIngrese el nombre del candidato: ");
            String nombre = scanner.nextLine();

            System.out.println("\nIngrese la cedula del candidato: ");
            String cedula = scanner.nextLine();

            System.out.println("\nIngrese la idelogia politica del candidato (Izquierda - Derecha): ");
            String ideologia = scanner.nextLine();

            System.out.println("\nIngrese la cantidad de promesas de campaña: ");
            byte cantPromesas = scanner.nextByte();
            scanner.nextLine(); // Limpia el ultimo caracter de espacio nulo \n

            String promesas[] = new String[cantPromesas];
            String promesa;

            for(int i = 0; i < cantPromesas; i++) {
                System.out.println("\nIngrese la promesa " + (i + 1) + ": ");
                promesa = scanner.nextLine();
                promesas[i] = promesa;
            }

            System.out.println("\nIngrese el numero de votos del candidato: ");
            int votos = scanner.nextInt();

            Ideologia ideologiaPolitica = Ideologia.Izquierda;

            for(Ideologia ideolog : Ideologia.values()) {
                if(ideologia.equals(ideolog.toString())) {
                    ideologiaPolitica = ideolog;
                    ideologia = "";
                    break;
                }
            }

            if(ideologia.length() == 0) {
                Candidato candidatoAct = new Candidato(nombre, cedula, ideologiaPolitica, promesas, votos);
                candidatos.set(indice, candidatoAct);
            } else {
                System.out.println("La ideologia politica es incorrecta");
            }
        } else {
            System.out.println("\nEl nombre del candidato no fue encontrado");
        }

        scanner.close();
    }
}
