package com.example.musicplayer;

import android.icu.text.AlphabeticIndex;

public class SongCollection {

    public Song songs[] = new Song[12];


    public SongCollection(){

        Song theWayYouLookTonight = new Song( "S1001",
                "1.The Way You Look Tonight",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/b4893d249495bdad00828e6f0059b7e7d762da07?cid=2afe87a64b0042dabf51f37318616965",
                4.66,
                R.drawable.michael_buble_collection);

        Song billieJean = new Song ("S1002",
                "Billie Jean",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/6bc16eec6d10da63a03860070cf6d625936d68f2?cid=2afe87a64b0042dabf51f37318616965",
                4.9,
                R.drawable.billie_jean);

        Song cryARiver = new Song("S1003",
                "Cry a river",
                "Michael Buble",
                "https://p.scdn.co/mp3-preview/778ed9d47563b43c6b53405bc59dcf71f243e5a3?cid=2afe87a64b0042dabf51f37318616965",
                4.25,
                R.drawable.cry_me_a_river);

        Song lateNightTalking = new Song("S1004",
                "Late Night Talking",
                "Harry Styles",
                "https://p.scdn.co/mp3-preview/ab3568a72e1c016308c263854dc307251ce33a2b?cid=2afe87a64b0042dabf51f37318616965",
                2.97,
                R.drawable.late_night_talking);

        Song letMe = new Song("S1005",
                "Let Me",
                "Zayn Malik",
                "https://p.scdn.co/mp3-preview/68226ec377af584e49fb492034a7f622cc74e45a?cid=2afe87a64b0042dabf51f37318616965",
                3.09,
                R.drawable.let_me);

        Song celia = new Song("S1006",
                "Celia",
                "Camila Cabello",
                "https://p.scdn.co/mp3-preview/fe1a8367ecc033703a84a39deba6183b7cf73eb3?cid=2afe87a64b0042dabf51f37318616965",
                2.55,
                R.drawable.celia);

        Song scream = new Song("S10010",
                "Scream",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/c7263de9ccebf4310a1d170be725392e0248de1e?cid=2afe87a64b0042dabf51f37318616965",
                4.63,
                R.drawable.scream);

        Song dangerous = new Song("S10011",
                "Dangerous",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/5b1d0cc10084531bf6a0dd1e152d50b99c916fba?cid=2afe87a64b0042dabf51f37318616965",
                6.98,
                R.drawable.dangerous);

        Song xscape = new Song("S10012",
                "Xscape",
                "Michael Jackson",
                "https://p.scdn.co/mp3-preview/f6fecd5f162404781646ce1596777285757c395b?cid=2afe87a64b0042dabf51f37318616965",
                4.09,
                R.drawable.xscape);

        Song snowman = new Song("S10013",
                "Snowman",
                "Sia",
                "https://p.scdn.co/mp3-preview/c711b25bded61e014729e1037c087938d97bc46b?cid=2afe87a64b0042dabf51f37318616965",
                2.77,
                R.drawable.snowman);

        Song girlfriend = new Song("S10014",
                "Girlfriend",
                "Dixie",
                "https://p.scdn.co/mp3-preview/fb6711d92e4e56555b8175390f4fb8ea12d0456c?cid=2afe87a64b0042dabf51f37318616965",
                3.08,
                R.drawable.girlfriend);

        Song calamity = new Song("S10015",
                "Calamity",
                "Zayn Malik",
                "https://p.scdn.co/mp3-preview/777c3da18e71105416beb9243ce8b8df85d9823a?cid=2afe87a64b0042dabf51f37318616965",
                3.13,
                R.drawable.calamity);

        songs[0] = theWayYouLookTonight;
        songs[1] = billieJean;
        songs[2] = cryARiver;
        songs[3] = lateNightTalking;
        songs[4] = letMe;
        songs[5] = celia;
        songs[6] = scream;
        songs[7] = dangerous;
        songs[8] = xscape;
        songs[9] = snowman;
        songs[10] = girlfriend;
        songs[11] = calamity;


    }



    public Song getCurrentSong(int currentSongId){

        return songs[currentSongId];
    }

    public int searchSongById(String id) {
        for (int index = 0; index < songs.length; index++) {
            Song tempSong = songs[index];
            if (tempSong.getId().equals(id)) {
                return index;
            }

        }
        return -1;
    }

    public int getNextSong(int currentSongIndex){
        if (currentSongIndex >= songs.length - 1){
            return currentSongIndex;
        }
        else {
            return currentSongIndex +1;
        }
    }

    public int getPrevSong(int currentSongIndex){
        if (currentSongIndex <= 0){
            return currentSongIndex;
        }
        else{
            return currentSongIndex - 1;
        }
    }

    public Song searchById(String id){
        Song tempSong = null;
        for (int i = 0; i < songs.length; i++) {
            tempSong = songs[i];
            String tempId = tempSong.getId();
            if (tempId.equals(id)){
                return tempSong;
            }
        }
        return tempSong;
    }

}

