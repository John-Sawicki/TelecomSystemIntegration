package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PdsActivity extends AppCompatActivity {
    String[] pdsActivities;
    String[] defaults= new String[34];
    ArrayAdapter<String> arrayAdapter;
    ListView listProjects;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pds);
        pdsActivities = new String[]{"UPS/ PDU Sizing","Voltage Drop"};
        List<String> allCalculations = new ArrayList<String>(Arrays.asList(pdsActivities));
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list,R.id.name,allCalculations);
        listProjects = (ListView)findViewById(R.id.pdsListView);
        listProjects.setAdapter(arrayAdapter);
        listProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent upsIntent = new Intent(PdsActivity.this, UpsActivity.class);
                    startActivity(upsIntent);
                }
                if(position==1){
                    Intent vdropIntent = new Intent(PdsActivity.this, VoltageDropActivity.class);
                    startActivity(vdropIntent);
                }
            }
        });
    }
}
