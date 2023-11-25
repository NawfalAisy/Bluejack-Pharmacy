package com.example.mcs_lab_quiz;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toolbar;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

public class Transaction extends AppCompatActivity {

    private RecyclerView recyclerView;

    private ImageView backtohome, logouttransaction;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.transactionrecycler);

        backtohome = findViewById(R.id.backtohome);
        logouttransaction = findViewById(R.id.logouttransaction);

        backtohome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tohome = new Intent(Transaction.this, Home.class);
                startActivity(tohome);
                finish();
            }
        });

        logouttransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent tologin = new Intent(Transaction.this, MainActivity.class);
                startActivity(tologin);
                finish();
            }
        });
    }
}
