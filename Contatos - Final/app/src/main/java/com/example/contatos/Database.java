package com.example.contatos;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Database extends SQLiteOpenHelper {
    private static final String TAG = "Database";

    public static final String nome_database = "contato.db";
    public static final String nome_tabela ="pessoa_tb";
    public static final String codigo_db = "codigo";
    public static final String nome_db = "name";
    public static final String numero_db = "numero";
    public static final String email_db = "email";
    public static final String endereco_db = "endereco";
    public static final String data_nasc_db = "data";

    public Database(@Nullable Context context) {
        super(context, nome_database, null, 1);
        SQLiteDatabase bd = this.getWritableDatabase();
    }

    String comandos(){
        return "create table " + nome_tabela + "(" +
                codigo_db + " integer primary key autoincrement," +
                nome_db + " text," +
                numero_db + " text," +
                email_db + " text," +
                endereco_db + " text," +
                data_nasc_db + " text"
                + ")";
    }

    @Override
    public void onCreate(SQLiteDatabase bd) {
        bd.execSQL(comandos());
    }

    @Override
    public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion) {
        //bd.execSQL("DROP TABLE IF EXIST " + nome_tabela);
        onCreate(bd);
    }

    public boolean insertBD(Contato contato){
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();

        content_values.put(nome_db, contato.getNome());
        content_values.put(numero_db, contato.getNumero());
        content_values.put(email_db, contato.getEmail());
        content_values.put(endereco_db, contato.getEndereco());
        content_values.put(data_nasc_db, contato.getData());

        long result = bd.insert(nome_tabela, null, content_values);

        if(result == -1){
            return false;
        }
        else{
            return true;
        }
    }

    public List<Contato> mostrarBD(){
        SQLiteDatabase bd = this.getWritableDatabase();
        List<Contato> contatos = new ArrayList<>();
        Cursor res = bd.rawQuery("select * from "+ nome_tabela, null);

        while(res.moveToNext()){
            Contato contato = new Contato();
            contato.setId(res.getString(0));
            contato.setNome(res.getString(1));
            contato.setNumero(res.getString(2));
            contato.setEndereco(res.getString(4));
            contato.setEmail(res.getString(3));
            contato.setData(res.getString(5));

            contatos.add(contato);
        }

        return contatos;
    }

    public Contato visuBD(String id){
        SQLiteDatabase bd = this.getWritableDatabase();
        ///Cursor res = bd.rawQuery("select * from "+ nome_tabela, null);
        Contato contato = new Contato();
        //Cursor cursor= bd.rawQuery("SELECT * FROM " + nome_tabela + " WHERE codigo =?",new String[] { id });
        //Cursor res = bd.rawQuery("select * from pessoa_tb where codigo = ?", new String[]{id});
        //Cursor res = bd.rawQuery("select * from pessoa_tb",null);
        Cursor res = bd.rawQuery("select * from pessoa_tb where codigo = " + id, null);
        //Cursor res = bd.query(nome_tabela,new String[] {codigo_db,nome_db,numero_db,endereco_db,email_db},codigo_db,new String[] {id}, null, null, null);
        //Log.v(TAG,"Teste");
        if(res.moveToNext()){
            //Contato contato = new Contato();
            contato.setId(res.getString(0));
            contato.setNome(res.getString(1));
            contato.setNumero(res.getString(2));
            contato.setEndereco(res.getString(4));
            contato.setEmail(res.getString(3));
            contato.setData(res.getString(5));
        }
        /*contato.setId(res.getString(0));
        contato.setNome(res.getString(1));
        contato.setNumero(res.getString(2));
        contato.setEndereco(res.getString(4));
        contato.setEmail(res.getString(3));
        contato.setData(res.getString(5));*/
        //Log.v(TAG,"Nome: "+contato.getNome());

        return contato;
    }

    //public boolean updateBD(String id, String nome, String numero, String email, String endereco, String data_nasc){
    public boolean updateBD(Contato contato){
        //Toast.makeText("Click", );
        SQLiteDatabase bd = this.getWritableDatabase();
        ContentValues content_values = new ContentValues();

        content_values.put(nome_db, contato.getNome());
        content_values.put(numero_db, contato.getNumero());
        content_values.put(email_db, contato.getEmail());
        content_values.put(endereco_db, contato.getEndereco());
        content_values.put(data_nasc_db, contato.getData());

        //bd.rawQuery("update pessoa_tb set name = 'teste' where codigo = 3", null);
        Log.d(TAG, "updatebd " + contato.getId() + "text");

        bd.update(nome_tabela, content_values, "codigo = ?", new String[]{contato.getId()});

        return true;
    }

    public boolean deleteBD(String id){
        SQLiteDatabase bd = this.getWritableDatabase();

        //bd.delete(nome_tabela, "id = ?", new String[]{id});
        bd.delete(nome_tabela, "codigo = ?", new String[]{id});

        return true;
    }
}
