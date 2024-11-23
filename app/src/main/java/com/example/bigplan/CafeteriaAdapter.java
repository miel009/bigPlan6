package com.example.bigplan;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class CafeteriaAdapter extends RecyclerView.Adapter<CafeteriaAdapter.ViewHolder> {

    private List<Cafeteria> cafeteriaList;

    public CafeteriaAdapter(List<Cafeteria> cafeteriaList) {
        this.cafeteriaList = cafeteriaList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_cafeteria, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Cafeteria cafeteria = cafeteriaList.get(position);
        holder.tvNombreCafeteria.setText(cafeteria.getNombre());
        holder.tvDireccionCafeteria.setText(cafeteria.getDireccion());
    }

    @Override
    public int getItemCount() {
        return cafeteriaList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvNombreCafeteria, tvDireccionCafeteria;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvNombreCafeteria = itemView.findViewById(R.id.tvNombreCafeteria);
            tvDireccionCafeteria = itemView.findViewById(R.id.tvDireccionCafeteria);
        }
    }
}
