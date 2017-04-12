package com.example.stephen.onlinestore;

/**
 * Created by Stephen on 12/04/2017.
 */

class ShoppingCartEntry {
    private Product mProduct;
    private int mQuantity;
    public ShoppingCartEntry(Product p, int q) {
        mProduct = p;
        mQuantity = q;
    }

    public void setQuantity(int productQuantity) {
       mQuantity = productQuantity;
    }

    public int getQuantity() {
        return mQuantity;
    }

    public Product getProduct() {
        return mProduct;
    }
}
