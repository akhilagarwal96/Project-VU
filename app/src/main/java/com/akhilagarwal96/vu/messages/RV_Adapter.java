package com.akhilagarwal96.vu.messages;

/**
 * Created by Adm on 27-Jun-17.
 */

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.akhilagarwal96.vu.R;

import java.util.ArrayList;

public class RV_Adapter extends RecyclerView.Adapter<RV_Adapter.MyViewHolder>{

    private ArrayList<DPMessages> dpMessagesArrayList = new ArrayList<>();

    public RV_Adapter(ArrayList<DPMessages> dpMessagesArrayList) {
        this.dpMessagesArrayList = dpMessagesArrayList;
    }
/*
    public RV_Adapter(List<Response> responses) {
        this.responses = responses;
    }
*/

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.row_messages, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.u.setText(dpMessagesArrayList.get(position).getFaculty_name());
        holder.i.setText(dpMessagesArrayList.get(position).getFaculty_messages());

    }

    @Override
    public int getItemCount() {
        if (dpMessagesArrayList == null) {
            return 0;
        }
        return dpMessagesArrayList.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {

        TextView u,i,t,b;

        public MyViewHolder(View itemView) {
            super(itemView);

            u = (TextView) itemView.findViewById(R.id.faculty_name);
            i = (TextView) itemView.findViewById(R.id.faculty_message);

        }
    }

}
