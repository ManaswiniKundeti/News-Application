package com.manaswini.hellonews.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.manaswini.hellonews.R;
import com.manaswini.hellonews.model.News;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ListAdapter extends BaseAdapter {

    private final Context context;
    private final List<News> newsList;

    public ListAdapter(Context context, List<News> newsList) {
        this.context = context;
        this.newsList = newsList;
    }

    @Override
    public int getCount() {
        return newsList.size();
    }

    @Override
    public News getItem(int position) {
        return newsList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if(convertView == null){
            convertView = LayoutInflater.from(context)
                    .inflate(R.layout.news_item, parent, false);
        }

        ImageView newsImageView = convertView.findViewById(R.id.news_image_view);
        TextView newsTitleTextView = convertView.findViewById(R.id.news_title_text_view);
        TextView newsSourceNameTextView = convertView.findViewById(R.id.news_source_name_text_view);

        News news = newsList.get(position);

        Picasso.get()
                .load(news.getmNewsImage())
                .into(newsImageView);

        newsTitleTextView.setText(news.getmNewsTitle());

        newsSourceNameTextView.setText(news.getmSource().getmSourceName());

        return convertView;
    }
}
