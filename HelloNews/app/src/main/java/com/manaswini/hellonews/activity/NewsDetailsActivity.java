package com.manaswini.hellonews.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.view.MenuItemCompat;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.ShareActionProvider;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.manaswini.hellonews.R;
import com.manaswini.hellonews.retrofit.NewsService;
import com.squareup.picasso.Picasso;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsActivity extends AppCompatActivity {

    ShareActionProvider shareActionProvider;

    private static final String TAG = NewsDetailsActivity.class.getSimpleName();

    public static final String PARAM_NEWS_TITLE = "param_news_title";
    public static final String PARAM_NEWS_IMAGE = "param_news_image";
    public static final String PARAM_NEWS_AUTHOR = "param_news_author";
    public static final String PARAM_NEWS_DESCRIPTION = "param_news_description";
    public static final String PARAM_NEWS_BROWSER_LINK = "param_news_browser_link";
    public static final String PARAM_NEWS_DATE = "param_news_date";
    public static final String PARAM_NEWS_SOURCE_NAME = "param_news_source_name";

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

    String newsTitle;
    String newsUrl;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_details);
        ButterKnife.bind(this);

        setTitle(getString(R.string.activity_details_title));

        Intent intentThatStartedThisActivity = getIntent();

        newsTitle = intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_TITLE);
        newsUrl = intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_BROWSER_LINK);

        Picasso.get()
                .load(intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_IMAGE))
                .into(mNewsImageView);
        mTitleTextView.setText(newsTitle);
        mAuthorTextView.setText(intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_AUTHOR));
        mDescriptionTextView.setText(intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_DESCRIPTION));
        mBrowserLinkTextView.setText(newsUrl);
        mNewsDateTextView.setText(intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_DATE));
        mSourceNameTextView.setText(intentThatStartedThisActivity.getStringExtra(PARAM_NEWS_SOURCE_NAME));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_news_details, menu);
        MenuItem item = menu.findItem(R.id.action_share);

        ShareActionProvider provider = (ShareActionProvider) MenuItemCompat.getActionProvider(item);
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("text/plain");
        shareIntent.putExtra(Intent.EXTRA_TEXT, newsTitle);
        shareIntent.putExtra(Intent.EXTRA_TEXT, newsUrl);
        provider.setShareIntent(shareIntent);

        return true;
    }
}
