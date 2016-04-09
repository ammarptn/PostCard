package com.ammarptn.postcard;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.support.test.InstrumentationRegistry;
import android.support.test.espresso.intent.Intents;
import android.test.ActivityInstrumentationTestCase2;
import android.util.Log;

import org.hamcrest.Matcher;
import org.junit.Before;

import java.util.Collections;
import java.util.List;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasAction;
import static android.support.test.espresso.intent.matcher.IntentMatchers.hasData;
import static android.support.test.espresso.matcher.ViewMatchers.hasContentDescription;
import static android.support.test.espresso.matcher.ViewMatchers.isClickable;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;

/**
 * Created by ammarptn on 11/7/2015.
 */
public class TestPostCard extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;
    private static final String TAG = "com.ammarptn.postcard";

    public TestPostCard() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();

        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();


    }


    public void testViewAllGallery()
    {
        Intent mainIntent = new Intent(Intent.ACTION_PICK, null);
        mainIntent.setData(android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
        List<ResolveInfo> pkgAppsList = getActivity().getPackageManager().queryIntentActivities( mainIntent, PackageManager.GET_RESOLVED_FILTER);
        int size = pkgAppsList.size();
        int i = 0;
        Log.i(TAG, "Size: " + size);
        for(ResolveInfo infos : pkgAppsList){
            String name = infos.activityInfo.applicationInfo.loadLabel(getActivity().getPackageManager()).toString();
            Log.i(TAG, "name: " + name);

        }



    }


}
