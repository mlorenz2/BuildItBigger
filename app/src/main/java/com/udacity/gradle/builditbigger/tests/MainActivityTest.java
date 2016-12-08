package com.udacity.gradle.builditbigger.tests;

import com.udacity.gradle.builditbigger.MainActivity;

public class MainActivityTest extends MainActivity {

   private JokeTestCallback jokeTestCallback;

   public void setJokeTestCallback(JokeTestCallback jokeTestCallback) {
      this.jokeTestCallback = jokeTestCallback;
   }

   public interface JokeTestCallback {
      void handleJokeResponse(String joke);
   }

   @Override
   public void handleJoke(String result) {
      jokeTestCallback.handleJokeResponse(result);
   }
}
