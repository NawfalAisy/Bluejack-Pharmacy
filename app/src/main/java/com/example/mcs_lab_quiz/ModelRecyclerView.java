package com.example.mcs_lab_quiz;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ModelRecyclerView extends RecyclerView.Adapter<ModelRecyclerView.ViewHolder> {

    Context context;
    ArrayList<Model> arrayList = new ArrayList<>();

    public ModelRecyclerView(Context context, ArrayList<Model> arrayList){
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.card_view,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.imageView.setImageResource(arrayList.get(position).getImage());
        holder.textView1OBH.setText(arrayList.get(position).getName());
        holder.textView2OBH.setText(arrayList.get(position).getManufakture());
        holder.textView3OBH.setText(arrayList.get(position).getPrice());
        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, Home2.class);
                i.putExtra("Namemed", arrayList.get(position).getName());
                i.putExtra("Pricemed", arrayList.get(position).getPrice());
                i.putExtra("ManufacMed", arrayList.get(position).getManufakture());
                i.putExtra("DescMed", arrayList.get(position).getDetail());
                i.putExtra("image", arrayList.get(position).getImage());
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imageView;
        TextView textView1OBH, textView2OBH, textView3OBH, textView4OBH;
        CardView cardView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewOBHCombi);
            textView1OBH = itemView.findViewById(R.id.OBHCombiName);
            textView2OBH = itemView.findViewById(R.id.OBHCombiManufacture);
            textView3OBH = itemView.findViewById(R.id.OBHCombiPrice);
            textView4OBH = itemView.findViewById(R.id.MedDesc);
            cardView = itemView.findViewById(R.id.cardView);
        }
    }
}
