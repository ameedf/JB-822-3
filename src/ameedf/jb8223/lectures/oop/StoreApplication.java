package ameedf.jb8223.lectures.oop;

import ameedf.jb8223.lectures.oop.entities.Store;

public class StoreApplication {

    public static void main(String[] args) {
        Store store = new Store(5);
        add(store, "Tomatoes", 10.5f);
        add(store, "Apples", 6.5f);
        add(store, "Meat", 165.59f);
        add(store, "Coke", 11.9f);

        System.out.println("Before update");
        System.out.println(store.storeRepresentation());

        add(store, "Milk", 2.23f);
        add(store, "Ice cream", 20.41f);

        store.updatePrices(10);
        System.out.println("After update");
        System.out.println(store.storeRepresentation());

        store.removeProduct("Meat");
        System.out.println("Removed the Meat product");
        System.out.println(store.storeRepresentation());

        System.out.println(store.priceOf("Milk"));
        System.out.println(store.priceOf("Ice cream"));
    }

    private static void add(Store store, String productName, float price) {
        if (store.addProduct(productName, price)) {
            System.out.println("Added '" + productName + "' to the store.. There are now " + (store.getProductsNumber()) + " products");
        } else {
            System.out.println("Can't add '" + productName + "' !!");
        }
    }
}
