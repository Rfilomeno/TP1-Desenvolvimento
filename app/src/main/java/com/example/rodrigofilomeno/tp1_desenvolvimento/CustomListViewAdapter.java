package com.example.rodrigofilomeno.tp1_desenvolvimento;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by cfilo on 15/12/2017.
 */

public class CustomListViewAdapter extends ArrayAdapter<Contato> {

    private ArrayList<Contato> contato;
    private Context context;


    public CustomListViewAdapter(Context c,ArrayList<Contato> objects) {
        super(c, 0, objects);
        this.context = c;
        this.contato = objects;
    }


    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        View view = null;

        if (contato != null){
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);

            view = inflater.inflate(R.layout.listacontato, parent , false);
            TextView txtViewNome = (TextView) view.findViewById(R.id.txtViewNome);

            Contato contatos = contato.get(position);
            txtViewNome.setText(contatos.Nome.toString());

        }
        return view;


    }
}