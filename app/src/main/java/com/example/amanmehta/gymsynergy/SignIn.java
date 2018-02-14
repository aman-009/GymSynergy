package com.example.amanmehta.gymsynergy;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;


public class SignIn extends AppCompatActivity {


    Button joinUs,submitButton;
    EditText UserName,UserPassword;
    private FirebaseAuth mAuth;

    private FirebaseAuth.AuthStateListener mAuthListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_in);
        mAuth = FirebaseAuth.getInstance();

        UserName = (EditText) findViewById(R.id.userName);
        UserPassword = (EditText) findViewById(R.id.userPassword);
        joinUs = (Button) findViewById(R.id.JoinUs);
        submitButton = (Button) findViewById(R.id.SubmitButton);

        final Intent i = new Intent(this, SignUp.class);
        joinUs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                finish();
            }
        });

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startSignIn();
            }
        });

        mAuthListener = new FirebaseAuth.AuthStateListener(){

            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                if(firebaseAuth.getCurrentUser() != null){

                    startActivity(new Intent(SignIn.this, Home.class));

                }
            }
        };

    }

    @Override
    protected void onStart() {
        super.onStart();
        mAuth.addAuthStateListener(mAuthListener);
    }

    public void startSignIn(){
        String email = UserName.getText().toString();
        String Password = UserPassword.getText().toString();

        if(TextUtils.isEmpty(email) || TextUtils.isEmpty(Password)){

            Toast.makeText(SignIn.this, "Fields are empty", Toast.LENGTH_LONG).show();
        }
        else{

            mAuth.signInWithEmailAndPassword(email, Password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {

                    if(!task.isSuccessful()){

                        startActivity(new Intent(SignIn.this, Home.class));

                    }

                }
            });
        }
    }
}
