package com.example.justjava.fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.justjava.MainActivity;
import com.example.justjava.R;
import com.example.justjava.UserDetails;
import com.example.justjava.WelcomeActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class ProfileFragment extends Fragment {

    TextView Name,Email;
    LinearLayout signOut;
    FirebaseAuth auth;
    private DatabaseReference ref;
    String userId;
    FirebaseUser firebaseUser;






    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_profile, container, false);
        auth=FirebaseAuth.getInstance();
        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
        userId=firebaseUser.getUid();

        Name=view.findViewById(R.id.Name);
        Email=view.findViewById(R.id.Email);
        signOut=view.findViewById(R.id.SignOut);


        signOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                auth.signOut();
                Intent intent=new Intent(getActivity(), WelcomeActivity.class);
                startActivity(intent);
                getActivity().finish();

            }
        });

//        auth.signOut();
//        Intent intent=new Intent(getActivity(), WelcomeActivity.class);
//        startActivity(intent);
//        getActivity().finish();



        ref= FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

        ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                UserDetails user=snapshot.getValue(UserDetails.class);
                Name.setText(user.getName());
                Email.setText(user.getEmail());


            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });






        return  view;
    }
}