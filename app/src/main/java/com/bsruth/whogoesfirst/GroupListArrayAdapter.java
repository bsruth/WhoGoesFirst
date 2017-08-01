package com.bsruth.whogoesfirst;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by bsruth on 9/7/15.
 */
public class GroupListArrayAdapter extends ArrayAdapter<GameGroup> {

    public final static String GROUP_CLICKED_MSG = "com.bsruth.whogoesfirst.GROUP_CLICKED";
    private List<GameGroup> gameGroups;

    public GroupListArrayAdapter(Context context, int resource, List<GameGroup> objects) {
        super(context, resource, objects);
        this.gameGroups = objects;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v = convertView;
        if (v == null) {
            LayoutInflater vi = (LayoutInflater)(getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE));
            v = vi.inflate(R.layout.group_list_item_layout, null);
        }
        final GameGroup group = gameGroups.get(position);
        if (group != null) {
            Button itemBtn = (Button) v.findViewById(R.id.itemButton);
            if (itemBtn != null) {
                itemBtn.setText( group.GetGroupName());
                itemBtn.setTag(group);
                itemBtn.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent(getContext(), RollResultActivity.class);
                        GameGroup clickedGroup = (GameGroup)v.getTag();
                        intent.putExtra(GROUP_CLICKED_MSG, clickedGroup);
                        getContext().startActivity(intent);
                    }
                });
            }
        }
        return v;
    }
}
