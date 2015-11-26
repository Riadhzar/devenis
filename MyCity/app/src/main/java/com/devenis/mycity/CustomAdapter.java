package com.devenis.mycity;
import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomAdapter extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] web;
    private final Integer[] imageId;
    public CustomAdapter(Activity context,
                         String[] web, Integer[] imageId) {
        super(context, R.layout.liste, web);
        this.context = context;
        this.web = web;
        this.imageId = imageId;

    }
    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView= inflater.inflate(R.layout.liste, null, true);
        TextView txtTitle = (TextView) rowView.findViewById(R.id.txt);

        ImageView imageView = (ImageView) rowView.findViewById(R.id.img);
        txtTitle.setText(web[position]);
        imageView.setImageResource(imageId[position]);
        return rowView;
    }    /*public CustomAdapter(Context context,String[] name) {
        super(context,R.layout.activity_accommodation ,name);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = LayoutInflater.from(getContext());
        View customView =inflater.inflate(R.layout.activity_accommodation, parent, false);
        String str = getItem(position);
        TextView text = (TextView) customView.findViewById(R.id.textView);
        ImageView image = (ImageView) customView.findViewById(R.id.imageView);
        text.setText(str);
        return customView;
    }*/
}
