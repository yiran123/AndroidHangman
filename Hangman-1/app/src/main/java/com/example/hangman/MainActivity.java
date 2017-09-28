package com.example.hangman;

import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    WordModel model;
    int[] btnIds = new int[]{R.id.A, R.id.B, R.id.C, R.id.D, R.id.E, R.id.F, R.id.G, R.id.H, R.id.I, R.id.J, R.id.K, R.id.L, R.id.M, R.id.N, R.id.O, R.id.P, R.id.Q, R.id.R, R.id.S, R.id.T, R.id.U, R.id.V, R.id.W, R.id.X, R.id.Y, R.id.Z};
    Button[] btnLetters;
    TextView hangman;
    TextView hint;
    TextView word;
    Button newgame;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        hangman = (TextView) findViewById(R.id.hangman);
        word = (TextView) findViewById(R.id.word);
        //  word.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
        newgame = (Button) findViewById(R.id.newgame);
        hint = (TextView) findViewById(R.id.hint);
        btnLetters = new Button[btnIds.length];
        for (int i = 0; i < btnIds.length; i++) {
            btnLetters[i] = (Button) findViewById(btnIds[i]);
            btnLetters[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    //0 mean game has no end
                    if (model == null || model.calcResult() != 0) {
                        Toast.makeText(MainActivity.this, "Now has no started game,Please click new game button!", Toast.LENGTH_LONG).show();
                        return;
                    }
                    Button btn = (Button) view;
                    view.setEnabled(false);
                    view.setClickable(false);
                    Log.i("hangmen", "onClick: " + btn.getText().toString().toLowerCase().charAt(0));
                    boolean right = model.guessWord(btn.getText().toString().toLowerCase().charAt(0));
                    //if right update the guss word
                    if (right) {
                        showWord(model.getGuessWord());
                        if (model.calcResult() == 1) {
                            Toast.makeText(MainActivity.this, "You Win!", Toast.LENGTH_LONG).show();
                            return;
                        }
                        //otherwise update the hangman
                    } else {
                        hangman.setText(HangMan.drawableHangMan(model.getErrorTimes()));
                        if (model.calcResult() == -1) {
                            Toast.makeText(MainActivity.this, "You Lose!", Toast.LENGTH_LONG).show();
                            return;
                        }
                    }


                }
            });
        }
        newgame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (model == null) {
                    model = new WordModel();
                }
                model.newGame();
                //reset guess word
                word.setText(model.getGuessWord());
                hint.setText(model.getHintWord());
                //reset hangman
                hangman.setText(HangMan.drawableHangMan(model.getErrorTimes()));
                //reset button can click
                for (int i = 0; i < btnIds.length; i++) {
                    btnLetters[i].setEnabled(true);
                    btnLetters[i].setClickable(true);
                }
            }
        });

        if (savedInstanceState != null) {
            model = new WordModel();
            model.setData(savedInstanceState);
            for (int i = 0; i < btnIds.length; i++) {
                boolean b = savedInstanceState.getBoolean("" + i);
                btnLetters[i].setClickable(b);
                btnLetters[i].setEnabled(b);
            }
            hangman.setText(HangMan.drawableHangMan(model.getErrorTimes()));
            word.setText(model.getGuessWord());
            hint.setText(model.getHintWord());
        }

    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        model.saveData(outState);
        for (int i = 0; i < btnIds.length; i++) {
            outState.putBoolean("" + i, btnLetters[i].isClickable());
        }

    }

    private String showWord(String guessWord) {
        word.setText("");
        for (int i = 0; i < guessWord.length(); i++) {
            word.append(guessWord.charAt(i) + " ");

        }
        return guessWord;
    }

}
