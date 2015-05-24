package com.xurxo.lollipopnewfeatures.activities;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.graphics.Palette;

import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.fragments.ItemDataFragment;
import com.xurxo.lollipopnewfeatures.fragments.ItemImageFragment;

public class ItemDetailActivity  extends ActionBarActivity
                                 implements ItemImageFragment.OnPaletteGeneratedListener {

    private static final String TAG_IMAGE_FRAGMENT = "image_fragment";
    private static final String TAG_DATA_FRAGMENT = "data_fragment";
    ItemImageFragment itemImageFragment;
    ItemDataFragment itemDataFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item_detail);

        itemImageFragment = (ItemImageFragment) getSupportFragmentManager().findFragmentByTag(TAG_IMAGE_FRAGMENT);
        itemDataFragment = (ItemDataFragment) getSupportFragmentManager().findFragmentByTag(TAG_DATA_FRAGMENT);

        if (itemImageFragment == null) {
            itemImageFragment = new ItemImageFragment();
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.itemImageContainer, itemImageFragment,TAG_IMAGE_FRAGMENT)
                    .commit();
        }

        if (itemDataFragment == null) {
            itemDataFragment = new ItemDataFragment();

            getSupportFragmentManager().beginTransaction()
                    .add(R.id.itemDataContainer, itemDataFragment,TAG_DATA_FRAGMENT)
                    .commit();
        }
    }

    //OnPaletteGeneratedListener
    @Override
    public void onPaletteGenerated(Palette palette) {
        if (itemDataFragment != null)
            itemDataFragment.updatePalette(palette);
    }

}