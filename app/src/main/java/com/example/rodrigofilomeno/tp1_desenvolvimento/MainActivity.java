package com.example.rodrigofilomeno.tp1_desenvolvimento;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class MainActivity extends AppCompatActivity {


    TextView Nome;
    TextView Telefone;
    TextView Email;
    TextView Cidade;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        Nome = (TextView) findViewById(R.id.Nome);
        Telefone = (TextView) findViewById(R.id.Telefone);
        Email = (TextView) findViewById(R.id.Email);
        Cidade = (TextView) findViewById(R.id.Cidade);

    }



    public void Salvar(View v){

        Contato contato = new Contato(Nome.getText().toString(),Telefone.getText().toString(),Email.getText().toString(),Cidade.getText().toString());

        try
        {
            FileOutputStream fos = openFileOutput("contatos1.txt", Context.MODE_PRIVATE);
            ObjectOutputStream out = new ObjectOutputStream(fos);
            out.writeObject(contato);


            Mensagem("Contato Salvo com sucesso!");

            clean();

        }
        catch (Exception e)
        {
            Mensagem("Erro : " + e.getMessage());
        }



    }

    public void Limpar(View v){
        clean();

    }

    private void Mensagem(String msg)
    {
        Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT).show();

    }

public void clean(){
    Nome.setText("");
    Telefone.setText("");
    Email.setText("");
    Cidade.setText("");

}

public void verContatos(View v){
    Intent intent = new Intent (MainActivity.this, Lista_ContatosActivity.class);
    startActivity(intent);
}

}
