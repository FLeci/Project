package com.pbca.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class OurCuisine extends AppCompatActivity {

    Button btn ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ourcuisine);

        btn = findViewById(R.id.btnone);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(OurCuisine.this, Meals.class);
                startActivity(intent);
            }
        });
    }
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.home){
        Intent intent = new Intent(OurCuisine.this, AboutUs.class);
        startActivity(intent);

            return true;
        }
        else if (id == R.id.restaurant_menu){
            Intent intent = new Intent(OurCuisine.this, ShowMenu.class);
            startActivity(intent);

            return true;
        }
        else if(id == R.id.our_cuisine){
            return true;
        }
        else if(id == R.id.meals){
            Intent intent = new Intent(OurCuisine.this, Meals.class);
            startActivity(intent);
        return true;
        }
        else if(id == R.id.place){
            Intent intent = new Intent(OurCuisine.this, Place.class);
            startActivity(intent);
        }

        return super.onOptionsItemSelected(item);
    }
}