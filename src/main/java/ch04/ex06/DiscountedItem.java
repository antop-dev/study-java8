package ch04.ex06;

import java.util.Objects;

public class DiscountedItem extends Item {
    private double discount;

    public DiscountedItem(String description, double price, double discount) {
        super(description, price);
        this.discount = discount;
    }

    public boolean equals(Object otherObject) {
        if (otherObject instanceof DiscountedItem) {
            DiscountedItem other = (DiscountedItem) otherObject;
            return discount == other.discount;
        }
        return super.equals(otherObject);
    }
    
    public int hashCode() {
        return Objects.hash(super.hashCode(), discount);
    }
}