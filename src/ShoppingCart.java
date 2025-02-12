import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCart {
    private List<Item> listOfItems = new ArrayList<>();

    public List<Item> getListOfItems() {
        return new ArrayList<>(listOfItems);
    }

    public void setListOfItems(List<Item> listOfItems) {
        this.listOfItems = listOfItems;
    }

    public void addList(List<Item> list) {
        listOfItems.addAll(list);
    }

    public void removeItem(Item item) {
        listOfItems.remove(item);
    }

    public void addItem(Item item) { listOfItems.add(item);}


    public BigDecimal getPriceOfItem() {
        BigDecimal price = BigDecimal.ZERO;
        for (Item item : listOfItems) {
            price = item.getPrice();
        }
        return price;
    }

    public List<Item> priceOverN(BigDecimal price) {
        List<Item> listOverPriceN = new ArrayList<>();
        for (Item item : listOfItems) {
            if (item.getPrice().compareTo(price) > 0) {
                listOverPriceN.add(item);
            }
        }
        return listOverPriceN;
    }

    public BigDecimal getTotalPrice() {
        BigDecimal totalPrice = BigDecimal.ZERO;
        for (Item item : listOfItems) {
            totalPrice = totalPrice.add(item.getPriceTimesQuant());
        }
        return totalPrice;
    }
    public int getNumberOfItemsInCart() {
        return listOfItems.size();
    }
    public BigDecimal getAveragePrice() throws ShoppingCartException {
        if (listOfItems.isEmpty()) {
            throw new ShoppingCartException("Neze počítat průměrnou cenu u prázdného košíku.");
        }
        return getTotalPrice().divide(BigDecimal.valueOf(getNumberOfItemsInCart()), RoundingMode.HALF_UP);
    }

    }

//    public BigDecimal getAveragePrice() throws ShoppingCartException {
//        if (items.isEmpty()) {
//            throw new ShoppingCartException("Nelze počítat průměrnou cenu u prázdného košíku!");
//        }
//        return getTotalPrice().divide(BigDecimal.valueOf(getItemCount()), RoundingMode.HALF_UP);
//    }
//}

