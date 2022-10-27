package com.example.proj8;

import static com.example.proj8.R.layout;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class AddEditCustomerActivity extends AppCompatActivity {
    ListView lvCustomer;
    Button btnCAdd;
    ArrayList<Customer> customers;
    ArrayAdapter<Customer> customerArrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.customers_add_edit_activity);

        // Set references
        lvCustomer = super.findViewById(R.id.lvCustomers); //added the super part to see if helped
        btnCAdd = super.findViewById(R.id.btnCAdd);

        //this,loadCustomers
        customerArrayAdapter = new ArrayAdapter<Customer>(this, android.R.layout.simple_list_item_1);
        lvCustomer.setAdapter(customerArrayAdapter);


        // Fill lvcustomer
        //loadAgents();
        lvCustomer.setAdapter(customerArrayAdapter);

        // Add agent
        btnCAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addCustomer();
            }
        });
    }

    private void addCustomer() {
        Log.d("Tallis", "AgentActivity: Adding customer");
        Intent intent = new Intent(getApplicationContext(), AddEditCustomerActivity.class);
        intent.putExtra("isAdd", true);
        startActivity(intent);
    }
}

