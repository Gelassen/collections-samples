package com.example.collections.ui;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.collections.R;
import com.example.collections.codility.FindMinValueInLine;
import com.example.collections.hackerrank.AlternatingCharacters;
import com.example.collections.hackerrank.Pangrams;
import com.example.collections.hackerrank.Seats;

import java.util.Scanner;

public class MainActivity extends AppCompatActivity {

    private AlternatingCharacters alternatingCharacters;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new Seats().testRun();

//        alternatingCharacters = new AlternatingCharacters();
//        testAlternatingCharacters();



////        FlippingBits.testMe(1);
//
//        final Integer[] test = new Integer[] {3, 1, 2, 4, 3};
////        TapeEquilibrium tapeEquilibrium = new TapeEquilibrium();
////        Log.d(App.TAG, "Result: " + tapeEquilibrium.solution(test));
//
//        final Integer[] test2 = new Integer[] {1, 3, 6, 4, 1, 2};
//        FindMinValueInLine solver = new FindMinValueInLine();
//        solver.solution(test2);
    }


    public void testAlternatingCharacters() {
        String test1 = "AAA"; // 2
        String test2 = "AAABBB"; //4
        String test3 = "ABABAB"; // 0
        String test4 = "ABZ"; // 0
        String test5 = "AAABBABAB"; // 3;
        String test6 = "";

    }

}
