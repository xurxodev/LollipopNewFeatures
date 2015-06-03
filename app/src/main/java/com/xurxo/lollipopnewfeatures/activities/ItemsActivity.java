package com.xurxo.lollipopnewfeatures.activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.ActivityOptionsCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.View;

import com.xurxo.lollipopnewfeatures.fragments.ItemsFragment;
import com.xurxo.lollipopnewfeatures.R;
import com.xurxo.lollipopnewfeatures.models.Item;

public class ItemsActivity extends ActionBarActivity implements ItemsFragment.OnItemClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_items);

        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new ItemsFragment())
                    .commit();
        }
    }

    @Override
    public void onItemClick(View view,Item item) {
        View sharedView = view.findViewById(R.id.itemImage);
        String transitionName = getString(R.string.image_transition_name);

        ActivityOptionsCompat options =
                ActivityOptionsCompat.makeSceneTransitionAnimation(
                        this,  sharedView, transitionName);

        Intent intent = new Intent(this, ItemDetailActivity.class);
        intent.putExtra("item", item);
        ActivityCompat.startActivity(this, intent, options.toBundle());
    }
}
