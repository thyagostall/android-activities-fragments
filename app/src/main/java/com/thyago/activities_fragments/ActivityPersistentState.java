package com.thyago.activities_fragments;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ActivityPersistentState extends AppCompatActivity {

    private static final String LOG_TAG = ActivityPersistentState.class.getSimpleName();
    private static final String CREATED_TIME = "createdTime";
    private TextView mCreatedTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity_persistent_state);

        mCreatedTime = (TextView) findViewById(R.id.tvCreatedTime);
        if (savedInstanceState == null) {
            DateFormat format = SimpleDateFormat.getTimeInstance();
            mCreatedTime.setText(format.format(new Date()));
        } else {
            mCreatedTime.setText(savedInstanceState.getString(CREATED_TIME));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putString(CREATED_TIME, mCreatedTime.getText().toString());
    }
}
