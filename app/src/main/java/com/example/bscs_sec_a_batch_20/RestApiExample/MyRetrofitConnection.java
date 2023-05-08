package com.example.bscs_sec_a_batch_20.RestApiExample;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofitConnection {

    public static Retrofit retrofit = null;
    public static String uRL = "https://jsonplaceholder.typicode.com/";
    public static Retrofit getMyRetrofit()
    {
        if(retrofit==null)
        {
            retrofit = new Retrofit.Builder().baseUrl(uRL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }
}
