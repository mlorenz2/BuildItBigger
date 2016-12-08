package com.udacity.gradle.builditbigger;

import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.text.TextUtils;

import com.udacity.gradle.builditbigger.tests.MainActivityTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import static junit.framework.Assert.assertTrue;
import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.matcher.ViewMatchers.withId;

@RunWith (AndroidJUnit4.class)
public class JokeTest {

   @Rule
   public ActivityTestRule<MainActivityTest> activityTestRule =
         new ActivityTestRule<>(MainActivityTest.class);

   @Test
   public void testGCEJokeTelling() throws Exception{
      MainActivityTest activityTest = activityTestRule.getActivity();
      activityTest.setJokeTestCallback(new MainActivityTest.JokeTestCallback() {
         @Override
         public void handleJokeResponse(String joke) {
            assertTrue(!TextUtils.isEmpty(joke));
         }
      });
      onView(withId(R.id.gceJoker)).perform(click());
   }
}
