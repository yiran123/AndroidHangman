package com.example.yiranpan.hangman2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity implements Fragment1Buttons.OnClickLetterListener, Fragment1Buttons.OnNewGameListener{
    WordModel model;
    Fragment1Buttons Fragment1;
    Fragment2Hint Fragment2;
    Fragment3Hangman Fragment3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_activity);
        Fragment1 = new Fragment1Buttons();
        Fragment2 = new Fragment2Hint();
        Fragment3 = new Fragment3Hangman();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment1buttons, Fragment1).commit();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment2hint, Fragment2).commit();
        getFragmentManager().beginTransaction()
                .add(R.id.fragment3hangman, Fragment3).commit();

    }
    @Override
    public void onClickLetter(View view, char letter) {
        //0 mean game has no end
        if(model==null||model.Result()!=0){
            Toast.makeText(MainActivity.this,"Now has no started game, Please click new game button!",Toast.LENGTH_LONG).show();
            return;
        }
        Button btn = (Button) view;
        view.setEnabled(false);
        view.setClickable(false);
        //Log.i("hangmen", "onClick: "+btn.getText().toString().toLowerCase().charAt(0));
        boolean right = model.guessWord(btn.getText().toString().toLowerCase().charAt(0));
        //if right update the guss word
        if(right){
            Fragment3.setGuessWord(model.getGuessWord());
            if(model.Result()==1){
                Toast.makeText(MainActivity.this,"You Win!",Toast.LENGTH_LONG).show();
                return;
            }
            //otherwise update the hangman
        }else{
            Fragment3.drawHangman(Hangman.drawableHangMan(model.getErrorTimes()));
            if(model.Result()==-1){
                Toast.makeText(MainActivity.this,"You Lose!",Toast.LENGTH_LONG).show();
                return;
            }
        }
    }

    @Override
    public void onNewGame() {
        if(model==null){
            model = new WordModel();
        }
        model.newGame();
        //reset guess word
        Fragment3.setGuessWord(model.getGuessWord());
        Fragment2.setHint(model.getGuessWord());
        //reset hangman
        Fragment3.drawHangman(Hangman.drawableHangMan(model.getErrorTimes()));
        //reset button can click
        Fragment1.init();
    }
}
