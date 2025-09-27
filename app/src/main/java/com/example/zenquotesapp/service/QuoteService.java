package com.example.zenquotesapp.service;

// Servicio para lógica adicional, por ejemplo, caché en memoria
import com.example.zenquotesapp.model.Quote;
import java.util.List;

public class QuoteService {
    private List<Quote> cache;

    public void saveToCache(List<Quote> quotes) {
        this.cache = quotes;
    }

    public List<Quote> getCache() {
        return cache;
    }
}

