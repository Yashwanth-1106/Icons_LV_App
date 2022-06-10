import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.myapplication.R;

public class MyAdapter extends ArrayAdapter {

    
    private String[] GenAppList;
    private Integer[] imageid;
    private Activity context;

    public MyAdapter(@NonNull Context context, int resource) {
        super(context, resource);
    }






    public View getView(int position, View convertView, ViewGroup parent) {
        View row=convertView;
        LayoutInflater inflater = context.getLayoutInflater();
        if(convertView==null)
            row = inflater.inflate(R.layout.icons_listview, null, true);
        TextView textViewCountry = (TextView) row.findViewById(R.id.tV);
        ImageView imageFlag = (ImageView) row.findViewById(R.id.iV1);

        textViewCountry.setText(GenAppList[position]);
        imageFlag.setImageResource(imageid[position]);
        return  row;
    }
}
