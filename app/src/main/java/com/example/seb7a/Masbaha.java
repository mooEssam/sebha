package com.example.seb7a;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

public class Masbaha extends AppCompatActivity {
    TextView sophan,hamd,akpar,result;
    ImageButton plus,refin,history;
    EditText zekr;
    int number=0,memo=0;
    int m;
    SharedPreferences sharedPreferences;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_masbaha);
        sharedPreferences=getBaseContext().getSharedPreferences("memo",getBaseContext().MODE_PRIVATE);
        history=findViewById(R.id.rusem);
        sophan=findViewById(R.id.sophan);
        hamd=findViewById(R.id.hamd);
        akpar=findViewById(R.id.akpar);
        result=findViewById(R.id.result);
        plus=findViewById(R.id.plus);
        refin=findViewById(R.id.refine);
        zekr=findViewById(R.id.zekr);
        Intent i=getIntent();
         m=i.getIntExtra("i",0);
        if (m==1)
        {
            history.setVisibility(View.INVISIBLE);
            zekr.setVisibility(View.INVISIBLE);
            plus.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                   if (number<33)
                    {
                        number++;
                        memo++;
                        result.setText(number+"");
                        if (memo<33){
                            sophan.setVisibility(View.VISIBLE);
                            hamd.setVisibility(View.INVISIBLE);
                            akpar.setVisibility(View.INVISIBLE);
                        }
                        if (memo>33&&memo<=66)
                        {
                            sophan.setVisibility(View.VISIBLE);
                            hamd.setVisibility(View.VISIBLE);
                            akpar.setVisibility(View.INVISIBLE);

                        }
                        if (memo>66)
                        {
                            sophan.setVisibility(View.VISIBLE);
                            hamd.setVisibility(View.VISIBLE);
                            akpar.setVisibility(View.VISIBLE);

                        }
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

        history.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                number=sharedPreferences.getInt("no",0);
              result.setText(number+"");


            }
        });


    }



    @Override
    protected void onPause() {
        super.onPause();
        if (m==2)
        {

            SharedPreferences.Editor editor = sharedPreferences.edit();
            int nom= Integer.parseInt(result.getText().toString());
            editor.putInt("no", nom);
            editor.apply();
        }
    }
}
