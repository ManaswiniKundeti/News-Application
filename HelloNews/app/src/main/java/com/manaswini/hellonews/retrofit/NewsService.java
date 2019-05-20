package com.manaswini.hellonews.retrofit;

import com.manaswini.hellonews.model.NewsResult;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface NewsService {

    //@Headers("api_key:756d6e0288f54d98bf5e6bc8f228a401")
    @GET("top-headlines")
    Call<NewsResult> getNews(@Query("country") String filter, @Query("apiKey") String apiKey);
}
