package com.example.dfrag;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

   Button prevbtn , nextbtn ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        prevbtn = findViewById(R.id.btnprev);
        nextbtn = findViewById(R.id.btnnext);

        prevbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dynamicFragment d_frag = new dynamicFragment();
                FragmentManager fmanager = d_frag.getFragmentManager();
                FragmentTransaction ftrans = fmanager.beginTransaction();
                ftrans.add(R.id.framelayout_id ,d_frag , "MyFragment");
                ftrans.commit();
            }
        });


    }
}
