package com.example.amanmehta.gymsynergy;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    ImageView iv;
    Animation mytrans;
    Button Enterbtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        iv = (ImageView) findViewById(R.id.imageView);
        mytrans = AnimationUtils.loadAnimation(this,R.anim.mytransition);
        iv.startAnimation(mytrans);


        Enterbtn = (Button) findViewById(R.id.EnterButton);
        // feature to be include **if already existing then send to main page directly**
        final Intent i = new Intent(this, SignIn.class);
        Thread timer = new Thread(){
            public void run(){
                try{
                    sleep(9000);
                }
                catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
        };
        timer.start();

        Enterbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(i);
                finish();
            }
        });
    }
}
