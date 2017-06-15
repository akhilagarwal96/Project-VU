package com.akhilagarwal96.vu;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.triggertrap.seekarc.SeekArc;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class CgpaCal extends AppCompatActivity {
    private EditText e1, e2, e3, e4, e5, e6;
    private TextView t1;
    private SeekArc mSeekArc;
    private double cgpa;
    private Button b1;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cgpa_cal);

        t1 = (TextView) findViewById(R.id.seekArcProgress);
        mSeekArc = (SeekArc) findViewById(R.id.seekArc);
        e1= (EditText) findViewById(R.id.g1);
        e2 = (EditText) findViewById(R.id.g2);
        e3 = (EditText) findViewById(R.id.g3);
        e4 = (EditText) findViewById(R.id.g4);
        e5 = (EditText) findViewById(R.id.g5);
        e6 = (EditText) findViewById(R.id.g6);
        b1 = (Button) findViewById(R.id.submit);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if( !TextUtils.isEmpty(e1.getText()) &&
                        !TextUtils.isEmpty(e2.getText()) &&
                        !TextUtils.isEmpty(e3.getText()) &&
                        !TextUtils.isEmpty(e4.getText()) &&
                        !TextUtils.isEmpty(e5.getText()) &&
                        !TextUtils.isEmpty(e6.getText())){

                    int s_count = 0;
                    int a_count = 0;
                    int b_count = 0;
                    int c_count = 0;
                    int d_count = 0;
                    int e_count = 0;
                    int f_count = 0;

                    final String g1 = e1.getText().toString();
                    final String g2 = e2.getText().toString();
                    final String g3 = e3.getText().toString();
                    final String g4 = e4.getText().toString();
                    final String g5 = e5.getText().toString();
                    final String g6 = e6.getText().toString();

                    final List<String> list = new ArrayList<>();

                    list.add(g1);
                    list.add(g2);
                    list.add(g3);
                    list.add(g4);
                    list.add(g5);
                    list.add(g6);

                    for(int i = 0; i<6; i++) {
                        if (Objects.equals(list.get(i), "S")) {
                            s_count++;
                        }
                        if (Objects.equals(list.get(i), "A")) {
                            a_count++;
                        }
                        if (Objects.equals(list.get(i), "B")) {
                            b_count++;
                        }
                        if (Objects.equals(list.get(i), "C")) {
                            c_count++;
                        }
                        if (Objects.equals(list.get(i), "D")) {
                            d_count++;
                        }
                        if (Objects.equals(list.get(i), "E")) {
                            e_count++;
                        }
                        if (Objects.equals(list.get(i), "F")) {
                            f_count++;
                        }
                    }
                    cgpa = (((s_count * 10) + (a_count * 9) + (b_count * 8) + (c_count * 7) + (d_count * 6) + (e_count * 5) + (f_count * 4)) / 6.0);
                    t1.setText(String.format("%.2f", cgpa) + " / 10.00");
                    int percent = (int) (cgpa*10);
                    mSeekArc.setProgress(percent);
                }else{
                    Toast.makeText(getApplicationContext(), "Please Fill in the required details", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
