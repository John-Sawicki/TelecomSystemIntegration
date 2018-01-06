package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PmActivity extends AppCompatActivity {
    String[] pmActivities;
    ArrayAdapter<String> mStringArrayAdapter;
    ListView listProjects;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pm);
        pmActivities =new String[] {"Document Forecasts", "TimeSheets"};
        List<String> allTasks =  new ArrayList<String>(Arrays.asList(pmActivities));
        mStringArrayAdapter = new ArrayAdapter<String>(this,R.layout.list,R.id.name,allTasks);
        listProjects = (ListView)findViewById(R.id.pmListView);
        listProjects.setAdapter(mStringArrayAdapter);

        listProjects.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position==0){
                    Intent docIntent = new Intent(PmActivity.this, DocForecast.class);
                    startActivity(docIntent);
                }
                if(position==1){
                    Intent timeIntent = new Intent(PmActivity.this, TimesheetActivity.class);
                    startActivity(timeIntent);
                }
            }
        });

    }
}
