package com.example.justjava.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.justjava.HistoryAdapter;
import com.example.justjava.OrderHistory;
import com.example.justjava.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
import java.util.List;


public class HistoryFragment extends Fragment {

    RecyclerView recyclerHistory;
    HistoryAdapter adapter;
    LinearLayoutManager layoutManager;
    List<OrderHistory> list;

    private DatabaseReference ref;
    String userId;
    FirebaseUser firebaseUser;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_history, container, false);
        list=new ArrayList<>();

        firebaseUser= FirebaseAuth.getInstance().getCurrentUser();
        recyclerHistory=view.findViewById(R.id.recyclerHistory);
        layoutManager=new LinearLayoutManager(getActivity());

        userId=firebaseUser.getUid();


        ref= FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("orders");


        return view;
    }
}