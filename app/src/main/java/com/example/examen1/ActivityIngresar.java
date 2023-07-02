package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.viewmodel.CreationExtras;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.examen1.Configuracion.ConfigDB;
import com.example.examen1.Configuracion.SQLiteConnection;

public class ActivityIngresar extends AppCompatActivity {

    EditText id, nombres, apellidos, edad;
    Spinner pais, posicion;
    Button btningresar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ingresar);

        id = (EditText) findViewById(R.id.txtid);
        nombres = (EditText) findViewById(R.id.txtnombres);
        apellidos = (EditText) findViewById(R.id.txtapellidos);
        pais = (Spinner) findViewById(R.id.cmdpais);
        posicion = (Spinner) findViewById(R.id.cmdposicion);
        edad = ( EditText) findViewById(R.id.txtedad);

        btningresar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) { insertar_datos();}
        });

    }

    private void insertar_datos()
    {
        SQLiteConnection conexion = new SQLiteConnection(this, ConfigDB.namebd, null, 1);
        SQLiteDatabase db = conexion.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(ConfigDB.nombres,nombres.getText().toString());
        values.put(ConfigDB.apellidos,apellidos.getText().toString());
        values.put(ConfigDB.pais,pais.getSelectedItem().toString());
        values.put(ConfigDB.posicion,posicion.getSelectedItem().toString());
        values.put(ConfigDB.edad,edad.getText().toString());

        Long resultado = db.insert(ConfigDB.tblfutbolistas, ConfigDB.id, values);
        if(resultado > 0)
        {
            Toast.makeText(getApplicationContext(), "Registro ingresado exitosamente", Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(getApplicationContext(), "Registro no ingresado", Toast.LENGTH_SHORT).show();
        }

        db.close();

        ClearScreen();

    }

    private void ClearScreen()
    {
        nombres.setText(ConfigDB.Empty);
        apellidos.setText(ConfigDB.Empty);
        edad.setText(ConfigDB.Empty);

    }
}