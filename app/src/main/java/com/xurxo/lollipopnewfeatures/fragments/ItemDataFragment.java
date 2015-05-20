package com.xurxo.lollipopnewfeatures.fragments;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemDataFragment extends Fragment {
    TextView titleTextView;
    TextView descriptionTextView;

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View rootView = inflater.inflate(R.layout.fragment_item_data, container, false);
        titleTextView = (TextView)rootView.findViewById(R.id.detailItemTitle);
        descriptionTextView = (TextView)rootView.findViewById(R.id.detailItemDescription);

        return rootView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        Item item = (Item) getActivity().getIntent().getSerializableExtra("item");

        titleTextView.setText(item.getTitle());
        descriptionTextView.setText(item.getDescription());
    }
}
