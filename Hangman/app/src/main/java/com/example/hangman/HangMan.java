package com.example.hangman;

/**
 * Created by yiranpan on 2017/9/28.
 */

public class HangMan {
    public static final String ERRORTIMES1 = "________\n|              |\n               |\n               |\n               |\n               |\n               |\n    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES2 = "________\n |             |\n◯            |\n               |\n               |\n               |\n               |\n    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES3 = "________\n |             |\n◯            |\n |             |\n               |\n               |\n               |\n    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES4 = "________\n |             |\n◯            |\n | /           |\n               |\n               |\n               |\n    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES5 = "________\n |             |\n◯            |\n | /          |\n  \\           |\n               |\n               |\n    ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES6 = "________\n  |             |\n ◯            |\n\\ | /          |\n   \\            |\n                |\n                |\n     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static final String ERRORTIMES7 = " ________\n  |             |\n ◯            |\n\\ | /          |\n/  \\           |\n                |\n                |\n     ¯¯¯¯¯¯¯¯¯¯¯¯¯¯¯";
    public static String drawableHangMan(int errorTimes){
        switch (errorTimes){
            case 1: return ERRORTIMES1;
            case 2: return ERRORTIMES2;
            case 3: return ERRORTIMES3;
            case 4: return ERRORTIMES4;
            case 5: return ERRORTIMES5;
            case 6: return ERRORTIMES6;
            case 7: return ERRORTIMES7;
        }
        return "";
    };
}
