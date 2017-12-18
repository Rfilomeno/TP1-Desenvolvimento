package com.example.rodrigofilomeno.tp1_desenvolvimento;

import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class Lista_ContatosActivity extends AppCompatActivity {

    ListView lvContatos;
    ArrayList<Contato> contatos = new ArrayList<>();
    private ArrayAdapter<Contato> adapter;
    Contato contato;
   
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_contatos);
        Contato contato1 = new Contato("Rodrigo", "(21) 98753-6007", "rodrigo.filomeno@al.infnet.edu.br", "RJ");
        contatos.add(contato1);

//        Não consegui ler do arquivo...
        try {
            FileInputStream fis = new FileInputStream("contatos1.txt");
            ObjectInputStream ois = new ObjectInputStream(fis);
            contatos =(ArrayList<Contato>) ois.readObject();

        }catch (Exception e){
            Toast.makeText(this, "erro:" + e.toString(), Toast.LENGTH_LONG);
        }

        lvContatos = (ListView) findViewById(R.id.ListViewContatos);
        adapter = new CustomListViewAdapter(this, contatos);
        lvContatos.setAdapter(adapter);

        lvContatos.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Contato contatos = (Contato) parent.getItemAtPosition(position);

                AlertDialog.Builder adb = new AlertDialog.Builder(Lista_ContatosActivity.this);
                adb.setTitle(contatos.Nome.toString());
                adb.setMessage("E-mail: " + contatos.Email.toString()
                        + "\nTelefone: " + contatos.Telefone.toString()
                        + "\nCidade: " + contatos.Cidade.toString());
                adb.show();


            }

        });

    }



}
