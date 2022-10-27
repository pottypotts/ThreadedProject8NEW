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

public class AddEditAgentsActivity extends AppCompatActivity {
    ListView lvAgents;
    Button btnAgAdd;
    ArrayList<Agent> agents;
    ArrayAdapter<Agent> agentAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(layout.agents_add_edit_activity);

        // Set references
        lvAgents = super.findViewById(R.id.lvCustomers); //added the super part to see if helped
        btnAgAdd = super.findViewById(R.id.btnCAdd);

        //this,loadAgents
        agentAdapter = new ArrayAdapter<Agent>(this, android.R.layout.simple_list_item_1);
        lvAgents.setAdapter(agentAdapter);
        //btnAgAdd = findViewById(R.id.btnAgAdd);

        // Fill lvAgents
        //loadAgents();
        lvAgents.setAdapter(agentAdapter);

        // Add agent
        btnAgAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addAgent();
            }
        });
    }

    private void addAgent() {
        Log.d("Tallis", "AgentActivity: Adding agent");
        Intent intent = new Intent(getApplicationContext(), AddEditAgentsActivity.class);
        intent.putExtra("isAdd", true);
        startActivity(intent);
    }
}

