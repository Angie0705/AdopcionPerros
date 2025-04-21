import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;



    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        List<Persona> listaPersonas = new ArrayList<>();
        List<Perro> listaPerros = new ArrayList<>();

        int opc;

        do {
            System.out.println("""
                    Menú de registro e información
                    1. Agregar perro
                    2. Agregar persona 
                    3. Ver personas registradas
                    4. Ver perros disponibles
                    5. Adoptar perro
                    6. Consultar el perro más viejo 
                    7. Salir
                    """);

            System.out.print("Digite una opción: ");
            opc = scanner.nextInt();
            scanner.nextLine();

            switch (opc) {
                case 1 -> {
                    String nombre, placa, raza, tamaño;
                    int edad;

                    System.out.println("Agregar datos del perro");
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Raza: ");
                    raza = scanner.nextLine();
                    System.out.print("Tamaño: ");
                    tamaño = scanner.nextLine();
                    System.out.print("Placa: ");
                    placa = scanner.nextLine();
                    System.out.print("Edad: ");
                    edad = scanner.nextInt();
                    scanner.nextLine();

                    listaPerros.add(new Perro(placa, nombre, raza, edad, tamaño));
                    System.out.println("Perro registrado exitosamente");
                }

                case 2 -> {
                    String nombre, apellido;
                    int edad, documento;

                    System.out.println("Agregar datos de la persona");
                    System.out.print("Nombre: ");
                    nombre = scanner.nextLine();
                    System.out.print("Apellido: ");
                    apellido = scanner.nextLine();
                    System.out.print("Edad: ");
                    edad = scanner.nextInt();
                    System.out.print("Documento: ");
                    documento = scanner.nextInt();
                    scanner.nextLine();

                    listaPersonas.add(new Persona(nombre, apellido, edad, documento));
                    System.out.println("Persona registrada exitosamente");
                }

                case 3 -> {
                    System.out.println("\n--- Personas Registradas ---");
                    if (listaPersonas.isEmpty()) {
                        System.out.println("No hay personas registradas.");
                    } else {
                        for (Persona persona : listaPersonas) {
                            System.out.println(persona);
                        }
                    }
                }

                case 4 -> {
                    System.out.println("\n--- Perros Disponibles ---");
                    if (listaPerros.isEmpty()) {
                        System.out.println("No hay perros disponibles para adoptar.");
                    } else {
                        for (Perro perro : listaPerros) {
                            System.out.println(perro);
                        }
                    }
                }

                case 5 -> {
                    System.out.println("\n--- Adoptar Perro ---");
                    System.out.print("Ingrese el documento de la persona que va a adoptar: ");
                    int documentoAdopcion = scanner.nextInt();
                    scanner.nextLine();

                    Persona personaAdopta = null;
                    for (Persona persona : listaPersonas) {
                        if (persona.getDocumento() == documentoAdopcion) {
                            personaAdopta = persona;
                            break;
                        }
                    }

                    if (personaAdopta != null) {
                        System.out.print("Ingrese la placa del perro que desea adoptar: ");
                        String placaAdopcion = scanner.nextLine();

                        Perro perroAdoptado = null;
                        for (Perro perro : listaPerros) {
                            if (perro.getPlaca().equalsIgnoreCase(placaAdopcion)) {
                                perroAdoptado = perro;
                                break;
                            }
                        }

                        if (perroAdoptado != null) {
                            personaAdopta.adoptarPerro(perroAdoptado);
                            listaPerros.remove(perroAdoptado);
                            System.out.println("¡Adopción realizada con éxito!");
                        } else {
                            System.out.println("No se encontró un perro con esa placa.");
                        }

                    } else {
                        System.out.println("No se encontró ninguna persona con ese documento.");
                    }
                }

                case 6 -> {
                    System.out.println("\n--- Consultar Perro Más Viejo Adoptado ---");
                    System.out.print("Ingrese el documento de la persona a consultar: ");
                    int documentoConsulta = scanner.nextInt();
                    scanner.nextLine();

                    Persona personaConsulta = null;
                    for (Persona persona : listaPersonas) {
                        if (persona.getDocumento() == documentoConsulta) {
                            personaConsulta = persona;
                            break;
                        }
                    }

                    if (personaConsulta != null) {
                        Perro perroViejo = personaConsulta.perroMasGrande();
                        if (perroViejo != null) {
                            System.out.println("El perro más viejo adoptado por " + personaConsulta.getNombre() +
                                    " es: " + perroViejo.getNombre() + " (Edad: " + perroViejo.getEdad() + " años).");
                        } else {
                            System.out.println(personaConsulta.getNombre() + " no ha adoptado ningún perro.");
                        }
                    } else {
                        System.out.println("No se encontró ninguna persona con ese documento.");
                    }
                }

                case 7 -> System.out.println("Saliendo del programa. ¡Hasta luego!");

                default -> System.out.println("Opción inválida. Por favor, intente de nuevo.");
            }

        } while (opc != 7);

        scanner.close();
    }

