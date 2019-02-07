package com.boss.cuncis.footballschedule.fragment.team;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.boss.cuncis.footballschedule.R;


/**
 * A simple {@link Fragment} subclass.
 */
public class TeamFragment extends Fragment {


    public TeamFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_team, container, false);
        return view;
    }

}
