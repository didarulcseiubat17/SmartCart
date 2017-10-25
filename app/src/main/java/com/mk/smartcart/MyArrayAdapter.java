package com.mk.smartcart;

/**
 * Created by leena on 13-09-2017.
 */
import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

//import com.androidbuts.jsonparsing.R;
//import com.androidbuts.jsonparsing.model.MyDataModel;
import com.squareup.picasso.Picasso;

import java.util.List;

public class MyArrayAdapter extends ArrayAdapter<MyDataModel> {

    List<MyDataModel> modelList;
    Context context;
    private LayoutInflater mInflater;

    // Constructors
    public MyArrayAdapter(Context context, List<MyDataModel> objects) {
        super(context, 0, objects);
        this.context = context;
        this.mInflater = LayoutInflater.from(context);
        modelList = objects;
    }

    @Override
    public MyDataModel getItem(int position) {
        return modelList.get(position);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final ViewHolder vh;
        if (convertView == null) {
            View view = mInflater.inflate(R.layout.layout_row_view, parent, false);
            vh = ViewHolder.create((RelativeLayout) view);
            view.setTag(vh);
        } else {
            vh = (ViewHolder) convertView.getTag();
        }

        MyDataModel item = getItem(position);

        vh.textViewName.setText(item.getName());
        vh.textViewEmail.setText(item.getEmail());
        Picasso.with(context).load(item.getImage()).placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(vh.imageView);

        return vh.rootView;
    }

    /**
     * ViewHolder class for layout.<br />
     * <br />
     * Auto-created on 2016-01-05 00:50:26 by Android Layout Finder
     * (http://www.buzzingandroid.com/tools/android-layout-finder)
     */
    private static class ViewHolder {
        public final RelativeLayout rootView;
        public final ImageView imageView;
        public final TextView textViewName;
        public final TextView textViewEmail;

        private ViewHolder(RelativeLayout rootView, ImageView imageView, TextView textViewName, TextView textViewEmail) {
            this.rootView = rootView;
            this.imageView = imageView;
            this.textViewName = textViewName;
            this.textViewEmail = textViewEmail;
        }

        public static ViewHolder create(RelativeLayout rootView) {
            ImageView imageView = (ImageView) rootView.findViewById(R.id.imageView);
            TextView textViewName = (TextView) rootView.findViewById(R.id.textViewName);
            TextView textViewEmail = (TextView) rootView.findViewById(R.id.textViewEmail);
            return new ViewHolder(rootView, imageView, textViewName, textViewEmail);
        }
    }
}