package com.booleanuk.extension;

import com.booleanuk.core.Basket;
import com.booleanuk.core.Inventory;
import com.booleanuk.core.Item;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ExtensionTests {

    public Item BGLP;
    public Item BGLO;
    public Item BGLE;
    public Item COFB;
    public Item COF;
    public Item BGLS;
    public Item COFW;
    public Item COFC;
    public Item COFL;
    public Item FILB;
    public Item FILE;
    public Item FILC;
    public Item FILX;
    public Item FILS;
    public Item FILH;
    public Basket basket;
    private Inventory inventory;

    private Extension.ExtendedBasket ExtendedBasket;

    @BeforeEach
    void setUp() {

        BGLP = new Item("BGLP", 0.49);
        BGLO = new Item("BGLO", 0.49);
        BGLE = new Item("BGLE", 0.49);
        COFB = new Item("COFB", 1.25);
        COF = new Item("COF", 0.99);
        BGLS = new Item("BGLS", 0.49);
        COFW = new Item("COFW", 1.19);
        COFC = new Item("COFC", 1.29);
        COFL = new Item("COFL", 1.29);
        FILB = new Item("FILB", 0.12);
        FILE = new Item("FILE", 0.12);
        FILC = new Item("FILC", 0.12);
        FILX = new Item("FILX", 0.12);
        FILS = new Item("FILS", 0.12);
        FILH = new Item("FILH", 0.12);

        ExtendedBasket = new Extension.ExtendedBasket(30);

        basket = new Basket(30);

        inventory = new Inventory();
        inventory.add(BGLP, 20);
        inventory.add(BGLO, 20);
        inventory.add(BGLE, 20);
        inventory.add(COF, 20);
    }

    @Test
    void Story11SetDiscountAndOrderBySKUCalculateDiscount() {

        ExtendedBasket.setDiscount(BGLO, 6, 2.49);
        ExtendedBasket.setDiscount(BGLP, 12, 3.99);
        ExtendedBasket.setDiscount(BGLE, 6, 2.49);

        ExtendedBasket.add(BGLP, 12, inventory);
        assertEquals(3.99, ExtendedBasket.getTotalPrice());

        ExtendedBasket.add(BGLO, 2, inventory);
        ExtendedBasket.add(BGLE, 6, inventory);
        ExtendedBasket.add(COF, 3, inventory);

        assertEquals(10.43, ExtendedBasket.getTotalPrice());

    }

    @Test
    void Story12CreateReceipt() {

        ExtendedBasket.setDiscount(BGLO, 6, 2.49);
        ExtendedBasket.setDiscount(BGLP, 12, 3.99);
        ExtendedBasket.setDiscount(BGLE, 6, 2.49);

        ExtendedBasket.add(BGLP, 12, inventory);
        assertEquals(3.99, ExtendedBasket.getTotalPrice());

        ExtendedBasket.add(BGLO, 2, inventory);
        ExtendedBasket.add(BGLE, 6, inventory);
        ExtendedBasket.add(COF, 3, inventory);

        assertEquals(10.43, ExtendedBasket.getTotalPrice());

        ExtendedBasket.printReceipt(ExtendedBasket);


    }

    @Test
    void Story13CreateReceiptwithDiscount() {

        ExtendedBasket.setDiscount(BGLO, 6, 2.49);
        ExtendedBasket.setDiscount(BGLP, 12, 3.99);
        ExtendedBasket.setDiscount(BGLE, 6, 2.49);

        ExtendedBasket.add(BGLP, 12, inventory);
        assertEquals(3.99, ExtendedBasket.getTotalPrice());

        ExtendedBasket.add(BGLO, 2, inventory);
        ExtendedBasket.add(BGLE, 6, inventory);
        ExtendedBasket.add(COF, 3, inventory);

        assertEquals(10.43, ExtendedBasket.getTotalPrice());

        ExtendedBasket.printReceiptDiscount(ExtendedBasket);

    }
}

