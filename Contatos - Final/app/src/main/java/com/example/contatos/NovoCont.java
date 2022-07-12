package com.example.contatos;

import static com.example.contatos.Database.nome_database;
import static com.example.contatos.Database.nome_db;
import static com.example.contatos.Database.nome_tabela;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class NovoCont extends AppCompatActivity implements View.OnClickListener {
    private Button BtnSalvarNovo, BtnMostrarNovo, BtnCancelarNovo, BtnExcluir;
    private TextView txtMostrarNome;
    private EditText edtNomeNovo, edtNumeroNovo, edtEmailNovo, edtEnderecoNovo, edtDataNovo;
    protected ArrayList<Contato> lista;
    private int i;
    private Adapter adapter;
    Database db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.novo);

        //ActionBar ab = getSupportActionBar();
        //ab.setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        lista = getIntent().getParcelableArrayListExtra("lista");

        BtnSalvarNovo = findViewById(R.id.BtnSalvarNovo);
        BtnSalvarNovo.setOnClickListener(this);

        BtnCancelarNovo = findViewById(R.id.BtnCancelarNovo);
        BtnCancelarNovo.setOnClickListener(this);

        BtnMostrarNovo = findViewById(R.id.BtnMostrarNovo);
        BtnMostrarNovo.setOnClickListener(this);

        txtMostrarNome = findViewById(R.id.txtMostrarNovo);

        edtNomeNovo = findViewById(R.id.edtNomeNovo);
        edtNumeroNovo = findViewById(R.id.edtNumeroNovo);
        edtEmailNovo = findViewById(R.id.edtEmailNovo);
        edtEnderecoNovo = findViewById(R.id.edtEnderecoNovo);
        edtDataNovo = findViewById(R.id.edtDataNovo);

        db = new Database(this);

        i = 0;
    }

    private void limpar(){
        edtNomeNovo.setText("");
        edtNumeroNovo.setText("");
        edtEmailNovo.setText("");
        edtEnderecoNovo.setText("");
        edtDataNovo.setText("");
    }

    private void cadastrar(){
        Contato contato = new Contato();

        contato.setNome(edtNomeNovo.getText().toString());
        contato.setNumero(edtNumeroNovo.getText().toString());
        contato.setEmail(edtEmailNovo.getText() + "");
        contato.setEndereco(edtEnderecoNovo.getText().toString());
        contato.setData(edtDataNovo.getText().toString());

        lista.add(contato);
        /*db.insertBD(edtNomeNovo.getText().toString(), edtNumeroNovo.getText().toString(),
                edtEmailNovo.getText().toString(), edtEnderecoNovo.getText().toString(),
                edtDataNovo.getText().toString());*/
        db.insertBD(contato);
        //db.insertBD(contato);
        limpar();

        //String telefone = ((EditText)findViewById(R.id.edtNumeroNovo)).getText().toString();
    }

    public boolean onSupportNavigateUp(){
        finalizar();

        return true;
    }

    @Override
    public void onBackPressed() {
        finalizar();
    }

    public boolean onOptionsItemSelected(MenuItem item){
        return super.onOptionsItemSelected(item);
    }

    /*public void salvarNovo(View view) {
        if(edtNomeNovo.getText().length() == 0){
            //Caixa de dialogo
        }
        else{
            //salvarbd();
            //Intent intentSalvarNovo = new Intent(this, MainActivity.class);
            //startActivity(intentSalvarNovo);
            finish();
        }
    }*/

    private void finalizar(){
        Intent intent = new Intent();
        //intent.putExtra("lista", lista);
        setResult(RESULT_OK, intent);
        finish();
    }

    @Override
    public void onClick(View v) {
        if(v.equals(BtnCancelarNovo)){
            finalizar();
        }

        else if(v.equals(BtnMostrarNovo)){
            if(lista.size() > 0){
                txtMostrarNome.setText(lista.get(i).getNome());
                ++i;
                if(i >= lista.size()){
                    i = 0;
                }
            }
        }

        else if(v.equals(BtnSalvarNovo)){
            cadastrar();

            //Intent intent = new Intent();
            //intent.putExtra("Nome", "Joana");
            /*intent.putExtra("Nome", edtNomeNovo.getText().toString());
            intent.putExtra("Numero", edtNumeroNovo.getText().toString());
            intent.putExtra("Endereco", edtEnderecoNovo.getText().toString());
            intent.putExtra("Email", edtEmailNovo.getText().toString());
            intent.putExtra("Data", edtDataNovo.getText().toString());*/

            //finalizar();
        }
    }
}
