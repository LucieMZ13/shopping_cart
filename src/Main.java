import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Item item1 = new Item("Koblih s marmeládou",
                BigDecimal.valueOf(14.90), LocalDate.now(),true,
                3,Category.food);
        Item item2 = new Item("Tekuté mýdlo (250 ml)",
                BigDecimal.valueOf(95.0),LocalDate.now(),true,
                8,Category.consumables);
        try {
            Item item = new Item("Minus",BigDecimal.valueOf(-12.5));
            System.out.println(item.getPrice());
        }
        catch (IllegalArgumentException e) {
            System.err.println(e.getMessage());
//              nebo pokud chci, aby program po chybové hlášce pokračoval:
//            e.printStackTrace();
        }
        
    ShoppingCart shoppingCart1 = new ShoppingCart();
    shoppingCart1.addItem(item1);
    shoppingCart1.addItem(item2);
    shoppingCart1.addItem(new Item("Běžecké boty",BigDecimal.valueOf(1599)));

        try {
            System.out.println("Průměrná cena všech položek v košíku je: " + shoppingCart1.getAveragePrice() + " Kč");
        } catch (ShoppingCartException e) {
            System.err.println("Chyba při výpočtu průměru: "+e.getLocalizedMessage());;
        }

        System.out.println(shoppingCart1.getNumberOfItemsInCart());
        System.out.println(shoppingCart1.getTotalPrice());
        List<Item> itemsOver50 = shoppingCart1.priceOverN(BigDecimal.valueOf(50));
        itemsOver50.forEach(item -> System.out.println(item.getDescription()));
        shoppingCart1.getListOfItems().forEach(item -> System.out.println
                (item.getDescription()+" ("+item.getQuantity()+" ks, "+
                        item.getPrice()+"Kč)"));
    }
}