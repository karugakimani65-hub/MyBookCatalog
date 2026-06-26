package com.example.mybookcatalog;

import android.content.Intent;
import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements BookAdapter.OnBookClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerViewBooks);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<Book> bookList = new ArrayList<>();
        bookList.add(new Book("The Last Ember", "Daniel Roth", "A former archaeologist is pulled into a deadly conspiracy when ancient secrets buried beneath Rome resurface.", "Historical Thriller", 128, R.drawable.the_last_ember, 
                "Chapter 1: The Ash\nChapter 2: Beneath the Forum\nChapter 3: The Silent Guardian"));
        bookList.add(new Book("Quantum Mirage", "Lila Chen", "In a future where time travel is illegal, a rogue physicist must choose between saving the world or saving her daughter.", "Science Fiction", 134, R.drawable.quantum_mirage,
                "Chapter 1: Zero Hour\nChapter 2: The Chronos Leak\nChapter 3: Echoes of Tomorrow"));
        bookList.add(new Book("Roots & Wings", "Maria Esteban", "A moving generational story of a Cuban-American family searching for identity, belonging, and redemption.", "Literary Fiction", 122, R.drawable.roots_and_wings,
                "Chapter 1: The Shore\nChapter 2: Letters from Havana\nChapter 3: The Flight"));
        bookList.add(new Book("The Mind Sculptor", "Dr. Evan Shaw", "A groundbreaking look at neuroplasticity and how you can rewire your brain for success and happiness.", "Psychology / Non-Fiction", 115, R.drawable.the_mind_sculptor,
                "Chapter 1: The Plastic Brain\nChapter 2: Habits of Thought\nChapter 3: The Architecture of Joy"));
        bookList.add(new Book("Inkbound: Chronicles of the Lost Library", "J.R. Faulkner", "A young librarian discovers that ancient books can open portals to other worlds—but not all stories have happy endings.", "Fantasy / Adventure", 142, R.drawable.inkbound,
                "Chapter 1: Dust and Dreams\nChapter 2: The Whispering Shelf\nChapter 3: The First Portal"));
        bookList.add(new Book("Startup Savage", "Nicole Vega", "A brutally honest guide to launching a tech startup in the real world, full of failures, pivots, and unexpected wins.", "Business / Entrepreneurship", 112, R.drawable.startup_savage,
                "Chapter 1: The Garage Days\nChapter 2: Venture Capital Vultures\nChapter 3: The Pivot"));
        bookList.add(new Book("Beneath Crimson Skies", "Tomasz Novak", "The intertwined lives of resistance fighters, spies, and survivors during the Nazi occupation of Warsaw.", "Historical Fiction / WWII", 131, R.drawable.beneath_crimson_skies,
                "Chapter 1: Shadows in Warsaw\nChapter 2: The Resistance Begins\nChapter 3: A Bridge Too Far"));
        bookList.add(new Book("The Art of Stillness", "Tara Bell", "Learn how to find peace in a chaotic world by mastering the ancient wisdom of stillness.", "Self-Help / Mindfulness", 110, R.drawable.the_art_of_stillness,
                "Chapter 1: Finding the Quiet\nChapter 2: The Power of Breath\nChapter 3: Living in the Now"));
        bookList.add(new Book("Neon Ghosts", "Khalid Jones", "A private investigator with the ability to see spirits uncovers a supernatural conspiracy beneath the city's neon lights.", "Urban Fantasy / Mystery", 126, R.drawable.neon_ghosts,
                "Chapter 1: Rainy Nights\nChapter 2: The Spectral Client\nChapter 3: Neon Blood"));
        bookList.add(new Book("Eat Green, Live Clean", "Dr. Sanjay Patel", "A practical guide to plant-based nutrition and detox living, backed by science and easy recipes.", "Health & Wellness", 118, R.drawable.eat_green_live_clean,
                "Chapter 1: Why Plants?\nChapter 2: The Detox Myth\nChapter 3: Your New Pantry"));

        BookAdapter adapter = new BookAdapter(bookList, this);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onBookClick(Book book) {
        Intent intent = new Intent(this, BookDetailActivity.class);
        intent.putExtra(BookDetailActivity.EXTRA_BOOK, book);
        startActivity(intent);
    }
}
