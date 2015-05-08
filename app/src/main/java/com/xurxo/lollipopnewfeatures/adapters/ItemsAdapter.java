package com.xurxo.lollipopnewfeatures.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private Item[] items;
    private static OnItemClickListener onItemClickListener;

    public ItemsAdapter(Item[] items) {
        this.items = items;
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        onItemClickListener = listener;
    }

    @Override
    public ItemsAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_items, parent, false);

        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Item item = items[position];

        Picasso.with(holder.imageView.getContext())
                .load(item.getImageUrl())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return items.length;
    }

    public static interface OnItemClickListener {
        public void onItemClick(View view, int position);
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ImageView imageView;

        public ViewHolder(View itemRootView) {
            super(itemRootView);
            imageView = (ImageView) itemRootView.findViewById(R.id.itemImage);

            itemRootView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position  = ViewHolder.super.getAdapterPosition();
                    onItemClickListener.onItemClick(view,position);
                }
            });
        }
    }
}