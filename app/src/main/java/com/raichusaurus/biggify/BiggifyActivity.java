package com.raichusaurus.biggify;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
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
        if (message.length() > 0) {
            TextView messageView = (TextView) findViewById(R.id.message);

            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics ();
            display.getMetrics(displayMetrics);

            float density  = getResources().getDisplayMetrics().density;
            float dpHeight = displayMetrics.heightPixels / density;
            float dpWidth  = displayMetrics.widthPixels / density;

            String currentLetter = message.charAt(0) + "";
            messageView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dpWidth - 20);
            messageView.setText(currentLetter);
        }
    }
}
