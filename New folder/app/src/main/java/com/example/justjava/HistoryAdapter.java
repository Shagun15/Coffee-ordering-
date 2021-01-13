package com.example.justjava;

import android.content.Context;
import android.content.SharedPreferences;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;


public class HistoryAdapter extends RecyclerView.Adapter<HistoryAdapter.ViewHolder> {

    private Context context;
    private List<OrderHistory> list;
//    SharedPreferences sharedPreferences;



    public  HistoryAdapter(Context context, List<OrderHistory> list){
        this.context=context;
        this.list=list;


    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.single_item_history,parent,false);
        return new HistoryAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

//        sharedPreferences=context.getSharedPreferences("Order",Context.MODE_PRIVATE);


//        final boolean isChecked =false;

        final OrderHistory drinks=list.get(position);





    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView nameDrink, priceDrink,topping1Name,topping1price,topping2Name,topping2price;


        public ViewHolder(View itemView){
            super(itemView);

            nameDrink=itemView.findViewById(R.id.nameDrink);
            priceDrink=itemView.findViewById(R.id.priceDrink);
            topping1Name=itemView.findViewById(R.id.topping1Name);
            topping1price=itemView.findViewById(R.id.topping1price);
            topping2Name=itemView.findViewById(R.id.topping2Name);
            topping2price=itemView.findViewById(R.id.topping2price);


        }
    }


}

