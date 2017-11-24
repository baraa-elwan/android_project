package com.baraa.android_project;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.MenuItem;

import java.lang.reflect.Field;

/**
 * Created by BARAA on 11/24/2017.
 */

public class MainNavigationHelper {


    public static BottomNavigationView.OnNavigationItemSelectedListener onNavigationItemSelectedListener(final MainActivity activity, final ViewPager viewPager) {
       return new BottomNavigationView.OnNavigationItemSelectedListener() {

            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {


                switch (item.getItemId()) {
                    case R.id.navigation_chats:
                        viewPager.setCurrentItem(0);
                        activity.setTitle(R.string.title_chats);
                        return true;
                    case R.id.navigation_words:
                        viewPager.setCurrentItem(1);
                        activity.setTitle(R.string.title_words);
                        return true;
                    case R.id.navigation_search:
                        viewPager.setCurrentItem(2);
                        activity.setTitle(R.string.title_search);
                        return true;
                    case R.id.navigation_profile:
                        viewPager.setCurrentItem(3);
                        activity.setTitle(R.string.title_profile);
                        return true;
                }
                return false;
            }

        };
    }

    public static BottomNavigationView.OnNavigationItemReselectedListener onNavigationItemReselectedListener() {
      return  new BottomNavigationView.OnNavigationItemReselectedListener() {

            @Override
            public void onNavigationItemReselected(@NonNull MenuItem item) {

            }
        };
    }
    public static void disableShiftMode(BottomNavigationView view) {
        BottomNavigationMenuView menuView = (BottomNavigationMenuView) view.getChildAt(0);
        try {
            Field shiftingMode = menuView.getClass().getDeclaredField("mShiftingMode");
            shiftingMode.setAccessible(true);
            shiftingMode.setBoolean(menuView, false);
            shiftingMode.setAccessible(false);
            for (int i = 0; i < menuView.getChildCount(); i++) {
                BottomNavigationItemView item = (BottomNavigationItemView) menuView.getChildAt(i);
                //noinspection RestrictedApi
                item.setShiftingMode(false);
                // set once again checked value, so view will be updated
                //noinspection RestrictedApi
                item.setChecked(item.getItemData().isChecked());
            }
        } catch (NoSuchFieldException e) {
            Log.e("BNVHelper", "Unable to get shift mode field", e);
        } catch (IllegalAccessException e) {
            Log.e("BNVHelper", "Unable to change value of shift mode", e);
        }
    };

}
