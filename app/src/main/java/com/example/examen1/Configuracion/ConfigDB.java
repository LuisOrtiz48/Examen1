package com.example.examen1.Configuracion;

public class ConfigDB
{
    // Configuracion de los papametros de la base de datos local en SQLite
    // Nombre de la base de datos
    public static final String namebd = "DBExam";

    // Tablas de la base de datos
    public  static final String tblfutbolistas = "FUTBOLISTAS";

    //Campos de la tabla futbolistas
    public static  final String id = "id";
    public static  final String nombres = "nombres";
    public static  final String apellidos = "apellidos";
    public static  final String pais = "pais";
    public static  final String posicion = "posicion";
    public static  final String edad = "edad";

    // Crearcion de objetos DDL
    public static final String CreateTBFutbolistas = "CREATE TABLE FUTBOLISTAS (id INTEGER PRIMARY KEY AUTOINCREMENT, nombres TEXT," +
            "apellidos TEXT, pais TEXT, posicion TEXT, edad INTEGER)";

    public static final String DropTBFutbolistas = "DROP TABLE IF EXISTS FUTBOLISTAS";

    // Creacion de objetos DML
    public static final String SelectTBFutbolistas = "SELECT * FROM " + ConfigDB.tblfutbolistas;

    // Comando de limpieza
    public static final String Empty = "";
}
