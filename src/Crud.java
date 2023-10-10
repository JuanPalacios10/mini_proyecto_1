import java.util.ArrayList;
import java.util.Scanner;

public abstract class Crud {
    private static int indice = -1;

    public static void insertarCandidato(ArrayList<Candidato> candidatos){
        Scanner dato = new Scanner(System.in);
        System.out.println("\nIngrese el nombre del candidato: ");
        String nombre = dato.nextLine();

        System.out.println("\nIngrese el número de cédula del candidato: ");
        String cedula = dato.nextLine();

        System.out.println("\nLista de ciudades\n");
        for(Ciudades ciudad : Ciudades.values()) {
            System.out.println("- " + ciudad.toString().replace("_", " "));
        }

        System.out.println("\nIngrese la ciudad del candidato: ");
        String ciudadIn = dato.nextLine();

        System.out.println("\nIngrese la idelogia politica del candidato (Izquierda - Derecha): ");
        String ideologiaIn = dato.nextLine();

        System.out.println("\nLista de partidos politicos\n");
        for(Partidos partido : Partidos.values()) {
            System.out.println("- " + partido.toString().replace("_", " "));
        }
        System.out.println("\nIngrese el partido politico del candidato: ");
        String partidoIn = dato.nextLine();

        System.out.println("\nIngrese la cantidad de promesas de campaña: ");
        byte cantPromesas = dato.nextByte();
        dato.nextLine(); // Limpia el ultimo caracter de espacio nulo \n

        String promesas[] = new String[cantPromesas];
        String promesa;

        for(int i = 0; i < cantPromesas; i++) {
            System.out.println("\nIngrese la promesa " + (i + 1) + ": ");
            promesa = dato.nextLine();
            promesas[i] = promesa;
            }

            Ciudades ciudadOrigen = Ciudades.Alcala;
            Partidos partidoPolitico = Partidos.AICO;
            Ideologia ideologiaPolitica = Ideologia.Izquierda;

            for(Ciudades cuidad : Ciudades.values()) {
                if(ciudadIn.equals(cuidad.toString().replace("_", " "))) {
                    ciudadOrigen = cuidad;
                    ciudadIn = "";
                    break;
                }
            }

            for(Ideologia ideologia : Ideologia.values()) {
                if(ideologiaIn.equals(ideologia.toString())) {
                    ideologiaPolitica = ideologia;
                    ideologiaIn = "";
                    break;
                }
            }

            for(Partidos partido : Partidos.values()) {
                if(partidoIn.equals(partido.toString().replace("_", " "))) {
                    partidoPolitico = partido;
                    partidoIn = "";
                    break;
                }
            }

            if(ciudadIn.length() != 0) {
                System.out.println("\nLa ciudad de origen es incorrecta\n");
            } else if(ideologiaIn.length() != 0) {
                System.out.println("\nLa ideologia politica es incorrecta\n");
            } else if(partidoIn.length() != 0) {
                System.out.println("\nEl partido politico es incorrecto\n");
            } else {
                Candidato nuevoCandidato = new Candidato(nombre, cedula, ciudadOrigen, ideologiaPolitica, partidoPolitico, promesas);
                candidatos.add(nuevoCandidato);
                System.out.println("\nEl candidato fue agregado correctamente.\n");
            }
    }

    public static void actualizarCandidato(ArrayList<Candidato> candidatos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el nombre del candidato a actualizar: ");
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

            System.out.println("\nLista de ciudades\n");
            for(Ciudades ciudad : Ciudades.values()) {
                System.out.println("- " + ciudad.toString().replace("_", " "));
            }
            System.out.println("\nIngrese la ciudad del candidato: ");
            String ciudadIn = scanner.nextLine();

            System.out.println("\nIngrese la idelogia politica del candidato (Izquierda - Derecha): ");
            String ideologiaIn = scanner.nextLine();

            System.out.println("\nLista de partidos politicos\n");
            for(Partidos partido : Partidos.values()) {
                System.out.println("- " + partido.toString().replace("_", " "));
            }
            System.out.println("\nIngrese el partido politico del candidato: ");
            String partidoIn = scanner.nextLine();

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

            Ciudades ciudadOrigen = Ciudades.Buenaventura;
            Partidos partidoPolitico = Partidos.AICO;
            Ideologia ideologiaPolitica = Ideologia.Izquierda;

            for(Ciudades cuidad : Ciudades.values()) {
                if(ciudadIn.equals(cuidad.toString().replace("_", " "))) {
                    ciudadOrigen = cuidad;
                    ciudadIn = "";
                    break;
                }
            }

            for(Ideologia ideologia : Ideologia.values()) {
                if(ideologiaIn.equals(ideologia.toString())) {
                    ideologiaPolitica = ideologia;
                    ideologiaIn = "";
                    break;
                }
            }

            for(Partidos partido : Partidos.values()) {
                if(partidoIn.equals(partido.toString().replace("_", " "))) {
                    partidoPolitico = partido;
                    partidoIn = "";
                    break;
                }
            }

            if(ciudadIn.length() != 0) {
                System.out.println("\nLa ciudad de origen es incorrecta\n");
            } else if(ideologiaIn.length() != 0) {
                System.out.println("La ideologia politica es incorrecta\n");
            } else if(partidoIn.length() != 0) {
                System.out.println("El partido politico es incorrecto\n");
            } else {
                candidatos.get(indice).setNombre(nombre);
                candidatos.get(indice).setCedula(cedula);
                candidatos.get(indice).setCiudad(ciudadOrigen);
                candidatos.get(indice).setIdeologia(ideologiaPolitica);
                candidatos.get(indice).setPartido(partidoPolitico);
                candidatos.get(indice).setPromesas(promesas);

                System.out.println("\nEl candidato fue actualizaco correctamente.\n");
            }
        } else {
            System.out.println("\nEl candidato no fue encontrado.\n");
        }

