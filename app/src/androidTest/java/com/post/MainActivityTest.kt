package com.maishameds.post

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.swipeDown
import androidx.test.espresso.action.ViewActions.swipeUp
import androidx.test.espresso.matcher.ViewMatchers.withId
import com.maishameds.post.ui.MainActivity
import org.junit.Test

class MainActivityTest {

    @Test
    fun runApp_pullToRefresh() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.postRefresh)).perform(swipeDown())

    }

    @Test
    fun runApp_SwipeUp() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.postRefresh)).perform(swipeUp())

    }

    @Test
    fun runApp_SwipeDown() {
        ActivityScenario.launch(MainActivity::class.java)
        onView(withId(R.id.postRefresh)).perform(swipeDown())

    }


}