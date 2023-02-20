package com.example.myloginapplication.screen;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.myloginapplication.Item;

import com.example.myloginapplication.ItemClickListener;
import com.example.myloginapplication.MyAdapter;
import com.example.myloginapplication.R;
import com.example.myloginapplication.product_detail;

import java.util.ArrayList;
import java.util.List;


public class CategoriesFragment extends Fragment implements ItemClickListener {

    List<Item> items = new ArrayList<Item>();

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_categories, container, false);
        RecyclerView recyclerView = rootView.findViewById(R.id.recycleview);

        items.add(new Item("1", "Store", R.drawable.img_1));
        items.add(new Item("2", "Pharmacy", R.drawable.img_2));
        items.add(new Item("3", "Pharmacy", R.drawable.img_3));
        items.add(new Item("4", "Clothing", R.drawable.img_4));
        items.add(new Item("5", "Shoe", R.drawable.img_5));
        items.add(new Item("6", "Home", R.drawable.img_6));
        items.add(new Item("7", "Baby", R.drawable.img_7));
        items.add(new Item("8", "Grow", R.drawable.img_8));
        items.add(new Item("9", "Store", R.drawable.img_1));
        items.add(new Item("10", "Pharmacy", R.drawable.img_2));
        items.add(new Item("11", "Pharmacy", R.drawable.img_3));
        items.add(new Item("12", "Clothing", R.drawable.img_4));
        items.add(new Item("13", "Shoe", R.drawable.img_5));
        items.add(new Item("14", "Home", R.drawable.img_6));
        items.add(new Item("15", "Baby", R.drawable.img_7));
        items.add(new Item("16", "Grow", R.drawable.img_8));


        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));
        recyclerView.setAdapter(new MyAdapter(getContext(), items, this));


        return rootView;
    }

    @Override
    public void onItemClick(int position) {
        Intent i = new Intent(getContext(), product_detail.class);
        i.putExtra("id", items.get(position).getId());
        i.putExtra("name", items.get(position).getName());
        i.putExtra("image", items.get(position).getImage());
        startActivity(i);
    }
}