package com.baraa.android_project;


import android.app.SearchManager;
import android.content.Context;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.SearchView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.Window;
import android.widget.TextView;
import com.baraa.android_project.pages.*;

import static com.baraa.android_project.MainNavigationHelper.*;

public class MainActivity extends AppCompatActivity {


    private BottomNavigationView navigationView;

    //pages navigator objects
    private ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ChatsFragment chats_page;
    private ProfileFragment profile_page;
    private GainedWordsFragment gained_words_page;
    private SearchFragment search_page;

    MenuItem prevMenuItem = null;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //refernce widgets
        navigationView = (BottomNavigationView) findViewById(R.id.navigation);
        viewPager = (ViewPager) findViewById(R.id.pages_viewer);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());

        chats_page =new ChatsFragment();
        profile_page = new ProfileFragment();
        gained_words_page = new GainedWordsFragment();
        search_page = new SearchFragment();

        adapter.addFragment(chats_page,gained_words_page,search_page,profile_page);

        viewPager.setAdapter(adapter);

        //
        this.setTitle(R.string.title_chats);

        disableShiftMode(navigationView);
        navigationView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener(this,viewPager));
        navigationView.setOnNavigationItemReselectedListener(onNavigationItemReselectedListener());


        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    navigationView.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                navigationView.getMenu().getItem(position).setChecked(true);
                prevMenuItem = navigationView.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }


//search icon view
//    @Override
//    public boolean onCreateOptionsMenu(Menu menu) {
//        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_search, menu);
//        SearchManager searchManager = (SearchManager) getSystemService(Context.SEARCH_SERVICE);
//        SearchView searchView = (SearchView) menu.findItem(R.id.menu_search).getActionView();
//        searchView.setSearchableInfo(searchManager.getSearchableInfo(getComponentName()));
//
//
//        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
//
//            @Override
//            public boolean onQueryTextSubmit(String query) {
//                //TODO write your code what you want to perform on search
//                return true;
//            }
//            @Override
//            public boolean onQueryTextChange(String query) {
//                //TODO write your code what you want to perform on search text change
//                return true;
//            }
//        });
//        return true;
//    }

}



