package com.akhilagarwal96.vu;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

    /**
     * Created by Adm on 03-Jun-17.
     */

    public class Nav_Draw extends Fragment {
        private ActionBarDrawerToggle mDrawerToggle;
        private DrawerLayout mDrawerLayout;
        private boolean mUserLearnedDrawer;
        private boolean mFromSavedInstanceState;
        private static final String shared_pref_file_name = "";
        public static String key_user_learned = "";
        private View containerView;
        RecyclerView recyclerView;
        RecyclerAdapter recyclerAdapter;


        public Nav_Draw() {
            // Required empty public constructor
        }

        public void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            mUserLearnedDrawer = Boolean.valueOf(readFromPreferences(getActivity(), key_user_learned, "false"));

        }

        public List<Info> getData() {
            List<Info> data = new ArrayList<Info>();


            String[] titles = {"Home", "Messages", "Attendance", "Timetable", "Marks", "Hostel", "Exchange", "Grades", "Calendar", "Profile" };

            for (int i = 0; i < titles.length ; i++) {

                Info current = new Info();

                current.title = titles[i];
                data.add(current);
            }
            return data;
        }


        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            // Inflate the layout for this fragment
            View layout= inflater.inflate(R.layout.fragment_nav__draw, container, false);
            recyclerView = (RecyclerView) layout.findViewById(R.id.rec_view);
            recyclerAdapter = new RecyclerAdapter(getActivity(), getData());
            recyclerView.setAdapter(recyclerAdapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
            return layout;
        }

        public void setUp(int fragId, DrawerLayout drawerLayout, Toolbar toolbar) {
            containerView = getActivity().findViewById(fragId);
            mDrawerLayout = drawerLayout;
            mDrawerToggle = new ActionBarDrawerToggle(getActivity(), drawerLayout, toolbar, R.string.Open, R.string.Close) {
                @Override
                public void onDrawerOpened(View drawerView) {
                    super.onDrawerOpened(drawerView);
                    if (!mUserLearnedDrawer) {
                        mUserLearnedDrawer = true;
                        savedToPreferences(getActivity(), key_user_learned, mUserLearnedDrawer + "");
                    }
                    getActivity().invalidateOptionsMenu();

                }


                @Override
                public void onDrawerClosed(View drawerView) {
                    super.onDrawerClosed(drawerView);
                }
            };
            if (!mUserLearnedDrawer && !mFromSavedInstanceState) {
                mDrawerLayout.openDrawer(containerView);
            }
            mDrawerLayout.addDrawerListener(mDrawerToggle);
            mDrawerLayout.post(new Runnable() {
                @Override
                public void run() {
                    mDrawerToggle.syncState();
                }
            });
        }

        public static void savedToPreferences(Context context, String preferenceName, String preferenceValue) {

            SharedPreferences sharedPreferences = context.getSharedPreferences(shared_pref_file_name, Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString(preferenceName, preferenceValue);
            editor.commit();
        }

        public static String readFromPreferences(Context context, String preferenceName, String defaultValue) {
            SharedPreferences sharedPreferences = context.getSharedPreferences(shared_pref_file_name, Context.MODE_PRIVATE);
            return sharedPreferences.getString(preferenceName, defaultValue);
        }

    }