        indice = -1; // Reinicio del indice
    }

    public static void buscarCandidato(ArrayList<Candidato> candidatos) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("\nIngrese el nombre del candidato a buscar: ");
        String nombre = scanner.nextLine();

        candidatos.forEach((candidato) -> {
            if(candidato.getNombre().equals(nombre)) {
                indice = candidatos.indexOf(candidato);

                System.out.println("\nNombre: " + candidato.getNombre());
                System.out.println("Cedula: " + candidato.getCedula());
                System.out.println("Ciudad: " + candidato.getCiudad().toString().replace("_", " "));
                System.out.println("Ideologia: " + candidato.getIdeologia());
                System.out.println("Partido politico: " + candidato.getPartido().toString().replace("_", " "));
                
                System.out.println("Lista de promesas de campaña: ");
                for(String promesa : candidato.getPromesas()) {
                    System.out.println("- " + promesa);
                }

                System.out.println(""); // Salto de linea
            }
        });

        if(indice == -1) System.out.println("\nEl candidato no fue encontrado.\n");

        indice = -1; // Reinicio del indice
    }

    public static void eliminarCandidato(ArrayList<Candidato> candidatos){
        Scanner dato = new Scanner(System.in);

        System.out.println("\nIngrese el nombre del candidato a eliminar: ");
        String busqueda = dato.nextLine();

        for (Candidato candidato : candidatos) {
            if (candidato.getNombre().equals(busqueda)) {
                indice = candidatos.indexOf(candidato);
                candidatos.remove(candidato);
                System.out.println("\nEl candidato fue eliminado correctamente.\n");
                break;
            }     
        }

        if(indice == -1) System.out.println("\nEl candidato no fue encontrado.\n");   

        indice = -1; // Reinicio del indice
    }       
    
    public static void listarCandidatos(ArrayList<Candidato> candidatos){
        if(candidatos.size() == 0) System.out.println("\nAun no existen candidatos\n");
        else {
            System.out.println("\nListado de candidatos:\n");

            for (Candidato candidato : candidatos) {
                System.out.println("Nombre: " + candidato.getNombre());
                System.out.println("Cedula: " + candidato.getCedula());
                System.out.println("Ciudad: " + candidato.getCiudad().toString().replace("_", " "));
                System.out.println("Ideologia: " + candidato.getIdeologia());
                System.out.println("Partido politico: " + candidato.getPartido().toString().replace("_", " "));
                    
                System.out.println("Lista de promesas de campaña: ");
                for(String promesa : candidato.getPromesas()) {
                    System.out.println("- " + promesa);
                }

                System.out.println("Votos: " + candidato.getVotos());

                System.out.println(""); // Salto de linea
            }
        }
    }

    public static void encontrarGanador(ArrayList<Candidato> candidatos) {
        // Inicializar la persona con más votos con el primer elemento de la lista
        Candidato ganador = candidatos.get(0);

        // Iterar a través de la lista para encontrar la persona con la mayor número de votos
        for (int i = 1; i < candidatos.size(); i++) {
            Candidato candidato_iterador = candidatos.get(i);
            if (candidato_iterador.getVotos() > ganador.getVotos()) {
                ganador = candidato_iterador;
            }
        }

        System.out.println("El ganador es " + ganador.getNombre() + " con número de cédula " + ganador.getCedula());
        System.out.println("Lista de promesas de campaña del ganador: ");
        for(String promesa : ganador.getPromesas()) {
            System.out.println("- " + promesa);
        }
    }
}