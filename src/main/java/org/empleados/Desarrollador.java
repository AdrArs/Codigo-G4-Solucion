package org.empleados;

import java.util.List;
import java.util.Random;

public class Desarrollador extends Empleado implements EvaluarDesempeno{
    private final List<String> lenguajes;
    private static final Random rand = new Random();
    private final int indDesempeno;

    public Desarrollador(String id, String nombre, String departamento, double salario,
                         List<String> lenguajes) {
        super(id, nombre, departamento, salario);

        this.lenguajes = lenguajes;

        indDesempeno = rand.nextInt(3);
    }

    @Override
    public double calcularBono() {
        double porcentajeBono = 0.0;

        switch (evaluarDesempeno()){
            case "BUENO":
                if(lenguajes.size() >= 6)       {porcentajeBono = 1.0;}
                else if(lenguajes.size() >= 3)  {porcentajeBono = 0.8;}
                else                            {porcentajeBono = 0.7;}
                break;
            case "REGULAR":
                if(lenguajes.size() >= 6)       {porcentajeBono = 0.5;}
                else if(lenguajes.size() >= 3)  {porcentajeBono = 0.4;}
                else                            {porcentajeBono = 0.3;}
                break;
            case "MALO":
                porcentajeBono = 0.0;
                break;
        }

        return getSalario() * porcentajeBono;
    }

    @Override
    public String mostrarDetalles() {
        return String.format("%s%n%-12s: %s%n%-12s: %.2f%n%-12s: %s", super.mostrarDetalles(), "Desempeño",
                evaluarDesempeno(), "Bono", calcularBono(), "Lenguajes", lenguajes);
    }

    @Override
    public String evaluarDesempeno() {
        String[] desemepeno = {"MALO" , "REGULAR", "BUENO"};
        return desemepeno[indDesempeno];
    }
    @Override
    public String toString() {
        return String.format("%s", getNombre());
    }
}