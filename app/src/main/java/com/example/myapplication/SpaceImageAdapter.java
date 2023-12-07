package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class SpaceImageAdapter extends RecyclerView.Adapter<SpaceImageAdapter.ViewHolder> {
    private List<SpaceImageData> spaceImageList;
    private LayoutInflater inflater;

    SpaceImageAdapter(Context context, List<SpaceImageData> spaceImageList) {
        this.inflater = LayoutInflater.from(context);
        this.spaceImageList = spaceImageList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.space_image_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        SpaceImageData imageData = spaceImageList.get(position);
        holder.titleView.setText(imageData.getTitle());
        Picasso.get().load(imageData.getImageUrl()).into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return spaceImageList.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView titleView;
        ImageView imageView;

        ViewHolder(View itemView) {
            super(itemView);
            titleView = itemView.findViewById(R.id.titleViewSpaceImage);
            imageView = itemView.findViewById(R.id.imageViewSpaceImage);
        }
    }
}
