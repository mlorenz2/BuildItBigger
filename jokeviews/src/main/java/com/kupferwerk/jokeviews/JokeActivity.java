package com.kupferwerk.jokeviews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import java.util.Random;

public class JokeActivity extends AppCompatActivity {

   public static final String JOKE_VIEW_JOKE = "joke.view.joke";
   private static final int EMPTY = 0;
   private String[] joke;

   public static void start(Context context, String[] joke) {
      Intent starter = new Intent(context, JokeActivity.class);
      starter.putExtra(JOKE_VIEW_JOKE, joke);
      context.startActivity(starter);
   }

   public void tellAwesomeJoke(View view) {
      Toast.makeText(this, joke[new Random().nextInt(joke.length)], Toast.LENGTH_SHORT)
            .show();
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_joke_view);
      Intent i = getIntent();
      if (i != null) {
         if (i.hasExtra(JOKE_VIEW_JOKE)) {
            joke = i.getStringArrayExtra(JOKE_VIEW_JOKE);
            if (joke != null && joke.length == EMPTY) {
               Toast.makeText(this, R.string.provide_joke, Toast.LENGTH_SHORT)
                     .show();
               finish();
            }
         } else {
            Toast.makeText(this, R.string.use_starter, Toast.LENGTH_SHORT)
                  .show();
            finish();
         }
      }
   }
}
