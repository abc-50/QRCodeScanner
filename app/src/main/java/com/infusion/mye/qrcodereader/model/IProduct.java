package com.infusion.mye.qrcodereader.model;

import java.net.URL;
import java.util.UUID;

/**
 * Created by mye on 2016-01-22.
 */
public interface IProduct {
    UUID getId();
    String getName();
    void setName(String name);
    double getPrice();
    void setPrice(double price);
    String getProductImgUrl();
    void setProductImgUrl(String productImgUrl);

}
