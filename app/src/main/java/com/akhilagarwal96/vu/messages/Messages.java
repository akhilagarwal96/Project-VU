package com.akhilagarwal96.vu.messages;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.akhilagarwal96.vu.R;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Messages extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager layoutManager;
    private RecyclerView.Adapter adapter;
    private ArrayList<DPMessages> dpMessagesList;

    String regnumber = "15BCE0405";

    ApiInterfaceMessages apiInterfaceMessages;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_messages);

        recyclerView = (RecyclerView) findViewById(R.id.rv_messages);
        layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        apiInterfaceMessages = ApiClientMessages.getClient().create(ApiInterfaceMessages.class);

        Call<DPMessages> call1 = apiInterfaceMessages.postRegNo(regnumber);

        call1.enqueue(new Callback<DPMessages>() {
            @Override
            public void onResponse(Call<DPMessages> call, Response<DPMessages> response) {

                Call<DPMessages> call2 = apiInterfaceMessages.getMessages();
                call2.enqueue(new Callback<DPMessages>() {
                    @Override
                    public void onResponse(Call<DPMessages> call, Response<DPMessages> response) {
                        Log.d("Success","Success");
                        dpMessagesList = new ArrayList<DPMessages>();
                        dpMessagesList.add(response.body());


                        adapter = new RV_Adapter(dpMessagesList);
                        recyclerView.setAdapter(adapter);
                    }

                    @Override
                    public void onFailure(Call<DPMessages> call, Throwable t) {

                        Log.d("Failed","Failed");
                    }
                });
            }

            @Override
            public void onFailure(Call<DPMessages> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
