package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdaptadorAlimentos extends RecyclerView.Adapter<AdaptadorAlimentos.ViewHolderGibutaDieta>  {

    private Cursor cursor;
    private Context context;

    public AdaptadorAlimentos(Context context) {
        this.context = context;
    }

    public void setCursor(Cursor cursor) {
        if (this.cursor != cursor) {
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }

    @NonNull
    @Override
    public ViewHolderGibutaDieta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            View itemdados = LayoutInflater.from(context).inflate(R.layout.item_dados, parent, false);
        return new ViewHolderGibutaDieta(itemdados);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGibutaDieta holder, int position) {
        cursor.moveToPosition(position);
        TiposAlimentos tiposAlimentos = TiposAlimentos.fromCursor(cursor);
        holder.setTiposAlimentos(tiposAlimentos);
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }


    public TiposAlimentos getAlimentoSelecionado() {
        if (viewHolderLivroSelecionado == null) return null;

        return viewHolderLivroSelecionado.tiposAlimentos;
    }

    private static ViewHolderGibutaDieta viewHolderLivroSelecionado = null;

    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder implements View.OnClickListener  {


        public TextView textViewTipo;
        public TextView textViewDescricao;
        public TextView textViewValor;

        private TiposAlimentos tiposAlimentos;


        public ViewHolderGibutaDieta(@NonNull View itemView) {
            super(itemView);


            textViewTipo = (TextView)itemView.findViewById(R.id.textViewTipo);
            textViewDescricao =  (TextView)itemView.findViewById(R.id.textViewDescricao);
            textViewValor =  (TextView)itemView.findViewById(R.id.textViewValor);

            itemView.setOnClickListener(this);
        }


        public void setTiposAlimentos(TiposAlimentos tiposAlimentos) {
            this.tiposAlimentos = tiposAlimentos;

            textViewTipo.setText(tiposAlimentos.getAlimentos());
            textViewDescricao.setText(String.valueOf(tiposAlimentos.getDescricaoAlimentos()));
            textViewValor.setText(tiposAlimentos.getNomeCategoria());

        }

        @Override
        public void onClick(View v) {
            if (viewHolderLivroSelecionado != null) {
                viewHolderLivroSelecionado.desSeleciona();
            }

            viewHolderLivroSelecionado = this;

            seleciona();
        }

        private void desSeleciona() {
            itemView.setBackgroundResource(android.R.color.white);
        }

        private void seleciona() {
            itemView.setBackgroundResource(R.color.colorAccent);
        }
        }
}

