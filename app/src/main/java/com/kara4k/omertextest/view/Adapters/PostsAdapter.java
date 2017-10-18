package com.kara4k.omertextest.view.Adapters;


import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.kara4k.omertextest.R;
import com.kara4k.omertextest.presenter.vo.ReadyPost;
import com.kara4k.omertextest.view.DetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PostsAdapter extends RecyclerView.Adapter<PostsAdapter.Holder> {

    private List<ReadyPost> mList;


    @Inject
    public PostsAdapter() {
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.post_holder, parent, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder holder, int position) {
        holder.onBind(mList.get(position));
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void setList(List<ReadyPost> list) {
        mList = list;
        notifyDataSetChanged();
    }

    class Holder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.thumb_image_view) ImageView mThumbIV;
        @BindView(R.id.title_text_view) TextView mTitleTV;
        @BindView(R.id.body_text_view) TextView mBodyTV;

        private ReadyPost mReadyPost;
        private Context mContext;


        public Holder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mContext = itemView.getContext();
            itemView.setOnClickListener(this);
        }

        public void onBind(ReadyPost post) {
            mReadyPost = post;

            mTitleTV.setText(post.getTitle());
            mBodyTV.setText(post.getBody());
            Picasso.with(mContext).load(post.getThumbUrl()).into(mThumbIV);
        }

        @Override
        public void onClick(View v) {
            Intent intent = DetailsActivity.newIntent(mContext, mReadyPost);
            mContext.startActivity(intent);
        }
    }
}
