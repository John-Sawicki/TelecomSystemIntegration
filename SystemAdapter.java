package app.cominjohnsawickitrkhp_identity_photo.linkedin.httpswww.telecomsystemintegration;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by John on 4/22/2017.
 */

public class SystemAdapter extends ArrayAdapter<System> {

    public SystemAdapter (Activity context, ArrayList<System> system){
        super (context, 0, system);
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_system, parent, false);
        }
        System currentSystem = getItem(position);
        TextView nameTextView =(TextView)listItemView.findViewById(R.id.system_name);
        nameTextView.setText(currentSystem.getSystemName());
        ImageView iconView =(ImageView)listItemView.findViewById(R.id.system_icon);
        iconView.setImageResource(currentSystem.getImageResourceId());
        return listItemView;
    }
}
