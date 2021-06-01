package com.tashteam.mvvm_fragment.ui.main.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.tashteam.mvvm_fragment.R;
import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;

import java.util.List;


public class HomeStringListAdapter  extends RecyclerView.Adapter<HomeStringListAdapter.ViewHolder> {

    private Context context;
    private List<ProductModel> stringList;
    public HomeStringListAdapter(Context context, List<ProductModel> stringList){
        this.stringList = stringList;
        this.context = context;
    }

    public void setLiveDataList(List<ProductModel> stringList){
        this.stringList = stringList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HomeStringListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_card,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HomeStringListAdapter.ViewHolder holder, int position) {
        holder.stringTextView.setText(stringList.get(position).getTitle());
    }

    @Override
    public int getItemCount() {
        if(stringList.size()!=0){
            return  stringList.size();
        }else{
            return 0;
        }
    }



    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView stringTextView;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            stringTextView = itemView.findViewById(R.id.listNameTextView);
        }
    }
}
