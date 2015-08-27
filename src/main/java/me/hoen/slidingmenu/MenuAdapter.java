package me.hoen.slidingmenu;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class MenuAdapter extends ArrayAdapter<MenuItem> {
    protected Activity context;
    protected int resourceId;
    protected List<MenuItem> list;

    public MenuAdapter(Activity context, List<MenuItem> list){
        this(context, R.layout.action_menu, list);
    }
    public MenuAdapter(Activity context, int resourceId, List<MenuItem> list) {
        super(context, resourceId, list);

        this.context = context;
        this.resourceId = resourceId;
        this.list = list;
    }

    public int getCount() {
        return list.size();
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        View rowView = convertView;
        ViewHolder viewHolder;

        if (rowView == null) {
            LayoutInflater inflater = context.getLayoutInflater();
            rowView = inflater.inflate(resourceId, null);

            viewHolder = new ViewHolder();

            viewHolder.labelTv = (TextView) rowView.findViewById(R.id.sliding_menu_label);

            rowView.setTag(viewHolder);
        } else {
            viewHolder = (ViewHolder) rowView.getTag();
        }

        MenuItem item = list.get(position);

        int iconResId = item.getIconResId();
        if(iconResId != 0){
            viewHolder.labelTv.setCompoundDrawablesWithIntrinsicBounds
                    (context.getResources().getDrawable
                            (iconResId),
                    null,
                    null,
                    null);
        }
        viewHolder.labelTv.setText(item.getLabel());

        return rowView;
    }

    static class ViewHolder {
        TextView labelTv;
    }
}
