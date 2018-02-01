package com.raichusaurus.biggify;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.Display;
import android.widget.TextView;

import org.w3c.dom.Text;

public class BiggifyActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "message";

    private String message = "  ";
    private int currentChar = 0;
    private boolean space = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_biggify);
        message += getMessage();
        biggify();
    }

    protected String getMessage() {
        Intent intent = getIntent();
        String messageText = intent.getStringExtra(EXTRA_MESSAGE);

        return messageText;
    }

    protected void biggify() {
        if (message.length() > 0) {
            final TextView messageView = (TextView) findViewById(R.id.message);

            Display display = getWindowManager().getDefaultDisplay();
            DisplayMetrics displayMetrics = new DisplayMetrics ();
            display.getMetrics(displayMetrics);

            float density  = getResources().getDisplayMetrics().density;
            float dpHeight = displayMetrics.heightPixels / density;
            float dpWidth  = displayMetrics.widthPixels / density;

            messageView.setTextSize(TypedValue.COMPLEX_UNIT_DIP, dpWidth - 70);

            final Handler handler = new Handler();
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int delay = 50;
                    String currentLetter = "";
                    if (space) {
                        space = false; // will display letter next
                    } else {
                        delay = 500;
                        currentLetter += message.charAt(currentChar);

                        // increment char and possibly reset to 0
                        currentChar = ++currentChar % message.length();
                        space = true; // brief pause between letters
                    }

                    messageView.setText(currentLetter);

                    handler.postDelayed(this, delay);
                }
            });
        }
    }
}
