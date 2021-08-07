package tech.hamid.android_internship_assessment;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private List list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        requestQueue = VolleySingleton.getmInstance(this).getRequestQueue();

        list = new ArrayList<>();
        fetchdetails();
    }

    private void fetchdetails() {

        String url = "https://api.unsplash.com/photos/?client_id=8634366274bd23efb9b023fb9b2c6502e67f7dd5d6a7962b3b49fbee170940f8";

        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        for (int i = 0 ; i < response.length() ; i ++){
                            try {
                                JSONObject rootObj = response.getJSONObject(i);
                                JSONObject urlsObj = rootObj.getJSONObject("urls");
                                JSONObject userObj = rootObj.getJSONObject("user");
                                JSONObject userProfileObj = userObj.getJSONObject("profile_image");

                                Details detail = new Details(
                                        userObj.getString("name"),
                                        rootObj.getString("description"),
                                        urlsObj.getString("regular"),
                                        userProfileObj.getString("medium"),
                                        userObj.getString("bio"),
                                        userObj.getString("location")
                                );
                                list.add(detail);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                            Adapter adapter = new Adapter(MainActivity.this, list);
                            recyclerView.setAdapter(adapter);

                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast.makeText(MainActivity.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });
        requestQueue.add(jsonArrayRequest);
    }
}