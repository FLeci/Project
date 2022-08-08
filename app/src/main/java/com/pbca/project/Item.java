package com.pbca.project;

public class Item {
    private String imageUrl, name, bottomtext;
    private int servings;

    public Item(String imageUrl, String name, int servings, String bottomtext) {
        this.imageUrl = imageUrl;
        this.name = name;
        this.servings = servings;
        this.bottomtext = bottomtext;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getName() {
        return name;
    }

    public int getServings() {
        return servings;
    }

    public String getBottomtext() {
        return bottomtext;
    }
}
