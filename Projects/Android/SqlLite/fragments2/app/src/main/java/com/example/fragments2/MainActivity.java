package com.example.fragments2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity {
    Button gradiantbtn , solidbtn , imagebtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gradiantbtn = findViewById(R.id.btnGradiant);
        solidbtn = findViewById(R.id.Solidbtn);
        imagebtn = findViewById(R.id.imagebtn);
        gradiantbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                gradiantfragment gf = new gradiantfragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ftrans = fragmentManager.beginTransaction();
                FrameLayout fl = findViewById(R.id.star);
                fl.clearFocus();
                ftrans.add(R.id.star , gf , "Myfragrad");
                ftrans.commit();
            }

        });

        solidbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                newShape sf = new newShape();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ftrans = fragmentManager.beginTransaction();
                FrameLayout fl = findViewById(R.id.star);
                fl.clearFocus();
                ftrans.add(R.id.star , sf , "Myfragsolid");
                ftrans.commit();
            }
        });

        imagebtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagefragment imf = new imagefragment();
                FragmentManager fragmentManager = getSupportFragmentManager();
                FragmentTransaction ftrans = fragmentManager.beginTransaction();
                FrameLayout fl = findViewById(R.id.star);
                fl.clearFocus();
                ftrans.add(R.id.star , imf , "myfragimg");
                ftrans.commit();
            }
        });
    }

}
