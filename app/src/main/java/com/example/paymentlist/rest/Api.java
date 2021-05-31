package com.example.paymentlist.rest;

import com.example.paymentlist.BuildConfig;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;


public class Api {
    private static Api instance;
    private ApiServiceClient apiServiceClient;

    private Api() {
        OkHttpClient.Builder okHttpClient = new OkHttpClient.Builder()
                .connectTimeout(5, TimeUnit.MINUTES)
                .readTimeout(5, TimeUnit.MINUTES);


        if (BuildConfig.DEBUG) {
            HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
            logging.setLevel(HttpLoggingInterceptor.Level.BODY);

            okHttpClient.addInterceptor(logging);
        }


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(RestConstants.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder().setLenient().create()))
                .addCallAdapterFactory(RxJava3CallAdapterFactory.create())
                .client(okHttpClient.build())
                .build();


        this.apiServiceClient = retrofit.create(ApiServiceClient.class);
    }

    public static Api getInstance() {
        if (instance == null) {
            instance = new Api();
        }

        return instance;
    }

    public ApiServiceClient getApiServiceClient() {
        return apiServiceClient;
    }
}
