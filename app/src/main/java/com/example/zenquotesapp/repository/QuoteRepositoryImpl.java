package com.example.zenquotesapp.repository;

import com.example.zenquotesapp.api.ApiClient;
import com.example.zenquotesapp.model.Quote;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuoteRepositoryImpl implements QuoteRepository {
    @Override
    public void getQuotes(QuoteRepository.Callback callback) {
        ApiClient.getApi().getRandomQuotes().enqueue(new retrofit2.Callback<List<Quote>>() {
            @Override
            public void onResponse(retrofit2.Call<List<Quote>> call, retrofit2.Response<List<Quote>> response) {
                if (response.isSuccessful() && response.body() != null) {
                    callback.onSuccess(response.body());
                } else {
                    callback.onError(new Exception("Respuesta inválida de la API"));
                }
            }
            @Override
            public void onFailure(retrofit2.Call<List<Quote>> call, Throwable t) {
                callback.onError(t);
            }
        });
    }
}
