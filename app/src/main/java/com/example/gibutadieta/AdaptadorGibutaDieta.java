package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdaptadorGibutaDieta extends RecyclerView.Adapter<AdaptadorGibutaDieta.ViewHolderGibutaDieta>{

    private Cursor cursor;
    private Context context;

    public  AdaptadorGibutaDieta(Context context) {
        this.context = context;
    }

    //Notificação do Cursor
    public void setCursor(Cursor cursor) {
        if (this.cursor != cursor) {
            this.cursor = cursor;
            notifyDataSetChanged();
        }
    }


    @NonNull
    @Override
    public ViewHolderGibutaDieta onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemDados = LayoutInflater.from(context).inflate(R.layout.item_dados, parent, false);

        return new ViewHolderGibutaDieta(itemDados);

    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGibutaDieta holder, int position) {
        cursor.moveToPosition(position);
        TiposAlimentos alimentos = TiposAlimentos.fromCursor(cursor);
        holder.setAlimentos(alimentos);
        TiposBebidas bebidas = TiposBebidas.fromCursor(cursor);
        holder.setBebidas(bebidas);
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }

    private static ViewHolderGibutaDieta viewHolderGibutaDietaSelecionado = null;


    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder {


        private TextView textViewconsumo;
        private TextView textViewHora;
        private TextView textViewQuantidade;


        private TiposAlimentos alimentos;
        private TiposBebidas bebidas;

        public ViewHolderGibutaDieta(@NonNull View itemView) {
            super(itemView);

            textViewconsumo = (TextView)itemView.findViewById(R.id.textViewconsumo);
            textViewHora =  (TextView)itemView.findViewById(R.id.textViewHora);
            textViewQuantidade =  (TextView)itemView.findViewById(R.id.textViewQuantidade);


        }

        public void setAlimentos(TiposAlimentos alimentos) {
            this.alimentos = alimentos;

            textViewconsumo.setText(alimentos.getAlimentos());

        }

        public void setBebidas(TiposBebidas bebidas) {
            this.bebidas = bebidas;

            textViewconsumo.setText(bebidas.getBebidas());

        }

        public void onClick(View v) {
            if (viewHolderGibutaDietaSelecionado != null) {
                viewHolderGibutaDietaSelecionado.desSeleciona();
            }

            viewHolderGibutaDietaSelecionado = this;

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
