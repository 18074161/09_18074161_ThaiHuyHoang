package com.example.a09_18074161_thaihuyhoang.recy;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.a09_18074161_thaihuyhoang.OnClickListner;
import com.example.a09_18074161_thaihuyhoang.R;
import com.example.a09_18074161_thaihuyhoang.User;

import java.util.List;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder>{
    List<User> mUsers;
    OnClickListner listner;

    public CustomAdapter(List<User> users, OnClickListner listner1) {
        mUsers = users;
        this.listner = listner1;
    }

    @NonNull
    @Override
    public CustomAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item, parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull  CustomAdapter.ViewHolder holder, int position) {
        User user = mUsers.get(position);
        holder.user1 = user;
        holder.tvName.setText(user.getName());
        holder.tvPrice.setText(user.getPrice()+"");
        holder.imgUser.setImageResource(user.getAnh());
    }

    @Override
    public int getItemCount() {
        return mUsers.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvName, tvPrice;
        ImageView imgUser;
        User user1;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvName = itemView.findViewById(R.id.tvName);
            tvPrice = itemView.findViewById(R.id.tvPrice);
            imgUser = itemView.findViewById(R.id.imgUser);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listner.itemClick(user1);
                }
            });
        }
    }
}
