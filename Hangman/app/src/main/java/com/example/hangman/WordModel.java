package com.example.hangman;

import android.os.Bundle;
import android.util.Log;

/**
 * Created by yiranpan on 2017/9/28.
 */

public class WordModel {
    private WordList words;
    private String curWord;
    private String hintWord;
    private char[] guessWord;
    private int errorTimes;
    private static final int MAX_ERROR_TIMES = 7;
    public WordModel(){
        words = new WordList();
    }
    public void newGame(){
        errorTimes = 0;
        curWord = words.getRandomNewWord();
        hintWord = words.getHint();
        Log.i("hangman", "getRandomNewWord: " +curWord);
        int len = curWord.length();
        guessWord = new char[len];
        while(len>0){
            guessWord[len-1]='_';
            len--;
        }
    }

    /**
     * recevice a letter to guess word
     * @param letter
     * @return return true is meaning exist this letter
     */
    public boolean guessWord(char letter){
        boolean right =false;
        for(int i = 0;i<curWord.length();i++){
            if(curWord.charAt(i)==letter){
                guessWord[i]=letter;
                right = true;
            }
        }
        if(!right){
            errorTimes++;
        }
        return right;
    }

    public String getGuessWord(){
        String s = "";
        for (int i = 0;i<guessWord.length;i++){
            s+=(guessWord[i]+" ");
        }
        return s;
    }
    public int getErrorTimes(){
        return errorTimes;
    }
    public String getHintWord(){
        return hintWord;
    }
    /**
     * has  _ ?
     * @return
     */
    private boolean hasHintLetter(){
        for (int i = 0;i<guessWord.length;i++){
            if(guessWord[i]=='_')return true;
        }
        return false;
    }

    /**
     * return -1 : you lose
     * return 1 : you win
     * return 0 : game has no end;
     * @return
     */
    public int calcResult(){
        if(errorTimes==MAX_ERROR_TIMES){
            return -1;
        }else if(!hasHintLetter()){
            return 1;
        }else{
            return 0;
        }
    }
    public void setData(Bundle bundle){
        curWord = bundle.getString("curWord");
        hintWord = bundle.getString("hintWord");
        errorTimes = bundle.getInt("errorTimes");
        guessWord = bundle.getCharArray("guessWord");
    }
    public void saveData(Bundle bundle){
        bundle.putString("curWord",curWord);
        bundle.putString("hintWord",hintWord);
        bundle.putCharArray("guessWord",guessWord);
        bundle.putInt("errorTimes",errorTimes);
    }
}
