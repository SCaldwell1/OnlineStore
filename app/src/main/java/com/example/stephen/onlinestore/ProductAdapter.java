package com.example.stephen.onlinestore;

import java.util.List;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;



class ProductAdapter extends BaseAdapter {

    private List<Product> mProductList;
    private LayoutInflater mInflater;
    private boolean mShowQuantity;
    public ProductAdapter(List<Product> list, LayoutInflater layoutInflater, boolean b) {
        mProductList = list;
        mInflater = layoutInflater;
        mShowQuantity = b;
    }

    @Override
    public int getCount() {
        return mProductList.size();
    }

    @Override
    public Object getItem(int i) {
        return mProductList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        final ViewItem item;

        if(view == null){
            view = mInflater.inflate(R.layout.item, null);
            item = new ViewItem();
            item.productImageView = (ImageView) view.findViewById(R.id.ImageViewItem);
            item.productTitle = (TextView) view.findViewById(R.id.TextViewItem);
            item.productQuantity = (TextView) view.findViewById(R.id.textViewQuantity);
            view.setTag(item);
        }else{
            item = (ViewItem) view.getTag();
        }

        Product p = mProductList.get(i);
        item.productImageView.setImageDrawable(p.productImage);
        item.productTitle.setText(p.title);

        if(mShowQuantity){
            item.productQuantity.setText("Quantity: " + ProductHelper.getProductQuantity(p));
        }else{
            item.productQuantity.setVisibility(View.GONE);
        }

        return view;
    }

    private class ViewItem {
        ImageView productImageView;
        TextView productTitle;
        TextView productQuantity;
    }
}
