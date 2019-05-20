package com.example.gibutadieta;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

public class AdaptadorGibutaDieta extends RecyclerView.Adapter<AdaptadorGibutaDieta.ViewHolderGibutaDieta>{

    private Cursor cursor;
    private Context context;


    @NonNull
    @Override
    public AdaptadorGibutaDieta onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return null;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderGibutaDieta viewHolderGibutaDieta, int i) {

    }

    @Override
    public void onBindViewHolder(@NonNull AdaptadorGibutaDieta adaptadorGibutaDieta, int i) {

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolderGibutaDieta extends RecyclerView.ViewHolder {
    }
}
