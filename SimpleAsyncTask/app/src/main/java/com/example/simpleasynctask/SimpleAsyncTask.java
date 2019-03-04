package com.example.simpleasynctask;

import android.os.AsyncTask;
import android.widget.TextView;

import java.util.Random;

import javax.xml.transform.Result;

public class SimpleAsyncTask extends AsyncTask <Void, Void, String> {

    private TextView mTextView;

    public SimpleAsyncTask(TextView tv) {
        mTextView = tv;
    }

    @Override
    protected String doInBackground(Void... voids) {
        //generate a random number between 0 to 10
        Random r = new Random();
        int n = r.nextInt(11);

        //make the task takes long enough that we have to rotate the phone while it is running
        int s = n * 200;

        //sleep for the random amount of time
        try {
            Thread.sleep(s);
        }
        catch (InterruptedException e) {
            e.printStackTrace();
        }

        //return a string result
        return "Awake after sleeping for " + s + "milliseconds!";
    }

    protected void onPostExecute(String result) {
        mTextView.setText(result);
    }
}
