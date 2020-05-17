package com.example.appmusic.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.sql.Array;
import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

//Hien thi du lieu

// Cấu hình Retrofit
public class APIRetrofitClient {
    //Caapss phát bộ nhớ
    private static Retrofit retrofit = null;

    public static Retrofit getClient(String base_url)
    {
        // De tuong tac voi phia server
        OkHttpClient okHttpClient = new OkHttpClient.Builder().readTimeout(10000000, TimeUnit.MILLISECONDS)
                .writeTimeout(10000000,TimeUnit.MILLISECONDS)
                .connectTimeout(10000000,TimeUnit.MILLISECONDS)
                .retryOnConnectionFailure(true)
                .protocols(Arrays.asList(Protocol.HTTP_1_0)).build();
        //Readtimeout: neu server tra ve du lieu qua lau, thi ta se ngat
        //writeTimeout:
        //COnnect:
        //Retry: thu ket noi lai


        Gson gson = new GsonBuilder().setLenient().create();
        //Bien gson de khi du lieu tra tu phia server ve se la API , gson se chuyen tu khoa phia API ve tu khoa java

        retrofit = new Retrofit.Builder()
                .baseUrl(base_url).client(okHttpClient)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit;
    }
}
