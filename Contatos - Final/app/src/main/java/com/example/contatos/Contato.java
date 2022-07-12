package com.example.contatos;

import android.os.Parcel;
import android.os.Parcelable;

public class Contato implements Parcelable {

    private String id, nome, numero, email, endereco, data;

    protected Contato(Parcel in) {
        id = in.readString();
        nome = in.readString();
        numero = in.readString();
        email = in.readString();
        endereco = in.readString();
        data = in.readString();
    }

    public static final Creator<Contato> CREATOR = new Creator<Contato>() {
        @Override
        public Contato createFromParcel(Parcel in) {
            return new Contato(in);
        }

        @Override
        public Contato[] newArray(int size) {
            return new Contato[size];
        }
    };

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }


    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }


    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }


    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public Contato(String id, String nome, String numero, String email, String endereco, String data) {
        this.id = id;
        this.nome = nome;
        this.numero = numero;
        this.email = email;
        this.endereco = endereco;
        this.data = data;
    }

    public Contato(){
        this("", "", "", "", "", "");
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(nome);
        dest.writeString(numero);
        dest.writeString(email);
        dest.writeString(endereco);
        dest.writeString(data);
    }
}
