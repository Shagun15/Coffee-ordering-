package com.example.justjava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.justjava.Drinks;
import com.example.justjava.DrinksAdapter;
import com.example.justjava.R;

import java.util.ArrayList;
import java.util.List;


public class OrdersFragment extends Fragment {

    RecyclerView recycler;
    LinearLayoutManager layoutManager;
    DrinksAdapter adapter;
    List<Drinks> drinks=new ArrayList<>();


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_orders, container, false);

        recycler=view.findViewById(R.id.recyclerDrinks);
        layoutManager= new LinearLayoutManager(getActivity());
        drinks.add(new Drinks("Espresso",1));
        drinks.add(new Drinks("Americano",5));
        drinks.add(new Drinks("Macchiato",7));
        drinks.add(new Drinks("Flat White",9));
        drinks.add(new Drinks("Caffe Latte",7));
        drinks.add(new Drinks("con Panna",10));
        drinks.add(new Drinks("Caffe Breve",13));
        drinks.add(new Drinks("Cappuccino",4));
        drinks.add(new Drinks("Cafe mocha",6));
        drinks.add(new Drinks("Tea in stock",1));

        adapter=new DrinksAdapter(getActivity(),drinks);



        recycler.setAdapter(adapter);
        recycler.setLayoutManager(layoutManager);

        return view;
    }
}