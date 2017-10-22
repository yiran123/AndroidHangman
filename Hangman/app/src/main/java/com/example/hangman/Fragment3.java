package com.example.hangman;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yiranpan on 2017/10/18.
 */

public class Fragment3 extends Fragment {
    TextView hangman;
    TextView guessWord;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3,null,false);
        hangman = (TextView) view.findViewById(R.id.hangman);
        guessWord = (TextView) view.findViewById(R.id.word);
        return view;
    }

   public void drawHangman(String drawable){
       hangman.setText(drawable);
   }
   public void setGuessWord(String guess){
       guessWord.setText(guess);
   }

}
