package com.example.registation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.BaseAdapter;
import android.widget.TextView;

public class ShopActivity extends AppCompatActivity  implements View.OnClickListener{

    private ListView mListView;
    private Button return_btn;
    //set array to save product names and prices
    private String[]products = {"Apple", "Table", "Cake","Sweater","Kiwi", "Scarf", "Playstation 5","Iphone 14 Pro Max","4K Gaming Monitor",
            "Gaming PC", "Karma Akabane Poster", "Kuro Sensei Poster", "One Piece Poster"};
    private String[]prices= {"4 RMB/KG", "1799.99 RMB", "49.99 RMB","349.99 RMB","4 MB/KG", "149.99 RMB", "3999.99 RMB",
            "5999.99 RMB", "999.99 RMB", "3499.99 RMB", "9.99 RMB","29.99 RMB", "49.99 RMB"};

    //set array to save pictures
    private int[] icons = {R.drawable.apple,R.drawable.table,R.drawable.cake,
            R.drawable.sweater,R.drawable.kiwi,R.drawable.scarf, R.drawable.ps5,R.drawable.iphone_14,
            R.drawable.gaming_monitor,R.drawable.gaming_pc,R.drawable.karma, R.drawable.kuro_sensei, R.drawable.one_piece};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        return_btn = findViewById(R.id.return_btn);
        return_btn.setOnClickListener(this);
        mListView = findViewById(R.id.lv);
        MyBaseAdapter mAdapter = new MyBaseAdapter();// create Adapter
        mListView.setAdapter(mAdapter);// set Adapter

    }

    @Override
    public void onClick(View v) {
        Intent intent = new Intent();
        ShopActivity.this.finish();
    }


    public class MyBaseAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return prices.length; //Returns the total number of list objects
        }

        @Override
        public Object getItem(int position) {
            return prices[position]; // Return item's data object
        }

        @Override
        public long getItemId(int position) {
            return position; //Return item's id
        }

/*       @Override
//        public View getView(int position, View convertView, ViewGroup parent) {
//          View view = View.inflate(MainActivity.this,R.layout.list_item, null);
//            TextView product = view.findViewById(R.id.pName);
//            TextView price = view.findViewById(R.id.price);
//            ImageView iv = view.findViewById(R.id.pImage);
//
//            product.setText(products[position]);
//            price.setText(prices[position]);
//            iv.setBackgroundResource(icons[position]);
//            return view;
//
//        }*/

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder = null;
            if (convertView == null) {
                //Find list_item.xml and convert into View
                convertView = View.inflate(ShopActivity.this, R.layout.list_item_shop, null);

                holder = new ViewHolder();
                holder.product = convertView.findViewById(R.id.pName);
                holder.price = convertView.findViewById(R.id.price);
                holder.iv = convertView.findViewById(R.id.pImage);
                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }
            holder.product.setText(products[position]);
            holder.price.setText(prices[position]);
            holder.iv.setBackgroundResource(icons[position]);
            return convertView;
        }

        class ViewHolder {
            TextView product, price;
            ImageView iv;
        }
    }
}

