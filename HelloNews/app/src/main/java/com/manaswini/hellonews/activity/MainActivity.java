package com.manaswini.hellonews.activity;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.Toast;

import com.manaswini.hellonews.R;
import com.manaswini.hellonews.adapter.ListAdapter;
import com.manaswini.hellonews.model.News;
import com.manaswini.hellonews.model.NewsResult;
import com.manaswini.hellonews.retrofit.NewsService;
import com.manaswini.hellonews.retrofit.RetrofitInstance;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    @BindView(R.id.news_list_data)
    ListView mListView;

    @BindView(R.id.news_progress_bar)
    ProgressBar mNewsProgressBar;

    private NewsService mNewsService;

    public List<News> newsList = new ArrayList<News>();

    ListAdapter newsAdapter;

    final static String USA = "us";

    final static String INDIA = "in";

    final static String CANADA = "ca";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        setTitle(getString(R.string.activity_main_title));

        newsAdapter = new ListAdapter(this,newsList);
        mListView.setAdapter(newsAdapter);

        mListView.setOnItemClickListener((parent, view, position, id) -> {
            Context context = MainActivity.this;
            Class destinationActivity = NewsDetailsActivity.class;
            Intent createNewsDetailActivityIntent = new Intent(context, destinationActivity);

            News selectedItem = newsAdapter.getItem(position);

            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_TITLE,selectedItem.getmNewsTitle());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_IMAGE,selectedItem.getmNewsImage());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_AUTHOR,selectedItem.getmNewsAuthor());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_DESCRIPTION,selectedItem.getmDescription());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_BROWSER_LINK,selectedItem.getmBrowserLink());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_DATE,selectedItem.getmPublishedDate());
            createNewsDetailActivityIntent.putExtra(NewsDetailsActivity.PARAM_NEWS_SOURCE_NAME,selectedItem.getmSource().getmSourceName());
            startActivity(createNewsDetailActivityIntent);

        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_activity_main, menu);
        return true;
    }

    public void onItemClick(MenuItem item) {
        if (item.getItemId() == R.id.india_news) {
            getNews(INDIA);
        } else if (item.getItemId() == R.id.us_news) {
            getNews(USA);
        } else if (item.getItemId() == R.id.canada_news) {
            getNews(CANADA);
//            Toast toast = Toast.makeText(getApplicationContext(), "Canada news clicked", Toast.LENGTH_SHORT);
//            toast.show();
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        if(newsList.isEmpty()){
            getNews(USA);
        }
    }

    private void getNews(String filter) {
        if(mNewsService == null) {
            mNewsService = RetrofitInstance.getRetrofitInstance().create(NewsService.class);
        }

        toggleProgressBar(true);

        Call<NewsResult> call = mNewsService.getNews(filter, RetrofitInstance.API_KEY);

        call.enqueue(new Callback<NewsResult>() {
            @Override
            public void onResponse(Call<NewsResult> call, Response<NewsResult> response) {
                toggleProgressBar(false);
                newsList.clear();

                if(response.isSuccessful() && response.body() != null){
                    newsList.addAll(response.body().getNewsList());
                    newsAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<NewsResult> call, Throwable t) {
                Log.e(TAG, "Error fetching news", t);
                Toast.makeText(MainActivity.this, "Error fetching news", Toast.LENGTH_SHORT).show();
            }
        });
    }


    public void toggleProgressBar(boolean isLoading) {
        mNewsProgressBar.setVisibility(isLoading ? View.VISIBLE : View.GONE);
    }

}
