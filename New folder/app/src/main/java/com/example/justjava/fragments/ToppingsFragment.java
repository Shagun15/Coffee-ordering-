package com.example.justjava.fragments;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.justjava.OrderHistory;
import com.example.justjava.R;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class ToppingsFragment extends Fragment {

    SharedPreferences sharedPreferences;
    float Quantity = 2;

    float price=0;

    EditText nameField;
    String name;

    ImageView btn_logout;
    Button placeOrder;
    TextView drinkChosen;

    CheckBox WhippedCreamCheckBox;
    CheckBox ChocolateCheckBox;

    boolean hasWhippedCream;
    boolean hasChocolate;

    float extraPrice=0;
    String drinkname;
//
//    private FirebaseUser firebaseUser;
//    private DatabaseReference ref;
//
//    List<OrderHistory> historyList;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_toppings, container, false);
        placeOrder=view.findViewById(R.id.placeOrder);
        nameField= (EditText) view.findViewById(R.id.editName);
        drinkChosen=view.findViewById(R.id.drinkChosen);
        WhippedCreamCheckBox= view.findViewById(R.id.Whipped_cream_checkbox);
        ChocolateCheckBox= view.findViewById(R.id.chocolate_checkbox);
//        firebaseUser=FirebaseAuth.getInstance().getCurrentUser();
//        historyList=new ArrayList<OrderHistory>();



        sharedPreferences=getActivity().getSharedPreferences("Order", Context.MODE_PRIVATE);
        price=sharedPreferences.getFloat("orderPrice",0);
        drinkname=sharedPreferences.getString("orderName","null");
        Quantity=sharedPreferences.getFloat("Quant",0);

        drinkChosen.setText("you chose : "+drinkname);

        System.out.println("price1"+price);
//        final String userId=firebaseUser.getUid();



//
        placeOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                name=nameField.getText().toString();
//
//                System.out.println("price4"+price);
//
//
//
//
//
//                ref= FirebaseDatabase.getInstance().getReference().child("Users").child(userId).child("orders");
//
//                ref.addValueEventListener(new ValueEventListener() {
//                    @Override
//                    public void onDataChange(@NonNull DataSnapshot snapshot) {
//                        OrderHistory orderHist=snapshot.getValue(OrderHistory.class);
//                        orderHist.setName(drinkname);
//                        orderHist.setPrice(price);
//
//                        if(WhippedCreamCheckBox.isChecked()==true){
//
//                            orderHist.setTopping1Name(" with WhippedCream");
//                            orderHist.setTopping1Price(2);
//
//                        }
//                        else {
//
//                            orderHist.setTopping1Name(" without WhippedCream");
//                            orderHist.setTopping1Price(0);
//
//                        }
//
//                        if(ChocolateCheckBox.isChecked()==true){
//
//                            orderHist.setTopping1Name(" with Chocolate");
//                            orderHist.setTopping1Price(4);
//
//                        }
//                        else {
//
//                            orderHist.setTopping1Name(" without Chocolate");
//                            orderHist.setTopping1Price(0);
//
//                        }
//
//                        historyList.add(orderHist);
//
//                        for(int i=0;i<historyList.size();i++){
//                            System.out.println("histList"+historyList.get(i));
//                        }
//
//
//                        ref.setValue(orderHist);
//
//
//
//
//
//
//
//                    }
//
//                    @Override
//                    public void onCancelled(@NonNull DatabaseError error) {
//
//                    }
//                });

                if(WhippedCreamCheckBox.isChecked()==true) {
                price=price+2;
                    hasWhippedCream=true;
                }

                if(ChocolateCheckBox.isChecked()==true) {
                    price=price+4;
                    hasChocolate=true;
                }



                String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);

                System.out.println("pricemesg"+priceMessage);

                Intent intent = new Intent(Intent.ACTION_SENDTO);
                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
                intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
                intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
                if (intent.resolveActivity(getActivity().getPackageManager()) != null) {
                    startActivity(intent);
                }


            }
        });

        return view;
    }

    private String createOrderSummary(String name, float price, boolean addWhippedCream, boolean addChocolate) {
        String priceMessage = getString(R.string.order_summary_name,name);
        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
        priceMessage += "\nAdd Chocolate Topping? " + addChocolate;
        priceMessage += "\nQuantity:" + Quantity;
        priceMessage += "\nTotal: $" + ( price) + "\n "+ getString(R.string.Thank_you);
        return priceMessage;
    }
}