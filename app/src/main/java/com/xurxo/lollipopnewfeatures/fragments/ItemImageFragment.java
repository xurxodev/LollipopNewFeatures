package com.xurxo.lollipopnewfeatures.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;
import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemImageFragment extends Fragment {

    ImageView imageView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                            Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_item_image, container, false);
        imageView = (ImageView)rootView.findViewById(R.id.detailItemImage);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Item item = (Item) getActivity().getIntent().getSerializableExtra("item");

        //cargamos la imagen con picasso
        Picasso.with(imageView.getContext())
                .load(item.getImageUrl())
                .into(imageView);


    }
}
