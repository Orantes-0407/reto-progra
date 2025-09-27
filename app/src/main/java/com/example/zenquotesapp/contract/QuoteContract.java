package com.example.zenquotesapp.contract;

import com.example.zenquotesapp.model.Quote;
import java.util.List;

public interface QuoteContract {
    interface View {
        void showLoading();
        void showQuotes(List<Quote> quotes);
        void showError(String message);
    }
    interface Presenter {
        void loadQuotes();
        void onRefresh();
    }
}

