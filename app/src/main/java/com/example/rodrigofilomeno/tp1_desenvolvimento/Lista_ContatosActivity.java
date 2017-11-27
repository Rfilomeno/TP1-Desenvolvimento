package com.example.rodrigofilomeno.tp1_desenvolvimento;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class Lista_ContatosActivity extends AppCompatActivity {

    String filename = "contatos1.txt";
    ArrayList<Contato> Lista;
    ListView Lv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        Lv = (ListView) findViewById(R.id.ListViewContatos);

        ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename));
        Lista = (ArrayList<Contato>) in.readObject();



    }








}
