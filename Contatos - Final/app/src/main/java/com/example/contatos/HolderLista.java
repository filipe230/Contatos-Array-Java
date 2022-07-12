package com.example.contatos;

import android.view.View;
import android.widget.AdapterView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HolderLista extends RecyclerView.ViewHolder implements View.OnClickListener {
    public TextView txtNome, txtNumero;
    private ArrayList<Contato> lista;
    private RVClick rvClick;

    public HolderLista(@NonNull View itemView, RVClick rvClick) {
        super(itemView);
        this.lista = lista;
        this.rvClick = rvClick;

        txtNome = itemView.findViewById(R.id.nome_contLayout);
        txtNumero = itemView.findViewById(R.id.numero_contLayout);

        /*itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //RVClick.itemClick(getAdapterPosition());
                Intent intent = new Intent(itemView.getContext(), NovoCont.class);
                intent.putExtra("lista", lista.get(getAdapterPosition()).getNome());
                intent.putExtra("lista", "Joao");
                itemView.getContext().startActivity(intent);
                //Toast.makeText(itemView.getContext(), "ViewHolder Holder" + getAdapterPosition(), 2000).show();
                //int position = getLayoutPosition();
                //int pos = lista.indexOf(lista);

                //Intent intent = new Intent(itemView.getContext(), Visualizar.class);
                //intent.putExtra("lista", lista.get(getAdapterPosition()).getNome());

                //Toast.makeText(itemView.getContext(), "ViewHolder clicado", 4000).show();
                //lista.get(getAdapterPosition())

                //onItemClickListener.onItemClick(AdapterView<?>, View, int, long);
                //Intent intent = new Intent(this, Visualizar.class);
                //resultAddActivity.launch(intent);
                //intent.putExtra("lista", lista);
                //startActivityForResult(intent, Activity.CONTEXT_INCLUDE_CODE);*/
            //}
        //});

        //itemView.setOnClickListener((View.OnClickListener) this);
        itemView.setOnClickListener(this);
    }

    public TextView getTxtNome() {
        return txtNome;
    }

    public TextView getTxtNumero() {
        return txtNumero;
    }

    public void onClick(View v) {
        rvClick.itemClick(getAdapterPosition());

        //Toast.makeText(v.getContext(), "ViewHolder clicado jjj" + getAdapterPosition(), 2000).show();

    }
}