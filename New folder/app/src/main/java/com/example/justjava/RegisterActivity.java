package com.example.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class RegisterActivity extends AppCompatActivity {

    EditText fullName_signUp;
    EditText email_signUp;
    EditText password_signUp;
    Button register_btn;
    TextView signIn_link;

    private FirebaseAuth auth;
    private FirebaseUser firebaseUser;
    private DatabaseReference ref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register2);

        fullName_signUp=findViewById(R.id.fullName_signUp);
        email_signUp=findViewById(R.id.email_signUp);
        password_signUp=findViewById(R.id.password_signUp);
        register_btn=findViewById(R.id.register_btn);
        signIn_link=findViewById(R.id.signIn_link);

        signIn_link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(RegisterActivity.this, LoginActivity.class);
                startActivity(intent);
                finish();
            }
        });

        auth=FirebaseAuth.getInstance();



        register_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String name = fullName_signUp.getText().toString();
                String email = email_signUp.getText().toString();
                String password = password_signUp.getText().toString();

                if (name.isEmpty() || email.isEmpty() || password.isEmpty()) {
                    Toast.makeText(RegisterActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                } else if (password.length() < 6) {
                    password_signUp.setError("Password should be of atleast 6 characters");
                }

                else{

                    register(name, email, password);
                }


            }
        });
    }

    public void register(final String name, final String email, String password) {
        auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            FirebaseUser firebaseUser = auth.getCurrentUser();
                            String userId = firebaseUser.getUid();

                            ref = FirebaseDatabase.getInstance().getReference().child("Users").child(userId);

                            UserDetails user=new UserDetails(name,email,userId);

                            ref.setValue(user).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                                        startActivity(intent);
                                        finish();
                                    }
                                }
                            });

                        } else {
                            Toast.makeText(RegisterActivity.this, "Cannot Register with this email or password", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }
}