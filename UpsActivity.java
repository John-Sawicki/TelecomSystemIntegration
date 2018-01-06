package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

//need settings to UPS power factor and voltage. Assuming 0.9 pf and 120VAC
public class UpsActivity extends AppCompatActivity {
    Button calc, clear;
    EditText equipment1, equipment2, wattage1, qty1, wattage2, qty2;
    TextView total1,total2, grandTotalW, voltAmpTotal, breakerSize;
    String value_wattage1, value_quantity1,value_wattage2, value_quantity2 ;
    double power_factor =0.9, double_VA_total, double_value_VA_total, doubleVoltage, doubleAmps ;
     int lineTotal1=0, wattageInt1=0, quantityInt1=0, lineTotal2=0, wattageInt2=0, quantityInt2=0, value_wattage_total =0, value_VA_total=0,  amps =9, value_breaker=2, voltage=120;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ups);
        equipment1= (EditText)findViewById(R.id.equipment_one);
        wattage1 = (EditText)findViewById(R.id.wattage_one);
        qty1 = (EditText)findViewById(R.id.quantity_one);
        total1 = (TextView) findViewById(R.id.total_one);
        equipment2= (EditText)findViewById(R.id.equipment_two);
        wattage2 = (EditText)findViewById(R.id.wattage_two);
        qty2 = (EditText)findViewById(R.id.quantity_two);
        total2 = (TextView) findViewById(R.id.total_two);
        grandTotalW = (TextView)findViewById(R.id.value_total_watts);
        voltAmpTotal = (TextView)findViewById(R.id.value_volt_amp);
        breakerSize = (TextView)findViewById(R.id.value_breaker);
        calc = (Button)findViewById(R.id.Calculate);
        clear = (Button)findViewById(R.id.Clear);
        calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                value_wattage1 = wattage1.getText().toString();     //convert user's input to String
                value_quantity1 = qty1.getText().toString();
                wattageInt1 = Integer.parseInt(value_wattage1);     //input type prevents decimal places
                quantityInt1 = Integer.parseInt(value_quantity1);   //converts string to int
                lineTotal1 = wattageInt1 * quantityInt1;
                total1.setText(Integer.toString(lineTotal1));       //convert int to string

                value_wattage2 = wattage2.getText().toString();
                value_quantity2 = qty2.getText().toString();
                wattageInt2 = Integer.parseInt(value_wattage2);
                quantityInt2 = Integer.parseInt(value_quantity2);
                lineTotal2 = wattageInt2 * quantityInt2;
                total2.setText(Integer.toString(lineTotal2));


                value_wattage_total = lineTotal1 + lineTotal2;
                grandTotalW.setText(Integer.toString(value_wattage_total));
                //double_VA_total = (power_factor * (double)value_wattage_total);   //need to limit to one row/ convert to int
                //voltAmpTotal.setText(Double.toString(double_VA_total));
                value_VA_total = (int)((double)value_wattage_total/power_factor);   //typecast to double for division than to int
                voltAmpTotal.setText(Integer.toString(value_VA_total));
                    double_value_VA_total = (double)value_VA_total;
                    doubleVoltage = (double)voltage;
                doubleAmps = (double_value_VA_total/doubleVoltage);
                doubleAmps = ( (double)value_VA_total*(1/(double)voltage));
                value_breaker=5;
                if(doubleAmps>=(5*0.8)){value_breaker=10;}   //need 20% margin, 4.2A or less for a 5A breaker
                if(doubleAmps>=(10*0.8)){value_breaker=15;}
                if(doubleAmps>=(15*0.8)){value_breaker=20;}
                if(doubleAmps>=(20*0.8)){value_breaker=25;}
                if(doubleAmps>=(25*0.8)){value_breaker=30;}
                if(doubleAmps>=(30*0.8)){value_breaker=35;}
                if(doubleAmps>=(35*0.8)){value_breaker=40;}
                if(doubleAmps>=(40*0.8)){value_breaker=45;}
                if(doubleAmps>=(45*0.8)){value_breaker=50;}
                if(doubleAmps>=(50*0.8)){value_breaker=60;}
                if(doubleAmps>=(60*0.8)){value_breaker=70;}
                if(doubleAmps>=(70*0.8)){value_breaker=80;}
                if(doubleAmps>=(80*0.8)){value_breaker=90;}
                if(doubleAmps>=(90*0.8)){
                    value_breaker=0;
                    Toast.makeText(UpsActivity.this, "You need to distribute the load among more circuits", Toast.LENGTH_LONG).show();
                }
                breakerSize.setText(Integer.toString(value_breaker));

            }
        });
        clear.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                equipment1.setText("");equipment2.setText(""); wattage1.setText(""); qty1.setText(""); wattage2.setText(""); qty2.setText("");
                total1.setText(""); total2.setText(""); grandTotalW.setText(""); voltAmpTotal.setText(""); breakerSize.setText("");
                value_breaker=0;
            }
        });

    }

}
