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

public class MainActivity extends AppCompatActivity {
    String[] systems;
    ArrayAdapter<String> arrayAdapter;
    ListView listSystems;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<System> systemName = new ArrayList<System>();
        systemName.add(new System("ACS", R.drawable.acs_icon));     //0
        systemName.add(new System("CCTV", R.drawable.cctv_icon));
        systemName.add(new System("IDS", R.drawable.ids_camera_icon));
        systemName.add(new System("LAN", R.drawable.lan_icon));
        systemName.add(new System("PAGA", R.drawable.paga_icon));
        systemName.add(new System("PDS", R.drawable.pds_icon)); //5
        systemName.add(new System("Radio", R.drawable.radio_icon));
        systemName.add(new System("SCS/ Cable", R.drawable.scs_icon));      //7
        systemName.add(new System("Project Management", R.drawable.pm_icon));       //8

        ListView listView = (ListView)findViewById(R.id.systemView);
        SystemAdapter systemAdapter = new SystemAdapter(this, systemName);
        listView.setAdapter(systemAdapter);

        /*
        systems = new String[]{"ACS","CCTV","IDS","LAN","PAGA","PDS","Radio","SCS/ Cables"};
        List<String> allSystems = new ArrayList<String>(Arrays.asList(systems));
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list,R.id.name,allSystems);
        listSystems = (ListView)findViewById(R.id.systemView);
        listSystems.setAdapter(arrayAdapter);
        */
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==5){
                    Intent pds = new Intent(MainActivity.this, PdsActivity.class);
                    startActivity(pds);
                }
                if(position==7){
                    Intent scs = new Intent(MainActivity.this, ScsActivity.class);
                    startActivity(scs);
                }
                if(position==8){
                    Intent pm = new Intent(MainActivity.this, PmActivity.class);
                    startActivity(pm);
                }
            }
        });

    }
}
