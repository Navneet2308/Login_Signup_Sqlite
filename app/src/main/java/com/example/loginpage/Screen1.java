package com.example.loginpage;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Screen1 extends AppCompatActivity {
private String url="https://jsonplaceholder.typicode.com/posts";
    final List<Screen1Model> mydata=new ArrayList<Screen1Model>();
    ArrayList<String> arrayList = new ArrayList<>();
   private  RecyclerView recyclerView;
   private RequestQueue requestQueue;
   private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen1);
        recyclerView=findViewById(R.id.recyclerview);

        layoutManager=new LinearLayoutManager(Screen1.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        Showdata();
    }

    public void Showdata()
    {
        requestQueue= Volley.newRequestQueue(getApplicationContext());

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONArray jsonArray = new JSONArray(response);
                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                     String userid=   obj.getString("userId");
                        String id=  obj.getString("id");
                        String title=  obj.getString("title");
                        String body=  obj.getString("body");

                        Screen1Model model = new Screen1Model();
                        model.setUserid(userid);
                        model.setId(id);
                        model.setTitle(title);
                        model.setBody(body);
                        mydata.add(model);

                    }
                    Scree1Adapter adapter = new Scree1Adapter(Screen1.this, mydata);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Screen1.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Screen1.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

                requestQueue = Volley.newRequestQueue(getApplicationContext());
                requestQueue.add(request);



    }


}