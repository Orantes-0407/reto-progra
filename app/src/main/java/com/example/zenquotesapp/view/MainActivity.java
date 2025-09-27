package com.example.zenquotesapp.view;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Toast;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;
import com.example.zenquotesapp.R;
import com.example.zenquotesapp.adapter.QuotesAdapter;
import com.example.zenquotesapp.contract.QuoteContract;
import com.example.zenquotesapp.model.Quote;
import com.example.zenquotesapp.presenter.QuotePresenter;
import com.example.zenquotesapp.repository.QuoteRepositoryImpl;
import java.util.List;

public class MainActivity extends AppCompatActivity implements QuoteContract.View {
    private QuotesAdapter adapter;
    private SwipeRefreshLayout swipeRefreshLayout;
    private QuotePresenter presenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView recyclerView = findViewById(R.id.recyclerQuotes);
        swipeRefreshLayout = findViewById(R.id.swipeRefresh);
        adapter = new QuotesAdapter();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        presenter = new QuotePresenter(this, new QuoteRepositoryImpl());
        swipeRefreshLayout.setOnRefreshListener(() -> presenter.onRefresh());
        presenter.loadQuotes();
    }

    @Override
    public void showLoading() {
        swipeRefreshLayout.setRefreshing(true);
    }

    @Override
    public void showQuotes(List<Quote> quotes) {
        swipeRefreshLayout.setRefreshing(false);
        adapter.setQuotes(quotes);
    }

    @Override
    public void showError(String message) {
        swipeRefreshLayout.setRefreshing(false);
        Toast.makeText(this, message, Toast.LENGTH_SHORT).show();
        Log.e("MainActivity", message);
    }
}

