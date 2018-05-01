package com.kcci.emmi.donasmainview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.HashMap;

public class InfoFragment extends Fragment {
    ArrayList<HashMap<String, String>> tkykPoints;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_info, null);
        tkykPoints = (ArrayList<HashMap<String, String>>) getArguments().getSerializable("tkykPoints");

        return view;
    }
}
