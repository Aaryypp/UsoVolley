package com.ariel.usovolley;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.util.TypedValue;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.util.Log;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ArticulosAdapter extends RecyclerView.Adapter<ArticulosAdapter.ViewHolder> {
    private ArrayList<Articulo> mDataSet;
    private final Context mContext;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;

        public ViewHolder(TextView tv) {
            super(tv);
            textView = tv;
        }
    }

    public ArticulosAdapter(Context context) {
        mDataSet = new ArrayList<>();
        mContext = context;
    }

    public void setDataSet(ArrayList<Articulo> dataSet) {
        mDataSet = dataSet;
        notifyDataSetChanged();
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        TextView tv = (TextView) LayoutInflater.from(parent.getContext()).inflate(R.layout.item_articulo, parent, false);
        tv.setGravity(Gravity.CENTER_HORIZONTAL);
        return new ViewHolder(tv);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Articulo articulo = mDataSet.get(position);
        holder.textView.setText((position + 1) + ". " + articulo.getNombre());
        holder.textView.setOnClickListener(v -> verArticulo(articulo));
    }

    private void verArticulo(Articulo articulo) {
        // Crear el mensaje con formato
        String mensaje = "ID: " + articulo.getId()
                + "\nNombre: " + articulo.getNombre()
                + "\nCategoría: " + articulo.getCategoria()
                + "\nStock: " + articulo.getStock()
                + "\nID Proveedor: " + articulo.getId_p();

        // Crear un nuevo Toast con duración corta
        Toast toast = Toast.makeText(mContext, mensaje, Toast.LENGTH_SHORT);

        // Mostrar el Toast centrado en la pantalla
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();

        // Puedes descomentar el siguiente código para iniciar la actividad si es necesario
    /*
    Intent intent = new Intent(mContext, ArticuloVista.class);
    intent.putExtra("objeto_articulo", articulo);
    mContext.startActivity(intent);
    */
    }


    @Override
    public int getItemCount() {
        return mDataSet.size();
    }
}

