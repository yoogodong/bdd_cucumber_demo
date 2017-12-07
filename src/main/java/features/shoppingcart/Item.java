package features.shoppingcart;

public class Item {

    private final Product product;
    private int quality;

    public Item(Product product) {
        this.product = product;
        this.quality = 1;
    }

    public Item(Product product, int quantity) {
        this.product = product;
        this.quality = quantity;
    }

    public int quality() {
        return quality;
    }

    public Product product() {
        return product;
    }


    public int price() {
        return product.price()*quality();
    }

    public void increase() {
        quality++;
    }


    public void add(int quantity) {
        this.quality+=quantity;
    }

    public void quality(int quality) {
        this.quality = quality;
    }
}
