package com.example.bigplan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class PlaceAdapter extends RecyclerView.Adapter<PlaceAdapter.PlaceViewHolder> {

    private final Context context;
    private final List<Place> places;

    public PlaceAdapter(Context context, List<Place> places) {
        this.context = context;
        this.places = places;
    }

    @NonNull
    @Override
    public PlaceViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Inflar el diseño item_card.xml
        View view = LayoutInflater.from(context).inflate(R.layout.item_card, parent, false);
        return new PlaceViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PlaceViewHolder holder, int position) {
        // Obtener el objeto Place actual
        Place place = places.get(position);

        // Configurar el título
        holder.placeTitle.setText(place.getTitle());

        // Cargar la imagen con Glide
        Glide.with(context)
                .load(place.getImageUrl())
                .into(holder.placeImage);
    }

    @Override
    public int getItemCount() {
        return places.size(); // Cantidad de elementos en la lista
    }

    // Clase ViewHolder para vincular vistas
    public static class PlaceViewHolder extends RecyclerView.ViewHolder {
        ImageView placeImage;
        TextView placeTitle;

        public PlaceViewHolder(@NonNull View itemView) {
            super(itemView);

            // Vincular las vistas del diseño item_card.xml
            placeImage = itemView.findViewById(R.id.placeImage);
            placeTitle = itemView.findViewById(R.id.placeTitle);
        }
    }


}
