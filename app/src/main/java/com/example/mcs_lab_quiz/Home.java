package com.example.mcs_lab_quiz;

import static android.app.PendingIntent.getActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.widget.Toolbar;

import java.util.ArrayList;

public class Home extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ArrayList<Model> arrayList = new ArrayList<>();
    private Toolbar toolbar;
    private ImageView shop, aboutus, logOut;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        toolbar = findViewById(R.id.toolbar);
        shop = findViewById(R.id.icon_transaction);
        aboutus = findViewById(R.id.icon_aboutus);
        logOut = findViewById(R.id.icon_logout);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(false);

        shop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent toshop = new Intent(Home.this, Transaction.class);
                startActivity(toshop);
            }
        });

        aboutus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent toAboutUs = new Intent(Home.this, AboutUs.class);
                startActivity(toAboutUs);
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent tologin = new Intent(Home.this, MainActivity.class);
                startActivity(tologin);
            }
        });

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        arrayList.add(new Model(R.drawable.obhcombibatukflu, "OBH Combi Batuk plus Flu 100ml", "PT.Combhipar", "$7.0", "OBH COMBI PLUS Cough FLU is a cough medicine containing OBH, Paracetamol, Ephedrine HCl, and Chlorphenamine Maleate which is used to relieve coughs accompanied by flu symptoms such as fever, headache, nasal congestion, and sneezing."));
        arrayList.add(new Model(R.drawable.vicks44obatbatuk, "Vicks Batuk 100ml", "Procter & Gamble and Helen of Troy Limited", "$9.0", "VICKS FORMULA 44 SYRUP is a cough syrup with a combination formula of Dextromethorphan HBr and Doxylamine Succinate to relieve coughs that don't produce phlegm accompanied by sneezing/allergies."));
        arrayList.add(new Model(R.drawable.sangobion, "Sangobion Replenish iron stores & increases haemogoblin", "PT.Merck", "$10.0", "SANGOBION is a blood booster vitamin the ingredients in this product help the process of forming hemoglobin in the body so that it can help treat anemia during menstruation, pregnancy, breastfeeding, the growth period, and after bleeding."));
        arrayList.add(new Model(R.drawable.tolakangin, "Tolak Angin Herbal Liquid with Honey & Mint", "Sidomuncul", "$5.0", "Tolak Angin Herbal Liquid with Honey & Mint is a standardized herbal medicine that contains a combination of various natural herbs that can be used to help maintain or maintain the immune system and relieve symptoms of colds."));
        arrayList.add(new Model(R.drawable.scottsemulsion, "Scott's Emulsion Vita Cod Liver Oil Orange Flavour", "SCOTT & BOWNE", "$15.0", "Scott's Emulsion is a cod liver oil supplement that is usually given to children. This supplement has various benefits such as maintaining endurance, preventing vitamin D & A deficiencies, and also overcoming nutritional disorders"));

        ModelRecyclerView modelRecyclerView = new ModelRecyclerView(this,arrayList);
        recyclerView.setAdapter(modelRecyclerView);
    }
}