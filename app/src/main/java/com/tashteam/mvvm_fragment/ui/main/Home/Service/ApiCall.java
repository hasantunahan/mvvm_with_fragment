package com.tashteam.mvvm_fragment.ui.main.Home.Service;

import androidx.lifecycle.MutableLiveData;

import com.tashteam.mvvm_fragment.Core.Network.APIService;
import com.tashteam.mvvm_fragment.Core.Network.RetroInstance;
import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ApiCall {

    private MutableLiveData<List<ProductModel>> productList ;

    public ApiCall(){
        productList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductModel>> callProductAPI() {
        APIService apiService= RetroInstance.getRetrofitClient().create(APIService.class);
        Call<List<ProductModel>> call = apiService.getProductList();
        call.enqueue(new Callback<List<ProductModel>>() {
            @Override
            public void onResponse(Call<List<ProductModel>> call, Response<List<ProductModel>> response) {
                productList.postValue(response.body());
            }
            @Override
            public void onFailure(Call<List<ProductModel>> call, Throwable t) {
                productList.postValue(null);

            }
        });
        return productList;
    }
}
