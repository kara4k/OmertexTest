package com.kara4k.omertextest.view;


import android.content.Context;
import android.content.Intent;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.kara4k.omertextest.R;
import com.kara4k.omertextest.presenter.vo.ReadyPost;
import com.squareup.picasso.Picasso;

import butterknife.BindView;

public class DetailsActivity extends BaseActivity {

    public static final String POST = "post";


    @BindView(R.id.photo_image_view)
    ImageView mPhotoIV;
    @BindView(R.id.photo_id_text_view)
    TextView mPhotoIdTV;
    @BindView(R.id.user_id_text_view)
    TextView mUserIdTV;
    @BindView(R.id.title_text_view)
    TextView mTitleTV;
    @BindView(R.id.body_text_view)
    TextView mBodyTV;


    @Override
    int getContentId() {
        return R.layout.details_activity;
    }

    @Override
    protected void onViewPrepared() {
        super.onViewPrepared();
        setupBackArrow();
        setupViews();
    }

    private void setupViews() {

        if (getIntent().getExtras() == null) return;

        ReadyPost post = (ReadyPost) getIntent().getSerializableExtra(POST);

        if (post == null) return;

        String photoId = getString(R.string.details_photo_id) + post.getId().toString();
        String userId = getString(R.string.details_user_id) + post.getUserId().toString();
        String title = getString(R.string.details_post_title) + post.getTitle();
        String body = getString(R.string.details_post_body) + post.getBody();

        mPhotoIdTV.setText(photoId);
        mUserIdTV.setText(userId);
        mTitleTV.setText(title);
        mBodyTV.setText(body);
        Picasso.with(this).load(post.getPhotoSmallUrl()).into(mPhotoIV);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                onBackPressed();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public static Intent newIntent(Context context, ReadyPost readyPost) {
        Intent intent = new Intent(context, DetailsActivity.class);
        intent.putExtra(POST, readyPost);
        return intent;
    }

}
