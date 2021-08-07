package tech.hamid.android_internship_assessment;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.ItemHolder> {

    private Context context;
    private List<Details> detailsList;

    public Adapter(Context context, List<Details> detailsList) {
        this.context = context;
        this.detailsList = detailsList;
    }

    @NonNull
    @Override
    public ItemHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item, parent, false);
        return new ItemHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemHolder holder, int position) {
        Details detail = detailsList.get(position);

        holder.name.setText(detail.getName().toString());
        holder.description.setText(detail.getDescription().toString());
        Glide.with(context).load(detail.getMain_img()).into(holder.main_img);
        Glide.with(context).load(detail.getProfile_img()).into(holder.profile_img);

        holder.constraintLayout.getViewById(R.id.itemCard).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DescImgActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", detail.getName());
                bundle.putString("description", detail.getDescription());
                bundle.putString("main_img", detail.getMain_img());
                bundle.putString("profile_img", detail.getProfile_img());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });

        holder.constraintLayout.getViewById(R.id.itemCard2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, ProNameActivity.class);

                Bundle bundle = new Bundle();
                bundle.putString("name", detail.getName());
                bundle.putString("description", detail.getDescription());
                bundle.putString("main_img", detail.getMain_img());
                bundle.putString("profile_img", detail.getProfile_img());
                bundle.putString("location", detail.getUserLocation());
                bundle.putString("bio", detail.getUserBio());

                intent.putExtras(bundle);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return detailsList.size();
    }

    public class ItemHolder extends RecyclerView.ViewHolder {
        TextView name, description;
        ImageView main_img, profile_img;
        ConstraintLayout constraintLayout;

        public ItemHolder(@NonNull View itemView) {
            super(itemView);
            main_img = itemView.findViewById(R.id.cardImageView);
            profile_img = itemView.findViewById(R.id.imageView2);
            description = itemView.findViewById(R.id.description_ti);
            name = itemView.findViewById(R.id.name_ov);
            constraintLayout = itemView.findViewById(R.id.main_layout);

        }
    }
}
