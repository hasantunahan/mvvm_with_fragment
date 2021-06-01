package com.tashteam.mvvm_fragment.Core.Network;

import com.tashteam.mvvm_fragment.Core.Constant.Config;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetroInstance {

    private static Retrofit retrofit;
    public static Retrofit getRetrofitClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(Config.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return  retrofit;
    }
}
