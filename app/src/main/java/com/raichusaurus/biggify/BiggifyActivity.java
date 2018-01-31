package com.raichusaurus.biggify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BiggifyActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biggify);
        String message = getMessage();
        biggify(message);
    }

    protected String getMessage() {
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        return messageText;
    }

    protected void biggify(String message) {
        TextView messageView = (TextView) findViewById(R.id.message);
        messageView.setText(message);
    }
}
