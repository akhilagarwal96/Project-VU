package com.akhilagarwal96.vu;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class Upcoming extends Fragment {

    Button attend;

    @InjectView(R.id.miss_button)
    Button miss;

    // @InjectView(R.id.attend_count)
    TextView attend_count;

    @InjectView(R.id.miss_count)
    TextView miss_count;

    public Upcoming() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view= inflater.inflate(R.layout.fragment_upcoming, container, false);

        ButterKnife.inject(view);

        attend_count = (TextView) view.findViewById(R.id.attend_count);

        attend = (Button) view.findViewById(R.id.attend_button);
        attend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                attend_count.setText("Checking");
            }
        });
        return view;
    }

}

