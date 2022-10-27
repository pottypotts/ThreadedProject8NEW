package com.example.proj8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.concurrent.Executors;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import com.android.volley.DefaultRetryPolicy;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class CustomersActivity extends AppCompatActivity {
    ListView lvCustomers;
    Button btnCAdd;
    ArrayList<Customer> customers;
    ArrayAdapter<Customer> customerArrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customers);

        //References
        lvCustomers = findViewById(R.id.lvCustomers);
        btnCAdd = findViewById(R.id.btnCAdd);

        //this.load customers
        customerArrayAdapter = new ArrayAdapter<Customer>(this, android.R.layout.simple_list_item_1);
        //Fill customers
        lvCustomers.setAdapter(customerArrayAdapter);
        btnCAdd = findViewById(R.id.btnCAdd);

        //Add customer
        btnCAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        //edit or delete customer
        lvCustomers.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Customer aCustomer = customerArrayAdapter.getItem(i);
                editCustomer(aCustomer);
            }
        });
    }//end of OnCreate

    private void loadCustomer(){
        customers.clear();
        customerArrayAdapter.clear();
        Executors.newSingleThreadExecutor().execute(new Runnable() {
            @Override
            public void run() {
                String url = "http://10.0.2.2:8080/JSP-JPA-1.0-SNAPSHOT/api/customer/getcustomers";
                StringRequest request = new StringRequest(url, new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONArray jsonArray = new JSONArray(response);
                            for (int i = 0; i < jsonArray.length(); i++)
                            {
                                //THIS PART HERE IM NOT SURE ABOUT WITH OBJECT NAMING
                                JSONObject jsonObject = jsonArray.getJSONObject(i);

                                int agentId = jsonObject.getInt("agentId");
                                String custAddress = jsonObject.has("custAddress")
                                        ? jsonObject.getString("custAddress")
                                        :null;
                                String custBusPhone = jsonObject.has("custBusPhone")
                                        ? jsonObject.getString("custBusPhone")
                                        :null;
                                String custCity = jsonObject.has("custCity")
                                        ? jsonObject.getString("custCity")
                                        :null;
                                String custCountry = jsonObject.has("custCountry")
                                        ? jsonObject.getString("custCountry")
                                        :null;
                                String custEmail = jsonObject.has("custEmail")
                                        ? jsonObject.getString("custEmail")
                                        :null;
                                String custFirstName = jsonObject.has("custFirstName")
                                        ? jsonObject.getString("custFirstName")
                                        :null;
                                String custLastName = jsonObject.has("custLastName")
                                        ? jsonObject.getString("custLastName")
                                        :null;
                                String custHomePhone = jsonObject.has("custHomePhone")
                                        ? jsonObject.getString("custHomePhone")
                                        :null;
                                int customerId = jsonObject.getInt("customerId");
                                String custPostal = jsonObject.has("custPostal")
                                        ? jsonObject.getString("custPostal")
                                        :null;
                                String custProv = jsonObject.has("custProv")
                                        ? jsonObject.getString("custProv")
                                        :null;

                                Customer aCustomer =  new Customer(agentId,  custAddress,
                                        custBusPhone, custCity,
                                         custCountry, custEmail,
                                         custFirstName,  custHomePhone,
                                         custLastName, customerId, custPostal, custProv);


                                runOnUiThread(new Runnable() {
                                    @Override
                                    public void run() {
                                        //customers.add(customer);
                                        customerArrayAdapter.add(aCustomer);
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
        private void addCustomer(){
            Log.d("Tallis","CustomerActivity: Adding customer");
            Intent intent = new Intent(getApplicationContext(),AddEditCustomerActivity.class);
            intent.putExtra("isAdd",true);
            startActivity(intent);
        }
            private void editCustomer(Customer customer){
                Log.d("Tallis","CustomersActivity: Editing " + customer.getCustFirstName());
                Intent intent = new Intent(getApplicationContext(),AddEditAgentsActivity.class);
                intent.putExtra("customer",customer);
                intent.putExtra("isAdd",false);
                startActivity(intent);
            }
    // Refresh data
    @Override
    protected void onResume() {
        super.onResume();
        loadCustomer();
    }
}


