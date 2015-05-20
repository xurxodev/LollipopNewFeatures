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
                { new Item("Steve Jobs","Design is not just what it looks like and feels like. Design is how it works.",commonPath + "1"),
                  new Item(" Martin Fowler","Any fool can write code that a computer can understand. Good programmers write code that humans can understand.",commonPath + "2"),
                  new Item("Ralph Johnson ","Before software can be reusable it first has to be usable.",commonPath + "3"),
                  new Item("John Johnson","First, solve the problem. Then, write the code.",commonPath + "4"),
                  new Item("Linus Torvalds","Software is like sex: It’s better when it’s free.",commonPath + "5"),
                  new Item("Steve McConnell","Good code is its own best documentation.",commonPath + "6"),
                  new Item("Vidiu Platon","I don’t care if it works on your machine!  We are not shipping your machine!",commonPath + "7"),
                  new Item("Grady Booch","The function of good software is to make the complex appear to be simple.",commonPath + "8"),
                  new Item("Edward V Berard","Walking on water and developing software from a specification are easy if both are frozen",commonPath + "9"),
                  new Item("Xurxo","You understand something new when you're able to explain it to someone",commonPath + "10")};

        return items;
    }
}
