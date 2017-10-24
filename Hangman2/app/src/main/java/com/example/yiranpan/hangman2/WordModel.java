package com.example.yiranpan.hangman2;

import android.os.Bundle;

/**
 * Created by yiranpan on 10/20/17.
 */

public class WordModel {
    private WordList wordList;
    private String currentWord;
    private String currentHint;
    private char[] guessWord;
    private int errorTimes;
    private static final int MAX_ERROR_TIMES = 7;
    public WordModel() {
        wordList = new WordList();
    }
    public void newGame() {
        errorTimes = 0;
        currentWord = wordList.getRandomNewWord();
        currentHint = wordList.getHint();

        int wordLen = currentWord.length();
        guessWord = new char[wordLen];

        //get the underline
        while(wordLen>0) {
            guessWord[wordLen-1] = '_';
            wordLen--;
        }
    }


    //get the input letter and decide whether it is correct
    public boolean guessWord(char letter) {
        boolean correct = false;
        for(int i = 0; i<currentWord.length();i++) {
            if(letter == currentWord.charAt(i)) {
                guessWord[i] = letter;
                correct = true;
            }
        }
        if(!correct) {
            errorTimes++;
        }
        return correct;
    }

    public String getGuessWord() {
        String gword = "";
        for (int i = 0; i< guessWord.length;i++) {
            gword+=(guessWord[i]+" ");
        }
        return gword;
    }

    public int getErrorTimes() {
        return errorTimes;
    }

    public boolean hasLetter() {
        for (int i = 0; i<guessWord.length;i++) {
            if(guessWord[i] == '_') {
                return false;
            }
        }
        return true;
    }

    //return -1: Lose;
    //return 1: Win;
    //return 0: Continue
    public int Result() {
        if(errorTimes==MAX_ERROR_TIMES) {
            return -1;
        }
        else if (hasLetter()) {
            return 1;
        }
        else {
            return 0;
        }
    }

    public void setData(Bundle bundle) {
        currentWord = bundle.getString("currentWord");
        currentHint = bundle.getString("currentHint");
        errorTimes = bundle.getInt("errorTimes");
        guessWord = bundle.getCharArray("guessWord");
    }

    public void saveData(Bundle bundle) {
        bundle.putString("currentWord", currentWord);
        bundle.putString("currentHint", currentHint);
        bundle.putCharArray("guessWord", guessWord);
        bundle.putInt("errorTimes", errorTimes);
    }


}
