package com.example.musicplayer;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlaySongActivity extends AppCompatActivity {
    private String title = "";
    private String artiste = "";
    private String fileLink = "";
    private int drawable;
    private int currentIndex = -1;

    private MediaPlayer player = new MediaPlayer();
    private Button btnPlayPause = null;
    private SongCollection songCollection = new SongCollection();
    private SongCollection originalSongCollection = new SongCollection();

    List<Song> shuffleList = Arrays.asList(songCollection.songs);


    ImageView repeatBtn;
    ImageView shuffleBtn;
    Boolean repeatFlag = false;
    Boolean shuffleFlag = false;

    SeekBar seekbar;
    Handler handler = new Handler();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_song);
        btnPlayPause = findViewById(R.id.btnPlayPause);
        Bundle songData = this.getIntent().getExtras();
        currentIndex = songData.getInt("index");
        Log.d("temasek", "Retrieved position: " + currentIndex);
        displaySongBasedIndex();
        Log.d("temasek", "Retrieved position: " + currentIndex);
        playSong(fileLink);
        Log.d("temasek", "Retrieved position: " + currentIndex);

        seekbar = findViewById(R.id.seekBar);
        seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
                if (player != null && player.isPlaying()) {
                    player.seekTo(seekBar.getProgress());

                }

            }
        });

        repeatBtn = findViewById(R.id.repeatBtn);
        shuffleBtn = findViewById(R.id.shuffleBtn);

    }

    Runnable p_bar = new Runnable() {
        @Override
        public void run() {
            if (player != null && player.isPlaying()) {
                seekbar.setProgress(player.getCurrentPosition());

            }
            handler.postDelayed(this, 1000);
        }

    };



    public void playNext(View View){
        currentIndex = songCollection.getNextSong (currentIndex);
        Toast.makeText(this, "After Clicking playNext\nthe current index of this song\n " +
                "in the songCollection array is now :" + currentIndex, Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playNext, the index is now :" + currentIndex);
        displaySongBasedIndex();
        playSong(fileLink);
    }

    public void playPrevious(View View){
        currentIndex = songCollection.getPrevSong(currentIndex);
        Toast.makeText(this, "After clicking playPrevious, \nthe current index of this song\n" +
                "in the SongCollection is now :" + currentIndex,Toast.LENGTH_LONG).show();
        Log.d("temasek", "After playPrevious, the indexx is now :" + currentIndex);
        displaySongBasedIndex();
        playSong(fileLink);
    }

    public void playSong(String songUrl){
        try{
            player.reset();
            player.setDataSource(songUrl);
            player.prepare();
            player.start();
            gracefullyStopsWhenMusicEnds();

            btnPlayPause.setText("PAUSE");
            setTitle(title);

        } catch (IOException e){
            e.printStackTrace();
        }
    }

    public void playOrPauseMusic(View View){
        if (player.isPlaying()){ //if player is playing
            player.pause();
            btnPlayPause.setText("Play");
            seekbar.setMax(player.getDuration());
            handler.removeCallbacks(p_bar);
            handler.postDelayed(p_bar, 1000);

        } else {
            player.start();
            btnPlayPause.setText("Pause");
        }
    }


    private void gracefullyStopsWhenMusicEnds(){
        player.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp){
                Toast.makeText(getBaseContext (), "The song had ended and the onCompleteListener is activated\n" +
                        "The button text is changed to 'PLAY' " , Toast.LENGTH_LONG).show();

                if (repeatFlag)
                {
                    playOrPauseMusic(null);

                }else {
                    btnPlayPause.setText("PLAY");
                }

            }

        });

    }

    @Override
    public void onBackPressed(){
        super.onBackPressed();
        handler.removeCallbacks(p_bar);
        player.release();
    }


    public void displaySongBasedIndex(){
        Song song = songCollection.getCurrentSong(currentIndex);
        title = song.getTitle();
        artiste = song.getArtiste();
        fileLink = song.getFileLink();
        drawable = song.getDrawable();
        TextView txtTitle = findViewById(R.id.txtSongTitle);
        txtTitle.setText(title);
        TextView txtArtiste = findViewById(R.id.txtArtist);
        txtArtiste.setText(artiste);
        ImageView iCoverArt = findViewById(R.id.imgCoverArt);
        iCoverArt.setImageResource(drawable);
    }


    public void repeatSong(View view) {

        if (repeatFlag){
            repeatBtn.setBackgroundResource(R.drawable.repeat_off);

        }else
        {
            repeatBtn.setBackgroundResource(R.drawable.repeat_on);
        }
        repeatFlag = !repeatFlag;

    }

    public void shuffleSong(View view) {

        if (shuffleFlag){
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_off);
            songCollection = new SongCollection();

        }else
        {
            shuffleBtn.setBackgroundResource(R.drawable.shuffle_on);
            Collections.shuffle(shuffleList);
            shuffleList.toArray(songCollection.songs);
        }
        shuffleFlag = !shuffleFlag;

    }
}