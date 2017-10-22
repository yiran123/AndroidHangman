package com.example.hangman;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements Fragment1.OnClickLetterListener,Fragment1.OnNewGameListener{
    WordModel model;
    Fragment1 fragment1;
    Fragment2 fragment2;
    Fragment3 fragment3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1  = new Fragment1();
        fragment2  = new Fragment2();
        fragment3  = new Fragment3();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment1, fragment1).commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment2, fragment2).commit();
        getSupportFragmentManager().beginTransaction()
                .add(R.id.fragment3, fragment3).commit();


    }



    @Override
    public void onClickLetter(View view, char letter) {
        //0 mean game has no end
        if(model==null||model.calcResult()!=0){
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
            fragment3.setGuessWord(model.getGuessWord());
            if(model.calcResult()==1){
                Toast.makeText(MainActivity.this,"You Win!",Toast.LENGTH_LONG).show();
                return;
            }
            //otherwise update the hangman
        }else{
            fragment3.drawHangman(HangMan.drawableHangMan(model.getErrorTimes()));
            if(model.calcResult()==-1){
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
            fragment3.setGuessWord(model.getGuessWord());
            fragment2.setHint(model.getHintWord());
            //reset hangman
            fragment3.drawHangman(HangMan.drawableHangMan(model.getErrorTimes()));
            //reset button can click
            fragment1.init();
        }
}
