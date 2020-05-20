package com.example.rcv_getdatamysql;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class myAdapter extends RecyclerView.Adapter<myAdapter.ViewHolder> {
    private ArrayList<SinhVien> mSV;
    private Context mContext;

    public myAdapter(ArrayList<SinhVien> mSV, Context mContext) {
        this.mSV = mSV;
        this.mContext = mContext;
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        View view = inflater.inflate(R.layout.item_layout, parent, false);
        ViewHolder views = new ViewHolder(view);
        return views;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        final SinhVien SV = mSV.get(position);
        holder.txtTitle.setText(SV.getName());
        Picasso.get().load(SV.getImg())
                .resize(800,400)
                .into(holder.imgUrl);
        holder.itemLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(mContext, SecondActivity.class);
                intent.putExtra("name", SV.getName()+"");
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mSV.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private TextView txtTitle;
        private ImageView imgUrl;
        ConstraintLayout itemLayout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            txtTitle =  itemView.findViewById(R.id.txt_title);
            imgUrl = itemView.findViewById(R.id.hinh);
            itemLayout = itemView.findViewById(R.id.item_constraint);
        }
    }
}
