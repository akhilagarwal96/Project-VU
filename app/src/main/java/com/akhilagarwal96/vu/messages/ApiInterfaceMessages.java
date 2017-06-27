package com.akhilagarwal96.vu.messages;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Adm on 27-Jun-17.
 */

public interface ApiInterfaceMessages {

    @FormUrlEncoded
    @POST("/messages")
    Call<DPMessages> postRegNo(@Field("regno") String regno);

    @GET("/messages")
    Call<DPMessages> getMessages();

}
