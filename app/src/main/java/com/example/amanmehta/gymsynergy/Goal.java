package com.example.amanmehta.gymsynergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Goal extends AppCompatActivity {


    Button submitButton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goal);

        submitButton = (Button) findViewById(R.id.Submit);

        final Intent i = new Intent(Goal.this, Home.class);
        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                finish();
            }
        });
    }
}
