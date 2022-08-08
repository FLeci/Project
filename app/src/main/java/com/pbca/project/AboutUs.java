package com.pbca.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class AboutUs extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.home){
            return true;
        }
         if (id == R.id.restaurant_menu){
            Intent intent = new Intent(AboutUs.this, ShowMenu.class);
            startActivity(intent);

            return true;
        }

         else if(id == R.id.our_cuisine){
             Intent intent = new Intent(AboutUs.this, OurCuisine.class);
             startActivity(intent);
             return true;
         }
         else if(id == R.id.meals){
             Intent intent = new Intent(AboutUs.this, Meals.class);
             startActivity(intent);
             return true;
         }
         else if(id == R.id.place){
             Intent intent = new Intent(AboutUs.this, Place.class);
             startActivity(intent);
         }
        return super.onOptionsItemSelected(item);
    }
}