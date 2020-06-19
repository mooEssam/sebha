package com.example.seb7a;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView salah,spe;
        salah=findViewById(R.id.salah);
        spe=findViewById(R.id.spe);
        salah.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Masbaha.class);
                intent.putExtra("i",1);
                startActivity(intent);
            }
        });
        spe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,Masbaha.class);
                intent.putExtra("i",2);
                startActivity(intent);
            }
        });

    }
}
