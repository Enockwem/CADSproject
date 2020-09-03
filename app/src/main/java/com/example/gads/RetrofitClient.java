package com.example.gads;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {
    private static Retrofit retrofit;

    // Then i define the base URL
    private static final String BASE_URL = "https://gadsapi.herokuapp.com/";

    // Creating the retrofit instance

    public static Retrofit getRetrofitInstance(){
        if (retrofit == null){
            retrofit = new retrofit2.Retrofit.Builder ().baseUrl (BASE_URL)
                    // Adding the converter
                    .addConverterFactory (GsonConverterFactory.create ())
                    // Build the retrofit instance
            .build ();
        }
        return retrofit;
    }
}
