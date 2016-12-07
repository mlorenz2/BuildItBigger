package com.example;

import java.util.Random;

public class JokeMachine {

   private static String[] jokeDB = { "Chuck Norris does BBQ under water",
         "Chuck Norris once fought against superman. The loser had to war his underwear over his " +
               "pants",
         "Chuck Norris makes fire by rubbing 2 ice cubes together",
         "Chuck Norris counted to infinity. Twice.",
         "Why there are so many Chuck Norris Jokes, but no single one of Bruce Lee? Because Bruce" +
               " Lee is no joke." };

   public static String getJoke() {
      return jokeDB[new Random().nextInt(jokeDB.length)];
   }

   public static String[] getJokeDB() {
      return jokeDB;
   }
}
