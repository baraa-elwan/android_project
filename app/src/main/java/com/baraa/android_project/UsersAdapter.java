package com.baraa.android_project;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


public class UsersAdapter extends RecyclerView.Adapter<UsersAdapter.myViewHolder> {


    User[] user_list;

    public static class  myViewHolder extends RecyclerView.ViewHolder{

        TextView userName;
        ImageView profile_picture;
        ImageView country_picture;


        public myViewHolder(View itemView) {
            super(itemView);
            userName = (TextView)itemView.findViewById(R.id.user_name);
            profile_picture = (ImageView)itemView.findViewById(R.id.user_img);
            country_picture = (ImageView)itemView.findViewById(R.id.country_img);
        }
    }

    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.user_row, parent, false);

        return new myViewHolder(itemView);
    }

    public  UsersAdapter(User[] list){
        user_list = list;

    }

    @Override
    public void onBindViewHolder(myViewHolder holder, int position) {
        User user  = user_list[position];

        holder.userName.setText(user.getName());
        //holder.profile_picture.setImageResource();
        //holder.country_picture.setImageResource();

    }


    @Override
    public int getItemCount() {
        return user_list.length;
    }
}
