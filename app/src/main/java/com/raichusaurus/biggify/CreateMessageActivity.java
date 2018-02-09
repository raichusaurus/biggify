package com.raichusaurus.biggify;

import com.newrelic.agent.android.NewRelic;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class CreateMessageActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        NewRelic.withApplicationToken(

                "AA0bdf8aded949eb5e2129f5126c66665bfba1ab87"
        ).start(this.getApplication());
    }

    public void onSendMessage(View view) {
        EditText messageView = (EditText) findViewById(R.id.message);
        String messageText = messageView.getText().toString();
        Intent intent = new Intent(this, BiggifyActivity.class);
        intent.putExtra(BiggifyActivity.EXTRA_MESSAGE, messageText);
        startActivity(intent);
    }
}
