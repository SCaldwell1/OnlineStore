package com.example.stephen.onlinestore;

import android.content.res.Resources;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;


class ProductHelper {
    public static final String PRODUCT_INDEX = "INDEX";

    private static List<Product> list;
    private static Map<Product, ShoppingCartEntry> map = new HashMap<Product, ShoppingCartEntry>();

    public static List<Product> getCatalog(Resources resources) {
        if (list==null){
            list = new Vector<Product>();
            list.add(new Product("The Witcher 3", resources.getDrawable(R.drawable.witcher3), "Description", 49.99));
            list.add(new Product("FIFA 17", resources.getDrawable(R.drawable.fifa17), "Description", 49.99));
        }

        return list;
    }

    public static void setProductQuantity(Product p, int q){
        ShoppingCartEntry sce = map.get(p); //current cart entry

        //if quantity = 0 remove products
        if(q <= 0 ){
            if (sce != null)
                removeProduct(p);
            return;
        }

        //if cart entry doesn't exist this creates an entry
        if(sce == null){
            sce = new ShoppingCartEntry(p,q);
            map.put(p, sce);
            return;
        }

        //Update the quantity
        sce.setQuantity(q);
    }

    public static int getProductQuantity(Product p) {
        ShoppingCartEntry e = map.get(p);
        if(e != null)
            return e.getQuantity();
        return 0;
    }

    public static void removeProduct(Product product) {
        map.remove(product);
    }

    public static List<Product> getCartList(){
        List<Product> cartList = new Vector<Product>(map.keySet().size());
        for(Product p : map.keySet()){
            cartList.add(p);
        }
        return cartList;
    }
}
