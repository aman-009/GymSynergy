package com.example.amanmehta.gymsynergy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthException;

import static android.R.id.message;

public class SignUp extends AppCompatActivity {



    Button SignUp;
    EditText UserName,UserPassword,Email;
    private FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);

        mAuth = FirebaseAuth.getInstance();

        Email = (EditText) findViewById(R.id.email);
        UserName = (EditText) findViewById(R.id.username);
        UserPassword = (EditText) findViewById(R.id.password);
        SignUp = (Button) findViewById(R.id.SignUp);


        SignUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignUp();
            }
        });
    }

    public void startSignUp(){


        String email = UserName.getText().toString();
        String Password = UserPassword.getText().toString();
        String username = UserName.getText().toString();

        mAuth.createUserWithEmailAndPassword(email, Password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            startActivity(new Intent(SignUp.this, Goal.class));
                        }
                    }
                });
    }
}
