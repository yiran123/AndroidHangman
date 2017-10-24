package com.example.yiranpan.hangman2;

import android.app.Fragment;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * Created by yiranpan on 10/20/17.
 */

public class Fragment1Buttons extends Fragment{

    private int[] btnIds = new int[]{R.id.A,R.id.B,R.id.C,R.id.D,R.id.E,R.id.F,R.id.G,R.id.H,R.id.I,
            R.id.J,R.id.K,R.id.L,R.id.M,R.id.N,R.id.O,R.id.P,R.id.Q,R.id.R,R.id.S,R.id.T,R.id.U,
            R.id.V,R.id.W,R.id.X,R.id.Y,R.id.Z,};
    private Button[] btnLetters;
    private Button newgame;

    public interface OnClickLetterListener {
        void onClickLetter(View view, char letter);

    }

    public interface OnNewGameListener{
        void onNewGame();
    }

    private OnClickLetterListener onClickLetterListener;
    private OnNewGameListener onNewGameListener;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment1buttons, null, false);
        newgame = (Button) view.findViewById(R.id.newgame);
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (onNewGameListener != null) {
                    onNewGameListener.onNewGame();
                }
            }
        });
        btnLetters = new Button[btnIds.length];
        for (int i = 0; i<btnIds.length;i++) {
            btnLetters[i] = (Button) view.findViewById(btnIds[i]);
            btnLetters[i].setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View view) {
                    if(onClickLetterListener !=null) {
                        char letter = ((Button)view).getText().toString().toLowerCase().charAt(0);
                        onClickLetterListener.onClickLetter(view, letter);
                    }
                }

            });
        }
        return view;
    }

    public void init() {
        for (int i =0;i<btnIds.length;i++) {
            btnLetters[i].setClickable(true);
            btnLetters[i].setEnabled(true);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        onClickLetterListener = (OnClickLetterListener) context;
        onNewGameListener = (OnNewGameListener) context;
    }


}
