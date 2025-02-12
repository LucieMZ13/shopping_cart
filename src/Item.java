import java.math.BigDecimal;
import java.time.LocalDate;

public class Item {
    private String description;
    private BigDecimal price;
    private LocalDate reservationTime;
    private boolean isInStock;
    private int quantity;
    private Category category;

    public Item(String description, BigDecimal price, LocalDate reservationTime, boolean isInStock, int quantity, Category category) {
        this.description = description;
        setPrice(price);
        this.reservationTime = reservationTime;
        this.isInStock = isInStock;
        this.quantity = quantity;
        this.category = category;
    }

    public Item(String description, BigDecimal price) {
        this.description = description;
        this.price = price;
        this.reservationTime = LocalDate.now();
        this.isInStock = true;
        this.quantity = 1;
        this.category = Category.food;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        if (price.compareTo(BigDecimal.ZERO) < 0) {
            throw new IllegalArgumentException("Cena nesmí být záporná.");
        }
        this.price = price;
    }

    public LocalDate getReservationTime() {
        return reservationTime;
    }

    public void setReservationTime(LocalDate reservationTime) {
        this.reservationTime = reservationTime;
    }

    public boolean isInStock() {
        return isInStock;
    }

    public void setInStock(boolean inStock) {
        isInStock = inStock;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public BigDecimal getPriceTimesQuant() {
        return getPrice().multiply(BigDecimal.valueOf(getQuantity()));
    }
}


//
//Popis položky — co se nakupovalo (description)
//Částku za nákup (price)
//Datum a čas nákupu (reservationTime) … výchozí hodnota je aktuální okamžik
//        Informaci, jestli
//je zboží skladem (isOnStock) … výchozí hodnota je ano
//Počet kusů (quantity) … výchozí hodnota je 1