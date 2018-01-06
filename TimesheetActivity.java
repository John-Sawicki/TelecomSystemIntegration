package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class TimesheetActivity extends AppCompatActivity {
    public EditText mMonIn, mMonOut, mMonLunchOut, mMonLunchIn;
    public String[][] timesString = new String[5][4];   // 1 row for each day, same columns as timesheet
    public TextView mMonHours, mHoursWorked, mTimtToGo;
    public Button mCalculate, mEmail;
    public Spinner hours, mimutes;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_timesheet);
        mMonIn = (EditText)findViewById(R.id.MonIn);
        mMonOut = (EditText)findViewById(R.id.MonOut);
        mMonLunchOut = (EditText)findViewById(R.id.MonLunchOut);
        mMonLunchIn = (EditText)findViewById(R.id.MonLunchIn);
        mCalculate = (Button)findViewById(R.id.calculateTime);
        mEmail = (Button)findViewById(R.id.emailButton);
        mCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timesString[0][0] =mMonIn.getText().toString(); //time in on Monday
                timesString[0][1] =mMonLunchOut.getText().toString(); //leave for lunch
                timesString[0][2] =mMonIn.getText().toString(); //return from lunch
                timesString[0][4] =mMonOut.getText().toString(); //leave for the day

            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Toast.makeText(this,"You pressed the back button!", Toast.LENGTH_SHORT).show();
    }
}
