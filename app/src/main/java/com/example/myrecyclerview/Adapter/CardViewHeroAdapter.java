package com.example.myrecyclerview.Adapter;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.myrecyclerview.Models.Hero;
import com.example.myrecyclerview.R;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class CardViewHeroAdapter extends RecyclerView.Adapter<CardViewHeroAdapter.CardViewHeroViewHolder> {

    private ArrayList<Hero> listHero;

    public CardViewHeroAdapter(ArrayList<Hero> list){
        this.listHero = list;
    }

    public class CardViewHeroViewHolder extends RecyclerView.ViewHolder {

        ImageView imgPhoto;
        Button btnFavorite, btnShare;
        TextView tvName, tvDetail;

        public CardViewHeroViewHolder(View itemView) {
            super(itemView);
            imgPhoto = itemView.findViewById(R.id.img_item_photo);
            btnFavorite = itemView.findViewById(R.id.btn_set_favorite);
            btnShare = itemView.findViewById(R.id.btn_set_share);
            tvName = itemView.findViewById(R.id.tv_item_name);
            tvDetail = itemView.findViewById(R.id.tv_item_detail);
        }
    }

    @Override
    public CardViewHeroViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_cardview_hero, parent, false);
        return new CardViewHeroViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final CardViewHeroViewHolder holder, int position) {
        Hero hero = listHero.get(position);

        Glide.with(holder.itemView.getContext())
                .load(hero.getPhoto())
                .apply(new RequestOptions().override(350, 550))
                .into(holder.imgPhoto);

        holder.tvName.setText(hero.getName());
        holder.tvDetail.setText(hero.getDetail());

        holder.btnFavorite.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make toast on button click
                Toast.makeText(holder.itemView.getContext(),
                        listHero.get(holder.getAdapterPosition()).getName() + " added to Favorite",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.btnShare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //make toast on button click
                Toast.makeText(holder.itemView.getContext(),
                        listHero.get(holder.getAdapterPosition()).getName() + " Shared",
                        Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return listHero.size();
    }

}
