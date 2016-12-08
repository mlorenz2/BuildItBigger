package com.kupferwerk.jokeviews;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewJokeActivity extends AppCompatActivity {

   public static final String TEXT_VIEW_JOKE = "text.view.joke";

   public static void start(Context context, String joke) {
      Intent starter = new Intent(context, TextViewJokeActivity.class);
      starter.putExtra(TEXT_VIEW_JOKE, joke);
      context.startActivity(starter);
   }

   @Override
   protected void onCreate(Bundle savedInstanceState) {
      super.onCreate(savedInstanceState);
      setContentView(R.layout.activity_text_view_joke);
      Intent i = getIntent();
      if (i != null) {
         if (i.hasExtra(TEXT_VIEW_JOKE)) {
            String joke = i.getStringExtra(TEXT_VIEW_JOKE);
            if (TextUtils.isEmpty(joke)) {
               Toast.makeText(this, R.string.provide_joke, Toast.LENGTH_SHORT)
                     .show();
               finish();
            } else {
               TextView tv = (TextView) findViewById(R.id.joke);
               tv.setText(joke);
            }
         }
      }
   }
}
