package com.tashteam.mvvm_fragment.ui.main.Home;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toolbar;

import com.tashteam.mvvm_fragment.Core.Navigation.IFragmentNavigation;
import com.tashteam.mvvm_fragment.R;
import com.tashteam.mvvm_fragment.ui.main.Home.Adapter.HomeStringListAdapter;
import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;
import com.tashteam.mvvm_fragment.ui.main.Home.ViewModel.HomeViewModel;

import java.util.ArrayList;
import java.util.List;


public class HomeView extends Fragment implements IFragmentNavigation {


    private HomeViewModel homeViewModel;
    private List<ProductModel> stringList;
    private HomeStringListAdapter homeStringListAdapter;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home_view, container, false);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Button button = view.findViewById(R.id.backButton);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                goNewFragment(view);
            }
        });
        setRecylerView(view);
    }

    public void setRecylerView(View view){
        stringList = new ArrayList<>();
        homeViewModel=new HomeViewModel();
        RecyclerView recyclerView= view.findViewById(R.id.stringRecylerView);
        LinearLayoutManager layoutManager= new LinearLayoutManager(getActivity().getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        homeStringListAdapter = new HomeStringListAdapter(getActivity().getApplicationContext(),stringList);
        recyclerView.setAdapter(homeStringListAdapter);
        homeViewModel.getData();
        homeViewModel.getDataListObserver().observe(getViewLifecycleOwner(), new Observer<List<ProductModel>>() {
            @Override
            public void onChanged(List<ProductModel> strings) {
                if(strings != null){
                    stringList = strings;
                    homeStringListAdapter.setLiveDataList(strings);
                }
            }
        });
    }

    @Override
    public void goNewFragment(View view) {
        NavController navController = Navigation.findNavController(view);
        navController.navigate(R.id.action_homeView_to_mainFragment);
    }
}