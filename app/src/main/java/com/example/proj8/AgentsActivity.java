package com.example.proj8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.concurrent.Executors;

public class AgentsActivity extends AppCompatActivity {
    ListView lvAgents;
    Button btnAgAdd;
    ArrayList<Agent> agents;
    ArrayAdapter<Agent> agentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agents);

        // Set references
        lvAgents = findViewById(R.id.lvCustomers);
        btnAgAdd = findViewById(R.id.btnCAdd);

        //this.loadAgents
        agentAdapter = new ArrayAdapter<Agent>(this,android.R.layout.simple_list_item_1);

        lvAgents.setAdapter(agentAdapter);
       // btnAgAdd= findViewById(R.id.btnAgAdd);

        // Fill lvAgents
        //loadAgents();
        lvAgents.setAdapter(agentAdapter);

        // Add agent
        btnAgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAgents();
            }
        });

        // Edit/delete agent
        lvAgents.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Agent aAgent = agentAdapter.getItem(i);
                editAgent(aAgent);
            }
        });
    } // End of onCreate

    // Get products and update adapter
    private void loadAgents(){
        agents.clear();
        agentAdapter.clear();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                String url = "http://10.0.2.2:8080/JSP-JPA-1.0-SNAPSHOT/api/agent/getagents";
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++)
                            {

                                //THIS PART HERE IM NOT SURE ABOUT WITH OBJECT NAMING
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                int AgId = jsonObject.getInt("AgId");
                                String AgPhone = jsonObject.has("AgPhone")
                                        ? jsonObject.getString("AgPhone")
                                        :null;
                                String AgFName = jsonObject.has("AgFName")
                                        ? jsonObject.getString("AgFName")
                                        :null;
                               String AgLName = jsonObject.has("AgLName")
                                        ? jsonObject.getString("AgLName")
                                        :null;
                                String AgEmail = jsonObject.has("AgEmail")
                                        ? jsonObject.getString("AgLEmail")
                                        :null;
                                int AgyId = jsonObject.getInt("AgyId");
                                String AgPosition = jsonObject.has("AgPosition")
                                        ? jsonObject.getString("AgPosition")
                                        :null;
                                Agent agent =  new Agent( 1, "123", "wayne", "bw@y.com", "hhh@y.com", 123,  "Manager");


                                //int agentId, String agtBusPhone, String agtFirstName,
                                //                 String agtLastName, String agtEmail, int agencyId, String agtPosition
                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //agents.add(agent);
                                        agentAdapter.add(agent);
                                    }
                                });
                            }
                        } catch (JSONException jsonException) {
                            jsonException.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("getProducts", "volley error: " + error.toString());
                        Toast.makeText(getApplicationContext(), "Volley communication failed", Toast.LENGTH_LONG).show();
                    }
                });
                request.setRetryPolicy(new DefaultRetryPolicy(
                        60000, DefaultRetryPolicy.DEFAULT_MAX_RETRIES, DefaultRetryPolicy.DEFAULT_BACKOFF_MULT));

                RequestQueue requestQueue = Volley.newRequestQueue(getApplicationContext()); //getApplicationContext()
                requestQueue.add(request);
            }
        });
    }
    private void addAgents(){
        Log.d("Tallis","AgentsActivity: Adding agent");
        Intent intent = new Intent(getApplicationContext(),AddEditAgentsActivity.class);
        intent.putExtra("isAdd",true);
        startActivity(intent);
    }
    private void editAgent(Agent agent){
        Log.d("Tallis","AgentsActivity: Editing " + agent.getAgtFirstName());
        Intent intent = new Intent(getApplicationContext(),AddEditAgentsActivity.class);
        intent.putExtra("agent",agent);
        intent.putExtra("isAdd",false);
        startActivity(intent);
    }
    // Refresh data
    @Override
    protected void onResume() {
        super.onResume();
        loadAgents();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        loadAgents();
    }
    // Testing product selection
    private void testAgent(Agent agent){
        String message = "AgentsActivity: " + agent.getAgtFirstName() + " was clicked.";
        Log.d("Tallis",message);
        Toast toast = Toast.makeText(getApplicationContext(), message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
    }
} // End of ProductsActivity