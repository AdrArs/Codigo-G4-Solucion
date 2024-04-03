package org.empleados;

import java.util.List;
import java.util.Random;

public class Gerente extends Empleado implements EvaluarDesempeno{
    private final List<Empleado> equipo;
    private static final Random rand = new Random();
    private final int indDesempeno;

    public Gerente(String id, String nombre, String departamento, double salario,
                   List<Empleado> equipo) {
        super(id, nombre, departamento, salario);

        this.equipo = equipo;
        indDesempeno = rand.nextInt(3);
    }

    @Override
    public double calcularBono() {
        double porcentajeBono = 0.0;

        switch (evaluarDesempeno()){
            case "BUENO":
                if(equipo.size() >= 6)      {porcentajeBono = 1.0;}
                else if(equipo.size() >= 3) {porcentajeBono = 0.8;}
                else                        {porcentajeBono = 0.7;}
                break;
            case "REGULAR":
                if(equipo.size() >= 6)      {porcentajeBono = 0.5;}
                else if(equipo.size() >= 3) {porcentajeBono = 0.4;}
                else                        {porcentajeBono = 0.3;}
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
                evaluarDesempeno(), "Bono", calcularBono(), "Equipo", equipo);
    }

    @Override
    public String evaluarDesempeno() {
        String[] desemepeno = {"MALO" , "REGULAR", "BUENO"};
        return desemepeno[indDesempeno];
    }
}