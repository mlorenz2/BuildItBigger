package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;
import android.util.Log;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import static junit.framework.Assert.assertTrue;

@RunWith (AndroidJUnit4.class)
public class JokeTest {

   @Rule
   public ActivityTestRule<MainActivity> activityTestRule =
         new ActivityTestRule<>(MainActivity.class);

   @Test
   public void testGCEJokeTelling() {
      EndpointAsyncTask asyncTask = new EndpointAsyncTask(activityTestRule.getActivity()
            .getApplicationContext());

      try {
         asyncTask.execute();
         String response = asyncTask.get(3, TimeUnit.SECONDS);
         assertTrue(!TextUtils.isEmpty(response));
      } catch (TimeoutException | InterruptedException | ExecutionException exception) {
         Log.e(JokeTest.class.getSimpleName(), exception.getMessage(), exception);
      }
   }
}
