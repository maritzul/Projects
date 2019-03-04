package com.example.scorekeeper;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    //member variables for holding the score
    private int mScore1;
    private int mScore2;

    //member variable for the two score TextView
    private TextView mScoreText1;
    private TextView mScoreText2;

    //tag to be used as the key in OnSavedInstanceState
    static final String STATE_SCORE_1 = "Team 1 Score";
    static final String STATE_SCORE_2 = "Team 2 Score";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //find the TextViews by ID
        mScoreText1 = (TextView) findViewById(R.id.score1);
        mScoreText2 = (TextView) findViewById(R.id.score2);

        //restores the scores if there is savedInstanceState
        if (savedInstanceState != null) {
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            //set the score text views
            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //inflate the menu from XML
        getMenuInflater().inflate(R.menu.main_menu, menu);

        //change the label of the menu based on the state of the app
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        } else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        //check if the correct item was clicked
        if (item.getItemId()==R.id.night_mode) {
            //get the night mode state of the app
            int nightMode = AppCompatDelegate.getDefaultNightMode();

            //set the theme mode for the restarted activity
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES) {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            } else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }

            //recreate the activity for the theme change to take effect
            recreate();

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public void decreaseScore(View view) {
        //get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID) {
            //if it was on Team 1
            case R.id.decreaseT1:
                //decrement the score and update the TextView
                mScore1--;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            //if it was on Team 2
            case R.id.decreaseT2:
                //decrement the score and update the TextView
                mScore2--;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void increaseScore(View view) {
        //get the ID of the button that was clicked
        int viewID = view.getId();
        switch (viewID) {
            //if it was on Team 1
            case R.id.increaseT1:
                //increment the score and update the TextView
                mScore1++;
                mScoreText1.setText(String.valueOf(mScore1));
                break;

            //if it was on Team 1
            case R.id.increaseT2:
                //increment the score and update the TextView
                mScore2++;
                mScoreText2.setText(String.valueOf(mScore2));
        }
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        //save the scores
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
