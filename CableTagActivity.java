package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;

public class CableTagActivity extends AppCompatActivity {
    //create email intent for bottom button
    //if one a/b button is checked, automatically uncheck the other buttton
    String[] defaults;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cable_tag);

        Intent intent= getIntent();
        defaults = intent.getStringArrayExtra("tag constants"); //default values from ScsActivity
        TextView sum1= (TextView)findViewById(R.id.sum1);
        sum1.setText(defaults[2]);

        TextView sum2= (TextView)findViewById(R.id.sum2);
        sum2.setText(defaults[4]);
        TextView sum3= (TextView)findViewById(R.id.sum3);
        sum3.setText(defaults[6]);
        TextView sum4= (TextView)findViewById(R.id.sum4);
        sum4.setText(defaults[8]);
        TextView sum5= (TextView)findViewById(R.id.sum5);
        sum5.setText(defaults[10]);
        TextView sum6= (TextView)findViewById(R.id.sum6);
        sum6.setText(defaults[12]);
        TextView sum7= (TextView)findViewById(R.id.sum7);
        sum7.setText(defaults[14]);
        TextView sum8= (TextView)findViewById(R.id.sum8);
        sum8.setText(defaults[16]);
        TextView sum9= (TextView)findViewById(R.id.sum9);
        sum9.setText(defaults[18]);
        TextView sum10= (TextView)findViewById(R.id.sum10);
        sum10.setText(defaults[20]);
        TextView sum11= (TextView)findViewById(R.id.sum11);
        sum11.setText(defaults[22]);
        TextView sum12= (TextView)findViewById(R.id.sum12);
        sum12.setText(defaults[24]);
        TextView sum13= (TextView)findViewById(R.id.sum13);
        sum13.setText(defaults[26]);
        TextView sum14= (TextView)findViewById(R.id.sum14);
        sum14.setText(defaults[28]);
        TextView sum15= (TextView)findViewById(R.id.sum15);
        sum15.setText(defaults[30]);
        TextView sum16= (TextView)findViewById(R.id.sum16);
        sum16.setText(defaults[32]);

        TextView pf1= (TextView)findViewById(R.id.pf1);
        pf1.setText(defaults[1]);
        TextView pf2= (TextView)findViewById(R.id.pf2);
        pf2.setText(defaults[3]);
        EditText pf3 = (EditText)findViewById(R.id.pf3);
        String buildingCode =pf3.getText().toString();
        EditText pf5 = (EditText)findViewById(R.id.pf5);
        String eqpCode =pf5.getText().toString();
        EditText pf6 = (EditText)findViewById(R.id.pf6);
        String startNum =pf6.getText().toString();
        EditText pf7 = (EditText)findViewById(R.id.pf7);
        String firstFloor4p =pf7.getText().toString();
        EditText pf8 = (EditText)findViewById(R.id.pf8);
        String secondFloor4p =pf8.getText().toString();
        EditText pf9 = (EditText)findViewById(R.id.pf9);
        String thirdFloor4p =pf9.getText().toString();
        EditText pf10 = (EditText)findViewById(R.id.pf10);
        String firstFloor1p =pf10.getText().toString();
        EditText pf11 = (EditText)findViewById(R.id.pf11);
        String secondFloor1p =pf11.getText().toString();
        EditText pf12 = (EditText)findViewById(R.id.pf12);
        String thirdFloor1p =pf12.getText().toString();
        EditText pf13 = (EditText)findViewById(R.id.pf13);
        String numberOfFloors =pf13.getText().toString();

        RadioButton fiberAndPowerBtn = (RadioButton)findViewById(R.id.pf14);
        fiberAndPowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        RadioButton sameAB = (RadioButton)findViewById(R.id.pf15);
        fiberAndPowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        RadioButton altAB = (RadioButton)findViewById(R.id.pf16);
        fiberAndPowerBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        Button toastButton = (Button)findViewById(R.id.toastCableButton);
        toastButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        Button emailButton = (Button)findViewById(R.id.emailButton);
        emailButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
        /*
        import java.util.Scanner;

public class LanCableSchedule {
	public static void main(String[] args) {
		String cableTag ="a to b";
        String cableType = "1C";
        String systemCode = "EFY0";
        String dash = "-";
        String equipmentCode = "OUT";
        int stoQuadCountSecond =0, stoSingleCountSecond=0,stoQuadCountThird=0,stoSingleCountThird=0;
        //int floor = 1; //prefix for the floor of the cable ex 001
        String prefixZero = "0"; //used for the second of three digits for the first 10 STO, the last group of two numbers will also use the prefix
        //int stoCount=stoQuadCount+stoSingleCount;
        Scanner input = new Scanner(System.in);
        System.out.println("Building Code ");
        String areaCode = input.next();
        System.out.println("Number of floors ");
        int numberOfFloors = input.nextInt();
        System.out.println("Quad ports on first floor ");
        int stoQuadCount = input.nextInt();
        System.out.println("Single ports on first floor ");
        int stoSingleCount = input.nextInt(); 		//tag all the quad ports before the single ones
    	if(numberOfFloors >1){
    		System.out.println("Quad ports on second floor ");
            stoQuadCountSecond = input.nextInt();
            System.out.println("Single ports on second floor ");
            stoSingleCountSecond = input.nextInt();
    	}
    	if(numberOfFloors >2){
    		System.out.println("Quad ports on third floor ");
            stoQuadCountThird = input.nextInt();
            System.out.println("Single ports on third floor ");
            stoSingleCountThird = input.nextInt();
    	}

        //System.out.println("Building code is "+areaCode+ " floor number "+numberOfFloors+ " quad ports "+stoQuadCount+ " single ports " +stoSingleCount);

       for(int floor=1;floor<=numberOfFloors;floor++ ){
    	    if(numberOfFloors<2) {floor= floor-1;}	//single floor building start at 001 multistory start at 101
	        for (int sto4=1; sto4<=stoQuadCount; sto4++){
	        	if (sto4>9){prefixZero ="";}			//remove prefix 0 than int will be 10 which takes up 2 places, ex prefixZero+9 to 10
		        for (int port = 1; port <5; port++){
		        	cableTag = cableType+ systemCode+ dash+ areaCode+ dash+ equipmentCode+ dash+
		        			Integer.toString(floor)+ prefixZero+ Integer.toString(sto4)+dash+ // user enters '1' for floor so substract 1
		        			Integer.toString(0)+ Integer.toString(port);
		        	System.out.println(cableTag);
		        }
	        }
	        for (int sto1=1; sto1<=stoSingleCount; sto1++){
	        	if ((stoQuadCount+sto1)>9){prefixZero ="";}
	        	cableTag = cableType+ systemCode+ dash+ areaCode+ dash+ equipmentCode+ dash+
	        			Integer.toString(floor)+ prefixZero+ Integer.toString(sto1+stoQuadCount); //start count at 1 above last quad port number
	        		System.out.println(cableTag);
	        }
        // repeat for second and third floors set stoQuadCountSecond to stoQuadCount to reuse code
	        if(numberOfFloors>1){		// initialize second floor and work your way up till outer loop ends
	        	stoQuadCount =stoQuadCountSecond;
	        	stoSingleCount = stoSingleCountSecond;
	        }
	        if(floor==2& numberOfFloors==3){	    //set sto count for third floor once loop finishes on the second floor
	        	stoQuadCount =stoQuadCountThird;
	        	stoSingleCount = stoSingleCountThird;
	        }
	        if(numberOfFloors<2) {floor= floor+1;}   //increment back to exit loop
	        prefixZero="0";	//reset prefix for the next floor
       }
    }
}


         */

    }
}

