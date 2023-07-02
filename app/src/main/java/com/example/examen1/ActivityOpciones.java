package com.example.examen1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActivityOpciones extends AppCompatActivity {

    Button btnoptingresar, btnlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        btnoptingresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { page_insertar(); }

        });

        btnlist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) { page_lista(); }
        });

    }

    private void page_lista()
    {
        Intent intent = new Intent(this, ActivityList.class);
        startActivity(intent);
    }

    private void page_insertar()
    {
        Intent intent = new Intent(this, ActivityIngresar.class);
        startActivity(intent);
    }
}