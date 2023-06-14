package model;

import java.util.HashMap;

public class Category {

    private final String name;
    private final HashMap<String, Category> subCategories;

    public Category(String name, HashMap<String, Category> subCategories) {
        this.name = name;
        this.subCategories = subCategories;
    }

    public String getName() {
        return name;
    }

    public HashMap<String, Category> getSubCategories() {
        return subCategories;
    }
}
