package com.wu.allen.retrofitdemoforproxy;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {
    public static final String API_URL = "https://api.github.com";
    private static final String TAG = "MainActivity";
    Button btnSearch;
    TextView tvShowinfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnSearch = (Button) findViewById(R.id.btn_search);
        tvShowinfo = (TextView) findViewById(R.id.tv_show);
        // 开始查询
        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(API_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
                GitHubApi github = retrofit.create(GitHubApi.class);
                Call<Repo> call = github.listInfos("wuchangfeng");
                call.enqueue(new Callback<Repo>() {
                    @Override
                    public void onResponse(Call<Repo> call, Response<Repo> response) {
                        Log.d(TAG,response.body().getBlog());
                        tvShowinfo.setText(response.body().getBlog());
                    }

                    @Override
                    public void onFailure(Call<Repo> call, Throwable t) {
                        Log.d(TAG,t.getMessage());
                    }
                });
            }
        });
    }
}
