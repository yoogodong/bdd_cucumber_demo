package features.shoppingcart;

import java.util.ArrayList;
import java.util.List;

public class Cart {


    List<Item> itemList = new ArrayList<Item>();
    private int originalQuatity;


    public void add(Product product) {
        add(product,1);
    }

    public boolean contains(Product product) {
        return getItem(product) != null;
    }


    public Item getItem(Product product) {
        for (Item item : itemList) {
            if (item.product().equals(product))
                return item;
        }
        return null;
    }


    public Item getItem8(Product product) {
        final Item item = itemList.stream().filter(it -> it.product().equals(product)).findFirst().get();
        return item;
    }

    public int totalPrice() {
        int totalPrice = 0;
        for (Item item : itemList) {
            totalPrice += item.price();
        }
        return totalPrice;
    }

    public void add(Product product, int addedQuantity) {
        final Item item = this.getItem(product);
        if (item !=null){
            originalQuatity = item.quality();
            item.quality(originalQuatity + addedQuantity);
        }else {
           itemList.add(new Item(product,addedQuantity));
        }
    }
}
