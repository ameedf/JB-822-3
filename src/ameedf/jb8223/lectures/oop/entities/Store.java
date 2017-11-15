package ameedf.jb8223.lectures.oop.entities;

public class Store {
    private Product[] products;

    public Store(int maximumProducts) {
        this.products = new Product[maximumProducts];
    }

    /**
     * Add a product to the store
     * @param productName the product name
     * @param price the product price
     * @return true if and only if the product was added to the store
     */
    public boolean addProduct(String productName, float price) {
        int index = nextIndex();
        if (index >= 0) {
            Product newProduct = new Product((index + 1) * 10, productName, price);
            this.products[index] = newProduct;
            return true;
        }
        return false;
    }

    /**
     * Remove a product from the store
     * @param productName the name of the product that should be removed
     * @return true if and only if a product with the same name exists
     */
    public boolean removeProduct(String productName) {
        int index = indexOf(productName);
        if (index != -1) {
            this.products[index] = null;
            return true;
        }
        return false;
    }

    /**
     * Updates the prices of all the products in the store
     * @param percent the percent for updating the store prices
     */
    public void updatePrices(float percent) {
        for (Product product : this.products) {
            if (product != null) {
                product.updatePrice(percent);
            }
        }
    }

    /**
     * Check the price of a product
     * @param productName the name of the product to be checked
     * @return the price of the product or "0" if the product doesn't exist
     */
    public float priceOf(String productName) {
        int index = indexOf(productName);
        return index == -1 ? 0 : this.products[index].getPrice();
    }

    /**
     * The String representation of the store
     * @return a String that represents the status of all the products in the store
     */
    public String storeRepresentation() {
        String storeStringRepresentation = "-------------- Store status -----------------------\n";
        int numberOfProducts = getProductsNumber();
        if (numberOfProducts == this.products.length) {
            storeStringRepresentation += "The store is full !!";
        } else {
            storeStringRepresentation += "There are " + numberOfProducts + " products in the store";
        }

        for (Product product : this.products) {
            if (product != null) {
                storeStringRepresentation += "\n" + product.productRepresentation();
            }
        }
        return storeStringRepresentation + "\n";
    }

    /**
     * @return the number of products in the store
     */
    public int getProductsNumber() {
        int count = 0;
        for (Product product : products) {
            if (product != null) {
                count++;
            }
        }
        return count;
    }

    private int indexOf(String productName) {
        for (int i = 0; i < this.products.length; i++) {
            Product product = this.products[i];
            if (product != null){
                String currentProductName = product.getName();
                if (currentProductName.equals(productName)) {
                    return i;
                }
            }
        }
        return -1;
    }

    /**
     * @return the next available index in the products array or -1 if the array is full
     */
    private int nextIndex() {
        for (int i = 0; i < this.products.length; i++) {
            if (products[i] == null) {
                return i;
            }
        }
        return -1; // no place available
    }
}
