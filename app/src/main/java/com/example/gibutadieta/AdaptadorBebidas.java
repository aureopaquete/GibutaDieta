package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class AdaptadorBebidas extends RecyclerView.Adapter<AdaptadorBebidas.ViewHolderBebidas>  {

    private Cursor cursor;
    private Context context;

    public AdaptadorBebidas(Context context) {
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
    public AdaptadorBebidas.ViewHolderBebidas onCreateViewHolder(@NonNull ViewGroup parent, int viewType){
        View itemdados = LayoutInflater.from(context).inflate(R.layout.item_dados, parent, false);
        return new AdaptadorBebidas.ViewHolderBebidas(itemdados);
    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorBebidas.ViewHolderBebidas holder, int position) {
        cursor.moveToPosition(position);
        TiposBebidas tiposBebidas = TiposBebidas.fromCursor(cursor);
        holder.setTiposBebidas(tiposBebidas);
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }



    public TiposBebidas getBebidaSelecionada() {
        if (viewHolderBbebidaSelecionada == null) return null;

        return viewHolderBbebidaSelecionada.tiposBebidas;
    }

    private static AdaptadorBebidas.ViewHolderBebidas viewHolderBbebidaSelecionada = null;

    public class ViewHolderBebidas extends RecyclerView.ViewHolder implements View.OnClickListener {


        public TextView textViewTipo;
        public TextView textViewDescricao;
        public TextView textViewValor;

        private TiposBebidas tiposBebidas;


        public ViewHolderBebidas(@NonNull View itemView) {
            super(itemView);

            textViewTipo = (TextView) itemView.findViewById(R.id.textViewTipo);
            textViewDescricao = (TextView) itemView.findViewById(R.id.textViewDescricao);
            textViewValor = (TextView) itemView.findViewById(R.id.textViewValor);

            itemView.setOnClickListener(this);
        }

        public void setTiposBebidas(TiposBebidas tiposBebidas) {
            this.tiposBebidas = tiposBebidas;

            textViewTipo.setText(tiposBebidas.getNomeCategoriaBebida());
            textViewDescricao.setText(tiposBebidas.getDescricaoBebidas());
            textViewValor.setText(String.valueOf(tiposBebidas.getBebidas())+"cl");

        }


        @Override
        public void onClick(View v) {

            if (viewHolderBbebidaSelecionada != null) {
                viewHolderBbebidaSelecionada.desSeleciona();
            }

            viewHolderBbebidaSelecionada = this;

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
