package com.example.zenquotesapp.api;

import com.example.zenquotesapp.model.Quote;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ZenQuotesApi {
    @GET("random")
    Call<List<Quote>> getRandomQuotes();
}

