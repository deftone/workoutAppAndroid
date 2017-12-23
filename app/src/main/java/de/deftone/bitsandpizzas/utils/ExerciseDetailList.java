package de.deftone.bitsandpizzas.utils;

/**
 * Created by deftone on 12.12.17.
 */


import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import de.deftone.bitsandpizzas.R;

public class ExerciseDetailList extends ArrayAdapter<String> {

    private final Activity context;
    private final String[] desc;
    private final String[] icon;

    public ExerciseDetailList(Activity context, String[] icon, String[] desc) {
        super(context, R.layout.list_exercise_detail, desc);
        this.context = context;
        this.desc = desc;
        this.icon = icon;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowView = inflater.inflate(R.layout.list_exercise_detail, null, true);
        TextView icon = rowView.findViewById(R.id.icon);
        TextView desc = rowView.findViewById(R.id.txt);

        icon.setText(this.icon[position]);
        desc.setText(this.desc[position]);
        return rowView;
    }
}