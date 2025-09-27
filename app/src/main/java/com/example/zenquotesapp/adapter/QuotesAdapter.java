package com.example.zenquotesapp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.example.zenquotesapp.R;
import com.example.zenquotesapp.model.Quote;
import java.util.ArrayList;
import java.util.List;

public class QuotesAdapter extends RecyclerView.Adapter<QuotesAdapter.QuoteViewHolder> {
    private final List<Quote> quotes = new ArrayList<>();

    public void setQuotes(List<Quote> newQuotes) {
        quotes.clear();
        quotes.addAll(newQuotes);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public QuoteViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        return new QuoteViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull QuoteViewHolder holder, int position) {
        Quote quote = quotes.get(position);
        holder.textQuote.setText(quote.getQ());
        holder.textAuthor.setText(quote.getA());
    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    static class QuoteViewHolder extends RecyclerView.ViewHolder {
        TextView textQuote, textAuthor;
        QuoteViewHolder(View itemView) {
            super(itemView);
            textQuote = itemView.findViewById(R.id.textQuote);
            textAuthor = itemView.findViewById(R.id.textAuthor);
        }
    }
}
