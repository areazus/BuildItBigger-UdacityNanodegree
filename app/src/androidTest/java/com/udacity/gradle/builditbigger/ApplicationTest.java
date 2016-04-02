package com.udacity.gradle.builditbigger;

import android.app.Application;
import android.test.ApplicationTestCase;

import java.util.concurrent.CountDownLatch;

/**
 * <a href="http://d.android.com/tools/testing/testing_android.html">Testing Fundamentals</a>
 */
public class ApplicationTest extends ApplicationTestCase<Application> {
    public ApplicationTest() {
        super(Application.class);
    }

    public void testNonEmptyReturnString() throws Throwable{
        final CountDownLatch signal = new CountDownLatch(1);
        new EndpointsAsyncTask(){
            @Override
            protected void onPostExecute(String result) {
                assertNotNull(result);
                assertNotSame("", result);
                signal.countDown();
            }
        }.execute(getContext());
        signal.await();
    }
}