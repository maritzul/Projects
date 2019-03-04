package com.example.simpleasynctask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //key for saving the state of the TextView
    private static final String TEXT_STATE = "currentText";

    //the TextView where we will show results
    private TextView mTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize mTextView
        mTextView = (TextView) findViewById(R.id.textView1);

        //restore the text view if there is a savedInstanceState
        if (savedInstanceState != null) {
            mTextView.setText(savedInstanceState.getString(TEXT_STATE));
        }
    }

    public void startTask(View view) {
        //put a message in the text view
        mTextView.setText("Napping...");

        //start the AsyncTask
        //the AsyncTask has a callback that will update the TextView
        new SimpleAsyncTask(mTextView).execute();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);

        //save the state of the TextView
        outState.putString(TEXT_STATE, mTextView.getText().toString());
    }
}
