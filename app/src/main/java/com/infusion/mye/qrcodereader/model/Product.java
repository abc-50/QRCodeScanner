package com.infusion.mye.qrcodereader.model;

import java.io.Serializable;
import java.net.URL;
import java.util.UUID;

/**
 * Created by mye on 2016-01-22.
 */
public class Product implements IProduct, Serializable {
    final private UUID uuid;
    private String name;
    private double price;
    private String productImgUrl;

    public Product(String name, double price, String productImgUrl) {
        this.uuid = UUID.randomUUID();
        this.name = name;
        this.price=price;
        this.productImgUrl=productImgUrl;
    }

    @Override
    public UUID getId() {
        return uuid;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void setName(String name) {
        this.name=name;
    }

    @Override
    public double getPrice() {
        return price;
    }

    @Override
    public void setPrice(double price) {
        this.price=price;
    }

    @Override
    public String getProductImgUrl() {
        return productImgUrl;
    }

    @Override
    public void setProductImgUrl(String productImgUrl) {
        this.productImgUrl=productImgUrl;
    }

}
