package com.example.musicplayer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.MenuItemCompat;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.gson.Gson;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    SongCollection songCollection = new SongCollection();
    static ArrayList<Song> favList = new ArrayList<Song>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);




            // Initialize and assign variable
            BottomNavigationView bottomNavigationView=findViewById(R.id.bottom_navigation);

            // Set Home selected
            bottomNavigationView.setSelectedItemId(R.id.home);

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
                        case R.id.home:
                            return true;
                        case R.id.about:
                            startActivity(new Intent(getApplicationContext(),About.class));
                            overridePendingTransition(0,0);
                            return true;
                    }
                    return false;
                }
            });

        }



        public void handleSelection (View myView){
            String resourceId = getResources().getResourceEntryName(myView.getId());
            int currentArrayIndex = songCollection.searchSongById(resourceId);
            Log.d("temasek", "The index in the array for this song is :" + currentArrayIndex);
            sendDataToActivity(currentArrayIndex);
        }
        public void sendDataToActivity ( int index){
            Intent intent = new Intent(this, PlaySongActivity.class);
            intent.putExtra("index", index);
            startActivity(intent);
        }


    public void addToFavorite(View view) {

        String songID = view.getContentDescription().toString();
        Song song = songCollection.searchById(songID);
        Toast.makeText(this, "Added to playlist", Toast.LENGTH_SHORT).show();
        favList.add(song);



    }

    public void goToFavorite (View view){
       // for (int i = 0; i < favList.size(); i++){
       //     Log.d("temasek", favList.get(i).getTitle());
       // }

        Intent intent = new Intent(this, Dashboard.class);
        startActivity(intent);
    }
}



