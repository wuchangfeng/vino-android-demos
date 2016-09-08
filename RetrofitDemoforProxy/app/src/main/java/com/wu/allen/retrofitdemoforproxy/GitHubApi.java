package com.wu.allen.retrofitdemoforproxy;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by allen on 2016/9/8.
 */

public interface GitHubApi {

    @GET("users/{user}")
    Call<Repo> listInfos(@Path("user") String user);
}
