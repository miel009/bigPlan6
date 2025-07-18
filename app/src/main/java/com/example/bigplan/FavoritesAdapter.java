package com.example.bigplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class FavoritesAdapter extends RecyclerView.Adapter<FavoritesAdapter.ViewHolder> {

    private List<FavoritoItem> favorites;



    public FavoritesAdapter(List<FavoritoItem> favorites) {
        this.favorites = favorites;
    }

    @NonNull
    @Override
    public FavoritesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_favorito, parent, false); // Asegúrate de tener este layout
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull FavoritesAdapter.ViewHolder holder, int position) {
        FavoritoItem item = favorites.get(position);
        holder.nombreText.setText(item.getNombre());
        holder.descripcionText.setText(item.getDescripcion());
    }

    @Override
    public int getItemCount() {
        return favorites.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView nombreText;
        TextView descripcionText;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            nombreText = itemView.findViewById(R.id.textNombre);
            descripcionText = itemView.findViewById(R.id.textDescripcion);
        }
    }
}
