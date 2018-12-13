package com.wassi.camprandoapp;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.wassi.camprandoapp.fragments.EvtParticipeFragment;
import com.wassi.camprandoapp.fragments.Fragment_liste_evt;
import com.wassi.camprandoapp.fragments.ProfileFragment;
import com.wassi.camprandoapp.model.UserModel;

import butterknife.Bind;
import butterknife.ButterKnife;

public class Acceuil_Activity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    @Bind(R.id.drawer_layout)
    SimpleDraweeView simpleDraweeView;
    NavigationView navigationView;
    DrawerLayout drawer;
    TextView nameTextView;
    TextView emailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acceuil);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        UserModel userModel = getUserModelFromIntent();
        if (userModel != null)
            setDataOnNavigationView(userModel);
        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Acceuil_Activity.this, Add_Event_Activity.class);
                startActivity(intent);
            }
        });
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        //Setting 1st item to be main screen
        /*Fragment fragment = null;
       Class fragmentClass = Fragment_liste_evt.class;
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();*/
        navigationView.getMenu().getItem(0).setChecked(true);
        setTitle(navigationView.getMenu().getItem(0).getTitle());
        //end
        drawer.openDrawer(Gravity.LEFT, true);
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                drawer.closeDrawer(GravityCompat.START);
            }
        }, 2000);
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
        getMenuInflater().inflate(R.menu.acceuil_, menu);
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

    private void setDataOnNavigationView(UserModel userModel) {
        if (navigationView != null) {
            setupDrawerContent(userModel);
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();
        Fragment fragment = null;
        Class fragmentClass = null;
        if (id == R.id.nav_list_evt) {
            fragmentClass = Fragment_liste_evt.class;
        } else if (id == R.id.nav_list_evt_participe) {
            fragmentClass = EvtParticipeFragment.class;
        } else if (id == R.id.nav_user_profile) {
            fragmentClass = ProfileFragment.class;
        } else if (id == R.id.nav_sign_out) {
            /*drawerLayout.closeDrawers();
            SharedPreferenceManager.getSharedInstance().clearAllPreferences();
            startLoginActivity();
            return true;*/
        }
        try {
            fragment = (Fragment) fragmentClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction().replace(R.id.flContent, fragment).commit();
        item.setChecked(true);
        setTitle(item.getTitle());
        drawer.closeDrawers();
        return true;
    }

    private UserModel getUserModelFromIntent() {
        Intent intent = getIntent();
        return intent.getParcelableExtra(UserModel.class.getSimpleName());
    }

    private void setupDrawerContent(UserModel userModel) {
        View headerView = navigationView.getHeaderView(0);

        simpleDraweeView = ButterKnife.findById(headerView, R.id.user_profile_view);
        simpleDraweeView.setImageURI(Uri.parse(userModel.profilePic));

        nameTextView = ButterKnife.findById(headerView, R.id.tv_user_name);
        nameTextView.setText(userModel.userName);

        emailTextView = ButterKnife.findById(headerView, R.id.tv_user_email);
        emailTextView.setText(userModel.userEmail);
    }

    private void startLoginActivity() {
        Intent intent = new Intent(this, LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
