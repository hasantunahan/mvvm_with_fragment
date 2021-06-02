package com.tashteam.mvvm_fragment.ui.main.Home.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.tashteam.mvvm_fragment.R;
import com.tashteam.mvvm_fragment.ui.main.Home.Model.ProductModel;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


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
        Glide.with(context)
                .load(stringList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.mainImage);
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
        private CircleImageView mainImage;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            mainImage = itemView.findViewById(R.id.profile_image);
            stringTextView = itemView.findViewById(R.id.listNameTextView);
        }
    }
}
