package com.example.myapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import java.util.ArrayList;
import com.squareup.picasso.Picasso;

public class ImageGalleryAdapter extends ArrayAdapter<ImageData> {

    public ImageGalleryAdapter(Context context, ArrayList<ImageData> images) {
        super(context, 0, images);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item_image, parent, false);
        }

        ImageData imageData = getItem(position);
        TextView titleView = convertView.findViewById(R.id.titleViewList);
        ImageView imageView = convertView.findViewById(R.id.imageViewList);

        titleView.setText(imageData.getTitle());
        Picasso.get().load(imageData.getImageUrl()).into(imageView);

        return convertView;
    }
}
