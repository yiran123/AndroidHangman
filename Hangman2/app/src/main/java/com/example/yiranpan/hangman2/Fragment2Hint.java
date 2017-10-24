package com.example.yiranpan.hangman2;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by yiranpan on 10/20/17.
 */

public class Fragment2Hint extends Fragment{
    TextView hint;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment2hint, null, false);
        hint = (TextView) view.findViewById(R.id.hint);
        return view;
    }

    public void setHint(String hintWord) {
        hint.setText("HINT: " + hintWord);
    }
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
    }

}
