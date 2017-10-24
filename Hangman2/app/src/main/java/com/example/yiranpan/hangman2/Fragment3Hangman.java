package com.example.yiranpan.hangman2;

import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yiranpan on 10/20/17.
 */

public class Fragment3Hangman extends Fragment{
    TextView hangman;
    TextView guessWord;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3hangman, null, false);
        hangman = (TextView) view.findViewById(R.id.hangman);
        guessWord = (TextView) view.findViewById(R.id.word);
        return view;
    }

    public void drawHangman(String drawablehangman) {
        hangman.setText(drawablehangman);
    }
    public void setGuessWord(String gWord) {
        guessWord.setText(gWord);
    }
}
