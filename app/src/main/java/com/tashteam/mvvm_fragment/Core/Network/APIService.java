package com.tashteam.mvvm_fragment.Core.Network;


import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("products")
    Call<List<ProductModel>> getProductList();

}
