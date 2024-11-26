package com.example.bigplan;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CafeteriaAdapter extends RecyclerView.Adapter<CafeteriaAdapter.CafeteriaViewHolder> {

    private final List<Cafeteria> cafeterias;
    private final OnCafeteriaClickListener onCafeteriaClicked;

    // Interfaz para manejar clics
    public interface OnCafeteriaClickListener {
        void onCafeteriaClick(Cafeteria cafeteria);
    }

    public CafeteriaAdapter(List<Cafeteria> cafeterias, OnCafeteriaClickListener onCafeteriaClicked) {
        this.cafeterias = cafeterias;
        this.onCafeteriaClicked = onCafeteriaClicked;
    }

    public static class CafeteriaViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;

        public CafeteriaViewHolder(@NonNull View view) {
            super(view);
            nameTextView = view.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public CafeteriaViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new CafeteriaViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CafeteriaViewHolder holder, int position) {
        Cafeteria cafeteria = cafeterias.get(position);
        holder.nameTextView.setText(cafeteria.getNombre());
        holder.itemView.setOnClickListener(view -> onCafeteriaClicked.onCafeteriaClick(cafeteria));
    }

    @Override
    public int getItemCount() {
        return cafeterias.size();
    }
}