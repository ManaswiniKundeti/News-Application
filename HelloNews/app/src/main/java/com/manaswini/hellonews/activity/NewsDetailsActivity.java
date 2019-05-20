package com.manaswini.hellonews.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.manaswini.hellonews.R;
import com.manaswini.hellonews.retrofit.NewsService;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsActivity extends AppCompatActivity {

    private static final String TAG = NewsDetailsActivity.class.getSimpleName();

    private NewsService mNewsService;

    @BindView(R.id.news_detail_image)
    ImageView mNewsImageView;

    @BindView(R.id.news_detail_title)
    TextView mTitleTextView;

    @BindView(R.id.news_detail_author_name)
    TextView mAuthorTextView;

    @BindView(R.id.news_detail_description)
    TextView mDescriptionTextView;

    @BindView(R.id.news_detail_browser_link)
    TextView mBrowserLinkTextView;

    @BindView(R.id.news_detail_date)
    TextView mNewsDateTextView;

    @BindView(R.id.news_detail_source_name)
    TextView mSourceNameTextView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);

        setTitle(getString(R.string.activity_details_title));

        Intent intentThatStartedThisActivity = getIntent();
    }
}
