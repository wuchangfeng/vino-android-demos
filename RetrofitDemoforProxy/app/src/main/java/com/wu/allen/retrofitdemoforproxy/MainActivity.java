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
    private String BASE_URL = "https://api.shanbay.com/";
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
                        .baseUrl(BASE_URL)
                        .addConverterFactory(GsonConverterFactory.create())
                        .build();
                ShanBeiApi shanbei= retrofit.create(ShanBeiApi.class);
                Call<Translation> call = shanbei.listInfos("hello");
                call.enqueue(new Callback<Translation>() {

                    @Override
                    public void onResponse(Call<Translation> call, Response<Translation> response) {
                        //String msg = response.body().getData().getDefinition();
                        //System.out.println(msg);
                        //tvShowinfo.setText(msg);
                        Log.d(TAG,response.body().getData().getDefinition());
                    }

                    @Override
                    public void onFailure(Call<Translation> call, Throwable throwable) {
                        Log.d(TAG,throwable.getMessage());
                    }
                });
            }
        });
    }
}
