package com.mycompany.jsontutorial;
 
import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.Request;
import com.android.volley.Response;
import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONException;
import com.android.volley.VolleyError;

public class MainActivity extends Activity { 
     
    TextView textView; 

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textView = findViewById(R.id.activitymainTextView1);


// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://earningaide.000webhostapp.com/app/adminDeal.json";

// Request a string response from the provided URL.

        JsonArrayRequest jsonArrayRequest= new JsonArrayRequest(Request.Method.GET, url,null,
            new Response.Listener<JSONArray>() {

                @Override
                public void onResponse(JSONArray response) {

                    try {

                        for(int x=0; x<response.length(); x++){



                            JSONObject jSONObject =  response.getJSONObject(x);
                            String name = jSONObject.getString("Name");
                            String link = jSONObject.getString("link");

                            textView.append(("Index Number: "+x+"\n"+name+"\n"+link+"\n\n"));
                        }

                    } catch (JSONException e) {}

                }





            }, new Response.ErrorListener() {

                @Override
                public void onErrorResponse(VolleyError p1) {
                }


            });

// Add the request to the RequestQueue.

        queue.add(jsonArrayRequest);

    }



    //###########################
    
	
} 
