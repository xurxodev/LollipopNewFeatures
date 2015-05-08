package com.xurxo.lollipopnewfeatures.models;

import java.io.Serializable;

public class Item implements Serializable {
    String title;
    String description;
    String imageUrl;

    public Item(String title, String description, String imageUrl) {
        this.title = title;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public String getImageUrl() {
        return imageUrl;
    }
}
