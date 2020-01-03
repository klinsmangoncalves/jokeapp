package com.udacity.gradle.imageactivity;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class ImageActivityFragment extends Fragment {


    String currentJoke;
    TextView textView;

    public ImageActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_image, container, false);
        textView = view.findViewById(R.id.tv_joke);
        if(currentJoke != null){
            textView.setText(currentJoke);
        }
        return view;
    }

    public String getCurrentJoke() {
        return currentJoke;
    }

    public void setCurrentJoke(String currentJoke) {
        this.currentJoke = currentJoke;
        if(textView != null){
            textView.setText(currentJoke);

        }
    }


}
