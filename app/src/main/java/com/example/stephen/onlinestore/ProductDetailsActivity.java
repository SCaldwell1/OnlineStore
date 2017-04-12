package com.example.stephen.onlinestore;

import java.util.List;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

class ProductDetailsActivity extends Activity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.productdetails);

        List<Product> catalog = ProductHelper.getCatalog(getResources());

        int productIndex = getIntent().getExtras().getInt(
                ProductHelper.PRODUCT_INDEX);
        final Product sProduct = catalog.get(productIndex);

        //set image and text
        ImageView iv = (ImageView) findViewById(R.id.ImageViewProduct);
        iv.setImageDrawable(sProduct.productImage);

        TextView tvTitle = (TextView) findViewById(R.id.TextViewProductTitle);
        tvTitle.setText(sProduct.title);

        TextView tvDesc = (TextView) findViewById(R.id.TextViewProductDetails);
        tvDesc.setText(sProduct.description);

        //update quantity in cart
        TextView tvQuantity = (TextView) findViewById(R.id.textViewCurrentlyInCart);
        tvQuantity.setText("Cart: " + ProductHelper.getProductQuantity(sProduct));

        final EditText editTextQuantity = (EditText) findViewById(R.id.editTextQuantity);

        Button addToCart = (Button) findViewById(R.id.ButtonAddToCart);
        addToCart.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View view) {
                //check t see if a valid quantity was entered
                int q = 0;
                try{
                    q = Integer.parseInt(editTextQuantity.getText().toString());

                    if(q<0){
                        Toast.makeText(getBaseContext(), "Please enter a quantity of 0 or higher", Toast.LENGTH_SHORT).show();
                        return;
                    }
                }catch (Exception e){
                    Toast.makeText(getBaseContext(), "Please enter a numeric quantity", Toast.LENGTH_SHORT).show();
                    return;
                }
                //if a valid quantity was entered
                ProductHelper.setProductQuantity(sProduct, q);

                finish();
            }
        });
    }
}
