package com.emergentes.modelo;

public class Vacuna {
    private int id;
    private String nombre;
    private int peso;
    private int talla;
    private String vacuna;

    public Vacuna() {
        id = 0;
        nombre = "";
        peso = 0;
        talla = 0;
        vacuna = "";
    }
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPeso() {
        return peso;
    }

    public void setPeso(int peso) {
        this.peso = peso;
    }

    public int getTalla() {
        return talla;
    }

    public void setTalla(int talla) {
        this.talla = talla;
    }

    public String getVacuna() {
        return vacuna;
    }

    public void setVacuna(String vacuna) {
        this.vacuna = vacuna;
    }
    
}
