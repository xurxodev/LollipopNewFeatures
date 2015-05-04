package com.xurxo.lollipopnewfeatures;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

public class ItemsActivity extends ActionBarActivity {

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
}
