package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class VoltageDropActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    int temp = 68, zip=77020;
    boolean metric = false, jbx = false;
    Button calcButton, clearButton, emailButton;
    EditText EditTemp, EditDistance, EditPower, EditVdrop;
    Spinner SpinVoltage;
    CheckBox CheckMetric;
    String tempString, distanceString, powerString, voltageString, vdropString;
    int voltagePosition= 0;
    double voltage = 120.0, result;
    int voltageArray[] = {12,24,24,120,208,230};    //from spinner
    double awgArea[] = {2.08,3.31,5.26,8.37,13.3,21.2,33.6,42.4,53.5};    //area coefficients in mmm2
    double metricArea[]= {1.5,2.5,4,10,16,25,35,50};       //area coefficients in mmm2

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //zip = sharedPreferences.getInt("edit_zip", 90210);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_voltage_drop);
        //Toast.makeText(this, "the zip is "+zip, Toast.LENGTH_SHORT);
         // metric = sharedPreferences.getBoolean("metric", false);
        // Toast.makeText(this, String.valueOf(metric),Toast.LENGTH_SHORT).show();
        EditTemp = (EditText)findViewById(R.id.cable_temp);
        EditDistance = (EditText)findViewById(R.id.distance_one);
        EditPower = (EditText)findViewById(R.id.power_one);
        calcButton = (Button)findViewById(R.id.calculateDropButton);
        emailButton = (Button)findViewById(R.id.emailButton);
        CheckMetric = (CheckBox)findViewById(R.id.check_metric);
        EditVdrop= (EditText)findViewById(R.id.edit_vdrop);
        SpinVoltage = (Spinner)findViewById(R.id.spinner);
        calcButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
            tempString = EditTemp.getText().toString();
            distanceString = EditDistance.getText().toString();
            powerString = EditPower.getText().toString();
            vdropString = EditVdrop.getText().toString();
            metric = CheckMetric.isChecked();  //checked for metric units
            voltageString= SpinVoltage.getSelectedItem().toString();
            voltagePosition = SpinVoltage.getSelectedItemPosition();
            switch(voltagePosition){        //match the values on the Spinner with int voltage values
                case 0: voltage = 12.0; break;
                case 1: voltage = 24.0; break;
                case 2: voltage = 24.0; break;
                case 3: voltage = 120.0; break;
                case 4: voltage = 208.0; break;
                case 5: voltage = 230.0; break;
            }
                //double result = voltageDrop(1200,86,120,120,false);



             //Toast.makeText(VoltageDropActivity.this, tempString+" "+distanceString+" "+powerString+" "+voltageString+" "+voltagePosition, Toast.LENGTH_SHORT).show();

            }
        });
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                result = voltageDrop(Double.parseDouble(distanceString),Double.parseDouble(tempString),Double.parseDouble(powerString),Double.parseDouble(vdropString),voltage,metric);
                Toast.makeText(VoltageDropActivity.this, Double.toString(result)+"%", Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.pds_menu, menu);
        return true;
    }
    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        if(id==R.id.settings_item){
            Intent settingsIntent = new Intent(this, TelecomSettingActivity.class);
            startActivity(settingsIntent);
        }
        return super.onOptionsItemSelected(item);
    }
    public double voltageDrop(double l, double t, double w, double drop, double v, boolean m){
        double length = l; double tempVD = t; double watt = w; double vdrop =drop; double voltage = v; boolean metricVD = m;
        if(metricVD == false){    //convert temp and length to metric units
            tempVD = (tempVD - 32)*5/9;
            length= length *0.3048;
        }
        double voltDrop, percentDrop;
        double tempCo = (1+0.00398*(tempVD -20.0));

        voltDrop = tempCo*(1.72*length*(watt/voltage)) /(50*awgArea[1]);
        percentDrop = 100.0*voltDrop/voltage;
        return percentDrop;
    }
}
