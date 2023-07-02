package com.example.examen1.Configuracion;

public class Futbolistas
{
    private  Integer id;
    private String nombres;
    private String apellidos;
    private String pais;
    private String posicion;
    private Integer edad;

    public Futbolistas()
    {
    }

    public Futbolistas(Integer id, String nombres, String apellidos, String pais, String posicion, Integer edad) {
        this.id = id;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.pais = pais;
        this.posicion = posicion;
        this.edad = edad;
    }

    public Integer getId() { return id; }

    public void setId(Integer id) { this.id = id; }

    public String getNombres() { return nombres; }

    public void setNombres(String nombres) { this.nombres = nombres; }

    public String getApellidos() { return apellidos; }

    public void setApellidos(String apellidos) { this.apellidos = apellidos; }

    public String getPais() { return pais; }

    public void setPais(String pais) { this.pais = pais; }

    public String getPosicion() { return posicion; }

    public void setPosicion(String posicion) { this.posicion = posicion; }

    public Integer getEdad() { return edad; }

    public void setEdad(Integer edad) { this.edad = edad; }

}
