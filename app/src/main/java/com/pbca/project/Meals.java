package com.pbca.project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class Meals extends AppCompatActivity {

    Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meals);

        btn = findViewById(R.id.btntwo);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Meals.this, Place.class);
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
            Intent intent = new Intent(Meals.this, AboutUs.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.restaurant_menu){
            Intent intent = new Intent(Meals.this, ShowMenu.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.our_cuisine){
            Intent intent = new Intent(Meals.this, OurCuisine.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.meals){
            return true;
        }
        else if (id == R.id.place){
            Intent intent = new Intent(Meals.this, Place.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}