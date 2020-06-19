package com.example.seb7a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Masbaha extends AppCompatActivity {
    TextView sophan,hamd,akpar,result;
    ImageButton plus,refin;
    EditText zekr;
    int number=0,memo=0;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masbaha);
        sophan=findViewById(R.id.sophan);
        hamd=findViewById(R.id.hamd);
        akpar=findViewById(R.id.akpar);
        result=findViewById(R.id.result);
        plus=findViewById(R.id.plus);
        refin=findViewById(R.id.refine);
        zekr=findViewById(R.id.zekr);
        Intent i=getIntent();
        int m=i.getIntExtra("i",0);
        if (m==1)
        {
            zekr.setVisibility(View.INVISIBLE);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (number<33)
                    {
                        number++;
                        memo++;
                        result.setText(number+"");
                        if (memo==99){
                            Toast.makeText(getBaseContext(),"لقد اتممت تسبيح الصلاة",Toast.LENGTH_LONG).show();
                            startActivity(new Intent(Masbaha.this,MainActivity.class));
                        }
                    }
                    else if (number>=33)
                    {
                        Toast.makeText(getBaseContext(),"لقد اتممت الثلاثة وثلالثين عدة",Toast.LENGTH_LONG).show();
                        number=0;
                        result.setText("0");
                    }

                }
            });

        }

        if (m==2)
        {
            sophan.setVisibility(View.INVISIBLE);
           hamd.setVisibility(View.INVISIBLE);
            akpar.setVisibility(View.INVISIBLE);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    number++;
                    result.setText(number+"");
                }
            });
        }
        refin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                number=0;
                memo=0;
                result.setText("0");
            }
        });


    }

}
