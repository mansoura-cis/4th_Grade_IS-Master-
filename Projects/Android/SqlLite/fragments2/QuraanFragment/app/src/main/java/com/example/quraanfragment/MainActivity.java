package com.example.quraanfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import org.xml.sax.DTDHandler;

public class MainActivity extends AppCompatActivity {

    public static int counter=0;
    Button next,prev;
    FrameLayout flay;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
      next = findViewById(R.id.btnNext);
      prev = findViewById(R.id.btnPrev);
        pics q = new pics();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction ftrans = fragmentManager.beginTransaction();
        ftrans.add(R.id.flayout , q , "sd");


        ftrans.commit();
      next.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FrameLayout frameLayout = findViewById(R.id.flayout);
              frameLayout.removeAllViews();
              counter++;
              if (counter==16)
              {
                  counter=0;
              }
              pics.Counter = counter;
              pics q = new pics();
              FragmentManager fragmentManager = getSupportFragmentManager();
              FragmentTransaction ftrans = fragmentManager.beginTransaction();
              ftrans.add(R.id.flayout , q , "sd");
              ftrans.commit();

          }
      });
      prev.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              FrameLayout frameLayout = findViewById(R.id.flayout);
              frameLayout.removeAllViews();
              counter--;
              if (counter==-1)
              {
                  counter=15;
              }
              pics.Counter = counter;
              pics q = new pics();

              FragmentManager fragmentManager = getSupportFragmentManager();
              FragmentTransaction ftrans = fragmentManager.beginTransaction();
              ftrans.add(R.id.flayout , q , "sd");
              ftrans.commit();

          }
      });

    }



}
