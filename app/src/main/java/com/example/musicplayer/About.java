package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class About extends AppCompatActivity {

    // List View object
    ListView listView;

    // Define array adapter for ListView
    ArrayAdapter<String> adapter;

    // Define array List for List View data
    ArrayList<String> mylist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // Initialize and assign variable
        BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

        // Set Home selected
        bottomNavigationView.setSelectedItemId(R.id.about);

        // Perform item selected listener
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch(item.getItemId())
                {
                    case R.id.dashboard:
                        startActivity(new Intent(getApplicationContext(),Dashboard.class));
                        overridePendingTransition(0,0);
                        return true;
                    case R.id.about:
                        return true;
                    case R.id.home:
                        startActivity(new Intent(getApplicationContext(),MainActivity.class));
                        overridePendingTransition(0,0);
                        return true;
                }
                return false;
            }
        });



            // initialise ListView with id
            listView = findViewById(R.id.listView);

            // Add items to Array List
            mylist = new ArrayList<>();
            mylist.add("The Way You Look Tonight");
            mylist.add("Billie Jean");
            mylist.add("Cry A River");
            mylist.add("Late Night Talking");
            mylist.add("Let Me");
            mylist.add("Celia");
            mylist.add("Scream");
            mylist.add("Dangerous");
            mylist.add("Xscape");
            mylist.add("Snowman");
            mylist.add("Girlfriend");
            mylist.add("Calamity");

            // Set adapter to ListView
            adapter
                    = new ArrayAdapter<String>(
                    this,
                    android.R.layout.simple_list_item_1,
                    mylist);
            listView.setAdapter(adapter);
        }

        @Override
        public boolean onCreateOptionsMenu(Menu menu)
        {
            // Inflate menu with items using MenuInflator
            MenuInflater inflater = getMenuInflater();
            inflater.inflate(R.menu.menu, menu);

            // Initialise menu item search bar
            // with id and take its object
            MenuItem searchViewItem = menu.findItem(R.id.search_bar);
            SearchView searchView = (SearchView) MenuItemCompat.getActionView(searchViewItem);

            // attach setOnQueryTextListener
            // to search view defined above
            searchView.setOnQueryTextListener(
                    new SearchView.OnQueryTextListener() {

                        // Override onQueryTextSubmit method
                        // which is call
                        // when submitquery is searched

                        @Override
                        public boolean onQueryTextSubmit(String query)
                        {
                            // If the list contains the search query
                            // than filter the adapter
                            // using the filter method
                            // with the query as its argument
                            if (mylist.contains(query)) {
                                adapter.getFilter().filter(query);
                            }
                            else {
                                // Search query not found in List View
                                Toast
                                        .makeText(About.this, "Not found",
                                                Toast.LENGTH_LONG)
                                        .show();
                            }
                            return false;
                        }

                        // This method is overridden to filter
                        // the adapter according to a search query
                        // when the user is typing search
                        @Override
                        public boolean onQueryTextChange(String newText)
                        {
                            adapter.getFilter().filter(newText);
                            return false;
                        }
                    });

            return super.onCreateOptionsMenu(menu);
        }

    }

