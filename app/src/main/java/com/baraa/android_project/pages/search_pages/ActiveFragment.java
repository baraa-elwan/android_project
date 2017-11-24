package com.baraa.android_project.pages.search_pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baraa.android_project.R;


public class ActiveFragment extends Fragment {


    public ActiveFragment() {
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_active, container, false);
        setHasOptionsMenu(true);

        return rootView;
    }





}