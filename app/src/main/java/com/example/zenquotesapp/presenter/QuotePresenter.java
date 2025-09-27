package com.example.zenquotesapp.presenter;

import com.example.zenquotesapp.contract.QuoteContract;
import com.example.zenquotesapp.model.Quote;
import com.example.zenquotesapp.repository.QuoteRepository;
import java.util.List;

public class QuotePresenter implements QuoteContract.Presenter {
    private final QuoteContract.View view;
    private final QuoteRepository repository;

    public QuotePresenter(QuoteContract.View view, QuoteRepository repository) {
        this.view = view;
        this.repository = repository;
    }

    @Override
    public void loadQuotes() {
        view.showLoading();
        repository.getQuotes(new QuoteRepository.Callback() {
            @Override
            public void onSuccess(List<Quote> quotes) {
                view.showQuotes(quotes);
            }
            @Override
            public void onError(Throwable t) {
                view.showError(t.getMessage());
            }
        });
    }

    @Override
    public void onRefresh() {
        loadQuotes();
    }
}

