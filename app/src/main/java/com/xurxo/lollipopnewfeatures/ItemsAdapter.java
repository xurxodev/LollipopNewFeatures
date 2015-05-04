package com.xurxo.lollipopnewfeatures;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private Item[] items;

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(View v) {
            super(v);
            imageView = (ImageView) v.findViewById(R.id.itemImage);
        }
    }

    public ItemsAdapter(Item[] items) {
        this.items = items;
    }

    // crea una nueva vista(invocado por el layout manager)
    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        //creamos la nueva imagen
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_items, parent, false);

        ViewHolder vh = new ViewHolder(v);
        return vh;
    }

    // Reemplaza el contenido de una vista (invocado por el layout manager)
    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items[position];

        //cargamos la imagen con picasso
        Picasso.with(holder.imageView.getContext())
                .load(item.imageUrl)
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }
}