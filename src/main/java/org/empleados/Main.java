package org.empleados;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<String> len1 = Arrays.asList("JavasCript", "Rust");
        List<String> len4 = Arrays.asList("C", "C+", "Java", "Rust");
        List<String> len6 = Arrays.asList("C", "C+", "Java", "Rust", "JavaScript", "Assembly");

        // desarrolladores
        Desarrollador dev1 = new Desarrollador("11111111", "the primigen", "Youtube", 2000.5, len1);
        Desarrollador dev2 = new Desarrollador("22222222", "Linus Torvalds", "Sistemas", 1600.25, len4);
        Desarrollador dev3 = new Desarrollador("33333333", "John Carmack", "Videojuegos", 1600.25, len6);
        Desarrollador dev4 = new Desarrollador("44444444", "Dennis Ritchie", "lima", 2000.5, len4);
        Desarrollador dev5 = new Desarrollador("55555555", "Ada Lovelace", "Sistemas", 1600.25, len6);
        Desarrollador dev6 = new Desarrollador("66666666", "Guido Van Rossum", "Sistemas", 1600.25, len4);
        Desarrollador dev7 = new Desarrollador("77777777", "MiduDev", "Youtube", 1600.25, len1);

        List<Empleado> team1 = Arrays.asList(dev1, dev2, dev3, dev4, dev5, dev6);
        List<Empleado> team2 = Arrays.asList(dev7, dev2, dev3, dev4);
        List<Empleado> team3 = Arrays.asList(dev1, dev2);

        // gerentes
        Gerente gerente1 = new Gerente("88888888", "Steve Jobs", "gerencia", 60000.00, team2);
        Gerente gerente2 = new Gerente("99999999", "Satia Nadela", "gerencia", 30000.00, team3);
        Gerente gerente3 = new Gerente("10101010", "Jensen Huang", "gerencia", 60000.00, team1);

        // Lista de empleados
        List<Empleado> empleados  = List.of(dev1, gerente1, dev2, gerente2, dev3, gerente3,
                                            dev4, dev5, dev6, dev7);

        System.out.println("EMPLEADOS:");

        for (Empleado empleado : empleados) {
            System.out.println(empleado.mostrarDetalles());
            System.out.printf("%s","------------------------------------------------------------------------");
            System.out.println();
        }

    }
}