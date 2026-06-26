package com.example.mybookcatalog;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public class BookDetailActivity extends AppCompatActivity {

    public static final String EXTRA_BOOK = "extra_book";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_detail);

        Book book = (Book) getIntent().getSerializableExtra(EXTRA_BOOK);

        if (book != null) {
            ImageView imageViewCover = findViewById(R.id.imageViewDetailCover);
            TextView textViewTitle = findViewById(R.id.textViewDetailTitle);
            TextView textViewAuthor = findViewById(R.id.textViewDetailAuthor);
            TextView textViewGenre = findViewById(R.id.textViewDetailGenre);
            TextView textViewChapters = findViewById(R.id.textViewDetailChapters);
            TextView textViewDescription = findViewById(R.id.textViewDetailDescription);
            TextView textViewPreview = findViewById(R.id.textViewDetailPreview);

            imageViewCover.setImageResource(book.getCoverImageResId());
            textViewTitle.setText(book.getTitle());
            textViewAuthor.setText(String.format("By %s", book.getAuthor()));
            textViewGenre.setText(String.format("Genre: %s", book.getGenre()));
            textViewChapters.setText(String.format(Locale.getDefault(), "Chapters: %d", book.getNumChapters()));
            textViewDescription.setText(book.getDescription());
            textViewPreview.setText(book.getPreviewChapters());
        }
    }
}
