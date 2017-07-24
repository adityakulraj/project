package aarnav100.developer.bankapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.synnapps.carouselview.CarouselView;
import com.synnapps.carouselview.ImageListener;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    CarouselView carouselView;
    int[] sampleImages = {R.drawable.images, R.drawable.images1, R.drawable.images2, R.drawable.download, R.drawable.download1};
    ImageView gs1,gs2,gs3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        carouselView = (CarouselView) findViewById(R.id.carouselView);
        carouselView.setPageCount(sampleImages.length);

        carouselView.setImageListener(new ImageListener() {
                                          @Override
                                          public void setImageForPosition(int position, ImageView imageView) {
                                              imageView.setImageResource(sampleImages[position]);
                                          }
                                      });
        gs1=(ImageView)findViewById(R.id.gs1);
        gs2=(ImageView)findViewById(R.id.gs2);
        gs3=(ImageView)findViewById(R.id.gs3);
        View.OnClickListener ocl=new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=null;
                switch (v.getId())
                {
                    case R.id.gs1:
                        i=new Intent(MainActivity.this,LoanPage.class);
                        break;
                    case R.id.gs2:
                        i=new Intent(MainActivity.this,MutualFundsPage.class);
                        break;
                    case R.id.gs3:
                        i=new Intent(MainActivity.this,InsurancePage.class);
                        break;
                }
                if(i!=null)
                    startActivity(i);
            }
        };
        gs1.setOnClickListener(ocl);
        gs2.setOnClickListener(ocl);
        gs3.setOnClickListener(ocl);
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

        if (id == R.id.nav_login) {
            Intent i=new Intent(this,Login.class);
            startActivity(i);
        } else if (id == R.id.nav_sug) {
            Intent i=new Intent(this,Suggestion.class);
            startActivity(i);
        } else if (id == R.id.nav_map) {
            Intent i=new Intent(this,MapsActivity.class);
            startActivity(i);
        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
