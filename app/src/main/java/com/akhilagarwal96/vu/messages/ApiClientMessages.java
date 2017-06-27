package com.akhilagarwal96.vu.messages;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Adm on 27-Jun-17.
 */

public class ApiClientMessages {

    private static final String BASE_URL = "https://young-ravine-50082.herokuapp.com";

    public static Retrofit retrofit = null;

    public static Retrofit getClient() {
        if (retrofit == null) {
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build();
        }
        return retrofit;
    }
}
