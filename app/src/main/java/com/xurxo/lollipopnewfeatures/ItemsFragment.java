package com.xurxo.lollipopnewfeatures;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class ItemsFragment extends Fragment {
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_items, container, false);

        recyclerView = (RecyclerView) rootView.findViewById(R.id.items_recycler_view);

        //poner a true si cambios en el contenido  no supone
        //cambios en el tamaño del control, esto mejora rendimiento
        recyclerView.setHasFixedSize(true);

        //usamos un GridLayoutManager con 2 columnas
        layoutManager = new GridLayoutManager(rootView.getContext(),2);

        recyclerView.setLayoutManager(layoutManager);

        adapter = new ItemsAdapter(createItems());

        recyclerView.setAdapter(adapter);
        return rootView;
    }


    private Item[] createItems(){

        String commonPath = "http://lorempixel.com/400/400/people/";

        Item[] items = new Item[]
                { new Item(null,null,commonPath + "1"),
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
