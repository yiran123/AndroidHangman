package com.example.hangman;

import java.util.Random;

/**
 * Created by yiranpan on 2017/9/28.
 */

public class WordList {
    private static final String[] words = new String[]{"apple", "football", "closet", "chinese", "google"};
    private static final String[] hints = new String[]{"food", "sport", "furniture", "language", "website"};
    private int currentIndex;

    /**
     * calc random ,and not the same as #currentIndex
     * @return
     */
    private int randomIndex() {
        Random random = new Random();
        int i;
        while ((i = random.nextInt(words.length)) != currentIndex) {
            return i;
        }
        return 0;
    }

    /**
     * get a random word
     * @return
     */
    public String getRandomNewWord(){
        currentIndex = randomIndex();
        return words[currentIndex];
    }

    /**
     * get current word
     * @return
     */
    public String getWord(){
        return words[currentIndex];
    }

    /**
     *  get current word hint
     * @return
     */
    public String getHint(){
        return hints[currentIndex];
    }
}
