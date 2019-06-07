package com.josea.pruebafootters.UI.Main.Adapter;

import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.josea.pruebafootters.R;
import com.josea.pruebafootters.UI.Entities.User;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MemberAdapter extends RecyclerView.Adapter<MemberAdapter.CustomViewHolder> {


    private List<User> userList;
    private OnClickUser onClickUser;

    public MemberAdapter(List<User> users, OnClickUser onClickUser) {
        this.userList = users;
        this.onClickUser = onClickUser;
    }

    @NonNull
    @Override
    public CustomViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_member, viewGroup, false);
        CustomViewHolder customViewHolder = new CustomViewHolder(view);
        return customViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CustomViewHolder customViewHolder, int i) {
        customViewHolder.user = userList.get(i);
        customViewHolder.textViewNickName.setText(customViewHolder.user.getLogin());
        customViewHolder.textViewName.setText(customViewHolder.user.getName());
        Glide.with(customViewHolder.imageView)
                .load(customViewHolder.user.getAvatar_url())
                .into(customViewHolder.imageView);
        customViewHolder.createClick(userList.get(i),this.onClickUser);
        customViewHolder.UserItem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onClickUser.onClickUserListener(customViewHolder.user);
            }
        });

    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        @BindView(R.id.textViewName)
        TextView textViewName;
        @BindView(R.id.textViewNickName)
        TextView textViewNickName;
        @BindView(R.id.imageView)
        ImageView imageView;
        @BindView(R.id.memberItem)
        ConstraintLayout UserItem;

        User user;
        OnClickUser onClickUser;

        public CustomViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        public void createClick(User user, OnClickUser onClickUser) {
            this.user = user;
            this.onClickUser = onClickUser;
        }

        @Override
        public void onClick(View v) {
            onClickUser.onClickUserListener(user);
        }
    }

    public interface OnClickUser {
        void onClickUserListener(User user);
    }
}
