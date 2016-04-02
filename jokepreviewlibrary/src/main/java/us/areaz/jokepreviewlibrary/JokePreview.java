package us.areaz.jokepreviewlibrary;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokePreview extends AppCompatActivity {
    public static String INTENT_EXTRA_TAG = "JokeExtra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke_preview);
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra(INTENT_EXTRA_TAG)) {
            String joke = intent.getStringExtra(INTENT_EXTRA_TAG);
            TextView jokeTextView = (TextView) findViewById(R.id.jokeTextView);
            jokeTextView.setText(joke);
        }
    }


}
