package com.example.contatos;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<HolderLista>{
    private ArrayList<Contato> lista;
    private RVClick rvClick;

    public Adapter(ArrayList<Contato> lista, RVClick rvClick){
        this.rvClick = rvClick;
        this.lista = lista;
    }

    @NonNull
    @Override
    public HolderLista onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.contato_layout, parent, false);

        return new HolderLista(view, rvClick);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderLista holder, int position) {
        holder.getTxtNome().setText(lista.get(position).getNome());
        holder.getTxtNumero().setText(lista.get(position).getNumero());
    }

    @Override
    public int getItemCount() {
        return lista.size();
    }

    public ArrayList<Contato> getLista(){
        return lista;
    }

    public void setLista(ArrayList<Contato> lista){
        this.lista = lista;
        notifyDataSetChanged();
    }
}
