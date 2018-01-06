package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.SharedPreferences;
import android.preference.PreferenceActivity;
import android.preference.PreferenceFragment;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

//public class TelecomSettingActivity extends PreferenceActivity implements SharedPreferences.OnSharedPreferenceChangeListener {
public class TelecomSettingActivity extends AppCompatActivity{
    int zip = 12345, temp = 100;
    boolean metric = false;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor ed;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_telecom_setting);

        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        ed = sharedPreferences.edit();
       // zip = sharedPreferences.getInt("edit_zip", 90210);
        // Toast.makeText(this, String.valueOf(zip),Toast.LENGTH_SHORT).show();
        metric = sharedPreferences.getBoolean("metric", false);
        Toast.makeText(this, String.valueOf(metric),Toast.LENGTH_SHORT).show();
        Fragment fragment = new TelecomSettingFragment();
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        if(savedInstanceState ==null){
            fragmentTransaction.add(R.id.activity_telecom_setting, fragment, "pds_settings");
            fragmentTransaction.commit();
        }else {
            fragment = getFragmentManager().findFragmentByTag("pds_settings");
        }
    }
    public static class TelecomSettingFragment extends PreferenceFragment {
        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            addPreferencesFromResource(R.xml.pref_pds);

        }
    }



    @Override
    protected void onPause() {
        super.onPause();
        ed.putBoolean("metric", metric);
    }
}
