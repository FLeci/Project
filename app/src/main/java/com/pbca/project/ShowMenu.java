package com.pbca.project;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ShowMenu extends AppCompatActivity {

    private RecyclerView recycleView;
    private RequestQueue requestQueue;
    private List<Item> mList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_showmenu);

        recycleView = findViewById(R.id.recycleView);
        recycleView.setHasFixedSize(true);
        recycleView.setLayoutManager(new LinearLayoutManager(this));
        requestQueue = VolleySingelton.getmInstance(this).getRequestQueue();
        mList = new ArrayList<>();
        fetchData();

    }



    private void fetchData(){
        String url = "https://tasty.p.rapidapi.com/recipes/list?from=0&size=20&tags=under_30_minutes";

        JsonObjectRequest jsonObjectRequest = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray jsonArray = response.getJSONArray("results");
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject jsonObject = jsonArray.getJSONObject(i);
                        String imageUrl = jsonObject.getString("thumbnail_url");
                        String name = jsonObject.getString("name");
                        String bottomtext = jsonObject.getString("description");
                        int servings = jsonObject.getInt("num_servings");

                        Item post = new Item(imageUrl, name, servings, bottomtext);
                        mList.add(post);
                    }
                    PostAdapter adapter = new PostAdapter(ShowMenu.this, mList);
                    recycleView.setAdapter(adapter);
                    adapter.notifyDataSetChanged();
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(ShowMenu.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }

    }){
            @Override
            public Map<String, String> getHeaders(){
                Map<String, String> params = new HashMap<String, String>();
                params.put("X-RapidAPI-Key", "4336011968msh504c4700428c787p144cb6jsn1e6f4d7b4ebd");
                params.put("content-type", "application/json");
                return params;
            }
        };
        requestQueue.add(jsonObjectRequest);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }
    public  boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();
        if(id == R.id.home){
            Intent intent = new Intent(ShowMenu.this, AboutUs.class);
            startActivity(intent);

            return true;
        }
        else  if (id == R.id.restaurant_menu){
            return true;
        }
        else if (id == R.id.our_cuisine){
            Intent intent = new Intent(ShowMenu.this, OurCuisine.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.meals){
            Intent intent = new Intent(ShowMenu.this, Meals.class);
            startActivity(intent);

            return true;
        }
        else if (id == R.id.place){
            Intent intent = new Intent(ShowMenu.this, Place.class);
            startActivity(intent);

            return true;
        }
        return super.onOptionsItemSelected(item);
    }

}