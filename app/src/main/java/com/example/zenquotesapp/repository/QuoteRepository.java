package com.example.zenquotesapp.repository;

import com.example.zenquotesapp.model.Quote;
import java.util.List;

public interface QuoteRepository {
    void getQuotes(Callback callback);

    interface Callback {
        void onSuccess(List<Quote> quotes);
        void onError(Throwable t);
    }
}

