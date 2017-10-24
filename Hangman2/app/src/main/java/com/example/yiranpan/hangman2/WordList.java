package com.example.yiranpan.hangman2;

import java.util.Random;

/**
 * Created by yiranpan on 10/20/17.
 */

public class WordList {

    //Create WordsList and HintsList
    private static final String[] words = new String[]{"apple", "football","closet", "chinese", "google"};
    private static final String[] hints = new String[]{"fruit", "sport","furniture", "language", "search engine"};
    private int currentIndex;


    //get a random next word, not the same as current one
    private int randomIndex() {
        Random random = new Random();
        int i;
        while ((i = random.nextInt(words.length)) != currentIndex) {
            return i;
        }
        return 0;
    }

    //get a random current word
    public String getRandomNewWord() {
        currentIndex = randomIndex();
        return words[currentIndex];
    }

    public String getWord() {
        return words[currentIndex];
    }

    public String getHint() {
        return hints[currentIndex];
    }


}
