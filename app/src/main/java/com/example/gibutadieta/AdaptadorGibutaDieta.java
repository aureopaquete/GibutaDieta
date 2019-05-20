package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public class AdaptadorGibutaDieta extends RecyclerView.Adapter<AdaptadorGibutaDieta.ViewHolderGibutaDieta>{

    private Cursor cursor;
    private Context context;


    @NonNull
    @Override
    public ViewHolderGibutaDieta onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGibutaDieta viewHolderGibutaDieta, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder {
        public ViewHolderGibutaDieta(@NonNull View itemView) {
            super(itemView);
        }
    }
}
