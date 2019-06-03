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

        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());

        View itemDados = layoutInflater.from(context).inflate(R.layout.item_dados, parent, false);

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

    public TiposAlimentos getTiposAlimentosSelecionado() {
        if (viewHolderGibutaDietaSelecionado == null) return null;

        return viewHolderGibutaDietaSelecionado.alimentos;
    }


    public TiposBebidas getTiposBebidasSelecionado() {
        if (viewHolderGibutaDietaSelecionado == null) return null;

        return viewHolderGibutaDietaSelecionado.bebidas;
    }

    private static ViewHolderGibutaDieta viewHolderGibutaDietaSelecionado = null;


    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView textViewconsumo;
        public TextView textViewQuantidade;
        //private TextView textViewHora;



        private TiposAlimentos alimentos;
        private TiposBebidas bebidas;

        public ViewHolderGibutaDieta(@NonNull View itemView) {
            super(itemView);

            textViewconsumo = (TextView)itemView.findViewById(R.id.textViewconsumo);
            textViewQuantidade =  (TextView)itemView.findViewById(R.id.textViewQuantidade);
            //textViewHora =  (TextView)itemView.findViewById(R.id.textViewHora);

            itemView.setOnClickListener(this);

        }

        public void setAlimentos(TiposAlimentos alimentos) {
            this.alimentos = alimentos;

            textViewQuantidade.setText(alimentos.getAlimentos());

        }

        public void setBebidas(TiposBebidas bebidas) {
            this.bebidas = bebidas;

            textViewQuantidade.setText(bebidas.getBebidas());

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
