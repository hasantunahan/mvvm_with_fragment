package com.tashteam.mvvm_fragment.ui.main.Home.ViewModel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;
import com.tashteam.mvvm_fragment.ui.main.Home.Service.ApiCall;

import java.util.ArrayList;
import java.util.List;

public class HomeViewModel extends ViewModel {

    private MutableLiveData<List<ProductModel>> dataList;

    public HomeViewModel(){
        dataList = new MutableLiveData<>();
    }

    public MutableLiveData<List<ProductModel>> getDataListObserver() {
        return dataList;
    }


    public void getData(){
        ApiCall apiCall=new ApiCall();
        dataList = apiCall.callProductAPI();
    }

}
