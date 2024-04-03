package org.empleados;

import java.util.Random;

public abstract class Empleado {
    private final String id;
    private final String nombre;
    private final String departamento;
    private double salario;

    public Empleado(String id, String nombre, String departamento , double salario) {
        this.id = id;
        this.nombre = nombre;
        this.departamento = departamento;

        if (salario < 0.0) {
            throw new IllegalArgumentException("El salario debe ser un numero positivo");
        }
        this.salario = salario;
    }

    public String getId() { return id; }

    public String getNombre() { return nombre; }

    public String getDepartamento() { return departamento; }

    public double getSalario() { return salario; }

    public void setSalario(double salario) { this.salario = salario; }

    public String mostrarDetalles() {
        return String.format("%-12s: %s%n%-12s: %s%n%-12s: %s%n%-12s: %.2f", "id", id, "nombre", nombre,
                "departamento", departamento, "salario", salario);
    }

    public abstract double calcularBono();
}