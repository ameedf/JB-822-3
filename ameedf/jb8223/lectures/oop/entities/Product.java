package ameedf.jb8223.lectures.oop.entities;

import java.util.Random;

public class Product {
    private int catalogId;
    private String name;
    private float price;

    public Product(int catalogId, String name, float price) {
        this.catalogId = catalogId;
        this.name = name;
        this.price = price;
    }

    public Product(String name, float price) {
        this.catalogId = new Random().nextInt(100000);
        this.name = name;
        this.price = price;
    }

    public int getCatalogId() {
        return catalogId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public String productRepresentation() {
        return "Catalog ID: " + catalogId + ", Name: " + name + ", Price: " + price;
    }

    /**
     * Update the price by some percentage.
     * @param percent the percent by which to update the price. May be negative
     */
    public void updatePrice(float percent) {
        if (percent >= -100.0) {
            double factor = 1 + percent / 100.0;
            this.price *= factor;
        }
    }
}
