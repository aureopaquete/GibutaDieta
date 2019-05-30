package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class AdaptadorGibutaDieta extends RecyclerView.Adapter<AdaptadorGibutaDieta.ViewHolderGibutaDieta>{

    private Cursor cursor;
    private Context context;

    public void setContext(Context context) {
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
    }

    @Override
    public int getItemCount() {
        if (cursor == null) return 0;

        return cursor.getCount();
    }

    private static ViewHolderGibutaDieta viewHolderGibutaDietaSelecionado = null;


    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder {


        

        private TiposAlimentos alimentos;

        public ViewHolderGibutaDieta(@NonNull View itemView) {
            super(itemView);
        }

        public void setAlimentos(TiposAlimentos alimentos) {
            this.alimentos = alimentos;
        }
    }
}
