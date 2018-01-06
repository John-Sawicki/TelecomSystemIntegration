package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ScsActivity extends AppCompatActivity {
    String[] projects;
    String[] defaults= new String[34];
    ArrayAdapter<String> arrayAdapter;
    ListView listProjects;
    Spinner systemSpinner;
    String[] items = new String[]{"ACS","CTV","LAN","MRS",  "PAG","PDS","PRS","SCS","   TEL"};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scs);



        systemSpinner = (Spinner)findViewById(R.id.spinnerSystem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_dropdown_item, items);
        systemSpinner.setAdapter(adapter);

        systemSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                int systemId=systemSpinner.getSelectedItemPosition();
                switch(systemId){
                    case 0:defaults[3] = "EEA0";break;
                    case 1:defaults[3] = "EEC0";break;
                    case 2:defaults[3] = "EFD0";break;
                    case 3:defaults[3] = "EFR6";break;
                    case 4:defaults[3] = "EFP0";break;
                    case 5:defaults[3] = "EUY0";break;
                    case 6:defaults[3] = "EFR0";break;
                    case 7:defaults[3] = "EFY0";break;
                    case 8:defaults[3] = "EFV0";break;
                }
                Toast.makeText(getBaseContext(), "You have selected system " + defaults[3],
                        Toast.LENGTH_SHORT).show();
            }
            @Override
            public void onNothingSelected(AdapterView<?> parent) {
                defaults[3] = "EFY0";
            }
        });

        projects = new String[]{"CCLNG","Franklin","Custom","Create New"};
        List<String> allProjects = new ArrayList<String>(Arrays.asList(projects));
        arrayAdapter = new ArrayAdapter<String>(this,R.layout.list,R.id.name,allProjects);
        listProjects = (ListView)findViewById(R.id.projectView);
        listProjects.setAdapter(arrayAdapter);
        listProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){//pass default values for CCLNG, populate TextView for cells to fill out i.e. building code, 3-letter eqp type
                    defaults[2]="Cable Type"; defaults[4]= "System Code"; defaults[6]= "Building Code"; defaults[10]= "Eqp. Code"; defaults[12]="Start Count";
                    defaults[14]="4P 1st Flr"; defaults[16]="4P 2nd Flr"; defaults[18]="4P 3rd Flr";defaults[20]="1P 1st Flr"; defaults[22]="1P 2nd Flr"; defaults[24]="1P 3rd Flr";
                    defaults[26]="Number of Floors"; defaults[28]= "Both fiber and power"; defaults[30]="A/B Same Number";defaults[32]="A/B Alternate Number";
                    Intent cclng = new Intent(ScsActivity.this, CableTagActivity.class);
                    cclng.putExtra("tag constants",defaults);
                    startActivity(cclng);
                }
            }
        });

    }

}

