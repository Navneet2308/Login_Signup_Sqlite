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

public class Screen2 extends AppCompatActivity {
    private String url="https://api.themoviedb.org/3/trending/all/day?api_key=c4824776bf6f08433a4c4e7cd75a6acc";
    final List<Screen2Model> mydata=new ArrayList<Screen2Model>();
    private RecyclerView recyclerView;
    private RequestQueue requestQueue;
    private RecyclerView.LayoutManager layoutManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen2);

        recyclerView=findViewById(R.id.recyclerview2);
        layoutManager=new LinearLayoutManager(Screen2.this,LinearLayoutManager.VERTICAL,false);
        recyclerView.setLayoutManager(layoutManager);


        Showdata();


    }



    public void Showdata()
    {
        final String[] title = {"No title"};
        final String[] release_date = {"No title"};
       final String[] original_title = {"No title"};
        final String[] adult = {"No title"};
        final  String[] generid={"no title "};
        requestQueue= Volley.newRequestQueue(getApplicationContext());

        StringRequest request=new StringRequest(Request.Method.GET, url, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                try {
                    JSONObject jsonObject = new JSONObject(response);
                    JSONArray jsonArray= (JSONArray) jsonObject.get("results");

                    for (int i = 0; i < jsonArray.length(); i++) {
                        JSONObject obj = jsonArray.getJSONObject(i);
                        String mid=   obj.getString("id");
                        String vote_count=  obj.getString("vote_count");
                        String vote_average=  obj.getString("vote_average");





                        if (obj.has("genre_ids"))
                        {
                            JSONArray jsonArray1= (JSONArray) obj.get("genre_ids");

                                generid[0] = jsonArray1.get(0).toString();





                        }

                        else
                        {
                            generid[0] =  "null";

                        }








                        if (obj.has("title"))
                        {

                             title[0] =  obj.getString("title");
                        }

                        else
                        {
                            title[0] =  "null";

                        }



                        if (obj.has("release_date"))
                        {

                            release_date[0] =  obj.getString("release_date");
                        }

                        else
                        {
                            release_date[0] =  "null";

                        }


                        if (obj.has("original_title"))
                        {

                            original_title[0] =  obj.getString("original_title");
                        }

                        else
                        {
                            original_title[0] =  "null";

                        }


                        if (obj.has("original_title"))
                        {

                            original_title[0] =  obj.getString("original_title");
                        }

                        else
                        {
                            original_title[0] =  "null";

                        }







                        if (obj.has("adult"))
                        {

                            adult[0] =  obj.getString("adult");
                        }

                        else
                        {
                            adult[0] =  "null";

                        }






//                        String title=  obj.getString("title");

//                        String release_date=  obj.getString("release_date");
                        String original_language=  obj.getString("original_language");
//                        String original_title=  obj.getString("original_title");
                        String backdrop_path=  obj.getString("backdrop_path");
//                        String adult=  obj.getString("adult");
                        String overview=  obj.getString("overview");
                        String poster_path=  obj.getString("poster_path");
                        String popularity=  obj.getString("popularity");
                        String media_type=  obj.getString("media_type");




                        Screen2Model model = new Screen2Model();
                        model.setMid(mid);
                        model.setMvotec(vote_count);
                        model.setMvotea(vote_average);
                      model.setMtitle(title[0]);
                       model.setMreldate(release_date[0]);
                        model.setMorlang(original_language);
                        model.setMortitle(original_title[0]);
                        model.setMbackimg(backdrop_path);
                         model.setMgnrid(generid[0]);
                       model.setMadult(adult[0]);
                        model.setMoverview(overview);
                        model.setMposterimg(poster_path);
                        model.setMpopularity(popularity);
                        model.setMmediatype(media_type);

                        mydata.add(model);

                    }
                    screen2_adapter adapter = new screen2_adapter(Screen2.this, mydata);
                    recyclerView.setAdapter(adapter);
                } catch (JSONException e) {
                    e.printStackTrace();
                    Toast.makeText(Screen2.this, e.getMessage(), Toast.LENGTH_SHORT).show();
                }


            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

                Toast.makeText(Screen2.this, error.getMessage(), Toast.LENGTH_SHORT).show();
            }
        });

        requestQueue = Volley.newRequestQueue(getApplicationContext());
        requestQueue.add(request);



    }

}