package com.example.gamenet.locationingooglemap;

import android.app.Activity;
import android.app.Dialog;
import android.graphics.Bitmap;
import android.graphics.drawable.ColorDrawable;
import android.view.View;
import android.view.Window;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;

/**
 * Created by GameNet on 3/20/2017.
 */

public class MyInfoWindowAdapter implements GoogleMap.InfoWindowAdapter{


    private Dialog alertDialog;
    private TextView tv1,tv2;

    private Activity context;
    public MyInfoWindowAdapter(Activity context)
    {
        this.context=context;
    }
    @Override
    public View getInfoContents(Marker arg0) {
// Getting view from the layout file info_window_layout
        View v = this.context.getLayoutInflater().inflate(R.layout.custom_info, null);

// Getting the position from the marker
        LatLng latLng = arg0.getPosition();

// Getting reference to the TextView to set latitude
        TextView tvLat = (TextView) v.findViewById(R.id.tv_lat);

// Getting reference to the TextView to set longitude
        TextView tvLng = (TextView) v.findViewById(R.id.tv_lng);

        TextView tvTitle = (TextView) v.findViewById(R.id.tv_title);

        TextView tvSnippet = (TextView) v.findViewById(R.id.tv_snippet);

// Setting the latitude
        tvLat.setText("Latitude:" + latLng.latitude);

// Setting the longitude
        tvLng.setText("Longitude:"+ latLng.longitude);

        tvTitle.setText(arg0.getTitle());
        tvSnippet.setText(arg0.getSnippet());
        return v;
    }

    @Override
    public View getInfoWindow(Marker arg0) {

        return null;
    }

}