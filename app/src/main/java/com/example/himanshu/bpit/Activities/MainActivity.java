package com.example.himanshu.bpit.Activities;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.FragmentTransaction;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.example.himanshu.bpit.Fragment.FragmentOtherInfo;
import com.example.himanshu.bpit.Fragment.FragmentTimeTable;
import com.example.himanshu.bpit.R;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    public static final String TAG="MAIN";
FrameLayout containerFrame;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);




        BottomNavigationView bottomNavigationView=findViewById(R.id.bottonNavigationView);
//        disableShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.menuHome:
                        FragmentTransaction ftraxHome=getSupportFragmentManager().beginTransaction();
                        ftraxHome.replace(R.id.containerFrame,new FragmentOtherInfo());
                        ftraxHome.commit();
                        break;
                    case R.id.menuTimeTable:

                        FragmentTimeTable fragmentTimeTable=new FragmentTimeTable();
                        FragmentTransaction ftraxTT=getSupportFragmentManager().beginTransaction();
                        ftraxTT.replace(R.id.containerFrame,fragmentTimeTable);
                        ftraxTT.commit();
                        break;

                    case R.id.menuChat:
                        Intent intent=new Intent(MainActivity.this,ChatBoxActivity.class);
                        startActivity(intent);
                        break;


                }
                return true;
            }
        });

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_camera) {
            // Handle the camera action
        } else if (id == R.id.nav_gallery) {

        } else if (id == R.id.nav_Result) {
            Intent intent=new Intent(MainActivity.this,ResultActivity.class);
            startActivity(intent);

        }  else if (id == R.id.nav_share) {

        } else if (id == R.id.nav_send) {

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

 //@SuppressLint("RestrictedApi")
// public void disableShiftMode(BottomNavigationView view)
// {
//     BottomNavigationMenuView menuView= (BottomNavigationMenuView) view.getChildAt(0);
//     try {
//         Field field=menuView.getClass().getDeclaredField("mShiftedMode");
//         field.setAccessible(true);
//         try {
//             field.setBoolean(menuView, false);
//         } catch (IllegalAccessException e) {
//             e.printStackTrace();
//         }
//         field.setAccessible(false);
//        if(menuView.getChildCount()<6) {
//            for (int i = 0; i < menuView.getChildCount(); ++i) {
//                BottomNavigationItemView itemView = (BottomNavigationItemView) menuView.getChildAt(i);
//                itemView.setShifting(false);
//                itemView.setChecked(itemView.getItemData().isChecked());
//            }
//        }
//     } catch (NoSuchFieldException e) {
//         e.printStackTrace();
//         Log.d(TAG, "disableShiftMode: ");
//     }
//
// }
}
