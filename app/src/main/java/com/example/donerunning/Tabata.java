package com.example.donerunning;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class Tabata extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        Intent intent = new Intent(getActivity(),tabata_start.class);
        startActivity(intent);

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_tabata, container, false);

    }
}
