package com.example.stephen.onlinestore;


public class ShoppingCartEntry {
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
