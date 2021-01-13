package com.example.justjava;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.justjava.fragments.HistoryFragment;
import com.example.justjava.fragments.OrdersFragment;
import com.example.justjava.fragments.ToppingsFragment;

import java.util.List;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {

    private Context context;
    private List<Drinks> list;
    SharedPreferences sharedPreferences;
     float number=2;


    public  DrinksAdapter(Context context, List<Drinks> list){
        this.context=context;
        this.list=list;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_item_drinks,parent,false);
        return new DrinksAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        sharedPreferences=context.getSharedPreferences("Order",Context.MODE_PRIVATE);


//        final boolean isChecked =false;

        final Drinks drinks=list.get(position);
        holder.drinksNAme.setText(drinks.getName());
        holder.drinksPrice.setText("$"+String.valueOf(drinks.getPrice()));


        holder.icreament.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number++;

                if(number==100){
                    Toast.makeText(context, "You cannot have more than 100 coffee", Toast.LENGTH_SHORT).show();
                }


                displayQuantity(number,holder);



            }
        });

        holder.decrement.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                number--;

                if(number==1){
                   Toast.makeText(context, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
                }

                displayQuantity(number,holder);




            }
        });

        holder.llDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                sharedPreferences.edit().putFloat("orderPrice",drinks.price*number).apply();
                sharedPreferences.edit().putString("orderName",drinks.name).apply();
                sharedPreferences.edit().putFloat("Quant",number).apply();

                AppCompatActivity activity = (AppCompatActivity) v.getContext();



                 activity.getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ToppingsFragment())
                        .commit();

//                Intent intent = new Intent(context, MainActivity.class);
//                context.startActivity(intent);







//                if(isChecked) {
//
//                    holder.checkDrink.setChecked(true);
//                }else{
//                    holder.checkDrink.setChecked(true);
//                }


            }
        });

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView drinksNAme, drinksPrice;
        public LinearLayout llDrinks;
        Button icreament;
        Button decrement;
        TextView quantity_text_view;
//        public CheckBox checkDrink;

        public ViewHolder(View itemView){
            super(itemView);

            drinksNAme=itemView.findViewById(R.id.drink_name);
            drinksPrice=itemView.findViewById(R.id.drink_price);
            llDrinks=itemView.findViewById(R.id.llDrinks);
            icreament=itemView.findViewById(R.id.icreament);
            decrement=itemView.findViewById(R.id.decrement);
            quantity_text_view=itemView.findViewById(R.id.quantity_text_view);
//            checkDrink=itemView.findViewById(R.id.checkDrink);

        }
    }

    void displayQuantity(float number, ViewHolder holder){

        holder.quantity_text_view.setText(" "+ number);


    }


}
