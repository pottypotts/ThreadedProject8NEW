package com.example.proj8;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;


public class MainActivity extends AppCompatActivity {
    ListView lvTables;
    ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get reference
        lvTables = findViewById(R.id.lvTables);

        // Fill lvTables
        loadTables();
        lvTables.setAdapter(arrayAdapter);

        // Navigate to table
        lvTables.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String selectedTable = arrayAdapter.getItem(i);
                openActivity(selectedTable);
            }
        });

    } //End OnCreate
    // Create adapter for lvTables
    private void loadTables(){
        arrayAdapter = new ArrayAdapter(this,android.R.layout.simple_list_item_1);
        arrayAdapter.add("Agents");
        arrayAdapter.add("Customers");
        //  arrayAdapter.add("Suppliers");
        //arrayAdapter.add("Product Supplier");
        //arrayAdapter.add("Package Product Supplier");
    }

    // Navigate
    private void openActivity(String selectedTable) {
        switch (selectedTable) {
           /* case "Agents":
                Intent intent_agents = new Intent(getApplicationContext(), AgentsActivity.class);
                startActivity(intent_agents);
                break; */
            case "Customers":
                Intent intent_products = new Intent(getApplicationContext(), CustomersActivity.class);
                startActivity(intent_customers);
                break;
            default:
                testTable("Default");
                break;
        }
    };
    // Testing table opening
    private void testTable(String selectedTable){
        String message = "MainActivity: " + selectedTable + " was clicked.";
        Log.d("Tallis",message);
        Toast toast = Toast.makeText(getApplicationContext(), message,Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP,0,0);
        toast.show();
    }
} //End of MainActivity