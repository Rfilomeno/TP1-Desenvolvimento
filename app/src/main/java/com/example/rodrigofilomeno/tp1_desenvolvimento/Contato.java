package com.example.rodrigofilomeno.tp1_desenvolvimento;

import java.io.Serializable;

/**
 * Created by rodrigo.filomeno on 10/11/17.
 */

public class Contato implements Serializable {

    String Nome;
    String Telefone;
    String Email;
    String Cidade;

    public Contato(String nome, String telefone, String email, String cidade) {
        Nome = nome;
        Telefone = telefone;
        Email = email;
        Cidade = cidade;
    }
}
