package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.examen1.Configuracion.ConfigDB;
import com.example.examen1.Configuracion.Futbolistas;
import com.example.examen1.Configuracion.SQLiteConnection;

import java.util.ArrayList;

public class ActivityList extends AppCompatActivity
{
    SQLiteConnection conexion;
    ListView list;
    ArrayList<Futbolistas> listfutbolistas;
    ArrayList<String> arreglofutbolistas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        conexion = new SQLiteConnection(this, ConfigDB.namebd, null, 1);
        list = (ListView) findViewById(R.id.ListaF);

        ObtenerTabla();

        ArrayAdapter apd = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arreglofutbolistas);
        list.setAdapter(apd);

    }

    private void ObtenerTabla()
    {
        SQLiteDatabase db = conexion.getReadableDatabase();
        Futbolistas futbol = null;
        listfutbolistas = new ArrayList<Futbolistas>();

        // Cursor de Base de Datos
        Cursor cursor = db.rawQuery(ConfigDB.SelectTBFutbolistas,null);

        // Recorremos el cursor
        while(cursor.moveToNext())
        {
            futbol = new Futbolistas();
            futbol.setId(cursor.getInt(0));
            futbol.setNombres(cursor.getString(1));
            futbol.setApellidos(cursor.getString(2));
            futbol.setPais(cursor.getString(3));
            futbol.setPosicion(cursor.getString(4));
            futbol.setEdad(cursor.getInt(5));
            listfutbolistas.add(futbol);
        }

        cursor.close();

        fillData();
    }

    private void fillData()
    {
        arreglofutbolistas = new ArrayList<String>();

        for(int i=0; i < listfutbolistas.size(); i++)
        {
            arreglofutbolistas.add(listfutbolistas.get(i).getId() + " - "
                    +listfutbolistas.get(i).getNombres() + " - "
                    +listfutbolistas.get(i).getPosicion());
        }
    }
}