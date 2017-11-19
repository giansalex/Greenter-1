package com.analycer.greenter.greenter;

import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.analycer.greenter.greenter.fragments.CategoriaFragment;
import com.analycer.greenter.greenter.fragments.ClientFragment;
import com.analycer.greenter.greenter.fragments.ProductsFragment;
import com.analycer.greenter.greenter.fragments.ResumFragment;
import com.greenter.core.service.NetWorking;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    private static final String API_ENDPOINT = "http://greenterapp-quertium.1d35.starter-us-east-1.openshiftapps.com/api/v1";
    private FloatingActionButton fab;
    private Toolbar toolbar;
    private Fragment mResumFragment;

    @Override
        protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        findViewById();
        addEvents();

        NetWorking.init(getApplicationContext(), API_ENDPOINT);
    }

    private void findViewById(){
        fab = (FloatingActionButton) findViewById(R.id.fab);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        mResumFragment = new ResumFragment();
        FragmentManager mFragmentManager = getSupportFragmentManager();
        mFragmentManager.beginTransaction().replace(R.id.mainFrgamnet,mResumFragment).commit();

    }

    private void addEvents(){
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
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

        Fragment mFragment = null;
        final FragmentManager mFragmentManager = getSupportFragmentManager();

        switch (id){
            case R.id.nav_resumen:
                mFragment = mResumFragment;
                break;
            case R.id.nav_product:
                mFragment = new ProductsFragment();
                break;
            case R.id.nav_category:
                mFragment = new CategoriaFragment();
                break;
            case R.id.nav_client:
                mFragment =new ClientFragment();
                break;
            case R.id.nav_share:
                break;
            case R.id.nav_send:
                break;
        }


        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        if (mFragment!=null){
            final Fragment finalMFragment = mFragment;
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() {
                    mFragmentManager.beginTransaction().replace(R.id.mainFrgamnet, finalMFragment).commit();
                }
            }, 400);
        }
        return true;
    }
}
