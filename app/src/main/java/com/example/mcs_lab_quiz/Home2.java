package com.example.mcs_lab_quiz;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class Home2 extends AppCompatActivity {

    TextView MedName, MedManufact, MedPrice, MedDecs;

    ImageView MedImage, backhome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        MedName = findViewById(R.id.MedName);
        MedManufact = findViewById(R.id.MedManufact);
        MedPrice = findViewById(R.id.MedPrice);
        MedDecs = findViewById(R.id.MedDesc);
        MedImage = findViewById(R.id.MedImage);

        String nameMedichine = getIntent().getStringExtra("Namemed");
        String manufacture = getIntent().getStringExtra("ManufacMed");
        String price = getIntent().getStringExtra("Pricemed");
        String detail = getIntent().getStringExtra("DescMed");
        Integer image = getIntent().getExtras().getInt("image");

        MedName.setText(nameMedichine);
        MedManufact.setText(manufacture);
        MedPrice.setText(price);
        MedDecs.setText(detail);
        MedImage.setImageResource(image);

        backhome = findViewById(R.id.backhome);
        backhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent home = new Intent(Home2.this, Home.class);
                startActivity(home);
            }
        });
    }
}