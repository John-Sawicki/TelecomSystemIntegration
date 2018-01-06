package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DocForecast extends AppCompatActivity {
    Date date= new Date();
    Button schedule, email;
    CheckBox newDoc;
    EditText returnCode;
    int returnValue;
    String StringReturnCode, dayOFWeek ="";
    boolean newDocument;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_doc_forecast);
        schedule = (Button)findViewById(R.id.schedule);
        email = (Button)findViewById(R.id.email);
        newDoc = (CheckBox)findViewById(R.id.new_doc);
        returnCode = (EditText)findViewById(R.id.return_code);
        date.setTime(date.getTime());
        schedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringReturnCode = returnCode.getText().toString();
                    returnValue = Integer.parseInt(StringReturnCode);
                newDocument = newDoc.isChecked();
                SimpleDateFormat dateFormat = new SimpleDateFormat("EEE");
                Date date = new Date();
                dayOFWeek = dateFormat.format(date);

                if(newDocument==true){date.setTime(1000*60*60*(24*3));}  //3 days for a new document
                if(returnValue ==3){date.setTime(1000*60*60*3);}    //3 hours for code 3
                if(returnValue ==2 ||returnValue ==1){date.setTime(1000*60*60*2);}    //2 hours for code 2

            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(DocForecast.this,"Toasty",Toast.LENGTH_SHORT).show();
                //Toast.makeText(DocForecast.this,dayOFWeek,Toast.LENGTH_SHORT).show();
            }
        });




    }
}
/*
 Date date= new Date();
                Date date2 =new Date();
                String dayOfWeek, main, max, min, composite;
                int maxInt, minInt;
                for (int i = 0; i < days.length(); i++) {
                    date2.setTime(date.getTime()+i*24*60*60*1000);  //increment my day by multiplying by milliseconds
                    dayOfWeek =String.format("%ta %<tb %<td", date2);
                    JSONObject dayInfo = days.getJSONObject(i);
                    Log.d("DT ", dayInfo.getString("dt"));
                    JSONObject temp = dayInfo.getJSONObject("temp");
                    max=temp.getString("max");
                    min = temp.getString("min");
                    JSONArray weatherJSON = dayInfo.getJSONArray("weather");
                    JSONObject weatherInfo = weatherJSON.getJSONObject(0);
                    main = weatherInfo.getString("main");
                    composite =dayOfWeek+" - "+main+" - "+ formatHighLows(max,min);
                    //Log.d("Max temp", temp.getString("max"));
                    //formattedString[i]=temp.getString("max");
                    formattedString[i]=composite;
 */