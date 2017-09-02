package ch04;

import ch04.ex06.DiscountedItem;
import ch04.ex06.Item;
import org.junit.Test;

public class Ex06Test {

    @Test
    public void eq() {
        DiscountedItem x = new DiscountedItem("Item", 1000, 200);
        Item y = new Item("Item", 1000);
        DiscountedItem z = new DiscountedItem("Item", 1000, 100);

        System.out.println(x.equals(y)); // true
        System.out.println(y.equals(z)); // true
        System.out.println(x.equals(z)); // false
    }

}
