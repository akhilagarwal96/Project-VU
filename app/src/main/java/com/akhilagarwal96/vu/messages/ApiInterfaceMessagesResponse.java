package com.akhilagarwal96.vu.messages;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by Adm on 27-Jun-17.
 */

public interface ApiInterfaceMessagesResponse {

    @GET("/messages/regno")
    Call<DPMessages> getMessages();
}
