package com.infusion.mye.qrcodereader.model;

import com.infusion.mye.qrcodereader.model.Product;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mye on 2016-01-23.
 */
public class TestProducts {

    public static List<Product> getTestProducts() {
        Product shirt = new Product("Shirt", 20, "http://bit.ly/1SE0B7l");
        Product pants = new Product("Pant", 50, "http://bit.ly/1OO5LrA");
        Product cup = new Product("Ceramic mug", 10, "http://bit.ly/1NrRHSB");
        List<Product> productsList = new ArrayList<Product>();
        productsList.add(shirt);
        productsList.add(pants);
        productsList.add(cup);
        return productsList;
    }
}
