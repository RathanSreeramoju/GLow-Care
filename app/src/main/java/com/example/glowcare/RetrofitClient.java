package com.example.glowcare;
import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;

import retrofit2.Retrofit;
import retrofit2.converter.scalars.ScalarsConverterFactory;
public class RetrofitClient {
    public static final String BASE_URL = "http://192.168.2.75:5000";
    public static Retrofit retrofit = null;

    /**
     * @return retrofit instance with an connection else return the error if the connection is unsuccessful.
     */
    public static Retrofit getApiClient() {

        if (retrofit == null) {


            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(ScalarsConverterFactory.create())
                    .build();

        }
        return retrofit;

    }
}
