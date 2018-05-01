package com.kcci.emmi.donasmainview;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.Toast;


public class MenuFragment extends Fragment {
    View.OnClickListener ocl = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(
                    getContext(), "오픈 준비 중입니다", Toast.LENGTH_SHORT).show();
        }
    };

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_menu, container, false);

        LinearLayout ddeok = v.findViewById(R.id.ddeok);
        ddeok.setOnClickListener(ocl);

        LinearLayout odeng = v.findViewById(R.id.odeng);
        odeng.setOnClickListener(ocl);

        LinearLayout gun = v.findViewById(R.id.gun);
        gun.setOnClickListener(ocl);

        LinearLayout bad = v.findViewById(R.id.bad);
        bad.setOnClickListener(ocl);

        LinearLayout boong = v.findViewById(R.id.boong);
        boong.setOnClickListener(ocl);

        LinearLayout other = v.findViewById(R.id.other);
        other.setOnClickListener(ocl);

        LinearLayout ho = v.findViewById(R.id.ho);
        ho.setOnClickListener(ocl);

        LinearLayout hot = v.findViewById(R.id.hot);
        hot.setOnClickListener(ocl);

        return v;
    }
}
