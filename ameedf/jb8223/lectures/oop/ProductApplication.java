package ameedf.jb8223.lectures.oop;

import ameedf.jb8223.lectures.oop.entities.Product;

public class ProductApplication {
    public static void main(String[] args) {
        System.out.println("Adding tomatoes");
        Product tomatoes = new Product(1, "Tomatoes", 3.2f);
        System.out.println("Before update");
        tomatoes.productRepresentation();
        tomatoes.updatePrice(10.0f);
        System.out.println("After update");
        tomatoes.productRepresentation();
        System.out.println("----------------------");

        System.out.println("Adding apples");
        Product apples = new Product("Apples", 8.9f);
        System.out.println("Before update");
        apples.productRepresentation();
        apples.updatePrice(-20.0f);
        System.out.println("After update");
        apples.productRepresentation();
        System.out.println("----------------------");

        System.out.println("Adding wine");
        Product wine = new Product( "BadName", 81.7f);
        System.out.println("Before update");
        wine.productRepresentation();
        wine.updatePrice(-120.0f);
        wine.setName("Wine");
        System.out.println("After update");
        wine.productRepresentation();
        System.out.println("----------------------");

    }
}
