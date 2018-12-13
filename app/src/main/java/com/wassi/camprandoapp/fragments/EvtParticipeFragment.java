package com.wassi.camprandoapp.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wassi.camprandoapp.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class EvtParticipeFragment extends Fragment {
private RecyclerView rv_evt_part;

    public EvtParticipeFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_evt_participe, container, false);
    }
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        rv_evt_part= getView().findViewById(R.id.rv_evt_part);
    }

}
