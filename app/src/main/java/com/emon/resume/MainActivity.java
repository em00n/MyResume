package com.emon.resume;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {
    ViewFlipper viewFlipper;
    CardView cardView1,cardView2,cardView3,cardView4;
//    Button basicInfBtn,eduInfBtn,skillInfBtn,image;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        viewFlipper=findViewById(R.id.slideVF);
        cardView1=findViewById(R.id.basicInfCv);
        cardView2=findViewById(R.id.eduInfInfCv);
        cardView3=findViewById(R.id.skillInfCv);
        cardView4=findViewById(R.id.imageCv);
        getSupportActionBar().setTitle("Home");


        //image sliding
        int [] images={R.drawable.basicinf,R.drawable.eduinf,R.drawable.skillinf,R.drawable.image,};
        for (int image:images){
            flipperImage(image);
        }

        //basicInformation Button
        cardView1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
            }
        });
        cardView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent);
            }
        });
        cardView3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main4Activity.class);
                startActivity(intent);
            }
        });
        cardView4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Main5Activity.class);
                startActivity(intent);
            }
        });





    }
    //this methode use in slideing
    public void flipperImage(int image){
        ImageView imageView=new ImageView(this);
        imageView.setImageResource(image);
        viewFlipper.addView(imageView);
        viewFlipper.setFlipInterval(2000); // 2 sec
        viewFlipper.setAutoStart(true);
        //animation
        viewFlipper.setInAnimation(this,android.R.anim.slide_in_left);

    }



    public void onBackPressed() {

        AlertDialog.Builder alert= new AlertDialog.Builder(this)
                .setTitle("Exit:")
                .setMessage("Do You Want To Exit..")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                }).setNegativeButton("No",null);
        AlertDialog alertDialog=alert.create();
        alertDialog.show();

    }
}
