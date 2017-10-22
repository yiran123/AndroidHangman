package com.example.hangman;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by yiranpan on 2017/10/18.
 */

public class Fragment2 extends Fragment {
    TextView hint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2,null,false);
        hint = (TextView) view.findViewById(R.id.hint);
        return view;
    }
    public void setHint(String hintWord){
        hint.setText("HINT: "+hintWord);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }
}
