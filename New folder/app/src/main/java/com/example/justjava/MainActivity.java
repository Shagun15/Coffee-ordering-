


/**
 * IMPORTANT: Make sure you are using the correct package name.
 * This example uses the package name:
 * package com.example.android.justjava
 * If you get an error when copying this code into Android studio, update it to match teh package name found
 * in the project's AndroidManifest.xml file.
 **/

package com.example.justjava;


import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.example.justjava.fragments.HistoryFragment;
import com.example.justjava.fragments.OrdersFragment;
import com.example.justjava.fragments.ProfileFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;


/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    private FirebaseUser firebaseUser;
    private DatabaseReference ref;
    private BottomNavigationView bottomNavigationView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        firebaseUser = FirebaseAuth.getInstance().getCurrentUser();

        bottomNavigationView = findViewById(R.id.bottom_navigation);

        openHome();


        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.ordersFrag:
                        openHome();
                        break;
//                    case R.id.historyFrag:
//                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new HistoryFragment())
//                                .commit();

//                        break;
                    case R.id.profileFrag:
                        getSupportFragmentManager().beginTransaction().replace(R.id.frame, new ProfileFragment())
                                .commit();

                        break;
                    default:
                        openHome();
                }
                return true;
            }
        });

    }

        public void openHome () {
            getSupportFragmentManager().beginTransaction().replace(R.id.frame, new OrdersFragment())
                    .commit();

        }

        @Override
        public void onBackPressed () {
            super.onBackPressed();
            finishAffinity();
        }

    }


//        placeOrder=findViewById(R.id.placeOrder);
//        nameField= (EditText) findViewById(R.id.editName);
//        drinkChosen=findViewById(R.id.drinkChosen);
//        WhippedCreamCheckBox= findViewById(R.id.Whipped_cream_checkbox);
//        ChocolateCheckBox= findViewById(R.id.chocolate_checkbox);
//
//        sharedPreferences=getSharedPreferences("Order", MODE_PRIVATE);
//        price=sharedPreferences.getFloat("orderPrice",0);
//        drinkname=sharedPreferences.getString("orderName","null");
//
//        drinkChosen.setText("you chose : "+drinkname);
//
//        System.out.println("price1"+price);
//
////        hasWhippedCream=WhippedCreamCheckBox.isChecked();
////        hasChocolate=ChocolateCheckBox.isChecked();
//
//        if(WhippedCreamCheckBox.isChecked()){
//
//            price=(Quantity*price)+1;
//            System.out.println("price2"+price);
//
//        }
//
//        if(ChocolateCheckBox.isChecked()){
//
//            price=(Quantity*price)+2;
//            System.out.println("price3"+price);
//
//        }
//
//
////        extraPrice=extraPrice(hasWhippedCream,hasChocolate);
//
//        name = nameField.getText().toString();



//        placeOrder.setText("place Order"+"$"+price);

//        placeOrder.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                System.out.println("price4"+price);
//
//
//
//                String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
//
//                Intent intent = new Intent(Intent.ACTION_SENDTO);
//                intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//                intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
//                intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//                if (intent.resolveActivity(getPackageManager()) != null) {
//                    startActivity(intent);
//                }
//
//
//            }
//        });



//        btn_logout=findViewById(R.id.btn_logout);
//
//        auth=FirebaseAuth.getInstance();
//
//        btn_logout.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                auth.signOut();
//                Intent intent=new Intent(MainActivity.this, WelcomeActivity.class);
//                startActivity(intent);
//                finish();
//
//
//            }
//        });




//    public void increment(View view) {
//        if (Quantity == 100) {
//            Toast.makeText(this, "You cannot have more than 100 coffees", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Quantity += 1;
//
////        Intent intent = new Intent(this, MainActivity.class);
////        startActivity(intent);
//
//        displayQuantity(Quantity);
//
//    }

//    public void decrement(View view) {
//        if (Quantity == 1) {
//            Toast.makeText(this, "You cannot have less than 1 coffee", Toast.LENGTH_SHORT).show();
//            return;
//        }
//        Quantity -= 1;
//
//        displayQuantity(Quantity);
//
//    }

    /**
     * This method is called when the order button is clicked.
     */
//    public void submitOrder(View view) {



//
//        CheckBox WhippedCreamCheckBox = (CheckBox) findViewById(R.id.Whipped_cream_checkbox);
//        boolean hasWhippedCream = WhippedCreamCheckBox.isChecked();
//
//        CheckBox ChocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkbox);
//        boolean hasChocolate = ChocolateCheckBox.isChecked();

//        price = calculatePrice(hasWhippedCream, hasChocolate);
//        placeOrder.setText("place Order"+"$"+price);
//        String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);


//        Intent intent = new Intent(Intent.ACTION_SENDTO);
//        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
//        intent.putExtra(Intent.EXTRA_SUBJECT, "Just Java order for " + name);
//        intent.putExtra(Intent.EXTRA_TEXT, priceMessage);
//        if (intent.resolveActivity(getPackageManager()) != null) {
//            startActivity(intent);
//        }

//    }


    /**
     * Calculates the price of the order.
     */
//    private float extraPrice(boolean addWhippedCream, boolean addChocolate) {
//
//        float basePrice = price;
//        // add $1 if the user wants whipped cream
//        if (addWhippedCream) {
//            basePrice = basePrice + 1;
//        }
//        // add $2 if the user wants chocolate
//        if (addChocolate) {
//            basePrice = basePrice + 2;
//        }
//        // calculate the total order price by multiplying by quantity
//        return Quantity * basePrice;
//
//    }

//    private String createOrderSummary(String name, float price, boolean addWhippedCream, boolean addChocolate) {
//        String priceMessage = getString(R.string.order_summary_name,name);
//        priceMessage += "\nAdd whipped cream? " + addWhippedCream;
//        priceMessage += "\nAdd Chocolate Topping? " + addChocolate;
//        priceMessage += "\nQuantity:" + Quantity;
//        priceMessage += "\nTotal: $" + (Quantity * 5 + price) + "\n "+ getString(R.string.Thank_you);
//        return priceMessage;
//    }

    /**
     * This method displays the given quantity value on the screen.
     */
//    private void displayQuantity(int number) {
//        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
//        quantityTextView.setText("" + number);
//    }





