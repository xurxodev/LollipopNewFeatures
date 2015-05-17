package com.xurxo.lollipopnewfeatures.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.activities.ItemDetailActivity;
import com.xurxo.lollipopnewfeatures.adapters.ItemsAdapter;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    private Item[] items;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.items_recycler_view);

        layoutManager = new GridLayoutManager(rootView.getContext(),2);

        recyclerView.setHasFixedSize(true);

        recyclerView.setLayoutManager(layoutManager);

        items = createItems();

        adapter = new ItemsAdapter(items);

        ((ItemsAdapter) adapter).setOnItemClickListener(new ItemsAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                Item item = items[position];

                View sharedView = view.findViewById(R.id.itemImage);
                String transitionName = getString(R.string.image_transition_name);

                ActivityOptionsCompat options =
                        ActivityOptionsCompat.makeSceneTransitionAnimation(
                                getActivity(),  sharedView, transitionName);

                Intent intent = new Intent(getActivity(), ItemDetailActivity.class);
                intent.putExtra("item", item);
                ActivityCompat.startActivity(getActivity(), intent, options.toBundle());
            }
        });

        recyclerView.setAdapter(adapter);

        return rootView;
    }


    private Item[] createItems(){

        String commonPath = "http://lorempixel.com/400/400/people/";

        Item[] items = new Item[]
                { new Item("Titulo 1",null,commonPath + "1"),
                        new Item(null,null,commonPath + "2"),
                        new Item(null,null,commonPath + "3"),
                        new Item(null,null,commonPath + "4"),
                        new Item(null,null,commonPath + "5"),
                        new Item(null,null,commonPath + "6"),
                        new Item(null,null,commonPath + "7"),
                        new Item(null,null,commonPath + "8"),
                        new Item(null,null,commonPath + "9"),
                        new Item(null,null,commonPath + "10")};

        return items;
    }
}
