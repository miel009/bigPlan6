package com.example.bigplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.FavoritesViewHolder> {

    private final List<Cafeteria> favorites;

    public FavoritesAdapter(List<Cafeteria> favorites) {
        this.favorites = favorites;
    }

    // ViewHolder para manejar los elementos de la lista
    public static class FavoritesViewHolder extends RecyclerView.ViewHolder {
        public final TextView nameTextView;


        public FavoritesViewHolder(@NonNull View view) {
            super(view);
            nameTextView = view.findViewById(android.R.id.text1);
        }
    }

    @NonNull
    @Override
    public FavoritesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(android.R.layout.simple_list_item_1, parent, false);
        return new FavoritesViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesViewHolder holder, int position) {
        holder.nameTextView.setText(favorites.get(position).getNombre());
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }
}