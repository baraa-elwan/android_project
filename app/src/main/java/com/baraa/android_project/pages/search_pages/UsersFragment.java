package com.baraa.android_project.pages.search_pages;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.baraa.android_project.R;


public class UsersFragment extends Fragment {


    RecyclerView users_rv;

    public UsersFragment() {
    }




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_users, container, false);
        setHasOptionsMenu(true);

        users_rv = (RecyclerView) rootView.findViewById(R.id.rv_users);

        return rootView;
    }





}