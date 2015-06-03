package com.xurxo.lollipopnewfeatures.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.fragments.ItemImageFragment;

public class ItemFullScreenActivity  extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ItemImageFragment())
                    .commit();
        }
    }
}