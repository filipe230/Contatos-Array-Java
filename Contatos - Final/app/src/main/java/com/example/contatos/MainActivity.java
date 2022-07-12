package com.example.contatos;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.*;
import android.widget.*;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements RVClick{
    //private Button BtnBuscar, BtnNovoMain;
    protected ArrayList<Contato> lista;
    //private TextView ConsultaTXT;
    private RecyclerView rvLista;
    private EditText edtBuscarMain;
    private int i;
    private Adapter adapter;
    private FloatingActionButton BtnNovoFloa;
    Database db;
    private List<Contato> lista_cont = new ArrayList<>();
    //private static final String TAG = "MyActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lista = getIntent().getParcelableArrayListExtra("lista");
        if(lista == null){
            lista = new ArrayList();
        }

        Contato cont1 = new Contato();
        cont1.setNome("Joao");
        cont1.setNumero("123-45678");
        cont1.setEmail("fp@gmail");
        cont1.setEndereco("Rua 8");
        cont1.setData("23/08/2002");

        Contato cont2 = new Contato();
        cont2.setNome("Maria");
        cont2.setNumero("9988776655");
        cont2.setEmail("jj");
        cont2.setEndereco("Av");
        cont2.setData("10/01/2014");

        Contato cont3 = new Contato();
        cont3.setNome("Joaquim");
        cont3.setNumero("123-45678");
        cont3.setEmail("joaquim12");
        cont3.setEndereco("Bairro");
        cont3.setData("");

        Contato cont4 = new Contato();
        cont4.setNome("Marioooo");
        cont4.setNumero("9988776655");
        cont4.setEmail("marioo@outlook");
        cont4.setEndereco("Logradouro");
        cont4.setData("");

        Contato cont5 = new Contato();
        cont5.setNome("THua");
        cont5.setNumero("123-45678");
        cont5.setEmail("thua@ifgoiano");
        cont5.setEndereco("centro");
        cont5.setData("10/10/10");

        /*lista.add(cont1);
        lista.add(cont2);
        lista.add(cont3);
        lista.add(cont4);
        lista.add(cont5);*/

        //BtnBuscar = findViewById(R.id.BtnBuscarMain);
        //BtnNovoMain = findViewById(R.id.BtnNovoMain);
        BtnNovoFloa = findViewById(R.id.BtnNovoFloa);

        rvLista = findViewById(R.id.rvLista);

        db = new Database(this);
        lista = new ArrayList<>(db.mostrarBD());
        adapter = new Adapter(lista, this);
        rvLista.setAdapter(adapter);

        /*adapter = new Adapter(lista, this);
        rvLista.setAdapter(adapter);*/
        RecyclerView.LayoutManager layout = new LinearLayoutManager (this, LinearLayoutManager.VERTICAL, false);
        rvLista.setLayoutManager(layout);
        rvLista.setHasFixedSize(true);

        i = 0;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        //lista = data.getParcelableArrayListExtra("lista");
        lista = new ArrayList<>(db.mostrarBD());

        adapter.setLista(lista);
        adapter.notifyDataSetChanged();
    }

    public void novoMain(View view) {
        Intent intentNovoMain = new Intent(this, NovoCont.class);
        intentNovoMain.putExtra("lista", lista);
        startActivityForResult(intentNovoMain, Activity.CONTEXT_INCLUDE_CODE);
    }

    @Override
    public void itemClick(int pos) {
        //Toast.makeText(this, "Click" + pos, Toast.LENGTH_SHORT).show();
        //Toast.makeText(this, "Click: " + pos, Toast.LENGTH_SHORT).show();

        Intent intentItem = new Intent(this, Visualizar.class);
        //intentItem.putExtra("lista", lista);
        //intentItem.putExtra("pos", Integer.toString(pos));
        /*intentItem.putExtra("nome", lista.get(pos).getNome());
        intentItem.putExtra("numero", lista.get(pos).getNumero());
        intentItem.putExtra("email", lista.get(pos).getEmail());
        intentItem.putExtra("endereco", lista.get(pos).getEndereco());
        intentItem.putExtra("data", lista.get(pos).getData());*/
        intentItem.putExtra("contato", lista.get(pos));

        startActivityForResult(intentItem, Activity.CONTEXT_INCLUDE_CODE);
    }
}